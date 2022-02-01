package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

class ComposeMailActivity$15
  implements QMComposeFooter.QMComposeFooterCallback
{
  ComposeMailActivity$15(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onAddAttaches(QMComposeFooter paramQMComposeFooter, View paramView)
  {
    if (ComposeMailActivity.access$1100(this.this$0))
    {
      ComposeMailActivity.access$1200(this.this$0).changeAttachButtonBackground(false);
      ComposeMailActivity.access$1300(this.this$0);
      return;
    }
    this.this$0.composeView.blurEditerFocus();
    ComposeMailActivity.access$1200(this.this$0).changeAttachButtonBackground(true);
    ComposeMailActivity.access$1400(this.this$0);
    this.this$0.composeView.hideformatToolbar(false);
    this.this$0.onFormatToobarChange(false);
    ((InputMethodManager)this.this$0.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(ComposeMailActivity.access$1200(this.this$0).getWindowToken(), 0);
  }
  
  public boolean onChangeKeyBoardState(QMComposeFooter paramQMComposeFooter, View paramView)
  {
    boolean bool = this.this$0.composeView.isKBShown();
    if (bool) {
      ComposeMailActivity.access$1500(this.this$0);
    }
    while (!bool)
    {
      return true;
      ComposeMailActivity.access$1600(this.this$0);
    }
    return false;
  }
  
  public void onEditContent()
  {
    onEditContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.15
 * JD-Core Version:    0.7.0.1
 */