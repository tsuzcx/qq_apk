import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.2;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.6;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.7;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.9;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.2;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.1;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.MultiMsgDownloadCallback.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ybl
  extends BaseChatPie
{
  private long JI;
  private TextView KI;
  acnd jdField_a_of_type_Acnd = new ybq(this);
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  String aXd;
  private Drawable ad;
  private accd jdField_b_of_type_Accd = new ybn(this);
  private aghq jdField_b_of_type_Aghq = new ybo(this);
  private final int bEf = 300;
  private int bYp;
  public boolean blg;
  acfd c = new ybp(this);
  private ChatXListView d;
  private Runnable dH = new MultiForwardChatPie.4(this);
  private wki e;
  public Runnable ez;
  private MessageForStructing f;
  private RelativeLayout id;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  public String mSourceName;
  View rM;
  private RelativeLayout root;
  private List<ChatMessage> sr;
  private ImageView ud;
  public long uniseq;
  public MqqHandler x = new ybm(this);
  private View xs;
  
  public ybl(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void DD(int paramInt)
  {
    aavt localaavt = (aavt)a(4);
    if (localaavt != null) {
      localaavt.Ck(paramInt);
    }
  }
  
  private void H(boolean paramBoolean, Object paramObject)
  {
    this.uiHandler.removeMessages(24);
    if ((this.jdField_a_of_type_Arhz == null) || (!this.jdField_a_of_type_Arhz.isShowing())) {}
    do
    {
      return;
      if ((paramBoolean) && (paramObject != null) && (ajlc.a().djF == 6))
      {
        this.jdField_a_of_type_Arhz.dismiss();
        ajlc.a().lD.clear();
        ajlc.a().lD.putAll((Map)paramObject);
        ((wvy)this.jdField_a_of_type_Wvm.a(11)).a((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MultiMsg_TAG", 4, "handleMultiFavorite = " + paramObject);
  }
  
  private void a(View paramView, int paramInt, ausj paramausj)
  {
    if (paramView == null)
    {
      paramausj.dismiss();
      return;
    }
    String str = paramausj.getContent(paramInt);
    if (str == null)
    {
      paramausj.dismiss();
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      paramausj.dismiss();
      return;
    }
    if (str.equals(paramView.getResources().getString(2131694752)))
    {
      ajlg.report("0X8009AB5");
      gg(this.uniseq);
    }
    paramausj.dismiss();
  }
  
  private void ccC()
  {
    this.uiHandler.removeCallbacks(this.dH);
    wtb localwtb = (wtb)a(49);
    if (localwtb != null) {
      localwtb.Ck(7);
    }
  }
  
  private void fA(View paramView)
  {
    paramView = ausj.d(paramView.getContext());
    paramView.addButton(2131694752);
    paramView.addCancelButton(2131721058);
    paramView.a(new ybs(this, paramView));
    paramView.show();
  }
  
  private void gg(long paramLong)
  {
    ThreadManagerV2.post(new MultiForwardChatPie.9(this, paramLong), 8, null, true);
  }
  
  public void Ib()
  {
    this.TAG = "MultiForwardChatPie";
  }
  
  public akxb a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new ybl.b(this, this.uniseq);
    case 1: 
      return new ybl.b(this, this.uniseq);
    }
    return new ybl.a(this);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardChatPie", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    paramMessageRecord = this.e.getList();
    if (paramMessageRecord != null)
    {
      Iterator localIterator = paramMessageRecord.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessageRecord = (ChatMessage)localIterator.next();
      } while ((top.t(paramMessageRecord)) || (top.s(paramMessageRecord)) || ((paramMessageRecord instanceof MessageForSafeGrayTips)) || (paramMessageRecord.shmsgseq != paramLong));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (paramMessageRecord != null)
        {
          bool = true;
          QLog.d("MultiForwardChatPie", 2, new Object[] { "refreshHeadMessage==>", "isFind:", Boolean.valueOf(bool) });
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.YN(paramInt3);
        if ((paramMessageRecord == null) || (ahwb.aB(paramMessageRecord))) {
          break label302;
        }
        paramInt2 = this.e.K(paramMessageRecord.uniseq);
        if (paramInt2 == -1) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, 10);
      }
      label231:
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if (paramMessageRecord.msgtype == -2006) {
            QQToast.a(this.mActivity, acfp.m(2131708577), 0).show(this.mActivity.getTitleBarHeight());
          }
        } while (!QLog.isColorLevel());
        QLog.d("MultiForwardChatPie", 2, new Object[] { "pos is -1, msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
        return;
        QQToast.a(this.mActivity, 2131699910, 0).show(this.mActivity.getTitleBarHeight());
      } while (!QLog.isColorLevel());
      label302:
      if (paramMessageRecord != null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("MultiForwardChatPie", 2, new Object[] { "foundMsgRecord:", Boolean.valueOf(bool) });
        return;
      }
      paramMessageRecord = null;
    }
  }
  
  public boolean af(boolean paramBoolean)
  {
    this.aSD = true;
    this.blg = BaseChatItemLayout.bdx;
    BaseChatItemLayout.bdx = false;
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    this.bEu = 2;
    Object localObject1 = (ViewGroup)this.mAIORootView.findViewById(2131362332);
    ((ViewGroup)localObject1).removeView(this.mAIORootView.findViewById(2131377546));
    Object localObject2 = View.inflate(this.mActivity, 2131558676, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.bYp = this.mActivity.getIntent().getIntExtra("callback_type", 1);
    this.aXd = this.mActivity.getIntent().getStringExtra("multi_url");
    this.uniseq = this.mActivity.getIntent().getLongExtra("multimsg_uniseq", 0L);
    this.mSourceName = this.mActivity.getIntent().getStringExtra("multi_title");
    if (TextUtils.isEmpty(this.mSourceName)) {
      this.mSourceName = acfp.m(2131708576);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 4, "MultiForwardActivity.doOnCreate ResID = " + this.aXd + "  msg.uniseq = " + this.uniseq + " downCallBackType" + this.bYp);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.mAIORootView.findViewById(2131377361));
    this.pz = ((ImageView)this.mAIORootView.findViewById(2131377362));
    this.Cr = ((TextView)this.mAIORootView.findViewById(2131369579));
    this.pp = ((ImageView)this.mAIORootView.findViewById(2131369594));
    this.ps = ((ImageView)this.mAIORootView.findViewById(2131369588));
    this.pq = ((ImageView)this.mAIORootView.findViewById(2131369967));
    this.mDensity = this.app.getApplication().getResources().getDisplayMetrics().density;
    wja.i(this.pq, 0, 0, 0, (int)(50.0F * this.mDensity + 0.5F));
    this.Cs = ((TextView)this.mAIORootView.findViewById(2131380514));
    this.cJ = ((ViewGroup)this.mAIORootView.findViewById(2131379823));
    localObject2 = this.cJ.getLayoutParams();
    if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
      localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
      i = wja.dp2px(64.0F, this.cJ.getResources());
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i;
    }
    this.Cr.setOnClickListener(this);
    this.pq.setOnClickListener(this);
    this.Cs.setOnClickListener(this);
    this.pp.setContentDescription(acfp.m(2131708574));
    this.mTitleText = ((TextView)this.mAIORootView.findViewById(2131379769));
    this.Cu = ((TextView)this.mAIORootView.findViewById(2131379857));
    this.ps.setVisibility(4);
    this.pp.setVisibility(4);
    this.Cr.setText(this.mActivity.getString(2131691039));
    vU(false);
    this.root = ((RelativeLayout)this.mAIORootView.findViewById(2131372063));
    this.id = ((RelativeLayout)this.mAIORootView.findViewById(2131372061));
    this.ud = ((ImageView)this.mAIORootView.findViewById(2131372071));
    this.KI = ((TextView)this.mAIORootView.findViewById(2131372060));
    this.d = ((ChatXListView)this.mAIORootView.findViewById(2131372068));
    this.d.setStackFromBottom(false);
    this.d.setTranscriptMode(0);
    this.d.setLongClickable(true);
    this.d.setDelAnimationDuration(300L);
    this.d.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.mAIORootView.findViewById(2131362727));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.p(this.d);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.d);
    localObject1 = this.mActivity.getIntent().getExtras();
    localObject2 = ((Bundle)localObject1).getString("uin");
    String str = ((Bundle)localObject1).getString("troop_code");
    int i = ((Bundle)localObject1).getInt("uintype");
    this.sessionInfo = new SessionInfo();
    this.sessionInfo.aTl = ((String)localObject2);
    this.sessionInfo.cZ = i;
    this.sessionInfo.troopUin = str;
    ajlc.a().setSessionInfo(this.sessionInfo);
    localObject1 = this.app.b().a((String)localObject2, i, this.uniseq);
    if (localObject1 != null) {
      ajlc.a().Rd(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.xs = new View(this.mActivity);
      this.xs.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.mActivity.getResources().getDisplayMetrics())));
      this.d.addFooterView(this.xs);
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.d);
      this.e = new wki(this.app, this.mActivity, this.sessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      if (this.rM == null)
      {
        this.rM = new View(this.mContext);
        i = this.mContext.getResources().getDimensionPixelSize(2131299627);
        this.rM.setLayoutParams(new AbsListView.LayoutParams(-1, i));
        this.rM.setId(2131362463);
        this.d.addHeaderView(this.rM, null, false);
        this.d.setOverscrollHeaderTop(i);
      }
      this.d.setAdapter(this.e);
      localObject1 = LayoutInflater.from(this.app.getApp()).inflate(2131559032, null);
      this.d.setOverScrollHeader((View)localObject1);
      this.sessionInfo.a = new wkj();
      this.sessionInfo.cN = ChatTextSizeSettingActivity.ag(BaseApplicationImpl.getContext());
      if (wkj.a(BaseApplicationImpl.getContext(), this.app.getCurrentAccountUin(), this.sessionInfo.aTl, true, 7, this.sessionInfo.a)) {
        this.root.setBackgroundDrawable(this.sessionInfo.a.img);
      }
      ThreadManager.post(new MultiForwardChatPie.2(this), 8, null, true);
      this.mTitleText.setSingleLine(false);
      this.mTitleText.setMaxLines(2);
      this.mTitleText.setTextSize(16.0F);
      this.mTitleText.setText(this.mSourceName);
      if (this.aey) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851105);
      this.pz.setVisibility(8);
      this.pq.setVisibility(8);
      this.Cs.setVisibility(8);
      localObject1 = this.mContext.getResources().getColorStateList(2131167301);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.Cr.setVisibility(0);
      localObject1 = this.pp;
      i = 2130840663;
      if (this.aey) {
        i = 2130844509;
      }
      ((ImageView)localObject1).setImageResource(i);
      ((ImageView)localObject1).setContentDescription(acfp.m(2131708573));
      ((ImageView)localObject1).setVisibility(0);
      ((ImageView)localObject1).setOnClickListener(new ybr(this));
      bHZ();
      localObject1 = (wtb)a(49);
      if (localObject1 != null) {
        ((wtb)localObject1).Ck(3);
      }
      return true;
      ajlc.a().Rd(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851106);
    this.pz.setVisibility(0);
    if (!TextUtils.isEmpty(this.Cs.getText())) {
      this.Cs.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.mContext.getResources().getColorStateList(2131167302);
      this.mTitleText.setTextColor((ColorStateList)localObject1);
      this.Cr.setVisibility(8);
      break;
      this.Cs.setVisibility(4);
    }
  }
  
  public ListView b()
  {
    return this.d;
  }
  
  public void bF(List<ChatMessage> paramList)
  {
    this.sr = paramList;
  }
  
  public void bHZ()
  {
    this.app.a().addObserver(this.jdField_b_of_type_Aghq);
    this.app.addObserver(this.jdField_b_of_type_Accd);
    this.app.addObserver(this.c);
    this.app.addObserver(this.jdField_a_of_type_Acnd);
  }
  
  public void bIa()
  {
    this.app.a().deleteObserver(this.jdField_b_of_type_Aghq);
    this.app.removeObserver(this.jdField_b_of_type_Accd);
    this.app.removeObserver(this.c);
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 21) && (paramInt2 == -1) && (paramIntent != null)) {
      super.bm(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.app.getApplication().getString(2131720735));
      bm(paramIntent.getExtras());
    }
    if ((paramInt1 == 24) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
  }
  
  public void doOnDestroy()
  {
    this.bEu = 9;
    DD(12);
    this.rK = null;
    this.rL = null;
    this.Hy = 0;
    this.bEz = 0;
    this.e.destroy();
    if (this.sr != null) {
      this.sr.clear();
    }
    bIa();
    this.uiHandler.removeCallbacks(this.dH);
    wtb localwtb = (wtb)a(49);
    if (localwtb != null) {
      localwtb.Ck(13);
    }
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    this.bEu = 5;
    DD(9);
  }
  
  public void doOnResume()
  {
    if (this.aSD) {
      this.uiHandler.postDelayed(this.dH, 800L);
    }
    if (this.aSD)
    {
      this.d.postDelayed(new MultiForwardChatPie.5(this), 600L);
      this.aSD = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      this.bEu = 4;
      DD(5);
      return;
      this.e.notifyDataSetChanged();
    }
  }
  
  public void doOnStart()
  {
    this.bEu = 3;
  }
  
  public void doOnStop()
  {
    this.bEu = 6;
    DD(10);
  }
  
  public void ey(View paramView)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleScrollOutScreen , view = ");
      if (paramView == null)
      {
        str = "null";
        QLog.i("MultiForwardActivity", 2, str);
      }
    }
    else
    {
      if (paramView != null) {
        break label56;
      }
    }
    label56:
    do
    {
      do
      {
        return;
        str = paramView.toString();
        break;
        paramView = wja.a(paramView);
      } while (!(paramView instanceof xov.a));
      paramView = (xov.a)paramView;
    } while (paramView.a == null);
    paramView.a.detach();
  }
  
  public boolean fV(int paramInt)
  {
    this.bEu = 8;
    this.uiHandler.removeCallbacks(this.dH);
    if (this.ez != null)
    {
      this.d.removeCallbacks(this.ez);
      this.ez = null;
    }
    return false;
  }
  
  public void finish()
  {
    if (this.ez != null)
    {
      this.d.removeCallbacks(this.ez);
      this.ez = null;
    }
    if (this.mActivity != null) {
      this.mActivity.finish();
    }
  }
  
  public boolean onBackEvent()
  {
    aavt localaavt = (aavt)a(4);
    if ((localaavt != null) && (localaavt.XE())) {
      return true;
    }
    if (this.ez != null)
    {
      this.d.removeCallbacks(this.ez);
      this.ez = null;
    }
    BaseChatItemLayout.bdx = this.blg;
    return false;
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
      finish();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.Hy < paramInt1) {
      ey(this.rK);
    }
    for (;;)
    {
      this.Hy = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.bEz = (paramInt1 + paramInt2 - 1);
      }
      this.rK = paramAbsListView.getChildAt(0);
      this.rL = paramAbsListView.getChildAt(paramInt2 - 1);
      paramAbsListView = (wtb)a(49);
      if (paramAbsListView != null) {
        paramAbsListView.Ck(19);
      }
      return;
      if ((paramInt1 + paramInt2 - 1 < this.bEz) && (paramInt1 + paramInt2 - 1 > 0)) {
        ey(this.rL);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      DD(16);
      return;
    }
    DD(14);
  }
  
  public void refreshData()
  {
    Object localObject2 = ajlc.a().a(this.app, this.uniseq);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      bF((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.sr, this.sessionInfo, this.app);
      localObject1 = ChatActivityUtils.a(this.app, BaseApplicationImpl.getContext(), this.sessionInfo, (MessageRecord)localObject1, -1L);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.JI));
      }
      ajlc.a().a(this.app, this.sr, true);
      this.mActivity.runOnUiThread(new MultiForwardChatPie.6(this, (CharSequence)localObject1));
      return;
    }
    this.mActivity.runOnUiThread(new MultiForwardChatPie.7(this));
  }
  
  protected boolean startTitleProgress()
  {
    if (this.ad == null)
    {
      this.ad = this.mActivity.getResources().getDrawable(2130839657);
      this.mOldDrawables = this.mTitleText.getCompoundDrawables();
      this.mOldPadding = this.mTitleText.getCompoundDrawablePadding();
      this.mTitleText.setCompoundDrawablePadding(10);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      ((Animatable)this.ad).start();
      return true;
    }
    return false;
  }
  
  public boolean stopTitleProgress()
  {
    if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.mTitleText.setCompoundDrawablePadding(this.mOldPadding);
      this.mTitleText.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
  
  public static class a
    implements akxb
  {
    WeakReference<ybl> mActivityRef;
    
    public a(ybl paramybl)
    {
      this.mActivityRef = new WeakReference(paramybl);
    }
    
    public void a(akxb.a parama)
    {
      if (this.mActivityRef == null) {}
      label409:
      for (;;)
      {
        return;
        ybl localybl = (ybl)this.mActivityRef.get();
        if ((localybl != null) && (localybl.ez != null))
        {
          ybl.a(localybl).removeCallbacks(localybl.ez);
          localybl.ez = null;
        }
        if ((parama.result == 0) && (parama.data != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload success");
          }
          if (localybl == null) {
            continue;
          }
          Object localObject1 = new HashMap();
          Object localObject2 = localybl.app.b().a(localybl.sessionInfo.aTl, localybl.sessionInfo.cZ, localybl.uniseq);
          localObject2 = localybl.app.a().b().a(parama.data, (HashMap)localObject1, (MessageRecord)localObject2, null);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() == 1))
          {
            if (((MessageRecord)((ArrayList)localObject2).get(0)).msgtype == -1035) {
              ((ajcy)localybl.app.getManager(174)).bt(false, localybl.sessionInfo.cZ);
            }
            ajlc.a().a((HashMap)localObject1, localybl.uniseq, localybl.app);
            localObject1 = new ArrayList();
            ((List)localObject1).add((ChatMessage)((ArrayList)localObject2).get(0));
            localybl.bF((List)localObject1);
            localObject1 = ChatActivityUtils.a(ybl.a(localybl), localybl.sessionInfo, localybl.app);
            localObject1 = ChatActivityUtils.a(localybl.app, BaseApplicationImpl.getContext(), localybl.sessionInfo, (MessageRecord)localObject1, -1L);
            if (QLog.isColorLevel()) {
              QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - ybl.a(localybl)));
            }
            localybl.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.1(this, localybl, (CharSequence)localObject1));
          }
        }
        for (;;)
        {
          if ((localybl == null) || (localybl.app == null)) {
            break label409;
          }
          ((ajkw)localybl.app.getManager(166)).a(localybl.app, localybl.sessionInfo.cZ, parama.result, 2);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "MultiForwardActivity.onDownload failed");
          }
          if (localybl == null) {
            break;
          }
          localybl.mActivity.runOnUiThread(new MultiForwardChatPie.LongTextDownloadCallback.2(this, localybl));
        }
      }
    }
    
    public void aS(int paramInt, boolean paramBoolean) {}
  }
  
  public static class b
    implements akxb
  {
    WeakReference<ybl> mActivityRef;
    long mUniseq;
    
    public b(ybl paramybl, long paramLong)
    {
      this.mActivityRef = new WeakReference(paramybl);
      this.mUniseq = paramLong;
    }
    
    public void a(akxb.a parama)
    {
      if (this.mActivityRef == null) {}
      ybl localybl;
      do
      {
        HashMap localHashMap;
        do
        {
          do
          {
            return;
            localybl = (ybl)this.mActivityRef.get();
            if ((localybl != null) && (localybl.ez != null))
            {
              ybl.a(localybl).removeCallbacks(localybl.ez);
              localybl.ez = null;
            }
            if ((parama.result != 0) || (parama.data == null)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload success");
            }
          } while (localybl == null);
          localHashMap = new HashMap();
          MessageRecord localMessageRecord = localybl.app.b().a(localybl.sessionInfo.aTl, localybl.sessionInfo.cZ, localybl.uniseq);
          localObject = localMessageRecord;
          if (localMessageRecord == null)
          {
            localObject = localMessageRecord;
            if (this.mUniseq == 0L)
            {
              localObject = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(35).a(acfp.m(2131708575)).a(3).a("viewMultiMsg", "", null, null, null).c("MultiMsg").b(localybl.aXd).a();
              localObject = anbi.a(localybl.app, "0", "0", "0", 0, 0L, (AbsStructMsg)localObject);
            }
          }
          localObject = localybl.app.a().b().a(parama.data, localHashMap, (MessageRecord)localObject, null);
        } while ((localObject == null) || (((HashMap)localObject).size() <= 0));
        ajlc.a().a(localHashMap, localybl.uniseq, localybl.app);
        parama = new ArrayList();
        Object localObject = ((ArrayList)((HashMap)localObject).get("MultiMsg")).iterator();
        while (((Iterator)localObject).hasNext()) {
          parama.add((ChatMessage)((Iterator)localObject).next());
        }
        localybl.bF(parama);
        localObject = ChatActivityUtils.a(ybl.a(localybl), localybl.sessionInfo, localybl.app);
        localObject = ChatActivityUtils.a(localybl.app, BaseApplicationImpl.getContext(), localybl.sessionInfo, (MessageRecord)localObject, -1L);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - ybl.a(localybl)));
        }
        ajlc.a().a(localybl.app, ybl.a(localybl), true);
        if (this.mUniseq == 0L)
        {
          parama = ujt.a(localybl.mActivity, "", parama, localHashMap, true);
          ybl.a(localybl, anbi.a(localybl.app, "0", "0", "0", 0, 0L, parama));
          parama = (anqu)parama.mStructMsgItemLists.get(0);
          if ((parama instanceof anqv))
          {
            parama = (anqu)((anqv)parama).rz.get(0);
            if ((parama instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)parama).setText(localybl.mSourceName);
            }
          }
        }
        localybl.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.1(this, localybl, (CharSequence)localObject));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.onDownload failed");
        }
      } while (localybl == null);
      ajlc.a().a(localybl.app, null, false);
      localybl.mActivity.runOnUiThread(new MultiForwardChatPie.MultiMsgDownloadCallback.2(this, localybl));
    }
    
    public void aS(int paramInt, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybl
 * JD-Core Version:    0.7.0.1
 */