package com.tencent.qqmail.bottle.model.table;

public final class BottleBeachTableData
{
  String adurl;
  String bottleid;
  String city;
  String content;
  String contentheader;
  long convsvrtime;
  String displaycontent;
  int distance;
  String emoji;
  String geo;
  String imageurl;
  int number;
  String subject;
  int tagcolor;
  long time;
  int type;
  String uin;
  
  public void setAll(String paramString1, int paramInt1, String paramString2, long paramLong1, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt3, String paramString10, long paramLong2, int paramInt4, String paramString11)
  {
    this.bottleid = paramString1;
    this.type = paramInt1;
    this.subject = paramString2;
    this.time = paramLong1;
    this.geo = paramString3;
    this.city = paramString4;
    this.distance = paramInt2;
    this.contentheader = paramString5;
    this.content = paramString6;
    this.displaycontent = paramString7;
    this.emoji = paramString8;
    this.imageurl = paramString9;
    this.number = paramInt3;
    this.uin = paramString10;
    this.convsvrtime = paramLong2;
    this.tagcolor = paramInt4;
    this.adurl = paramString11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleBeachTableData
 * JD-Core Version:    0.7.0.1
 */