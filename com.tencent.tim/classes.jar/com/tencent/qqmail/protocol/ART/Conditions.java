package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class Conditions
  extends BaseProtoBuf
{
  private static final int fieldNumberSender_ = 7;
  private static final int fieldNumberSubject_ = 9;
  private static final int fieldNumberTo_ = 8;
  public String sender_;
  public String subject_;
  public String to_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.sender_ != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(7, this.sender_);
    }
    int i = j;
    if (this.to_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.to_);
    }
    j = i;
    if (this.subject_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(9, this.subject_);
    }
    return j;
  }
  
  public final Conditions parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, Conditions paramConditions, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      paramConditions.sender_ = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramConditions.to_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramConditions.subject_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.sender_ != null) {
      paramOutputWriter.writeString(7, this.sender_);
    }
    if (this.to_ != null) {
      paramOutputWriter.writeString(8, this.to_);
    }
    if (this.subject_ != null) {
      paramOutputWriter.writeString(9, this.subject_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.Conditions
 * JD-Core Version:    0.7.0.1
 */