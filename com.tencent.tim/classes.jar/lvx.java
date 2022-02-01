import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qphone.base.util.QLog;

public class lvx
{
  public static void aNJ()
  {
    PTSLog.registerLogger(new lwa());
    PTSDeviceUtil.setTextHeightOffsetPerLine(0.1165049F);
    PTSNodeFactory.registerNodeVirtual("img", PTSNodeImage.class);
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
  }
  
  static void aNK() {}
  
  public static boolean aq(Context paramContext)
  {
    if (!lwf.a.CQ()) {}
    do
    {
      return false;
      int i = kys.getChannelId();
      if (!kys.dt(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!lvg.a().BJ()) || (!lve.a().dN("daily_feeds")));
    bX(paramContext);
    return true;
  }
  
  private static void bX(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = lve.a().eL("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    lvg.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.start(paramContext, localIntent, PTSFragment.class);
  }
  
  public static void init()
  {
    lwf.a.init();
    lvy.a().init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvx
 * JD-Core Version:    0.7.0.1
 */