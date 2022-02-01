import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class adrc
{
  java.lang.ref.WeakReference<QQAppInterface> gj;
  
  public adrc(QQAppInterface paramQQAppInterface)
  {
    this.gj = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, acci paramacci)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.r("ArkApp.SSO", "requestArkAppList, app is null, return false");
      return false;
    }
    return ((adqx)localQQAppInterface.getBusinessHandler(95)).a(paramString, paramInt1, paramInt2, paramacci);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, acci paramacci)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.gj.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.r("ArkApp.SSO", "sendAppMsg, app is null, return false");
      return false;
    }
    return ((adqx)localQQAppInterface.getBusinessHandler(95)).a(paramString1, paramString2, paramInt1, paramInt2, paramacci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adrc
 * JD-Core Version:    0.7.0.1
 */