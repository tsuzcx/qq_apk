package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetRsaRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberMd5pwd = 1;
  private static final int fieldNumberMd5sec = 2;
  public String md5pwd;
  public String md5sec;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.md5pwd != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.md5pwd);
    }
    int j = i;
    if (this.md5sec != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.md5sec);
    }
    return j;
  }
  
  public final CmdGetRsaRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetRsaRsp paramCmdGetRsaRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdGetRsaRsp.md5pwd = paramInputReader.readString(paramInt);
      return true;
    }
    paramCmdGetRsaRsp.md5sec = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.md5pwd != null) {
      paramOutputWriter.writeString(1, this.md5pwd);
    }
    if (this.md5sec != null) {
      paramOutputWriter.writeString(2, this.md5sec);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetRsaRsp
 * JD-Core Version:    0.7.0.1
 */