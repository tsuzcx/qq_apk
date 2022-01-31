import android.util.LruCache;

class wdu
  extends LruCache<String, wdm>
{
  wdu(wdt paramwdt, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, wdm paramwdm1, wdm paramwdm2)
  {
    super.entryRemoved(paramBoolean, paramString, paramwdm1, paramwdm2);
    wdk.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramwdm1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdu
 * JD-Core Version:    0.7.0.1
 */