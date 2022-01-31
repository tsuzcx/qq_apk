import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class uvz
  implements syq<tlw, syn>
{
  uvz(uvx paramuvx) {}
  
  public void a(@NonNull tlw paramtlw, @Nullable syn paramsyn, @NonNull ErrorMessage paramErrorMessage)
  {
    paramsyn = (tlx)paramsyn;
    int j = paramErrorMessage.errorCode;
    int k = paramtlw.b.size();
    if (paramsyn == null) {}
    for (int i = 0;; i = paramsyn.jdField_a_of_type_JavaUtilList.size())
    {
      ved.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramtlw.b });
      if ((!paramErrorMessage.isFail()) && (paramsyn != null)) {
        break;
      }
      paramtlw = paramtlw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtlw.hasNext())
      {
        paramsyn = (uvp)paramtlw.next();
        uvx.a().remove(paramsyn.a);
      }
    }
    if (paramtlw.jdField_a_of_type_JavaUtilList.size() != paramsyn.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramtlw = paramtlw.jdField_a_of_type_JavaUtilList.iterator();
      while (paramtlw.hasNext())
      {
        uvp localuvp = (uvp)paramtlw.next();
        if (!paramsyn.jdField_a_of_type_JavaUtilHashSet.contains(localuvp.a))
        {
          paramErrorMessage.add(localuvp.a);
          uvx.a().remove(localuvp.a);
        }
      }
      ved.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramtlw = paramsyn.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtlw.hasNext())
    {
      paramsyn = (uxm)paramtlw.next();
      this.a.a(paramsyn.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvz
 * JD-Core Version:    0.7.0.1
 */