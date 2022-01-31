import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class tki
  extends thb<stNotificationRsp>
{
  public tki(String paramString)
  {
    super("Notification");
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = tlp.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    tlo.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tki
 * JD-Core Version:    0.7.0.1
 */