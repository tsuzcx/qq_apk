package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.upload.AbstractUploadDatas;

public final class v
  extends AbstractUploadDatas
{
  private B d = null;
  
  public v(Context paramContext, int paramInt1, int paramInt2, B paramB)
  {
    super(paramContext, 1111, 200);
    this.d = paramB;
  }
  
  public final C a()
  {
    try
    {
      Context localContext = this.c;
      int i = this.a;
      if (this.d == null) {}
      for (byte[] arrayOfByte = null;; arrayOfByte = this.d.a()) {
        return a(localContext, i, arrayOfByte);
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.v
 * JD-Core Version:    0.7.0.1
 */