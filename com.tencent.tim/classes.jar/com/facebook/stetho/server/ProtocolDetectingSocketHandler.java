package com.facebook.stetho.server;

import android.content.Context;
import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class ProtocolDetectingSocketHandler
  extends SecureSocketHandler
{
  private static final int SENSING_BUFFER_SIZE = 256;
  private final ArrayList<HandlerInfo> mHandlers = new ArrayList(2);
  
  public ProtocolDetectingSocketHandler(Context paramContext)
  {
    super(paramContext);
  }
  
  public void addHandler(MagicMatcher paramMagicMatcher, SocketLikeHandler paramSocketLikeHandler)
  {
    this.mHandlers.add(new HandlerInfo(paramMagicMatcher, paramSocketLikeHandler, null));
  }
  
  protected void onSecured(LocalSocket paramLocalSocket)
    throws IOException
  {
    LeakyBufferedInputStream localLeakyBufferedInputStream = new LeakyBufferedInputStream(paramLocalSocket.getInputStream(), 256);
    if (this.mHandlers.isEmpty()) {
      throw new IllegalStateException("No handlers added");
    }
    int j = this.mHandlers.size();
    int i = 0;
    while (i < j)
    {
      HandlerInfo localHandlerInfo = (HandlerInfo)this.mHandlers.get(i);
      localLeakyBufferedInputStream.mark(256);
      boolean bool = localHandlerInfo.magicMatcher.matches(localLeakyBufferedInputStream);
      localLeakyBufferedInputStream.reset();
      if (bool)
      {
        paramLocalSocket = new SocketLike(paramLocalSocket, localLeakyBufferedInputStream);
        localHandlerInfo.handler.onAccepted(paramLocalSocket);
        return;
      }
      i += 1;
    }
    throw new IOException("No matching handler, firstByte=" + localLeakyBufferedInputStream.read());
  }
  
  public static class AlwaysMatchMatcher
    implements ProtocolDetectingSocketHandler.MagicMatcher
  {
    public boolean matches(InputStream paramInputStream)
      throws IOException
    {
      return true;
    }
  }
  
  public static class ExactMagicMatcher
    implements ProtocolDetectingSocketHandler.MagicMatcher
  {
    private final byte[] mMagic;
    
    public ExactMagicMatcher(byte[] paramArrayOfByte)
    {
      this.mMagic = paramArrayOfByte;
    }
    
    public boolean matches(InputStream paramInputStream)
      throws IOException
    {
      byte[] arrayOfByte = new byte[this.mMagic.length];
      return (paramInputStream.read(arrayOfByte) == arrayOfByte.length) && (Arrays.equals(arrayOfByte, this.mMagic));
    }
  }
  
  static class HandlerInfo
  {
    public final SocketLikeHandler handler;
    public final ProtocolDetectingSocketHandler.MagicMatcher magicMatcher;
    
    private HandlerInfo(ProtocolDetectingSocketHandler.MagicMatcher paramMagicMatcher, SocketLikeHandler paramSocketLikeHandler)
    {
      this.magicMatcher = paramMagicMatcher;
      this.handler = paramSocketLikeHandler;
    }
  }
  
  public static abstract interface MagicMatcher
  {
    public abstract boolean matches(InputStream paramInputStream)
      throws IOException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.ProtocolDetectingSocketHandler
 * JD-Core Version:    0.7.0.1
 */