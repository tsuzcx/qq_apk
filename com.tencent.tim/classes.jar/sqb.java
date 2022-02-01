import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class sqb
  extends aehv<sqa>
{
  @NonNull
  public sqa a(int paramInt)
  {
    return new sqa();
  }
  
  @Nullable
  public sqa a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return sqa.a(paramArrayOfaeic[0].content);
    }
    return null;
  }
  
  public void a(sqa paramsqa)
  {
    axaq.a().XY(true);
  }
  
  public Class<sqa> clazz()
  {
    return sqa.class;
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
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    axaq.a().XY(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqb
 * JD-Core Version:    0.7.0.1
 */