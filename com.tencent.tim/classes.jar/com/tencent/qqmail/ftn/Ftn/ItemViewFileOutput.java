package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewFileOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 3;
  private static final int fieldNumberFilename = 4;
  private static final int fieldNumberSize = 1;
  private static final int fieldNumberType = 2;
  public ByteString content;
  public String filename;
  public long size;
  public String type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeLongSize(1, this.size);
    int i = j;
    if (this.type != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.type);
    }
    j = i;
    if (this.content != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.content);
    }
    i = j;
    if (this.filename != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.filename);
    }
    return i;
  }
  
  public final ItemViewFileOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.type == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewFileOutput paramItemViewFileOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewFileOutput.size = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramItemViewFileOutput.type = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramItemViewFileOutput.content = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramItemViewFileOutput.filename = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.type == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeLong(1, this.size);
    if (this.type != null) {
      paramOutputWriter.writeString(2, this.type);
    }
    if (this.content != null) {
      paramOutputWriter.writeByteString(3, this.content);
    }
    if (this.filename != null) {
      paramOutputWriter.writeString(4, this.filename);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewFileOutput
 * JD-Core Version:    0.7.0.1
 */