import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aeua
  extends aehv<aetz>
{
  public static aetz a()
  {
    return (aetz)aeif.a().o(483);
  }
  
  @NonNull
  public aetz a(int paramInt)
  {
    return new aetz();
  }
  
  public void a(aetz paramaetz)
  {
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt("key_tencent_doc_history_tab_tips_count", 0).apply();
  }
  
  @Nullable
  public aetz b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetz.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetz> clazz()
  {
    return aetz.class;
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
    return 483;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeua
 * JD-Core Version:    0.7.0.1
 */