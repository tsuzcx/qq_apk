package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class DataReport
  extends BaseProtoBuf
{
  private static final int fieldNumberData = 2;
  private static final int fieldNumberType = 1;
  private static final int fieldNumberUse_gzip = 3;
  public ByteString data;
  public int type;
  public boolean use_gzip;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.data != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.data);
    }
    return i + ComputeSizeUtil.computeBooleanSize(3, this.use_gzip);
  }
  
  public final DataReport parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DataReport paramDataReport, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDataReport.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramDataReport.data = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramDataReport.use_gzip = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.data != null) {
      paramOutputWriter.writeByteString(2, this.data);
    }
    paramOutputWriter.writeBoolean(3, this.use_gzip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.DataReport
 * JD-Core Version:    0.7.0.1
 */