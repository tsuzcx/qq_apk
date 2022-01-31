package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class MAutoDBItem
  extends IAutoDBItem
{
  public void convertFrom(Cursor paramCursor)
  {
    int j = 0;
    Object localObject = paramCursor.getColumnNames();
    if (localObject == null) {
      Log.e("MicroMsg.SDK.MAutoDBItem", "convertFrom: get column names failed");
    }
    int i;
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      i = 0;
      while (i < localObject.length)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      localObject = getDBInfo().fields;
      int k = localObject.length;
      i = j;
      for (;;)
      {
        if (i < k)
        {
          Field localField = localObject[i];
          String str = getColName(localField);
          if (!Util.isNullOrNil(str))
          {
            j = Util.nullAs((Integer)localHashMap.get(str), -1);
            if (j < 0) {}
          }
          try
          {
            CursorFieldHelper.setter(localField.getType()).invoke(localField, this, paramCursor, j);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      i = Util.nullAs((Integer)localHashMap.get("rowid"), -1);
    } while (i < 0);
    this.systemRowid = paramCursor.getLong(i);
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    Field[] arrayOfField = getDBInfo().fields;
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        try
        {
          CursorFieldHelper.getter(localField.getType()).invoke(localField, this, localContentValues);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MAutoDBItem
 * JD-Core Version:    0.7.0.1
 */