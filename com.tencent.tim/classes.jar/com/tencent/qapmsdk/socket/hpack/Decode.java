package com.tencent.qapmsdk.socket.hpack;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public class Decode
{
  private static final String TAG = "HTTP2Decode";
  private ContinuationSource continuation;
  private Hpack.Reader hpackReader;
  private BufferedSource source;
  
  public Decode(InputStream paramInputStream)
  {
    this.source = Okio.buffer(Okio.source(paramInputStream));
    this.continuation = new ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(4096, this.continuation);
  }
  
  private void readData(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
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
    paramInt1 = Http2Reader.lengthWithoutPadding(paramInt1, paramByte, s);
    paramHandler.data(bool, paramInt2, this.source, paramInt1);
    this.source.skip(s);
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
  
  private void readHeaders(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
    throws IOException
  {
    boolean bool2 = true;
    short s = 0;
    if (paramInt2 == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    boolean bool1;
    if ((paramByte & 0x1) != 0)
    {
      bool1 = true;
      if ((paramByte & 0x4) == 0) {
        break label118;
      }
    }
    for (;;)
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
      paramHandler.headers(bool1, bool2, paramInt2, -1, readHeaderBlock(Http2Reader.lengthWithoutPadding(i, paramByte, s), s, paramByte, paramInt2));
      return;
      bool1 = false;
      break;
      label118:
      bool2 = false;
    }
  }
  
  static int readMedium(BufferedSource paramBufferedSource)
    throws IOException
  {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private void readPriority(Http2Reader.Handler paramHandler, int paramInt)
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
  
  private void readPriority(Http2Reader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
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
  
  public boolean readFrame(Http2Reader.Handler paramHandler)
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
    byte b2 = (byte)(this.source.readByte() & 0xFF);
    int j = this.source.readInt() & 0x7FFFFFFF;
    Logger.INSTANCE.d(new String[] { "HTTP2Decode", Http2.frameLog(true, j, i, b1, b2) });
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
    }
    readPriority(paramHandler, i, b2, j);
    return true;
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
      int j = Decode.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(this.source.readByte() & 0xFF);
      this.flags = ((byte)(this.source.readByte() & 0xFF));
      Logger.INSTANCE.d(new String[] { "HTTP2Decode", Http2.frameLog(true, this.streamId, this.length, b, this.flags) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Decode
 * JD-Core Version:    0.7.0.1
 */