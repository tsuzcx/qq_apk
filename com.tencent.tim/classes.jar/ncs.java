import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ncs
{
  private static ncs a;
  private int aXN = 0;
  private int aXO = 0;
  
  private ncs()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(218);
    if (localAladdinConfig != null)
    {
      this.aXN = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_pure", 0);
      this.aXO = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_mix", 0);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "Daily entry pure : " + this.aXN + ", mix : " + this.aXO);
    }
  }
  
  public static ncs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ncs();
      }
      return a;
    }
    finally {}
  }
  
  public static nss a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelable("daily_bottom_entry_data");
    if ((paramBundle instanceof nss)) {
      return (nss)paramBundle;
    }
    return null;
  }
  
  private String kF()
  {
    int i = -1;
    int j = qw();
    if (j == 2) {
      i = 5;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("diandianfeeds_type", i);
        ((JSONObject)localObject).put("trigger_src", 1);
        ((JSONObject)localObject).put("channel_id", kvs.getChannelId());
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (j == 3) {
        i = 6;
      } else if (j == 1) {
        i = RecommendFeedsDiandianEntranceManager.a().qE();
      }
    }
    return "";
  }
  
  public static boolean q(Bundle paramBundle)
  {
    return paramBundle.containsKey("daily_bottom_entry_data");
  }
  
  public boolean Fm()
  {
    return qw() != 0;
  }
  
  public View.OnClickListener a(Activity paramActivity, View paramView, kge paramkge)
  {
    switch (qw())
    {
    case 1: 
    default: 
      return new ncv(this, paramActivity);
    case 3: 
      return new nct(this, paramkge);
    case 0: 
      return null;
    }
    return new ncu(this, paramActivity);
  }
  
  public void aVD()
  {
    if (qw() != 0) {
      kbp.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", kF(), false);
    }
  }
  
  public void aVE()
  {
    kbp.a(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", kF(), false);
  }
  
  public int qw()
  {
    if (!awit.aMG())
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode | hide mode");
      return 0;
    }
    if (kys.dt(kys.getChannelId()))
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInNormalDaily : " + this.aXN);
      return this.aXN;
    }
    QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInMixDaily : " + this.aXO);
    return this.aXO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncs
 * JD-Core Version:    0.7.0.1
 */