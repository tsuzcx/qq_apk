package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemDocPreviewOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 3;
  private static final int fieldNumberFileName = 1;
  private static final int fieldNumberSize = 2;
  public String content;
  public String fileName;
  public long size;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.fileName != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.fileName);
    }
    int j = i + ComputeSizeUtil.computeLongSize(2, this.size);
    i = j;
    if (this.content != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.content);
    }
    return i;
  }
  
  public final ItemDocPreviewOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fileName == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemDocPreviewOutput paramItemDocPreviewOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemDocPreviewOutput.fileName = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemDocPreviewOutput.size = paramInputReader.readLong(paramInt);
      return true;
    }
    paramItemDocPreviewOutput.content = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fileName == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fileName != null) {
      paramOutputWriter.writeString(1, this.fileName);
    }
    paramOutputWriter.writeLong(2, this.size);
    if (this.content != null) {
      paramOutputWriter.writeString(3, this.content);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemDocPreviewOutput
 * JD-Core Version:    0.7.0.1
 */