package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactModifyReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCreate_info = 1;
  public ContactCreateInfo create_info;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.create_info != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.create_info.computeSize());
    }
    return i;
  }
  
  public final ContactModifyReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactModifyReq paramContactModifyReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      ContactCreateInfo localContactCreateInfo = new ContactCreateInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localContactCreateInfo.populateBuilderWithField((InputReader)localObject, localContactCreateInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramContactModifyReq.create_info = localContactCreateInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.create_info != null)
    {
      paramOutputWriter.writeMessage(1, this.create_info.computeSize());
      this.create_info.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactModifyReq
 * JD-Core Version:    0.7.0.1
 */