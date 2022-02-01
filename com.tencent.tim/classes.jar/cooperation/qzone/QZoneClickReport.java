package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class QZoneClickReport
{
  public static final int ACTION_TYPE_LIVE_READ = 8;
  public static final int RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PLUGIN = 3;
  public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PTU_SO = "1";
  public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_STL_SO = "2";
  public static final int SUB_ACTION_TYPE_LIVE_NOT_DOWNLOAD = 128;
  public static final String SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT = "125";
  public static final int SUB_ACTION_TYPE_LIVE_PLUGIN_MANUL_DOWNLOAD = 129;
  public static final String SUB_ACTION_TYPE_LIVE_PLUS_CLICK = "1";
  private static String TAG = QZoneClickReport.class.getSimpleName();
  public static boolean isShowToast;
  public static int reportAmount;
  public static int reportRate;
  
  private static long getLong(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 2, "long string(" + paramString + ") is ill-format, return default value " + paramLong);
    }
    return paramLong;
  }
  
  public static void report(String paramString, a parama, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new LpReportInfo_pf00064();
        paramString.extraInfo = parama.toJSON().toString();
        parama = LpReportManager.getInstance();
        if (!paramBoolean)
        {
          paramBoolean = true;
          parama.reportToPF00064(paramString, paramBoolean, false);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QZoneClickReport", 1, paramString, new Object[0]);
        return;
      }
      paramBoolean = false;
    }
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    a locala = new a();
    locala.toUin = getLong(paramString1, 0L);
    locala.actionType = paramString2;
    locala.cMI = paramString3;
    locala.reserves = paramString4;
    locala.readSource = paramString5;
    report(paramString1, locala, paramBoolean);
  }
  
  public static void startReportImediately(String paramString, a parama)
  {
    if ((getLong(paramString, 0L) <= 0L) || (parama == null)) {
      return;
    }
    try
    {
      paramString = new LpReportInfo_pf00064();
      paramString.extraInfo = parama.toJSON().toString();
      LpReportManager.getInstance().reportToPF00064(paramString, false, true);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneClickReport", 1, paramString, new Object[0]);
    }
  }
  
  public static void startReportImediately(String paramString1, String paramString2, String paramString3)
  {
    long l = getLong(paramString1, 0L);
    if (l > 0L)
    {
      a locala = new a();
      locala.aab(paramString2);
      locala.nG(l);
      locala.aac(paramString3);
      startReportImediately(paramString1, locala);
    }
  }
  
  public static class a
  {
    public String actionType = "";
    public String appId = "0";
    public String cMI = "";
    public String domain_type = "2";
    public String extraInfo = "";
    public String info = "";
    private Map<String, String> mapReportInfo;
    public int mergenum;
    public int networkType = NetworkState.getNetworkType();
    public String pushstatkey = "";
    public String readSource = "0";
    public String referId = "";
    public String reserves = "";
    public String reserves10 = "";
    public ArrayList<String> reservesExt;
    public String sourceFrom = "";
    public String sourceTo = "";
    public String sourceType = "";
    public int tabletype;
    public long time = System.currentTimeMillis();
    public long toUin;
    private boolean useMapMode;
    
    public a() {}
    
    public a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, ArrayList<String> paramArrayList)
    {
      this();
      this.toUin = paramLong;
      this.appId = paramString1;
      this.referId = paramString3;
      this.actionType = paramString4;
      this.cMI = paramString5;
      this.tabletype = paramInt;
      this.reserves = paramString6;
      this.info = paramString2;
      this.reservesExt = paramArrayList;
    }
    
    public a(long paramLong, String paramString, Map<String, String> paramMap)
    {
      this();
      this.toUin = paramLong;
      this.appId = paramString;
      this.useMapMode = true;
      if (paramMap != null)
      {
        this.mapReportInfo = new HashMap();
        this.mapReportInfo.putAll(paramMap);
      }
    }
    
    public a(String paramString)
    {
      this();
      this.readSource = paramString;
      this.actionType = "12";
    }
    
    public void aab(String paramString)
    {
      this.actionType = paramString;
    }
    
    public void aac(String paramString)
    {
      this.cMI = paramString;
    }
    
    public void aad(String paramString)
    {
      this.reserves = paramString;
    }
    
    public void nG(long paramLong)
    {
      this.toUin = paramLong;
    }
    
    public JSONObject toJSON()
      throws JSONException
    {
      if (!TextUtils.isEmpty(this.extraInfo)) {}
      Object localObject;
      for (JSONObject localJSONObject = new JSONObject(this.extraInfo);; localJSONObject = new JSONObject())
      {
        localJSONObject.put("touin", this.toUin);
        localJSONObject.put("network_type", String.valueOf(this.networkType));
        localJSONObject.put("tabletype", this.tabletype);
        if (!this.useMapMode) {
          break;
        }
        if ((this.mapReportInfo == null) || (this.mapReportInfo.isEmpty())) {
          break label366;
        }
        localObject = this.mapReportInfo.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      if (!localJSONObject.has("refer")) {
        localJSONObject.put("refer", this.referId);
      }
      localJSONObject.put("actiontype", this.actionType);
      localJSONObject.put("subactiontype", this.cMI);
      localJSONObject.put("tabletype", this.tabletype);
      localJSONObject.put("domain_type", this.domain_type);
      localJSONObject.put("reserves", this.reserves);
      localJSONObject.put("source_type", this.sourceType);
      localJSONObject.put("source_from", this.sourceFrom);
      localJSONObject.put("source_to", this.sourceTo);
      localJSONObject.put("mergenum", this.mergenum);
      localJSONObject.put("reserves10", this.reserves10);
      if (this.reservesExt != null)
      {
        int j = this.reservesExt.size();
        int i = 0;
        while (i < j)
        {
          localObject = (String)this.reservesExt.get(i);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localJSONObject.put("reserves" + (i + 2), localObject);
          }
          i += 1;
        }
      }
      label366:
      localJSONObject.put("read_source", this.readSource);
      localJSONObject.put("time", String.valueOf(this.time));
      localJSONObject.put("info", this.info);
      localJSONObject.put("pushstatkey", this.pushstatkey);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport
 * JD-Core Version:    0.7.0.1
 */