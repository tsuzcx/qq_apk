package com.tencent.mobileqq.nearby.guide;

import acfp;
import ajrb;
import ajud;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyGuideActivity$2$1
  implements Runnable
{
  public NearbyGuideActivity$2$1(ajud paramajud, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.a.this$0.cwL();
    if (this.val$isSuccess)
    {
      this.a.this$0.aL(2, acfp.m(2131708723));
      this.a.this$0.Mp(true);
      this.a.this$0.finish();
      ajrb.c(this.a.this$0.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    String str2 = this.val$errorTips;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131708737);
    }
    this.a.this$0.aL(1, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.2.1
 * JD-Core Version:    0.7.0.1
 */