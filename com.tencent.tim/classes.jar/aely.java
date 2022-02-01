import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aely
{
  public long Wm;
  public long Wn = 0L;
  public long Wo = 524288000L;
  public long Wp = 31457280L;
  public long Wq = 31457280L;
  public long Wr = 31457280L;
  public long Ws = 100L;
  public long Wt = 150L;
  public long Wu = 40960L;
  public long Wv = 71680L;
  public long Ww = 204800L;
  public long Wx = 1L;
  public long Wy = 819200L;
  public String bzA = "51f3f3f7";
  public String bzB = "20-24;0-1";
  public String bzy = "12000|600|20000|400|6000|300|20000|200";
  public String bzz = "20|10|50|10";
  
  public static aely a(aeic[] paramArrayOfaeic)
  {
    aely localaely = new aely();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      int j = paramArrayOfaeic.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaeic[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aeic)localObject).content;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localaely);
            b(localJSONObject, localaely);
            if (QLog.isColorLevel()) {
              QLog.i("PicPreDownloadBean", 2, "parse: " + (String)localObject + " bean:" + localaely.toString());
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return localaely;
  }
  
  private static void a(JSONObject paramJSONObject, aely paramaely)
  {
    if (paramJSONObject.has("PicPreDownSwitch")) {
      paramaely.Wm = paramJSONObject.optLong("PicPreDownSwitch");
    }
    if (paramJSONObject.has("PicAuDownTimePoint")) {
      paramaely.Wn = paramJSONObject.optLong("PicAuDownTimePoint");
    }
    if (paramJSONObject.has("MaxWifiFlow")) {
      paramaely.Wo = paramJSONObject.optLong("MaxWifiFlow");
    }
    if (paramJSONObject.has("Max4GFlow")) {
      paramaely.Wp = paramJSONObject.optLong("Max4GFlow");
    }
    if (paramJSONObject.has("Max3GFlow")) {
      paramaely.Wq = paramJSONObject.optLong("Max3GFlow");
    }
    if (paramJSONObject.has("Max2GFlow")) {
      paramaely.Wr = paramJSONObject.optLong("Max2GFlow");
    }
  }
  
  private static void b(JSONObject paramJSONObject, aely paramaely)
  {
    if (paramJSONObject.has("flowCombination")) {
      paramaely.bzy = paramJSONObject.optString("flowCombination");
    }
    if (paramJSONObject.has("troopCombination")) {
      paramaely.bzz = paramJSONObject.optString("troopCombination");
    }
    if (paramJSONObject.has("maxRequest")) {
      paramaely.Ws = paramJSONObject.optLong("maxRequest");
    }
    if (paramJSONObject.has("xGPreDownPolicy")) {
      paramaely.bzA = paramJSONObject.optString("xGPreDownPolicy");
    }
    if (paramJSONObject.has("AFBFlowHitXG")) {
      paramaely.Wt = paramJSONObject.optLong("AFBFlowHitXG");
    }
    if (paramJSONObject.has("AFBFlowMissXG")) {
      paramaely.Wu = paramJSONObject.optLong("AFBFlowMissXG");
    }
    if (paramJSONObject.has("APicAvgSize")) {
      paramaely.Wv = paramJSONObject.optLong("APicAvgSize");
    }
    if (paramJSONObject.has("APicMaxSize")) {
      paramaely.Ww = paramJSONObject.optLong("APicMaxSize");
    }
    if (paramJSONObject.has("enablePeakFlow")) {
      paramaely.Wx = paramJSONObject.optLong("enablePeakFlow");
    }
    if (paramJSONObject.has("PeakFlowTimePeriod")) {
      paramaely.bzB = paramJSONObject.optString("PeakFlowTimePeriod");
    }
    if (paramJSONObject.has("PeakFlowMaxPicSize")) {
      paramaely.Wy = paramJSONObject.optLong("PeakFlowMaxPicSize");
    }
  }
  
  public String toString()
  {
    return "PicPreDownloadBean{,PreDownSwitch=" + this.Wm + ",PicAuDownTimePoint=" + this.Wn + ",PreDownMaxWifiFlow=" + this.Wo + ",PreDownMax4GFlow=" + this.Wp + ",PreDownMax3GFlow=" + this.Wq + ",PreDownMax2GFlow=" + this.Wr + ",flowsCombination=" + this.bzy + ",troopCombination=" + this.bzz + ",requestListMaxSize=" + this.Ws + ",xGPreDownPolicy=" + this.bzA + ",xgFlowHitFeedback=" + this.Wt + ",XgFlowMissFeedback=" + this.Wu + ",pisSizeAvg=" + this.Wv + ",pisSizeMax=" + this.Ww + ",mEnablePeakFlow=" + this.Wx + ",mPeakFlowTimePeriod=" + this.bzB + ",mPeakFlowMaxPicSize=" + this.Wy + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aely
 * JD-Core Version:    0.7.0.1
 */