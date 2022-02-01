package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class DownloadUrlItemInput
  extends BaseProtoBuf
{
  private static final int fieldNumberCode = 3;
  private static final int fieldNumberFid = 1;
  private static final int fieldNumberFilename = 4;
  private static final int fieldNumberKey = 2;
  public String code;
  public String fid;
  public String filename;
  public String key;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.fid != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.fid);
    }
    int i = j;
    if (this.key != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.key);
    }
    j = i;
    if (this.code != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.code);
    }
    i = j;
    if (this.filename != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.filename);
    }
    return i;
  }
  
  public final DownloadUrlItemInput parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DownloadUrlItemInput paramDownloadUrlItemInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDownloadUrlItemInput.fid = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramDownloadUrlItemInput.key = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramDownloadUrlItemInput.code = paramInputReader.readString(paramInt);
      return true;
    }
    paramDownloadUrlItemInput.filename = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.key == null) || (this.code == null) || (this.filename == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(1, this.fid);
    }
    if (this.key != null) {
      paramOutputWriter.writeString(2, this.key);
    }
    if (this.code != null) {
      paramOutputWriter.writeString(3, this.code);
    }
    if (this.filename != null) {
      paramOutputWriter.writeString(4, this.filename);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.DownloadUrlItemInput
 * JD-Core Version:    0.7.0.1
 */