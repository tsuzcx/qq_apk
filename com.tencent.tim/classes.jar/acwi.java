import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;

public class acwi
  extends acuk
{
  public acwi(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean acL()
  {
    if (this.app == null) {
      return false;
    }
    Object localObject = (aneo)this.app.getManager(10);
    if ((localObject != null) && ((((aneo)localObject).jn(2) > 0) || (((aneo)localObject).jn(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.x((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.source).getQueryParameter("push_trans_channel");
      avpw.a((Activity)this.context, this.app.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.source);
      return true;
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = acL();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneFriendFeedsV1AndV2Action", 1, "doAction error: " + localException.getMessage());
      Ge("QzoneFriendFeedsV1AndV2Action");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acwi
 * JD-Core Version:    0.7.0.1
 */