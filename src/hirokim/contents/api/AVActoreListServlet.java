package hirokim.contents.api;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.gson.*;

@SuppressWarnings("serial")
public class AVActoreListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		// Gson�I�u�W�F�N�g���쐬
		Gson gson = new Gson();
		
		int[] numbers = {1, 2, 3};
		resp.getWriter().println(gson.toJson(numbers));
	}
}
