package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdClrContactTypeReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 3;
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberType = 2;
  public int account_id = -2147483648;
  public LinkedList<String> email = new LinkedList();
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 1, this.email) + ComputeSizeUtil.computeIntegerSize(2, this.type);
    int i = j;
    if (this.account_id != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.account_id);
    }
    return i;
  }
  
  public final CmdClrContactTypeReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.email.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdClrContactTypeReq paramCmdClrContactTypeReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdClrContactTypeReq.email.add(paramInputReader.readString(paramInt));
      return true;
    case 2: 
      paramCmdClrContactTypeReq.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdClrContactTypeReq.account_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.email);
    paramOutputWriter.writeInteger(2, this.type);
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(3, this.account_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdClrContactTypeReq
 * JD-Core Version:    0.7.0.1
 */