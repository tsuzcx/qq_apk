import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.HighwayConfBean;
import com.tencent.qphone.base.util.QLog;

public class aole
  extends aehv<HighwayConfBean>
{
  @NonNull
  public HighwayConfBean a(int paramInt)
  {
    HighwayConfBean localHighwayConfBean = new HighwayConfBean();
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localHighwayConfBean;
  }
  
  @Nullable
  public HighwayConfBean a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      HighwayConfBean localHighwayConfBean = HighwayConfBean.parse(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("HighwayConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localHighwayConfBean;
    }
    return null;
  }
  
  public void a(HighwayConfBean paramHighwayConfBean)
  {
    HighwayConfBean.updateHighwayConf((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramHighwayConfBean);
  }
  
  public Class<HighwayConfBean> clazz()
  {
    return HighwayConfBean.class;
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
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aole
 * JD-Core Version:    0.7.0.1
 */