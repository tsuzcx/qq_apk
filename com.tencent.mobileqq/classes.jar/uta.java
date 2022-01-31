import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class uta
  extends QQUIEventReceiver<usw, utq>
{
  public uta(usw paramusw)
  {
    super(paramusw);
  }
  
  public void a(@NonNull usw paramusw, @NonNull utq paramutq)
  {
    if (paramutq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramutq = paramutq.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramutq.hasNext(); i = ((MomeriesYearNode)paramutq.next()).videoCount + i) {}
      if (i >= 0)
      {
        veg.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        usw.a(paramusw, i);
        if (paramusw.a != null)
        {
          paramusw.a.videoCount = usw.a(paramusw);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramusw), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return utq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uta
 * JD-Core Version:    0.7.0.1
 */