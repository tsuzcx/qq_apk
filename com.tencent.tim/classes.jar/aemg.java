import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aemg
  extends aehv<aemf>
{
  @NonNull
  public aemf a(int paramInt)
  {
    return new aemf();
  }
  
  @Nullable
  public aemf a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      aemf localaemf = aemf.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaemf;
    }
    return null;
  }
  
  public void a(aemf paramaemf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramaemf.toString());
    }
  }
  
  public Class<aemf> clazz()
  {
    return aemf.class;
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
    return 488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemg
 * JD-Core Version:    0.7.0.1
 */