package com.tencent.qqmail.ftn.activity;

import android.text.Editable;
import android.text.TextWatcher;

class FtnSearchListActivity$9
  implements TextWatcher
{
  FtnSearchListActivity$9(FtnSearchListActivity paramFtnSearchListActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.toString().length() > 0)
    {
      FtnSearchListActivity.access$1600(this.this$0);
      FtnSearchListActivity.access$1300(this.this$0, paramCharSequence.toString());
      FtnSearchListActivity.access$1500(this.this$0, FtnSearchListActivity.access$1400(this.this$0));
      return;
    }
    FtnSearchListActivity.access$800(this.this$0);
    FtnSearchListActivity.access$1300(this.this$0, "");
    FtnSearchListActivity.access$1500(this.this$0, "");
    FtnSearchListActivity.access$1700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnSearchListActivity.9
 * JD-Core Version:    0.7.0.1
 */