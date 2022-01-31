package com.tencent.mobileqq.msf.core.b;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;

public class b
  implements c
{
  MsfCore a;
  
  public b(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  protected int a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.put(paramArrayOfByte).flip();
    return localByteBuffer.getInt();
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws Exception
  {
    Object localObject2 = new e(paramMsfSocketInputBuffer).a();
    if (e.a((d)localObject2))
    {
      if (((d)localObject2).f() == -1) {
        break label104;
      }
      ((d)localObject2).a(new ContentLengthInputStream(paramMsfSocketInputBuffer, ((d)localObject2).f()));
    }
    for (;;)
    {
      i = ((d)localObject2).b().getStatusCode();
      if (i >= 200) {
        break;
      }
      if (i == 100) {
        break label283;
      }
      throw new ProtocolException("Unexpected response: " + ((d)localObject2).b());
      label104:
      if (((d)localObject2).h().equalsIgnoreCase("chunked")) {
        ((d)localObject2).a(new ChunkedInputStream(paramMsfSocketInputBuffer));
      } else {
        ((d)localObject2).a(new IdentityInputStream(paramMsfSocketInputBuffer));
      }
    }
    byte[] arrayOfByte1 = new byte[20480];
    Object localObject1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      int k = ((d)localObject2).k().read(arrayOfByte1);
      if (k <= 0) {
        break;
      }
      int j = i + k;
      byte[] arrayOfByte2 = new byte[k];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
      ((ArrayList)localObject1).add(arrayOfByte2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, " read " + arrayOfByte2.length);
        i = j;
      }
    }
    if (((ArrayList)localObject1).size() == 1) {
      this.a.sender.b((byte[])((ArrayList)localObject1).get(0));
    }
    label283:
    while (!paramMsfSocketInputBuffer.hasBufferedData())
    {
      return;
      localObject2 = new byte[i];
      localObject1 = ((ArrayList)localObject1).iterator();
      for (i = 0; ((Iterator)localObject1).hasNext(); i = arrayOfByte1.length + i)
      {
        arrayOfByte1 = (byte[])((Iterator)localObject1).next();
        System.arraycopy(arrayOfByte1, 0, localObject2, i, arrayOfByte1.length);
      }
      this.a.sender.b((byte[])localObject2);
    }
  }
  
  public byte[] a(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
    int k = a(arrayOfByte1);
    if (paramArrayOfByte.length > k)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      for (;;)
      {
        int m = i;
        if (paramArrayOfByte.length >= k)
        {
          byte[] arrayOfByte2 = new byte[k];
          System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, arrayOfByte2.length);
          byte[] arrayOfByte3 = b(paramd, paramString1, paramString2, arrayOfByte2);
          i += arrayOfByte3.length;
          localArrayList.add(arrayOfByte3);
          j += arrayOfByte2.length;
          if (j >= paramArrayOfByte.length) {
            m = i;
          }
        }
        else
        {
          paramd = new byte[m];
          paramString1 = localArrayList.iterator();
          for (i = 0; paramString1.hasNext(); i = paramString2.length + i)
          {
            paramString2 = (byte[])paramString1.next();
            System.arraycopy(paramString2, 0, paramd, i, paramString2.length);
          }
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, arrayOfByte1.length);
        k = a(arrayOfByte1);
      }
      return paramd;
    }
    return b(paramd, paramString1, paramString2, paramArrayOfByte);
  }
  
  protected byte[] b(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramd = ("POST / HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + paramd.c() + ":" + paramd.d() + "\r\n" + "Accept: */*\r\n" + "User-Agent: javaMsfClient\r\n" + "Content-Type: application/x-www-form-urlencoded\r\n" + "Content-Length: " + paramArrayOfByte.length + "\r\n\r\n").getBytes();
    paramString1 = new byte[paramd.length + paramArrayOfByte.length];
    System.arraycopy(paramd, 0, paramString1, 0, paramd.length);
    System.arraycopy(paramArrayOfByte, 0, paramString1, paramd.length, paramArrayOfByte.length);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.b
 * JD-Core Version:    0.7.0.1
 */