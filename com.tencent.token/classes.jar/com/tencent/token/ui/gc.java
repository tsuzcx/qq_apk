package com.tencent.token.ui;

import android.content.Intent;

class gc
  implements Runnable
{
  gc(fj paramfj) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, ModifyQQPwdActivity.class);
    localIntent.putExtra("face_vry_succ", true);
    localIntent.putExtra("source_id", FaceRecognitionCameraActivity.access$1500(this.a.a));
    localIntent.addFlags(67108864);
    this.a.a.startActivity(localIntent);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gc
 * JD-Core Version:    0.7.0.1
 */