package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhonecallCheckInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberReceiver_email = 2;
  private static final int fieldNumberSender_email = 1;
  public ByteString receiver_email;
  public ByteString sender_email;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sender_email != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.sender_email);
    }
    int j = i;
    if (this.receiver_email != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.receiver_email);
    }
    return j;
  }
  
  public final PhonecallCheckInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhonecallCheckInfo paramPhonecallCheckInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhonecallCheckInfo.sender_email = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramPhonecallCheckInfo.receiver_email = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.sender_email != null) {
      paramOutputWriter.writeByteString(1, this.sender_email);
    }
    if (this.receiver_email != null) {
      paramOutputWriter.writeByteString(2, this.receiver_email);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhonecallCheckInfo
 * JD-Core Version:    0.7.0.1
 */