package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewVideoInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFid = 3;
  private static final int fieldNumberFilename = 6;
  private static final int fieldNumberQuerytype = 5;
  private static final int fieldNumberSha = 1;
  private static final int fieldNumberSize = 2;
  private static final int fieldNumberUrlsha = 4;
  public String fid;
  public String filename;
  public int querytype;
  public String sha;
  public long size;
  public String urlsha;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sha != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.sha);
    }
    int j = i + ComputeSizeUtil.computeLongSize(2, this.size);
    i = j;
    if (this.fid != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.fid);
    }
    j = i;
    if (this.urlsha != null) {
      j = i + ComputeSizeUtil.computeStringSize(4, this.urlsha);
    }
    j += ComputeSizeUtil.computeIntegerSize(5, this.querytype);
    i = j;
    if (this.filename != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.filename);
    }
    return i;
  }
  
  public final ItemViewVideoInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.sha == null) || (this.fid == null) || (this.filename == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewVideoInput paramItemViewVideoInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewVideoInput.sha = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemViewVideoInput.size = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramItemViewVideoInput.fid = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramItemViewVideoInput.urlsha = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramItemViewVideoInput.querytype = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramItemViewVideoInput.filename = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.sha == null) || (this.fid == null) || (this.filename == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(1, this.sha);
    }
    paramOutputWriter.writeLong(2, this.size);
    if (this.fid != null) {
      paramOutputWriter.writeString(3, this.fid);
    }
    if (this.urlsha != null) {
      paramOutputWriter.writeString(4, this.urlsha);
    }
    paramOutputWriter.writeInteger(5, this.querytype);
    if (this.filename != null) {
      paramOutputWriter.writeString(6, this.filename);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewVideoInput
 * JD-Core Version:    0.7.0.1
 */