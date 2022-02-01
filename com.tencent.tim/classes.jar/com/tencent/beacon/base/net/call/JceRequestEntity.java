package com.tencent.beacon.base.net.call;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.a;
import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.base.net.b.d;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JceRequestEntity
{
  private static final String TAG = "JceRequestEntity";
  private final String appKey;
  private final byte[] content;
  private final String domain;
  private final Map<String, String> header;
  private final int port;
  private final int requestCmd;
  private final int responseCmd;
  private final RequestType type;
  private final String url;
  
  private JceRequestEntity(RequestType paramRequestType, String paramString1, String paramString2, int paramInt1, String paramString3, byte[] paramArrayOfByte, Map<String, String> paramMap, int paramInt2, int paramInt3)
  {
    this.type = paramRequestType;
    this.url = paramString1;
    this.domain = paramString2;
    this.port = paramInt1;
    this.appKey = paramString3;
    this.content = paramArrayOfByte;
    this.header = paramMap;
    this.requestCmd = paramInt2;
    this.responseCmd = paramInt3;
  }
  
  public static a builder()
  {
    return new a();
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public Map<String, String> getHeader()
  {
    return this.header;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public int getRequestCmd()
  {
    return this.requestCmd;
  }
  
  public int getResponseCmd()
  {
    return this.responseCmd;
  }
  
  public RequestType getType()
  {
    return this.type;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String toString()
  {
    return "JceRequestEntity{type=" + this.type + ", url='" + this.url + '\'' + ", domain='" + this.domain + '\'' + ", port=" + this.port + ", appKey='" + this.appKey + '\'' + ", content.length=" + this.content.length + ", header=" + this.header + ", requestCmd=" + this.requestCmd + ", responseCmd=" + this.responseCmd + '}';
  }
  
  public static final class a
  {
    private String a;
    private int b;
    private String c;
    private int d;
    private int e;
    private RequestType f;
    private String g;
    private Map<String, String> h = new ConcurrentHashMap(5);
    private Map<String, String> i = new LinkedHashMap(10);
    private byte[] j;
    private AbstractJceStruct k;
    
    public a a(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public a a(RequestType paramRequestType)
    {
      this.f = paramRequestType;
      return this;
    }
    
    public a a(AbstractJceStruct paramAbstractJceStruct)
    {
      this.k = paramAbstractJceStruct;
      return this;
    }
    
    public a a(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public a a(String paramString, int paramInt)
    {
      this.g = paramString;
      this.b = paramInt;
      return this;
    }
    
    public a a(@NonNull String paramString1, String paramString2)
    {
      this.h.put(paramString1, paramString2);
      return this;
    }
    
    public a a(Map<String, String> paramMap)
    {
      if (paramMap != null) {
        this.i.putAll(paramMap);
      }
      return this;
    }
    
    public JceRequestEntity a()
    {
      com.tencent.beacon.base.net.c localc;
      if ((!TextUtils.isEmpty(this.a)) || (!TextUtils.isEmpty(this.g)))
      {
        if (TextUtils.isEmpty(this.c)) {
          break label200;
        }
        localc = com.tencent.beacon.base.net.c.c();
        this.h.putAll(d.a());
        if (this.f == RequestType.EVENT)
        {
          this.j = ((byte[])localc.e.c().a((RequestPackageV2)this.k));
          return new JceRequestEntity(this.f, this.a, this.g, this.b, this.c, this.j, this.h, this.d, this.e, null);
        }
      }
      else
      {
        throw new IllegalArgumentException("url || domain == null");
      }
      Object localObject = this.k;
      if (localObject == null) {}
      for (localObject = "".getBytes();; localObject = ((AbstractJceStruct)localObject).toByteArray())
      {
        localObject = d.a(this.d, (byte[])localObject, this.i, this.c);
        this.j = ((byte[])localc.d.c().a(localObject));
        break;
      }
      label200:
      throw new IllegalArgumentException("appKey == null");
    }
    
    public a b(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.a = paramString;
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      this.i.put(paramString1, str);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.JceRequestEntity
 * JD-Core Version:    0.7.0.1
 */