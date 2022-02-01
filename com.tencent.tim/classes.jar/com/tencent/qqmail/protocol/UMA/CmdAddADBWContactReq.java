package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdAddADBWContactReq
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberIs_black = 2;
  private static final int fieldNumberUser = 3;
  public LinkedList<String> email = new LinkedList();
  public boolean is_black = true;
  public ADBWUserInfo user;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 1, this.email) + ComputeSizeUtil.computeBooleanSize(2, this.is_black);
    int i = j;
    if (this.user != null) {
      i = j + ComputeSizeUtil.computeMessageSize(3, this.user.computeSize());
    }
    return i;
  }
  
  public final CmdAddADBWContactReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.email.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdAddADBWContactReq paramCmdAddADBWContactReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdAddADBWContactReq.email.add(paramInputReader.readString(paramInt));
      return true;
    case 2: 
      paramCmdAddADBWContactReq.is_black = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      ADBWUserInfo localADBWUserInfo = new ADBWUserInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localADBWUserInfo.populateBuilderWithField((InputReader)localObject, localADBWUserInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdAddADBWContactReq.user = localADBWUserInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.email);
    paramOutputWriter.writeBoolean(2, this.is_black);
    if (this.user != null)
    {
      paramOutputWriter.writeMessage(3, this.user.computeSize());
      this.user.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdAddADBWContactReq
 * JD-Core Version:    0.7.0.1
 */