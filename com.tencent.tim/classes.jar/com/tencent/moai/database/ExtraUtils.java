package com.tencent.moai.database;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.moai.database.sqlite.CursorWindow;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class ExtraUtils
{
  private static final boolean DEBUG = false;
  public static final int STATEMENT_ABORT = 6;
  public static final int STATEMENT_ATTACH = 3;
  public static final int STATEMENT_BEGIN = 4;
  public static final int STATEMENT_COMMIT = 5;
  public static final int STATEMENT_DDL = 8;
  public static final int STATEMENT_DETACH = 10;
  public static final int STATEMENT_OTHER = 99;
  public static final int STATEMENT_PRAGMA = 7;
  public static final int STATEMENT_SELECT = 1;
  public static final int STATEMENT_UNPREPARED = 9;
  public static final int STATEMENT_UPDATE = 2;
  private static final String TAG = "ExtraUtils";
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if ((paramInt < 0) || (paramInt >= paramCursor.getCount())) {
      return;
    }
    int j = paramCursor.getPosition();
    int k = paramCursor.getColumnCount();
    paramCursorWindow.clear();
    paramCursorWindow.setStartPosition(paramInt);
    paramCursorWindow.setNumColumns(k);
    if (paramCursor.moveToPosition(paramInt))
    {
      if (paramCursorWindow.allocRow()) {}
    }
    else
    {
      label64:
      paramCursor.moveToPosition(j);
      return;
    }
    int i = 0;
    for (;;)
    {
      Object localObject;
      boolean bool;
      if (i < k) {
        switch (paramCursor.getType(i))
        {
        case 3: 
        default: 
          localObject = paramCursor.getString(i);
          if (localObject != null) {
            bool = paramCursorWindow.putString((String)localObject, paramInt, i);
          }
          break;
        }
      }
      for (;;)
      {
        if (bool) {
          break label269;
        }
        paramCursorWindow.freeLastRow();
        paramInt += 1;
        if (paramCursor.moveToNext()) {
          break;
        }
        break label64;
        bool = paramCursorWindow.putNull(paramInt, i);
        continue;
        bool = paramCursorWindow.putLong(paramCursor.getLong(i), paramInt, i);
        continue;
        bool = paramCursorWindow.putDouble(paramCursor.getDouble(i), paramInt, i);
        continue;
        localObject = paramCursor.getBlob(i);
        if (localObject != null)
        {
          bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);
        }
        else
        {
          bool = paramCursorWindow.putNull(paramInt, i);
          continue;
          bool = paramCursorWindow.putNull(paramInt, i);
        }
      }
      label269:
      i += 1;
    }
  }
  
  public static int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static int getSqlStatementType(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {}
    do
    {
      return 99;
      paramString = paramString.substring(0, 3).toUpperCase(Locale.ROOT);
      if (paramString.equals("SEL")) {
        return 1;
      }
      if ((paramString.equals("INS")) || (paramString.equals("UPD")) || (paramString.equals("REP")) || (paramString.equals("DEL"))) {
        return 2;
      }
      if (paramString.equals("ATT")) {
        return 3;
      }
      if (paramString.equals("COM")) {
        return 5;
      }
      if (paramString.equals("END")) {
        return 5;
      }
      if (paramString.equals("ROL")) {
        return 6;
      }
      if (paramString.equals("BEG")) {
        return 4;
      }
      if (paramString.equals("PRA")) {
        return 7;
      }
      if ((paramString.equals("CRE")) || (paramString.equals("DRO")) || (paramString.equals("ALT"))) {
        return 8;
      }
      if (paramString.equals("ANA")) {
        return 9;
      }
    } while (!paramString.equals("DET"));
    return 10;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return 2;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte))) {
      return 1;
    }
    return 3;
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    return paramSQLiteStatement.simpleQueryForLong();
  }
  
  public static HashMap<String, Object> toHashMap(ContentValues paramContentValues)
  {
    paramContentValues = paramContentValues.valueSet().iterator();
    HashMap localHashMap = new HashMap();
    while (paramContentValues.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContentValues.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.database.ExtraUtils
 * JD-Core Version:    0.7.0.1
 */