import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

final class yus
  extends QIPCModule
{
  private static volatile yus a;
  
  private yus(String paramString)
  {
    super(paramString);
  }
  
  public static yus a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new yus("gdt_server_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    yxs.b("GdtInterstitialPreDownloader", String.format("onCall action:%s", new Object[] { paramString }));
    if (TextUtils.equals(paramString, "PRELOAD_INTERSTITIAL_MAIN_TO_TOOL")) {
      yuo.b(yuo.a());
    }
    paramString = new EIPCResult();
    paramString.code = 0;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */