package com.tencent.qqmail.bottle.model.table;

public final class BottleConversationTableData
{
  String audioUrl;
  String bottleid;
  String content;
  String contentheader;
  String displaycontent;
  String emoji;
  String imageUrl;
  boolean isMine;
  String msgid;
  long time;
  String uin;
  int unsend;
  
  public void setAll(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, String paramString7, String paramString8, int paramInt, String paramString9)
  {
    this.bottleid = paramString1;
    this.msgid = paramString2;
    this.time = paramLong;
    this.contentheader = paramString3;
    this.content = paramString4;
    this.displaycontent = paramString5;
    this.emoji = paramString6;
    this.isMine = paramBoolean;
    this.imageUrl = paramString7;
    this.audioUrl = paramString8;
    this.unsend = paramInt;
    this.uin = paramString9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottleConversationTableData
 * JD-Core Version:    0.7.0.1
 */