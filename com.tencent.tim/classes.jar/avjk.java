import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public abstract interface avjk
{
  public static final Uri R = Uri.parse("content://tim.favorites/biz_related");
  public static final Uri S = Uri.parse("content://tim.favorites/global_search");
  
  public static abstract interface a
  {
    public abstract int delete(Uri paramUri, String paramString, String[] paramArrayOfString);
    
    public abstract Uri insert(Uri paramUri, ContentValues paramContentValues);
    
    public abstract Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
    
    public abstract int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avjk
 * JD-Core Version:    0.7.0.1
 */