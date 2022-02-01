import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeiu
  extends aehv<aeit>
{
  public static void cXi()
  {
    aeit localaeit = (aeit)aeif.a().o(430);
    aeit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaeit);
  }
  
  @NonNull
  public aeit a(int paramInt)
  {
    return new aeit();
  }
  
  public void a(aeit paramaeit)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    aeit.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaeit);
  }
  
  @Nullable
  public aeit b(aeic[] paramArrayOfaeic)
  {
    return aeit.a(paramArrayOfaeic);
  }
  
  public Class<aeit> clazz()
  {
    return aeit.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiu
 * JD-Core Version:    0.7.0.1
 */