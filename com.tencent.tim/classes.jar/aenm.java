import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aenm
  extends aehv<aenl>
{
  public static aenl a()
  {
    return (aenl)aeif.a().o(292);
  }
  
  @NonNull
  public aenl a(int paramInt)
  {
    return new aenl();
  }
  
  @Nullable
  public aenl a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaeic);
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaeic[0].content);
      }
      return aenl.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(aenl paramaenl) {}
  
  public Class<aenl> clazz()
  {
    return aenl.class;
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
    return 292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenm
 * JD-Core Version:    0.7.0.1
 */