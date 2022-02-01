import android.database.Cursor;
import android.os.Parcel;

final class artn
  implements aryh.a<artm>
{
  public artm a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new artm();
    ((artm)localObject).readFromParcel(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public aryh.b[] a()
  {
    return new aryh.b[] { new aryh.b("groupId", "INTEGER UNIQUE"), new aryh.b("data", "BLOB") };
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public int version()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artn
 * JD-Core Version:    0.7.0.1
 */