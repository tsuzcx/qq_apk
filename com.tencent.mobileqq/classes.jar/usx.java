import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class usx
  extends QQUIEventReceiver<ust, utn>
{
  public usx(ust paramust)
  {
    super(paramust);
  }
  
  public void a(@NonNull ust paramust, @NonNull utn paramutn)
  {
    if (paramutn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramutn = paramutn.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramutn.hasNext(); i = ((MomeriesYearNode)paramutn.next()).videoCount + i) {}
      if (i >= 0)
      {
        ved.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        ust.a(paramust, i);
        if (paramust.a != null)
        {
          paramust.a.videoCount = ust.a(paramust);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramust), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return utn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usx
 * JD-Core Version:    0.7.0.1
 */