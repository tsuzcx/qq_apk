package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.util.b;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackage;
import com.tencent.beacon.pack.ResponsePackage;

public final class a
  extends c.a<byte[], AbstractJceStruct>
{
  private final a a = new a();
  private final b b = new b();
  
  public static a a()
  {
    return new a();
  }
  
  public c<byte[], ResponsePackage> b()
  {
    return this.b;
  }
  
  public c<RequestPackage, byte[]> c()
  {
    return this.a;
  }
  
  static final class a
    implements c<RequestPackage, byte[]>
  {
    private byte[] a(byte[] paramArrayOfByte)
    {
      g localg = g.b();
      byte[] arrayOfByte = paramArrayOfByte;
      if (localg != null) {
        arrayOfByte = b.b(paramArrayOfByte, 2, 3, localg.a());
      }
      return arrayOfByte;
    }
    
    private byte[] b(RequestPackage paramRequestPackage)
    {
      com.tencent.beacon.pack.c localc = new com.tencent.beacon.pack.c();
      localc.a(1);
      localc.b("test");
      localc.a("test");
      localc.b("detail", paramRequestPackage);
      return localc.a();
    }
    
    public byte[] a(RequestPackage paramRequestPackage)
    {
      if (paramRequestPackage == null) {
        paramRequestPackage = null;
      }
      byte[] arrayOfByte;
      do
      {
        return paramRequestPackage;
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackage: " + paramRequestPackage.toString(), new Object[0]);
        arrayOfByte = a(b(paramRequestPackage));
        paramRequestPackage = arrayOfByte;
      } while (arrayOfByte == null);
      com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + arrayOfByte.length, new Object[0]);
      return arrayOfByte;
    }
  }
  
  static final class b
    implements c<byte[], ResponsePackage>
  {
    private ResponsePackage b(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null) {
        try
        {
          if (paramArrayOfByte.length > 0)
          {
            com.tencent.beacon.pack.c localc = new com.tencent.beacon.pack.c();
            localc.a(paramArrayOfByte);
            paramArrayOfByte = new ResponsePackage();
            paramArrayOfByte = (ResponsePackage)localc.a("detail", paramArrayOfByte);
            return paramArrayOfByte;
          }
        }
        catch (Throwable paramArrayOfByte) {}
      }
      return null;
    }
    
    private byte[] c(byte[] paramArrayOfByte)
    {
      return b.a(paramArrayOfByte, 2, 3, g.b().a());
    }
    
    public ResponsePackage a(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      return b(c(paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.a
 * JD-Core Version:    0.7.0.1
 */