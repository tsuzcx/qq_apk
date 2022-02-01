package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginProtectResult
  implements Serializable
{
  public static final int CONF_ID_DEVICE_LOCK = 71;
  public static final int CONF_ID_GAME_PROTECT = 6;
  public static final int CONF_ID_MAIL_PROTECT = 70;
  public static final int CONF_ID_QQ_PROTECT = 80;
  public static final int CONF_ID_QQ_PROTECT_1_0 = 81;
  public static final int CONF_ID_WEB_PROTECT = 82;
  private static final long serialVersionUID = 2427127947506109099L;
  public List<a> mLists = new ArrayList();
  
  public LoginProtectResult(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("list");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      int j = ((JSONObject)localObject).getInt("id");
      if ((j == 80) || (j == 82))
      {
        localObject = new a((JSONObject)localObject);
        this.mLists.add(localObject);
      }
      i += 1;
    }
  }
  
  public class a
  {
    public int a;
    public String b;
    public boolean c;
    public boolean d = false;
    public boolean e;
    
    public a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.getInt("id");
      this.b = paramJSONObject.getString("title");
      if (paramJSONObject.getInt("is_set") == 1)
      {
        bool1 = true;
        this.c = bool1;
        if (this.a == 80) {
          if (paramJSONObject.getInt("is_device_set") != 1) {
            break label87;
          }
        }
      }
      label87:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.e = bool1;
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.LoginProtectResult
 * JD-Core Version:    0.7.0.1
 */