import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aejl
  extends aehv<aejk>
{
  public static aejk a()
  {
    return (aejk)aeif.a().o(452);
  }
  
  @NonNull
  public aejk a(int paramInt)
  {
    return new aejk().b("0");
  }
  
  @Nullable
  public aejk a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aejk localaejk = aejk.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaejk;
    }
    return null;
  }
  
  public void a(aejk paramaejk) {}
  
  public Class<aejk> clazz()
  {
    return aejk.class;
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
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejl
 * JD-Core Version:    0.7.0.1
 */