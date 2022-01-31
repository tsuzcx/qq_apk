package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.do;
import com.tencent.token.utils.w;

class aem
  implements View.OnClickListener
{
  aem(UtilsTokenLabActivity paramUtilsTokenLabActivity) {}
  
  public void onClick(View paramView)
  {
    if (do.a().j())
    {
      paramView = new Intent(this.a, FaceRecognitionDefaultActivity.class);
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      UtilsTokenLabActivity.access$000(this.a).setVisibility(4);
      w.a(null, "util_lab_fr_new", true);
      return;
      paramView = new Intent(this.a, FaceRecognitionCreateActivity.class);
      this.a.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aem
 * JD-Core Version:    0.7.0.1
 */