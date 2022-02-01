import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz.1;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class omx
  extends omr<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private Intent mNewIntent;
  private int mScene;
  
  public omx(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.mScene = paramInt;
    this.mNewIntent = paramIntent;
  }
  
  private String fx(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("logsour");
    }
    return null;
  }
  
  private void pO(String paramString)
  {
    if ((this.mScene == 2) && (TextUtils.equals(fx(paramString), "2020020163")))
    {
      ong.bfQ();
      WSPublicAccReport.getInstance().feedsItemForPushReport("gzh_click", 1000003);
    }
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool3 = rpw.isWeishiInstalled(paramContext);
    ooz.e("WSPushLog", "WSWeSeeClientBiz strategyInfo.scheme = " + paramWSPushStrategyInfo.mScheme + ", isInstallWeishi = " + bool3);
    boolean bool1 = false;
    if (this.mScene == 2)
    {
      WSHomeFragment.cq(paramContext);
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme))
    {
      bool2 = bool1;
      if (bool3)
      {
        oks.a().postDelayed(new WSWeSeeClientBiz.1(this, paramContext, paramWSPushStrategyInfo), 200L);
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     omx
 * JD-Core Version:    0.7.0.1
 */