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
	 * �R���e���cCSV�ǂݍ���
	 * @param path �t�@�C���p�X
	 * @return Content�̃��X�g
	 */
	public List<Content> readToList(String path) {
		
		// �R���e���c���X�g����
		ArrayList<Content> contents = new ArrayList<Content>();
		
		try {
			
			// �t�@�C���ǂݍ���
			FileInputStream file = new FileInputStream(path);
			InputStreamReader input = new InputStreamReader(file, "UTF-8");
			BufferedReader buffer = new BufferedReader(input);
			
			String line;
			while ((line = buffer.readLine()) != null) {
				
				// �R���e���c����
				Content con = new Content();
				
				// �J���}��؂蕪��
				String column[] = line.split(",");
				
				// �l�Z�b�g
				con.setCategory(column[0]);
				con.setGroup(column[1]);
				con.setName(column[2]);
				con.setUrl(column[3]);
				
				// �R���e���c���X�g�ɒǉ�
				contents.add(con);
			}
			
			// ��n��
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
