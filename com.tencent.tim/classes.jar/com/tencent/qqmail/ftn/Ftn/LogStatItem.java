package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class LogStatItem
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 2;
  private static final int fieldNumberOptid = 1;
  public String content;
  public int optid;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.optid);
    int i = j;
    if (this.content != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.content);
    }
    return i;
  }
  
  public final LogStatItem parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.content == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, LogStatItem paramLogStatItem, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramLogStatItem.optid = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramLogStatItem.content = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.content == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.optid);
    if (this.content != null) {
      paramOutputWriter.writeString(2, this.content);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.LogStatItem
 * JD-Core Version:    0.7.0.1
 */