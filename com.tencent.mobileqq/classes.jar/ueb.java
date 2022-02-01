import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ueb
{
  public static long a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (uki.d(paramAdvertisementInfo)) {
      return 30102L;
    }
    if (uki.b(paramAdvertisementInfo)) {
      return 30103L;
    }
    return 0L;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "0";
    case 1: 
      return "1";
    case 2: 
      return "2";
    }
    return "3";
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return "0";
          if (paramBoolean1) {
            return "1";
          }
        } while (!paramBoolean2);
        return "0";
        return "8";
        return "9";
        if (paramBoolean1) {
          return "2";
        }
      } while (!paramBoolean2);
      return "1";
    } while (!paramBoolean2);
    return "2";
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (paramAdvertisementInfo == null) {
      return null;
    }
    int i = uek.a(paramAdvertisementInfo);
    HashMap localHashMap;
    if (i >= 0)
    {
      str = i + "";
      localHashMap = new HashMap();
      localHashMap.put("oper_module", Long.valueOf(a(paramAdvertisementInfo)));
      localHashMap.put("oper_id", Long.valueOf(paramLong1));
      localHashMap.put("oper_type", Long.valueOf(paramLong2));
      localHashMap.put("obj_id", "" + str);
      localHashMap.put("loc_id", "0");
      if (paramAdvertisementInfo.gameAdComData == null) {
        break label347;
      }
      str = paramAdvertisementInfo.gameAdComData.g;
      label141:
      localHashMap.put("app_id", str);
      if (paramAdvertisementInfo.gameAdComData == null) {
        break label354;
      }
    }
    label347:
    label354:
    for (String str = paramAdvertisementInfo.gameAdComData.d;; str = "")
    {
      localHashMap.put("game_pkg", str);
      localHashMap.put("ex1", paramString1);
      localHashMap.put("ex2", paramAdvertisementInfo.getExtraParam("game_adtag"));
      localHashMap.put("ex3", paramAdvertisementInfo.mRowKey);
      localHashMap.put("ex4", String.valueOf(paramAdvertisementInfo.mArticleID));
      localHashMap.put("ex5", paramString2);
      paramAdvertisementInfo = new JSONObject();
      paramString1 = localHashMap.keySet();
      try
      {
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramAdvertisementInfo.put(paramString2, localHashMap.get(paramString2));
        }
        str = "";
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = new JSONObject();
        try
        {
          paramString1.put("game_gift_report", paramAdvertisementInfo.toString());
          return paramString1;
        }
        catch (JSONException paramAdvertisementInfo)
        {
          paramAdvertisementInfo.printStackTrace();
          return paramString1;
        }
      }
      break;
      str = "";
      break label141;
    }
  }
  
  public static JSONObject a(AdData paramAdData, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    if (paramAdData == null) {
      return null;
    }
    return a(paramAdData.a, paramLong1, paramLong2, paramString1, paramString2);
  }
  
  public static void a(JumpMode paramJumpMode, AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    long l = 3010205L;
    if (paramAdvertisementInfo == null) {
      ukq.a("GameComponentReport", "doGameDownloadStateReport:advertisementInfo is null");
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return;
      bool1 = uki.d(paramAdvertisementInfo);
      bool2 = uki.b(paramAdvertisementInfo);
    } while ((!bool1) && (!bool2));
    String str = a(bool1, bool2, paramInt);
    if (bool1) {}
    for (;;)
    {
      paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
      a(paramAdvertisementInfo, ois.a(paramAdvertisementInfo), a(paramAdvertisementInfo, l, 9L, str, paramString), ReportAction.CLICK, ActionEntity.GamePopWindow, paramJumpMode);
      return;
      if (bool2) {
        l = 3010307L;
      }
    }
  }
  
  public static void a(JumpMode paramJumpMode, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    a(paramAdvertisementInfo, paramJSONObject1, paramJSONObject2, ReportAction.CLICK, ActionEntity.Default, paramJumpMode);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    if (paramAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameComponentReport", 2, "advertisementInfo is null");
      }
      return;
    }
    String str = a(paramInt);
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClickBtn;
    a(paramAdvertisementInfo, ois.a(paramAdvertisementInfo), a(paramAdvertisementInfo, 3010305L, 10L, str, paramString), ReportAction.CLICK, ActionEntity.GamePopWindow, JumpMode.GIFT);
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2, ReportAction paramReportAction, ActionEntity paramActionEntity, JumpMode paramJumpMode)
  {
    uks.b(paramAdvertisementInfo);
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    ois.a(new ufy().a(localQQAppInterface).a(BaseApplication.getContext()).a(119).b(39).a(paramReportAction).a(paramJumpMode).a(paramActionEntity).e(paramJSONObject2).a(paramAdvertisementInfo).d(paramJSONObject1).a());
  }
  
  public static void b(JumpMode paramJumpMode, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    paramAdvertisementInfo.adClickPos = AdClickPos.SoftAdClose;
    a(paramAdvertisementInfo, paramJSONObject1, paramJSONObject2, ReportAction.CLOSE, ActionEntity.Default, paramJumpMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ueb
 * JD-Core Version:    0.7.0.1
 */