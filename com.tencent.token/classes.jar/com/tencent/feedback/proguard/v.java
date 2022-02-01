package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.AbstractUploadDatas;

public final class v
  extends AbstractUploadDatas
{
  private S d = null;
  
  public v(Context paramContext, int paramInt1, int paramInt2, S paramS)
  {
    super(paramContext, 1111, 540);
    this.d = paramS;
  }
  
  public final N a()
  {
    try
    {
      Context localContext = this.c;
      int i = this.a;
      if (this.d == null) {
        localObject = null;
      } else {
        localObject = this.d.a();
      }
      Object localObject = a(localContext, i, (byte[])localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      if (!e.a(localException)) {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.v
 * JD-Core Version:    0.7.0.1
 */