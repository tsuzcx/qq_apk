package com.tencent.token.ui;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;
import com.tencent.token.utils.n;

final class ek
  implements View.OnClickListener
{
  ek(FacePKCameraActivity paramFacePKCameraActivity) {}
  
  public final void onClick(View paramView)
  {
    e.c("onBackPressed");
    FacePKCameraActivity.access$700(this.a).removeMessages(90);
    if (n.a().c())
    {
      FacePKCameraActivity.access$700(this.a).postDelayed(new el(this), 300L);
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ek
 * JD-Core Version:    0.7.0.1
 */