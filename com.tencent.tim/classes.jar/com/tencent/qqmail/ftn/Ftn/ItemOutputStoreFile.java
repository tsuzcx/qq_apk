package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemOutputStoreFile
  extends BaseProtoBuf
{
  private static final int fieldNumberCode = 1;
  private static final int fieldNumberRet = 2;
  public String code;
  public int ret;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.code != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.code);
    }
    return i + ComputeSizeUtil.computeIntegerSize(2, this.ret);
  }
  
  public final ItemOutputStoreFile parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.code == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemOutputStoreFile paramItemOutputStoreFile, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemOutputStoreFile.code = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemOutputStoreFile.ret = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.code == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.code != null) {
      paramOutputWriter.writeString(1, this.code);
    }
    paramOutputWriter.writeInteger(2, this.ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemOutputStoreFile
 * JD-Core Version:    0.7.0.1
 */