package com.tencent.analysis.a;

import com.tencent.analysis.d.a.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;

public abstract class g
  extends a
{
  public String c()
  {
    Object localObject1 = new ByteArrayOutputStream(200);
    a(a((ByteArrayOutputStream)localObject1));
    ((ByteArrayOutputStream)localObject1).write(112);
    short s = (short)((ByteArrayOutputStream)localObject1).size();
    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
    Object localObject2 = ByteBuffer.wrap((byte[])localObject1);
    ((ByteBuffer)localObject2).position(1);
    ((ByteBuffer)localObject2).putShort(s);
    if ((localObject1 == null) || (localObject1.length == 0)) {
      return null;
    }
    localObject2 = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject2);
    localGZIPOutputStream.write((byte[])localObject1);
    localGZIPOutputStream.close();
    return b.a(((ByteArrayOutputStream)localObject2).toByteArray());
  }
  
  public String toString()
  {
    return "Request [toString()=" + super.toString() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.g
 * JD-Core Version:    0.7.0.1
 */