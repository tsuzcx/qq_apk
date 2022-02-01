package com.tencent.mobileqq.activity;

import accn;
import acff;
import acgx;
import alco;
import alcs;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqep;
import aqhu;
import aqrc;
import aura;
import auru;
import avpn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import vfw;
import vfx;

public class LikeRankingListActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener, aqdf.a, AbsListView.e, AdapterView.c
{
  TextView Ea;
  TextView Eb;
  TextView Ec;
  long Gn = 0L;
  accn jdField_a_of_type_Accn = new vfx(this);
  public acgx a;
  aqdf jdField_a_of_type_Aqdf;
  public a a;
  LikeRankingInfo jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
  PullToZoomListView jdField_a_of_type_ComTencentWidgetPullToZoomListView;
  public String aNR;
  auru jdField_b_of_type_Auru = new auru(this);
  public Card b;
  VasQuickUpdateManager.CallBacker jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new vfw(this);
  int bGV;
  int bHA = 0;
  int bIa = 1;
  CardHandler c;
  CircleProgress d;
  ImmersiveTitleBar2 e;
  acff f;
  ColorStateList i;
  ColorStateList j;
  int mCoverHeight;
  String mCoverUrl;
  int mCoverWidth;
  public View mEmptyView;
  View mHeaderView;
  int mLastTop = 0;
  String mSelfUin;
  public int mStartIndex = 0;
  AlphaAnimation o;
  AlphaAnimation p;
  ImageView qo;
  ImageView qp;
  View tB;
  View tC;
  View tD;
  private View tE;
  
  private void xB(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(0);
      this.tB.setVisibility(0);
      this.Ea.setBackgroundResource(2130851758);
      this.Ea.setTextColor(this.j);
      this.Eb.setTextColor(this.j);
      return;
    }
    this.e.setVisibility(4);
    this.tB.setVisibility(8);
    this.Ea.setBackgroundResource(2130838937);
    this.Ea.setTextColor(this.i);
    this.Eb.setTextColor(this.i);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131561409);
    if (getIntent().getIntExtra("param_from", 0) == 1) {
      this.app.reportClickEvent("dc00898", "0X8007619");
    }
    this.jdField_a_of_type_Acgx = ((acgx)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = this.jdField_a_of_type_Acgx.a();
    this.f = ((acff)this.app.getManager(51));
    this.jdField_a_of_type_Aqdf = new aqdf(this, this.app);
    this.jdField_a_of_type_Aqdf.a(this);
    this.c = ((CardHandler)this.app.getBusinessHandler(2));
    addObserver(this.jdField_a_of_type_Accn);
    this.mSelfUin = this.app.getCurrentAccountUin();
    this.e = ((ImmersiveTitleBar2)findViewById(2131379866));
    this.e.setVisibility(4);
    this.tB = findViewById(2131379801);
    this.Ea = ((TextView)findViewById(2131369579));
    this.Eb = ((TextView)findViewById(2131369627));
    paramBundle = getResources();
    this.i = paramBundle.getColorStateList(2131165412);
    this.j = paramBundle.getColorStateList(2131167301);
    findViewById(2131369579).setOnClickListener(this);
    this.mCoverWidth = aqep.x(this);
    this.mCoverHeight = aqep.y(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = ((PullToZoomListView)findViewById(2131370947));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOverScrollDistance(0);
    this.mHeaderView = LayoutInflater.from(this).inflate(2131561410, null);
    this.qo = ((ImageView)this.mHeaderView.findViewById(2131369718));
    this.d = ((CircleProgress)this.mHeaderView.findViewById(2131369719));
    this.d.setStrokeWidth(2.0F);
    this.d.setBgAndProgressColor(0, 2131167595, 100, 16763714);
    this.d.setProgress(100.0F);
    this.qo.setOnClickListener(this);
    this.tE = this.mHeaderView.findViewById(2131365485);
    this.qp = ((ImageView)this.mHeaderView.findViewById(2131369717));
    this.Ec = ((TextView)this.mHeaderView.findViewById(2131380637));
    this.tC = this.mHeaderView.findViewById(2131369695);
    this.tD = this.mHeaderView.findViewById(2131380594);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.addHeaderView(this.mHeaderView);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setHeaderImage(this.tE);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a = new a();
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnItemClickListener(this);
    this.mEmptyView = findViewById(2131366437);
    DisplayMetrics localDisplayMetrics = paramBundle.getDisplayMetrics();
    int k = paramBundle.getDimensionPixelSize(2131299627);
    this.bGV = (paramBundle.getDimensionPixelSize(2131297973) - k - (int)(localDisplayMetrics.density * 66.0F));
    this.o = new AlphaAnimation(0.0F, 1.0F);
    this.o.setDuration(300L);
    this.o.setInterpolator(this, 17432581);
    this.o.setAnimationListener(this);
    this.p = new AlphaAnimation(1.0F, 0.0F);
    this.p.setDuration(300L);
    this.p.setInterpolator(this, 17432581);
    this.p.setAnimationListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
      updateCover(this.mSelfUin);
    }
    paramBundle = this.jdField_a_of_type_Acgx.ea();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      updateCover(String.valueOf(((LikeRankingInfo)paramBundle.get(0)).uin));
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.W(paramBundle, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.mIsLoading = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.notifyDataSetChanged();
      this.c.ab(this.mSelfUin, this.mStartIndex, 500);
      ThreadManager.post(new LikeRankingListActivity.3(this), 5, null, false);
      ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      return true;
      updateCover(null);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Accn);
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    avpn.cI(this);
  }
  
  void e(Card paramCard)
  {
    this.jdField_b_of_type_Auru.post(new LikeRankingListActivity.5(this, paramCard));
    if (aura.a(this.app, paramCard)) {
      if (!aura.b(this.app, paramCard)) {
        if ((paramCard.lCurrentBgId == 1600L) || (paramCard.lCurrentBgId == 160L) || (alcs.cy(paramCard.lCurrentStyleId)))
        {
          aura.c(this.app, paramCard);
          f(paramCard);
        }
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_ComTencentMobileqqDataCard = paramCard;
        ((aqrc)this.app.getManager(235)).b.av(this.app, "card." + paramCard.lCurrentBgId);
        return;
        f(paramCard);
        return;
        localObject = paramCard.getCoverData(this.bHA);
        paramCard = (String)localObject[0];
        localObject = (Integer)localObject[1];
        if (!TextUtils.isEmpty(paramCard)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("LikeRankingListActivity", 2, "[updateCover] url is null");
        }
      } while ((this.mCoverUrl != null) || (this.bHA != 0));
      this.mCoverUrl = paramCard;
      this.bHA = ((Integer)localObject).intValue();
      this.jdField_b_of_type_Auru.post(new LikeRankingListActivity.6(this));
      return;
    } while (paramCard.equals(this.mCoverUrl));
    if ((((Integer)localObject).intValue() == 0) && (!TextUtils.isEmpty(this.mCoverUrl)) && (this.bHA == 0) && (QLog.isColorLevel())) {
      QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
    }
    this.mCoverUrl = paramCard;
    this.bHA = ((Integer)localObject).intValue();
    this.jdField_b_of_type_Auru.post(new LikeRankingListActivity.7(this));
  }
  
  public void f(Card paramCard)
  {
    Object localObject = null;
    if ((this.mCoverUrl != null) && (this.mCoverUrl.equals(paramCard.backgroundUrl))) {}
    String str;
    label196:
    do
    {
      return;
      this.bHA = 0;
      this.mCoverUrl = paramCard.backgroundUrl;
      if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L))
      {
        str = aqep.I(this.app.getApp(), paramCard.strDrawerCardUrl);
        if (QLog.isColorLevel()) {
          QLog.d("LikeRankingListActivity", 2, "updateCoverCard type personal card, path" + str);
        }
        paramCard = BaseApplicationImpl.sImageCache.get(str + "#rank");
        if (!Bitmap.class.isInstance(paramCard)) {
          break label196;
        }
        localObject = (Bitmap)paramCard;
      }
      for (;;)
      {
        if (localObject == null) {
          break label265;
        }
        this.jdField_b_of_type_Auru.postDelayed(new LikeRankingListActivity.8(this, (Bitmap)localObject), 100L);
        return;
        str = alco.b(this.app.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
        break;
        paramCard = (Card)localObject;
        try
        {
          localObject = aqhu.d(str, null);
          paramCard = (Card)localObject;
          BaseApplicationImpl.sImageCache.put(str + "#rank", localObject);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject = paramCard;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, localOutOfMemoryError, new Object[0]);
          localObject = paramCard;
        }
      }
    } while (!QLog.isColorLevel());
    label265:
    QLog.e("LikeRankingListActivity", 2, "updateCoverCard type personal card bitmap = null, path" + str);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.Gn = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.notifyDataSetChanged();
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.p) {
      xB(false);
    }
    this.e.clearAnimation();
    this.tB.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.o) {
      xB(true);
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
      finish();
      continue;
      String str2 = "2";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null)
      {
        str1 = str2;
        if (this.mSelfUin.equals(this.aNR)) {
          str1 = "1";
        }
      }
      anot.a(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, str1, "", "", "");
      ProfileActivity.b(this, new ProfileActivity.AllInOne(this.aNR, 1));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListActivity", 2, "onDecodeTaskCompleted, remainingTasks= " + paramInt1 + " ,type= " + paramInt2 + ", uin= " + paramString + ", avatar= " + paramBitmap);
    }
    if (paramString.equals(this.aNR)) {
      this.qo.setImageBitmap(paramBitmap);
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l = SystemClock.uptimeMillis() - this.Gn;
    this.jdField_b_of_type_Auru.removeMessages(1);
    if (l >= 800L)
    {
      this.Gn = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.notifyDataSetChanged();
      return;
    }
    this.jdField_b_of_type_Auru.sendEmptyMessageDelayed(1, 800L - l);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      paramInt -= 1;
    } while ((this.mStartIndex != -1) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.getCount() - 1));
    if (paramInt == -1)
    {
      paramAdapterView = this.aNR;
      label40:
      if (!TextUtils.isEmpty(paramAdapterView))
      {
        String str = "2";
        paramView = str;
        if (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null)
        {
          paramView = str;
          if (this.mSelfUin.equals(paramAdapterView)) {
            paramView = "1";
          }
        }
        anot.a(this.app, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, paramView, "", "", "");
        ProfileActivity.b(this, new ProfileActivity.AllInOne(paramAdapterView, 1));
      }
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$a.a(paramInt);
      if (paramAdapterView != null) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "";; paramAdapterView = String.valueOf(paramAdapterView.uin))
    {
      break label40;
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.getChildAt(0);
    Object localObject;
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = Math.abs(paramAbsListView.getTop());
      localObject = null;
      if ((paramInt1 <= this.mLastTop) || (paramInt1 < this.bGV) || (this.tB.getVisibility() != 8)) {
        break label102;
      }
      paramAbsListView = this.o;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.tB.getAnimation()))
      {
        paramAbsListView.reset();
        this.tB.startAnimation(paramAbsListView);
        this.e.startAnimation(paramAbsListView);
      }
      this.mLastTop = paramInt1;
      return;
      label102:
      paramAbsListView = localObject;
      if (paramInt1 < this.mLastTop)
      {
        paramAbsListView = localObject;
        if (paramInt1 <= this.bGV)
        {
          paramAbsListView = localObject;
          if (this.tB.getVisibility() == 0) {
            paramAbsListView = this.p;
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void updateCover(String paramString)
  {
    if ((this.aNR != null) && (this.aNR.equals(paramString))) {
      return;
    }
    this.aNR = paramString;
    this.bHA = 0;
    this.mCoverUrl = null;
    if (paramString == null)
    {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.Wi(false);
      this.qp.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.qo.setVisibility(4);
      this.Ec.setVisibility(4);
      this.tC.setVisibility(4);
      this.d.setVisibility(4);
      this.tD.setVisibility(4);
      this.mCoverUrl = null;
      this.bHA = 0;
      xB(true);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.Wi(true);
    Bitmap localBitmap2 = this.jdField_a_of_type_Aqdf.b(1, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_Aqdf.isPausing()) {
        this.jdField_a_of_type_Aqdf.i(paramString, 1, true);
      }
      localBitmap1 = aqhu.G();
    }
    this.qo.setImageBitmap(localBitmap1);
    this.qo.setVisibility(0);
    this.bIa = 1;
    this.app.execute(new LikeRankingListActivity.4(this, paramString));
  }
  
  public class a
    extends BaseAdapter
  {
    RelativeSizeSpan a = new RelativeSizeSpan(0.62F);
    String aNS = LikeRankingListActivity.this.getString(2131695313);
    String aNT = LikeRankingListActivity.this.getString(2131721233);
    int[] fs = { 2130846265, 2130846266, 2130846267 };
    int[] ft = { 2130846262, 2130846263, 2130846264 };
    public boolean mIsLoading = false;
    List<LikeRankingInfo> ni = new ArrayList();
    
    public a() {}
    
    public void W(List<LikeRankingInfo> paramList, boolean paramBoolean)
    {
      this.ni.clear();
      LikeRankingInfo localLikeRankingInfo1 = LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
      int i = paramList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          LikeRankingInfo localLikeRankingInfo2 = (LikeRankingInfo)paramList.get(i);
          if (localLikeRankingInfo2.uin == LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) {
            LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = localLikeRankingInfo2;
          }
        }
        else
        {
          if ((this.ni.size() == 0) && (LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum > 3) && (LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
            this.ni.add(LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.i("LikeRankingListActivity", 2, String.format("setList isServer:%s oldRankInfo:%s newRankInfo:%s size:%d", new Object[] { Boolean.valueOf(paramBoolean), localLikeRankingInfo1, LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo, Integer.valueOf(paramList.size()) }));
          }
          this.ni.addAll(paramList);
          this.mIsLoading = false;
          notifyDataSetChanged();
          return;
        }
        i -= 1;
      }
    }
    
    public LikeRankingInfo a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.ni.size())) {
        return (LikeRankingInfo)this.ni.get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      return this.ni.size() + 1;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == getCount() - 1) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int k = 8;
      int j = 0;
      int i = getItemViewType(paramInt);
      if (paramView == null) {}
      switch (i)
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      LikeRankingInfo localLikeRankingInfo;
      do
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = LayoutInflater.from(LikeRankingListActivity.this).inflate(2131561411, null);
        localObject1 = new b();
        ((b)localObject1).Ee = ((TextView)paramView.findViewById(2131380871));
        ((b)localObject1).qr = ((ImageView)paramView.findViewById(2131369866));
        ((b)localObject1).qs = ((ImageView)paramView.findViewById(2131369669));
        ((b)localObject1).qt = ((ImageView)paramView.findViewById(2131369668));
        ((b)localObject1).Ef = ((TextView)paramView.findViewById(2131380821));
        ((b)localObject1).Eg = ((TextView)paramView.findViewById(2131380992));
        ((b)localObject1).Eh = ((TextView)paramView.findViewById(2131380783));
        ((b)localObject1).ev = paramView.findViewById(2131365990);
        paramView.setTag(localObject1);
        break;
        paramView = LayoutInflater.from(LikeRankingListActivity.this).inflate(2131559672, null);
        localObject1 = new a();
        ((a)localObject1).Ed = ((TextView)paramView.findViewById(2131371975));
        ((a)localObject1).K = ((ProgressBar)paramView.findViewById(2131377037));
        ((a)localObject1).qq = ((ImageView)paramView.findViewById(2131370781));
        paramView.setTag(localObject1);
        break;
        localLikeRankingInfo = a(paramInt);
      } while (localLikeRankingInfo == null);
      b localb = (b)paramView.getTag();
      localb.Ee.setText(String.valueOf(paramInt));
      label384:
      String str;
      if ((paramInt == 0) && (localLikeRankingInfo.uin == LikeRankingListActivity.this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin) && ((localLikeRankingInfo.rankingNum > 3) || (localLikeRankingInfo.rankingNum < 1)))
      {
        localb.ev.setVisibility(0);
        str = String.valueOf(localLikeRankingInfo.uin);
        localObject1 = LikeRankingListActivity.this.f.e(str);
        if (localObject1 == null) {
          break label670;
        }
        localb.Ef.setText(((Friends)localObject1).getFriendNick());
        localObject2 = LikeRankingListActivity.this.jdField_a_of_type_Aqdf.b(1, str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (!LikeRankingListActivity.this.jdField_a_of_type_Aqdf.isPausing()) {
            LikeRankingListActivity.this.jdField_a_of_type_Aqdf.i(str, 1, true);
          }
          localObject1 = aqhu.G();
        }
        localb.qt.setImageBitmap((Bitmap)localObject1);
        label493:
        switch (localLikeRankingInfo.rankingNum)
        {
        default: 
          if (localLikeRankingInfo.rankingNum < 1) {
            localb.Ee.setText("-");
          }
          break;
        }
      }
      for (;;)
      {
        localb.qr.setVisibility(8);
        localb.qs.setVisibility(8);
        for (;;)
        {
          localObject1 = new SpannableString(String.format(Locale.CHINA, this.aNS, new Object[] { Integer.valueOf(localLikeRankingInfo.likeCountOfToday) }));
          ((SpannableString)localObject1).setSpan(this.a, 0, 1, 33);
          localb.Eh.setText((CharSequence)localObject1);
          localb.Eg.setText(String.format(Locale.CHINA, this.aNT, new Object[] { Integer.valueOf(localLikeRankingInfo.totalLikeCount) }));
          break;
          localb.ev.setVisibility(8);
          break label384;
          label670:
          localb.Ef.setText(str);
          localb.qt.setImageBitmap(aqhu.G());
          break label493;
          localb.Ee.setText(String.valueOf(localLikeRankingInfo.rankingNum));
          localb.qr.setVisibility(8);
          localb.qs.setImageResource(this.ft[(localLikeRankingInfo.rankingNum - 1)]);
          localb.qs.setVisibility(0);
        }
        localb.Ee.setText(String.valueOf(localLikeRankingInfo.rankingNum));
      }
      Object localObject1 = (a)paramView.getTag();
      Object localObject2 = ((a)localObject1).Ed;
      if (this.mIsLoading)
      {
        i = 2131695458;
        label799:
        ((TextView)localObject2).setText(i);
        localObject2 = ((a)localObject1).K;
        if (!this.mIsLoading) {
          break label883;
        }
        i = 0;
        label823:
        ((ProgressBar)localObject2).setVisibility(i);
        localObject1 = ((a)localObject1).qq;
        if (!this.mIsLoading) {
          break label890;
        }
        i = k;
        label848:
        ((ImageView)localObject1).setVisibility(i);
        if (!this.mIsLoading) {
          break label896;
        }
      }
      label896:
      for (i = j;; i = 4)
      {
        paramView.setVisibility(i);
        break;
        i = 2131695992;
        break label799;
        label883:
        i = 8;
        break label823;
        label890:
        i = 0;
        break label848;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    class a
    {
      TextView Ed;
      ProgressBar K;
      ImageView qq;
      
      a() {}
    }
    
    class b
    {
      TextView Ee;
      TextView Ef;
      TextView Eg;
      TextView Eh;
      View ev;
      ImageView qr;
      ImageView qs;
      ImageView qt;
      
      b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity
 * JD-Core Version:    0.7.0.1
 */