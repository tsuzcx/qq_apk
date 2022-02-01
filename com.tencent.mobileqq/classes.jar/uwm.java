import UserGrowth.stNotificationReq;
import UserGrowth.stNotificationRsp;

public class uwm
  extends urg<stNotificationRsp>
{
  public uwm(String paramString)
  {
    super("Notification", 4);
    stNotificationReq localstNotificationReq = new stNotificationReq();
    localstNotificationReq.linkStrategyArgs = uyb.a();
    localstNotificationReq.push_info = paramString;
    this.a = localstNotificationReq;
    uya.b("NotificationRequest", "stNotificationReq = " + localstNotificationReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwm
 * JD-Core Version:    0.7.0.1
 */