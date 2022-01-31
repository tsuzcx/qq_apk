package com.tencent.token.ui;

import android.content.Intent;

final class fl
  implements Runnable
{
  fl(es parames) {}
  
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
 * Qualified Name:     com.tencent.token.ui.fl
 * JD-Core Version:    0.7.0.1
 */