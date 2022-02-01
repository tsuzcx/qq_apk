package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PushInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberCaller_nickname = 5;
  private static final int fieldNumberData = 4;
  private static final int fieldNumberEmail_caller = 1;
  private static final int fieldNumberEmail_receiver = 2;
  private static final int fieldNumberSubject = 3;
  public ByteString caller_nickname;
  public ByteString data;
  public ByteString email_caller;
  public ByteString email_receiver;
  public ByteString subject;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.email_caller != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.email_caller);
    }
    int i = j;
    if (this.email_receiver != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.email_receiver);
    }
    j = i;
    if (this.subject != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.subject);
    }
    i = j;
    if (this.data != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.data);
    }
    j = i;
    if (this.caller_nickname != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.caller_nickname);
    }
    return j;
  }
  
  public final PushInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PushInfo paramPushInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPushInfo.email_caller = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramPushInfo.email_receiver = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramPushInfo.subject = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramPushInfo.data = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramPushInfo.caller_nickname = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email_caller != null) {
      paramOutputWriter.writeByteString(1, this.email_caller);
    }
    if (this.email_receiver != null) {
      paramOutputWriter.writeByteString(2, this.email_receiver);
    }
    if (this.subject != null) {
      paramOutputWriter.writeByteString(3, this.subject);
    }
    if (this.data != null) {
      paramOutputWriter.writeByteString(4, this.data);
    }
    if (this.caller_nickname != null) {
      paramOutputWriter.writeByteString(5, this.caller_nickname);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PushInfo
 * JD-Core Version:    0.7.0.1
 */