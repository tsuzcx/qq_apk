package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactCreateResp
  extends BaseProtoBuf
{
  private static final int fieldNumberContact_list = 3;
  private static final int fieldNumberError_code = 1;
  private static final int fieldNumberSync_key = 2;
  public LinkedList<Contacts> contact_list = new LinkedList();
  public int error_code;
  public String sync_key;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.error_code);
    int i = j;
    if (this.sync_key != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sync_key);
    }
    return i + ComputeSizeUtil.computeListSize(3, 8, this.contact_list);
  }
  
  public final ContactCreateResp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactCreateResp paramContactCreateResp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContactCreateResp.error_code = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramContactCreateResp.sync_key = paramInputReader.readString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      Contacts localContacts = new Contacts();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localContacts.populateBuilderWithField((InputReader)localObject, localContacts, getNextFieldNumber((InputReader)localObject))) {}
      paramContactCreateResp.contact_list.add(localContacts);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.error_code);
    if (this.sync_key != null) {
      paramOutputWriter.writeString(2, this.sync_key);
    }
    paramOutputWriter.writeList(3, 8, this.contact_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactCreateResp
 * JD-Core Version:    0.7.0.1
 */