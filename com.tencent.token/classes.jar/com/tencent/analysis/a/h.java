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
    if ((paramString == null) || (paramString.length() < 21)) {}
    ByteArrayOutputStream localByteArrayOutputStream;
    for (paramString = null;; paramString = localByteArrayOutputStream.toByteArray())
    {
      paramString = ByteBuffer.wrap(paramString);
      b(paramString);
      if (this.a >= 0) {
        break;
      }
      c(paramString);
      return;
      localByteArrayOutputStream = new ByteArrayOutputStream();
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
    StringBuilder localStringBuilder = new StringBuilder("Response [errorMsg=").append(this.c).append(", isSucess()=");
    if (this.a == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool + ", toString()=" + super.toString() + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.h
 * JD-Core Version:    0.7.0.1
 */