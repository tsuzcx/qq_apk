package com.tencent.qqmail.activity.setting.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import java.util.Iterator;
import java.util.List;

class SettingFeedbackDetailActivity$2
  implements View.OnClickListener
{
  SettingFeedbackDetailActivity$2(SettingFeedbackDetailActivity paramSettingFeedbackDetailActivity) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = SettingFeedbackDetailActivity.access$500(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((UITableItemView)localIterator.next()).setChecked(false);
    }
    ((UITableItemView)paramView).setChecked(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity.2
 * JD-Core Version:    0.7.0.1
 */