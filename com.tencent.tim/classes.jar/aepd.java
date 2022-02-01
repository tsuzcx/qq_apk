import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aepd
  extends aehv<aepc>
{
  @NonNull
  public aepc a(int paramInt)
  {
    return new aepc();
  }
  
  public void a(aepc paramaepc) {}
  
  @Nullable
  public aepc b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aepc.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aepc> clazz()
  {
    return aepc.class;
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
    return 484;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepd
 * JD-Core Version:    0.7.0.1
 */