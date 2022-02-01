import android.util.LruCache;

class xrg
  extends LruCache<String, xqy>
{
  xrg(xrf paramxrf, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, xqy paramxqy1, xqy paramxqy2)
  {
    super.entryRemoved(paramBoolean, paramString, paramxqy1, paramxqy2);
    xqw.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramxqy1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrg
 * JD-Core Version:    0.7.0.1
 */