import android.graphics.Bitmap;
import com.tencent.common.cache.MemoryClearManagerNew.IClearMemoryListener;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.util.Utils;
import com.tencent.widget.UpSideDownDrawable;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class thq
  implements MemoryClearManagerNew.IClearMemoryListener
{
  public thq(QQSettingMe paramQQSettingMe) {}
  
  public int a()
  {
    if (QQSettingMe.a(this.a).size() > 0)
    {
      Iterator localIterator = QQSettingMe.a(this.a).values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((UpSideDownDrawable)localIterator.next()).a();
        if (localBitmap == null) {
          break label79;
        }
        i = Utils.a(localBitmap) + i;
      }
      label79:
      for (;;)
      {
        break;
        QQSettingMe.a(this.a).clear();
        return i;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     thq
 * JD-Core Version:    0.7.0.1
 */