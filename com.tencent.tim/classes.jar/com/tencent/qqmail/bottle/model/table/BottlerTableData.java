package com.tencent.qqmail.bottle.model.table;

public final class BottlerTableData
{
  boolean anonymous;
  String avatar;
  String bigavatar;
  int isMine;
  String name;
  boolean sex;
  String uin;
  
  public void setAll(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.uin = paramString1;
    this.avatar = paramString2;
    this.bigavatar = paramString3;
    this.name = paramString4;
    this.anonymous = paramBoolean1;
    this.sex = paramBoolean2;
    this.isMine = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.model.table.BottlerTableData
 * JD-Core Version:    0.7.0.1
 */