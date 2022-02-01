import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ykr
  extends QQUIEventReceiver<ykq, wop>
{
  public ykr(ykq paramykq1, @NonNull ykq paramykq2)
  {
    super(paramykq2);
  }
  
  public void a(@NonNull ykq paramykq, @NonNull wop paramwop)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramykq.b(paramwop.a);
  }
  
  public Class acceptEventClass()
  {
    return wop.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykr
 * JD-Core Version:    0.7.0.1
 */