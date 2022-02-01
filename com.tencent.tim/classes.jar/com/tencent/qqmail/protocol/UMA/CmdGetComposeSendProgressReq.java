package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetComposeSendProgressReq
  extends BaseProtoBuf
{
  private static final int fieldNumberTask_id = 1;
  public int task_id = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.task_id != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.task_id);
    }
    return i;
  }
  
  public final CmdGetComposeSendProgressReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetComposeSendProgressReq paramCmdGetComposeSendProgressReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramCmdGetComposeSendProgressReq.task_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.task_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.task_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetComposeSendProgressReq
 * JD-Core Version:    0.7.0.1
 */