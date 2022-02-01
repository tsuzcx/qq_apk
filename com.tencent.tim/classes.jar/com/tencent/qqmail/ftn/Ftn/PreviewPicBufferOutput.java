package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class PreviewPicBufferOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberBuffer = 1;
  public String buffer;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.buffer != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.buffer);
    }
    return i;
  }
  
  public final PreviewPicBufferOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.buffer == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PreviewPicBufferOutput paramPreviewPicBufferOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramPreviewPicBufferOutput.buffer = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.buffer == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.buffer != null) {
      paramOutputWriter.writeString(1, this.buffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.PreviewPicBufferOutput
 * JD-Core Version:    0.7.0.1
 */