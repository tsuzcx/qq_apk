package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdSetUserSettingReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCur_config_version = 2;
  private static final int fieldNumberSetting = 1;
  public String cur_config_version;
  public UserSetting setting;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.setting != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.setting.computeSize());
    }
    int j = i;
    if (this.cur_config_version != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.cur_config_version);
    }
    return j;
  }
  
  public final CmdSetUserSettingReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdSetUserSettingReq paramCmdSetUserSettingReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        UserSetting localUserSetting = new UserSetting();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localUserSetting.populateBuilderWithField((InputReader)localObject, localUserSetting, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdSetUserSettingReq.setting = localUserSetting;
        paramInt += 1;
      }
      return true;
    }
    paramCmdSetUserSettingReq.cur_config_version = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.setting != null)
    {
      paramOutputWriter.writeMessage(1, this.setting.computeSize());
      this.setting.writeFields(paramOutputWriter);
    }
    if (this.cur_config_version != null) {
      paramOutputWriter.writeString(2, this.cur_config_version);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdSetUserSettingReq
 * JD-Core Version:    0.7.0.1
 */