import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class wkr
  implements uni<vao, unf>
{
  wkr(wkp paramwkp) {}
  
  public void a(@NonNull vao paramvao, @Nullable unf paramunf, @NonNull ErrorMessage paramErrorMessage)
  {
    paramunf = (vap)paramunf;
    int j = paramErrorMessage.errorCode;
    int k = paramvao.b.size();
    if (paramunf == null) {}
    for (int i = 0;; i = paramunf.jdField_a_of_type_JavaUtilList.size())
    {
      wsv.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramvao.b });
      if ((!paramErrorMessage.isFail()) && (paramunf != null)) {
        break;
      }
      paramvao = paramvao.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvao.hasNext())
      {
        paramunf = (wkh)paramvao.next();
        wkp.a().remove(paramunf.a);
      }
    }
    if (paramvao.jdField_a_of_type_JavaUtilList.size() != paramunf.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramvao = paramvao.jdField_a_of_type_JavaUtilList.iterator();
      while (paramvao.hasNext())
      {
        wkh localwkh = (wkh)paramvao.next();
        if (!paramunf.jdField_a_of_type_JavaUtilHashSet.contains(localwkh.a))
        {
          paramErrorMessage.add(localwkh.a);
          wkp.a().remove(localwkh.a);
        }
      }
      wsv.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramvao = paramunf.jdField_a_of_type_JavaUtilList.iterator();
    while (paramvao.hasNext())
    {
      paramunf = (wme)paramvao.next();
      this.a.a(paramunf.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkr
 * JD-Core Version:    0.7.0.1
 */