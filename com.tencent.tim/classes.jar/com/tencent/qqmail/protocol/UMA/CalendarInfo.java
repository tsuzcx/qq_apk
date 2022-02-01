package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CalendarInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberContent = 2;
  private static final int fieldNumberInvite_email = 1;
  private static final int fieldNumberMd5 = 3;
  public ByteString content;
  public ByteString invite_email;
  public ByteString md5;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.invite_email != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.invite_email);
    }
    int i = j;
    if (this.content != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.content);
    }
    j = i;
    if (this.md5 != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.md5);
    }
    return j;
  }
  
  public final CalendarInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CalendarInfo paramCalendarInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCalendarInfo.invite_email = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCalendarInfo.content = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCalendarInfo.md5 = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.invite_email != null) {
      paramOutputWriter.writeByteString(1, this.invite_email);
    }
    if (this.content != null) {
      paramOutputWriter.writeByteString(2, this.content);
    }
    if (this.md5 != null) {
      paramOutputWriter.writeByteString(3, this.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CalendarInfo
 * JD-Core Version:    0.7.0.1
 */