import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class top
  implements INetEventHandler
{
  public top(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.getApplication(), this.a.a.getString(2131436274), 1).show();
      toq localtoq = new toq(this);
      new Handler().postDelayed(localtoq, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     top
 * JD-Core Version:    0.7.0.1
 */