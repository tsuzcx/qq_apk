import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.util.QZLog;

public class wxs
  implements EncodeVideoTask.ResultListener
{
  public wxs(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Integer.valueOf(paramInt);
    this.a.a.sendMessage(localMessage);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    QZLog.d("PhotoListActivity", 2, new Object[] { "encode video cost time = ", Long.valueOf(System.currentTimeMillis() - this.a.g) });
    ThreadManager.postImmediately(new wxt(this, paramString1, paramString2, paramInt3), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxs
 * JD-Core Version:    0.7.0.1
 */