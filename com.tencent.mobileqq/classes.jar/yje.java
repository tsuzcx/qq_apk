import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class yje
  extends QQUIEventReceiver<yja, yju>
{
  public yje(yja paramyja)
  {
    super(paramyja);
  }
  
  public void a(@NonNull yja paramyja, @NonNull yju paramyju)
  {
    if (paramyju.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramyju = paramyju.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramyju.hasNext(); i = ((MomeriesYearNode)paramyju.next()).videoCount + i) {}
      if (i >= 0)
      {
        yuk.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        yja.a(paramyja, i);
        if (paramyja.a != null)
        {
          paramyja.a.videoCount = yja.a(paramyja);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramyja), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return yju.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yje
 * JD-Core Version:    0.7.0.1
 */