package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetComposeSendProgressRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberTask_progress = 1;
  private static final int fieldNumberTask_result = 2;
  public int task_progress = -2147483648;
  public int task_result;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.task_progress != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.task_progress);
    }
    return i + ComputeSizeUtil.computeIntegerSize(2, this.task_result);
  }
  
  public final CmdGetComposeSendProgressRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetComposeSendProgressRsp paramCmdGetComposeSendProgressRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdGetComposeSendProgressRsp.task_progress = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdGetComposeSendProgressRsp.task_result = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.task_progress != -2147483648) {
      paramOutputWriter.writeInteger(1, this.task_progress);
    }
    paramOutputWriter.writeInteger(2, this.task_result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetComposeSendProgressRsp
 * JD-Core Version:    0.7.0.1
 */