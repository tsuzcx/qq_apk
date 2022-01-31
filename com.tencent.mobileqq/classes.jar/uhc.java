import android.support.v4.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class uhc
  extends LruCache<KEY, VALUE>
{
  uhc(uhb paramuhb, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, KEY paramKEY, VALUE paramVALUE1, VALUE paramVALUE2)
  {
    this.a.a.put(paramKEY, new WeakReference(paramVALUE1));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */