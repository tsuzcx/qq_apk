package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnlineDeviceResult
  implements Serializable
{
  private static final long serialVersionUID = 8266486502836044167L;
  public ArrayList<a> mDevicesList;
  
  public OnlineDeviceResult(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      this.mDevicesList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        a locala = new a();
        locala.a(localJSONObject);
        this.mDevicesList.add(locala);
        i += 1;
      }
    }
  }
  
  public class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public int h;
    
    public a() {}
    
    public void a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.getString("dguid");
      this.b = paramJSONObject.getString("dname");
      this.c = paramJSONObject.getString("dtype");
      this.d = paramJSONObject.getString("ddes");
      this.e = paramJSONObject.getInt("dappid");
      this.f = paramJSONObject.getInt("dsubappid");
      this.g = paramJSONObject.getString("dappname");
      this.h = paramJSONObject.getInt("dflag");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.OnlineDeviceResult
 * JD-Core Version:    0.7.0.1
 */