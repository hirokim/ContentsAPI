package hirokim.contents.api;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import com.google.gson.*;
import hirokim.contents.api.model.*;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class AVActoreListServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(AVActoreListServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		List<Content> contents = loadContentCSV("av_acter.csv");
		
		// Gson�I�u�W�F�N�g���쐬
		Gson gson = new Gson();
		resp.getWriter().println(gson.toJson(contents, List.class));
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	private List<Content> loadContentCSV(String fileName) {
		
		// �R���e���c���X�g����
		ArrayList<Content> contents = new ArrayList<Content>();
		
		try {
			// �t�@�C���p�X�쐬
			String path = this.getServletContext().getRealPath("/WEB-INF/csv/" + fileName);
			
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