import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class wpa
  implements urr<vex, uro>
{
  wpa(woy paramwoy) {}
  
  public void a(@NonNull vex paramvex, @Nullable uro paramuro, @NonNull ErrorMessage paramErrorMessage)
  {
    paramuro = (vey)paramuro;
    int j = paramErrorMessage.errorCode;
    int k = paramvex.b.size();
    if (paramuro == null) {}
    for (int i = 0;; i = paramuro.jdField_a_of_type_JavaUtilList.size())
    {
      wxe.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramvex.b });
      if ((!paramErrorMessage.isFail()) && (paramuro != null)) {
        break;
      }
      paramvex = paramvex.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvex.hasNext())
      {
        paramuro = (woq)paramvex.next();
        woy.a().remove(paramuro.a);
      }
    }
    if (paramvex.jdField_a_of_type_JavaUtilList.size() != paramuro.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramvex = paramvex.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvex.hasNext())
      {
        woq localwoq = (woq)paramvex.next();
        if (!paramuro.jdField_a_of_type_JavaUtilHashSet.contains(localwoq.a))
        {
          paramErrorMessage.add(localwoq.a);
          woy.a().remove(localwoq.a);
        }
      }
      wxe.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramvex = paramuro.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvex.hasNext())
    {
      paramuro = (wqn)paramvex.next();
      this.a.a(paramuro.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpa
 * JD-Core Version:    0.7.0.1
 */