package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdComposeSendRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberDemand_len = 3;
  private static final int fieldNumberDemand_pos = 2;
  private static final int fieldNumberTask_id = 1;
  public int demand_len = -2147483648;
  public int demand_pos = -2147483648;
  public int task_id = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.task_id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.task_id);
    }
    int i = j;
    if (this.demand_pos != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.demand_pos);
    }
    j = i;
    if (this.demand_len != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.demand_len);
    }
    return j;
  }
  
  public final CmdComposeSendRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdComposeSendRsp paramCmdComposeSendRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdComposeSendRsp.task_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCmdComposeSendRsp.demand_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdComposeSendRsp.demand_len = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.task_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.task_id);
    }
    if (this.demand_pos != -2147483648) {
      paramOutputWriter.writeInteger(2, this.demand_pos);
    }
    if (this.demand_len != -2147483648) {
      paramOutputWriter.writeInteger(3, this.demand_len);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdComposeSendRsp
 * JD-Core Version:    0.7.0.1
 */