package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdCheckPendingTipsReq
  extends BaseProtoBuf
{
  private static final int fieldNumberLatest_tip_seq = 1;
  public int latest_tip_seq = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.latest_tip_seq != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.latest_tip_seq);
    }
    return i;
  }
  
  public final CmdCheckPendingTipsReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdCheckPendingTipsReq paramCmdCheckPendingTipsReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramCmdCheckPendingTipsReq.latest_tip_seq = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.latest_tip_seq != -2147483648) {
      paramOutputWriter.writeInteger(1, this.latest_tip_seq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdCheckPendingTipsReq
 * JD-Core Version:    0.7.0.1
 */