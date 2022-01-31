import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class eef
  implements Callable
{
  public eef(SearchTask paramSearchTask, int paramInt1, int paramInt2) {}
  
  public List a()
  {
    Object localObject = SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    ISearchable localISearchable;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {
          break label141;
        }
      }
      if (!SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).equals(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask))) {
        localObject = localArrayList.iterator();
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (!this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {}
      }
      else
      {
        return localArrayList;
        label141:
        localISearchable.a(SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
        if (localISearchable.d() == -9223372036854775808L) {
          break;
        }
        int i = localArrayList.indexOf(localISearchable);
        if (-1 == i)
        {
          localArrayList.add(localISearchable);
          break;
        }
        if (((ISearchable)localArrayList.get(i)).d() >= localISearchable.d()) {
          break;
        }
        localArrayList.set(i, localISearchable);
        break;
      }
      long l = localISearchable.d();
      localISearchable.a(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
      if (localISearchable.d() == -9223372036854775808L) {
        localISearchable.a(l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eef
 * JD-Core Version:    0.7.0.1
 */