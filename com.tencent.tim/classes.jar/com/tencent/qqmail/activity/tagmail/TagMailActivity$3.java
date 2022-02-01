package com.tencent.qqmail.activity.tagmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TagMailActivity$3
  implements View.OnClickListener
{
  TagMailActivity$3(TagMailActivity paramTagMailActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.tagmail.TagMailActivity.3
 * JD-Core Version:    0.7.0.1
 */