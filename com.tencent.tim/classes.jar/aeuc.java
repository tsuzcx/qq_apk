import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aeuc
  extends aehv<aeub>
{
  public static aeub a()
  {
    return (aeub)aeif.a().o(377);
  }
  
  @NonNull
  public aeub a(int paramInt)
  {
    return new aeub();
  }
  
  public void a(aeub paramaeub) {}
  
  @Nullable
  public aeub b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeub.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeub> clazz()
  {
    return aeub.class;
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
    return 377;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuc
 * JD-Core Version:    0.7.0.1
 */