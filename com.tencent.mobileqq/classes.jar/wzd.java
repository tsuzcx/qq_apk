import android.os.AsyncTask;
import com.tencent.mobileqq.activity.qwallet.FrameAnimHelper;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;

public class wzd
  extends AsyncTask
{
  private wzd(FrameAnimHelper paramFrameAnimHelper) {}
  
  protected AnimationView.AnimationInfo a(String... paramVarArgs)
  {
    if ("1".equals(paramVarArgs[1])) {
      return AnimationView.AnimationInfo.loadFromZip(paramVarArgs[0]);
    }
    return AnimationView.AnimationInfo.loadFromFolder(paramVarArgs[0]);
  }
  
  protected void a(AnimationView.AnimationInfo paramAnimationInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "task over info = " + paramAnimationInfo);
    }
    this.a.a(paramAnimationInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzd
 * JD-Core Version:    0.7.0.1
 */