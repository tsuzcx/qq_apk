import android.support.annotation.NonNull;
import java.io.File;

public abstract class pnq
{
  protected pnq a;
  protected String[] bM;
  
  public pnq(@NonNull String[] paramArrayOfString)
  {
    this.bM = paramArrayOfString;
  }
  
  public static double a(File paramFile)
  {
    double d1 = 0.0D;
    double d2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      d2 = d1;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          d2 = d1;
          if (i >= j) {
            break;
          }
          d2 = a(paramFile[i]);
          i += 1;
          d1 = d2 + d1;
        }
      }
    }
    else
    {
      d2 = paramFile.length() / 1024.0D / 1024.0D;
    }
    return d2;
  }
  
  public pnq a(pnq parampnq)
  {
    this.a = parampnq;
    return this.a;
  }
  
  public void a(pnq.a parama)
  {
    a(this.bM, parama);
    if (this.a != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.a.a(parama);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ram.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = rox.dY() / 1024L;
      ram.w("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - parama.startTime), Long.valueOf(l) });
      if (parama.bjw != 0) {
        rar.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(parama.bjw), String.valueOf(parama.bi), String.valueOf(l) });
      }
    } while (parama.bjx == 0);
    rar.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(parama.bjx), String.valueOf(parama.bj), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, pnq.a parama);
  
  public void deleteFile(File paramFile)
  {
    try
    {
      rox.fA(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      ram.w("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public static class a
  {
    public boolean aAR;
    public double bi;
    public double bj;
    public int bjw;
    public int bjx;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnq
 * JD-Core Version:    0.7.0.1
 */