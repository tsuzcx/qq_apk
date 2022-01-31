import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class whp
  extends QQUIEventReceiver<whl, wif>
{
  public whp(whl paramwhl)
  {
    super(paramwhl);
  }
  
  public void a(@NonNull whl paramwhl, @NonNull wif paramwif)
  {
    if (paramwif.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramwif = paramwif.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramwif.hasNext(); i = ((MomeriesYearNode)paramwif.next()).videoCount + i) {}
      if (i >= 0)
      {
        wsv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        whl.a(paramwhl, i);
        if (paramwhl.a != null)
        {
          paramwhl.a.videoCount = whl.a(paramwhl);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramwhl), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wif.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whp
 * JD-Core Version:    0.7.0.1
 */