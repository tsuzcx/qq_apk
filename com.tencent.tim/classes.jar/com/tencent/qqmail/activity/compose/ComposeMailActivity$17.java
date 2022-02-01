package com.tencent.qqmail.activity.compose;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import java.util.ArrayList;

class ComposeMailActivity$17
  implements PickerViewControl.PickerViewControlCallback
{
  ComposeMailActivity$17(ComposeMailActivity paramComposeMailActivity) {}
  
  public void didSelectRow(PickerViewControl paramPickerViewControl, int paramInt)
  {
    if (paramPickerViewControl == ComposeMailActivity.access$2200(this.this$0))
    {
      paramPickerViewControl = (MailGroupContact)ComposeMailActivity.access$2300(this.this$0).getGroupContacts().get(paramInt);
      if (paramPickerViewControl != null) {
        ComposeMailActivity.access$2400(this.this$0, paramPickerViewControl);
      }
    }
  }
  
  public void dismissPickerView(View paramView) {}
  
  public Activity getActivity()
  {
    return this.this$0;
  }
  
  public void touchUpOutSideContainer() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.17
 * JD-Core Version:    0.7.0.1
 */