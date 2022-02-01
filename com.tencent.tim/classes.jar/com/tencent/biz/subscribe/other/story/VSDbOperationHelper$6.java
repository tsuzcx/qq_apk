package com.tencent.biz.subscribe.other.story;

import android.os.Handler;
import android.text.TextUtils;
import sfk;
import sfk.b;

public class VSDbOperationHelper$6
  implements Runnable
{
  public VSDbOperationHelper$6(sfk paramsfk, String paramString, sfk.b paramb, Handler paramHandler) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.aDQ)) {}
    VSUploadVideoEntry localVSUploadVideoEntry;
    do
    {
      return;
      localVSUploadVideoEntry = sfk.a(this.this$0, this.aDQ);
    } while ((this.a == null) || (this.val$handler == null));
    this.val$handler.post(new VSDbOperationHelper.6.1(this, localVSUploadVideoEntry));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSDbOperationHelper.6
 * JD-Core Version:    0.7.0.1
 */