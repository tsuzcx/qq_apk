import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class aomy
{
  private ArrayList<String> Bm = new ArrayList();
  public String aft = "";
  public String bRd = "";
  public int cXn;
  public String clO = "";
  public String clZ = "";
  public String cma = "";
  public String cmb = "";
  public String cmc = "";
  public String cme = "";
  public int dPX;
  public int dPY;
  public long mFileSize;
  public int mIPStackType;
  private boolean mIsSuccess;
  public String mMD5 = "";
  public String mReason = "";
  public String mServerIp = "";
  public long mTimeCost;
  public String mUrl = "";
  
  private HashMap<String, String> aa()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("isSuccess", String.valueOf(this.mIsSuccess));
    localHashMap.put("server_ip", this.mServerIp);
    localHashMap.put("server_port", this.clZ);
    localHashMap.put("param_FailCode", this.cma);
    localHashMap.put("param_reason", this.mReason);
    localHashMap.put("param_errorDesc", this.clO);
    localHashMap.put("chatType", this.cmb);
    localHashMap.put("chatUin", this.cmc);
    localHashMap.put("file_url", this.mUrl);
    localHashMap.put("http_errorCode", this.cme);
    localHashMap.put("md5", this.mMD5);
    localHashMap.put("uuid", this.bRd);
    localHashMap.put("business_type", this.aft);
    localHashMap.put("param_time_cost", String.valueOf(this.mTimeCost));
    localHashMap.put("filesize", String.valueOf(this.mFileSize));
    localHashMap.put("param_Ipv6Policy", String.valueOf(this.dPX));
    localHashMap.put("msfConnIPType", String.valueOf(this.dPY));
    localHashMap.put("ipStackType", String.valueOf(this.mIPStackType));
    localHashMap.put("param_ipType", String.valueOf(this.cXn));
    return localHashMap;
  }
  
  private void dWb()
  {
    this.mIPStackType = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.dPY = MsfServiceSdk.get().getConnectedIPFamily();
    this.cXn = eF(this.mServerIp);
  }
  
  private void n(String paramString, HashMap<String, String> paramHashMap)
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("report , reportName = ").append(paramString).append(", mServerIp = ");
      if (this.mServerIp == null)
      {
        str = "null";
        QLog.d("RMServMonitorReport", 2, str + " , mTimeCost = " + this.mTimeCost);
      }
    }
    else if (this.cXn == 2)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString + "_ipv6", this.mIsSuccess, this.mTimeCost, this.mFileSize, paramHashMap, "");
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder().append("report , reportName = ").append(paramString).append("_ipv6, mServerIp = ");
        if (this.mServerIp != null) {
          break label217;
        }
      }
    }
    label217:
    for (paramString = "null";; paramString = this.mServerIp)
    {
      QLog.d("RMServMonitorReport", 2, paramString + " , mTimeCost = " + this.mTimeCost);
      return;
      str = this.mServerIp;
      break;
    }
  }
  
  public void da(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mServerIp != null))
    {
      if (this.Bm.contains(this.mServerIp)) {
        return;
      }
      this.Bm.add(this.mServerIp);
    }
    this.mIsSuccess = paramBoolean;
    dWb();
    n(paramString, aa());
  }
  
  protected int eF(String paramString)
  {
    int j = 3;
    int i = j;
    if (paramString != null)
    {
      paramString = paramString.replaceAll("[\\[\\]]", "");
      i = j;
      if (paramString != null)
      {
        if (!aoln.qc(paramString)) {
          break label34;
        }
        i = 2;
      }
    }
    label34:
    do
    {
      return i;
      i = j;
    } while (!aoln.qb(paramString));
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomy
 * JD-Core Version:    0.7.0.1
 */