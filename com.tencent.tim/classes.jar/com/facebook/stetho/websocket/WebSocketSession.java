package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class WebSocketSession
  implements SimpleSession
{
  private final SimpleEndpoint mEndpoint;
  private final WriteCallback mErrorForwardingWriteCallback = new WebSocketSession.2(this);
  private AtomicBoolean mIsOpen = new AtomicBoolean(false);
  private final ReadCallback mReadCallback = new WebSocketSession.1(this);
  private final ReadHandler mReadHandler;
  private volatile boolean mSentClose;
  private final WriteHandler mWriteHandler;
  
  public WebSocketSession(InputStream paramInputStream, OutputStream paramOutputStream, SimpleEndpoint paramSimpleEndpoint)
  {
    this.mReadHandler = new ReadHandler(paramInputStream, paramSimpleEndpoint);
    this.mWriteHandler = new WriteHandler(paramOutputStream);
    this.mEndpoint = paramSimpleEndpoint;
  }
  
  private void doWrite(Frame paramFrame)
  {
    if (signalErrorIfNotOpen()) {
      return;
    }
    this.mWriteHandler.write(paramFrame, this.mErrorForwardingWriteCallback);
  }
  
  private void sendClose(int paramInt, String paramString)
  {
    doWrite(FrameHelper.createCloseFrame(paramInt, paramString));
    markSentClose();
  }
  
  private void signalError(IOException paramIOException)
  {
    this.mEndpoint.onError(this, paramIOException);
  }
  
  private boolean signalErrorIfNotOpen()
  {
    if (!isOpen())
    {
      signalError(new IOException("Session is closed"));
      return true;
    }
    return false;
  }
  
  public void close(int paramInt, String paramString)
  {
    sendClose(paramInt, paramString);
    markAndSignalClosed(paramInt, paramString);
  }
  
  public void handle()
    throws IOException
  {
    markAndSignalOpen();
    try
    {
      this.mReadHandler.readLoop(this.mReadCallback);
      return;
    }
    catch (EOFException localEOFException)
    {
      markAndSignalClosed(1011, "EOF while reading");
      return;
    }
    catch (IOException localIOException)
    {
      markAndSignalClosed(1006, null);
      throw localIOException;
    }
  }
  
  public boolean isOpen()
  {
    return this.mIsOpen.get();
  }
  
  void markAndSignalClosed(int paramInt, String paramString)
  {
    if (this.mIsOpen.getAndSet(false)) {
      this.mEndpoint.onClose(this, paramInt, paramString);
    }
  }
  
  void markAndSignalOpen()
  {
    if (!this.mIsOpen.getAndSet(true)) {
      this.mEndpoint.onOpen(this);
    }
  }
  
  void markSentClose()
  {
    this.mSentClose = true;
  }
  
  public void sendBinary(byte[] paramArrayOfByte)
  {
    doWrite(FrameHelper.createBinaryFrame(paramArrayOfByte));
  }
  
  public void sendText(String paramString)
  {
    doWrite(FrameHelper.createTextFrame(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WebSocketSession
 * JD-Core Version:    0.7.0.1
 */