package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.a;
import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.pack.AbstractResponseCommon;
import com.tencent.beacon.pack.ResponsePackage;

class i
  implements Callback<byte[]>
{
  i(j paramj, Callback paramCallback) {}
  
  public void a(byte[] paramArrayOfByte)
    throws NetException
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "raw response size: " + paramArrayOfByte.length, new Object[0]);
    Object localObject;
    if (j.a(this.b).getType() == RequestType.EVENT)
    {
      localObject = (AbstractResponseCommon)com.tencent.beacon.base.net.c.c().e.b().a(paramArrayOfByte);
      if (localObject != null) {
        paramArrayOfByte = null;
      }
    }
    do
    {
      com.tencent.beacon.base.net.b.d.a(j.b(this.b), ((AbstractResponseCommon)localObject).serverTime, ((AbstractResponseCommon)localObject).srcGatewayIp);
      localObject = this.a;
      if (localObject != null) {
        ((Callback)localObject).onResponse(paramArrayOfByte);
      }
      return;
      throw new NetException("ResponsePackageV2 == null");
      localObject = (AbstractResponseCommon)com.tencent.beacon.base.net.c.c().d.b().a(paramArrayOfByte);
      if (localObject == null) {
        break label214;
      }
      paramArrayOfByte = (ResponsePackage)localObject;
      if (paramArrayOfByte.cmd != j.a(this.b).getResponseCmd()) {
        break label204;
      }
      if (paramArrayOfByte.result != 0) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.sBuffer;
    } while ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0));
    throw new NetException("responsePackage.buffer == null");
    throw new NetException("responsePackage.result != OK(0)");
    label204:
    throw new NetException("responsePackage.cmd != requestEntity.responseCmd");
    label214:
    throw new NetException("responsePackage == null");
  }
  
  public void onFailure(com.tencent.beacon.base.net.d paramd)
  {
    Callback localCallback = this.a;
    if (localCallback != null) {
      localCallback.onFailure(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.i
 * JD-Core Version:    0.7.0.1
 */