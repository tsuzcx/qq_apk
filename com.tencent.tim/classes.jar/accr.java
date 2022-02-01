import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ClubContentUpdateHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class accr
  extends accg
{
  public QQAppInterface app;
  private aqva c;
  aquy n = new accs(this);
  
  public accr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  private void D(int paramInt1, int paramInt2, String paramString)
  {
    ((ajdg)this.app.getManager(14)).b(paramString, paramInt1, "", paramInt2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    aqpi.aP(this.app.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString, paramInt1);
  }
  
  private void a(int paramInt, aqpi.c paramc)
  {
    if (Math.abs(paramInt - aqpi.bI(this.app.getApplication().getApplicationContext(), paramc.cuQ)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.c == null) {
        this.c = ((aqva)this.app.getManager(47));
      }
      File localFile = new File(this.app.getApplication().getApplicationContext().getFilesDir(), paramc.cuN);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", paramc.cuQ);
      paramc = new aquz(paramc.cuO, localFile);
      this.c.a(1).a(paramc, this.n, localBundle);
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(aqpi.d.businessName))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, aqpi.d, paramBoolean);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString1.equals(aqpi.a.businessName)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
          }
          paramInt2 = aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.a.cuQ);
        } while (paramInt1 <= paramInt2);
        this.app.getApplication();
        aqpi.aP(MobileQQ.getContext(), aqpi.a.cuQ, paramInt2);
        paramString1 = this.app.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
        ((acdz)this.app.getBusinessHandler(12)).cIq();
        paramString1.edit().putLong("last_get_recommendemotion_time_" + this.app.getCurrentUin(), System.currentTimeMillis()).commit();
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!afnu.jx(paramInt2));
      ((ajdg)this.app.getManager(14)).c(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((ajdg)this.app.getManager(14)).b(paramString1, paramInt1, paramString2, paramInt2, 0);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
  }
  
  private boolean a(int paramInt, aqpi.c paramc, boolean paramBoolean)
  {
    int i = aqpi.bI(this.app.getApplication().getApplicationContext(), paramc.cuQ);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + paramc.businessName + " localVersion = " + i + " version = " + paramInt);
    }
    if (paramInt > i)
    {
      aqpi.a(this.app, paramc, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void aK(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("group_domain")) && (paramJSONObject.has("group_strategy"))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        String str = paramJSONObject.getString("group_domain");
        paramJSONObject = paramJSONObject.getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("ClubContentUpdateHandler", 2, "cdnCacheConfig, domain: " + str + ", strategys: " + paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        do
        {
          paramJSONObject.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.w("ClubContentUpdateHandler", 2, "", paramJSONObject);
        return;
      }
    }
    QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
  }
  
  private void cHR() {}
  
  public static void cm(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("3.4.4.3058");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      ArrayList localArrayList1 = new ArrayList();
      int i = paramQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("signature_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      localArrayList2.add(localObject2);
      localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(8);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
      localArrayList1.add(localObject2);
      localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
  }
  
  private void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals(aqpi.b.businessName)) {}
    }
  }
  
  private void x(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update panel id: " + paramString + ", version: " + paramInt2);
          abhh localabhh1 = (abhh)this.app.getManager(153);
          if ((abhh.aV(this.app.getApp())) && (localabhh1 != null) && (1 == localabhh1.cd(this.app.getCurrentUin())))
          {
            if (TextUtils.equals("tab_list_android_json_v665", paramString)) {
              dr(paramString, paramInt2);
            }
          }
          else
          {
            QLog.i("ClubContentUpdateHandler", 1, "panel update cancel, apollo not available.");
            return;
            QLog.i("ClubContentUpdateHandler", 1, "saveQVIPResConfigContent apollo_client realtime update apolloWebView config name: " + paramString + ", version: " + paramInt2);
            abuy.a(null, this.app, paramInt2, false);
            return;
            try
            {
              QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update role id: " + paramString + ", ver: " + paramInt2);
              localabhh1 = (abhh)this.app.getManager(153);
              if ((abhh.aV(this.app.getApp())) && (localabhh1 != null) && (1 == localabhh1.cd(this.app.getCurrentUin())))
              {
                paramInt1 = Integer.parseInt(paramString);
                l = localabhh1.f(1, paramInt1) / 1000L;
                if (l == paramInt2) {
                  continue;
                }
                abto.a(this.app, this.app.getCurrentAccountUin(), null, paramInt1, null, -1, -1, true);
                QLog.i("ClubContentUpdateHandler", 1, "download apollo role id: " + paramString + ", loc ver: " + l);
                return;
              }
            }
            catch (Exception localException1)
            {
              QLog.e("ClubContentUpdateHandler", 2, "apollo: update role res realTime failed name:" + paramString, localException1);
              return;
            }
            QLog.i("ClubContentUpdateHandler", 1, "apollo role res ");
            return;
            try
            {
              QLog.i("ClubContentUpdateHandler", 1, "apollo realtime update dress id: " + paramString + ", ver: " + paramInt2);
              abhh localabhh2 = (abhh)this.app.getManager(153);
              if ((abhh.aV(this.app.getApp())) && (localabhh2 != null) && (1 == localabhh2.cd(this.app.getCurrentUin())))
              {
                paramInt1 = Integer.parseInt(paramString);
                l = localabhh2.f(2, paramInt1) / 1000L;
                if (l != paramInt2)
                {
                  abto.b(this.app, this.app.getCurrentUin(), null, -1, new int[] { paramInt1 }, -1, -1, true);
                  QLog.i("ClubContentUpdateHandler", 1, "download apollo dress id: " + paramInt1 + ", loc ver: " + l);
                  return;
                }
              }
            }
            catch (Exception localException2)
            {
              QLog.e("ClubContentUpdateHandler", 2, "apollo dress real time update id:" + paramString, localException2);
              return;
            }
          }
        }
      } while (!aczo.rZ().equals(paramString));
      paramString = (abhh)this.app.getManager(153);
      if ((!abhh.aV(this.app.getApp())) || (paramString == null) || (1 != paramString.cd(this.app.getCurrentUin()))) {
        break;
      }
    } while ((aczo)this.app.getBusinessHandler(115) == null);
    long l = aczo.fk();
    if (l != paramInt2)
    {
      paramString = abxi.bjI + "base.zip";
      Bundle localBundle = new Bundle();
      localBundle.putLong("version", paramInt2);
      abto.a(this.app, paramString, abxi.bjG, localBundle, new aczo.a());
    }
    QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push version: " + paramInt2 + ", old version: " + l);
    return;
    QLog.i("ClubContentUpdateHandler", 1, "apollo_base_script login push");
  }
  
  public void M(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "func saveQVIPResConfigContent invoked!");
    }
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putString("qvip_res_push_cfg_txt.", paramString).commit();
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramString).getJSONArray("data");
        j = paramQQAppInterface.length();
        if (i >= j) {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ClubContentUpdateHandler", 2, "name= saveQVIPResConfigContent ", paramQQAppInterface);
        return;
      }
      try
      {
        paramString = paramQQAppInterface.getJSONObject(i);
        j = paramString.getInt("version");
        k = paramString.getInt("id");
        paramString = paramString.getString("filename");
        if (paramString == null) {
          return;
        }
        w(k, paramString, j);
        x(k, paramString, j);
        if (aqpi.e.businessName.equals(paramString)) {
          a(j, aqpi.e);
        }
      }
      catch (Exception paramString)
      {
        continue;
      }
      i += 1;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((ajdg)this.app.getManager(14)).af(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag);
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!afnu.jy(localEmoticonPackage.updateFlag)))
        {
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(aqpi.c paramc, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramc.businessName);
    localReqItemInfo.uint_version.set(aqpi.bI(this.app.getApplication().getApplicationContext(), paramc.cuQ));
    localArrayList.add(localReqItemInfo);
    paramc = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramc.uint_appid.set(paramInt);
    paramc.rpt_msg_reqiteminfo.set(localArrayList);
    paramc.setHasFlag(true);
    return paramc;
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals(aqpi.h.businessName)) {
        a(i, aqpi.h, false);
      }
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((ajdg)this.app.getManager(14)).af(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "BigEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!afnu.jy(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label377;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label377:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(aqpi.d.businessName);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.d.cuQ));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(aqpi.c paramc, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(paramc.businessName);
    localReqItemInfo.uint_version.set(aqpi.bI(this.app.getApplication().getApplicationContext(), paramc.cuQ));
    localArrayList.add(localReqItemInfo);
    paramc = new ClubContentUpdateInfoPb.ReqAppInfo();
    paramc.uint_appid.set(paramInt);
    paramc.rpt_msg_reqiteminfo.set(localArrayList);
    paramc.setHasFlag(true);
    return paramc;
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = new StringBuilder(((ArrayList)localObject).size() * 64);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        paramRspAppInfo.append("name=").append(str1).append(", version=").append(i).append(", updateFlag=").append(j).append(", extStr=").append(str2);
      }
      if ((str1.equals(aqpi.e.businessName)) && (i > aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.e.cuQ))) {
        a(i, aqpi.e);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((ajdg)this.app.getManager(14)).af(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!afnu.jy(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label319;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label319:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
        }
        if (str1.equals(aqpi.c.businessName))
        {
          if (i > aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.c.cuQ)) {
            aqpi.a(this.app, aqpi.c, i, false);
          }
        }
        else if (str1.equals(aqpi.f.businessName))
        {
          if (i > aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.f.cuQ)) {
            aqpi.a(this.app, aqpi.f, i, false);
          }
        }
        else if (str1.equals(aqpi.i.businessName))
        {
          j = aqpi.bI(this.app.getApplication().getApplicationContext(), aqpi.i.cuQ);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i + " localVersion = " + j);
          }
          if (i > j) {
            aqpi.a(this.app, aqpi.i, i, false);
          }
        }
      }
    }
  }
  
  protected void cR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          cHR();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label326;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 2: 
        case 3: 
        case 9: 
        case 18: 
        case 1: 
          e(paramFromServiceMsg);
          break;
        case 10: 
          d(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      c(paramFromServiceMsg);
      continue;
      b(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      f(paramFromServiceMsg);
      continue;
      a(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      label326:
      return;
      i = 0;
      break;
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      int j = localRspItemInfo.uint_update_flag.get();
      int k = aqpi.bI(this.app.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + j + ",version" + i + ",localVersion:" + k);
      }
      if (k < i) {
        D(i, j, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
    }
  }
  
  public void dG(Context paramContext)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("data");
        if (i >= ((JSONArray)localObject).length()) {
          continue;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        String str = localJSONObject.getString("filename");
        if (!aqpi.e.cuN.equals(str)) {
          break label168;
        }
        localObject = localJSONObject.getString("version");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + paramContext.toString());
        return;
        i = -1;
        if (i != -1) {
          continue;
        }
      }
      if (aqpi.bI(paramContext, aqpi.e.cuQ) != i)
      {
        a(i, aqpi.e);
        return;
      }
      label167:
      return;
      label168:
      i += 1;
    }
  }
  
  public void dr(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ClubContentUpdateHandler.1(this, paramInt, paramString));
  }
  
  protected void e(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int j = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      a(str1, i, paramRspAppInfo, j, localHashMap, false);
    }
  }
  
  protected void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals("individuation_mainpage_config2")) {}
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      cR(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void sendRequest()
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.app.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("3.4.4.3058");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b());
    localArrayList.add(a());
    localArrayList.add(c());
    localArrayList.add(b(aqpi.c, 7));
    localArrayList.add(a(aqpi.e, 105));
    localArrayList.add(b(aqpi.f, 11));
    localArrayList.add(b(aqpi.h, 113));
    localArrayList.add(b(aqpi.i, 5));
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  public void w(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramInt1 = aqpi.bI(this.app.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString);
                if (QLog.isColorLevel()) {
                  QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + paramString + ",version" + paramInt2 + ",localVersion:" + paramInt1);
                }
              } while (paramInt1 >= paramInt2);
              D(paramInt2, 1, paramString);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "func handleSmallEmosmResponse, bigEmoji and magicEmoji");
              }
              a(paramString, paramInt2, "", 1, new HashMap(), true);
              return;
            } while (!aqpi.c.businessName.equals(paramString));
            a(paramInt2, aqpi.c, true);
            return;
          } while ((!aqpi.b.businessName.equals(paramString)) || (!QLog.isColorLevel()));
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, update json for individuation url config");
          return;
        } while (!aqpi.h.businessName.equals(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent UrlInterceptJson");
        }
        a(paramInt2, aqpi.h, true);
        return;
      } while (!aqpi.i.businessName.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent FontInfoList");
      }
      a(paramInt2, aqpi.i, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, individuation mainpage, name=" + paramString);
      }
    } while (!paramString.equals("individuation_mainpage_config2"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accr
 * JD-Core Version:    0.7.0.1
 */