import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ulm
  extends QQUIEventReceiver<ull, spj>
{
  public ulm(ull paramull1, @NonNull ull paramull2)
  {
    super(paramull2);
  }
  
  public void a(@NonNull ull paramull, @NonNull spj paramspj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.playernew.StoryPlayerActivity", 2, "GetStoryListReceiver");
    }
    paramull.b(paramspj.a);
  }
  
  public Class acceptEventClass()
  {
    return spj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ulm
 * JD-Core Version:    0.7.0.1
 */