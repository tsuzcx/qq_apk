package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemInput
  extends BaseProtoBuf
{
  private static final int fieldNumberAction = 1;
  private static final int fieldNumberCode = 4;
  private static final int fieldNumberFid = 2;
  private static final int fieldNumberFilename = 5;
  private static final int fieldNumberKey = 3;
  public int action;
  public String code;
  public String fid;
  public String filename;
  public String key;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.action);
    int i = j;
    if (this.fid != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.fid);
    }
    j = i;
    if (this.key != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.key);
    }
    i = j;
    if (this.code != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.code);
    }
    j = i;
    if (this.filename != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.filename);
    }
    return j;
  }
  
  public final ItemInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fid == null) || (this.key == null) || (this.code == null) || (this.filename == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemInput paramItemInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemInput.action = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramItemInput.fid = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramItemInput.key = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramItemInput.code = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemInput.filename = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.key == null) || (this.code == null) || (this.filename == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.action);
    if (this.fid != null) {
      paramOutputWriter.writeString(2, this.fid);
    }
    if (this.key != null) {
      paramOutputWriter.writeString(3, this.key);
    }
    if (this.code != null) {
      paramOutputWriter.writeString(4, this.code);
    }
    if (this.filename != null) {
      paramOutputWriter.writeString(5, this.filename);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemInput
 * JD-Core Version:    0.7.0.1
 */