import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class vlb
  extends vfo<stNotificationRsp>
{
  public vlb(String paramString)
  {
    super("Notification", 4);
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = vmq.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    vmp.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlb
 * JD-Core Version:    0.7.0.1
 */