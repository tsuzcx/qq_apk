package com.facebook.stetho.dumpapp;

import android.net.Uri;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

@Deprecated
public class DumpappHttpSocketLikeHandler
  implements SocketLikeHandler
{
  private final LightHttpServer mServer;
  
  public DumpappHttpSocketLikeHandler(Dumper paramDumper)
  {
    HandlerRegistry localHandlerRegistry = new HandlerRegistry();
    localHandlerRegistry.register(new ExactPathMatcher("/dumpapp"), new DumpappLegacyHttpHandler(paramDumper));
    this.mServer = new LightHttpServer(localHandlerRegistry);
  }
  
  public void onAccepted(SocketLike paramSocketLike)
    throws IOException
  {
    this.mServer.serve(paramSocketLike);
  }
  
  static class DumpappLegacyHttpHandler
    implements HttpHandler
  {
    private static final String CONTENT_TYPE = "application/octet-stream";
    private static final String QUERY_PARAM_ARGV = "argv";
    private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private final Dumper mDumper;
    
    public DumpappLegacyHttpHandler(Dumper paramDumper)
    {
      this.mDumper = paramDumper;
    }
    
    public boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse)
      throws IOException
    {
      boolean bool = "POST".equals(paramLightHttpRequest.method);
      int i;
      ByteArrayOutputStream localByteArrayOutputStream;
      Framer localFramer;
      if ((!bool) && ("GET".equals(paramLightHttpRequest.method)))
      {
        i = 1;
        if ((i == 0) && (!bool)) {
          break label211;
        }
        paramLightHttpRequest = paramLightHttpRequest.uri.getQueryParameters("argv");
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localFramer = new Framer(new ByteArrayInputStream(new byte[0]), localByteArrayOutputStream);
        if (!bool) {
          break label196;
        }
        paramSocketLike = "ERROR";
        label89:
        localFramer.getStderr().println("*** " + paramSocketLike + ": Using legacy HTTP protocol; update dumpapp script! ***");
        if (i == 0) {
          break label202;
        }
        DumpappSocketLikeHandler.dump(this.mDumper, localFramer, (String[])paramLightHttpRequest.toArray(new String[paramLightHttpRequest.size()]));
      }
      for (;;)
      {
        paramLightHttpResponse.code = 200;
        paramLightHttpResponse.reasonPhrase = "OK";
        paramLightHttpResponse.addHeader("Access-Control-Allow-Origin", "*");
        paramLightHttpResponse.body = LightHttpBody.create(localByteArrayOutputStream.toByteArray(), "application/octet-stream");
        return true;
        i = 0;
        break;
        label196:
        paramSocketLike = "WARNING";
        break label89;
        label202:
        localFramer.writeExitCode(1);
      }
      label211:
      paramLightHttpResponse.code = 501;
      paramLightHttpResponse.reasonPhrase = "Not implemented";
      paramLightHttpResponse.body = LightHttpBody.create(paramLightHttpRequest.method + " not implemented", "text/plain");
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.DumpappHttpSocketLikeHandler
 * JD-Core Version:    0.7.0.1
 */