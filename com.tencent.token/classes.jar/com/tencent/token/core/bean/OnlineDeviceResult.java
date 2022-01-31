package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineDeviceResult
  implements Serializable
{
  private static final long serialVersionUID = 8266486502836044167L;
  public ArrayList mDevicesList;
  
  public OnlineDeviceResult(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      this.mDevicesList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        f localf = new f(this);
        localf.a = localJSONObject.getString("dguid");
        localf.b = localJSONObject.getString("dname");
        localf.c = localJSONObject.getString("dtype");
        localf.d = localJSONObject.getString("ddes");
        localf.e = localJSONObject.getInt("dappid");
        localf.f = localJSONObject.getInt("dsubappid");
        localf.g = localJSONObject.getString("dappname");
        localf.h = localJSONObject.getInt("dflag");
        this.mDevicesList.add(localf);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.OnlineDeviceResult
 * JD-Core Version:    0.7.0.1
 */