import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeld
  extends aehv<aelc>
{
  @NonNull
  public static aelc b()
  {
    aelc localaelc2 = (aelc)aeif.a().o(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localaelc2);
    }
    aelc localaelc1 = localaelc2;
    if (localaelc2 == null) {
      localaelc1 = new aelc();
    }
    return localaelc1;
  }
  
  @NonNull
  public aelc a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new aelc();
  }
  
  public void a(aelc paramaelc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramaelc.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).iz(34))
      {
        ((ysf)((QQAppInterface)localObject).getManager(34)).a = paramaelc;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
    }
  }
  
  @Nullable
  public aelc b(aeic[] paramArrayOfaeic)
  {
    return aelc.a(paramArrayOfaeic);
  }
  
  public Class<aelc> clazz()
  {
    return aelc.class;
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
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 458;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeld
 * JD-Core Version:    0.7.0.1
 */