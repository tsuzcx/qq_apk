import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.6.1;
import mqq.util.WeakReference;

public class awvk
  implements pog.e
{
  public void g(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      QZLog.d("PhotoListActivity", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.LA) });
      ThreadManager.postImmediately(new AEPhotoListLogicDefault.6.1(this), null, true);
      return;
    }
    paramString1 = Message.obtain();
    paramString1.what = 2;
    paramString1.obj = Integer.valueOf(paramInt);
    ((awuv)this.this$0.bu.get()).mHandler.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awvk
 * JD-Core Version:    0.7.0.1
 */