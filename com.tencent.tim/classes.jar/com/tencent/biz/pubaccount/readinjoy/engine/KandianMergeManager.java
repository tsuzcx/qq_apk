package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import acfd;
import acxw;
import acza;
import aklk;
import altq;
import anbi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseIntArray;
import anre;
import aqoj;
import awit;
import awiy;
import awiy.b;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kbp;
import kbs;
import kfv;
import kpe;
import kvr;
import kxh;
import kxk;
import kxm;
import kxm.b;
import kyd;
import kyi;
import kys;
import lat;
import lbo;
import lbp;
import lbq;
import lbr;
import lbs;
import lbt;
import lbu;
import lbz;
import lcc;
import lcd;
import lcm;
import lde;
import ljc;
import lvx;
import mgt;
import mhm;
import mhm.a;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import njn;
import nyn;
import oan;
import ocp;
import oea;
import oej;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BiuBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tog;
import top;
import tos;

public class KandianMergeManager
  implements Manager
{
  public static String aek = "PUSH_0X210_ORANGE_KEY";
  private AtomicInteger K;
  private AtomicInteger L;
  private AtomicInteger M;
  private AtomicInteger N;
  private AtomicInteger O;
  private acfd jdField_a_of_type_Acfd = new lbr(this);
  private aklk jdField_a_of_type_Aklk = new lbo(this);
  AladdinListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener = new KandianMergeManager.7(this);
  private KandianSetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo;
  b jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$b = new b();
  private volatile Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private KandianMsgBoxRedPntInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  private mhm.a jdField_a_of_type_Mhm$a;
  private mhm jdField_a_of_type_Mhm;
  private oea jdField_a_of_type_Oea;
  private int aMU;
  public int aMV = -1;
  private String aed;
  public String aee;
  private String aef;
  private String aeg;
  private String aeh;
  private String aei = "";
  private String aej = "";
  BroadcastReceiver ai = new lbt(this);
  public boolean aiS;
  private BroadcastReceiver aj = new lbu(this);
  public long algorithmId;
  private QQAppInterface app;
  private KandianRedDotInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private mhm jdField_b_of_type_Mhm;
  private KandianRedDotInfo jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  private mhm jdField_c_of_type_Mhm;
  private KandianRedDotInfo d;
  private HashMap<String, Boolean> dC = new HashMap();
  private Map<Long, String> ef = new HashMap();
  private AtomicLong g;
  private AtomicLong h;
  private List<a> hb = new ArrayList();
  private List<d> hc;
  private List<e> hd;
  private List<c> he;
  private ArrayList<Long> ks;
  public long tn;
  private Long u;
  
  public KandianMergeManager(QQAppInterface paramQQAppInterface)
  {
    QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
    this.app = paramQQAppInterface;
    aIx();
    this.K = new AtomicInteger(0);
    this.g = new AtomicLong(0L);
    this.O = new AtomicInteger(0);
    this.L = new AtomicInteger(0);
    this.h = new AtomicLong(0L);
    this.aef = "";
    this.M = new AtomicInteger(-1);
    this.N = new AtomicInteger(-1);
    kxh.aHI();
    kyi.aIg();
    qh();
    lat.prepare();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(258);
    if ((Looper.getMainLooper() == Looper.myLooper()) && (localAladdinConfig.getIntegerFromString("merge_manager_opt_switch", 0) == 1)) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.1(this));
    }
    for (;;)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Acfd);
      ThreadManager.executeOnSubThread(new KandianMergeManager.2(this));
      awiy.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$b);
      kyd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
      kvr.aHv();
      oej.register();
      mgt.aPc();
      kpe.clear();
      paramQQAppInterface.registObserver(this.jdField_a_of_type_Aklk);
      lvx.init();
      aIw();
      lde.preload();
      return;
      aIv();
    }
  }
  
  public static int a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
      } while (((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.frienduin, acbn.blx)));
      if ((paramMessageRecord.extInt == 1) && (TextUtils.equals(paramMessageRecord.frienduin, acbn.blx))) {
        return 0;
      }
      if ((paramMessageRecord.extInt == 2) && (TextUtils.equals(paramMessageRecord.frienduin, acbn.blx))) {
        return 1;
      }
      if (TextUtils.equals(paramMessageRecord.frienduin, acbn.blw)) {
        return 0;
      }
    } while ((paramMessageRecord.istroop != 1008) || (!nyn.h(paramQQAppInterface, paramMessageRecord.frienduin)));
    return 1;
  }
  
  private long a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    long l = 0L;
    paramKandian210Msg0xeeInfo = paramKandian210Msg0xeeInfo.notifyInfos.iterator();
    while (paramKandian210Msg0xeeInfo.hasNext()) {
      l = ((Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.next()).contextId;
    }
    return l;
  }
  
  private long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
      if (paramMessageRecord.structingMsg != null) {
        break label34;
      }
      QLog.d("KandianMergeManager", 1, "getArticleIDFromMessageRecord : struct msg body is null");
    }
    for (;;)
    {
      return 0L;
      label34:
      if ((paramMessageRecord.time >= this.g.get()) && (!TextUtils.isEmpty(paramMessageRecord.structingMsg.mArticleIds)))
      {
        paramMessageRecord = paramMessageRecord.structingMsg.mArticleIds.split("\\|");
        if (paramMessageRecord.length > 0) {
          try
          {
            if (!TextUtils.isEmpty(paramMessageRecord[0]))
            {
              long l = new BigInteger(paramMessageRecord[0]).longValue();
              return l;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            QLog.e("KandianMergeManager", 1, "getArticleIDFromMessageRecord has num format error : " + paramMessageRecord);
          }
        }
      }
    }
    return 0L;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {}
    while ((!paramBoolean) && ((paramMessageRecord.extInt == 3) || (paramMessageRecord.extInt == 4)) && (TextUtils.equals(paramMessageRecord.msg, paramString1))) {
      return null;
    }
    MessageRecord localMessageRecord = anbi.d(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, long paramLong, String paramString2)
  {
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.frienduin = acbn.bkN;
    localMessageRecord.senderuin = acbn.bkN;
    localMessageRecord.istroop = 7225;
    localMessageRecord.msg = paramString1;
    localMessageRecord.time = paramLong;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msg_id", paramString2);
      localMessageRecord.extStr = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.i("KandianMergeManager", 2, "createLockScreenInteractMessage, msg=" + paramString1 + ", msg_id=" + paramString2);
      }
      return localMessageRecord;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("KandianMergeManager", 1, "put msgId error, e=" + localJSONException.toString());
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.selfuin = this.app.getCurrentUin();
    a(localMessageRecord, paramString1, paramString2, paramInt);
    return localMessageRecord;
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.selfuin = this.app.getCurrentUin();
    localMessageRecord.frienduin = acbn.blx;
    localMessageRecord.senderuin = acbn.blw;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 6;
    if (awit.cA(this.app))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      localMessageRecord.isread = false;
      localMessageRecord.issend = 0;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong1;
      try
      {
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(aek, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          localMessageRecord.vipBubbleID = -999L;
          kxm.j(localMessageRecord);
          this.app.b().b(localMessageRecord, this.app.getCurrentUin());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(aek, paramString2);
          paramString1.put("strategy_id", paramLong2);
          paramString1.put("algorithm_id", paramLong3);
          paramString1.put("article_id", paramLong4);
          paramString1.put("folder_status", paramLong5);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
      }
    }
  }
  
  private MessageRecord a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    MessageRecord localMessageRecord = anbi.d(-1000);
    boolean bool = awit.aMK();
    localMessageRecord.selfuin = this.app.getCurrentUin();
    localMessageRecord.frienduin = acbn.blx;
    localMessageRecord.senderuin = acbn.blw;
    localMessageRecord.istroop = 7220;
    localMessageRecord.extInt = 5;
    if (awit.cA(this.app))
    {
      localMessageRecord.extLong |= 0x20000000;
      localMessageRecord.extLong |= 0x1;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localMessageRecord.extInt = 2;
        bool = awit.ub(paramString3);
      }
      localMessageRecord.issend = 0;
      localMessageRecord.isread = false;
      localMessageRecord.msg = paramString1;
      localMessageRecord.time = paramLong;
      try
      {
        this.aed = paramString3;
        if (TextUtils.isEmpty(localMessageRecord.extStr))
        {
          paramString1 = new JSONObject();
          paramString1.put(aek, paramString2);
          paramString1.put("kdUin", this.aed);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
        for (localMessageRecord.extStr = paramString1.toString();; localMessageRecord.extStr = paramString1.toString())
        {
          if (!BA()) {
            break label362;
          }
          localMessageRecord.vipBubbleID = -1000L;
          if ((localMessageRecord.vipBubbleID == -1000L) && (!paramBoolean1)) {
            localMessageRecord.extStr = null;
          }
          if (njn.a().ee(2000002)) {
            break label387;
          }
          paramString1 = this.app.b();
          kxm.j(localMessageRecord);
          paramString1.b(localMessageRecord, this.app.getCurrentUin());
          return localMessageRecord;
          localMessageRecord.extLong |= 0x2;
          break;
          paramString1 = new JSONObject(localMessageRecord.extStr);
          paramString1.put(aek, paramString2);
          paramString1.put("kdUin", this.aed);
          paramString1.put("kdShouldShowMergedAvatar", bool);
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          localMessageRecord.extStr = null;
        }
        label362:
        if (paramBoolean1) {}
        for (paramLong = -999L;; paramLong = -1000L)
        {
          localMessageRecord.vipBubbleID = paramLong;
          break;
        }
        label387:
        QLog.w("KandianMergeManager", 2, "app in push is showing, abandon 210 push update msg table!");
      }
    }
    return localMessageRecord;
  }
  
  private MessageRecord a(NamedNodeMap paramNamedNodeMap)
  {
    if (paramNamedNodeMap == null)
    {
      QLog.d("KandianMergeManager", 2, "parseRedPntInfoAndSave redInfoMap null ");
      return null;
    }
    String str1;
    String str2;
    label69:
    String str3;
    label97:
    String str4;
    label125:
    String str5;
    label153:
    String str6;
    if (paramNamedNodeMap.getNamedItem("orangeWord") != null)
    {
      str1 = paramNamedNodeMap.getNamedItem("orangeWord").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("brief") == null) {
        break label425;
      }
      str2 = paramNamedNodeMap.getNamedItem("brief").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("articleIds") == null) {
        break label431;
      }
      str3 = paramNamedNodeMap.getNamedItem("articleIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("algorithmIds") == null) {
        break label438;
      }
      str4 = paramNamedNodeMap.getNamedItem("algorithmIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("strategyIds") == null) {
        break label445;
      }
      str5 = paramNamedNodeMap.getNamedItem("strategyIds").getNodeValue();
      if (paramNamedNodeMap.getNamedItem("actionData") == null) {
        break label452;
      }
      str6 = paramNamedNodeMap.getNamedItem("actionData").getNodeValue();
      label181:
      if (paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue") == null) {
        break label459;
      }
    }
    label425:
    label431:
    label438:
    label445:
    label452:
    label459:
    for (paramNamedNodeMap = paramNamedNodeMap.getNamedItem("reportEventFolderStatusValue").getNodeValue();; paramNamedNodeMap = "")
    {
      this.aej = str3;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.16(this));
      MessageForStructing localMessageForStructing = (MessageForStructing)anbi.d(-2011);
      localMessageForStructing.msgtype = -2011;
      localMessageForStructing.structingMsg = anre.a();
      localMessageForStructing.structingMsg.mMsgServiceID = 142;
      localMessageForStructing.structingMsg.mMsgBrief = str2;
      localMessageForStructing.structingMsg.mOrangeWord = str1;
      localMessageForStructing.structingMsg.mArticleIds = str3;
      localMessageForStructing.structingMsg.mStrategyIds = str5;
      localMessageForStructing.structingMsg.mAlgorithmIds = str4;
      localMessageForStructing.structingMsg.reportEventFolderStatusValue = paramNamedNodeMap;
      localMessageForStructing.structingMsg.mMsgActionData = str6;
      localMessageForStructing.extInt = 1;
      localMessageForStructing.frienduin = acbn.blx;
      localMessageForStructing.selfuin = this.app.getCurrentUin();
      localMessageForStructing.senderuin = acbn.blw;
      localMessageForStructing.istroop = 7220;
      localMessageForStructing.issend = 0;
      localMessageForStructing.isread = false;
      localMessageForStructing.extLong = 0;
      localMessageForStructing.time = NetConnInfoCenter.getServerTime();
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.doPrewrite();
      return a(localMessageForStructing);
      str1 = "";
      break;
      str2 = "";
      break label69;
      str3 = "";
      break label97;
      str4 = "";
      break label125;
      str5 = "";
      break label153;
      str6 = "";
      break label181;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = acbn.blx;
    paramMessageRecord.senderuin = acbn.blx;
    paramMessageRecord.istroop = 7220;
    paramMessageRecord.msg = paramString1;
    for (;;)
    {
      try
      {
        paramMessageRecord.time = Long.parseLong(paramString2);
        paramMessageRecord.createMessageUniseq();
        if (paramInt == 0)
        {
          paramMessageRecord.extInt = 3;
          paramMessageRecord.extLong = 0;
          return;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
      if (paramInt == 1) {
        paramMessageRecord.extInt = 4;
      } else if (paramInt == 5) {
        paramMessageRecord.extInt = paramInt;
      } else {
        paramMessageRecord.extInt = 0;
      }
    }
  }
  
  private void a(mhm parammhm, long paramLong)
  {
    boolean bool = false;
    mhm localmhm = this.jdField_c_of_type_Mhm;
    if (localmhm != null)
    {
      if (localmhm != null) {
        QLog.d("KandianMergeManager", 1, "0x210Msg reached, oldSeq = " + localmhm.msgSeq + ", newSeq = " + parammhm.msgSeq);
      }
      if (localmhm.msgSeq >= parammhm.msgSeq)
      {
        if (localmhm.msgSeq != parammhm.msgSeq) {
          bool = true;
        }
        if (bool) {
          localmhm.msgCount += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0x210msg delay reach , has a latest msg , no cover! needAddCount : " + bool);
        }
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_Mhm != null) {
        parammhm.msgCount += this.jdField_c_of_type_Mhm.msgCount;
      }
      this.jdField_c_of_type_Mhm = parammhm;
      this.jdField_c_of_type_Mhm.msgTime = paramLong;
      this.jdField_c_of_type_Mhm.U(this.app);
      int i = 0;
      while (i < parammhm.kV.size())
      {
        a((MySelfNormalItemRedPointInfo)parammhm.kV.get(i));
        i += 1;
      }
    }
  }
  
  private void aIA()
  {
    ThreadManager.post(new KandianMergeManager.11(this), 8, null, false);
  }
  
  private void aII()
  {
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2;
    if (this.jdField_a_of_type_Mhm.aRL == 1)
    {
      localObject1 = this.jdField_a_of_type_Mhm.summary;
      localObject2 = this.jdField_a_of_type_Mhm.orangeWord;
      long l = this.jdField_a_of_type_Mhm.msgTime;
      if (this.jdField_a_of_type_Mhm.aRN == 0)
      {
        bool1 = true;
        localObject1 = a((String)localObject1, (String)localObject2, l, bool1, true, String.valueOf(this.jdField_a_of_type_Mhm.vi));
        this.u = Long.valueOf(this.jdField_a_of_type_Mhm.rX);
        this.aeg = this.jdField_a_of_type_Mhm.summary;
        a((MessageRecord)localObject1, true);
        this.jdField_b_of_type_Mhm = this.jdField_a_of_type_Mhm;
        this.jdField_b_of_type_Mhm.W(this.app);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Mhm.summary).append(", showInFolder : ");
      if (this.jdField_a_of_type_Mhm.aRL != 1) {
        break label322;
      }
    }
    label322:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", showLockScreen : ");
      bool1 = bool2;
      if (this.jdField_a_of_type_Mhm.aRM == 1) {
        bool1 = true;
      }
      QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_Mhm.aRN + ", msgSeq : " + this.jdField_a_of_type_Mhm.msgSeq + ", orangeWord : " + this.jdField_a_of_type_Mhm.orangeWord + ", msgCount : " + this.jdField_a_of_type_Mhm.msgCount);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("BID_TYPE", 2);
      b((MessageRecord)localObject1, mhm.aRQ, (Bundle)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void aIU()
  {
    try
    {
      this.jdField_a_of_type_Oea = new oea(BaseApplicationImpl.getContext(), 0, 0);
      this.jdField_a_of_type_Oea.a(new lbs(this));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      QLog.e("KandianMergeManager", 1, localSecurityException, new Object[0]);
    }
  }
  
  private void aIV()
  {
    if (this.jdField_a_of_type_Oea != null)
    {
      this.jdField_a_of_type_Oea.onDestroy();
      this.jdField_a_of_type_Oea = null;
    }
  }
  
  private void aIX()
  {
    if ((this.ks != null) && (this.ks.size() > 0)) {}
    for (long l = ((Long)this.ks.get(0)).longValue();; l = 0L)
    {
      eq(l);
      return;
    }
  }
  
  private void aIv()
  {
    lcd locallcd = (lcd)this.app.getManager(163);
    locallcd.b().a(0, 20, 9223372036854775807L, true);
    locallcd.b().a(56, 20, 9223372036854775807L, true);
    locallcd.b().a(70, 20, 9223372036854775807L, true);
    locallcd.b().a(kys.getChannelId(), 20, 9223372036854775807L, true);
    locallcd.b().qq(0);
    locallcd.b().aJs();
    locallcd.b().aJz();
    locallcd.b().aJh();
    lcm.aJY();
    aIU();
  }
  
  private void aIw()
  {
    ThreadManager.getFileThreadHandler().post(new KandianMergeManager.3(this));
  }
  
  private void aIx()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.4(this));
  }
  
  private void aIy()
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.5(this));
  }
  
  private void aIz()
  {
    if (this.app != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("qqplayer_exit_action");
      this.app.getApplication().getApplicationContext().registerReceiver(this.aj, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private MessageRecord b()
  {
    Object localObject1 = null;
    altq localaltq = (altq)this.app.getManager(36);
    if (localaltq == null)
    {
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | RedTouchManager is null ");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = localaltq.getAppInfoByPath("1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    localObject2 = localaltq.b(7, "1130");
    if (localObject2 != null) {
      localArrayList.add(localObject2);
    }
    QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | receive a red point push notify, size : " + localArrayList.size());
    int i = 0;
    Object localObject5;
    if (i < localArrayList.size())
    {
      localObject5 = (BusinessInfoCheckUpdate.AppInfo)localArrayList.get(i);
      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | parse redPntInfo type :  " + ((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get());
      localObject2 = Aladdin.getConfig(186);
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get() == 5) {
        if (((AladdinConfig)localObject2).getIntegerFromString("use_new_route", 0) == 0)
        {
          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | use old route, skip parse num push info");
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break;
      localObject2 = localObject1;
      if (((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get() != null)
      {
        localObject2 = localObject1;
        if (((BusinessInfoCheckUpdate.RedDisplayInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get()).red_type_info.get() != null)
        {
          localObject5 = (BusinessInfoCheckUpdate.RedDisplayInfo)((BusinessInfoCheckUpdate.AppInfo)localObject5).red_display_info.get();
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject5 = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.RedDisplayInfo)localObject5).tab_display_info.get();
            localObject2 = localObject1;
            if (localObject5 != null)
            {
              localObject5 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject5).red_content.get();
              Object localObject6 = localaltq.ai(1130);
              localObject2 = localObject1;
              if (localObject6 != null)
              {
                localObject2 = localObject1;
                if (!((List)localObject6).isEmpty())
                {
                  localObject2 = new ArrayList((Collection)localObject6);
                  int k = ((List)localObject2).size();
                  localObject6 = new long[k];
                  int j = 0;
                  if (j < k)
                  {
                    BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((List)localObject2).get(j);
                    if (localNumRedPath == null) {}
                    for (;;)
                    {
                      j += 1;
                      break;
                      localObject6[j] = localNumRedPath.uint64_msgid.get();
                    }
                  }
                  localaltq.a((long[])localObject6, "kandian_num_red_pnt_buffer", new lbp(this));
                  QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | numRedPoint num: " + (String)localObject5 + ", extraNum : " + localaltq.iK(1130) + ", lastMsgID : " + localObject6[(localObject6.length - 1)]);
                  localObject2 = localObject1;
                  continue;
                  localObject2 = localObject1;
                  if (((BusinessInfoCheckUpdate.AppInfo)localObject5).type.get() == 0)
                  {
                    localObject2 = localObject1;
                    if (((BusinessInfoCheckUpdate.AppInfo)localObject5).buffer.has())
                    {
                      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)localObject5).buffer.get();
                      QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | buffer jsonStr " + (String)localObject2);
                      try
                      {
                        localObject2 = new JSONObject((String)localObject2);
                        localObject5 = ((JSONObject)localObject2).optString("_show_mission");
                        localObject2 = new JSONObject(new JSONObject(((JSONObject)localObject2).optString("param")).optString((String)localObject5)).optString("_red_ext_kd_push_msg_xml");
                        QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | kandian redpoint xmlContent " + (String)localObject2);
                        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject2).getBytes("utf-8"))).getElementsByTagName("msg").item(0);
                        if (localObject2 == null) {
                          break label991;
                        }
                        localObject2 = ((Node)localObject2).getAttributes();
                        if (localObject2 == null) {
                          break label991;
                        }
                        if ((((NamedNodeMap)localObject2).getNamedItem("articleIds") != null) && (!TextUtils.isEmpty(this.aej)) && (this.aej.equalsIgnoreCase(((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue())))
                        {
                          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify | duplicate redPntInfo | mLastRedTouchInfoArticleId " + this.aej + " ; duplicateArticleId: " + ((NamedNodeMap)localObject2).getNamedItem("articleIds").getNodeValue());
                          localObject2 = localObject1;
                        }
                      }
                      catch (Exception localException1) {}
                      for (;;)
                      {
                        QLog.e("KandianMergeManager", 1, "handlerRedPntCenterNotify JSONException " + localException1);
                        Object localObject3 = localObject1;
                        break;
                        localObject3 = a((NamedNodeMap)localObject3);
                        localObject1 = localObject3;
                        try
                        {
                          localObject5 = new StringBuilder().append("handlerRedPntCenterNotify | parseRedPntInfoAndSave ");
                          if (localObject1 != null) {}
                          for (localObject3 = "succeed";; localObject3 = "failed")
                          {
                            QLog.d("KandianMergeManager", 1, (String)localObject3);
                            localObject3 = localObject1;
                            if (localObject1 == null) {
                              break;
                            }
                            localObject3 = localObject1;
                            if (this.app == null) {
                              break;
                            }
                            this.app.b().b(localObject1, this.app.getCurrentUin());
                            localObject3 = localObject1;
                            break;
                          }
                          QLog.d("KandianMergeManager", 1, "handlerRedPntCenterNotify end !");
                          return localObject1;
                        }
                        catch (Exception localException2) {}
                      }
                      label991:
                      Object localObject4 = localObject1;
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
  
  private void b(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (this.he != null)
    {
      Iterator localIterator = this.he.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramMessageRecord, paramInt, paramBundle);
      }
    }
  }
  
  private boolean dH(String paramString)
  {
    if ((ReadinjoyTabFrame.Dx()) && (!kfv.zj())) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "isNeedToBlockPushRedPoint, ret = ", Boolean.valueOf(bool), ", tag = ", paramString });
      return bool;
    }
  }
  
  private void eq(long paramLong)
  {
    try
    {
      String str = new kxm.b().c(paramLong).build();
      kbp.a(null, "", "0X8009A8A", "0X8009A8A", 0, 0, "", "", "", str, false);
      QLog.d("KandianMergeManager", 2, new Object[] { "reportAbandonPushRedPoint action = 0X8009A8A, r5 = ", str });
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("KandianMergeManager", 1, "reportAbandonPushRedPoint exception.");
    }
  }
  
  private void f(MessageRecord paramMessageRecord)
  {
    if (this.he != null)
    {
      Iterator localIterator = this.he.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).f(paramMessageRecord);
      }
    }
  }
  
  private void qh()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = awit.b(this.app, 1);
    this.aej = localSharedPreferences.getString("kandian_red_touch_pnt_article_id", "");
    QLog.d("KandianMergeManager", 1, "initCache mLastRedTouchInfoArticleId : " + this.aej);
    Object localObject = localSharedPreferences.getString("kandian_push_msg_xml", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = anre.a(aqoj.ag((String)localObject));
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mArticleIds))
      {
        String[] arrayOfString = ((AbsStructMsg)localObject).mArticleIds.split("\\|");
        this.ks = new ArrayList();
        while (i < arrayOfString.length)
        {
          this.ks.add(Long.valueOf(arrayOfString[i]));
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData)) {
        this.aee = ((AbsStructMsg)localObject).mMsgActionData;
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mAlgorithmIds)) {
        this.algorithmId = Long.parseLong(localObject.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((AbsStructMsg)localObject).mStrategyIds)) {
        this.tn = Long.parseLong(localObject.mStrategyIds.split("\\|")[0]);
      }
      this.K.set(1);
      l = localSharedPreferences.getLong("kandian_push_msg_time", 0L);
      this.g.set(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l;
        localException.printStackTrace();
      }
    }
    this.aeg = "";
    this.aeh = "";
    this.u = Long.valueOf(-1L);
    l = localSharedPreferences.getLong("subscribe_push_msg_time", 0L);
    if (l > 0L)
    {
      this.h.set(l);
      this.aef = localSharedPreferences.getString("subscribe_push_msg_uin", "");
      this.M.set(localSharedPreferences.getInt("subscribe_push_msg_status", -1));
      this.N.set(localSharedPreferences.getInt("subscribe_push_msg_msgtype", -1));
      if ((this.M.get() != 3) && (this.M.get() != -1)) {
        this.L.set(1);
      }
    }
    this.jdField_a_of_type_Mhm$a = mhm.a.a();
    this.jdField_a_of_type_Mhm = mhm.b();
    this.jdField_b_of_type_Mhm = mhm.c();
    this.jdField_c_of_type_Mhm = mhm.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = KandianMsgBoxRedPntInfo.getRedPntInfoFromSp();
    QLog.d("KandianMergeManager", 1, "init msgbox info from sp. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = Kandian210Msg0xeeInfo.getKandian210Msg0xeeInfoFromSp(this.app);
    QLog.d("KandianAppInPush", 2, "init app push info from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
    if (this.jdField_b_of_type_Mhm != null)
    {
      this.u = Long.valueOf(this.jdField_b_of_type_Mhm.rX);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Mhm.summary)) {
        this.aeg = this.jdField_b_of_type_Mhm.summary;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = ((KandianSetTopInfo)kxm.a(this.app, "kandian_msgtab_settop", true));
    QLog.d("KandianMergeManager.SETTOP", 2, "get from cache : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo);
    aIA();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.app, "kandian_video_tab_reddot_info", true);
    QLog.d("KandianMergeManager", 1, "init mianVideoTabRed : " + this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.getRedDotFromDisk(this.app, "kandian_red_pnt_lock_screen", true);
    QLog.d("KandianMergeManager", 2, "lock screen push info : " + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.executeOnSubThread(new KandianMergeManager.9(this));
  }
  
  public boolean BA()
  {
    MessageRecord localMessageRecord = this.app.b().d(acbn.blx, 7220);
    if ((localMessageRecord == null) || (localMessageRecord.isread)) {}
    while (localMessageRecord.vipBubbleID != -1000L) {
      return false;
    }
    return true;
  }
  
  public boolean BB()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null;
  }
  
  public boolean BC()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SplashActivity");
    if ((BaseActivity.sTopActivity != null) && ((kxm.getAppRuntime() instanceof QQAppInterface)) && (!FrameHelperActivity.bHr))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      String str = localBaseActivity.getClass().getSimpleName();
      if (localArrayList.contains(str))
      {
        if ("SplashActivity".equals(str))
        {
          if (SplashActivity.bKT != 1) {
            return false;
          }
          if (((SplashActivity)localBaseActivity).getCurrentTab() == MainFragment.bIq) {
            return false;
          }
        }
        if (this.dC.get(str) != null) {
          return ((Boolean)this.dC.get(str)).booleanValue();
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean BD()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead);
  }
  
  /* Error */
  public boolean BE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:hb	Ljava/util/List;
    //   6: invokeinterface 1011 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	KandianMergeManager
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public boolean Bv()
  {
    return this.K.get() > 0;
  }
  
  public boolean Bw()
  {
    if (!awit.cA(this.app)) {}
    do
    {
      return false;
      QLog.d("KandianMergeManager", 1, "SubUnread : " + this.L.get() + ", SubStatus : " + this.M.get() + ", mSubTitle : " + kxm.ev(this.aeg) + ", KDUnread : " + this.K.get());
    } while ((this.K.get() <= 0) && ((this.L.get() <= 0) || (this.M.get() != 1)) && ((this.L.get() > 0) || (this.M.get() != 3) || ((!awit.cD(this.app)) && (ocp.n(this.app, this.aef)))));
    if ((awit.Vs()) && (this.K.get() <= 0) && (this.u.longValue() <= 0L) && (TextUtils.isEmpty(this.aeh)))
    {
      QLog.d("KandianMergeManager", 2, "subscribe push has not article id , give up auto refresh! only for kandian tab");
      return false;
    }
    return true;
  }
  
  public boolean Bx()
  {
    return !kxm.e(this.app);
  }
  
  public boolean By()
  {
    return false;
  }
  
  public boolean Bz()
  {
    return false;
  }
  
  public void K(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = localMsgBody.uint64_seq.get();
      long l2 = this.jdField_a_of_type_Mhm$a.msgSeq;
      QLog.d("KandianMergeManager", 1, "biu 0x210Msg reached, oldSeq = " + l2 + ", newSeq = " + l1);
      if (l2 >= l1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "biu 0x210Msg delay reached, no updated!");
        }
      }
      else if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.has()) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get() != null) && (((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.has()))
      {
        l2 = ((submsgtype0xc5.BiuBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_biu_body.get()).uint64_biu_uin.get();
        this.jdField_a_of_type_Mhm$a.msgSeq = l1;
        this.jdField_a_of_type_Mhm$a.vj = l2;
        this.jdField_a_of_type_Mhm$a.status = 0;
        this.jdField_a_of_type_Mhm$a.Y(this.app);
        QLog.d("KandianMergeManager", 1, "has biu 0x210 msg push, seq = " + l1 + ", uin = " + l2);
        b(null, mhm.aRQ, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void W(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1)
    {
      i = 1;
      this.aMV = i;
      if ((!paramBoolean2) || (!this.aiS)) {
        break label28;
      }
    }
    label28:
    acxw localacxw;
    RecentUser localRecentUser;
    do
    {
      return;
      i = 0;
      break;
      localacxw = this.app.a().a();
      localRecentUser = localacxw.b(acbn.blx, 7220);
    } while ((localRecentUser == null) && (!paramBoolean1) && (paramBoolean2 == true));
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      localObject = new RecentUser(acbn.blx, 7220);
      ((RecentUser)localObject).lastmsgtime = NetConnInfoCenter.getServerTime();
    }
    if (paramBoolean1) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localacxw.e((RecentUser)localObject);
      localObject = this.app.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (paramBoolean2) {
        break;
      }
      mT(paramBoolean1);
      return;
    }
  }
  
  public boolean Z(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KandianMergeManager", 2, "erasureTabRedWhenSwitchTab from: " + paramInt1 + ", to: " + paramInt2);
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {}
    do
    {
      return false;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return true;
      }
      if ((paramInt1 != 1) && (paramInt2 == 1))
      {
        if (de(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.29(this));
        }
        ql(1);
        return true;
      }
      if ((paramInt1 == 1) && (paramInt2 == 1))
      {
        if (de(1) > 0) {
          ThreadManager.getSubThreadHandler().post(new KandianMergeManager.30(this));
        }
        ql(1);
        return true;
      }
      if (paramInt2 == 2)
      {
        ql(2);
        return true;
      }
    } while ((paramInt2 != 3) || (de(3) <= 0));
    return false;
  }
  
  public KandianMsgBoxRedPntInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo;
  }
  
  public MySelfNormalItemRedPointInfo a(int paramInt)
  {
    Object localObject1 = awit.a(this.app, true, true).getString("kandian_myself_red_point" + paramInt, "");
    Object localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = null;
    }
    Object localObject2;
    do
    {
      return localObject3;
      localObject1 = new ByteArrayInputStream(Base64.decode(((String)localObject1).getBytes(), 0));
      try
      {
        localObject1 = (MySelfNormalItemRedPointInfo)new ObjectInputStream((InputStream)localObject1).readObject();
        if (localObject1 == null) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("KandianMergeManager", 2, "getMySelfRedPointInfo:" + localException.toString());
          }
          localObject2 = null;
        }
        if (localObject2.failureTime < System.currentTimeMillis() / 1000L)
        {
          qm(paramInt);
          return null;
        }
        localObject3 = localObject2;
      }
    } while (localObject2.effectTime <= System.currentTimeMillis() / 1000L);
    return null;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.app == null))
    {
      localObject1 = null;
      return localObject1;
    }
    if ((a(paramMessageRecord, this.app) == 0) && (kxm.e(this.app))) {
      return null;
    }
    if (njn.a().ee(2000002))
    {
      QLog.d("KandianMergeManager", 2, "app in push is showing, abandon the new msg !");
      return null;
    }
    if ((kxm.e(paramMessageRecord)) && (kxm.g(paramMessageRecord)))
    {
      QLog.d("KandianMergeManager", 1, "receive daily lock screen red point push ! mr : " + paramMessageRecord);
      ((KandianDailyManager)this.app.getManager(296)).k(paramMessageRecord);
      return null;
    }
    if (!h(paramMessageRecord)) {
      return null;
    }
    QQMessageFacade localQQMessageFacade = this.app.b();
    if (localQQMessageFacade != null) {}
    label559:
    label595:
    label610:
    Object localObject2;
    label680:
    label958:
    for (Object localObject1 = localQQMessageFacade.d(acbn.blx, 7220);; localObject2 = null)
    {
      Object localObject4;
      Object localObject3;
      if ((localObject1 != null) && (a(paramMessageRecord, this.app) == 1) && (((MessageRecord)localObject1).extInt == 2) && (!((MessageRecord)localObject1).isread)) {
        if (QLog.isColorLevel())
        {
          localObject4 = "lastMr_info 【" + "msg: " + kxm.ev(((MessageRecord)localObject1).msg) + ", msguid : " + ((MessageRecord)localObject1).msgUid;
          localObject3 = localObject4;
          if ((localObject1 instanceof MessageForStructing))
          {
            localMessageForStructing = (MessageForStructing)localObject1;
            localMessageForStructing.parse();
            localObject3 = localObject4;
            if (localMessageForStructing.structingMsg != null) {
              localObject3 = (String)localObject4 + ", title : " + kxm.ev(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
            }
          }
          localObject4 = "newMr_info 【" + "msg: " + kxm.ev(paramMessageRecord.msg) + ", senderUin : " + paramMessageRecord.senderuin + " , msguid : " + paramMessageRecord.msgUid;
          if (!(paramMessageRecord instanceof MessageForStructing)) {
            break label990;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
          localMessageForStructing.parse();
          if (localMessageForStructing.structingMsg == null) {
            break label990;
          }
          localObject4 = (String)localObject4 + ", title : " + kxm.ev(localMessageForStructing.structingMsg.mMsgBrief) + " 】";
        }
      }
      int i;
      label833:
      label985:
      label990:
      for (;;)
      {
        QLog.i("KandianMergeManager", 2, "subscribe push msg cover ! \n" + (String)localObject3 + "\n" + (String)localObject4);
        localQQMessageFacade.b((MessageRecord)localObject1, false);
        localObject4 = anbi.d(paramMessageRecord.msgtype);
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject4, paramMessageRecord);
        ((MessageRecord)localObject4).frienduin = acbn.blx;
        ((MessageRecord)localObject4).istroop = 7220;
        i = a(paramMessageRecord, this.app);
        if (i == 0)
        {
          ((MessageRecord)localObject4).extInt = 1;
          a((MessageRecord)localObject4, 0);
          if (!awit.cA(this.app)) {
            break label900;
          }
          ((MessageRecord)localObject4).extLong |= 0x20000000;
          ((MessageRecord)localObject4).extLong |= 0x1;
          if (!BA()) {
            break label915;
          }
          ((MessageRecord)localObject4).vipBubbleID = -1000L;
        }
        try
        {
          if (!(localObject4 instanceof MessageForStructing)) {
            break label833;
          }
          localObject1 = (MessageForStructing)localObject4;
          ((MessageForStructing)localObject1).parse();
          if (((MessageForStructing)localObject1).structingMsg == null) {
            break label833;
          }
          localObject1 = new JSONObject(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
          if (!((JSONObject)localObject1).has("showMergedAvatar")) {
            break label985;
          }
          if (((JSONObject)localObject1).getInt("showMergedAvatar") != 1) {
            break label926;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            boolean bool;
            localException.printStackTrace();
            continue;
            if (i == 1)
            {
              g((MessageRecord)localObject4);
              aIM();
              continue;
              localObject2 = null;
              continue;
              continue;
              bool = false;
            }
          }
        }
        if (((JSONObject)localObject1).has("uin")) {
          this.aed = ((JSONObject)localObject1).getString("uin");
        }
        if (((JSONObject)localObject1).has("biuUin"))
        {
          this.aed = ((JSONObject)localObject1).getString("biuUin");
          bool = awit.aMJ();
          if (((JSONObject)localObject1).has("defaultAvatarUrl"))
          {
            localObject1 = ((JSONObject)localObject1).getString("defaultAvatarUrl");
            if (TextUtils.isEmpty(((MessageRecord)localObject4).extStr)) {}
            for (localObject3 = new JSONObject();; localObject3 = new JSONObject(((MessageRecord)localObject4).extStr))
            {
              if (!TextUtils.isEmpty(this.aed)) {
                ((JSONObject)localObject3).put("kdUin", this.aed);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                ((JSONObject)localObject3).put("kdDefaultSourceAvatarUrl", localObject1);
              }
              ((JSONObject)localObject3).put("kdShouldShowMergedAvatar", bool);
              ((MessageRecord)localObject4).extStr = ((JSONObject)localObject3).toString();
              if (i != 0) {
                break label958;
              }
              f((MessageRecord)localObject4);
              kxm.j((MessageRecord)localObject4);
              localObject1 = localObject4;
              if (!kxm.e(paramMessageRecord)) {
                break;
              }
              ThreadManager.post(new KandianMergeManager.17(this), 8, null, false);
              return localObject4;
              if (i == 1)
              {
                ((MessageRecord)localObject4).extInt = 2;
                break label559;
              }
              ((MessageRecord)localObject4).extInt = 0;
              break label559;
              ((MessageRecord)localObject4).extLong |= 0x2;
              break label595;
              ((MessageRecord)localObject4).vipBubbleID = -999L;
              break label610;
              bool = false;
              break label680;
            }
          }
        }
      }
    }
  }
  
  public MessageRecord a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)anbi.d(-2011);
    localMessageForStructing.istroop = 7220;
    localMessageForStructing.selfuin = this.app.getCurrentUin();
    localMessageForStructing.frienduin = acbn.blx;
    localMessageForStructing.senderuin = acbn.blw;
    localMessageForStructing.time = kxm.a(this.app);
    localMessageForStructing.isread = false;
    localMessageForStructing.issend = 0;
    localMessageForStructing.extInt = 1;
    localMessageForStructing.extLong |= 0x20000000;
    localMessageForStructing.extLong |= 0x1;
    localMessageForStructing.structingMsg = anre.a(this.app, localMessageForStructing.istroop, Long.valueOf(localMessageForStructing.senderuin).longValue(), paramString.getBytes(), 0);
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    localMessageForStructing.msg = localMessageForStructing.structingMsg.mMsgBrief;
    localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
    a(localMessageForStructing, 1);
    if (!h(localMessageForStructing)) {
      return null;
    }
    paramString = this.app.b();
    kxm.j(localMessageForStructing);
    paramString.b(localMessageForStructing, this.app.getCurrentUin());
    return localMessageForStructing;
  }
  
  public void a(acza paramacza)
  {
    a(paramacza);
    a(paramacza);
    a(paramacza);
    lcc.a().b(paramacza);
  }
  
  public void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        this.hb.add(parama);
      }
      finally {}
    }
  }
  
  public void a(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.he == null) {
          this.he = new ArrayList();
        }
        QLog.d("KandianMergeManager", 2, "add MsgObserver " + paramc.getClass().getSimpleName() + ", " + paramc);
        if (this.he.contains(paramc)) {
          continue;
        }
        this.he.add(paramc);
      }
      finally {}
    }
  }
  
  public void a(d paramd)
  {
    if (paramd == null) {}
    do
    {
      return;
      if (this.hc == null) {
        this.hc = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + paramd.getClass().getSimpleName() + ", " + paramd);
    } while (this.hc.contains(paramd));
    this.hc.add(paramd);
  }
  
  public void a(e parame)
  {
    if (parame == null) {}
    do
    {
      return;
      if (this.hd == null) {
        this.hd = new CopyOnWriteArrayList();
      }
      QLog.d("KandianMergeManager", 2, "add tabRedNumChangeObserver " + parame.getClass().getSimpleName() + ", " + parame);
    } while (this.hd.contains(parame));
    this.hd.add(parame);
  }
  
  public void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (paramKandianMsgBoxRedPntInfo.mSeq <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSeq) && ((this.aei == null) || (this.aei.isEmpty()))) {}
    for (int i = 1; (paramKandianMsgBoxRedPntInfo == null) || (paramKandianMsgBoxRedPntInfo.mMsgCnt <= 0) || (i != 0); i = 0)
    {
      QLog.d("KandianMergeManager", 1, new Object[] { "new msgbox red info has error, local : ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo, "new : ", paramKandianMsgBoxRedPntInfo });
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo = paramKandianMsgBoxRedPntInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
    this.aei = "";
    String str;
    long l;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mNeedShowInFolder)
    {
      paramKandianMsgBoxRedPntInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mSummary;
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mOrangeWord;
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgTime;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mRedType == 0) {
        bool = true;
      }
    }
    for (paramKandianMsgBoxRedPntInfo = a(paramKandianMsgBoxRedPntInfo, str, l, bool, false, null);; paramKandianMsgBoxRedPntInfo = null)
    {
      b(paramKandianMsgBoxRedPntInfo, mhm.aRP, null);
      aIM();
      QLog.d("KandianMergeManager", 1, "update msgbox redpnt info. " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
      return;
      bool = false;
      break;
    }
  }
  
  public void a(MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo)
  {
    ThreadManager.getSubThreadHandler().post(new KandianMergeManager.35(this, paramMySelfNormalItemRedPointInfo));
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord == null) {
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramMessageRecord.extStr))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("kandian_push_from", paramInt);
        paramMessageRecord.extStr = localJSONObject.toString();
        return;
      }
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
    localJSONObject.put("kandian_push_from", paramInt);
    paramMessageRecord.extStr = localJSONObject.toString();
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || ((paramInt != 0) && (paramInt != 1))) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      do
      {
        return;
      } while (paramInt == 1);
      localQQMessageFacade = this.app.b();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new KandianMergeManager.12(this, localQQMessageFacade, paramString1, paramString2, paramInt, paramBoolean), 10, null, false);
  }
  
  public void a(boolean paramBoolean, Class paramClass)
  {
    this.dC.put(paramClass.getSimpleName(), Boolean.valueOf(paramBoolean));
    String str = paramClass.getSimpleName();
    if (BaseActivity.sTopActivity != null) {}
    for (paramClass = BaseActivity.sTopActivity.getClass().getSimpleName();; paramClass = "")
    {
      if (TextUtils.equals(str, paramClass))
      {
        if (!paramBoolean) {
          break;
        }
        aIQ();
      }
      return;
    }
    njn.a().pM(false);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, tos paramtos)
  {
    int i = mhm.q(paramArrayOfByte);
    QLog.i("KandianMergeManager", 1, "processMsg0x210Sub0xc5, receiveMsg bidType= " + i);
    if (i == 2)
    {
      paramArrayOfByte = mhm.a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "process 0x210 follow msg fail!");
        }
      }
    }
    Object localObject;
    boolean bool1;
    label360:
    label489:
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
              paramtos = this.jdField_a_of_type_Mhm;
              if ((paramtos == null) || (paramtos.msgSeq <= paramArrayOfByte.msgSeq)) {
                break label597;
              }
              if (paramArrayOfByte.aRL != 1) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach showFolder, has a latest msg , no cover! + oldMsg.msgSeq" + paramtos.msgSeq + "msg.msgSeq:" + paramArrayOfByte.msgSeq + "brief : " + paramArrayOfByte.summary);
              }
              if ((this.jdField_b_of_type_Mhm == null) || (paramArrayOfByte.msgSeq > this.jdField_b_of_type_Mhm.msgSeq))
              {
                if ((this.jdField_b_of_type_Mhm != null) && (QLog.isColorLevel())) {
                  QLog.d("KandianMergeManager", 2, "upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Mhm.msgSeq + "msg.msgSeq:" + paramArrayOfByte.msgSeq);
                }
                paramtos = paramArrayOfByte.summary;
                localObject = paramArrayOfByte.orangeWord;
                paramLong = paramArrayOfByte.msgTime;
                if (paramArrayOfByte.aRN == 0)
                {
                  bool1 = true;
                  paramtos = a(paramtos, (String)localObject, paramLong, bool1, true, String.valueOf(paramArrayOfByte.vi));
                  a(paramtos, true);
                  this.jdField_b_of_type_Mhm = paramArrayOfByte;
                  this.jdField_b_of_type_Mhm.W(this.app);
                  if (QLog.isColorLevel())
                  {
                    paramArrayOfByte = new StringBuilder().append("has 0x210 follow msg push , brief : ").append(this.jdField_a_of_type_Mhm.summary).append(", showInFolder : ");
                    if (this.jdField_a_of_type_Mhm.aRL != 1) {
                      break label483;
                    }
                    bool1 = true;
                    paramArrayOfByte = paramArrayOfByte.append(bool1).append(", showLockScreen : ");
                    if (this.jdField_a_of_type_Mhm.aRM != 1) {
                      break label489;
                    }
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d("KandianMergeManager", 1, bool1 + ", redType : " + this.jdField_a_of_type_Mhm.aRN + ", msgSeq : " + this.jdField_a_of_type_Mhm.msgSeq + ", orangeWord : " + this.jdField_a_of_type_Mhm.orangeWord + ", msgCount : " + this.jdField_a_of_type_Mhm.msgCount);
                  b(paramtos, mhm.aRQ, null);
                  return;
                  bool1 = false;
                  break;
                  bool1 = false;
                  break label360;
                }
              }
            } while (!QLog.isColorLevel());
            QLog.d("KandianMergeManager", 2, "no upDate ox210ShowInFolderFollowPushMsg.msgSeq" + this.jdField_b_of_type_Mhm.msgSeq + "msg.msgSeq:" + paramArrayOfByte.msgSeq);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("KandianMergeManager", 2, "0x210msgc5 delay reach discarded,  + oldMsg.msgSeq" + paramtos.msgSeq + "msg.msgSeq:" + paramArrayOfByte.msgSeq);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("KandianMergeManager", 2, "0x210msgc5 nomel , msg.msgSeq:" + paramArrayOfByte.msgSeq);
          }
          this.jdField_a_of_type_Mhm = paramArrayOfByte;
          this.jdField_a_of_type_Mhm.msgTime = paramLong;
          this.jdField_a_of_type_Mhm.V(this.app);
          aII();
          return;
          i = mhm.o(paramArrayOfByte);
        } while (i == mhm.aRO);
        if (i == mhm.aRQ)
        {
          K(paramArrayOfByte);
          return;
        }
        localObject = mhm.a(paramArrayOfByte);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("KandianMergeManager", 2, "process 0x210 msg fail!");
      return;
      i = mhm.p(paramArrayOfByte);
    } while (i == mhm.aRR);
    label483:
    boolean bool2;
    label597:
    boolean bool3;
    if ((i == mhm.aRS) || (i == mhm.aRT))
    {
      lbz.a().ar(0, "");
      bool2 = kxm.g(this.app);
      bool3 = kxm.AZ();
      if (((!bool2) && (!bool3)) || (((mhm)localObject).aRM != 1) || (!((Boolean)awit.f("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())) {
        break label1019;
      }
      bool1 = true;
      label810:
      if (bool1)
      {
        paramArrayOfByte = a(((mhm)localObject).summary, ((mhm)localObject).msgTime, ((mhm)localObject).msgId);
        this.app.b().a(paramArrayOfByte, this.app.getCurrentUin(), false, false, true, false);
        paramtos.a("handleGetKandian210Message", true, 1, true, false);
        if ((kxm.nZ() != 1) && (kxm.nX() == 2)) {
          break label1025;
        }
      }
    }
    label1025:
    for (i = 3;; i = 1)
    {
      kbp.bp("0X80081DC", new kxm.b().a("uin", this.app.getCurrentAccountUin()).a("load_mode", Integer.valueOf(i)).a("push_type", Integer.valueOf(9)).build());
      QLog.i("KandianMergeManager", 1, "isAppBackground=" + bool2 + ",needNotificationForeground" + bool3 + ",showLockScreen=" + ((mhm)localObject).aRM + ",needShow=" + bool1);
      return;
      if (i != mhm.aRU) {
        break;
      }
      a((mhm)localObject, paramLong);
      break;
      label1019:
      bool1 = false;
      break label810;
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        long l = paramMessageRecord.time;
        String str = paramMessageRecord.senderuin;
        int j = paramMessageRecord.msgtype;
        Object localObject2 = "";
        if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("kandian_replace_subscribe_msg")))
        {
          paramMessageRecord = (lcd)this.app.getManager(163);
          if (paramMessageRecord != null) {
            paramMessageRecord.b().es(this.app.getLongAccountUin());
          }
          paramBoolean = false;
          return paramBoolean;
        }
        if (l > this.h.get())
        {
          if (!paramBoolean)
          {
            this.aeg = "";
            this.aeh = "";
            this.u = Long.valueOf(-1L);
            if (ocp.f(this.app, str, paramMessageRecord.msgtype))
            {
              bool = true;
              localObject1 = "";
              this.h.set(l);
              this.L.set(1);
              this.aef = str;
              this.M.set(1);
              this.N.set(j);
              if ((paramBoolean) || (!awit.Vs())) {
                aIG();
              }
              ThreadManager.getSubThreadHandler().post(new KandianMergeManager.20(this, l, str, 1, (String)localObject1, j));
              QLog.d("KandianMergeManager", 1, "subscribe push, title : " + this.aeg + ", id : " + this.u + ", msguid : " + paramMessageRecord.msgUid + ", isInterestedAccount : " + bool);
              paramBoolean = true;
              continue;
            }
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              Object localObject3 = (MessageForStructing)paramMessageRecord;
              ((MessageForStructing)localObject3).parse();
              if (((MessageForStructing)localObject3).structingMsg == null) {
                break label518;
              }
              localObject1 = aqoj.C(((MessageForStructing)localObject3).structingMsg.getBytes());
              this.aeg = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
              if (!TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mInnerUniqIds))
              {
                localObject2 = ((MessageForStructing)localObject3).structingMsg.mInnerUniqIds.split("\\|");
                k = localObject2.length;
                i = 0;
                if (i >= k) {
                  break label525;
                }
                localObject3 = localObject2[i];
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label531;
                }
                this.aeh = ((String)localObject3);
                break label525;
              }
              localObject2 = localObject1;
              if (TextUtils.isEmpty(((MessageForStructing)localObject3).structingMsg.mArticleIds)) {
                break label518;
              }
              localObject3 = ((MessageForStructing)localObject3).structingMsg.mArticleIds.split("\\|");
              int k = localObject3.length;
              i = 0;
              localObject2 = localObject1;
              if (i >= k) {
                break label518;
              }
              localObject2 = localObject3[i];
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label538;
              }
              this.u = Long.valueOf((String)localObject2);
              break label525;
            }
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "parse subscribe push struct msg fail !");
            }
          }
          bool = false;
          localObject1 = "";
          continue;
        }
        else
        {
          paramBoolean = false;
          continue;
        }
        Object localObject1 = localObject2;
      }
      finally {}
      label518:
      label525:
      boolean bool = false;
      continue;
      label531:
      i += 1;
      continue;
      label538:
      i += 1;
    }
  }
  
  public List<Long> aA()
  {
    ArrayList localArrayList = new ArrayList();
    if (!awit.cA(this.app)) {}
    while (this.K.get() == 0) {
      return localArrayList;
    }
    if ((this.ks != null) && (!this.ks.isEmpty())) {
      localArrayList.addAll(this.ks);
    }
    if ((this.ks != null) && (!this.ks.isEmpty()))
    {
      localArrayList.add(Long.valueOf(this.algorithmId));
      localArrayList.add(Long.valueOf(this.tn));
    }
    QLog.i("KandianMergeManager", 1, "getKandianArticleIdsWhenRefreshKandian: " + localArrayList.toString());
    return localArrayList;
  }
  
  public List<a> aB()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.hb);
      this.hb.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aIB()
  {
    altq localaltq = (altq)this.app.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("1130");
    if (localAppInfo != null) {
      localaltq.e(localAppInfo, "");
    }
    localAppInfo = localaltq.b(7, "1130");
    if (localAppInfo != null) {
      localaltq.e(localAppInfo, "");
    }
    QLog.d("KandianMergeManager", 1, "reportRedPntExposure");
  }
  
  public void aIC()
  {
    if (awit.Vs()) {
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : isShowKandianTab give up clean !");
    }
    int i;
    label53:
    do
    {
      do
      {
        return;
        if (this.L.get() == 0) {
          break label281;
        }
        if (!ocp.f(this.app, this.aef, this.N.get())) {
          break;
        }
        aIE();
        i = 1;
        localObject1 = oan.a();
        if (localObject1 != null) {
          ((oan)localObject1).aq(this.app);
        }
      } while (i == 0);
      localObject1 = this.app.b().d(acbn.blx, 7220);
      if (localObject1 == null) {
        break label286;
      }
    } while ((((MessageRecord)localObject1).extInt == 1) || (((MessageRecord)localObject1).extInt == 3));
    long l = ((MessageRecord)localObject1).time;
    label123:
    Object localObject1 = c();
    if (localObject1 == null) {
      localObject1 = this.app.getApp().getResources().getString(2131697442);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.app.getApp().getResources().getString(2131697442);
      }
      localObject1 = a((String)localObject2, String.valueOf(l), 0);
      kxm.j((MessageRecord)localObject1);
      this.app.b().b((MessageRecord)localObject1, this.app.getCurrentUin());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("KandianMergeManager", 2, "cleanKandianMergeSummary : last msg is interested account,replace by kandian. " + ((MessageRecord)localObject1).msg);
      return;
      if (this.M.get() == 2)
      {
        aIE();
        i = 0;
        break label53;
      }
      qk(3);
      label281:
      i = 0;
      break label53;
      label286:
      l = NetConnInfoCenter.getServerTime();
      break label123;
      if ((((MessageRecord)localObject1).extInt == 1) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject2 = (MessageForStructing)localObject1;
        ((MessageForStructing)localObject2).parse();
        if (((MessageForStructing)localObject2).structingMsg == null) {
          localObject1 = ((MessageRecord)localObject1).msg;
        } else {
          localObject1 = ((MessageForStructing)localObject2).structingMsg.mMsgBrief;
        }
      }
      else
      {
        localObject1 = ((MessageRecord)localObject1).msg;
      }
    }
  }
  
  public void aID()
  {
    kxm.aHX();
    MessageRecord localMessageRecord = this.app.b().d(acbn.blx, 7220);
    if ((localMessageRecord != null) && (!localMessageRecord.isread))
    {
      localMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.18(this, localMessageRecord), 10, null, false);
    }
  }
  
  public void aIE()
  {
    try
    {
      this.L.set(0);
      this.h.set(0L);
      this.aef = "";
      this.M.set(-1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.22(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aIF()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = null;
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aIG()
  {
    try
    {
      this.K.set(0);
      this.g.set(0L);
      if (this.ks != null) {
        this.ks.clear();
      }
      this.algorithmId = 0L;
      this.tn = 0L;
      this.aee = null;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.25(this));
      return;
    }
    finally {}
  }
  
  public void aIH()
  {
    kxm.aHX();
    tog localtog = this.app.b().a();
    String str;
    if (awit.cA(this.app)) {
      str = acbn.blx;
    }
    for (int i = 7220;; i = 1008)
    {
      if ((localtog != null) && (localtog.A(str, i) > 0)) {
        ThreadManager.post(new KandianMergeManager.26(this, str, i), 8, null, false);
      }
      return;
      str = acbn.blw;
    }
  }
  
  public void aIJ()
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), kbs.class);
    localNewIntent.putExtra("cmd", "get_message_configuration");
    mobileqq_mp.GetMessageConfigurationRequest localGetMessageConfigurationRequest = new mobileqq_mp.GetMessageConfigurationRequest();
    localGetMessageConfigurationRequest.uin.set(2171946401L);
    localGetMessageConfigurationRequest.versionInfo.set(ocp.getVersionInfo());
    localNewIntent.putExtra("data", localGetMessageConfigurationRequest.toByteArray());
    localNewIntent.setObserver(new lbq(this));
    this.app.startServlet(localNewIntent);
  }
  
  public void aIK()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianMergeManager.28(this));
    }
  }
  
  public void aIL()
  {
    Object localObject = this.app.b().d(acbn.blx, 7220);
    acxw localacxw;
    RecentUser localRecentUser;
    if ((localObject != null) && (!((MessageRecord)localObject).isread))
    {
      localacxw = this.app.a().a();
      localRecentUser = localacxw.b(acbn.blx, 7220);
      if (localRecentUser != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis() / 1000L;
    localRecentUser.lastmsgtime = l;
    this.app.b().a(acbn.blx, 7220, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(l));
    localacxw.e(localRecentUser);
    localObject = this.app.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    QLog.d("KandianMergeManager", 1, "stickKandianConversation successful! newTime : " + l);
  }
  
  public void aIM()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.31(this));
  }
  
  public void aIN()
  {
    ThreadManager.getUIHandler().post(new KandianMergeManager.32(this));
  }
  
  public void aIO()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo == null) {
      return;
    }
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.removeFromDiskAsync(true);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    aIN();
  }
  
  public void aIP()
  {
    if (dH("showKandianTabRedDot")) {
      return;
    }
    this.K.set(1);
    aIM();
  }
  
  public void aIQ()
  {
    ThreadManager.executeOnSubThread(new KandianMergeManager.33(this));
  }
  
  public void aIR()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.canDoAnimation = true;
    }
  }
  
  public void aIS()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.asyncWriteToSP();
      aIM();
      QLog.d("KandianMergeManager", 1, "clear msg box redPnt info, " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void aIT()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.writeToSP();
      aIM();
      QLog.d("KandianMergeManager", 1, "clear msg box redPnt info, " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo);
    }
  }
  
  public void aIW()
  {
    try
    {
      boolean bool = Bw();
      QLog.d("KandianMergeManager", 1, new Object[] { "switch to sub channel, clear kandian red point, hasRedPoint = ", Boolean.valueOf(bool) });
      if (bool)
      {
        aIX();
        aIG();
        aIF();
        aIM();
      }
      return;
    }
    finally {}
  }
  
  public void ap(int paramInt, String paramString)
  {
    this.aei = paramString;
    if (!this.aei.isEmpty()) {
      lbz.a().ar(paramInt, this.aei);
    }
  }
  
  public int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return -1;
      if (!TextUtils.isEmpty(paramMessageRecord.extStr)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.extStr);
          if (paramMessageRecord.has("kandian_push_from"))
          {
            int i = Integer.parseInt(paramMessageRecord.getString("kandian_push_from"));
            return i;
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return -1;
  }
  
  public SparseIntArray b()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.append(0, de(0));
    localSparseIntArray.append(1, de(1));
    localSparseIntArray.append(2, de(2));
    localSparseIntArray.append(3, de(3));
    return localSparseIntArray;
  }
  
  public String b(Long paramLong)
  {
    if (paramLong.longValue() > 0L) {
      return (String)this.ef.get(paramLong);
    }
    return null;
  }
  
  public void b(acza paramacza)
  {
    b(paramacza);
    b(paramacza);
    b(paramacza);
    lcc.a().c(paramacza);
  }
  
  public void b(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.he == null) || (this.he.isEmpty())) {
          continue;
        }
        QLog.d("KandianMergeManager", 2, "remove MsgObserver " + paramc.getClass().getSimpleName() + ", " + paramc);
        this.he.remove(paramc);
      }
      finally {}
    }
  }
  
  public void b(d paramd)
  {
    if (paramd == null) {}
    while ((this.hc == null) || (this.hc.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + paramd.getClass().getSimpleName() + ", " + paramd);
    this.hc.remove(paramd);
  }
  
  public void b(e parame)
  {
    if ((parame == null) || (this.hd == null) || (this.hd.isEmpty())) {
      return;
    }
    QLog.d("KandianMergeManager", 2, "remove tabRedNumChangeObserver " + parame.getClass().getSimpleName() + ", " + parame);
    this.hd.remove(parame);
  }
  
  public KandianRedDotInfo c()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public MessageRecord c()
  {
    Object localObject = this.app.b().k(acbn.blx, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4)) {}
        while ((!localMessageRecord.isValid) || (top.fz(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.app.b().b(acbn.blx, 7220, "extInt=1 OR extInt=3");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public void c(KandianRedDotInfo paramKandianRedDotInfo)
  {
    if (paramKandianRedDotInfo == null) {
      return;
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null) {
      if (!paramKandianRedDotInfo.hasArticleID()) {}
    }
    for (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo;; this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = paramKandianRedDotInfo)
    {
      QLog.d("KandianMergeManager", 1, "update mainVideoTab RedDot : " + paramKandianRedDotInfo);
      aIN();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
      return;
      QLog.d("KandianMergeManager", 1, "main video tab fake red drop because of has reddot now!");
      return;
    }
  }
  
  public void cD(int paramInt1, int paramInt2)
  {
    KandianSetTopInfo localKandianSetTopInfo = KandianSetTopInfo.get(paramInt1, paramInt2);
    kxm.b("kandian_msgtab_settop", localKandianSetTopInfo, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo = localKandianSetTopInfo;
    QLog.d("KandianMergeManager.SETTOP", 2, "update kandian push msg setTop info : " + localKandianSetTopInfo);
  }
  
  public long cu()
  {
    if (this.jdField_a_of_type_Mhm != null) {
      return this.jdField_a_of_type_Mhm.vh;
    }
    return 0L;
  }
  
  public long cv()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$KandianSetTopInfo.lastSetTopMsgUniseq;
    }
    return 0L;
  }
  
  public long cw()
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null)
    {
      l1 = l2;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead) {
        l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mUin;
      }
    }
    return l1;
  }
  
  public KandianRedDotInfo d()
  {
    return this.d;
  }
  
  public MessageRecord d()
  {
    Object localObject = this.app.b().k(acbn.blx, 7220);
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)((List)localObject).get(i);
        if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4) || (localMessageRecord.extInt == 3)) {}
        while (((localMessageRecord.extInt == 5) && (!Bz())) || (!localMessageRecord.isValid) || (top.fz(localMessageRecord.msgtype)))
        {
          i -= 1;
          break;
        }
      }
    }
    for (;;)
    {
      localObject = localMessageRecord;
      if (localMessageRecord == null) {
        localObject = this.app.b().b(acbn.blx, 7220, "extInt=1");
      }
      return localObject;
      localMessageRecord = null;
    }
  }
  
  public int dd(int paramInt)
  {
    if (!awit.cA(this.app)) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.K.get();
    }
    return this.L.get();
  }
  
  public int de(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "getTabRedNums tab: " + paramInt + ", nums: " + i);
      }
      return i;
      i = this.K.get();
      if (i < 0) {
        break;
      }
      continue;
      i = this.O.get();
      if (i <= 0) {
        break;
      }
      continue;
      if (this.jdField_a_of_type_Mhm == null) {
        break;
      }
      i = 1;
      continue;
      i = ok();
    }
  }
  
  public KandianRedDotInfo e()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  }
  
  public void f(byte[] paramArrayOfByte, long paramLong)
  {
    paramArrayOfByte = Kandian210Msg0xeeInfo.decodeFromPbBytes(paramArrayOfByte);
    if ((paramArrayOfByte == null) || (njn.a().isShowing())) {
      if (QLog.isColorLevel()) {
        QLog.d("KandianMergeManager", 2, "process 0x210 sub 0xee msg fail!");
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo != null) && (paramArrayOfByte.msgSeq < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.msgSeq));
      if ((paramArrayOfByte.notifyInfos != null) && (!paramArrayOfByte.notifyInfos.isEmpty()) && (!TextUtils.isEmpty(((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).contextTitle))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("KandianMergeManager", 2, "0x210 sub 0xee msg title empty, just abandon " + paramArrayOfByte);
    return;
    if (dH("processMsg0x210Sub0xee"))
    {
      eq(a(paramArrayOfByte));
      return;
    }
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo;
    if (paramArrayOfByte.isArticleAppInPush())
    {
      this.algorithmId = ((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).algorithmID;
      this.tn = ((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).strategyID;
      this.aee = kxk.D(((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).extCookie, 0);
      localObject1 = ((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).orangeWord;
      if (localObject1 == null) {}
      this.ks = new ArrayList();
      localObject2 = paramArrayOfByte.notifyInfos.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject2).next();
        this.ks.add(0, Long.valueOf(localNotifyInfo.contextId));
      }
      localObject1 = a(((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).contextTitle, (String)localObject1, paramLong, this.tn, this.algorithmId, ((Long)this.ks.get(0)).longValue(), ((Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0)).folderStatus);
      if (localObject1 != null) {
        i((MessageRecord)localObject1);
      }
      f((MessageRecord)localObject1);
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo = paramArrayOfByte;
        Kandian210Msg0xeeInfo.writeToSpAsync(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo);
        aIQ();
      }
      QLog.d("KandianMergeManager", 2, "process Msg 210 0xee canHandle : " + bool + "\n InAppPush : " + paramArrayOfByte);
      return;
      if (paramArrayOfByte.isVideoAppInPush())
      {
        if (!awit.aMH())
        {
          QLog.d("KandianMergeManager", 2, "received video app in push , but user is not in video tab, drop it as wife");
          return;
        }
        localObject1 = new KandianRedDotInfo("kandian_video_tab_reddot_info");
        localObject2 = (Kandian210Msg0xeeInfo.NotifyInfo)paramArrayOfByte.notifyInfos.get(0);
        ((KandianRedDotInfo)localObject1).algorithmID = ((Kandian210Msg0xeeInfo.NotifyInfo)localObject2).algorithmID;
        ((KandianRedDotInfo)localObject1).cookie = Html.fromHtml(((Kandian210Msg0xeeInfo.NotifyInfo)localObject2).extCookie).toString();
        localObject2 = paramArrayOfByte.notifyInfos.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)((Iterator)localObject2).next();
          ((KandianRedDotInfo)localObject1).articleIDList.add(0, Long.valueOf(localNotifyInfo.contextId));
        }
        c((KandianRedDotInfo)localObject1);
        aIN();
        bool = true;
      }
      else
      {
        QLog.d("KandianMergeManager", 2, "received unknow app in push, bid " + paramArrayOfByte.bid);
      }
    }
  }
  
  public void g(MessageRecord paramMessageRecord)
  {
    if (this.he != null)
    {
      Iterator localIterator = this.he.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).g(paramMessageRecord);
      }
    }
  }
  
  public boolean h(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    int i = a(paramMessageRecord, this.app);
    if (i == 0) {
      bool = j(paramMessageRecord);
    }
    while (i != 1) {
      return bool;
    }
    return a(paramMessageRecord, false);
  }
  
  public boolean i(MessageRecord paramMessageRecord)
  {
    AbsStructMsg localAbsStructMsg;
    try
    {
      localAbsStructMsg = anre.b();
      localAbsStructMsg.uin = paramMessageRecord.frienduin;
      localAbsStructMsg.currentAccountUin = paramMessageRecord.selfuin;
      localAbsStructMsg.mMsgBrief = paramMessageRecord.msg;
      localAbsStructMsg.mMsgActionData = this.aee;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.ks.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(String.valueOf((Long)localIterator.next())).append("|");
      }
      localAbsStructMsg.mArticleIds = localStringBuilder.toString();
    }
    finally {}
    localAbsStructMsg.mAlgorithmIds = String.valueOf(this.algorithmId);
    localAbsStructMsg.mStrategyIds = String.valueOf(this.tn);
    long l = paramMessageRecord.time;
    paramMessageRecord = aqoj.C(localAbsStructMsg.getBytes());
    if (l > this.g.get())
    {
      this.g.set(l);
      this.K.set(1);
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.23(this, paramMessageRecord, l));
      if ((this.L.get() > 0) && (this.M.get() != 2))
      {
        qk(2);
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, "0xee push, ids: " + this.ks);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if ((this.L.get() > 0) || (this.M.get() != 3)) {
        break;
      }
      aIE();
      break;
    }
  }
  
  public boolean j(MessageRecord paramMessageRecord)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      long l;
      Object localObject2;
      try
      {
        if (dH("updateKandianPush2SP"))
        {
          eq(a(paramMessageRecord));
          bool = false;
          return bool;
        }
        if (ReadInJoyLockScreenJumpDelegate.d(paramMessageRecord))
        {
          if (kxm.e(paramMessageRecord)) {
            this.d = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
          }
          QLog.i("KandianMergeManager", 1, "updateKandianPush2SP: block lock screen red dot.");
          bool = true;
          continue;
        }
        if (!(paramMessageRecord instanceof MessageForStructing)) {
          break label670;
        }
        localObject1 = (MessageForStructing)paramMessageRecord;
        ((MessageForStructing)localObject1).parse();
        if (((MessageForStructing)localObject1).structingMsg == null)
        {
          if (!QLog.isColorLevel()) {
            break label676;
          }
          QLog.d("KandianMergeManager", 2, "kandian push msg : struct msg body is null");
          break label676;
        }
        localObject1 = aqoj.C(((MessageForStructing)paramMessageRecord).structingMsg.getBytes());
        l = paramMessageRecord.time;
        if (paramMessageRecord.time < this.g.get()) {
          break label670;
        }
        if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds))
        {
          localObject2 = ((MessageForStructing)paramMessageRecord).structingMsg.mArticleIds.split("\\|");
          this.ks = new ArrayList();
          int j = localObject2.length;
          if (i < j) {
            try
            {
              if (TextUtils.isEmpty(localObject2[i])) {
                break label682;
              }
              BigInteger localBigInteger = new BigInteger(localObject2[i]);
              this.ks.add(Long.valueOf(localBigInteger.longValue()));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              QLog.e("KandianMergeManager", 1, "parse kandian push articleID has num format error : " + localNumberFormatException);
            }
          }
        }
        this.aee = ((MessageForStructing)paramMessageRecord).structingMsg.mMsgActionData;
      }
      finally {}
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds)) {
        this.algorithmId = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mAlgorithmIds.split("\\|")[0]);
      }
      if (!TextUtils.isEmpty(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds)) {
        this.tn = Long.parseLong(((MessageForStructing)paramMessageRecord).structingMsg.mStrategyIds.split("\\|")[0]);
      }
      this.g.set(paramMessageRecord.time);
      this.K.set(1);
      if ((kxm.e(paramMessageRecord)) && (this.ks != null))
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo != null)
        {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.saveToDiskAsync(true);
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.hasArticleID())
          {
            localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.articleIDList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              this.ef.put(localLong, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo.extInfo);
            }
          }
        }
        this.d = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_red_pnt_lock_screen");
      }
      ThreadManager.getSubThreadHandler().post(new KandianMergeManager.24(this, (String)localObject1, l));
      if ((this.L.get() > 0) && (this.M.get() != 2)) {
        qk(2);
      }
      for (;;)
      {
        aIF();
        QLog.d("KandianMergeManager", 1, "kandian push, ids: " + this.ks + ", msgUid : " + paramMessageRecord.msgUid + ", isLockScreenMsg : " + kxm.e(paramMessageRecord) + ", pushContent : " + this.aee);
        bool = true;
        break;
        if ((this.L.get() <= 0) && (this.M.get() == 3)) {
          aIE();
        }
      }
      label670:
      boolean bool = false;
      continue;
      label676:
      bool = false;
      continue;
      label682:
      i += 1;
    }
  }
  
  public String jd()
  {
    return this.aee;
  }
  
  public Pair<Object, String> l()
  {
    if ((!awit.cA(this.app)) || ((this.L.get() <= 0) && (this.M.get() != 3)) || ((this.L.get() > 0) && (this.M.get() == 2))) {}
    do
    {
      return null;
      qk(2);
      QLog.d("KandianMergeManager", 1, "mSubscribePushMsgTitle : " + kxm.ev(this.aeg) + " mSubscribePushMsgArticleID : " + this.u + " mInnerUniqId : " + this.aeh + " seedUIN :  " + this.aef + ", isInterestedAccount : " + ocp.f(this.app, this.aef, this.N.get()));
    } while ((TextUtils.isEmpty(this.aeg)) || ((TextUtils.isEmpty(this.aeh)) && (this.u.longValue() == -1L)));
    if ((awit.cD(this.app)) && (!TextUtils.isEmpty(this.aeh))) {
      return new Pair(this.aeh, this.aeg);
    }
    return new Pair(this.u, this.aeg);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo l()
  {
    int i = 1;
    int k = 0;
    int j = 0;
    Object localObject2 = "";
    label42:
    Object localObject1;
    if (!awit.aMH()) {
      if (Bw())
      {
        k = 1;
        int m = ol();
        if ((k <= 0) && (m <= 0)) {
          break label159;
        }
        i = 1;
        if (m > 0) {
          j = 5;
        }
        localObject1 = String.valueOf(m);
        if (m > 99) {
          localObject1 = String.valueOf("99+");
        }
        QLog.d("KandianMergeManager", 1, "getReadinjoyTabRedInfo, recommendRedNum : " + k + ", msgBoxRedNum : " + m);
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label188;
      }
      localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#FF0000'}");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(j);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set((String)localObject1);
      return localObject2;
      k = 0;
      break;
      label159:
      i = 0;
      break label42;
      j = k;
      localObject1 = localObject2;
      if (!BB())
      {
        i = 0;
        j = k;
        localObject1 = localObject2;
      }
    }
    label188:
    return null;
  }
  
  public void m(MessageRecord paramMessageRecord)
  {
    
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      paramMessageRecord.isread = true;
      ThreadManager.post(new KandianMergeManager.19(this, paramMessageRecord), 10, null, false);
    }
  }
  
  public void mN(String paramString)
  {
    try
    {
      if (TextUtils.equals(paramString, this.aef))
      {
        aIE();
        MessageRecord localMessageRecord = this.app.b().d(acbn.blx, 7220);
        if ((localMessageRecord != null) && (localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, paramString)))
        {
          paramString = c();
          if (paramString != null)
          {
            kxm.j(paramString);
            this.app.b().b(paramString, this.app.getCurrentUin());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void mR(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.app;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      kxm.a(localQQAppInterface, paramBoolean);
      return;
    }
  }
  
  public void mS(boolean paramBoolean)
  {
    W(paramBoolean, false);
  }
  
  public void mT(boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.aMV = i;
      ljc localljc = lbz.a().a();
      if (localljc != null)
      {
        String str = this.app.getCurrentUin();
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        localljc.aG(str, i);
      }
      return;
    }
  }
  
  public void mU(boolean paramBoolean)
  {
    altq localaltq = (altq)this.app.getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramBoolean)
    {
      localAppInfo = localaltq.b(7, "1130");
      if (localAppInfo != null) {
        localaltq.d(localAppInfo, "");
      }
    }
    for (;;)
    {
      QLog.d("KandianMergeManager", 1, "reportRedPntClick, isNumRedPnt : " + paramBoolean);
      return;
      localAppInfo = localaltq.getAppInfoByPath("1130");
      if (localAppInfo != null) {
        localaltq.d(localAppInfo, "");
      }
    }
  }
  
  public int og()
  {
    return this.aMU;
  }
  
  public int oh()
  {
    if (this.jdField_a_of_type_Mhm != null) {
      return this.jdField_a_of_type_Mhm.aRK;
    }
    return 0;
  }
  
  public int oi()
  {
    int i = 0;
    if (BD()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return i;
  }
  
  public int oj()
  {
    return lbz.a().om();
  }
  
  public int ok()
  {
    int i = 0;
    if (BD()) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return i;
  }
  
  public int ol()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.isRead)) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianMsgBoxRedPntInfo.mMsgCnt;
    }
    return 0;
  }
  
  public void onDestroy()
  {
    awit.eDJ();
    aIV();
    if (this.app != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Acfd);
      this.app.unRegistObserver(this.jdField_a_of_type_Aklk);
    }
    awiy.a().a(null);
    TaskManager.getInstance().stopAllTasks();
    if (this.hc != null) {
      this.hc.clear();
    }
    if (this.he != null) {
      this.he.clear();
    }
    oej.unregister();
    kyd.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigAladdinListener);
    aIy();
  }
  
  public void qi(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("KandianMergeManager", 2, "followListLength" + paramInt);
    }
    this.aMU = paramInt;
    ThreadManager.post(new KandianMergeManager.10(this, paramInt), 8, null, false);
  }
  
  public void qj(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.L.get() == 0);
    aIE();
  }
  
  /* Error */
  public void qk(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_3
    //   4: if_icmpne +29 -> 33
    //   7: aload_0
    //   8: getfield 186	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:M	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 1239	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_2
    //   15: if_icmpne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 1920	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:aIE	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 180	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:L	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: iconst_0
    //   30: invokevirtual 1215	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   33: aload_0
    //   34: getfield 186	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:M	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: iload_1
    //   38: invokevirtual 1215	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   41: invokestatic 626	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   44: new 2445	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$21
    //   47: dup
    //   48: aload_0
    //   49: iload_1
    //   50: invokespecial 2446	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager$21:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;I)V
    //   53: invokevirtual 635	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   56: pop
    //   57: goto -35 -> 22
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	KandianMergeManager
    //   0	65	1	paramInt	int
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	60	finally
    //   25	33	60	finally
    //   33	57	60	finally
  }
  
  public void ql(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("erasureTabRed index: " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
    case 1: 
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KandianMergeManager", 2, localStringBuilder.toString());
        }
        aIM();
        return;
        this.O.set(0);
      }
    }
    if (de(paramInt) > 0) {}
    for (;;)
    {
      localStringBuilder.append(", subscribe msg successful");
      break;
      lbz.a().aJu();
    }
  }
  
  public void qm(int paramInt)
  {
    SharedPreferences.Editor localEditor = awit.a(this.app, true, false).edit();
    localEditor.remove("kandian_myself_red_point" + paramInt);
    awit.a(localEditor, true);
  }
  
  public static class KandianSetTopInfo
    implements Serializable
  {
    public int count;
    private int fixNumOfTimes;
    private long lastSetTopMsgUniseq;
    private long setTopCountResetTime;
    
    private void aIY()
    {
      if (System.currentTimeMillis() >= this.setTopCountResetTime)
      {
        this.count = this.fixNumOfTimes;
        this.setTopCountResetTime += 86400000L;
        kxm.b("kandian_msgtab_settop", this, true);
        QLog.d("KandianMergeManager.SETTOP", 2, "reset kandian SetTopInfo count : " + this);
      }
    }
    
    public static KandianSetTopInfo get(int paramInt1, int paramInt2)
    {
      KandianSetTopInfo localKandianSetTopInfo = new KandianSetTopInfo();
      localKandianSetTopInfo.fixNumOfTimes = paramInt1;
      localKandianSetTopInfo.count = paramInt1;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      localKandianSetTopInfo.setTopCountResetTime = (localCalendar.getTimeInMillis() + paramInt2 * 1000);
      return localKandianSetTopInfo;
    }
    
    public String toString()
    {
      return " fixNumOfTimes : " + this.fixNumOfTimes + ", count : " + this.count + ", resetTime : " + this.setTopCountResetTime + ", lastMsgUniseq : " + this.lastSetTopMsgUniseq;
    }
    
    public void trySetTopKandianMsg(QQAppInterface paramQQAppInterface)
    {
      aIY();
      MessageRecord localMessageRecord = paramQQAppInterface.b().d(acbn.blx, 7220);
      long l;
      acxw localacxw;
      RecentUser localRecentUser;
      if ((localMessageRecord != null) && (!localMessageRecord.isread) && (!kxm.dB(acbn.blx)) && (localMessageRecord.uniseq != this.lastSetTopMsgUniseq) && (this.count != 0))
      {
        if (!paramQQAppInterface.a.abU()) {
          break label243;
        }
        l = System.currentTimeMillis() / 1000L;
        localacxw = paramQQAppInterface.a().a();
        localRecentUser = localacxw.b(acbn.blx, 7220);
        if (localRecentUser != null) {}
      }
      else
      {
        return;
      }
      localRecentUser.lastmsgtime = l;
      paramQQAppInterface.b().a(acbn.blx, 7220, localMessageRecord.uniseq, "time", Long.valueOf(l));
      localacxw.e(localRecentUser);
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      this.count -= 1;
      this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
      kxm.b("kandian_msgtab_settop", this, true);
      kbp.b(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
      QLog.d("KandianMergeManager.SETTOP", 2, "successful setTop !  newTime : " + l + this);
      return;
      label243:
      kxm.ain = true;
      QLog.d("KandianMergeManager.SETTOP", 2, "receiving msg , wait callback ! " + this);
    }
  }
  
  public static class a
  {
    public int launchFrom;
    public long rX;
    
    public String toString()
    {
      return "articleId : " + this.rX + "  launchFrom: " + this.launchFrom;
    }
  }
  
  public static class b
    extends awiy.b
  {
    public void report(String paramString)
    {
      TaskManager.getInstance().accept(paramString);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle);
    
    public abstract void f(MessageRecord paramMessageRecord);
    
    public abstract void g(MessageRecord paramMessageRecord);
  }
  
  public static abstract interface d
  {
    public abstract void aDh();
  }
  
  public static abstract interface e
  {
    public abstract void aIZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager
 * JD-Core Version:    0.7.0.1
 */