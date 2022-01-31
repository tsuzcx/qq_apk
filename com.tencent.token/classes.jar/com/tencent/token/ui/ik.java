package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.utils.t;

final class ik
  implements View.OnClickListener
{
  ik(FaceRecognitionCreateActivity paramFaceRecognitionCreateActivity) {}
  
  public final void onClick(View paramView)
  {
    if (FaceRecognitionCreateActivity.access$100(this.a).isChecked())
    {
      if (ax.a().e() == null) {
        this.a.showNoAccountTipDialog(this.a, 3, 0);
      }
    }
    else {
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      this.a.showNoAccountTipDialog(this.a, 3, 1);
      return;
    }
    if (FaceRecognitionCreateActivity.getFlag())
    {
      if (t.l() == 0) {}
      for (paramView = new Intent(this.a, FaceRecognitionCameraActivityOld.class);; paramView = new Intent(this.a, FaceRegCameraActivity.class))
      {
        paramView.putExtra("scene", 1);
        paramView.putExtra("flag", 1);
        this.a.startActivity(paramView);
        this.a.finish();
        return;
      }
    }
    this.a.setContentView(2130903095);
    FaceRecognitionCreateActivity.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ik
 * JD-Core Version:    0.7.0.1
 */