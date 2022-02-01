import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aebr
  extends aehv<aebq>
{
  public static aebq a()
  {
    return (aebq)aeif.a().o(586);
  }
  
  @NonNull
  public aebq a(int paramInt)
  {
    return new aebq();
  }
  
  @Nullable
  public aebq a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aebq.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(aebq paramaebq) {}
  
  public Class<aebq> clazz()
  {
    return aebq.class;
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
    return 586;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebr
 * JD-Core Version:    0.7.0.1
 */