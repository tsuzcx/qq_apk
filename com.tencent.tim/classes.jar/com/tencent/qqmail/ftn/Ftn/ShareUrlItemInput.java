package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ShareUrlItemInput
  extends BaseProtoBuf
{
  private static final int fieldNumberCode = 2;
  private static final int fieldNumberKey = 1;
  public String code;
  public String key;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.key != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.key);
    }
    int j = i;
    if (this.code != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.code);
    }
    return j;
  }
  
  public final ShareUrlItemInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.key == null) || (this.code == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ShareUrlItemInput paramShareUrlItemInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramShareUrlItemInput.key = paramInputReader.readString(paramInt);
      return true;
    }
    paramShareUrlItemInput.code = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.key == null) || (this.code == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.key != null) {
      paramOutputWriter.writeString(1, this.key);
    }
    if (this.code != null) {
      paramOutputWriter.writeString(2, this.code);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ShareUrlItemInput
 * JD-Core Version:    0.7.0.1
 */