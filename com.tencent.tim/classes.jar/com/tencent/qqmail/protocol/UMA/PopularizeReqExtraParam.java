package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PopularizeReqExtraParam
  extends BaseProtoBuf
{
  private static final int fieldNumberImage_times = 1;
  public int image_times = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.image_times != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.image_times);
    }
    return i;
  }
  
  public final PopularizeReqExtraParam parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PopularizeReqExtraParam paramPopularizeReqExtraParam, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramPopularizeReqExtraParam.image_times = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.image_times != -2147483648) {
      paramOutputWriter.writeInteger(1, this.image_times);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PopularizeReqExtraParam
 * JD-Core Version:    0.7.0.1
 */