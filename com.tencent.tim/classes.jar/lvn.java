import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSAllInOneJump;
import com.tencent.qphone.base.util.QLog;

public class lvn
  implements IPTSAllInOneJump
{
  public final String TAG = "PTSAllInOneJumpModule";
  
  public void allInOneJump(String paramString)
  {
    QLog.i("PTSAllInOneJumpModule", 1, "[allInOneJump], url = " + paramString);
    if (BaseActivity.sTopActivity != null) {
      kxm.aJ(BaseActivity.sTopActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvn
 * JD-Core Version:    0.7.0.1
 */