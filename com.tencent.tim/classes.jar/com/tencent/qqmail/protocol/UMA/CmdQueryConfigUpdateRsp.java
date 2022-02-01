package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryConfigUpdateRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberResponse = 1;
  public LinkedList<CmdQueryConfigUpdateRsp_ResponseField> response = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.response);
  }
  
  public final CmdQueryConfigUpdateRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.response.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryConfigUpdateRsp paramCmdQueryConfigUpdateRsp, int paramInt)
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
      CmdQueryConfigUpdateRsp_ResponseField localCmdQueryConfigUpdateRsp_ResponseField = new CmdQueryConfigUpdateRsp_ResponseField();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localCmdQueryConfigUpdateRsp_ResponseField.populateBuilderWithField((InputReader)localObject, localCmdQueryConfigUpdateRsp_ResponseField, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdQueryConfigUpdateRsp.response.add(localCmdQueryConfigUpdateRsp_ResponseField);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.response);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateRsp
 * JD-Core Version:    0.7.0.1
 */