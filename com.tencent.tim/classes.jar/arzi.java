import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class arzi
{
  private static arzi jdField_a_of_type_Arzi;
  private arzi.a jdField_a_of_type_Arzi$a = new arzi.a(null);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new arzj(this, "Module_DownloaderGetCodeServer");
  private Map<String, Bundle> oQ = Collections.synchronizedMap(new HashMap());
  
  public static arzi a()
  {
    if (jdField_a_of_type_Arzi == null) {}
    try
    {
      jdField_a_of_type_Arzi = new arzi();
      return jdField_a_of_type_Arzi;
    }
    finally {}
  }
  
  private QQAppInterface getAppInterface()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QIPCModule b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
  
  class a
    extends accz
  {
    private a() {}
    
    protected void w(boolean paramBoolean, String paramString1, String paramString2)
    {
      arwt.d("DownloaderWriteCodeIPC", "GetAuthCodeObserver onGetAuthCode isSuccess|" + paramBoolean + " code|" + paramString1 + " reqId|" + paramString2);
      if (paramString2 == null) {
        return;
      }
      Bundle localBundle = (Bundle)arzi.a(arzi.this).get(paramString2);
      if (localBundle == null)
      {
        arwt.d("DownloaderWriteCodeIPC", "GetAuthCodeObserver reqId|" + paramString2 + "  but params context is null");
        return;
      }
      int i = localBundle.getInt("CallbackId");
      paramString2 = new Bundle();
      paramString2.putString("PackageName", localBundle.getString("PackageName"));
      paramString2.putInt("VersionCode", localBundle.getInt("VersionCode"));
      if (paramBoolean)
      {
        paramString2.putBoolean("IsSuccess", true);
        paramString2.putString("Code", paramString1);
      }
      for (;;)
      {
        arwt.d("DownloaderWriteCodeIPC", "GetAuthCodeObserver callbackId|" + i + " result|" + paramString2);
        arzi.a(arzi.this).callbackResult(i, EIPCResult.createSuccessResult(paramString2));
        return;
        paramString2.putBoolean("IsSuccess", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzi
 * JD-Core Version:    0.7.0.1
 */