package com.tencent.biz.subscribe.other.story;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import ram;
import sfk;
import sfp;

public class VSUploadVideoManager$6
  implements Runnable
{
  public VSUploadVideoManager$6(sfp paramsfp, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.aDQ)) {
      return;
    }
    ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[vs_publish_flow] deleteUploadTask() delete task info => fakeId=" + this.aDQ);
    Object localObject = sfp.a(this.this$0, this.this$0.by(), this.aDQ);
    if (localObject != null) {
      this.this$0.b((VSUploadVideoEntry)localObject);
    }
    if (this.this$0.a == null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "deleteUploadTask() mDbHelper == null");
      return;
    }
    this.this$0.a.tb(this.aDQ);
    localObject = new Intent();
    QQStoryContext.a().getApp().sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.6
 * JD-Core Version:    0.7.0.1
 */