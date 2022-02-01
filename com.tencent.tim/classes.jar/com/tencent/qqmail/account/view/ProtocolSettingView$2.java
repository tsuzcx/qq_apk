package com.tencent.qqmail.account.view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.tencent.qqmail.account.helper.HelperTextChange;

class ProtocolSettingView$2
  implements HelperTextChange
{
  ProtocolSettingView$2(ProtocolSettingView paramProtocolSettingView) {}
  
  public void onChange(EditText paramEditText)
  {
    if (paramEditText == null) {
      return;
    }
    String str = paramEditText.getText().toString();
    if (paramEditText == ProtocolSettingView.access$000(this.this$0))
    {
      if (!ProtocolSettingView.access$100(this.this$0).isChecked()) {
        break label63;
      }
      ProtocolSettingView.access$202(this.this$0, str);
    }
    for (;;)
    {
      ProtocolSettingView.access$400(this.this$0, true, new View[] { paramEditText });
      return;
      label63:
      ProtocolSettingView.access$302(this.this$0, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.view.ProtocolSettingView.2
 * JD-Core Version:    0.7.0.1
 */