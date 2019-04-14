import LP.clsMenu;
import java.io.IOException;
import java.sql.SQLException;

import EXCEPCIONES.excepcionEntrenadorRepe;
import EXCEPCIONES.excepcionJugadorNoEncontrado;
import EXCEPCIONES.excepcionJugadorRepe;
import EXCEPCIONES.excepcionSocioRepe;
import EXCEPCIONES.excepcionStaffRepe;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, excepcionJugadorRepe, excepcionEntrenadorRepe, excepcionSocioRepe, excepcionStaffRepe, excepcionJugadorNoEncontrado {


        /**Se da inicio a la clase de menú

         **/
        clsMenu.menuGeneral();
    }
}
