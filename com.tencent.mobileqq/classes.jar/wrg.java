import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrg
  extends QQUIEventReceiver<wrf, uvd>
{
  public wrg(wrf paramwrf1, @NonNull wrf paramwrf2)
  {
    super(paramwrf2);
  }
  
  public void a(@NonNull wrf paramwrf, @NonNull uvd paramuvd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramwrf.b(paramuvd.a);
  }
  
  public Class acceptEventClass()
  {
    return uvd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrg
 * JD-Core Version:    0.7.0.1
 */