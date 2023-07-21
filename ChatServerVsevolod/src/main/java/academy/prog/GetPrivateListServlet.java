package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class GetPrivateListServlet extends HttpServlet {
    private PrivateDialogue pdList = PrivateAddServlet.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fromStr = req.getParameter("private_from");

        int privatefrom = 0;
        try {
            privatefrom = Integer.parseInt(fromStr);
            if (privatefrom < 1) {
                privatefrom = 1;
            }
        } catch (Exception ex) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        resp.setContentType("application/json");
        String json = pdList.toJSON(privatefrom);


        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);

            //PrintWriter pw = resp.getWriter();
            //pw.print(json);
        }
    }
}
