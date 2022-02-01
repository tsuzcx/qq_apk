package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class RealNameQueryResult
  implements Serializable
{
  private static final long serialVersionUID = 8007253534094985809L;
  private int is_auth_user;
  private String mask_mobile;
  private String sms_port;
  private String sms_up_code;
  private int zzb_rebind_type;
  
  public RealNameQueryResult(JSONObject paramJSONObject)
  {
    this.is_auth_user = paramJSONObject.getInt("is_auth_user");
    try
    {
      this.zzb_rebind_type = paramJSONObject.getInt("zzb_rebind_type");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.mask_mobile = paramJSONObject.getString("mobile_mask");
          try
          {
            label34:
            this.sms_port = paramJSONObject.getString("sms_port");
            this.sms_up_code = paramJSONObject.getString("sms_up_code");
            return;
          }
          catch (Exception paramJSONObject) {}
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label34;
      }
    }
  }
  
  public int a()
  {
    return this.is_auth_user;
  }
  
  public int b()
  {
    return this.zzb_rebind_type;
  }
  
  public String c()
  {
    return this.mask_mobile;
  }
  
  public String d()
  {
    return this.sms_port;
  }
  
  public String e()
  {
    return this.sms_up_code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameQueryResult
 * JD-Core Version:    0.7.0.1
 */