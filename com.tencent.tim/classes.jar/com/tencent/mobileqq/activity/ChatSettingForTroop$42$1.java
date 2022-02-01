package com.tencent.mobileqq.activity;

import android.text.SpannableString;
import android.text.TextUtils;
import aofe;
import aqpm;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class ChatSettingForTroop$42$1
  implements Runnable
{
  ChatSettingForTroop$42$1(ChatSettingForTroop.42 param42) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.a.this$0.p != null)
    {
      localFormSimpleItem = (FormSimpleItem)this.a.this$0.p[6];
      if ((localFormSimpleItem != null) && (!TextUtils.equals(localFormSimpleItem.a().getText(), this.a.this$0.a.troopColorNick)))
      {
        if (!TextUtils.isEmpty(this.a.this$0.a.troopColorNick)) {
          break label96;
        }
        localFormSimpleItem.setRightText(this.a.this$0.getString(2131699791));
      }
    }
    return;
    label96:
    SpannableString localSpannableString = new aofe(this.a.this$0.a.troopColorNick, 16).k();
    localFormSimpleItem.setRightText(localSpannableString);
    aqpm.a(this.a.this$0.app, localFormSimpleItem.a(), localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.42.1
 * JD-Core Version:    0.7.0.1
 */