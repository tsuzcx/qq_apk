package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryNewPubKeyReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDevice_id = 2;
  private static final int fieldNumberRsp_key = 1;
  public String device_id;
  public ByteString rsp_key;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.rsp_key != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.rsp_key);
    }
    int j = i;
    if (this.device_id != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.device_id);
    }
    return j;
  }
  
  public final CmdQueryNewPubKeyReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryNewPubKeyReq paramCmdQueryNewPubKeyReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdQueryNewPubKeyReq.rsp_key = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCmdQueryNewPubKeyReq.device_id = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.rsp_key != null) {
      paramOutputWriter.writeByteString(1, this.rsp_key);
    }
    if (this.device_id != null) {
      paramOutputWriter.writeString(2, this.device_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryNewPubKeyReq
 * JD-Core Version:    0.7.0.1
 */