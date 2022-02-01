import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class onu
  extends okw<stNotificationRsp>
{
  public onu(String paramString)
  {
    super("Notification");
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = opa.a();
    localstNotificationReq.push_info = paramString;
    this.req = localstNotificationReq;
    ooz.d("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     onu
 * JD-Core Version:    0.7.0.1
 */