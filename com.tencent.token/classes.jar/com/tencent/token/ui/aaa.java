package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.token.af;
import com.tencent.token.utils.t;

final class aaa
  implements View.OnClickListener
{
  aaa(SettingSubmitCommentActivity paramSettingSubmitCommentActivity) {}
  
  public final void onClick(View paramView)
  {
    SettingSubmitCommentActivity.access$002(this.a, SettingSubmitCommentActivity.access$300(this.a).getText().toString());
    if (SettingSubmitCommentActivity.access$000(this.a).length() == 0) {
      return;
    }
    t.a(this.a);
    try
    {
      SettingSubmitCommentActivity.access$200(this.a).a(SettingSubmitCommentActivity.access$000(this.a), SettingSubmitCommentActivity.access$100(this.a));
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aaa
 * JD-Core Version:    0.7.0.1
 */