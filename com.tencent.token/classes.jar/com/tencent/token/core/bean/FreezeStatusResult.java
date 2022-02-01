package com.tencent.token.core.bean;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class FreezeStatusResult
  implements Serializable
{
  private static final long serialVersionUID = 7676294823998377948L;
  public int mAutoFreezeIntervalTime;
  public long mAutoMeltTime;
  public String mFreezeReason;
  public boolean mFreezeReasonOK;
  public int mFreezeStatus;
  
  public FreezeStatusResult(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.mFreezeStatus = paramJSONObject.getInt("freeze_state");
        this.mFreezeReason = paramJSONObject.getString("system_freeze_reason");
        this.mAutoMeltTime = paramJSONObject.getLong("auto_melt_time");
        this.mAutoFreezeIntervalTime = paramJSONObject.getInt("auto_freeze_time");
        int i = paramJSONObject.getInt("freeze_success");
        bool = true;
        if (i == 1)
        {
          this.mFreezeReasonOK = bool;
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.FreezeStatusResult
 * JD-Core Version:    0.7.0.1
 */