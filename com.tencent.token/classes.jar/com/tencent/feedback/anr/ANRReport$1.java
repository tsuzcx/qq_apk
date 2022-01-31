package com.tencent.feedback.anr;

import android.content.Context;

final class ANRReport$1
  implements Runnable
{
  ANRReport$1(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run()
  {
    ANRReport.uploadANRInfo(this.a, this.b, this.c, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.ANRReport.1
 * JD-Core Version:    0.7.0.1
 */