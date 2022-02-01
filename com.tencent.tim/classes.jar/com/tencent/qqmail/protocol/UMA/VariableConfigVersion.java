package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class VariableConfigVersion
  extends BaseProtoBuf
{
  private static final int fieldNumberType = 1;
  private static final int fieldNumberVersion = 2;
  public int type;
  public String version;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.version != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.version);
    }
    return i;
  }
  
  public final VariableConfigVersion parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, VariableConfigVersion paramVariableConfigVersion, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramVariableConfigVersion.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramVariableConfigVersion.version = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.version != null) {
      paramOutputWriter.writeString(2, this.version);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.VariableConfigVersion
 * JD-Core Version:    0.7.0.1
 */