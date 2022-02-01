package com.tencent.qapmsdk.socket.hpack;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public class Http2Reader
{
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
  
  public static abstract interface Handler
  {
    public abstract void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException;
    
    public abstract void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList);
    
    public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Http2Reader
 * JD-Core Version:    0.7.0.1
 */