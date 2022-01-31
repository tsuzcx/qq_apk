package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.w;

class hm
  implements View.OnClickListener
{
  hm(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceChangeMobileActivity.class);
    paramView.putExtra("open_switch", FaceRecognitionDefaultActivity.access$100(this.a));
    this.a.startActivity(paramView);
    w.a(null, "face_changemobile_redtip", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hm
 * JD-Core Version:    0.7.0.1
 */