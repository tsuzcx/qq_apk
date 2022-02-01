import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class xkp
  extends QQUIEventReceiver<xkl, xlf>
{
  public xkp(xkl paramxkl)
  {
    super(paramxkl);
  }
  
  public void a(@NonNull xkl paramxkl, @NonNull xlf paramxlf)
  {
    if (paramxlf.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramxlf = paramxlf.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramxlf.hasNext(); i = ((MomeriesYearNode)paramxlf.next()).videoCount + i) {}
      if (i >= 0)
      {
        xvv.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        xkl.a(paramxkl, i);
        if (paramxkl.a != null)
        {
          paramxkl.a.videoCount = xkl.a(paramxkl);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramxkl), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xlf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkp
 * JD-Core Version:    0.7.0.1
 */