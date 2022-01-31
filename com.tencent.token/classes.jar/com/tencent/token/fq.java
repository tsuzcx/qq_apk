package com.tencent.token;

import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.g;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fq
{
  public g a = new g();
  public ArrayList b;
  String c;
  long d;
  
  private void a(g paramg)
  {
    try
    {
      this.a = paramg;
      ax.a();
      this.c = ax.c;
      if (ax.a().e() != null) {
        this.d = ax.a().e().mUin;
      }
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    g localg = new g();
    if (paramJSONArray != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONArray.length() > 0)
        {
          i = 0;
          if (i < paramJSONArray.length())
          {
            Object localObject = paramJSONArray.getJSONObject(i);
            localg.a = ((JSONObject)localObject).getInt("id");
            localg.b = ((JSONObject)localObject).getString("name");
            if (((JSONObject)localObject).getInt("value") == 0) {
              break label267;
            }
            bool = true;
            localg.c = bool;
            localObject = ((JSONObject)localObject).getJSONArray("list");
            if (((JSONArray)localObject).length() > 0)
            {
              this.b = new ArrayList();
              int j = 0;
              if (j >= ((JSONArray)localObject).length()) {
                break label273;
              }
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
              DeviceInfo localDeviceInfo = new DeviceInfo();
              localDeviceInfo.dguid = localJSONObject.getString("dguid");
              localDeviceInfo.dname = localJSONObject.getString("dname");
              localDeviceInfo.dtype = localJSONObject.getString("dtype");
              localDeviceInfo.ddes = localJSONObject.getString("ddes");
              localDeviceInfo.dappid = localJSONObject.getInt("dappid");
              localDeviceInfo.dsubappid = localJSONObject.getInt("dsubappid");
              localDeviceInfo.dappname = localJSONObject.getString("dappname");
              this.b.add(localDeviceInfo);
              j += 1;
              continue;
            }
            this.b = new ArrayList();
            break label273;
          }
        }
        a(localg);
        return true;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return false;
      }
      label267:
      boolean bool = false;
      continue;
      label273:
      i += 1;
    }
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    g localg = new g();
    for (;;)
    {
      try
      {
        localg.a = paramJSONObject.getInt("id");
        localg.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          localg.c = bool;
          paramJSONObject = paramJSONObject.getJSONArray("list");
          if (paramJSONObject.length() > 0)
          {
            this.b = new ArrayList();
            int i = 0;
            if (i < paramJSONObject.length())
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
              DeviceInfo localDeviceInfo = new DeviceInfo();
              localDeviceInfo.dguid = localJSONObject.getString("dguid");
              localDeviceInfo.dname = localJSONObject.getString("dname");
              localDeviceInfo.dtype = localJSONObject.getString("dtype");
              localDeviceInfo.ddes = localJSONObject.getString("ddes");
              localDeviceInfo.dappid = localJSONObject.getInt("dappid");
              localDeviceInfo.dsubappid = localJSONObject.getInt("dsubappid");
              localDeviceInfo.dappname = localJSONObject.getString("dappname");
              this.b.add(localDeviceInfo);
              i += 1;
              continue;
            }
          }
          else
          {
            this.b = new ArrayList();
          }
          a(localg);
          return true;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fq
 * JD-Core Version:    0.7.0.1
 */