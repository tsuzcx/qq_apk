import android.util.LruCache;

class ablm
  extends LruCache<String, abll.a>
{
  ablm(abll paramabll, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, abll.a parama)
  {
    if ((parama == null) || (parama.mData == null)) {
      return 0;
    }
    return parama.mData.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ablm
 * JD-Core Version:    0.7.0.1
 */