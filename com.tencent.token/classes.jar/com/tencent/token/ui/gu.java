package com.tencent.token.ui;

import android.content.Intent;

final class gu
  implements Runnable
{
  gu(fz paramfz) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(this.a.a, ModifyQQPwdActivity.class);
    localIntent.putExtra("face_vry_succ", true);
    localIntent.addFlags(67108864);
    this.a.a.startActivity(localIntent);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gu
 * JD-Core Version:    0.7.0.1
 */