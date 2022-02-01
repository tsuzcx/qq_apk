import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class uev
{
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private final String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "2909288299" };
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public uev(uet paramuet, BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_Int = pay.c();
    this.jdField_a_of_type_JavaLangString = ("PubAccountHttpDownloader." + this.jdField_a_of_type_Int);
  }
  
  private void a(NetResp paramNetResp)
  {
    if (paramNetResp != null)
    {
      if (paramNetResp.mRespProperties != null)
      {
        paramNetResp = (String)paramNetResp.mRespProperties.get("param_rspHeader");
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "resp: " + paramNetResp);
        return;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "esp headers: empty");
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "resp is null");
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int k;
    int j;
    if (paramString != null)
    {
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      k = arrayOfString.length;
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < k)
      {
        if (paramString.equals(arrayOfString[j])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
  {
    return new uew(this, paramURLDrawableHandler, this);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.d = null;
  }
  
  public void a(int paramInt, DownloadParams paramDownloadParams)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("puin"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get("puin");
      paramDownloadParams = (String)this.jdField_a_of_type_JavaUtilMap.get("msgid");
    }
    for (;;)
    {
      if (a((String)localObject1)) {}
      Object localObject2;
      do
      {
        return;
        if ((paramDownloadParams.mExtraInfo == null) || (!(paramDownloadParams.mExtraInfo instanceof MessageRecord))) {
          break label900;
        }
        paramDownloadParams = (MessageRecord)paramDownloadParams.mExtraInfo;
        localObject1 = paramDownloadParams.frienduin;
        if (((paramDownloadParams instanceof MessageForStructing)) && (((MessageForStructing)paramDownloadParams).structingMsg != null))
        {
          paramDownloadParams = "" + ((MessageForStructing)paramDownloadParams).structingMsg.msgId;
          break;
        }
        if ((!(paramDownloadParams instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramDownloadParams).mPAMessage == null)) {
          break label895;
        }
        paramDownloadParams = "" + ((MessageForPubAccount)paramDownloadParams).mPAMessage.mMsgId;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
        if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {
          break label334;
        }
        localObject2 = (QQAppInterface)localObject2;
        if (localObject1 == null) {
          break label310;
        }
        switch (ugf.a((QQAppInterface)localObject2, (String)localObject1))
        {
        }
      } while (this.jdField_b_of_type_Int == 0);
      int j = 0;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_acc_type", "" + j);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", localObject1);
      label310:
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", localObject1);
      }
      label334:
      if (paramDownloadParams != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_msgid", paramDownloadParams);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("AttemptCount", "" + paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put("picFormat", this.e);
      this.jdField_a_of_type_JavaUtilHashMap.put("netType", this.h);
      this.jdField_a_of_type_JavaUtilHashMap.put("plateform", this.g);
      this.jdField_a_of_type_JavaUtilHashMap.put("pixDensity", this.i);
      paramDownloadParams = InnerDns.getInstance().reqDnsForIpList(this.jdField_c_of_type_JavaLangString, 1009);
      if (paramDownloadParams != null)
      {
        paramDownloadParams = TextUtils.join(",", paramDownloadParams);
        label459:
        this.jdField_a_of_type_JavaUtilHashMap.put("IPs", paramDownloadParams);
        this.jdField_a_of_type_JavaUtilHashMap.put("ServerIP", "");
        this.jdField_a_of_type_JavaUtilHashMap.put("OriginURL", this.jdField_b_of_type_JavaLangString);
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Boolean) {
          break label852;
        }
        paramDownloadParams = String.valueOf(1);
        label514:
        ((HashMap)localObject1).put("Success", paramDownloadParams);
        this.jdField_a_of_type_JavaUtilHashMap.put("TotalTime", Long.toString(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("picType", this.f);
        this.jdField_a_of_type_JavaUtilHashMap.put("ReceivedBytes", String.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("ErrorReason", this.d);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", this.jdField_c_of_type_Int + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("Speed", Float.toString((float)this.jdField_c_of_type_Long / ((float)this.jdField_b_of_type_Long / 1000.0F)));
        paramDownloadParams = "actSubscriptionUnkonw";
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      for (;;)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportTag:").append(paramDownloadParams).append(", success:").append(this.jdField_a_of_type_Boolean).append(", time:").append(this.jdField_b_of_type_Long).append(", size:").append(this.jdField_c_of_type_Long).append(", url:").append(this.jdField_b_of_type_JavaLangString).append(", exInfo:").append(this.jdField_a_of_type_JavaUtilHashMap.toString());
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, ((StringBuilder)localObject1).toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramDownloadParams, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
        return;
        j = 1;
        break;
        j = 2;
        break;
        j = 3;
        break;
        j = 4;
        break;
        paramDownloadParams = "";
        break label459;
        label852:
        paramDownloadParams = String.valueOf(0);
        break label514;
        paramDownloadParams = "actSubscriptionAIO";
        continue;
        paramDownloadParams = "actSubscriptionDetail";
        continue;
        paramDownloadParams = "actSubscriptionFolder";
        continue;
        paramDownloadParams = "actKandianImage";
        continue;
        paramDownloadParams = "actNativeWebImage";
      }
      label895:
      paramDownloadParams = null;
      continue;
      label900:
      paramDownloadParams = null;
      localObject1 = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = paramInt;
    }
    this.d = paramString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(DownloadParams paramDownloadParams, Map<String, String> paramMap)
  {
    long l = NetworkCenter.getInstance().getNetType();
    this.h = "None";
    if ((l > 0L) && (l < AppConstants.NET_TYPE_NAME.length)) {
      this.h = AppConstants.NET_TYPE_NAME[((int)l)];
    }
    this.g = ("ANDROID.MOBILE-" + Build.MODEL + ".SDK-" + Build.VERSION.SDK);
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
    this.i = (localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
    this.jdField_b_of_type_JavaLangString = paramDownloadParams.urlStr;
    this.jdField_c_of_type_JavaLangString = paramDownloadParams.url.getHost();
    this.e = "none";
    int j = this.jdField_b_of_type_JavaLangString.lastIndexOf("/");
    if ((j != -1) && (j + 1 <= this.jdField_b_of_type_JavaLangString.length()) && (j + 1 < this.jdField_b_of_type_JavaLangString.length()))
    {
      this.e = this.jdField_b_of_type_JavaLangString.substring(j + 1);
      j = this.e.indexOf("?");
      if (j != -1) {
        this.e = this.e.substring(0, j);
      }
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(NetResp paramNetResp, String paramString)
  {
    a(paramNetResp);
    if (paramNetResp != null)
    {
      this.f = "none";
      paramString = (String)paramNetResp.mRespProperties.get("Content-Type");
      if ((paramString != null) && (paramString.startsWith("image/"))) {
        this.f = paramString.replace("image/", "");
      }
      this.jdField_c_of_type_Long = paramNetResp.mTotalFileLen;
      return;
    }
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uev
 * JD-Core Version:    0.7.0.1
 */