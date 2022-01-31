package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

final class is
  implements View.OnClickListener
{
  is(FaceRecognitionDefaultActivity paramFaceRecognitionDefaultActivity) {}
  
  public final void onClick(View paramView)
  {
    if (t.l() == 0)
    {
      paramView = new Intent(this.a, FacePKCameraActivity.class);
      paramView.putExtra("flag", 2);
      paramView.putExtra("istry", 2);
      this.a.startActivity(paramView);
      FaceRecognitionDefaultActivity.access$100(this.a).setVisibility(4);
      s.h("fr_redtip");
      return;
    }
    paramView = new Intent(this.a, FacePKCameraActivity.class);
    paramView.putExtra("flag", 2);
    paramView.putExtra("istry", 2);
    this.a.startActivity(paramView);
    FaceRecognitionDefaultActivity.access$100(this.a).setVisibility(4);
    s.h("fr_redtip");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.is
 * JD-Core Version:    0.7.0.1
 */