package cooperation.qzone.report.lp;

import android.os.Build;
import avpp;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class LpReportInfo_dc04171
  implements LpReportInfo
{
  public String mAppid = "";
  public String mBytesRefer;
  public String mChatId;
  public String mGuid = "";
  public int mMsgFrom;
  public int mMsgType;
  public String mPlatform;
  public String mQQPfTo = "";
  public String mSenderUin;
  public String mSubAppid = "";
  public String mUrl;
  
  public LpReportInfo_dc04171(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    this.mUrl = paramString1;
    this.mBytesRefer = paramString2;
    this.mPlatform = paramString3;
    this.mMsgType = paramInt1;
    this.mMsgFrom = paramInt2;
    this.mSenderUin = paramString4;
    this.mChatId = paramString5;
  }
  
  public static void report(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5)
  {
    paramString1 = new LpReportInfo_dc04171(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramString5);
    LpReportManager.getInstance().reportToDC04171(paramString1, false, false);
  }
  
  public String getSimpleInfo()
  {
    return "dc041171:" + this.mUrl + "," + this.mBytesRefer + "," + this.mPlatform;
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    LpReportUtils.safePut(localHashMap, "uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    LpReportUtils.safePut(localHashMap, "appid", this.mAppid);
    LpReportUtils.safePut(localHashMap, "subappid", this.mSubAppid);
    LpReportUtils.safePut(localHashMap, "os_type", "Android");
    LpReportUtils.safePut(localHashMap, "app_name", "QQ");
    LpReportUtils.safePut(localHashMap, "device_name", Build.MODEL);
    LpReportUtils.safePut(localHashMap, "imei", avpp.a().getIMEI());
    LpReportUtils.safePut(localHashMap, "guid", this.mGuid);
    LpReportUtils.safePut(localHashMap, "url", this.mUrl);
    LpReportUtils.safePut(localHashMap, "qq_pf_to", this.mQQPfTo);
    LpReportUtils.safePut(localHashMap, "bytes_referer", this.mBytesRefer);
    LpReportUtils.safePut(localHashMap, "plateform", this.mPlatform);
    LpReportUtils.safePut(localHashMap, "msg_type", String.valueOf(this.mMsgType));
    LpReportUtils.safePut(localHashMap, "msg_from", String.valueOf(this.mMsgFrom));
    LpReportUtils.safePut(localHashMap, "send_uin", this.mSenderUin);
    LpReportUtils.safePut(localHashMap, "msg_chatid", this.mChatId);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc04171
 * JD-Core Version:    0.7.0.1
 */