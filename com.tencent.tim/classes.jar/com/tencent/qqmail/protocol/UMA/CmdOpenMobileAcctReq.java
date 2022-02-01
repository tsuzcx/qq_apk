package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdOpenMobileAcctReq
  extends BaseProtoBuf
{
  private static final int fieldNumberMobilenum_list = 1;
  public LinkedList<String> mobilenum_list = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.mobilenum_list);
  }
  
  public final CmdOpenMobileAcctReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.mobilenum_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdOpenMobileAcctReq paramCmdOpenMobileAcctReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramCmdOpenMobileAcctReq.mobilenum_list.add(paramInputReader.readString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.mobilenum_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdOpenMobileAcctReq
 * JD-Core Version:    0.7.0.1
 */