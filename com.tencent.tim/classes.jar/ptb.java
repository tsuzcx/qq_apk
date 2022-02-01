import android.os.Handler;
import com.tencent.biz.qqstory.model.TrimmableManager.1;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ptb
  implements psj
{
  private CopyOnWriteArraySet<psk> a = new CopyOnWriteArraySet();
  private Handler bh = new Handler(ThreadManager.getSubThreadLooper());
  
  public ptb()
  {
    this.a.add(new ptb.a());
  }
  
  private void vW(int paramInt)
  {
    ram.w("TrimmableManager", "trimMemory : level = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((psk)localIterator.next()).trimMemory(paramInt);
    }
    System.gc();
  }
  
  public void a(psk parampsk)
  {
    this.a.add(parampsk);
  }
  
  public void b(psk parampsk)
  {
    this.a.remove(parampsk);
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void vV(int paramInt)
  {
    this.bh.post(new TrimmableManager.1(this, paramInt));
  }
  
  public static class a
    implements psk
  {
    public void trimMemory(int paramInt)
    {
      switch (paramInt)
      {
      case 0: 
      default: 
        return;
      }
      URLDrawable.clearMemoryCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptb
 * JD-Core Version:    0.7.0.1
 */