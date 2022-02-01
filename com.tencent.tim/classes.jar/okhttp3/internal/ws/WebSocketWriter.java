package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter
{
  boolean activeWriter;
  final Buffer buffer = new Buffer();
  final FrameSink frameSink = new FrameSink();
  final boolean isClient;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  final Random random;
  final BufferedSink sink;
  final Buffer sinkBuffer;
  boolean writerClosed;
  
  WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.sinkBuffer = paramBufferedSink.buffer();
    this.random = paramRandom;
    if (paramBoolean) {}
    for (paramBufferedSink = new byte[4];; paramBufferedSink = null)
    {
      this.maskKey = paramBufferedSink;
      paramBufferedSink = localObject;
      if (paramBoolean) {
        paramBufferedSink = new Buffer.UnsafeCursor();
      }
      this.maskCursor = paramBufferedSink;
      return;
    }
  }
  
  private void writeControlFrame(int paramInt, ByteString paramByteString)
    throws IOException
  {
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i = paramByteString.size();
    if (i > 125L) {
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
    this.sinkBuffer.writeByte(paramInt | 0x80);
    if (this.isClient)
    {
      this.sinkBuffer.writeByte(i | 0x80);
      this.random.nextBytes(this.maskKey);
      this.sinkBuffer.write(this.maskKey);
      if (i > 0)
      {
        long l = this.sinkBuffer.size();
        this.sinkBuffer.write(paramByteString);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(l);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
      }
    }
    for (;;)
    {
      this.sink.flush();
      return;
      this.sinkBuffer.writeByte(i);
      this.sinkBuffer.write(paramByteString);
    }
  }
  
  Sink newMessageSink(int paramInt, long paramLong)
  {
    if (this.activeWriter) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.activeWriter = true;
    this.frameSink.formatOpcode = paramInt;
    this.frameSink.contentLength = paramLong;
    this.frameSink.isFirstFrame = true;
    this.frameSink.closed = false;
    return this.frameSink;
  }
  
  void writeClose(int paramInt, ByteString paramByteString)
    throws IOException
  {
    Object localObject = ByteString.EMPTY;
    if ((paramInt != 0) || (paramByteString != null))
    {
      if (paramInt != 0) {
        WebSocketProtocol.validateCloseCode(paramInt);
      }
      localObject = new Buffer();
      ((Buffer)localObject).writeShort(paramInt);
      if (paramByteString != null) {
        ((Buffer)localObject).write(paramByteString);
      }
      localObject = ((Buffer)localObject).readByteString();
    }
    try
    {
      writeControlFrame(8, (ByteString)localObject);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }
  
  void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i;
    if (paramBoolean1)
    {
      i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(i);
      if (!this.isClient) {
        break label267;
      }
    }
    label267:
    for (paramInt = 128;; paramInt = 0)
    {
      if (paramLong <= 125L)
      {
        i = (int)paramLong;
        this.sinkBuffer.writeByte(paramInt | i);
        label82:
        if (!this.isClient) {
          break label252;
        }
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.size();
          this.sinkBuffer.write(this.buffer, paramLong);
          this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(l);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      for (;;)
      {
        this.sink.emit();
        return;
        paramInt = 0;
        break;
        if (paramLong <= 65535L)
        {
          this.sinkBuffer.writeByte(paramInt | 0x7E);
          this.sinkBuffer.writeShort((int)paramLong);
          break label82;
        }
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
        break label82;
        label252:
        this.sinkBuffer.write(this.buffer, paramLong);
      }
    }
  }
  
  void writePing(ByteString paramByteString)
    throws IOException
  {
    writeControlFrame(9, paramByteString);
  }
  
  void writePong(ByteString paramByteString)
    throws IOException
  {
    writeControlFrame(10, paramByteString);
  }
  
  final class FrameSink
    implements Sink
  {
    boolean closed;
    long contentLength;
    int formatOpcode;
    boolean isFirstFrame;
    
    FrameSink() {}
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, true);
      this.closed = true;
      WebSocketWriter.this.activeWriter = false;
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, false);
      this.isFirstFrame = false;
    }
    
    public Timeout timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.buffer.write(paramBuffer, paramLong);
      if ((this.isFirstFrame) && (this.contentLength != -1L) && (WebSocketWriter.this.buffer.size() > this.contentLength - 8192L)) {}
      for (int i = 1;; i = 0)
      {
        paramLong = WebSocketWriter.this.buffer.completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0))
        {
          WebSocketWriter.this.writeMessageFrame(this.formatOpcode, paramLong, this.isFirstFrame, false);
          this.isFirstFrame = false;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter
 * JD-Core Version:    0.7.0.1
 */