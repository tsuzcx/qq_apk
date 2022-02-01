import com.tencent.biz.qqstory.album.StoryAlbumResourceDownloader.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class wbw
{
  public static int a;
  private static wbw jdField_a_of_type_Wbw;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private String a(int paramInt)
  {
    if (paramInt == jdField_a_of_type_Int) {
      return nku.a("3408") + "3408" + File.separator + "loading" + File.separator;
    }
    return "";
  }
  
  public static wbw a()
  {
    if (jdField_a_of_type_Wbw == null) {
      jdField_a_of_type_Wbw = new wbw();
    }
    return jdField_a_of_type_Wbw;
  }
  
  private void a(boolean paramBoolean)
  {
    yqp.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource , upzip : %s", Boolean.valueOf(paramBoolean));
    nko.b("3408", bojv.a(), new wby(this, paramBoolean), paramBoolean, 0, true);
  }
  
  private void b()
  {
    yqp.b("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "unzip now");
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new StoryAlbumResourceDownloader.3(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new File(a(jdField_a_of_type_Int));
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
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
  }
  
  public List<String> a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return new ArrayList();
    }
    if (paramInt == jdField_a_of_type_Int) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return new ArrayList();
  }
  
  public void a()
  {
    String str = a(jdField_a_of_type_Int);
    boolean bool1 = nko.d("3408");
    boolean bool2 = new File(str).exists();
    if (bool1)
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , new version exist , unzip now !");
      b();
      return;
    }
    if (bool2)
    {
      yqp.d("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , old file exist , check but not unzip now!");
      Bosses.get().postJob(new wbx(this));
      return;
    }
    yqp.d("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkAndUpdateResource , old file not exist , check and unzip now!");
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbw
 * JD-Core Version:    0.7.0.1
 */