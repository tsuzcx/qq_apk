package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.CommonActionSheetDialog;

final class vn
  implements View.OnClickListener
{
  vn(RealNameGuidActivity paramRealNameGuidActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.getResources().getString(2131362475);
    String str = this.a.getResources().getString(2131362476);
    this.a.dialog = new CommonActionSheetDialog(this.a, this.a.listener, new String[] { paramView, str });
    this.a.dialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vn
 * JD-Core Version:    0.7.0.1
 */