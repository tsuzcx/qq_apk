package com.tencent.android.tpush.message;

import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

public class d
  extends a
{
  private int d = 0;
  private int e = 1;
  private int f = 1;
  private int g = 1;
  private int h = 0;
  private int i = 0;
  private String j = "";
  private int k = 1;
  private String l = "";
  private String m = "";
  private int n = 0;
  private int o = 0;
  private String p = "";
  private String q = "";
  private String r = "";
  private int s = 2;
  private String t = "";
  private a u = new a();
  private int v = -1;
  private String w = "";
  private String x = "";
  private int y = 0;
  
  public d(String paramString)
  {
    super(paramString);
  }
  
  public String A()
  {
    return this.x;
  }
  
  public int B()
  {
    return this.y;
  }
  
  public int b()
  {
    return 1;
  }
  
  protected void c()
  {
    this.d = this.a.optInt("builder_id");
    this.e = this.a.optInt("ring", 1);
    this.l = this.a.optString("ring_raw");
    this.j = this.a.optString("icon_res");
    this.m = this.a.optString("small_icon");
    this.k = this.a.optInt("lights", 1);
    this.f = this.a.optInt("vibrate", 1);
    this.i = this.a.optInt("icon");
    this.n = this.a.optInt("icon_type", 0);
    this.h = this.a.optInt("n_id");
    this.o = this.a.optInt("style_id", 0);
    this.r = this.a.optString("xg_media_resources", null);
    this.t = this.a.optString("xg_media_audio_resources", null);
    this.p = this.a.optString("n_ch_id");
    this.q = this.a.optString("n_ch_name");
    this.s = this.a.optInt("is_show_type", 2);
    this.y = this.a.optInt("color", 0);
    if (!this.a.isNull("clearable")) {}
    for (this.g = this.a.optInt("clearable");; this.g = 1)
    {
      if (!this.a.isNull("action")) {
        a.a(this.u, this.a.getString("action"));
      }
      this.v = this.a.optInt("badge_type", -1);
      this.w = this.a.optString("thread_id");
      this.x = this.a.optString("thread_sumtext");
      return;
    }
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public int i()
  {
    return this.f;
  }
  
  public int j()
  {
    return this.g;
  }
  
  public int k()
  {
    return this.h;
  }
  
  public a l()
  {
    return this.u;
  }
  
  public int m()
  {
    return this.i;
  }
  
  public String n()
  {
    return this.r;
  }
  
  public String o()
  {
    return this.t;
  }
  
  public int p()
  {
    return this.k;
  }
  
  public String q()
  {
    return this.l;
  }
  
  public String r()
  {
    return this.j;
  }
  
  public String s()
  {
    return this.m;
  }
  
  public int t()
  {
    return this.n;
  }
  
  public int u()
  {
    return this.o;
  }
  
  public String v()
  {
    return this.p;
  }
  
  public String w()
  {
    return this.q;
  }
  
  public int x()
  {
    return this.s;
  }
  
  public int y()
  {
    return this.v;
  }
  
  public String z()
  {
    return this.w;
  }
  
  public static class a
  {
    public int a = NotificationAction.activity.getType();
    public String b = "";
    public a c = new a();
    public String d = "";
    public String e = "";
    public String f = "";
    public int g = 0;
    public String h = "";
    public String i = "";
    public String j = "";
    
    private void a(String paramString)
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("action_type")) {
        this.a = paramString.getInt("action_type");
      }
      if (!paramString.isNull("activity")) {
        this.b = paramString.getString("activity");
      }
      Object localObject;
      if (!paramString.isNull("aty_attr"))
      {
        localObject = paramString.optString("aty_attr");
        if (i.b((String)localObject)) {}
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        this.c.a = ((JSONObject)localObject).optInt("if");
        this.c.b = ((JSONObject)localObject).optInt("pf");
        if (!paramString.isNull("intent")) {
          this.d = paramString.getString("intent");
        }
        if (!paramString.isNull("browser"))
        {
          this.e = paramString.getString("browser");
          localObject = new JSONObject(this.e);
          if (!((JSONObject)localObject).isNull("url")) {
            this.f = ((JSONObject)localObject).getString("url");
          }
          if (!((JSONObject)localObject).isNull("confirm")) {
            this.g = ((JSONObject)localObject).getInt("confirm");
          }
        }
        if (!paramString.isNull("package_name"))
        {
          this.i = paramString.getString("package_name");
          paramString = new JSONObject(this.i);
          if (!paramString.isNull("packageDownloadUrl")) {
            this.j = paramString.getString("packageDownloadUrl");
          }
          if (!paramString.isNull("packageName")) {
            this.h = paramString.getString("packageName");
          }
          if (!paramString.isNull("confirm")) {
            this.g = paramString.getInt("confirm");
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TLogger.e("PushMessageAction", "decode activityAttribute error", localThrowable);
        }
      }
    }
    
    public static class a
    {
      public int a = 0;
      public int b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.d
 * JD-Core Version:    0.7.0.1
 */