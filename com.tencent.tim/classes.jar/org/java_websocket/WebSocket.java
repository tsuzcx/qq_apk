package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;
import org.java_websocket.drafts.Draft;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.framing.Framedata;

public abstract interface WebSocket
{
  public abstract void close();
  
  public abstract void close(int paramInt);
  
  public abstract void close(int paramInt, String paramString);
  
  public abstract void closeConnection(int paramInt, String paramString);
  
  public abstract <T> T getAttachment();
  
  public abstract Draft getDraft();
  
  public abstract InetSocketAddress getLocalSocketAddress();
  
  public abstract ReadyState getReadyState();
  
  public abstract InetSocketAddress getRemoteSocketAddress();
  
  public abstract String getResourceDescriptor();
  
  public abstract boolean hasBufferedData();
  
  public abstract boolean isClosed();
  
  public abstract boolean isClosing();
  
  public abstract boolean isFlushAndClose();
  
  public abstract boolean isOpen();
  
  public abstract void send(String paramString);
  
  public abstract void send(ByteBuffer paramByteBuffer);
  
  public abstract void send(byte[] paramArrayOfByte);
  
  public abstract void sendFragmentedFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract void sendFrame(Collection<Framedata> paramCollection);
  
  public abstract void sendFrame(Framedata paramFramedata);
  
  public abstract void sendPing();
  
  public abstract <T> void setAttachment(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.WebSocket
 * JD-Core Version:    0.7.0.1
 */