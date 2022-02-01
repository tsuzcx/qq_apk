package com.tencent.qqmail.activity.compose;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import java.util.List;

class ComposeFeedbackActivity$9$2
  implements PickerViewControl.PickerViewControlCallback
{
  ComposeFeedbackActivity$9$2(ComposeFeedbackActivity.9 param9, List paramList, TextView paramTextView) {}
  
  public void didSelectRow(PickerViewControl paramPickerViewControl, int paramInt)
  {
    paramPickerViewControl = ((String)this.val$users.get(paramInt)).split(" ");
    this.val$receiverView.setText(paramPickerViewControl[0]);
    this.this$1.this$0.setFeedbackReceiver(paramPickerViewControl[1]);
  }
  
  public void dismissPickerView(View paramView) {}
  
  public Activity getActivity()
  {
    return this.this$1.this$0;
  }
  
  public void touchUpOutSideContainer() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.9.2
 * JD-Core Version:    0.7.0.1
 */