import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;

public class akre
  extends ContentObserver
{
  static final String[] PROJECTION = { "_data", "date_added" };
  private static final String apU = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private akre.a a;
  private ContentResolver contentResolver;
  
  public akre(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
    this.contentResolver = paramContext.getContentResolver();
  }
  
  public void a(akre.a parama)
  {
    this.a = parama;
  }
  
  public void bdL()
  {
    this.contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
  }
  
  public void bdM()
  {
    this.contentResolver.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    Cursor localCursor;
    String str;
    long l;
    if (paramUri == null)
    {
      localCursor = alld.query(this.contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PROJECTION, null, null, "date_added DESC");
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        str = localCursor.getString(localCursor.getColumnIndex("_data"));
        l = localCursor.getLong(localCursor.getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (str.toLowerCase().contains("screenshot")) && (this.a != null)) {
          this.a.g(paramUri);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramUri.toString().matches(apU + "/\\d+"));
      localCursor = alld.query(this.contentResolver, paramUri, PROJECTION, null, null, null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        str = localCursor.getString(localCursor.getColumnIndex("_data"));
        l = localCursor.getLong(localCursor.getColumnIndex("date_added"));
        if ((Math.abs(System.currentTimeMillis() / 1000L - l) <= 3L) && (str.toLowerCase().contains("screenshot")) && (this.a != null)) {
          this.a.g(paramUri);
        }
      }
    } while (localCursor == null);
    localCursor.close();
  }
  
  public static abstract interface a
  {
    public abstract void g(Uri paramUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akre
 * JD-Core Version:    0.7.0.1
 */