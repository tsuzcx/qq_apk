import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aeml
  extends aehv<aemk>
{
  @NonNull
  public aemk a(int paramInt)
  {
    return new aemk();
  }
  
  @Nullable
  public aemk a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aemk.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(aemk paramaemk) {}
  
  public Class<aemk> clazz()
  {
    return aemk.class;
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
    return 419;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeml
 * JD-Core Version:    0.7.0.1
 */