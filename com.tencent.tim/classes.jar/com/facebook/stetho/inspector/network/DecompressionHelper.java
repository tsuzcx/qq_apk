package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.InflaterOutputStream;
import javax.annotation.Nullable;

public class DecompressionHelper
{
  static final String DEFLATE_ENCODING = "deflate";
  static final String GZIP_ENCODING = "gzip";
  
  public static InputStream teeInputWithDecompression(NetworkPeerManager paramNetworkPeerManager, String paramString1, InputStream paramInputStream, OutputStream paramOutputStream, @Nullable String paramString2, ResponseHandler paramResponseHandler)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool2;
    if (paramString2 != null)
    {
      boolean bool1 = "gzip".equals(paramString2);
      bool2 = "deflate".equals(paramString2);
      if ((bool1) || (bool2))
      {
        paramString2 = new CountingOutputStream(paramOutputStream);
        if (bool1) {
          paramOutputStream = GunzippingOutputStream.create(paramString2);
        }
      }
    }
    for (;;)
    {
      return new ResponseHandlingInputStream(paramInputStream, paramString1, paramOutputStream, paramString2, paramNetworkPeerManager, paramResponseHandler);
      localObject1 = paramString2;
      if (bool2)
      {
        paramOutputStream = new InflaterOutputStream(paramString2);
        continue;
        CLog.writeToConsole(paramNetworkPeerManager, Console.MessageLevel.WARNING, Console.MessageSource.NETWORK, "Unsupported Content-Encoding in response for request #" + paramString1 + ": " + paramString2);
        localObject1 = localObject2;
      }
      else
      {
        paramString2 = (String)localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.DecompressionHelper
 * JD-Core Version:    0.7.0.1
 */