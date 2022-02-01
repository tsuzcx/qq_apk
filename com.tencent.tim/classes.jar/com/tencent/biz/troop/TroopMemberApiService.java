package com.tencent.biz.troop;

import SecurityAccountServer.RespondQueryQQBindingStat;
import accc;
import accd;
import accv;
import acde;
import acfd;
import acff;
import acfp;
import acfv;
import acgf;
import acgk;
import acgk.a;
import acgr;
import acgs;
import acjz;
import ackq;
import acms;
import acnd;
import acob;
import aevs;
import ahav;
import ahbj;
import aicu;
import aidf;
import aidn;
import aifl;
import aigu;
import ajdo;
import ajpc;
import ajpn;
import ajrm;
import ajrs;
import ajrw;
import altq;
import anaz;
import anbi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import ankq;
import anot;
import anre;
import anwh;
import anxg;
import aooi;
import aook;
import aoqu;
import aotc.c;
import apcy;
import apdr;
import apmb;
import apqz;
import apre;
import aprp;
import aprs;
import apsf;
import apsv;
import apts;
import aqiw;
import aquz;
import aqva;
import aqvc;
import aqym;
import awit;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jnl;
import jnp;
import jnv;
import jof;
import joj;
import jom;
import jrv;
import jrw;
import jxc;
import jxl;
import jxo;
import jzf;
import kgw;
import kkz;
import knd;
import knq;
import lbz;
import lcc;
import lce;
import ljq;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.observer.BusinessObserver;
import mzg;
import obh;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONException;
import org.json.JSONObject;
import pma;
import shk;
import skp;
import skq;
import skr;
import sks;
import skt;
import sku;
import skv;
import skw;
import skx;
import sky;
import skz;
import sla;
import slb;
import slc;
import sld;
import sle;
import slf;
import slh;
import tencent.im.group.nearbybanner.nearbybanner.ClientInfo;
import tencent.im.group.nearbybanner.nearbybanner.ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import top;
import tzj;
import wja;
import zjq;

public class TroopMemberApiService
  extends AppService
{
  accd jdField_a_of_type_Accd = new skt(this);
  accv jdField_a_of_type_Accv;
  acgf jdField_a_of_type_Acgf = new skp(this);
  public acgk a;
  public acgs a;
  acjz jdField_a_of_type_Acjz;
  acob jdField_a_of_type_Acob = new skr(this);
  jom jdField_a_of_type_Jom;
  ljq jdField_a_of_type_Ljq = null;
  tzj jdField_a_of_type_Tzj = null;
  public String aEu;
  public String aEv;
  String aEw;
  public boolean aLT = false;
  public boolean aLU = false;
  acnd jdField_b_of_type_Acnd = new sks(this);
  public ajrw b;
  joj jdField_b_of_type_Joj;
  obh jdField_b_of_type_Obh;
  public int bxA;
  public int bxB;
  public int bxC;
  public int bxD;
  public int bxx;
  public int bxy = -1;
  public int bxz;
  ConcurrentHashMap<String, Messenger> cw = new ConcurrentHashMap();
  aook e = new sky(this);
  public acfd f = new skv(this);
  public lce g = new skx(this);
  Messenger mClient = null;
  final Messenger mMessenger = new Messenger(new a());
  ArrayList<Integer> od = new ArrayList();
  public String yc;
  
  public TroopMemberApiService()
  {
    this.jdField_a_of_type_Acgk = null;
    this.jdField_a_of_type_Acgs = new sku(this);
    this.jdField_b_of_type_Ajrw = new skw(this);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, HWTroopFileStatusInfo paramHWTroopFileStatusInfo, Bundle paramBundle)
  {
    if (paramHWTroopFileStatusInfo == null) {
      return;
    }
    FileInfo localFileInfo = new FileInfo();
    if (!ahbj.isFileExists(paramHWTroopFileStatusInfo.LocalFile)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong).aBu();
    }
    String str = "";
    if (!TextUtils.isEmpty(paramHWTroopFileStatusInfo.FileName)) {
      str = paramHWTroopFileStatusInfo.FileName;
    }
    apsf.a(paramQQAppInterface, paramLong).d(paramHWTroopFileStatusInfo.Id);
    localFileInfo.setName(str);
    localFileInfo.setPath(paramHWTroopFileStatusInfo.LocalFile);
    localFileInfo.setSize(paramHWTroopFileStatusInfo.ProgressTotal);
    paramQQAppInterface = new apcy();
    paramQQAppInterface.FileName = str;
    paramQQAppInterface.LocalFile = paramHWTroopFileStatusInfo.LocalFile;
    paramQQAppInterface.ProgressTotal = paramHWTroopFileStatusInfo.ProgressTotal;
    paramQQAppInterface.Id = paramHWTroopFileStatusInfo.Id;
    paramQQAppInterface.TroopUin = paramLong;
    paramQQAppInterface.BusId = paramHWTroopFileStatusInfo.BusId;
    paramQQAppInterface.FilePath = paramHWTroopFileStatusInfo.FilePath;
    paramQQAppInterface.sha1 = paramHWTroopFileStatusInfo.sha1;
    paramQQAppInterface.ThumbnailFile_Small = paramHWTroopFileStatusInfo.ThumbnailFile_Small;
    paramQQAppInterface.ThumbnailFile_Large = paramHWTroopFileStatusInfo.ThumbnailFile_Large;
    paramQQAppInterface.Status = paramHWTroopFileStatusInfo.Status;
    paramBundle.putLong("sessionId", ahav.a(paramQQAppInterface).nSessionId);
    paramBundle.putInt("cloudType", 4);
    paramBundle.putInt("type", 10006);
    paramBundle.putString("filePath", localFileInfo.getPath());
    paramBundle.putString("fileName", localFileInfo.getName());
    paramBundle.putLong("fileSize", localFileInfo.getSize());
    paramBundle.putLong("troopCode", paramLong);
    j(20, paramBundle);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    nearbybanner.ReqBody localReqBody = new nearbybanner.ReqBody();
    try
    {
      Object localObject = paramAppRuntime.getApplication().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = new nearbybanner.ClientInfo();
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_height.set(j);
      ((nearbybanner.ClientInfo)localObject).uint32_lcd_width.set(i);
      ((nearbybanner.ClientInfo)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("3.4.4.3058"));
      ((nearbybanner.ClientInfo)localObject).uint32_os.set(0);
      localReqBody.msg_client_info.set((MessageMicro)localObject);
      localObject = new NewIntent(paramAppRuntime.getApplication(), jnl.class);
      ((NewIntent)localObject).putExtra("cmd", "nearby_group_banner.get_banner_info");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      paramAppRuntime.startServlet((NewIntent)localObject);
      return true;
    }
    catch (Exception paramAppRuntime) {}
    return false;
  }
  
  private boolean i(long paramLong, boolean paramBoolean)
  {
    aevs localaevs = zjq.a().a(paramLong);
    if ((localaevs == null) || (localaevs.a == null)) {
      return false;
    }
    boolean bool;
    if (localaevs.bo == 0)
    {
      bool = true;
      label35:
      if (paramBoolean == bool) {
        break label143;
      }
      if (!paramBoolean) {
        break label145;
      }
    }
    label143:
    label145:
    for (byte b1 = 0;; b1 = 1)
    {
      localaevs.bo = b1;
      if (!(this.app instanceof QQAppInterface)) {
        break;
      }
      zjq.a().a((QQAppInterface)this.app, localaevs.a.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      paramLong = NetConnInfoCenter.getServerTimeMillis();
      ackq localackq = (ackq)((QQAppInterface)this.app).getBusinessHandler(31);
      if (localackq != null) {
        localackq.f(String.valueOf(localaevs.a.uiResId), paramBoolean, paramLong);
      }
      return true;
      bool = false;
      break label35;
      break;
    }
  }
  
  public joj a()
  {
    if (this.jdField_b_of_type_Joj == null) {
      this.jdField_b_of_type_Joj = new joj(this);
    }
    return this.jdField_b_of_type_Joj;
  }
  
  public jom a()
  {
    if (this.jdField_a_of_type_Jom == null) {
      this.jdField_a_of_type_Jom = new jom(this);
    }
    return this.jdField_a_of_type_Jom;
  }
  
  public void bb(Bundle paramBundle)
  {
    int j = 0;
    Object localObject1;
    if ((this.app instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (jnv)((QQAppInterface)localObject1).getManager(70);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = ((jnv)localObject2).a(7);
        i = j;
        if (localObject2 != null)
        {
          jnp.a((QQAppInterface)localObject1, (oidb_0x791.RedDotInfo)localObject2);
          localObject1 = (jnp)((QQAppInterface)this.app).getBusinessHandler(43);
          i = j;
          if (localObject1 != null) {
            ((jnp)localObject1).notifyUI(105, true, null);
          }
        }
      }
    }
    for (int i = j;; i = 1)
    {
      localObject1 = new Bundle();
      if (paramBundle != null)
      {
        ((Bundle)localObject1).putInt("seq", paramBundle.getInt("seq", -1));
        if (!TextUtils.isEmpty(paramBundle.getString("callback"))) {
          ((Bundle)localObject1).putString("callback", paramBundle.getString("callback"));
        }
      }
      ((Bundle)localObject1).putString("data", "{code:\"" + i + "\"}");
      ((Bundle)localObject1).putString("method", "cleanDynamicRedPoint");
      j(15, (Bundle)localObject1);
      return;
      anot.a(null, "P_CliOper", "BizTechReport", "", "tribe", "clearreddot", 0, 1, "", "", "", "");
    }
  }
  
  public void cM(String paramString1, String paramString2)
  {
    WtloginHelper localWtloginHelper = new WtloginHelper(this.app.getApplication().getApplicationContext(), WtloginPrivacyListenerImpl.getSingleton());
    localWtloginHelper.SetListener(new skq(this, localWtloginHelper));
    String str = this.app.getAccount();
    paramString1 = paramString1.getBytes();
    long l = Long.valueOf(paramString2).longValue();
    paramString2 = "5.2".getBytes();
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WFastLoginInfo localWFastLoginInfo = new WFastLoginInfo();
    if (localWtloginHelper.GetA1WithA1(str, 16L, 16L, paramString1, 1L, l, 1L, paramString2, new byte[] { -51, 50, 114, -105, -54, -19, 112, -124, -125, -52, -72, -101, -27, 33, 65, -128 }, localWUserSigInfo, localWFastLoginInfo) != -1001) {
      j(61, null);
    }
  }
  
  public void j(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain(null, paramInt);
    Messenger localMessenger2 = this.mClient;
    String str = paramBundle.getString("processName");
    Messenger localMessenger1 = localMessenger2;
    if (str != null)
    {
      localMessenger1 = localMessenger2;
      if (this.cw != null)
      {
        localMessenger1 = localMessenger2;
        if (this.cw.get(str) != null) {
          localMessenger1 = (Messenger)this.cw.get(str);
        }
      }
    }
    localMessage.setData(paramBundle);
    if (localMessenger1 != null) {}
    try
    {
      localMessenger1.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("com.tencent.biz.troop.TroopMemberApiService", 2, "messeage not sent:" + paramBundle.getMessage());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onBind");
    }
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onCreate");
    }
    super.onCreate();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Accd, true);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Acgs);
      ((QQAppInterface)this.app).addObserver(this.f);
      ((QQAppInterface)this.app).addObserver(this.jdField_b_of_type_Acnd);
      ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Acgf);
      ((QQAppInterface)this.app).addObserver(this.jdField_b_of_type_Ajrw);
      this.app.registObserver(this.jdField_a_of_type_Acob);
    }
    lcc.a().b(this.g);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "MessengerService onDestroy");
    }
    super.onDestroy();
    if ((this.app instanceof QQAppInterface))
    {
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Accd);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Acgs);
      ((QQAppInterface)this.app).removeObserver(this.f);
      ((QQAppInterface)this.app).removeObserver(this.jdField_b_of_type_Acnd);
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Acgf);
      ((QQAppInterface)this.app).removeObserver(this.jdField_b_of_type_Ajrw);
      ((QQAppInterface)this.app).a().b(this.e);
      this.app.unRegistObserver(this.jdField_a_of_type_Acob);
    }
    lcc.a().c(this.g);
    if ((TextUtils.isEmpty(this.aEw)) || (this.jdField_a_of_type_Ljq != null)) {
      this.jdField_a_of_type_Ljq.onDestroy();
    }
    this.app = null;
    this.mClient = null;
    if (this.cw != null)
    {
      this.cw.clear();
      this.cw = null;
    }
    if (this.jdField_a_of_type_Accv != null) {
      this.jdField_a_of_type_Accv.aW(this);
    }
  }
  
  public void q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport param null");
    return;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      paramString2 = URLEncoder.encode(paramString2);
      paramString1 = "groupuin=" + paramString1 + "&eviluin=0&anonyid=" + paramString2 + "&impeachuin=" + paramString3 + "&msglist=" + paramString4;
      paramString1 = paramString1 + "&uin_source=unfriend";
      paramString1 = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + paramString1;
      if (paramString1 == null) {
        paramString1 = null;
      }
      for (;;)
      {
        paramString2 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString2.putExtra("BSafeReportPost", true);
        paramString2.putExtra("SafeReportData", paramString1);
        paramString2.putExtra("hide_more_button", true);
        paramString2.putExtra("ishiderefresh", true);
        paramString2.putExtra("ishidebackforward", true);
        paramString2.putExtra("url", "https://jubao.qq.com/cn/jubao");
        paramString2.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString2);
        return;
        try
        {
          paramString1 = paramString1.getBytes("utf-8");
        }
        catch (Exception paramString1) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "safetyReport exception" + paramString1.getMessage());
      return;
      paramString1 = "0";
    }
  }
  
  public class a
    extends Handler
  {
    a() {}
    
    private void bc(Bundle paramBundle)
    {
      Object localObject1 = (QQAppInterface)TroopMemberApiService.d(TroopMemberApiService.this);
      Object localObject3 = ((ajdo)TroopMemberApiService.e(TroopMemberApiService.this).getManager(11)).a();
      String str1 = "";
      Object localObject2 = "";
      if (localObject3 != null) {
        str1 = ((RespondQueryQQBindingStat)localObject3).mobileNo;
      }
      String str2 = ((QQAppInterface)localObject1).getCurrentNickname();
      localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getString("cur_city", null);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((String)localObject3).split("-");
        localObject1 = localObject2;
        if (localObject3.length > 0)
        {
          localObject2 = localObject3[0];
          localObject1 = localObject2;
          if (localObject3.length < 2) {}
        }
      }
      for (localObject1 = localObject3[1];; localObject1 = localObject3)
      {
        paramBundle.putString("phone", str1);
        paramBundle.putString("name", str2);
        paramBundle.putString("city", (String)localObject2);
        paramBundle.putString("area", (String)localObject1);
        return;
        localObject3 = "";
        localObject2 = localObject1;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject8 = TroopMemberApiService.c(TroopMemberApiService.this);
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject1 = null;
      if ((localObject8 instanceof QQAppInterface))
      {
        localObject5 = (accc)((QQAppInterface)localObject8).getBusinessHandler(22);
        localObject6 = (acgr)((QQAppInterface)localObject8).getBusinessHandler(3);
        localObject1 = (acms)((QQAppInterface)localObject8).getBusinessHandler(20);
      }
      if ((paramMessage == null) || (localObject8 == null) || (!(localObject8 instanceof QQAppInterface))) {}
      Object localObject7;
      do
      {
        return;
        localObject7 = paramMessage.getData();
      } while (localObject7 == null);
      label720:
      int i;
      int j;
      long l1;
      boolean bool;
      long l2;
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 5: 
      case 10: 
      case 14: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 33: 
      case 40: 
      case 43: 
      case 48: 
      case 49: 
      case 50: 
      case 57: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 68: 
      case 83: 
      case 89: 
      case 90: 
      case 91: 
      case 112: 
      case 123: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      default: 
      case 1: 
      case 2: 
      case 6: 
      case 7: 
      case 8: 
      case 147: 
      case 34: 
      case 41: 
      case 75: 
      case 73: 
      case 70: 
      case 38: 
      case 35: 
      case 36: 
      case 120: 
        for (;;)
        {
          super.handleMessage(paramMessage);
          return;
          TroopMemberApiService.this.mClient = paramMessage.replyTo;
          if (paramMessage.obj != null)
          {
            localObject1 = ((Bundle)paramMessage.obj).getString("processName");
            if (localObject1 != null)
            {
              TroopMemberApiService.this.cw.put(localObject1, paramMessage.replyTo);
              continue;
              TroopMemberApiService.this.mClient = null;
              if (paramMessage.obj != null)
              {
                localObject1 = ((Bundle)paramMessage.obj).getString("processName");
                if (localObject1 != null)
                {
                  TroopMemberApiService.this.cw.remove(localObject1);
                  continue;
                  TroopMemberApiService.this.jdField_a_of_type_Acjz = new acjz(((AppRuntime)localObject8).getAccount());
                  continue;
                  localObject1 = ((Bundle)localObject7).getString("gcode");
                  localObject5 = ((Bundle)localObject7).getString("anId");
                  localObject6 = jof.a().I((String)localObject1, (String)localObject5);
                  if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                  {
                    TroopMemberApiService.this.q((String)localObject1, (String)localObject5, ((AppRuntime)localObject8).getAccount(), (String)localObject6);
                    if (QLog.isDevelopLevel())
                    {
                      QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                      continue;
                      TroopMemberApiService.this.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                      continue;
                      TroopMemberApiService.this.a().a((AppRuntime)localObject8, (Bundle)localObject7);
                      continue;
                      localObject5 = ((Bundle)localObject7).getString("troopUin");
                      if (localObject1 != null)
                      {
                        ((acms)localObject1).tj((String)localObject5);
                        continue;
                        localObject5 = ((Bundle)localObject7).getString("troopUin");
                        localObject6 = ((Bundle)localObject7).getString("troopCode");
                        if (localObject1 != null) {
                          ((acms)localObject1).b(true, (String)localObject5, (String)localObject6, 0);
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject6);
                          continue;
                          localObject1 = ((Bundle)localObject7).getString("path");
                          TroopMemberApiService.this.aEu = ((Bundle)localObject7).getString("photoPath");
                          TroopMemberApiService.this.bxz = ((Bundle)localObject7).getInt("seq", -1);
                          ajrm.a((QQAppInterface)localObject8, (String)localObject1, TroopMemberApiService.this.e);
                          continue;
                          localObject5 = ((Bundle)localObject7).getByteArray("xmlData");
                          localObject1 = ((Bundle)localObject7).getString("friendUin");
                          i = ((Bundle)localObject7).getInt("directionFlag");
                          j = ((Bundle)localObject7).getInt("from");
                          if ((localObject8 instanceof QQAppInterface))
                          {
                            localObject6 = (QQAppInterface)localObject8;
                            if (!ajpc.e((AppInterface)localObject6, (String)localObject1))
                            {
                              l1 = anaz.gQ();
                              localObject7 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                              localObject5 = anre.a((byte[])localObject5, -1);
                              if (localObject5 != null)
                              {
                                ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                                localObject8 = (MessageForStructing)anbi.d(-2011);
                                ((MessageForStructing)localObject8).init((String)localObject7, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                                ((MessageForStructing)localObject8).structingMsg = ((AbsStructMsg)localObject5);
                                ((MessageForStructing)localObject8).msgData = ((MessageForStructing)localObject8).structingMsg.getBytes();
                                ((MessageForStructing)localObject8).isread = true;
                                ajpc.h((AppInterface)localObject6, (String)localObject1);
                                ajpc.a((MessageRecord)localObject8, "isFaceScoreBubbleMsg", true);
                                ajpc.a((MessageRecord)localObject8, "isFaceScoreSecondMember", true);
                                ajpc.bl.add(localObject1);
                                if (i == 1) {}
                                for (bool = true;; bool = false)
                                {
                                  top.a((MessageRecord)localObject8, bool);
                                  ((QQAppInterface)localObject6).b().b((MessageRecord)localObject8, ((MessageForStructing)localObject8).selfuin);
                                  if (!QLog.isColorLevel()) {
                                    break;
                                  }
                                  QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject8);
                                  break;
                                }
                                localObject1 = ((Bundle)localObject7).getString("troopUin");
                                localObject5 = ((Bundle)localObject7).getString("memUin");
                                i = ((Bundle)localObject7).getInt("serviceType");
                                localObject6 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                                if (localObject6 != null)
                                {
                                  localObject7 = new ArrayList();
                                  ((List)localObject7).add(Long.valueOf(Long.parseLong((String)localObject5)));
                                  ((acfv)localObject6).a((QQAppInterface)localObject8, (String)localObject1, (List)localObject7, i);
                                  continue;
                                  l1 = ((Bundle)localObject7).getLong("dwGroupCode");
                                  l2 = ((Bundle)localObject7).getLong("cGroupOption");
                                  long l3 = ((Bundle)localObject7).getLong("dwGroupClass");
                                  localObject5 = ((Bundle)localObject7).getString("strGroupName");
                                  i = ((Bundle)localObject7).getInt("wGroupFace");
                                  localObject6 = ((Bundle)localObject7).getString("strGroupMemo");
                                  localObject8 = ((Bundle)localObject7).getString("strFingerMemo");
                                  j = ((Bundle)localObject7).getInt("nFlag");
                                  if (localObject1 != null)
                                  {
                                    ((acms)localObject1).a(l1, l2, l3, (String)localObject5, i, (String)localObject6, (String)localObject8, j);
                                    continue;
                                    localObject5 = ((Bundle)localObject7).getString("troopUin");
                                    if (localObject1 != null)
                                    {
                                      ((acms)localObject1).tk((String)localObject5);
                                      continue;
                                      localObject1 = ((Bundle)localObject7).getString("troopUin");
                                      bool = ((Bundle)localObject7).getBoolean("isChecked");
                                      if (localObject5 != null)
                                      {
                                        ((accc)localObject5).aD((String)localObject1, bool);
                                        continue;
                                        localObject1 = ((Bundle)localObject7).getString("troopUin");
                                        bool = ((Bundle)localObject7).getBoolean("isChecked");
                                        if (localObject5 != null) {
                                          ((accc)localObject5).aE((String)localObject1, bool);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      case 122: 
        localObject1 = ((Bundle)localObject7).getString("content");
        i = ((Bundle)localObject7).getInt("seq");
        localObject5 = (acde)((QQAppInterface)localObject8).getBusinessHandler(8);
        if (localObject5 != null) {
          if (((acde)localObject5).a((String)localObject1, 0).longValue() > 0L) {
            bool = true;
          }
        }
        break;
      }
      for (;;)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("isSuccess", bool);
        ((Bundle)localObject1).putInt("seq", i);
        TroopMemberApiService.this.j(122, (Bundle)localObject1);
        break label720;
        bool = false;
        continue;
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        if (localObject1 != null) {
          ((acms)localObject1).Fa((String)localObject5);
        }
        if (!QLog.isDevelopLevel()) {
          break label720;
        }
        QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject5 }));
        break label720;
        if (localObject6 == null) {
          break label720;
        }
        localObject1 = ((Bundle)localObject7).getString("methord_name");
        if ("getGroupInArea".equals(localObject1))
        {
          ((acgr)localObject6).c(((Bundle)localObject7).getString("areaName"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("startIndex"), ((Bundle)localObject7).getInt("count"), ((Bundle)localObject7).getInt("iFilterId"));
          break label720;
        }
        if ("getNearbyTroops".equals(localObject1))
        {
          ((acgr)localObject6).a(((Bundle)localObject7).getBoolean("isFirst"), ((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("sortType"), ((Bundle)localObject7).getString("strGroupArea"), ((Bundle)localObject7).getInt("iFilterId"));
          break label720;
        }
        if ("getAreaList".equals(localObject1))
        {
          ((acgr)localObject6).h(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"), ((Bundle)localObject7).getInt("radius"), ((Bundle)localObject7).getBoolean("isClickable"));
          break label720;
        }
        if (!"getNewNearbyTroop".equals(localObject1)) {
          break label720;
        }
        ((acgr)localObject6).gV(((Bundle)localObject7).getInt("lat"), ((Bundle)localObject7).getInt("lon"));
        break label720;
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        localObject6 = ((Bundle)localObject7).getString("memberUin");
        i = ((Bundle)localObject7).getInt("titleId");
        localObject7 = (TroopManager)((AppRuntime)localObject8).getManager(52);
        if ((localObject7 == null) || (i <= 0)) {
          break label720;
        }
        ((TroopManager)localObject7).a((String)localObject5, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
        ((acms)localObject1).notifyUI(144, true, new Object[] { localObject5, localObject6, Integer.valueOf(i) });
        break label720;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
        localObject5 = ((Bundle)localObject7).getStringArray("paths");
        if (((localObject8 instanceof QQAppInterface)) && (localObject5 != null) && (localObject5.length > 0))
        {
          localObject6 = (altq)((AppRuntime)localObject8).getManager(36);
          if (localObject6 != null)
          {
            localObject7 = new int[localObject5.length];
            localObject8 = new int[localObject5.length];
            i = 0;
            if (i < localObject8.length)
            {
              localObject9 = ((altq)localObject6).getAppInfoByPath(localObject5[i]);
              if (localObject9 != null)
              {
                localObject7[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).iNewFlag.get();
                localObject8[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject9).type.get();
              }
              for (;;)
              {
                i += 1;
                break;
                localObject7[i] = 0;
                localObject8[i] = -1;
              }
            }
            ((Bundle)localObject1).putIntArray("iNewFlags", (int[])localObject7);
            ((Bundle)localObject1).putIntArray("types", (int[])localObject8);
          }
        }
        TroopMemberApiService.this.j(11, (Bundle)localObject1);
        break label720;
        new Bundle().putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
        localObject1 = ((Bundle)localObject7).getString("path");
        if (!(localObject8 instanceof QQAppInterface)) {
          break label720;
        }
        localObject5 = (altq)((AppRuntime)localObject8).getManager(36);
        if (localObject5 == null) {
          break label720;
        }
        ((altq)localObject5).OS((String)localObject1);
        break label720;
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        localObject6 = ((Bundle)localObject7).getString("processName");
        if (localObject1 == null) {
          break label720;
        }
        ((acms)localObject1).eW((String)localObject5, (String)localObject6);
        break label720;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("method", "changeAnonymousNick");
        ((Bundle)localObject1).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        l1 = ((Bundle)localObject7).getLong("bubbleId");
        i = ((Bundle)localObject7).getInt("headId");
        localObject6 = ((Bundle)localObject7).getString("nickName");
        j = ((Bundle)localObject7).getInt("expireTime");
        localObject7 = ((Bundle)localObject7).getString("rankColor");
        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
        {
          jof.a().a((String)localObject5, l1, i, (String)localObject6, j, "", (String)localObject7);
          ((Bundle)localObject1).putBoolean("result", true);
        }
        for (;;)
        {
          TroopMemberApiService.this.j(13, (Bundle)localObject1);
          break;
          ((Bundle)localObject1).putBoolean("result", false);
        }
        i = ((Bundle)localObject7).getInt("appid");
        localObject5 = ((Bundle)localObject7).getString("token");
        ((acms)localObject1).b(i, ((Bundle)localObject7).getString("openGroupId"), (String)localObject5, ((Bundle)localObject7).getString("url"), ((Bundle)localObject7).getInt("seq"));
        break label720;
        i = ((Bundle)localObject7).getInt("seq");
        if (TroopMemberApiService.this.jdField_a_of_type_Tzj == null) {
          TroopMemberApiService.this.jdField_a_of_type_Tzj = new tzj((AppRuntime)localObject8, TroopMemberApiService.this);
        }
        TroopMemberApiService.this.jdField_a_of_type_Tzj.a(118, (Bundle)localObject7, i);
        break label720;
        i = ((Bundle)localObject7).getInt("appid");
        localObject5 = ((Bundle)localObject7).getString("token");
        ((acms)localObject1).g(i, ((Bundle)localObject7).getString("openId"), (String)localObject5, ((Bundle)localObject7).getInt("seq"));
        break label720;
        bool = ((Bundle)localObject7).getBoolean("isTroopAppListChanged");
        localObject1 = (aprp)((AppRuntime)localObject8).getManager(109);
        if (localObject1 == null) {
          break label720;
        }
        ((aprp)localObject1).Se(bool);
        break label720;
        bool = ((Bundle)localObject7).getBoolean("isTroopProfileAppListChanged");
        localObject1 = ((Bundle)localObject7).getString("profileAppListChangedTroopUin");
        localObject5 = (aprp)((AppRuntime)localObject8).getManager(109);
        if (localObject5 == null) {
          break label720;
        }
        ((aprp)localObject5).aQ(bool, (String)localObject1);
        break label720;
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        localObject1 = ((Bundle)localObject7).getString("opn");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
          break label720;
        }
        if (((String)localObject1).equals("g_homework"))
        {
          l1 = Long.parseLong((String)localObject5);
          localObject1 = "";
          if (apsv.n((QQAppInterface)localObject8, l1)) {
            localObject1 = "role=teacher&";
          }
          localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
          ((Intent)localObject6).putExtra("url", "https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
          ((Intent)localObject6).setFlags(268435456);
          TroopMemberApiService.this.startActivity((Intent)localObject6);
          break label720;
        }
        if (!((String)localObject1).equals("g_troop_reward")) {
          break label720;
        }
        apts.a((QQAppInterface)localObject8, TroopMemberApiService.this, (String)localObject5, true);
        break label720;
        ((Bundle)localObject7).putBoolean("isSuccess", true);
        ((Bundle)localObject7).putString("data", TroopBarPublishActivity.cne);
        TroopMemberApiService.this.j(81, (Bundle)localObject7);
        break label720;
        TroopMemberApiService.this.bb((Bundle)localObject7);
        break label720;
        if (TroopMemberApiService.a((AppRuntime)localObject8, new skz(this, (Bundle)localObject7))) {
          break label720;
        }
        TroopMemberApiService.this.j(16, (Bundle)localObject7);
        break label720;
        l1 = ((Bundle)localObject7).getLong("uiResId");
        localObject1 = zjq.a().a(l1);
        if ((localObject1 != null) && (((aevs)localObject1).a != null))
        {
          ((Bundle)localObject7).putString("packageName", ((aevs)localObject1).a.strPkgName);
          ((Bundle)localObject7).putString("imageUrl", ((aevs)localObject1).a.strResURL);
          ((Bundle)localObject7).putString("name", ((aevs)localObject1).a.strResName);
          if (((aevs)localObject1).bo == 0)
          {
            bool = true;
            label3241:
            ((Bundle)localObject7).putBoolean("isOpen", bool);
            ((Bundle)localObject7).putInt("type", 0);
            ((Bundle)localObject7).putBoolean("has", true);
          }
        }
        for (;;)
        {
          TroopMemberApiService.this.j(18, (Bundle)localObject7);
          break;
          bool = false;
          break label3241;
          ((Bundle)localObject7).putBoolean("has", false);
        }
        zjq.cdv |= 0x1;
        bool = ((Bundle)localObject7).getBoolean("isChecked");
        l1 = ((Bundle)localObject7).getLong("uiResId");
        ((Bundle)localObject7).putBoolean("result", TroopMemberApiService.a(TroopMemberApiService.this, l1, bool));
        TroopMemberApiService.this.j(17, (Bundle)localObject7);
        break label720;
        localObject5 = ((Bundle)localObject7).getString("troopUin");
        Object localObject9 = ((Bundle)localObject7).getString("troopName");
        ((Bundle)localObject7).getInt("troopTypeId");
        localObject6 = (TroopManager)((AppRuntime)localObject8).getManager(52);
        if (localObject6 != null)
        {
          localObject1 = ((TroopManager)localObject6).b((String)localObject5);
          if (localObject1 == null)
          {
            localObject1 = new TroopInfo();
            ((TroopInfo)localObject1).troopuin = ((String)localObject5);
            ((TroopInfo)localObject1).troopname = ((String)localObject9);
            ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject8).getCurrentAccountUin();
            ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
            ((TroopManager)localObject6).i((TroopInfo)localObject1);
          }
        }
        for (;;)
        {
          String str2;
          for (;;)
          {
            localObject9 = (acms)((QQAppInterface)localObject8).getBusinessHandler(20);
            if (localObject9 != null) {
              ((acms)localObject9).Fa((String)localObject5);
            }
            if ((localObject6 != null) && (localObject1 != null)) {
              ((TroopManager)localObject6).l((TroopInfo)localObject1);
            }
            if (!(localObject8 instanceof QQAppInterface)) {
              break;
            }
            TroopMemberApiService.this.j(19, (Bundle)localObject7);
            break;
            if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
              break;
            }
            l1 = ((Bundle)localObject7).getLong("troopCode");
            localObject1 = ((Bundle)localObject7).getString("filePath");
            localObject5 = ((Bundle)localObject7).getString("fileName");
            l2 = ((Bundle)localObject7).getLong("fileSize");
            i = ((Bundle)localObject7).getInt("busid");
            localObject1 = apsv.a((QQAppInterface)localObject8, l1, null, (String)localObject1, (String)localObject5, l2, i);
            localObject5 = new Bundle();
            ((Bundle)localObject5).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
            if (!TextUtils.isEmpty(((Bundle)localObject7).getString("callback"))) {
              ((Bundle)localObject5).putString("callback", ((Bundle)localObject7).getString("callback"));
            }
            ((Bundle)localObject5).putString("method", "getFileInfo");
            TroopMemberApiService.a(TroopMemberApiService.this, (QQAppInterface)localObject8, l1, HWTroopFileStatusInfo.parse((apcy)localObject1), (Bundle)localObject5);
            break;
            if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
              break;
            }
            if (TroopMemberApiService.this.b == null) {
              TroopMemberApiService.this.b = new obh(TroopMemberApiService.this, (QQAppInterface)localObject8);
            }
            if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
            {
              TroopMemberApiService.this.b.aN((Bundle)localObject7);
              break;
            }
            TroopMemberApiService.this.b.aP((Bundle)localObject7);
            break;
            if ((!(localObject8 instanceof QQAppInterface)) || (localObject7 == null)) {
              break;
            }
            if (TroopMemberApiService.this.b == null) {
              TroopMemberApiService.this.b = new obh(TroopMemberApiService.this, (QQAppInterface)localObject8);
            }
            if (((Bundle)localObject7).getBoolean("is_pic_or_voice"))
            {
              TroopMemberApiService.this.b.aO((Bundle)localObject7);
              break;
            }
            TroopMemberApiService.this.b.aQ((Bundle)localObject7);
            break;
            if (TroopMemberApiService.this.b == null) {
              break;
            }
            TroopMemberApiService.this.b.bde();
            break;
            TroopMemberApiService.this.bxA = ((Bundle)localObject7).getInt("appId");
            TroopMemberApiService.this.bxB = ((Bundle)localObject7).getInt("seq");
            if (TroopMemberApiService.this.bxA == 0) {
              break;
            }
            localObject1 = (aprp)((AppRuntime)localObject8).getManager(109);
            if (localObject1 == null) {
              break;
            }
            localObject5 = new ArrayList();
            if ((((aprp)localObject1).mh(0)) && (!((aprp)localObject1).mi(0)))
            {
              localObject6 = ((aprp)localObject1).b(false, 0);
              if ((localObject6 != null) && (!((List)localObject6).isEmpty()))
              {
                localObject6 = ((List)localObject6).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  localObject7 = (TroopAIOAppInfo)((Iterator)localObject6).next();
                  ((ArrayList)localObject5).add(Integer.valueOf(((TroopAIOAppInfo)localObject7).appid));
                  if (((TroopAIOAppInfo)localObject7).appid == TroopMemberApiService.this.bxA)
                  {
                    QQToast.a(BaseApplication.getContext(), 2, 2131721288, 0).show(TroopMemberApiService.this.getResources().getDimensionPixelSize(2131299627));
                    return;
                  }
                }
              }
              ((ArrayList)localObject5).add(Integer.valueOf(TroopMemberApiService.this.bxA));
              localObject6 = new ArrayList();
              ((ArrayList)localObject6).add(Integer.valueOf(TroopMemberApiService.this.bxA));
              ((aprp)localObject1).o((ArrayList)localObject5, (ArrayList)localObject6);
              break;
            }
            TroopMemberApiService.this.aLT = true;
            ((aprp)localObject1).b(true, 0);
            break;
            l1 = ((Bundle)localObject7).getLong("roomid", 0L);
            localObject1 = ((Bundle)localObject7).getString("roomname");
            localObject5 = ((Bundle)localObject7).getString("userdata");
            localObject6 = ((Bundle)localObject7).getString("vasname");
            i = ((Bundle)localObject7).getInt("fromid", 0);
            ((aigu)((QQAppInterface)localObject8).getManager(108)).a(TroopMemberApiService.this, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
            break;
            localObject1 = ((Bundle)localObject7).getString("appType");
            localObject5 = ((Bundle)localObject7).getString("openType");
            localObject6 = ((Bundle)localObject7).getString("uri");
            localObject9 = ((Bundle)localObject7).getString("action");
            str2 = ((Bundle)localObject7).getString("pluginPackageName");
            localObject7 = ((Bundle)localObject7).getString("pluginParams");
            aidn.a((QQAppInterface)localObject8, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject9, str2, (String)localObject7);
            break;
            localObject1 = ((Bundle)localObject7).getString("pluginPackageName");
            localObject5 = ((Bundle)localObject7).getString("appType");
            aidf.a(((QQAppInterface)localObject8).getApp(), (String)localObject1, (String)localObject5).dsa();
            break;
            try
            {
              l1 = ((Bundle)localObject7).getLong("troopPubAccountUin");
              localObject1 = ((Bundle)localObject7).getLongArray("troopUinList");
              if ((localObject1 == null) || (localObject1.length <= 0)) {
                break;
              }
              localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
              i = 0;
              while (i < localObject1.length)
              {
                localObject6 = ((TroopManager)localObject5).b(localObject1[i] + "");
                if (localObject6 != null) {
                  ((TroopInfo)localObject6).associatePubAccount = l1;
                }
                ((TroopManager)localObject5).i((TroopInfo)localObject6);
                i += 1;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            catch (Exception localException1) {}
          }
          QLog.e("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + localException1.toString());
          break label720;
          Object localObject2 = ((Bundle)localObject7).getString("troopUin");
          localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
          if (localObject5 == null) {
            break label720;
          }
          localObject2 = ((TroopManager)localObject5).b((String)localObject2);
          if (localObject2 == null) {
            break label720;
          }
          ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
          ((TroopManager)localObject5).i((TroopInfo)localObject2);
          break label720;
          localObject2 = ((Bundle)localObject7).getString("troopUin");
          localObject5 = (TroopManager)((AppRuntime)localObject8).getManager(52);
          if (localObject5 != null)
          {
            localObject2 = ((TroopManager)localObject5).b((String)localObject2);
            if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
              bool = true;
            }
          }
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  ((Bundle)localObject7).putBoolean("hasOrgs", bool);
                  TroopMemberApiService.this.j(46, (Bundle)localObject7);
                  break label720;
                  bool = false;
                  continue;
                  localObject2 = ((Bundle)localObject7).getString("localFilePath");
                  localObject5 = ((Bundle)localObject7).getString("fileDisPlayName");
                  apqz.n(TroopMemberApiService.this, (String)localObject2, (String)localObject5);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  i = ((Bundle)localObject7).getInt("rewardMoney");
                  localObject5 = ((Bundle)localObject7).getString("rewardContent");
                  localObject6 = ((Bundle)localObject7).getString("mediaPath");
                  j = ((Bundle)localObject7).getInt("rewardType");
                  apts.dVR = ((Bundle)localObject7).getInt("imageMaxWidthPixels", 1080);
                  apts.dVS = ((Bundle)localObject7).getInt("imageMaxHeightPixels", 1920);
                  ((apts)((AppRuntime)localObject8).getManager(152)).d((String)localObject2, i, (String)localObject5, (String)localObject6, j);
                  break label720;
                  ((acms)localObject2).aA(((Bundle)localObject7).getLong("troopUin"), ((Bundle)localObject7).getInt("flag"));
                  break label720;
                  localObject2 = (QQAppInterface)localObject8;
                  ((Bundle)localObject7).putInt("fontSize", QQAppInterface.cxk);
                  TroopMemberApiService.this.j(52, (Bundle)localObject7);
                  break label720;
                  i = ((Bundle)localObject7).getInt("fontSize", 1);
                  localObject2 = (QQAppInterface)localObject8;
                  QQAppInterface.cxk = i;
                  ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  localObject5 = ((Bundle)localObject7).getString("rewardId");
                  localObject5 = ((apts)((AppRuntime)localObject8).getManager(152)).a((String)localObject2, (String)localObject5);
                  localObject2 = "";
                  if (localObject5 != null) {
                    localObject2 = ((MessageForTroopReward)localObject5).mediaPath;
                  }
                  ((Bundle)localObject7).putString("videoPath", (String)localObject2);
                  TroopMemberApiService.this.j(55, (Bundle)localObject7);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  localObject5 = ((Bundle)localObject7).getString("largeImageFile");
                  localObject6 = ((Bundle)localObject7).getString("fileName");
                  l1 = ((Bundle)localObject7).getLong("progressTotal");
                  i = ((Bundle)localObject7).getInt("busId");
                  TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  localObject5 = ((Bundle)localObject7).getString("filePath");
                  localObject6 = ((Bundle)localObject7).getString("fileName");
                  i = ((Bundle)localObject7).getInt("size");
                  j = ((Bundle)localObject7).getInt("busId");
                  TroopFileTransferManager.a((QQAppInterface)localObject8, Long.parseLong((String)localObject2)).e((String)localObject5, (String)localObject6, j, i);
                  break label720;
                  localObject5 = (TroopPluginManager)((AppRuntime)localObject8).getManager(119);
                  localObject6 = ((Bundle)localObject7).getString("troopUin");
                  i = ((Bundle)localObject7).getInt("seq");
                  localObject7 = ((Bundle)localObject7).getString("processName");
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((TroopPluginManager)localObject5).a("troop_manage_plugin.apk", new slc(this, (acms)localObject2, (String)localObject6, i, (String)localObject7));
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("appid");
                  localObject5 = ((Bundle)localObject7).getString("pkgname");
                  TroopMemberApiService.this.cM((String)localObject5, (String)localObject2);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("hashName");
                  ((Bundle)localObject7).putByteArray("decryptResult", PreloadManager.a().k((String)localObject2));
                  TroopMemberApiService.this.j(66, (Bundle)localObject7);
                  break label720;
                  ((acms)localObject2).a(((Bundle)localObject7).getString("troopUin"), "", ((Bundle)localObject7).getInt("statOption"), ((Bundle)localObject7).getString("authKey"), null, null, null);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("groupCode");
                  localObject5 = ((Bundle)localObject7).getString("groupMemberUin");
                  i = ((Bundle)localObject7).getInt("seq");
                  ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (TroopManager)((AppRuntime)localObject8).getManager(52), (String)localObject2, (String)localObject5, (Bundle)localObject7, i), 8, null, true);
                  break label720;
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
                  localObject5 = ((aqva)((AppRuntime)localObject8).getManager(47)).a(1);
                  localObject6 = new File(ajpn.bRZ + File.separator + "nearby_heart.mp4");
                  if (!((File)localObject6).exists()) {
                    ((File)localObject6).mkdirs();
                  }
                  for (;;)
                  {
                    ((aqvc)localObject5).a(new aquz("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject6), new sld(this, (Bundle)localObject2), new Bundle());
                    break;
                    ((File)localObject6).delete();
                  }
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
                  bool = false;
                  if ((localObject8 instanceof QQAppInterface))
                  {
                    localObject5 = (QQAppInterface)localObject8;
                    if ((!((QQAppInterface)localObject5).bF()) || (((QQAppInterface)localObject5).a().sB())) {
                      break label5607;
                    }
                  }
                  label5607:
                  for (bool = true;; bool = false)
                  {
                    ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
                    TroopMemberApiService.this.j(84, (Bundle)localObject2);
                    break;
                  }
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("seq", ((Bundle)localObject7).getInt("seq", -1));
                  if ((localObject8 instanceof QQAppInterface))
                  {
                    localObject6 = (apre)((AppRuntime)localObject8).getManager(224);
                    if (localObject6 != null)
                    {
                      localObject5 = ((apre)localObject6).By();
                      localObject6 = ((apre)localObject6).getTitle();
                      ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject5);
                      ((Bundle)localObject2).putString("title", (String)localObject6);
                    }
                  }
                  TroopMemberApiService.this.j(76, (Bundle)localObject2);
                  break label720;
                  if (!(localObject8 instanceof QQAppInterface)) {
                    break label720;
                  }
                  bool = ankq.f((QQAppInterface)localObject8, BaseApplicationImpl.getContext());
                  if (!QLog.isColorLevel()) {
                    break label720;
                  }
                  QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("packageName");
                  localObject5 = ((Bundle)localObject7).getString("pluginId");
                  localObject6 = ((Bundle)localObject7).getString("versionCode");
                  jrw.a().a((String)localObject2, (String)localObject5, (String)localObject6);
                  jrw.a().z((QQAppInterface)localObject8);
                  ((Bundle)localObject7).putInt("state", jrv.aCR);
                  ((Bundle)localObject7).putString("version", jrv.versionCode);
                  ((Bundle)localObject7).putLong("size", jrv.qw);
                  TroopMemberApiService.this.j(78, (Bundle)localObject7);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("via");
                  localObject5 = ((Bundle)localObject7).getString("startParam");
                  i = ((Bundle)localObject7).getInt("action");
                  jrw.a().a((String)localObject2, i, (String)localObject5, new sle(this, (Bundle)localObject7, i));
                  break label720;
                  ((Bundle)localObject7).putInt("currentFragment", SplashActivity.bKT);
                  TroopMemberApiService.this.j(80, (Bundle)localObject7);
                  break label720;
                  localObject2 = (mzg)((AppRuntime)localObject8).getManager(226);
                  ((mzg)localObject2).a(TroopMemberApiService.this);
                  ((mzg)localObject2).e(((Bundle)localObject7).getString("videoPath"), (Bundle)localObject7);
                  break label720;
                  i = ((Bundle)localObject7).getInt("subCmd");
                  localObject2 = (apdr)((QQAppInterface)localObject8).getManager(231);
                  switch (i)
                  {
                  }
                  for (;;)
                  {
                    TroopMemberApiService.this.j(87, (Bundle)localObject7);
                    break;
                    ((apdr)localObject2).i(((Bundle)localObject7).getInt("effectId"), ((Bundle)localObject7).getString("effectName"), ((Bundle)localObject7).getInt("svipLevel"), ((Bundle)localObject7).getInt("svipType"));
                    continue;
                    localObject5 = ((Bundle)localObject7).getStringArrayList("statusList");
                    if (localObject5 != null) {
                      ((apdr)localObject2).eY((ArrayList)localObject5);
                    }
                  }
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  localObject5 = ((Bundle)localObject7).getString("path");
                  i = ((Bundle)localObject7).getInt("msgTailType", 0);
                  localObject6 = new Intent();
                  ((Intent)localObject6).putExtra("send_in_background", true);
                  ((Intent)localObject6).putExtra("file_send_path", (String)localObject5);
                  ((Intent)localObject6).putExtra("file_send_size", new File((String)localObject5).length());
                  ((Intent)localObject6).putExtra("file_send_duration", ShortVideoUtils.getDurationOfVideo((String)localObject5));
                  ((Intent)localObject6).putExtra("uin", (String)localObject2);
                  ((Intent)localObject6).putExtra("uintype", 1);
                  ((Intent)localObject6).putExtra("file_source", "album_flow");
                  ((Intent)localObject6).putExtra("short_video_msg_tail_type", i);
                  new SendVideoActivity.c((Intent)localObject6).execute(new Void[0]);
                  TroopMemberApiService.this.j(87, (Bundle)localObject7);
                  break label720;
                  l1 = ((Bundle)localObject7).getLong("roomId");
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("jumpType", 1);
                  ((Bundle)localObject2).putString("roomid", String.valueOf(l1));
                  ((aifl)((AppRuntime)localObject8).getManager(306)).cL((Bundle)localObject2);
                  break label720;
                  ((aifl)((AppRuntime)localObject8).getManager(306)).preload();
                  break label720;
                  if (TroopMemberApiService.this.aLU) {
                    break;
                  }
                  TroopMemberApiService.this.aLU = true;
                  bool = aqiw.isNetworkAvailable(null);
                  VideoEnvironment.k("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
                  if (bool)
                  {
                    VideoEnvironment.k("TroopMemberApiService", acfp.m(2131715999), null);
                    ShortVideoResourceManager.b((QQAppInterface)localObject8, new slf(this, (AppRuntime)localObject8, (Bundle)localObject7));
                    break label720;
                  }
                  ((Bundle)localObject7).putInt("result", -1);
                  TroopMemberApiService.this.j(93, (Bundle)localObject7);
                  break label720;
                  i = ((Bundle)localObject7).getInt("isGroupCode");
                  localObject2 = ((Bundle)localObject7).getString("roomId");
                  localObject5 = ((Bundle)localObject7).getString("action");
                  localObject6 = ((Bundle)localObject7).getString("fromId");
                  localObject9 = ((Bundle)localObject7).getString("backType");
                  str2 = ((Bundle)localObject7).getString("openType");
                  localObject7 = ((Bundle)localObject7).getString("extra");
                  ((aicu)((AppRuntime)localObject8).getManager(236)).a(TroopMemberApiService.this, (String)localObject2, ((QQAppInterface)localObject8).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject9, str2, (String)localObject7);
                  break label720;
                  ((Bundle)localObject7).getString("fromId");
                  ((aicu)((AppRuntime)localObject8).getManager(236)).b(null, 10L);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("uin");
                  i = ((Bundle)localObject7).getInt("index");
                  localObject2 = jxl.a().b((String)localObject2);
                  if (localObject2 == null) {
                    break label720;
                  }
                  localObject5 = (jxo)((AppRuntime)localObject8).getManager(238);
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((jxo)localObject5).a((jxc)localObject2, i);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopCode");
                  localObject5 = ((Bundle)localObject7).getString("uin");
                  localObject6 = ((Bundle)localObject7).getString("nick");
                  localObject7 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject7 == null) {
                    break label720;
                  }
                  ((acfv)localObject7).R((String)localObject2, (String)localObject5, (String)localObject6);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopCode");
                  localObject5 = ((Bundle)localObject7).getString("uin");
                  localObject6 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject6 == null) {
                    break label720;
                  }
                  ((acfv)localObject6).cI((String)localObject2, (String)localObject5);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopCode");
                  localObject5 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((acfv)localObject5).tl((String)localObject2);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopCode");
                  localObject5 = ((Bundle)localObject7).getString("uin");
                  localObject6 = ((Bundle)localObject7).getString("nick");
                  localObject7 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject7 == null) {
                    break label720;
                  }
                  ((acfv)localObject7).as((String)localObject2, (String)localObject5, (String)localObject6);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("troopCode");
                  localObject5 = ((Bundle)localObject7).getString("uin");
                  localObject6 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject6 == null) {
                    break label720;
                  }
                  ((acfv)localObject6).cJ((String)localObject2, (String)localObject5);
                  break label720;
                  ((Bundle)localObject7).getString("troopCode");
                  localObject2 = ((Bundle)localObject7).getString("rid");
                  localObject5 = new slh(this, (Bundle)localObject7);
                  TroopMemberApiService.this.jdField_a_of_type_Acgk = new acgk((QQAppInterface)localObject8, (acgk.a)localObject5, (String)localObject2);
                  TroopMemberApiService.this.jdField_a_of_type_Acgk.hy(10000L);
                  break label720;
                  TroopMemberApiService.this.bxC = ((Bundle)localObject7).getInt("seq", -1);
                  localObject2 = ((Bundle)localObject7).getStringArrayList("tinyIdList");
                  localObject5 = (acfv)((QQAppInterface)localObject8).getBusinessHandler(35);
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((acfv)localObject5).dE((ArrayList)localObject2);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getString("schoolName");
                  i = ((Bundle)localObject7).getInt("isValid");
                  localObject5 = (ajrs)((QQAppInterface)localObject8).getBusinessHandler(60);
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((ajrs)localObject5).bB((String)localObject2, i);
                  break label720;
                  localObject2 = ((Bundle)localObject7).getStringArrayList("preloadList");
                  localObject5 = (jzf)((AppRuntime)localObject8).getManager(248);
                  if (localObject5 == null) {
                    break label720;
                  }
                  ((jzf)localObject5).bM((ArrayList)localObject2);
                  break label720;
                  localObject2 = (jzf)((AppRuntime)localObject8).getManager(248);
                  if (localObject2 == null) {
                    break label720;
                  }
                  ((jzf)localObject2).aBr();
                  break label720;
                  i = ((Bundle)localObject7).getInt("topicId");
                  j = ((Bundle)localObject7).getInt("followInfo");
                  if (lbz.a().aa(i, j)) {
                    break label720;
                  }
                  lbz.a().cH(i, j);
                  break label720;
                  ((Bundle)localObject7).putInt("readinjoy_to_wx_config", awit.y((AppRuntime)localObject8));
                  TroopMemberApiService.this.j(113, (Bundle)localObject7);
                  break label720;
                  if (TroopMemberApiService.this.jdField_a_of_type_Ljq == null) {
                    TroopMemberApiService.this.jdField_a_of_type_Ljq = new ljq((AppRuntime)localObject8, TroopMemberApiService.this);
                  }
                  TroopMemberApiService.this.jdField_a_of_type_Ljq.az((Bundle)localObject7);
                  break label720;
                  ((pma)((QQAppInterface)localObject8).getBusinessHandler(98)).vI(((Bundle)localObject7).getInt("reqUserSetEnableAlbumScan"));
                  break label720;
                  if (TroopMemberApiService.this.jdField_a_of_type_Ljq == null) {
                    TroopMemberApiService.this.jdField_a_of_type_Ljq = new ljq((AppRuntime)localObject8, TroopMemberApiService.this);
                  }
                  TroopMemberApiService.this.jdField_a_of_type_Ljq.aA((Bundle)localObject7);
                  break label720;
                  if (TroopMemberApiService.this.jdField_a_of_type_Ljq == null) {
                    TroopMemberApiService.this.jdField_a_of_type_Ljq = new ljq((AppRuntime)localObject8, TroopMemberApiService.this);
                  }
                  TroopMemberApiService.this.jdField_a_of_type_Ljq.aB((Bundle)localObject7);
                  break label720;
                  if (TroopMemberApiService.this.jdField_a_of_type_Ljq == null) {
                    TroopMemberApiService.this.jdField_a_of_type_Ljq = new ljq((AppRuntime)localObject8, TroopMemberApiService.this);
                  }
                  TroopMemberApiService.this.jdField_a_of_type_Ljq.ay((Bundle)localObject7);
                  break label720;
                  TroopMemberApiService.this.aEv = ((Bundle)localObject7).getString("callback");
                  TroopMemberApiService.this.bxD = ((Bundle)localObject7).getInt("seq");
                  localObject5 = ((Bundle)localObject7).getString("troopUin");
                  localObject6 = ((Bundle)localObject7).getString("chatType");
                  if ((!TextUtils.isEmpty((CharSequence)localObject5)) && ("group".equals(localObject6)))
                  {
                    if (localObject2 == null) {
                      break label720;
                    }
                    ((acms)localObject2).a((String)localObject5, false, "TroopMemberApiService111", true, true, false, false);
                    break label720;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject5 + ", chatType=" + (String)localObject6);
                  }
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putBoolean("isSuccess", false);
                  ((Bundle)localObject2).putInt("seq", TroopMemberApiService.this.bxD);
                  ((Bundle)localObject2).putString("callback", TroopMemberApiService.this.aEv);
                  TroopMemberApiService.this.j(112, (Bundle)localObject2);
                  break label720;
                  localObject2 = new Intent(((QQAppInterface)localObject8).getApp().getApplicationContext(), SplashActivity.class);
                  ((Intent)localObject2).putExtras((Bundle)localObject7);
                  localObject2 = wja.a((Intent)localObject2, null);
                  localObject5 = ForwardUtils.a((Intent)localObject2);
                  ForwardUtils.a((QQAppInterface)localObject8, ((QQAppInterface)localObject8).getApp().getApplicationContext(), (SessionInfo)localObject5, (Intent)localObject2);
                  break label720;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_BEACON_REPORT");
                  }
                  anxg.jdMethod_do(((Bundle)localObject7).getBundle("reportData"));
                  break label720;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_PRELOAD");
                  }
                  if (!(localObject8 instanceof QQAppInterface)) {
                    break label720;
                  }
                  ((anwh)((AppRuntime)localObject8).getManager(362)).fi(BaseApplicationImpl.getContext());
                  break label720;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
                  }
                  localObject2 = ((Bundle)localObject7).getString("troopUin");
                  localObject5 = ((Bundle)localObject7).getString("type");
                  if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject5)) || (apqz.m((QQAppInterface)localObject8, (String)localObject2) == 0)) {
                    break label720;
                  }
                  apqz.aU((QQAppInterface)localObject8, (String)localObject2);
                  break label720;
                  l1 = ((Bundle)localObject7).getLong("followUin");
                  i = ((Bundle)localObject7).getInt("followInfo");
                  if ((i != 2) && (i != 1)) {
                    break label720;
                  }
                  localObject2 = lcc.a();
                  if (i == 2) {}
                  for (bool = true;; bool = false)
                  {
                    ((lcc)localObject2).W(l1, bool);
                    ThreadManager.post(new TroopMemberApiService.IncomingHandler.9(this, l1, i), 8, null, true);
                    break;
                  }
                  localObject5 = ((Bundle)localObject7).getString("url");
                  i = ((Bundle)localObject7).getInt("type", -1);
                  j = ((Bundle)localObject7).getInt("msgfrom", 0);
                  localObject6 = ((Bundle)localObject7).getString("senderUin");
                  localObject9 = ((Bundle)localObject7).getString("chatId");
                  str2 = ((Bundle)localObject7).getString("source");
                  k = ((Bundle)localObject7).getInt("seq");
                  localObject2 = ((Bundle)localObject7).getString("processName");
                  localObject7 = ((Bundle)localObject7).getString("originUrl");
                  localObject8 = (aqym)((AppRuntime)localObject8).getManager(290);
                  if (localObject8 != null)
                  {
                    ((aqym)localObject8).a((String)localObject5, i, j, (String)localObject6, (String)localObject9, str2, (String)localObject7, new sla(this, k, (String)localObject2));
                    break label720;
                  }
                  localObject5 = new Bundle();
                  ((Bundle)localObject5).putInt("seq", k);
                  ((Bundle)localObject5).putString("processName", (String)localObject2);
                  TroopMemberApiService.this.j(121, (Bundle)localObject5);
                  break label720;
                  try
                  {
                    localObject2 = (aqym)((AppRuntime)localObject8).getManager(290);
                    if (localObject2 == null) {
                      break label8189;
                    }
                    ((aqym)localObject2).dz((Bundle)localObject7);
                  }
                  catch (Throwable localThrowable)
                  {
                    QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
                  }
                }
                break label720;
                label8189:
                if (!QLog.isColorLevel()) {
                  break label720;
                }
                QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
                break label720;
                Object localObject3 = (aqym)((AppRuntime)localObject8).getManager(290);
                localObject5 = ((Bundle)localObject7).getString("appid");
                localObject6 = ((Bundle)localObject7).getString("openid");
                localObject8 = ((Bundle)localObject7).getString("troopuin");
                i = ((Bundle)localObject7).getInt("seq");
                localObject7 = ((Bundle)localObject7).getString("processName");
                if (localObject3 != null)
                {
                  ((aqym)localObject3).a((String)localObject5, (String)localObject6, (String)localObject8, new slb(this, i, (String)localObject7));
                  break label720;
                }
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt("seq", i);
                ((Bundle)localObject3).putString("processName", (String)localObject7);
                ((Bundle)localObject3).putInt("result", -1);
                TroopMemberApiService.this.j(146, (Bundle)localObject3);
                break label720;
                ((Bundle)localObject7).putString("nickName", ((QQAppInterface)localObject8).getCurrentNickname());
                TroopMemberApiService.this.j(128, (Bundle)localObject7);
                break label720;
                if (BaseActivity.sTopActivity != null) {}
                for (localObject3 = BaseActivity.sTopActivity;; localObject3 = TroopMemberApiService.this.getApplicationContext())
                {
                  KandianSubscribeManager.e((Context)localObject3, 3, 4);
                  break;
                }
                if (((Bundle)localObject7).getBoolean("open_readinjoy_tab"))
                {
                  awit.acy(1);
                  awit.bP(true);
                  awit.Xg(true);
                }
                if (BaseActivity.sTopActivity != null) {}
                for (localObject3 = BaseActivity.sTopActivity;; localObject4 = TroopMemberApiService.this.getApplicationContext())
                {
                  for (;;)
                  {
                    if (!awit.Vs()) {
                      break label8599;
                    }
                    j = 12;
                    try
                    {
                      localObject5 = ((Bundle)localObject7).getString("from");
                      i = j;
                      if (!TextUtils.isEmpty((CharSequence)localObject5))
                      {
                        i = j;
                        if (TextUtils.isDigitsOnly((CharSequence)localObject5)) {
                          i = Integer.valueOf((String)localObject5).intValue();
                        }
                      }
                      localObject5 = kgw.a((Context)localObject3, i);
                      if (i == 16)
                      {
                        ((Intent)localObject5).putExtra("redpackid", ((Bundle)localObject7).getString("redpackid"));
                        ((Intent)localObject5).putExtra("redpack_type", 3);
                        ((Intent)localObject5).putExtra("plat_source", ((Bundle)localObject7).getInt("plat_source"));
                      }
                      ((Context)localObject3).startActivity((Intent)localObject5);
                    }
                    catch (Exception localException2) {}
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
                  break;
                }
                label8599:
                localObject5 = (QQAppInterface)localObject8;
                if (awit.cA((QQAppInterface)localObject5))
                {
                  kgw.b((QQAppInterface)localObject5, (Context)localObject4, 2, 0);
                  break label720;
                }
                kgw.a((Context)localObject4, null, -1L, 2);
                break label720;
                i = ((Bundle)localObject7).getInt("seq");
                localObject4 = (QQAppInterface)localObject8;
                localObject5 = ((acff)((AppRuntime)localObject8).getManager(51)).b(((QQAppInterface)localObject4).getCurrentUin());
                if (localObject5 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberApiService", 2, "get user gender:" + ((Card)localObject5).shGender);
                  }
                  ((Bundle)localObject7).putShort("gender", ((Card)localObject5).shGender);
                }
                ((Bundle)localObject7).putString("facePath", ((QQAppInterface)localObject4).getCustomFaceFilePath(1, ((QQAppInterface)localObject4).getCurrentAccountUin(), 0));
                ((Bundle)localObject7).putInt("seq", i);
                TroopMemberApiService.this.j(126, (Bundle)localObject7);
                break label720;
                i = ((Bundle)localObject7).getInt("start");
                j = ((Bundle)localObject7).getInt("msgType");
                int k = ((Bundle)localObject7).getInt("count");
                localObject4 = aoqu.a(TroopMemberApiService.this.getApplicationContext(), (QQAppInterface)localObject8, i, j, k);
                if (localObject4 != null) {
                  ((Bundle)localObject7).putString("sayhiinfo", ((JSONObject)localObject4).toString());
                }
                TroopMemberApiService.this.j(129, (Bundle)localObject7);
                break label720;
                i = ((Bundle)localObject7).getInt("clearType");
                j = ((Bundle)localObject7).getInt("msgType");
                localObject4 = ((Bundle)localObject7).getString("uin");
                aoqu.h((QQAppInterface)localObject8, (String)localObject4, i, j);
                break label720;
                i = ((Bundle)localObject7).getInt("deleteType");
                localObject4 = ((Bundle)localObject7).getString("uin");
                j = ((Bundle)localObject7).getInt("msgType");
                aoqu.i((QQAppInterface)localObject8, (String)localObject4, i, j);
                break label720;
                bool = ((Bundle)localObject7).getBoolean("isSuccess");
                localObject4 = ((Bundle)localObject7).getString("pkgname");
                lcc.a().a(null, 101, bool, new String[] { localObject4 });
                break label720;
                localObject4 = knq.get(2);
                if ((localObject4 == null) || (!(localObject4 instanceof kkz))) {
                  break label720;
                }
                ((kkz)localObject4).ar((Bundle)localObject7);
                break label720;
                knd.aEK();
                break label720;
                bc((Bundle)localObject7);
                TroopMemberApiService.this.j(141, (Bundle)localObject7);
                break label720;
                localObject4 = ((Bundle)localObject7).getString("uin");
                shk.c(BaseApplicationImpl.getContext(), (String)localObject4, null);
                break label720;
                localObject5 = ((Bundle)localObject7).getString("code");
                localObject4 = new String[4];
                localObject4[0] = "0";
                localObject4[1] = "0";
                localObject4[2] = "0";
                localObject4[3] = "0";
                try
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject5))
                  {
                    localObject5 = new JSONObject((String)localObject5);
                    localObject4[0] = ((JSONObject)localObject5).optString("country", "0");
                    localObject4[1] = ((JSONObject)localObject5).optString("province", "0");
                    localObject4[2] = ((JSONObject)localObject5).optString("city", "0");
                    localObject4[3] = ((JSONObject)localObject5).optString("area", "0");
                  }
                  if (TroopMemberApiService.this.jdField_a_of_type_Accv == null)
                  {
                    TroopMemberApiService.this.jdField_a_of_type_Accv = ((accv)((AppRuntime)localObject8).getManager(59));
                    TroopMemberApiService.this.jdField_a_of_type_Accv.aV(this);
                  }
                  localObject5 = new Intent(BaseApplicationImpl.getContext(), LocationSelectActivity.class);
                  ((Intent)localObject5).putExtra("param_is_popup", false);
                  ((Intent)localObject5).putExtra("param_req_type", 2);
                  ((Intent)localObject5).putExtra("param_location", (String[])localObject4);
                  ((Intent)localObject5).putExtra("param_location_param", TroopMemberApiService.this.jdField_a_of_type_Accv.e((String[])localObject4));
                  BaseApplicationImpl.getContext().startActivity((Intent)localObject5);
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    localJSONException.printStackTrace();
                  }
                }
              }
              if (BaseActivity.sTopActivity != null) {}
              for (localObject4 = BaseActivity.sTopActivity; localObject4 != null; localObject4 = TroopMemberApiService.this.getApplicationContext())
              {
                KandianDailyManager.bV((Context)localObject4);
                break;
              }
              bool = ((Bundle)localObject7).getBoolean("isOpen");
              localObject4 = ((Bundle)localObject7).getString("troopUin");
              if (QLog.isColorLevel()) {
                QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject4, Boolean.valueOf(bool) }));
              }
              ((apmb)((AppRuntime)localObject8).getManager(346)).aF((String)localObject4, bool);
              break label720;
              localObject6 = ((Bundle)localObject7).getString("groupCode");
              String str1 = ((Bundle)localObject7).getString("appID");
              localObject4 = ((Bundle)localObject7).getString("url");
              localObject7 = ((Bundle)localObject7).getString("source");
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", new Object[] { localObject6, str1, localObject4, localObject7 }));
              }
              localObject7 = new SessionInfo();
              ((SessionInfo)localObject7).aTl = ((String)localObject6);
              ((SessionInfo)localObject7).cZ = 1;
              localObject6 = new aotc.c();
              try
              {
                ((aotc.c)localObject6).aqz = Long.parseLong(str1);
                label9546:
                ((aotc.c)localObject6).cmX = ((String)localObject4);
                aprs.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), (SessionInfo)localObject7, (aotc.c)localObject6);
              }
              catch (NumberFormatException localNumberFormatException)
              {
                break label9546;
              }
            }
            bool = false;
          }
          continue;
          Object localObject4 = null;
        }
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService
 * JD-Core Version:    0.7.0.1
 */