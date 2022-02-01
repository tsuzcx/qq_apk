package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class RealNameQueryResult
  implements Serializable
{
  private static final long serialVersionUID = 8007253534094985809L;
  public int is_auth_user;
  public String mask_mobile;
  public String sms_port;
  public String sms_up_code;
  public int zzb_rebind_type;
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameQueryResult
 * JD-Core Version:    0.7.0.1
 */