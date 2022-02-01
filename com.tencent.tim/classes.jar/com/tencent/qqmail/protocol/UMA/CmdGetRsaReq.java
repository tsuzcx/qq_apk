package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetRsaReq
  extends BaseProtoBuf
{
  private static final int fieldNumberRsa = 1;
  private static final int fieldNumberRsp_key = 2;
  public String rsa;
  public ByteString rsp_key;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.rsa != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.rsa);
    }
    int j = i;
    if (this.rsp_key != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.rsp_key);
    }
    return j;
  }
  
  public final CmdGetRsaReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetRsaReq paramCmdGetRsaReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdGetRsaReq.rsa = paramInputReader.readString(paramInt);
      return true;
    }
    paramCmdGetRsaReq.rsp_key = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.rsa != null) {
      paramOutputWriter.writeString(1, this.rsa);
    }
    if (this.rsp_key != null) {
      paramOutputWriter.writeByteString(2, this.rsp_key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetRsaReq
 * JD-Core Version:    0.7.0.1
 */