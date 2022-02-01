import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeon
  extends aehv<aeom>
{
  @NonNull
  public static aeom a()
  {
    aeom localaeom2 = (aeom)aeif.a().o(550);
    aeom localaeom1 = localaeom2;
    if (localaeom2 == null) {
      localaeom1 = new aeom();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localaeom1.toString());
    }
    return localaeom1;
  }
  
  @NonNull
  public aeom a(int paramInt)
  {
    return new aeom();
  }
  
  public void a(aeom paramaeom)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).iz(347))
      {
        ((ajkq)((QQAppInterface)localObject).getManager(347)).a = paramaeom;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramaeom.toString());
        }
      }
    }
  }
  
  @Nullable
  public aeom b(aeic[] paramArrayOfaeic)
  {
    return aeom.a(paramArrayOfaeic);
  }
  
  public Class clazz()
  {
    return aeom.class;
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
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeon
 * JD-Core Version:    0.7.0.1
 */