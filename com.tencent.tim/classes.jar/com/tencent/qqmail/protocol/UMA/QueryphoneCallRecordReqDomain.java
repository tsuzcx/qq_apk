package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class QueryphoneCallRecordReqDomain
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_address = 1;
  private static final int fieldNumberAccount_synckey = 2;
  public String account_address;
  public String account_synckey;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_address != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.account_address);
    }
    int j = i;
    if (this.account_synckey != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.account_synckey);
    }
    return j;
  }
  
  public final QueryphoneCallRecordReqDomain parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, QueryphoneCallRecordReqDomain paramQueryphoneCallRecordReqDomain, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramQueryphoneCallRecordReqDomain.account_address = paramInputReader.readString(paramInt);
      return true;
    }
    paramQueryphoneCallRecordReqDomain.account_synckey = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_address != null) {
      paramOutputWriter.writeString(1, this.account_address);
    }
    if (this.account_synckey != null) {
      paramOutputWriter.writeString(2, this.account_synckey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.QueryphoneCallRecordReqDomain
 * JD-Core Version:    0.7.0.1
 */