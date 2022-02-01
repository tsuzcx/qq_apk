package com.tencent.open.adapter;

import android.content.Context;
import arwt;
import java.util.HashMap;

final class OpenAppClient$2
  implements Runnable
{
  OpenAppClient$2(Context paramContext, HashMap paramHashMap) {}
  
  public void run()
  {
    try
    {
      OpenAppClient.e(this.val$context, this.pN);
      return;
    }
    catch (Exception localException)
    {
      String str = "onPushMsg exception: " + this.pN;
      arwt.e(OpenAppClient.TAG, str, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.2
 * JD-Core Version:    0.7.0.1
 */