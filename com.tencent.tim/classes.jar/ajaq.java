import android.os.Bundle;
import com.tencent.mobileqq.mediafocus.MediaFocusStackItem;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class ajaq
  extends QIPCModule
{
  public static boolean cnj;
  private String bcr;
  private boolean bvf;
  
  private ajaq()
  {
    super("MediaFocusModuleClient");
    kJ();
  }
  
  public static ajaq a()
  {
    return ajaq.a.b();
  }
  
  private void kJ()
  {
    QIPCClientHelper.getInstance().getClient().connect(new ajar(this));
    QIPCClientHelper.getInstance().getClient().addListener(new ajas(this));
  }
  
  public static void registerModule()
  {
    ajaq localajaq = a();
    if (!cnj)
    {
      QIPCClientHelper.getInstance().register(localajaq);
      cnj = true;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      boolean bool = false;
      if (paramString != null) {
        bool = ajat.a().bf(paramString.getClientId(), paramString.getProcessName());
      }
      localBundle.putBoolean("isItemExist", bool);
      localBundle.putBoolean("isConnected", this.bvf);
      localBundle.putParcelable("focusItem", paramString);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  static class a
  {
    private static ajaq b = new ajaq(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajaq
 * JD-Core Version:    0.7.0.1
 */