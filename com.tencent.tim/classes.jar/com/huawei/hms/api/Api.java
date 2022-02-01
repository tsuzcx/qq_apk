package com.huawei.hms.api;

import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public class Api<O extends ApiOptions>
{
  private final String a;
  private final Options<O> b;
  public List<ConnectionPostProcessor> mConnetctPostList;
  
  public Api(String paramString)
  {
    this.a = paramString;
    this.b = null;
  }
  
  public Api(String paramString, Options<O> paramOptions)
  {
    this.a = paramString;
    this.b = paramOptions;
  }
  
  public String getApiName()
  {
    return this.a;
  }
  
  public Options<O> getOptions()
  {
    return this.b;
  }
  
  public List<ConnectionPostProcessor> getmConnetctPostList()
  {
    return this.mConnetctPostList;
  }
  
  public void setmConnetctPostList(List<ConnectionPostProcessor> paramList)
  {
    this.mConnetctPostList = paramList;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class Options<O>
  {
    public List<PermissionInfo> getPermissionInfoList(O paramO)
    {
      return Collections.emptyList();
    }
    
    public List<Scope> getScopeList(O paramO)
    {
      return Collections.emptyList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.Api
 * JD-Core Version:    0.7.0.1
 */