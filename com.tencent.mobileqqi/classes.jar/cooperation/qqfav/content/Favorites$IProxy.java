package cooperation.qqfav.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public abstract interface Favorites$IProxy
{
  public abstract int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
  
  public abstract int a(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  public abstract Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract Uri a(Uri paramUri, ContentValues paramContentValues);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.content.Favorites.IProxy
 * JD-Core Version:    0.7.0.1
 */