package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SetEMailNicknameReqInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberInfo = 2;
  private static final int fieldNumberNickname = 3;
  public String email;
  public EmailProtocolInfo info;
  public String nickname;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.email != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int i = j;
    if (this.info != null) {
      i = j + ComputeSizeUtil.computeMessageSize(2, this.info.computeSize());
    }
    j = i;
    if (this.nickname != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.nickname);
    }
    return j;
  }
  
  public final SetEMailNicknameReqInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SetEMailNicknameReqInfo paramSetEMailNicknameReqInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSetEMailNicknameReqInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        EmailProtocolInfo localEmailProtocolInfo = new EmailProtocolInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localEmailProtocolInfo.populateBuilderWithField((InputReader)localObject, localEmailProtocolInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramSetEMailNicknameReqInfo.info = localEmailProtocolInfo;
        paramInt += 1;
      }
      return true;
    }
    paramSetEMailNicknameReqInfo.nickname = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(2, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
    if (this.nickname != null) {
      paramOutputWriter.writeString(3, this.nickname);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SetEMailNicknameReqInfo
 * JD-Core Version:    0.7.0.1
 */