package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdReportReceivedReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 1;
  private static final int fieldNumberUrl = 2;
  public int account_id = -2147483648;
  public LinkedList<String> url = new LinkedList();
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_id != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
    }
    return i + ComputeSizeUtil.computeListSize(2, 1, this.url);
  }
  
  public final CmdReportReceivedReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.url.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdReportReceivedReq paramCmdReportReceivedReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdReportReceivedReq.account_id = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdReportReceivedReq.url.add(paramInputReader.readString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.account_id);
    }
    paramOutputWriter.writeList(2, 1, this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdReportReceivedReq
 * JD-Core Version:    0.7.0.1
 */