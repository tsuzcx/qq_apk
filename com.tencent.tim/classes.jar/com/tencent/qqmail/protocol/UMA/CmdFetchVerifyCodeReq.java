package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdFetchVerifyCodeReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDevice_id = 2;
  private static final int fieldNumberRsp_key = 3;
  private static final int fieldNumberVerify_code_type = 1;
  public String device_id;
  public ByteString rsp_key;
  public int verify_code_type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.verify_code_type);
    int i = j;
    if (this.device_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.device_id);
    }
    j = i;
    if (this.rsp_key != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.rsp_key);
    }
    return j;
  }
  
  public final CmdFetchVerifyCodeReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdFetchVerifyCodeReq paramCmdFetchVerifyCodeReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdFetchVerifyCodeReq.verify_code_type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCmdFetchVerifyCodeReq.device_id = paramInputReader.readString(paramInt);
      return true;
    }
    paramCmdFetchVerifyCodeReq.rsp_key = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.verify_code_type);
    if (this.device_id != null) {
      paramOutputWriter.writeString(2, this.device_id);
    }
    if (this.rsp_key != null) {
      paramOutputWriter.writeByteString(3, this.rsp_key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdFetchVerifyCodeReq
 * JD-Core Version:    0.7.0.1
 */