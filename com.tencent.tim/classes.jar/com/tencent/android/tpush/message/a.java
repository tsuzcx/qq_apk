package com.tencent.android.tpush.message;

import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONObject;

public abstract class a
{
  protected JSONObject a = null;
  protected String b = null;
  protected String c = null;
  private String d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  
  protected a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a()
  {
    try
    {
      this.a = new JSONObject(this.b);
      try
      {
        if (!this.a.isNull("title")) {
          this.d = this.a.getString("title");
        }
        if (!this.a.isNull("content")) {
          this.e = this.a.getString("content");
        }
        if (!this.a.isNull("custom_content"))
        {
          String str = this.a.optString("custom_content", "");
          if ((str != null) && (!str.trim().equals("{}"))) {
            this.f = str;
          }
        }
        if (!this.a.isNull("accept_time")) {
          this.g = this.a.optString("accept_time", "");
        }
      }
      catch (Throwable localThrowable6)
      {
        for (;;)
        {
          TLogger.d("BaseMessageHolder", "unexpected for decode");
        }
      }
      c();
      this.c = Md5.md5(this.b).toUpperCase();
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          this.a = new JSONObject(this.b.substring(this.b.indexOf("{"), this.b.lastIndexOf("}") + 1));
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            this.a = new JSONObject(this.b.substring(1));
          }
          catch (Throwable localThrowable3)
          {
            try
            {
              this.a = new JSONObject(this.b.substring(2));
            }
            catch (Throwable localThrowable4)
            {
              try
              {
                this.a = new JSONObject(this.b.substring(3));
              }
              catch (Throwable localThrowable5)
              {
                TLogger.d("BaseMessageHolder", "unexpected for decode");
              }
            }
          }
        }
      }
    }
  }
  
  public abstract int b();
  
  protected abstract void c();
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseMessageHolder [msgJson=").append(this.a).append(", msgJsonStr=").append(this.b).append(", title=").append(this.d).append(", content=").append(this.e).append(", customContent=").append(this.f).append(", acceptTime=").append(this.g).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.a
 * JD-Core Version:    0.7.0.1
 */