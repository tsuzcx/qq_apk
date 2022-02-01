package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhoneCallPushReq
  extends BaseProtoBuf
{
  private static final int fieldNumberInfoitem = 1;
  public PushInfo infoitem;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.infoitem != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.infoitem.computeSize());
    }
    return i;
  }
  
  public final PhoneCallPushReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhoneCallPushReq paramPhoneCallPushReq, int paramInt)
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
      PushInfo localPushInfo = new PushInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localPushInfo.populateBuilderWithField((InputReader)localObject, localPushInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramPhoneCallPushReq.infoitem = localPushInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.infoitem != null)
    {
      paramOutputWriter.writeMessage(1, this.infoitem.computeSize());
      this.infoitem.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhoneCallPushReq
 * JD-Core Version:    0.7.0.1
 */