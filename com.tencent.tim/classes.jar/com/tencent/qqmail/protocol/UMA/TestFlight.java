package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class TestFlight
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 5;
  private static final int fieldNumberEnable = 1;
  private static final int fieldNumberSvrid = 3;
  private static final int fieldNumberType = 4;
  private static final int fieldNumberVersion = 2;
  public ByteString content;
  public boolean enable;
  public int svrid = -2147483648;
  public int type = -2147483648;
  public ByteString version;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.enable);
    int i = j;
    if (this.version != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.version);
    }
    j = i;
    if (this.svrid != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.svrid);
    }
    i = j;
    if (this.type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.type);
    }
    j = i;
    if (this.content != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.content);
    }
    return j;
  }
  
  public final TestFlight parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, TestFlight paramTestFlight, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramTestFlight.enable = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramTestFlight.version = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramTestFlight.svrid = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramTestFlight.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramTestFlight.content = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.enable);
    if (this.version != null) {
      paramOutputWriter.writeByteString(2, this.version);
    }
    if (this.svrid != -2147483648) {
      paramOutputWriter.writeInteger(3, this.svrid);
    }
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(4, this.type);
    }
    if (this.content != null) {
      paramOutputWriter.writeByteString(5, this.content);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.TestFlight
 * JD-Core Version:    0.7.0.1
 */