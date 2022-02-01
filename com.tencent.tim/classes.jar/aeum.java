import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aeum
  extends aehv<aeul>
{
  public static aeul a()
  {
    return (aeul)aeif.a().o(451);
  }
  
  @NonNull
  public aeul a(int paramInt)
  {
    return new aeul();
  }
  
  public void a(aeul paramaeul) {}
  
  @Nullable
  public aeul b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeul.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeul> clazz()
  {
    return aeul.class;
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
    return 451;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeum
 * JD-Core Version:    0.7.0.1
 */