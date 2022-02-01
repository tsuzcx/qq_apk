package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQuerySecAppReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCompressed = 3;
  private static final int fieldNumberDevice_info = 2;
  private static final int fieldNumberTriggered_by_server = 1;
  public boolean compressed;
  public ByteString device_info;
  public boolean triggered_by_server;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.triggered_by_server);
    int i = j;
    if (this.device_info != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.device_info);
    }
    return i + ComputeSizeUtil.computeBooleanSize(3, this.compressed);
  }
  
  public final CmdQuerySecAppReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQuerySecAppReq paramCmdQuerySecAppReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdQuerySecAppReq.triggered_by_server = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramCmdQuerySecAppReq.device_info = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCmdQuerySecAppReq.compressed = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.triggered_by_server);
    if (this.device_info != null) {
      paramOutputWriter.writeByteString(2, this.device_info);
    }
    paramOutputWriter.writeBoolean(3, this.compressed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQuerySecAppReq
 * JD-Core Version:    0.7.0.1
 */