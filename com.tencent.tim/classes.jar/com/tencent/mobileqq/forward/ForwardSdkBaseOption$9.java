package com.tencent.mobileqq.forward;

import ahgf;
import ahki;
import akyj;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ForwardSdkBaseOption$9
  implements Runnable
{
  public ForwardSdkBaseOption$9(ahki paramahki) {}
  
  public void run()
  {
    this.this$0.gd("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy running...");
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.this$0.chm) && (this.this$0.b != null)))
      {
        if ((this.this$0.mShareAppId != 65520L) && (!this.this$0.anK())) {
          this.this$0.dol();
        }
      }
      else {
        try
        {
          this.this$0.gd("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy sleeping...");
          Thread.sleep(1000L);
          this.this$0.gd("ForwardOption.ForwardSdkBaseOption", "asyncUploadImageAndSendToBuddy awake.");
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "InterruptedException", localInterruptedException);
          this.this$0.dol();
          return;
        }
      }
    }
    if ((!this.this$0.chm) || (TextUtils.isEmpty(this.this$0.fT)))
    {
      this.this$0.gd("ForwardOption.ForwardSdkBaseOption", "-->asyncUploadImageAndSendToBuddy--skey not ready");
      this.this$0.doz();
      this.this$0.mActivity.runOnUiThread(new ForwardSdkBaseOption.9.1(this));
      this.this$0.dol();
      return;
    }
    if (this.this$0.b != null)
    {
      if ((this.this$0.b.getSourceUrl() != null) && (this.this$0.mShareAppId != Long.parseLong("1103584836"))) {
        this.this$0.bf.putString("struct_share_key_source_url", this.this$0.b.getSourceUrl());
      }
      if (!TextUtils.isEmpty(this.this$0.b.wk())) {
        this.this$0.bf.putString("struct_share_key_source_icon", this.this$0.b.wk());
      }
      if (this.this$0.b.getAppName() != null) {
        this.this$0.bf.putString("struct_share_key_source_name", this.this$0.b.getAppName());
      }
      if (this.this$0.b.getPkgName() != null) {
        this.this$0.bf.putString("struct_share_key_source_a_action_data", this.this$0.b.getPkgName());
      }
    }
    String str1 = this.this$0.app.getCurrentAccountUin();
    String str2 = this.this$0.bf.getString("detail_url");
    Object localObject1 = this.this$0.bf.getString("image_url");
    Object localObject2 = this.this$0.bf.getString("struct_share_key_source_url");
    String str3 = this.this$0.bf.getString("struct_share_key_source_icon");
    HashMap localHashMap = new HashMap();
    if ((!TextUtils.isEmpty(str2)) && (str2.length() > 150)) {
      localHashMap.put("targetUrl", str2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localHashMap.put("sourceIcon", str3);
    }
    localObject2 = new ImageInfo();
    ((ImageInfo)localObject2).selfuin = str1;
    ((ImageInfo)localObject2).toUin = this.this$0.bf.getString("uin");
    localObject2 = StructMsgForImageShare.scaleLocalImage(this.this$0.mActivity, (ImageInfo)localObject2, (String)localObject1, this.this$0.bf.getInt("uintype"));
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = new CompressInfo((String)localObject1, 0);
      akyj.c((CompressInfo)localObject2);
      if (((CompressInfo)localObject2).destPath != null)
      {
        this.this$0.bf.putInt("struct_share_key_thumb_height", ((CompressInfo)localObject2).dpy);
        this.this$0.bf.putInt("struct_share_key_thumb_width", ((CompressInfo)localObject2).dpx);
      }
      this.this$0.bf.putString("image_url", (String)localObject1);
      this.this$0.bf.remove("image_url_remote");
      this.this$0.bf.remove("title");
      this.this$0.bf.remove("desc");
      this.this$0.bf.remove("detail_url");
      this.this$0.b(str2, str1, localHashMap);
      return;
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.9
 * JD-Core Version:    0.7.0.1
 */