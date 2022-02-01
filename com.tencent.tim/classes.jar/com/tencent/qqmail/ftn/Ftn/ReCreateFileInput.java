package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ReCreateFileInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFid = 1;
  private static final int fieldNumberSha = 2;
  public String fid;
  public String sha;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.fid != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.fid);
    }
    int j = i;
    if (this.sha != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.sha);
    }
    return j;
  }
  
  public final ReCreateFileInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fid == null) || (this.sha == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ReCreateFileInput paramReCreateFileInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramReCreateFileInput.fid = paramInputReader.readString(paramInt);
      return true;
    }
    paramReCreateFileInput.sha = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.sha == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(1, this.fid);
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(2, this.sha);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ReCreateFileInput
 * JD-Core Version:    0.7.0.1
 */