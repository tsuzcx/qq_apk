package com.tencent.beacon.base.net;

import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;

class a
  implements Callback<byte[]>
{
  a(c paramc, JceRequestEntity paramJceRequestEntity, boolean paramBoolean, Callback paramCallback) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      localObject1 = this.a.getType().name();
      if (!this.b) {
        break label215;
      }
    }
    label215:
    for (paramArrayOfByte = "402";; paramArrayOfByte = "452")
    {
      onFailure(new d((String)localObject1, paramArrayOfByte, 200, "raw response == null", null));
      return;
      Object localObject2;
      try
      {
        localObject1 = new StringBuilder();
        localObject1 = ((StringBuilder)localObject1).append("jceRequest: ").append(this.a.getType());
        com.tencent.beacon.base.util.c.a("[BeaconNet]", " request success!", new Object[0]);
        localObject1 = new StringBuilder();
        localObject2 = ((StringBuilder)localObject1).append("mode: ");
        boolean bool = this.b;
        if (bool)
        {
          localObject1 = "socket";
          com.tencent.beacon.base.util.c.a("[BeaconNet]", (String)localObject1, new Object[0]);
          this.c.onResponse(paramArrayOfByte);
          c.a(this.d);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = this.a.getType().name();
        if (!this.b) {}
      }
      for (paramArrayOfByte = "403";; paramArrayOfByte = "453")
      {
        onFailure(new d((String)localObject2, paramArrayOfByte, 200, localException.getMessage(), localException));
        return;
        String str = "http";
        break;
      }
    }
  }
  
  public void onFailure(d paramd)
  {
    com.tencent.beacon.base.util.c.a("[BeaconNet]", "jceRequest: " + paramd.toString(), new Object[0]);
    this.d.a(paramd);
    this.c.onFailure(paramd);
    c.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.a
 * JD-Core Version:    0.7.0.1
 */