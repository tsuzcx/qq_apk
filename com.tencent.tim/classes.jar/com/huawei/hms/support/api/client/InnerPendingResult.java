package com.huawei.hms.support.api.client;

import java.util.concurrent.TimeUnit;

public abstract class InnerPendingResult<R extends Result>
  extends PendingResult<R>
{
  public abstract R awaitOnAnyThread();
  
  public abstract R awaitOnAnyThread(long paramLong, TimeUnit paramTimeUnit);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.InnerPendingResult
 * JD-Core Version:    0.7.0.1
 */