import android.content.ContentValues;
import android.database.Cursor;

public abstract class aryh
{
  public abstract void writeTo(ContentValues paramContentValues);
  
  public static abstract interface a<T extends aryh>
  {
    public abstract T a(Cursor paramCursor);
    
    public abstract aryh.b[] a();
    
    public abstract String sortOrder();
    
    public abstract int version();
  }
  
  public static class b
  {
    protected String mName;
    protected String mType;
    
    public b(String paramString1, String paramString2)
    {
      this.mName = paramString1;
      this.mType = paramString2;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getType()
    {
      return this.mType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryh
 * JD-Core Version:    0.7.0.1
 */