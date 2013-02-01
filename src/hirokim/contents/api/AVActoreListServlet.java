package hirokim.contents.api;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import com.google.gson.*;
import hirokim.contents.api.util.*;
import hirokim.contents.api.model.*;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class AVActoreListServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(AVActoreListServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		// ファイルパス作成
		String path = this.getServletContext().getRealPath("/WEB-INF/csv/av_acter.csv");
		log.info(path);
		
		// CSV読み込み
		ContentsCSVReader reader = new ContentsCSVReader();
		List<Content> contents = reader.readToList(path);
		
		// JSON出力
		Gson gson = new Gson();
		resp.getWriter().println(gson.toJson(contents, List.class));
	}
}