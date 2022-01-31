package com.tencent.component.network.module.common.a;

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

final class i
{
  private static SecureRandom b = new SecureRandom();
  private long a = 5000L;
  
  public final void a(long paramLong)
  {
    if (paramLong > 0L) {
      this.a = paramLong;
    }
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfByte)
    throws IOException, SocketTimeoutException
  {
    localDatagramChannel = null;
    for (;;)
    {
      try
      {
        localObject = DatagramChannel.open();
        ((SelectableChannel)localObject).configureBlocking(false);
        localObject = ((SelectableChannel)localObject).register(Selector.open(), 1);
      }
      finally
      {
        Object localObject;
        InetSocketAddress localInetSocketAddress;
        long l1;
        long l2;
        long l3;
        paramArrayOfByte = localDatagramChannel;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        localDatagramChannel = (DatagramChannel)((SelectionKey)localObject).channel();
        localInetSocketAddress = new InetSocketAddress(b.nextInt(64511) + 1024);
        localDatagramChannel.socket().bind(localInetSocketAddress);
        localDatagramChannel.connect(new InetSocketAddress(InetAddress.getByName(paramString), 53));
        localDatagramChannel.write(ByteBuffer.wrap(paramArrayOfByte));
        paramString = new byte[512];
        l1 = System.currentTimeMillis();
        l2 = this.a;
        try
        {
          boolean bool = ((SelectionKey)localObject).isReadable();
          if (bool)
          {
            if (((SelectionKey)localObject).isValid()) {
              ((SelectionKey)localObject).interestOps(0);
            }
            l1 = localDatagramChannel.read(ByteBuffer.wrap(paramString));
            if (l1 <= 0L) {
              continue;
            }
            i = (int)l1;
            paramArrayOfByte = new byte[i];
            System.arraycopy(paramString, 0, paramArrayOfByte, 0, i);
            if (localObject != null)
            {
              ((SelectionKey)localObject).selector().close();
              ((SelectionKey)localObject).channel().close();
            }
            return paramArrayOfByte;
          }
          l3 = l1 + l2 - System.currentTimeMillis();
          if (l3 > 0L)
          {
            i = ((SelectionKey)localObject).selector().select(l3);
            if (i != 0) {
              continue;
            }
            throw new SocketTimeoutException();
          }
        }
        finally
        {
          if (((SelectionKey)localObject).isValid()) {
            ((SelectionKey)localObject).interestOps(0);
          }
        }
        if (l3 != 0L) {
          continue;
        }
      }
      finally
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.selector().close();
          paramArrayOfByte.channel().close();
        }
      }
      i = ((SelectionKey)localObject).selector().selectNow();
    }
    if (localObject != null)
    {
      ((SelectionKey)localObject).selector().close();
      ((SelectionKey)localObject).channel().close();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.i
 * JD-Core Version:    0.7.0.1
 */