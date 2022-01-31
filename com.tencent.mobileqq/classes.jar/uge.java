import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class uge
  extends QQUIEventReceiver<uga, ugu>
{
  public uge(uga paramuga)
  {
    super(paramuga);
  }
  
  public void a(@NonNull uga paramuga, @NonNull ugu paramugu)
  {
    if (paramugu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramugu = paramugu.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramugu.hasNext(); i = ((MomeriesYearNode)paramugu.next()).videoCount + i) {}
      if (i >= 0)
      {
        urk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        uga.a(paramuga, i);
        if (paramuga.a != null)
        {
          paramuga.a.videoCount = uga.a(paramuga);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramuga), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ugu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uge
 * JD-Core Version:    0.7.0.1
 */