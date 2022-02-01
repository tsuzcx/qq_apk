import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aeus
  extends aehv<aeur>
{
  public static aeur a()
  {
    return (aeur)aeif.a().o(346);
  }
  
  @NonNull
  public aeur a(int paramInt)
  {
    return new aeur();
  }
  
  public void a(aeur paramaeur)
  {
    if ((paramaeur != null) && (!TextUtils.isEmpty(paramaeur.tX()))) {
      ((aocq)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).b(paramaeur);
    }
  }
  
  @Nullable
  public aeur b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeur.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeur> clazz()
  {
    return aeur.class;
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
    return 346;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeus
 * JD-Core Version:    0.7.0.1
 */