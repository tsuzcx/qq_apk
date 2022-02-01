package com.tencent.android.tpns.mqtt.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class MultiByteArrayInputStream
  extends InputStream
{
  private byte[] bytesA;
  private byte[] bytesB;
  private int lengthA;
  private int lengthB;
  private int offsetA;
  private int offsetB;
  private int pos = 0;
  
  public MultiByteArrayInputStream(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    this.bytesA = paramArrayOfByte1;
    this.bytesB = paramArrayOfByte2;
    this.offsetA = paramInt1;
    this.offsetB = paramInt3;
    this.lengthA = paramInt2;
    this.lengthB = paramInt4;
  }
  
  public int read()
    throws IOException
  {
    if (this.pos < this.lengthA) {}
    for (int i = this.bytesA[(this.offsetA + this.pos)];; i = this.bytesB[(this.offsetB + this.pos - this.lengthA)])
    {
      int j = i;
      if (i < 0) {
        j = i + 256;
      }
      this.pos += 1;
      return j;
      if (this.pos >= this.lengthA + this.lengthB) {
        break;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.MultiByteArrayInputStream
 * JD-Core Version:    0.7.0.1
 */