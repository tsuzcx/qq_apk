package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class RspBase
  extends BaseProtoBuf
{
  private static final int fieldNumberApp = 1;
  private static final int fieldNumberCmd = 3;
  private static final int fieldNumberPkg = 6;
  private static final int fieldNumberRet = 5;
  private static final int fieldNumberSeq = 4;
  private static final int fieldNumberUsr = 2;
  public int app = -2147483648;
  public int cmd = -2147483648;
  public ByteString pkg;
  public int ret = -1;
  public int seq = -2147483648;
  public long usr = -9223372036854775808L;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.app != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.app);
    }
    int i = j;
    if (this.usr != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.usr);
    }
    j = i;
    if (this.cmd != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.cmd);
    }
    i = j;
    if (this.seq != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.seq);
    }
    j = i;
    if (this.ret != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.ret);
    }
    i = j;
    if (this.pkg != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.pkg);
    }
    return i;
  }
  
  public final RspBase parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, RspBase paramRspBase, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramRspBase.app = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramRspBase.usr = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramRspBase.cmd = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramRspBase.seq = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramRspBase.ret = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramRspBase.pkg = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.app != -2147483648) {
      paramOutputWriter.writeInteger(1, this.app);
    }
    if (this.usr != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.usr);
    }
    if (this.cmd != -2147483648) {
      paramOutputWriter.writeInteger(3, this.cmd);
    }
    if (this.seq != -2147483648) {
      paramOutputWriter.writeInteger(4, this.seq);
    }
    if (this.ret != -2147483648) {
      paramOutputWriter.writeInteger(5, this.ret);
    }
    if (this.pkg != null) {
      paramOutputWriter.writeByteString(6, this.pkg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.RspBase
 * JD-Core Version:    0.7.0.1
 */