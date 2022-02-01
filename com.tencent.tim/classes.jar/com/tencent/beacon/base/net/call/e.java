package com.tencent.beacon.base.net.call;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.HttpMethod;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private final String a;
  private final HttpMethod b;
  private final Map<String, String> c;
  private final Map<String, String> d;
  private final String e;
  private BodyType f;
  private String g;
  private byte[] h;
  
  private e(HttpMethod paramHttpMethod, String paramString1, Map<String, String> paramMap1, BodyType paramBodyType, String paramString2, Map<String, String> paramMap2, byte[] paramArrayOfByte, String paramString3)
  {
    this.b = paramHttpMethod;
    this.a = paramString1;
    this.c = paramMap1;
    this.f = paramBodyType;
    this.g = paramString2;
    this.d = paramMap2;
    this.h = paramArrayOfByte;
    this.e = paramString3;
  }
  
  public static a b()
  {
    return new a();
  }
  
  public BodyType a()
  {
    return this.f;
  }
  
  public byte[] c()
  {
    return this.h;
  }
  
  public Map<String, String> d()
  {
    return this.d;
  }
  
  public Map<String, String> e()
  {
    return this.c;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public HttpMethod g()
  {
    return this.b;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public String i()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "HttpRequestEntity{url='" + this.a + '\'' + ", method=" + this.b + ", headers=" + this.c + ", formParams=" + this.d + ", bodyType=" + this.f + ", json='" + this.g + '\'' + ", tag='" + this.e + '\'' + '}';
  }
  
  public static class a
  {
    private HttpMethod a;
    private String b;
    private String c;
    private Map<String, String> d = new HashMap(3);
    private Map<String, String> e = new HashMap(3);
    private String f;
    private BodyType g;
    private byte[] h;
    
    private void a(BodyType paramBodyType)
    {
      if (this.g == null) {
        this.g = paramBodyType;
      }
      if (this.g == paramBodyType) {
        return;
      }
      throw new IllegalStateException("bodyType already set!");
    }
    
    public a a(HttpMethod paramHttpMethod)
    {
      this.a = paramHttpMethod;
      return this;
    }
    
    public a a(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a a(@NonNull Map<String, String> paramMap)
    {
      a(BodyType.FORM);
      this.d.putAll(paramMap);
      return this;
    }
    
    public e a()
    {
      if (this.a != null)
      {
        if (!TextUtils.isEmpty(this.b))
        {
          BodyType localBodyType = this.g;
          if (localBodyType != null)
          {
            int i = d.a[localBodyType.ordinal()];
            if (i != 1) {
              if (i != 2) {
                if (i == 3) {}
              }
            }
            while (!TextUtils.isEmpty(this.f))
            {
              do
              {
                do
                {
                  return new e(this.a, this.b, this.e, this.g, this.f, this.d, this.h, this.c, null);
                } while (this.h != null);
                throw new NullPointerException("data request body == null");
              } while (!this.d.isEmpty());
              throw new NullPointerException("form request body == null");
            }
            throw new NullPointerException("json request body == null");
          }
          throw new NullPointerException("bodyType == null");
        }
        throw new NullPointerException("request url == null!");
      }
      throw new NullPointerException("request method == null");
    }
    
    public a b(@NonNull String paramString)
    {
      this.b = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.e
 * JD-Core Version:    0.7.0.1
 */