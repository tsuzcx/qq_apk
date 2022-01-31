package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.s;

final class io
  implements View.OnClickListener
{
  io(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceChangePwdIndexActivity.class);
    paramView.putExtra("open_switch", FaceRecognitionDefaultActivity.access$000(this.a));
    this.a.startActivity(paramView);
    s.h("face_changepsw_redtip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.io
 * JD-Core Version:    0.7.0.1
 */