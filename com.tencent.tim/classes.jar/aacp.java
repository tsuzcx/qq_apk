import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.qphone.base.util.QLog;

public class aacp
  implements jox
{
  public aacp(PreloadModule paramPreloadModule) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId loaded, code:" + paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadModule", 2, "checkUpByBusinessId progress:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacp
 * JD-Core Version:    0.7.0.1
 */