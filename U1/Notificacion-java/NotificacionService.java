public class NotificacionService {
    private EmailService emailService;
    public NotificacionService() {
        this.emailService = new EmailService();
    }
    public void notificacionUsuario(String usuario, String mensaje){
        emailService.enviarCorreo(usuario, mensaje);
    }
}
