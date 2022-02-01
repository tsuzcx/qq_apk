package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.ui.QMTips;

class ReadMailTitle$1
  implements View.OnLongClickListener
{
  ReadMailTitle$1(ReadMailTitle paramReadMailTitle) {}
  
  public boolean onLongClick(View paramView)
  {
    this.this$0.setSelected(true);
    CommUtils.copyText(ReadMailTitle.access$000(this.this$0).getText().toString());
    paramView = new QMTips(this.this$0.getContext());
    paramView.showSuccess(2131718608);
    paramView.setCallback(new ReadMailTitle.1.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ReadMailTitle.1
 * JD-Core Version:    0.7.0.1
 */