package com.tencent.qqmail.bottle.model.table;

public final class BottleListTableData
{
  String bottleid;
  String city;
  String displaysummary;
  int distance;
  String emoji;
  String geo;
  boolean isMine;
  String summary;
  long time;
  int type;
  String uin;
  int unreadCnt;
  
  public void setAll(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, String paramString5, String paramString6, int paramInt3, boolean paramBoolean, String paramString7)
  {
    this.bottleid = paramString1;
    this.unreadCnt = paramInt1;
    this.summary = paramString2;
    this.displaysummary = paramString3;
    this.emoji = paramString4;
    this.time = paramLong;
    this.type = paramInt2;
    this.geo = paramString5;
    this.city = paramString6;
    this.distance = paramInt3;
    this.isMine = paramBoolean;
    this.uin = paramString7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleListTableData
 * JD-Core Version:    0.7.0.1
 */