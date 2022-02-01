package com.tencent.mobileqq.dating;

import aajg;
import aalb;
import acbn;
import acgs;
import afck;
import afcq;
import afcr;
import afcs;
import afct;
import afcu;
import afcu.a;
import afdd;
import ajpj;
import ajqo;
import ajrb;
import ajrk;
import ajww;
import akkv;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import anov;
import aqft;
import aqhv;
import aqik;
import aqmj;
import aqmr;
import auru;
import ausj.a;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentDarenAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentInteractAndFollowItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentYanZhiItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForInteractAndFollow;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import jqi;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;
import tog;
import ton;
import top;

public class MsgBoxListActivity
  extends BaseMsgBoxActivity
  implements View.OnClickListener, ausj.a
{
  public View BC;
  private View BD;
  private View BE;
  protected afcu.a a;
  public akkv a;
  public CarrierHelper.EntranceConfig a;
  private CarrierHelper a;
  protected boolean aey;
  String bCX;
  private String bCY;
  public boolean bXp;
  acgs c = new afcq(this);
  RecentBaseData f;
  LinearLayout iE;
  Handler mHandler = null;
  boolean mIsInit = false;
  
  public MsgBoxListActivity()
  {
    this.jdField_a_of_type_Afcu$a = new afct(this);
  }
  
  private void cYt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.isShowing())
    {
      if (this.BD.getVisibility() != 0)
      {
        this.BD.setVisibility(0);
        this.b.addHeaderView(this.BD);
      }
      if (this.BE.getVisibility() != 0)
      {
        this.BE.setVisibility(0);
        this.b.addHeaderView(this.BE);
      }
    }
    do
    {
      return;
      if (this.BD.getVisibility() != 8)
      {
        this.BD.setVisibility(8);
        this.b.removeHeaderView(this.BD);
      }
    } while (this.BE.getVisibility() == 8);
    this.BE.setVisibility(8);
    this.b.removeHeaderView(this.BE);
  }
  
  private void cbK()
  {
    if ((this.cMA != 1010) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig != null) && (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl)) && (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording)) && (!aqmr.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.yy.setImageDrawable((Drawable)localObject);
      this.Rr.setText(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording);
    }
  }
  
  public static int f(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    int i1 = ((Integer)ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_say_hello_msg_type", Integer.valueOf(0))).intValue();
    int i2 = ((Integer)ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "key_nearby_msg_box_comment_zan_msg_type", Integer.valueOf(0))).intValue();
    Object localObject1 = paramQQAppInterface.a(1001).g(paramString, 1001);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("getNearbyMsgBoxUnReadNum mainProcess, rawMsgNum=");
      if (localObject1 != null) {
        break label160;
      }
    }
    int m;
    label160:
    for (int i = 0;; i = ((List)localObject1).size())
    {
      QLog.d("nearby.msgbox.tab", 2, i);
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "msgNum=0, cost=" + (System.currentTimeMillis() - l));
      }
      m = 0;
      return m;
    }
    String str1 = "";
    Object localObject2 = ((List)localObject1).iterator();
    label184:
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      paramString = (MessageRecord)((Iterator)localObject2).next();
      if ((TextUtils.isEmpty(paramString.senderuin)) || (paramString.msgtype == -4011))
      {
        ((Iterator)localObject2).remove();
      }
      else
      {
        if ((paramString instanceof MessageForInteractAndFollow))
        {
          localObject3 = (MessageForInteractAndFollow)paramString;
          if ((((MessageForInteractAndFollow)localObject3).type == 1) || (((MessageForInteractAndFollow)localObject3).type == 2))
          {
            ((Iterator)localObject2).remove();
            continue;
          }
        }
        if ((!paramString.senderuin.equals(acbn.blg)) && (!paramString.senderuin.equals(acbn.blh))) {
          break label953;
        }
      }
    }
    label401:
    label796:
    label932:
    label953:
    for (paramString = paramString.senderuin;; paramString = str1)
    {
      str1 = paramString;
      break label184;
      i = ((List)localObject1).size();
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "afterFilter msgNum=" + i);
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.msgbox.tab", 2, "msgNum=0, cost=" + (System.currentTimeMillis() - l));
        }
        return 0;
      }
      int k;
      int j;
      label445:
      String str2;
      if (i <= 50)
      {
        paramString = ((List)localObject1).subList(0, i);
        localObject1 = new ArrayList();
        localObject2 = new ConcurrentHashMap();
        localObject3 = paramString.iterator();
        k = 0;
        i = 0;
        j = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label847;
        }
        paramString = (MessageRecord)((Iterator)localObject3).next();
        str2 = paramString.senderuin + "_" + paramString.msgtype;
        if (!((ConcurrentHashMap)localObject2).containsKey(str2)) {
          break label605;
        }
        paramString = (RecentBaseData)((ConcurrentHashMap)localObject2).get(str2);
        paramString.c(paramQQAppInterface, BaseApplication.getContext());
        ((List)localObject1).add(paramString);
        if ((paramString.mUnreadFlag != 1) && (paramString.mUnreadFlag != 3)) {
          break label932;
        }
        if (!(paramString instanceof RecentSayHelloBoxItem)) {
          break label737;
        }
        if ((!paramBoolean) || (i1 != 1)) {
          break label707;
        }
        m = k;
        k = 1;
        j = i;
        i = m;
      }
      for (;;)
      {
        m = k;
        k = i;
        i = j;
        j = m;
        break label445;
        i = 50;
        break label401;
        label605:
        if (paramString.senderuin.equals(str1)) {
          paramString = new RecentSayHelloBoxItem(paramString);
        }
        for (;;)
        {
          ((ConcurrentHashMap)localObject2).put(str2, paramString);
          break;
          if ((paramString instanceof MessageForNearbyLiveTip)) {
            paramString = new RecentItemNearbyLiveTipData(paramString);
          } else if ((paramString instanceof MessageForInteractAndFollow)) {
            paramString = new RecentInteractAndFollowItem(paramString);
          } else if ((paramString instanceof MessageForDarenAssistant)) {
            paramString = new RecentDarenAssistantItem(paramString);
          } else {
            paramString = new RecentMsgBoxItem(paramString);
          }
        }
        label707:
        int n = k + paramString.mUnreadNum;
        k = i;
        m = j;
        i = n;
        j = k;
        k = m;
        continue;
        label737:
        if ((paramString instanceof RecentInteractAndFollowItem))
        {
          int i3 = ((RecentInteractAndFollowItem)paramString).yL();
          n = k;
          m = i;
          if (i3 > 0)
          {
            if ((!paramBoolean) || (i2 != 1)) {
              break label796;
            }
            m = 1;
            n = k;
          }
          for (;;)
          {
            i = n;
            k = j;
            j = m;
            break;
            n = k + i3;
            m = i;
          }
        }
        if (paramString.mUnreadFlag == 1)
        {
          n = k + paramString.mUnreadNum;
          k = i;
          m = j;
          i = n;
          j = k;
          k = m;
          continue;
          label847:
          if (QLog.isColorLevel()) {
            QLog.d("nearby.msgbox.tab", 2, "unReadNum=" + k + ", timeCost=" + (System.currentTimeMillis() - l));
          }
          ((ConcurrentHashMap)localObject2).clear();
          m = k;
          if (!paramBoolean) {
            break;
          }
          m = k;
          if (k != 0) {
            break;
          }
          if (j == 0)
          {
            m = k;
            if (i == 0) {
              break;
            }
          }
          return -1;
        }
        m = i;
        n = j;
        i = k;
        j = m;
        k = n;
      }
    }
  }
  
  public static void g(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public void OnClick(View paramView, int paramInt) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      paramView = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      paramString = paramView.nearbyLiveTipMsg;
      if (paramString != null)
      {
        aqhv localaqhv = aqik.c(this.app, this, paramString.jumpingUrl);
        if (localaqhv != null)
        {
          localaqhv.ace();
          if (top.gV(((RecentItemNearbyLiveTipData)paramRecentBaseData).hf()))
          {
            this.app.b().ca(((RecentItemNearbyLiveTipData)paramRecentBaseData).mData.senderuin, paramRecentBaseData.ng());
            if (top.gV(paramString.senderuin))
            {
              if (paramView.wU() >= 1) {
                break label231;
              }
              paramView = "0";
              anot.a(null, "dc00899", "grp_lbs", "", "msg_box", "assist_click", 0, 0, "", "", "", paramView);
            }
          }
          this.app.b().ca(paramRecentBaseData.qx(), paramRecentBaseData.ng());
          this.app.b().ca(((RecentItemNearbyLiveTipData)paramRecentBaseData).hf(), paramRecentBaseData.ng());
        }
        else
        {
          ThreadManagerV2.excute(new MsgBoxListActivity.7(this, paramString, (ajpj)this.app.getManager(106)), 32, null, false);
        }
      }
      else
      {
        anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "click_live_message", 0, 0, "", "", "", "");
      }
    }
    label231:
    do
    {
      return;
      paramView = "1";
      break;
      if (!(paramRecentBaseData instanceof RecentInteractAndFollowItem)) {
        break label598;
      }
      aalb.l(this.app, paramRecentBaseData.qx(), this.cMA);
      this.app.b().ca(paramRecentBaseData.qx(), this.cMA);
      if (top.gU(paramRecentBaseData.qx()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/notification.html?_bid=2623&_wv=1027");
        startActivityForResult(paramView, 1);
        paramView = ((RecentMsgBoxItem)paramRecentBaseData).mFromFlag + "";
        new anov(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_update").a(new String[] { "", "", paramView }).report();
        return;
      }
      if (top.ap(paramRecentBaseData.qx()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/greeting/topic.html?_bid=2623&_wv=1027 ");
        startActivityForResult(paramView, 2);
        new anov(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_focus").report();
        return;
      }
    } while (!top.gT(paramRecentBaseData.qx()));
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html ");
    startActivityForResult(paramView, 3);
    if (this.isFromNearby) {}
    for (paramView = "1";; paramView = "0")
    {
      new anov(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("clk_notice").a(new String[] { "", "", paramView }).report();
      return;
    }
    label598:
    if ((paramRecentBaseData instanceof RecentDarenAssistantItem))
    {
      this.app.b().ca(paramRecentBaseData.qx(), this.cMA);
      if ((((RecentDarenAssistantItem)paramRecentBaseData).mData instanceof MessageForDarenAssistant))
      {
        paramView = ((MessageForDarenAssistant)((RecentDarenAssistantItem)paramRecentBaseData).mData).jumpUrl;
        if (QLog.isColorLevel()) {
          QLog.i("MsgBoxListActivity", 2, "messageForDarenAssistant.jumpUrl=" + paramView);
        }
        paramView = aqik.c(this.app, this, paramView);
        if (paramView != null) {
          paramView.ace();
        }
      }
      new anov(this.app).a("dc00899").b("grp_lbs").c("vip_tips").d("clk").report();
      return;
    }
    if ((paramRecentBaseData instanceof RecentYanZhiItem))
    {
      this.app.b().ca(paramRecentBaseData.qx(), this.cMA);
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.bCY);
      startActivity(paramView);
      return;
    }
    super.a(paramView, paramRecentBaseData, paramString, paramBoolean);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    super.a(paramRecentBaseData, paramString);
    if (paramRecentBaseData != null)
    {
      aqmj.h(this.app.getApp(), this.app.getCurrentAccountUin(), paramRecentBaseData.qx(), 1);
      paramString = "0";
      if ((paramRecentBaseData instanceof RecentMsgBoxItem)) {
        paramString = ((RecentMsgBoxItem)paramRecentBaseData).mFromFlag + "";
      }
      if (!top.gU(paramRecentBaseData.qx())) {
        break label144;
      }
      anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_update", 0, 0, "", "", paramString, "");
    }
    for (;;)
    {
      if (this.isFromNearby)
      {
        this.cQa = f(this.app, this.bwL, false);
        NearbyActivity.a(this.s, this.cQa);
      }
      return;
      label144:
      if (top.ap(paramRecentBaseData.qx())) {
        anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "swipe_focus", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(RecentItemNearbyLiveTipData paramRecentItemNearbyLiveTipData, List<nearby_now_anchor.AnchorStatus> paramList)
  {
    long l1 = Long.parseLong(paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg.senderuin);
    long l2 = acbn.Pd;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (nearby_now_anchor.AnchorStatus)paramList.next();
      if ((((nearby_now_anchor.AnchorStatus)localObject).uint64_uin.get() == l1 - l2) && (((nearby_now_anchor.AnchorStatus)localObject).enum_stat.get() == 2))
      {
        localObject = paramRecentItemNearbyLiveTipData.nearbyLiveTipMsg;
        ((MessageForNearbyLiveTip)localObject).isLiving = false;
        ((MessageForNearbyLiveTip)localObject).msg = ((MessageForNearbyLiveTip)localObject).c2cMsgWording;
        ((MessageForNearbyLiveTip)localObject).prewrite();
        this.app.b().c(((MessageForNearbyLiveTip)localObject).senderuin, ((MessageForNearbyLiveTip)localObject).istroop, ((MessageForNearbyLiveTip)localObject).uniseq, ((MessageForNearbyLiveTip)localObject).msgData);
        paramRecentItemNearbyLiveTipData.c(this.app, BaseApplication.getContext());
        this.jdField_f_of_type_Aajg.cW(((MessageForNearbyLiveTip)localObject).senderuin, this.cMA);
      }
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (aqft.equalsWithNullCheck(paramString1, getString(aakb.fy[6])))
    {
      this.jdField_f_of_type_ComTencentMobileqqActivityRecentRecentBaseData = paramRecentBaseData;
      this.bCX = paramString2;
      if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
        break label45;
      }
      QLog.w("MsgBoxListActivity", 1, "data instanceof RecentItemNearbyLiveTipData = [false]");
    }
    label45:
    do
    {
      return;
      new anov(this.app).a("dc00899").b("grp_lbs").c("msg_box").d("unfollow").e(((RecentItemNearbyLiveTipData)paramRecentBaseData).hf()).report();
      if (!jqi.isNetworkAvailable(getApplicationContext()))
      {
        QQToast.a(getApplicationContext(), 1, 2131696270, 0).show();
        return;
      }
      paramString1 = (RecentItemNearbyLiveTipData)paramRecentBaseData;
      if (paramString1.nearbyLiveTipMsg != null) {
        break;
      }
      QLog.w("MsgBoxListActivity", 1, "rData.nearbyLiveTipMsg == null");
    } while (paramString1.mData == null);
    paramString1 = paramString1.mData.senderuin;
    try
    {
      for (;;)
      {
        l = Long.valueOf(paramString1).longValue();
        if (l <= acbn.Pd) {
          break label283;
        }
        l -= acbn.Pd;
        this.jdField_f_of_type_Aajg.b(this.jdField_f_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.bCX);
        if (this.isFromNearby)
        {
          if (this.jdField_f_of_type_Aajg.getCount() != 0) {
            break;
          }
          this.BB.setVisibility(0);
        }
        new ajww(this.app).a(l, 0L, 0, 16, false, new afcs(this));
        return;
        paramString1 = paramString1.nearbyLiveTipMsg.senderuin;
      }
    }
    catch (NumberFormatException paramString1)
    {
      label283:
      for (;;)
      {
        long l = 0L;
        continue;
        this.BB.setVisibility(8);
      }
    }
  }
  
  protected void aQ()
  {
    if (this.isFromNearby) {
      break label7;
    }
    label7:
    while ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    TextView localTextView;
    if (this.aey)
    {
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackText.setVisibility(0);
      localTextView = this.mLeftBackText;
      i(localTextView, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
    }
    for (;;)
    {
      Object localObject = this.app.b();
      if (localObject == null) {
        break;
      }
      int i = ((QQMessageFacade)localObject).bl();
      localObject = "" + i;
      if (!this.aey)
      {
        localObject = getString(2131720735) + "(" + i + ")";
        if (i > 99) {
          localObject = getString(2131720735) + "(99+)";
        }
      }
      if (i < 0) {
        localObject = getString(2131720735);
      }
      if ((this.aey) && (i <= 0)) {
        localTextView.setVisibility(4);
      }
      localTextView.setText((CharSequence)localObject);
      return;
      this.leftView.setVisibility(0);
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localTextView = this.leftView;
    }
  }
  
  protected List<RecentBaseData> aW(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = paramList.iterator();
    long l2;
    if (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      Object localObject = paramList.senderuin + "_" + paramList.msgtype;
      l2 = System.currentTimeMillis();
      if (this.jP.containsKey(localObject)) {
        localObject = (RecentBaseData)this.jP.get(localObject);
      }
      label195:
      do
      {
        ((RecentBaseData)localObject).c(this.app, BaseApplication.getContext());
        localArrayList.add(localObject);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("MsgBoxListActivity", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        break;
        if (!paramList.senderuin.equals(this.bCS)) {
          break label245;
        }
        paramList = new RecentSayHelloBoxItem(paramList);
        this.jP.put(localObject, paramList);
        localObject = paramList;
      } while (!(paramList instanceof RecentMsgBoxItem));
      localObject = (RecentMsgBoxItem)paramList;
      if (this.isFromNearby) {}
      for (int i = 1;; i = 0)
      {
        ((RecentMsgBoxItem)localObject).mFromFlag = i;
        localObject = paramList;
        break;
        label245:
        if ((paramList instanceof MessageForNearbyLiveTip))
        {
          paramList = new RecentItemNearbyLiveTipData(paramList);
          break label195;
        }
        if ((paramList instanceof MessageForInteractAndFollow))
        {
          paramList = new RecentInteractAndFollowItem(paramList);
          break label195;
        }
        if ((paramList instanceof MessageForDarenAssistant))
        {
          paramList = new RecentDarenAssistantItem(paramList);
          break label195;
        }
        if ((paramList instanceof MessageForYanZhi))
        {
          paramList = new RecentYanZhiItem(paramList);
          break label195;
        }
        paramList = new RecentMsgBoxItem(paramList);
        break label195;
      }
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("MsgBoxListActivity", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList;
  }
  
  protected void cWQ()
  {
    if (this.yT == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList1 = new ArrayList(10);
      localArrayList2 = new ArrayList(10);
      Iterator localIterator = this.yT.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (RecentBaseData)localIterator.next();
        if ((localObject instanceof RecentItemNearbyLiveTipData))
        {
          localObject = (RecentItemNearbyLiveTipData)localObject;
          if ((((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg != null) && (!MessageForNearbyLiveTip.isHuayangTip(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.jumpingUrl)) && (((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.isLiving))
          {
            try
            {
              Long localLong = Long.valueOf(Long.valueOf(Long.parseLong(((RecentItemNearbyLiveTipData)localObject).nearbyLiveTipMsg.senderuin)).longValue() - acbn.Pd);
              if (!localArrayList1.contains(localLong)) {
                localArrayList1.add(localLong);
              }
              localArrayList2.add(localObject);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel()) {
              QLog.w("MsgBoxListActivity", 2, localException.toString());
            }
          }
        }
      }
    } while (localArrayList1.size() == 0);
    afcu.a(this.app, localArrayList1, null, new afcr(this, localArrayList2));
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3)) {
      afcu.a(this.app, 2, this.jdField_a_of_type_Afcu$a);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    if (this.aey)
    {
      if (getTitleBarView() != null) {
        getTitleBarView().setBackgroundDrawable(getResources().getDrawable(2130851106));
      }
      if (this.centerView != null) {
        this.centerView.setTextColor(-1);
      }
    }
    this.iE = new LinearLayout(this);
    this.iE.setOrientation(1);
    this.jdField_a_of_type_Akkv = new akkv(this);
    this.bCY = afdd.e(this.app);
    if (this.cMA == 1010)
    {
      setTitle(2131700984);
      this.BA.setVisibility(8);
    }
    for (;;)
    {
      if (this.isFromNearby) {
        setTitle(2131696191);
      }
      this.BA.setOnClickListener(this);
      this.app.addObserver(this.c, true);
      afcu.a(this.app, 1, this.jdField_a_of_type_Afcu$a);
      if ((this.cMA != 1001) && (this.cMA != 10002)) {
        break;
      }
      return true;
      if ((this.cMA == 1001) || (this.cMA == 10002))
      {
        setTitle(2131694589);
        this.BA.setVisibility(8);
        QQAppInterface localQQAppInterface = this.app;
        if (this.cMA == 1001) {}
        for (paramBundle = "0";; paramBundle = "1")
        {
          anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_msg_list", 0, 0, paramBundle, "", "", "");
          break;
        }
      }
      if (this.cMA == 1009)
      {
        setTitle(2131718916);
        this.BA.setVisibility(8);
      }
    }
    anot.a(this.app, "dc00899", "grp_lbs", "", "msg_box", "otherType", 0, 0, this.cMA + "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    removeObserver(this.c);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      ThreadManager.post(new MsgBoxListActivity.3(this), 5, null, false);
    }
    if (this.jdField_a_of_type_Akkv != null) {
      this.jdField_a_of_type_Akkv.destroy();
    }
    ajqo.Ro(1);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.B(1, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.Zg();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
    aQ();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.B(1, Boolean.valueOf(true));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mIsInit))
    {
      this.mIsInit = true;
      if (this.mHandler == null)
      {
        a locala = new a(this.app.getAccount());
        this.mHandler = new auru(ThreadManager.getFileThreadLooper(), locala);
      }
      this.mHandler.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  public void finish()
  {
    if (((this.cMA == 1001) || (this.cMA == 10002)) && (!this.bwL.equals(acbn.bkF)))
    {
      this.app.getPreferences().edit().putLong("sp_key_nearby_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.getPreferences().edit().putInt("sp_key_sayhello_box_unread_count", 0).commit();
      this.app.a().h(this.bwL, this.cMA, true);
      this.app.a().clearMsgBoxUnreadCount();
    }
    super.finish();
  }
  
  public void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new MsgBoxListActivity.4(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  protected void jM(List<MessageRecord> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Object localObject = paramList.iterator();
    ArrayList localArrayList3 = new ArrayList(3);
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    MessageRecord localMessageRecord;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((TextUtils.isEmpty(localMessageRecord.senderuin)) || (localMessageRecord.msgtype == -4011))
        {
          ((Iterator)localObject).remove();
        }
        else
        {
          MessageForInteractAndFollow localMessageForInteractAndFollow;
          if ((this.isFromNearby) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
          {
            localMessageForInteractAndFollow = (MessageForInteractAndFollow)localMessageRecord;
            if ((localMessageForInteractAndFollow.type == 1) || (localMessageForInteractAndFollow.type == 2))
            {
              ((Iterator)localObject).remove();
              continue;
            }
          }
          if ((this.isFromNearby) && ((localMessageRecord instanceof MessageForInteractAndFollow)))
          {
            localMessageForInteractAndFollow = (MessageForInteractAndFollow)localMessageRecord;
            if ((localMessageForInteractAndFollow.type == 1) || (localMessageForInteractAndFollow.type == 2))
            {
              ((Iterator)localObject).remove();
              continue;
            }
          }
          if (top.gS(localMessageRecord.senderuin))
          {
            localArrayList3.add(localMessageRecord);
            ((Iterator)localObject).remove();
          }
          if ((localMessageRecord.senderuin.equals(acbn.blg)) || (localMessageRecord.senderuin.equals(acbn.blh)))
          {
            this.bXf = true;
            this.bCS = localMessageRecord.senderuin;
            localArrayList3.add(localMessageRecord);
            ((Iterator)localObject).remove();
          }
          else if (afck.m(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
          {
            if (localArrayList1 != null) {
              break label468;
            }
            localArrayList1 = new ArrayList();
          }
        }
      }
    }
    label468:
    for (;;)
    {
      ((Iterator)localObject).remove();
      localArrayList1.add(localMessageRecord);
      break;
      if (!afck.l(this.app, localMessageRecord.senderuin, localMessageRecord.istroop)) {
        break;
      }
      if (localArrayList2 == null) {
        localArrayList2 = new ArrayList();
      }
      for (;;)
      {
        ((Iterator)localObject).remove();
        localArrayList2.add(localMessageRecord);
        break;
        localObject = new ArrayList();
        ((List)localObject).addAll(localArrayList3);
        if (0 != 0) {
          ((List)localObject).add(null);
        }
        if ((localArrayList2 != null) && (!localArrayList2.isEmpty())) {
          ((List)localObject).addAll(localArrayList2);
        }
        if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
          ((List)localObject).addAll(localArrayList1);
        }
        paramList.addAll(0, (Collection)localObject);
        return;
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent;
    if (this.isFromNearby)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
    }
    for (;;)
    {
      return super.onBackEvent();
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig == null)
      {
        if (QLog.isColorLevel()) {
          ajrk.m("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        if (this.cMA == 1010)
        {
          label74:
          ajqo.Rn(1);
          label78:
          if (this.Rr != null) {
            break label355;
          }
        }
      }
      label355:
      for (Object localObject = "";; localObject = this.Rr.getText().toString())
      {
        if (this.cMA != 1010) {
          break label371;
        }
        anot.a(this.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", (String)localObject, "");
        break;
        if ((this.cMA != 1001) && (this.cMA != 10002)) {
          break label74;
        }
        if (!ajrb.nF(this.app.getAccount()))
        {
          localObject = new Intent(this, NearbyActivity.class);
          ((Intent)localObject).putExtra("FROM_WHERE", 1003);
          ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
          NearbyFakeActivity.S(this, (Intent)localObject);
          break label74;
        }
        localObject = new Intent(this, NearbyGuideActivity.class);
        ((Intent)localObject).putExtra("FROM_WHERE", 1003);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        startActivity((Intent)localObject);
        break label74;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl.startsWith("mqqapi")))
        {
          localObject = new Intent(this, JumpActivity.class);
          ((Intent)localObject).setAction("android.intent.action.VIEW");
          ((Intent)localObject).setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl));
          startActivity((Intent)localObject);
          ajqo.Rn(1);
          break label78;
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl);
        startActivity((Intent)localObject);
        break label78;
      }
      label371:
      if (this.cMA == 1001) {
        anot.a(this.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", (String)localObject, "");
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    runOnUiThread(new MsgBoxListActivity.5(this));
  }
  
  static class a
    implements Handler.Callback
  {
    private String mAccount;
    
    public a(String paramString)
    {
      this.mAccount = paramString;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return true;
      }
      ajqo.fl(this.mAccount, 1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity
 * JD-Core Version:    0.7.0.1
 */