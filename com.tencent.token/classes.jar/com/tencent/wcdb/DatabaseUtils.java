package com.tencent.wcdb;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;

public final class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int EX_HAS_REPLY_HEADER = -128;
  public static final int STATEMENT_ABORT = 6;
  public static final int STATEMENT_ATTACH = 3;
  public static final int STATEMENT_BEGIN = 4;
  public static final int STATEMENT_COMMIT = 5;
  public static final int STATEMENT_DDL = 8;
  public static final int STATEMENT_OTHER = 99;
  public static final int STATEMENT_PRAGMA = 7;
  public static final int STATEMENT_SELECT = 1;
  public static final int STATEMENT_UNPREPARED = 9;
  public static final int STATEMENT_UPDATE = 2;
  private static final String TAG = "WCDB.DatabaseUtils";
  private static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
        i += 1;
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static String[] appendSelectionArgs(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1 != null)
    {
      if (paramArrayOfString1.length == 0) {
        return paramArrayOfString2;
      }
      String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
      System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
      System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
      return arrayOfString;
    }
    return paramArrayOfString2;
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("NULL");
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        paramStringBuilder.append('1');
        return;
      }
      paramStringBuilder.append('0');
      return;
    }
    appendEscapedSQLString(paramStringBuilder, paramObject.toString());
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      paramSQLiteProgram.bindNull(paramInt);
      return;
    }
    if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float)))
    {
      if ((paramObject instanceof Number))
      {
        paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          paramSQLiteProgram.bindLong(paramInt, 1L);
          return;
        }
        paramSQLiteProgram.bindLong(paramInt, 0L);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
        return;
      }
      paramSQLiteProgram.bindString(paramInt, paramObject.toString());
      return;
    }
    paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(") AND (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    createDbFromSqlStatements(paramContext, paramString1, null, null, paramInt, paramString2);
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, String paramString2)
  {
    paramContext = com.tencent.wcdb.support.Context.openOrCreateDatabase(paramContext, paramString1, paramArrayOfByte, paramSQLiteCipherSpec, 0, null);
    paramString1 = TextUtils.split(paramString2, ";\n");
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte = paramString1[i];
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        paramContext.execSQL(paramArrayOfByte);
      }
      i += 1;
    }
    paramContext.setVersion(paramInt);
    paramContext.close();
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
      return;
    }
    paramContentValues.put(paramString2, (Double)null);
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= paramCursor.getCount()) {
        return;
      }
      int j = paramCursor.getPosition();
      int k = paramCursor.getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(k);
      if (paramCursor.moveToPosition(paramInt)) {
        do
        {
          if (!paramCursorWindow.allocRow()) {
            break;
          }
          int i = 0;
          while (i < k)
          {
            int m = paramCursor.getType(i);
            Object localObject;
            boolean bool;
            if (m != 4)
            {
              switch (m)
              {
              default: 
                localObject = paramCursor.getString(i);
                if (localObject != null) {
                  bool = paramCursorWindow.putString((String)localObject, paramInt, i);
                } else {
                  bool = paramCursorWindow.putNull(paramInt, i);
                }
                break;
              case 2: 
                bool = paramCursorWindow.putDouble(paramCursor.getDouble(i), paramInt, i);
                break;
              case 1: 
                bool = paramCursorWindow.putLong(paramCursor.getLong(i), paramInt, i);
                break;
              case 0: 
                bool = paramCursorWindow.putNull(paramInt, i);
                break;
              }
            }
            else
            {
              localObject = paramCursor.getBlob(i);
              if (localObject != null) {
                bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);
              } else {
                bool = paramCursorWindow.putNull(paramInt, i);
              }
            }
            if (!bool)
            {
              paramCursorWindow.freeLastRow();
              break;
            }
            i += 1;
          }
          paramInt += 1;
        } while (paramCursor.moveToNext());
      }
      paramCursor.moveToPosition(j);
      return;
    }
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
      return;
    }
    paramContentValues.put(paramString2, (Integer)null);
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
      return;
    }
    paramContentValues.put(paramString2, (Long)null);
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
  }
  
  public static int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AbstractWindowedCursor localAbstractWindowedCursor;
    if ((paramCursor instanceof AbstractWindowedCursor)) {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
    } else {
      localAbstractWindowedCursor = null;
    }
    String[] arrayOfString = paramCursor.getColumnNames();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ((localAbstractWindowedCursor != null) && (localAbstractWindowedCursor.isBlob(i))) {
        paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
      } else {
        paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
      }
      i += 1;
    }
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    dumpCurrentRow(paramCursor, System.out);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {");
    paramPrintStream.println(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        label79:
        StringBuilder localStringBuilder;
        break label79;
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      paramPrintStream.println(localStringBuilder.toString());
      i += 1;
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {\n");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        label80:
        StringBuilder localStringBuilder;
        break label80;
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      paramStringBuilder.append(localStringBuilder.toString());
      i += 1;
    }
    paramStringBuilder.append("}\n");
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    dumpCursor(paramCursor, System.out);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    paramPrintStream.println(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    localStringBuilder.append("\n");
    paramStringBuilder.append(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar1 = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      char[] arrayOfChar2 = DIGITS;
      arrayOfChar1[j] = arrayOfChar2[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar1[m] = arrayOfChar2[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar1;
  }
  
  private static int extractSqlCode(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      int m = paramString.charAt(i);
      int k;
      if ((m >= 97) && (m <= 122))
      {
        k = m - 97 + 65;
      }
      else
      {
        k = m;
        if (m >= 128) {
          return 0;
        }
      }
      j |= (k & 0x7F) << i * 8;
      i += 1;
    }
    return j;
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
  
  public static String getCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new String(paramString, 0, getKeyLen(paramString), "ISO8859_1");
      return paramString;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    return "";
  }
  
  private static byte[] getCollationKeyInBytes(String paramString)
  {
    if (mColl == null)
    {
      mColl = Collator.getInstance();
      mColl.setStrength(0);
    }
    return mColl.getCollationKey(paramString).toByteArray();
  }
  
  public static String getHexCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    return new String(encodeHex(paramString), 0, getKeyLen(paramString) * 2);
  }
  
  private static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {
      return paramArrayOfByte.length;
    }
    return paramArrayOfByte.length - 1;
  }
  
  public static int getSqlStatementType(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {
      return 99;
    }
    switch (extractSqlCode(paramString))
    {
    default: 
      return 99;
    case 5526593: 
      return 3;
    case 5001042: 
      return 6;
    case 4998483: 
      return 1;
    case 4670786: 
      return 4;
    case 4543043: 
    case 5198404: 
    case 5524545: 
      return 8;
    case 4477013: 
    case 4998468: 
    case 5260626: 
    case 5459529: 
      return 2;
    case 4476485: 
    case 5066563: 
      return 5;
    case 4280912: 
      return 7;
    }
    return 9;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Byte))) {
        return 3;
      }
      return 1;
    }
    return 2;
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
  
  public static boolean objectEquals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean queryIsEmpty(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select exists(select 1 from ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    return longForQuery(paramSQLiteDatabase, localStringBuilder.toString(), null) == 0L;
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return queryNumEntries(paramSQLiteDatabase, paramString, null, null);
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    return queryNumEntries(paramSQLiteDatabase, paramString1, paramString2, null);
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" where ");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
    }
    else
    {
      paramString2 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(*) from ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return longForQuery(paramSQLiteDatabase, localStringBuilder.toString(), paramArrayOfString);
  }
  
  private static final int readExceptionCode(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -128)
    {
      if (paramParcel.readInt() == 0) {
        Log.e("WCDB.DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
      }
      return 0;
    }
    return i;
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    int i = readExceptionCode(paramParcel);
    if (i == 0) {
      return;
    }
    readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
  }
  
  private static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 11: 
      throw new OperationCanceledException(paramString);
    case 9: 
      throw new SQLiteException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
  {
    int i = readExceptionCode(paramParcel);
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 1)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new FileNotFoundException(str);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
  {
    int i = readExceptionCode(paramParcel);
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 10)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new OperationApplicationException(str);
  }
  
  public static String sqlEscapeString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    return paramSQLiteStatement.simpleQueryForString();
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    int i;
    int j;
    if ((paramException instanceof FileNotFoundException))
    {
      i = 1;
      j = 0;
    }
    else if ((paramException instanceof IllegalArgumentException))
    {
      i = 2;
      j = 1;
    }
    else if ((paramException instanceof UnsupportedOperationException))
    {
      i = 3;
      j = 1;
    }
    else if ((paramException instanceof SQLiteAbortException))
    {
      i = 4;
      j = 1;
    }
    else if ((paramException instanceof SQLiteConstraintException))
    {
      i = 5;
      j = 1;
    }
    else if ((paramException instanceof SQLiteDatabaseCorruptException))
    {
      i = 6;
      j = 1;
    }
    else if ((paramException instanceof SQLiteFullException))
    {
      i = 7;
      j = 1;
    }
    else if ((paramException instanceof SQLiteDiskIOException))
    {
      i = 8;
      j = 1;
    }
    else if ((paramException instanceof SQLiteException))
    {
      i = 9;
      j = 1;
    }
    else if ((paramException instanceof OperationApplicationException))
    {
      i = 10;
      j = 1;
    }
    else
    {
      if (!(paramException instanceof OperationCanceledException)) {
        break label191;
      }
      i = 11;
      j = 0;
    }
    paramParcel.writeInt(i);
    paramParcel.writeString(paramException.getMessage());
    if (j != 0) {
      Log.e("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
    }
    return;
    label191:
    paramParcel.writeException(paramException);
    Log.e("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
  }
  
  @Deprecated
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    private HashMap<String, Integer> mColumns;
    private final SQLiteDatabase mDb;
    private String mInsertSQL = null;
    private SQLiteStatement mInsertStatement = null;
    private SQLiteStatement mPreparedStatement = null;
    private SQLiteStatement mReplaceStatement = null;
    private final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      this.mDb = paramSQLiteDatabase;
      this.mTableName = paramString;
    }
    
    private void buildSQL()
    {
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append("INSERT INTO ");
      localStringBuilder1.append(this.mTableName);
      localStringBuilder1.append(" (");
      StringBuilder localStringBuilder2 = new StringBuilder(128);
      localStringBuilder2.append("VALUES (");
      String str1 = null;
      Object localObject1 = str1;
      for (;;)
      {
        try
        {
          Object localObject3 = this.mDb;
          localObject1 = str1;
          Object localObject4 = new StringBuilder();
          localObject1 = str1;
          ((StringBuilder)localObject4).append("PRAGMA table_info(");
          localObject1 = str1;
          ((StringBuilder)localObject4).append(this.mTableName);
          localObject1 = str1;
          ((StringBuilder)localObject4).append(")");
          localObject1 = str1;
          localObject3 = ((SQLiteDatabase)localObject3).rawQuery(((StringBuilder)localObject4).toString(), null);
          localObject1 = localObject3;
          this.mColumns = new HashMap(((Cursor)localObject3).getCount());
          int i = 1;
          localObject1 = localObject3;
          if (((Cursor)localObject3).moveToNext())
          {
            localObject1 = localObject3;
            str1 = ((Cursor)localObject3).getString(1);
            localObject1 = localObject3;
            localObject4 = ((Cursor)localObject3).getString(4);
            localObject1 = localObject3;
            this.mColumns.put(str1, Integer.valueOf(i));
            localObject1 = localObject3;
            localStringBuilder1.append("'");
            localObject1 = localObject3;
            localStringBuilder1.append(str1);
            localObject1 = localObject3;
            localStringBuilder1.append("'");
            if (localObject4 == null)
            {
              localObject1 = localObject3;
              localStringBuilder2.append("?");
            }
            else
            {
              localObject1 = localObject3;
              localStringBuilder2.append("COALESCE(?, ");
              localObject1 = localObject3;
              localStringBuilder2.append((String)localObject4);
              localObject1 = localObject3;
              localStringBuilder2.append(")");
            }
            localObject1 = localObject3;
            if (i == ((Cursor)localObject3).getCount())
            {
              str1 = ") ";
              localObject1 = localObject3;
              localStringBuilder1.append(str1);
              localObject1 = localObject3;
              if (i != ((Cursor)localObject3).getCount()) {
                break label403;
              }
              str1 = ");";
              localObject1 = localObject3;
              localStringBuilder2.append(str1);
              i += 1;
            }
          }
          else
          {
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            localStringBuilder1.append(localStringBuilder2);
            this.mInsertSQL = localStringBuilder1.toString();
            return;
          }
        }
        finally
        {
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
        }
        String str2 = ", ";
        continue;
        label403:
        str2 = ", ";
      }
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (this.mReplaceStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("INSERT OR REPLACE");
          ((StringBuilder)localObject).append(this.mInsertSQL.substring(6));
          localObject = ((StringBuilder)localObject).toString();
          this.mReplaceStatement = this.mDb.compileStatement((String)localObject);
        }
        return this.mReplaceStatement;
      }
      if (this.mInsertStatement == null)
      {
        if (this.mInsertSQL == null) {
          buildSQL();
        }
        this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
      }
      return this.mInsertStatement;
    }
    
    /* Error */
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   4: invokevirtual 143	com/tencent/wcdb/database/SQLiteDatabase:beginTransactionNonExclusive	()V
      //   7: aload_0
      //   8: iload_2
      //   9: invokespecial 145	com/tencent/wcdb/DatabaseUtils$InsertHelper:getStatement	(Z)Lcom/tencent/wcdb/database/SQLiteStatement;
      //   12: astore 5
      //   14: aload 5
      //   16: invokevirtual 150	com/tencent/wcdb/database/SQLiteStatement:clearBindings	()V
      //   19: aload_1
      //   20: invokevirtual 156	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   23: invokeinterface 162 1 0
      //   28: astore 6
      //   30: aload 6
      //   32: invokeinterface 167 1 0
      //   37: ifeq +44 -> 81
      //   40: aload 6
      //   42: invokeinterface 171 1 0
      //   47: checkcast 173	java/util/Map$Entry
      //   50: astore 7
      //   52: aload 5
      //   54: aload_0
      //   55: aload 7
      //   57: invokeinterface 176 1 0
      //   62: checkcast 129	java/lang/String
      //   65: invokevirtual 180	com/tencent/wcdb/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   68: aload 7
      //   70: invokeinterface 183 1 0
      //   75: invokestatic 187	com/tencent/wcdb/DatabaseUtils:bindObjectToProgram	(Lcom/tencent/wcdb/database/SQLiteProgram;ILjava/lang/Object;)V
      //   78: goto -48 -> 30
      //   81: aload 5
      //   83: invokevirtual 191	com/tencent/wcdb/database/SQLiteStatement:executeInsert	()J
      //   86: lstore_3
      //   87: aload_0
      //   88: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   91: invokevirtual 194	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
      //   94: aload_0
      //   95: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   98: invokevirtual 197	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   101: lload_3
      //   102: lreturn
      //   103: astore_1
      //   104: goto +77 -> 181
      //   107: astore 5
      //   109: new 46	java/lang/StringBuilder
      //   112: dup
      //   113: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   116: astore 6
      //   118: aload 6
      //   120: ldc 199
      //   122: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   125: pop
      //   126: aload 6
      //   128: aload_1
      //   129: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   132: pop
      //   133: aload 6
      //   135: ldc 204
      //   137: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: pop
      //   141: aload 6
      //   143: aload_0
      //   144: getfield 42	com/tencent/wcdb/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   147: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   150: pop
      //   151: ldc 206
      //   153: aload 6
      //   155: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   158: iconst_1
      //   159: anewarray 4	java/lang/Object
      //   162: dup
      //   163: iconst_0
      //   164: aload 5
      //   166: aastore
      //   167: invokestatic 212	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   170: aload_0
      //   171: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   174: invokevirtual 197	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   177: ldc2_w 213
      //   180: lreturn
      //   181: aload_0
      //   182: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   185: invokevirtual 197	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   188: aload_1
      //   189: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	190	0	this	InsertHelper
      //   0	190	1	paramContentValues	ContentValues
      //   0	190	2	paramBoolean	boolean
      //   86	16	3	l	long
      //   12	70	5	localSQLiteStatement	SQLiteStatement
      //   107	58	5	localSQLException	SQLException
      //   28	126	6	localObject	Object
      //   50	19	7	localEntry	java.util.Map.Entry
      // Exception table:
      //   from	to	target	type
      //   7	30	103	finally
      //   30	78	103	finally
      //   81	94	103	finally
      //   109	170	103	finally
      //   7	30	107	com/tencent/wcdb/SQLException
      //   30	78	107	com/tencent/wcdb/SQLException
      //   81	94	107	com/tencent/wcdb/SQLException
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramDouble);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramFloat);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      this.mPreparedStatement.bindLong(paramInt1, paramInt2);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      this.mPreparedStatement.bindLong(paramInt, paramLong);
    }
    
    public void bind(int paramInt, String paramString)
    {
      if (paramString == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        return;
      }
      this.mPreparedStatement.bindString(paramInt, paramString);
    }
    
    public void bind(int paramInt, boolean paramBoolean)
    {
      SQLiteStatement localSQLiteStatement = this.mPreparedStatement;
      long l;
      if (paramBoolean) {
        l = 1L;
      } else {
        l = 0L;
      }
      localSQLiteStatement.bindLong(paramInt, l);
    }
    
    public void bind(int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        return;
      }
      this.mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
    }
    
    public void bindNull(int paramInt)
    {
      this.mPreparedStatement.bindNull(paramInt);
    }
    
    public void close()
    {
      SQLiteStatement localSQLiteStatement = this.mInsertStatement;
      if (localSQLiteStatement != null)
      {
        localSQLiteStatement.close();
        this.mInsertStatement = null;
      }
      localSQLiteStatement = this.mReplaceStatement;
      if (localSQLiteStatement != null)
      {
        localSQLiteStatement.close();
        this.mReplaceStatement = null;
      }
      this.mInsertSQL = null;
      this.mColumns = null;
    }
    
    /* Error */
    public long execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 38	com/tencent/wcdb/DatabaseUtils$InsertHelper:mPreparedStatement	Lcom/tencent/wcdb/database/SQLiteStatement;
      //   4: astore_3
      //   5: aload_3
      //   6: ifnull +81 -> 87
      //   9: aload_3
      //   10: invokevirtual 191	com/tencent/wcdb/database/SQLiteStatement:executeInsert	()J
      //   13: lstore_1
      //   14: aload_0
      //   15: aconst_null
      //   16: putfield 38	com/tencent/wcdb/DatabaseUtils$InsertHelper:mPreparedStatement	Lcom/tencent/wcdb/database/SQLiteStatement;
      //   19: lload_1
      //   20: lreturn
      //   21: astore_3
      //   22: goto +58 -> 80
      //   25: astore_3
      //   26: new 46	java/lang/StringBuilder
      //   29: dup
      //   30: invokespecial 60	java/lang/StringBuilder:<init>	()V
      //   33: astore 4
      //   35: aload 4
      //   37: ldc 241
      //   39: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: pop
      //   43: aload 4
      //   45: aload_0
      //   46: getfield 42	com/tencent/wcdb/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   49: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: pop
      //   53: ldc 206
      //   55: aload 4
      //   57: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: iconst_1
      //   61: anewarray 4	java/lang/Object
      //   64: dup
      //   65: iconst_0
      //   66: aload_3
      //   67: aastore
      //   68: invokestatic 212	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   71: aload_0
      //   72: aconst_null
      //   73: putfield 38	com/tencent/wcdb/DatabaseUtils$InsertHelper:mPreparedStatement	Lcom/tencent/wcdb/database/SQLiteStatement;
      //   76: ldc2_w 213
      //   79: lreturn
      //   80: aload_0
      //   81: aconst_null
      //   82: putfield 38	com/tencent/wcdb/DatabaseUtils$InsertHelper:mPreparedStatement	Lcom/tencent/wcdb/database/SQLiteStatement;
      //   85: aload_3
      //   86: athrow
      //   87: new 243	java/lang/IllegalStateException
      //   90: dup
      //   91: ldc 245
      //   93: invokespecial 248	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   96: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	97	0	this	InsertHelper
      //   13	7	1	l	long
      //   4	6	3	localSQLiteStatement	SQLiteStatement
      //   21	1	3	localObject	Object
      //   25	61	3	localSQLException	SQLException
      //   33	23	4	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   9	14	21	finally
      //   26	71	21	finally
      //   9	14	25	com/tencent/wcdb/SQLException
    }
    
    public int getColumnIndex(String paramString)
    {
      getStatement(false);
      Object localObject = (Integer)this.mColumns.get(paramString);
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("column '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("' is invalid");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public long insert(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, false);
    }
    
    public void prepareForInsert()
    {
      this.mPreparedStatement = getStatement(false);
      this.mPreparedStatement.clearBindings();
    }
    
    public void prepareForReplace()
    {
      this.mPreparedStatement = getStatement(true);
      this.mPreparedStatement.clearBindings();
    }
    
    public long replace(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.DatabaseUtils
 * JD-Core Version:    0.7.0.1
 */