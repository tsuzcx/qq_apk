package com.tencent.feedback.upload;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;

public final class a
  extends AbstractUploadDatas
{
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
  }
  
  public final N a()
  {
    Object localObject = c.a(this.c);
    byte[] arrayOfByte = "".getBytes();
    String str = t.a(this.c).b().d();
    try
    {
      localObject = com.tencent.feedback.proguard.a.a(b(), (c)localObject, arrayOfByte, (byte)-1, (byte)-1, str);
      if (localObject != null) {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      if (!e.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      e.d("rqdp{  encode2RequestPackage failed}", new Object[0]);
    }
    return null;
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.a
 * JD-Core Version:    0.7.0.1
 */