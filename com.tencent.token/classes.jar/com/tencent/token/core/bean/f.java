package com.tencent.token.core.bean;

import org.json.JSONObject;

public class f
{
  public int a;
  public String b;
  public boolean c;
  public boolean d = false;
  public boolean e;
  
  public f(LoginProtectResult paramLoginProtectResult, JSONObject paramJSONObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.f
 * JD-Core Version:    0.7.0.1
 */