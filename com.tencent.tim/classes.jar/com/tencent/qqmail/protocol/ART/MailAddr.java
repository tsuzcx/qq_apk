package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class MailAddr
  extends BaseProtoBuf
{
  private static final int fieldNumberAddr_ = 2;
  private static final int fieldNumberLabel_ = 1;
  public String addr_;
  public String label_;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.label_ != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.label_);
    }
    int j = i;
    if (this.addr_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.addr_);
    }
    return j;
  }
  
  public final MailAddr parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, MailAddr paramMailAddr, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramMailAddr.label_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramMailAddr.addr_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.label_ != null) {
      paramOutputWriter.writeString(1, this.label_);
    }
    if (this.addr_ != null) {
      paramOutputWriter.writeString(2, this.addr_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.MailAddr
 * JD-Core Version:    0.7.0.1
 */