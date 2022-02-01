import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ahrz
  extends SQLiteOpenHelper
{
  private Context mContext;
  
  public ahrz(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 28);
    this.mContext = paramContext;
  }
  
  private ahrz.a a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      ahrz.a locala = new ahrz.a();
      locala.appId = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      locala.packageName = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      locala.apkUrl = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      locala.bLD = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      locala.versionCode = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      locala.appName = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      locala.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      locala.apkChannel = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      locala.via = paramCursor.getString(paramCursor.getColumnIndex("via"));
      locala.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      locala.bLE = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      locala.from = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      locala.bLF = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      locala.extraData = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      locala.fileSize = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      locala.DZ = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      locala.aJb = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      locala.bBa = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      locala.taskId = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      locala.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return locala;
    }
    return null;
  }
  
  private boolean anW()
  {
    return new File(this.mContext.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<ahrz.a> fh()
  {
    Object localObject1 = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return null;
    }
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from TASKS", null);
    for (;;)
    {
      Object localObject4;
      if (localCursor != null) {
        localObject4 = localObject1;
      }
      try
      {
        if (localCursor.moveToNext())
        {
          localObject4 = localObject1;
          ahrz.a locala = a(localCursor);
          if (locala == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(locala);
          localObject1 = localObject3;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject4;
        return localException;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        localSQLiteDatabase.close();
      }
    }
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    if (!anW()) {
      return null;
    }
    return super.getReadableDatabase();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    throw new SQLiteException("WadlTaskReader don't upgrade database from version " + paramInt1 + " to " + paramInt2);
  }
  
  public static class a
  {
    public long DZ;
    public String aJb;
    public String apkChannel;
    public String apkUrl;
    public String appId;
    public String appName;
    public int bBa;
    public String bLD;
    public String bLE;
    public String bLF;
    public long createTime;
    public String extraData;
    public long fileSize;
    public int flags;
    public int from;
    public String iconUrl;
    public String packageName;
    public String taskId;
    public int versionCode;
    public String via;
    
    public String toString()
    {
      return "TaskInfo{appId=" + this.appId + ", packageName=" + this.packageName + ", appName=" + this.appName + ", taskStatus=" + this.bBa + ", fileSize=" + this.fileSize + ", downloadFileSize=" + this.DZ + ", downloadFilePath='" + this.aJb + '\'' + ", createTime=" + this.createTime + ", apkChannel=" + this.apkChannel + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrz
 * JD-Core Version:    0.7.0.1
 */