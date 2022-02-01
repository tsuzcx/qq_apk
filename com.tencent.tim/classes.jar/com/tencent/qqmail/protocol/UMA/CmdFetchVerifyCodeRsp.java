package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdFetchVerifyCodeRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberVerify_code_bin = 2;
  private static final int fieldNumberVerify_code_sid = 1;
  public ByteString verify_code_bin;
  public String verify_code_sid;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.verify_code_sid != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.verify_code_sid);
    }
    int j = i;
    if (this.verify_code_bin != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.verify_code_bin);
    }
    return j;
  }
  
  public final CmdFetchVerifyCodeRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdFetchVerifyCodeRsp paramCmdFetchVerifyCodeRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdFetchVerifyCodeRsp.verify_code_sid = paramInputReader.readString(paramInt);
      return true;
    }
    paramCmdFetchVerifyCodeRsp.verify_code_bin = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.verify_code_sid != null) {
      paramOutputWriter.writeString(1, this.verify_code_sid);
    }
    if (this.verify_code_bin != null) {
      paramOutputWriter.writeByteString(2, this.verify_code_bin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdFetchVerifyCodeRsp
 * JD-Core Version:    0.7.0.1
 */