package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONObject;

public class RealNameQueryResult
  implements Serializable
{
  private static final long serialVersionUID = 8007253534094985809L;
  private int is_auth_user;
  private int is_h5_user;
  private String mask_mobile;
  private String sms_port;
  private String sms_up_code;
  private int zzb_rebind_type;
  
  public RealNameQueryResult(JSONObject paramJSONObject)
  {
    this.is_auth_user = paramJSONObject.getInt("is_auth_user");
    this.is_h5_user = paramJSONObject.optInt("is_h5_user", 0);
    try
    {
      this.zzb_rebind_type = paramJSONObject.getInt("zzb_rebind_type");
      try
      {
        label35:
        this.mask_mobile = paramJSONObject.getString("mobile_mask");
        try
        {
          label45:
          this.sms_port = paramJSONObject.getString("sms_port");
          this.sms_up_code = paramJSONObject.getString("sms_up_code");
          return;
        }
        catch (Exception paramJSONObject) {}
      }
      catch (Exception localException1)
      {
        break label45;
      }
    }
    catch (Exception localException2)
    {
      break label35;
    }
  }
  
  public final int a()
  {
    return this.is_auth_user;
  }
  
  public final int b()
  {
    return this.zzb_rebind_type;
  }
  
  public final String c()
  {
    return this.mask_mobile;
  }
  
  public final String d()
  {
    return this.sms_port;
  }
  
  public final String e()
  {
    return this.sms_up_code;
  }
  
  public final int f()
  {
    return this.is_h5_user;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.RealNameQueryResult
 * JD-Core Version:    0.7.0.1
 */