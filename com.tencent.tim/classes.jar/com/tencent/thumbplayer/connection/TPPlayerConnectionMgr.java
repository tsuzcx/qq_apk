package com.tencent.thumbplayer.connection;

import com.tencent.thumbplayer.api.connection.ITPPlayerConnection;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionMgr;

public class TPPlayerConnectionMgr
  implements ITPPlayerConnection
{
  private TPNativePlayerConnectionMgr mNativeConnection = new TPNativePlayerConnectionMgr();
  
  public int activeAllConnections()
    throws IllegalStateException, UnsupportedOperationException
  {
    return this.mNativeConnection.activeAllConnections();
  }
  
  public int activeConnection(int paramInt)
    throws IllegalStateException, UnsupportedOperationException
  {
    return this.mNativeConnection.activeConnection(paramInt);
  }
  
  public int addConnection(long paramLong1, TPPlayerConnectionNode paramTPPlayerConnectionNode1, long paramLong2, TPPlayerConnectionNode paramTPPlayerConnectionNode2)
    throws IllegalStateException, UnsupportedOperationException
  {
    return this.mNativeConnection.addConnection(paramLong1, paramTPPlayerConnectionNode1.getNativeNode(), paramLong2, paramTPPlayerConnectionNode2.getNativeNode());
  }
  
  public void deactiveAllConnections()
    throws IllegalStateException, UnsupportedOperationException
  {
    this.mNativeConnection.deactiveAllConnections();
  }
  
  public void deactiveConnection(int paramInt)
    throws IllegalStateException, UnsupportedOperationException
  {
    this.mNativeConnection.deactiveConnection(paramInt);
  }
  
  public void init()
    throws IllegalStateException, UnsupportedOperationException
  {
    this.mNativeConnection.init();
  }
  
  public void removeConnection(int paramInt)
    throws IllegalStateException, UnsupportedOperationException
  {
    this.mNativeConnection.removeConnection(paramInt);
  }
  
  public void uninit()
    throws UnsupportedOperationException
  {
    this.mNativeConnection.unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.connection.TPPlayerConnectionMgr
 * JD-Core Version:    0.7.0.1
 */