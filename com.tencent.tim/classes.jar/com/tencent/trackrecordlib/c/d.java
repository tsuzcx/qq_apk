package com.tencent.trackrecordlib.c;

import com.tencent.trackrecordlib.enums.EventTopic;
import com.tencent.trackrecordlib.enums.UiAction;
import org.json.JSONObject;

public class d
  extends a
{
  private final UiAction b;
  private final com.tencent.trackrecordlib.b.a c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  
  public d(a parama)
  {
    super(EventTopic.EVENT_UI_ACTION);
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.d = a.c(parama);
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.g = a.f(parama);
    this.h = a.g(parama);
    this.i = a.h(parama);
    this.j = a.i(parama);
    this.k = a.j(parama);
    a(a.k(parama));
  }
  
  public JSONObject e()
  {
    try
    {
      if (this.b != null) {
        this.a.put("op", this.b.getSeq());
      }
      if (this.c != null) {
        this.a.put("data", this.c.a());
      }
      this.a.put("view_type", this.d);
      this.a.put("view_tag", this.e);
      this.a.put("view_text", this.f);
      this.a.put("view_desc", this.g);
      this.a.put("view_pos", this.h);
      this.a.put("view_super", this.i);
      this.a.put("page", this.j);
      this.a.put("page_id", this.k);
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public UiAction f()
  {
    return this.b;
  }
  
  public static class a
  {
    private UiAction a = null;
    private com.tencent.trackrecordlib.b.a b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    
    public a a(com.tencent.trackrecordlib.b.a parama)
    {
      this.b = parama;
      return this;
    }
    
    public a a(UiAction paramUiAction)
    {
      this.a = paramUiAction;
      return this;
    }
    
    public a a(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public d a()
    {
      return new d(this);
    }
    
    public a b(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public a f(String paramString)
    {
      this.h = paramString;
      return this;
    }
    
    public a g(String paramString)
    {
      this.i = paramString;
      return this;
    }
    
    public a h(String paramString)
    {
      this.j = paramString;
      return this;
    }
    
    public a i(String paramString)
    {
      this.k = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.c.d
 * JD-Core Version:    0.7.0.1
 */