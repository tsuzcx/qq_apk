import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeme
  extends aehv<aemd>
{
  @NonNull
  public aemd a(int paramInt)
  {
    return new aemd();
  }
  
  @Nullable
  public aemd a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aemd localaemd = aemd.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaemd;
    }
    return null;
  }
  
  public void a(aemd paramaemd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramaemd.toString());
    }
  }
  
  public Class<aemd> clazz()
  {
    return aemd.class;
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
    return 442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeme
 * JD-Core Version:    0.7.0.1
 */