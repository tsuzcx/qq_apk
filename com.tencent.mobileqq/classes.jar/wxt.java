import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;

class wxt
  implements Runnable
{
  wxt(wxs paramwxs, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    String str = PhotoListActivity.a(this.jdField_a_of_type_Wxs.a, this.jdField_a_of_type_JavaLangString);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.b;
      localLocalMediaInfo.mDuration = this.jdField_a_of_type_Int;
      localLocalMediaInfo.fileSize = new File(str).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
      PhotoListActivity.a().put(str, localLocalMediaInfo);
      this.jdField_a_of_type_Wxs.a.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PhotoListActivity", 2, new Object[] { "get new video info exception", localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wxt
 * JD-Core Version:    0.7.0.1
 */