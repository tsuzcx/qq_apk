package com.tencent.mobileqq.apollo.debug;

import abkj;
import abkj.a;
import abkk;
import abkl;
import abkm;
import abkn;
import abko;
import abkp;
import abmt;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SimpleAdapter;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment;
import com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class CmGameDebugView
  extends FrameworkView
  implements View.OnClickListener
{
  private View AH;
  private View AI;
  private abkj.a jdField_a_of_type_Abkj$a = new abkp(this);
  private CmGameDebugBaseFragment jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment;
  private boolean bDw = true;
  private boolean bDx;
  private SparseArray<CmGameDebugBaseFragment> bW = new SparseArray();
  public AdapterView.OnItemClickListener h = new abkn(this);
  private RelativeLayout jg;
  private Context mContext;
  private DisplayMetrics mDm;
  FragmentManager mFragmentManager;
  private HorizontalListView mListView;
  private View mMaskView;
  public int mScreenHeight;
  public int mScreenWidth;
  public View.OnTouchListener mTouchListener = new abkk(this);
  
  public CmGameDebugView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initView(paramContext);
  }
  
  public CmGameDebugView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    this.mContext = paramContext;
    initView(paramContext);
  }
  
  private void Hq(int paramInt)
  {
    int i = 0;
    while (i < this.bW.size())
    {
      CmGameDebugBaseFragment localCmGameDebugBaseFragment = (CmGameDebugBaseFragment)this.bW.get(i);
      if ((localCmGameDebugBaseFragment instanceof CmGameDebugLogFragment)) {
        ((CmGameDebugLogFragment)localCmGameDebugBaseFragment).Hr(paramInt);
      }
      i += 1;
    }
  }
  
  private void cCC()
  {
    abkj localabkj = abmt.a();
    if (localabkj != null) {
      localabkj.a(this.jdField_a_of_type_Abkj$a);
    }
  }
  
  private void initView(Context paramContext)
  {
    this.mDm = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    if (this.b.viewMode > 0)
    {
      if (this.mDm.heightPixels > this.mDm.widthPixels)
      {
        i = this.mDm.heightPixels;
        this.mScreenWidth = i;
        if (this.mDm.heightPixels <= this.mDm.widthPixels) {
          break label263;
        }
      }
      label263:
      for (i = this.mDm.widthPixels;; i = this.mDm.heightPixels)
      {
        this.mScreenHeight = i;
        paramContext = (FrameLayout)LayoutInflater.from(paramContext).inflate(2131558999, null);
        this.AH = paramContext.findViewById(2131364832);
        this.jg = ((RelativeLayout)paramContext.findViewById(2131364834));
        this.mListView = ((HorizontalListView)paramContext.findViewById(2131364835));
        this.mMaskView = paramContext.findViewById(2131364833);
        this.mMaskView.setOnClickListener(this);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AH.getLayoutParams();
        localLayoutParams.leftMargin = (this.mScreenWidth - aqcx.dip2px(this.mContext, 130.0F));
        localLayoutParams.topMargin = (this.mScreenHeight - aqcx.dip2px(this.mContext, 46.0F));
        this.AH.setOnTouchListener(this.mTouchListener);
        addView(paramContext);
        ((RelativeLayout)((Activity)this.mActivityRef.get()).findViewById(2131377555)).addView(this, new RelativeLayout.LayoutParams(-2, -2));
        ckj();
        return;
        i = this.mDm.widthPixels;
        break;
      }
    }
    if (this.mDm.heightPixels < this.mDm.widthPixels)
    {
      i = this.mDm.heightPixels;
      label299:
      this.mScreenWidth = i;
      if (this.mDm.heightPixels >= this.mDm.widthPixels) {
        break label348;
      }
    }
    label348:
    for (int i = this.mDm.widthPixels;; i = this.mDm.heightPixels)
    {
      this.mScreenHeight = i;
      break;
      i = this.mDm.widthPixels;
      break label299;
    }
  }
  
  private void setTabSelect(int paramInt)
  {
    if (this.AI != null) {
      this.AI.setSelected(false);
    }
    View localView = this.mListView.getChild(paramInt);
    if (localView != null)
    {
      localView.setSelected(true);
      this.AI = localView;
    }
  }
  
  public void Hp(int paramInt)
  {
    if (this.mFragmentManager == null) {
      this.mFragmentManager = ((FragmentActivity)this.mContext).getSupportFragmentManager();
    }
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment != null) {
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment);
    }
    CmGameDebugBaseFragment localCmGameDebugBaseFragment2 = (CmGameDebugBaseFragment)this.bW.get(paramInt);
    CmGameDebugBaseFragment localCmGameDebugBaseFragment1 = localCmGameDebugBaseFragment2;
    if (localCmGameDebugBaseFragment2 == null)
    {
      localCmGameDebugBaseFragment1 = abkj.a(paramInt);
      localCmGameDebugBaseFragment1.a(new abko(this));
      this.bW.put(paramInt, localCmGameDebugBaseFragment1);
    }
    if (!localCmGameDebugBaseFragment1.isAdded()) {
      localFragmentTransaction.add(2131364831, localCmGameDebugBaseFragment1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDebugPageCmGameDebugBaseFragment = localCmGameDebugBaseFragment1;
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.show(localCmGameDebugBaseFragment1);
    }
  }
  
  public void cCA()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jg.getHeight(), 0.0F);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setDuration(200L);
    this.jg.setVisibility(0);
    this.mMaskView.setVisibility(0);
    this.jg.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new abkl(this));
  }
  
  public void cCB()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jg.getHeight());
    localTranslateAnimation.setDuration(200L);
    localTranslateAnimation.setFillAfter(true);
    this.jg.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new abkm(this));
  }
  
  public void ckj()
  {
    SimpleAdapter localSimpleAdapter = new SimpleAdapter(this.mContext, dD(), 2131559000, new String[] { "title" }, new int[] { 2131364836 });
    this.mListView.setAdapter(localSimpleAdapter);
    this.mListView.setOnItemClickListener(this.h);
    Hp(0);
    cCC();
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameDebugView", 2, "game debug view init");
    }
  }
  
  public List<HashMap<String, Object>> dD()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < abkj.du.length)
    {
      String str = abkj.du[i];
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", str);
      localArrayList.add(localHashMap);
      i += 1;
    }
    return localArrayList;
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
      cCB();
    }
  }
  
  public void onDestroy()
  {
    this.bW.clear();
  }
  
  public void resetView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView
 * JD-Core Version:    0.7.0.1
 */