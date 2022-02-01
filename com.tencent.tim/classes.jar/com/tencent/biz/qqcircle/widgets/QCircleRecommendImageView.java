package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationStateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleTaskCenterEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;
import ouy;
import ovd;
import ozo;
import ozo.a;
import ozo.b;
import pgr;
import pgs;
import pgt;
import pgu;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import rwv;
import rwx;
import sgm;
import sow;

public class QCircleRecommendImageView
  extends ImageView
  implements rwx
{
  private static boolean azZ;
  private static ozo jdField_b_of_type_Ozo = new ozo();
  private static int biK = 300;
  private static final int biL = QzoneConfig.getQQCircleMaxPushCount();
  private static final int biM = QzoneConfig.getQQCirclePushNotEnoughValue();
  private static Map<String, ozo.a> fz;
  private LongPressTimerTask jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask;
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$a;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private FeedCloudMeta.StPushList jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList;
  private boolean aAa;
  private boolean aAb;
  private boolean aAc = true;
  private QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private int biG;
  private int biH;
  private int biI;
  private int biJ;
  private FeedCloudMeta.StFeed l;
  private boolean mIsRelease;
  private int mLastMotionY;
  private int mPageType;
  private Timer mTimer;
  private long zP;
  private long zQ;
  private long zR;
  
  static
  {
    jdField_b_of_type_Ozo.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/icon_start_recommend.zip"));
    jdField_b_of_type_Ozo.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/icon_end_recommend.zip"));
    jdField_b_of_type_Ozo.a(new ozo.b("https://downv6.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip"));
  }
  
  public QCircleRecommendImageView(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public QCircleRecommendImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private QQAnimationDrawable a(String paramString)
  {
    try
    {
      if ((fz != null) && (fz.containsKey(paramString)))
      {
        paramString = (ozo.a)fz.get(paramString);
        if (paramString != null)
        {
          paramString = sgm.g(paramString.mFilePath);
          if ((paramString != null) && (paramString.length > 0))
          {
            QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
            localQQAnimationDrawable.Q(paramString);
            return localQQAnimationDrawable;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleRecommend_", 1, "getAnimationDrawable error" + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void bkI()
  {
    try
    {
      if ((this.mPageType == 1) || (this.mPageType == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130844806));
        return;
      }
      if (this.mPageType == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130844789));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend_", 1, "showRecommendView setBackgroundDrawable error");
    }
  }
  
  private void bkJ()
  {
    try
    {
      if ((this.mPageType == 1) || (this.mPageType == 3))
      {
        setBackgroundDrawable(getResources().getDrawable(2130844805));
        return;
      }
      if (this.mPageType == 2)
      {
        setBackgroundDrawable(getResources().getDrawable(2130844788));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend_", 1, "showUnRecommendView setBackgroundDrawable error");
    }
  }
  
  private void bkK()
  {
    if (this.aAc)
    {
      if (this.mPageType != 2) {
        break label29;
      }
      setBackgroundDrawable(getResources().getDrawable(2130844780));
    }
    label29:
    while ((this.mPageType != 1) && (this.mPageType != 3)) {
      return;
    }
    setBackgroundDrawable(getResources().getDrawable(2130844799));
  }
  
  private void bkL()
  {
    sow.b(QCircleDoRecommendRequest.class.getSimpleName(), biK, new pgu(this));
  }
  
  private void bkM()
  {
    ouy.a().aZ(getContext(), getContext().getResources().getString(2131700067));
  }
  
  private void bkN()
  {
    ouy.a().aZ(getContext(), getContext().getString(2131700131, new Object[] { Integer.valueOf(biL) }));
  }
  
  private void bkO()
  {
    QCircleTaskCenterEvent localQCircleTaskCenterEvent = new QCircleTaskCenterEvent(getContext().hashCode(), true);
    rwv.a().a(localQCircleTaskCenterEvent);
  }
  
  private void bkP()
  {
    bkQ();
    this.mTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask = new LongPressTimerTask(this);
    this.mTimer.schedule(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$LongPressTimerTask, biK, biK);
  }
  
  private void bkQ()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer.purge();
    }
  }
  
  private void dL(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      QLog.d("QCircleRecommend_", 1, "fuel is use up: " + paramInt2);
      ouy.a().aZ(getContext(), getContext().getString(2131700076, new Object[] { Integer.valueOf(paramInt2) }));
      bkO();
      return;
    }
    if (paramInt1 <= biM)
    {
      QLog.d("QCircleRecommend_", 1, "fuel is not enough: " + paramInt2);
      ouy.a().aZ(getContext(), getContext().getString(2131700119, new Object[] { Integer.valueOf(paramInt2) }));
      return;
    }
    QLog.d("QCircleRecommend_", 1, "fuel is enough: " + paramInt2);
    ouy.a().aZ(getContext(), getResources().getString(2131700165, new Object[] { Integer.valueOf(paramInt2) }));
  }
  
  private void qw(String paramString)
  {
    if (!NetworkUtils.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, BaseApplicationImpl.getContext().getResources().getString(2131696284), 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).show();
  }
  
  private void rA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bkI();
      return;
    }
    bkJ();
  }
  
  private void report(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$a != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$a.onClick(paramInt);
    }
  }
  
  private void rz(boolean paramBoolean)
  {
    if (!azZ)
    {
      jdField_b_of_type_Ozo.a(new pgt(this, paramBoolean));
      jdField_b_of_type_Ozo.start();
      return;
    }
    try
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.5(this, paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("QCircleRecommend_", 1, "playError " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  private void showEnd()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning())) {
      return;
    }
    if (this.mPageType == 2) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://downv6.qq.com/video_story/qcircle/animation/icon_end_recommend.zip");
    }
    while (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null)
    {
      QLog.d("QCircleRecommend_", 1, "mStartAnimationDrawable is null");
      bkL();
      return;
      if ((this.mPageType == 1) || (this.mPageType == 3))
      {
        this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://downv6.qq.com/video_story/qcircle/animation/qcircle_follow_tab_push_icon_end.zip");
      }
      else
      {
        QLog.e("QCircleRecommend_", 1, "showEnd error pageType" + this.mPageType);
        return;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.setOneShot(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.setDuration(250L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new pgs(this));
    postDelayed(new QCircleRecommendImageView.3(this), 250L);
    setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  private void showStart()
  {
    if (this.aAa) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = a("https://downv6.qq.com/video_story/qcircle/animation/icon_start_recommend.zip");
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null)
    {
      QLog.d("QCircleRecommend_", 1, "mStartAnimationDrawable is null");
      bkL();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.setOneShot(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.setDuration(480L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(new pgr(this));
    setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  public FeedCloudMeta.StFeed b()
  {
    return this.l;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.biJ = i;
        this.mLastMotionY = j;
        this.mIsRelease = false;
        this.aAb = false;
        this.zP = System.currentTimeMillis();
        if (this.biH >= biL)
        {
          bkN();
          return false;
        }
        if ((b() != null) && (ovd.a((FeedCloudMeta.StUser)b().poster.get())))
        {
          bkM();
          return false;
        }
        bkP();
        continue;
        if ((!this.aAb) && ((Math.abs(this.biJ - i) > 20) || (Math.abs(this.mLastMotionY - j) > 20)))
        {
          this.aAb = true;
          bkQ();
        }
      }
    }
    this.zQ = System.currentTimeMillis();
    bkQ();
    if ((b() != null) && (!TextUtils.isEmpty(b().id.get())) && (this.zQ - this.zP < biK) && (this.biH < biL))
    {
      this.biH += 1;
      if (this.zQ - this.zR <= biK) {
        break label328;
      }
      i = 1;
      label269:
      rz(true);
      if (i == 0) {
        break label333;
      }
      this.biI = 1;
      rwv.a().a(new QCirclePushAnimationEvent(b().id.get(), 1, 1, this.mPageType));
    }
    for (;;)
    {
      this.zR = this.zQ;
      this.mIsRelease = true;
      break;
      label328:
      i = 0;
      break label269;
      label333:
      this.biI += 1;
      rwv.a().a(new QCirclePushAnimationEvent(b().id.get(), this.biI, 2, this.mPageType));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushAnimationStateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  protected void initView()
  {
    bkJ();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent.mHashCode == hashCode()) || (this.l == null)) {
      QLog.d("QCircleRecommend_", 1, "receive event sent by self or feed is null");
    }
    for (;;)
    {
      return;
      Object localObject;
      if ((paramSimpleBaseEvent instanceof QCirclePushAnimationStateEvent))
      {
        localObject = (QCirclePushAnimationStateEvent)paramSimpleBaseEvent;
        QLog.d("QCircleRecommend_", 1, "mTargetFeedId:" + ((QCirclePushAnimationStateEvent)localObject).mTargetFeedId + "mPage" + ((QCirclePushAnimationStateEvent)localObject).mSceneType);
        if ((((QCirclePushAnimationStateEvent)localObject).mTargetFeedId.equals(this.l.id.get())) && (((QCirclePushAnimationStateEvent)localObject).mSceneType == this.mPageType)) {
          rz(false);
        }
      }
      if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
      {
        paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
        if (paramSimpleBaseEvent.mTargetFeedId.equals(this.l.id.get())) {
          localObject = new QQCircleFeedBase.StFeedBusiReqData();
        }
      }
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(this.l.busiData.get().toByteArray());
        if (((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList != null)
        {
          if (paramSimpleBaseEvent.mAllPushTimes <= 0) {
            break label280;
          }
          bool = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramSimpleBaseEvent)
      {
        for (;;)
        {
          paramSimpleBaseEvent.printStackTrace();
          return;
          boolean bool = false;
        }
      }
      catch (Exception paramSimpleBaseEvent)
      {
        QLog.e("QCircleRecommend_", 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
    }
    rA(bool);
    this.biG = paramSimpleBaseEvent.mAllPushTimes;
    this.biH = paramSimpleBaseEvent.mAllPushTimes;
    QLog.d("QCircleRecommend_", 1, "hasLikeCount" + this.biG);
    ((QQCircleFeedBase.StFeedBusiReqData)localObject).pushList.hasClickCount.set(paramSimpleBaseEvent.mAllPushTimes);
    this.l.busiData.set(ByteStringMicro.copyFrom(((QQCircleFeedBase.StFeedBusiReqData)localObject).toByteArray()));
    return;
    label280:
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    boolean bool = true;
    this.mPageType = paramInt;
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null))
    {
      this.l = paramStFeed;
      localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList = localStFeedBusiReqData.pushList;
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList != null) {
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.status.get() != 1) {
          break label170;
        }
      }
      for (;;)
      {
        rA(bool);
        this.biG = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StPushList.hasClickCount.get();
        this.biH = this.biG;
        QLog.d("QCircleRecommend_", 1, "hashCode" + hashCode() + "feedId:" + this.l.id.get() + "  hasClickCount" + this.biG);
        return;
        label170:
        bool = false;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
  
  public void setPageType(int paramInt)
  {
    this.mPageType = paramInt;
  }
  
  public void setReportListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView$a = parama;
  }
  
  static class LongPressTimerTask
    extends TimerTask
  {
    private WeakReference<QCircleRecommendImageView> H;
    
    public LongPressTimerTask(QCircleRecommendImageView paramQCircleRecommendImageView)
    {
      this.H = new WeakReference(paramQCircleRecommendImageView);
    }
    
    public void run()
    {
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.LongPressTimerTask.1(this));
    }
  }
  
  public static abstract interface a
  {
    public abstract void onClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView
 * JD-Core Version:    0.7.0.1
 */