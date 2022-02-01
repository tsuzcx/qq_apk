package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SpamContact
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberMailid = 3;
  private static final int fieldNumberSubject = 2;
  public String email;
  public String mailid;
  public String subject;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.email != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int i = j;
    if (this.subject != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.subject);
    }
    j = i;
    if (this.mailid != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.mailid);
    }
    return j;
  }
  
  public final SpamContact parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SpamContact paramSpamContact, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSpamContact.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSpamContact.subject = paramInputReader.readString(paramInt);
      return true;
    }
    paramSpamContact.mailid = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    if (this.subject != null) {
      paramOutputWriter.writeString(2, this.subject);
    }
    if (this.mailid != null) {
      paramOutputWriter.writeString(3, this.mailid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SpamContact
 * JD-Core Version:    0.7.0.1
 */