import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class wly
  extends QQUIEventReceiver<wlu, wmo>
{
  public wly(wlu paramwlu)
  {
    super(paramwlu);
  }
  
  public void a(@NonNull wlu paramwlu, @NonNull wmo paramwmo)
  {
    if (paramwmo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramwmo = paramwmo.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramwmo.hasNext(); i = ((MomeriesYearNode)paramwmo.next()).videoCount + i) {}
      if (i >= 0)
      {
        wxe.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        wlu.a(paramwlu, i);
        if (paramwlu.a != null)
        {
          paramwlu.a.videoCount = wlu.a(paramwlu);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramwlu), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wmo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wly
 * JD-Core Version:    0.7.0.1
 */