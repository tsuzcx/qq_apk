package com.tencent.trackrecordlib.c;

import com.tencent.trackrecordlib.enums.EventTopic;
import org.json.JSONObject;

public class c
  extends a
{
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  
  public c(a parama)
  {
    super(EventTopic.EVENT_PAGE_CHANGE);
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.d = a.c(parama);
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.g = a.f(parama);
    this.h = a.g(parama);
    a(a.h(parama));
  }
  
  public JSONObject e()
  {
    try
    {
      this.a.put("pre_page_id", this.b);
      this.a.put("pre_page", this.c);
      this.a.put("page_id", this.d);
      this.a.put("page", this.e);
      this.a.put("pre_page_start", this.f);
      this.a.put("pre_page_end", this.g);
      this.a.put("page_start", this.h);
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static class a
  {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    
    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public c a()
    {
      return new c(this);
    }
    
    public a b(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      this.e = paramString;
      return this;
    }
    
    public a f(String paramString)
    {
      this.f = paramString;
      return this;
    }
    
    public a g(String paramString)
    {
      this.g = paramString;
      return this;
    }
    
    public a h(String paramString)
    {
      this.h = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.c.c
 * JD-Core Version:    0.7.0.1
 */