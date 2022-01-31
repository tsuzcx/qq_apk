package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;

final class zt
  implements View.OnClickListener
{
  zt(SettingPageActivity paramSettingPageActivity) {}
  
  public final void onClick(View paramView)
  {
    s.a(this.a, SettingPageActivity.access$700(this.a).headlineurl, RqdApplication.i().getResources().getString(2131362749));
    SettingPageActivity.mShowSafeNew = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zt
 * JD-Core Version:    0.7.0.1
 */