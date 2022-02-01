package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;
import java.util.List;

public class TraceStatistics
{
  public final List<Record> records;
  
  public TraceStatistics(List<Record> paramList)
  {
    this.records = paramList;
  }
  
  public static final class Record
  {
    @NonNull
    public final String name;
    public final long timeUs;
    
    public Record(@NonNull String paramString, long paramLong)
    {
      this.name = paramString;
      this.timeUs = paramLong;
    }
    
    public String toString()
    {
      return "Record{name='" + this.name + '\'' + ", timeUs=" + this.timeUs + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.TraceStatistics
 * JD-Core Version:    0.7.0.1
 */