package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemAddVideoTaskInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFid = 4;
  private static final int fieldNumberFilename = 3;
  private static final int fieldNumberSha = 1;
  private static final int fieldNumberSize = 2;
  public String fid;
  public String filename;
  public String sha;
  public long size;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sha != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.sha);
    }
    int j = i + ComputeSizeUtil.computeLongSize(2, this.size);
    i = j;
    if (this.filename != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.filename);
    }
    j = i;
    if (this.fid != null) {
      j = i + ComputeSizeUtil.computeStringSize(4, this.fid);
    }
    return j;
  }
  
  public final ItemAddVideoTaskInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.sha == null) || (this.filename == null) || (this.fid == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemAddVideoTaskInput paramItemAddVideoTaskInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemAddVideoTaskInput.sha = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemAddVideoTaskInput.size = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramItemAddVideoTaskInput.filename = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemAddVideoTaskInput.fid = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.sha == null) || (this.filename == null) || (this.fid == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(1, this.sha);
    }
    paramOutputWriter.writeLong(2, this.size);
    if (this.filename != null) {
      paramOutputWriter.writeString(3, this.filename);
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(4, this.fid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemAddVideoTaskInput
 * JD-Core Version:    0.7.0.1
 */