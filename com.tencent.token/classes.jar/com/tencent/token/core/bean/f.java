package com.tencent.token.core.bean;

import com.tencent.token.global.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public int a;
  public String b;
  public boolean c;
  public int d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public Object h = null;
  protected List<f> i = null;
  
  public void a(f paramf)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramf);
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a = paramJSONObject.getInt("id");
        this.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          this.c = bool;
          this.d = paramJSONObject.getInt("type");
          try
          {
            if (paramJSONObject.getInt("is_more") != 0) {
              break label281;
            }
            bool = false;
            this.g = bool;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        int j;
        Object localObject2;
        Object localObject1;
        bool = false;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("child");
          if (paramJSONObject != null)
          {
            j = 0;
            if (j < paramJSONObject.length())
            {
              localObject2 = paramJSONObject.getJSONObject(j);
              if (localObject2 == null) {
                break label286;
              }
              bool = true;
              g.a(bool);
              localObject1 = new f();
              if (!((f)localObject1).a((JSONObject)localObject2))
              {
                paramJSONObject = new StringBuilder();
                paramJSONObject.append("child json parse error: ");
                paramJSONObject.append(j);
                g.c(paramJSONObject.toString());
                return false;
              }
              a((f)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add child: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((f)localObject1).b);
              g.b(((StringBuilder)localObject2).toString());
              j += 1;
              continue;
            }
          }
          return true;
        }
        catch (JSONException paramJSONObject)
        {
          return true;
        }
        paramJSONObject = paramJSONObject;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException: ");
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        g.c(((StringBuilder)localObject1).toString());
        return false;
      }
      continue;
      label281:
      boolean bool = true;
      continue;
      label286:
      bool = false;
    }
  }
  
  public boolean b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a = paramJSONObject.getInt("id");
        this.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          this.c = bool;
        }
        int j;
        Object localObject2;
        Object localObject1;
        bool = false;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("child");
          if (paramJSONObject != null)
          {
            j = 0;
            if (j < paramJSONObject.length())
            {
              localObject2 = paramJSONObject.getJSONObject(j);
              if (localObject2 == null) {
                break label242;
              }
              bool = true;
              g.a(bool);
              localObject1 = new f();
              if (!((f)localObject1).b((JSONObject)localObject2))
              {
                paramJSONObject = new StringBuilder();
                paramJSONObject.append("child json parse error: ");
                paramJSONObject.append(j);
                g.c(paramJSONObject.toString());
                return false;
              }
              a((f)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add child: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((f)localObject1).b);
              g.b(((StringBuilder)localObject2).toString());
              j += 1;
              continue;
            }
          }
          return true;
        }
        catch (JSONException paramJSONObject)
        {
          return true;
        }
        paramJSONObject = paramJSONObject;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException: ");
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        g.c(((StringBuilder)localObject1).toString());
        return false;
      }
      continue;
      label242:
      boolean bool = false;
    }
  }
  
  public boolean c(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a = paramJSONObject.getInt("id");
        this.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          this.c = bool;
          if (paramJSONObject.getInt("is_more") != 0) {
            break label261;
          }
          bool = false;
          this.g = bool;
        }
        int j;
        Object localObject2;
        Object localObject1;
        bool = false;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("child");
          if (paramJSONObject != null)
          {
            j = 0;
            if (j < paramJSONObject.length())
            {
              localObject2 = paramJSONObject.getJSONObject(j);
              if (localObject2 == null) {
                break label266;
              }
              bool = true;
              g.a(bool);
              localObject1 = new f();
              if (!((f)localObject1).c((JSONObject)localObject2))
              {
                paramJSONObject = new StringBuilder();
                paramJSONObject.append("child json parse error: ");
                paramJSONObject.append(j);
                g.c(paramJSONObject.toString());
                return false;
              }
              a((f)localObject1);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("add child: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((f)localObject1).b);
              g.b(((StringBuilder)localObject2).toString());
              j += 1;
              continue;
            }
          }
          return true;
        }
        catch (JSONException paramJSONObject)
        {
          return true;
        }
        paramJSONObject = paramJSONObject;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("JSONException: ");
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        g.c(((StringBuilder)localObject1).toString());
        return false;
      }
      continue;
      label261:
      boolean bool = true;
      continue;
      label266:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.f
 * JD-Core Version:    0.7.0.1
 */