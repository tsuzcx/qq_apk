package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ListInput
  extends BaseProtoBuf
{
  private static final int fieldNumberEncrypt = 3;
  private static final int fieldNumberLastupdatetime = 1;
  private static final int fieldNumberPassword = 2;
  public boolean encrypt;
  public int lastupdatetime;
  public String password;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.lastupdatetime);
    int i = j;
    if (this.password != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.password);
    }
    return i + ComputeSizeUtil.computeBooleanSize(3, this.encrypt);
  }
  
  public final ListInput parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ListInput paramListInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramListInput.lastupdatetime = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramListInput.password = paramInputReader.readString(paramInt);
      return true;
    }
    paramListInput.encrypt = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.lastupdatetime);
    if (this.password != null) {
      paramOutputWriter.writeString(2, this.password);
    }
    paramOutputWriter.writeBoolean(3, this.encrypt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ListInput
 * JD-Core Version:    0.7.0.1
 */