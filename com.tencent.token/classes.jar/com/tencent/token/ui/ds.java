package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.global.e;

final class ds
  implements CompoundButton.OnCheckedChangeListener
{
  ds(FaceChangePwdIndexActivity paramFaceChangePwdIndexActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    e.a("isChecked" + paramBoolean);
    e.a("mIsChecked" + FaceChangePwdIndexActivity.access$000(this.a));
    if (paramBoolean)
    {
      this.a.showUserDialog(2131362812, this.a.getResources().getString(2131362813), 2131361804, 2131362697, new dt(this), new du(this), new dv(this, paramBoolean));
      FaceChangePwdIndexActivity.access$200(this.a).setVisibility(4);
      FaceChangePwdIndexActivity.access$300(this.a).setVisibility(4);
      FaceChangePwdIndexActivity.access$400(this.a).setVisibility(4);
      return;
    }
    FaceChangePwdIndexActivity.access$200(this.a).setVisibility(0);
    FaceChangePwdIndexActivity.access$300(this.a).setVisibility(0);
    FaceChangePwdIndexActivity.access$400(this.a).setVisibility(0);
    this.a.showProDialog(this.a, 2131361808, 2131362485, null);
    FaceChangePwdIndexActivity.access$502(this.a, 3);
    FaceChangePwdIndexActivity.access$600(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ds
 * JD-Core Version:    0.7.0.1
 */