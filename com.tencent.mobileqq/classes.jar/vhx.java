import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class vhx
{
  public static int a;
  private static vhx jdField_a_of_type_Vhx;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private String a(int paramInt)
  {
    if (paramInt == jdField_a_of_type_Int) {
      return noe.a("3408") + "3408" + File.separator + "loading" + File.separator;
    }
    return "";
  }
  
  public static vhx a()
  {
    if (jdField_a_of_type_Vhx == null) {
      jdField_a_of_type_Vhx = new vhx();
    }
    return jdField_a_of_type_Vhx;
  }
  
  private void a()
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
  
  private void a(boolean paramBoolean)
  {
    xvv.a("Q.qqstory.recommendAlbum.logic.StoryAlbumResourceDownloader", "checkResource , upzip : %s", Boolean.valueOf(paramBoolean));
    nny.b("3408", bmql.a(), new vhy(this, paramBoolean), paramBoolean, 0, true);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhx
 * JD-Core Version:    0.7.0.1
 */