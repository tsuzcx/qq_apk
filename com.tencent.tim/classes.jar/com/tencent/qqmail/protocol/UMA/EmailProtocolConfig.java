package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class EmailProtocolConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberExchange_domain = 6;
  private static final int fieldNumberFlag = 7;
  private static final int fieldNumberHost = 2;
  private static final int fieldNumberPath_prefix = 5;
  private static final int fieldNumberPolling_interval = 9;
  private static final int fieldNumberPort = 3;
  private static final int fieldNumberSecurity = 4;
  private static final int fieldNumberState = 8;
  private static final int fieldNumberType = 1;
  public String exchange_domain;
  public int flag = -2147483648;
  public String host;
  public String path_prefix;
  public int polling_interval = -2147483648;
  public int port = -2147483648;
  public LinkedList<EmailSecurityConfig> security = new LinkedList();
  public int state;
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.host != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.host);
    }
    j = i;
    if (this.port != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.port);
    }
    j += ComputeSizeUtil.computeListSize(4, 8, this.security);
    i = j;
    if (this.path_prefix != null) {
      i = j + ComputeSizeUtil.computeStringSize(5, this.path_prefix);
    }
    j = i;
    if (this.exchange_domain != null) {
      j = i + ComputeSizeUtil.computeStringSize(6, this.exchange_domain);
    }
    i = j;
    if (this.flag != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(7, this.flag);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(8, this.state);
    i = j;
    if (this.polling_interval != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(9, this.polling_interval);
    }
    return i;
  }
  
  public final EmailProtocolConfig parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.security.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, EmailProtocolConfig paramEmailProtocolConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramEmailProtocolConfig.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramEmailProtocolConfig.host = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramEmailProtocolConfig.port = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        EmailSecurityConfig localEmailSecurityConfig = new EmailSecurityConfig();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localEmailSecurityConfig.populateBuilderWithField((InputReader)localObject, localEmailSecurityConfig, getNextFieldNumber((InputReader)localObject))) {}
        paramEmailProtocolConfig.security.add(localEmailSecurityConfig);
        paramInt += 1;
      }
      return true;
    case 5: 
      paramEmailProtocolConfig.path_prefix = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramEmailProtocolConfig.exchange_domain = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramEmailProtocolConfig.flag = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramEmailProtocolConfig.state = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramEmailProtocolConfig.polling_interval = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.host != null) {
      paramOutputWriter.writeString(2, this.host);
    }
    if (this.port != -2147483648) {
      paramOutputWriter.writeInteger(3, this.port);
    }
    paramOutputWriter.writeList(4, 8, this.security);
    if (this.path_prefix != null) {
      paramOutputWriter.writeString(5, this.path_prefix);
    }
    if (this.exchange_domain != null) {
      paramOutputWriter.writeString(6, this.exchange_domain);
    }
    if (this.flag != -2147483648) {
      paramOutputWriter.writeInteger(7, this.flag);
    }
    paramOutputWriter.writeInteger(8, this.state);
    if (this.polling_interval != -2147483648) {
      paramOutputWriter.writeInteger(9, this.polling_interval);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.EmailProtocolConfig
 * JD-Core Version:    0.7.0.1
 */