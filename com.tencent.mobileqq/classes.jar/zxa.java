import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class zxa
  extends aptq<zwz>
{
  @NonNull
  public zwz a(int paramInt)
  {
    return new zwz();
  }
  
  @Nullable
  public zwz a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return zwz.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(zwz paramzwz)
  {
    bltp.a().a(true);
  }
  
  public Class<zwz> clazz()
  {
    return zwz.class;
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
    bltp.a().a(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxa
 * JD-Core Version:    0.7.0.1
 */