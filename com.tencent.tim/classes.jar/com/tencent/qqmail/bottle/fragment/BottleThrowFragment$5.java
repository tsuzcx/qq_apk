package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.view.QMTopBar;

class BottleThrowFragment$5
  implements View.OnClickListener
{
  BottleThrowFragment$5(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.getTopBar() != null) && (this.this$0.getTopBar().getButtonRight() != null)) {
      this.this$0.getTopBar().getButtonRight().setEnabled(false);
    }
    BottleThrowFragment.access$100(this.this$0).sendBottle(BottleThrowFragment.access$600(this.this$0).getText().toString(), BottleThrowFragment.access$700(this.this$0), BottleThrowFragment.access$800(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.5
 * JD-Core Version:    0.7.0.1
 */