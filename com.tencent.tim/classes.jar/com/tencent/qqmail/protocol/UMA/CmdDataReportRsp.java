package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdDataReportRsp
  extends BaseProtoBuf
{
  public final int computeSize()
  {
    return 0;
  }
  
  public final CmdDataReportRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdDataReportRsp paramCmdDataReportRsp, int paramInt)
    throws IOException
  {
    return false;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdDataReportRsp
 * JD-Core Version:    0.7.0.1
 */