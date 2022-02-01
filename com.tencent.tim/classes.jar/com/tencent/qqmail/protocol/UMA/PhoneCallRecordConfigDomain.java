package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhoneCallRecordConfigDomain
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_address = 1;
  private static final int fieldNumberNeed_update = 2;
  public String account_address;
  public boolean need_update;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_address != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.account_address);
    }
    return i + ComputeSizeUtil.computeBooleanSize(2, this.need_update);
  }
  
  public final PhoneCallRecordConfigDomain parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhoneCallRecordConfigDomain paramPhoneCallRecordConfigDomain, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhoneCallRecordConfigDomain.account_address = paramInputReader.readString(paramInt);
      return true;
    }
    paramPhoneCallRecordConfigDomain.need_update = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_address != null) {
      paramOutputWriter.writeString(1, this.account_address);
    }
    paramOutputWriter.writeBoolean(2, this.need_update);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhoneCallRecordConfigDomain
 * JD-Core Version:    0.7.0.1
 */