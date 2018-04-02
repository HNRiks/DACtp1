package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class somatorio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int contServer;

    @Override
    public void init() {
        contServer = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("inicio") == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet somatorio</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Aguardando parametros.</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            //Calcula o somatorio
            int inicio = Integer.parseInt(request.getParameter("inicio"));
            int fim = Integer.parseInt(request.getParameter("fim"));
            int soma = 0;
            for (int i = inicio; i <= fim; i++) {
                soma = soma + i;
            }

            //Incrementa o contador de usos do servlet
            contServer++;

            //Incrementa o contador de usos da sessao
            HttpSession session = request.getSession();
            int contSess;
            if (session.getAttribute("cont") != null) {
                contSess = Integer.parseInt(session.getAttribute("cont").toString());
                contSess++;
            } else {
                session.setAttribute("cont", 1);
                contSess = 1;
            }
            session.setAttribute("cont", contSess);

            //Incrementa o contador de usos do browser
            int contBrowser = 0;
            Cookie cookie;
            Cookie[] cookies;
            cookies = request.getCookies();
            //Busca um cookie contador, if any
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("cont")) {
                        contBrowser = Integer.parseInt(c.getValue());
                        contBrowser++;
                    }
                }
            }
            //Se não houver um cookie contador, ou cookie algum
            if (contBrowser == 0) {
                contBrowser = 1;
            }

            cookie = new Cookie("cont", "" + contBrowser);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);

            //Output
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet somatorio</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>O somatório de " + inicio + " a " + fim + " é " + soma + ".</h1>");
                out.println("Você usou o serviço " + contSess + " vezes nessa sessão.<br />");
                out.println("Você usou o serviço " + contBrowser + " vezes nesse browser<br />");
                out.println("Esse serviço foi usado " + contServer + " vezes desde que o servidor foi iniciado.<br />");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
        //protected
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo

        
            () {
        return "Short description";
        }// </editor-fold>

    }
