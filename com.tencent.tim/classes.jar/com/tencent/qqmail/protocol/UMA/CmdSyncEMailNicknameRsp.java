package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdSyncEMailNicknameRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberInfo = 1;
  public LinkedList<SyncEMailNicknameRspInfo> info = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.info);
  }
  
  public final CmdSyncEMailNicknameRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdSyncEMailNicknameRsp paramCmdSyncEMailNicknameRsp, int paramInt)
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
      SyncEMailNicknameRspInfo localSyncEMailNicknameRspInfo = new SyncEMailNicknameRspInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localSyncEMailNicknameRspInfo.populateBuilderWithField((InputReader)localObject, localSyncEMailNicknameRspInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdSyncEMailNicknameRsp.info.add(localSyncEMailNicknameRspInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdSyncEMailNicknameRsp
 * JD-Core Version:    0.7.0.1
 */