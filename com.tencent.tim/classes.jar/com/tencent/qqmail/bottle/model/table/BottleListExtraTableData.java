package com.tencent.qqmail.bottle.model.table;

public final class BottleListExtraTableData
{
  String bottleid;
  long convdbtimestamp;
  boolean convoverdue;
  long convsvrtime;
  int total;
  
  public void setAll(String paramString, int paramInt, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    this.bottleid = paramString;
    this.total = paramInt;
    this.convsvrtime = paramLong1;
    this.convoverdue = paramBoolean;
    this.convdbtimestamp = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListExtraTableData
 * JD-Core Version:    0.7.0.1
 */