package com.tencent.mobileqq.profile.PersonalityLabel;

import alcf;
import alcf.a;
import alcg;
import android.app.Activity;
import android.text.TextUtils;
import aqgv;
import avpw;
import avpw.d;
import com.tencent.mobileqq.app.QQAppInterface;
import rwt;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
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
    avpw.d locald = avpw.d.a();
    locald.cMP = this.a.a.b.mApp.getAccount();
    locald.nickname = aqgv.n(this.a.a.b.mApp, this.a.a.b.mApp.getAccount());
    avpw.a(this.a.a.b.mActivity, locald, this.val$filePath, this.a.a.b.mActivity.getString(2131693309), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */