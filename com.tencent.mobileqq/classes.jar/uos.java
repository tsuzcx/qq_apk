import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class uos
  extends ukl<stNotificationRsp>
{
  public uos(String paramString)
  {
    super("Notification", 4);
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = uqg.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    uqf.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */