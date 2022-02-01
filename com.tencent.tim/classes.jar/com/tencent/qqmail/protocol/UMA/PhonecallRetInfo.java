package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhonecallRetInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberCan_call = 3;
  private static final int fieldNumberEncrypt_info = 4;
  private static final int fieldNumberReceiver_email = 2;
  private static final int fieldNumberReceiver_url = 6;
  private static final int fieldNumberSender_email = 1;
  private static final int fieldNumberSender_url = 5;
  public boolean can_call;
  public ByteString encrypt_info;
  public ByteString receiver_email;
  public ByteString receiver_url;
  public ByteString sender_email;
  public ByteString sender_url;
  
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
    j += ComputeSizeUtil.computeBooleanSize(3, this.can_call);
    i = j;
    if (this.encrypt_info != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.encrypt_info);
    }
    j = i;
    if (this.sender_url != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.sender_url);
    }
    i = j;
    if (this.receiver_url != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.receiver_url);
    }
    return i;
  }
  
  public final PhonecallRetInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhonecallRetInfo paramPhonecallRetInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhonecallRetInfo.sender_email = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramPhonecallRetInfo.receiver_email = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramPhonecallRetInfo.can_call = paramInputReader.readBoolean(paramInt);
      return true;
    case 4: 
      paramPhonecallRetInfo.encrypt_info = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramPhonecallRetInfo.sender_url = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramPhonecallRetInfo.receiver_url = paramInputReader.readByteString(paramInt);
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
    paramOutputWriter.writeBoolean(3, this.can_call);
    if (this.encrypt_info != null) {
      paramOutputWriter.writeByteString(4, this.encrypt_info);
    }
    if (this.sender_url != null) {
      paramOutputWriter.writeByteString(5, this.sender_url);
    }
    if (this.receiver_url != null) {
      paramOutputWriter.writeByteString(6, this.receiver_url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhonecallRetInfo
 * JD-Core Version:    0.7.0.1
 */