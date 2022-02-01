package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class EmailSecurityConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberOverride_config = 2;
  private static final int fieldNumberType = 1;
  public EmailProtocolConfig override_config;
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.override_config != null) {
      i = j + ComputeSizeUtil.computeMessageSize(2, this.override_config.computeSize());
    }
    return i;
  }
  
  public final EmailSecurityConfig parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, EmailSecurityConfig paramEmailSecurityConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramEmailSecurityConfig.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      EmailProtocolConfig localEmailProtocolConfig = new EmailProtocolConfig();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localEmailProtocolConfig.populateBuilderWithField((InputReader)localObject, localEmailProtocolConfig, getNextFieldNumber((InputReader)localObject))) {}
      paramEmailSecurityConfig.override_config = localEmailProtocolConfig;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.override_config != null)
    {
      paramOutputWriter.writeMessage(2, this.override_config.computeSize());
      this.override_config.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.EmailSecurityConfig
 * JD-Core Version:    0.7.0.1
 */