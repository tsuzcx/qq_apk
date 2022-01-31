import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uyf
  extends QQUIEventReceiver<uye, tcc>
{
  public uyf(uye paramuye1, @NonNull uye paramuye2)
  {
    super(paramuye2);
  }
  
  public void a(@NonNull uye paramuye, @NonNull tcc paramtcc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramuye.b(paramtcc.a);
  }
  
  public Class acceptEventClass()
  {
    return tcc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyf
 * JD-Core Version:    0.7.0.1
 */