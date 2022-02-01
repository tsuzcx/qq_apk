package com.tencent.thumbplayer.api.connection;

public abstract interface ITPPlayerConnection
{
  public abstract int activeAllConnections()
    throws IllegalStateException;
  
  public abstract int activeConnection(int paramInt)
    throws IllegalStateException;
  
  public abstract int addConnection(long paramLong1, TPPlayerConnectionNode paramTPPlayerConnectionNode1, long paramLong2, TPPlayerConnectionNode paramTPPlayerConnectionNode2)
    throws IllegalStateException;
  
  public abstract void deactiveAllConnections()
    throws IllegalStateException;
  
  public abstract void deactiveConnection(int paramInt)
    throws IllegalStateException;
  
  public abstract void init();
  
  public abstract void removeConnection(int paramInt)
    throws IllegalStateException;
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.ITPPlayerConnection
 * JD-Core Version:    0.7.0.1
 */