package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdLstContactWithTypeReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 3;
  private static final int fieldNumberType = 1;
  public int account_id = -2147483648;
  public LinkedList<Integer> type = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 2, this.type);
    int i = j;
    if (this.account_id != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.account_id);
    }
    return i;
  }
  
  public final CmdLstContactWithTypeReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.type.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdLstContactWithTypeReq paramCmdLstContactWithTypeReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      paramCmdLstContactWithTypeReq.type.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    }
    paramCmdLstContactWithTypeReq.account_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 2, this.type);
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(3, this.account_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdLstContactWithTypeReq
 * JD-Core Version:    0.7.0.1
 */