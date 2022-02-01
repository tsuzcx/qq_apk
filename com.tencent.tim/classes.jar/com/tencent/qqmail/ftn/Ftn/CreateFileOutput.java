package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class CreateFileOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberFid = 4;
  private static final int fieldNumberIp = 1;
  private static final int fieldNumberKey = 3;
  private static final int fieldNumberPort = 2;
  private static final int fieldNumberShakey = 5;
  public String fid;
  public String ip;
  public String key;
  public int port;
  public String shakey;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.ip != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.ip);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.port);
    i = j;
    if (this.key != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.key);
    }
    j = i;
    if (this.fid != null) {
      j = i + ComputeSizeUtil.computeStringSize(4, this.fid);
    }
    i = j;
    if (this.shakey != null) {
      i = j + ComputeSizeUtil.computeStringSize(5, this.shakey);
    }
    return i;
  }
  
  public final CreateFileOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.ip == null) || (this.key == null) || (this.fid == null) || (this.shakey == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CreateFileOutput paramCreateFileOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCreateFileOutput.ip = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCreateFileOutput.port = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramCreateFileOutput.key = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCreateFileOutput.fid = paramInputReader.readString(paramInt);
      return true;
    }
    paramCreateFileOutput.shakey = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.ip == null) || (this.key == null) || (this.fid == null) || (this.shakey == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.ip != null) {
      paramOutputWriter.writeString(1, this.ip);
    }
    paramOutputWriter.writeInteger(2, this.port);
    if (this.key != null) {
      paramOutputWriter.writeString(3, this.key);
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(4, this.fid);
    }
    if (this.shakey != null) {
      paramOutputWriter.writeString(5, this.shakey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.CreateFileOutput
 * JD-Core Version:    0.7.0.1
 */