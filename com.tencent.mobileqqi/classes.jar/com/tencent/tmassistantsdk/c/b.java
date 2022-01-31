package com.tencent.tmassistantsdk.c;

import com.tencent.tmassistantsdk.b.a;
import com.tencent.tmassistantsdk.d.c;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.protocol.jce.SettingsCfg;
import com.tencent.tmassistantsdk.protocol.jce.StatCfg;
import java.util.ArrayList;

public final class b
  implements c
{
  private static b a = null;
  private com.tencent.tmassistantsdk.d.b b = null;
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public final void a(GetSettingsResponse paramGetSettingsResponse, boolean paramBoolean)
  {
    this.b = null;
    if (paramBoolean)
    {
      if ((paramGetSettingsResponse.settings != null) && (paramGetSettingsResponse.settings.size() > 0))
      {
        paramGetSettingsResponse = (SettingsCfg)paramGetSettingsResponse.settings.get(0);
        if ((paramGetSettingsResponse != null) && (paramGetSettingsResponse.cfg != null))
        {
          paramGetSettingsResponse = (StatCfg)a.a(paramGetSettingsResponse.cfg, StatCfg.class);
          if (paramGetSettingsResponse == null) {
            break label84;
          }
          e.a().a(paramGetSettingsResponse.netType);
        }
      }
      for (;;)
      {
        j.b("GetSettingEngine", "response.settings is null !");
        return;
        label84:
        j.b("GetSettingEngine", "response  StatCfg is null !");
      }
    }
    j.b("GetSettingEngine", "get settings failed!");
  }
  
  public final void b()
  {
    try
    {
      if (this.b != null)
      {
        this.b.b();
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c()
  {
    if (this.b != null) {
      return;
    }
    this.b = new com.tencent.tmassistantsdk.d.b();
    this.b.a(this);
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.b
 * JD-Core Version:    0.7.0.1
 */