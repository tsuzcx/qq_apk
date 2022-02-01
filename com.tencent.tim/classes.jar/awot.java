import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.pb.gamecenter.MonitReport.MonitReportReq;
import com.tencent.pb.gamecenter.MonitReport.PublicAccountReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.sso.WadlCmdUtil.1;
import cooperation.wadl.sso.WadlCmdUtil.2;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class awot
{
  public static String TAG = "WadlCmdUtil";
  private static volatile awot a;
  public static HashSet<String> bU = new HashSet();
  private static String cRR;
  private static String cRS;
  static byte[] lock = new byte[0];
  private CopyOnWriteArrayList<WeakReference<awos>> Z = new CopyOnWriteArrayList();
  private long aBs = -1L;
  private short aJ;
  
  static
  {
    bU.add("13169");
    bU.add("13032");
    bU.add("12820");
  }
  
  public static File R()
  {
    return new File(S(), "conf.json");
  }
  
  public static File S()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "gc_conf");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static void X(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[reportGamePubAccountMsgList] status:" + paramInt + ",msg:" + paramString1 + ",url:" + paramString2);
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = Long.valueOf(0L);; paramString1 = Long.valueOf(Long.parseLong(paramString1)))
    {
      localPublicAccountReq.msgid.set(paramString1.longValue());
      localPublicAccountReq.url.set(paramString2);
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramString1 = new NewIntent(BaseApplicationImpl.getApplication(), awor.class);
      paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if (paramString2 != null) {
        break;
      }
      return;
    }
    paramString2.startServlet(paramString1);
  }
  
  public static awot a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new awot();
      }
      return a;
    }
  }
  
  private void b(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listeners size=" + this.Z.size());
    }
    Iterator localIterator = this.Z.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      awos localawos = (awos)((WeakReference)localObject).get();
      if (localawos != null)
      {
        localObject = localawos.getFilterCmds();
        if ((localObject == null) || (((HashSet)localObject).contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyListeners cmd=" + paramString + ",ret=" + paramLong + ",listener=" + localawos);
          }
          localawos.onCmdRsp(paramIntent, paramString, paramLong, paramJSONObject);
        }
      }
      else
      {
        this.Z.remove(localObject);
      }
    }
  }
  
  private void bH(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "writeConfig...newVersion=" + paramLong + ",content=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManagerV2.excute(new WadlCmdUtil.2(this, paramString, paramLong), 16, null, false);
  }
  
  private void nU(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "requestConfig currVersion=" + paramLong);
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("op_version", paramLong);
      localJSONObject1.put("req", localJSONObject2);
      a("13136", localJSONObject1, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static String o(AppInterface paramAppInterface)
  {
    if ((TextUtils.isEmpty(cRS)) && (paramAppInterface != null))
    {
      paramAppInterface = paramAppInterface.getApp();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getResources().getDisplayMetrics();
        cRS = paramAppInterface.widthPixels + "*" + paramAppInterface.heightPixels;
      }
    }
    return cRS;
  }
  
  public void D(String paramString, ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (paramArrayList != null)
    {
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put((String)((Iterator)localObject).next());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getApkDownloadInfo channelId=" + paramString + ",appIds=" + localJSONArray);
    }
    try
    {
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("channel_id", paramString);
      localJSONObject.put("v_appid", localJSONArray);
      ((JSONObject)localObject).put("req", localJSONObject);
      paramString = new Bundle();
      paramString.putStringArrayList("appids", paramArrayList);
      a("13169", (JSONObject)localObject, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getApkDownloadInfo exception=", paramString);
    }
  }
  
  public void S(boolean paramBoolean, long paramLong)
  {
    ThreadManagerV2.excute(new WadlCmdUtil.1(this, paramBoolean, paramLong), 16, null, false);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (paramIntent == null) {}
    long l2;
    do
    {
      return;
      localObject3 = null;
      l2 = -1L;
      localObject1 = paramIntent.getStringExtra("webssoCmdId");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = localObject3;
      l1 = l2;
      if (paramBoolean)
      {
        localObject1 = localObject3;
        l1 = l2;
        if (paramArrayOfByte != null) {
          l1 = l2;
        }
      }
      try
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
        l1 = l2;
        localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
        l1 = l2;
        l2 = localUniSsoServerRsp.ret.get();
        localObject1 = localObject3;
        l1 = l2;
        if (l2 == 0L)
        {
          l1 = l2;
          paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get());
          localObject1 = localObject3;
          l1 = l2;
          if (paramArrayOfByte != null)
          {
            l1 = l2;
            paramArrayOfByte = paramArrayOfByte.optJSONObject((String)localObject2);
            localObject1 = localObject3;
            l1 = l2;
            if (paramArrayOfByte != null)
            {
              l1 = l2;
              paramArrayOfByte = paramArrayOfByte.optJSONObject("data");
              localObject1 = localObject3;
              l1 = l2;
              if (paramArrayOfByte != null)
              {
                l1 = l2;
                localObject1 = paramArrayOfByte.optJSONObject("rsp");
                l1 = l2;
              }
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "onRespWebSso err:" + paramArrayOfByte.getMessage());
          localObject1 = localObject3;
          continue;
          this.aJ = ((short)(this.aJ + 1));
          continue;
          if (("12829".equals(localObject2)) && (l1 == 0L) && (localObject1 != null))
          {
            GameNoticeInfo.saveTipInfo(paramIntent.getExtras().getString("appId"), (JSONObject)localObject1);
            continue;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onRespWebSso webssoCmd=" + (String)localObject2 + ",isSucc=" + paramBoolean + ",ret=" + l1 + ",rspJson=" + localObject1);
      }
    } while (("12934".equals(localObject2)) || ("13325".equals(localObject2)));
    if ("13136".equals(localObject2)) {
      if ((paramBoolean) && (localObject1 != null))
      {
        this.aJ = 0;
        this.aBs = System.currentTimeMillis();
        l2 = ((JSONObject)localObject1).optLong("version", -1L);
        if (l2 > -1L) {
          bH(((JSONObject)localObject1).optString("content"), l2);
        }
        if (localObject1 != null) {
          break label482;
        }
        paramArrayOfByte = new JSONObject();
        b(paramIntent, (String)localObject2, l1, paramArrayOfByte);
        return;
      }
    }
  }
  
  public void a(awos paramawos)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "addListener listener=" + paramawos);
    }
    if (paramawos == null) {
      return;
    }
    Iterator localIterator = this.Z.iterator();
    while (localIterator.hasNext())
    {
      awos localawos = (awos)((WeakReference)localIterator.next()).get();
      if ((localawos != null) && (localawos == paramawos)) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "addListener listener=" + paramawos + " succ");
    }
    this.Z.add(new WeakReference(paramawos));
  }
  
  public void a(WadlParams paramWadlParams, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "checkGameDownload wadlParams=" + paramWadlParams);
    }
    if (paramWadlParams == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad_tag", paramWadlParams.bLF);
      localJSONObject2.put("appid", paramWadlParams.appId);
      localJSONObject2.put("channel_id", paramWadlParams.apkChannel);
      localJSONObject2.put("download_url", paramWadlParams.apkUrl);
      localJSONObject2.put("source_url", paramWadlParams.bLE);
      localJSONObject2.put("refer", paramWadlParams.extraData);
      localJSONObject2.put("version_code", String.valueOf(paramWadlParams.versionCode));
      localJSONObject2.put("clientver", "3.4.4");
      localJSONObject1.put("req", localJSONObject2);
      a("12829", localJSONObject1, paramBundle);
      return;
    }
    catch (Exception paramWadlParams)
    {
      QLog.e(TAG, 1, "checkGameDownload exception=", paramWadlParams);
    }
  }
  
  public void a(String paramString1, String paramString2, ascg paramascg, String paramString3)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "reportDC appRuntime=" + localAppRuntime + ",dcId=" + paramString3 + ",oper_id=" + paramString1 + ",operType=" + paramString2 + ",reportInfo=" + paramascg);
    }
    if (paramascg == null) {
      return;
    }
    label902:
    label911:
    label924:
    label930:
    label942:
    for (;;)
    {
      WadlParams localWadlParams;
      JSONObject localJSONObject1;
      int i;
      try
      {
        localWadlParams = paramascg.a;
        if (TextUtils.isEmpty(cRR)) {
          cRR = String.valueOf(aqgz.LU());
        }
        String str = paramascg.getChannelId();
        localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "3.4.4");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        localJSONObject3.put("apk_volume", String.valueOf(paramascg.DZ));
        int j = jqc.getNetWorkType();
        if (j < 0) {
          break label924;
        }
        i = j;
        if (j >= acbn.dQ.length) {
          break label924;
        }
        localJSONObject3.put("net_type", acbn.dQ[i]);
        localJSONObject3.put("resolution", o(null));
        localJSONObject3.put("is_red_point", "0");
        localJSONObject3.put("is_new_status", "0");
        localJSONObject3.put("gamecenter_src", "1");
        localJSONObject3.put("oper_moudle", "558");
        localJSONObject3.put("oper_id", paramString1);
        localJSONObject3.put("ret_id", String.valueOf(paramascg.errCode));
        if (localWadlParams != null)
        {
          paramString1 = localWadlParams.appId;
          localJSONObject3.put("gameappid", paramString1);
          localJSONObject3.put("ext1", "55801");
          localJSONObject3.put("ext3", "1");
          localJSONObject3.put("ext4", paramString2);
          localJSONObject3.put("ext11", "4");
          localJSONObject3.put("ext12", "430");
          localJSONObject3.put("ext14", Build.MODEL);
          localJSONObject3.put("ext15", Build.VERSION.RELEASE);
          localJSONObject3.put("ext16", cRR);
          localJSONObject3.put("ext31", paramascg.cEj);
          localJSONObject3.put("ext32", paramascg.taskId);
          localJSONObject3.put("ext36", paramascg.DJ());
          localJSONObject3.put("ext37", ascg.imei);
          if (localWadlParams != null)
          {
            localJSONObject3.put("ext2", String.valueOf(localWadlParams.from));
            if (!localWadlParams.dqZ) {
              break label887;
            }
            if (localWadlParams.resType != 1) {
              break label930;
            }
            i = 2;
            localJSONObject3.put("ext5", String.valueOf(i));
            localJSONObject3.put("ext18", localWadlParams.via);
            if (TextUtils.isEmpty(paramascg.packageName)) {
              break label902;
            }
            paramString1 = paramascg.packageName;
            localJSONObject3.put("ext33", paramString1);
            localJSONObject3.put("ext34", localWadlParams.apkUrl);
            localJSONObject3.put("ext35", localWadlParams.apkChannel);
            localJSONObject3.put("ext38", String.valueOf(localWadlParams.flags));
            localJSONObject3.put("ext39", localWadlParams.bLF);
            localJSONObject3.put("ext40", localWadlParams.extraData);
            if (!localWadlParams.nO(256)) {
              break label942;
            }
            paramString1 = "1";
            localJSONObject3.put("ext44", paramString1);
            localJSONObject3.put("ext46", String.valueOf(localWadlParams.channelNum));
          }
          if (!TextUtils.isEmpty(str)) {
            localJSONObject3.put("ext45", str);
          }
          if (!TextUtils.isEmpty(paramascg.bXT)) {
            localJSONObject3.put("ext42", paramascg.bXT);
          }
          if (!TextUtils.isEmpty(paramascg.cEl)) {
            localJSONObject3.put("ext43", paramascg.cEl);
          }
          localJSONObject2.put("data", localJSONObject3);
          localJSONObject2.put("dc_id", paramString3);
          localJSONArray.put(localJSONObject2);
          localJSONObject1.put("report_list", localJSONArray);
          if (localAppRuntime == null) {
            break label911;
          }
          e(localAppRuntime, "dc05076", localJSONObject1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString1 = "";
      continue;
      label887:
      if (localWadlParams.from == 3)
      {
        i = 3;
        continue;
        paramString1 = localWadlParams.packageName;
        continue;
        annx.o(null, "dc05076", localJSONObject1.toString());
        return;
        i = 0;
        continue;
        i = 4;
      }
      else
      {
        i = 1;
        continue;
        paramString1 = "0";
      }
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "requestWebSso webssoCmd=" + paramString + ",reqData=" + paramJSONObject);
    }
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {}
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (localAppRuntime == null);
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put(paramString, paramJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), awor.class);
      paramJSONObject = paramBundle;
      if (paramBundle == null) {
        paramJSONObject = new Bundle();
      }
      paramJSONObject.putString("webssoCmdId", paramString);
      paramJSONObject.putByteArray("webssoReq", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtras(paramJSONObject);
      localAppRuntime.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "requestWebSso exception=", paramString);
    }
  }
  
  public void abY(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getFloadWindowInfo appid=" + paramString);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("tt", 1);
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localJSONObject2.put("uin", localObject);
        localJSONObject2.put("skey", getSkey());
        localJSONObject1.put("req", localJSONObject2);
        localObject = new Bundle();
        ((Bundle)localObject).putString("appid", paramString);
        a("13126", localJSONObject1, (Bundle)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getFloadWindowInfo exception=", paramString);
    }
  }
  
  public void acU(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "requestRedPoint scene_id=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("scene_id", paramInt);
      localJSONObject2.put("uin", getUin());
      localJSONObject2.put("tt", 1);
      localJSONObject1.put("req", localJSONObject2);
      a("13325", localJSONObject1, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "requestRedPoint exception=", localException);
    }
  }
  
  public void b(awos paramawos)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "removeListener listener=" + paramawos);
    }
    if (paramawos == null) {
      return;
    }
    boolean bool;
    do
    {
      Iterator localIterator;
      do
      {
        localIterator = this.Z.iterator();
      } while (!localIterator.hasNext());
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      awos localawos = (awos)localWeakReference.get();
      if ((localawos == null) || (localawos != paramawos)) {
        break;
      }
      bool = this.Z.remove(localWeakReference);
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 1, "removeListener listener=" + paramawos + " " + bool);
  }
  
  public void b(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "reportDownloadStart...");
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if (paramJSONArray1 != null) {
        localJSONObject2.put("appid_list", paramJSONArray1);
      }
      if (paramJSONArray2 != null) {
        localJSONObject2.put("res_list", paramJSONArray2);
      }
      localJSONObject1.put("req", localJSONObject2);
      a("12952", localJSONObject1, null);
      return;
    }
    catch (Exception paramJSONArray1)
    {
      QLog.e(TAG, 1, "reportDownloadStart exception=", paramJSONArray1);
    }
  }
  
  public void c(String paramString1, String paramString2, ascg paramascg)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "reportDC05076 appRuntime=" + localAppRuntime + ",oper_id=" + paramString1 + ",operType=" + paramString2 + ",reportInfo=" + paramascg);
    }
    if (paramascg == null) {
      return;
    }
    for (;;)
    {
      WadlParams localWadlParams;
      JSONObject localJSONObject1;
      try
      {
        localWadlParams = paramascg.a;
        if (TextUtils.isEmpty(cRR)) {
          cRR = String.valueOf(aqgz.LU());
        }
        String str = paramascg.getChannelId();
        localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        localJSONObject3.put("itimestamp", String.valueOf(NetConnInfoCenter.getServerTime()));
        localJSONObject3.put("domain", "1");
        localJSONObject3.put("sq_ver", "3.4.4");
        localJSONObject3.put("gamecenter_ver", "");
        localJSONObject3.put("gamecenter_ver_type", "2");
        localJSONObject3.put("device_type", Build.BRAND);
        localJSONObject3.put("apk_volume", String.valueOf(paramascg.DZ));
        int j = jqc.getNetWorkType();
        if (j < 0) {
          break label852;
        }
        i = j;
        if (j >= acbn.dQ.length) {
          break label852;
        }
        localJSONObject3.put("net_type", acbn.dQ[i]);
        localJSONObject3.put("resolution", o(null));
        localJSONObject3.put("is_red_point", "0");
        localJSONObject3.put("is_new_status", "0");
        localJSONObject3.put("gamecenter_src", "1");
        localJSONObject3.put("oper_moudle", "558");
        localJSONObject3.put("oper_id", paramString1);
        localJSONObject3.put("ret_id", String.valueOf(paramascg.errCode));
        if (localWadlParams != null)
        {
          paramString1 = localWadlParams.appId;
          localJSONObject3.put("gameappid", paramString1);
          localJSONObject3.put("ext1", "55801");
          localJSONObject3.put("ext3", "1");
          localJSONObject3.put("ext4", paramString2);
          localJSONObject3.put("ext11", "4");
          localJSONObject3.put("ext12", "430");
          localJSONObject3.put("ext14", Build.MODEL);
          localJSONObject3.put("ext15", Build.VERSION.RELEASE);
          localJSONObject3.put("ext16", cRR);
          localJSONObject3.put("ext32", paramascg.taskId);
          localJSONObject3.put("ext36", paramascg.DJ());
          localJSONObject3.put("ext37", ascg.imei);
          if (localWadlParams != null)
          {
            localJSONObject3.put("ext2", String.valueOf(localWadlParams.from));
            localJSONObject3.put("ext18", localWadlParams.via);
            if (TextUtils.isEmpty(paramascg.packageName)) {
              break label830;
            }
            paramString1 = paramascg.packageName;
            localJSONObject3.put("ext33", paramString1);
            localJSONObject3.put("ext34", localWadlParams.apkUrl);
            localJSONObject3.put("ext35", localWadlParams.apkChannel);
            localJSONObject3.put("ext38", String.valueOf(localWadlParams.flags));
            localJSONObject3.put("ext39", localWadlParams.bLF);
            localJSONObject3.put("ext40", localWadlParams.extraData);
            if (!localWadlParams.nO(256)) {
              break label858;
            }
            paramString1 = "1";
            localJSONObject3.put("ext44", paramString1);
            localJSONObject3.put("ext46", String.valueOf(localWadlParams.channelNum));
          }
          if (!TextUtils.isEmpty(str)) {
            localJSONObject3.put("ext45", str);
          }
          if (!TextUtils.isEmpty(paramascg.bXT)) {
            localJSONObject3.put("ext42", paramascg.bXT);
          }
          if (!TextUtils.isEmpty(paramascg.cEl)) {
            localJSONObject3.put("ext43", paramascg.cEl);
          }
          localJSONObject2.put("data", localJSONObject3);
          localJSONObject2.put("dc_id", "dc05076");
          localJSONArray.put(localJSONObject2);
          localJSONObject1.put("report_list", localJSONArray);
          if (localAppRuntime == null) {
            break label839;
          }
          e(localAppRuntime, "dc05076", localJSONObject1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      paramString1 = "";
      continue;
      label830:
      paramString1 = localWadlParams.packageName;
      continue;
      label839:
      annx.o(null, "dc05076", localJSONObject1.toString());
      return;
      label852:
      int i = 0;
      continue;
      label858:
      paramString1 = "0";
    }
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("sq_ver", "3.4.4");
      localJSONObject3.put("device_type", Build.BRAND);
      localJSONObject3.put("gameappid", paramString1);
      localJSONObject3.put("ext12", paramString3);
      localJSONObject3.put("ext11", paramString2);
      localJSONObject3.put("ext1", paramString5);
      localJSONObject3.put("oper_moudle", paramString4);
      localJSONObject3.put("oper_id", paramString6);
      localJSONObject3.put("ext2", paramString7);
      localJSONObject3.put("ext3", paramString8);
      localJSONObject3.put("ext4", paramString9);
      localJSONObject3.put("ext6", paramString10);
      localJSONObject2.put("data", localJSONObject3);
      localJSONObject2.put("dc_id", "dc00087");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("report_list", localJSONArray);
      if (localAppRuntime != null)
      {
        e(localAppRuntime, "dc00087", localJSONObject1.toString());
        return;
      }
      annx.o(null, "dc00087", localJSONObject1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, paramString1, new Object[0]);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy listeners size=" + this.Z.size());
    }
    this.Z.clear();
  }
  
  public void e(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null) {
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 2, "reportDC05076 fail,appRuntime is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "reportDC05076 reportData=" + paramString2);
      }
    } while (TextUtils.isEmpty(paramString2));
    try
    {
      paramAppRuntime = new JSONObject(paramString2);
      paramString1 = new JSONObject();
      paramString1.put("req", paramAppRuntime);
      a("12934", paramString1, null);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public void eEH()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getAutoDownloadApk...");
    }
    for (;;)
    {
      boolean bool2;
      boolean bool1;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject3 = new JSONObject();
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("left", tax.bAT);
        localJSONObject4.put("status", 1);
        localJSONObject3.put("battery", localJSONObject4);
        localJSONObject4 = new JSONObject();
        bool2 = aqiw.isWifiConnected(BaseApplicationImpl.getContext());
        if (aqux.Mv() == 1)
        {
          bool1 = true;
          break label287;
          localJSONObject4.put("type", i);
          localJSONObject3.put("netinfo", localJSONObject4);
          localJSONObject4 = new JSONObject();
          localJSONObject4.put("status", aqey.isScreenOn(BaseApplicationImpl.getContext()));
          localJSONObject3.put("screen", localJSONObject4);
          localJSONObject4 = new JSONObject();
          long[] arrayOfLong = aqgz.getSDCardMemory();
          localJSONObject4.put("total", arrayOfLong[0]);
          localJSONObject4.put("left", arrayOfLong[1]);
          localJSONObject3.put("storage", localJSONObject4);
          localJSONObject2.put("context_info", localJSONObject3);
          localJSONObject2.put("qq_version", AppSetting.getVersion());
          localJSONObject1.put("req", localJSONObject2);
          a("13625", localJSONObject1, null);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, "getAutoDownloadApk exception=", localException);
        return;
      }
      label287:
      if ((bool1 | bool2)) {
        i = 1;
      }
    }
  }
  
  public void eEI()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        JSONArray localJSONArray = tbi.d("DOWNLOAD_COMPLETE_APK_PACK");
        if (QLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("getUnpackApk tgpaApkList size=");
          if (localJSONArray == null) {
            break label133;
          }
          i = localJSONArray.length();
          QLog.d(str, 2, i);
        }
        if (localJSONArray != null)
        {
          if (localJSONArray.length() < 1) {
            return;
          }
          localJSONObject2.put("tgpa_versions", localJSONArray);
          localJSONObject1.put("req", localJSONObject2);
          a("13629", localJSONObject1, null);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, "getUnpackApk exception=", localException);
      }
      return;
      label133:
      int i = 0;
    }
  }
  
  public void g(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getAutoDownloadRes...");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("3.4.4.3058");
      new WebSSOAgent.UniSsoServerReq().comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tgpa_games", paramJSONObject1);
      localJSONObject.put("pkg_to_appids", paramJSONObject2);
      ((JSONObject)localObject).put("req", localJSONObject);
      a("12942", (JSONObject)localObject, null);
      return;
    }
    catch (Exception paramJSONObject1)
    {
      QLog.e(TAG, 1, "getAutoDownloadRes exception=", paramJSONObject1);
    }
  }
  
  public String getSkey()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      return ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
    }
    awom.a().ctN();
    localObject = new Bundle();
    localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getSkey", (Bundle)localObject);
    if ((localObject != null) && (((EIPCResult)localObject).isSuccess()) && (((EIPCResult)localObject).data != null)) {
      return ((EIPCResult)localObject).data.getString("skey");
    }
    return "";
  }
  
  public long getUin()
  {
    long l2 = 0L;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    if (localObject != null) {
      l1 = ((AppRuntime)localObject).getLongAccountUin();
    }
    do
    {
      do
      {
        do
        {
          return l1;
          awom.a().ctN();
          localObject = new Bundle();
          localObject = QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.getUin", (Bundle)localObject);
          l1 = l2;
        } while (localObject == null);
        l1 = l2;
      } while (!((EIPCResult)localObject).isSuccess());
      l1 = l2;
    } while (((EIPCResult)localObject).data == null);
    return ((EIPCResult)localObject).data.getLong("uin");
  }
  
  public void hd(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setPreloadStatus appId=" + paramString + ",status=" + paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("appid", paramString);
      ((JSONObject)localObject).put("platform", 1);
      ((JSONObject)localObject).put("channel", 1);
      ((JSONObject)localObject).put("op", paramInt);
      localJSONObject.put("req", localObject);
      localJSONObject.put("subscribe_type", 1);
      localObject = new Bundle();
      ((Bundle)localObject).putString("appid", paramString);
      a("13032", localJSONObject, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "setPreloadStatus exception=", paramString);
    }
  }
  
  public void jH(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "preloadGame appId=" + paramString1 + ",channelId=" + paramString2);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString1);
      localJSONObject2.put("platform", 1);
      localJSONObject2.put("need_ark", 1);
      localJSONObject2.put("channel_id", paramString2);
      localJSONObject2.put("skey", getSkey());
      localJSONObject1.put("req", localJSONObject2);
      localJSONObject1.put("subscribe_type", 1);
      paramString2 = new Bundle();
      paramString2.putString("appid", paramString1);
      a("12820", localJSONObject1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(TAG, 1, "preloadGame exception=", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awot
 * JD-Core Version:    0.7.0.1
 */