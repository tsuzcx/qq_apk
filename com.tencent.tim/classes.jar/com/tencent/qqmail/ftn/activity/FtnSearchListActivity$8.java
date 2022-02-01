package com.tencent.qqmail.ftn.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class FtnSearchListActivity$8
  implements TextView.OnEditorActionListener
{
  FtnSearchListActivity$8(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 0) || (paramInt == 2))
    {
      FtnSearchListActivity.access$1200(this.this$0);
      FtnSearchListActivity.access$1300(this.this$0, paramTextView.getText().toString());
      FtnSearchListActivity.access$1500(this.this$0, FtnSearchListActivity.access$1400(this.this$0));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.8
 * JD-Core Version:    0.7.0.1
 */