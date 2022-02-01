package com.tencent.token;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class sp
{
  public List<a> a;
  
  public sp(String paramString)
  {
    a(paramString);
  }
  
  private void a(String paramString)
  {
    this.a = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("uinlist");
        int i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          a locala = new a();
          locala.a = localJSONObject.getLong("uin");
          locala.b = localJSONObject.getString("uin_mask");
          locala.c = localJSONObject.getString("nick");
          locala.d = localJSONObject.getLong("real_uin");
          int j = localJSONObject.getInt("is_supper_qq");
          bool = true;
          if (j == 1)
          {
            locala.e = bool;
            this.a.add(locala);
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public static final class a
  {
    public long a;
    public String b;
    public String c;
    public long d;
    public boolean e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sp
 * JD-Core Version:    0.7.0.1
 */