package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import aqdj;
import aqhu;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.concurrent.ConcurrentHashMap;
import kxm;
import ldw;
import mfj;
import mfs;
import niy;
import wja;

public class ReadinjoyTabbar
  extends BaseTabbar
{
  private ReadInJoyNewFeedsActivity a;
  protected KandianMergeManager b;
  private ConcurrentHashMap<Integer, a> bv = new ConcurrentHashMap();
  private BubblePopupWindow d;
  private BubblePopupWindow f;
  protected QQAppInterface mApp;
  
  public ReadinjoyTabbar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadinjoyTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static BubblePopupWindow a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null)) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    paramView1.getLocationOnScreen(arrayOfInt);
    return a(paramView1, paramView2, arrayOfInt[0] + paramView1.getMeasuredWidth() / 2, arrayOfInt[1]);
  }
  
  private static BubblePopupWindow a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    try
    {
      BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
      localBubblePopupWindow.setContentView(paramView2);
      localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      localBubblePopupWindow.setTouchable(false);
      localBubblePopupWindow.setFocusable(false);
      localBubblePopupWindow.setSoftInputMode(1);
      localBubblePopupWindow.setInputMethodMode(2);
      localBubblePopupWindow.d(paramView1, paramInt1, paramInt2);
      return localBubblePopupWindow;
    }
    catch (Exception paramView1)
    {
      QLog.d("TabBarView", 1, "showAtLocation", paramView1);
    }
    return null;
  }
  
  private void a(int paramInt, Object paramObject, View paramView)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 3: 
      dg(paramView);
      return;
    }
    df(paramView);
  }
  
  private void aXS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissVideoBubbleTips()");
    }
    if ((this.d != null) && (this.d.isShowing())) {}
    try
    {
      this.d.dismiss();
      this.d = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void aXT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissSelfBubbleTips()");
    }
    if ((this.f != null) && (this.f.isShowing())) {}
    try
    {
      this.f.dismiss();
      this.f = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void df(View paramView)
  {
    if ((this.f != null) && (this.f.isShowing())) {}
    while ((this.d != null) && (this.d.isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "showVideoBubbleTips()");
    }
    Context localContext = paramView.getContext();
    RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
    TextView localTextView = new TextView(localContext);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 16.0F);
    localTextView.setGravity(17);
    int i = aqcx.dip2px(localContext, 10.0F);
    localTextView.setPadding(i, 0, i, 0);
    localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
    this.d = a(paramView, localRelativeLayout);
  }
  
  private void dg(View paramView)
  {
    if ((this.d != null) && (this.d.isShowing())) {}
    Context localContext;
    RelativeLayout localRelativeLayout;
    TextView localTextView;
    long l;
    do
    {
      do
      {
        return;
      } while ((this.f != null) && (this.f.isShowing()));
      if (QLog.isColorLevel()) {
        QLog.d("TabBarView", 2, "showSelfBubbleTips()");
      }
      localContext = paramView.getContext();
      localRelativeLayout = new RelativeLayout(localContext);
      localTextView = new TextView(localContext);
      localTextView.setId(2131376709);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(1, 16.0F);
      localTextView.setGravity(17);
      int i = aqcx.dip2px(localContext, 10.0F);
      localTextView.setPadding(i, 0, i, 0);
      l = this.b.cw();
    } while (this.b.de(3) <= 0);
    Object localObject = aqhu.aU();
    if (l != -1L) {}
    for (localObject = aqdj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, Long.toString(l), 3, (Drawable)localObject, (Drawable)localObject);; localObject = this.a.getApplicationContext().getResources().getDrawable(2130843818))
    {
      ((Drawable)localObject).setBounds(0, 0, aqcx.dip2px(localContext, 25.0F), aqcx.dip2px(localContext, 25.0F));
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
      localRelativeLayout.setOnClickListener(new niy(this));
      this.f = a(paramView, localRelativeLayout);
      if (this.f == null) {
        break;
      }
      this.f.setTouchable(true);
      this.f.setOutsideTouchable(true);
      this.f.update();
      return;
    }
  }
  
  private void init()
  {
    setUnselectColor(-8947849);
    setTabTextSize(17);
    setBackgroundDrawable(new ColorDrawable(0));
    setTabHeight(wja.dp2px(65.0F, getResources()));
    setUnderLineHeight(wja.dp2px(6.0F, getResources()));
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.b = ((KandianMergeManager)this.mApp.getManager(162));
    setSelectColor(((mfs)this.mApp.getManager(261)).a(8).getColor());
  }
  
  public ReadInJoyBaseFragment a(a parama)
  {
    if (parama == null) {
      return null;
    }
    return parama.c();
  }
  
  public BaseTabbar.b a(int paramInt, String paramString)
  {
    paramString = super.a(paramInt, paramString);
    a locala = new a();
    locala.d = null;
    locala.b = paramString;
    this.bv.put(Integer.valueOf(paramInt), locala);
    return paramString;
  }
  
  public a a(int paramInt)
  {
    return (a)this.bv.get(Integer.valueOf(paramInt));
  }
  
  public void l(int paramInt, View paramView)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 3: 
      aXT();
      return;
    }
    aXS();
  }
  
  public int qD()
  {
    if ((this.f != null) && (this.f.isShowing())) {
      return 3;
    }
    if ((this.d != null) && (this.d.isShowing())) {
      return 1;
    }
    return -1;
  }
  
  public void setCurrentActivity(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.a = paramReadInJoyNewFeedsActivity;
  }
  
  public void setSelection(int paramInt1, int paramInt2, FragmentManager paramFragmentManager, Intent paramIntent, int paramInt3, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    a locala;
    for (;;)
    {
      try
      {
        paramIntent = a(paramInt2);
        locala = a(paramInt1);
        if ((paramInt1 == paramInt2) && (a(locala) != null) && (paramInt3 == 256))
        {
          locala.c().aIq();
          setTabState(paramInt1, false);
          return;
        }
        if (paramInt3 != 256) {
          setSelectedTab(paramInt1, true, true);
        }
        paramFragmentManager = paramFragmentManager.beginTransaction();
        if (paramInt1 < paramInt2)
        {
          paramFragmentManager.setCustomAnimations(2130772382, 2130772385);
          if ((paramIntent != null) && (paramIntent.d != null) && (paramIntent.d == this.a.a()))
          {
            paramFragmentManager.hide(paramIntent.d);
            paramIntent.d.aCc();
          }
          if ((this.a.a() != null) && (this.a.a() != locala.d)) {
            paramFragmentManager.hide(this.a.a());
          }
          if (locala.d == null)
          {
            locala.d = ldw.a(paramInt1);
            if (locala.d == null) {
              continue;
            }
          }
          if (!locala.mAdded) {
            paramFragmentManager.add(2131365373, locala.d, String.valueOf(paramInt1));
          }
          paramFragmentManager.show(locala.d);
          paramFragmentManager.commitAllowingStateLoss();
          this.a.a(locala.d);
          if (paramInt3 == 258) {
            locala.c().aw(paramBundle);
          }
          if (paramInt3 != 257) {
            break;
          }
          paramFragmentManager = locala.d;
          if (locala.mAdded) {
            break label483;
          }
          label297:
          paramFragmentManager.a(bool1, this.a, paramBundle);
          label309:
          if (!locala.mAdded) {
            locala.mAdded = true;
          }
          df(paramInt2, paramInt1);
          if (((mfs)this.mApp.getManager(261)).pg() != 0) {
            break label477;
          }
          if (!paramIntent.b.Fl()) {
            paramIntent.b.ac(true, false);
          }
          if (!locala.asu) {
            continue;
          }
          locala.b.ac(false, false);
          continue;
        }
        if (paramInt1 <= paramInt2) {
          continue;
        }
      }
      finally {}
      if ((paramBundle != null) && (paramBundle.getBoolean("READINJOY_VIDEO_FORCE_INSERT_SET_SELECTION", false))) {
        paramFragmentManager.setCustomAnimations(2130772390, 2130772391);
      } else {
        paramFragmentManager.setCustomAnimations(2130772384, 2130772386);
      }
    }
    paramFragmentManager = locala.d;
    if (!locala.mAdded) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramFragmentManager.a(bool1, this.a, null);
      break label309;
      label477:
      AbstractGifImage.resumeAll();
      break;
      label483:
      bool1 = false;
      break label297;
    }
  }
  
  public void setTabState(int paramInt, boolean paramBoolean)
  {
    Object localObject = (mfs)this.mApp.getManager(261);
    if ((paramBoolean) && (((mfs)localObject).pg() != 0)) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("TabBarView", 4, "setTabState type:" + paramInt + " isRefreshState:" + paramBoolean);
    }
    localObject = a(paramInt);
    ((a)localObject).asu = paramBoolean;
    BaseTabbar.b localb = ((a)localObject).b;
    if (!((a)localObject).asu) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localb.ac(paramBoolean, true);
      return;
    }
  }
  
  public void tG(int paramInt)
  {
    a locala = (a)this.bv.get(Integer.valueOf(paramInt));
    locala.b.a.post(new ReadinjoyTabbar.2(this, paramInt, locala));
  }
  
  public static class a
  {
    public boolean asu;
    public BaseTabbar.b b;
    ReadInJoyBaseFragment d;
    boolean mAdded = false;
    
    public ReadInJoyBaseFragment c()
    {
      return this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar
 * JD-Core Version:    0.7.0.1
 */