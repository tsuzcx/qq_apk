package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CAttendee
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberName = 2;
  private static final int fieldNumberStatus = 3;
  private static final int fieldNumberType = 4;
  public String email;
  public String name;
  public int status;
  public int type;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i;
    if (this.name != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.name);
    }
    return j + ComputeSizeUtil.computeIntegerSize(3, this.status) + ComputeSizeUtil.computeIntegerSize(4, this.type);
  }
  
  public final CAttendee parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CAttendee paramCAttendee, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCAttendee.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCAttendee.name = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCAttendee.status = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCAttendee.type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    if (this.name != null) {
      paramOutputWriter.writeString(2, this.name);
    }
    paramOutputWriter.writeInteger(3, this.status);
    paramOutputWriter.writeInteger(4, this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CAttendee
 * JD-Core Version:    0.7.0.1
 */