import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aepb
  extends aehv<aepe>
{
  public static aepe a()
  {
    return (aepe)aeif.a().o(497);
  }
  
  @NonNull
  public aepe a(int paramInt)
  {
    return new aepe();
  }
  
  @Nullable
  public aepe a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aepe.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(aepe paramaepe) {}
  
  public Class<aepe> clazz()
  {
    return aepe.class;
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
    return 497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepb
 * JD-Core Version:    0.7.0.1
 */