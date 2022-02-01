package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdRegisterRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberUma_id = 1;
  private static final int fieldNumberUma_psw = 2;
  public long uma_id = -9223372036854775808L;
  public ByteString uma_psw;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.uma_id != -9223372036854775808L) {
      i = 0 + ComputeSizeUtil.computeLongSize(1, this.uma_id);
    }
    int j = i;
    if (this.uma_psw != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.uma_psw);
    }
    return j;
  }
  
  public final CmdRegisterRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdRegisterRsp paramCmdRegisterRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdRegisterRsp.uma_id = paramInputReader.readLong(paramInt);
      return true;
    }
    paramCmdRegisterRsp.uma_psw = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uma_id != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.uma_id);
    }
    if (this.uma_psw != null) {
      paramOutputWriter.writeByteString(2, this.uma_psw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdRegisterRsp
 * JD-Core Version:    0.7.0.1
 */