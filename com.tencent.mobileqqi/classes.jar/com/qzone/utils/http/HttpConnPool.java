package com.qzone.utils.http;

import com.qzone.utils.http.pool.AbstractConnPool;
import com.qzone.utils.http.pool.ConnFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.DefaultClientConnection;

class HttpConnPool
  extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry>
{
  private static AtomicLong COUNTER = new AtomicLong();
  private final Log log;
  private final long timeToLive;
  private final TimeUnit tunit;
  
  public HttpConnPool(Log paramLog, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit)
  {
    super(new InternalConnFactory(), paramInt1, paramInt2);
    this.log = paramLog;
    this.timeToLive = paramLong;
    this.tunit = paramTimeUnit;
  }
  
  protected HttpPoolEntry createEntry(HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection)
  {
    String str = Long.toString(COUNTER.getAndIncrement());
    return new HttpPoolEntry(this.log, str, paramHttpRoute, paramOperatedClientConnection, this.timeToLive, this.tunit);
  }
  
  static class InternalConnFactory
    implements ConnFactory<HttpRoute, OperatedClientConnection>
  {
    public OperatedClientConnection create(HttpRoute paramHttpRoute)
      throws IOException
    {
      return new DefaultClientConnection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.HttpConnPool
 * JD-Core Version:    0.7.0.1
 */