package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import aqgz;
import atau.a;
import auts;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import kxm;
import lie;
import lta;
import mfo;
import mgh;
import nda;
import ndc;
import ngm;
import nhl;
import npy;
import npy.a;
import npy.b;
import nqb;
import odd;

public class ReadInJoyXListView
  extends ReadInJoyBaseListView
  implements ngm
{
  private npy.a jdField_a_of_type_Npy$a;
  private npy jdField_a_of_type_Npy;
  protected int aDE;
  protected int aYC;
  public int aYI = -1;
  public int aYJ = -1;
  private int aYK = 0;
  private int aYL = -1;
  public float[] aq = new float[2];
  public float[] ar = new float[2];
  private boolean asc;
  protected boolean asd;
  private boolean ase;
  protected boolean asf;
  private boolean asg;
  private boolean ash = true;
  private ndc b;
  private ThreadLocal<Integer> l = new nhl(this);
  private View mD;
  private Handler mHandler;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Tc()
  {
    if ((this.jdField_a_of_type_Npy != null) && (!this.asg))
    {
      this.mD = this.jdField_a_of_type_Npy.d(this);
      setOverScrollHeader(this.jdField_a_of_type_Npy.d(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.jdField_a_of_type_Npy.qC());
      if ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager)) {
        setOverscrollHeader(new ColorDrawable(Color.parseColor("#F7F7F7")));
      }
    }
    else
    {
      return;
    }
    setOverscrollHeader(new ColorDrawable(-1));
  }
  
  private void eO(long paramLong)
  {
    if (this.asc)
    {
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void pD(boolean paramBoolean)
  {
    this.asc = paramBoolean;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(214);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("feeds_loading", 0);
      QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], isOpen = " + i);
      if (i == 0)
      {
        QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], do not switch layer type.");
        return;
      }
    }
    kxm.p().post(new ReadInJoyXListView.3(this, paramBoolean));
  }
  
  private void ty(int paramInt)
  {
    int j = 0;
    if ((this.asc) || (this.asg)) {
      return;
    }
    this.l.set(Integer.valueOf(paramInt));
    int i;
    if (mfo.b(getContext(), 0) != null)
    {
      i = 1;
      label42:
      if ((!(this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager)) || ((paramInt != 2) && (paramInt != 3)) || (this.mChannelId != 0) || (i == 0)) {
        break label223;
      }
      i = 1;
      label75:
      if (i == 0) {
        break label234;
      }
      this.jdField_a_of_type_Npy.qC();
      if (!mgh.DA()) {
        break label228;
      }
      int k = Aladdin.getConfig(189).getIntegerFromString("banner_refresh_length", 0);
      if (k > 0)
      {
        float f = aqgz.getDispalyDpi() / 160.0F;
        setOverScrollHeight((int)(k * f));
        j = i;
      }
      label133:
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyXListView", 2, "changeRefreshAreaHeight with refreshType：" + paramInt);
        i = j;
      }
    }
    label223:
    label228:
    label234:
    for (;;)
    {
      showOverScrollHeader();
      if ((!this.asf) && (this.jdField_a_of_type_Npy != null)) {
        this.jdField_a_of_type_Npy.aXf();
      }
      if ((this.jdField_a_of_type_Npy == null) || (i == 0)) {
        break;
      }
      setOverScrollHeight(this.jdField_a_of_type_Npy.qC());
      return;
      i = 0;
      break label42;
      i = 0;
      break label75;
      j = i;
      break label133;
    }
  }
  
  private void tz(int paramInt)
  {
    if (this.ase)
    {
      if (this.mFirstPosition == 0)
      {
        QLog.d("ReadInJoyXListView", 2, "scroll2Top : stop on top,refresh ! from : " + paramInt);
        ty(1);
        this.ase = false;
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyXListView", 2, "scroll2Top : not on top, jump to top and refresh. from : " + paramInt);
    if (paramInt != 3)
    {
      this.ase = false;
      if ((getAdapter() instanceof auts)) {
        setAdapter(((auts)getAdapter()).getWrappedAdapter());
      }
      for (;;)
      {
        ty(1);
        return;
        setAdapter(getAdapter());
      }
    }
    aWi();
  }
  
  public boolean Fz()
  {
    return this.asc;
  }
  
  public npy a(int paramInt)
  {
    if (this.aYL == paramInt) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_Npy != null) && ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_Npy.onDestroy();
    }
    this.jdField_a_of_type_Npy = nqb.a(getContext(), paramInt);
    if (this.jdField_a_of_type_Npy$a != null) {
      this.jdField_a_of_type_Npy.setRefreshPullDistanceListener(this.jdField_a_of_type_Npy$a);
    }
    if (this.asd) {
      Tc();
    }
    return this.jdField_a_of_type_Npy;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Npy == null) || (paramView != this.jdField_a_of_type_Npy.d(this)) || (this.asf)) {
      return;
    }
    this.jdField_a_of_type_Npy.ag(paramInt2, this.asc);
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Npy == null) || (paramView != this.jdField_a_of_type_Npy.d(this)) || (this.asf)) {
      return;
    }
    this.jdField_a_of_type_Npy.dn(paramInt, this.mTouchMode);
  }
  
  public void a(npy.b paramb)
  {
    if (this.jdField_a_of_type_Npy != null) {
      this.jdField_a_of_type_Npy.a(paramb);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    do
    {
      return true;
      paramInt = ((Integer)this.l.get()).intValue();
      this.l.set(Integer.valueOf(0));
    } while ((this.asc) || (this.jdField_a_of_type_Npy == null) || (paramView != this.jdField_a_of_type_Npy.d(this)));
    if (!this.asf)
    {
      paramView = this.jdField_a_of_type_Npy;
      if (paramInt == 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      paramView.pY(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c == null) {
        break;
      }
      pD(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c.a(this, paramInt);
      return true;
    }
  }
  
  public void aCB()
  {
    pD(false);
    springBackOverScrollHeaderView();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c.aCB();
    }
    if ((!this.asc) && (this.jdField_a_of_type_Npy != null) && (!this.asf)) {
      this.jdField_a_of_type_Npy.aCB();
    }
  }
  
  public void aWg()
  {
    if ((this.jdField_a_of_type_Npy != null) && ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Npy).aWg();
    }
  }
  
  public void aWh()
  {
    if ((this.jdField_a_of_type_Npy != null) && ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Npy).aWh();
    }
  }
  
  public void aWi()
  {
    tx(1);
  }
  
  public void aXd()
  {
    if ((this.jdField_a_of_type_Npy != null) && (this.asc)) {
      eO(0L);
    }
  }
  
  public void aXe()
  {
    if (this.mD != null) {
      this.mD.setVisibility(8);
    }
    this.asg = true;
    setOverScrollHeight(0);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Npy == null) || (paramView != this.jdField_a_of_type_Npy.d(this)) || (this.asc) || (this.asf)) {
      return;
    }
    this.jdField_a_of_type_Npy.ag(100, false);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if ((!this.asc) && (this.jdField_a_of_type_Npy != null) && (paramView == this.jdField_a_of_type_Npy.d(this)) && (!this.asf)) {
      this.jdField_a_of_type_Npy.aZZ();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.aYI = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.aq[0] = paramMotionEvent.getX();
      this.aq[1] = paramMotionEvent.getY();
      continue;
      this.aYJ = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.ar[0] = paramMotionEvent.getX();
      this.ar[1] = paramMotionEvent.getY();
    }
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.init(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.rE);
    this.asd = paramContext.getBoolean(1, false);
    paramContext.recycle();
    this.aDE = ((int)aqgz.hL());
    this.aYK = getLayerType();
  }
  
  public void initPaddingManual()
  {
    super.initPaddingManual();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 2, "initPaddingManual  mPaddingTop=" + this.mPaddingTop + ",mListPadding.top=" + this.mListPadding.top);
    }
    if ((this.mListPadding.top == 0) && (this.mPaddingTop > 0)) {
      this.mListPadding.top = this.mPaddingTop;
    }
    if ((this.mListPadding.bottom == 0) && (this.mPaddingBottom > 0)) {
      this.mListPadding.bottom = this.mPaddingBottom;
    }
    if ((this.mListPadding.left == 0) && (this.mPaddingLeft > 0)) {
      this.mListPadding.left = this.mPaddingLeft;
    }
    if ((this.mListPadding.right == 0) && (this.mPaddingRight > 0)) {
      this.mListPadding.right = this.mPaddingRight;
    }
  }
  
  public void onAttachChildView(View paramView)
  {
    if (((paramView instanceof nda)) && (!((nda)paramView).isResumed()))
    {
      ((nda)paramView).setIsResume(true);
      ((nda)paramView).onViewResume();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.b != null)) {
        this.b.aMQ();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Npy != null)
    {
      this.jdField_a_of_type_Npy.onDestroy();
      this.jdField_a_of_type_Npy = null;
    }
    this.mD = null;
  }
  
  public void onDetachChildView(View paramView)
  {
    if (((paramView instanceof nda)) && (((nda)paramView).isResumed()))
    {
      ((nda)paramView).setIsResume(false);
      ((nda)paramView).onViewPause();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.b != null)) {
        this.b.aMR();
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mHandler = new Handler(new b(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.ash)
    {
      odd.bU("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      odd.bU(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.ash = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 == 0)
    {
      paramAbsListView = getChildAt(0);
      if ((paramAbsListView == null) || (paramAbsListView.getTop() < 0)) {}
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      tz(3);
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label38;
      }
      ((ReadInJoyNewFeedsActivity)getContext()).oT(8);
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!(getContext() instanceof SplashActivity));
      paramAbsListView = kxm.a(getContext());
    } while (paramAbsListView == null);
    paramAbsListView.oT(8);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ase)
    {
      QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_a_of_type_Npy != null) && (this.jdField_a_of_type_Npy.onTouchEvent(paramMotionEvent)))
    {
      return true;
      this.aYC = ((int)paramMotionEvent.getRawY());
      continue;
      this.aYh = ((int)paramMotionEvent.getRawY() - this.aYC);
      continue;
      FrameHelperActivity.EO(true);
      if ((this.jdField_a_of_type_Npy != null) && ((this.jdField_a_of_type_Npy instanceof ReadInJoySkinAnimManager)) && (((ReadInJoySkinAnimManager)this.jdField_a_of_type_Npy).FE())) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      tz(1);
    }
  }
  
  public void pu(boolean paramBoolean)
  {
    if (!paramBoolean) {
      tz(2);
    }
  }
  
  public int qz()
  {
    return this.mTouchMode;
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.asd = paramBoolean;
    Tc();
  }
  
  public void setNoteCardLifeCycle(ndc paramndc)
  {
    this.b = paramndc;
  }
  
  public void setRefreshPullDistanceListener(npy.a parama)
  {
    this.jdField_a_of_type_Npy$a = parama;
    if (this.jdField_a_of_type_Npy != null) {
      this.jdField_a_of_type_Npy.setRefreshPullDistanceListener(parama);
    }
  }
  
  public void t(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_Npy != null) && (this.asc))
    {
      eO(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_animation_total_time", 1000));
      this.jdField_a_of_type_Npy.t(paramBoolean, paramString);
    }
  }
  
  public void tw(int paramInt)
  {
    QLog.d("ReadInJoyXListView", 1, new Object[] { "beginRefresh, refreshType = ", Integer.valueOf(paramInt), ", mIsTopRefreshing = ", Boolean.valueOf(this.asc) });
    if (this.asc) {
      return;
    }
    post(new ReadInJoyXListView.2(this, paramInt));
  }
  
  public void tx(int paramInt)
  {
    if (this.asc) {
      return;
    }
    smoothScrollBy(0, 0);
    setSelection(0);
    ty(paramInt);
    QLog.d("ReadInJoyXListView", 2, "scroll2TopAndRefresh needScroll : " + true);
  }
  
  public static abstract interface a
  {
    public abstract void aXf();
    
    public abstract View d(ViewGroup paramViewGroup);
    
    public abstract int qC();
    
    public abstract void t(boolean paramBoolean, String paramString);
  }
  
  public static class b
    implements Handler.Callback
  {
    private WeakReference<ReadInJoyXListView> cu;
    
    public b(ReadInJoyXListView paramReadInJoyXListView)
    {
      this.cu = new WeakReference(paramReadInJoyXListView);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return false;
      }
      if ((this.cu != null) && (this.cu.get() != null))
      {
        ((ReadInJoyXListView)this.cu.get()).aCB();
        return true;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */