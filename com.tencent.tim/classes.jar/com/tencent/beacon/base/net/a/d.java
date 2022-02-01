package com.tencent.beacon.base.net.a;

import android.text.TextUtils;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.SocketRequestPackage;
import java.util.Map;

public final class d
  implements c<JceRequestEntity, SocketRequestPackage>
{
  private Map<String, String> b(JceRequestEntity paramJceRequestEntity)
  {
    paramJceRequestEntity = paramJceRequestEntity.getHeader();
    if (!paramJceRequestEntity.containsKey("sid"))
    {
      String str = g.b().c();
      if (!TextUtils.isEmpty(str)) {
        paramJceRequestEntity.put("sid", str);
      }
    }
    return paramJceRequestEntity;
  }
  
  public SocketRequestPackage a(JceRequestEntity paramJceRequestEntity)
  {
    return new SocketRequestPackage(b(paramJceRequestEntity), paramJceRequestEntity.getContent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.d
 * JD-Core Version:    0.7.0.1
 */