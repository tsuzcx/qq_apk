import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class acky
  extends accg
{
  public static String boZ = "Add_friend_to_desktop|";
  public static String bpa = "Click_desktop_friend|";
  private String KEY = "FuMeiTiCeSu|";
  
  public acky(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String f(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "PLUG|" + paramString1 + "|" + paramString2 + "|internal|" + paramString3 + "|PB|" + paramString4 + "||";
  }
  
  public void M(String[] paramArrayOfString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
    localToServiceMsg.extraData.putStringArray("data", paramArrayOfString);
    super.send(localToServiceMsg);
  }
  
  public void ch(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
      localToServiceMsg.extraData.putAll(paramBundle);
      super.send(localToServiceMsg);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acky
 * JD-Core Version:    0.7.0.1
 */