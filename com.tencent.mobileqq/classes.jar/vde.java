import com.tencent.biz.qqstory.network.handler.GetUserIconHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class vde
{
  private static final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  public static boolean a;
  
  public static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      if (!jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        jdField_a_of_type_JavaUtilArrayList.add(paramString);
        jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
        ThreadManager.post(new GetUserIconHandler.1(), 5, null, true);
      }
      return;
    }
  }
  
  public static void a(ArrayList<String> paramArrayList)
  {
    paramArrayList = new vdf(paramArrayList);
    vdg localvdg = new vdg();
    utz.a().a(paramArrayList, localvdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */