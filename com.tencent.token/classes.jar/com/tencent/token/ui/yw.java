package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.cw;
import com.tencent.token.utils.x;

class yw
  implements View.OnClickListener
{
  yw(SettingSubmitCommentActivity paramSettingSubmitCommentActivity) {}
  
  public void onClick(View paramView)
  {
    SettingSubmitCommentActivity.access$002(this.a, SettingSubmitCommentActivity.access$300(this.a).getText().toString());
    if (SettingSubmitCommentActivity.access$000(this.a).length() == 0) {
      return;
    }
    SettingSubmitCommentActivity.access$300(this.a).clearFocus();
    x.a(this.a);
    try
    {
      SettingSubmitCommentActivity.access$200(this.a).b(0L, SettingSubmitCommentActivity.access$000(this.a), SettingSubmitCommentActivity.access$100(this.a));
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yw
 * JD-Core Version:    0.7.0.1
 */