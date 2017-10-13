package com.zhuyidi.chapter3;

import org.omg.CORBA.portable.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dela on 3/8/17.
 */

@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {
    private void writeBytes(InputStream in, ServletOutputStream out)
            throws IOException {
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length = in.read(buffer)) != -1){
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String passwd = req.getParameter("passwd");
        if("123456".equals(passwd)){
            resp.setContentType("application/pdf");
            InputStream in = getServletContext().
                    getResourceAsStream("/WEB-INF/jdbc.pdf");
            ServletOutputStream out = resp.getOutputStream();
            writeBytes(in, out);
        }
    }
}
