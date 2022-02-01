import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeis
  extends aehv<aeir>
{
  public static void cXh()
  {
    int i = aeif.a().q(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    aeif.a().hJ(67, 0);
  }
  
  public static void initConfig()
  {
    aeir localaeir = (aeir)aeif.a().o(67);
    aeir.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaeir);
  }
  
  @NonNull
  public aeir a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new aeir();
    }
    aeir.cXg();
    return new aeir();
  }
  
  public void a(aeir paramaeir)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    aeir.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaeir);
  }
  
  @Nullable
  public aeir b(aeic[] paramArrayOfaeic)
  {
    return aeir.a(paramArrayOfaeic);
  }
  
  public Class<aeir> clazz()
  {
    return aeir.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public int type()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeis
 * JD-Core Version:    0.7.0.1
 */