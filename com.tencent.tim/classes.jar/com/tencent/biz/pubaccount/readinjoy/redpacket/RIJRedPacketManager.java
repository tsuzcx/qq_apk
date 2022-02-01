package com.tencent.biz.pubaccount.readinjoy.redpacket;

import acfp;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.ViewGroup;
import android.view.Window;
import anwa;
import aqgz;
import avpw;
import awit;
import awmw;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.protofile.cmd0xe19.cmd0xe19.ReqBody;
import com.tencent.protofile.cmd0xe19.cmd0xe19.RspBody;
import com.tencent.protofile.cmd0xe19.cmd0xe19.TaskRedPacket;
import com.tencent.protofile.cmd0xe23.cmd0xe23.ReqBody;
import com.tencent.protofile.cmd0xe36.cmd0xe36.ReqBody;
import com.tencent.protofile.cmd0xe40.cmd0xe40.ReqBody;
import com.tencent.protofile.oidb_0xe1f.oidb_0xe1f.ReqBody;
import com.tencent.protofile.oidb_0xe21.oidb_0xe21.ReqBody;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimeZone;
import jnm;
import kxm;
import lcc;
import mdf;
import mdg;
import mdh;
import mdi;
import mdj;
import mdk;
import mdl;
import mdm;
import mdp;
import mdx;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import muj;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import skj;

public class RIJRedPacketManager
{
  private static volatile RIJRedPacketManager a;
  private LruCache<String, String> c = new LruCache(10000);
  @org.jetbrains.annotations.Nullable
  private EntityManagerFactory d;
  
  private boolean Du()
  {
    return getSharedPreferences().getBoolean("enableDoArticleTask_" + kxm.getLongAccountUin(), false);
  }
  
  private boolean Dv()
  {
    return getSharedPreferences().getBoolean("enableDoVideoTask_" + kxm.getLongAccountUin(), false);
  }
  
  public static RIJRedPacketManager a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        RIJRedPacketManager localRIJRedPacketManager2 = a;
        localObject = localRIJRedPacketManager2;
        if (localRIJRedPacketManager2 == null)
        {
          localObject = new RIJRedPacketManager();
          a = (RIJRedPacketManager)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localRIJRedPacketManager1;
  }
  
  private void a(byte[] paramArrayOfByte, @NotNull d paramd)
  {
    String str1 = null;
    try
    {
      cmd0xe19.RspBody localRspBody = new cmd0xe19.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      int i = localRspBody.ret.get();
      if (i == 0)
      {
        long l = localRspBody.money.get();
        str2 = localRspBody.detail_wording.get();
        paramArrayOfByte = str1;
        if (localRspBody.has_task.get())
        {
          paramArrayOfByte = new mdp();
          paramArrayOfByte.avatarUrl = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).head.get();
          paramArrayOfByte.nickName = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).nick.get();
          paramArrayOfByte.wording = ((cmd0xe19.TaskRedPacket)localRspBody.task.get()).wording.get();
        }
        paramd.a(i, l, str2, paramArrayOfByte, localRspBody.button_wording.get(), localRspBody.outcome_wording.get(), "");
        aOG();
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 ret = " + i + " money " + l + " detailWording " + str2);
        return;
      }
      paramArrayOfByte = "";
      String str2 = "";
      str1 = "";
      if (localRspBody.toast.has()) {
        paramArrayOfByte = localRspBody.toast.get();
      }
      if (localRspBody.button_wording.has()) {
        str1 = localRspBody.button_wording.get();
      }
      if (localRspBody.detail_wording.has()) {
        str2 = localRspBody.detail_wording.get();
      }
      paramd.a(i, 0L, str2, null, str1, localRspBody.outcome_wording.get(), paramArrayOfByte);
      QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 ret = " + i + " toast wording: " + paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RIJRedPacketManager", 1, QLog.getStackTraceString(paramArrayOfByte));
      }
      paramd.aOI();
    }
  }
  
  private void b(int paramInt, @NotNull f paramf)
  {
    cmd0xe23.ReqBody localReqBody = new cmd0xe23.ReqBody();
    localReqBody.uin.set(kxm.getLongAccountUin());
    jnm.a(kxm.getAppRuntime(), new mdg(this, paramInt, paramf), localReqBody.toByteArray(), "OidbSvc.0xe23", 3619, 0, new Bundle(), 5000L);
  }
  
  private long c(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private long cH()
  {
    String str = Aladdin.getConfig(272).getString("request_wallet_time_interval", "60");
    try
    {
      double d1 = Double.valueOf(str).doubleValue();
      return (d1 * 60.0D * 1000.0D);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 3600000L;
  }
  
  private long cI()
  {
    return getSharedPreferences().getLong("readinjoy_red_packet_next_request_ts" + kxm.getLongAccountUin(), 0L);
  }
  
  private SharedPreferences.Editor getEditor()
  {
    return getSharedPreferences().edit();
  }
  
  private EntityManagerFactory getEntityManagerFactory()
  {
    Object localObject1 = kxm.getAccount();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.d == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.d).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.excute(new RIJRedPacketManager.12(this, (ReadInJoyEntityManagerFactory)localObject1), 16, null, false);
        this.d = ((EntityManagerFactory)localObject1);
      }
      return this.d;
    }
    finally {}
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
  }
  
  private void nL(boolean paramBoolean)
  {
    getEditor().putBoolean("enableDoArticleTask_" + kxm.getLongAccountUin(), paramBoolean).apply();
  }
  
  private void nM(boolean paramBoolean)
  {
    getEditor().putBoolean("enableDoVideoTask_" + kxm.getLongAccountUin(), paramBoolean).apply();
  }
  
  private boolean r(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (c(paramLong1) == c(paramLong2));
  }
  
  public boolean Dp()
  {
    if ((AppSetting.Nv()) && (BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() == 2436410075L)) {}
    long l1;
    long l2;
    do
    {
      return true;
      l1 = getSharedPreferences().getLong("last_fetch_red_packet_info_time" + kxm.getLongAccountUin(), 0L);
      l2 = NetConnInfoCenter.getServerTimeMillis();
    } while ((!getSharedPreferences().getBoolean("readinjoy_red_packet_window_has_closed" + kxm.getLongAccountUin(), false)) && (l2 - l1 >= cH()) && (Dt()));
    return false;
  }
  
  public boolean Dq()
  {
    return getSharedPreferences().getBoolean("readinjoy_red_packet_has_opened" + kxm.getLongAccountUin(), false);
  }
  
  public boolean Dr()
  {
    return getSharedPreferences().getBoolean("readinjoy_has_red_packet_permission" + kxm.getLongAccountUin(), false);
  }
  
  public boolean Ds()
  {
    return getSharedPreferences().getBoolean("readinjoy_red_packet_can_do_task" + kxm.getLongAccountUin(), true);
  }
  
  public boolean Dt()
  {
    if (Aladdin.getConfig(285).getIntegerFromString("is_highest_red_packet_authority_on", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = anwa.aze();
      QLog.i("RIJRedPacketManager", 1, "isHighestRedPacketAuthorityOn: " + bool1 + " ,isStudyMode=" + bool2);
      if ((!bool1) || (bool2)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public JSONObject a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    if ((Dr()) && (Dt())) {
      if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSubArtilceList == null) || (paramBaseArticleInfo.mSubArtilceList.size() <= 0)) {
        break label93;
      }
    }
    label93:
    for (ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);; localArticleInfo = null)
    {
      if (paramBaseArticleInfo.hasWalletIcon) {
        paramJSONObject.put("red_packet_icon_path", "readinjoy_red_packet.png");
      }
      if ((localArticleInfo != null) && (localArticleInfo.hasWalletIcon)) {
        paramJSONObject.put("sub_red_packet_icon_path", "readinjoy_red_packet.png");
      }
      return paramJSONObject;
    }
  }
  
  public void a(int paramInt, @NotNull f paramf)
  {
    boolean bool2 = true;
    long l = NetConnInfoCenter.getServerTimeMillis();
    QLog.i("RIJRedPacketManager", 1, "requestShouldDoTaskTiming curTs: " + l + " getNextRequestCanDoTaskTs： " + cI());
    if (l < cI())
    {
      if (paramInt == 1)
      {
        bool1 = bool2;
        if (Du()) {}
      }
      else
      {
        if ((paramInt != 2) || (!Dv())) {
          break label102;
        }
      }
      label102:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        muj.runOnUIThread(new RIJRedPacketManager.2(this, paramf, bool1));
        return;
      }
    }
    b(paramInt, paramf);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, @NotNull d paramd)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 \nshareSource: " + paramInt + "\nred packetId: " + paramString1 + "\nrowkey: " + paramString2);
    cmd0xe19.ReqBody localReqBody = new cmd0xe19.ReqBody();
    localReqBody.id.set(paramString1);
    localReqBody.rowkey.set(paramString2);
    localReqBody.task_idx.setHasFlag(true);
    paramString1 = new terminal_info.TerminalInfo();
    paramString1.qimei.set(awmw.getQIMEI());
    paramString1.os_version.set(String.valueOf(aqgz.getOsVersion()));
    paramString1.imsi.set(kxm.iU());
    paramString1.qua.set(avpw.getQUA());
    localReqBody.terminal_info.set(paramString1);
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe19 terminal info: qimei " + awmw.getQIMEI() + "\n os_version: " + aqgz.getOsVersion() + "\n imsi: " + kxm.iU() + "\n qua: " + avpw.getQUA());
    paramString1 = ((TicketManager)kxm.getAppRuntime().getManager(2)).getSkey(kxm.getAppRuntime().getAccount());
    localReqBody.skey.set(paramString1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      jnm.a(kxm.getAppRuntime(), new mdj(this, paramd), localReqBody.toByteArray(), "OidbSvc.0xe19", 3609, 1, new Bundle(), 5000L);
      return;
      localReqBody.source.set(1);
      continue;
      localReqBody.source.set(5);
      continue;
      localReqBody.source.set(4);
      continue;
      localReqBody.source.set(2);
      continue;
      localReqBody.source.set(3);
    }
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString1, String paramString2, @NotNull g paramg, boolean paramBoolean, skj paramskj)
  {
    QLog.i("RIJRedPacketManager", 1, "onClickBubbleTips share source: " + paramInt + "\n encryptId: " + paramString1 + "\nrowkey: " + paramString2);
    if (!awit.aME())
    {
      a(paramActivity, paramString1, 2, 0, paramBoolean, paramskj);
      return;
    }
    if ("QzoneFeedsPluginProxyActivity".equals(paramActivity.getIntent().getStringExtra("SourceActivityName"))) {}
    for (int i = 3;; i = 2)
    {
      a(paramInt, paramString1, paramString2, new mdk(this, paramActivity, paramString1, paramInt, i, paramString2, paramg));
      return;
    }
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, skj paramskj)
  {
    new mdx((ViewGroup)paramActivity.getWindow().getDecorView(), paramString, paramInt1, paramInt2, paramBoolean, paramskj).show();
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    kxm.aJ(paramContext, String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  public void a(f paramf)
  {
    if ((Dr()) && (Dt()))
    {
      a(2, paramf);
      return;
    }
    muj.runOnUIThread(new RIJRedPacketManager.1(this, paramf));
  }
  
  public void a(@NotNull g paramg)
  {
    QLog.i("RIJRedPacketManager", 1, "request yyy_0xe36");
    cmd0xe36.ReqBody localReqBody = new cmd0xe36.ReqBody();
    localReqBody.nothing.set(1);
    jnm.a(kxm.getAppRuntime(), new mdi(this, paramg), localReqBody.toByteArray(), "OidbSvc.0xe36", 3638, 1, new Bundle(), 5000L);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, @org.jetbrains.annotations.Nullable e parame)
  {
    oidb_0xe21.ReqBody localReqBody = new oidb_0xe21.ReqBody();
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 report progress rowkey: " + paramString + " type: " + paramInt1 + " taskTime: " + paramInt2);
    localReqBody.progress.set(paramInt2);
    localReqBody.rowkey.set(paramString);
    localReqBody.type.set(paramInt1);
    Object localObject = new terminal_info.TerminalInfo();
    ((terminal_info.TerminalInfo)localObject).qimei.set(awmw.getQIMEI());
    ((terminal_info.TerminalInfo)localObject).os_version.set(String.valueOf(aqgz.getOsVersion()));
    ((terminal_info.TerminalInfo)localObject).imsi.set(kxm.iU());
    ((terminal_info.TerminalInfo)localObject).qua.set(avpw.getQUA());
    localReqBody.terminal_info.set((MessageMicro)localObject);
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe21 terminal info: qimei " + awmw.getQIMEI() + "\n os_version: " + aqgz.getOsVersion() + "\n imsi: " + kxm.iU() + "\n qua: " + avpw.getQUA());
    localObject = ((TicketManager)kxm.getAppRuntime().getManager(2)).getSkey(kxm.getAppRuntime().getAccount());
    localReqBody.skey.set((String)localObject);
    jnm.a(kxm.getAppRuntime(), new mdf(this, paramString, paramInt2, parame), localReqBody.toByteArray(), "OidbSvc.0xe21", 3617, 1, new Bundle(), 5000L);
  }
  
  public void a(String paramString, @NotNull b paramb)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe1f: rowkey: " + paramString);
    oidb_0xe1f.ReqBody localReqBody = new oidb_0xe1f.ReqBody();
    localReqBody.rowkey.set(paramString);
    jnm.a(kxm.getAppRuntime(), new mdh(this, paramb), localReqBody.toByteArray(), "OidbSvc.0xe1f", 3615, 1, new Bundle(), 5000L);
  }
  
  public void a(@NotNull String paramString, @NotNull c paramc)
  {
    ThreadManager.excute(new RIJRedPacketManager.10(this, paramString, paramc), 32, null, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, @NotNull a parama)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe40 rowkey: " + paramString1 + "\n");
    cmd0xe40.ReqBody localReqBody = new cmd0xe40.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.id.set(paramString2);
    localReqBody.source.set(paramInt);
    jnm.a(kxm.getAppRuntime(), new mdl(this, parama), localReqBody.toByteArray(), "OidbSvc.0xe40", 3648, 1, new Bundle(), 5000L);
  }
  
  public void aI(String paramString, int paramInt)
  {
    getEditor().putString("readinjoy_red_packet_last_timing_task_rowkey" + kxm.getLongAccountUin(), paramString).apply();
    getEditor().putInt("readinjoy_red_packet_last_timing_task_time" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public void aOD()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    getEditor().putLong("last_fetch_red_packet_info_time" + kxm.getLongAccountUin(), l).apply();
  }
  
  public void aOE()
  {
    getEditor().putBoolean("readinjoy_red_packet_window_has_closed" + kxm.getLongAccountUin(), true).apply();
  }
  
  public void aOF()
  {
    getEditor().putBoolean("readinjoy_red_packet_has_opened" + kxm.getLongAccountUin(), true).apply();
  }
  
  public void aOG()
  {
    lcc.a().nd(true);
    getEditor().putBoolean("readinjoy_has_red_packet_permission" + kxm.getLongAccountUin(), true).apply();
  }
  
  public void aOH()
  {
    ThreadManager.excute(new RIJRedPacketManager.9(this), 32, null, true);
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    String str3 = null;
    String str1;
    String str2;
    label66:
    int i;
    label109:
    int k;
    if (((paramChatMessage instanceof MessageForStructing)) && (((MessageForStructing)paramChatMessage).structingMsg != null))
    {
      str1 = ((MessageForStructing)paramChatMessage).structingMsg.mMsgUrl;
      str2 = ((MessageForStructing)paramChatMessage).structingMsg.getSourceName();
      str3 = ((MessageForStructing)paramChatMessage).structingMsg.mQzoneExtraMsg;
      if (TextUtils.isEmpty(str1)) {
        break label252;
      }
      j = 1;
      if ((j == 0) || ((!str1.startsWith("https://post.mp.qq.com/kan/article/")) && (!str1.startsWith("http://post.mp.qq.com/kan/article/"))) || (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 83)) {
        break label257;
      }
      i = 1;
      if ((j == 0) || ((!str1.startsWith("https://post.mp.qq.com/kan/video/")) && (!str1.startsWith("http://post.mp.qq.com/kan/video/"))) || (((MessageForStructing)paramChatMessage).structingMsg.mMsgServiceID != 140)) {
        break label262;
      }
      k = 1;
      label154:
      if ((j == 0) || (!str1.contains("redpackid"))) {
        break label268;
      }
      j = 1;
      label171:
      if ((j == 0) || ((i == 0) && (k == 0))) {
        break label273;
      }
      i = 1;
      label186:
      if ((!acfp.m(2131717872).equals(str2)) && (TextUtils.isEmpty(str3))) {
        break label278;
      }
    }
    label257:
    label262:
    label268:
    label273:
    label278:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (!Dt()) || (j != 0)) {
        break label283;
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("RIJRedPacketManager", 2, "((MessageForStructing) message).structingMsg is null.");
      }
      str1 = "";
      str2 = null;
      break;
      label252:
      j = 0;
      break label66;
      i = 0;
      break label109;
      k = 0;
      break label154;
      j = 0;
      break label171;
      i = 0;
      break label186;
    }
    label283:
    return false;
  }
  
  public boolean dQ(String paramString)
  {
    return this.c.get(paramString) != null;
  }
  
  public String jC()
  {
    return Aladdin.getConfig(275).getString("video_tips_content", BaseApplicationImpl.getApplication().getString(2131718524));
  }
  
  public String jD()
  {
    return getSharedPreferences().getString("readinjoy_red_packet_last_timing_task_rowkey" + kxm.getLongAccountUin(), "");
  }
  
  public String jE()
  {
    return Aladdin.getConfig(275).getString("article_share_tips_wording_android", BaseApplicationImpl.getContext().getString(2131718491));
  }
  
  public void ny(@NotNull String paramString)
  {
    this.c.put(paramString, paramString);
  }
  
  public void nz(@NotNull String paramString)
  {
    ThreadManager.excute(new RIJRedPacketManager.11(this, paramString), 32, null, true);
  }
  
  public int oT()
  {
    if (r(getSharedPreferences().getLong("task_progress_last_update_time_stamp" + kxm.getLongAccountUin(), 0L), NetConnInfoCenter.getServerTimeMillis())) {}
    for (;;)
    {
      return getSharedPreferences().getInt("global_current_task_time" + kxm.getLongAccountUin(), 0);
      rz(0);
    }
  }
  
  public int oU()
  {
    return getSharedPreferences().getInt("readinjoy_red_packet_total_task_time_ms" + kxm.getLongAccountUin(), 300000);
  }
  
  public int oV()
  {
    return getSharedPreferences().getInt("readinjoy_red_packet_station_article" + kxm.getLongAccountUin(), 3000);
  }
  
  public int oW()
  {
    return Aladdin.getConfig(275).getIntegerFromString("task_tips_duration", 3) * 1000;
  }
  
  public int oX()
  {
    return Aladdin.getConfig(275).getIntegerFromString("video_tips_duration", 3) * 1000;
  }
  
  public int oY()
  {
    return getSharedPreferences().getInt("readinjoy_red_packet_last_timing_task_time" + kxm.getLongAccountUin(), 0);
  }
  
  public int oZ()
  {
    return getSharedPreferences().getInt("readinjoy_red_packet_max_task_time_for_article" + kxm.getLongAccountUin(), 20000);
  }
  
  public int pa()
  {
    return Aladdin.getConfig(275).getIntegerFromString("article_share_tips_duration_android", 5) * 1000;
  }
  
  public int pb()
  {
    return getSharedPreferences().getInt("readinjoy_red_packet_task_total_round" + kxm.getLongAccountUin(), 5);
  }
  
  public void r(boolean paramBoolean, long paramLong)
  {
    getEditor().putLong("readinjoy_red_packet_next_request_ts" + kxm.getLongAccountUin(), paramLong).apply();
    getEditor().putBoolean("readinjoy_red_packet_can_do_task" + kxm.getLongAccountUin(), paramBoolean).apply();
  }
  
  public void rA(int paramInt)
  {
    getEditor().putInt("readinjoy_red_packet_total_task_time_ms" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public void rB(int paramInt)
  {
    getEditor().putInt("readinjoy_red_packet_station_article" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public void rC(int paramInt)
  {
    getEditor().putInt("readinjoy_red_packet_max_task_time_for_article" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public void rD(int paramInt)
  {
    getEditor().putInt("readinjoy_red_packet_task_total_round" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public void rz(int paramInt)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    getEditor().putLong("task_progress_last_update_time_stamp" + kxm.getLongAccountUin(), l).apply();
    getEditor().putInt("global_current_task_time" + kxm.getLongAccountUin(), paramInt).apply();
  }
  
  public static class OpenRedPacketResultStruct
    implements Parcelable
  {
    public static final Parcelable.Creator<OpenRedPacketResultStruct> CREATOR = new mdm();
    public String agh;
    public String agi;
    public String agj;
    public String agk;
    public String agl;
    public boolean amc;
    public String buttonWording;
    public long uP;
    
    public OpenRedPacketResultStruct() {}
    
    public OpenRedPacketResultStruct(Parcel paramParcel)
    {
      this.uP = paramParcel.readLong();
      this.agh = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.amc = bool;
        this.agi = paramParcel.readString();
        this.agj = paramParcel.readString();
        this.agk = paramParcel.readString();
        this.buttonWording = paramParcel.readString();
        this.agl = paramParcel.readString();
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.uP);
      paramParcel.writeString(this.agh);
      if (this.amc) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.agi);
        paramParcel.writeString(this.agj);
        paramParcel.writeString(this.agk);
        paramParcel.writeString(this.buttonWording);
        paramParcel.writeString(this.agl);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(boolean paramBoolean, String paramString, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void p(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(@android.support.annotation.Nullable RedPacketTaskData paramRedPacketTaskData);
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, long paramLong, String paramString1, mdp parammdp, String paramString2, String paramString3, String paramString4);
    
    public abstract void aOI();
  }
  
  public static abstract interface e
  {
    public abstract void o(boolean paramBoolean, String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void lJ(boolean paramBoolean);
  }
  
  public static abstract interface g
  {
    public abstract void showToast(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager
 * JD-Core Version:    0.7.0.1
 */