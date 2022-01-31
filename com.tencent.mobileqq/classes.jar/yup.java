import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

final class yup
  extends QIPCModule
{
  private static volatile yup a;
  
  private yup(String paramString)
  {
    super(paramString);
  }
  
  public static yup a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new yup("gdt_server_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    yxp.b("GdtInterstitialPreDownloader", String.format("onCall action:%s", new Object[] { paramString }));
    if (TextUtils.equals(paramString, "PRELOAD_INTERSTITIAL_MAIN_TO_TOOL")) {
      yul.b(yul.a());
    }
    paramString = new EIPCResult();
    paramString.code = 0;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yup
 * JD-Core Version:    0.7.0.1
 */