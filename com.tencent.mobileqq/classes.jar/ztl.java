import android.os.Bundle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ztl
  extends zqp
{
  ztl(ztk paramztk) {}
  
  private List<zqp> a(Session paramSession)
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
    return a(str1);
  }
  
  private List<zqp> a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      if (paramString != null) {
        return (List)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
      return null;
      paramString = "";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgProgress");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).a(paramBundle);
      }
    }
  }
  
  public void a(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "onServiceSessionNew:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).a(paramSession);
      }
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "onServiceSessionProgress:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).a(paramSession, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "onServiceSessionComplete:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).a(paramSession, paramBoolean);
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "OnDataPointFileMsgSendRet");
    }
    Object localObject = a("");
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).b(paramBundle);
      }
    }
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(ztk.jdField_a_of_type_JavaLangString, 4, "onServiceSessionStart:" + paramSession.uSessionID);
    }
    Object localObject = a(paramSession);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zqp)((Iterator)localObject).next()).b(paramSession);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ztl
 * JD-Core Version:    0.7.0.1
 */