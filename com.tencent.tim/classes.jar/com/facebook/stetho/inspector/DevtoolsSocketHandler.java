package com.facebook.stetho.inspector;

import android.content.Context;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.websocket.WebSocketHandler;
import java.io.IOException;

public class DevtoolsSocketHandler
  implements SocketLikeHandler
{
  private final Context mContext;
  private final Iterable<ChromeDevtoolsDomain> mModules;
  private final LightHttpServer mServer;
  
  public DevtoolsSocketHandler(Context paramContext, Iterable<ChromeDevtoolsDomain> paramIterable)
  {
    this.mContext = paramContext;
    this.mModules = paramIterable;
    this.mServer = createServer();
  }
  
  private LightHttpServer createServer()
  {
    HandlerRegistry localHandlerRegistry = new HandlerRegistry();
    new ChromeDiscoveryHandler(this.mContext, "/inspector").register(localHandlerRegistry);
    localHandlerRegistry.register(new ExactPathMatcher("/inspector"), new WebSocketHandler(new ChromeDevtoolsServer(this.mModules)));
    return new LightHttpServer(localHandlerRegistry);
  }
  
  public void onAccepted(SocketLike paramSocketLike)
    throws IOException
  {
    this.mServer.serve(paramSocketLike);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.DevtoolsSocketHandler
 * JD-Core Version:    0.7.0.1
 */