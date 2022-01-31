package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.CommonActionSheetDialog;

class ua
  implements View.OnClickListener
{
  ua(RealNameActivity paramRealNameActivity) {}
  
  public void onClick(View paramView)
  {
    RealNameActivity.access$302(this.a, 2);
    paramView = this.a.getResources().getString(2131230988);
    String str = this.a.getResources().getString(2131230989);
    this.a.dialog = new CommonActionSheetDialog(this.a, 2131362182, this.a.listener, new String[] { paramView, str });
    this.a.dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ua
 * JD-Core Version:    0.7.0.1
 */