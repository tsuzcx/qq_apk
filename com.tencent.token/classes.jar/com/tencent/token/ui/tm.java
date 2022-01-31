package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;

final class tm
  implements CompoundButton.OnCheckedChangeListener
{
  SafeMsgItem a;
  
  public tm(tj paramtj, SafeMsgItem paramSafeMsgItem)
  {
    this.a = paramSafeMsgItem;
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.mIsChecked = true;
      if (this.b.b.d()) {
        tj.b(this.b).setSelectState(true);
      }
      return;
    }
    this.a.mIsChecked = false;
    tj.b(this.b).setSelectState(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tm
 * JD-Core Version:    0.7.0.1
 */