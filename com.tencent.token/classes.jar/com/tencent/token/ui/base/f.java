package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.FaceRecognitionDefaultActivity;

class f
  implements View.OnClickListener
{
  f(CopyFaceDialog paramCopyFaceDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent(CopyFaceDialog.a(this.a), FaceRecognitionDefaultActivity.class);
    paramView.addFlags(67108864);
    CopyFaceDialog.a(this.a).startActivity(paramView);
    ((Activity)CopyFaceDialog.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.f
 * JD-Core Version:    0.7.0.1
 */