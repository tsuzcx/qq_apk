import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class plw
  extends LruCache<KEY, VALUE>
{
  plw(plv paramplv, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, KEY paramKEY, VALUE paramVALUE1, VALUE paramVALUE2)
  {
    this.a.bQ.put(paramKEY, new WeakReference(paramVALUE1));
    this.a.blJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */