package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.UtilFucntionItem;
import com.tencent.token.utils.s;

final class zv
  implements View.OnClickListener
{
  zv(SettingPageActivity paramSettingPageActivity, UtilFucntionItem paramUtilFucntionItem) {}
  
  public final void onClick(View paramView)
  {
    SettingPageActivity.mShowQueryNew = false;
    if ((this.a.d() != null) && (!this.a.d().isEmpty())) {
      s.b(this.b, this.a.d(), this.a.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zv
 * JD-Core Version:    0.7.0.1
 */