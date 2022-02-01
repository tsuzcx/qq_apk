package com.tencent.qqmail.model.qmnote.storage;

public class QMNoteSQLiteItem
{
  public byte[] domain;
  public String itemId;
  public int type;
  public double updateTime = System.currentTimeMillis() / 1000L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmnote.storage.QMNoteSQLiteItem
 * JD-Core Version:    0.7.0.1
 */