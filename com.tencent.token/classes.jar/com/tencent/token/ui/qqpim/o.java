package com.tencent.token.ui.qqpim;

import android.util.Log;
import com.tencent.token.dy;
import com.tmsdk.TMSDKContext;

class o
  implements dy
{
  o(QQPimNewActivity paramQQPimNewActivity) {}
  
  public void a()
  {
    QQPimNewActivity.access$502(this.a, true);
    this.a.runOnUiThread(new p(this));
    QQPimNewActivity.access$802(this.a, 0.0F);
    TMSDKContext.saveActionData(170023);
    Log.i("QQPimNewActivity", "onFinished: ");
  }
  
  public void a(float paramFloat)
  {
    Log.i("QQPimNewActivity", "onProgress: " + paramFloat);
    if ((paramFloat > 0.01D) && (paramFloat <= 1.0F) && (paramFloat > QQPimNewActivity.access$800(this.a)))
    {
      this.a.runOnUiThread(new q(this, paramFloat));
      QQPimNewActivity.access$802(this.a, paramFloat);
    }
  }
  
  public void b()
  {
    Log.i("QQPimNewActivity", "onPause: ");
    this.a.runOnUiThread(new r(this));
  }
  
  public void c()
  {
    this.a.runOnUiThread(new s(this));
    Log.i("QQPimNewActivity", "onCancel: ");
    QQPimNewActivity.access$802(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.o
 * JD-Core Version:    0.7.0.1
 */