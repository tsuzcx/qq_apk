import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yom
  extends QQUIEventReceiver<yol, wsk>
{
  public yom(yol paramyol1, @NonNull yol paramyol2)
  {
    super(paramyol2);
  }
  
  public void a(@NonNull yol paramyol, @NonNull wsk paramwsk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramyol.b(paramwsk.a);
  }
  
  public Class acceptEventClass()
  {
    return wsk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yom
 * JD-Core Version:    0.7.0.1
 */