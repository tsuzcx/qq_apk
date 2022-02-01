import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class yfj
  extends QQUIEventReceiver<yff, yfz>
{
  public yfj(yff paramyff)
  {
    super(paramyff);
  }
  
  public void a(@NonNull yff paramyff, @NonNull yfz paramyfz)
  {
    if (paramyfz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramyfz = paramyfz.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramyfz.hasNext(); i = ((MomeriesYearNode)paramyfz.next()).videoCount + i) {}
      if (i >= 0)
      {
        yqp.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        yff.a(paramyff, i);
        if (paramyff.a != null)
        {
          paramyff.a.videoCount = yff.a(paramyff);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramyff), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return yfz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfj
 * JD-Core Version:    0.7.0.1
 */