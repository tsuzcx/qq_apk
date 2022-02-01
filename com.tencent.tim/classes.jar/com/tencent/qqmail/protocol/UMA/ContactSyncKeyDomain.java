package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactSyncKeyDomain
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_addresses = 1;
  private static final int fieldNumberSync_key = 2;
  public String account_addresses;
  public String sync_key;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_addresses != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.account_addresses);
    }
    int j = i;
    if (this.sync_key != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.sync_key);
    }
    return j;
  }
  
  public final ContactSyncKeyDomain parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactSyncKeyDomain paramContactSyncKeyDomain, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContactSyncKeyDomain.account_addresses = paramInputReader.readString(paramInt);
      return true;
    }
    paramContactSyncKeyDomain.sync_key = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_addresses != null) {
      paramOutputWriter.writeString(1, this.account_addresses);
    }
    if (this.sync_key != null) {
      paramOutputWriter.writeString(2, this.sync_key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactSyncKeyDomain
 * JD-Core Version:    0.7.0.1
 */