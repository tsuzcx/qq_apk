package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ADBWUserInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 2;
  private static final int fieldNumberFunc = 4;
  private static final int fieldNumberType = 3;
  private static final int fieldNumberUin = 1;
  public ByteString email;
  public int func = -2147483648;
  public int type = -2147483648;
  public int uin = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.uin != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.uin);
    }
    int i = j;
    if (this.email != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.email);
    }
    j = i;
    if (this.type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.type);
    }
    i = j;
    if (this.func != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.func);
    }
    return i;
  }
  
  public final ADBWUserInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ADBWUserInfo paramADBWUserInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramADBWUserInfo.uin = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramADBWUserInfo.email = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramADBWUserInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramADBWUserInfo.func = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uin != -2147483648) {
      paramOutputWriter.writeInteger(1, this.uin);
    }
    if (this.email != null) {
      paramOutputWriter.writeByteString(2, this.email);
    }
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(3, this.type);
    }
    if (this.func != -2147483648) {
      paramOutputWriter.writeInteger(4, this.func);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ADBWUserInfo
 * JD-Core Version:    0.7.0.1
 */