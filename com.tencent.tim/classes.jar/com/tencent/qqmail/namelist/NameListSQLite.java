package com.tencent.qqmail.namelist;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper.UnsupportedGetDatabase;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.namelist.model.NameListContact.NameListContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class NameListSQLite
  extends QMMailSQLiteHelper.UnsupportedGetDatabase
{
  private static final char[] LETTERS = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  private static final char[] LETTERS_LOWERCASE = { 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final char LETTER_ANY = '#';
  private static final char LETTER_BIG_HEAD = '@';
  private static final char LETTER_BIG_TAIL = '[';
  private static final char LETTER_HEAD = '`';
  private static final char LETTER_TAIL = '{';
  private static final String ORDER_BY_ALPHABET = " ORDER BY  (CASE WHEN (C.email > '`' AND C.email < '{') OR (C.email > '@' AND C.email < '[') THEN 0  ELSE 1 END), upper(C.email)";
  private static final String SEARCH_NAME_LIST_CONTACT_PARAM = "(C.email LIKE $keyword$)";
  private static final String SECTION_AND = "C.email >= '$firstLetter$' AND C.email < '$lastLetter$'";
  private static final String SECTION_OR = "C.email >  '$firstLetter$' OR  C.email < '$lastLetter$'";
  private static final String SELECT_COUNT = "SELECT COUNT(C.id) FROM QM_NAME_LIST AS C";
  private static final String SELECT_NAME_LIST = "SELECT * FROM QM_NAME_LIST AS C";
  private static final String TAG = "NameListSQLite";
  private static final String querySearchContactsByAccountIdsAndTypes = "SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId=$accountId$ AND C.type=$type$ AND ((C.email LIKE $keyword$)) ORDER BY  (CASE WHEN (C.email > '`' AND C.email < '{') OR (C.email > '@' AND C.email < '[') THEN 0  ELSE 1 END), upper(C.email)";
  private static final String sqlCreate = "CREATE TABLE IF NOT EXISTS QM_NAME_LIST(id varchar primary key, accountId varchar, email varchar, type integer, isQQ integer )";
  private static final String sqlCreateForUpgrade = "CREATE TABLE IF NOT EXISTS QM_NAME_LIST(id varchar primary key, accountId varchar, email varchar, type integer, isQQ integer )";
  private static final String sqlDeleteNameListByAccountAndEmail = "DELETE FROM QM_NAME_LIST WHERE accountId=? AND email=?";
  private static final String sqlDeleteNameListContact = "DELETE FROM QM_NAME_LIST WHERE accountId=?";
  private static final String sqlDrop = "DROP TABLE IF EXISTS QM_NAME_LIST";
  private static final String sqlInsert = "REPLACE INTO QM_NAME_LIST (id , accountId , email , type , isQQ ) VALUES (?,?,?,?,?)";
  private static final String sqlQueryByAccountIdAndType = "C.accountId=$accountId$ AND C.type=$type$";
  private static final String sqlQueryNameListByAccountAndType = "SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId=? AND C.type =? ORDER BY  (CASE WHEN (C.email > '`' AND C.email < '{') OR (C.email > '@' AND C.email < '[') THEN 0  ELSE 1 END), upper(C.email)";
  private static final String sqlQueryNameListByAccountIdAndTypeWhereClause = " C.accountId=? AND C.type =?";
  private static final String sqlQueryNameListContactById = "SELECT * FROM QM_NAME_LIST AS C WHERE C.id = ? ";
  private static final String sqlQueryNameListExist = "SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId = ? AND C.email = ? AND C.type = ?";
  private static final String sqlUpdateNameListContactTypeByContactId = "UPDATE QM_NAME_LIST SET type =?  WHERE id =? ";
  
  public NameListSQLite(Context paramContext)
  {
    super(paramContext, false);
  }
  
  private static void beginColumnIndex(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {
      paramArrayOfInt[0] = 0;
    }
  }
  
  public static void fillNameListContact(NameListContact paramNameListContact, Cursor paramCursor, int[] paramArrayOfInt)
  {
    boolean bool = true;
    beginColumnIndex(paramArrayOfInt);
    paramNameListContact.setId(Long.parseLong(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "id"))));
    paramNameListContact.setAccountId(Integer.parseInt(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "accountId"))));
    paramNameListContact.setEmail(paramCursor.getString(getColumnIndex(paramArrayOfInt, paramCursor, "email")));
    paramNameListContact.setType(paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "type")));
    if (paramCursor.getInt(getColumnIndex(paramArrayOfInt, paramCursor, "isQQ")) == 1) {}
    for (;;)
    {
      paramNameListContact.setIsQQ(bool);
      return;
      bool = false;
    }
  }
  
  private static int getColumnIndex(int[] paramArrayOfInt, Cursor paramCursor, String paramString)
  {
    if (paramArrayOfInt == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    int i = paramArrayOfInt[0] + 1;
    paramArrayOfInt[0] = i;
    if ((paramArrayOfInt[i] > -2147483648) && (paramArrayOfInt[i] != -1)) {
      return paramArrayOfInt[i];
    }
    paramArrayOfInt[i] = paramCursor.getColumnIndex(paramString);
    return paramArrayOfInt[i];
  }
  
  public void createIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_NAME_LIST(id varchar primary key, accountId varchar, email varchar, type integer, isQQ integer )");
    QMLog.log(4, "NameListSQLite", "create table");
  }
  
  public void deleteNameListContactByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_NAME_LIST WHERE accountId=?", new Object[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteNameListContactByAccountIdAndEmail(SQLiteDatabase paramSQLiteDatabase, int paramInt, String[] paramArrayOfString)
  {
    int i = 0;
    try
    {
      int j = paramArrayOfString.length;
      while (i < j)
      {
        paramSQLiteDatabase.execSQL("DELETE FROM QM_NAME_LIST WHERE accountId=? AND email=?", new Object[] { String.valueOf(paramInt), paramArrayOfString[i] });
        i += 1;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void dropIndex(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_NAME_LIST");
    QMLog.log(4, "NameListSQLite", "drop table");
  }
  
  public NameListContact getNameListContactById(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_NAME_LIST AS C WHERE C.id = ? ", new String[] { String.valueOf(paramLong) });
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = new NameListContact();
        fillNameListContact(paramSQLiteDatabase, localCursor, null);
      }
      for (;;)
      {
        localCursor.close();
        return paramSQLiteDatabase;
        paramSQLiteDatabase = null;
      }
    }
    return null;
  }
  
  public Cursor getNameListCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId=? AND C.type =? ORDER BY  (CASE WHEN (C.email > '`' AND C.email < '{') OR (C.email > '@' AND C.email < '[') THEN 0  ELSE 1 END), upper(C.email)", new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
    return null;
  }
  
  public Cursor getNameListSearchCursor(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2, String paramString)
  {
    String str = "SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId=$accountId$ AND C.type=$type$ AND ((C.email LIKE $keyword$)) ORDER BY  (CASE WHEN (C.email > '`' AND C.email < '{') OR (C.email > '@' AND C.email < '[') THEN 0  ELSE 1 END), upper(C.email)".replace("$accountId$", String.valueOf(paramInt1)).replace("$type$", String.valueOf(paramInt2));
    if (paramString != null) {}
    for (paramString = DatabaseUtils.sqlEscapeString("%" + paramString + "%");; paramString = "''")
    {
      paramString = str.replace("$keyword$", paramString);
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, null);
        return paramSQLiteDatabase;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
    return null;
  }
  
  public LinkedHashMap<String, Integer> getSectionMap(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 0;
    String str = "C.accountId=$accountId$ AND C.type=$type$".replace("$accountId$", String.valueOf(paramInt1)).replace("$type$", String.valueOf(paramInt2));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT ");
    paramInt1 = 0;
    while (paramInt1 < LETTERS.length)
    {
      localStringBuilder.append("(");
      localStringBuilder.append("SELECT COUNT(C.id) FROM QM_NAME_LIST AS C" + " WHERE (" + "C.email >= '$firstLetter$' AND C.email < '$lastLetter$'".replace("$firstLetter$", String.valueOf(LETTERS[paramInt1])).replace("$lastLetter$", String.valueOf((char)(LETTERS[paramInt1] + '\001'))) + " OR " + "C.email >= '$firstLetter$' AND C.email < '$lastLetter$'".replace("$firstLetter$", String.valueOf(LETTERS_LOWERCASE[paramInt1])).replace("$lastLetter$", String.valueOf((char)(LETTERS_LOWERCASE[paramInt1] + '\001'))) + ") AND " + str);
      localStringBuilder.append("),");
      paramInt1 += 1;
    }
    localStringBuilder.append("(");
    localStringBuilder.append("SELECT COUNT(C.id) FROM QM_NAME_LIST AS C" + " WHERE ((" + "C.email >  '$firstLetter$' OR  C.email < '$lastLetter$'".replace("$firstLetter$", "Z").replace("$lastLetter$", "A") + ") AND (" + "C.email >  '$firstLetter$' OR  C.email < '$lastLetter$'".replace("$firstLetter$", "z").replace("$lastLetter$", "a") + ")) AND " + str);
    localStringBuilder.append(")");
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramInt1 = i;
        while (paramInt1 < LETTERS.length)
        {
          paramInt2 = paramSQLiteDatabase.getInt(paramInt1);
          if (paramInt2 > 0) {
            localLinkedHashMap.put(String.valueOf(LETTERS[paramInt1]), Integer.valueOf(paramInt2));
          }
          paramInt1 += 1;
        }
        paramInt1 = paramSQLiteDatabase.getInt(LETTERS.length);
        if (paramInt1 > 0) {
          localLinkedHashMap.put(String.valueOf('#'), Integer.valueOf(paramInt1));
        }
      }
      paramSQLiteDatabase.close();
    }
    return localLinkedHashMap;
  }
  
  public void insertNameListContact(SQLiteDatabase paramSQLiteDatabase, ArrayList<NameListContact> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            NameListContact localNameListContact = (NameListContact)paramArrayList.next();
            paramSQLiteDatabase.execSQL("REPLACE INTO QM_NAME_LIST (id , accountId , email , type , isQQ ) VALUES (?,?,?,?,?)", new Object[] { Long.valueOf(localNameListContact.getId()), Integer.valueOf(localNameListContact.getAccountId()), localNameListContact.getEmail(), Integer.valueOf(localNameListContact.getType()), Boolean.valueOf(localNameListContact.isQQ()) });
          }
        }
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
  }
  
  public boolean isBlackNameExist(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    return isNameExist(paramSQLiteDatabase, paramInt, paramString, NameListContact.NameListContactType.BLACK.ordinal());
  }
  
  public boolean isNameExist(SQLiteDatabase paramSQLiteDatabase, int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = true;
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_NAME_LIST AS C WHERE C.accountId = ? AND C.email = ? AND C.type = ?", new String[] { String.valueOf(paramInt1), paramString, String.valueOf(paramInt2) });
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        if (paramSQLiteDatabase.getCount() <= 0) {}
      }
      for (;;)
      {
        paramSQLiteDatabase.close();
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public boolean isWhiteNameExist(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    return isNameExist(paramSQLiteDatabase, paramInt, paramString, NameListContact.NameListContactType.WHITE.ordinal());
  }
  
  public void sqlUpdateNameListContactTypeByContactId(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_NAME_LIST SET type =?  WHERE id =? ", new Object[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "NameListSQLite", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void upgradeTableFor5007(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_NAME_LIST(id varchar primary key, accountId varchar, email varchar, type integer, isQQ integer )");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListSQLite
 * JD-Core Version:    0.7.0.1
 */