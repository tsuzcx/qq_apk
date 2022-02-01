package com.facebook.stetho.server;

import java.io.IOException;

public abstract interface SocketLikeHandler
{
  public abstract void onAccepted(SocketLike paramSocketLike)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.SocketLikeHandler
 * JD-Core Version:    0.7.0.1
 */