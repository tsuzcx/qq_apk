import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aena
  extends aehv<aemz>
{
  @NonNull
  public aemz a(int paramInt)
  {
    return new aemz();
  }
  
  @Nullable
  public aemz a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aemz localaemz = aemz.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfaeic[0].content);
      }
      return localaemz;
    }
    return null;
  }
  
  public void a(aemz paramaemz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramaemz.toString());
    }
  }
  
  public Class<aemz> clazz()
  {
    return aemz.class;
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
    return 534;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aena
 * JD-Core Version:    0.7.0.1
 */