package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import rwt;

class PersonalityLabelShareActivity$2$1
  implements Runnable
{
  PersonalityLabelShareActivity$2$1(PersonalityLabelShareActivity.2 param2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.UM)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.Qu));
      this.a.this$0.sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.a.this$0.getString(2131717218, new Object[] { this.Qu }), 1).show(this.a.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.this$0.mEnable = true;
      this.a.this$0.UL = true;
      return;
      rwt.ez(1, 2131717217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity.2.1
 * JD-Core Version:    0.7.0.1
 */