package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PushConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 3;
  private static final int fieldNumberHash = 4;
  private static final int fieldNumberId = 1;
  private static final int fieldNumberType = 2;
  private static final int fieldNumberVersion = 5;
  public ByteString content;
  public int hash = -2147483648;
  public int id = -2147483648;
  public int type = -2147483648;
  public int version = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.id);
    }
    int i = j;
    if (this.type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.type);
    }
    j = i;
    if (this.content != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.content);
    }
    i = j;
    if (this.hash != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.hash);
    }
    j = i;
    if (this.version != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.version);
    }
    return j;
  }
  
  public final PushConfig parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PushConfig paramPushConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPushConfig.id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramPushConfig.type = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramPushConfig.content = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramPushConfig.hash = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramPushConfig.version = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.id);
    }
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(2, this.type);
    }
    if (this.content != null) {
      paramOutputWriter.writeByteString(3, this.content);
    }
    if (this.hash != -2147483648) {
      paramOutputWriter.writeInteger(4, this.hash);
    }
    if (this.version != -2147483648) {
      paramOutputWriter.writeInteger(5, this.version);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PushConfig
 * JD-Core Version:    0.7.0.1
 */