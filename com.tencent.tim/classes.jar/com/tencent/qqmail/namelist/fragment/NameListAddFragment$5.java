package com.tencent.qqmail.namelist.fragment;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import com.tencent.qqmail.view.QMTopBar;

class NameListAddFragment$5
  implements View.OnFocusChangeListener
{
  NameListAddFragment$5(NameListAddFragment paramNameListAddFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    paramView = (TextView)NameListAddFragment.access$100(this.this$0).getButtonLeft();
    if (paramBoolean)
    {
      i = 2131691246;
      paramView.setText(i);
      paramView = NameListAddFragment.access$100(this.this$0).getButtonRight();
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 0;; i = 4)
    {
      paramView.setVisibility(i);
      if (NameListAddFragment.access$300(this.this$0) != null)
      {
        paramView = this.this$0;
        if (!paramBoolean) {
          bool = true;
        }
        NameListAddFragment.access$400(paramView, bool);
      }
      return;
      i = 2131691552;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.5
 * JD-Core Version:    0.7.0.1
 */