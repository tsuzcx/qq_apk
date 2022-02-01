import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeto
  extends aehv<aetn>
{
  @NonNull
  public aetn a(int paramInt)
  {
    return new aetn();
  }
  
  public void a(aetn paramaetn)
  {
    if (paramaetn == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    aobw.V((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaetn.ahP());
    aobw.W((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaetn.ahQ());
  }
  
  @Nullable
  public aetn b(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aetn.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aetn> clazz()
  {
    return aetn.class;
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
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 294;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeto
 * JD-Core Version:    0.7.0.1
 */