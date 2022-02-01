import android.os.Bundle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class szz
  extends szg
{
  szz(szy paramszy) {}
  
  private List<szg> T(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      if (paramString != null) {
        return (List)this.this$0.gn.get(paramString);
      }
      return null;
      paramString = "";
    }
  }
  
  private List<szg> a(Session paramSession)
  {
    String str2 = "";
    String str1 = str2;
    if (paramSession != null)
    {
      str1 = str2;
      if (paramSession.actionInfo != null) {
        str1 = paramSession.actionInfo.strServiceName;
      }
    }
    return T(str1);
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "onServiceSessionProgress:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).a(paramSession, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "onServiceSessionComplete:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).a(paramSession, paramBoolean);
      }
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "onServiceSessionNew:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).b(paramSession);
      }
    }
  }
  
  public void bh(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "OnDataPointFileMsgProgress");
    }
    Object localObject = T("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).bh(paramBundle);
      }
    }
  }
  
  public void bi(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "OnDataPointFileMsgSendRet");
    }
    Object localObject = T("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).bi(paramBundle);
      }
    }
  }
  
  public void c(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(szy.TAG, 4, "onServiceSessionStart:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((szg)((Iterator)localObject).next()).c(paramSession);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szz
 * JD-Core Version:    0.7.0.1
 */