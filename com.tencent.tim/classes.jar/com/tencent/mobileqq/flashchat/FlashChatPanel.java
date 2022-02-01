package com.tencent.mobileqq.flashchat;

import abin;
import acfp;
import adqr;
import ahej;
import ahek;
import ahep;
import ahxs;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aofk;
import aofy;
import aqcl;
import aqdj;
import aqrf;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import mqq.app.MobileQQ;
import wja;
import wlz;
import wyw;

@TargetApi(11)
public class FlashChatPanel
  extends RelativeLayout
  implements ahep, ViewPager.OnPageChangeListener, View.OnClickListener, TabBarView.a, Runnable
{
  public static final int bQT;
  public static final int bTs = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  protected static final int bTt = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  public static final int bTu = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  public static final int bTv = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  public static final int bsz;
  public static int cZH;
  public static final int cZI;
  public View Dn;
  TabBarView a;
  public FlashChatTextEffectView[] a;
  int aXA = -1;
  ArkAppLoadLayout jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  QQViewPager jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager = null;
  ArkAppView c;
  public HiBoomTextView c;
  int cZJ = -1;
  public int cZK;
  public boolean cgv;
  public ArkAppRootLayout d;
  public MessageForArkFlashChat e;
  public ETTextView j;
  public HashMap<Integer, ArkFlashChatContainerWrapper> kW = new HashMap();
  RelativeLayout ky = null;
  public int[] ls = new int[2];
  BaseChatPie mBaseChatPie;
  public View mBtnSend;
  int mCurrentTab = -1;
  public HashMap<Integer, ArkFlashChatContainerWrapper> mHashMap = new HashMap();
  public Random mRandom = new Random();
  int mSelectedPosition;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    bQT = wja.dp2px(400.0F, localResources);
    cZI = wja.dp2px(1.0F, localResources);
    bsz = (localResources.getDisplayMetrics().widthPixels - cZI * 2) / 3;
    cZH = wja.dp2px(100.0F, localResources);
  }
  
  public FlashChatPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
  }
  
  public FlashChatPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView = new FlashChatTextEffectView[2];
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    paramQQAppInterface = new Rect();
    paramDrawable.getPadding(paramQQAppInterface);
    int i = paramView.getPaddingTop();
    int k = paramQQAppInterface.top;
    int m = paramView.getPaddingLeft();
    int n = paramQQAppInterface.left;
    int i1 = paramView.getPaddingRight();
    int i2 = paramQQAppInterface.right;
    int i3 = paramView.getPaddingBottom();
    int i4 = paramQQAppInterface.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(m + n, i + k, i1 + i2, i4 + i3);
  }
  
  private void a(FlashChatItem paramFlashChatItem)
  {
    String str2 = aofy.oh(ahxs.ls(this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = acfp.m(2131706338);
    }
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.panel", 2, "updateHiBoomPreview item = " + paramFlashChatItem);
    }
    this.j.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(paramFlashChatItem.id, 0, ahxs.b);
    this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText(str1);
  }
  
  public static float bd()
  {
    return 20.0F * MobileQQ.sMobileQQ.getResources().getDisplayMetrics().scaledDensity + adqr.cJe;
  }
  
  public static float be()
  {
    return bd() * 3.0F / 4.0F;
  }
  
  public void C(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "selectItem " + paramInt1 + " " + paramInt2);
    }
    Object localObject2 = a(paramInt1, paramInt2);
    Object localObject1;
    if (localObject2 != null) {
      if (((FlashChatItem)localObject2).id == -100000)
      {
        localObject1 = d(paramInt1);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "random empty");
          }
          this.mSelectedPosition = paramInt2;
          this.aXA = paramInt1;
          paramInt1 = i;
          label111:
          if (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView.length) {
            break label225;
          }
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt1];
          if (localObject1 != null)
          {
            if (paramInt1 == this.aXA) {
              break label469;
            }
            ((FlashChatTextEffectView)localObject1).select(-1);
          }
        }
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label111;
      QLog.d("FlashChat", 2, "random" + ((Pair)localObject1).first + " " + ((Pair)localObject1).second);
      ii(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
      label225:
      return;
      if (paramInt1 == 0)
      {
        localObject1 = FlashChatManager.a(this.mBaseChatPie.app, (FlashChatItem)localObject2);
        if (localObject1 != null)
        {
          localObject2 = "mvip.g.a.sl_" + ((FlashChatItem)localObject2).id;
          aqrf.a(getContext(), (String)localObject2, (String)localObject1, 0, false, false);
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(this.aXA, false);
        }
        setupArkUI((FlashChatItem)localObject2);
        break;
      }
      if (paramInt1 != 1) {
        break;
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
      }
      a((FlashChatItem)localObject2);
      break;
      localObject2 = this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131706329);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "cancelChoose");
      }
      this.j.setVisibility(0);
      this.j.setText((CharSequence)localObject2);
      this.d.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
      if ((!paramBoolean) || (paramInt1 < 0) || (paramInt1 > 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
      break;
      label469:
      ((FlashChatTextEffectView)localObject1).select(paramInt2);
    }
  }
  
  public void Kn(boolean paramBoolean)
  {
    int m = -1;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      com.tencent.widget.XPanelContainer.aLe = (int)(246.0F * getResources().getDisplayMetrics().density);
      localObject1 = a(true);
      if (((RelativeLayout)localObject1).getParent() == null)
      {
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((FrameLayout)this.mBaseChatPie.mAIORootView.findViewById(2131373566)).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        this.mBaseChatPie.mAIORootView.findViewById(2131367817).setVisibility(8);
        this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(8);
        if (this.mBaseChatPie.b != null)
        {
          this.cZK = this.mBaseChatPie.b.getHeight();
          this.mBaseChatPie.b.setCustomHeight(0);
        }
        if (this.mBaseChatPie.jdField_a_of_type_Abin != null) {
          this.mBaseChatPie.jdField_a_of_type_Abin.DF(false);
        }
        this.mBaseChatPie.bIf();
        localObject3 = this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ((String)localObject3).trim();
        }
        if ((localObject1 != null) && (((String)localObject1).length() != 0) && (((String)localObject1).length() <= 20)) {
          break label410;
        }
        this.mBtnSend.setEnabled(false);
        label229:
        localObject1 = ((FlashChatManager)this.mBaseChatPie.app.getManager(217)).we();
        if (localObject1 == null) {
          break label723;
        }
      }
    }
    for (;;)
    {
      int i;
      int n;
      for (;;)
      {
        int k;
        try
        {
          localObject1 = ((String)localObject1).split(":");
          if (localObject1.length != 2) {
            break label723;
          }
          i = Integer.valueOf(localObject1[0]).intValue();
          k = i;
        }
        catch (Exception localException1)
        {
          int i1;
          int i2;
          label410:
          i = -1;
          k = m;
        }
        try
        {
          n = Integer.valueOf(localObject1[1]).intValue();
          k = i;
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[i];
          k = m;
          if (localObject1 != null)
          {
            m = -1;
            k = 0;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            i = k;
            k = m;
          }
        }
        try
        {
          if (k >= ((FlashChatTextEffectView)localObject1).getSize()) {
            break label717;
          }
          localObject3 = ((FlashChatTextEffectView)localObject1).a(k);
          if (i == 0)
          {
            i1 = m;
            if (FlashChatManager.a(this.mBaseChatPie.app, (FlashChatItem)localObject3) == null)
            {
              i1 = m;
              if (localObject3 != null)
              {
                i2 = ((FlashChatItem)localObject3).id;
                i1 = m;
                if (i2 == n) {
                  i1 = k;
                }
              }
            }
            k += 1;
            m = i1;
            continue;
            ((RelativeLayout)localObject1).setVisibility(0);
            break;
            this.mBtnSend.setEnabled(true);
            break label229;
          }
          i1 = m;
          if (i == 1)
          {
            i1 = m;
            if (localObject3 != null)
            {
              i2 = ((FlashChatItem)localObject3).id;
              i1 = m;
              if (i2 != n) {}
            }
          }
        }
        catch (Exception localException3)
        {
          k = m;
          break label511;
          k = m;
        }
      }
      C(i, k, true);
      if (i == 0)
      {
        localObject1 = (FlashChatManager)this.mBaseChatPie.app.getManager(217);
        if (((FlashChatManager)localObject1).cS().size() < 3) {
          ((FlashChatManager)localObject1).dmU();
        }
      }
      return;
      label511:
      localException1.printStackTrace();
      continue;
      this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setVisibility(0);
      if (this.mBaseChatPie.jdField_a_of_type_Abin != null) {
        this.mBaseChatPie.jdField_a_of_type_Abin.DF(true);
      }
      this.mBaseChatPie.bIe();
      localObject2 = a(false);
      if (localObject2 != null) {
        ((RelativeLayout)localObject2).setVisibility(8);
      }
      this.mBaseChatPie.mAIORootView.findViewById(2131367817).setVisibility(0);
      if (this.mBaseChatPie.b != null) {
        this.mBaseChatPie.b.setCustomHeight(this.cZK);
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView != null)
      {
        localObject2 = this.kW.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ArkFlashChatContainerWrapper)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((ArkFlashChatContainerWrapper)localObject3).doOnEvent(2);
          }
        }
        this.kW.clear();
      }
      if (QLog.isColorLevel())
      {
        QLog.i("FlashChat", 2, "restore layout");
        return;
        label717:
        label723:
        n = -1;
        i = -1;
      }
    }
  }
  
  public RelativeLayout a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.ky;
    }
    if (this.ky == null)
    {
      Object localObject2 = getContext();
      this.ky = ((RelativeLayout)LayoutInflater.from((Context)localObject2).inflate(2131561354, null));
      this.ky.setOnClickListener(this);
      this.ky.findViewById(2131364677).setOnClickListener(this);
      this.Dn = this.ky.findViewById(2131364224);
      this.Dn.setOnClickListener(this);
      Object localObject1 = this.mBaseChatPie.app;
      ((ImageView)this.ky.findViewById(2131365616)).setImageDrawable(aqdj.a((AppInterface)localObject1, 1, ((QQAppInterface)localObject1).getCurrentUin()));
      this.ky.findViewById(2131362975).setPadding(0, 0, 0, 0);
      Object localObject3 = (ArkAppLoadLayout)this.ky.findViewById(2131370776);
      Object localObject4 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).setMargins(5, 5, 5, 5);
      ((ArkAppLoadLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.j = ((ETTextView)this.ky.findViewById(2131379589));
      this.j.setTextColor(((Context)localObject2).getResources().getColorStateList(2131167322));
      this.j.setLinkTextColor(((Context)localObject2).getResources().getColorStateList(2131167316));
      this.j.setSpannableFactory(aofk.a);
      this.j.setMaxWidth(BaseChatItemLayout.bNS);
      this.j.setMovementMethod(LinkMovementMethod.getInstance());
      if ((0 == 0) && (BaseApplicationImpl.sImageCache != null))
      {
        localObject2 = (Drawable.ConstantState)BaseApplicationImpl.sImageCache.get("bubblebg://default_mine");
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {}
          ((Drawable.ConstantState)localObject2).newDrawable();
        }
      }
      localObject2 = ((QQAppInterface)localObject1).getApp().getResources();
      localObject3 = ((Resources)localObject2).getDrawable(2130851001);
      localObject4 = ((Resources)localObject2).getDrawable(2130851000);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject4);
      if (BaseApplicationImpl.sImageCache != null)
      {
        if (QLog.isColorLevel()) {}
        BaseApplicationImpl.sImageCache.put("bubblebg://default_mine", localStateListDrawable.getConstantState());
      }
      a((QQAppInterface)localObject1, this.j, localStateListDrawable);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167326);
      this.j.setPadding(bTu, bTs, bTv, bTt);
      this.j.setTextColor((ColorStateList)localObject1);
      this.j.setTextSize(0, this.mBaseChatPie.sessionInfo.cN);
      this.d = ((ArkAppRootLayout)this.ky.findViewById(2131362963));
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.ky.findViewById(2131362952));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)this.ky.findViewById(2131370776));
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(14.0F);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(2);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setAlignLeft(false);
      new b();
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new ahek(this));
      this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)this.ky.findViewById(2131368515));
    }
    return this.ky;
  }
  
  public FlashChatItem a()
  {
    return a(this.aXA, this.mSelectedPosition);
  }
  
  public FlashChatItem a(int paramInt1, int paramInt2)
  {
    try
    {
      FlashChatItem localFlashChatItem = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt1].a(paramInt2);
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("FlashChat", 2, "recordChoose " + paramInt1 + " " + this.mSelectedPosition + "" + paramInt2);
      }
    }
    return null;
  }
  
  public boolean anb()
  {
    if (getVisibility() != 0) {}
    while (TextUtils.isEmpty(this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
      return false;
    }
    dmW();
    this.mBaseChatPie.send();
    return true;
  }
  
  public void close()
  {
    dmW();
    this.mBaseChatPie.hidePanel();
    Kn(false);
  }
  
  public Pair<Integer, Integer> d(int paramInt)
  {
    Object localObject = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        FlashChatTextEffectView localFlashChatTextEffectView = this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[paramInt];
        if (localFlashChatTextEffectView != null)
        {
          i = 0;
          if (i < localFlashChatTextEffectView.getSize())
          {
            FlashChatItem localFlashChatItem = localFlashChatTextEffectView.a(i);
            if ((FlashChatManager.a(this.mBaseChatPie.app, localFlashChatItem) != null) || (localFlashChatItem.id == -100000)) {
              break label152;
            }
            ((ArrayList)localObject).add(new Pair(Integer.valueOf(paramInt), Integer.valueOf(i)));
            break label152;
          }
        }
        if (((ArrayList)localObject).isEmpty()) {
          return null;
        }
        i = this.mRandom.nextInt(((ArrayList)localObject).size());
        paramInt = i;
        if (this.cZJ == i) {
          paramInt = (i + 1) / ((ArrayList)localObject).size();
        }
        this.cZJ = paramInt;
        localObject = (Pair)((ArrayList)localObject).get(paramInt);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label152:
      i += 1;
    }
  }
  
  public void dmW()
  {
    FlashChatItem localFlashChatItem = a();
    if (QLog.isColorLevel()) {
      QLog.i("FlashChat", 1, "recordChoose" + this.aXA + " " + localFlashChatItem);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localFlashChatItem != null)
    {
      localStringBuilder.append(this.aXA);
      localStringBuilder.append(":");
      if (localFlashChatItem != null) {
        break label126;
      }
      localStringBuilder.append(-1);
    }
    for (;;)
    {
      ((FlashChatManager)this.mBaseChatPie.app.getManager(217)).JU(localStringBuilder.toString());
      return;
      localStringBuilder.append(this.mCurrentTab);
      break;
      label126:
      localStringBuilder.append(localFlashChatItem.id);
    }
  }
  
  public void dmX()
  {
    ii(this.aXA, -1);
    dmW();
    QQToast.a(getContext(), acfp.m(2131706328), 0).show();
  }
  
  public void h(View paramView, int paramInt1, int paramInt2)
  {
    if (AppSetting.enableTalkBack) {}
    try
    {
      FlashChatItem localFlashChatItem = a(paramInt2, paramInt1);
      if (localFlashChatItem != null) {
        aqcl.speak(paramView, localFlashChatItem.name);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
    ii(paramInt2, paramInt1);
  }
  
  public void ii(int paramInt1, int paramInt2)
  {
    C(paramInt1, paramInt2, false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (this.ky != paramView) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anb();
      close();
      continue;
      close();
      this.cgv = true;
      continue;
      dmX();
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
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, false);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt2, true);
    this.mCurrentTab = paramInt2;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void run()
  {
    Object localObject = a(false);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((View)localObject).getLayoutParams();
    } while (localObject == null);
    ((ViewGroup)this.mBaseChatPie.mAIORootView.findViewById(2131369277)).getLocationInWindow(this.ls);
    ((ViewGroup.LayoutParams)localObject).height = (this.ls[1] - ImmersiveUtils.getStatusBarHeight(getContext()));
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Kn(true);
      return;
    }
    if (!this.cgv) {
      dmW();
    }
    Kn(false);
  }
  
  public void setupArkUI(FlashChatItem paramFlashChatItem)
  {
    Object localObject2 = this.mBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = acfp.m(2131706330);
    }
    for (;;)
    {
      int i;
      if (paramFlashChatItem.id == -100000)
      {
        i = this.mRandom.nextInt(2);
        int k = this.mRandom.nextInt(this.jdField_a_of_type_ArrayOfComTencentMobileqqFlashchatFlashChatTextEffectView[i].getSize());
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "setupArkUI  random " + i + " " + k);
        }
        ii(i, k);
      }
      ArkAppView localArkAppView;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "setupArkUI" + paramFlashChatItem);
        }
        this.j.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqHiboomHiBoomTextView.setVisibility(8);
        this.d.setVisibility(0);
        i = paramFlashChatItem.id;
        localArkAppView = this.jdField_c_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      } while (localArkAppView == null);
      Object localObject3 = (ArkFlashChatContainerWrapper)this.kW.get(Integer.valueOf(i));
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new ArkFlashChatContainerWrapper();
        this.kW.put(Integer.valueOf(i), localObject2);
      }
      localObject3 = new MessageForArkFlashChat();
      ((MessageForArkFlashChat)localObject3).uniseq = i;
      ((MessageForArkFlashChat)localObject3).ark_app_message = new ArkFlashChatMessage();
      ((MessageForArkFlashChat)localObject3).ark_app_message.promptText = ((String)localObject1);
      ((MessageForArkFlashChat)localObject3).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
      localObject1 = this.e;
      this.e = ((MessageForArkFlashChat)localObject3);
      ((ArkFlashChatContainerWrapper)localObject2).a(this.mBaseChatPie.app, getContext(), paramFlashChatItem.appName, paramFlashChatItem.mainView, paramFlashChatItem.ver, paramFlashChatItem.id, ((MessageForArkFlashChat)localObject3).ark_app_message.getMeta(((MessageForArkFlashChat)localObject3).uniseq, false), getContext().getResources().getDisplayMetrics().scaledDensity, this.mBaseChatPie.a(), bd(), be(), bd(), be(), this.e);
      localArkAppView.a((wyw)localObject2, this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setCallback(new ahej(this, paramFlashChatItem, (MessageForArkFlashChat)localObject1, (MessageForArkFlashChat)localObject3));
      localArkAppView.a((wyw)localObject2, this.jdField_b_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      return;
    }
  }
  
  public void x(View paramView, int paramInt1, int paramInt2) {}
  
  public static class a
  {
    public int actionId;
    public int appid;
    public FlashChatItem b;
    public boolean beg;
    public String contentDescription;
    public String text;
  }
  
  public class b
    implements wlz
  {
    public b() {}
    
    public boolean onLongClick(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      return true;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if ((paramView instanceof ArkAppView)) {
        ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatPanel
 * JD-Core Version:    0.7.0.1
 */