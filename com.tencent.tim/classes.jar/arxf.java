import android.database.Cursor;
import android.os.Parcel;

final class arxf
  implements aryh.a<arxe>
{
  public arxe a(Cursor paramCursor)
  {
    try
    {
      String str1 = paramCursor.getString(paramCursor.getColumnIndex("urlKey"));
      String str2 = paramCursor.getString(paramCursor.getColumnIndex("ETag"));
      long l1 = paramCursor.getLong(paramCursor.getColumnIndex("lastModify"));
      long l2 = paramCursor.getLong(paramCursor.getColumnIndex("cacheTime"));
      Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("response"));
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = paramCursor.readString();
      paramCursor.recycle();
      paramCursor = new arxe(str1, str2, l1, l2, (String)localObject);
      return paramCursor;
    }
    catch (Exception paramCursor)
    {
      paramCursor.printStackTrace();
    }
    return null;
  }
  
  public aryh.b[] a()
  {
    return new aryh.b[] { new aryh.b("urlKey", "TEXT"), new aryh.b("ETag", "TEXT"), new aryh.b("lastModify", "INTEGER"), new aryh.b("cacheTime", "INTEGER"), new aryh.b("response", "BLOB") };
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxf
 * JD-Core Version:    0.7.0.1
 */