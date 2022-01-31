package com.tencent.tmassistantsdk.d;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;

public final class b
  extends d
{
  private c b = null;
  
  public final void a()
  {
    super.a(new GetSettingsRequest());
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    if (paramJceStruct2 == null) {
      j.b("GetSettingHttpRequest", "response is null!");
    }
    while ((this.b == null) || (paramInt != 0) || (!(paramJceStruct2 instanceof GetSettingsResponse))) {
      return;
    }
    paramJceStruct1 = (GetSettingsResponse)paramJceStruct2;
    if (paramJceStruct1.ret == 0)
    {
      this.b.a(paramJceStruct1, true);
      return;
    }
    this.b.a(paramJceStruct1, false);
  }
  
  public final void a(c paramc)
  {
    this.b = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.d.b
 * JD-Core Version:    0.7.0.1
 */