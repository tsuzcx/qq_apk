package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CommInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberKey = 1;
  private static final int fieldNumberValue = 2;
  public ByteString key;
  public ByteString value;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.key != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.key);
    }
    int j = i;
    if (this.value != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.value);
    }
    return j;
  }
  
  public final CommInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CommInfo paramCommInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCommInfo.key = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCommInfo.value = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.key != null) {
      paramOutputWriter.writeByteString(1, this.key);
    }
    if (this.value != null) {
      paramOutputWriter.writeByteString(2, this.value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CommInfo
 * JD-Core Version:    0.7.0.1
 */