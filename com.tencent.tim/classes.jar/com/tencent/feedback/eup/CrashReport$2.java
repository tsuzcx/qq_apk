package com.tencent.feedback.eup;

import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.t;
import com.tencent.feedback.upload.UploadHandleListener;

final class CrashReport$2
  implements t
{
  CrashReport$2(UploadHandleListener paramUploadHandleListener) {}
  
  public final void a(int paramInt)
  {
    this.a.onUploadStart(paramInt);
  }
  
  public final void a(int paramInt, an paraman, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    if (paraman == null) {}
    for (int i = -1;; i = paraman.b)
    {
      this.a.onUploadEnd(paramInt, i, paramLong1, paramLong2, paramBoolean, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport.2
 * JD-Core Version:    0.7.0.1
 */