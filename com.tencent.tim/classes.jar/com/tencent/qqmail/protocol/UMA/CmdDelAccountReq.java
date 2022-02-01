package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdDelAccountReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 1;
  public int account_id = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_id != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
    }
    return i;
  }
  
  public final CmdDelAccountReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdDelAccountReq paramCmdDelAccountReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramCmdDelAccountReq.account_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.account_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdDelAccountReq
 * JD-Core Version:    0.7.0.1
 */