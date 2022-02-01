import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.biz.WSWeSeeClientBiz.1;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

public class ume
  extends uly<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public ume(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("logsour");
    }
    return null;
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 2) && (TextUtils.equals(a(paramString), "2020020163")))
    {
      umw.a();
      WSPublicAccReport.getInstance().feedsItemForPushReport("gzh_click", 1000003);
    }
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    boolean bool3 = zmi.a(paramContext);
    upe.d("WSPushLog", "WSWeSeeClientBiz strategyInfo.scheme = " + paramWSPushStrategyInfo.mScheme + ", isInstallWeishi = " + bool3);
    boolean bool1 = false;
    if (this.jdField_a_of_type_Int == 2)
    {
      WSHomeFragment.a(paramContext);
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme))
    {
      bool2 = bool1;
      if (bool3)
      {
        ujn.a().a(new WSWeSeeClientBiz.1(this, paramContext, paramWSPushStrategyInfo), 200L);
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ume
 * JD-Core Version:    0.7.0.1
 */