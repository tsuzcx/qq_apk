package com.tencent.mobileqq.activity.photo.album;

import android.os.Handler;
import android.os.Message;
import aqhq;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import ztv;
import zub;

public class PhotoListLogicDefault$9$1
  implements Runnable
{
  public PhotoListLogicDefault$9$1(zub paramzub) {}
  
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
      ((NewPhotoListActivity)this.a.this$0.mActivity).mHandler.sendMessage(localMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.9.1
 * JD-Core Version:    0.7.0.1
 */