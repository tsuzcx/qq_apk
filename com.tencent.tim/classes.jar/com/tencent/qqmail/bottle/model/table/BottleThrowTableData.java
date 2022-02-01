package com.tencent.qqmail.bottle.model.table;

public final class BottleThrowTableData
{
  String bottleid;
  String city;
  String geo;
  int throwtype;
  
  public void setAll(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.bottleid = paramString1;
    this.geo = paramString2;
    this.city = paramString3;
    this.throwtype = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleThrowTableData
 * JD-Core Version:    0.7.0.1
 */