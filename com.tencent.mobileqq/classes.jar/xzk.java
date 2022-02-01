import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class xzk
  extends QQUIEventReceiver<xzg, yaa>
{
  public xzk(xzg paramxzg)
  {
    super(paramxzg);
  }
  
  public void a(@NonNull xzg paramxzg, @NonNull yaa paramyaa)
  {
    if (paramyaa.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramyaa = paramyaa.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramyaa.hasNext(); i = ((MomeriesYearNode)paramyaa.next()).videoCount + i) {}
      if (i >= 0)
      {
        ykq.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        xzg.a(paramxzg, i);
        if (paramxzg.a != null)
        {
          paramxzg.a.videoCount = xzg.a(paramxzg);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramxzg), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return yaa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzk
 * JD-Core Version:    0.7.0.1
 */