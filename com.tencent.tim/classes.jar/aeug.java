import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aeug
  extends aehv<aeuf>
{
  @NonNull
  public aeuf a(int paramInt)
  {
    return new aeuf();
  }
  
  public void a(aeuf paramaeuf) {}
  
  @Nullable
  public aeuf b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeuf.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeuf> clazz()
  {
    return aeuf.class;
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
    return 440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeug
 * JD-Core Version:    0.7.0.1
 */