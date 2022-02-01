package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;

public class ResolvePendingResult<T extends IMessageEntity>
  extends PendingResultImpl<ResolveResult<T>, T>
{
  protected ResolvePendingResult(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass)
  {
    super(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<R> paramClass)
  {
    return new ResolvePendingResult(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public T get()
  {
    return (IMessageEntity)((ResolveResult)await()).getValue();
  }
  
  public ResolveResult<T> onComplete(T paramT)
  {
    paramT = new ResolveResult(paramT);
    paramT.setStatus(new Status(0));
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.ResolvePendingResult
 * JD-Core Version:    0.7.0.1
 */