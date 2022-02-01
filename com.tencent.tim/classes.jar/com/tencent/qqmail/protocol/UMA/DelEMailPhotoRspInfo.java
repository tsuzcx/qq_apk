package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class DelEMailPhotoRspInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberQquin = 3;
  private static final int fieldNumberResult = 2;
  public String email;
  public int qquin = -2147483648;
  public int result;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.result);
    i = j;
    if (this.qquin != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.qquin);
    }
    return i;
  }
  
  public final DelEMailPhotoRspInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DelEMailPhotoRspInfo paramDelEMailPhotoRspInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDelEMailPhotoRspInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramDelEMailPhotoRspInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramDelEMailPhotoRspInfo.qquin = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    paramOutputWriter.writeInteger(2, this.result);
    if (this.qquin != -2147483648) {
      paramOutputWriter.writeInteger(3, this.qquin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.DelEMailPhotoRspInfo
 * JD-Core Version:    0.7.0.1
 */