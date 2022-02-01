package com.tencent.mobileqq.profile.PersonalityLabel;

import ahgq;
import alcf;
import alcf.a;
import alcg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import rwt;

class ShareHelper$1$1$1
  implements Runnable
{
  ShareHelper$1$1$1(ShareHelper.1.1 param1, String paramString) {}
  
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
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.val$filePath);
    localBundle.putString("forward_thumb", this.val$filePath);
    localBundle.putString("forward_urldrawable_big_url", this.val$filePath);
    localBundle.putString("forward_extra", this.val$filePath);
    localBundle.putInt(ahgq.bKy, 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ahgq.f(this.a.a.b.mActivity, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1.1
 * JD-Core Version:    0.7.0.1
 */