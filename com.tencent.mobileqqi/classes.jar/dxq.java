import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AnimationPath;
import com.tencent.mobileqq.activity.aio.anim.AnimationPath.Values;
import com.tencent.mobileqq.activity.aio.anim.PathAnimation;
import com.tencent.mobileqq.bubble.ChatXListView;
import java.util.ArrayList;
import java.util.Iterator;

public class dxq
  implements Runnable
{
  private dxq(PathAnimation paramPathAnimation) {}
  
  public void run()
  {
    long l3 = AnimationUtils.currentAnimationTimeMillis();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l2 = -1L;
    if (localIterator.hasNext())
    {
      AnimationPath.Values localValues = (AnimationPath.Values)localIterator.next();
      long l1;
      if (l3 < localValues.jdField_a_of_type_Long)
      {
        l1 = localValues.jdField_a_of_type_Long - l3;
        label63:
        if (l1 < 0L) {
          break label195;
        }
        if (l2 >= 0L) {
          break label186;
        }
        label75:
        this.a.a(localValues.jdField_a_of_type_AndroidViewView, localValues);
      }
      for (;;)
      {
        l2 = l1;
        break;
        if (!localValues.jdField_a_of_type_Boolean)
        {
          l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(localValues, localValues.jdField_a_of_type_AndroidViewView.getWidth(), localValues.jdField_a_of_type_AndroidViewView.getHeight(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight());
          localValues.jdField_a_of_type_Boolean = true;
          break label63;
        }
        l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(l3 - localValues.jdField_a_of_type_Long, localValues);
        break label63;
        label186:
        l1 = Math.min(l2, l1);
        break label75;
        label195:
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(localValues.jdField_a_of_type_AndroidViewView);
        localIterator.remove();
        l1 = l2;
      }
    }
    if (l2 >= 0L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(this, l2);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dxq
 * JD-Core Version:    0.7.0.1
 */