package mqq.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EncryptedDatabase
{
  private static final String SQL_GET_TABLE_ATTR = "select sql from sqlite_master where type=? and name=?";
  private static final String TAG = "db";
  private SQLiteDatabase.CursorFactory encryptedFactory = new SQLiteDatabase.CursorFactory()
  {
    String[] ex = { "sqlite_master", "sqlite_sequence", "sqlite_temp_master" };
    
    public Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, final String paramAnonymousString, SQLiteQuery paramAnonymousSQLiteQuery)
    {
      new SQLiteCursor(paramAnonymousSQLiteDatabase, paramAnonymousSQLiteCursorDriver, paramAnonymousString, paramAnonymousSQLiteQuery)
      {
        public String getString(int paramAnonymous2Int)
        {
          Object localObject = paramAnonymousString;
          String str = super.getString(paramAnonymous2Int);
          localObject = str;
          if (!"sqlite_master".equals(paramAnonymousString)) {}
          try
          {
            localObject = SecurityUtile.decode(str);
            return localObject;
          }
          catch (Exception localException) {}
          return str;
        }
      };
    }
  };
  private final SQLiteOpenHelper mHelper;
  private final Map<String, ArrayList<String>> tableMap = new HashMap();
  
  public EncryptedDatabase(Context paramContext, String paramString, int paramInt)
  {
    SecurityUtile.setKey(paramContext);
    this.mHelper = new DBHelper(paramContext, paramString, paramInt);
  }
  
  private ArrayList<String> analyseTableField(String paramString1, String paramString2)
  {
    paramString1 = paramString1.substring(paramString1.indexOf("(") + 1, paramString1.indexOf(")")).split(",");
    paramString2 = paramString2.toLowerCase();
    ArrayList localArrayList = new ArrayList();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString1[i].trim().split(" ");
      if ((arrayOfString.length > 1) && (paramString2.equals(arrayOfString[1].toLowerCase()))) {
        localArrayList.add(arrayOfString[0]);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private String convert(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.encode(str);
  }
  
  private ContentValues convertContentValues(String paramString, ContentValues paramContentValues)
  {
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {}
    for (;;)
    {
      return paramContentValues;
      paramString = getTableInfo(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          String str1 = (String)paramString.next();
          if (paramContentValues.containsKey(str1))
          {
            String str2 = (String)paramContentValues.get(str1);
            if ((str2 != null) && (str2.length() > 0)) {
              paramContentValues.put(str1, convert(paramContentValues.get(str1)));
            }
          }
        }
      }
    }
  }
  
  private ArrayList<String> getTableInfo(String paramString)
  {
    if (!this.tableMap.containsKey(paramString))
    {
      localObject2 = null;
      localObject1 = null;
    }
    try
    {
      localCursor = this.mHelper.getReadableDatabase().rawQueryWithFactory(null, "select sql from sqlite_master where type=? and name=?", new String[] { "table", paramString }, "sqlite_master");
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          ArrayList localArrayList = analyseTableField(localCursor.getString(0), "TEXT");
          localObject1 = localCursor;
          localObject2 = localCursor;
          this.tableMap.put(paramString, localArrayList);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Cursor localCursor;
        localObject2 = localObject1;
        localException.printStackTrace();
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label168;
      }
      localObject2.close();
    }
    return (ArrayList)this.tableMap.get(paramString);
  }
  
  public void close()
  {
    this.mHelper.close();
  }
  
  public void execSQL(String paramString)
  {
    this.mHelper.getWritableDatabase().execSQL(paramString);
  }
  
  public long insert(String paramString, ContentValues paramContentValues)
  {
    paramContentValues = convertContentValues(paramString, paramContentValues);
    return this.mHelper.getWritableDatabase().insert(paramString, null, paramContentValues);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return this.mHelper.getReadableDatabase().rawQuery(paramString, paramArrayOfString);
  }
  
  private class DBHelper
    extends SQLiteOpenHelper
  {
    public DBHelper(Context paramContext, String paramString, int paramInt)
    {
      super(paramString, EncryptedDatabase.this.encryptedFactory, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.database.EncryptedDatabase
 * JD-Core Version:    0.7.0.1
 */