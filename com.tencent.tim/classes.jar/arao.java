import android.util.LruCache;

public final class arao
  extends LruCache<String, uaw>
{
  public arao(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, uaw paramuaw1, uaw paramuaw2)
  {
    super.entryRemoved(paramBoolean, paramString, paramuaw1, paramuaw2);
    paramuaw1.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arao
 * JD-Core Version:    0.7.0.1
 */