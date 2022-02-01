import android.os.Handler;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.6.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class vts
  implements INetEventHandler
{
  vts(vtm paramvtm) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Toast.makeText(BaseApplicationImpl.getApplication(), this.this$0.mActivity.getString(2131696283), 1).show();
      SendMultiPictureHelper.6.1 local1 = new SendMultiPictureHelper.6.1(this);
      new Handler().postDelayed(local1, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vts
 * JD-Core Version:    0.7.0.1
 */