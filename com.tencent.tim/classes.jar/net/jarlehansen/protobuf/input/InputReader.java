package net.jarlehansen.protobuf.input;

import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import net.jarlehansen.protobuf.input.taghandler.UnknownTagHandler;
import net.jarlehansen.protobuf.original.WireFormat;
import net.jarlehansen.protobuf.original.input.CodedInputStream;

public class InputReader
{
  private final CodedInputStream codedInput;
  private int previousTag = 0;
  private final UnknownTagHandler unknownTagHandler;
  
  public InputReader(InputStream paramInputStream, UnknownTagHandler paramUnknownTagHandler)
  {
    this.codedInput = CodedInputStream.newInstance(paramInputStream);
    this.unknownTagHandler = paramUnknownTagHandler;
  }
  
  public InputReader(DelimitedInputStream paramDelimitedInputStream, UnknownTagHandler paramUnknownTagHandler)
  {
    this.codedInput = CodedInputStream.newInstance(paramDelimitedInputStream);
    this.unknownTagHandler = paramUnknownTagHandler;
  }
  
  public InputReader(byte[] paramArrayOfByte, UnknownTagHandler paramUnknownTagHandler)
  {
    this.codedInput = CodedInputStream.newInstance(paramArrayOfByte);
    this.unknownTagHandler = paramUnknownTagHandler;
  }
  
  public int getNextFieldNumber()
    throws IOException
  {
    this.previousTag = this.codedInput.readTag();
    return WireFormat.getTagFieldNumber(this.previousTag);
  }
  
  public void getPreviousTagDataTypeAndReadContent()
    throws IOException
  {
    int i = WireFormat.getTagWireType(this.previousTag);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(WireFormat.getTagFieldNumber(this.previousTag)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      this.unknownTagHandler.unknownTag(localStringBuffer.toString());
      return;
      localStringBuffer.append("float value: ").append(Float.toString(this.codedInput.readFloat()));
      continue;
      localStringBuffer.append("double value: ").append(Double.toString(this.codedInput.readDouble()));
      continue;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.codedInput.readString());
      continue;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.codedInput.readRawVarint64());
    }
  }
  
  public boolean readBoolean(int paramInt)
    throws IOException
  {
    return this.codedInput.readBool();
  }
  
  public ByteString readByteString(int paramInt)
    throws IOException
  {
    return this.codedInput.readBytes();
  }
  
  public double readDouble(int paramInt)
    throws IOException
  {
    return this.codedInput.readDouble();
  }
  
  public float readFloat(int paramInt)
    throws IOException
  {
    return this.codedInput.readFloat();
  }
  
  public int readInt(int paramInt)
    throws IOException
  {
    return this.codedInput.readInt32();
  }
  
  public int readInteger(int paramInt)
    throws IOException
  {
    return readInt(paramInt);
  }
  
  public LinkedList<Integer> readInts(int paramInt)
    throws IOException
  {
    return this.codedInput.readInt32s();
  }
  
  public long readLong(int paramInt)
    throws IOException
  {
    return this.codedInput.readInt64();
  }
  
  public int readMessageStart()
    throws IOException
  {
    return this.codedInput.readMessageStart();
  }
  
  public LinkedList<byte[]> readMessages(int paramInt)
    throws IOException
  {
    return this.codedInput.readMessages(paramInt);
  }
  
  public String readString(int paramInt)
    throws IOException
  {
    return this.codedInput.readString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.input.InputReader
 * JD-Core Version:    0.7.0.1
 */