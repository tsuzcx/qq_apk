import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ijh
  extends ijg
{
  static long lr;
  
  public ijh(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    int i;
    long l1;
    if (((ikt)paramVideoAppInterface.a(5)).k(0, "750") == 1)
    {
      i = 1;
      l1 = AudioHelper.hF();
      if (i == 0) {
        break label214;
      }
      i = 12;
      localObject = (ijg)paramVideoAppInterface.getBusinessHandler(1);
    }
    for (Object localObject = paramString2 + "|" + ((ijg)localObject).getSessionId() + "|" + paramLong + "|" + l1;; localObject = paramString2)
    {
      long l2 = lr;
      lr = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendZimuCmd, id[" + paramString2 + "], cmdInfo[" + (String)localObject + "], autoDetect[" + true + "], from[" + paramString1 + "], seq[" + paramLong + "], sendTime[" + l1 + "], sendInterval[" + (l1 - l2) + "]");
      paramVideoAppInterface.b().d(i, (String)localObject);
      return;
      i = 0;
      break;
      label214:
      i = 7;
    }
  }
  
  void D(long paramLong1, long paramLong2)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.mApp;
    ZimuItem localZimuItem = (ZimuItem)((ilg)localVideoAppInterface.a(0)).a();
    if ((localZimuItem != null) && (!TextUtils.isEmpty(localZimuItem.getId()))) {
      a(localVideoAppInterface, "sendToPeer", paramLong1, localZimuItem.getId(), true);
    }
  }
  
  String ay()
  {
    VideoController localVideoController = ((VideoAppInterface)this.mApp).b();
    if ((localVideoController != null) && (localVideoController.b() != null)) {
      return localVideoController.b().peerUin;
    }
    return "";
  }
  
  int getNetType()
  {
    int i = 100;
    if (AppNetConnInfo.isWifiConn()) {
      i = 2;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 100;
    case 1: 
      return 4;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  int getVersion()
  {
    return jll.mM();
  }
  
  boolean isSender()
  {
    return ((ilg)((VideoAppInterface)this.mApp).a(0)).isSender();
  }
  
  boolean ts()
  {
    return ((iji)this.mApp.getBusinessHandler(0)).tt();
  }
  
  public static class a
  {
    private static a b = new a();
    public int anH;
    public List<NetAddr> eM;
    public int mChannelType;
    public long mSessionId;
    
    public static a a()
    {
      return b;
    }
    
    public String toString()
    {
      return "mChannelType[" + this.mChannelType + "], mSessionId[" + this.mSessionId + "], mTransType[" + this.anH + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijh
 * JD-Core Version:    0.7.0.1
 */