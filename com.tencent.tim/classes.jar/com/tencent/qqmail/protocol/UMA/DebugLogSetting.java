package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class DebugLogSetting
  extends BaseProtoBuf
{
  private static final int fieldNumberArgs = 3;
  private static final int fieldNumberDuration = 2;
  private static final int fieldNumberLevel = 1;
  public ByteString args;
  public int duration = -2147483648;
  public int level = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.level != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.level);
    }
    int i = j;
    if (this.duration != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.duration);
    }
    j = i;
    if (this.args != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.args);
    }
    return j;
  }
  
  public final DebugLogSetting parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DebugLogSetting paramDebugLogSetting, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDebugLogSetting.level = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramDebugLogSetting.duration = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramDebugLogSetting.args = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.level != -2147483648) {
      paramOutputWriter.writeInteger(1, this.level);
    }
    if (this.duration != -2147483648) {
      paramOutputWriter.writeInteger(2, this.duration);
    }
    if (this.args != null) {
      paramOutputWriter.writeByteString(3, this.args);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.DebugLogSetting
 * JD-Core Version:    0.7.0.1
 */