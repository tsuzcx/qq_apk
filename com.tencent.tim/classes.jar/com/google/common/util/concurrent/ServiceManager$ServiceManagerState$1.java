package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.Map.Entry;

class ServiceManager$ServiceManagerState$1
  implements Function<Map.Entry<Service, Long>, Long>
{
  ServiceManager$ServiceManagerState$1(ServiceManager.ServiceManagerState paramServiceManagerState) {}
  
  public Long apply(Map.Entry<Service, Long> paramEntry)
  {
    return (Long)paramEntry.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ServiceManager.ServiceManagerState.1
 * JD-Core Version:    0.7.0.1
 */