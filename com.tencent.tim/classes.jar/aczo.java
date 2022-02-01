import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class aczo
  extends accg
{
  protected QQAppInterface app;
  public AtomicBoolean cM = new AtomicBoolean(false);
  
  public aczo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  public static void cC(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      ArrayList localArrayList = new ArrayList();
      iq(0L);
      aczo localaczo = (aczo)paramQQAppInterface.getBusinessHandler(115);
      if (localaczo == null) {
        break label49;
      }
      localaczo.dR(localArrayList);
      localaczo.bQ(localArrayList);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script forceCheckBaseScript");
      return;
      label49:
      cD(paramQQAppInterface);
    }
  }
  
  private static void cD(QQAppInterface paramQQAppInterface)
  {
    abto.a(paramQQAppInterface, abxi.bjI + "base.zip", abxi.bjG, null, new aczo.a());
  }
  
  public static long fj()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getLong("apollo_client_script_" + abxi.bjK, 0L);
  }
  
  public static long fk()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getLong("apollo_client_script_" + abxi.bjH, 0L);
  }
  
  public static void ip(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit().putLong("apollo_client_script_" + abxi.bjK, paramLong).commit();
    QLog.i("ApolloContentUpdateHandler", 1, "updateNewestApolloBaseResVersion version: " + paramLong);
  }
  
  public static void iq(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).edit().putLong("apollo_client_script_" + abxi.bjH, paramLong).commit();
    QLog.i("ApolloContentUpdateHandler", 1, "updateApolloBaseResVersion version: " + paramLong);
  }
  
  public static void r(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    int i = ApolloUtil.gh(paramInt);
    if (i == 0) {
      ((abhh)paramQQAppInterface.getManager(153)).o(true, "checkApolloPanelJsonVer : local ver==0", paramInt);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "checkApolloPanelJsonVer local ver: " + i + ",taskType:" + paramInt);
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("3.4.4.3058");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      if (1 == paramInt) {
        ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("tab_list_android_json_v665");
      }
      ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
      if (1 == paramInt) {
        localReqAppInfo.uint_appid.set(201);
      }
      localReqAppInfo.rpt_msg_reqiteminfo.add((MessageMicro)localObject2);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localReqAppInfo);
      localReqBody.rpt_msg_reqappinfo.set((List)localObject2);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "apollo_content_update.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
      QLog.i("ApolloContentUpdateHandler", 1, "checkApolloPanelJsonVer from version " + i + ",taskType:" + paramInt);
    }
  }
  
  public static String rZ()
  {
    return "client_script_config_" + abxi.bjH;
  }
  
  public static String sa()
  {
    return "client_script_config_" + abxi.bjK;
  }
  
  public void bQ(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    String str = this.app.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("3.4.4.3058");
    localReqBody.uint_uin.set(Long.parseLong(str));
    int i;
    if (paramArrayList == null)
    {
      paramArrayList = new ArrayList();
      if (abhh.aV(this.app.getApp()))
      {
        i = ((abhh)this.app.getManager(153)).cd(this.app.getCurrentUin());
        paramArrayList.add(e());
        if (1 == i)
        {
          ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = d();
          if (localReqAppInfo != null) {
            paramArrayList.add(localReqAppInfo);
          }
          localReqAppInfo = f();
          if (localReqAppInfo != null) {
            paramArrayList.add(localReqAppInfo);
          }
          dR(paramArrayList);
          localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
        }
      }
    }
    for (;;)
    {
      localReqBody.setHasFlag(true);
      paramArrayList = new ToServiceMsg("mobileqq.service", str, "apollo_content_update.Req");
      paramArrayList.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.i("ApolloContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      return;
      QLog.d("ApolloContentUpdateHandler", 1, "apollo status: " + i);
      break;
      if (ahbj.isFileExists(ApolloUtil.bkb)) {
        abhh.g(this.app);
      }
      QLog.d("ApolloContentUpdateHandler", 1, "ApolloFunc close...");
      break;
      localReqBody.rpt_msg_reqappinfo.set(paramArrayList);
    }
  }
  
  protected void cHR() {}
  
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
            QLog.d("ApolloContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          cHR();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label246;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloContentUpdateHandler", 2, "handleResponse, switch result=" + paramFromServiceMsg.uint_appid.get());
        }
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 201: 
          h(paramFromServiceMsg);
          break;
        case 205: 
          i(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      j(paramFromServiceMsg);
      continue;
      k(paramFromServiceMsg);
      continue;
      label246:
      return;
      i = 0;
      break;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo d()
  {
    int i = ApolloUtil.gh(1);
    QLog.i("ApolloContentUpdateHandler", 1, "getApolloPanelReqInfo ver: " + i);
    if (i == 0)
    {
      ((abhh)this.app.getManager(153)).o(true, "login : local ver==0", 1);
      return null;
    }
    ((abhh)this.app.getManager(153)).o(false, "login : check action", 1);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set("tab_list_android_json_v665");
    localReqItemInfo.uint_version.set(i);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(201);
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    return localReqAppInfo;
  }
  
  public void dR(ArrayList<ClubContentUpdateInfoPb.ReqAppInfo> paramArrayList)
  {
    if (!abhh.ch.get())
    {
      QLog.w("ApolloContentUpdateHandler", 1, "sendRequest but apollo config is not done");
      this.cM.set(true);
      return;
    }
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(206);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo1 = new ClubContentUpdateInfoPb.ReqItemInfo();
    String str1 = rZ();
    localReqItemInfo1.str_name.set(str1);
    localReqItemInfo1.uint_version.set((int)fk());
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo1);
    if (!TextUtils.isEmpty(abxi.bjK))
    {
      ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      String str2 = sa();
      long l = fj();
      localReqItemInfo2.str_name.set(str2);
      localReqItemInfo2.uint_version.set((int)l);
      localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo2);
      QLog.i("ApolloContentUpdateHandler", 1, "getApolloBaseScriptUpdateInfo newest str_name:" + str2 + " ,ver: " + l);
    }
    paramArrayList.add(localReqAppInfo);
    QLog.i("ApolloContentUpdateHandler", 1, "getApolloBaseScriptUpdateInfo str_name:" + str1 + " ,ver: " + localReqItemInfo1.uint_version.get());
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo e()
  {
    int i = BaseApplicationImpl.getContext().getSharedPreferences("sp_apollo_webView", 4).getInt("sp_key_apollo_webView_config_version", 0);
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set("apollo_thunder_json_v670");
    localReqItemInfo.uint_version.set(i);
    ClubContentUpdateInfoPb.ReqAppInfo localReqAppInfo = new ClubContentUpdateInfoPb.ReqAppInfo();
    localReqAppInfo.uint_appid.set(205);
    localReqAppInfo.rpt_msg_reqiteminfo.add(localReqItemInfo);
    return localReqAppInfo;
  }
  
  public ClubContentUpdateInfoPb.ReqAppInfo f()
  {
    Object localObject1 = new SparseArray(8);
    Object localObject2 = new File(abxi.bio, "/def/role/0/config.json");
    if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {}
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    for (;;)
    {
      try
      {
        long l = new JSONObject(aqhq.readFileContent((File)localObject2)).optLong("version");
        ((SparseArray)localObject1).put(0, Long.valueOf(l));
        QLog.i("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId: 0, ver: " + l / 1000L);
        localObject2 = new File(abxi.bis);
        if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory())) {
          ((File)localObject2).listFiles(new aczp(this, (SparseArray)localObject1));
        }
        localObject2 = new ArrayList();
        i = 0;
        if (i >= ((SparseArray)localObject1).size()) {
          break;
        }
        localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        int j = ((SparseArray)localObject1).keyAt(i);
        localReqItemInfo.str_name.set(j + "");
        localReqItemInfo.uint_version.set((int)(((Long)((SparseArray)localObject1).get(j)).longValue() / 1000L));
        ((ArrayList)localObject2).add(localReqItemInfo);
        i += 1;
        continue;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo roleId:0", localException);
        ((SparseArray)localObject1).put(0, Long.valueOf(0L));
        continue;
      }
      QLog.e("ApolloContentUpdateHandler", 1, "getApolloRoleReqInfo not find role 0 config");
      ((SparseArray)localObject1).put(0, Long.valueOf(0L));
    }
    int i = 0;
    while (i < 3)
    {
      if (((SparseArray)localObject1).get(i) == null)
      {
        localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
        localReqItemInfo.str_name.set(i + "");
        localReqItemInfo.uint_version.set(0);
        localException.add(localReqItemInfo);
      }
      i += 1;
    }
    if (localException.size() > 0)
    {
      localObject1 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).uint_appid.set(202);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject1).rpt_msg_reqiteminfo.addAll(localException);
      return localObject1;
    }
    return null;
  }
  
  protected void h(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    int i;
    String str;
    int j;
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = localRspItemInfo.str_name.get();
      i = localRspItemInfo.uint_version.get();
      str = localRspItemInfo.str_extend.get();
      j = localRspItemInfo.uint_update_flag.get();
      if (1 != (j & 0x1)) {
        break label161;
      }
      ((abhh)this.app.getManager(153)).o(true, "12h update...", 1);
    }
    for (;;)
    {
      QLog.i("ApolloContentUpdateHandler", 1, "apollo panel json: " + paramRspAppInfo + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str);
      return;
      try
      {
        label161:
        int k = ApolloUtil.gh(1);
        if (this.app.getApplication().getSharedPreferences("apollo_sp", 0).getInt("apollo_json_version" + this.app.getCurrentAccountUin(), 0) == k) {
          continue;
        }
        ((abhh)this.app.getManager(153)).Yb();
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ApolloContentUpdateHandler", 2, "apollo json error" + localThrowable.toString());
      }
    }
  }
  
  protected void i(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject;
    int i;
    String str;
    int j;
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.rpt_msg_rspiteminfo.get().get(0);
      paramRspAppInfo = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
      i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
      str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
      j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
      localObject = this.app;
      if (1 != (j & 0x1)) {
        break label162;
      }
    }
    label162:
    for (boolean bool = true;; bool = false)
    {
      abuy.a(null, (AppInterface)localObject, i, bool);
      QLog.i("ApolloContentUpdateHandler", 1, "handleApolloWebViewResponse apollo_client ApolloWebView Config json: " + paramRspAppInfo + ", ver: " + i + ", updateFlag: " + j + ", extStr: " + str);
      return;
    }
  }
  
  protected void j(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if ((paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      while (paramRspAppInfo.hasNext())
      {
        ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
        try
        {
          int i = Integer.parseInt(localRspItemInfo.str_name.get());
          int j = localRspItemInfo.uint_version.get();
          String str = localRspItemInfo.str_extend.get();
          int k = localRspItemInfo.uint_update_flag.get();
          if ((k & 0x1) == 1) {
            abto.a(this.app, this.app.getCurrentAccountUin(), null, i, null, -1, -1, true);
          }
          QLog.i("ApolloContentUpdateHandler", 1, "apollo role: " + i + ", ver: " + j + ", updateFlag: " + k + ", extStr: " + str);
        }
        catch (Exception localException)
        {
          QLog.e("ApolloContentUpdateHandler", 1, "handleApolloRoleResponse role id: " + localRspItemInfo.str_name.get(), localException);
        }
      }
    }
  }
  
  public void k(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject;
    String str;
    int i;
    int j;
    boolean bool;
    if ((paramRspAppInfo != null) && (paramRspAppInfo.rpt_msg_rspiteminfo.has()) && (paramRspAppInfo.rpt_msg_rspiteminfo.size() > 0))
    {
      paramRspAppInfo = paramRspAppInfo.rpt_msg_rspiteminfo.get().iterator();
      for (;;)
      {
        if (paramRspAppInfo.hasNext())
        {
          localObject = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
          str = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_name.get();
          if (!TextUtils.isEmpty(str)) {
            if (str.equals(rZ()))
            {
              i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
              ((ClubContentUpdateInfoPb.RspItemInfo)localObject).str_extend.get();
              j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
              if (j != 0) {
                break label521;
              }
              localObject = new File(abxi.bjI);
              if (!((File)localObject).exists()) {
                bool = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = abxi.bjI + "base.zip";
      Bundle localBundle;
      if ((1 == (j & 0x1)) || (bool))
      {
        localBundle = new Bundle();
        localBundle.putLong("version", i);
        abto.a(this.app, (String)localObject, abxi.bjG, localBundle, new aczo.a());
      }
      QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script str_name:" + str + ",ver: " + i + ", updateFlag: " + j + ", needUpdate: " + bool);
      break;
      if ((((File)localObject).list() == null) || (((File)localObject).list().length == 0))
      {
        bool = true;
        continue;
        if (!str.equals(sa())) {
          break;
        }
        i = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_version.get();
        j = ((ClubContentUpdateInfoPb.RspItemInfo)localObject).uint_update_flag.get();
        if (j == 0)
        {
          localObject = new File(abxi.bjL);
          if (!((File)localObject).exists()) {
            bool = true;
          }
        }
        for (;;)
        {
          localObject = abxi.bjL + "base.zip";
          if ((1 == (j & 0x1)) || (bool))
          {
            localBundle = new Bundle();
            localBundle.putLong("version", i);
            abto.a(this.app, (String)localObject, abxi.bjJ, localBundle, new aczo.b());
          }
          QLog.i("ApolloContentUpdateHandler", 1, "apollo_base_script newest str_name:" + str + ",ver: " + i + ", updateFlag: " + j + ", needUpdate: " + bool);
          break;
          if ((((File)localObject).list() == null) || (((File)localObject).list().length == 0)) {
            bool = true;
          } else {
            bool = false;
          }
        }
      }
      label521:
      bool = false;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("apollo_content_update.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApolloContentUpdateHandler", 2, "onReceive called.");
      }
      cR(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static class a
    extends aquy
  {
    /* Error */
    public void onDone(aquz paramaquz)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 20	aquy:onDone	(Laquz;)V
      //   5: iconst_3
      //   6: aload_1
      //   7: invokevirtual 26	aquz:getStatus	()I
      //   10: if_icmpne +107 -> 117
      //   13: aload_1
      //   14: getfield 30	aquz:GP	Ljava/util/List;
      //   17: invokeinterface 35 1 0
      //   22: iconst_1
      //   23: if_icmpne +94 -> 117
      //   26: aload_1
      //   27: getfield 39	aquz:ov	Ljava/util/Map;
      //   30: aload_1
      //   31: getfield 43	aquz:key	Ljava/lang/String;
      //   34: invokeinterface 49 2 0
      //   39: checkcast 51	java/io/File
      //   42: astore 4
      //   44: aload 4
      //   46: invokevirtual 55	java/io/File:exists	()Z
      //   49: ifeq +68 -> 117
      //   52: aload 4
      //   54: new 57	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   61: aload 4
      //   63: invokevirtual 62	java/io/File:getParent	()Ljava/lang/String;
      //   66: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: getstatic 69	java/io/File:separator	Ljava/lang/String;
      //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: invokestatic 78	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
      //   81: aload_1
      //   82: invokevirtual 82	aquz:getParams	()Landroid/os/Bundle;
      //   85: astore_1
      //   86: aload_1
      //   87: ifnull +20 -> 107
      //   90: aload_1
      //   91: ldc 84
      //   93: invokevirtual 90	android/os/Bundle:getLong	(Ljava/lang/String;)J
      //   96: lstore_2
      //   97: lconst_0
      //   98: lload_2
      //   99: lcmp
      //   100: ifeq +7 -> 107
      //   103: lload_2
      //   104: invokestatic 94	aczo:iq	(J)V
      //   107: iconst_1
      //   108: invokestatic 100	abhh:DB	(Z)V
      //   111: aload 4
      //   113: invokevirtual 103	java/io/File:delete	()Z
      //   116: pop
      //   117: return
      //   118: astore_1
      //   119: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   122: ifeq +31 -> 153
      //   125: ldc 110
      //   127: iconst_2
      //   128: new 57	java/lang/StringBuilder
      //   131: dup
      //   132: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   135: ldc 112
      //   137: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: aload_1
      //   141: invokevirtual 115	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   144: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   150: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   153: aload 4
      //   155: invokevirtual 103	java/io/File:delete	()Z
      //   158: pop
      //   159: return
      //   160: astore_1
      //   161: return
      //   162: astore_1
      //   163: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   166: ifeq +31 -> 197
      //   169: ldc 110
      //   171: iconst_2
      //   172: new 57	java/lang/StringBuilder
      //   175: dup
      //   176: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   179: ldc 121
      //   181: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   184: aload_1
      //   185: invokevirtual 122	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   188: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   194: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   197: aload 4
      //   199: invokevirtual 103	java/io/File:delete	()Z
      //   202: pop
      //   203: return
      //   204: astore_1
      //   205: return
      //   206: astore_1
      //   207: aload 4
      //   209: invokevirtual 103	java/io/File:delete	()Z
      //   212: pop
      //   213: aload_1
      //   214: athrow
      //   215: astore_1
      //   216: return
      //   217: astore 4
      //   219: goto -6 -> 213
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	222	0	this	a
      //   0	222	1	paramaquz	aquz
      //   96	8	2	l	long
      //   42	166	4	localFile	File
      //   217	1	4	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   52	86	118	java/lang/Exception
      //   90	97	118	java/lang/Exception
      //   103	107	118	java/lang/Exception
      //   107	111	118	java/lang/Exception
      //   153	159	160	java/lang/Exception
      //   52	86	162	java/lang/OutOfMemoryError
      //   90	97	162	java/lang/OutOfMemoryError
      //   103	107	162	java/lang/OutOfMemoryError
      //   107	111	162	java/lang/OutOfMemoryError
      //   197	203	204	java/lang/Exception
      //   52	86	206	finally
      //   90	97	206	finally
      //   103	107	206	finally
      //   107	111	206	finally
      //   119	153	206	finally
      //   163	197	206	finally
      //   111	117	215	java/lang/Exception
      //   207	213	217	java/lang/Exception
    }
  }
  
  public static class b
    extends aquy
  {
    /* Error */
    public void onDone(aquz paramaquz)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 20	aquy:onDone	(Laquz;)V
      //   5: iconst_3
      //   6: aload_1
      //   7: invokevirtual 26	aquz:getStatus	()I
      //   10: if_icmpne +103 -> 113
      //   13: aload_1
      //   14: getfield 30	aquz:GP	Ljava/util/List;
      //   17: invokeinterface 35 1 0
      //   22: iconst_1
      //   23: if_icmpne +90 -> 113
      //   26: aload_1
      //   27: getfield 39	aquz:ov	Ljava/util/Map;
      //   30: aload_1
      //   31: getfield 43	aquz:key	Ljava/lang/String;
      //   34: invokeinterface 49 2 0
      //   39: checkcast 51	java/io/File
      //   42: astore 4
      //   44: aload 4
      //   46: invokevirtual 55	java/io/File:exists	()Z
      //   49: ifeq +64 -> 113
      //   52: aload 4
      //   54: new 57	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   61: aload 4
      //   63: invokevirtual 62	java/io/File:getParent	()Ljava/lang/String;
      //   66: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: getstatic 69	java/io/File:separator	Ljava/lang/String;
      //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: invokestatic 77	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
      //   81: aload_1
      //   82: invokevirtual 81	aquz:getParams	()Landroid/os/Bundle;
      //   85: astore_1
      //   86: aload_1
      //   87: ifnull +20 -> 107
      //   90: aload_1
      //   91: ldc 83
      //   93: invokevirtual 89	android/os/Bundle:getLong	(Ljava/lang/String;)J
      //   96: lstore_2
      //   97: lconst_0
      //   98: lload_2
      //   99: lcmp
      //   100: ifeq +7 -> 107
      //   103: lload_2
      //   104: invokestatic 93	aczo:ip	(J)V
      //   107: aload 4
      //   109: invokevirtual 96	java/io/File:delete	()Z
      //   112: pop
      //   113: return
      //   114: astore_1
      //   115: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   118: ifeq +31 -> 149
      //   121: ldc 103
      //   123: iconst_2
      //   124: new 57	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   131: ldc 105
      //   133: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: aload_1
      //   137: invokevirtual 108	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   140: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   146: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   149: aload 4
      //   151: invokevirtual 96	java/io/File:delete	()Z
      //   154: pop
      //   155: return
      //   156: astore_1
      //   157: return
      //   158: astore_1
      //   159: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   162: ifeq +31 -> 193
      //   165: ldc 103
      //   167: iconst_2
      //   168: new 57	java/lang/StringBuilder
      //   171: dup
      //   172: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   175: ldc 114
      //   177: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: aload_1
      //   181: invokevirtual 115	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   184: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   190: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   193: aload 4
      //   195: invokevirtual 96	java/io/File:delete	()Z
      //   198: pop
      //   199: return
      //   200: astore_1
      //   201: return
      //   202: astore_1
      //   203: aload 4
      //   205: invokevirtual 96	java/io/File:delete	()Z
      //   208: pop
      //   209: aload_1
      //   210: athrow
      //   211: astore_1
      //   212: return
      //   213: astore 4
      //   215: goto -6 -> 209
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	218	0	this	b
      //   0	218	1	paramaquz	aquz
      //   96	8	2	l	long
      //   42	162	4	localFile	File
      //   213	1	4	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   52	86	114	java/lang/Exception
      //   90	97	114	java/lang/Exception
      //   103	107	114	java/lang/Exception
      //   149	155	156	java/lang/Exception
      //   52	86	158	java/lang/OutOfMemoryError
      //   90	97	158	java/lang/OutOfMemoryError
      //   103	107	158	java/lang/OutOfMemoryError
      //   193	199	200	java/lang/Exception
      //   52	86	202	finally
      //   90	97	202	finally
      //   103	107	202	finally
      //   115	149	202	finally
      //   159	193	202	finally
      //   107	113	211	java/lang/Exception
      //   203	209	213	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczo
 * JD-Core Version:    0.7.0.1
 */