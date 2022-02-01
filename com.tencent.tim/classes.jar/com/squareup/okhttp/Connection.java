package com.squareup.okhttp;

import java.net.Socket;

public abstract interface Connection
{
  public abstract Handshake getHandshake();
  
  public abstract Protocol getProtocol();
  
  public abstract Route getRoute();
  
  public abstract Socket getSocket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Connection
 * JD-Core Version:    0.7.0.1
 */