import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeoi
  extends aehv<aeog>
{
  @NonNull
  public aeog a(int paramInt)
  {
    return new aeog();
  }
  
  @Nullable
  public aeog a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aeog localaeog = aeog.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherEntryConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeog;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aeog paramaeog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onUpdate " + paramaeog.toString());
    }
  }
  
  public Class<aeog> clazz()
  {
    return aeog.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoi
 * JD-Core Version:    0.7.0.1
 */