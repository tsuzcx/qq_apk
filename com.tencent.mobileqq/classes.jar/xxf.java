import android.util.LruCache;

class xxf
  extends LruCache<String, xwx>
{
  xxf(xxe paramxxe, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, xwx paramxwx1, xwx paramxwx2)
  {
    super.entryRemoved(paramBoolean, paramString, paramxwx1, paramxwx2);
    xwv.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramxwx1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxf
 * JD-Core Version:    0.7.0.1
 */