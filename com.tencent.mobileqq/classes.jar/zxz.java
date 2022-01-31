import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class zxz
  implements Runnable
{
  public zxz(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      DialogUtil.a(ARVideoRecordUIControllerImpl.a().a(), 230, this.a, this.b, "", "我知道了", new zya(this), null).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */