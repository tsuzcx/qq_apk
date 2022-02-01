package com.tencent.beacon.base.net.a;

import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import com.tencent.beacon.pack.ResponsePackageV2;
import com.tencent.beacon.pack.a;

public class b
  extends c.a<byte[], AbstractJceStruct>
{
  private final a a = new a();
  private final b b = new b();
  
  public static b a()
  {
    return new b();
  }
  
  public c<byte[], ResponsePackageV2> b()
  {
    return this.b;
  }
  
  public c<RequestPackageV2, byte[]> c()
  {
    return this.a;
  }
  
  static final class a
    implements c<RequestPackageV2, byte[]>
  {
    private byte[] a(byte[] paramArrayOfByte)
    {
      g localg = g.b();
      byte[] arrayOfByte = paramArrayOfByte;
      if (localg != null)
      {
        if (com.tencent.beacon.e.b.a().i()) {
          arrayOfByte = com.tencent.beacon.base.util.b.b(paramArrayOfByte, 2, 3, localg.a());
        }
      }
      else {
        return arrayOfByte;
      }
      return com.tencent.beacon.base.util.b.b(paramArrayOfByte, 2);
    }
    
    public byte[] a(RequestPackageV2 paramRequestPackageV2)
    {
      if (paramRequestPackageV2 == null) {
        paramRequestPackageV2 = null;
      }
      Object localObject;
      do
      {
        return paramRequestPackageV2;
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackageV2: " + paramRequestPackageV2.toString(), new Object[0]);
        localObject = new com.tencent.beacon.pack.b();
        paramRequestPackageV2.writeTo((com.tencent.beacon.pack.b)localObject);
        localObject = a(((com.tencent.beacon.pack.b)localObject).b());
        paramRequestPackageV2 = (RequestPackageV2)localObject;
      } while (localObject == null);
      com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + localObject.length, new Object[0]);
      return localObject;
    }
  }
  
  static final class b
    implements c<byte[], ResponsePackageV2>
  {
    private byte[] b(byte[] paramArrayOfByte)
    {
      g localg = g.b();
      if (com.tencent.beacon.e.b.a().i()) {
        return com.tencent.beacon.base.util.b.a(paramArrayOfByte, 2, 3, localg.a());
      }
      return com.tencent.beacon.base.util.b.a(paramArrayOfByte, 2);
    }
    
    public ResponsePackageV2 a(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        return null;
      }
      paramArrayOfByte = b(paramArrayOfByte);
      ResponsePackageV2 localResponsePackageV2 = new ResponsePackageV2();
      localResponsePackageV2.readFrom(new a(paramArrayOfByte));
      return localResponsePackageV2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.b
 * JD-Core Version:    0.7.0.1
 */