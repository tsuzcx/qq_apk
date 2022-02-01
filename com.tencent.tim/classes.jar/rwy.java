import com.jakewharton.disklrucache.DiskLruCache.Snapshot;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class rwy
{
  protected static int bvF;
  protected static ArrayList<String[]> nS = new ArrayList();
  
  public abstract boolean R(String paramString1, String paramString2);
  
  public abstract rwy.a a(String paramString);
  
  public abstract boolean a(String paramString, InputStream paramInputStream);
  
  public void bnE()
  {
    for (;;)
    {
      try
      {
        int i = bvF;
        if (i >= 1) {
          return;
        }
        bvF += 1;
        if (nS.size() > 0)
        {
          String[] arrayOfString = (String[])nS.remove(0);
          R(arrayOfString[0], arrayOfString[1]);
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        else
        {
          bvF -= 1;
        }
      }
      finally {}
    }
  }
  
  public abstract void clear();
  
  public abstract boolean fR(String paramString);
  
  public String gs(String paramString)
  {
    return oav.md5(paramString);
  }
  
  public abstract void remove(String paramString);
  
  public class a
  {
    private DiskLruCache.Snapshot a;
    private InputStream mInputStream;
    
    public a() {}
    
    public void a(DiskLruCache.Snapshot paramSnapshot)
    {
      this.a = paramSnapshot;
    }
    
    public InputStream getInputStream()
    {
      return this.mInputStream;
    }
    
    public void setInputStream(InputStream paramInputStream)
    {
      this.mInputStream = paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwy
 * JD-Core Version:    0.7.0.1
 */