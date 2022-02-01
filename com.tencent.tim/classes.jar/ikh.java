import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ikh
{
  private static ArrayList<PendantItem> in;
  private static int mDownloadCount;
  private static int mTotalCount;
  
  private static Class<?> a()
  {
    return PendantItem.class;
  }
  
  private static String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = igg.gw() + paramPendantItem.getName();
    }
    return str;
  }
  
  public static void ann()
  {
    aqmj.kl(mDownloadCount, mTotalCount);
    igd.aJ("AVEffectPendantReport", "setAVPendantDownloadInfo()  mTotalCount = " + mTotalCount + "  mDownloadCount = " + mDownloadCount);
  }
  
  public static void ano()
  {
    aqmj.ano();
    igd.aJ("AVEffectPendantReport", "setAVPendantUseInfo()  time = " + System.currentTimeMillis());
  }
  
  public static void anp()
  {
    ThreadManager.getFileThreadHandler().post(new AVEffectPendantReport.1());
  }
  
  public static void anq()
  {
    String str = getConfigString();
    in = null;
    in = o(str);
  }
  
  public static void anr()
  {
    long l1 = -1L;
    try
    {
      localHashMap = new HashMap();
      bool = aqmj.aFc();
      arrayOfInt = aqmj.ag();
      l2 = aqmj.hP();
      if ((!bool) && (arrayOfInt[1] <= 0))
      {
        alwd.a().Ol(false);
        aqmj.eeq();
      }
      if (l2 <= 0L) {
        break label361;
      }
      l1 = (System.currentTimeMillis() - l2) / 1000L;
    }
    catch (Throwable localThrowable)
    {
      int[] arrayOfInt;
      do
      {
        HashMap localHashMap;
        boolean bool;
        long l2;
        BigDecimal localBigDecimal;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AVEffectPendantReport", 2, "reportAVPendantDownloadInfo", localThrowable);
        return;
        if ((arrayOfInt[0] <= 0) && (arrayOfInt[1] <= 0)) {
          break;
        }
      } while (arrayOfInt[0] <= arrayOfInt[1]);
    }
    localBigDecimal = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
    localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
    localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
    localHashMap.put("filter_ratio", String.valueOf(localBigDecimal.setScale(2, 4).floatValue()));
    localHashMap.put("filter_spacing", String.valueOf(l1));
    if (QLog.isColorLevel()) {
      QLog.d("DailyReport", 2, "reportAVPendantDownloadInfo filter_download = " + arrayOfInt[0] + ",filter_total = " + arrayOfInt[1] + ",filter_spacing" + l1);
    }
    bool = UserAction.onUserAction("AVFunChatExpression", true, -1L, -1L, localHashMap, true);
    UserAction.flushObjectsToDB(true);
    igd.aJ("AVEffectPendantReport", "reportAVPendantDownloadInfo, filter_download[" + (String)localHashMap.get("filter_download") + "], filter_total[" + (String)localHashMap.get("filter_total") + "],filter_total[" + (String)localHashMap.get("filter_ratio") + "],filter_ratio[" + (String)localHashMap.get("filter_spacing") + "], lastUserTime = " + l2 + "    ret[" + bool + "]");
    return;
    label361:
  }
  
  private static boolean b(PendantItem paramPendantItem)
  {
    if ((getConfigID() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId()))) {
      igd.aL("AVEffectPendantReport", "isTemplateUsable:" + getConfigID() + "|");
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
        return true;
      }
    } while (!new File(a(paramPendantItem)).exists());
    System.currentTimeMillis();
    String str = SecUtil.getFileMd5(a(paramPendantItem));
    System.currentTimeMillis();
    return paramPendantItem.getMd5().equalsIgnoreCase(str);
  }
  
  private static String gL()
  {
    return "content";
  }
  
  private static int getConfigID()
  {
    return 106;
  }
  
  private static String getConfigString()
  {
    return igl.b(getConfigID()).content;
  }
  
  private static ArrayList<PendantItem> o(String paramString)
  {
    localArrayList = new ArrayList();
    mTotalCount = 0;
    mDownloadCount = 0;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = jll.mM();
        Object localObject = gL();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = a();
          int i = 0;
          while (i < paramString.length())
          {
            PendantItem localPendantItem = (PendantItem)aqec.convertFrom((JSONObject)paramString.get(i), (Class)localObject);
            if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())) && (localPendantItem.isShow()))
            {
              int k = localPendantItem.getPlatform();
              if ((k == 0) || (j >= k))
              {
                boolean bool = b(localPendantItem);
                localPendantItem.setUsable(bool);
                localArrayList.add(localPendantItem);
                mTotalCount += 1;
                if (bool) {
                  mDownloadCount += 1;
                }
              }
            }
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikh
 * JD-Core Version:    0.7.0.1
 */