package com.tencent.mobileqq.hiboom;

import ahep;
import aheq;
import ahxf;
import ahxn;
import ahxs;
import ahxs.c;
import ahya;
import ahyb;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anlm;
import anot;
import aqcx;
import aqmj;
import aqqj;
import aqrb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wja;
import ykm;

public class RichTextPanel
  extends RelativeLayout
  implements ahep, ahxs.c, ViewPager.OnPageChangeListener, View.OnClickListener, SimpleSlidingIndicator.b
{
  public static int dcd = 1;
  private ImageView AG;
  private int Ac = -1;
  private ahyb jdField_a_of_type_Ahyb;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private boolean aLS;
  private PagerAdapter b = new ahya(this);
  private int bQS;
  private boolean bfw;
  private QQViewPager c;
  private boolean ciT;
  private boolean ciU;
  private boolean ciV;
  private int dcc;
  private Button ef;
  private boolean isNight;
  private BaseChatPie mBaseChatPie;
  private int mMinHeight;
  private ArrayList<RichTextPanelView> mPages = new ArrayList();
  private ArrayList<Integer> xi = new ArrayList();
  private ArrayList<RichTextPanelView> xj = new ArrayList();
  
  public RichTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void KJ(boolean paramBoolean)
  {
    int m = 2131167311;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null)
    {
      bool1 = ThemeUtil.isNowThemeIsDefaultCache(this.mBaseChatPie.app, true);
      bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
      bool3 = anlm.Vr();
      if ((paramBoolean) || (this.aLS != bool1) || (this.isNight != bool2) || (this.ciU != bool3)) {}
    }
    else
    {
      return;
    }
    int k = 25;
    int i;
    int j;
    if (bool3) {
      if (bool2)
      {
        i = 2131166736;
        k = 2131167383;
        int n = 255;
        j = i;
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.EU(k);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.T(m, i, j);
      if (this.ef != null)
      {
        this.ef.setBackgroundDrawable(getResources().getDrawable(2130838476));
        this.ef.setTextColor(getResources().getColor(2131167461));
      }
      this.aLS = bool1;
      this.isNight = bool2;
      this.ciU = bool3;
      return;
      i = 2131166735;
      break;
      if (bool2)
      {
        m = 2131165722;
        i = 2131165721;
        j = 2131165720;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131167383;
        j = 2131167311;
      }
      else
      {
        m = 2131165723;
        i = 2131167383;
        j = 2131165723;
      }
    }
  }
  
  private void PA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!this.xj.isEmpty());
      this.xj.clear();
      Object localObject1 = (FlashChatManager)this.mBaseChatPie.app.getManager(217);
      Object localObject2 = aheq.a(this.mBaseChatPie.app).a(this.mBaseChatPie.app);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i = ((Integer)((Iterator)localObject2).next()).intValue();
        if (i == 1)
        {
          if (((FlashChatManager)localObject1).cS().size() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RichTextPanel", 2, "flashItem is null, cannot show flashPanel");
            }
            this.xj.add(this.mPages.get(i));
            this.xi.add(Integer.valueOf(1));
            localArrayList1.add(((RichTextPanelView)this.mPages.get(i)).getName());
            localArrayList2.add(Integer.valueOf(2131377259));
          }
        }
        else if (i == 2)
        {
          if (ahxs.a(this.mBaseChatPie.app).aor())
          {
            this.xj.add(this.mPages.get(i));
            this.xi.add(Integer.valueOf(2));
            localArrayList1.add(((RichTextPanelView)this.mPages.get(i)).getName());
            localArrayList2.add(Integer.valueOf(2131377262));
          }
        }
        else if ((i == 0) && (ykm.a(this.mBaseChatPie.getApp()).TO()))
        {
          this.xj.add(this.mPages.get(i));
          this.xi.add(Integer.valueOf(0));
          localArrayList1.add(((RichTextPanelView)this.mPages.get(i)).getName());
          localArrayList2.add(Integer.valueOf(2131377266));
        }
        else
        {
          if ((i == 3) || (i == 4))
          {
            this.xj.add(this.mPages.get(i));
            this.xi.add(Integer.valueOf(i));
            localArrayList1.add(((RichTextPanelView)this.mPages.get(i)).getName());
            if (i == 3) {}
            for (i = 2131377260;; i = 2131377257)
            {
              localArrayList2.add(Integer.valueOf(i));
              break;
            }
          }
          if (i == 5)
          {
            this.xj.add(this.mPages.get(i));
            this.xi.add(Integer.valueOf(5));
            localArrayList1.add(((RichTextPanelView)this.mPages.get(i)).getName());
            localArrayList2.add(Integer.valueOf(2131377258));
          }
        }
      }
      this.b.notifyDataSetChanged();
      localObject1 = new String[localArrayList1.size()];
      localObject2 = new int[localArrayList2.size()];
      i = 0;
      int k;
      for (int j = -1; i < this.xj.size(); j = k)
      {
        localObject1[i] = ((String)localArrayList1.get(i));
        localObject2[i] = ((Integer)localArrayList2.get(i)).intValue();
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.xj.get(i);
        k = j;
        if (this.ciT)
        {
          k = j;
          if ((localRichTextPanelView instanceof HiBoomPanelView)) {
            k = i;
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData((String[])localObject1, (int[])localObject2);
      if (j != -1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.EV(j);
      }
      i = aheq.a(this.mBaseChatPie.app).a(this.mBaseChatPie.app, this.xi);
      if (i >= this.xj.size()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(i, false);
    } while (i != 0);
    d(0, false);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(0, false);
    d(0, false);
  }
  
  private void aj(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(paramView.getContext(), paramInt);
    localAnimation.setFillAfter(false);
    paramView.startAnimation(localAnimation);
  }
  
  private boolean ka(int paramInt)
  {
    boolean bool1 = true;
    if ((paramInt < 0) || (paramInt >= this.xi.size()))
    {
      QLog.e("RichTextPanel", 1, "needShowGuide outofindex: " + paramInt + "," + this.xi.size());
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      String str = "had_show_fontbubble_guide_" + this.xi.get(paramInt);
      SharedPreferences localSharedPreferences = this.mBaseChatPie.app.getPreferences();
      bool2 = localSharedPreferences.getBoolean(str, false);
      localSharedPreferences.edit().putBoolean(str, true).commit();
    } while (!bool2);
    return false;
  }
  
  public void Af(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTextPanel", 2, "onPanelStatusChanged show = " + paramBoolean);
    }
    if (paramBoolean)
    {
      PA();
      KJ(false);
    }
    if ((this.Ac >= this.xj.size()) || (this.Ac < 0)) {
      return;
    }
    Object localObject = (RichTextPanelView)this.xj.get(this.Ac);
    ((RichTextPanelView)localObject).Af(paramBoolean);
    String str;
    if (paramBoolean)
    {
      ((aqrb)this.mBaseChatPie.app.getBusinessHandler(71)).aF(ahxs.ls(this.mBaseChatPie.a.getText().toString()));
      ahxs.a(this.mBaseChatPie.app).a(this);
      str = null;
      if (!(localObject instanceof HiBoomPanelView)) {
        break label236;
      }
      str = "0X80094D4";
      localObject = "HighFont";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        anot.a(this.mBaseChatPie.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "InputFunc", "EnterFunc", "", 1, 0, 0, "", "", (String)localObject);
      }
      this.bfw = paramBoolean;
      return;
      label236:
      if ((localObject instanceof ZhituPanelView))
      {
        str = "0X80094D2";
        localObject = "SmartPic";
      }
      else if ((localObject instanceof FlashChatPanelView))
      {
        str = "0X80094D3";
        localObject = "FlashChat";
      }
      else
      {
        if ((localObject instanceof FontBubblePanelView))
        {
          str = "";
          ((FontBubblePanelView)localObject).reportShow();
        }
        localObject = "";
      }
    }
  }
  
  public void KH(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.xj.get(this.Ac);
      if ((localRichTextPanelView instanceof FlashChatPanelView)) {
        ThreadManager.getUIHandler().post(new RichTextPanel.3(this, localRichTextPanelView));
      }
    }
  }
  
  public int d(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.Ac) || (this.xj.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "onTabSelected: already at the position: " + paramInt + " mShowPages.size: " + this.xj.size());
      }
      return 0;
    }
    int i;
    RichTextPanelView localRichTextPanelView;
    String str;
    if (this.ciV)
    {
      i = 2;
      dcd = i;
      this.ciV = false;
      if ((this.Ac >= 0) && (this.Ac < this.xj.size())) {
        ((RichTextPanelView)this.xj.get(this.Ac)).Af(false);
      }
      if ((paramInt >= 0) && (paramInt < this.xj.size()))
      {
        localRichTextPanelView = (RichTextPanelView)this.xj.get(paramInt);
        if (localRichTextPanelView != null)
        {
          str = null;
          localRichTextPanelView.Af(true);
          if (!(localRichTextPanelView instanceof HiBoomPanelView)) {
            break label600;
          }
          str = "0X80094D4";
          label180:
          if (!TextUtils.isEmpty(str)) {
            anot.a(this.mBaseChatPie.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
          }
        }
        if ((localRichTextPanelView instanceof EmoticonHotPicSearchPanelView))
        {
          str = this.mBaseChatPie.a.getText().toString();
          if (str != null) {
            anot.a(this.mBaseChatPie.app, "dc00898", "", "", "0X800AE34", "0X800AE34", 0, 0, "", "", str, "");
          }
        }
        if (((localRichTextPanelView instanceof FontBubblePanelView)) && (ka(paramInt))) {
          this.AG.setVisibility(0);
        }
        i = 0;
        if (this.mBaseChatPie != null) {
          i = aheq.a(this.mBaseChatPie.getApp()).wQ();
        }
        if (((localRichTextPanelView instanceof ZhituPanelView)) && (i == 1)) {
          this.ef.setVisibility(8);
        }
        if ((!(localRichTextPanelView instanceof ZhituPanelView)) || (this.ef.getVisibility() != 8)) {
          break label656;
        }
        aj(this.ef, 2130772027);
        if (i != 1) {
          this.ef.setVisibility(0);
        }
      }
      label404:
      if (paramInt < 0) {
        break label689;
      }
    }
    for (;;)
    {
      this.Ac = paramInt;
      if (this.Ac != this.c.getCurrentItem()) {
        this.c.setCurrentItem(this.Ac, true);
      }
      if ((this.Ac < this.xj.size()) && (this.ciT) && ((this.xj.get(this.Ac) instanceof HiBoomPanelView)))
      {
        this.mBaseChatPie.app.getPreferences().edit().putBoolean("isHiBoomFirstShow", false).commit();
        this.ciT = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.EW(this.Ac);
      }
      if ((this.xi != null) && (this.Ac >= 0) && (this.Ac < this.xi.size()))
      {
        paramInt = ((Integer)this.xi.get(this.Ac)).intValue();
        aqmj.aE(this.mBaseChatPie.app.getApp(), this.mBaseChatPie.app.getCurrentAccountUin(), paramInt);
      }
      return 0;
      i = 1;
      break;
      label600:
      if ((localRichTextPanelView instanceof ZhituPanelView))
      {
        str = "0X80094D2";
        break label180;
      }
      if ((localRichTextPanelView instanceof FlashChatPanelView))
      {
        str = "0X80094D3";
        break label180;
      }
      if (!(localRichTextPanelView instanceof FontBubblePanelView)) {
        break label180;
      }
      str = "";
      ((FontBubblePanelView)localRichTextPanelView).reportShow();
      break label180;
      label656:
      if (this.ef.getVisibility() != 0) {
        break label404;
      }
      aj(this.ef, 2130772028);
      this.ef.setVisibility(8);
      break label404;
      label689:
      paramInt = 0;
    }
  }
  
  public void dqS()
  {
    this.jdField_a_of_type_Ahyb.onShow();
    ((EmoticonHotPicSearchPanelView)this.mPages.get(5)).onShow();
  }
  
  public void h(View paramView, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = aqqj.o(getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "enter hiboom mall url = " + (String)localObject);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(getContext(), (String)localObject, 4096L, null, false, -1);
      continue;
      this.AG.setVisibility(8);
      continue;
      localObject = ykm.a(this.mBaseChatPie.app);
      if ((localObject != null) && (((ykm)localObject).a != null)) {
        ((ykm)localObject).a.ciZ();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mPages.size() > 0)
    {
      Iterator localIterator = this.mPages.iterator();
      while (localIterator.hasNext())
      {
        RichTextPanelView localRichTextPanelView = (RichTextPanelView)localIterator.next();
        if (localRichTextPanelView != null) {
          localRichTextPanelView.onDestroy();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bfw) {
      this.jdField_a_of_type_Ahyb.onDetachedFromWindow();
    }
    this.bfw = false;
  }
  
  public void onHide()
  {
    if ((this.xj.size() > 0) && (this.Ac > 0) && (this.Ac < this.xj.size()))
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.xj.get(this.Ac);
      if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
        ((FlashChatPanelView)localRichTextPanelView).onHide();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_Ahyb.aox()) && (this.AG.getVisibility() == 0)) {
      if (this.AG.getVisibility() != 0) {
        break label180;
      }
    }
    label180:
    for (this.dcc = ((paramInt3 - paramInt1) * 598 / 750);; this.dcc = this.mMinHeight)
    {
      if (this.dcc != XPanelContainer.aLe)
      {
        this.bQS = XPanelContainer.aLe;
        XPanelContainer.aLe = this.dcc;
        if (QLog.isColorLevel()) {
          QLog.d("RichTextPanel", 2, "showGuide set mExternalPanelheight: " + XPanelContainer.aLe);
        }
        if (this.AG.getVisibility() == 0)
        {
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ColorDrawable localColorDrawable = new ColorDrawable(16777215);
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/vipData/app/imageStore/7e2fb795e29a9d0c4bc54f62adf2aa2e.png", (URLDrawable.URLDrawableOptions)localObject);
          this.AG.setImageDrawable((Drawable)localObject);
        }
        requestLayout();
      }
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.Ac != paramInt)
    {
      this.ciV = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    }
  }
  
  public void onShow()
  {
    if ((this.xj.size() > 0) && (this.Ac > 0) && (this.Ac < this.xj.size()))
    {
      RichTextPanelView localRichTextPanelView = (RichTextPanelView)this.xj.get(this.Ac);
      if ((localRichTextPanelView != null) && ((localRichTextPanelView instanceof FlashChatPanelView))) {
        ((FlashChatPanelView)localRichTextPanelView).onShow();
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void x(View paramView, int paramInt1, int paramInt2) {}
  
  public void x(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Ahyb = new ahyb(this.mBaseChatPie.app, this.mBaseChatPie, this);
    Drawable localDrawable = getResources().getDrawable(2130851275);
    Object localObject = null;
    if ((localDrawable instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)localDrawable).getBitmap();
      localObject = new BitmapDrawable((Bitmap)localObject);
      if (localObject == null) {
        break label791;
      }
      ((BitmapDrawable)localObject).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)localObject).setDither(true);
      setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      setBackgroundDrawable((Drawable)localObject);
      this.mMinHeight = wja.dp2px(250.0F, getResources());
      this.ciT = this.mBaseChatPie.app.getPreferences().getBoolean("isHiBoomFirstShow", true);
      localObject = new RichTextPanel.1(this, getContext());
      ((RelativeLayout)localObject).setId(2131377265);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, aqcx.dip2px(getContext(), 40.0F));
      localLayoutParams1.addRule(12, -1);
      ((RelativeLayout)localObject).setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)View.inflate(getContext(), 2131558678, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setId(2131377264);
      KJ(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, aqcx.dip2px(getContext(), 40.0F));
      localLayoutParams2.addRule(0, 2131377979);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator, localLayoutParams2);
      this.ef = new Button(getContext());
      this.ef.setId(2131377979);
      this.ef.setBackgroundDrawable(getResources().getDrawable(2130838476));
      this.ef.setText(getResources().getString(2131721960));
      this.ef.setTextColor(getResources().getColor(2131167461));
      this.ef.setContentDescription(getResources().getString(2131721960));
      this.ef.setTextSize(2, 14.0F);
      this.ef.setVisibility(8);
      localLayoutParams2 = new RelativeLayout.LayoutParams(aqcx.dip2px(getContext(), 60.0F), aqcx.dip2px(getContext(), 40.0F));
      localLayoutParams2.addRule(11);
      this.ef.setOnClickListener(this);
      ((RelativeLayout)localObject).addView(this.ef, localLayoutParams2);
      addView((View)localObject, localLayoutParams1);
      this.c = new QQViewPager(getContext());
      this.c.setId(2131377263);
      this.c.setBackgroundDrawable(localDrawable);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.c.setFocusable(true);
      this.c.setFocusableInTouchMode(true);
      this.c.TN(true);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131377265);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      this.c.setAdapter(this.b);
      this.c.setOnPageChangeListener(this);
      this.AG = new ImageView(getContext());
      this.AG.setId(2131367449);
      this.AG.setOnClickListener(this);
      this.AG.setVisibility(8);
      this.AG.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      addView(this.AG, (ViewGroup.LayoutParams)localObject);
      this.mPages.add(new ZhituPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb, this.ef));
      this.mPages.add(new FlashChatPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb));
      this.mPages.add(new HiBoomPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb));
      this.mPages.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb, new ahxn()));
      this.mPages.add(new FontBubblePanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb, new ahxf()));
      this.mPages.add(new EmoticonHotPicSearchPanelView(getContext(), paramBaseChatPie, this.jdField_a_of_type_Ahyb));
      return;
      if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
        break;
      }
      localObject = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      break;
      label791:
      if (QLog.isColorLevel()) {
        QLog.d("RichTextPanel", 2, "PokePanel background is null:");
      }
    }
  }
  
  public void yQ(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahyb.yQ(paramBoolean);
    ((EmoticonHotPicSearchPanelView)this.mPages.get(5)).yQ(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel
 * JD-Core Version:    0.7.0.1
 */