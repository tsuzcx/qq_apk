import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pnu
  extends pnq
{
  protected int bjy;
  protected int mMaxCount;
  
  public pnu(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (psr)psx.a(10);
    this.mMaxCount = ((Integer)paramArrayOfString.c("StoryMyCacheCountMax", Integer.valueOf(200))).intValue();
    this.bjy = ((Integer)paramArrayOfString.c("StoryMyCacheCountNormal", Integer.valueOf(100))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, pnq.a parama)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    String str;
    if (i < m)
    {
      str = paramArrayOfString[i];
      if (!o(str, this.mMaxCount)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      File localFile = new File(str);
      double d = a(localFile);
      File[] arrayOfFile = localFile.listFiles();
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      int j = 0;
      while (j < k)
      {
        localArrayList.add(new pnu.a(arrayOfFile[j]));
        j += 1;
      }
      Collections.sort(localArrayList);
      int n = localArrayList.size();
      k = 0;
      j = 0;
      while (j < n)
      {
        if (j % 150 == 0) {}
        try
        {
          Thread.sleep(100L);
          if ((j % 20 == 0) && (o(str, this.bjy))) {
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          deleteFile(((pnu.a)localArrayList.get(j)).file);
          k += 1;
          j += 1;
        }
      }
      parama.bi = (d - a(localFile) + parama.bi);
      parama.bjw += k;
    }
  }
  
  public boolean o(String paramString, int paramInt)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {}
    while (paramString.length <= paramInt) {
      return true;
    }
    return false;
  }
  
  class a
    implements Comparable<a>
  {
    public long createTime;
    public final File file;
    
    public a(File paramFile)
    {
      this.file = paramFile;
      this$1 = paramFile.getName();
      try
      {
        this.createTime = Long.parseLong(pnu.this);
        return;
      }
      catch (Exception paramFile)
      {
        ram.w("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { pnu.this, paramFile.getMessage() });
      }
    }
    
    public int a(a parama)
    {
      if (this.createTime < parama.createTime) {
        return -1;
      }
      if (this.createTime == parama.createTime) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnu
 * JD-Core Version:    0.7.0.1
 */