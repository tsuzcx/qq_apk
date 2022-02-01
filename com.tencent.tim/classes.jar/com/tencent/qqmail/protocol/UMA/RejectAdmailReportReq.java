package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class RejectAdmailReportReq
  extends BaseProtoBuf
{
  private static final int fieldNumberSvrid = 2;
  private static final int fieldNumberType = 3;
  private static final int fieldNumberUin = 1;
  public long svrid = -9223372036854775808L;
  public int type = -2147483648;
  public long uin = -9223372036854775808L;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.uin != -9223372036854775808L) {
      j = 0 + ComputeSizeUtil.computeLongSize(1, this.uin);
    }
    int i = j;
    if (this.svrid != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.svrid);
    }
    j = i;
    if (this.type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.type);
    }
    return j;
  }
  
  public final RejectAdmailReportReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, RejectAdmailReportReq paramRejectAdmailReportReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramRejectAdmailReportReq.uin = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramRejectAdmailReportReq.svrid = paramInputReader.readLong(paramInt);
      return true;
    }
    paramRejectAdmailReportReq.type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.uin);
    }
    if (this.svrid != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.svrid);
    }
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(3, this.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.RejectAdmailReportReq
 * JD-Core Version:    0.7.0.1
 */