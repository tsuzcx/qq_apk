package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SpreadResult
  extends BaseProtoBuf
{
  private static final int fieldNumberSpread_flag = 2;
  private static final int fieldNumberSpread_type = 1;
  public boolean spread_flag;
  public int spread_type = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.spread_type != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.spread_type);
    }
    return i + ComputeSizeUtil.computeBooleanSize(2, this.spread_flag);
  }
  
  public final SpreadResult parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SpreadResult paramSpreadResult, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSpreadResult.spread_type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSpreadResult.spread_flag = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.spread_type != -2147483648) {
      paramOutputWriter.writeInteger(1, this.spread_type);
    }
    paramOutputWriter.writeBoolean(2, this.spread_flag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SpreadResult
 * JD-Core Version:    0.7.0.1
 */