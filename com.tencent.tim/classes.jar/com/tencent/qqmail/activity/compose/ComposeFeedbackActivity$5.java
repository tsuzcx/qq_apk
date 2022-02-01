package com.tencent.qqmail.activity.compose;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeFeedbackActivity$5
  implements View.OnClickListener
{
  ComposeFeedbackActivity$5(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeFeedbackActivity.access$200(this.this$0).getEditableText().clear();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.5
 * JD-Core Version:    0.7.0.1
 */