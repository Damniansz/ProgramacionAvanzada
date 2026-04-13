public class NotificacionServiceSMS {

    private NotifiacionService notifiacionService;
    public NotificacionServiceSMS(){
        this.notifiacionService = new NotifiacionService();
    }
    public void notificacionUsuario(String operadora, String mensaje){
        notifiacionService.enviarNotifiacionSMS(operadora, mensaje);
    }

}
