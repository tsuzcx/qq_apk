import android.util.LruCache;

class yba
  extends LruCache<String, yas>
{
  yba(yaz paramyaz, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, yas paramyas1, yas paramyas2)
  {
    super.entryRemoved(paramBoolean, paramString, paramyas1, paramyas2);
    yaq.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramyas1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yba
 * JD-Core Version:    0.7.0.1
 */