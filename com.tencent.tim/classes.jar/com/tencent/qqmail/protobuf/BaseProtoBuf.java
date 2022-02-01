package com.tencent.qqmail.protobuf;

import java.io.IOException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.input.taghandler.DefaultUnknownTagHandlerImpl;
import net.jarlehansen.protobuf.input.taghandler.UnknownTagHandler;
import net.jarlehansen.protobuf.output.OutputWriter;

public class BaseProtoBuf
{
  protected static UnknownTagHandler unknownTagHandler = ;
  
  public static int getNextFieldNumber(InputReader paramInputReader)
    throws IOException
  {
    return paramInputReader.getNextFieldNumber();
  }
  
  public int computeSize()
  {
    throw new Error("Cannot use this method");
  }
  
  public BaseProtoBuf parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    throw new IOException("Cannot use this method.");
  }
  
  public byte[] toByteArray()
    throws IOException
  {
    validate();
    byte[] arrayOfByte = new byte[computeSize()];
    OutputWriter localOutputWriter = new OutputWriter(arrayOfByte);
    writeFields(localOutputWriter);
    localOutputWriter.writeData();
    return arrayOfByte;
  }
  
  protected BaseProtoBuf validate()
  {
    return this;
  }
  
  public void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    throw new IOException("Cannot use this method.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protobuf.BaseProtoBuf
 * JD-Core Version:    0.7.0.1
 */