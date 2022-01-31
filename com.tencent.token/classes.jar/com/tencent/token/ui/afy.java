package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.ax;
import com.tencent.token.utils.s;

final class afy
  implements View.OnClickListener
{
  afy(UtilsTokenLabActivity paramUtilsTokenLabActivity) {}
  
  public final void onClick(View paramView)
  {
    if (ax.a().j())
    {
      paramView = new Intent(this.a, FaceRecognitionDefaultActivity.class);
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      UtilsTokenLabActivity.access$000(this.a).setVisibility(4);
      s.h("util_lab_fr_new");
      return;
      paramView = new Intent(this.a, FaceRecognitionCreateActivity.class);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afy
 * JD-Core Version:    0.7.0.1
 */