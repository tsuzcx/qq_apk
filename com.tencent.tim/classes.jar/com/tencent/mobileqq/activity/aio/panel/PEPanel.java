package com.tencent.mobileqq.activity.aio.panel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import anot;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import java.io.FileInputStream;
import mqq.os.MqqHandler;
import wja;
import wms;
import xks;
import xrr;
import xrs;
import yfx;

public class PEPanel
  extends FrameLayout
{
  private long Jq;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel$a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private wms jdField_a_of_type_Wms;
  private String aVV;
  private boolean aoO = true;
  private boolean bii;
  private BaseChatPie c;
  private DiniFlyAnimationView i;
  private MqqHandler mUIHandler;
  private SessionInfo sessionInfo;
  
  public PEPanel(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PEPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.sessionInfo = paramSessionInfo;
    this.c = paramBaseChatPie;
    paramBaseChatPie = new DiniFlyAnimationView(getContext());
    paramSessionInfo = new FrameLayout.LayoutParams(-1, XPanelContainer.aLe - wja.dp2px(40.0F, getResources()));
    this.i = paramBaseChatPie;
    addView(paramBaseChatPie, paramSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetListView = new StickerBubbleListView(getContext(), this.c);
    paramBaseChatPie = new FrameLayout.LayoutParams(-1, -1);
    paramBaseChatPie.topMargin = wja.dp2px(30.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetListView.setLayoutParams(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentWidgetListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setVerticalFadingEdgeEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(new ColorDrawable(0));
    addView(this.jdField_a_of_type_ComTencentWidgetListView, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPEPanel$a = new a();
    this.aVV = (yfx.aXt + "aio_panel_pe_ani.json");
    this.mUIHandler = new MqqHandler(Looper.myLooper(), new xrr(this));
  }
  
  public void cer()
  {
    int k = 1;
    String str = this.aVV;
    Object localObject = this.i;
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim isAlreadyAnimating = %b,mIsLottieJsonLoaded = %b", new Object[] { Boolean.valueOf(((DiniFlyAnimationView)localObject).isAnimating()), Boolean.valueOf(this.bii) }));
    }
    if (((DiniFlyAnimationView)localObject).isAnimating()) {
      return;
    }
    int m;
    int n;
    int j;
    if (this.bii)
    {
      m = xks.c(this.c.getApp(), 4);
      n = xks.c(this.c.getApp(), 1);
      if ((m != 1) || (n <= 0)) {
        break label227;
      }
      j = k;
    }
    for (;;)
    {
      for (;;)
      {
        anot.a(this.c.getApp(), "dc00898", "", "", "0X8009221", "0X8009221", j, 0, "", "", "", "");
        return;
        try
        {
          localObject = new xrs(this, (DiniFlyAnimationView)localObject);
          LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str), (OnCompositionLoadedListener)localObject);
          this.bii = true;
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(0);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PokeEmo.PEPanel", 2, "load lottie exception ,msg = " + localException.getMessage());
      break;
      label227:
      if ((m == 0) && (n > 0))
      {
        j = 2;
      }
      else if ((m == 1) && (n == 0))
      {
        j = 3;
      }
      else
      {
        j = k;
        if (m == 0)
        {
          j = k;
          if (n == 0) {
            j = 4;
          }
        }
      }
    }
  }
  
  public void clear() {}
  
  public void onHide() {}
  
  public void reload(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo.PEPanel", 2, String.format(" reload..reload = %s", new Object[] { paramString }));
    }
    paramString = yfx.ac(paramString);
    this.jdField_a_of_type_Wms = new wms(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Wms);
    this.jdField_a_of_type_Wms.cS(paramString);
    this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
  }
  
  public void setListViewVisibile(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetListView.setVisibility(paramInt);
  }
  
  public class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if ((PEPanel.a(PEPanel.this) != null) && (QLog.isColorLevel())) {
        QLog.d("PokeEmo.PEPanel", 2, String.format(" playLottieAnim onAnimationEnd listView.visibility = %d ", new Object[] { Integer.valueOf(PEPanel.a(PEPanel.this).getVisibility()) }));
      }
      if ((PEPanel.a(PEPanel.this) != null) && (PEPanel.a(PEPanel.this).getVisibility() != 0)) {
        PEPanel.a(PEPanel.this).setVisibility(0);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      PEPanel.this.setListViewVisibile(8);
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel
 * JD-Core Version:    0.7.0.1
 */