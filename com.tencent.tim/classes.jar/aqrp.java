import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasResEngine.VasResController.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class aqrp
{
  private aqvc a;
  AppRuntime mApp;
  private int mId;
  private Handler mUIHandler;
  aquy w = new aqrq(this);
  
  public aqrp(int paramInt, AppRuntime paramAppRuntime, Handler paramHandler)
  {
    this.mId = paramInt;
    this.mApp = paramAppRuntime;
    this.mUIHandler = paramHandler;
  }
  
  public Handler A()
  {
    return this.mUIHandler;
  }
  
  public void aP(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new VasResController.2(this, paramString, paramInt1, paramInt2), 5, null, true);
  }
  
  public void c(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((this.a == null) && (this.mApp != null))
    {
      Manager localManager = this.mApp.getManager(47);
      if ((localManager != null) && ((localManager instanceof aqva))) {
        this.a = ((aqva)localManager).a(1);
      }
    }
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasResController", 1, "downLoad error url is empty dst =" + paramString2);
    }
    if ((this.a != null) && (this.a.a(paramString1) == null))
    {
      paramString1 = new aquz(paramString1, new File(paramString2));
      this.a.a(paramString1, this.w, paramBundle);
    }
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public void update(int paramInt)
  {
    this.mId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrp
 * JD-Core Version:    0.7.0.1
 */