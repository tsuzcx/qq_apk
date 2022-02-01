import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class axik
  extends QIPCModule
{
  private static boolean dct;
  
  public axik(String paramString)
  {
    super(paramString);
  }
  
  public static axik a()
  {
    return axik.a.a;
  }
  
  public static void registerModule()
  {
    if (!dct)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(a());
      dct = true;
    }
  }
  
  public static void unRegisterModule()
  {
    if (dct)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
      dct = false;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_send_to_info".equals(paramString)) {
      axim.a().o(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        axim.a().eLg();
      }
    }
  }
  
  static class a
  {
    public static axik a = new axik("ae_camera_get_info_client");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axik
 * JD-Core Version:    0.7.0.1
 */