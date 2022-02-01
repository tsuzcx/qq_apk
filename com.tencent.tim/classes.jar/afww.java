import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class afww
  extends aehv<afxa>
{
  public static afxa a()
  {
    return (afxa)aeif.a().o(532);
  }
  
  @NonNull
  public afxa a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new afxa();
  }
  
  @Nullable
  public afxa a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
      }
      return afxa.a(paramArrayOfaeic[0]);
    }
    return null;
  }
  
  public void a(afxa paramafxa)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramafxa == null) {
        break label73;
      }
    }
    label73:
    for (paramafxa = paramafxa.toString();; paramafxa = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramafxa);
      paramafxa = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramafxa instanceof QQAppInterface)) {
        ((afsi)((QQAppInterface)paramafxa).getManager(264)).dbQ();
      }
      return;
    }
  }
  
  public Class<afxa> clazz()
  {
    return afxa.class;
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
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 532;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afww
 * JD-Core Version:    0.7.0.1
 */