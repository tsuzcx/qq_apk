package com.tencent.analysis.a;

import com.tencent.analysis.d.a.c;
import com.tencent.analysis.d.a.d;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  private static AtomicInteger c = new AtomicInteger(new Random(System.currentTimeMillis() / 1000L).nextInt());
  protected int a = -10000;
  int b = -1;
  private int d;
  private d e;
  private Map f = new HashMap();
  
  final DataOutputStream a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream = new DataOutputStream(paramByteArrayOutputStream);
    paramByteArrayOutputStream.writeByte(7);
    paramByteArrayOutputStream.writeShort(0);
    paramByteArrayOutputStream.writeShort(0);
    paramByteArrayOutputStream.writeShort(this.b);
    if (this.e == null) {
      this.e = c.a();
    }
    paramByteArrayOutputStream.writeShort(this.e.a);
    this.d = c.incrementAndGet();
    paramByteArrayOutputStream.writeInt(this.d);
    paramByteArrayOutputStream.writeByte(0);
    if (this.f.size() > 0)
    {
      Object localObject = new ByteArrayOutputStream(200);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeShort(this.f.size());
      int i = 0;
      while (i < this.f.size())
      {
        Iterator localIterator = this.f.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localDataOutputStream.write(((b)localEntry.getKey()).a((String)localEntry.getValue()));
        }
        i += 1;
      }
      localObject = this.e.b.b(((ByteArrayOutputStream)localObject).toByteArray());
      paramByteArrayOutputStream.writeShort(localObject.length);
      if (localObject.length != 0) {
        paramByteArrayOutputStream.write((byte[])localObject);
      }
      return paramByteArrayOutputStream;
    }
    paramByteArrayOutputStream.writeShort(0);
    return paramByteArrayOutputStream;
  }
  
  public final Map a()
  {
    return this.f;
  }
  
  public final void a(b paramb, String paramString)
  {
    if (paramb.b() != f.b) {}
    while ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    this.f.put(paramb, paramString);
  }
  
  abstract void a(DataOutputStream paramDataOutputStream);
  
  abstract void a(ByteBuffer paramByteBuffer);
  
  public final d b()
  {
    return this.e;
  }
  
  final void b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    if (i != 7) {
      throw new RuntimeException("STX(2) invalid:" + i);
    }
    paramByteBuffer.getShort();
    paramByteBuffer.getShort();
    this.b = paramByteBuffer.getShort();
    i = paramByteBuffer.getShort() & 0xFFFF;
    if (this.e == null)
    {
      this.e = c.a(i);
      if (this.e == null) {
        this.e = c.b();
      }
      if (this.e.a != i) {
        throw new RuntimeException("the keySerial [" + i + "] is unknow:" + c.c());
      }
    }
    this.d = paramByteBuffer.getInt();
    this.a = paramByteBuffer.get();
    i = paramByteBuffer.getShort() & 0xFFFF;
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer = ByteBuffer.wrap(this.e.b.a(arrayOfByte));
      int j = paramByteBuffer.getShort();
      i = 0;
      for (;;)
      {
        if (i < (0xFFFF & j)) {
          try
          {
            b.a(paramByteBuffer, this.f);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "CMD [seq=" + this.d + ", key=" + this.e + ", confField=" + this.f + ", cmd=" + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.a
 * JD-Core Version:    0.7.0.1
 */