package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class GetShareUrlOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberShareurl = 1;
  public String shareurl;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.shareurl != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.shareurl);
    }
    return i;
  }
  
  public final GetShareUrlOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.shareurl == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, GetShareUrlOutput paramGetShareUrlOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramGetShareUrlOutput.shareurl = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.shareurl == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.shareurl != null) {
      paramOutputWriter.writeString(1, this.shareurl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.GetShareUrlOutput
 * JD-Core Version:    0.7.0.1
 */