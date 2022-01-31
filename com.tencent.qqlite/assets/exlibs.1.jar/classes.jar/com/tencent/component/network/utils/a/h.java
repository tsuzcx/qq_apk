package com.tencent.component.network.utils.a;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;

final class h
  implements ClientConnectionRequest
{
  h(g paramg, Future paramFuture) {}
  
  public final void abortRequest()
  {
    this.b.cancel(true);
  }
  
  public final ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    return this.a.a(this.b, paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.h
 * JD-Core Version:    0.7.0.1
 */