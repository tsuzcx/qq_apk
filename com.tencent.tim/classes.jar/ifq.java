import android.support.v4.util.LruCache;

class ifq
  extends LruCache<String, String>
{
  ifq(ifp paramifp, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifq
 * JD-Core Version:    0.7.0.1
 */