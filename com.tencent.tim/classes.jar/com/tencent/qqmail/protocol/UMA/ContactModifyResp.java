package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ContactModifyResp
  extends BaseProtoBuf
{
  private static final int fieldNumberError_code = 1;
  private static final int fieldNumberSync_key = 2;
  public int error_code;
  public String sync_key;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.error_code);
    int i = j;
    if (this.sync_key != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sync_key);
    }
    return i;
  }
  
  public final ContactModifyResp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ContactModifyResp paramContactModifyResp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContactModifyResp.error_code = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramContactModifyResp.sync_key = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.error_code);
    if (this.sync_key != null) {
      paramOutputWriter.writeString(2, this.sync_key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ContactModifyResp
 * JD-Core Version:    0.7.0.1
 */