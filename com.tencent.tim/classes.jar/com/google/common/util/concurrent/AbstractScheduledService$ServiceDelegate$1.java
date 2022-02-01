package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

class AbstractScheduledService$ServiceDelegate$1
  implements Supplier<String>
{
  AbstractScheduledService$ServiceDelegate$1(AbstractScheduledService.ServiceDelegate paramServiceDelegate) {}
  
  public String get()
  {
    return this.this$1.this$0.serviceName() + " " + this.this$1.state();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.1
 * JD-Core Version:    0.7.0.1
 */