package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.java_websocket.util.ByteBufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel
  implements ByteChannel, WrappedByteChannel
{
  private static final Logger log = LoggerFactory.getLogger(SSLSocketChannel.class);
  private final SSLEngine engine;
  private ExecutorService executor;
  private ByteBuffer myAppData;
  private ByteBuffer myNetData;
  private ByteBuffer peerAppData;
  private ByteBuffer peerNetData;
  private final SocketChannel socketChannel;
  
  public SSLSocketChannel(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey)
    throws IOException
  {
    if ((paramSocketChannel == null) || (paramSSLEngine == null) || (this.executor == paramExecutorService)) {
      throw new IllegalArgumentException("parameter must not be null");
    }
    this.socketChannel = paramSocketChannel;
    this.engine = paramSSLEngine;
    this.executor = paramExecutorService;
    this.myNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
    this.peerNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
    this.engine.beginHandshake();
    if (doHandshake())
    {
      if (paramSelectionKey != null) {
        paramSelectionKey.interestOps(paramSelectionKey.interestOps() | 0x4);
      }
      return;
    }
    try
    {
      this.socketChannel.close();
      return;
    }
    catch (IOException paramSocketChannel)
    {
      log.error("Exception during the closing of the channel", paramSocketChannel);
    }
  }
  
  private void closeConnection()
    throws IOException
  {
    this.engine.closeOutbound();
    try
    {
      doHandshake();
      label12:
      this.socketChannel.close();
      return;
    }
    catch (IOException localIOException)
    {
      break label12;
    }
  }
  
  private boolean doHandshake()
    throws IOException
  {
    int i = this.engine.getSession().getApplicationBufferSize();
    this.myAppData = ByteBuffer.allocate(i);
    this.peerAppData = ByteBuffer.allocate(i);
    this.myNetData.clear();
    this.peerNetData.clear();
    Object localObject1 = this.engine.getHandshakeStatus();
    i = 0;
    for (;;)
    {
      if (i == 0) {}
      switch (SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[localObject1.ordinal()])
      {
      case 5: 
      default: 
        throw new IllegalStateException("Invalid SSL status: " + localObject1);
      case 1: 
        if (!this.peerNetData.hasRemaining()) {}
        for (i = 1; i != 0; i = 0) {
          return true;
        }
        this.socketChannel.write(this.peerNetData);
        break;
      case 2: 
        if (this.socketChannel.read(this.peerNetData) < 0) {
          if ((this.engine.isInboundDone()) && (this.engine.isOutboundDone())) {
            return false;
          }
        }
      case 3: 
      case 4: 
        try
        {
          this.engine.closeInbound();
          label208:
          this.engine.closeOutbound();
          localObject1 = this.engine.getHandshakeStatus();
          continue;
          this.peerNetData.flip();
          SSLEngineResult.HandshakeStatus localHandshakeStatus;
          try
          {
            SSLEngineResult localSSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
            this.peerNetData.compact();
            localHandshakeStatus = localSSLEngineResult.getHandshakeStatus();
            localObject1 = localHandshakeStatus;
            switch (SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localSSLEngineResult.getStatus().ordinal()])
            {
            case 1: 
            default: 
              throw new IllegalStateException("Invalid SSL status: " + localSSLEngineResult.getStatus());
            }
          }
          catch (SSLException localSSLException1)
          {
            this.engine.closeOutbound();
            localObject2 = this.engine.getHandshakeStatus();
          }
          continue;
          this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
          Object localObject2 = localHandshakeStatus;
          continue;
          this.peerNetData = handleBufferUnderflow(this.peerNetData);
          localObject2 = localHandshakeStatus;
          continue;
          if (this.engine.isOutboundDone()) {
            return false;
          }
          this.engine.closeOutbound();
          localObject2 = this.engine.getHandshakeStatus();
          continue;
          this.myNetData.clear();
          try
          {
            localObject2 = this.engine.wrap(this.myAppData, this.myNetData);
            localHandshakeStatus = ((SSLEngineResult)localObject2).getHandshakeStatus();
            switch (SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localObject2.getStatus().ordinal()])
            {
            default: 
              throw new IllegalStateException("Invalid SSL status: " + ((SSLEngineResult)localObject2).getStatus());
            }
          }
          catch (SSLException localSSLException2)
          {
            this.engine.closeOutbound();
            localObject3 = this.engine.getHandshakeStatus();
          }
          continue;
          this.myNetData.flip();
          for (;;)
          {
            localObject3 = localHandshakeStatus;
            if (!this.myNetData.hasRemaining()) {
              break;
            }
            this.socketChannel.write(this.myNetData);
          }
          this.myNetData = enlargePacketBuffer(this.myNetData);
          Object localObject3 = localHandshakeStatus;
          continue;
          throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
          try
          {
            this.myNetData.flip();
            while (this.myNetData.hasRemaining()) {
              this.socketChannel.write(this.myNetData);
            }
          }
          catch (Exception localException)
          {
            localObject4 = this.engine.getHandshakeStatus();
          }
          this.peerNetData.clear();
          Object localObject4 = localHandshakeStatus;
          continue;
          for (;;)
          {
            localObject4 = this.engine.getDelegatedTask();
            if (localObject4 == null) {
              break;
            }
            this.executor.execute((Runnable)localObject4);
          }
          localObject4 = this.engine.getHandshakeStatus();
        }
        catch (SSLException localSSLException3)
        {
          break label208;
        }
      }
    }
  }
  
  private ByteBuffer enlargeApplicationBuffer(ByteBuffer paramByteBuffer)
  {
    return enlargeBuffer(paramByteBuffer, this.engine.getSession().getApplicationBufferSize());
  }
  
  private ByteBuffer enlargeBuffer(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt > paramByteBuffer.capacity()) {
      return ByteBuffer.allocate(paramInt);
    }
    return ByteBuffer.allocate(paramByteBuffer.capacity() * 2);
  }
  
  private ByteBuffer enlargePacketBuffer(ByteBuffer paramByteBuffer)
  {
    return enlargeBuffer(paramByteBuffer, this.engine.getSession().getPacketBufferSize());
  }
  
  private ByteBuffer handleBufferUnderflow(ByteBuffer paramByteBuffer)
  {
    if (this.engine.getSession().getPacketBufferSize() < paramByteBuffer.limit()) {
      return paramByteBuffer;
    }
    ByteBuffer localByteBuffer = enlargePacketBuffer(paramByteBuffer);
    paramByteBuffer.flip();
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
  
  private void handleEndOfStream()
    throws IOException
  {
    try
    {
      this.engine.closeInbound();
      closeConnection();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        log.error("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
      }
    }
  }
  
  public void close()
    throws IOException
  {
    closeConnection();
  }
  
  public boolean isBlocking()
  {
    return this.socketChannel.isBlocking();
  }
  
  public boolean isNeedRead()
  {
    return (this.peerNetData.hasRemaining()) || (this.peerAppData.hasRemaining());
  }
  
  public boolean isNeedWrite()
  {
    return false;
  }
  
  public boolean isOpen()
  {
    return this.socketChannel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    for (;;)
    {
      try
      {
        boolean bool = paramByteBuffer.hasRemaining();
        if (!bool)
        {
          i = 0;
          return i;
        }
        if (this.peerAppData.hasRemaining())
        {
          this.peerAppData.flip();
          i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
          continue;
        }
        this.peerNetData.compact();
        i = this.socketChannel.read(this.peerNetData);
        if ((i <= 0) && (!this.peerNetData.hasRemaining())) {
          break label294;
        }
        this.peerNetData.flip();
        if (!this.peerNetData.hasRemaining()) {
          break label302;
        }
        this.peerAppData.compact();
        SSLEngineResult localSSLEngineResult;
        this.peerAppData.flip();
      }
      finally
      {
        try
        {
          localSSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
          switch (SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localSSLEngineResult.getStatus().ordinal()])
          {
          case 1: 
            throw new IllegalStateException("Invalid SSL status: " + localSSLEngineResult.getStatus());
          }
        }
        catch (SSLException paramByteBuffer)
        {
          log.error("SSLExcpetion during unwrap", paramByteBuffer);
          throw paramByteBuffer;
        }
        paramByteBuffer = finally;
      }
      int i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
      continue;
      this.peerAppData.flip();
      i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
      continue;
      this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
      i = read(paramByteBuffer);
      continue;
      closeConnection();
      paramByteBuffer.clear();
      i = -1;
      continue;
      label294:
      if (i < 0) {
        handleEndOfStream();
      }
      label302:
      ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
    }
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return read(paramByteBuffer);
  }
  
  /* Error */
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: istore_3
    //   6: aload_1
    //   7: invokevirtual 158	java/nio/ByteBuffer:hasRemaining	()Z
    //   10: ifeq +172 -> 182
    //   13: aload_0
    //   14: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   17: invokevirtual 121	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   20: pop
    //   21: aload_0
    //   22: getfield 51	org/java_websocket/SSLSocketChannel:engine	Ljavax/net/ssl/SSLEngine;
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   30: invokevirtual 208	javax/net/ssl/SSLEngine:wrap	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   33: astore 4
    //   35: getstatic 191	org/java_websocket/SSLSocketChannel$1:$SwitchMap$javax$net$ssl$SSLEngineResult$Status	[I
    //   38: aload 4
    //   40: invokevirtual 195	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   43: invokevirtual 198	javax/net/ssl/SSLEngineResult$Status:ordinal	()I
    //   46: iaload
    //   47: tableswitch	default:+139 -> 186, 1:+65->112, 2:+119->166, 3:+104->151, 4:+129->176
    //   77: nop
    //   78: l2d
    //   79: dup
    //   80: new 140	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   87: ldc 143
    //   89: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload 4
    //   94: invokevirtual 195	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   97: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 155	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    //   112: aload_0
    //   113: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   116: invokevirtual 177	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   119: pop
    //   120: iload_2
    //   121: istore_3
    //   122: iload_3
    //   123: istore_2
    //   124: aload_0
    //   125: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   128: invokevirtual 158	java/nio/ByteBuffer:hasRemaining	()Z
    //   131: ifeq -127 -> 4
    //   134: iload_3
    //   135: aload_0
    //   136: getfield 49	org/java_websocket/SSLSocketChannel:socketChannel	Ljava/nio/channels/SocketChannel;
    //   139: aload_0
    //   140: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   143: invokevirtual 162	java/nio/channels/SocketChannel:write	(Ljava/nio/ByteBuffer;)I
    //   146: iadd
    //   147: istore_3
    //   148: goto -26 -> 122
    //   151: aload_0
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   157: invokespecial 211	org/java_websocket/SSLSocketChannel:enlargePacketBuffer	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   160: putfield 71	org/java_websocket/SSLSocketChannel:myNetData	Ljava/nio/ByteBuffer;
    //   163: goto -159 -> 4
    //   166: new 108	javax/net/ssl/SSLException
    //   169: dup
    //   170: ldc 213
    //   172: invokespecial 214	javax/net/ssl/SSLException:<init>	(Ljava/lang/String;)V
    //   175: athrow
    //   176: aload_0
    //   177: invokespecial 240	org/java_websocket/SSLSocketChannel:closeConnection	()V
    //   180: iconst_0
    //   181: istore_3
    //   182: aload_0
    //   183: monitorexit
    //   184: iload_3
    //   185: ireturn
    //   186: goto -110 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	SSLSocketChannel
    //   0	189	1	paramByteBuffer	ByteBuffer
    //   3	121	2	i	int
    //   5	180	3	j	int
    //   33	60	4	localSSLEngineResult	SSLEngineResult
    // Exception table:
    //   from	to	target	type
    //   6	76	107	finally
    //   76	107	107	finally
    //   112	120	107	finally
    //   124	148	107	finally
    //   151	163	107	finally
    //   166	176	107	finally
    //   176	180	107	finally
  }
  
  public void writeMore()
    throws IOException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.SSLSocketChannel
 * JD-Core Version:    0.7.0.1
 */