import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class xnr
  implements vqp<wdu, vqm>
{
  xnr(xnp paramxnp) {}
  
  public void a(@NonNull wdu paramwdu, @Nullable vqm paramvqm, @NonNull ErrorMessage paramErrorMessage)
  {
    paramvqm = (wdv)paramvqm;
    int j = paramErrorMessage.errorCode;
    int k = paramwdu.b.size();
    if (paramvqm == null) {}
    for (int i = 0;; i = paramvqm.jdField_a_of_type_JavaUtilList.size())
    {
      xvv.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramwdu.b });
      if ((!paramErrorMessage.isFail()) && (paramvqm != null)) {
        break;
      }
      paramwdu = paramwdu.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwdu.hasNext())
      {
        paramvqm = (xnh)paramwdu.next();
        xnp.a().remove(paramvqm.a);
      }
    }
    if (paramwdu.jdField_a_of_type_JavaUtilList.size() != paramvqm.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramwdu = paramwdu.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwdu.hasNext())
      {
        xnh localxnh = (xnh)paramwdu.next();
        if (!paramvqm.jdField_a_of_type_JavaUtilHashSet.contains(localxnh.a))
        {
          paramErrorMessage.add(localxnh.a);
          xnp.a().remove(localxnh.a);
        }
      }
      xvv.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramwdu = paramvqm.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwdu.hasNext())
    {
      paramvqm = (xpe)paramwdu.next();
      this.a.a(paramvqm.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnr
 * JD-Core Version:    0.7.0.1
 */