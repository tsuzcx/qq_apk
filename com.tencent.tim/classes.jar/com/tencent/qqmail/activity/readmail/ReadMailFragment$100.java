package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$100
  implements View.OnClickListener
{
  ReadMailFragment$100(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView)
  {
    ReadMailFragment.access$2502(this.this$0, true);
    ReadMailFragment.access$16700(this.this$0);
    ReadMailFragment.access$2300(this.this$0).execJs("resetShowImages();");
    ReadMailFragment.access$2300(this.this$0).downloadResource();
    ReadMailFragment.access$2300(this.this$0).reflow();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.100
 * JD-Core Version:    0.7.0.1
 */