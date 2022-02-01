package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactModifyInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_address = 2;
  private static final int fieldNumberContact_list = 1;
  public String account_address;
  public LinkedList<Contacts> contact_list = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 8, this.contact_list);
    int i = j;
    if (this.account_address != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.account_address);
    }
    return i;
  }
  
  public final ContactModifyInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.contact_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactModifyInfo paramContactModifyInfo, int paramInt)
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
        Contacts localContacts = new Contacts();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localContacts.populateBuilderWithField((InputReader)localObject, localContacts, getNextFieldNumber((InputReader)localObject))) {}
        paramContactModifyInfo.contact_list.add(localContacts);
        paramInt += 1;
      }
      return true;
    }
    paramContactModifyInfo.account_address = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.contact_list);
    if (this.account_address != null) {
      paramOutputWriter.writeString(2, this.account_address);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactModifyInfo
 * JD-Core Version:    0.7.0.1
 */