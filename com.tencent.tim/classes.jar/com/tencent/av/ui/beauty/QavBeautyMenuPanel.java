package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import iti;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jfx;
import jjc;

public class QavBeautyMenuPanel
  extends QavMenuBaseView
{
  static final int[] cN = { 2131374150, 2131374151 };
  boolean Zb = false;
  boolean Zc = false;
  final PanelViewPage jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage;
  final a jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a;
  final SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  final View iu;
  long oK = 0L;
  
  public QavBeautyMenuPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavBeautyMenuPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.TAG = ("QavBeautyMenuPanel" + AudioHelper.hG());
    inflate(paramContext, 2131559943, this);
    Object localObject = paramContext.getResources();
    this.iu = findViewById(2131379154);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.iu.findViewById(2131378499));
    paramAttributeSet = ((Resources)localObject).getDisplayMetrics();
    int k = Math.min(paramAttributeSet.widthPixels, paramAttributeSet.heightPixels);
    int j = ((Resources)localObject).getDimensionPixelSize(2131298022);
    int i = ((Resources)localObject).getDimensionPixelSize(2131298019);
    if (k - i - j * 2 > 20) {}
    for (paramInt = (k - i - j * 2) / 2;; paramInt = (k - i - j * 2) / 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.update(j, i, 0, paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 4, String.format("QavBeautyMenuPanel, init[%s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) }));
      }
      paramAttributeSet = ((Resources)localObject).getString(2131697594);
      localObject = ((Resources)localObject).getString(2131697595);
      SimpleSlidingIndicator localSimpleSlidingIndicator = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
      int[] arrayOfInt = cN;
      localSimpleSlidingIndicator.setTabData(new String[] { paramAttributeSet, localObject }, arrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(0, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(new jfx(this));
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage = ((PanelViewPage)findViewById(2131372841));
      paramAttributeSet = new ArrayList(2);
      paramAttributeSet.add(new BeautyView(paramContext));
      paramAttributeSet.add(new MakeupView(paramContext));
      this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a = new a(paramAttributeSet);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setAdapter(this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setIsPagingEnabled(false);
      this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(0, false);
      setBackgroundResource(2130843030);
      return;
      float f = j * 2 + i;
      f = (k - 20) / f;
      i = (int)(i * f);
      j = (int)(f * j);
    }
  }
  
  private RedDotTextView a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.findViewById(cN[paramInt]);
    if ((localObject instanceof RedTouch))
    {
      localObject = (RedTouch)localObject;
      paramInt = 0;
      while (paramInt < ((RedTouch)localObject).getChildCount())
      {
        if ((((RedTouch)localObject).getChildAt(paramInt) instanceof RedDotTextView)) {
          return (RedDotTextView)((RedTouch)localObject).getChildAt(paramInt);
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  private void nr(int paramInt)
  {
    if ((!this.Zc) && (paramInt == 1))
    {
      this.Zc = true;
      jjc.au("0X800AA61", 0);
    }
  }
  
  public void K(long paramLong, boolean paramBoolean)
  {
    super.K(paramLong, paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.getCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.a(i);
        if (localObject != null) {
          ((BeautyBaseView)localObject).K(paramLong, paramBoolean);
        }
        i += 1;
      }
      localObject = iti.a(this.mApp, 8);
      if (!iti.a((BusinessInfoCheckUpdate.AppInfo)localObject)) {
        break label148;
      }
      RedDotTextView localRedDotTextView = a(1);
      if (localRedDotTextView == null) {
        break label131;
      }
      localRedDotTextView.showRedDot(true);
      localObject = iti.aP(8);
      this.mApp.iy((String)localObject);
    }
    label131:
    label148:
    for (this.Zb = true;; this.Zb = false)
    {
      nr(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.getCurrentPosition());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.b(cN[1], (BusinessInfoCheckUpdate.AppInfo)localObject);
      break;
    }
  }
  
  public void L(long paramLong, boolean paramBoolean)
  {
    super.L(paramLong, paramBoolean);
    int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.getCount();
    int i = 0;
    while (i < j)
    {
      BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.a(i);
      if (localBeautyBaseView != null) {
        localBeautyBaseView.L(paramLong, paramBoolean);
      }
      i += 1;
    }
    this.Zc = false;
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    int j = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.getCount();
    int i = 0;
    while (i < j)
    {
      paramQavPanel = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.a(i);
      if (paramQavPanel != null) {
        paramQavPanel.setAppInterface(this.mApp);
      }
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.oK) > 200L))
    {
      this.oK = l;
      EffectSettingUi.a(this.mApp, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void refreshUI()
  {
    super.refreshUI();
    int i = this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem();
    BeautyBaseView localBeautyBaseView = this.jdField_a_of_type_ComTencentAvUiBeautyQavBeautyMenuPanel$a.a(i);
    if (localBeautyBaseView != null) {
      localBeautyBaseView.refreshUI();
    }
  }
  
  public void setCurSelTab(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 1)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 4, "setCurSelTab, [(" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem() + "," + this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.getCurrentPosition() + ") ---> " + paramInt1 + "], anim[" + paramBoolean + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getMeasuredWidth() + "], width[" + this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getWidth() + "], from[" + paramInt2 + "]");
      }
      if ((paramInt2 != 1) && (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.getCurrentPosition())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt1, paramBoolean);
      }
      if ((paramInt2 != 2) && (paramInt1 != this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.getCurrentItem())) {
        this.jdField_a_of_type_ComTencentAvUiBeautyPanelViewPage.setCurrentItem(paramInt1, paramBoolean);
      }
    } while ((!paramBoolean) || (paramInt1 != 1) || (!this.Zb));
    Object localObject = a(1);
    if (localObject != null) {
      ((RedDotTextView)localObject).showRedDot(false);
    }
    for (;;)
    {
      localObject = iti.aP(8);
      this.mApp.ix((String)localObject);
      this.Zb = false;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.tC(cN[paramInt1]);
    }
  }
  
  class a
    extends PagerAdapter
  {
    final List<BeautyBaseView> fD = new ArrayList();
    
    public a()
    {
      this.fD.clear();
      Collection localCollection;
      if (localCollection != null) {
        this.fD.addAll(localCollection);
      }
    }
    
    public BeautyBaseView a(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.fD.size()) {
          localObject1 = (BeautyBaseView)this.fD.get(paramInt);
        }
      }
      return localObject1;
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      if ((paramViewGroup != null) && ((paramObject instanceof BeautyBaseView))) {
        paramViewGroup.removeView((BeautyBaseView)paramObject);
      }
    }
    
    public int getCount()
    {
      return this.fD.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      BeautyBaseView localBeautyBaseView = a(paramInt);
      if ((paramViewGroup != null) && (localBeautyBaseView != null)) {
        paramViewGroup.addView(localBeautyBaseView);
      }
      return localBeautyBaseView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.QavBeautyMenuPanel
 * JD-Core Version:    0.7.0.1
 */