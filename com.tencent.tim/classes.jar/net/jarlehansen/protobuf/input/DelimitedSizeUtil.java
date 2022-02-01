package net.jarlehansen.protobuf.input;

import java.io.IOException;
import java.io.InputStream;
import net.jarlehansen.protobuf.original.input.CodedInputStream;

public class DelimitedSizeUtil
{
  public static int readDelimitedSize(InputStream paramInputStream)
    throws IOException
  {
    return CodedInputStream.readDelimitedSize(paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.input.DelimitedSizeUtil
 * JD-Core Version:    0.7.0.1
 */