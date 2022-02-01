import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aets
  extends aehv<aetr>
{
  public static aetr a()
  {
    return (aetr)aeif.a().o(383);
  }
  
  @NonNull
  public aetr a(int paramInt)
  {
    return new aetr();
  }
  
  public void a(aetr paramaetr)
  {
    if ((paramaetr != null) && (!TextUtils.isEmpty(paramaetr.tX()))) {
      ((aocy)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).d(paramaetr);
    }
  }
  
  @Nullable
  public aetr b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetr.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetr> clazz()
  {
    return aetr.class;
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
    return 383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aets
 * JD-Core Version:    0.7.0.1
 */