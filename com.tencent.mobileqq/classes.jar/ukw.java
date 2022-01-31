import android.util.LruCache;

class ukw
  extends LruCache<String, uko>
{
  ukw(ukv paramukv, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, uko paramuko1, uko paramuko2)
  {
    super.entryRemoved(paramBoolean, paramString, paramuko1, paramuko2);
    ukm.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramuko1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukw
 * JD-Core Version:    0.7.0.1
 */