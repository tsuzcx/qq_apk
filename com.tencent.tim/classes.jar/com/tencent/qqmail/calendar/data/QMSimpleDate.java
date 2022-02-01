package com.tencent.qqmail.calendar.data;

public class QMSimpleDate
{
  private int day;
  private int month;
  private int year;
  
  public QMSimpleDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void setYear(int paramInt)
  {
    this.year = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMSimpleDate
 * JD-Core Version:    0.7.0.1
 */