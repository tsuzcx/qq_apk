package com.tencent.biz.subscribe.other.story;

import android.os.Bundle;
import android.text.TextUtils;
import ram;
import sfp;

public class VSUploadVideoManager$2
  implements Runnable
{
  public VSUploadVideoManager$2(sfp paramsfp, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Bundle localBundle;
    if (this.val$event != null)
    {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[qq process receive]  onWebEvent() event:" + this.val$event);
      if ((this.val$data != null) && (this.val$data.getBundle("data") != null))
      {
        localBundle = this.val$data.getBundle("data");
        if (localBundle != null) {
          break label97;
        }
        ram.e("Q.videostory.publish.upload.VSUploadVideoManager", "onWebEvent() bundle == null");
        if (this.this$0.a != null) {
          this.this$0.a.bme();
        }
      }
    }
    label97:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = localBundle.getString("fakeVid");
          } while ((TextUtils.isEmpty(str)) || (this.this$0.a == null));
          this.this$0.a.h(str, localBundle);
          return;
        } while (this.val$event == null);
        ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "[qq process receive]  onWebEvent() event:" + this.val$event);
      } while ((this.val$data == null) || (this.val$data.getBundle("data") == null));
      localBundle = this.val$data.getBundle("data");
      if (localBundle == null)
      {
        ram.e("Q.videostory.publish.upload.VSUploadVideoManager", "onWebEvent() bundle == null");
        return;
      }
      String str = localBundle.getString("fakeVid");
      i = localBundle.getInt("command", 0);
      if (15 == i)
      {
        this.this$0.tb(str);
        return;
      }
      if (14 == i)
      {
        this.this$0.td(str);
        return;
      }
    } while (16 != i);
    long l = localBundle.getLong("uin");
    this.this$0.te(String.valueOf(Long.valueOf(l)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoManager.2
 * JD-Core Version:    0.7.0.1
 */