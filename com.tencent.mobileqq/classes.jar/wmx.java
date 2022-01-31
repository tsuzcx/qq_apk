import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wmx
  extends QQUIEventReceiver<wmw, uqu>
{
  public wmx(wmw paramwmw1, @NonNull wmw paramwmw2)
  {
    super(paramwmw2);
  }
  
  public void a(@NonNull wmw paramwmw, @NonNull uqu paramuqu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramwmw.b(paramuqu.a);
  }
  
  public Class acceptEventClass()
  {
    return uqu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmx
 * JD-Core Version:    0.7.0.1
 */