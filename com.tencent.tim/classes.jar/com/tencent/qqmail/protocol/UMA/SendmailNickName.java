package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SendmailNickName
  extends BaseProtoBuf
{
  private static final int fieldNumberCaller_nickname = 1;
  private static final int fieldNumberEmail_subject = 3;
  private static final int fieldNumberReceiver_nickname = 2;
  public ByteString caller_nickname;
  public ByteString email_subject;
  public ByteString receiver_nickname;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.caller_nickname != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.caller_nickname);
    }
    int i = j;
    if (this.receiver_nickname != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.receiver_nickname);
    }
    j = i;
    if (this.email_subject != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.email_subject);
    }
    return j;
  }
  
  public final SendmailNickName parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SendmailNickName paramSendmailNickName, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSendmailNickName.caller_nickname = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramSendmailNickName.receiver_nickname = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramSendmailNickName.email_subject = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.caller_nickname != null) {
      paramOutputWriter.writeByteString(1, this.caller_nickname);
    }
    if (this.receiver_nickname != null) {
      paramOutputWriter.writeByteString(2, this.receiver_nickname);
    }
    if (this.email_subject != null) {
      paramOutputWriter.writeByteString(3, this.email_subject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SendmailNickName
 * JD-Core Version:    0.7.0.1
 */