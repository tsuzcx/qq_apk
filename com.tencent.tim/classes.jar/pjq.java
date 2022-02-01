import com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class pjq
{
  private static pjq a;
  public static int bjb;
  private boolean aAf;
  private List<String> lO = new ArrayList();
  
  public static pjq a()
  {
    if (a == null) {
      a = new pjq();
    }
    return a;
  }
  
  private String bP(int paramInt)
  {
    if (paramInt == bjb) {
      return jpe.dO("3408") + "3408" + File.separator + "loading" + File.separator;
    }
    return "";
  }
  
  private void bll()
  {
    ram.d("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "unzip now");
    this.aAf = true;
    ThreadManager.getFileThreadHandler().post(new StoryAlbumResourceDownloader.3(this));
  }
  
  private void blm()
  {
    this.lO = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new File(bP(bjb));
    Object localObject2;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          localHashMap.put(((File)localObject2).getName(), localObject2);
          i += 1;
        }
      }
    }
    localObject1 = new ArrayList();
    int i = 0;
    while (i < 50)
    {
      localObject2 = (File)localHashMap.get(i + ".png");
      if (localObject2 != null) {
        ((List)localObject1).add(((File)localObject2).getAbsolutePath());
      }
      i += 1;
    }
    this.lO = ((List)localObject1);
  }
  
  private void rB(boolean paramBoolean)
  {
    ram.b("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource , upzip : %s", Boolean.valueOf(paramBoolean));
    jpa.b("3408", axov.d(), new pjs(this, paramBoolean), paramBoolean, 0, true);
  }
  
  public void blk()
  {
    String str = bP(bjb);
    boolean bool1 = jpa.dj("3408");
    boolean bool2 = new File(str).exists();
    if (bool1)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , new version exist , unzip now !");
      bll();
      return;
    }
    if (bool2)
    {
      ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , old file exist , check but not unzip now!");
      Bosses.get().postJob(new pjr(this));
      return;
    }
    ram.w("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , old file not exist , check and unzip now!");
    rB(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pjq
 * JD-Core Version:    0.7.0.1
 */