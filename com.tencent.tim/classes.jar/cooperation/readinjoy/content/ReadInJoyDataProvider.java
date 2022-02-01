package cooperation.readinjoy.content;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReadInJoyDataProvider
  extends AppContentProvider
{
  public static final Uri T = Uri.parse(cQL + "subscribe_msg_records");
  public static final Uri U = Uri.parse(cQL + "notify_msg_records");
  public static final Uri V = Uri.parse(cQL + "feeds_msg_records");
  public static final Uri W = Uri.parse(cQL + "recent_data");
  public static final Uri X = Uri.parse(cQL + "common_records");
  static String cQL = "content://tim.readinjoy/";
  private a a;
  private UriMatcher f;
  
  private SQLiteDatabase a(Uri paramUri, boolean paramBoolean)
  {
    String str1 = paramUri.getQueryParameter("uin");
    if (str1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin = null, uri=" + paramUri.getPath());
      }
    }
    AppRuntime localAppRuntime;
    String str2;
    do
    {
      do
      {
        return null;
        localAppRuntime = getRuntime(str1);
        if (localAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, ar is null, uri=" + paramUri.getPath());
      return null;
      str2 = localAppRuntime.getAccount();
      if (str2.equals(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyDataProvider", 2, "getDBHelper, uin not equal, uri=" + paramUri.getPath() + ", current account=" + localAppRuntime.getAccount());
    return null;
    if ((this.a == null) || (!this.a.mUin.equals(str2)))
    {
      this.a = new a(localAppRuntime.getApplication().getApplicationContext(), str1);
      this.a.mUin = str2;
    }
    if (paramBoolean) {
      return this.a.getReadableDatabase();
    }
    return this.a.getWritableDatabase();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.f.match(paramUri))
    {
    case 2002: 
    default: 
      return 0;
    case 2000: 
      return localSQLiteDatabase.delete("subscribe_msg_records", paramString, paramArrayOfString);
    case 2001: 
      localSQLiteDatabase.execSQL("DELETE from notify_msg_records;");
      return 0;
    case 2003: 
      return localSQLiteDatabase.delete("feeds_msg_records", paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.delete("common_records", paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null)
    {
      paramUri = null;
      return paramUri;
    }
    long l;
    switch (this.f.match(paramUri))
    {
    case 2002: 
    default: 
      l = -1L;
    }
    while (l == -1L)
    {
      return null;
      l = localSQLiteDatabase.insert("subscribe_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("notify_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("feeds_msg_records", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("common_records", null, paramContentValues);
    }
  }
  
  public boolean onCreate()
  {
    super.onCreate();
    this.f = new UriMatcher(-1);
    this.f.addURI("tim.readinjoy", "subscribe_msg_records", 2000);
    this.f.addURI("tim.readinjoy", "notify_msg_records", 2001);
    this.f.addURI("tim.readinjoy", "recent_data", 2002);
    this.f.addURI("tim.readinjoy", "feeds_msg_records", 2003);
    this.f.addURI("tim.readinjoy", "common_records", 2004);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, true);
    if (localSQLiteDatabase == null) {
      return null;
    }
    switch (this.f.match(paramUri))
    {
    case 2002: 
    default: 
      return null;
    case 2000: 
      return localSQLiteDatabase.query("subscribe_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramUri.getQueryParameter("limit"));
    case 2001: 
      return localSQLiteDatabase.query("notify_msg_records", null, null, null, null, null, "msgID DESC", null);
    case 2003: 
      return localSQLiteDatabase.query("feeds_msg_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
    }
    return localSQLiteDatabase.query("common_records", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, null);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {}
    SQLiteDatabase localSQLiteDatabase = a(paramUri, false);
    if (localSQLiteDatabase == null) {
      return -1;
    }
    switch (this.f.match(paramUri))
    {
    default: 
      return 0;
    case 2003: 
      return localSQLiteDatabase.update("feeds_msg_records", paramContentValues, paramString, paramArrayOfString);
    }
    return localSQLiteDatabase.update("common_records", paramContentValues, paramString, paramArrayOfString);
  }
  
  public class a
    extends SQLiteOpenHelper
  {
    public String mUin = "";
    
    public a(Context paramContext, String paramString)
    {
      super("readinjoy_main_" + paramString, null, 84);
      this.mUin = paramString;
    }
    
    private void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      if ((paramString.equals("subscribe_msg_records")) || (paramString.equals("notify_msg_records"))) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "msgID" + " INTEGER UNIQUE NOT NULL, " + "subscribeID" + " TEXT NOT NULL, " + "msgURL" + " TEXT NOT NULL, " + "msgContent" + " TEXT NOT NULL, " + "msgTime" + " INTEGER NOT NULL, " + "bindUin" + " INTEGER NOT NULL);");
      }
      while (!paramString.equals("feeds_msg_records")) {
        return;
      }
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "pushTime" + " INTEGER NOT NULL, " + "notifyType" + " INTEGER NOT NULL, " + "feedsOwner" + " INTEGER NOT NULL, " + "feedsID" + " INTEGER NOT NULL, " + "feedsSubject" + " TEXT DEFAULT '', " + "deleteUin" + " INTEGER NOT NULL, " + "publishFail" + " INTEGER NOT NULL, " + "likeUin" + " INTEGER NOT NULL, " + "commentUin" + " INTEGER NOT NULL, " + "commentID" + " VARCHAR(32) DEFAULT '', " + "replyUin" + " INTEGER NOT NULL, " + "replyID" + " VARCHAR(32) DEFAULT '', " + "commentInfo" + " TEXT DEFAULT '', " + "isDelete" + " INTEGER DEFAULT 0, " + "processSeq" + " INTEGER DEFAULT 0, " + "receiveTime" + " INTEGER NOT NULL);");
    }
    
    private void c(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      if ("common_records".equalsIgnoreCase(paramString)) {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + paramString + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "common_version" + " INTEGER NOT NULL, " + "common_key" + " TEXT DEFAULT '', " + "common_content" + " TEXT DEFAULT '');");
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      b(paramSQLiteDatabase, "subscribe_msg_records");
      b(paramSQLiteDatabase, "notify_msg_records");
      b(paramSQLiteDatabase, "feeds_msg_records");
      c(paramSQLiteDatabase, "common_records");
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (paramInt1 < 80)
      {
        paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("subscribe_msg_records"));
        paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement("notify_msg_records"));
        b(paramSQLiteDatabase, "subscribe_msg_records");
        b(paramSQLiteDatabase, "notify_msg_records");
      }
      if (paramInt1 < 81) {
        b(paramSQLiteDatabase, "feeds_msg_records");
      }
      for (;;)
      {
        if (paramInt1 < 84) {
          c(paramSQLiteDatabase, "common_records");
        }
        return;
        if (paramInt1 < 82) {
          paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "isDelete", "INTEGER DEFAULT 0" }));
        }
        if (paramInt1 < 83) {
          paramSQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD %s %s;", new Object[] { "feeds_msg_records", "processSeq", "INTEGER DEFAULT 0" }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.readinjoy.content.ReadInJoyDataProvider
 * JD-Core Version:    0.7.0.1
 */