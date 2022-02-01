package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeContact
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail_address_ = 3;
  private static final int fieldNumberIdentity_ = 1;
  private static final int fieldNumberName_ = 2;
  public String email_address_;
  public ExchangeIdentity identity_;
  public String name_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.identity_.computeSize());
    }
    int i = j;
    if (this.name_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.name_);
    }
    j = i;
    if (this.email_address_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.email_address_);
    }
    return j;
  }
  
  public final ExchangeContact parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeContact paramExchangeContact, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        ExchangeIdentity localExchangeIdentity = new ExchangeIdentity();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localExchangeIdentity.populateBuilderWithField((InputReader)localObject, localExchangeIdentity, getNextFieldNumber((InputReader)localObject))) {}
        paramExchangeContact.identity_ = localExchangeIdentity;
        paramInt += 1;
      }
      return true;
    case 2: 
      paramExchangeContact.name_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramExchangeContact.email_address_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.identity_ != null)
    {
      paramOutputWriter.writeMessage(1, this.identity_.computeSize());
      this.identity_.writeFields(paramOutputWriter);
    }
    if (this.name_ != null) {
      paramOutputWriter.writeString(2, this.name_);
    }
    if (this.email_address_ != null) {
      paramOutputWriter.writeString(3, this.email_address_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeContact
 * JD-Core Version:    0.7.0.1
 */