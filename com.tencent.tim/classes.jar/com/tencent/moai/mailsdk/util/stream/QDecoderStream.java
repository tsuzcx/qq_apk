package com.tencent.moai.mailsdk.util.stream;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import java.io.IOException;
import java.io.InputStream;

public class QDecoderStream
  extends QPDecoderStream
{
  public QDecoderStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
    throws IOException
  {
    int j = this.in.read();
    int i;
    if (j == 95) {
      i = 32;
    }
    do
    {
      return i;
      i = j;
    } while (j != 61);
    this.ba[0] = ((byte)this.in.read());
    this.ba[1] = ((byte)this.in.read());
    try
    {
      i = ASCIIUtility.parseInt(this.ba, 0, 2, 16);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IOException("QDecoder: Error in QP stream " + localNumberFormatException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.QDecoderStream
 * JD-Core Version:    0.7.0.1
 */