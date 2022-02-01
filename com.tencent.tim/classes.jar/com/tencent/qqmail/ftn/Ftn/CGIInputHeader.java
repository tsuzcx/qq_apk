package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class CGIInputHeader
  extends BaseProtoBuf
{
  private static final int fieldNumberAppid = 4;
  private static final int fieldNumberAppversion = 5;
  private static final int fieldNumberMethod = 2;
  private static final int fieldNumberPath = 3;
  private static final int fieldNumberUin = 1;
  public int appid;
  public int appversion;
  public int method;
  public String path;
  public int uin;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.uin) + ComputeSizeUtil.computeIntegerSize(2, this.method);
    int i = j;
    if (this.path != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.path);
    }
    return i + ComputeSizeUtil.computeIntegerSize(4, this.appid) + ComputeSizeUtil.computeIntegerSize(5, this.appversion);
  }
  
  public final CGIInputHeader parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.path == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CGIInputHeader paramCGIInputHeader, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCGIInputHeader.uin = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCGIInputHeader.method = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramCGIInputHeader.path = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCGIInputHeader.appid = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCGIInputHeader.appversion = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.path == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.uin);
    paramOutputWriter.writeInteger(2, this.method);
    if (this.path != null) {
      paramOutputWriter.writeString(3, this.path);
    }
    paramOutputWriter.writeInteger(4, this.appid);
    paramOutputWriter.writeInteger(5, this.appversion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.CGIInputHeader
 * JD-Core Version:    0.7.0.1
 */