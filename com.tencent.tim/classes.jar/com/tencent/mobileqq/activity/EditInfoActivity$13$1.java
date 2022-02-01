package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.widget.QQToast;
import uvt;

public class EditInfoActivity$13$1
  implements Runnable
{
  public EditInfoActivity$13$1(uvt paramuvt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    this.a.this$0.xa(false);
    if (this.val$isSuccess)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.aMX);
      localIntent.putExtra("edit_action", this.a.this$0.mAction);
      this.a.this$0.setResult(-1, localIntent);
      this.a.this$0.finish();
      return;
    }
    QQToast.a(this.a.this$0, 2, 2131695970, 0).show(this.a.this$0.getTitleBarHeight());
    this.a.this$0.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.13.1
 * JD-Core Version:    0.7.0.1
 */