package com.tencent.token;

import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class di
{
  public f a = new f();
  public ArrayList<DeviceInfo> b;
  String c;
  long d;
  private cr e = cr.a();
  
  public void a(f paramf)
  {
    try
    {
      this.a = paramf;
      paramf = this.e;
      this.c = cr.c;
      if (cr.a().e() != null) {
        this.d = this.e.e().mUin;
      }
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    f localf = new f();
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
            localf.a = ((JSONObject)localObject).getInt("id");
            localf.b = ((JSONObject)localObject).getString("name");
            if (((JSONObject)localObject).getInt("value") == 0) {
              break label270;
            }
            bool = true;
            localf.c = bool;
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
        a(localf);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.di
 * JD-Core Version:    0.7.0.1
 */