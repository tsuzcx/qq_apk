package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mrf;

public class VideoUploadController$1
  implements Runnable
{
  public VideoUploadController$1(mrf parammrf) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(mrf.a(this.this$0))) && (!TextUtils.isEmpty(mrf.b(this.this$0))) && (!mrf.a(this.this$0).equals(mrf.b(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "clearTempFile(video), origin:" + mrf.a(this.this$0) + ", compress:" + mrf.b(this.this$0));
      }
      File localFile = new File(mrf.b(this.this$0));
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController.1
 * JD-Core Version:    0.7.0.1
 */