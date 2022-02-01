package com.tencent.token;

import android.database.Cursor;

public abstract interface ahi
  extends Cursor
{
  public abstract void close();
  
  public abstract byte[] getBlob(int paramInt);
  
  public abstract int getColumnCount();
  
  public abstract int getColumnIndex(String paramString);
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  public abstract double getDouble(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract int getType(int paramInt);
  
  public abstract boolean isAfterLast();
  
  public abstract boolean isLast();
  
  public abstract boolean moveToFirst();
  
  public abstract boolean moveToLast();
  
  public abstract boolean moveToNext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahi
 * JD-Core Version:    0.7.0.1
 */