package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PushConfigHandle
  extends BaseProtoBuf
{
  private static final int fieldNumberHash = 3;
  private static final int fieldNumberId = 1;
  private static final int fieldNumberPush_config_handle_info = 4;
  private static final int fieldNumberState = 2;
  public int hash = -2147483648;
  public int id = -2147483648;
  public PushConfigHandleInfo push_config_handle_info;
  public int state = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.id);
    }
    int i = j;
    if (this.state != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.state);
    }
    j = i;
    if (this.hash != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.hash);
    }
    i = j;
    if (this.push_config_handle_info != null) {
      i = j + ComputeSizeUtil.computeMessageSize(4, this.push_config_handle_info.computeSize());
    }
    return i;
  }
  
  public final PushConfigHandle parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PushConfigHandle paramPushConfigHandle, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPushConfigHandle.id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramPushConfigHandle.state = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramPushConfigHandle.hash = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      PushConfigHandleInfo localPushConfigHandleInfo = new PushConfigHandleInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localPushConfigHandleInfo.populateBuilderWithField((InputReader)localObject, localPushConfigHandleInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramPushConfigHandle.push_config_handle_info = localPushConfigHandleInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.id);
    }
    if (this.state != -2147483648) {
      paramOutputWriter.writeInteger(2, this.state);
    }
    if (this.hash != -2147483648) {
      paramOutputWriter.writeInteger(3, this.hash);
    }
    if (this.push_config_handle_info != null)
    {
      paramOutputWriter.writeMessage(4, this.push_config_handle_info.computeSize());
      this.push_config_handle_info.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PushConfigHandle
 * JD-Core Version:    0.7.0.1
 */