package com.tencent.mobileqq.fragment;

import android.text.TextUtils;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;

class UnitedVerifyMsgEditFragment$1$1
  implements Runnable
{
  UnitedVerifyMsgEditFragment$1$1(UnitedVerifyMsgEditFragment.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.a.this$0.aq.setText(this.aV);
    try
    {
      if (!TextUtils.isEmpty(this.bLk)) {
        this.a.this$0.aq.setSelection(this.aV.lastIndexOf(this.bLk), this.aV.length());
      }
      for (;;)
      {
        label58:
        this.a.this$0.mContext.getWindow().setSoftInputMode(4);
        return;
        if (!TextUtils.isEmpty(this.aV)) {
          this.a.this$0.aq.setSelection(this.aV.length());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment.1.1
 * JD-Core Version:    0.7.0.1
 */