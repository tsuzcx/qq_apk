package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdSetContactTypeReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 3;
  private static final int fieldNumberContact = 4;
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberType = 2;
  public int account_id = -2147483648;
  public LinkedList<SpamContact> contact = new LinkedList();
  public LinkedList<String> email = new LinkedList();
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 1, this.email) + ComputeSizeUtil.computeIntegerSize(2, this.type);
    int i = j;
    if (this.account_id != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.account_id);
    }
    return i + ComputeSizeUtil.computeListSize(4, 8, this.contact);
  }
  
  public final CmdSetContactTypeReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.email.clear();
    this.contact.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdSetContactTypeReq paramCmdSetContactTypeReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdSetContactTypeReq.email.add(paramInputReader.readString(paramInt));
      return true;
    case 2: 
      paramCmdSetContactTypeReq.type = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramCmdSetContactTypeReq.account_id = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      SpamContact localSpamContact = new SpamContact();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localSpamContact.populateBuilderWithField((InputReader)localObject, localSpamContact, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdSetContactTypeReq.contact.add(localSpamContact);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.email);
    paramOutputWriter.writeInteger(2, this.type);
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(3, this.account_id);
    }
    paramOutputWriter.writeList(4, 8, this.contact);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdSetContactTypeReq
 * JD-Core Version:    0.7.0.1
 */