package dov.com.qq.im.ae.album.logic;

import android.os.Handler;
import android.os.Message;
import aqhq;
import awuv;
import awvf;
import awvk;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import mqq.util.WeakReference;

public class AEPhotoListLogicDefault$6$1
  implements Runnable
{
  public AEPhotoListLogicDefault$6$1(awvk paramawvk) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = this.a.val$targetPath;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    try
    {
      localLocalMediaInfo.path = this.a.val$targetPath;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.addedDate = System.currentTimeMillis();
      localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      localLocalMediaInfo.thumbnailPath = this.a.b.thumbPath;
      localLocalMediaInfo.mDuration = this.a.b.videoDuration;
      localLocalMediaInfo.fileSize = new File(this.a.val$targetPath).length();
      localLocalMediaInfo.isSystemMeidaStore = false;
      PhotoListBaseData.newCaptureMediaInfo.put(this.a.val$targetPath, localLocalMediaInfo);
      ((awuv)this.a.this$0.bu.get()).mHandler.sendMessage(localMessage);
      aqhq.cn(this.a.baS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.6.1
 * JD-Core Version:    0.7.0.1
 */