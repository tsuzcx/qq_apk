package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SaveCardRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberCarid = 2;
  private static final int fieldNumberH5url = 1;
  public ByteString carid;
  public ByteString h5url;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.h5url != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.h5url);
    }
    int j = i;
    if (this.carid != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.carid);
    }
    return j;
  }
  
  public final SaveCardRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SaveCardRsp paramSaveCardRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSaveCardRsp.h5url = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramSaveCardRsp.carid = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.h5url != null) {
      paramOutputWriter.writeByteString(1, this.h5url);
    }
    if (this.carid != null) {
      paramOutputWriter.writeByteString(2, this.carid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SaveCardRsp
 * JD-Core Version:    0.7.0.1
 */