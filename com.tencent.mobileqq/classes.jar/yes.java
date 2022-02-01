import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yes
  extends QQUIEventReceiver<yer, wiv>
{
  public yes(yer paramyer1, @NonNull yer paramyer2)
  {
    super(paramyer2);
  }
  
  public void a(@NonNull yer paramyer, @NonNull wiv paramwiv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramyer.b(paramwiv.a);
  }
  
  public Class acceptEventClass()
  {
    return wiv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yes
 * JD-Core Version:    0.7.0.1
 */