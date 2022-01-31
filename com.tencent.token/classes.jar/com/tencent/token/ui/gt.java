package com.tencent.token.ui;

import android.content.Intent;

final class gt
  implements Runnable
{
  gt(fz paramfz) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.a.a, FaceRecognitionDefaultActivity.class);
    localIntent.putExtra("toastflag", 1);
    localIntent.addFlags(67108864);
    this.a.a.startActivity(localIntent);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gt
 * JD-Core Version:    0.7.0.1
 */