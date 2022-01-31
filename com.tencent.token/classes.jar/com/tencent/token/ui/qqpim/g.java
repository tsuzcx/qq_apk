package com.tencent.token.ui.qqpim;

import android.util.Log;
import com.tencent.token.dy;
import com.tmsdk.TMSDKContext;

class g
  implements dy
{
  g(QQPimActivity paramQQPimActivity) {}
  
  public void a()
  {
    QQPimActivity.access$202(this.a, true);
    this.a.runOnUiThread(new h(this));
    QQPimActivity.access$502(this.a, 0.0F);
    TMSDKContext.saveActionData(170011);
    Log.i("QQPimActivity", "onFinished: ");
  }
  
  public void a(float paramFloat)
  {
    Log.i("QQPimActivity", "onProgress: " + paramFloat);
    if ((paramFloat > 0.01D) && (paramFloat <= 1.0F) && (paramFloat > QQPimActivity.access$500(this.a)))
    {
      this.a.runOnUiThread(new i(this, paramFloat));
      QQPimActivity.access$502(this.a, paramFloat);
    }
  }
  
  public void b()
  {
    Log.i("QQPimActivity", "onPause: ");
    this.a.runOnUiThread(new j(this));
  }
  
  public void c()
  {
    this.a.runOnUiThread(new k(this));
    Log.i("QQPimActivity", "onCancel: ");
    QQPimActivity.access$502(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.g
 * JD-Core Version:    0.7.0.1
 */