package com.qzone.common.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;

final class UdpClient
{
  private static final int EPHEMERAL_RANGE = 64511;
  private static final int EPHEMERAL_START = 1024;
  private static final int EPHEMERAL_STOP = 65535;
  private static final int MAX_SIZE = 512;
  private static SecureRandom prng = new SecureRandom();
  private long timeout_value = 5000L;
  
  private static void blockUntil(SelectionKey paramSelectionKey, long paramLong)
    throws IOException, SocketTimeoutException
  {
    paramLong -= System.currentTimeMillis();
    int i = 0;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    }
    while (i == 0)
    {
      throw new SocketTimeoutException();
      if (paramLong == 0L) {
        i = paramSelectionKey.selector().selectNow();
      }
    }
  }
  
  public byte[] sendrecv(String paramString, byte[] paramArrayOfByte)
    throws IOException, SocketTimeoutException
  {
    SelectionKey localSelectionKey2 = null;
    SelectionKey localSelectionKey1 = localSelectionKey2;
    try
    {
      DatagramChannel localDatagramChannel = DatagramChannel.open();
      localSelectionKey1 = localSelectionKey2;
      localDatagramChannel.configureBlocking(false);
      localSelectionKey1 = localSelectionKey2;
      localSelectionKey2 = localDatagramChannel.register(Selector.open(), 1);
      localSelectionKey1 = localSelectionKey2;
      localDatagramChannel = (DatagramChannel)localSelectionKey2.channel();
      localSelectionKey1 = localSelectionKey2;
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(prng.nextInt(64511) + 1024);
      localSelectionKey1 = localSelectionKey2;
      localDatagramChannel.socket().bind(localInetSocketAddress);
      localSelectionKey1 = localSelectionKey2;
      localDatagramChannel.connect(new InetSocketAddress(InetAddress.getByName(paramString), 53));
      localSelectionKey1 = localSelectionKey2;
      localDatagramChannel.write(ByteBuffer.wrap(paramArrayOfByte));
      localSelectionKey1 = localSelectionKey2;
      paramString = new byte[512];
      localSelectionKey1 = localSelectionKey2;
      long l1 = System.currentTimeMillis();
      localSelectionKey1 = localSelectionKey2;
      long l2 = this.timeout_value;
      try
      {
        for (;;)
        {
          boolean bool = localSelectionKey2.isReadable();
          if (bool)
          {
            localSelectionKey1 = localSelectionKey2;
            if (localSelectionKey2.isValid())
            {
              localSelectionKey1 = localSelectionKey2;
              localSelectionKey2.interestOps(0);
            }
            localSelectionKey1 = localSelectionKey2;
            l1 = localDatagramChannel.read(ByteBuffer.wrap(paramString));
            if (l1 <= 0L) {
              break;
            }
            int i = (int)l1;
            localSelectionKey1 = localSelectionKey2;
            paramArrayOfByte = new byte[i];
            localSelectionKey1 = localSelectionKey2;
            System.arraycopy(paramString, 0, paramArrayOfByte, 0, i);
            return paramArrayOfByte;
          }
          blockUntil(localSelectionKey2, l1 + l2);
        }
        paramString = finally;
      }
      finally
      {
        localSelectionKey1 = localSelectionKey2;
        if (localSelectionKey2.isValid())
        {
          localSelectionKey1 = localSelectionKey2;
          localSelectionKey2.interestOps(0);
        }
        localSelectionKey1 = localSelectionKey2;
      }
      if (localSelectionKey2 == null) {
        break label350;
      }
    }
    finally
    {
      if (localSelectionKey1 != null)
      {
        localSelectionKey1.selector().close();
        localSelectionKey1.channel().close();
      }
    }
    localSelectionKey2.selector().close();
    localSelectionKey2.channel().close();
    label350:
    return null;
  }
  
  public void setTimeout(long paramLong)
  {
    if (paramLong > 0L) {
      this.timeout_value = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.dns.UdpClient
 * JD-Core Version:    0.7.0.1
 */