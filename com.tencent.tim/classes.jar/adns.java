import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

final class adns
  implements adst.b
{
  public void GD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, new Object[] { "ArkSafe.report onReportUrlCheck content=", paramString });
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(121)).a();
        if (localObject != null) {
          ((adqb)localObject).lO(paramString);
        }
      }
      return;
    }
  }
  
  public void cTx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp", 2, "ArkSafe.report onDisableReport");
    }
    adst.a().a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adns
 * JD-Core Version:    0.7.0.1
 */