import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class unr
  extends ujr<stNotificationRsp>
{
  public unr(String paramString)
  {
    super("Notification", 4);
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = upf.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    upe.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unr
 * JD-Core Version:    0.7.0.1
 */