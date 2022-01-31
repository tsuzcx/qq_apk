import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.FloorJumper;
import com.tencent.mobileqq.activity.aio.anim.FloorJumperSet;
import com.tencent.mobileqq.activity.aio.anim.IAioAnimListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

public class ukq
  implements Runnable
{
  private ukq(FloorJumperSet paramFloorJumperSet) {}
  
  public void run()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l1 = -1L;
    if (localIterator.hasNext())
    {
      Object localObject = (FloorJumper)localIterator.next();
      long l2 = ((FloorJumper)localObject).a();
      if (l2 >= 0L)
      {
        if (l1 < 0L) {}
        for (l1 = l2;; l1 = Math.min(l1, l2)) {
          break;
        }
      }
      localIterator.remove();
      if (QLog.isColorLevel()) {
        QLog.d("FloorJumperSet", 2, "removed businessId:" + ((FloorJumper)localObject).c);
      }
      if (((FloorJumper)localObject).c == 1)
      {
        localObject = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((FloorJumper)((Iterator)localObject).next()).c != 1);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
      }
      break;
      if (l1 >= 0L)
      {
        if (FloorJumperSet.a(this.a) == 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this, l1);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      }
      do
      {
        return;
        this.a.d();
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a == null);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukq
 * JD-Core Version:    0.7.0.1
 */