package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailNicknameRspInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberNickname = 3;
  private static final int fieldNumberResult = 2;
  public String email;
  public String nickname;
  public int result;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.result);
    i = j;
    if (this.nickname != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.nickname);
    }
    return i;
  }
  
  public final SyncEMailNicknameRspInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailNicknameRspInfo paramSyncEMailNicknameRspInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSyncEMailNicknameRspInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSyncEMailNicknameRspInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSyncEMailNicknameRspInfo.nickname = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    paramOutputWriter.writeInteger(2, this.result);
    if (this.nickname != null) {
      paramOutputWriter.writeString(3, this.nickname);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailNicknameRspInfo
 * JD-Core Version:    0.7.0.1
 */