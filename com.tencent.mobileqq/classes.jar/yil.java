import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class yil
  implements wld<wyj, wla>
{
  yil(yij paramyij) {}
  
  public void a(@NonNull wyj paramwyj, @Nullable wla paramwla, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwla = (wyk)paramwla;
    int j = paramErrorMessage.errorCode;
    int k = paramwyj.b.size();
    if (paramwla == null) {}
    for (int i = 0;; i = paramwla.jdField_a_of_type_JavaUtilList.size())
    {
      yqp.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramwyj.b });
      if ((!paramErrorMessage.isFail()) && (paramwla != null)) {
        break;
      }
      paramwyj = paramwyj.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwyj.hasNext())
      {
        paramwla = (yib)paramwyj.next();
        yij.a().remove(paramwla.a);
      }
    }
    if (paramwyj.jdField_a_of_type_JavaUtilList.size() != paramwla.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramwyj = paramwyj.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwyj.hasNext())
      {
        yib localyib = (yib)paramwyj.next();
        if (!paramwla.jdField_a_of_type_JavaUtilHashSet.contains(localyib.a))
        {
          paramErrorMessage.add(localyib.a);
          yij.a().remove(localyib.a);
        }
      }
      yqp.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramwyj = paramwla.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwyj.hasNext())
    {
      paramwla = (yjy)paramwyj.next();
      this.a.a(paramwla.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yil
 * JD-Core Version:    0.7.0.1
 */