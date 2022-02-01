import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeux
  extends aehv<String>
{
  public void Hw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onUpdate");
    }
  }
  
  @Nullable
  public String a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoDrawConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      paramArrayOfaeic = null;
    }
    String str;
    do
    {
      return paramArrayOfaeic;
      str = paramArrayOfaeic[0].content;
      paramArrayOfaeic = str;
    } while (!QLog.isColorLevel());
    QLog.d("VideoDrawConfProcessor", 2, " onParsed, content:" + str);
    return str;
  }
  
  public Class<String> clazz()
  {
    return String.class;
  }
  
  @NonNull
  public String dT(int paramInt)
  {
    return "";
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
      QLog.d("VideoDrawConfProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 462;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeux
 * JD-Core Version:    0.7.0.1
 */