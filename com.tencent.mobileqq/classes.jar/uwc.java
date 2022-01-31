import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class uwc
  implements syt<tlz, syq>
{
  uwc(uwa paramuwa) {}
  
  public void a(@NonNull tlz paramtlz, @Nullable syq paramsyq, @NonNull ErrorMessage paramErrorMessage)
  {
    paramsyq = (tma)paramsyq;
    int j = paramErrorMessage.errorCode;
    int k = paramtlz.b.size();
    if (paramsyq == null) {}
    for (int i = 0;; i = paramsyq.jdField_a_of_type_JavaUtilList.size())
    {
      veg.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramtlz.b });
      if ((!paramErrorMessage.isFail()) && (paramsyq != null)) {
        break;
      }
      paramtlz = paramtlz.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtlz.hasNext())
      {
        paramsyq = (uvs)paramtlz.next();
        uwa.a().remove(paramsyq.a);
      }
    }
    if (paramtlz.jdField_a_of_type_JavaUtilList.size() != paramsyq.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramtlz = paramtlz.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtlz.hasNext())
      {
        uvs localuvs = (uvs)paramtlz.next();
        if (!paramsyq.jdField_a_of_type_JavaUtilHashSet.contains(localuvs.a))
        {
          paramErrorMessage.add(localuvs.a);
          uwa.a().remove(localuvs.a);
        }
      }
      veg.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramtlz = paramsyq.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtlz.hasNext())
    {
      paramsyq = (uxp)paramtlz.next();
      this.a.a(paramsyq.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwc
 * JD-Core Version:    0.7.0.1
 */