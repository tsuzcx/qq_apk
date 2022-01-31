package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;

class gu
  implements View.OnClickListener
{
  gu(FaceRecognitionCameraActivity paramFaceRecognitionCameraActivity, QQUser paramQQUser) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", this.a);
    paramView.putExtra("intent.determin_factors_result", FaceRecognitionCameraActivity.access$1300(this.b));
    paramView.putExtra("intent.determin_verify_type", FaceRecognitionCameraActivity.access$2500(this.b));
    this.b.startActivityForResult(paramView, 111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gu
 * JD-Core Version:    0.7.0.1
 */