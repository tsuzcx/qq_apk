import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aemn
  extends aehv<aemm>
{
  @NonNull
  public aemm a(int paramInt)
  {
    return new aemm();
  }
  
  @Nullable
  public aemm a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aemm localaemm = aemm.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaemm;
    }
    return new aemm();
  }
  
  public void a(aemm paramaemm)
  {
    ((aize)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).b(paramaemm);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramaemm);
    }
  }
  
  public Class<aemm> clazz()
  {
    return aemm.class;
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
  
  public int type()
  {
    return 390;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemn
 * JD-Core Version:    0.7.0.1
 */