import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.5.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class alaa
  extends acfd
{
  public alaa(PortalManager paramPortalManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead isSuccess = " + paramBoolean + ", mobileNumber = " + paramString);
    }
    if (this.this$0.gw.containsKey(paramString)) {
      ThreadManager.getSubThreadHandler().post(new PortalManager.5.1(this, paramString, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alaa
 * JD-Core Version:    0.7.0.1
 */