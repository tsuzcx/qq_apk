package com.tencent.qqmail.account.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProtocolSettingView$1
  implements View.OnClickListener
{
  ProtocolSettingView$1(ProtocolSettingView paramProtocolSettingView) {}
  
  public void onClick(View paramView)
  {
    String str = ProtocolSettingView.access$000(this.this$0).getText().toString();
    if (ProtocolSettingView.access$100(this.this$0).isChecked())
    {
      ProtocolSettingView.access$000(this.this$0).setText(ProtocolSettingView.access$200(this.this$0));
      ProtocolSettingView.access$302(this.this$0, str);
    }
    for (;;)
    {
      ProtocolSettingView.access$100(this.this$0).setFocusable(true);
      ProtocolSettingView.access$100(this.this$0).setFocusableInTouchMode(true);
      ProtocolSettingView.access$100(this.this$0).requestFocus();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProtocolSettingView.access$000(this.this$0).setText(ProtocolSettingView.access$300(this.this$0));
      ProtocolSettingView.access$202(this.this$0, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.view.ProtocolSettingView.1
 * JD-Core Version:    0.7.0.1
 */