import android.util.LruCache;

class jgr
  extends LruCache<String, jgq.a>
{
  jgr(jgq paramjgq, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, jgq.a parama)
  {
    if (parama == null) {
      return 0;
    }
    return parama.data.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgr
 * JD-Core Version:    0.7.0.1
 */