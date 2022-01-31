package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;

public abstract interface MDBItem
{
  public abstract void convertFrom(Cursor paramCursor);
  
  public abstract ContentValues convertTo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MDBItem
 * JD-Core Version:    0.7.0.1
 */