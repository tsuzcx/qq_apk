package com.tencent.analysis.a;

import com.tencent.analysis.d.a.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;

public abstract class h
  extends a
{
  protected String c;
  
  public final void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 21))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString = new GZIPInputStream(new ByteArrayInputStream(b.a(paramString)));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramString = localByteArrayOutputStream.toByteArray();
    }
    else
    {
      paramString = null;
    }
    paramString = ByteBuffer.wrap(paramString);
    b(paramString);
    if (this.a < 0)
    {
      c(paramString);
      return;
    }
    a(paramString);
  }
  
  void c(ByteBuffer paramByteBuffer) {}
  
  public final boolean c()
  {
    return this.a == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response [errorMsg=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isSucess()=");
    boolean bool;
    if (this.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(", toString()=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.h
 * JD-Core Version:    0.7.0.1
 */