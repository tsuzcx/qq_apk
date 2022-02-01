package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactSyncListReq
  extends BaseProtoBuf
{
  private static final int fieldNumberContact_synckey_domain = 1;
  public LinkedList<ContactSyncKeyDomain> contact_synckey_domain = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.contact_synckey_domain);
  }
  
  public final ContactSyncListReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.contact_synckey_domain.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactSyncListReq paramContactSyncListReq, int paramInt)
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
      ContactSyncKeyDomain localContactSyncKeyDomain = new ContactSyncKeyDomain();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localContactSyncKeyDomain.populateBuilderWithField((InputReader)localObject, localContactSyncKeyDomain, getNextFieldNumber((InputReader)localObject))) {}
      paramContactSyncListReq.contact_synckey_domain.add(localContactSyncKeyDomain);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.contact_synckey_domain);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactSyncListReq
 * JD-Core Version:    0.7.0.1
 */