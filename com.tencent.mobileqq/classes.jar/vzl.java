import android.util.LruCache;

class vzl
  extends LruCache<String, vzd>
{
  vzl(vzk paramvzk, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, vzd paramvzd1, vzd paramvzd2)
  {
    super.entryRemoved(paramBoolean, paramString, paramvzd1, paramvzd2);
    vzb.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramvzd1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */