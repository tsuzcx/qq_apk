import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public class ozo
{
  private WeakReference<ozo.c> E;
  private AtomicInteger ac;
  private AtomicInteger ad;
  private Map<String, ozo.a> fv;
  private List<ozo.b> lp;
  
  public void a(ozo.b paramb)
  {
    if (this.lp == null) {
      this.lp = new ArrayList();
    }
    this.lp.add(paramb);
  }
  
  public void a(ozo.c paramc)
  {
    this.E = new WeakReference(paramc);
  }
  
  public void start()
  {
    this.ac = new AtomicInteger(0);
    this.ad = new AtomicInteger(0);
    int i = this.lp.size();
    this.fv = new ConcurrentHashMap();
    Iterator localIterator = this.lp.iterator();
    while (localIterator.hasNext())
    {
      ozo.b localb = (ozo.b)localIterator.next();
      ozq.a().a(localb.mDownloadUrl, new ozp(this, localb, i));
    }
  }
  
  public static class a
  {
    public String mDownloadUrl;
    public String mFilePath;
    public boolean mIsSuccess;
    
    public a(String paramString1, boolean paramBoolean, String paramString2)
    {
      this.mDownloadUrl = paramString1;
      this.mIsSuccess = paramBoolean;
      this.mFilePath = paramString2;
    }
  }
  
  public static class b
  {
    public String mDownloadUrl;
    
    public b(String paramString)
    {
      this.mDownloadUrl = paramString;
    }
  }
  
  public static abstract interface c
  {
    public abstract void b(boolean paramBoolean, Map<String, ozo.a> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozo
 * JD-Core Version:    0.7.0.1
 */