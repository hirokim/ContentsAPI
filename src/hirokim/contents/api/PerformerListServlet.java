package hirokim.contents.api;

import hirokim.contents.api.model.Content;
import hirokim.contents.api.util.ContentsCSVReader;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class PerformerListServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(AVActoreListServlet.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		// ファイルパス作成
		String path = this.getServletContext().getRealPath("/WEB-INF/csv/performer.csv");
		log.info(path);
		
		// CSV読み込み
		ContentsCSVReader reader = new ContentsCSVReader();
		List<Content> contents = reader.readToList(path);
		
		// JSON出力
		Gson gson = new Gson();
		resp.getWriter().println(gson.toJson(contents, List.class));
	}
}
