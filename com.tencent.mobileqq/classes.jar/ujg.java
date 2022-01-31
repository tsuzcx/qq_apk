import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ujg
  implements slx<szd, slu>
{
  ujg(uje paramuje) {}
  
  public void a(@NonNull szd paramszd, @Nullable slu paramslu, @NonNull ErrorMessage paramErrorMessage)
  {
    paramslu = (sze)paramslu;
    int j = paramErrorMessage.errorCode;
    int k = paramszd.b.size();
    if (paramslu == null) {}
    for (int i = 0;; i = paramslu.jdField_a_of_type_JavaUtilList.size())
    {
      urk.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramszd.b });
      if ((!paramErrorMessage.isFail()) && (paramslu != null)) {
        break;
      }
      paramszd = paramszd.jdField_a_of_type_JavaUtilList.iterator();
      while (paramszd.hasNext())
      {
        paramslu = (uiw)paramszd.next();
        uje.a().remove(paramslu.a);
      }
    }
    if (paramszd.jdField_a_of_type_JavaUtilList.size() != paramslu.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramszd = paramszd.jdField_a_of_type_JavaUtilList.iterator();
      while (paramszd.hasNext())
      {
        uiw localuiw = (uiw)paramszd.next();
        if (!paramslu.jdField_a_of_type_JavaUtilHashSet.contains(localuiw.a))
        {
          paramErrorMessage.add(localuiw.a);
          uje.a().remove(localuiw.a);
        }
      }
      urk.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramszd = paramslu.jdField_a_of_type_JavaUtilList.iterator();
    while (paramszd.hasNext())
    {
      paramslu = (ukt)paramszd.next();
      this.a.a(paramslu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujg
 * JD-Core Version:    0.7.0.1
 */