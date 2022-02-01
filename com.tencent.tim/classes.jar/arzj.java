import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Map;

class arzj
  extends QIPCModule
{
  arzj(arzi paramarzi, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    arwt.d("DownloaderWriteCodeIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject = arzi.a(this.b);
    if (localObject == null) {
      arwt.d("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
    }
    String str;
    int i;
    do
    {
      do
      {
        return null;
      } while ((!"DownloaderWriteCodeIPC_Action__GetCode".equals(paramString)) || (paramBundle == null));
      str = paramBundle.getString("PackageName");
      i = paramBundle.getInt("VersionCode");
      arwt.d("DownloaderWriteCodeIPC", "onCall action|" + paramString + " packageName|" + str + " versionCode|" + i);
    } while (str == null);
    ((QQAppInterface)localObject).addDefaultObservers(arzi.a(this.b));
    paramString = (accy)((QQAppInterface)localObject).getBusinessHandler(4);
    localObject = str + "_" + i;
    paramBundle.putInt("CallbackId", paramInt);
    paramBundle = new Bundle(paramBundle);
    arzi.a(this.b).put(localObject, paramBundle);
    paramString.g(str, i, (String)localObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzj
 * JD-Core Version:    0.7.0.1
 */