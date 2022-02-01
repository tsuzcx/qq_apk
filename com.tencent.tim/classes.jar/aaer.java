import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aaer
  extends Handler
{
  public aaer(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      paramMessage = (DrawRedpacketPannelPreviewFragment.b)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.TAG, 2, "save path: " + paramMessage.path + " thread name: " + Thread.currentThread().getName());
      }
      localFragmentActivity = this.this$0.getActivity();
    } while (localFragmentActivity == null);
    Intent localIntent = new Intent(localFragmentActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage.path);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
    localIntent.putExtra("uin", paramMessage.aTl);
    localIntent.putExtra("uintype", paramMessage.uinType);
    localIntent.putExtra("troop_uin", paramMessage.troopUin);
    localIntent.putExtra("key_confess_topicid", paramMessage.topicId);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    if (localArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    }
    localFragmentActivity.startActivity(localIntent);
    localFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaer
 * JD-Core Version:    0.7.0.1
 */