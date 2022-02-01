package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CalendarSpam
  extends BaseProtoBuf
{
  private static final int fieldNumberMd5 = 1;
  private static final int fieldNumberSpam_type = 2;
  public ByteString md5;
  public int spam_type = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.md5 != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.md5);
    }
    int j = i;
    if (this.spam_type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(2, this.spam_type);
    }
    return j;
  }
  
  public final CalendarSpam parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CalendarSpam paramCalendarSpam, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCalendarSpam.md5 = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCalendarSpam.spam_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.md5 != null) {
      paramOutputWriter.writeByteString(1, this.md5);
    }
    if (this.spam_type != -2147483648) {
      paramOutputWriter.writeInteger(2, this.spam_type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CalendarSpam
 * JD-Core Version:    0.7.0.1
 */