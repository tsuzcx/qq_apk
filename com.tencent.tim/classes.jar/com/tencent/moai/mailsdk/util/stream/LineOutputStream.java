package com.tencent.moai.mailsdk.util.stream;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LineOutputStream
  extends FilterOutputStream
{
  private static byte[] newline = new byte[2];
  
  static
  {
    newline[0] = 13;
    newline[1] = 10;
  }
  
  public LineOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void writeln()
    throws IOException
  {
    this.out.write(newline);
  }
  
  public void writeln(String paramString)
    throws IOException
  {
    paramString = ASCIIUtility.getBytes(paramString);
    this.out.write(paramString);
    this.out.write(newline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.LineOutputStream
 * JD-Core Version:    0.7.0.1
 */