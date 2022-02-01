package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class EmailAccountInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 2;
  private static final int fieldNumberId = 1;
  private static final int fieldNumberRecv = 3;
  private static final int fieldNumberSend = 4;
  public String email;
  public int id = -2147483648;
  public EmailProtocolInfo recv;
  public EmailProtocolInfo send;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.id);
    }
    int i = j;
    if (this.email != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.email);
    }
    j = i;
    if (this.recv != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.recv.computeSize());
    }
    i = j;
    if (this.send != null) {
      i = j + ComputeSizeUtil.computeMessageSize(4, this.send.computeSize());
    }
    return i;
  }
  
  public final EmailAccountInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, EmailAccountInfo paramEmailAccountInfo, int paramInt)
    throws IOException
  {
    Object localObject;
    EmailProtocolInfo localEmailProtocolInfo;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramEmailAccountInfo.id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramEmailAccountInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localEmailProtocolInfo = new EmailProtocolInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localEmailProtocolInfo.populateBuilderWithField((InputReader)localObject, localEmailProtocolInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramEmailAccountInfo.recv = localEmailProtocolInfo;
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject = (byte[])paramInputReader.get(paramInt);
      localEmailProtocolInfo = new EmailProtocolInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (bool = true; bool; bool = localEmailProtocolInfo.populateBuilderWithField((InputReader)localObject, localEmailProtocolInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramEmailAccountInfo.send = localEmailProtocolInfo;
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
    if (this.email != null) {
      paramOutputWriter.writeString(2, this.email);
    }
    if (this.recv != null)
    {
      paramOutputWriter.writeMessage(3, this.recv.computeSize());
      this.recv.writeFields(paramOutputWriter);
    }
    if (this.send != null)
    {
      paramOutputWriter.writeMessage(4, this.send.computeSize());
      this.send.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.EmailAccountInfo
 * JD-Core Version:    0.7.0.1
 */