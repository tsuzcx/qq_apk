import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ymg
  implements woy<xce, wov>
{
  ymg(yme paramyme) {}
  
  public void a(@NonNull xce paramxce, @Nullable wov paramwov, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwov = (xcf)paramwov;
    int j = paramErrorMessage.errorCode;
    int k = paramxce.b.size();
    if (paramwov == null) {}
    for (int i = 0;; i = paramwov.jdField_a_of_type_JavaUtilList.size())
    {
      yuk.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramxce.b });
      if ((!paramErrorMessage.isFail()) && (paramwov != null)) {
        break;
      }
      paramxce = paramxce.jdField_a_of_type_JavaUtilList.iterator();
      while (paramxce.hasNext())
      {
        paramwov = (ylw)paramxce.next();
        yme.a().remove(paramwov.a);
      }
    }
    if (paramxce.jdField_a_of_type_JavaUtilList.size() != paramwov.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramxce = paramxce.jdField_a_of_type_JavaUtilList.iterator();
      while (paramxce.hasNext())
      {
        ylw localylw = (ylw)paramxce.next();
        if (!paramwov.jdField_a_of_type_JavaUtilHashSet.contains(localylw.a))
        {
          paramErrorMessage.add(localylw.a);
          yme.a().remove(localylw.a);
        }
      }
      yuk.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramxce = paramwov.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxce.hasNext())
    {
      paramwov = (ynt)paramxce.next();
      this.a.a(paramwov.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */