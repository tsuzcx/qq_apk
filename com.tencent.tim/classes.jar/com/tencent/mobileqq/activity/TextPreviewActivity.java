package com.tencent.mobileqq.activity;

import abgl;
import acff;
import acfp;
import acle;
import acrb;
import adxm;
import adxn;
import adxp;
import adyd;
import adye;
import ahxr;
import ahxs;
import altq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import anec;
import anlm;
import anot;
import apzp;
import apzp.a;
import aqdj;
import aqgm;
import aqgo;
import aqiw;
import aqpm;
import aqqj;
import aquy;
import aquz;
import aqva;
import aqvc;
import ayxa;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.c;
import com.tencent.mobileqq.business.sougou.WordMatchManager.e;
import com.tencent.mobileqq.business.sougou.WordMatchManager.f;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.a;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.ScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jpa;
import jqo;
import ku;
import vxc;
import vxd;
import vxe;
import vxf;
import vxg;
import wta;
import wtg;
import xva;
import yhv;

@TargetApi(11)
public class TextPreviewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String aQh = acfp.m(2131715272);
  private static final String aQj = acfp.m(2131715267);
  public static long uniseq;
  public CharSequence F = null;
  protected TextView FP;
  protected TextView FQ;
  TextView FR;
  TextView FS;
  protected long GY;
  Context L = this;
  private apzp.a jdField_a_of_type_Apzp$a;
  private apzp jdField_a_of_type_Apzp;
  private TextPreviewMenu jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu;
  public WordMatchManager.c a;
  WordMatchManager.e jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$e = new vxf(this);
  public WordMatchManager.f a;
  public ContainerView a;
  public ParticipleBottomMenuView a;
  public ParticipleView a;
  public ku a;
  public String aQi;
  protected String aQk;
  protected Rect aV;
  protected URLImageView aj;
  URLImageView al;
  public String atInfoStr;
  public ScrollView b;
  private wtg b;
  protected int bLf;
  protected int bLg;
  int bLh = 0;
  int bLi;
  public int bLj = 0;
  protected boolean baP;
  private boolean baQ;
  ExtensionInfo c = null;
  aquy d = new vxg(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  protected MotionEvent h;
  public boolean isMultiMsg;
  protected long iu;
  public MessageRecord j;
  public int mFontId = 0;
  int mFontType = 0;
  public Handler mHandler;
  private AnimationDrawable q;
  public ImageView rm;
  private ImageView rn;
  public String senderUin;
  public int sessionType;
  public String textString;
  protected View uT;
  protected View uU;
  protected View uV;
  protected View uW;
  protected View uX;
  protected View uY;
  protected View uZ;
  public int uinType = 0;
  protected View va;
  public View vb;
  public View vc;
  public View vd;
  public View ve;
  public View vf;
  
  public TextPreviewActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f = null;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$c = new vxe(this);
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface, aquy paramaquy)
  {
    File localFile = new File(ku.dV + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    Object localObject2 = aqqj.getUrl("fontAioImg");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("[id]", Integer.toString(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TextPreviewActivity", 2, "getFontInfo fontId=" + paramInt + " will down ,file path=" + localFile.getAbsolutePath());
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("font_id", paramInt);
    localObject1 = new aquz((String)localObject1, localFile);
    ((aqva)paramQQAppInterface.getManager(47)).a(1).a((aquz)localObject1, paramaquy, (Bundle)localObject2);
  }
  
  private void bVX()
  {
    ayxa.initLiuHaiProperty(this);
  }
  
  private void bVY()
  {
    if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW())) {
      ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
  }
  
  private void bVZ()
  {
    this.uW.setVisibility(8);
    if (!this.baP) {
      return;
    }
    Object localObject3 = (BubbleManager)this.app.getManager(44);
    Object localObject2 = ((BubbleManager)localObject3).a(this.bLf, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = adyd.c;
    }
    boolean bool;
    if ((this.aQk != null) && (!this.aQk.equals(this.app.getAccount())))
    {
      bool = false;
      if ((this.bLg <= 0) || (localObject1 == adyd.c)) {
        break label623;
      }
      localObject2 = (HashMap)adxn.a().eO.get(Integer.valueOf(this.bLf));
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        localObject2 = ((HashMap)localObject2).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((adye)((Iterator)localObject2).next()).type.equalsIgnoreCase("static"));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((TextView)super.findViewById(2131364053)).setText(getResources().getText(2131690238));
      }
      ((adxp)localObject1).a(this.app, bool, true, false, this.FP, this.aQk, this.bLg);
      label226:
      localObject3 = ((BubbleManager)localObject3).a(((adxp)localObject1).bubbleId, true);
      localObject2 = acfp.m(2131715257);
      i = Color.parseColor("#808080");
      localObject1 = new File(((adxp)localObject1).bvW);
      if ((localObject3 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((adxm)localObject3).name;
        i = ((adxm)localObject3).fontColor;
      }
      for (;;)
      {
        this.FQ.setText((CharSequence)localObject1);
        this.FQ.setTextColor(i);
        ((ImageView)super.findViewById(2131368375)).setImageDrawable(aqdj.a(this.app, 1, this.aQk));
        if ((this.c != null) && (this.c.isPendantValid()))
        {
          localObject1 = ((AvatarPendantManager)this.app.getManager(46)).a(this.c.pendantId);
          if (aqgm.cT(this.c.pendantId))
          {
            ((PendantInfo)localObject1).a(this.aj, 2, PendantInfo.ebQ, this.aQk, this.c.pendantDiyId);
            label407:
            this.jdField_a_of_type_Ku = ((ku)this.app.getManager(42));
            this.rm = ((ImageView)super.findViewById(2131367444));
            this.rm.setVisibility(0);
            this.FR = ((TextView)super.findViewById(2131367435));
            this.FR.setText(acfp.m(2131715266));
            if (this.jdField_a_of_type_Ku == null) {
              break label934;
            }
          }
        }
        label909:
        label934:
        for (bool = this.jdField_a_of_type_Ku.cy;; bool = false)
        {
          if (this.bLh > 0)
          {
            this.uY.setVisibility(8);
            this.uV.setVisibility(8);
            localObject1 = (ahxs)this.app.getManager(219);
            localObject2 = ((ahxs)localObject1).a(this.bLh);
            if (((ahxr)localObject2).fm != null)
            {
              this.rm.setImageBitmap(((ahxr)localObject2).fm);
              label556:
              this.FR.setText(acfp.m(2131715260));
              this.uU.setOnClickListener(this);
            }
          }
          for (;;)
          {
            this.uX = findViewById(2131371064);
            if ((bool) && (this.bLh <= 0)) {
              break label909;
            }
            this.uX.setVisibility(8);
            this.va.setVisibility(8);
            return;
            bool = true;
            break;
            label623:
            ((adxp)localObject1).a(this.app, bool, true, false, this.FP, false);
            break label226;
            ((PendantInfo)localObject1).a(this.aj, 1, PendantInfo.ebQ, this.aQk, this.c.pendantDiyId);
            break label407;
            this.aj.setImageDrawable(null);
            break label407;
            ThreadManagerV2.excute(new TextPreviewActivity.7(this, (ahxs)localObject1), 64, null, true);
            break label556;
            if (!bool)
            {
              this.uU.setVisibility(8);
              this.uZ.setVisibility(8);
            }
            else
            {
              this.uU.setOnClickListener(this);
              if (this.mFontId == -1)
              {
                if (this.c == null) {
                  break label878;
                }
                this.mFontId = ((int)this.c.uVipFont);
                this.mFontType = this.c.vipFontType;
              }
              for (;;)
              {
                localObject1 = getResources().getDrawable(2130847933);
                if (this.mFontId != 0) {
                  ThreadManager.post(new TextPreviewActivity.8(this), 8, null, true);
                }
                this.rm.setImageDrawable((Drawable)localObject1);
                if ((this.mFontType != 1) || (!ETEngine.getInstance().isEngineReady.get())) {
                  break;
                }
                localObject1 = new ETFont(this.mFontId, ku.e(this.mFontId, 1), 16.0F);
                if (!ETEngine.getInstance().native_isDecorationFont((ETFont)localObject1)) {
                  break label886;
                }
                this.FR.setText(aQh);
                break;
                label878:
                this.mFontId = 0;
              }
              label886:
              if (ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1)) {
                this.FR.setText("DIY字体");
              }
            }
          }
          this.va.setVisibility(0);
          this.uX.setVisibility(0);
          this.uX.setOnClickListener(this);
          return;
        }
        localObject1 = localObject2;
      }
    }
  }
  
  private void bWa()
  {
    this.rn.setBackgroundResource(2130838427);
    this.q = ((AnimationDrawable)this.rn.getBackground());
    this.q.start();
  }
  
  void BI(int paramInt)
  {
    Object localObject3 = (ku)this.app.getManager(42);
    int i = paramInt;
    if (paramInt == 0) {
      i = ((ku)localObject3).iG;
    }
    Object localObject2 = getResources().getDrawable(2130848023);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = getResources().getDrawable(2130848023);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    switch (i)
    {
    default: 
      localObject1 = (String)getResources().getText(2131690240);
      localObject2 = getResources().getDrawable(2130848039);
    }
    for (;;)
    {
      this.FS.setText((CharSequence)localObject1);
      this.al.setImageDrawable((Drawable)localObject2);
      return;
      localObject1 = ((ku)localObject3).ee;
      try
      {
        localObject3 = URLDrawable.getDrawable(((ku)localObject3).eh, localURLDrawableOptions);
        localObject2 = localObject3;
      }
      catch (Exception localException)
      {
        QLog.e("TextPreviewActivity", 1, "font effect exception, " + localException.getMessage());
      }
    }
  }
  
  public void bWb()
  {
    Drawable localDrawable = this.rn.getBackground();
    if ((localDrawable != null) && ((localDrawable instanceof AnimationDrawable)))
    {
      this.q = ((AnimationDrawable)localDrawable);
      this.q.stop();
      this.rn.setBackgroundResource(2130838428);
    }
  }
  
  public void bWc()
  {
    long l = System.currentTimeMillis();
    String str2;
    if (Math.abs(l - this.iu) > 2000L)
    {
      this.iu = l;
      str2 = ((ChatBackgroundManager)this.app.getManager(63)).bh(this.app.getCurrentAccountUin(), this.aQk);
      str1 = str2;
      if ("null".equals(str2)) {
        str1 = "0";
      }
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      if (this.c == null) {
        break label294;
      }
      l = this.c.pendantId;
      String str3 = this.aQk;
      int i = this.bLf;
      int k = this.mFontId;
      int m = this.bLi;
      if (this.aQi != null) {
        break label300;
      }
      str2 = this.aQk;
      label139:
      localIntent.putExtra("url", String.format("https://zb.vip.qq.com/v2/aioPage?targetUin=%s&widgetId=%d&bubbleId=%d&fontId=%d&fontEffectId=%d&bgId=%s&chatId=%s&isGroup=%d", new Object[] { str3, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), str1, str2, Integer.valueOf(this.sessionType) }));
      startActivity(localIntent);
      str2 = this.app.getCurrentAccountUin();
      if (!TextUtils.equals(this.aQk, this.app.getCurrentAccountUin())) {
        break label309;
      }
    }
    label294:
    label300:
    label309:
    for (String str1 = "1";; str1 = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(str2, "aio", "icon_click", "", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
      return;
      l = 0L;
      break;
      str2 = this.aQi;
      break label139;
    }
  }
  
  protected boolean d(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView.getVisibility() != 0) {
      return false;
    }
    if (this.aV == null) {
      this.aV = new Rect();
    }
    paramView.getDrawingRect(this.aV);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.aV.left = arrayOfInt[0];
    this.aV.top = arrayOfInt[1];
    paramView = this.aV;
    int i = paramView.right;
    paramView.right = (arrayOfInt[0] + i);
    paramView = this.aV;
    i = paramView.bottom;
    paramView.bottom = (arrayOfInt[1] + i);
    return this.aV.contains(paramInt1, paramInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.baQ) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.getVisibility() == 0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if ((d(this.uW, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (d(this.vb, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (d(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (d(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) || (d(this.vf, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.cj(this))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label190;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.isScrollFinished()) {
        break label182;
      }
      this.h = MotionEvent.obtain(paramMotionEvent);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label182:
      this.h = null;
      continue;
      label190:
      if ((this.h != null) && (paramMotionEvent.getAction() == 1)) {
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.cj(this))
        {
          int i = (int)this.h.getX() - (int)paramMotionEvent.getX();
          int k = (int)this.h.getY() - (int)paramMotionEvent.getY();
          if ((i * i + k * k < 10000) && (paramMotionEvent.getEventTime() - this.h.getEventTime() < 200L))
          {
            this.h = null;
            finish();
          }
        }
        else
        {
          this.h = null;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ForwardUtils.a(this.app, paramIntent, this);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.onBackPress()) {
      super.doOnBackPressed();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((ahxs)this.app.getManager(219)).cW = null;
    if (Build.VERSION.SDK_INT >= 11) {}
    WordMatchManager localWordMatchManager = (WordMatchManager)this.app.getManager(82);
    if (localWordMatchManager != null) {
      localWordMatchManager.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$e);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f != null) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f.LJ(this.bLj);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.b(this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = null;
    }
    if (this.jdField_b_of_type_Wtg != null) {
      this.jdField_b_of_type_Wtg.h(this);
    }
    if (this.jdField_a_of_type_Apzp != null) {
      this.jdField_a_of_type_Apzp.onDestroy();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Apzp.stop();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.onPause();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView != null) && (this.jdField_b_of_type_ComTencentWidgetScrollView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.getHeight() < this.jdField_b_of_type_ComTencentWidgetScrollView.getHeight())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMinimumHeight(this.jdField_b_of_type_ComTencentWidgetScrollView.getHeight());
    }
  }
  
  public void finish()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.GY;
    if (this.textString != null) {}
    for (int i = this.textString.length();; i = 0)
    {
      anot.a(this.app, "CliOper", "", "", "long_msg", "long_msg_amount", 0, 0, String.valueOf(l1 - l2), String.valueOf(i), "", "");
      super.finish();
      overridePendingTransition(0, 2130772022);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    int i;
    anec localanec;
    boolean bool;
    if (l - this.iu > 500L)
    {
      this.iu = l;
      i = paramView.getId();
      if ((i != 2131364048) && (i != 2131364058)) {
        break label950;
      }
      localanec = (anec)this.app.getManager(12);
      if (localanec == null) {
        break label2418;
      }
      if (localanec.ee("100005.100003") == -1) {
        break label870;
      }
      bool = true;
    }
    label900:
    label905:
    label910:
    label916:
    label922:
    label928:
    label934:
    label1830:
    for (;;)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("updateFlag", bool);
      localIntent.putExtra("scrollToBubble", true);
      localIntent.putExtra("individuation_url_type", 40301);
      Object localObject2 = aqqj.e(this, "bubbleDetail", String.valueOf(this.bLf), "mvip.gongneng.android.bubble.index_dynamic_tab");
      Object localObject1 = adxn.a();
      Object localObject6 = this.aQk + "_" + this.bLg;
      Object localObject4 = localObject2;
      Object localObject5;
      if (this.bLg > 0)
      {
        localObject5 = (String)((adxn)localObject1).jM.get(localObject6);
        localObject6 = (HashMap)((adxn)localObject1).jN.get(localObject6);
        localObject1 = localObject2;
        if (localObject6 != null)
        {
          localObject1 = localObject2;
          if (((HashMap)localObject6).size() > 0)
          {
            localObject4 = (String)((HashMap)localObject6).get("TL");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = jpa.r((String)localObject2, "tl=" + (String)localObject4);
            }
            localObject4 = (String)((HashMap)localObject6).get("TR");
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject2 = jpa.r((String)localObject1, "tr=" + (String)localObject4);
            }
            localObject1 = (String)((HashMap)localObject6).get("BL");
            localObject4 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject4 = jpa.r((String)localObject2, "bl=" + (String)localObject1);
            }
            localObject2 = (String)((HashMap)localObject6).get("BR");
            localObject1 = localObject4;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = jpa.r((String)localObject4, "br=" + (String)localObject2);
            }
          }
        }
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {}
      }
      int k;
      int m;
      int n;
      int i1;
      for (;;)
      {
        try
        {
          localObject2 = jpa.r((String)localObject1, "diyText=" + URLEncoder.encode((String)localObject5, "UTF-8"));
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("TextPreviewActivity", 2, "TextPreviewActivity bubble url: " + jqo.filterKeyForLog((String)localObject1, new String[0]));
          }
          VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 64L, localIntent, false, -1);
          localObject1 = this.aQk;
          if (!bool) {
            break label900;
          }
          i = 1;
          VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "bubble_enter", "", 1, 0, i, "", String.valueOf(this.bLf), "");
          if (bool)
          {
            if (localanec.ee("100005.100001") == -1) {
              break label905;
            }
            k = 1;
            if (localanec.ee("100005.100002") == -1) {
              break label910;
            }
            m = 1;
            if (localanec.ee("100005.100006") == -1) {
              break label916;
            }
            n = 1;
            if (localanec.ee("100005.100018") == -1) {
              break label922;
            }
            i1 = 1;
            if (localanec.ee("100005.100020") == -1) {
              break label928;
            }
            i2 = 1;
            if (localanec.ee("100005.100021") == -1) {
              break label934;
            }
            i3 = 1;
            bool = ((ku)this.app.getManager(42)).cy;
            i = 0;
            if (bool)
            {
              if (localanec.ee("100005.100011") == -1) {
                break label940;
              }
              i = 1;
            }
            if (((bool) && (k == 0) && (m == 0) && (n == 0) && (i == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)) || ((!bool) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0) && (i3 == 0)))
            {
              if (localanec.ee("100005") == -1) {
                break label945;
              }
              i = 1;
              if (i != 0) {
                ((altq)this.app.getManager(36)).OS("100005");
              }
            }
            ((altq)this.app.getManager(36)).OS("100005.100003");
          }
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label870:
          QLog.e("TextPreviewActivity", 1, "URLEncoder.encode error!", localUnsupportedEncodingException);
          localObject4 = localObject1;
        }
        bool = false;
        break;
        localObject1 = localObject4;
        continue;
        i = 0;
        continue;
        k = 0;
        continue;
        m = 0;
        continue;
        n = 0;
        continue;
        i1 = 0;
        continue;
        int i2 = 0;
        continue;
        int i3 = 0;
        continue;
        label940:
        i = 0;
        continue;
        label945:
        i = 0;
        continue;
        label950:
        if (i != 2131367417) {
          break label1434;
        }
        if (this.bLh <= 0) {
          break label1094;
        }
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("fontId", this.bLh);
        ((Intent)localObject1).putExtra("fromAIO", true);
        ((Intent)localObject1).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.e(this, "fontDetail", String.valueOf(this.bLh), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject1, false, -1);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "HighFont", "ClickDetail", "", 1, 0, 0, "", "" + this.bLh, "");
      }
      label1094:
      localObject1 = (anec)this.app.getManager(12);
      if (localObject1 != null) {
        if (((anec)localObject1).ee("100005.100011") != -1) {
          bool = true;
        }
      }
      label1321:
      label1963:
      for (;;)
      {
        label1128:
        Object localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("updateFlag", bool);
        ((Intent)localObject3).putExtra("fontId", this.mFontId);
        ((Intent)localObject3).putExtra("fromAIO", true);
        ((Intent)localObject3).putExtra("individuation_url_type", 40301);
        VasWebviewUtil.openQQBrowserWithoutAD(this, aqqj.e(this, "fontDetail", String.valueOf(this.mFontId), "mvip.gexinghua.mobile.font.client_tab_store"), 4096L, (Intent)localObject3, false, -1);
        localObject3 = this.aQk;
        if (bool)
        {
          i = 1;
          label1228:
          VasWebviewUtil.reportCommercialDrainage((String)localObject3, "bigtextpage", "font_enter", "", 1, 0, i, "", String.valueOf(this.mFontId), "");
          if (!bool) {
            break;
          }
          if (((anec)localObject1).ee("100005.100001") == -1) {
            break label1407;
          }
          i = 1;
          label1277:
          if (((anec)localObject1).ee("100005.100002") == -1) {
            break label1412;
          }
          k = 1;
          if (((anec)localObject1).ee("100005.100006") == -1) {
            break label1417;
          }
          m = 1;
          if (((anec)localObject1).ee("100005.100003") == -1) {
            break label1423;
          }
          n = 1;
          if ((i == 0) && (k == 0) && (m == 0) && (n == 0)) {
            if (((anec)localObject1).ee("100005") == -1) {
              break label1429;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((altq)this.app.getManager(36)).OS("100005");
          }
          ((altq)this.app.getManager(36)).OS("100005.100011");
          break;
          bool = false;
          break label1128;
          i = 0;
          break label1228;
          label1407:
          i = 0;
          break label1277;
          k = 0;
          break label1291;
          m = 0;
          break label1306;
          n = 0;
          break label1321;
        }
        if (i == 2131372963)
        {
          localanec = (anec)this.app.getManager(12);
          if (localanec == null) {
            break label2407;
          }
          if (localanec.ee("100005.100006") != -1) {
            i = 1;
          }
        }
        label1601:
        label2388:
        for (;;)
        {
          localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("hide_left_button", false);
          localIntent.putExtra("show_right_close_button", false);
          label1535:
          DiyPendantSticker localDiyPendantSticker;
          if (this.c != null)
          {
            l = this.c.pendantId;
            localObject4 = aqqj.e(this, "pendantDetail", String.valueOf(l), "mvip.gexinghua.mobile.faceaddon.client_tab_store");
            localObject3 = abgl.a().g;
            localObject5 = new StringBuilder().append(this.aQk).append("_");
            if (this.c == null) {
              break label1812;
            }
            localObject1 = Integer.valueOf(this.c.pendantDiyId);
            localObject1 = (DiyPendantEntity)((LRULinkedHashMap)localObject3).get(localObject1);
            if (localObject1 == null) {
              break label2400;
            }
            localObject5 = new ArrayList();
            localObject6 = ((DiyPendantEntity)localObject1).getStickerInfoList().iterator();
            label1645:
            if (!((Iterator)localObject6).hasNext()) {
              break label1840;
            }
            localDiyPendantSticker = (DiyPendantSticker)((Iterator)localObject6).next();
            k = localDiyPendantSticker.type;
            m = localDiyPendantSticker.stickerId;
            n = localDiyPendantSticker.angle;
            if (!TextUtils.isEmpty(localDiyPendantSticker.text)) {
              break label1820;
            }
            localObject1 = "0";
            i1 = localDiyPendantSticker.fontId;
            if (!TextUtils.isEmpty(localDiyPendantSticker.fontColor)) {
              break label1830;
            }
          }
          for (localObject3 = "0";; localObject3 = localDiyPendantSticker.fontColor)
          {
            ((List)localObject5).add(String.format("%d,%d,%d,%s,%d,%s,%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Integer.valueOf(localDiyPendantSticker.fontType) }));
            break label1645;
            i = 0;
            break;
            l = 0L;
            break label1535;
            localObject1 = "";
            break label1601;
            localObject1 = localDiyPendantSticker.text;
            break label1703;
          }
          localObject1 = TextUtils.join(";", (Iterable)localObject5);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject1 = URLEncoder.encode((String)localObject1);
          }
          label2009:
          label2138:
          label2143:
          label2400:
          for (localObject1 = jpa.r((String)localObject4, "stickerInfo=" + (String)localObject1);; localObject1 = localObject4)
          {
            localIntent.putExtra("url", (String)localObject1);
            localIntent.putExtra("business", 512L);
            localIntent.putExtra("individuation_url_type", 40301);
            localIntent.putExtra("isShowAd", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 512L, localIntent, false, -1);
            localObject1 = this.aQk;
            if (i != 0)
            {
              k = 1;
              VasWebviewUtil.reportCommercialDrainage((String)localObject1, "bigtextpage", "pendant_enter", "", 1, 0, k, "", String.valueOf(l), "");
              if (i == 0) {
                break;
              }
              if (localanec.ee("100005.100001") == -1) {
                break label2133;
              }
              i = 1;
              if (localanec.ee("100005.100002") == -1) {
                break label2138;
              }
              k = 1;
              label2023:
              if (localanec.ee("100005.100006") == -1) {
                break label2143;
              }
              m = 1;
              label2038:
              if (localanec.ee("100005.100003") == -1) {
                break label2149;
              }
              n = 1;
              if ((i == 0) && (k == 0) && (m == 0) && (n == 0)) {
                if (localanec.ee("100005") == -1) {
                  break label2155;
                }
              }
            }
            label2149:
            label2155:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                ((altq)this.app.getManager(36)).OS("100005");
              }
              ((altq)this.app.getManager(36)).OS("100005.100011");
              break;
              k = 0;
              break label1963;
              i = 0;
              break label2009;
              k = 0;
              break label2023;
              m = 0;
              break label2038;
              n = 0;
              break label2053;
            }
            if (i != 2131371064) {
              break;
            }
            localObject4 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("individuation_url_type", 40301);
            if (this.bLi == 0)
            {
              localObject3 = aqqj.o(this, "aioNoMagicFontEntrance", null);
              localObject1 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=1027&_wvx=3";
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label2388;
              }
              localObject1 = ((String)localObject1).replace("[id]", this.bLi + "");
              if (QLog.isColorLevel()) {
                QLog.i("TextPreviewActivity", 2, "mFontEffectId=" + this.bLi + " url=" + (String)localObject1);
              }
              VasWebviewUtil.openQQBrowserWithoutAD(this, (String)localObject1, 0L, (Intent)localObject4, false, -1);
            }
            for (;;)
            {
              VasWebviewUtil.reportCommercialDrainage(this.aQk, "bigtextpage", "font_size", "", 1, 0, 0, "", String.valueOf(this.bLi), "");
              break;
              localObject3 = aqqj.o(this, "aioMagicFontEntrance", null);
              localObject1 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2226;
              }
              localObject1 = "https://gxh.vip.qq.com/club/zb/font_effect_detail/html/aio-font-big.html?id=[id]&_wv=16778243&_wvx=3";
              break label2226;
              QLog.e("TextPreviewActivity", 2, "url is empty.");
            }
          }
          label2133:
          label2407:
          i = 0;
        }
        label1840:
        label2226:
        bool = false;
      }
      label1703:
      label2418:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if ((this.app == null) && ((getAppRuntime() instanceof QQAppInterface))) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TextPreviewActivity", 2, "TextPreviewActivity onCreate,  the app is null");
      }
      finish();
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        super.setContentView(2131558691);
        paramBundle = super.getIntent();
        this.aQi = paramBundle.getStringExtra("peeruin");
        this.senderUin = paramBundle.getStringExtra("senderUin");
        this.aQk = paramBundle.getStringExtra("real_msg_sender_uin");
        this.uinType = paramBundle.getIntExtra("uin_type", 0);
        this.isMultiMsg = paramBundle.getBooleanExtra("isMultiMsg", false);
        this.bLf = ((int)paramBundle.getLongExtra("bubbleId", 0L));
        this.textString = paramBundle.getStringExtra("content");
        this.atInfoStr = paramBundle.getStringExtra("troop_at_info");
        this.uY = super.findViewById(2131372983);
        this.uZ = super.findViewById(2131364057);
        this.va = super.findViewById(2131367443);
        this.sessionType = paramBundle.getIntExtra("sessionType", -2);
        this.bLg = paramBundle.getIntExtra("bubbleDiyId", 0);
        if (this.bLg == 0) {
          this.bLg = acle.R(paramBundle.getLongExtra("bubbleId", 0L));
        }
        this.bLh = paramBundle.getIntExtra("HiBoomId", 0);
        str = paramBundle.getStringExtra("fontId");
        if ((TextUtils.isEmpty(str)) || (!TextUtils.isDigitsOnly(str))) {
          break label1382;
        }
        if (ku.c(Long.parseLong(str)) == 0)
        {
          this.mFontId = -1;
          this.al = ((URLImageView)findViewById(2131371066));
          this.FS = ((TextView)findViewById(2131371065));
          this.bLi = paramBundle.getIntExtra("fontEffectId", 0);
          BI(this.bLi);
          long l = paramBundle.getLongExtra("uniseq", 0L);
          this.baP = paramBundle.getBooleanExtra(xva.aWx, true);
          this.baP = (paramBundle.getBooleanExtra(yhv.aWx, true) | this.baP);
          if (anlm.ayn()) {
            this.baP = false;
          }
          this.c = ((acff)this.app.getManager(51)).a(this.aQk);
          if (QLog.isColorLevel()) {
            QLog.d("TextPreviewActivity", 2, "previewBubble sender:" + this.aQk + ",bubbleId:" + this.bLf + ",bubbleDiyId:" + this.bLg + ",FontId:" + str + ",hiBoomId:" + this.bLh + ",fontEffectId:" + this.bLi);
          }
          this.jdField_a_of_type_Apzp = new apzp(this.app, this);
          this.mHandler = new vxc(this, Looper.getMainLooper());
          if (this.bLh != 0) {
            ((ahxs)this.app.getManager(219)).cW = this.mHandler;
          }
          if (uniseq != l)
          {
            ContainerView.Bg = 0.0F;
            uniseq = l;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView = ((ContainerView)super.findViewById(2131365360));
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setMsgHandler(this.mHandler);
          this.jdField_b_of_type_ComTencentWidgetScrollView = ((ScrollView)super.findViewById(2131379028));
          this.jdField_b_of_type_ComTencentWidgetScrollView.setOverScrollMode(2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setOutScrollView(this.jdField_b_of_type_ComTencentWidgetScrollView);
          this.uW = super.findViewById(2131363644);
          this.uT = super.findViewById(2131372963);
          this.uT.setOnClickListener(this);
          this.uU = super.findViewById(2131367417);
          this.uV = super.findViewById(2131364048);
          this.uV.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)findViewById(2131373865));
          this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)findViewById(2131372867));
          this.vb = findViewById(2131363647);
          this.vc = findViewById(2131367358);
          this.vd = findViewById(2131378641);
          this.rn = ((ImageView)findViewById(2131369065));
          this.rn.setBackgroundResource(2130838428);
          this.ve = findViewById(2131365455);
          this.vf = findViewById(2131367440);
          if (this.vf != null)
          {
            str = this.app.getCurrentAccountUin();
            if (!TextUtils.equals(this.aQk, this.app.getCurrentAccountUin())) {
              break label1390;
            }
            paramBundle = "1";
            VasWebviewUtil.reportCommercialDrainage(str, "aio", "icon_show", "", 0, 0, 0, "", "", paramBundle, "", "", "", "", 0, 0, 0, 0);
          }
          this.vf.setVisibility(8);
          this.FP = ((TextView)super.findViewById(2131364058));
          this.FQ = ((TextView)super.findViewById(2131364054));
          this.aj = ((URLImageView)super.findViewById(2131372984));
          this.uW.setVisibility(8);
          paramBundle = (TextView)super.findViewById(2131381386);
          if (TextUtils.isEmpty(this.aQk)) {
            break;
          }
          if (this.aQk.equals(this.app.getAccount())) {
            break label1397;
          }
          paramBundle.setText("TA正在使用的装扮");
          if ((Build.VERSION.SDK_INT < 11) || (this.textString != null))
          {
            QLog.i("TextPreviewActivity.hotWordDebug", 1, "" + this.textString);
            if (QLog.isColorLevel()) {
              QLog.i("TextPreviewActivity.hotWordDebug", 2, "" + aqgo.encodeToString(this.textString.getBytes(), 0));
            }
          }
          if (!this.isMultiMsg) {
            break label1407;
          }
          paramBundle = this.app.a();
          if (paramBundle != null) {
            this.j = paramBundle.b(uniseq);
          }
          wta.a(this, this.app, this.j, 1);
          paramBundle = aqpm.a(this.textString, this.atInfoStr, 30, this.j, 13);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu = new TextPreviewMenu();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.e.setMovementMethod(ContainerView.a.getInstance());
          paramBundle = (WordMatchManager)this.app.getManager(82);
          if (paramBundle != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$e);
            if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f != null)
            {
              if (this.bLj != 0) {
                this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f.LJ(this.bLj);
              }
              this.bLj = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f.a(1, this.textString, 3, this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$c);
            }
          }
          this.jdField_a_of_type_Apzp$a = new vxd(this);
          this.jdField_a_of_type_Apzp.a(this.jdField_a_of_type_Apzp$a);
          this.jdField_b_of_type_Wtg = new wtg();
          this.jdField_b_of_type_Wtg.e(this);
          this.mFlingHandler = new a(this, null);
          bVX();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("TextPreviewActivity", 1, "", paramBundle);
        finish();
        return;
      }
      this.mFontId = ((int)ku.h(Long.parseLong(str)));
      this.mFontType = ku.c(Long.parseLong(str));
      continue;
      label1382:
      this.mFontId = -1;
      continue;
      label1390:
      paramBundle = "2";
      continue;
      label1397:
      paramBundle.setText(aQj);
      continue;
      label1407:
      this.j = this.app.b().a(this.aQi, this.sessionType, uniseq);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bVZ();
    Object localObject = (WebProcessManager)this.app.getManager(13);
    if (localObject != null) {
      ((WebProcessManager)localObject).egu();
    }
    localObject = adxn.a();
    String str = this.aQk + "_" + this.bLg;
    if ((this.bLg > 0) && ((!((adxn)localObject).jM.containsKey(str)) || (!((adxn)localObject).jN.containsKey(str)))) {
      ThreadManager.post(new TextPreviewActivity.6(this, (adxn)localObject, str), 5, null, false);
    }
    this.jdField_b_of_type_Wtg.g(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu.onResume();
    bVY();
  }
  
  public void onStart()
  {
    super.onStart();
    this.GY = SystemClock.uptimeMillis();
  }
  
  public void wE(String paramString)
  {
    this.jdField_a_of_type_Apzp.bf(paramString, this.app.getCurrentAccountUin(), this.aQk);
  }
  
  public void wF(String paramString)
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, acfp.m(2131715271), 0).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (!this.jdField_a_of_type_Apzp.isPlaying())
    {
      wE(paramString);
      bWa();
      return;
    }
    this.jdField_a_of_type_Apzp.stop();
  }
  
  static final class a
    extends FlingGestureHandler
  {
    private WeakReference<TextPreviewActivity> activity;
    
    private a(TextPreviewActivity paramTextPreviewActivity)
    {
      super();
      this.activity = new WeakReference(paramTextPreviewActivity);
    }
    
    public void flingLToR()
    {
      TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.activity.get();
      int i;
      if (localTextPreviewActivity != null) {
        if ((localTextPreviewActivity.a != null) && (localTextPreviewActivity.a.getVisibility() == 0)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          super.flingLToR();
        }
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity
 * JD-Core Version:    0.7.0.1
 */