import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(14)
public class pnt
  extends pnq
{
  protected int bjy;
  protected int mMaxCount;
  
  public pnt(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (psr)psx.a(10);
    this.mMaxCount = ((Integer)paramArrayOfString.c("StoryFriendCacheCountMax", Integer.valueOf(300))).intValue();
    this.bjy = ((Integer)paramArrayOfString.c("StoryFriendCacheCountNormal", Integer.valueOf(200))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, pnq.a parama)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    String str;
    int j;
    if (i < m)
    {
      str = paramArrayOfString[i];
      if (parama.aAR)
      {
        j = 50;
        label31:
        if (!o(str, j)) {
          break label60;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = this.mMaxCount;
      break label31;
      label60:
      File localFile = new File(str);
      double d = a(localFile);
      File[] arrayOfFile = localFile.listFiles();
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      j = 0;
      while (j < k)
      {
        localArrayList.add(new pnt.a(arrayOfFile[j]));
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
          deleteFile(((pnt.a)localArrayList.get(j)).file);
          k += 1;
          j += 1;
        }
      }
      parama.bj = (d - a(localFile) + parama.bj);
      parama.bjx += k;
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
    public final File file;
    public final long modifyTime;
    
    public a(File paramFile)
    {
      this.file = paramFile;
      this.modifyTime = paramFile.lastModified();
    }
    
    public int a(a parama)
    {
      if (this.modifyTime < parama.modifyTime) {
        return -1;
      }
      if (this.modifyTime == parama.modifyTime) {
        return 0;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnt
 * JD-Core Version:    0.7.0.1
 */