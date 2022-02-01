import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller.1;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class pdd
  extends pcz
{
  private static boolean azp = true;
  private String asA = "";
  private Set<RecyclerView.ViewHolder> ay = new HashSet();
  private boolean azq;
  private ReportExtraTypeInfo b;
  private int bhm;
  private int bhn;
  private Runnable di = new QCircleFeedPlayerScroller.1(this);
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  private HashMap<String, Long> mPositionMap = new HashMap();
  
  public pdd()
  {
    this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  }
  
  private boolean E(View paramView)
  {
    if (!QzoneConfig.isQQCircleAutoPlay())
    {
      QLog.d("QCircleFeedPlayerHelper", 4, "not wifi autoPlay return");
      return true;
    }
    if ((paramView instanceof QCircleFeedWidget))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((QCircleFeedWidget)paramView).getData();
      if (localStFeed.type.get() == 3)
      {
        Object localObject = ((QCircleFeedWidget)paramView).a().aD;
        if (D((View)localObject))
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if ((localObject instanceof QCircleFeedCleanPlayView))
          {
            localObject = (QCircleFeedCleanPlayView)localObject;
            if (((QCircleFeedCleanPlayView)localObject).isPausing())
            {
              if (!this.asA.equals(a(localStFeed))) {
                break label151;
              }
              ((QCircleFeedCleanPlayView)localObject).setIsAutoPlay(true);
              ((QCircleFeedCleanPlayView)localObject).start();
              ((QCircleFeedCleanPlayView)localObject).setOutPutMute(azp);
              a(((QCircleFeedWidget)paramView).a(), false);
              pcl.a(8, 4, a(localStFeed.id.get()));
            }
          }
          for (;;)
          {
            return true;
            label151:
            a(((QCircleFeedWidget)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
            continue;
            a(((QCircleFeedWidget)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
          }
        }
      }
    }
    return false;
  }
  
  private boolean HO()
  {
    return (this.mExtraTypeInfo == null) || (this.mExtraTypeInfo.pageType != 9);
  }
  
  private RecyclerView.ViewHolder a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.ay.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if (paramString.equals(a(a(localViewHolder)))) {
        return localViewHolder;
      }
    }
    return null;
  }
  
  private FrameLayout a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof QCircleFeedWidget)) && (((QCircleFeedWidget)paramViewHolder.itemView).a() != null)) {
      return ((QCircleFeedWidget)paramViewHolder.itemView).a().aD;
    }
    return null;
  }
  
  private ReportExtraTypeInfo a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString.itemView instanceof QCircleFeedWidget)))
    {
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramString.itemView).getData());
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = ((QCircleFeedWidget)paramString.itemView).getPosition();
    }
    return this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  }
  
  private QCircleFeedCleanPlayView a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && ((paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))) {
      return (QCircleFeedCleanPlayView)paramFrameLayout.getChildAt(0);
    }
    return null;
  }
  
  private QCircleFeedCleanPlayView a(String paramString)
  {
    return a(a(a(paramString)));
  }
  
  private FeedCloudMeta.StFeed a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).getData() instanceof FeedCloudMeta.StFeed))) {
      return (FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).getData();
    }
    return null;
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (paramStFeed.isRecomFd.get()) {
        return paramStFeed.recomForward.id.get();
      }
      return paramStFeed.id.get();
    }
    return null;
  }
  
  private pie a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof QCircleFeedWidget)) && (((QCircleFeedWidget)paramViewHolder.itemView).a() != null)) {
      return ((QCircleFeedWidget)paramViewHolder.itemView).a();
    }
    return null;
  }
  
  private void a(FrameLayout paramFrameLayout, String paramString, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramFrameLayout != null) {
      while ((paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))
      {
        View localView = paramFrameLayout.getChildAt(0);
        paramFrameLayout.removeView(localView);
        if (((QCircleFeedCleanPlayView)localView).isPlaying())
        {
          ((QCircleFeedCleanPlayView)localView).pause();
          pcl.a(8, 5, a(paramString));
        }
        QLog.d("QCircleFeedPlayerHelper", 4, new Object[] { "clean player", paramString });
        ((QCircleFeedCleanPlayView)localView).release();
        a(a(paramViewHolder), true);
      }
    }
  }
  
  private void a(pie parampie, String paramString1, String paramString2)
  {
    if (this.mRecyclerView != null)
    {
      if (!jqi.isNetworkAvailable(BaseApplicationImpl.context))
      {
        arxa.a().showToast(acfp.m(2131715070));
        QLog.d("QCircleFeedPlayerHelper", 4, "network not available");
      }
      while (!eR(paramString2)) {
        return;
      }
      String str = ad(paramString1, "vid");
      FrameLayout localFrameLayout = parampie.aD;
      FeedCloudMeta.StFeed localStFeed = parampie.b();
      if ((!TextUtils.isEmpty(paramString1)) && (localFrameLayout != null) && (localStFeed != null))
      {
        a(localFrameLayout, paramString2, a(paramString2));
        QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = new QCircleFeedCleanPlayView(this.mContext, parampie.getPos());
        localQCircleFeedCleanPlayView.setVideoCover(parampie.W);
        localQCircleFeedCleanPlayView.setLoopBack(true);
        localQCircleFeedCleanPlayView.setOutPutMute(azp);
        localQCircleFeedCleanPlayView.setData(localStFeed);
        int j = 0;
        Long localLong = (Long)this.mPositionMap.get(paramString1);
        int i = j;
        if (localLong != null)
        {
          i = j;
          if (localLong.longValue() > 0L)
          {
            i = (int)localLong.longValue();
            QLog.d("QCircleFeedPlayerHelper", 4, "playInner seekTo: " + localLong);
          }
        }
        localQCircleFeedCleanPlayView.setBaseVideoViewListenerSets(new pde(this, parampie, localQCircleFeedCleanPlayView, paramString2, paramString1));
        if (TextUtils.isEmpty(str)) {
          str = localStFeed.video.fileId.get();
        }
        for (;;)
        {
          localQCircleFeedCleanPlayView.setVideoPath(str, paramString1, i);
          localFrameLayout.addView(localQCircleFeedCleanPlayView, 0, new FrameLayout.LayoutParams(-1, -1));
          this.asA = paramString2;
          m(parampie.mt);
          bjG();
          QLog.d("QCircleFeedPlayerHelper", 4, "playInner mCurrentPlayerUrl: " + this.asA);
          return;
        }
      }
      QLog.d("QCircleFeedPlayerHelper", 4, "vid is empty");
      return;
    }
    QLog.d("QCircleFeedPlayerHelper", 4, "url is empty");
  }
  
  private void a(pie parampie, boolean paramBoolean)
  {
    if (parampie != null)
    {
      if (!paramBoolean) {
        break label52;
      }
      if (QzoneConfig.isQQCircleAutoPlay()) {
        break label40;
      }
      parampie.ms.setVisibility(0);
    }
    for (;;)
    {
      parampie.W.setVisibility(0);
      parampie.mt.setVisibility(8);
      return;
      label40:
      parampie.ms.setVisibility(8);
    }
    label52:
    parampie.ms.setVisibility(8);
    parampie.W.setVisibility(8);
    parampie.mt.setVisibility(0);
  }
  
  private boolean a(RecyclerView.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).getData() instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).getData()).type.get() == 3);
  }
  
  private void azl()
  {
    try
    {
      rxy localrxy;
      Object localObject;
      int i;
      int j;
      if ((this.mRecyclerView != null) && ((this.mRecyclerView.getLayoutManager() instanceof rxy)))
      {
        localrxy = (rxy)this.mRecyclerView.getLayoutManager();
        localObject = localrxy.findFirstVisibleItemPositions(null);
        int[] arrayOfInt = localrxy.findLastVisibleItemPositions(null);
        i = localObject[0];
        j = arrayOfInt[0];
        QLog.d("QCircleFeedPlayerHelper", 4, i + "  " + j);
        if (i > j) {}
      }
      for (;;)
      {
        if (i <= j)
        {
          localObject = localrxy.findViewByPosition(i);
          if ((localObject != null) && (E((View)localObject))) {
            this.bhn = i;
          }
        }
        else
        {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bjF()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.asA);
    if ((localQCircleFeedCleanPlayView != null) && (!D(localQCircleFeedCleanPlayView)))
    {
      if (localQCircleFeedCleanPlayView.isPlaying())
      {
        localQCircleFeedCleanPlayView.pause();
        pcl.a(8, 5, a(this.asA));
      }
      a(a(a(this.asA)), true);
    }
  }
  
  private void bjG()
  {
    RecyclerView.ViewHolder localViewHolder1 = a(this.asA);
    Iterator localIterator = this.ay.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)localIterator.next();
      if (localViewHolder2 != localViewHolder1)
      {
        FeedCloudMeta.StFeed localStFeed = a(localViewHolder2);
        if ((localStFeed != null) && (!this.asA.equals(a(localStFeed)))) {
          a(a(localViewHolder2), a(localStFeed), localViewHolder2);
        }
      }
    }
  }
  
  private boolean eR(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qcircle_fakeid_")))
    {
      int i = oum.b(paramString).intValue();
      if ((i == 2) || (i == 5))
      {
        QLog.d("QCircleFeedPlayerHelper", 1, "FAKE FEED IS READY");
        return true;
      }
      QLog.d("QCircleFeedPlayerHelper", 1, "FAKE FEED NOT READY");
      return false;
    }
    QLog.d("QCircleFeedPlayerHelper", 1, "NOT FAKE FEED CAN PLAY");
    return true;
  }
  
  public static void flush()
  {
    azp = true;
  }
  
  private void m(ImageView paramImageView)
  {
    if (paramImageView != null) {
      if (!azp) {
        break label20;
      }
    }
    label20:
    for (int i = 2130844802;; i = 2130844803)
    {
      paramImageView.setImageResource(i);
      return;
    }
  }
  
  private void qA(String paramString)
  {
    RecyclerView.ViewHolder localViewHolder = a(paramString);
    FrameLayout localFrameLayout = a(localViewHolder);
    if (localFrameLayout != null) {
      while ((localFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))
      {
        View localView = localFrameLayout.getChildAt(0);
        localFrameLayout.removeView(localView);
        if (((QCircleFeedCleanPlayView)localView).isPlaying())
        {
          ((QCircleFeedCleanPlayView)localView).pause();
          pcl.a(8, 5, a(paramString));
        }
        ((QCircleFeedCleanPlayView)localView).release();
        a(a(localViewHolder), true);
      }
    }
  }
  
  private void rp(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.azq)
      {
        this.mMainHandler.removeCallbacks(this.di);
        this.mMainHandler.postDelayed(this.di, 500L);
        this.azq = true;
      }
      return;
    }
    this.mMainHandler.removeCallbacks(this.di);
  }
  
  public void I(String paramString, long paramLong)
  {
    if ((this.mPositionMap != null) && (this.mPositionMap.containsKey(paramString))) {
      this.mPositionMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).b(this);
      }
      if (paramStFeed != null)
      {
        paramStFeed = a(paramStFeed);
        if (a(this.asA) != paramViewHolder) {
          break label95;
        }
        paramStFeed = a(a(paramViewHolder));
        if ((paramStFeed != null) && (paramStFeed.isPlaying()))
        {
          if (paramStFeed.a() != null) {
            paramStFeed.a().setVisibility(8);
          }
          a(a(paramViewHolder), false);
        }
      }
    }
    return;
    label95:
    this.ay.add(paramViewHolder);
    a(a(paramViewHolder), paramStFeed, paramViewHolder);
    QLog.d("QCircleFeedPlayerHelper", 4, "onDataBind" + paramViewHolder.getAdapterPosition());
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    bjF();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, rxy paramrxy, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0)
    {
      this.jdField_b_of_type_Pdg.bjJ();
      azl();
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, ImageView paramImageView, int paramInt)
  {
    Object localObject;
    boolean bool;
    label66:
    ArrayList localArrayList;
    if (paramStFeed != null)
    {
      localObject = a(a(paramStFeed));
      if (localObject != null)
      {
        if (((QCircleFeedCleanPlayView)localObject).Mm()) {
          break label183;
        }
        bool = true;
        azp = bool;
        ((QCircleFeedCleanPlayView)localObject).setOutPutMute(azp);
        localObject = paramStFeed.poster.id.get();
        if (!azp) {
          break label189;
        }
        i = 9;
        pcl.a((String)localObject, 8, i, paramInt, paramStFeed, null);
        localArrayList = new ArrayList();
        localArrayList.add(pcr.a("ext2", paramStFeed.recomInfo.recomReason.get()));
        if (!pcr.a().ez(1)) {
          break label196;
        }
        localObject = "1";
        label126:
        localArrayList.add(pcr.a("ext4", (String)localObject));
        localObject = paramStFeed.poster.id.get();
        if (!azp) {
          break label204;
        }
      }
    }
    label183:
    label189:
    label196:
    label204:
    for (int i = 9;; i = 8)
    {
      pcl.a((String)localObject, 8, i, paramInt, paramStFeed, localArrayList);
      m(paramImageView);
      return;
      bool = false;
      break;
      i = 8;
      break label66;
      localObject = "2";
      break label126;
    }
  }
  
  public void a(pie parampie, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      String str = paramStFeed.video.playUrl.get();
      if (!TextUtils.isEmpty(str)) {
        a(parampie, str, a(paramStFeed));
      }
    }
  }
  
  public String ad(String paramString1, String paramString2)
  {
    String str = "";
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("&");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString1 = str;
      if (i < j)
      {
        paramString1 = arrayOfString[i];
        if (paramString1.contains(paramString2)) {
          paramString1 = paramString1.replace(paramString2 + "=", "");
        }
      }
      else
      {
        return paramString1;
      }
      i += 1;
    }
  }
  
  public void bhT()
  {
    this.bhm = -1;
    onPause();
  }
  
  public void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    azl();
  }
  
  public long dw()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.asA);
    if ((localQCircleFeedCleanPlayView != null) && (localQCircleFeedCleanPlayView.a() != null)) {
      return localQCircleFeedCleanPlayView.a().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void onDestroy()
  {
    this.asA = "";
    bjG();
    this.ay.clear();
    this.mPositionMap.clear();
    this.mMainHandler.removeCallbacks(this.di);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.bhm = paramInt;
    onResumed();
    if (!HO()) {
      rp(true);
    }
  }
  
  public void onPause()
  {
    rp(false);
    RecyclerView.ViewHolder localViewHolder = a(this.asA);
    Object localObject = a(localViewHolder);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getChildAt(0);
      if (((localObject instanceof QCircleFeedCleanPlayView)) && (((QCircleFeedCleanPlayView)localObject).isPlaying()))
      {
        ((QCircleFeedCleanPlayView)localObject).pause();
        pcl.a(8, 5, a(this.asA));
        QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
      }
    }
  }
  
  public void onResumed()
  {
    if (this.bhm == -1) {}
    RecyclerView.ViewHolder localViewHolder;
    View localView;
    do
    {
      do
      {
        return;
        localViewHolder = a(this.asA);
        localObject = a(localViewHolder);
      } while ((localObject == null) || (!(((FrameLayout)localObject).getChildAt(0) instanceof QCircleFeedCleanPlayView)) || (!D(((FrameLayout)localObject).getChildAt(0))));
      localView = ((FrameLayout)localObject).getChildAt(0);
    } while ((((QCircleFeedCleanPlayView)localView).isPlaying()) || (a(localViewHolder) == null));
    Object localObject = a(localViewHolder);
    if ((localObject != null) && (((FeedCloudMeta.StFeed)localObject).type.get() == 3))
    {
      localObject = ((FeedCloudMeta.StFeed)localObject).video.playUrl.get();
      if (!this.mPositionMap.containsKey(localObject)) {}
    }
    for (localObject = (Long)this.mPositionMap.get(localObject);; localObject = null)
    {
      if (localObject != null) {
        ((QCircleFeedCleanPlayView)localView).seek(((Long)localObject).longValue());
      }
      ((QCircleFeedCleanPlayView)localView).start();
      ((QCircleFeedCleanPlayView)localView).setOutPutMute(azp);
      m(a(localViewHolder).mt);
      pcl.a(8, 4, a(this.asA));
      QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
      return;
    }
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).b(this);
      }
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      this.ay.add(paramViewHolder);
      a(a(paramViewHolder), a(localStFeed), paramViewHolder);
      QLog.d("QCircleFeedPlayerHelper", 4, "bind position:" + paramViewHolder.getAdapterPosition());
      if (HO()) {
        rp(true);
      }
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      if (localStFeed != null)
      {
        qA(a(localStFeed));
        if (this.asA.equals(a(localStFeed))) {
          this.asA = "";
        }
        QLog.d("QCircleFeedPlayerHelper", 4, "unbind view position:" + paramViewHolder.getAdapterPosition());
      }
    }
  }
  
  public int sd()
  {
    return this.bhn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdd
 * JD-Core Version:    0.7.0.1
 */