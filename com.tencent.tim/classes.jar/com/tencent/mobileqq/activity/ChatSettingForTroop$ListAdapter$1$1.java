package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import aofe;
import aqpm;
import uqz;

public class ChatSettingForTroop$ListAdapter$1$1
  implements Runnable
{
  public ChatSettingForTroop$ListAdapter$1$1(uqz paramuqz, String paramString) {}
  
  public void run()
  {
    if (this.a.b.this$0.isDestory) {}
    while (!TextUtils.equals(this.a.a.uin, this.a.aMs)) {
      return;
    }
    SpannableString localSpannableString = new aofe(this.aMv, 12).k();
    this.a.CO.setText(localSpannableString);
    aqpm.a(this.a.b.this$0.app, this.a.CO, localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */