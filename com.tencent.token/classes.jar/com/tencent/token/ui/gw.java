package com.tencent.token.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.token.ch;
import com.tencent.token.ui.base.FaceView;

class gw
  implements View.OnClickListener
{
  gw(FaceRecognitionCameraPreview paramFaceRecognitionCameraPreview) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        bool = FaceRecognitionCameraPreview.b(this.a).getBrightMode();
        if (!bool) {
          continue;
        }
        FaceRecognitionCameraPreview.d(this.a).setImageDrawable(FaceRecognitionCameraPreview.c(this.a).getResources().getDrawable(2130837698));
        paramView = FaceRecognitionCameraPreview.b(this.a);
        if (bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
        boolean bool = false;
        continue;
      }
      catch (Error paramView)
      {
        paramView.printStackTrace();
      }
      paramView.setBrightMode(bool);
      return;
      FaceRecognitionCameraPreview.d(this.a).setImageDrawable(FaceRecognitionCameraPreview.c(this.a).getResources().getDrawable(2130837699));
      ch.a().a(System.currentTimeMillis(), 201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gw
 * JD-Core Version:    0.7.0.1
 */