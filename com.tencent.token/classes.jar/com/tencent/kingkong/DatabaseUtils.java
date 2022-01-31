package com.tencent.kingkong;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.kingkong.database.SQLiteAbortException;
import com.tencent.kingkong.database.SQLiteConstraintException;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.kingkong.database.SQLiteDatabase.Arithmetic;
import com.tencent.kingkong.database.SQLiteDatabase.LockedDevice;
import com.tencent.kingkong.database.SQLiteDatabaseCorruptException;
import com.tencent.kingkong.database.SQLiteDiskIOException;
import com.tencent.kingkong.database.SQLiteException;
import com.tencent.kingkong.database.SQLiteFullException;
import com.tencent.kingkong.database.SQLiteProgram;
import com.tencent.kingkong.database.SQLiteStatement;
import com.tencent.kingkong.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;
import java.util.Locale;

public class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int EX_HAS_REPLY_HEADER = -128;
  private static final Locale ROOT = new Locale("", "", "");
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
  private static final String TAG = "DatabaseUtils";
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
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0)) {
      return paramArrayOfString2;
    }
    String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    return arrayOfString;
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
    if (((paramObject instanceof Double)) || ((paramObject instanceof Float)))
    {
      paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
      return;
    }
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
  }
  
  public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = blobFileDescriptorForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static ParcelFileDescriptor blobFileDescriptorForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    return paramSQLiteStatement.simpleQueryForBlobFileDescriptor();
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    return "(" + paramString1 + ") AND (" + paramString2 + ")";
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    createDbFromSqlStatements(paramContext, paramString1, SQLiteDatabase.LockedDevice.DEFAULT, null, SQLiteDatabase.Arithmetic.UNKNOWN, paramInt, paramString2);
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, SQLiteDatabase.LockedDevice paramLockedDevice, String paramString2, SQLiteDatabase.Arithmetic paramArithmetic, int paramInt, String paramString3)
  {
    paramContext = com.tencent.kingkong.support.Context.openOrCreateDatabase(paramContext, paramString1, paramLockedDevice, paramString2, paramArithmetic, 0, null, false);
    paramString1 = TextUtils.split(paramString3, ";\n");
    int j = paramString1.length;
    int i = 0;
    if (i < j)
    {
      paramLockedDevice = paramString1[i];
      if (TextUtils.isEmpty(paramLockedDevice)) {}
      for (;;)
      {
        i += 1;
        break;
        paramContext.execSQL(paramLockedDevice);
      }
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
        if (localObject != null) {}
        for (bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);; bool = paramCursorWindow.putNull(paramInt, i)) {
          break;
        }
        bool = paramCursorWindow.putNull(paramInt, i);
      }
      label269:
      i += 1;
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
    String[] arrayOfString;
    int i;
    if ((paramCursor instanceof AbstractWindowedCursor))
    {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
      arrayOfString = paramCursor.getColumnNames();
      int j = arrayOfString.length;
      i = 0;
      label27:
      if (i >= j) {
        return;
      }
      if ((localAbstractWindowedCursor == null) || (!localAbstractWindowedCursor.isBlob(i))) {
        break label74;
      }
      paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
    }
    for (;;)
    {
      i += 1;
      break label27;
      localAbstractWindowedCursor = null;
      break;
      label74:
      paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
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
    paramPrintStream.println("" + paramCursor.getPosition() + " {");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramPrintStream.println("   " + arrayOfString[i] + '=' + str1);
          i += 1;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    paramStringBuilder.append("" + paramCursor.getPosition() + " {\n");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramStringBuilder.append("   " + arrayOfString[i] + '=' + str1 + "\n");
          i += 1;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
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
    paramPrintStream.println(">>>>> Dumping cursor " + paramCursor);
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
    paramStringBuilder.append(">>>>> Dumping cursor " + paramCursor + "\n");
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
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = DIGITS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
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
    catch (Exception paramString) {}
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
    if (paramString.length() < 3) {}
    do
    {
      return 99;
      paramString = paramString.substring(0, 3).toUpperCase(ROOT);
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
    } while ((!paramString.equals("ANA")) && (!paramString.equals("DET")));
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
  
  public static boolean queryIsEmpty(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    return longForQuery(paramSQLiteDatabase, "select exists(select 1 from " + paramString + ")", null) == 0L;
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
    if (!TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = " where " + paramString2;; paramString2 = "") {
      return longForQuery(paramSQLiteDatabase, "select count(*) from " + paramString1 + paramString2, paramArrayOfString);
    }
  }
  
  private static final int readExceptionCode(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    int i = j;
    if (j == -128)
    {
      if (paramParcel.readInt() == 0) {
        Log.e("DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
      }
      i = 0;
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
    case 2: 
      throw new IllegalArgumentException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 9: 
      throw new SQLiteException(paramString);
    }
    throw new OperationCanceledException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
    throws FileNotFoundException
  {
    int i = readExceptionCode(paramParcel);
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i == 1) {
      throw new FileNotFoundException(str);
    }
    readExceptionFromParcel(paramParcel, str, i);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
    throws OperationApplicationException
  {
    int i = readExceptionCode(paramParcel);
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i == 10) {
      throw new OperationApplicationException(str);
    }
    readExceptionFromParcel(paramParcel, str, i);
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
    int j = 1;
    int i;
    if ((paramException instanceof FileNotFoundException))
    {
      i = 1;
      j = 0;
    }
    for (;;)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(paramException.getMessage());
      if (j != 0) {
        Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
      }
      return;
      if ((paramException instanceof IllegalArgumentException))
      {
        i = 2;
      }
      else if ((paramException instanceof UnsupportedOperationException))
      {
        i = 3;
      }
      else if ((paramException instanceof SQLiteAbortException))
      {
        i = 4;
      }
      else if ((paramException instanceof SQLiteConstraintException))
      {
        i = 5;
      }
      else if ((paramException instanceof SQLiteDatabaseCorruptException))
      {
        i = 6;
      }
      else if ((paramException instanceof SQLiteFullException))
      {
        i = 7;
      }
      else if ((paramException instanceof SQLiteDiskIOException))
      {
        i = 8;
      }
      else if ((paramException instanceof SQLiteException))
      {
        i = 9;
      }
      else if ((paramException instanceof OperationApplicationException))
      {
        i = 10;
      }
      else
      {
        if (!(paramException instanceof OperationCanceledException)) {
          break;
        }
        i = 11;
        j = 0;
      }
    }
    paramParcel.writeException(paramException);
    Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
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
      throws SQLException
    {
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append("INSERT INTO ");
      localStringBuilder1.append(this.mTableName);
      localStringBuilder1.append(" (");
      StringBuilder localStringBuilder2 = new StringBuilder(128);
      localStringBuilder2.append("VALUES (");
      int i = 1;
      Object localObject1 = null;
      Cursor localCursor;
      for (;;)
      {
        try
        {
          localCursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
          localObject1 = localCursor;
          this.mColumns = new HashMap(localCursor.getCount());
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          String str1 = localCursor.getString(1);
          localObject1 = localCursor;
          String str3 = localCursor.getString(4);
          localObject1 = localCursor;
          this.mColumns.put(str1, Integer.valueOf(i));
          localObject1 = localCursor;
          localStringBuilder1.append("'");
          localObject1 = localCursor;
          localStringBuilder1.append(str1);
          localObject1 = localCursor;
          localStringBuilder1.append("'");
          if (str3 == null)
          {
            localObject1 = localCursor;
            localStringBuilder2.append("?");
            localObject1 = localCursor;
            if (i == localCursor.getCount())
            {
              str1 = ") ";
              localObject1 = localCursor;
              localStringBuilder1.append(str1);
              localObject1 = localCursor;
              if (i != localCursor.getCount()) {
                break label338;
              }
              str1 = ");";
              localObject1 = localCursor;
              localStringBuilder2.append(str1);
              i += 1;
            }
          }
          else
          {
            localObject1 = localCursor;
            localStringBuilder2.append("COALESCE(?, ");
            localObject1 = localCursor;
            localStringBuilder2.append(str3);
            localObject1 = localCursor;
            localStringBuilder2.append(")");
            continue;
          }
          str2 = ", ";
        }
        finally
        {
          if (localObject1 != null) {
            localObject1.close();
          }
        }
        continue;
        label338:
        String str2 = ", ";
      }
      if (localCursor != null) {
        localCursor.close();
      }
      localStringBuilder1.append(localStringBuilder2);
      this.mInsertSQL = localStringBuilder1.toString();
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
      throws SQLException
    {
      if (paramBoolean)
      {
        if (this.mReplaceStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          String str = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
          this.mReplaceStatement = this.mDb.compileStatement(str);
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
      //   1: getfield 40	com/tencent/kingkong/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/kingkong/database/SQLiteDatabase;
      //   4: invokevirtual 144	com/tencent/kingkong/database/SQLiteDatabase:beginTransactionNonExclusive	()V
      //   7: aload_0
      //   8: iload_2
      //   9: invokespecial 146	com/tencent/kingkong/DatabaseUtils$InsertHelper:getStatement	(Z)Lcom/tencent/kingkong/database/SQLiteStatement;
      //   12: astore 5
      //   14: aload 5
      //   16: invokevirtual 151	com/tencent/kingkong/database/SQLiteStatement:clearBindings	()V
      //   19: aload_1
      //   20: invokevirtual 157	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   23: invokeinterface 163 1 0
      //   28: astore 6
      //   30: aload 6
      //   32: invokeinterface 168 1 0
      //   37: ifeq +96 -> 133
      //   40: aload 6
      //   42: invokeinterface 172 1 0
      //   47: checkcast 174	java/util/Map$Entry
      //   50: astore 7
      //   52: aload 5
      //   54: aload_0
      //   55: aload 7
      //   57: invokeinterface 177 1 0
      //   62: checkcast 132	java/lang/String
      //   65: invokevirtual 181	com/tencent/kingkong/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   68: aload 7
      //   70: invokeinterface 184 1 0
      //   75: invokestatic 188	com/tencent/kingkong/DatabaseUtils:bindObjectToProgram	(Lcom/tencent/kingkong/database/SQLiteProgram;ILjava/lang/Object;)V
      //   78: goto -48 -> 30
      //   81: astore 5
      //   83: ldc 190
      //   85: new 48	java/lang/StringBuilder
      //   88: dup
      //   89: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   92: ldc 192
      //   94: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: aload_1
      //   98: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   101: ldc 197
      //   103: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: aload_0
      //   107: getfield 42	com/tencent/kingkong/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   110: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   116: aload 5
      //   118: invokestatic 203	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   121: pop
      //   122: aload_0
      //   123: getfield 40	com/tencent/kingkong/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/kingkong/database/SQLiteDatabase;
      //   126: invokevirtual 206	com/tencent/kingkong/database/SQLiteDatabase:endTransaction	()V
      //   129: ldc2_w 207
      //   132: lreturn
      //   133: aload 5
      //   135: invokevirtual 212	com/tencent/kingkong/database/SQLiteStatement:executeInsert	()J
      //   138: lstore_3
      //   139: aload_0
      //   140: getfield 40	com/tencent/kingkong/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/kingkong/database/SQLiteDatabase;
      //   143: invokevirtual 215	com/tencent/kingkong/database/SQLiteDatabase:setTransactionSuccessful	()V
      //   146: aload_0
      //   147: getfield 40	com/tencent/kingkong/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/kingkong/database/SQLiteDatabase;
      //   150: invokevirtual 206	com/tencent/kingkong/database/SQLiteDatabase:endTransaction	()V
      //   153: lload_3
      //   154: lreturn
      //   155: astore_1
      //   156: aload_0
      //   157: getfield 40	com/tencent/kingkong/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/kingkong/database/SQLiteDatabase;
      //   160: invokevirtual 206	com/tencent/kingkong/database/SQLiteDatabase:endTransaction	()V
      //   163: aload_1
      //   164: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	165	0	this	InsertHelper
      //   0	165	1	paramContentValues	ContentValues
      //   0	165	2	paramBoolean	boolean
      //   138	16	3	l	long
      //   12	41	5	localSQLiteStatement	SQLiteStatement
      //   81	53	5	localSQLException	SQLException
      //   28	13	6	localIterator	java.util.Iterator
      //   50	19	7	localEntry	java.util.Map.Entry
      // Exception table:
      //   from	to	target	type
      //   7	30	81	com/tencent/kingkong/SQLException
      //   30	78	81	com/tencent/kingkong/SQLException
      //   133	146	81	com/tencent/kingkong/SQLException
      //   7	30	155	finally
      //   30	78	155	finally
      //   83	122	155	finally
      //   133	146	155	finally
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
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        localSQLiteStatement.bindLong(paramInt, l);
        return;
      }
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
      if (this.mInsertStatement != null)
      {
        this.mInsertStatement.close();
        this.mInsertStatement = null;
      }
      if (this.mReplaceStatement != null)
      {
        this.mReplaceStatement.close();
        this.mReplaceStatement = null;
      }
      this.mInsertSQL = null;
      this.mColumns = null;
    }
    
    public long execute()
    {
      if (this.mPreparedStatement == null) {
        throw new IllegalStateException("you must prepare this inserter before calling execute");
      }
      try
      {
        long l = this.mPreparedStatement.executeInsert();
        return l;
      }
      catch (SQLException localSQLException)
      {
        Log.e("DatabaseUtils", "Error executing InsertHelper with table " + this.mTableName, localSQLException);
        return -1L;
      }
      finally
      {
        this.mPreparedStatement = null;
      }
    }
    
    public int getColumnIndex(String paramString)
    {
      getStatement(false);
      Integer localInteger = (Integer)this.mColumns.get(paramString);
      if (localInteger == null) {
        throw new IllegalArgumentException("column '" + paramString + "' is invalid");
      }
      return localInteger.intValue();
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
 * Qualified Name:     com.tencent.kingkong.DatabaseUtils
 * JD-Core Version:    0.7.0.1
 */