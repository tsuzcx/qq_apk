import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import mqq.app.QQPermissionCallback;

public class zwd
  implements QQPermissionCallback
{
  public zwd(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwd
 * JD-Core Version:    0.7.0.1
 */