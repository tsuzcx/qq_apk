import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aene
  extends aehv<aend>
{
  public static aend a()
  {
    return (aend)aeif.a().o(631);
  }
  
  @NonNull
  public aend a(int paramInt)
  {
    return new aend();
  }
  
  public void a(aend paramaend)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramaend.toString());
    }
  }
  
  @Nullable
  public aend b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      new aend();
      return aend.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aend> clazz()
  {
    return aend.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aene
 * JD-Core Version:    0.7.0.1
 */