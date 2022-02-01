package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CCalendar
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 24;
  private static final int fieldNumberAllday_event = 1;
  private static final int fieldNumberAppointment_replytime = 2;
  private static final int fieldNumberAttendees = 3;
  private static final int fieldNumberBody = 4;
  private static final int fieldNumberBusy_status = 20;
  private static final int fieldNumberCalendar_type = 35;
  private static final int fieldNumberCategories = 31;
  private static final int fieldNumberCid = 23;
  private static final int fieldNumberCloud_id = 33;
  private static final int fieldNumberCreate_time = 8;
  private static final int fieldNumberDt_stamp = 32;
  private static final int fieldNumberEnd_time = 7;
  private static final int fieldNumberEtag_ = 30;
  private static final int fieldNumberExceptions = 5;
  private static final int fieldNumberFolder_id_ = 27;
  private static final int fieldNumberIs_in_user_folder = 26;
  private static final int fieldNumberLocation = 10;
  private static final int fieldNumberMeeting_status = 11;
  private static final int fieldNumberModified_time = 9;
  private static final int fieldNumberNative_body_type = 12;
  private static final int fieldNumberOrganizer_email = 13;
  private static final int fieldNumberOrganizer_name = 14;
  private static final int fieldNumberPath_ = 29;
  private static final int fieldNumberRecurrence = 15;
  private static final int fieldNumberRelative_id = 34;
  private static final int fieldNumberReminder = 16;
  private static final int fieldNumberResponse_requested = 17;
  private static final int fieldNumberResponse_type = 18;
  private static final int fieldNumberSensitivity = 19;
  private static final int fieldNumberServer_id = 25;
  private static final int fieldNumberStart_time = 6;
  private static final int fieldNumberSubject = 21;
  private static final int fieldNumberTime_zone_ = 28;
  private static final int fieldNumberUid = 22;
  public long account_id = -1L;
  public boolean allday_event = false;
  public long appointment_replytime = -9223372036854775808L;
  public LinkedList<CAttendee> attendees = new LinkedList();
  public String body;
  public int busy_status;
  public int calendar_type;
  public LinkedList<String> categories = new LinkedList();
  public long cid = -1L;
  public String cloud_id;
  public long create_time = -9223372036854775808L;
  public long dt_stamp = -9223372036854775808L;
  public long end_time = -9223372036854775808L;
  public String etag_;
  public LinkedList<CException> exceptions = new LinkedList();
  public String folder_id_;
  public boolean is_in_user_folder = false;
  public String location;
  public int meeting_status;
  public long modified_time = -9223372036854775808L;
  public int native_body_type;
  public String organizer_email;
  public String organizer_name;
  public String path_;
  public CRecurrence recurrence;
  public String relative_id;
  public long reminder = -1L;
  public boolean response_requested = false;
  public int response_type;
  public int sensitivity;
  public String server_id;
  public long start_time = -9223372036854775808L;
  public String subject;
  public String time_zone_;
  public String uid;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.allday_event);
    int i = j;
    if (this.appointment_replytime != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.appointment_replytime);
    }
    j = i + ComputeSizeUtil.computeListSize(3, 8, this.attendees);
    i = j;
    if (this.body != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.body);
    }
    j = i + ComputeSizeUtil.computeListSize(5, 8, this.exceptions);
    i = j;
    if (this.start_time != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(6, this.start_time);
    }
    j = i;
    if (this.end_time != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(7, this.end_time);
    }
    i = j;
    if (this.create_time != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(8, this.create_time);
    }
    j = i;
    if (this.modified_time != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(9, this.modified_time);
    }
    i = j;
    if (this.location != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.location);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(11, this.meeting_status) + ComputeSizeUtil.computeIntegerSize(12, this.native_body_type);
    i = j;
    if (this.organizer_email != null) {
      i = j + ComputeSizeUtil.computeStringSize(13, this.organizer_email);
    }
    j = i;
    if (this.organizer_name != null) {
      j = i + ComputeSizeUtil.computeStringSize(14, this.organizer_name);
    }
    i = j;
    if (this.recurrence != null) {
      i = j + ComputeSizeUtil.computeMessageSize(15, this.recurrence.computeSize());
    }
    j = i;
    if (this.reminder != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(16, this.reminder);
    }
    j = j + ComputeSizeUtil.computeBooleanSize(17, this.response_requested) + ComputeSizeUtil.computeIntegerSize(18, this.response_type) + ComputeSizeUtil.computeIntegerSize(19, this.sensitivity) + ComputeSizeUtil.computeIntegerSize(20, this.busy_status);
    i = j;
    if (this.subject != null) {
      i = j + ComputeSizeUtil.computeStringSize(21, this.subject);
    }
    j = i;
    if (this.uid != null) {
      j = i + ComputeSizeUtil.computeStringSize(22, this.uid);
    }
    i = j;
    if (this.cid != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(23, this.cid);
    }
    j = i;
    if (this.account_id != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(24, this.account_id);
    }
    i = j;
    if (this.server_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(25, this.server_id);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(26, this.is_in_user_folder);
    i = j;
    if (this.folder_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(27, this.folder_id_);
    }
    j = i;
    if (this.time_zone_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(28, this.time_zone_);
    }
    i = j;
    if (this.path_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(29, this.path_);
    }
    j = i;
    if (this.etag_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(30, this.etag_);
    }
    j += ComputeSizeUtil.computeListSize(31, 1, this.categories);
    i = j;
    if (this.dt_stamp != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(32, this.dt_stamp);
    }
    j = i;
    if (this.cloud_id != null) {
      j = i + ComputeSizeUtil.computeStringSize(33, this.cloud_id);
    }
    i = j;
    if (this.relative_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(34, this.relative_id);
    }
    return i + ComputeSizeUtil.computeIntegerSize(35, this.calendar_type);
  }
  
  public final CCalendar parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.attendees.clear();
    this.exceptions.clear();
    this.categories.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CCalendar paramCCalendar, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCCalendar.allday_event = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramCCalendar.appointment_replytime = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CAttendee();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CAttendee)localObject1).populateBuilderWithField((InputReader)localObject2, (CAttendee)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCCalendar.attendees.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 4: 
      paramCCalendar.body = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CException();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CException)localObject1).populateBuilderWithField((InputReader)localObject2, (CException)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCCalendar.exceptions.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 6: 
      paramCCalendar.start_time = paramInputReader.readLong(paramInt);
      return true;
    case 7: 
      paramCCalendar.end_time = paramInputReader.readLong(paramInt);
      return true;
    case 8: 
      paramCCalendar.create_time = paramInputReader.readLong(paramInt);
      return true;
    case 9: 
      paramCCalendar.modified_time = paramInputReader.readLong(paramInt);
      return true;
    case 10: 
      paramCCalendar.location = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramCCalendar.meeting_status = paramInputReader.readInteger(paramInt);
      return true;
    case 12: 
      paramCCalendar.native_body_type = paramInputReader.readInteger(paramInt);
      return true;
    case 13: 
      paramCCalendar.organizer_email = paramInputReader.readString(paramInt);
      return true;
    case 14: 
      paramCCalendar.organizer_name = paramInputReader.readString(paramInt);
      return true;
    case 15: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CRecurrence();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CRecurrence)localObject1).populateBuilderWithField((InputReader)localObject2, (CRecurrence)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCCalendar.recurrence = ((CRecurrence)localObject1);
        paramInt += 1;
      }
      return true;
    case 16: 
      paramCCalendar.reminder = paramInputReader.readLong(paramInt);
      return true;
    case 17: 
      paramCCalendar.response_requested = paramInputReader.readBoolean(paramInt);
      return true;
    case 18: 
      paramCCalendar.response_type = paramInputReader.readInteger(paramInt);
      return true;
    case 19: 
      paramCCalendar.sensitivity = paramInputReader.readInteger(paramInt);
      return true;
    case 20: 
      paramCCalendar.busy_status = paramInputReader.readInteger(paramInt);
      return true;
    case 21: 
      paramCCalendar.subject = paramInputReader.readString(paramInt);
      return true;
    case 22: 
      paramCCalendar.uid = paramInputReader.readString(paramInt);
      return true;
    case 23: 
      paramCCalendar.cid = paramInputReader.readLong(paramInt);
      return true;
    case 24: 
      paramCCalendar.account_id = paramInputReader.readLong(paramInt);
      return true;
    case 25: 
      paramCCalendar.server_id = paramInputReader.readString(paramInt);
      return true;
    case 26: 
      paramCCalendar.is_in_user_folder = paramInputReader.readBoolean(paramInt);
      return true;
    case 27: 
      paramCCalendar.folder_id_ = paramInputReader.readString(paramInt);
      return true;
    case 28: 
      paramCCalendar.time_zone_ = paramInputReader.readString(paramInt);
      return true;
    case 29: 
      paramCCalendar.path_ = paramInputReader.readString(paramInt);
      return true;
    case 30: 
      paramCCalendar.etag_ = paramInputReader.readString(paramInt);
      return true;
    case 31: 
      paramCCalendar.categories.add(paramInputReader.readString(paramInt));
      return true;
    case 32: 
      paramCCalendar.dt_stamp = paramInputReader.readLong(paramInt);
      return true;
    case 33: 
      paramCCalendar.cloud_id = paramInputReader.readString(paramInt);
      return true;
    case 34: 
      paramCCalendar.relative_id = paramInputReader.readString(paramInt);
      return true;
    }
    paramCCalendar.calendar_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.allday_event);
    if (this.appointment_replytime != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.appointment_replytime);
    }
    paramOutputWriter.writeList(3, 8, this.attendees);
    if (this.body != null) {
      paramOutputWriter.writeString(4, this.body);
    }
    paramOutputWriter.writeList(5, 8, this.exceptions);
    if (this.start_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(6, this.start_time);
    }
    if (this.end_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(7, this.end_time);
    }
    if (this.create_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(8, this.create_time);
    }
    if (this.modified_time != -9223372036854775808L) {
      paramOutputWriter.writeLong(9, this.modified_time);
    }
    if (this.location != null) {
      paramOutputWriter.writeString(10, this.location);
    }
    paramOutputWriter.writeInteger(11, this.meeting_status);
    paramOutputWriter.writeInteger(12, this.native_body_type);
    if (this.organizer_email != null) {
      paramOutputWriter.writeString(13, this.organizer_email);
    }
    if (this.organizer_name != null) {
      paramOutputWriter.writeString(14, this.organizer_name);
    }
    if (this.recurrence != null)
    {
      paramOutputWriter.writeMessage(15, this.recurrence.computeSize());
      this.recurrence.writeFields(paramOutputWriter);
    }
    if (this.reminder != -9223372036854775808L) {
      paramOutputWriter.writeLong(16, this.reminder);
    }
    paramOutputWriter.writeBoolean(17, this.response_requested);
    paramOutputWriter.writeInteger(18, this.response_type);
    paramOutputWriter.writeInteger(19, this.sensitivity);
    paramOutputWriter.writeInteger(20, this.busy_status);
    if (this.subject != null) {
      paramOutputWriter.writeString(21, this.subject);
    }
    if (this.uid != null) {
      paramOutputWriter.writeString(22, this.uid);
    }
    if (this.cid != -9223372036854775808L) {
      paramOutputWriter.writeLong(23, this.cid);
    }
    if (this.account_id != -9223372036854775808L) {
      paramOutputWriter.writeLong(24, this.account_id);
    }
    if (this.server_id != null) {
      paramOutputWriter.writeString(25, this.server_id);
    }
    paramOutputWriter.writeBoolean(26, this.is_in_user_folder);
    if (this.folder_id_ != null) {
      paramOutputWriter.writeString(27, this.folder_id_);
    }
    if (this.time_zone_ != null) {
      paramOutputWriter.writeString(28, this.time_zone_);
    }
    if (this.path_ != null) {
      paramOutputWriter.writeString(29, this.path_);
    }
    if (this.etag_ != null) {
      paramOutputWriter.writeString(30, this.etag_);
    }
    paramOutputWriter.writeList(31, 1, this.categories);
    if (this.dt_stamp != -9223372036854775808L) {
      paramOutputWriter.writeLong(32, this.dt_stamp);
    }
    if (this.cloud_id != null) {
      paramOutputWriter.writeString(33, this.cloud_id);
    }
    if (this.relative_id != null) {
      paramOutputWriter.writeString(34, this.relative_id);
    }
    paramOutputWriter.writeInteger(35, this.calendar_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CCalendar
 * JD-Core Version:    0.7.0.1
 */