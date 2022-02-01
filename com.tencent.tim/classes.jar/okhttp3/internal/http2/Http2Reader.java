package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader
  implements Closeable
{
  static final Logger logger = Logger.getLogger(Http2.class.getName());
  private final boolean client;
  private final ContinuationSource continuation;
  final Hpack.Reader hpackReader;
  private final BufferedSource source;
  
  Http2Reader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    this.source = paramBufferedSource;
    this.client = paramBoolean;
    this.continuation = new ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(4096, this.continuation);
  }
  
  static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort)
    throws IOException
  {
    short s = paramInt;
    if ((paramByte & 0x8) != 0) {
      s = paramInt - 1;
    }
    if (paramShort > s) {
      throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(s) });
    }
    return (short)(s - paramShort);
  }
  
  private void readData(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    int i = 1;
    short s = 0;
    if (paramInt2 == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x20) == 0) {
        break label58;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label64;
      }
      throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool = false;
      break;
      label58:
      i = 0;
    }
    label64:
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.source.readByte() & 0xFF);
    }
    paramInt1 = lengthWithoutPadding(paramInt1, paramByte, s);
    paramHandler.data(bool, paramInt2, this.source, paramInt1);
    this.source.skip(s);
  }
  
  private void readGoAway(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 < 8) {
      throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    paramByte = this.source.readInt();
    paramInt2 = this.source.readInt();
    paramInt1 -= 8;
    ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt2);
    if (localErrorCode == null) {
      throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    ByteString localByteString = ByteString.EMPTY;
    if (paramInt1 > 0) {
      localByteString = this.source.readByteString(paramInt1);
    }
    paramHandler.goAway(paramByte, localErrorCode, localByteString);
  }
  
  private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
    throws IOException
  {
    ContinuationSource localContinuationSource = this.continuation;
    this.continuation.left = paramInt1;
    localContinuationSource.length = paramInt1;
    this.continuation.padding = paramShort;
    this.continuation.flags = paramByte;
    this.continuation.streamId = paramInt2;
    this.hpackReader.readHeaders();
    return this.hpackReader.getAndResetHeaderList();
  }
  
  private void readHeaders(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramByte & 0x8) != 0) {
        s = (short)(this.source.readByte() & 0xFF);
      }
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        readPriority(paramHandler, paramInt2);
        i = paramInt1 - 5;
      }
      paramHandler.headers(bool, paramInt2, -1, readHeaderBlock(lengthWithoutPadding(i, paramByte, s), s, paramByte, paramInt2));
      return;
    }
  }
  
  static int readMedium(BufferedSource paramBufferedSource)
    throws IOException
  {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private void readPing(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    boolean bool = true;
    if (paramInt1 != 8) {
      throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
    }
    paramInt1 = this.source.readInt();
    paramInt2 = this.source.readInt();
    if ((paramByte & 0x1) != 0) {}
    for (;;)
    {
      paramHandler.ping(bool, paramInt1, paramInt2);
      return;
      bool = false;
    }
  }
  
  private void readPriority(Handler paramHandler, int paramInt)
    throws IOException
  {
    int i = this.source.readInt();
    if ((0x80000000 & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHandler.priority(paramInt, i & 0x7FFFFFFF, (this.source.readByte() & 0xFF) + 1, bool);
      return;
    }
  }
  
  private void readPriority(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 5) {
      throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    readPriority(paramHandler, paramInt2);
  }
  
  private void readPushPromise(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.source.readByte() & 0xFF);
    }
    paramHandler.pushPromise(paramInt2, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock(lengthWithoutPadding(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }
  
  private void readRstStream(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4) {
      throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    paramInt1 = this.source.readInt();
    ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt1);
    if (localErrorCode == null) {
      throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramHandler.rstStream(paramInt2, localErrorCode);
  }
  
  private void readSettings(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt2 != 0) {
      throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0) {
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      paramHandler.ackSettings();
      return;
    }
    if (paramInt1 % 6 != 0) {
      throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    Settings localSettings = new Settings();
    paramInt2 = 0;
    if (paramInt2 < paramInt1)
    {
      byte b = this.source.readShort() & 0xFFFF;
      int i = this.source.readInt();
      paramByte = b;
      switch (b)
      {
      default: 
        paramByte = b;
      }
      do
      {
        do
        {
          for (;;)
          {
            localSettings.set(paramByte, i);
            paramInt2 += 6;
            break;
            paramByte = b;
            if (i != 0)
            {
              paramByte = b;
              if (i != 1)
              {
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                paramByte = 4;
              }
            }
          }
          paramByte = 7;
        } while (i >= 0);
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        if (i < 16384) {
          break label242;
        }
        paramByte = b;
      } while (i <= 16777215);
      label242:
      throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
    }
    paramHandler.settings(false, localSettings);
  }
  
  private void readWindowUpdate(Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 4) {
      throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    long l = this.source.readInt() & 0x7FFFFFFF;
    if (l == 0L) {
      throw Http2.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    paramHandler.windowUpdate(paramInt2, l);
  }
  
  public void close()
    throws IOException
  {
    this.source.close();
  }
  
  public boolean nextFrame(boolean paramBoolean, Handler paramHandler)
    throws IOException
  {
    int i;
    try
    {
      this.source.require(9L);
      i = readMedium(this.source);
      if ((i < 0) || (i > 16384)) {
        throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    catch (IOException paramHandler)
    {
      return false;
    }
    byte b1 = (byte)(this.source.readByte() & 0xFF);
    if ((paramBoolean) && (b1 != 4)) {
      throw Http2.ioException("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
    }
    byte b2 = (byte)(this.source.readByte() & 0xFF);
    int j = this.source.readInt() & 0x7FFFFFFF;
    if (logger.isLoggable(Level.FINE)) {
      logger.fine(Http2.frameLog(true, j, i, b1, b2));
    }
    switch (b1)
    {
    default: 
      this.source.skip(i);
      return true;
    case 0: 
      readData(paramHandler, i, b2, j);
      return true;
    case 1: 
      readHeaders(paramHandler, i, b2, j);
      return true;
    case 2: 
      readPriority(paramHandler, i, b2, j);
      return true;
    case 3: 
      readRstStream(paramHandler, i, b2, j);
      return true;
    case 4: 
      readSettings(paramHandler, i, b2, j);
      return true;
    case 5: 
      readPushPromise(paramHandler, i, b2, j);
      return true;
    case 6: 
      readPing(paramHandler, i, b2, j);
      return true;
    case 7: 
      readGoAway(paramHandler, i, b2, j);
      return true;
    }
    readWindowUpdate(paramHandler, i, b2, j);
    return true;
  }
  
  public void readConnectionPreface(Handler paramHandler)
    throws IOException
  {
    if (this.client)
    {
      if (!nextFrame(true, paramHandler)) {
        throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
      }
    }
    else
    {
      paramHandler = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
      if (logger.isLoggable(Level.FINE)) {
        logger.fine(Util.format("<< CONNECTION %s", new Object[] { paramHandler.hex() }));
      }
      if (!Http2.CONNECTION_PREFACE.equals(paramHandler)) {
        throw Http2.ioException("Expected a connection header but was %s", new Object[] { paramHandler.utf8() });
      }
    }
  }
  
  static final class ContinuationSource
    implements Source
  {
    byte flags;
    int left;
    int length;
    short padding;
    private final BufferedSource source;
    int streamId;
    
    ContinuationSource(BufferedSource paramBufferedSource)
    {
      this.source = paramBufferedSource;
    }
    
    private void readContinuationHeader()
      throws IOException
    {
      int i = this.streamId;
      int j = Http2Reader.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(this.source.readByte() & 0xFF);
      this.flags = ((byte)(this.source.readByte() & 0xFF));
      if (Http2Reader.logger.isLoggable(Level.FINE)) {
        Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, b, this.flags));
      }
      this.streamId = (this.source.readInt() & 0x7FFFFFFF);
      if (b != 9) {
        throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
      }
      if (this.streamId != i) {
        throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
      }
    }
    
    public void close()
      throws IOException
    {}
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.left == 0)
      {
        this.source.skip(this.padding);
        this.padding = 0;
        if ((this.flags & 0x4) == 0) {}
      }
      do
      {
        return -1L;
        readContinuationHeader();
        break;
        paramLong = this.source.read(paramBuffer, Math.min(paramLong, this.left));
      } while (paramLong == -1L);
      this.left = ((int)(this.left - paramLong));
      return paramLong;
    }
    
    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
  
  static abstract interface Handler
  {
    public abstract void ackSettings();
    
    public abstract void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong);
    
    public abstract void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException;
    
    public abstract void goAway(int paramInt, ErrorCode paramErrorCode, ByteString paramByteString);
    
    public abstract void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList);
    
    public abstract void ping(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException;
    
    public abstract void rstStream(int paramInt, ErrorCode paramErrorCode);
    
    public abstract void settings(boolean paramBoolean, Settings paramSettings);
    
    public abstract void windowUpdate(int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Reader
 * JD-Core Version:    0.7.0.1
 */