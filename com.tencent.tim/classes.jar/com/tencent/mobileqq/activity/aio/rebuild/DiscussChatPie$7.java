package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.Editable;
import android.text.SpannableString;
import appb;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import xyi;

public class DiscussChatPie$7
  implements Runnable
{
  public DiscussChatPie$7(xyi paramxyi, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    if (this.bkh)
    {
      j = this.this$0.a.getSelectionStart();
      this.this$0.a.getEditableText().delete(j - 1, j);
    }
    SpannableString localSpannableString = appb.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo.aTl, this.aQa, this.aNb, false, this.this$0.a, false);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {
      return;
    }
    int j = this.this$0.a.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.this$0.a.getEditableText().insert(i, localSpannableString);
      xyi.a(this.this$0).abp(1);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie.7
 * JD-Core Version:    0.7.0.1
 */