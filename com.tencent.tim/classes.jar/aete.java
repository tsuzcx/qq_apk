import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aete
  extends aehv<aetd>
{
  public static aetd a()
  {
    return (aetd)aeif.a().o(486);
  }
  
  @NonNull
  public aetd a(int paramInt)
  {
    return new aetd();
  }
  
  public void a(aetd paramaetd) {}
  
  @Nullable
  public aetd b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetd.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetd> clazz()
  {
    return aetd.class;
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
    return 486;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aete
 * JD-Core Version:    0.7.0.1
 */