import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeoz
  extends aehv<aeoy>
{
  @NonNull
  public aeoy a(int paramInt)
  {
    return new aeoy();
  }
  
  @Nullable
  public aeoy a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeoy localaeoy = aeoy.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfaeic[0].content);
      }
      return localaeoy;
    }
    return null;
  }
  
  public void a(aeoy paramaeoy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramaeoy.toString());
    }
  }
  
  public Class<aeoy> clazz()
  {
    return aeoy.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoz
 * JD-Core Version:    0.7.0.1
 */