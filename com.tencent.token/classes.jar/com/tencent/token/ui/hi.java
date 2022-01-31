package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

class hi
  implements View.OnClickListener
{
  hi(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public void onClick(View paramView)
  {
    if (FaceRecognitionCreateActivity.access$100(this.a).isChecked())
    {
      if (do.a().e() == null) {
        this.a.showNoAccountTipDialog(this.a, 3, 0);
      }
    }
    else {
      return;
    }
    if (!do.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 1);
      return;
    }
    if (FaceRecognitionCreateActivity.getFlag())
    {
      paramView = new Intent(this.a, FaceRegCameraActivity.class);
      paramView.putExtra("scene", 1);
      paramView.putExtra("flag", 1);
      this.a.startActivity(paramView);
      this.a.finish();
      return;
    }
    this.a.setContentView(2130968658);
    FaceRecognitionCreateActivity.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hi
 * JD-Core Version:    0.7.0.1
 */