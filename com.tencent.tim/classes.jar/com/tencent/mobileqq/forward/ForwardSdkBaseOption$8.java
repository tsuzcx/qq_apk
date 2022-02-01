package com.tencent.mobileqq.forward;

import ahki;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import anqx;
import com.tencent.mobileqq.app.QQAppInterface;

public class ForwardSdkBaseOption$8
  implements Runnable
{
  public ForwardSdkBaseOption$8(ahki paramahki, String paramString) {}
  
  public void run()
  {
    String str = anqx.load(this.this$0.mActivity.getApplicationContext(), this.this$0.app.getCurrentUin(), this.val$targetUrl);
    if (!TextUtils.isEmpty(str))
    {
      this.this$0.bf.putString("video_url", str);
      this.this$0.bf.putBoolean("video_url_load", true);
    }
    this.this$0.doC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.8
 * JD-Core Version:    0.7.0.1
 */