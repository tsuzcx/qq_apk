import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ahtn
  extends aehv<ahtm>
{
  private static ahtm b;
  private static AtomicBoolean cW = new AtomicBoolean(false);
  
  public static ahtm a()
  {
    if (b != null) {
      return b;
    }
    if (cW.compareAndSet(false, true)) {
      ThreadManager.executeOnSubThread(new GameShareConfProcessor.1());
    }
    return ahtm.a;
  }
  
  public static void reset()
  {
    b = null;
    cW.set(false);
  }
  
  @NonNull
  public ahtm a(int paramInt)
  {
    return new ahtm();
  }
  
  @Nullable
  public ahtm a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0) || (paramArrayOfaeic[0] == null)) {}
    for (paramArrayOfaeic = new ahtm();; paramArrayOfaeic = ahtm.a(paramArrayOfaeic[0].content))
    {
      b = paramArrayOfaeic;
      return paramArrayOfaeic;
    }
  }
  
  public void a(ahtm paramahtm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onUpdate] newConf:" + paramahtm);
    }
  }
  
  public Class<ahtm> clazz()
  {
    return ahtm.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    aeif.a().o(617);
  }
  
  public void onReqNoReceive()
  {
    aeif.a().o(617);
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.ConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + b);
    }
  }
  
  public int type()
  {
    return 617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtn
 * JD-Core Version:    0.7.0.1
 */