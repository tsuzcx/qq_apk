package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class CreateFileInput
  extends BaseProtoBuf
{
  private static final int fieldNumberAppid = 5;
  private static final int fieldNumberMd5 = 2;
  private static final int fieldNumberPath = 1;
  private static final int fieldNumberSha = 3;
  private static final int fieldNumberSha3 = 4;
  private static final int fieldNumberSize = 6;
  public int appid;
  public String md5;
  public String path;
  public String sha;
  public String sha3;
  public long size;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.path != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.path);
    }
    int i = j;
    if (this.md5 != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.md5);
    }
    j = i;
    if (this.sha != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.sha);
    }
    i = j;
    if (this.sha3 != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.sha3);
    }
    return i + ComputeSizeUtil.computeIntegerSize(5, this.appid) + ComputeSizeUtil.computeLongSize(6, this.size);
  }
  
  public final CreateFileInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.path == null) || (this.sha == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CreateFileInput paramCreateFileInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCreateFileInput.path = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCreateFileInput.md5 = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCreateFileInput.sha = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCreateFileInput.sha3 = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramCreateFileInput.appid = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCreateFileInput.size = paramInputReader.readLong(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.path == null) || (this.sha == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.path != null) {
      paramOutputWriter.writeString(1, this.path);
    }
    if (this.md5 != null) {
      paramOutputWriter.writeString(2, this.md5);
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(3, this.sha);
    }
    if (this.sha3 != null) {
      paramOutputWriter.writeString(4, this.sha3);
    }
    paramOutputWriter.writeInteger(5, this.appid);
    paramOutputWriter.writeLong(6, this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.CreateFileInput
 * JD-Core Version:    0.7.0.1
 */