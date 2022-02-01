package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CheckCalendarSpamReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCalendarlist = 1;
  public LinkedList<CalendarInfo> calendarlist = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.calendarlist);
  }
  
  public final CheckCalendarSpamReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.calendarlist.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CheckCalendarSpamReq paramCheckCalendarSpamReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      CalendarInfo localCalendarInfo = new CalendarInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localCalendarInfo.populateBuilderWithField((InputReader)localObject, localCalendarInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCheckCalendarSpamReq.calendarlist.add(localCalendarInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.calendarlist);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CheckCalendarSpamReq
 * JD-Core Version:    0.7.0.1
 */