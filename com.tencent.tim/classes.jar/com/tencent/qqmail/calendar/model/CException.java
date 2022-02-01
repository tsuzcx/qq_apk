package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CException
  extends BaseProtoBuf
{
  private static final int fieldNumberAllday_event = 11;
  private static final int fieldNumberAppointment_replytime = 16;
  private static final int fieldNumberAttendees = 15;
  private static final int fieldNumberBody = 6;
  private static final int fieldNumberBusyStatus = 10;
  private static final int fieldNumberCategories = 8;
  private static final int fieldNumberDeleted = 1;
  private static final int fieldNumberDt_stamp = 13;
  private static final int fieldNumberEnd_time = 5;
  private static final int fieldNumberException_start_time = 3;
  private static final int fieldNumberLocation = 7;
  private static final int fieldNumberMeeting_status = 14;
  private static final int fieldNumberReminder = 12;
  private static final int fieldNumberResponse_type = 17;
  private static final int fieldNumberSensitivity = 9;
  private static final int fieldNumberStart_time = 4;
  private static final int fieldNumberSubject = 2;
  public boolean allday_event = false;
  public long appointment_replytime = -9223372036854775808L;
  public LinkedList<CAttendee> attendees = new LinkedList();
  public String body;
  public int busyStatus;
  public LinkedList<String> categories = new LinkedList();
  public boolean deleted = false;
  public long dt_stamp = -9223372036854775808L;
  public long end_time = -9223372036854775808L;
  public long exception_start_time = -9223372036854775808L;
  public String location;
  public int meeting_status;
  public int reminder = 0;
  public int response_type;
  public int sensitivity;
  public long start_time = -9223372036854775808L;
  public String subject;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.deleted);
    int i = j;
    if (this.subject != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.subject);
    }
    j = i;
    if (this.exception_start_time != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(3, this.exception_start_time);
    }
    i = j;
    if (this.start_time != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(4, this.start_time);
    }
    j = i;
    if (this.end_time != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(5, this.end_time);
    }
    i = j;
    if (this.body != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.body);
    }
    j = i;
    if (this.location != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.location);
    }
    j = j + ComputeSizeUtil.computeListSize(8, 1, this.categories) + ComputeSizeUtil.computeIntegerSize(9, this.sensitivity) + ComputeSizeUtil.computeIntegerSize(10, this.busyStatus) + ComputeSizeUtil.computeBooleanSize(11, this.allday_event);
    i = j;
    if (this.reminder != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(12, this.reminder);
    }
    j = i;
    if (this.dt_stamp != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(13, this.dt_stamp);
    }
    j = j + ComputeSizeUtil.computeIntegerSize(14, this.meeting_status) + ComputeSizeUtil.computeListSize(15, 8, this.attendees);
    i = j;
    if (this.appointment_replytime != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(16, this.appointment_replytime);
    }
    return i + ComputeSizeUtil.computeIntegerSize(17, this.response_type);
  }
  
  public final CException parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.categories.clear();
    this.attendees.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CException paramCException, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCException.deleted = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramCException.subject = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCException.exception_start_time = paramInputReader.readLong(paramInt);
      return true;
    case 4: 
      paramCException.start_time = paramInputReader.readLong(paramInt);
      return true;
    case 5: 
      paramCException.end_time = paramInputReader.readLong(paramInt);
      return true;
    case 6: 
      paramCException.body = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramCException.location = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramCException.categories.add(paramInputReader.readString(paramInt));
      return true;
    case 9: 
      paramCException.sensitivity = paramInputReader.readInteger(paramInt);
      return true;
    case 10: 
      paramCException.busyStatus = paramInputReader.readInteger(paramInt);
      return true;
    case 11: 
      paramCException.allday_event = paramInputReader.readBoolean(paramInt);
      return true;
    case 12: 
      paramCException.reminder = paramInputReader.readInteger(paramInt);
      return true;
    case 13: 
      paramCException.dt_stamp = paramInputReader.readLong(paramInt);
      return true;
    case 14: 
      paramCException.meeting_status = paramInputReader.readInteger(paramInt);
      return true;
    case 15: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        CAttendee localCAttendee = new CAttendee();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localCAttendee.populateBuilderWithField((InputReader)localObject, localCAttendee, getNextFieldNumber((InputReader)localObject))) {}
        paramCException.attendees.add(localCAttendee);
        paramInt += 1;
      }
      return true;
    case 16: 
      paramCException.appointment_replytime = paramInputReader.readLong(paramInt);
      return true;
    }
    paramCException.response_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.deleted);
    if (this.subject != null) {
      paramOutputWriter.writeString(2, this.subject);
    }
    if (this.exception_start_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(3, this.exception_start_time);
    }
    if (this.start_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(4, this.start_time);
    }
    if (this.end_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(5, this.end_time);
    }
    if (this.body != null) {
      paramOutputWriter.writeString(6, this.body);
    }
    if (this.location != null) {
      paramOutputWriter.writeString(7, this.location);
    }
    paramOutputWriter.writeList(8, 1, this.categories);
    paramOutputWriter.writeInteger(9, this.sensitivity);
    paramOutputWriter.writeInteger(10, this.busyStatus);
    paramOutputWriter.writeBoolean(11, this.allday_event);
    if (this.reminder != -2147483648) {
      paramOutputWriter.writeInteger(12, this.reminder);
    }
    if (this.dt_stamp != -9223372036854775808L) {
      paramOutputWriter.writeLong(13, this.dt_stamp);
    }
    paramOutputWriter.writeInteger(14, this.meeting_status);
    paramOutputWriter.writeList(15, 8, this.attendees);
    if (this.appointment_replytime != -9223372036854775808L) {
      paramOutputWriter.writeLong(16, this.appointment_replytime);
    }
    paramOutputWriter.writeInteger(17, this.response_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CException
 * JD-Core Version:    0.7.0.1
 */