package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdOpenMobileAcctRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberExists_list = 1;
  private static final int fieldNumberFail_list = 3;
  private static final int fieldNumberSuccess_list = 2;
  public LinkedList<String> exists_list = new LinkedList();
  public LinkedList<String> fail_list = new LinkedList();
  public LinkedList<String> success_list = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.exists_list) + ComputeSizeUtil.computeListSize(2, 1, this.success_list) + ComputeSizeUtil.computeListSize(3, 1, this.fail_list);
  }
  
  public final CmdOpenMobileAcctRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.exists_list.clear();
    this.success_list.clear();
    this.fail_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdOpenMobileAcctRsp paramCmdOpenMobileAcctRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdOpenMobileAcctRsp.exists_list.add(paramInputReader.readString(paramInt));
      return true;
    case 2: 
      paramCmdOpenMobileAcctRsp.success_list.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramCmdOpenMobileAcctRsp.fail_list.add(paramInputReader.readString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.exists_list);
    paramOutputWriter.writeList(2, 1, this.success_list);
    paramOutputWriter.writeList(3, 1, this.fail_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdOpenMobileAcctRsp
 * JD-Core Version:    0.7.0.1
 */