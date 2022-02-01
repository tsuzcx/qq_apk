package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket;
import com.tencent.qqmail.utilities.qmnetwork.service.SendPacket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class QMSocketUtils
{
  public static ReceivePacket receive(InputStream paramInputStream)
    throws IOException
  {
    ReceivePacket localReceivePacket = new ReceivePacket();
    if (localReceivePacket.read(paramInputStream) > 0) {
      return localReceivePacket;
    }
    return null;
  }
  
  public static void recvTest(SocketChannel paramSocketChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(32);
    while (paramSocketChannel.read(localByteBuffer) > 0)
    {
      localByteBuffer.flip();
      localByteBuffer.clear();
    }
  }
  
  public static void send(SendPacket paramSendPacket, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramSendPacket == null) {
      return;
    }
    paramSendPacket.write(paramOutputStream);
  }
  
  public static void sendTest(SocketChannel paramSocketChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate("GET / HTTP/1.1\r\nHost: w.mail.qq.com\r\n\r\n".length());
    localByteBuffer.put("GET / HTTP/1.1\r\nHost: w.mail.qq.com\r\n\r\n".getBytes());
    localByteBuffer.flip();
    paramSocketChannel.write(localByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMSocketUtils
 * JD-Core Version:    0.7.0.1
 */