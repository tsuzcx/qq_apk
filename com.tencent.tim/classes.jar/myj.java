import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.SDKInstallListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class myj
{
  private static boolean mIsInited;
  private myj.a jdField_a_of_type_Myj$a;
  private nbq jdField_a_of_type_Nbq = nbs.a.a();
  private Handler aW = new Handler(new myk(this));
  private boolean ajR;
  
  public myj()
  {
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void acu()
  {
    try
    {
      if (!mIsInited)
      {
        this.jdField_a_of_type_Nbq.initSDK();
        mIsInited = true;
      }
      return;
    }
    finally {}
  }
  
  public boolean EU()
  {
    return this.jdField_a_of_type_Nbq.Ff();
  }
  
  public void a(myj.a parama)
  {
    this.jdField_a_of_type_Myj$a = parama;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Myj$a = null;
    this.aW.removeCallbacksAndMessages(null);
  }
  
  public void installPlugin()
  {
    if ((!EU()) && (!this.ajR)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ns(boolean paramBoolean);
  }
  
  public static class b
    implements nbp
  {
    private Handler mHandler;
    
    public b(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    private void U(boolean paramBoolean, int paramInt)
    {
      ThreadManager.excute(new VideoPluginInstall.SDKInstallListener.1(this, paramBoolean, paramInt), 16, null, true);
    }
    
    public void onInstalledFailed(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onInstalledFailed: code=" + paramInt);
      }
      U(false, paramInt);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1);
      }
    }
    
    public void onInstalledSuccessed()
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onInstalledSuccessed: ");
      }
      U(true, 0);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myj
 * JD-Core Version:    0.7.0.1
 */