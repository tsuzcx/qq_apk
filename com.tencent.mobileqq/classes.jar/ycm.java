import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ycm
  implements wfk<wsp, wfh>
{
  ycm(yck paramyck) {}
  
  public void a(@NonNull wsp paramwsp, @Nullable wfh paramwfh, @NonNull ErrorMessage paramErrorMessage)
  {
    paramwfh = (wsq)paramwfh;
    int j = paramErrorMessage.errorCode;
    int k = paramwsp.b.size();
    if (paramwfh == null) {}
    for (int i = 0;; i = paramwfh.jdField_a_of_type_JavaUtilList.size())
    {
      ykq.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramwsp.b });
      if ((!paramErrorMessage.isFail()) && (paramwfh != null)) {
        break;
      }
      paramwsp = paramwsp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwsp.hasNext())
      {
        paramwfh = (ycc)paramwsp.next();
        yck.a().remove(paramwfh.a);
      }
    }
    if (paramwsp.jdField_a_of_type_JavaUtilList.size() != paramwfh.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramwsp = paramwsp.jdField_a_of_type_JavaUtilList.iterator();
      while (paramwsp.hasNext())
      {
        ycc localycc = (ycc)paramwsp.next();
        if (!paramwfh.jdField_a_of_type_JavaUtilHashSet.contains(localycc.a))
        {
          paramErrorMessage.add(localycc.a);
          yck.a().remove(localycc.a);
        }
      }
      ykq.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramwsp = paramwfh.jdField_a_of_type_JavaUtilList.iterator();
    while (paramwsp.hasNext())
    {
      paramwfh = (ydz)paramwsp.next();
      this.a.a(paramwfh.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycm
 * JD-Core Version:    0.7.0.1
 */