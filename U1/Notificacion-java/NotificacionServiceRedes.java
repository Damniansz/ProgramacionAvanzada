public class NotificacionServiceRedes {
    
    private NotifiacionService notifiacionService;
    public NotificacionServiceRedes (){
        this.notifiacionService = new NotifiacionService();
    }
    public void notifacionUsuario(String redSocial, String mensaje){
        notifiacionService.enviarNotifiacionRedes(redSocial,mensaje);
    }
}
