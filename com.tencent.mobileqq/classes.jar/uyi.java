import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uyi
  extends QQUIEventReceiver<uyh, tcf>
{
  public uyi(uyh paramuyh1, @NonNull uyh paramuyh2)
  {
    super(paramuyh2);
  }
  
  public void a(@NonNull uyh paramuyh, @NonNull tcf paramtcf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramuyh.b(paramtcf.a);
  }
  
  public Class acceptEventClass()
  {
    return tcf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyi
 * JD-Core Version:    0.7.0.1
 */