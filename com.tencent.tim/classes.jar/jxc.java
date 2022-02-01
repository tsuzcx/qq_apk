import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;

public class jxc
{
  public String UA = "";
  public String Uw;
  public String Ux = "";
  public String Uy = "";
  public String Uz = "";
  public jxe a;
  public int aDQ;
  public int aDR;
  public int aDS;
  public boolean hasReport;
  public ArrayList<jxd> jw;
  public String mSenderUin;
  public long msgTime;
  public long msgUid;
  public long pushTime;
  public long qV;
  public short shMsgSeq;
  
  public jxc() {}
  
  public jxc(String paramString1, String paramString2, ArrayList<jxd> paramArrayList, String paramString3)
  {
    this.mSenderUin = paramString1;
    this.Uw = paramString2;
    this.jw = paramArrayList;
    this.a = new jxe(paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "AdvertisementItem json:" + paramString3);
    }
  }
  
  public static jxc a(String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static jxc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        jxc localjxc = new jxc();
        localjxc.mSenderUin = paramJSONObject.getString("senderUin");
        localjxc.Uw = paramJSONObject.getString("pageUrl");
        localjxc.Ux = paramJSONObject.optString("adMsgId");
        localjxc.pushTime = paramJSONObject.optLong("pushTime");
        localjxc.hasReport = paramJSONObject.optBoolean("hasReport");
        localjxc.Uy = paramJSONObject.optString("str_nick");
        localjxc.Uz = paramJSONObject.optString("str_head_url");
        localjxc.UA = paramJSONObject.optString("str_brief");
        localjxc.aDQ = paramJSONObject.optInt("video_preload_state");
        localjxc.qV = paramJSONObject.optLong("invalidTime");
        localjxc.msgTime = paramJSONObject.optLong("msgTime");
        localjxc.shMsgSeq = ((short)paramJSONObject.optInt("shMsgSeq"));
        localjxc.msgUid = paramJSONObject.optLong("msgUid");
        localjxc.aDR = ((short)paramJSONObject.optInt("maxExposureTime"));
        localjxc.aDS = ((short)paramJSONObject.optInt("realExposureTime"));
        localjxc.jw = new ArrayList();
        JSONArray localJSONArray = paramJSONObject.getJSONArray("videoList");
        i = 0;
        if (i < localJSONArray.length())
        {
          jxd localjxd = jxd.a(localJSONArray.getJSONObject(i));
          if (localjxd != null) {
            localjxc.jw.add(localjxd);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("AdvertisementRecentUserManager", 2, "convertFromJson msgCommonData" + paramJSONObject.optString("msgCommonData"));
          }
          localjxc.a = new jxe(paramJSONObject.optString("msgCommonData"));
          return localjxc;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static jxc b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        jxc localjxc = new jxc();
        localjxc.mSenderUin = paramJSONObject.getString("uint64_from_uin");
        localjxc.Uy = paramJSONObject.optString("str_nick");
        localjxc.Uz = paramJSONObject.optString("str_head_url");
        localjxc.UA = paramJSONObject.optString("str_brief");
        localjxc.Uw = paramJSONObject.getString("str_url");
        localjxc.pushTime = (paramJSONObject.optLong("uint32_pushTime") * 1000L);
        localjxc.qV = (paramJSONObject.optLong("uint32_invalidTime") * 1000L);
        localjxc.aDR = paramJSONObject.optInt("uint32_maxExposureTime");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_msg_video");
        localjxc.jw = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          jxd localjxd = jxd.a(i, localJSONArray.getJSONObject(i));
          if (localjxd != null) {
            localjxc.jw.add(localjxd);
          }
        }
        else
        {
          localjxc.a = jxe.a(paramJSONObject.optString("msg_msgCommonData"), localjxc.mSenderUin, localjxc.Uy);
          paramJSONObject = localjxc.a;
          if (paramJSONObject == null) {
            break;
          }
          return localjxc;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (jxc)paramObject;
    return this.mSenderUin.equals(paramObject.mSenderUin);
  }
  
  public String hV()
  {
    Object localObject;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localObject = this.jw.iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = ((jxd)((Iterator)localObject).next()).l();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      localObject = new JSONObject();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    ((JSONObject)localObject).put("senderUin", this.mSenderUin);
    ((JSONObject)localObject).put("pageUrl", this.Uw);
    ((JSONObject)localObject).put("adMsgId", this.Ux);
    ((JSONObject)localObject).put("pushTime", this.pushTime);
    ((JSONObject)localObject).put("hasReport", this.hasReport);
    ((JSONObject)localObject).put("videoList", localException);
    ((JSONObject)localObject).put("str_nick", this.Uy);
    ((JSONObject)localObject).put("str_head_url", this.Uz);
    ((JSONObject)localObject).put("str_brief", this.UA);
    ((JSONObject)localObject).put("video_preload_state", this.aDQ);
    ((JSONObject)localObject).put("invalidTime", this.qV);
    ((JSONObject)localObject).put("msgTime", this.msgTime);
    ((JSONObject)localObject).put("shMsgSeq", this.shMsgSeq);
    ((JSONObject)localObject).put("msgUid", this.msgUid);
    ((JSONObject)localObject).put("maxExposureTime", this.aDR);
    ((JSONObject)localObject).put("realExposureTime", this.aDS);
    if (QLog.isColorLevel()) {
      QLog.w("AdvertisementRecentUserManager", 2, "convertToJson msgCommonData" + this.a.l().toString());
    }
    ((JSONObject)localObject).put("msgCommonData", this.a.l().toString());
    String str = ((JSONObject)localObject).toString();
    return str;
  }
  
  public int hashCode()
  {
    return this.mSenderUin.hashCode();
  }
  
  public oidb_cmd0x886.AdInfo makeReportAdInfo(int paramInt)
  {
    long l2 = 0L;
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.Ux));
    localAdInfo.uint64_pull_time.set(this.pushTime);
    localAdInfo.enum_report_type.set(paramInt);
    try
    {
      l1 = Long.parseLong(this.a.UE);
      try
      {
        long l3 = Long.parseLong(this.a.hT);
        l2 = l3;
      }
      catch (Exception localException2)
      {
        label75:
        break label75;
      }
      localAdInfo.uint64_pos_id.set(l1);
      localAdInfo.uint64_aid.set(l2);
      return localAdInfo;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("====mSenderUin " + this.mSenderUin + "\n").append("====mContentPageUrl " + this.Uw + "\n").append("====invalidTime " + this.qV).append("====shMsgSeq " + this.shMsgSeq).append("====maxExposureTime " + this.aDR);
    Iterator localIterator;
    if ((this.jw != null) && (this.jw.size() > 0)) {
      localIterator = this.jw.iterator();
    }
    while (localIterator.hasNext())
    {
      jxd localjxd = (jxd)localIterator.next();
      localStringBuilder.append("====VideoCoverItem " + localjxd.toString() + "\n");
      continue;
      localStringBuilder.append("====VideoCoverItem NULL ~ \n");
    }
    if (this.a != null) {
      localStringBuilder.append("====VideoDownloadItem " + this.a.toString() + "\n");
    }
    return localStringBuilder.toString();
  }
  
  public boolean yF()
  {
    if (this.aDR == 0) {
      return true;
    }
    if (this.aDS >= this.aDR) {
      return false;
    }
    this.aDS += 1;
    return true;
  }
  
  public boolean yG()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.a.UD));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jxc
 * JD-Core Version:    0.7.0.1
 */