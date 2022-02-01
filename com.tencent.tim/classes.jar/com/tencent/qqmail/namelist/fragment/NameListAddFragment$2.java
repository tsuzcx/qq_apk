package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;

class NameListAddFragment$2
  implements View.OnClickListener
{
  NameListAddFragment$2(NameListAddFragment paramNameListAddFragment) {}
  
  public void onClick(View paramView)
  {
    NameListAddFragment.access$100(this.this$0).getButtonLeft().setEnabled(true);
    if ((NameListAddFragment.access$200(this.this$0) != null) && (NameListAddFragment.access$200(this.this$0).isFocused()))
    {
      NameListAddFragment.access$200(this.this$0).setText("");
      NameListAddFragment.access$200(this.this$0).clearFocus();
      this.this$0.hideKeyBoard();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.popBackStack();
      this.this$0.hideKeyBoard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.2
 * JD-Core Version:    0.7.0.1
 */