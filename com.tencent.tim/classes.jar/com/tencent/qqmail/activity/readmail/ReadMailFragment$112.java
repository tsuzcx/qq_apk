package com.tencent.qqmail.activity.readmail;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.EditTextInWebView;
import com.tencent.qqmail.view.QMQuickReplyView;
import com.tencent.qqmail.view.QMTopBar;

class ReadMailFragment$112
  implements TextWatcher
{
  ReadMailFragment$112(ReadMailFragment paramReadMailFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (ReadMailFragment.access$17200(this.this$0) != null)
    {
      ReadMailFragment.access$17200(this.this$0).refreshMinHeight();
      if ((this.this$0.getTopBar().getButtonRight() != null) && (ReadMailFragment.access$17300(this.this$0) != null))
      {
        paramEditable = this.this$0.getTopBar().getButtonRight();
        if (ReadMailFragment.access$17300(this.this$0).getText().length() <= 0) {
          break label88;
        }
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      paramEditable.setEnabled(bool);
      ReadMailFragment.access$17500(this.this$0, true);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ReadMailFragment.access$2300(this.this$0) != null) {
      ReadMailFragment.access$2300(this.this$0).reflow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.112
 * JD-Core Version:    0.7.0.1
 */