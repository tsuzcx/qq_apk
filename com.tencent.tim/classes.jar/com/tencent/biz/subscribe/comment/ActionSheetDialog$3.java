package com.tencent.biz.subscribe.comment;

import android.text.TextUtils;
import android.widget.TextView;
import sbx;

public class ActionSheetDialog$3
  implements Runnable
{
  public void run()
  {
    if (TextUtils.isEmpty(this.val$title))
    {
      sbx.a(this.this$0).setText("");
      sbx.a(this.this$0).setVisibility(8);
      return;
    }
    sbx.a(this.this$0).setText(this.val$title);
    sbx.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */