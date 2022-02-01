import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ygx
  extends aehv<ygw>
{
  @NonNull
  public ygw a(int paramInt)
  {
    return new ygw();
  }
  
  @Nullable
  public ygw a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      ygw localygw = ygw.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localygw;
    }
    return null;
  }
  
  public void a(ygw paramygw)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).getCurrentUin();
      yhf.l(BaseApplicationImpl.getApplication(), str, paramygw.wK());
      yhf.p((QQAppInterface)localObject, paramygw.TB());
    }
  }
  
  public Class<ygw> clazz()
  {
    return ygw.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
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
    return 410;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygx
 * JD-Core Version:    0.7.0.1
 */