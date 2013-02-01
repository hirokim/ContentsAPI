package hirokim.contents.api.util;

import hirokim.contents.api.AVActoreListServlet;
import hirokim.contents.api.model.Content;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ContentsCSVReader {

	private static final Logger log = Logger.getLogger(AVActoreListServlet.class.getName());
	
	/**
	 * コンテンツCSV読み込み
	 * @param path ファイルパス
	 * @return Contentのリスト
	 */
	public List<Content> readToList(String path) {
		
		// コンテンツリスト生成
		ArrayList<Content> contents = new ArrayList<Content>();
		
		try {
			
			// ファイル読み込み
			FileInputStream file = new FileInputStream(path);
			InputStreamReader input = new InputStreamReader(file, "UTF-8");
			BufferedReader buffer = new BufferedReader(input);
			
			String line;
			while ((line = buffer.readLine()) != null) {
				
				// コンテンツ生成
				Content con = new Content();
				
				// カンマ区切り分割
				String column[] = line.split(",");
				
				// 値セット
				con.setCategory(column[0]);
				con.setGroup(column[1]);
				con.setName(column[2]);
				con.setUrl(column[3]);
				
				// コンテンツリストに追加
				contents.add(con);
			}
			
			// 後始末
			buffer.close();
			input.close();
			file.close();
		}
		catch (FileNotFoundException e) {
			log.info(e.getStackTrace().toString());
		}
		catch (IOException e) {
			log.info(e.getStackTrace().toString());
		}
		
		return contents;
	}
}
