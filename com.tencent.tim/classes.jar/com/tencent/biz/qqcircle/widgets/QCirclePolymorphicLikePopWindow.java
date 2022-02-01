package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import ankt;
import com.app.hubert.guide.util.ScreenUtils;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jqi;
import mqq.os.MqqHandler;
import ovd;
import ozq;
import ozq.a;
import pcl;
import pcp;
import pcr;
import pgg;
import pgi;
import pgj;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import rwv;
import rze;

public class QCirclePolymorphicLikePopWindow
  extends PopupWindow
{
  public static int biA = 6;
  public static int biy;
  public static int biz;
  public static HashMap<String, Integer> eZ = new HashMap();
  private LinearLayout E;
  private QCirclePolyLikeFrameLayout.a a;
  private boolean azU;
  private volatile boolean azV = true;
  private volatile boolean azW;
  private boolean azX;
  private ReportExtraTypeInfo b;
  private int biB;
  private WeakReference<View> cK;
  private WeakReference<QCirclePolymorphicAniView> cL;
  private WeakReference<View> cM;
  private HashMap<String, a> fa = new HashMap();
  private HashMap<Integer, ozq.a> fb = new HashMap();
  private List<QQCircleFeedBase.StPolyLike> lF;
  private WeakReference<Activity> mActivity;
  private View mContainerView;
  private FeedCloudMeta.StFeed mFeed;
  private int mItems;
  private ImageView mi;
  
  static
  {
    eZ.put("2", Integer.valueOf(2130844868));
    eZ.put("3", Integer.valueOf(2130844874));
    eZ.put("4", Integer.valueOf(2130844873));
    eZ.put("6", Integer.valueOf(2130844872));
    eZ.put("7", Integer.valueOf(2130844867));
    biy = ankt.dip2px(88.0F);
    biz = ankt.dip2px(48.0F);
  }
  
  public QCirclePolymorphicLikePopWindow(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = new WeakReference(paramActivity);
    paramActivity = (Context)this.mActivity.get();
    if (paramActivity != null) {
      this.mContainerView = LayoutInflater.from(paramActivity).inflate(2131560937, null);
    }
    this.E = ((LinearLayout)this.mContainerView.findViewById(2131374563));
    this.mi = ((ImageView)this.mContainerView.findViewById(2131374558));
    setContentView(this.mContainerView);
    setOutsideTouchable(true);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(0));
  }
  
  private void a(a parama, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    try
    {
      parama.a().setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(((Integer)eZ.get(paramStPolyLike.polyLikeID.get())).intValue()));
      if (ozq.a().eM(paramStPolyLike.polySource.get()))
      {
        paramStPolyLike = ozq.a().aY(paramStPolyLike.polySource.get());
        b(parama.a(), paramStPolyLike);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
        }
      }
      pgj localpgj = new pgj(this, parama);
      this.fb.put(Integer.valueOf(parama.hashCode()), localpgj);
      ozq.a().a(paramStPolyLike.polySource.get(), localpgj);
    }
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    Object localObject2 = (a)this.fa.get(paramStPolyLike.polyLikeID.get());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new a((Activity)this.mActivity.get());
      this.fa.put(paramStPolyLike.polyLikeID.get(), localObject1);
    }
    ((a)localObject1).a(this.mFeed, paramStPolyLike, paramInt);
    localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.E.addView(a.a((a)localObject1), (ViewGroup.LayoutParams)localObject2);
    a((a)localObject1, paramStPolyLike);
    localObject2 = ((a)localObject1).a();
    a.a((a)localObject1).setOnClickListener(new pgg(this, paramStPolyLike, (AnimationView)localObject2, (a)localObject1));
  }
  
  private void b(AnimationView paramAnimationView, String paramString)
  {
    if ((paramAnimationView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramAnimationView.getAnimationFromInfo() != null) {
        paramAnimationView.play();
      }
    }
    else {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new LoadGifRunnable(this, paramAnimationView, paramString));
  }
  
  private void bkE()
  {
    if (this.lF != null) {
      if (this.lF.size() <= biA) {
        break label66;
      }
    }
    label66:
    for (int i = biA;; i = this.lF.size())
    {
      this.mItems = i;
      this.biB = (biz * this.mItems + ankt.dip2px(32.0F));
      setWidth(this.biB);
      setHeight(biy);
      return;
    }
  }
  
  public void a(View paramView1, View paramView2, boolean paramBoolean1, QCirclePolymorphicAniView paramQCirclePolymorphicAniView, FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList, ReportExtraTypeInfo paramReportExtraTypeInfo, boolean paramBoolean2)
  {
    this.cK = new WeakReference(paramView1);
    this.cL = new WeakReference(paramQCirclePolymorphicAniView);
    this.cM = new WeakReference(paramView2);
    this.mFeed = paramStFeed;
    this.azU = paramBoolean1;
    this.lF = paramList;
    this.b = paramReportExtraTypeInfo;
    this.azX = paramBoolean2;
    bkE();
  }
  
  public void a(QCirclePolyLikeFrameLayout.a parama)
  {
    this.a = parama;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    int j = 36;
    int i = 2;
    if (!jqi.isNetworkAvailable(this.mContainerView.getContext())) {
      QQToast.a(this.mContainerView.getContext(), acfp.m(2131696276), 0).show();
    }
    while (!this.azV) {
      return;
    }
    for (;;)
    {
      try
      {
        QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
        localStLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
        QQCircleFeedBase.StPolyLike localStPolyLike = localStLikeBusiData.curPolyLikeInfo;
        this.azW = false;
        QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData;
        if (paramStPolyLike.polyLikeID.get().equals(localStPolyLike.polyLikeID.get()))
        {
          a(true, false, paramStFeed, 0, localStPolyLike, new QQCircleFeedBase.StPolyLike());
          this.azW = true;
          i = 0;
          this.azV = false;
          QLog.d("QCirclePraise_", 4, "start zan id :" + paramStPolyLike.polyLikeID.get());
          FeedCloudMeta.StLike localStLike = ovd.a(paramStFeed.likeInfo);
          localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
          localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(localStLikeBusiData.curPolyLikeInfo);
          if (i == 0)
          {
            localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(new QQCircleFeedBase.StPolyLike());
            VSNetworkHelper.a().a(new QCircleDoLikeRequest(paramStFeed, i, localStLike, localStDoLikeReqDoPolyLikeBusiReqData), new pgi(this, paramStFeed, i, localStPolyLike, paramStPolyLike));
            if (i != 0) {
              continue;
            }
            if (!pcr.a().ez(57)) {
              continue;
            }
            pcp.b(39, 2, this.b);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(localStPolyLike.polyLikeID.get())) {
            continue;
          }
          i = 1;
          continue;
        }
        localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(paramStPolyLike);
        continue;
        pcl.a(39, 2, this.b);
        return;
        if (i == 1)
        {
          if (pcr.a().ez(57))
          {
            if (this.azX)
            {
              i = j;
              pcp.b(i, 2, this.b);
              rwv.a().a(new QCircleFuelAnimationEvent());
            }
          }
          else
          {
            if (!this.azX) {
              break label433;
            }
            i = 36;
            pcl.a(i, 2, this.b);
            continue;
          }
        }
        else
        {
          if (pcr.a().ez(57))
          {
            pcp.b(40, 2, this.b);
            return;
          }
          pcl.a(40, 2, this.b);
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        return;
      }
      i = 38;
      continue;
      label433:
      i = 38;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    int j = paramStFeed.likeInfo.count.get();
    int i;
    if (paramInt == 1) {
      i = j + 1;
    }
    for (;;)
    {
      paramStFeed.likeInfo.count.set(i);
      paramStFeed.likeInfo.status.set(paramInt);
      if (paramInt != 0) {
        break;
      }
      rwv.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, new QQCircleFeedBase.StPolyLike(), paramInt, i));
      return;
      i = j;
      if (paramInt == 0) {
        i = j - 1;
      }
    }
    rwv.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, i));
  }
  
  public void bkF()
  {
    int j = 0;
    label224:
    for (;;)
    {
      try
      {
        if (this.cK.get() == null) {
          break;
        }
        int[] arrayOfInt = new int[2];
        ((View)this.cK.get()).getLocationInWindow(arrayOfInt);
        setAnimationStyle(2131756539);
        int i;
        if (arrayOfInt[1] > biy + ankt.dip2px(60.0F) + ScreenUtils.getStatusBarHeight(this.mContainerView.getContext()))
        {
          setAnimationStyle(2131756539);
          i = arrayOfInt[1] - biy;
          if (!this.azU) {
            break label224;
          }
          i -= ankt.dip2px(5.0F);
          showAtLocation((View)this.cK.get(), 0, (ankt.SCREEN_WIDTH - this.biB) / 2, i);
          this.E.removeAllViews();
          i = j;
          if (i < this.mItems)
          {
            a((QQCircleFeedBase.StPolyLike)this.lF.get(i), i);
            i += 1;
            continue;
          }
        }
        else
        {
          setAnimationStyle(2131756538);
          i = arrayOfInt[1];
          i = ((View)this.cK.get()).getHeight() + i;
          continue;
        }
        if (rze.Mp())
        {
          this.mi.setVisibility(0);
          return;
        }
        this.mi.setVisibility(8);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    Iterator localIterator = this.fa.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (a)this.fa.get(localObject);
      if ((localObject != null) && (((a)localObject).a() != null) && (((a)localObject).a().getAnimationFromInfo() != null)) {
        ((a)localObject).a().pause();
      }
    }
  }
  
  public static class LoadGifRunnable
    implements Runnable
  {
    private WeakReference<AnimationView> cN;
    private WeakReference<String> cO;
    private WeakReference<QCirclePolymorphicLikePopWindow> cP;
    
    public LoadGifRunnable(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, AnimationView paramAnimationView, String paramString)
    {
      this.cP = new WeakReference(paramQCirclePolymorphicLikePopWindow);
      this.cN = new WeakReference(paramAnimationView);
      this.cO = new WeakReference(paramString);
    }
    
    public void run()
    {
      Object localObject = (String)this.cO.get();
      AnimationView localAnimationView = (AnimationView)this.cN.get();
      localObject = AnimationView.AnimationInfo.loadFromFolder((String)localObject);
      if (localObject != null)
      {
        ((AnimationView.AnimationInfo)localObject).mInterval = 50;
        ((AnimationView.AnimationInfo)localObject).mCycle = 2147483647;
        localAnimationView.post(new QCirclePolymorphicLikePopWindow.LoadGifRunnable.1(this, localAnimationView, (AnimationView.AnimationInfo)localObject));
      }
    }
  }
  
  public static class a
  {
    private QQCircleFeedBase.StPolyLike e;
    private AnimationView mAnimationView;
    private FeedCloudMeta.StFeed mFeed;
    private int mIndex;
    private View mItemView;
    
    public a(Activity paramActivity)
    {
      this.mItemView = LayoutInflater.from(paramActivity).inflate(2131560936, null);
      this.mAnimationView = ((AnimationView)this.mItemView.findViewById(2131374562));
    }
    
    public AnimationView a()
    {
      return this.mAnimationView;
    }
    
    public QQCircleFeedBase.StPolyLike a()
    {
      return this.e;
    }
    
    public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
    {
      this.mFeed = paramStFeed;
      this.e = paramStPolyLike;
      this.mIndex = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow
 * JD-Core Version:    0.7.0.1
 */