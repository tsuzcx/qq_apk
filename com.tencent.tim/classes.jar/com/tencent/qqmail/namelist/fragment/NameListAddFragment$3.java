package com.tencent.qqmail.namelist.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.qqmail.view.QMTopBar;

class NameListAddFragment$3
  implements View.OnKeyListener
{
  NameListAddFragment$3(NameListAddFragment paramNameListAddFragment) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0) && (NameListAddFragment.access$100(this.this$0).getButtonRight().isEnabled()))
    {
      NameListAddFragment.access$000(this.this$0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.3
 * JD-Core Version:    0.7.0.1
 */