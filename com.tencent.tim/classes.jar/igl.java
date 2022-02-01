import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class igl
  extends igm<igk>
{
  public igl(int paramInt)
  {
    super(paramInt);
  }
  
  public static igk b(int paramInt)
  {
    return (igk)aeif.a().o(paramInt);
  }
  
  public static int cm(int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aeif.a().q(paramInt, localAppInterface.getCurrentAccountUin());
  }
  
  @NonNull
  public igk a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new igk();
  }
  
  @Nullable
  protected igk a(aeic[] paramArrayOfaeic)
  {
    igk localigk = new igk();
    paramArrayOfaeic = a(this.TAG, type(), paramArrayOfaeic);
    if (paramArrayOfaeic != null) {
      localigk.set(paramArrayOfaeic.taskId, paramArrayOfaeic.content);
    }
    return localigk;
  }
  
  public void a(igk paramigk)
  {
    super.onUpdate(paramigk);
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppInterface instanceof QQAppInterface)) {}
    while (paramigk == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localAppInterface;
    switch (type())
    {
    default: 
      return;
    case 132: 
      ijo.a(this.TAG, localQQAppInterface.getApp(), 1, false);
      return;
    case 270: 
      jkw.a(localQQAppInterface, paramigk.content, localAppInterface.getCurrentAccountUin());
      return;
    case 192: 
      ixa.a().bj(paramigk.content);
      return;
    case 249: 
      ((irz)localQQAppInterface.getManager(254)).jz(paramigk.content);
      irm.iK(true);
      return;
    case 276: 
      aqji.UM(paramigk.content);
      return;
    case 287: 
      jkn.kM(paramigk.content);
      return;
    case 367: 
    case 382: 
      BusinessCommonConfig.getInstance(localQQAppInterface).decodeConfig(localQQAppInterface, type(), paramigk.content);
      return;
    }
    ind.jg(paramigk.content);
  }
  
  public Class<igk> clazz()
  {
    return igk.class;
  }
  
  public boolean isAccountRelated()
  {
    switch (type())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public void onReqFailed(int paramInt)
  {
    super.onReqFailed(paramInt);
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    }
    ((irz)((QQAppInterface)localObject).getManager(254)).aqj();
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    switch (type())
    {
    default: 
      return;
    case 249: 
      ((irz)((QQAppInterface)localObject).getManager(254)).aqj();
      return;
    }
    BusinessCommonConfig.getInstance((AppRuntime)localObject).handleResp_Config_NoResp((QQAppInterface)localObject, type());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igl
 * JD-Core Version:    0.7.0.1
 */