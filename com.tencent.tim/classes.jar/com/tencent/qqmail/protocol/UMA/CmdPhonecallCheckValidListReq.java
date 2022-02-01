package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdPhonecallCheckValidListReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCheck_info = 1;
  public LinkedList<PhonecallCheckInfo> check_info = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.check_info);
  }
  
  public final CmdPhonecallCheckValidListReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.check_info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdPhonecallCheckValidListReq paramCmdPhonecallCheckValidListReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      PhonecallCheckInfo localPhonecallCheckInfo = new PhonecallCheckInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localPhonecallCheckInfo.populateBuilderWithField((InputReader)localObject, localPhonecallCheckInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdPhonecallCheckValidListReq.check_info.add(localPhonecallCheckInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.check_info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdPhonecallCheckValidListReq
 * JD-Core Version:    0.7.0.1
 */