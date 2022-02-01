import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class amqc
  extends ampt
{
  public MiniAppLocalSearchEntity a;
  protected String keyword;
  public int[] nd = new int[3];
  
  public amqc(QQAppInterface paramQQAppInterface, int paramInt, MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity, String paramString)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.a = paramMiniAppLocalSearchEntity;
    this.keyword = paramString;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 6;
  }
  
  protected long au(String paramString)
  {
    return 0L;
  }
  
  public boolean awg()
  {
    return (this.a.showMask & 0x1) != 0;
  }
  
  public void cR(View paramView)
  {
    if ((MiniAppLocalSearchManager)this.app.getManager(310) != null)
    {
      if (this.a.showMask != 0) {
        break label314;
      }
      MiniAppLauncher.launchMiniAppById((Activity)paramView.getContext(), this.a.appId, null, null, null, null, 1005);
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      JSONObject localJSONObject;
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (amkl.mT.containsKey(this))
        {
          paramView = (amkl.a)amkl.mT.get(this);
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("project", amub.zn());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", paramView.index);
        localJSONObject.put("get_src", "native");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item").obj1(paramView.ajO + "").obj2(this.a.appId).ver1(paramView.key).ver2(amub.eZ(UniteSearchActivity.dCK));
        if (awg())
        {
          paramView = "1";
          amub.a(null, localReportModelDC02528.ver3(paramView).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
          amxk.e(localQQAppInterface, this.keyword, this.cbp, uU(), IU());
          if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
            break label379;
          }
          amub.a(null, 0, this.fromType, "0X8009D31", 3, 0, null, null);
          return;
          label314:
          MiniAppLauncher.launchMiniAppById((Activity)paramView.getContext(), this.a.appId, null, null, null, null, 1027);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e(TAG, 2, "e = " + localJSONException);
          continue;
          paramView = "0";
        }
        label379:
        if ((this.a.appName != null) && (this.a.appName.equals(this.keyword)))
        {
          amub.a(null, 0, this.fromType, "0X8009D33", 0, 0, this.a.appId, null);
          return;
        }
        amub.a(null, 0, this.fromType, "0X8009D45", 0, 0, this.a.appId, null);
      }
    }
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return this.a.desc;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    return amxk.b(this.a.appName, this.keyword, 10, true);
  }
  
  public String getUin()
  {
    return this.a.appId;
  }
  
  public int lk()
  {
    return 0;
  }
  
  public int pG()
  {
    return 0;
  }
  
  public String uU()
  {
    return this.a.appId;
  }
  
  public String za()
  {
    return this.a.appName;
  }
  
  public String zb()
  {
    return null;
  }
  
  public String zi()
  {
    return this.a.iconUrl;
  }
  
  public String zj()
  {
    return "https://qzonestyle.gtimg.cn/aoi/sola/20190108152813_orkMRcBegl.png";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqc
 * JD-Core Version:    0.7.0.1
 */