package com.tencent.mobileqq.activity.aio;

import abhh;
import acfp;
import acgr;
import acha;
import acie;
import acja;
import acms;
import aehj;
import aeif;
import aeku;
import aekv;
import aeof;
import aepa;
import afck;
import ahau;
import ahau.a;
import ahav;
import ahgq;
import aiob;
import airf;
import ajri;
import akza;
import altq;
import amja;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anec;
import anlm;
import anot;
import anpc;
import aobw;
import aogk;
import aohy;
import aoij;
import aoxw;
import aprg;
import aprp;
import apsw;
import apsw.f;
import apsz;
import apuh;
import apyu;
import aqfr;
import aqha;
import aqiw;
import aqji.c;
import aqju;
import aqmj;
import asgx;
import atni;
import auel;
import ausj;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import common.config.service.QzoneConfig;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import imm;
import itq;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jkn;
import jkn.b;
import jll;
import jml;
import jof;
import jof.b;
import jou;
import jqs;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import rar;
import rnw;
import rov;
import skd;
import snf;
import syw;
import szc;
import tar;
import ujt;
import wma;
import wmb;
import wmc;
import wmd;
import wme;
import wmf;
import wmg;
import wmh;
import wmj;
import wmz;
import xks;
import xrc;
import xro;
import xry;
import xwq;
import xyi;
import xys;
import ybt;
import ycd;
import ydw;
import ydz;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnLongClickListener
{
  public static final int[] fE = { 2131721253, 2130839324, 1104864054 };
  public static final int[] fF = { 2131721253, 2130839324, 217 };
  public static final int[] fH = { 2131691454, 2130839303, 218 };
  public static final int[] fL = { 2131721238, 2130839296, 201 };
  public static final int[] fQ = { 2131721247, 2130839337, 1106658188 };
  public static final int[] fR = { 2131721250, 2130839315, 1104864068 };
  public static final int[] fS = { 2131721250, 2130839315, 205 };
  public static final int[] fT = { 2131691460, 2130839327, 206 };
  private static final int[] gA = { 2131699454, 2130851781 };
  public static final int[] gB = { 2131700619, 2130845039, 1104639410 };
  public static final int[] gC = { 2131700619, 2130845039, 208 };
  private static final int[] gD = { 2131699528, 2130843307 };
  private static final int[] gE = { 2131699993, 2130843348, 1104536706 };
  public static final int[] gF = { 2131700795, 2130839337, 202 };
  private static final int[] gG = { 2131700795, 2130839337 };
  private static final int[] gH = { 2131694701, 2130843392 };
  private static final int[] gI = { 2131692753, 2130839306, 1104823592 };
  private static final int[] gJ = { 2131692689, 2130839295, 1105298834 };
  public static final int[] gK = { 2131695187, 2130839291, 1104788679 };
  public static final int[] gL = { 2131695187, 2130839291, 212 };
  private static final int[] gM = { 2131701257, 2130846364 };
  public static final int[] gN = { 2131700640, 2130838297, 1106114157 };
  public static final int[] gO = { 2131700640, 2130838297, 210 };
  private static final int[] gQ = { 2131690695, 2130838520 };
  public static final int[] gR = { 2131690695, 2130838520, 215 };
  public static int[] gS = { 2131700633, 2130839322, 203 };
  public static final int[] gT = { 2131700628, 2130839317, 209 };
  private static final int[] gU = { 2131700637, 2130839323 };
  public static final int[] gV = { 2131700638, 2130838351, 1106189400 };
  public static final int[] gW = { 2131700638, 2130838351, 216 };
  private static final int[] gX = { 2131699925, 2130851801, 1106194086 };
  private static final int[] gY = { 2131691441, 2130843452 };
  private static final int[] gZ = { 2131690468, 2130838739 };
  private static final int[] gb = { 2131696133, 2130839318, 1104864070 };
  public static final int[] gc = { 2131695320, 2130839314, 101761547 };
  public static final int[] gd = { 2131695320, 2130839314, 207 };
  public static final int[] ge = { 2131700719, 2130839340, 101793773 };
  public static final int[] gf = { 2131700693, 2130839335, 101817424 };
  public static final int[] gg = { 2131700693, 2130839335, 220 };
  public static final int[] gh = { 2131700691, 2130839332, 101850591 };
  public static final int[] gi = { 2131700691, 2130839332, 221 };
  private static final int[] gk = { 2131692439, 2130843224 };
  private static final int[] gm = { 2131690306, 2130844464, 1101487426 };
  private static final int[] gn = { 2131693283, 2130844464 };
  private static final int[] go = { 2131698291, 2130844471 };
  private static final int[] gp = { 2131689551, 2130843298, 1104864064 };
  private static final int[] gq = { 2131689553, 2130843299, 1101678813 };
  public static final int[] gr = { 2131717319, 2130839336, 211 };
  private static final int[] gs = { 2131700642, 2130839329 };
  public static final int[] gt = { 2131700642, 2130839329, 214 };
  private static final int[] gu = { 2131700639, 2130839328 };
  public static final int[] gv = { 2131700639, 2130839328, 222 };
  public static final int[] gw = { 2131719486, 2130839313, 1104864062 };
  public static final int[] gx = { 2131719486, 2130839313, 219 };
  public static final int[] gy = { 2131699526, 2130851800, 213 };
  private static final int[] gz = { 2131699526, 2130851800, 1104874204 };
  private static final int[] ha = { 2131699985, 2130843342, 1105981808 };
  private static final int[] hb = { 2131699493, 2130844494, 1106729451 };
  public static final int[] hc = { 2131700623, 2130838252, 204 };
  private static final int[] hd = { 2131700623, 2130838252, 1107930043 };
  private long HX;
  private long HY = -1L;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AIOLongCaptureCtrl jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl;
  public QQAppInterface app;
  public PanelAdapter b;
  skd b;
  public int bPn = -1;
  private boolean beh;
  private boolean bei;
  private boolean bej;
  public SparseArray<TroopAIOAppInfo> bu;
  private int byr;
  public BaseChatPie c;
  String[] cz = { "chat_tool_hongbao", "chat_tool_qwallettransfer" };
  long dr;
  public ViewPager.OnPageChangeListener e;
  private final int[] fD = { 2131700636, 2130839325 };
  private final int[] fG = { 2131691454, 2130839303 };
  private final int[] fI = { 2131721258, 2130839333 };
  private final int[] fJ = { 2131721258, 2130839333, 1104788673 };
  private final int[] fK = { 2131692601, 2130839338 };
  private final int[] fM = { 2131721252, 2130839296 };
  private final int[] fN = { 2131721248, 2130839297, 100719166 };
  private final int[] fO = { 2131721249, 2130839298, 101847385 };
  private final int[] fP = { 2131721245, 2130839296, 1104651886 };
  private final int[] fU = { 2131691463, 2130839327, 1104864066 };
  private final int[] fV = { 2131691465, 2130839334 };
  private final int[] fW = { 2131691462, 2130839326 };
  private final int[] fX = { 2131691457, 2130839312, 100729587 };
  private final int[] fY = { 2131691456, 2130839311, 1106184014 };
  private final int[] fZ = { 2131691466, 2130839320 };
  private final int[] gP = { 2131700847, 2130844514, 1106865772 };
  private final int[] ga = { 2131691464, 2130839330 };
  private final int[] gj = { 2131717316, 2130839294 };
  private final int[] gl = { 2131691467, 2130844579, 1104445552 };
  private final int[] he = { 2131691461, 2130845090, 1108961705 };
  private final int[][] q = { fE, this.fG, this.fP, fQ, hd, gw, this.fN, gp, gm, this.fU, fR, gb, gK, gq, gE, gs, gQ, gu };
  ArrayList<int[]> qf;
  private final int[][] r = { fE, this.fJ, this.fP, fQ, gN, this.fN, gw, this.gP, gp, gm, this.fU, fR, gb, gk, gK, gq, gE, gB, gz, this.gl, gI, gJ, gX, gV, ha, hb, hd, this.he, gc, gh, ge, gf, this.fO };
  private List<Integer> rD = new ArrayList();
  private final int[][] s = { fL, gF, gS, hc, fS, fT, gd, gC, gT, gO, gr, gL, gy, gt, gR, gW, fF, fH, gx, gg, gi };
  public SessionInfo sessionInfo;
  protected final int[][] t = { this.fU };
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Skd = null;
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Skd = null;
  }
  
  private boolean Rx()
  {
    if (this.sessionInfo.cZ != 1) {
      return false;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager.kB(this.sessionInfo.troopUin))
    {
      localTroopManager.FA(this.sessionInfo.troopUin);
      return true;
    }
    return false;
  }
  
  private boolean Ry()
  {
    return (this.sessionInfo.cZ == 1000) || (this.sessionInfo.cZ == 1004) || (this.sessionInfo.cZ == 1006) || (this.sessionInfo.cZ == 1003) || (this.sessionInfo.cZ == 1005) || (this.sessionInfo.cZ == 1021) || (this.sessionInfo.cZ == 1022) || (this.sessionInfo.cZ == 1023) || (this.sessionInfo.cZ == 1025) || (this.sessionInfo.cZ == 10004) || (this.sessionInfo.cZ == 10008);
  }
  
  private String S(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = akza.m(paramInt);
      if ((paramString != null) && (paramString.length >= 1)) {
        str = BaseApplicationImpl.getContext().getString(paramString[0]);
      }
    }
    else
    {
      return str;
    }
    return "";
  }
  
  private Drawable a(String paramString, int paramInt, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = akza.m(paramInt);
      if ((paramString != null) && (paramString.length >= 2)) {
        return BaseApplicationImpl.getContext().getResources().getDrawable(paramString[1]);
      }
    }
    else
    {
      return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(2130844474);
  }
  
  private String a(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    String str = paramTroopAIOAppInfo.name;
    switch (acha.Ax())
    {
    default: 
      return str;
    case 2052: 
      return paramTroopAIOAppInfo.name;
    }
    return paramTroopAIOAppInfo.enName;
  }
  
  private void a(a parama, altq paramaltq)
  {
    int m = 0;
    if (!TextUtils.isEmpty(parama.aTd))
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = paramaltq.a(10, parama.aTd);
      if (localAppInfo != null) {
        paramaltq.e(localAppInfo, "");
      }
    }
    int i;
    int j;
    label127:
    int k;
    label141:
    boolean bool;
    if ((parama.appid > 0) && (!this.rD.contains(Integer.valueOf(parama.appid))))
    {
      this.rD.add(Integer.valueOf(parama.appid));
      if ((this.sessionInfo.cZ != 0) && (!ChatActivityUtils.q(this.app, this.sessionInfo.aTl))) {
        break label215;
      }
      i = 1;
      if (this.sessionInfo.cZ != 3000) {
        break label220;
      }
      j = 1;
      if (this.sessionInfo.cZ != 1) {
        break label226;
      }
      k = 1;
      bool = Ry();
      if (i == 0) {
        break label232;
      }
      i = 1;
    }
    for (;;)
    {
      paramaltq = this.app;
      k = parama.appid;
      j = m;
      if (parama.beg) {
        j = 1;
      }
      anot.a(paramaltq, "dc00898", "", "", "0X800A46B", "0X800A46B", k, j, String.valueOf(i), "", "", "");
      return;
      label215:
      i = 0;
      break;
      label220:
      j = 0;
      break label127;
      label226:
      k = 0;
      break label141;
      label232:
      if (j != 0) {
        i = 2;
      } else if (k != 0) {
        i = 3;
      } else if (bool) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
  
  private void a(syw paramsyw)
  {
    if (this.sessionInfo.cZ == 0) {
      anpc.report("tim_msg_tab_c2c_aio_aio_plus_click_cloud_file_click");
    }
    for (;;)
    {
      Environment.getExternalStorageState();
      l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.sessionInfo.aTl);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          if ((this.sessionInfo.cZ == 9501) && (paramsyw != null) && (paramsyw.bn(l1)))
          {
            wmj.c(this.app, this.c.a(), this.sessionInfo);
          }
          else
          {
            xro.i(this.app, "0X800407C", this.sessionInfo.cZ);
            paramsyw = new ahau.a();
            paramsyw.bJE = "send_file";
            paramsyw.cYX = 1;
            ahau.a(this.app.getCurrentAccountUin(), paramsyw);
            auel.d(this.app, this.c.a(), this.sessionInfo);
          }
        }
      }
      if (this.sessionInfo.cZ != 1) {
        break;
      }
      anot.a(this.app, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
      auel.d(this.app, this.c.a(), this.sessionInfo);
      if (this.c != null) {
        this.c.a().setCanLock(false);
      }
      return;
      if (this.sessionInfo.cZ == 1) {
        anpc.report("tim_msg_tab_group_aio_aio_plus_click_cloud_file_click");
      }
    }
  }
  
  private boolean a(PanelAdapter.a parama)
  {
    if ((parama != null) && (this.bu != null) && (this.bu.indexOfKey(parama.appid) >= 0)) {
      return wmz.a((TroopAIOAppInfo)this.bu.get(parama.appid), this.c, parama);
    }
    return false;
  }
  
  private void aA(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = (HotChatManager)this.app.getManager(60);
    if ((localObject1 != null) && (((HotChatManager)localObject1).kj(this.sessionInfo.aTl))) {
      this.qf.add(fR);
    }
    do
    {
      for (;;)
      {
        return;
        if (this.bu != null) {
          this.bu.clear();
        }
        while (jof.a().dd(this.sessionInfo.aTl))
        {
          this.qf.add(fE);
          this.qf.add(this.fG);
          this.qf.add(gn);
          this.qf.add(go);
          return;
          this.bu = new SparseArray();
        }
        if (!TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.aTl)) {
          break;
        }
        this.qf.clear();
        localObject1 = this.t;
        int i = localObject1.length;
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = localObject1[paramInt];
          this.qf.add(localObject2);
          paramInt += 1;
        }
      }
      this.qf.add(fE);
      this.qf.add(this.fG);
      this.qf.add(this.fM);
      this.qf.add(gG);
      this.qf.add(this.fU);
      this.qf.add(gs);
      this.qf.add(gu);
      this.qf.add(gB);
      this.qf.add(this.fX);
      this.qf.add(gE);
      this.qf.add(gm);
      this.qf.add(gw);
      this.qf.add(gK);
      this.qf.add(fR);
      this.qf.add(this.fY);
      localObject1 = (TroopManager)this.app.getManager(52);
      if ((localObject1 != null) && (this.sessionInfo != null))
      {
        localObject1 = ((TroopManager)localObject1).b(this.sessionInfo.aTl);
        if ((localObject1 != null) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin()))) {
          this.qf.remove(gu);
        }
      }
    } while (paramInt != 3000);
    this.qf.remove(gu);
  }
  
  private void bZA()
  {
    ausj localausj = ausj.b(this.c.a());
    localausj.addButton(2131699510);
    localausj.addButton(2131699511);
    localausj.addCancelButton(2131721058);
    localausj.a(new wmd(this, localausj));
    localausj.show();
    anot.a(this.app, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
  }
  
  private void bZB()
  {
    if (this.app == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (this.sessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    if (jou.df(this.sessionInfo.aTl))
    {
      this.qf.add(fL);
      this.qf.add(gF);
      this.qf.add(fT);
      this.qf.add(gC);
      this.qf.add(fS);
      this.qf.add(gL);
    }
    for (;;)
    {
      anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
      return;
      if (ChatActivityUtils.e(this.app, this.sessionInfo))
      {
        this.qf.clear();
        this.qf.add(fL);
        this.qf.add(gF);
        this.qf.add(fS);
      }
      else if (this.app.getCurrentUin().equals(this.sessionInfo.aTl))
      {
        this.qf.add(fF);
        this.qf.add(fH);
        this.qf.add(gS);
        this.qf.add(gx);
        this.qf.add(fS);
        this.qf.add(fT);
        this.qf.add(gC);
      }
      else
      {
        this.qf.add(fF);
        this.qf.add(fH);
        this.qf.add(fL);
        this.qf.add(gF);
        this.qf.add(fT);
        this.qf.add(gt);
        this.qf.add(gv);
        this.qf.add(gC);
        this.qf.add(gS);
        this.qf.add(fS);
        this.qf.add(gr);
        this.qf.add(gw);
        this.qf.add(gK);
        if ((this.app.getAccount() != null) && (this.app.getAccount().equals(this.sessionInfo.aTl)))
        {
          this.qf.remove(gr);
          this.qf.remove(gS);
        }
      }
    }
  }
  
  private void bZE()
  {
    BaseActivity localBaseActivity = this.c.a();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    String str1 = localBaseActivity.getString(2131719220);
    Object localObject1 = localBaseActivity.getString(2131719217);
    Object localObject2 = localBaseActivity.getString(2131719218);
    String str4 = localBaseActivity.getString(2131719219);
    String str2 = localBaseActivity.getString(2131697810);
    String str3 = localBaseActivity.getString(2131697944);
    localObject1 = jkn.a((String)localObject1, (String)localObject2, str4);
    localObject1 = itq.a(localBaseActivity, ((jkn.b)localObject1).content, ((jkn.b)localObject1).SG, ((jkn.b)localObject1).link);
    localObject2 = PreferenceManager.getDefaultSharedPreferences(this.c.app.getApp());
    if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
    {
      itq.a(localBaseActivity, str1, (CharSequence)localObject1, str2, str3, true, 10, new wme(this), new wmf(this)).show();
      ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
      return;
    }
    aqha.a(localBaseActivity, 230, str1, (CharSequence)localObject1, str2, str3, new wmg(this), new wmh(this)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
  }
  
  private void bZF()
  {
    if (this.sessionInfo.cZ == 1)
    {
      d(10, false, "AIOShareScreen");
      jll.aw("0x800AD8E", 2);
    }
    do
    {
      return;
      if (this.sessionInfo.cZ == 0)
      {
        this.c.hidePanel();
        update();
        wmj.a(this.app, this.c.a(), this.sessionInfo, true, "AIOShareScreen", null);
        jll.aw("0x800AD8E", 1);
        this.c.a().setCanLock(false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PlusPanel", 2, "clickToolShareScreen, not support chat, [" + this.sessionInfo.cZ + "]");
  }
  
  private String cA(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2130839296: 
      return "0";
    case 2130839337: 
      return "1";
    case 2130839327: 
      return "3";
    case 2130845039: 
      return "4";
    case 2130839315: 
      return "5";
    case 2130839313: 
      return "6";
    }
    return "7";
  }
  
  private boolean hz(String paramString)
  {
    SharedPreferences localSharedPreferences = this.c.a().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio_new")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_poke")) {
      return a(this.app, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_poke_emo")) {
      return a(this.app, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_gift_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gift_stranger_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_tencentdoc")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.app.getCurrentAccountUin(), true);
  }
  
  private void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (!str.equals("")) {
        anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.sessionInfo.aTl, str, "", "");
      }
      if ((paramBoolean) && (paramInt2 != 0)) {
        anot.a(this.app, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, this.sessionInfo.aTl, String.valueOf(paramInt2), "", "");
      }
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
      continue;
      str = "23";
      continue;
      str = "4";
      continue;
      str = "5";
      continue;
      str = "6";
      continue;
      str = "8";
      continue;
      str = "24";
      continue;
      str = "9";
      continue;
      str = "11";
      continue;
      str = "22";
      continue;
      str = "12";
      continue;
      str = "13";
      continue;
      str = "14";
      continue;
      str = "15";
      continue;
      str = "16";
      continue;
      str = "17";
      continue;
      str = "18";
      continue;
      str = "21";
    }
  }
  
  private void xs(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Intent localIntent = new Intent(this.c.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.c.mContext.startActivity(localIntent);
    }
  }
  
  private void xt(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (MiniAppLauncher.isMiniAppUrl(paramString))) {
      MiniAppLauncher.startMiniApp(this.c.mContext, paramString, 2053, null);
    }
  }
  
  private void yC(boolean paramBoolean)
  {
    if (this.sessionInfo.cZ == 1) {}
    long l;
    HashMap localHashMap;
    try
    {
      l = Long.parseLong(this.sessionInfo.aTl);
      int i = jll.cL(this.sessionInfo.cZ);
      l = this.app.a().d(i, l);
      Object localObject = (apsw)this.app.getManager(48);
      boolean bool1 = ((apsw)localObject).bg(this.sessionInfo.aTl, this.app.getCurrentAccountUin());
      boolean bool2 = ((apsw)localObject).hs(this.sessionInfo.aTl);
      boolean bool3 = ((apsw)localObject).eL(this.sessionInfo.aTl);
      localObject = ((apsw)localObject).a(this.sessionInfo.aTl);
      if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((apsw.f)localObject).gagTimeStamp > 0L))))
      {
        QQToast.a(this.c.mContext, acfp.m(2131709784), 0).show(this.c.mContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l = 0L;
      }
      xu("chat_tool_gaudio");
      localHashMap = new HashMap();
      localHashMap.put("MultiAVType", String.valueOf(2));
      localHashMap.put("from", "Panel");
      if (!paramBoolean) {}
    }
    for (String str = "true";; str = "false")
    {
      localHashMap.put("publicClass", str);
      ChatActivityUtils.a(this.app, this.c.a(), this.sessionInfo.cZ, this.sessionInfo.aTl, localHashMap);
      this.c.hidePanel();
      update();
      if (this.c != null) {
        this.c.a().setCanLock(false);
      }
      l = Long.valueOf(this.sessionInfo.aTl).longValue();
      if (!this.app.a().j(1, l)) {
        anot.a(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.sessionInfo.aTl, "" + apuh.n(this.app, this.sessionInfo.aTl), "1", "");
      }
      xro.i(this.app, "0X8005CB5", this.sessionInfo.cZ);
      return;
    }
  }
  
  public void Cm(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", rov.getStackTrace(5) });
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.C(paramInt);
    altq localaltq = (altq)this.app.getManager(36);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(locala, localaltq);
      switch (locala.appid)
      {
      default: 
      case 1106717414: 
      case 1106729451: 
      case 101458937: 
        for (;;)
        {
          label156:
          if (locala.actionId == 2130839317)
          {
            anot.a(null, "dc00898", "", "", "0X800A11F", "0X800A11F", 0, 0, "", "", "", "");
            break;
            localObject = this.sessionInfo.aTl;
            aqfr.e(this.app, (String)localObject, "Grp_chain", "ChainEntry_Show");
            continue;
            localObject = this.sessionInfo.aTl;
            aqfr.e(this.app, (String)localObject, "MassMessage", "grpapp_Show");
            continue;
            localObject = (TroopManager)this.app.getManager(52);
            if (localObject == null) {
              break label434;
            }
          }
        }
      }
    }
    label434:
    for (localObject = ((TroopManager)localObject).b(this.sessionInfo.aTl);; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = "" + ((TroopInfo)localObject).dwGroupClassExt;; localObject = "")
      {
        anot.a(this.app, "dc00898", "", this.sessionInfo.aTl, "0X8009E24", "0X8009E24", 0, 0, "", "", "" + (String)localObject, "");
        anot.a(this.app, "dc00898", "", this.sessionInfo.aTl, "0X8009FCC", "0X8009FCC", 0, 0, "", "", "", "");
        break label156;
        break;
        if (paramInt == this.bPn) {
          TroopGiftPanel.eH(paramInt, this.byr);
        }
        return;
      }
    }
  }
  
  public void Cn(int paramInt)
  {
    if (paramInt == 1106717414)
    {
      str = this.sessionInfo.aTl;
      aqfr.e(this.app, str, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    String str = this.sessionInfo.aTl;
    aqfr.e(this.app, str, "MassMessage", "grpapp_Clk");
  }
  
  protected void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.sessionInfo = paramSessionInfo;
    this.app = paramBaseChatPie.getApp();
    this.c = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368755));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368721));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext(), this.app);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.w(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    a(this);
    paramBaseChatPie = getResources().getDrawable(2130851275);
    if ((paramBaseChatPie instanceof BitmapDrawable))
    {
      ((BitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
      if (!(this.c instanceof TroopChatPie)) {
        break label207;
      }
      this.byr = 1;
    }
    for (;;)
    {
      reload();
      return;
      if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
        break;
      }
      ((SkinnableBitmapDrawable)paramBaseChatPie).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((SkinnableBitmapDrawable)paramBaseChatPie).setDither(true);
      setBackgroundDrawable(paramBaseChatPie);
      break;
      label207:
      if ((this.c instanceof xys)) {
        this.byr = 2;
      } else if ((this.c instanceof xyi)) {
        this.byr = 6;
      } else if ((this.c instanceof ydz)) {
        this.byr = 7;
      } else if ((this.c instanceof ybt)) {
        this.byr = 3;
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = xks.c(paramQQAppInterface, 0);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(xks.TAG, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + " getPokeMsgFoldSwitch=" + i + " hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public void bZC()
  {
    this.bej = false;
  }
  
  public void bZD()
  {
    this.bej = false;
    this.beh = false;
  }
  
  public void bZG()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 21) {
      i = 1;
    }
    if (i == 0) {
      try
      {
        BaseActivity localBaseActivity = this.c.a();
        Resources localResources = localBaseActivity.getResources();
        aqha.a(localBaseActivity, 230, localResources.getString(2131692674), localResources.getString(2131698073), 0, 2131697810, new wma(this), null).show();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("PlusPanel", 1, "clickToolShareScreen", localThrowable);
        return;
      }
    }
    bZE();
  }
  
  public void bZH()
  {
    if (this.sessionInfo.cZ == 1) {
      d(10, true, null);
    }
    long l;
    do
    {
      return;
      if (this.sessionInfo.cZ != 3000) {
        break;
      }
      xu("chat_tool_gaudio");
      d(1, true, null);
      update();
      this.c.a().setCanLock(false);
      l = Long.valueOf(this.sessionInfo.aTl).longValue();
    } while (this.app.a().bG() == l);
    anot.a(this.app, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
    return;
    if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
    {
      anot.a(this.app, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
      if (!acgr.y(this.app, this.sessionInfo.aTl))
      {
        this.c.vh(BaseApplicationImpl.getContext().getString(2131696216));
        anot.a(this.app, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        anot.a(this.app, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.app;
        if (this.sessionInfo.cZ == 1001) {}
        for (String str = "0";; str = "1")
        {
          anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "1", "", "");
          return;
        }
      }
    }
    else if ((this.sessionInfo.cZ == 1010) && (!afck.F(this.app, this.sessionInfo.aTl)))
    {
      this.c.vh(BaseApplicationImpl.getContext().getString(2131696216));
      return;
    }
    this.c.bId();
    wmj.a(this.app, this.c.a(), this.sessionInfo, false, null, null);
    this.c.hidePanel();
    this.c.a().setCanLock(false);
    xro.i(this.app, "0X8004086", this.sessionInfo.cZ);
  }
  
  public void bZI()
  {
    if (this.sessionInfo.cZ == 1) {
      d(10, false, null);
    }
    long l;
    do
    {
      return;
      if (this.sessionInfo.cZ != 3000) {
        break;
      }
      xu("chat_tool_gaudio");
      d(1, false, null);
      update();
      this.c.a().setCanLock(false);
      l = Long.valueOf(this.sessionInfo.aTl).longValue();
    } while (this.app.a().bG() == l);
    anot.a(this.app, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
    return;
    if ((this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002))
    {
      anot.a(this.app, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
      if (!acgr.y(this.app, this.sessionInfo.aTl))
      {
        this.c.vh(BaseApplicationImpl.getContext().getString(2131696215));
        anot.a(this.app, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
        QQAppInterface localQQAppInterface = this.app;
        if (this.sessionInfo.cZ == 1001) {}
        for (String str = "0";; str = "1")
        {
          anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str, "0", "", "");
          return;
        }
      }
    }
    else if ((this.sessionInfo.cZ == 1010) && (!afck.F(this.app, this.sessionInfo.aTl)))
    {
      this.c.vh(BaseApplicationImpl.getContext().getString(2131696215));
      anot.a(this.app, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
      return;
    }
    xu("chat_tool_audio");
    this.c.hidePanel();
    update();
    if (this.sessionInfo.cZ == 1024)
    {
      if (((asgx)this.app.getManager(165)).sJ(this.sessionInfo.aTl))
      {
        wmj.a(this.app, this.c.a(), this.sessionInfo, true, null, null);
        return;
      }
      if (jqs.c(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ))
      {
        jqs.a(this.app, this.c.a(), this.sessionInfo, "IvrAIOBottomButtonEngineFalse");
        anot.a(this.app, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.c.a().setCanLock(false);
      xro.i(this.app, "0X800407B", this.sessionInfo.cZ);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131697893, 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "Don't support ivr");
        continue;
        wmj.a(this.app, this.c.a(), this.sessionInfo, true, null, null);
      }
    }
  }
  
  void d(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt == 10) {
      aqji.c.SG(paramBoolean);
    }
    xrc.a(this.app, getContext(), this.sessionInfo, paramInt, paramBoolean, this.app.getCurrentUin(), paramString);
    this.c.hidePanel();
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    PanelAdapter.a locala = (PanelAdapter.a)paramView.getTag();
    int m = locala.actionId;
    int n = locala.appid;
    int i = 0;
    if (Rx())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.sessionInfo.cZ == 9501) {}
    for (;;)
    {
      int k;
      boolean bool;
      Object localObject2;
      try
      {
        Object localObject1 = syw.b(this.app, Long.parseLong(this.sessionInfo.aTl));
        if (localObject1 != null) {
          i = ((DeviceInfo)localObject1).productId;
        }
        j = i;
        if (!TextUtils.isEmpty(locala.aTd))
        {
          localObject1 = (altq)this.app.getManager(36);
          ((altq)localObject1).d(((altq)localObject1).a(10, locala.aTd), "");
        }
        if (n > 0)
        {
          if ((this.sessionInfo.cZ == 0) || (ChatActivityUtils.q(this.app, this.sessionInfo.aTl)))
          {
            i = 1;
            if (this.sessionInfo.cZ != 3000) {
              continue;
            }
            k = 1;
            bool = Ry();
            if (i == 0) {
              continue;
            }
            i = 1;
            localObject1 = this.app;
            if (!locala.beg) {
              continue;
            }
            k = 1;
            anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A46C", "0X800A46C", n, k, String.valueOf(i), "", "", "");
          }
        }
        else
        {
          this.c.bIZ();
          if (!"web".equals(locala.actionType)) {
            continue;
          }
          xs(locala.action);
        }
      }
      catch (Exception localException1)
      {
        j = 0;
        continue;
        i = 0;
        continue;
        k = 0;
        continue;
        if (k != 0)
        {
          i = 2;
          continue;
        }
        if (this.sessionInfo.cZ == 1)
        {
          i = 3;
          continue;
        }
        if (bool)
        {
          i = 4;
          continue;
        }
        i = 5;
        continue;
        k = 0;
        continue;
        if ("miniapp".equals(locala.actionType))
        {
          xt(locala.action);
          break;
        }
        localObject2 = (syw)this.app.getBusinessHandler(51);
        switch (m)
        {
        default: 
          if (!a(locala)) {
            break label7397;
          }
        }
      }
      label853:
      Object localObject6;
      for (;;)
      {
        if (this.sessionInfo.cZ == 1)
        {
          if (((HotChatManager)this.app.getManager(60)).kj(this.sessionInfo.aTl)) {
            break;
          }
          if (this.bu == null)
          {
            localObject2 = null;
            label899:
            localObject6 = (aprp)this.app.getManager(109);
            if ((localObject2 != null) && (((TroopAIOAppInfo)localObject2).redPoint))
            {
              aoxw.a(this.app).Ws(((TroopAIOAppInfo)localObject2).appid);
              ThreadManager.post(new PlusPanel.4(this, (aprp)localObject6, (TroopAIOAppInfo)localObject2), 8, null, false);
            }
            if ((localObject2 == null) || (!((TroopAIOAppInfo)localObject2).canRemove)) {
              break label7426;
            }
            bool = true;
            label976:
            o(m, locala.appid, bool);
            if (localObject6 == null) {
              break;
            }
            ((aprp)localObject6).g(locala.appid, false, this.sessionInfo.aTl);
            break;
            if (this.c == null) {
              continue;
            }
            this.c.Ag(24);
            continue;
            atni.aU("0X8007922", 0, 1);
            atni.eM(this.app);
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("param_uin", this.sessionInfo.aTl);
            ((Intent)localObject2).putExtra("param_uin_type", this.sessionInfo.cZ);
            if ((this.sessionInfo.cZ == 1004) || (this.sessionInfo.cZ == 1000)) {
              ((Intent)localObject2).putExtra("param_source", this.sessionInfo.aTm);
            }
            ((Intent)localObject2).putExtra("param_entrance", 3);
            atni.startPluginActivityForResult(this.c.a(), "com.dingdong.business.Schedule.Activity.NewScheduleActivity", (Intent)localObject2, -1);
            anpc.report("tim_mine_tab_agenda_click_add_agenda_click");
            if (this.sessionInfo.cZ == 0)
            {
              anpc.report("tim_msg_tab_c2c_aio_aio_plus_click_agenda_click");
              continue;
            }
            if (this.sessionInfo.cZ != 1) {
              continue;
            }
            anpc.report("tim_msg_tab_group_aio_aio_plus_click_agenda_click");
            continue;
            this.c.k(Integer.valueOf(6));
            continue;
            if (!VideoEnvironment.o(this.app))
            {
              aqha.a(this.c.a(), 230).setMessage(acfp.m(2131709774)).setPositiveButton(2131721079, new wmb(this)).show();
              continue;
            }
            if (!BaseChatpieHelper.v(this.app)) {
              continue;
            }
            this.c.Al(2);
            continue;
            if ((!anlm.ayn()) && (!(this.c instanceof ydw))) {}
            this.c.k(Integer.valueOf(4));
            if (QLog.isColorLevel()) {
              QLog.d("PlusPanel", 2, "report() called with plus from simple!");
            }
            if (anlm.ayn()) {
              anot.a(null, "dc00898", "", "", "0X800A113", "0X800A113", 0, 0, "", "", "", "");
            }
            if (!(this.c instanceof ydw)) {
              continue;
            }
            anot.a(null, "dc00898", "", "", "0X800A489", "0X800A489", 0, 0, "", "", "", "");
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("testing", 2, "deliver flowers!");
            }
            if (n != 213) {}
          }
        }
      }
      for (;;)
      {
        long l1;
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject2 = QzoneConfig.getInstance().getConfig("H5Url", "C2CPlusGiftJumpUrl", "https://h5.qzone.qq.com/giftv2/sendDialog?_wv=16781315&_wwv=13&_proxy=1&themeMode={themeMode}&uin={uin}");
              if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                continue;
              }
              i = 1;
              localObject2 = ((String)localObject2).replace("{uin}", this.sessionInfo.aTl).replace("{themeMode}", i + "");
              localObject6 = new Intent(this.c.a(), QQTranslucentBrowserActivity.class);
              ((Intent)localObject6).putExtra("url", (String)localObject2);
              ((Intent)localObject6).setData(Uri.parse((String)localObject2));
              ((Intent)localObject6).putExtra("flag_show_loading_dialog", true);
              ((Intent)localObject6).putExtra("hide_left_button", true);
              this.c.a().startActivity((Intent)localObject6);
              bool = false;
            }
            catch (Exception localException2)
            {
              QLog.e("PlusPanel", 2, localException2, new Object[0]);
              bool = false;
              continue;
            }
            Object localObject3;
            if ((this.c instanceof ybt))
            {
              localObject6 = this.sessionInfo.aTl;
              if (this.c.sessionInfo.cZ == 10002)
              {
                localObject2 = "3";
                acie.i("gift_aio", "clk_icon", (String)localObject6, (String)localObject2, "", "");
                anot.a(this.app, "dc00899", "grp_lbs", "", "qq_gift", "plus_entry_clk", 0, 0, this.byr + "", "", "", "");
                if (QLog.isColorLevel()) {
                  QLog.d("PlusPanel", 2, "PlusPanel onGiftClick, aioType=" + this.byr);
                }
                if (this.byr != 7) {
                  break label2197;
                }
                localObject2 = "chat_tool_gift_stranger_clicked";
                xu((String)localObject2);
                update();
                break;
                i = 0;
                continue;
                this.c.wh(true);
                l1 = System.currentTimeMillis();
                localObject3 = this.c.a();
                if (localObject3 == null) {
                  break label7566;
                }
                long l2 = ((snf)localObject3).date;
                if ((!((snf)localObject3).MX) || (l1 < ((snf)localObject3).date) || (l1 > l2 + 2592000000L) || (((apsz)this.app.getManager(113)).aBx())) {
                  break label7566;
                }
                bool = true;
                continue;
              }
              localObject3 = "0";
              continue;
            }
            if (this.byr == 2) {
              anot.a(this.app, "dc00899", "Grp_flower", "", "C2C", "gift_clk", 0, 0, "", "", "", "");
            } else if (this.byr == 6) {
              anot.a(this.app, "dc00899", "Grp_flower", "", "discuss_grp", "gift_clk", 0, 0, "", "", "", "");
            } else if (this.byr == 7) {
              anot.a(this.app, "dc00899", "Grp_flower", "", "temp_c2c", "gift_clk", 0, 0, "", "", "", "");
            } else if (this.byr == 1) {
              if (jof.a().dd(this.sessionInfo.aTl))
              {
                anot.a(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, "" + this.sessionInfo.aTl, "", "", "");
              }
              else
              {
                anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + this.sessionInfo.aTl, "" + bool, "", "");
                continue;
                label2197:
                localObject3 = "chat_tool_gift_clicked";
                continue;
                new airf(this.app, this.c).show();
                break;
                bZH();
                break;
                if (!(this.c instanceof ycd)) {
                  break;
                }
                ((ycd)this.c).ue.performClick();
                break;
                bZI();
                break;
                try
                {
                  bZA();
                }
                catch (Exception localException3)
                {
                  QLog.d("PlusPanel", 1, "showTroopCourseActionSheet() func call Exception", localException3);
                }
              }
            }
          }
          break;
          try
          {
            yC(false);
          }
          catch (Exception localException4)
          {
            QLog.d("PlusPanel", 1, "handleTroopLiveOrTroopCourseClick Exception", localException4);
          }
        }
        break label853;
        xu("chat_tool_tencentdoc");
        update();
        aobw.a(this.app, this.c.a(), this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.aTn);
        if (this.sessionInfo.cZ == 0)
        {
          xro.i(this.app, "0X80093F4", this.sessionInfo.cZ);
          break label853;
        }
        if (this.sessionInfo.cZ == 3000)
        {
          xro.i(this.app, "0X80093F6", this.sessionInfo.cZ);
          break label853;
        }
        if (this.sessionInfo.cZ != 1) {
          break label853;
        }
        xro.i(this.app, "0X80093F8", this.sessionInfo.cZ);
        break label853;
        xu("chat_tool_tencentdoc");
        update();
        aobw.a(this.app, this.c.a(), this.sessionInfo.aTl, this.sessionInfo.cZ, this.sessionInfo.aTn);
        if (this.sessionInfo.cZ != 1) {
          break label853;
        }
        Object localObject4 = (TroopManager)this.app.getManager(52);
        if (localObject4 != null) {}
        label2779:
        label3198:
        Object localObject5;
        for (localObject4 = ((TroopManager)localObject4).b(this.sessionInfo.aTl);; localObject5 = null)
        {
          if (localObject4 != null) {}
          for (localObject4 = "" + ((TroopInfo)localObject4).dwGroupClassExt;; localObject5 = "")
          {
            anot.a(this.app, "dc00898", "", this.sessionInfo.aTl, "0X8009E25", "0X8009E25", 0, 0, "", "", "" + (String)localObject4, "");
            break label853;
            if (!CheckPermission.isHasStoragePermission(this.c.a()))
            {
              CheckPermission.requestSDCardPermission(this.c.a(), new wmc(this, (syw)localObject4));
              break;
            }
            a((syw)localObject4);
            break label853;
            xu("chat_tool_qlink_file");
            update();
            ahav.h(this.c.a(), this.app.getCurrentAccountUin(), this.sessionInfo.aTl, this.sessionInfo.aTn);
            anot.a(this.app, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
            break label853;
            i = 1;
            if (this.HY == -1L)
            {
              if (i == 0) {
                break label2848;
              }
              ujt.c(this.app, this.c.a(), this.sessionInfo);
              this.HY = System.currentTimeMillis();
            }
            for (;;)
            {
              xro.i(this.app, "0X8004081", this.sessionInfo.cZ);
              break;
              if (System.currentTimeMillis() - this.HY >= 10000L) {
                break label2779;
              }
              i = 0;
              break label2779;
              label2848:
              QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131709779), 0).show();
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putInt("forward_type", 23);
            ((Bundle)localObject4).putInt("curent_aio_uin_type", this.sessionInfo.cZ);
            ((Bundle)localObject4).putString("curent_aio_uinname", this.sessionInfo.aTn);
            ((Bundle)localObject4).putString("curent_aio_uin", this.sessionInfo.aTl);
            ((Bundle)localObject4).putString("curent_aio_troop_uin", this.sessionInfo.troopUin);
            ((Bundle)localObject4).putBoolean("only_single_selection", true);
            localObject6 = new Intent();
            ((Intent)localObject6).putExtras((Bundle)localObject4);
            ahgq.f(this.c.a(), (Intent)localObject6, 21);
            xro.i(this.app, "0X80056B3", this.sessionInfo.cZ);
            xro.i(this.app, "0X8007010", this.sessionInfo.cZ);
            break label853;
            if ((this.c != null) && (this.c.a() == null)) {
              break;
            }
            localObject4 = jml.a().H("aio_qqMusicShare", "");
            wmj.a(this.app, this.c.a(), this.sessionInfo, (String)localObject4);
            this.c.a().setCanLock(false);
            xro.i(this.app, "0X8004083", this.sessionInfo.cZ);
            break label853;
            if ((this.c != null) && (this.c.a() == null)) {
              break;
            }
            if (this.sessionInfo.cZ == 0)
            {
              k = 2;
              j = 0;
            }
            for (;;)
            {
              label3144:
              if (k == 0) {
                break label7550;
              }
              if (j != 0)
              {
                localObject4 = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
                localObject6 = this.app.getCurrentAccountUin();
                if (((TroopInfo)localObject4).isTroopOwner((String)localObject6)) {
                  i = 0;
                }
              }
              for (;;)
              {
                aiob.b(this.app, this.c.a(), k, this.sessionInfo.aTl, 0);
                if ((j == 0) && (aiob.a(this.app, "listen_together_c2c_aio_red_dot_show", true, false)))
                {
                  aiob.a(this.app, "listen_together_c2c_aio_red_dot_show", false, false);
                  update();
                }
                if (j == 0) {}
                for (localObject4 = "c2c_AIO";; localObject4 = "Grp_AIO")
                {
                  anot.a(null, "dc00899", (String)localObject4, "", "music_tab", "clk_panelmusic", 0, 0, this.sessionInfo.aTl, i + "", i + "", "");
                  break;
                  if (this.sessionInfo.cZ != 1) {
                    break label7544;
                  }
                  k = 1;
                  j = 1;
                  break label3144;
                  if (((TroopInfo)localObject4).isTroopAdmin((String)localObject6))
                  {
                    i = 1;
                    break label3198;
                  }
                  i = 2;
                  break label3198;
                }
                localObject4 = null;
                i = -1;
                j = -1;
                localObject6 = new Bundle();
                Object localObject8 = this.app.getCurrentAccountUin();
                Object localObject7 = (aohy)this.app.getManager(339);
                bool = ((aohy)localObject7).e(4, -1, this.sessionInfo.aTl);
                if (this.sessionInfo.cZ == 1)
                {
                  j = 0;
                  localObject4 = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
                  if (localObject4 == null) {
                    break;
                  }
                  localObject6 = aoij.a(bool, ((TroopInfo)localObject4).isTroopOwner((String)localObject8), ((TroopInfo)localObject4).isAdmin(), ((TroopInfo)localObject4).troopowneruin, this.sessionInfo.aTl, 0);
                  ((aohy)localObject7).g("sing_tab", "clk_panelsing", 0, this.sessionInfo.aTl);
                  i = 1;
                  localObject4 = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                    break label3629;
                  }
                  break;
                  if (this.sessionInfo.cZ == 0)
                  {
                    localObject6 = aoij.a(bool, 3);
                    anot.a(this.c.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_panelsing", 0, 0, this.sessionInfo.aTl, "", "", "");
                    j = 3;
                    i = 2;
                    localObject4 = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                  }
                }
                label3629:
                if (bool)
                {
                  ((aohy)localObject7).b(getContext(), this.sessionInfo.aTl, i, 4, j, (Bundle)localObject6);
                  break label853;
                }
                ((aohy)localObject7).a(getContext(), this.sessionInfo.aTl, i, 4, j, (Bundle)localObject6);
                break label853;
                if (((this.c != null) && (this.c.a() == null)) || (this.sessionInfo.cZ != 1)) {
                  break;
                }
                localObject4 = (aeof)aeif.a().o(535);
                if ((localObject4 == null) || (((aeof)localObject4).a == null))
                {
                  QQToast.a(getContext(), 0, 2131694552, 0).show();
                  break;
                }
                localObject6 = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
                if (localObject6 == null) {
                  break;
                }
                localObject7 = (aohy)this.app.getManager(339);
                bool = ((aohy)localObject7).e(2, 1, ((TroopInfo)localObject6).uin);
                localObject8 = aoij.a(bool, ((TroopInfo)localObject6).isTroopOwner(this.app.getCurrentAccountUin()), ((TroopInfo)localObject6).isAdmin(), ((TroopInfo)localObject6).troopowneruin, this.sessionInfo.aTl, 0);
                switch (((aeof)localObject4).a.getVersion())
                {
                default: 
                  if (((aohy)localObject7).a(getContext(), 2, ((TroopInfo)localObject6).troopuin, 0)) {
                    if (QLog.isColorLevel()) {
                      QLog.d("PlusPanel", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
                    }
                  }
                  break;
                }
                while (aoij.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false))
                {
                  aoij.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", false, false);
                  update();
                  break;
                  QQToast.a(getContext(), 0, 2131694552, 0).show();
                  continue;
                  if (!((TroopInfo)localObject6).isAdmin())
                  {
                    if (bool) {
                      ((aohy)localObject7).b(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                    } else {
                      ((aohy)localObject7).a(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                    }
                  }
                  else if (bool)
                  {
                    ((aohy)localObject7).b(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                  }
                  else
                  {
                    ((aohy)localObject7).a(getContext(), ((TroopInfo)localObject6).troopuin, 1, 2, 0, (Bundle)localObject8);
                    continue;
                    ((aohy)localObject7).g("video_tab", "clk_panelvideo", 0, ((TroopInfo)localObject6).troopuin);
                    aoij.a(this.app, ((aeof)localObject4).a.getJumpType(), ((aeof)localObject4).a.getJumpUrl(), ((aeof)localObject4).a.tC(), (Bundle)localObject8, 1);
                  }
                }
                skd.a().a(this.c.a(), "200002", "https://m.dianping.com/qq/aiodwonload", this.sessionInfo);
                skd.i("200002", "click_app", "", "", "");
                xro.i(this.app, "0X8005CB2", this.sessionInfo.cZ);
                break label853;
                apuh.a(this.app, this.c.a(), this.sessionInfo.aTl, "0");
                xro.i(this.app, "0X8005CB6", this.sessionInfo.cZ);
                break label853;
                localObject4 = new Bundle();
                ((Bundle)localObject4).putString("troop_uin", this.sessionInfo.aTl);
                ((Bundle)localObject4).putBoolean("hide_operation_bar", true);
                ((Bundle)localObject4).putBoolean("hide_more_button", true);
                ((Bundle)localObject4).putBoolean("isScreenOrientationPortrait", true);
                apuh.a(this.app, this.c.a(), (Bundle)localObject4);
                xro.i(this.app, "0X8005CB8", this.sessionInfo.cZ);
                break label853;
                if (!jof.a().dd(this.sessionInfo.aTl))
                {
                  aogk.a().QP(true);
                  xu("chat_tool_anonymous");
                  update();
                  if ((this.c instanceof TroopChatPie))
                  {
                    ((TroopChatPie)this.c).br(2, "");
                    ((acms)this.app.getBusinessHandler(20)).J(1, this.app.getCurrentAccountUin(), this.sessionInfo.aTl);
                    anot.c(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.sessionInfo.aTl), "", "", "");
                    xro.i(this.app, "0X8005CB4", this.sessionInfo.cZ);
                    break label853;
                  }
                  break;
                }
                if ((this.c instanceof TroopChatPie))
                {
                  ((TroopChatPie)this.c).zh(false);
                  aogk.a().QP(false);
                  anot.c(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.sessionInfo.aTl), "", "", "");
                  break label853;
                }
                break;
                if (!jof.a().dd(this.sessionInfo.aTl)) {
                  break label853;
                }
                localObject4 = this.app.getCurrentAccountUin();
                localObject6 = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
                if ((localObject6 != null) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
                  if ((((TroopInfo)localObject6).Administrator != null) && (((TroopInfo)localObject6).Administrator.contains((CharSequence)localObject4))) {
                    i = 3;
                  }
                }
                for (;;)
                {
                  label4669:
                  localObject4 = jof.a().a(this.sessionInfo.aTl);
                  localObject6 = new Intent(this.c.a(), QQBrowserActivity.class);
                  localObject7 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(this.sessionInfo.aTl).append("&avatar=").append(jof.aV(((jof.b)localObject4).aCw)).append("&nick=");
                  if (TextUtils.isEmpty(((jof.b)localObject4).nickName)) {}
                  for (localObject4 = "";; localObject4 = URLEncoder.encode(((jof.b)localObject4).nickName))
                  {
                    ((Intent)localObject6).putExtra("url", (String)localObject4 + "&role=" + String.valueOf(i) + "&self=1");
                    this.c.a().startActivity((Intent)localObject6);
                    anot.a(this.app, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, this.sessionInfo.aTl, String.valueOf(i), "", "");
                    break;
                    if (((String)localObject4).equals(((TroopInfo)localObject6).troopowneruin))
                    {
                      i = 2;
                      break label4669;
                    }
                    i = 1;
                    break label4669;
                  }
                  xu("chat_tool_qwallettransfer");
                  update();
                  localObject6 = new Intent(this.c.a(), TransactionActivity.class);
                  ((Intent)localObject6).putExtra("come_from", 2);
                  j = 0;
                  i = 0;
                  localObject4 = null;
                  switch (this.sessionInfo.cZ)
                  {
                  }
                  for (;;)
                  {
                    localObject7 = new JSONObject();
                    try
                    {
                      ((JSONObject)localObject7).put("targetUin", this.sessionInfo.aTl);
                      ((JSONObject)localObject7).put("targetNickname", this.sessionInfo.aTn);
                      ((JSONObject)localObject7).put("sign", "");
                      if (j != 0) {
                        ((JSONObject)localObject7).put("source", j);
                      }
                      ((JSONObject)localObject7).put("group_type", i);
                      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                        ((JSONObject)localObject7).put("group_uin", localObject4);
                      }
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        localJSONException.printStackTrace();
                      }
                    }
                    ((Intent)localObject6).putExtra("extra_data", ((JSONObject)localObject7).toString());
                    ((Intent)localObject6).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
                    ((Intent)localObject6).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + this.sessionInfo.cZ, 0, null));
                    this.c.a().startActivity((Intent)localObject6);
                    anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
                    xro.i(this.app, "0X8005CB0", this.sessionInfo.cZ);
                    break;
                    j = 5;
                    i = 3;
                    localObject4 = this.sessionInfo.troopUin;
                    continue;
                    j = 5;
                    i = 4;
                    localObject4 = this.sessionInfo.troopUin;
                  }
                  szc.bi(this.c.a());
                  if ((this.sessionInfo.cZ != 9501) || (TextUtils.isEmpty(this.sessionInfo.aTl))) {
                    break label853;
                  }
                  tar.a(this.app, Long.parseLong(this.sessionInfo.aTl), "Usr_AIO_SendMsg", 4, 0, j);
                  break label853;
                  l1 = System.currentTimeMillis();
                  if (Math.abs(l1 - this.dr) < 1000L) {
                    break;
                  }
                  this.dr = l1;
                  update();
                  if (this.c != null)
                  {
                    this.c.Ag(10);
                    wmj.Co(0);
                  }
                  localObject5 = "";
                  if ((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 1000) || (this.sessionInfo.cZ == 1004) || (this.sessionInfo.cZ == 1001) || (this.sessionInfo.cZ == 10002) || (this.sessionInfo.cZ == 10004) || (this.sessionInfo.cZ == 10008)) {
                    localObject5 = "entrance.click.c2c.plus";
                  }
                  for (;;)
                  {
                    anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", (String)localObject5, 0, 0, "", "", "", "");
                    break;
                    if (this.sessionInfo.cZ == 3000) {
                      localObject5 = "entrance.click.group.plus";
                    } else if (this.sessionInfo.cZ == 1) {
                      localObject5 = "entrance.click.chatgroup.plus";
                    }
                  }
                  xu("chat_tool_qfav");
                  update();
                  if (this.c == null) {
                    break label853;
                  }
                  wmj.b(this.app, this.c.a(), this.sessionInfo);
                  this.c.a().setCanLock(false);
                  xro.i(this.app, "0X8005CB1", this.sessionInfo.cZ);
                  break label853;
                  xu("chat_tool_dingyue");
                  update();
                  localObject5 = new Intent(this.c.a(), QQBrowserActivity.class);
                  ((Intent)localObject5).putExtra("url", "https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + this.sessionInfo.aTl);
                  this.c.a().startActivity((Intent)localObject5);
                  anot.a(this.app, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
                  break label853;
                  xu("chat_tool_toupiao");
                  update();
                  localObject5 = new Intent(this.c.a(), QQBrowserActivity.class);
                  ((Intent)localObject5).putExtra("selfSet_leftViewText", acfp.m(2131709772));
                  ((Intent)localObject5).putExtra("url", "https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + this.sessionInfo.aTl + "&src=3");
                  this.c.a().startActivity((Intent)localObject5);
                  anot.a(this.app, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
                  xro.i(this.app, "0X8005CB9", this.sessionInfo.cZ);
                  break label853;
                  localObject5 = new Intent(this.c.a(), QQBrowserActivity.class);
                  ((Intent)localObject5).putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793&f=6&uintype=3000&touin=" + this.sessionInfo.aTl);
                  ((Intent)localObject5).putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
                  this.c.a().startActivity((Intent)localObject5);
                  anot.a(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
                  xro.i(this.app, "0X8005CBB", this.sessionInfo.cZ);
                  break label853;
                  localObject5 = new Intent(this.c.a(), QQBrowserActivity.class);
                  ((Intent)localObject5).putExtra("url", "https://mqq.tenpay.com/mqq/groupreceipts/index.shtml?uin=$GCODE$&type=4&_wv=1027&_wvx=4".replace("$GCODE$", this.sessionInfo.aTl));
                  this.c.a().startActivity((Intent)localObject5);
                  break label853;
                  localObject5 = new Intent(this.c.a(), QQBrowserActivity.class);
                  ((Intent)localObject5).putExtra("url", "https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=" + this.sessionInfo.aTl + "&state=1");
                  this.c.a().startActivity((Intent)localObject5);
                  break label853;
                  if ((this.bu == null) || (this.bu.indexOfKey(locala.appid) < 0)) {
                    break label853;
                  }
                  localObject5 = (TroopAIOAppInfo)this.bu.get(locala.appid);
                  localObject6 = new Intent(this.c.a(), QQBrowserActivity.class);
                  if ((localObject5 == null) || (((TroopAIOAppInfo)localObject5).url == null)) {
                    break label853;
                  }
                  ((Intent)localObject6).putExtra("url", ((TroopAIOAppInfo)localObject5).url.replace("$GCODE$", this.sessionInfo.aTl));
                  this.c.a().startActivity((Intent)localObject6);
                  xro.i(this.app, "0X8005CBA", this.sessionInfo.cZ);
                  break label853;
                  if (localObject5 == null) {
                    break label853;
                  }
                  localObject6 = syw.b(this.app, Long.parseLong(this.sessionInfo.aTl));
                  if (localObject6 == null) {
                    break label853;
                  }
                  ((syw)localObject5).a(this.c.a(), (DeviceInfo)localObject6, false);
                  break label853;
                  bool = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_" + this.app.getCurrentAccountUin(), false);
                  xu("chat_tool_apollo");
                  if (bool) {
                    update();
                  }
                  for (i = 1;; i = 0)
                  {
                    if (this.c != null) {
                      this.c.Ae(0);
                    }
                    localObject5 = (abhh)this.app.getManager(153);
                    localObject6 = this.app;
                    localObject7 = this.sessionInfo.aTl;
                    j = ((abhh)localObject5).cd(this.app.getCurrentUin());
                    k = ApolloUtil.gp(abhh.x(this.app));
                    localObject8 = "" + i;
                    if (this.sessionInfo.cZ == 0) {}
                    for (localObject5 = "0";; localObject5 = "2")
                    {
                      VipUtils.a((AppInterface)localObject6, "cmshow", "Apollo", "panel_enter_clk", (String)localObject7, j, k, new String[] { localObject8, localObject5, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                      break;
                    }
                    this.app.a().dNS();
                    if (((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 3000)) && (ScribbleResMgr.Y(this.app.getApp().getBaseContext(), this.app.getCurrentAccountUin())))
                    {
                      ScribbleResMgr.bQ(this.app.getApp().getBaseContext(), this.app.getCurrentAccountUin());
                      update();
                    }
                    this.c.bIT();
                    break label853;
                    localObject5 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
                    if (a(this.app, (SharedPreferences)localObject5))
                    {
                      xu("chat_tool_poke");
                      if (Build.VERSION.SDK_INT <= 8) {
                        break label6789;
                      }
                      ((SharedPreferences)localObject5).edit().putBoolean("chat_tool_poke_clicked", true).apply();
                    }
                    for (;;)
                    {
                      update();
                      this.c.bIl();
                      this.app.reportClickEvent("CliOper", "0X8007F21");
                      if (!(this.c instanceof xwq)) {
                        break;
                      }
                      xro.a(this.app, "0X8008AAA", "C_Master_PTT", this.sessionInfo);
                      break;
                      label6789:
                      ((SharedPreferences)localObject5).edit().putBoolean("chat_tool_poke_clicked", true).commit();
                    }
                    this.c.bID();
                    break label853;
                    this.c.bIm();
                    break label853;
                    this.c.bIR();
                    break label853;
                    if (aqmj.aF(getContext(), this.app.getCurrentAccountUin())) {
                      TroopPicEffectsEditActivity.f(this.c.a(), this.sessionInfo.aTl, this.sessionInfo.troopUin);
                    }
                    for (;;)
                    {
                      apyu.ih("app_entry", "page_clk");
                      break;
                      aqmj.cN(getContext(), this.app.getCurrentAccountUin());
                      localObject5 = new Intent(this.c.a(), TroopPicEffectGuidePicActivity.class);
                      ((Intent)localObject5).putExtra("friendUin", this.sessionInfo.aTl);
                      ((Intent)localObject5).putExtra("troopUin", this.sessionInfo.troopUin);
                      this.c.a().startActivity((Intent)localObject5);
                    }
                    localObject5 = (TroopAIOAppInfo)this.bu.get(locala.appid);
                    if (localObject5 == null) {
                      break label853;
                    }
                    localObject5 = rnw.a(null, ((TroopAIOAppInfo)localObject5).url, this.sessionInfo.aTl);
                    localObject6 = new Intent(this.c.a(), JumpActivity.class);
                    ((Intent)localObject6).setData(Uri.parse((String)localObject5));
                    this.c.a().startActivity((Intent)localObject6);
                    rar.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
                    break label853;
                    anot.a(this.app, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
                    if (!aqiw.bW(BaseApplicationImpl.getContext()))
                    {
                      QQToast.a(BaseApplicationImpl.getContext(), 2131693404, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
                      break label853;
                    }
                    if (SystemClock.elapsedRealtime() - this.HX < 5000L) {
                      yD(false);
                    }
                    for (;;)
                    {
                      this.beh = true;
                      this.HX = SystemClock.elapsedRealtime();
                      break;
                      ((TroopChatPie)this.c).dN(acfp.m(2131709777));
                      ((acms)this.app.getBusinessHandler(20)).bJ(this.sessionInfo.aTl, false);
                    }
                    if ((this.bu == null) || (this.bu.indexOfKey(locala.appid) < 0)) {
                      break label853;
                    }
                    localObject5 = (TroopAIOAppInfo)this.bu.get(locala.appid);
                    wmz.a(this.c.a(), ((TroopAIOAppInfo)localObject5).url, this.sessionInfo.troopUin, this.sessionInfo.aTn, 1);
                    anot.a(this.app, "dc00898", "", this.sessionInfo.aTl, "0X8009FCD", "0X8009FCD", 0, 0, "", "", "", "");
                    break label853;
                    xry.a(this.app).a(getContext(), this.c);
                    update();
                    break label853;
                    bZG();
                    break label853;
                    label7397:
                    wmz.a(this, locala);
                    break label853;
                    localObject5 = (TroopAIOAppInfo)this.bu.get(locala.appid);
                    break label899;
                    label7426:
                    bool = false;
                    break label976;
                    if ((this.sessionInfo.cZ != 1001) && (this.sessionInfo.cZ != 10002)) {
                      break;
                    }
                    localObject6 = this.app;
                    if (this.sessionInfo.cZ == 1001) {}
                    for (localObject5 = "0";; localObject5 = "1")
                    {
                      anot.a((QQAppInterface)localObject6, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, (String)localObject5, cA(m), "", "");
                      break;
                    }
                  }
                  i = 0;
                }
                i = -1;
              }
              label7544:
              k = 0;
              j = 0;
            }
            label7550:
            break label853;
          }
        }
        label7566:
        bool = false;
      }
      int j = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (((PanelAdapter.a)paramView.getTag()).actionId)
    {
    }
    do
    {
      return false;
    } while ((!LightVideoConfigMgr.a().aPZ()) || (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl == null));
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl.aeV(1);
    return true;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.e != null) {
      this.e.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.e != null) {
      this.e.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() - 1)
    {
      if (this.byr != 2) {
        break label80;
      }
      anot.a(this.app, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      Cm(paramInt);
      if (this.e != null) {
        this.e.onPageSelected(paramInt);
      }
      return;
      label80:
      if (this.byr == 6) {
        anot.a(this.app, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      } else if (this.byr == 7) {
        anot.a(this.app, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void reload()
  {
    this.bei = false;
    boolean bool = "1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_hotchat_hongbao.name(), "1"));
    ShortVideoUtils.cFE = ShortVideoUtils.awJ();
    int i = this.sessionInfo.cZ;
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "reload(): showHongBao=" + bool + " type=" + i);
    }
    if (this.qf == null)
    {
      this.qf = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reload(): iconList size[" + this.qf.size());
      }
      if ((i != 1) && (i != 3000)) {
        break label898;
      }
      aA(bool, i);
      label162:
      if (!imm.isSupportSharpAudio())
      {
        this.qf.remove(gF);
        this.qf.remove(fL);
        this.qf.remove(this.fM);
        this.qf.remove(this.fN);
        this.qf.remove(this.fO);
        this.qf.remove(this.fP);
        this.qf.remove(fQ);
      }
      if ((i != 0) && (i != 1025) && (i != 1024) && (!ChatActivityUtils.q(this.app, this.sessionInfo.aTl)))
      {
        this.qf.remove(gF);
        this.qf.remove(fL);
      }
      if ((!this.bei) && (i == 0))
      {
        this.qf.remove(gb);
        if (!anlm.Vr()) {
          this.qf.remove(gx);
        }
        if (this.qf.indexOf(gT) >= 0)
        {
          this.qf.remove(gT);
          if (this.qf.size() >= 10) {
            break label1863;
          }
          this.qf.add(gT);
        }
      }
      label392:
      if ((i != 1) || (((HotChatManager)this.app.getManager(60)).kj(this.sessionInfo.aTl))) {
        break label2765;
      }
    }
    label435:
    label1863:
    label2765:
    for (i = 1;; i = 0)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      label2047:
      Object localObject3;
      if (j < this.qf.size())
      {
        int[] arrayOfInt = (int[])this.qf.get(j);
        a locala = new a();
        Resources localResources;
        String str2;
        if ((i != 0) || (this.bei))
        {
          if ((arrayOfInt.length >= 3) && (this.bu != null))
          {
            TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.bu.get(arrayOfInt[2]);
            if (localTroopAIOAppInfo != null)
            {
              localResources = BaseApplicationImpl.getContext().getResources();
              str2 = localTroopAIOAppInfo.name;
              for (;;)
              {
                for (;;)
                {
                  try
                  {
                    localObject1 = URLDrawable.URLDrawableOptions.obtain();
                    if ((arrayOfInt.length < 2) || (arrayOfInt[1] <= 0)) {
                      continue;
                    }
                    k = arrayOfInt[1];
                    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(k);
                    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(k);
                    if (!anlm.ayn()) {
                      continue;
                    }
                    if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
                      continue;
                    }
                    if (!TextUtils.isEmpty(localTroopAIOAppInfo.simpleNightUrl)) {
                      continue;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("PlusPanel", 2, "plusPanel reload simpleNightUrl is null!");
                    }
                    localObject1 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject1);
                    str1 = str2;
                    localObject4 = localObject1;
                    if (this.bei)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("PlusPanel", 2, "plusPanel reload useManageConfig = " + this.bei);
                      }
                      str1 = a(localTroopAIOAppInfo);
                      localObject4 = localObject1;
                    }
                  }
                  catch (Exception localException2)
                  {
                    Object localObject1;
                    int k;
                    Object localObject2;
                    Object localObject4 = localResources.getDrawable(2130844474);
                    String str1 = str2;
                    continue;
                  }
                  locala.drawable = ((Drawable)localObject4);
                  locala.actionId = arrayOfInt[1];
                  locala.appid = localTroopAIOAppInfo.appid;
                  locala.aTd = localTroopAIOAppInfo.redDotID;
                  locala.actionType = localTroopAIOAppInfo.actionType;
                  locala.action = localTroopAIOAppInfo.action;
                  locala.text = S(str1, localTroopAIOAppInfo.appid);
                  if ((arrayOfInt == gT) || (arrayOfInt == gw) || (arrayOfInt == gc) || (arrayOfInt == ge) || (arrayOfInt == gf)) {
                    locala.beg = localTroopAIOAppInfo.redPoint;
                  }
                  locala.contentDescription = (locala.text + acfp.m(2131709773));
                  localArrayList.add(locala);
                  if (locala.appid == 1104874204) {
                    this.bPn = (j / 8);
                  }
                  j += 1;
                  break label435;
                  this.qf.clear();
                  break;
                  if ((i == 1000) || (i == 1004))
                  {
                    if (!jou.df(this.sessionInfo.aTl)) {
                      this.qf.add(gx);
                    }
                    this.qf.add(fS);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    if (!jou.df(this.sessionInfo.aTl)) {
                      this.qf.add(gr);
                    }
                    this.qf.add(gL);
                    break label162;
                  }
                  if (i == 10004)
                  {
                    this.qf.add(fS);
                    break label162;
                  }
                  if (i == 1006)
                  {
                    this.qf.add(fS);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    this.qf.add(gL);
                    break label162;
                  }
                  if (i == 1020) {
                    break label162;
                  }
                  if (i == 1025)
                  {
                    this.qf.add(fL);
                    this.qf.add(gF);
                    this.qf.add(fS);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    break label162;
                  }
                  if ((i == 1008) || (i == 1024))
                  {
                    localObject1 = (asgx)this.app.getManager(165);
                    if (((asgx)localObject1).sM(this.sessionInfo.aTl))
                    {
                      if (((asgx)localObject1).sJ(this.sessionInfo.aTl))
                      {
                        this.qf.add(fL);
                        this.qf.add(gF);
                      }
                      this.qf.add(fT);
                      this.qf.add(fS);
                      break label162;
                    }
                    if (jqs.c(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ)) {
                      this.qf.add(fL);
                    }
                    this.qf.add(fF);
                    this.qf.add(fH);
                    if (i == 1008) {
                      ((acja)this.app.getManager(56)).b(this.sessionInfo.aTl);
                    }
                    this.qf.add(fS);
                    break label162;
                  }
                  if ((i == 1005) || (i == 1003)) {
                    break label162;
                  }
                  if (i == 1001)
                  {
                    this.qf.add(fL);
                    this.qf.add(gF);
                    this.qf.add(fS);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    break label162;
                  }
                  if (i == 10002)
                  {
                    this.qf.add(fS);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    break label162;
                  }
                  if (i == 1010)
                  {
                    this.qf.add(fL);
                    this.qf.add(gF);
                    this.qf.add(gC);
                    this.qf.add(fT);
                    this.qf.add(fS);
                    break label162;
                  }
                  if (i == 1021)
                  {
                    this.qf.add(fL);
                    this.qf.add(gF);
                    this.qf.add(gC);
                    break label162;
                  }
                  if ((i == 1022) || (i == 1009) || (i == 1024) || (i == 1023)) {
                    break label162;
                  }
                  if (i == 6000)
                  {
                    this.qf.add(gF);
                    this.qf.add(fT);
                    this.qf.add(gC);
                    break label162;
                  }
                  if (i == 9501) {
                    try
                    {
                      l = Long.parseLong(this.sessionInfo.aTl);
                      localObject1 = (syw)this.app.getBusinessHandler(51);
                      if ((localObject1 == null) || (!((syw)localObject1).bn(l))) {
                        break label162;
                      }
                      this.qf.add(fT);
                    }
                    catch (Exception localException1)
                    {
                      localException1.printStackTrace();
                      long l = 0L;
                    }
                  }
                }
                if ((i == 0) || (ChatActivityUtils.q(this.app, this.sessionInfo.aTl)))
                {
                  if (aprg.V(this.app, this.sessionInfo.aTl))
                  {
                    this.qf.add(fF);
                    this.qf.add(fH);
                    break label162;
                  }
                  bZB();
                  break label162;
                }
                if (aprg.V(this.app, this.sessionInfo.aTl))
                {
                  this.qf.add(fF);
                  this.qf.add(fH);
                  break label162;
                }
                this.qf.add(fS);
                break label162;
                this.qf.add(10, gT);
                break label392;
                k = 2130844474;
                continue;
                localObject2 = URLDrawable.getDrawable(localTroopAIOAppInfo.simpleNightUrl, localException1);
                continue;
                if (TextUtils.isEmpty(localTroopAIOAppInfo.simpleDayUrl))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PlusPanel", 2, "plusPanel reload simpleDayUrl is null!");
                  }
                  localObject2 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject2);
                }
                else
                {
                  localObject2 = URLDrawable.getDrawable(localTroopAIOAppInfo.simpleDayUrl, (URLDrawable.URLDrawableOptions)localObject2);
                  continue;
                  localObject2 = a(localTroopAIOAppInfo.iconUrl, localTroopAIOAppInfo.appid, (URLDrawable.URLDrawableOptions)localObject2);
                }
              }
            }
          }
        }
        else if (arrayOfInt == gy) {
          this.bPn = (j / 8);
        }
        if (arrayOfInt[1] != 2130839317)
        {
          locala.drawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
          if (arrayOfInt.length >= 3) {
            locala.appid = arrayOfInt[2];
          }
          locala.actionId = arrayOfInt[1];
          locala.text = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
          if ((i == 0) && (arrayOfInt == gT)) {
            locala.text = aekv.a().tr();
          }
          localObject3 = (anec)this.app.getManager(12);
          if (localObject3 != null)
          {
            if (((anec)localObject3).ee("999999.100004") == -1) {
              break label2289;
            }
            bool = true;
          }
          label2147:
          if (this.byr != 7) {
            break label2295;
          }
          localObject3 = "chat_tool_gift_stranger_clicked";
          label2161:
          if ((arrayOfInt != gD) || (!hz("chat_tool_dingyue"))) {
            break label2303;
          }
          locala.contentDescription = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + acfp.m(2131709781));
          if (jof.a().dd(this.sessionInfo.aTl))
          {
            if (arrayOfInt != fE) {
              break label2586;
            }
            locala.contentDescription = BaseApplicationImpl.getContext().getResources().getString(2131690311);
          }
        }
        for (;;)
        {
          localArrayList.add(locala);
          break;
          locala.drawable = xry.a(this.app).aD();
          break label2047;
          label2289:
          bool = false;
          break label2147;
          label2295:
          localObject3 = "chat_tool_gift_clicked";
          break label2161;
          label2303:
          if (((arrayOfInt == gr) && (hz("chat_tool_qwallettransfer"))) || ((arrayOfInt == gs) && (hz("chat_tool_tencentdoc"))) || ((arrayOfInt == gB) && (hz("chat_tool_qfav"))) || ((arrayOfInt == gQ) && (hz("chat_tool_apollo"))) || ((arrayOfInt == gS) && (hz("chat_tool_poke"))) || ((arrayOfInt == gy) && (hz((String)localObject3))) || ((arrayOfInt == gN) && (ScribbleResMgr.Y(this.app.getApp().getBaseContext(), this.app.getCurrentAccountUin())))) {
            break label2179;
          }
          if (arrayOfInt == hc)
          {
            if (ShortVideoUtils.cFL) {
              break label2179;
            }
            bool = ShortVideoUtils.pe(this.app.getCurrentAccountUin());
            ShortVideoUtils.cFL = true;
            if (!bool) {
              break label2179;
            }
            break label2179;
          }
          if (arrayOfInt == gT)
          {
            locala.beg = xry.a(this.app).SE();
            break label2179;
          }
          if (arrayOfInt == gc)
          {
            if (i != 0) {
              break label2179;
            }
            locala.beg = aiob.a(this.app, "listen_together_c2c_aio_red_dot_show", true, false);
            break label2179;
          }
          if (arrayOfInt == ge)
          {
            if (i == 0) {
              break label2179;
            }
            locala.beg = aoij.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_AIO_RED_DOT_SHOW", true, false);
            break label2179;
          }
          if (arrayOfInt == gf) {
            break label2179;
          }
          locala.beg = false;
          break label2179;
          if (arrayOfInt == this.fG) {
            locala.contentDescription = BaseApplicationImpl.getContext().getResources().getString(2131690307);
          }
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.xr(null);
      if (i != 0)
      {
        localObject3 = (aprp)this.app.getManager(109);
        if (localObject3 != null) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.xr(((aprp)localObject3).BA());
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.cW(localArrayList);
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.MF(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount());
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
          post(new PlusPanel.1(this));
          return;
        }
        catch (Exception localException3)
        {
          QLog.d("PlusPanel", 2, "e=" + localException3);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      }
    }
  }
  
  public void setAIOLongCaptureCtrlListener(AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = paramAIOLongCaptureCtrl;
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.e = paramOnPageChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != super.getVisibility()) {}
    for (int i = 1;; i = 0)
    {
      super.setVisibility(paramInt);
      if (paramInt == 0)
      {
        this.rD.clear();
        if (i != 0) {
          Cm(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
        }
      }
      return;
    }
  }
  
  public void update()
  {
    reload();
  }
  
  void xu(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gaudio_new")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_poke")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gift_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gift_stranger_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_tencentdoc")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.app.getCurrentAccountUin(), false).commit();
      }
    }
  }
  
  public void yD(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.beh) {
        ((TroopChatPie)this.c).aqz();
      }
    }
    else
    {
      if (!this.bej) {
        break label35;
      }
      if (!QLog.isColorLevel()) {}
    }
    label35:
    do
    {
      return;
      this.beh = false;
      str = this.sessionInfo.aTl;
      if ((((TroopManager)this.app.getManager(52)).c(str).dwGroupFlagExt3 & 0x2000) == 0L) {}
      for (int i = 1; i == 0; i = 0)
      {
        QQToast.a(getContext(), aehj.bxu, 0).show();
        return;
      }
    } while ((this.bu == null) || ((TroopAIOAppInfo)this.bu.get(1106865772) == null) || (TextUtils.isEmpty("https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio")));
    String str = "https://ti.qq.com/honest-say/group.html?_bid=3104&adtag=contact_tab&gc=$GCODE$&src_type=app&from=appstore_aio".replace("$GCODE$", ajri.encode(this.sessionInfo.aTl));
    Intent localIntent = this.c.a().getIntent();
    localIntent.putExtra("url", str);
    localIntent.putExtra("confess_half_screen_web", true);
    if ((this.c instanceof TroopChatPie)) {
      this.bej = aehj.d((TroopChatPie)this.c);
    }
    Cn(1106865772);
  }
  
  public static class a
  {
    public String aTd;
    public String action;
    public int actionId;
    public String actionType;
    public int appid;
    public boolean beg;
    public String contentDescription;
    public Drawable drawable;
    public String text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */