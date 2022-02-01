package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdSyncUserSettingRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberSetting = 2;
  private static final int fieldNumberSync_result = 1;
  public UserSetting setting;
  public int sync_result = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sync_result != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.sync_result);
    }
    int j = i;
    if (this.setting != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.setting.computeSize());
    }
    return j;
  }
  
  public final CmdSyncUserSettingRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdSyncUserSettingRsp paramCmdSyncUserSettingRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdSyncUserSettingRsp.sync_result = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      UserSetting localUserSetting = new UserSetting();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localUserSetting.populateBuilderWithField((InputReader)localObject, localUserSetting, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdSyncUserSettingRsp.setting = localUserSetting;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.sync_result != -2147483648) {
      paramOutputWriter.writeInteger(1, this.sync_result);
    }
    if (this.setting != null)
    {
      paramOutputWriter.writeMessage(2, this.setting.computeSize());
      this.setting.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdSyncUserSettingRsp
 * JD-Core Version:    0.7.0.1
 */