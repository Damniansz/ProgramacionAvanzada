

public class Main {
    public static void main(String[] args) {

        NotificacionService servicio = new NotificacionService();
        NotificacionServiceSMS sms = new NotificacionServiceSMS();
        NotificacionServiceRedes redes = new NotificacionServiceRedes();

        servicio.notificacionUsuario("Aldo@gmail.com", "Hola Mundo");
        sms.notificacionUsuario("Claro", "Te metimos a la central de riesgo");
        redes.notifacionUsuario("Facebook",  "Tienes un nuevo un mensaje");
    }
}
