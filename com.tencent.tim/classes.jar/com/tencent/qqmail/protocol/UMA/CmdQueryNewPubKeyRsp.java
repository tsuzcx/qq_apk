package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryNewPubKeyRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberNew_pubkey = 1;
  public ByteString new_pubkey;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.new_pubkey != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.new_pubkey);
    }
    return i;
  }
  
  public final CmdQueryNewPubKeyRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryNewPubKeyRsp paramCmdQueryNewPubKeyRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramCmdQueryNewPubKeyRsp.new_pubkey = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.new_pubkey != null) {
      paramOutputWriter.writeByteString(1, this.new_pubkey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryNewPubKeyRsp
 * JD-Core Version:    0.7.0.1
 */