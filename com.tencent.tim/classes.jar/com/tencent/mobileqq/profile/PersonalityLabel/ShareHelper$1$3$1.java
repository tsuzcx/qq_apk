package com.tencent.mobileqq.profile.PersonalityLabel;

import alcf;
import alcf.a;
import alcg;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import rwt;

class ShareHelper$1$3$1
  implements Runnable
{
  ShareHelper$1$3$1(ShareHelper.1.3 param3, String paramString) {}
  
  public void run()
  {
    if (this.a.a.b.mActivity.isFinishing()) {
      return;
    }
    this.a.a.b.a.iW(false);
    if (TextUtils.isEmpty(this.val$filePath))
    {
      rwt.ez(1, 2131698711);
      return;
    }
    if (this.a.val$id == 2L)
    {
      WXShareHelper.a().b(this.val$filePath, this.a.a.b.N, 0);
      return;
    }
    WXShareHelper.a().b(this.val$filePath, this.a.a.b.N, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3.1
 * JD-Core Version:    0.7.0.1
 */