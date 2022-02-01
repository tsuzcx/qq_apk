package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactsCustomInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberCustom_info_name = 1;
  private static final int fieldNumberCustom_info_value = 2;
  public ByteString custom_info_name;
  public ByteString custom_info_value;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.custom_info_name != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.custom_info_name);
    }
    int j = i;
    if (this.custom_info_value != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.custom_info_value);
    }
    return j;
  }
  
  public final ContactsCustomInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactsCustomInfo paramContactsCustomInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContactsCustomInfo.custom_info_name = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramContactsCustomInfo.custom_info_value = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.custom_info_name != null) {
      paramOutputWriter.writeByteString(1, this.custom_info_name);
    }
    if (this.custom_info_value != null) {
      paramOutputWriter.writeByteString(2, this.custom_info_value);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactsCustomInfo
 * JD-Core Version:    0.7.0.1
 */