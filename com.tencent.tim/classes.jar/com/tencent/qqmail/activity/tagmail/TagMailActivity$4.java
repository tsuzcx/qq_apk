package com.tencent.qqmail.activity.tagmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TagMailActivity$4
  implements View.OnClickListener
{
  TagMailActivity$4(TagMailActivity paramTagMailActivity) {}
  
  public void onClick(View paramView)
  {
    TagMailActivity.access$100(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.tagmail.TagMailActivity.4
 * JD-Core Version:    0.7.0.1
 */