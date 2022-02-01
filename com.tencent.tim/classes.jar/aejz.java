import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aejz
  extends aehv<aejy>
{
  @NonNull
  public aejy a(int paramInt)
  {
    return new aejy();
  }
  
  @Nullable
  public aejy a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aejy localaejy = new aejy();
      localaejy.content = paramArrayOfaeic[0].content;
      return localaejy;
    }
    return null;
  }
  
  public void a(aejy paramaejy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    abhh localabhh = (abhh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramaejy != null) {}
    for (paramaejy = paramaejy.content;; paramaejy = null)
    {
      localabhh.BG(paramaejy);
      return;
    }
  }
  
  public Class<aejy> clazz()
  {
    return aejy.class;
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
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    aejy localaejy = (aejy)aeif.a().o(417);
    if (localaejy != null) {
      ((abhh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).BG(localaejy.content);
    }
  }
  
  public int type()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejz
 * JD-Core Version:    0.7.0.1
 */