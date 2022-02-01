package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class EmailProtocolInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAssociate_uin = 9;
  private static final int fieldNumberDomain = 7;
  private static final int fieldNumberHost = 4;
  private static final int fieldNumberPath_prefix = 8;
  private static final int fieldNumberPort = 5;
  private static final int fieldNumberPsw = 3;
  private static final int fieldNumberPsw_type = 11;
  private static final int fieldNumberSecurity = 6;
  private static final int fieldNumberType = 1;
  private static final int fieldNumberUser = 2;
  public long associate_uin = -9223372036854775808L;
  public String domain;
  public String host;
  public String path_prefix;
  public int port = -2147483648;
  public String psw;
  public int psw_type;
  public int security = -2147483648;
  public int type;
  public String user;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.user != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.user);
    }
    j = i;
    if (this.psw != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.psw);
    }
    i = j;
    if (this.host != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.host);
    }
    j = i;
    if (this.port != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.port);
    }
    i = j;
    if (this.security != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.security);
    }
    j = i;
    if (this.domain != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.domain);
    }
    i = j;
    if (this.path_prefix != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.path_prefix);
    }
    j = i;
    if (this.associate_uin != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(9, this.associate_uin);
    }
    return j + ComputeSizeUtil.computeIntegerSize(11, this.psw_type);
  }
  
  public final EmailProtocolInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, EmailProtocolInfo paramEmailProtocolInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      return false;
    case 1: 
      paramEmailProtocolInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramEmailProtocolInfo.user = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramEmailProtocolInfo.psw = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramEmailProtocolInfo.host = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramEmailProtocolInfo.port = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramEmailProtocolInfo.security = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramEmailProtocolInfo.domain = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramEmailProtocolInfo.path_prefix = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramEmailProtocolInfo.associate_uin = paramInputReader.readLong(paramInt);
      return true;
    }
    paramEmailProtocolInfo.psw_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.user != null) {
      paramOutputWriter.writeString(2, this.user);
    }
    if (this.psw != null) {
      paramOutputWriter.writeString(3, this.psw);
    }
    if (this.host != null) {
      paramOutputWriter.writeString(4, this.host);
    }
    if (this.port != -2147483648) {
      paramOutputWriter.writeInteger(5, this.port);
    }
    if (this.security != -2147483648) {
      paramOutputWriter.writeInteger(6, this.security);
    }
    if (this.domain != null) {
      paramOutputWriter.writeString(7, this.domain);
    }
    if (this.path_prefix != null) {
      paramOutputWriter.writeString(8, this.path_prefix);
    }
    if (this.associate_uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(9, this.associate_uin);
    }
    paramOutputWriter.writeInteger(11, this.psw_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.EmailProtocolInfo
 * JD-Core Version:    0.7.0.1
 */