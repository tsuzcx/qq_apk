package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class APViewVideoInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberPlayurl = 2;
  private static final int fieldNumberResult = 1;
  public String playurl;
  public int result;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.result);
    int i = j;
    if (this.playurl != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.playurl);
    }
    return i;
  }
  
  public final APViewVideoInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.playurl == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, APViewVideoInfo paramAPViewVideoInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAPViewVideoInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramAPViewVideoInfo.playurl = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.playurl == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.result);
    if (this.playurl != null) {
      paramOutputWriter.writeString(2, this.playurl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.APViewVideoInfo
 * JD-Core Version:    0.7.0.1
 */