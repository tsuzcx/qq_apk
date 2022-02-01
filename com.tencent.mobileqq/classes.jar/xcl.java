import android.util.LruCache;

class xcl
  extends LruCache<String, xcd>
{
  xcl(xck paramxck, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, xcd paramxcd1, xcd paramxcd2)
  {
    super.entryRemoved(paramBoolean, paramString, paramxcd1, paramxcd2);
    xcb.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramxcd1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcl
 * JD-Core Version:    0.7.0.1
 */