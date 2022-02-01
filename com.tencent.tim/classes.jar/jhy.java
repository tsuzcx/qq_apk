import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import org.json.JSONObject;

public class jhy
  extends jit
{
  public final String Sc = "appid#0|bargainor_id#0|channel#bqredpacket1";
  public final String Sd = "appid#0|bargainor_id#0|channel#bqredpacket2";
  public final String Se = "appid#0|bargainor_id#0|channel#bqredpacket";
  public final String Sf = "2";
  public final String Sg = "16384";
  public final String Sh = "1";
  public final int azZ = 2;
  
  jhy(jht paramjht)
  {
    super(paramjht);
  }
  
  static long a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.b().b().peerUin;
    try
    {
      long l = Long.valueOf(paramVideoAppInterface).longValue();
      return l;
    }
    catch (Exception paramVideoAppInterface) {}
    return 0L;
  }
  
  static String a(VideoAppInterface paramVideoAppInterface)
  {
    return paramVideoAppInterface.getDisplayName(0, paramVideoAppInterface.getCurrentAccountUin(), null);
  }
  
  static String b(VideoAppInterface paramVideoAppInterface)
  {
    return paramVideoAppInterface.b().b().MO;
  }
  
  public static void d(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    long l = jik.b(paramVideoAppInterface);
    paramVideoAppInterface = new JSONObject();
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("url", paramString);
      paramVideoAppInterface.put("userId", l);
      paramVideoAppInterface.put("viewTag", "openEmbelUrl");
      paramVideoAppInterface.put("come_from", 2);
      paramVideoAppInterface.put("extra_data", localObject);
      paramString = BaseApplicationImpl.getApplication();
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", paramVideoAppInterface.toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      paramVideoAppInterface = new Intent(paramString.getApplicationContext(), PayBridgeActivity.class);
      paramVideoAppInterface.addFlags(268435456);
      paramVideoAppInterface.putExtras((Bundle)localObject);
      paramVideoAppInterface.putExtra("pay_requestcode", 5);
      paramString.getBaseContext().startActivity(paramVideoAppInterface);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhy
 * JD-Core Version:    0.7.0.1
 */