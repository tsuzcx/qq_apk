package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.SwitchButton;

class ey
  implements DialogInterface.OnCancelListener
{
  ey(ev paramev, boolean paramBoolean) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    h.a("onCancel");
    paramDialogInterface = FaceChangePwdIndexActivity.access$100(this.b.a);
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      paramDialogInterface.a(bool, false);
      FaceChangePwdIndexActivity.access$200(this.b.a).setVisibility(0);
      FaceChangePwdIndexActivity.access$300(this.b.a).setVisibility(0);
      FaceChangePwdIndexActivity.access$400(this.b.a).setVisibility(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ey
 * JD-Core Version:    0.7.0.1
 */