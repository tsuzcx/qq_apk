import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class muc
{
  private static final String TAG = muc.class.getSimpleName();
  private static int aUA;
  private QQAppInterface mApp;
  private String uin;
  
  public muc(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.uin = kxm.getAccount();
    aUA = 0;
  }
  
  private int pK()
  {
    int i = 0;
    boolean bool = awit.V(this.mApp);
    if (!bool) {
      awit.H(this.uin + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0));
    }
    if (bool) {
      i = ((Integer)awit.f(this.uin + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(0))).intValue();
    }
    return i;
  }
  
  public void aSr()
  {
    try
    {
      int i = pK();
      aUA += 1;
      awit.H(this.uin + "VideoFeedsGameAdComBarConfigure_DALIY", Integer.valueOf(i + 1));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(TAG, 2, "解析引流条出现的条件出错: " + localException.getMessage());
    }
  }
  
  public int pH()
  {
    return pK();
  }
  
  public int pL()
  {
    return aUA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muc
 * JD-Core Version:    0.7.0.1
 */