package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.global.h;

class ev
  implements CompoundButton.OnCheckedChangeListener
{
  ev(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    h.a("isChecked" + paramBoolean);
    h.a("mIsChecked" + FaceChangePwdIndexActivity.access$000(this.a));
    if (paramBoolean)
    {
      this.a.showUserDialog(2131231002, this.a.getResources().getString(2131231001), 2131230886, 2131231614, new ew(this), new ex(this), new ey(this, paramBoolean));
      FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
      FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
      FaceChangePwdIndexActivity.access$400(this.a).setVisibility(4);
      return;
    }
    FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
    FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
    FaceChangePwdIndexActivity.access$400(this.a).setVisibility(0);
    this.a.showProDialog(this.a, 2131230843, 2131231030, null);
    FaceChangePwdIndexActivity.access$502(this.a, 3);
    FaceChangePwdIndexActivity.access$600(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ev
 * JD-Core Version:    0.7.0.1
 */