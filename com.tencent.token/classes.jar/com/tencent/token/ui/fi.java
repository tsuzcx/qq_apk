package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class fi
  implements View.OnClickListener
{
  fi(FaceRecognitionAddFaceActivity paramFaceRecognitionAddFaceActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FaceRecognitionCameraActivity.class);
    paramView.putExtra("flag", 4);
    paramView.putExtra("scene", 7);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fi
 * JD-Core Version:    0.7.0.1
 */