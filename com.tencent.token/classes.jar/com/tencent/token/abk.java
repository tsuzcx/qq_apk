package com.tencent.token;

import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class abk
{
  public te a = new te();
  public ArrayList<DeviceInfo> b;
  long c;
  
  private void a(te paramte)
  {
    try
    {
      this.a = paramte;
      if (tt.a().k.b() != null) {
        this.c = tt.a().k.b().mUin;
      }
      return;
    }
    finally
    {
      paramte = finally;
      throw paramte;
    }
  }
  
  public final boolean a(JSONArray paramJSONArray)
  {
    te localte = new te();
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
            localte.a = ((JSONObject)localObject).getInt("id");
            localte.b = ((JSONObject)localObject).getString("name");
            if (((JSONObject)localObject).getInt("value") == 0) {
              break label270;
            }
            bool = true;
            localte.c = bool;
            localObject = ((JSONObject)localObject).getJSONArray("list");
            if (((JSONArray)localObject).length() > 0)
            {
              this.b = new ArrayList();
              int j = 0;
              if (j >= ((JSONArray)localObject).length()) {
                break label276;
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
            break label276;
          }
        }
        a(localte);
        return true;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return false;
      }
      label270:
      boolean bool = false;
      continue;
      label276:
      i += 1;
    }
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    te localte = new te();
    for (;;)
    {
      try
      {
        localte.a = paramJSONObject.getInt("id");
        localte.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          localte.c = bool;
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
          a(localte);
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
 * Qualified Name:     com.tencent.token.abk
 * JD-Core Version:    0.7.0.1
 */