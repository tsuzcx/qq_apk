package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CRecurrence
  extends BaseProtoBuf
{
  private static final int fieldNumberCalendar_type = 9;
  private static final int fieldNumberDay_of_month = 8;
  private static final int fieldNumberDay_of_week = 5;
  private static final int fieldNumberFirst_day_of_week = 11;
  private static final int fieldNumberInterval = 3;
  private static final int fieldNumberIs_leap_month = 10;
  private static final int fieldNumberMonth_of_year = 6;
  private static final int fieldNumberOccurrences = 2;
  private static final int fieldNumberType = 1;
  private static final int fieldNumberUntil = 7;
  private static final int fieldNumberWeek_of_month = 4;
  public int calendar_type;
  public long day_of_month = 0L;
  public long day_of_week = 0L;
  public int first_day_of_week;
  public long interval = 0L;
  public boolean is_leap_month = false;
  public long month_of_year = 0L;
  public long occurrences = 0L;
  public int type;
  public long until = 0L;
  public long week_of_month = 0L;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.occurrences != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.occurrences);
    }
    j = i;
    if (this.interval != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(3, this.interval);
    }
    i = j;
    if (this.week_of_month != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(4, this.week_of_month);
    }
    j = i;
    if (this.day_of_week != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(5, this.day_of_week);
    }
    i = j;
    if (this.month_of_year != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(6, this.month_of_year);
    }
    j = i;
    if (this.until != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(7, this.until);
    }
    i = j;
    if (this.day_of_month != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(8, this.day_of_month);
    }
    return i + ComputeSizeUtil.computeIntegerSize(9, this.calendar_type) + ComputeSizeUtil.computeBooleanSize(10, this.is_leap_month) + ComputeSizeUtil.computeIntegerSize(11, this.first_day_of_week);
  }
  
  public final CRecurrence parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CRecurrence paramCRecurrence, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCRecurrence.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCRecurrence.occurrences = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramCRecurrence.interval = paramInputReader.readLong(paramInt);
      return true;
    case 4: 
      paramCRecurrence.week_of_month = paramInputReader.readLong(paramInt);
      return true;
    case 5: 
      paramCRecurrence.day_of_week = paramInputReader.readLong(paramInt);
      return true;
    case 6: 
      paramCRecurrence.month_of_year = paramInputReader.readLong(paramInt);
      return true;
    case 7: 
      paramCRecurrence.until = paramInputReader.readLong(paramInt);
      return true;
    case 8: 
      paramCRecurrence.day_of_month = paramInputReader.readLong(paramInt);
      return true;
    case 9: 
      paramCRecurrence.calendar_type = paramInputReader.readInteger(paramInt);
      return true;
    case 10: 
      paramCRecurrence.is_leap_month = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramCRecurrence.first_day_of_week = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.occurrences != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.occurrences);
    }
    if (this.interval != -9223372036854775808L) {
      paramOutputWriter.writeLong(3, this.interval);
    }
    if (this.week_of_month != -9223372036854775808L) {
      paramOutputWriter.writeLong(4, this.week_of_month);
    }
    if (this.day_of_week != -9223372036854775808L) {
      paramOutputWriter.writeLong(5, this.day_of_week);
    }
    if (this.month_of_year != -9223372036854775808L) {
      paramOutputWriter.writeLong(6, this.month_of_year);
    }
    if (this.until != -9223372036854775808L) {
      paramOutputWriter.writeLong(7, this.until);
    }
    if (this.day_of_month != -9223372036854775808L) {
      paramOutputWriter.writeLong(8, this.day_of_month);
    }
    paramOutputWriter.writeInteger(9, this.calendar_type);
    paramOutputWriter.writeBoolean(10, this.is_leap_month);
    paramOutputWriter.writeInteger(11, this.first_day_of_week);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.CRecurrence
 * JD-Core Version:    0.7.0.1
 */