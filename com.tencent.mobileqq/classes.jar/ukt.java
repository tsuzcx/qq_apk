import android.util.LruCache;

class ukt
  extends LruCache<String, ukl>
{
  ukt(uks paramuks, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, ukl paramukl1, ukl paramukl2)
  {
    super.entryRemoved(paramBoolean, paramString, paramukl1, paramukl2);
    ukj.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramukl1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukt
 * JD-Core Version:    0.7.0.1
 */