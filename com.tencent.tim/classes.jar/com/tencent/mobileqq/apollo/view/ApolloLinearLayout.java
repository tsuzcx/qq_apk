package com.tencent.mobileqq.apollo.view;

import abhh;
import abhs;
import abxi;
import abxk;
import abzy;
import abzz;
import altq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqrb;
import aqrd;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import wja;

public class ApolloLinearLayout
  extends LinearLayout
{
  public static int cug;
  public static Rect tmp = new Rect();
  View AV;
  View AW = null;
  public CheckForLongPress a;
  public boolean bGy;
  public AtomicInteger ba = new AtomicInteger(0);
  public AtomicInteger bb = new AtomicInteger(0);
  public FrameLayout bq;
  public FrameLayout br;
  int ctO = 2;
  public aqrd f = new abzz(this);
  public BaseChatPie i;
  int mBinderType;
  int mColumn = 4;
  boolean mHasPerformedLongPress;
  public SessionInfo mSessionInfo;
  int page;
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    super.setOrientation(1);
    this.mBinderType = paramInt1;
    if (this.mBinderType == 4)
    {
      l(paramContext, paramInt2, paramInt3);
      return;
    }
    k(paramContext, paramInt2, paramInt3);
  }
  
  private static void a(a parama, int paramInt)
  {
    parama.wm.setVisibility(0);
    parama.wm.setImageResource(paramInt);
  }
  
  private void k(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int n = (int)((int)((int)((int)((int)(XPanelContainer.aLe - (XPanelContainer.evb * 0.25D + 12.0F * f2)) - 14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity * 2.0F) - (12.0F * f2 + 10.0F * f2 + 10.0F * f2)) - 6.0F * f2) - 40.0F * f2) / 2;
    cug = n;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.aLe + "imgHeight = " + n + "addHeight=" + XPanelContainer.evb);
    }
    int j = 0;
    while (j < paramInt2)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity) + n + (int)(6.0F * f2));
      localLayoutParams.leftMargin = ((int)(15.0F * f2));
      localLayoutParams.rightMargin = ((int)(15.0F * f2));
      localLinearLayout.setOrientation(0);
      int k;
      label256:
      Object localObject1;
      View localView;
      Object localObject2;
      int m;
      if (j == 0) {
        if (XPanelContainer.evb > 0)
        {
          localLayoutParams.topMargin = ((int)(12.0F * f2));
          k = 0;
          if (k >= paramInt1) {
            break label781;
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localView = LayoutInflater.from(paramContext).inflate(2131558733, null);
          localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new a();
          ((a)localObject1).ju = ((RelativeLayout)localView.findViewById(2131362767));
          ((a)localObject1).sk = ((ImageView)localView.findViewById(2131363197));
          ((a)localObject1).PW = ((TextView)localView.findViewById(2131362765));
          ((a)localObject1).xZ = ((ImageView)localView.findViewById(2131362763));
          ((a)localObject1).jw = ((RelativeLayout)localView.findViewById(2131362764));
          localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).sk.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).height = n;
          ((RelativeLayout.LayoutParams)localObject2).width = n;
          ((a)localObject1).name = ((TextView)localView.findViewById(2131362801));
          ((a)localObject1).g = ((URLImageView)localView.findViewById(2131362804));
          localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).g.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = (n / 2);
          ((RelativeLayout.LayoutParams)localObject2).height = (n / 2);
          ((a)localObject1).jv = ((RelativeLayout)localView.findViewById(2131362807));
          localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).jv.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = ((wja.dp2px(8.0F, getResources()) + n) / 2);
          if (XPanelContainer.evb <= 0) {
            break label753;
          }
          m = wja.dp2px(16.0F, getResources());
          label541:
          ((RelativeLayout.LayoutParams)localObject2).height = m;
          ((a)localObject1).Qn = ((TextView)localView.findViewById(2131362800));
          localObject2 = ((a)localObject1).Qn;
          if (XPanelContainer.evb <= 0) {
            break label767;
          }
          f1 = 8.0F;
          label582:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).Qn.getLayoutParams();
          if (XPanelContainer.evb <= 0) {
            break label774;
          }
        }
      }
      label774:
      for (float f1 = 16.0F;; f1 = 10.0F)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = ((n - wja.dp2px(f1, getResources())) / 2);
        ((a)localObject1).wm = ((ImageView)localView.findViewById(2131362806));
        ((a)localObject1).xX = ((ImageView)localView.findViewById(2131362803));
        ((a)localObject1).xY = ((ImageView)localView.findViewById(2131362805));
        ((RelativeLayout.LayoutParams)((a)localObject1).xY.getLayoutParams()).width = ((n - wja.dp2px(4.0F, getResources())) / 2);
        localView.setTag(localObject1);
        k += 1;
        break label256;
        localLayoutParams.topMargin = ((int)(12.0F * f2));
        break;
        localLayoutParams.topMargin = ((int)(6.0F * f2));
        break;
        label753:
        m = wja.dp2px(12.0F, getResources());
        break label541;
        label767:
        f1 = 6.0F;
        break label582;
      }
      label781:
      super.addView(localLinearLayout, localLayoutParams);
      j += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.evb));
  }
  
  private void l(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int n = (int)((int)((int)((int)(XPanelContainer.aLe - (XPanelContainer.evb * 0.25D + 50.0F * f2)) - (10.0F * f2 + 10.0F * f2)) - 10.0F * f2) - 40.0F * f2) / 2;
    cug = n;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.aLe + "imgHeight = " + n + "addHeight=" + XPanelContainer.evb);
    }
    int j = 0;
    while (j < paramInt2)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, n);
      localLayoutParams.leftMargin = ((int)(10.0F * f2));
      localLayoutParams.rightMargin = ((int)(20.0F * f2));
      localLinearLayout.setOrientation(0);
      if (j == 1) {
        localLayoutParams.topMargin = ((int)(10.0F * f2));
      }
      int k = 0;
      if (k < paramInt1)
      {
        Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * f2));
        View localView = LayoutInflater.from(paramContext).inflate(2131558734, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new a();
        ((a)localObject1).ju = ((RelativeLayout)localView.findViewById(2131362767));
        ((a)localObject1).sk = ((ImageView)localView.findViewById(2131363197));
        ((a)localObject1).PW = ((TextView)localView.findViewById(2131362765));
        ((a)localObject1).xZ = ((ImageView)localView.findViewById(2131362763));
        ((a)localObject1).jw = ((RelativeLayout)localView.findViewById(2131362764));
        Object localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).sk.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = n;
        ((RelativeLayout.LayoutParams)localObject2).width = n;
        ((a)localObject1).name = ((TextView)localView.findViewById(2131362801));
        ((a)localObject1).g = ((URLImageView)localView.findViewById(2131362804));
        localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).g.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (n / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (n / 2);
        ((a)localObject1).jv = ((RelativeLayout)localView.findViewById(2131362807));
        localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).jv.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((wja.dp2px(8.0F, getResources()) + n) / 2);
        int m;
        if (XPanelContainer.evb > 0)
        {
          m = wja.dp2px(16.0F, getResources());
          label504:
          ((RelativeLayout.LayoutParams)localObject2).height = m;
          ((a)localObject1).Qn = ((TextView)localView.findViewById(2131362800));
          localObject2 = ((a)localObject1).Qn;
          if (XPanelContainer.evb <= 0) {
            break label702;
          }
          f1 = 8.0F;
          label545:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((a)localObject1).Qn.getLayoutParams();
          if (XPanelContainer.evb <= 0) {
            break label709;
          }
        }
        label702:
        label709:
        for (float f1 = 16.0F;; f1 = 10.0F)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = ((n - wja.dp2px(f1, getResources())) / 2);
          ((a)localObject1).wm = ((ImageView)localView.findViewById(2131362806));
          ((a)localObject1).xX = ((ImageView)localView.findViewById(2131362803));
          ((a)localObject1).xY = ((ImageView)localView.findViewById(2131362805));
          ((RelativeLayout.LayoutParams)((a)localObject1).xY.getLayoutParams()).width = ((n - wja.dp2px(4.0F, getResources())) / 2);
          localView.setTag(localObject1);
          k += 1;
          break;
          m = wja.dp2px(12.0F, getResources());
          break label504;
          f1 = 6.0F;
          break label545;
        }
      }
      super.addView(localLinearLayout, localLayoutParams);
      j += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.evb));
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, a parama)
  {
    int j = 1;
    if ((paramInt & 0x1) > 0)
    {
      parama.xY.setImageResource(2130838667);
      parama.xY.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      parama.xY.setImageResource(2130838664);
      parama.xY.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(parama, 2130838656);
    }
    if ((paramInt & 0x80) > 0)
    {
      parama.Qn.setVisibility(0);
      parama.Qn.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(parama, 2130838659);
    }
    if ((paramInt & 0x200) > 0) {
      a(parama, 2130838658);
    }
    if ((paramInt & 0x4) > 0) {
      a(parama, 2130838666);
    }
    if ((paramInt & 0x8) > 0) {
      a(parama, 2130838666);
    }
    if ((paramInt & 0x10) > 0) {
      a(parama, 2130838666);
    }
    if ((paramInt & 0x2) > 0) {
      a(parama, 2130838662);
    }
    if ((paramInt & 0x2000) > 0)
    {
      parama.wm.setVisibility(0);
      ApolloUtil.a(parama.wm, true, true);
    }
    paramInt = j;
    if (paramApolloActionData.feeType == 10)
    {
      paramInt = j;
      if (!ApolloUtil.ba(parama.wm.getContext()))
      {
        parama.wm.setVisibility(0);
        parama.wm.setImageResource(2130838661);
        paramApolloActionData = (RelativeLayout.LayoutParams)parama.wm.getLayoutParams();
        if (paramApolloActionData != null)
        {
          paramApolloActionData.addRule(11);
          paramApolloActionData.addRule(9, 0);
        }
        paramInt = 0;
      }
    }
    if (paramInt != 0)
    {
      paramApolloActionData = (RelativeLayout.LayoutParams)parama.wm.getLayoutParams();
      if (paramApolloActionData != null)
      {
        paramApolloActionData.addRule(9);
        paramApolloActionData.addRule(11, 0);
      }
    }
  }
  
  public View a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramApolloActionData == null) {}
    int j;
    do
    {
      return localObject2;
      j = 0;
      localObject2 = localObject1;
    } while (j >= super.getChildCount());
    LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(j);
    int k = 0;
    label39:
    if (k < localLinearLayout.getChildCount())
    {
      localObject2 = localLinearLayout.getChildAt(k);
      Object localObject3 = (a)((View)localObject2).getTag();
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).d;
        if ((localObject3 != null) && (((abzy)localObject3).c != null) && (((abzy)localObject3).c.actionId == paramApolloActionData.actionId)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      k += 1;
      break label39;
    }
  }
  
  public void a(View paramView, abzy paramabzy)
  {
    d(this.i, paramabzy);
  }
  
  public boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  public View b(float paramFloat1, float paramFloat2)
  {
    int j = super.getChildCount() - 1;
    while (j >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(j);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int k = localLinearLayout.getChildCount() - 1;
        while (k >= 0)
        {
          View localView = localLinearLayout.getChildAt(k);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          k -= 1;
        }
      }
      j -= 1;
    }
    return null;
  }
  
  public boolean b(ApolloActionData paramApolloActionData)
  {
    if ((this.i == null) || (this.i.app == null) || (paramApolloActionData == null)) {
      return false;
    }
    Object localObject = (abhh)this.i.app.getManager(153);
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(abxi.bjf).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    if (!((abhh)localObject).jm(this.i.app.getCurrentUin()))
    {
      localObject = super.getResources().getString(2131690337);
      String str1 = super.getResources().getString(2131690342);
      String str2 = super.getResources().getString(2131690336);
      String str3 = abxi.bjf + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
      if (this.mSessionInfo != null) {
        VipUtils.a(this.i.app, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.gi(this.mSessionInfo.cZ), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
      }
      localHashMap.put("APOLLO_POP_TYPE", "dialog");
      localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
      localHashMap.put("title", str1);
      localHashMap.put("content", localObject);
      localHashMap.put("rightString", str2);
      localHashMap.put("url", str3);
      localHashMap.put("actionId", "" + paramApolloActionData.actionId);
      localHashMap.put("personNum", String.valueOf(paramApolloActionData.personNum));
      if ((this.i == null) || (this.i.app == null)) {
        return false;
      }
      paramApolloActionData = this.i.app.getHandler(ChatActivity.class);
      if (paramApolloActionData != null)
      {
        paramApolloActionData = paramApolloActionData.obtainMessage(45);
        paramApolloActionData.obj = localHashMap;
        paramApolloActionData.sendToTarget();
      }
      return false;
    }
    return true;
  }
  
  public void cGz()
  {
    if ((this.bq != null) && (this.bGy))
    {
      ((WindowManager)super.getContext().getSystemService("window")).removeViewImmediate(this.br);
      this.bGy = false;
    }
  }
  
  public void clear()
  {
    int j = 0;
    while (j < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(j);
      int m = localLinearLayout.getChildCount();
      int k = 0;
      while (k < m)
      {
        Object localObject = localLinearLayout.getChildAt(k);
        if (localObject != null)
        {
          localObject = (a)((View)localObject).getTag();
          if ((localObject != null) && (((a)localObject).sk != null))
          {
            ((a)localObject).sk.setBackgroundDrawable(null);
            ((a)localObject).sk.setImageDrawable(null);
            ((a)localObject).sk.setVisibility(8);
            ((a)localObject).name.setText("");
            ((a)localObject).Qn.setVisibility(8);
            ((a)localObject).wm.setVisibility(8);
            ((a)localObject).g.setVisibility(8);
            ((a)localObject).xY.setVisibility(8);
            ((a)localObject).xX.setVisibility(8);
            ((a)localObject).d = null;
            ((a)localObject).jw.setVisibility(8);
            ((a)localObject).xZ.setVisibility(8);
            if (((a)localObject).redTouch != null) {
              ((a)localObject).redTouch.dGB();
            }
            if (((a)localObject).ju != null) {
              ((a)localObject).ju.setBackgroundDrawable(null);
            }
          }
        }
        k += 1;
      }
      j += 1;
    }
    this.page = -1;
  }
  
  public void d(BaseChatPie paramBaseChatPie, abzy paramabzy)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramabzy == null)) {}
    abhs localabhs;
    do
    {
      return;
      localabhs = ((abhh)paramBaseChatPie.getApp().getManager(153)).a();
    } while (localabhs == null);
    localabhs.c(paramBaseChatPie, paramabzy);
  }
  
  public void gl(View paramView)
  {
    Object localObject = (a)paramView.getTag();
    if ((((a)localObject).d != null) && (this.i != null) && (((a)localObject).d.mType == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((altq)this.i.app.getManager(36)).OS(String.valueOf("103100.103200"));
      if (((a)localObject).redTouch != null) {
        ((a)localObject).redTouch.dGB();
      }
      ApolloUtil.a(this.i.mActivity, null, "aio", abxi.bju, null);
      if (this.mSessionInfo != null) {
        VipUtils.a(this.i.app, "cmshow", "Apollo", "enter_aio_clk", this.mSessionInfo.aTl, ApolloUtil.gi(this.mSessionInfo.cZ), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    label981:
    label983:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              boolean bool1;
              for (;;)
              {
                return;
                if ((((a)localObject).d != null) && (this.i != null) && (((a)localObject).d.mType == 2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
                  }
                  paramView = new Intent();
                  paramView.putExtra("extra_key_url_append", "&view=customize_action");
                  ApolloUtil.a(this.i.mActivity, paramView, "aio", abxi.bju, null);
                  return;
                }
                if ((((a)localObject).d != null) && (((a)localObject).d.c != null) && (((a)localObject).d.c.status != 0))
                {
                  localObject = ((a)localObject).d;
                  ((abzy)localObject).c.peerUin = null;
                  ((abzy)localObject).c.boy1 = null;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "click action " + ((abzy)localObject).toString());
                  }
                  if (!ApolloUtil.aF(((abzy)localObject).c.actionId, ((abzy)localObject).c.personNum))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((abzy)localObject).c.actionId);
                    }
                    j(((abzy)localObject).c);
                  }
                  if (this.mSessionInfo.cZ == 0) {
                    if ((this.i != null) && (this.i.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                      VipUtils.a(this.i.app, "cmshow", "Apollo", "action_clk", this.mSessionInfo.aTl, -1, 0, new String[] { "" + ((abzy)localObject).c.actionId, "655_" + ((abzy)localObject).cud, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                    }
                  }
                  for (;;)
                  {
                    if ((this.i == null) || (this.i.app == null)) {
                      break label981;
                    }
                    abxk localabxk = (abxk)this.i.app.getManager(155);
                    bool1 = localabxk.hY(((abzy)localObject).c.actionId);
                    bool2 = localabxk.hZ(((abzy)localObject).c.actionId);
                    if (((((abzy)localObject).c.feeType != 6) && (((abzy)localObject).c.feeType != 7)) || (bool1) || (bool2)) {
                      break label983;
                    }
                    ImageView localImageView = (ImageView)paramView.findViewById(2131379764);
                    ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = ((int)(cug / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
                    localImageView.setVisibility(0);
                    paramView.setClickable(false);
                    if ((this.i == null) || (this.i.app == null)) {
                      break;
                    }
                    k(localabxk.a(((abzy)localObject).c.actionId));
                    return;
                    if (((this.mSessionInfo.cZ == 1) || (this.mSessionInfo.cZ == 3000)) && (this.i != null) && (this.i.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                      if (((abzy)localObject).c.personNum == 0) {
                        VipUtils.a(this.i.app, "cmshow", "Apollo", "g_action_single_clk", this.mSessionInfo.aTl, -1, ApolloUtil.gi(this.mSessionInfo.cZ), new String[] { "" + ((abzy)localObject).c.actionId, "655_" + ((abzy)localObject).cud, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                      } else if (((abzy)localObject).c.personNum != 1) {}
                    }
                  }
                }
              }
              if ((((abzy)localObject).c.feeType != 2) || (bool1) || (bool2)) {
                break;
              }
            } while ((this.i == null) || (this.i.app == null));
            paramView = ((abhh)this.i.app.getManager(153)).a();
          } while (paramView == null);
          paramView.a(this.i, (abzy)localObject);
          return;
        } while ((((abzy)localObject).c.feeType == 9) && (!bool2) && (!b(((abzy)localObject).c)));
        if (((abzy)localObject).c.feeType == 10)
        {
          if (!ApolloUtil.ba(getContext()))
          {
            if ((this.i != null) && (this.i.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null))
            {
              this.i.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.m(((abzy)localObject).c);
              return;
            }
            QLog.e("ApolloLinearLayout", 1, "click kapu action, callback null");
            return;
          }
          if ((this.i != null) && (this.i.app != null) && (this.i.a() != null)) {
            VipUtils.a(this.i.app, "cmshow", "Apollo", "sendunlockedsucces", ApolloUtil.gi(this.i.a().cZ), 0, new String[] { String.valueOf(((abzy)localObject).c.actionId) });
          }
        }
      } while ((this.i == null) || (this.i.app == null));
      paramView = ((abhh)this.i.app.getManager(153)).a();
    } while (paramView == null);
    paramView.b(this.i, (abzy)localObject);
  }
  
  public void j(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    ThreadManager.post(new ApolloLinearLayout.1(this, paramApolloActionData), 5, null, false);
  }
  
  public void k(ApolloActionData paramApolloActionData)
  {
    if ((this.i == null) || (this.i.app == null) || (paramApolloActionData == null)) {
      return;
    }
    this.i.app.addObserver(this.f);
    ((aqrb)this.i.app.getBusinessHandler(71)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
    this.ba.incrementAndGet();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label565:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((!this.mHasPerformedLongPress) && (this.a != null)) {
              super.removeCallbacks(this.a);
            }
            if ((this.AV != null) && (!this.mHasPerformedLongPress)) {
              gl(this.AV);
            }
            if (this.AW != null)
            {
              paramMotionEvent = this.AW;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (a)paramMotionEvent.getTag();
                if (paramMotionEvent.sk != null) {
                  paramMotionEvent.sk.setImageDrawable(null);
                }
              }
            }
            cGz();
            this.AV = null;
            return true;
            this.mHasPerformedLongPress = false;
            this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while (this.AV == null);
          if (this.a == null) {
            this.a = new CheckForLongPress();
          }
          this.a.cCe();
          super.postDelayed(this.a, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (a)this.AV.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.sk == null) || (paramMotionEvent.d == null));
        paramMotionEvent.sk.setImageResource(2130838651);
        this.AW = this.AV;
        return true;
        super.setPressed(false);
        if (this.a != null) {
          super.removeCallbacks(this.a);
        }
        if (this.AW != null)
        {
          paramMotionEvent = this.AW;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (a)paramMotionEvent.getTag();
            if (paramMotionEvent.sk != null) {
              paramMotionEvent.sk.setImageDrawable(null);
            }
          }
        }
        cGz();
        this.AV = null;
        return true;
        if ((!this.mHasPerformedLongPress) || ((a(this.AV, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label565;
        }
        this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.AV == null) || (this.AV.getTag() == null)) {
          break;
        }
        if (this.AW != null)
        {
          paramMotionEvent = this.AW;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (a)paramMotionEvent.getTag();
            if (paramMotionEvent.sk != null) {
              paramMotionEvent.sk.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (a)this.AV.getTag();
        if ((paramMotionEvent.sk != null) && (paramMotionEvent.d != null))
        {
          paramMotionEvent.sk.setImageResource(2130838651);
          this.AW = this.AV;
        }
      } while ((paramMotionEvent.d == null) || (paramMotionEvent.d.c == null) || (paramMotionEvent.d.c.status != 1) || (paramMotionEvent.d == null) || (paramMotionEvent.d.mType == 1));
      a(this.AV, paramMotionEvent.d);
      return true;
      cGz();
      return true;
    } while ((this.mHasPerformedLongPress) || (this.AV == null) || ((a(this.AV, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))));
    this.AV = null;
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.i = paramBaseChatPie;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.mSessionInfo = paramSessionInfo;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    private int cpb;
    
    CheckForLongPress() {}
    
    public void cCe()
    {
      this.cpb = ApolloLinearLayout.b(ApolloLinearLayout.this);
    }
    
    public void run()
    {
      ViewParent localViewParent = ApolloLinearLayout.a(ApolloLinearLayout.this);
      ApolloLinearLayout.a locala;
      if ((localViewParent != null) && (this.cpb == ApolloLinearLayout.a(ApolloLinearLayout.this)) && (ApolloLinearLayout.this.AV != null))
      {
        locala = (ApolloLinearLayout.a)ApolloLinearLayout.this.AV.getTag();
        if ((locala != null) && (locala.d != null) && (locala.d.c != null) && (locala.d.c.status == 1)) {
          break label86;
        }
      }
      label86:
      do
      {
        do
        {
          return;
          ApolloLinearLayout.this.mHasPerformedLongPress = true;
          localViewParent.requestDisallowInterceptTouchEvent(true);
          ApolloLinearLayout.a(ApolloLinearLayout.this, 2);
        } while ((locala.d == null) || (locala.d.mType == 1) || (locala.d.c == null));
        ApolloLinearLayout.this.a(ApolloLinearLayout.this.AV, locala.d);
      } while ((ApolloLinearLayout.this.i == null) || (ApolloLinearLayout.this.mSessionInfo == null));
      VipUtils.a(ApolloLinearLayout.this.i.app, "cmshow", "Apollo", "long_press_icon", ApolloLinearLayout.this.mSessionInfo.aTl, ApolloUtil.gi(ApolloLinearLayout.this.mSessionInfo.cZ), 0, new String[] { "" + locala.d.c.actionId, "" + locala.d.cud, "", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
  }
  
  public static class a
  {
    public View AU;
    public TextView PW;
    TextView Qn;
    public abzy d;
    public URLImageView g;
    public RelativeLayout ju;
    RelativeLayout jv;
    public RelativeLayout jw;
    public TextView name;
    public RedTouch redTouch;
    public ImageView sk;
    ImageView wm;
    public ImageView xX;
    ImageView xY;
    public ImageView xZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */