import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpx
  extends QQUIEventReceiver<xpw, vua>
{
  public xpx(xpw paramxpw1, @NonNull xpw paramxpw2)
  {
    super(paramxpw2);
  }
  
  public void a(@NonNull xpw paramxpw, @NonNull vua paramvua)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramxpw.b(paramvua.a);
  }
  
  public Class acceptEventClass()
  {
    return vua.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpx
 * JD-Core Version:    0.7.0.1
 */