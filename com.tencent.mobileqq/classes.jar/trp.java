import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class trp
  implements INetEventHandler
{
  public trp(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.getApplication(), this.a.a.getString(2131436291), 1).show();
      trq localtrq = new trq(this);
      new Handler().postDelayed(localtrq, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trp
 * JD-Core Version:    0.7.0.1
 */