package com.tencent.component.network.utils.a;

import com.tencent.component.network.utils.a.b.e;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;

final class d
  extends e<HttpRoute, OperatedClientConnection>
{
  private RouteTracker a;
  private HttpRoute b;
  
  public d(String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
    this.b = paramHttpRoute;
    this.a = new RouteTracker(paramHttpRoute);
  }
  
  final RouteTracker a()
  {
    return this.a;
  }
  
  public final boolean a(long paramLong)
  {
    return super.a(paramLong);
  }
  
  public final void b()
  {
    this.a = new RouteTracker(this.b);
  }
  
  final HttpRoute c()
  {
    return this.a.toRoute();
  }
  
  public final boolean d()
  {
    return !((OperatedClientConnection)g()).isOpen();
  }
  
  public final void e()
  {
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)g();
    try
    {
      localOperatedClientConnection.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.d
 * JD-Core Version:    0.7.0.1
 */