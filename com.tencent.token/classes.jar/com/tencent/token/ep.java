package com.tencent.token;

import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ep
{
  public h a = new h();
  public ArrayList b;
  String c;
  long d;
  private do e = do.a();
  
  public void a(h paramh)
  {
    try
    {
      this.a = paramh;
      paramh = this.e;
      this.c = do.c;
      if (do.a().e() != null) {
        this.d = this.e.e().mUin;
      }
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public boolean a(JSONArray paramJSONArray)
  {
    h localh = new h();
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
            localh.a = ((JSONObject)localObject).getInt("id");
            localh.b = ((JSONObject)localObject).getString("name");
            if (((JSONObject)localObject).getInt("value") == 0) {
              break label267;
            }
            bool = true;
            localh.c = bool;
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
        a(localh);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ep
 * JD-Core Version:    0.7.0.1
 */