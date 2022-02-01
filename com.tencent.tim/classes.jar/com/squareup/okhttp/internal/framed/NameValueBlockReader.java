package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.InflaterSource;
import okio.Okio;

class NameValueBlockReader
{
  private int compressedLimit;
  private final InflaterSource inflaterSource = new InflaterSource(new NameValueBlockReader.1(this, paramBufferedSource), new NameValueBlockReader.2(this));
  private final BufferedSource source = Okio.buffer(this.inflaterSource);
  
  public NameValueBlockReader(BufferedSource paramBufferedSource) {}
  
  private void doneReading()
    throws IOException
  {
    if (this.compressedLimit > 0)
    {
      this.inflaterSource.refill();
      if (this.compressedLimit != 0) {
        throw new IOException("compressedLimit > 0: " + this.compressedLimit);
      }
    }
  }
  
  private ByteString readByteString()
    throws IOException
  {
    int i = this.source.readInt();
    return this.source.readByteString(i);
  }
  
  public void close()
    throws IOException
  {
    this.source.close();
  }
  
  public List<Header> readNameValueBlock(int paramInt)
    throws IOException
  {
    this.compressedLimit += paramInt;
    int i = this.source.readInt();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      ByteString localByteString1 = readByteString().toAsciiLowercase();
      ByteString localByteString2 = readByteString();
      if (localByteString1.size() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new Header(localByteString1, localByteString2));
      paramInt += 1;
    }
    doneReading();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.NameValueBlockReader
 * JD-Core Version:    0.7.0.1
 */