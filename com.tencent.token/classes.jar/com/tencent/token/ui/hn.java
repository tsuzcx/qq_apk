package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.x;

class hn
  implements View.OnClickListener
{
  hn(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, DownLineNoticeActivity.class);
    this.a.startActivity(paramView);
    x.a("face_downline_notice_clicked", true);
    FaceRecognitionDefaultActivity.access$200(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hn
 * JD-Core Version:    0.7.0.1
 */