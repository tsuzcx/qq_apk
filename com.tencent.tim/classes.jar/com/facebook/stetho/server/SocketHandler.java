package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;

public abstract interface SocketHandler
{
  public abstract void onAccepted(LocalSocket paramLocalSocket)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.SocketHandler
 * JD-Core Version:    0.7.0.1
 */