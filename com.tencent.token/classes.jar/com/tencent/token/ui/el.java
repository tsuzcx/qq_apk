package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.global.h;

class el
  implements CompoundButton.OnCheckedChangeListener
{
  el(FaceChangeMobileActivity paramFaceChangeMobileActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    h.a("isChecked" + paramBoolean);
    h.a("mIsChecked" + FaceChangeMobileActivity.access$100(this.a));
    if (paramBoolean)
    {
      this.a.showUserDialog(2131231002, this.a.getResources().getString(2131231001), 2131230886, 2131231614, new em(this), new en(this), new eo(this, paramBoolean));
      FaceChangeMobileActivity.access$300(this.a).setVisibility(4);
      FaceChangeMobileActivity.access$400(this.a).setVisibility(4);
      FaceChangeMobileActivity.access$500(this.a).setVisibility(4);
      return;
    }
    FaceChangeMobileActivity.access$300(this.a).setVisibility(0);
    FaceChangeMobileActivity.access$400(this.a).setVisibility(0);
    FaceChangeMobileActivity.access$500(this.a).setVisibility(0);
    this.a.showProDialog(this.a, 2131230843, 2131231030, null);
    FaceChangeMobileActivity.access$602(this.a, 6);
    FaceChangeMobileActivity.access$700(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.el
 * JD-Core Version:    0.7.0.1
 */