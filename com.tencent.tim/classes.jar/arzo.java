import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.MyAppApi.15.1;
import com.tencent.open.downloadnew.MyAppApi.15.2;
import mqq.os.MqqHandler;

public class arzo
  implements arwy.a
{
  arzo(arzk paramarzk, arwy paramarwy, long paramLong, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void G(String paramString, byte[] paramArrayOfByte)
  {
    arwt.v("MyAppApi", "onGetA1 ---");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.15.1(this, paramArrayOfByte, paramString));
  }
  
  public void elT()
  {
    arwt.v("MyAppApi", "onGetA1Fail ---");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.15.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzo
 * JD-Core Version:    0.7.0.1
 */