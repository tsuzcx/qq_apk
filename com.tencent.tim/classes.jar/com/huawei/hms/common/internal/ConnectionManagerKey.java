package com.huawei.hms.common.internal;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;

public class ConnectionManagerKey<TOption extends Api.ApiOptions>
{
  private final Api<TOption> a;
  private final TOption b;
  private final boolean c;
  private final int d;
  private final String e;
  
  private ConnectionManagerKey(Api<TOption> paramApi, TOption paramTOption, String paramString)
  {
    this.c = false;
    this.a = paramApi;
    this.b = paramTOption;
    this.d = Objects.hashCode(new Object[] { this.a, this.b });
    this.e = paramString;
  }
  
  private ConnectionManagerKey(Api<TOption> paramApi, String paramString)
  {
    this.c = true;
    this.a = paramApi;
    this.b = null;
    this.d = System.identityHashCode(this);
    this.e = paramString;
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Api<TOption> paramApi, TOption paramTOption, String paramString)
  {
    return new ConnectionManagerKey(paramApi, paramTOption, paramString);
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Api<TOption> paramApi, String paramString)
  {
    return new ConnectionManagerKey(paramApi, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionManagerKey)) {
        return false;
      }
      paramObject = (ConnectionManagerKey)paramObject;
    } while ((this.c == paramObject.c) && (Objects.equal(this.a, paramObject.a)) && (Objects.equal(this.b, paramObject.b)) && (Objects.equal(this.e, paramObject.e)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.ConnectionManagerKey
 * JD-Core Version:    0.7.0.1
 */