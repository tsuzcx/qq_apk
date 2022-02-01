package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class EmailAccountState
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_flag = 4;
  private static final int fieldNumberAccount_id = 1;
  private static final int fieldNumberPolling_interval = 3;
  private static final int fieldNumberState_code = 2;
  public int account_flag = -2147483648;
  public int account_id = -2147483648;
  public int polling_interval = -2147483648;
  public int state_code;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_id != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.state_code);
    i = j;
    if (this.polling_interval != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.polling_interval);
    }
    j = i;
    if (this.account_flag != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(4, this.account_flag);
    }
    return j;
  }
  
  public final EmailAccountState parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, EmailAccountState paramEmailAccountState, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramEmailAccountState.account_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramEmailAccountState.state_code = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramEmailAccountState.polling_interval = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramEmailAccountState.account_flag = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.account_id);
    }
    paramOutputWriter.writeInteger(2, this.state_code);
    if (this.polling_interval != -2147483648) {
      paramOutputWriter.writeInteger(3, this.polling_interval);
    }
    if (this.account_flag != -2147483648) {
      paramOutputWriter.writeInteger(4, this.account_flag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.EmailAccountState
 * JD-Core Version:    0.7.0.1
 */