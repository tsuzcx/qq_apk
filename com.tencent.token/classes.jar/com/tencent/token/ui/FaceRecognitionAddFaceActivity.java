package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FaceRecognitionAddFaceActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296334);
    ((Button)findViewById(2131165470)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(FaceRecognitionAddFaceActivity.this, FaceRecognitionCameraActivity.class);
        paramAnonymousView.putExtra("flag", 4);
        paramAnonymousView.putExtra("scene", 7);
        FaceRecognitionAddFaceActivity.this.startActivity(paramAnonymousView);
        FaceRecognitionAddFaceActivity.this.finish();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionAddFaceActivity
 * JD-Core Version:    0.7.0.1
 */