package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ch;

class wx
  implements View.OnClickListener
{
  wx(wp paramwp) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    ch.a().a(System.currentTimeMillis(), 91);
    paramView = new Intent(this.a.a, FaceRegCameraActivity.class);
    paramView.putExtra("flag", 3);
    paramView.putExtra("scene", 2);
    this.a.a.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wx
 * JD-Core Version:    0.7.0.1
 */