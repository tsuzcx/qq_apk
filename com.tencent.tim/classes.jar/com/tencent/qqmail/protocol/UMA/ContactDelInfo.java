package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactDelInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_address = 2;
  private static final int fieldNumberCid = 1;
  public String account_address;
  public LinkedList<Integer> cid = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 2, this.cid);
    int i = j;
    if (this.account_address != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.account_address);
    }
    return i;
  }
  
  public final ContactDelInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.cid.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactDelInfo paramContactDelInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContactDelInfo.cid.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    }
    paramContactDelInfo.account_address = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 2, this.cid);
    if (this.account_address != null) {
      paramOutputWriter.writeString(2, this.account_address);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactDelInfo
 * JD-Core Version:    0.7.0.1
 */