package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class FeedBackInput
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 2;
  private static final int fieldNumberTitle = 1;
  public String content;
  public String title;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.title != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.title);
    }
    int j = i;
    if (this.content != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.content);
    }
    return j;
  }
  
  public final FeedBackInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.title == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, FeedBackInput paramFeedBackInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramFeedBackInput.title = paramInputReader.readString(paramInt);
      return true;
    }
    paramFeedBackInput.content = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.title == null) || (this.content == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.title != null) {
      paramOutputWriter.writeString(1, this.title);
    }
    if (this.content != null) {
      paramOutputWriter.writeString(2, this.content);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.FeedBackInput
 * JD-Core Version:    0.7.0.1
 */