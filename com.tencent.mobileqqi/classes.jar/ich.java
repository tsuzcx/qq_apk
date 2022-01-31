import android.database.Cursor;
import android.os.Parcel;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.PackageInfo;
import cooperation.qzone.model.DbCacheData.DbCreator;
import cooperation.qzone.model.DbCacheData.Structure;

public final class ich
  implements DbCacheData.DbCreator
{
  public int a()
  {
    return 5;
  }
  
  public CoverCacheData a(Cursor paramCursor)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localCoverCacheData.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
    localCoverCacheData.local_url = paramCursor.getString(paramCursor.getColumnIndex("local_url"));
    localCoverCacheData.isJigsawOpen = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("urls"));
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall((byte[])localObject, 0, localObject.length);
      localParcel.setDataPosition(0);
      localCoverCacheData.urls = localParcel.readHashMap(getClass().getClassLoader());
      localParcel.recycle();
      label136:
      localObject = paramCursor.getBlob(paramCursor.getColumnIndex("package_info"));
      try
      {
        localParcel = Parcel.obtain();
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localCoverCacheData.packageInfo = ((CoverCacheData.PackageInfo)localParcel.readParcelable(getClass().getClassLoader()));
        localParcel.recycle();
        label195:
        paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("photo_wall"));
        try
        {
          localObject = Parcel.obtain();
          ((Parcel)localObject).unmarshall(paramCursor, 0, paramCursor.length);
          ((Parcel)localObject).setDataPosition(0);
          localCoverCacheData.photoWall = ((Parcel)localObject).readArrayList(getClass().getClassLoader());
          ((Parcel)localObject).recycle();
          return localCoverCacheData;
        }
        catch (Exception paramCursor)
        {
          return localCoverCacheData;
        }
      }
      catch (Exception localException1)
      {
        break label195;
      }
    }
    catch (Exception localException2)
    {
      break label136;
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public DbCacheData.Structure[] a()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("uin", "INTEGER"), new DbCacheData.Structure("type", "TEXT"), new DbCacheData.Structure("local_url", "TEXT"), new DbCacheData.Structure("urls", "BLOB"), new DbCacheData.Structure("package_info", "BLOB"), new DbCacheData.Structure("photo_wall", "BLOB"), new DbCacheData.Structure("jigsaw", "INTEGER") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ich
 * JD-Core Version:    0.7.0.1
 */