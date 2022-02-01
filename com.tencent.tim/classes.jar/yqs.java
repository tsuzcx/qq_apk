import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class yqs
  implements QQPermissionCallback
{
  public yqs(PublicView paramPublicView, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b.denied();
    aqha.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqs
 * JD-Core Version:    0.7.0.1
 */