import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aetg
  extends aehv<aetf>
{
  public static aetf a()
  {
    return (aetf)aeif.a().o(500);
  }
  
  @NonNull
  public aetf a(int paramInt)
  {
    return new aetf();
  }
  
  public void a(aetf paramaetf) {}
  
  @Nullable
  public aetf b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetf.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetf> clazz()
  {
    return aetf.class;
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
    return 500;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetg
 * JD-Core Version:    0.7.0.1
 */