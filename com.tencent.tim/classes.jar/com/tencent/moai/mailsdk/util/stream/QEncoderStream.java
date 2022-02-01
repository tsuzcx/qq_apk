package com.tencent.moai.mailsdk.util.stream;

import java.io.IOException;
import java.io.OutputStream;

public class QEncoderStream
  extends QPEncoderStream
{
  private static String TEXT_SPECIALS = "=_?";
  private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
  private String specials;
  
  public QEncoderStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramOutputStream, 2147483647);
    if (paramBoolean) {}
    for (paramOutputStream = WORD_SPECIALS;; paramOutputStream = TEXT_SPECIALS)
    {
      this.specials = paramOutputStream;
      return;
    }
  }
  
  public static int encodedLength(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int j = 0;
    String str;
    int i;
    if (paramBoolean)
    {
      str = WORD_SPECIALS;
      i = 0;
      label13:
      if (j >= paramArrayOfByte.length) {
        return i;
      }
      int k = paramArrayOfByte[j] & 0xFF;
      if ((k >= 32) && (k < 127) && (str.indexOf(k) < 0)) {
        break label71;
      }
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break label13;
      str = TEXT_SPECIALS;
      break;
      label71:
      i += 1;
    }
    return i;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    paramInt &= 0xFF;
    if (paramInt == 32)
    {
      output(95, false);
      return;
    }
    if ((paramInt < 32) || (paramInt >= 127) || (this.specials.indexOf(paramInt) >= 0))
    {
      output(paramInt, true);
      return;
    }
    output(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.QEncoderStream
 * JD-Core Version:    0.7.0.1
 */