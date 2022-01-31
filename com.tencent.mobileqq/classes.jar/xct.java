import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.qphone.base.util.QLog;

public class xct
  implements AsyncBack
{
  public xct(PreloadModule paramPreloadModule) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId progress:" + paramInt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId loaded, code:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xct
 * JD-Core Version:    0.7.0.1
 */