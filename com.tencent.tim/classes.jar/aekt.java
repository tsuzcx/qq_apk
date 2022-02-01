import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;

public class aekt
  extends aehv<aeks>
{
  public static aeks a()
  {
    return (aeks)aeif.a().o(446);
  }
  
  @NonNull
  public aeks a(int paramInt)
  {
    return new aeks();
  }
  
  public void a(aeks paramaeks)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppApiReportProcessor", 2, "onUpdate " + paramaeks.toString());
    }
    paramaeks = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaeks instanceof QQAppInterface))
    {
      paramaeks = (MiniAppEntryHandler)((QQAppInterface)paramaeks).getBusinessHandler(149);
      if (paramaeks != null) {
        paramaeks.notifyUI(0, true, null);
      }
    }
  }
  
  @Nullable
  public aeks b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aeks.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aeks> clazz()
  {
    return aeks.class;
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
  
  public int type()
  {
    return 446;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekt
 * JD-Core Version:    0.7.0.1
 */