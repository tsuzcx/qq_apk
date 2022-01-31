import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class vmo
  implements Runnable
{
  vmo(vmm paramvmm, List paramList) {}
  
  public void run()
  {
    Iterator localIterator1 = this.jdField_a_of_type_Vmm.a.a.iterator();
    label103:
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localIterator2.next();
          if (str.equals(localLocalMediaInfo.path)) {
            localLocalMediaInfo.mChecked = true;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label103;
        }
        localIterator1.remove();
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vmo
 * JD-Core Version:    0.7.0.1
 */