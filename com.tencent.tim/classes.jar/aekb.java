import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aekb
  extends aehv<aeka>
{
  public static final String TAG = ahtj.bLH + "GameCenterMsgConfigProcessor";
  
  public static aeka a()
  {
    return (aeka)aeif.a().o(608);
  }
  
  @NonNull
  public aeka a(int paramInt)
  {
    return new aeka();
  }
  
  @Nullable
  public aeka b(aeic[] paramArrayOfaeic)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[onParsed]");
    }
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0)
      {
        localObject1 = aeka.a(paramArrayOfaeic);
        paramArrayOfaeic = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((paramArrayOfaeic != null) && (localObject1 != null)) {
          ((ahta)paramArrayOfaeic.getManager(358)).c((aeka)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void b(aeka paramaeka)
  {
    QLog.i(TAG, 1, "[onUpdate]");
  }
  
  public Class<aeka> clazz()
  {
    return aeka.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int type()
  {
    return 608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekb
 * JD-Core Version:    0.7.0.1
 */