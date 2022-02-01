package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ReqBase
  extends BaseProtoBuf
{
  private static final int fieldNumberApp = 1;
  private static final int fieldNumberCli = 7;
  private static final int fieldNumberCmd = 3;
  private static final int fieldNumberPkg = 5;
  private static final int fieldNumberSeq = 4;
  private static final int fieldNumberUsr = 2;
  private static final int fieldNumberVer = 6;
  public int app = -2147483648;
  public int cli = -2147483648;
  public int cmd = -2147483648;
  public ByteString pkg;
  public int seq = -2147483648;
  public long usr = -9223372036854775808L;
  public ByteString ver;
  
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
    if (this.pkg != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.pkg);
    }
    i = j;
    if (this.ver != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.ver);
    }
    j = i;
    if (this.cli != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(7, this.cli);
    }
    return j;
  }
  
  public final ReqBase parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ReqBase paramReqBase, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramReqBase.app = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramReqBase.usr = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramReqBase.cmd = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramReqBase.seq = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramReqBase.pkg = paramInputReader.readByteString(paramInt);
      return true;
    case 6: 
      paramReqBase.ver = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramReqBase.cli = paramInputReader.readInteger(paramInt);
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
    if (this.pkg != null) {
      paramOutputWriter.writeByteString(5, this.pkg);
    }
    if (this.ver != null) {
      paramOutputWriter.writeByteString(6, this.ver);
    }
    if (this.cli != -2147483648) {
      paramOutputWriter.writeInteger(7, this.cli);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ReqBase
 * JD-Core Version:    0.7.0.1
 */