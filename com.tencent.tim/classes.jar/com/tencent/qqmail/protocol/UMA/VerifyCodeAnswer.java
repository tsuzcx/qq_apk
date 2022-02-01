package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class VerifyCodeAnswer
  extends BaseProtoBuf
{
  private static final int fieldNumberId = 3;
  private static final int fieldNumberText = 2;
  public String id;
  public String text;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.text != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(2, this.text);
    }
    int j = i;
    if (this.id != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.id);
    }
    return j;
  }
  
  public final VerifyCodeAnswer parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, VerifyCodeAnswer paramVerifyCodeAnswer, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 2: 
      paramVerifyCodeAnswer.text = paramInputReader.readString(paramInt);
      return true;
    }
    paramVerifyCodeAnswer.id = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.text != null) {
      paramOutputWriter.writeString(2, this.text);
    }
    if (this.id != null) {
      paramOutputWriter.writeString(3, this.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.VerifyCodeAnswer
 * JD-Core Version:    0.7.0.1
 */