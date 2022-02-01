package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.Editable;
import android.text.SpannableString;
import anot;
import appb;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import xwn;

public class BaseTroopChatPie$5
  implements Runnable
{
  public BaseTroopChatPie$5(xwn paramxwn, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.bkh)
    {
      i = this.this$0.a.getSelectionStart();
      this.this$0.a.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = appb.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo.aTl, this.aQa, this.aNb, this.this$0.SV(), this.this$0.a, true);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {}
    do
    {
      return;
      int j = this.this$0.a.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.a.getEditableText().insert(i, localSpannableString);
      xwn.a(this.this$0).abp(1);
      if (this.val$source == 1)
      {
        anot.a(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.this$0.sessionInfo.aTl, "", "", "");
        return;
      }
    } while (this.val$source != 4);
    if ((this.aQa != null) && (this.aQa.equalsIgnoreCase("0")))
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.this$0.sessionInfo.aTl, "", "", "");
      return;
    }
    anot.a(this.this$0.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.this$0.sessionInfo.aTl, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */