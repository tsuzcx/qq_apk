import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller.1;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class vup
  extends vui
{
  private static boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private Runnable jdField_a_of_type_JavaLangRunnable = new QCircleFeedPlayerScroller.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  
  public vup(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private RecyclerView.ViewHolder a(String paramString)
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "fetchHolder" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
    if (paramViewHolder != null)
    {
      if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((QCircleInsFeedItemView)paramViewHolder.itemView).a() != null)) {
        return ((QCircleInsFeedItemView)paramViewHolder.itemView).a().jdField_a_of_type_AndroidWidgetFrameLayout;
      }
      if (((paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && (((QCircleTimeLineFeedItemView)paramViewHolder.itemView).a() != null)) {
        return ((QCircleTimeLineFeedItemView)paramViewHolder.itemView).a().jdField_a_of_type_AndroidWidgetFrameLayout;
      }
    }
    return null;
  }
  
  private ReportExtraTypeInfo a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString.itemView instanceof QCircleInsFeedItemView)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramString.itemView).a());
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = ((QCircleInsFeedItemView)paramString.itemView).b();
    }
    return this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
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
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed))) {
      return (FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).a();
    }
    return null;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt2 > paramInt1)) {
      return "";
    }
    return new SimpleDateFormat("mm:ss").format(Integer.valueOf(paramInt1 - paramInt2));
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
  
  private String a(String paramString)
  {
    paramString = uyn.a(paramString);
    if (paramString != null) {
      return paramString.video.playUrl.get();
    }
    return "";
  }
  
  private wcz a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (((paramViewHolder.itemView instanceof QCircleInsFeedItemView)) && (((QCircleInsFeedItemView)paramViewHolder.itemView).a() != null)) {
        return ((QCircleInsFeedItemView)paramViewHolder.itemView).a();
      }
      if (((paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && (((QCircleTimeLineFeedItemView)paramViewHolder.itemView).a() != null)) {
        return ((QCircleTimeLineFeedItemView)paramViewHolder.itemView).a();
      }
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
        if (((QCircleFeedCleanPlayView)localView).b())
        {
          ((QCircleFeedCleanPlayView)localView).c();
          vtn.a(8, 5, a(paramString), this.jdField_b_of_type_Int);
        }
        QLog.d("QCircleFeedPlayerHelper", 4, new Object[] { "clean player", paramString });
        ((QCircleFeedCleanPlayView)localView).b();
        a(a(paramViewHolder), true);
      }
    }
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      if (!jdField_a_of_type_Boolean) {
        break label20;
      }
    }
    label20:
    for (int i = 2130843996;; i = 2130843999)
    {
      paramImageView.setImageResource(i);
      return;
    }
  }
  
  private void a(String paramString)
  {
    RecyclerView.ViewHolder localViewHolder = a(paramString);
    FrameLayout localFrameLayout = a(localViewHolder);
    if (localFrameLayout != null) {
      while ((localFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))
      {
        View localView = localFrameLayout.getChildAt(0);
        localFrameLayout.removeView(localView);
        if (((QCircleFeedCleanPlayView)localView).b())
        {
          ((QCircleFeedCleanPlayView)localView).c();
          vtn.a(8, 5, a(paramString), this.jdField_b_of_type_Int);
        }
        ((QCircleFeedCleanPlayView)localView).b();
        a(a(localViewHolder), true);
      }
    }
  }
  
  private void a(wcz paramwcz)
  {
    if (paramwcz.jdField_a_of_type_AndroidWidgetSeekBar != null) {
      paramwcz.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void a(wcz paramwcz, String paramString)
  {
    if (paramwcz.jdField_a_of_type_AndroidWidgetTextView != null) {
      paramwcz.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void a(wcz paramwcz, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (!nny.a(BaseApplicationImpl.context))
      {
        bjuh.a().a(anzj.a(2131713454));
        QLog.d("QCircleFeedPlayerHelper", 4, "network not available");
      }
      while (!a(paramString2)) {
        return;
      }
      Object localObject = a(paramString2);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.d("QCircleFeedPlayerHelper", 4, "has local cache, feed play local url: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString1 = (String)localObject;
      }
      for (;;)
      {
        a(paramString1, "vid");
        localObject = paramwcz.jdField_a_of_type_AndroidWidgetFrameLayout;
        FeedCloudMeta.StFeed localStFeed = paramwcz.a();
        if ((TextUtils.isEmpty(paramString1)) || (localObject == null) || (localStFeed == null)) {
          break;
        }
        a((FrameLayout)localObject, paramString2, a(paramString2));
        QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = new QCircleFeedCleanPlayView(this.jdField_a_of_type_AndroidContentContext, paramwcz.a());
        localQCircleFeedCleanPlayView.setReportBean(new QCircleReportBean().setPageId(this.jdField_b_of_type_Int));
        localQCircleFeedCleanPlayView.setVideoCover(paramwcz.jdField_a_of_type_ComTencentImageURLImageView);
        localQCircleFeedCleanPlayView.setLoopBack(true);
        localQCircleFeedCleanPlayView.setOutPutMute(b());
        localQCircleFeedCleanPlayView.setData(localStFeed);
        localQCircleFeedCleanPlayView.setLoadingView(paramwcz.jdField_b_of_type_AndroidViewView);
        localQCircleFeedCleanPlayView.setBaseVideoViewListenerSets(new vuq(this, paramwcz, localQCircleFeedCleanPlayView, paramString2, paramString1));
        localQCircleFeedCleanPlayView.setProgressBar(paramwcz.jdField_a_of_type_AndroidWidgetSeekBar);
        a(paramwcz);
        localQCircleFeedCleanPlayView.setVideoPath(localStFeed.video, this.jdField_c_of_type_Int);
        this.jdField_c_of_type_Int = 0;
        ((FrameLayout)localObject).addView(localQCircleFeedCleanPlayView, 0, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_JavaLangString = paramString2;
        a(paramwcz.jdField_b_of_type_AndroidWidgetImageView);
        l();
        QLog.d("QCircleFeedPlayerHelper", 4, "playInner mCurrentPlayerFeedId: " + this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.d("QCircleFeedPlayerHelper", 4, "vid is empty");
      return;
    }
    QLog.d("QCircleFeedPlayerHelper", 4, "url is empty");
  }
  
  private void a(wcz paramwcz, boolean paramBoolean)
  {
    int j = 8;
    if (paramwcz != null)
    {
      if (paramwcz.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if ((!paramBoolean) || (!a(paramwcz))) {
          break label111;
        }
        paramwcz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      Object localObject;
      if (paramwcz.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramwcz.jdField_a_of_type_ComTencentImageURLImageView;
        if (!paramBoolean) {
          break label123;
        }
        i = 0;
        label54:
        ((URLImageView)localObject).setVisibility(i);
      }
      if (paramwcz.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramwcz.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label129;
        }
        i = 8;
        label80:
        ((TextView)localObject).setVisibility(i);
      }
      if (paramwcz.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        paramwcz = paramwcz.jdField_b_of_type_AndroidWidgetImageView;
        if (!paramBoolean) {
          break label134;
        }
      }
    }
    label129:
    label134:
    for (int i = j;; i = 0)
    {
      paramwcz.setVisibility(i);
      return;
      label111:
      paramwcz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label123:
      i = 8;
      break label54;
      i = 0;
      break label80;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == this.jdField_b_of_type_Int;
  }
  
  private boolean a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null) {
      return d(paramViewHolder.itemView);
    }
    return false;
  }
  
  private boolean a(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramQCircleTimeLineFeedItemView.a();
    if (localStFeed.type.get() == 3)
    {
      Object localObject = paramQCircleTimeLineFeedItemView.a().jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(0);
      if ((localObject instanceof QCircleFeedCleanPlayView))
      {
        localObject = (QCircleFeedCleanPlayView)localObject;
        if (((QCircleFeedCleanPlayView)localObject).c()) {
          if (this.jdField_a_of_type_JavaLangString.equals(a(localStFeed)))
          {
            ((QCircleFeedCleanPlayView)localObject).setIsAutoPlay(true);
            ((QCircleFeedCleanPlayView)localObject).d();
            ((QCircleFeedCleanPlayView)localObject).setOutPutMute(b());
            a(paramQCircleTimeLineFeedItemView.a(), false);
            QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView is isPausing reStart");
          }
        }
      }
      for (;;)
      {
        return true;
        QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView data change reCreate");
        a(paramQCircleTimeLineFeedItemView.a(), localStFeed.video.playUrl.get(), a(localStFeed));
        continue;
        QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView is playing do nothing");
        continue;
        QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine playerView first");
        a(paramQCircleTimeLineFeedItemView.a(), localStFeed.video.playUrl.get(), a(localStFeed));
      }
    }
    QLog.d("QCircleFeedPlayerHelper", 1, "autoPlayInTimeLine is not video type");
    return false;
  }
  
  private boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("qcircle_fakeid_")))
    {
      int i = uyn.a(paramString).intValue();
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
  
  private boolean a(wcz paramwcz)
  {
    if ((paramwcz instanceof wdz)) {
      if (QzoneConfig.isQQCircleAutoPlay()) {}
    }
    while (!(paramwcz instanceof wec))
    {
      return true;
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return jdField_a_of_type_Boolean;
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  private boolean c(View paramView)
  {
    if (!QzoneConfig.isQQCircleAutoPlay())
    {
      QLog.d("QCircleFeedPlayerHelper", 4, "not wifi autoPlay return");
      return true;
    }
    if ((paramView instanceof QCircleInsFeedItemView))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((QCircleInsFeedItemView)paramView).a();
      if (localStFeed.type.get() == 3)
      {
        Object localObject = ((QCircleInsFeedItemView)paramView).a().jdField_a_of_type_AndroidWidgetFrameLayout;
        if (a((View)localObject))
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if ((localObject instanceof QCircleFeedCleanPlayView))
          {
            localObject = (QCircleFeedCleanPlayView)localObject;
            if (((QCircleFeedCleanPlayView)localObject).c())
            {
              if (!this.jdField_a_of_type_JavaLangString.equals(a(localStFeed))) {
                break label157;
              }
              ((QCircleFeedCleanPlayView)localObject).setIsAutoPlay(true);
              ((QCircleFeedCleanPlayView)localObject).d();
              ((QCircleFeedCleanPlayView)localObject).setOutPutMute(b());
              a(((QCircleInsFeedItemView)paramView).a(), false);
              vtn.a(8, 4, a(localStFeed.id.get()), this.jdField_b_of_type_Int);
            }
          }
          for (;;)
          {
            return true;
            label157:
            a(((QCircleInsFeedItemView)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
            continue;
            a(((QCircleInsFeedItemView)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
          }
        }
      }
    }
    else if ((paramView instanceof QCircleTimeLineFeedItemView))
    {
      return a((QCircleTimeLineFeedItemView)paramView);
    }
    return false;
  }
  
  private boolean d(View paramView)
  {
    if (((paramView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramView).a() instanceof FeedCloudMeta.StFeed))) {
      return ((FeedCloudMeta.StFeed)((BaseWidgetView)paramView).a()).type.get() == 3;
    }
    return false;
  }
  
  public static void h()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private void i()
  {
    aacf localaacf = (aacf)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    Object localObject = localaacf.findFirstVisibleItemPositions(null);
    int[] arrayOfInt = localaacf.findLastVisibleItemPositions(null);
    int i = localObject[0];
    int j = arrayOfInt[0];
    QLog.d("QCircleFeedPlayerHelper", 4, i + "  " + j);
    if (i <= j) {}
    for (;;)
    {
      if (i <= j)
      {
        localObject = localaacf.findViewByPosition(i);
        if ((localObject != null) && (c((View)localObject))) {
          this.jdField_d_of_type_Int = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void j()
  {
    int j = 1;
    aacd localaacd = (aacd)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    if (localaacd.getSpanCount() > 1) {
      QLog.e("QCircleFeedPlayerHelper", 1, "unSupportSpanCount:" + localaacd.getSpanCount());
    }
    label277:
    for (;;)
    {
      return;
      int i = localaacd.findFirstCompletelyVisibleItemPosition();
      int k = localaacd.findLastCompletelyVisibleItemPosition();
      QLog.d("QCircleFeedPlayerHelper", 1, "firstVisibilityPos:" + i + "    lastVisibilityPos" + k);
      if (i <= k)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        label114:
        if (i <= k)
        {
          View localView = localaacd.findViewByPosition(i);
          if (d(localView))
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
            if ((b(localView)) && (c(localView))) {
              this.jdField_d_of_type_Int = i;
            }
          }
        }
        for (i = j;; i = 0)
        {
          if ((i != 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
            break label277;
          }
          i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(0)).intValue();
          if ((i == 0) && (c(localaacd.findViewByPosition(i))))
          {
            this.jdField_d_of_type_Int = i;
            return;
            i += 1;
            break label114;
          }
          i = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
          if (!c(localaacd.findViewByPosition(i))) {
            break;
          }
          this.jdField_d_of_type_Int = i;
          return;
        }
      }
    }
  }
  
  private void k()
  {
    aace localaace = (aace)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    int i = localaace.findFirstVisibleItemPosition();
    int j = localaace.findLastVisibleItemPosition();
    QLog.d("QCircleFeedPlayerHelper", 4, i + "  " + j);
    if (i <= j) {}
    for (;;)
    {
      if (i <= j)
      {
        View localView = localaace.findViewByPosition(i);
        if ((localView != null) && (c(localView))) {
          this.jdField_d_of_type_Int = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void l()
  {
    RecyclerView.ViewHolder localViewHolder1 = a(this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)localIterator.next();
      if (localViewHolder2 != localViewHolder1)
      {
        FeedCloudMeta.StFeed localStFeed = a(localViewHolder2);
        if ((localStFeed != null) && (!this.jdField_a_of_type_JavaLangString.equals(a(localStFeed)))) {
          a(a(localViewHolder2), a(localStFeed), localViewHolder2);
        }
      }
    }
  }
  
  public long a()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.jdField_a_of_type_JavaLangString);
    if ((localQCircleFeedCleanPlayView != null) && (localQCircleFeedCleanPlayView.a() != null)) {
      return localQCircleFeedCleanPlayView.a().getCurrentPositionMs();
    }
    return 0L;
  }
  
  public String a(String paramString1, String paramString2)
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
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt)
  {
    b();
    if (a()) {
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "triggerSlowScroll");
    g();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).a(this);
      }
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      this.jdField_a_of_type_JavaUtilSet.add(paramViewHolder);
      a(a(paramViewHolder), a(localStFeed), paramViewHolder);
      QLog.d("QCircleFeedPlayerHelper", 4, "bind position:" + paramViewHolder.getAdapterPosition());
      if (a()) {
        a(true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).a(this);
      }
      if (paramStFeed != null)
      {
        paramStFeed = a(paramStFeed);
        if (a(this.jdField_a_of_type_JavaLangString) != paramViewHolder) {
          break label95;
        }
        paramStFeed = a(a(paramViewHolder));
        if ((paramStFeed != null) && (paramStFeed.b()))
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
    this.jdField_a_of_type_JavaUtilSet.add(paramViewHolder);
    a(a(paramViewHolder), paramStFeed, paramViewHolder);
    QLog.d("QCircleFeedPlayerHelper", 4, "onDataBind" + paramViewHolder.getAdapterPosition());
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    f();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, RecyclerView.LayoutManager paramLayoutManager, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Vut.b();
      g();
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, ImageView paramImageView, int paramInt)
  {
    Object localObject;
    boolean bool;
    ArrayList localArrayList;
    if (paramStFeed != null)
    {
      localObject = a(a(paramStFeed));
      if (localObject != null)
      {
        if (((QCircleFeedCleanPlayView)localObject).f()) {
          break label158;
        }
        bool = true;
        jdField_a_of_type_Boolean = bool;
        ((QCircleFeedCleanPlayView)localObject).setOutPutMute(jdField_a_of_type_Boolean);
        this.jdField_d_of_type_Boolean = jdField_a_of_type_Boolean;
        localArrayList = new ArrayList();
        localArrayList.add(vtt.a("ext2", paramStFeed.recomInfo.recomReason.get()));
        if (!a(1)) {
          break label164;
        }
        localObject = "1";
        label97:
        localArrayList.add(vtt.a("ext4", (String)localObject));
        localObject = paramStFeed.poster.id.get();
        if (!jdField_a_of_type_Boolean) {
          break label172;
        }
      }
    }
    label158:
    label164:
    label172:
    for (int i = 9;; i = 8)
    {
      vtn.a((String)localObject, 8, i, paramInt, paramStFeed, localArrayList, this.jdField_b_of_type_Int);
      a(paramImageView);
      return;
      bool = false;
      break;
      localObject = "2";
      break label97;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public void a(wdz paramwdz, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      String str = paramStFeed.video.playUrl.get();
      if (!TextUtils.isEmpty(str)) {
        a(paramwdz, str, a(paramStFeed));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "useGlobalVoiceControl:" + paramBoolean1 + " isVoiceMute:" + paramBoolean2);
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  public void b()
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "onResume mCurrentPlayFeedTag" + this.jdField_a_of_type_JavaLangString);
    RecyclerView.ViewHolder localViewHolder = a(this.jdField_a_of_type_JavaLangString);
    Object localObject = a(localViewHolder);
    View localView;
    if ((localObject != null) && ((((FrameLayout)localObject).getChildAt(0) instanceof QCircleFeedCleanPlayView)) && (a(((FrameLayout)localObject).getChildAt(0))))
    {
      localView = ((FrameLayout)localObject).getChildAt(0);
      if ((!((QCircleFeedCleanPlayView)localView).b()) && (a(localViewHolder) != null))
      {
        localObject = a(localViewHolder);
        if ((localObject == null) || (((FeedCloudMeta.StFeed)localObject).type.get() != 3)) {
          break label243;
        }
        localObject = ((FeedCloudMeta.StFeed)localObject).video.playUrl.get();
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          break label243;
        }
      }
    }
    label243:
    for (localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);; localObject = null)
    {
      if (localObject != null) {
        ((QCircleFeedCleanPlayView)localView).a(((Long)localObject).longValue());
      }
      ((QCircleFeedCleanPlayView)localView).d();
      ((QCircleFeedCleanPlayView)localView).setOutPutMute(b());
      a(a(localViewHolder).jdField_b_of_type_AndroidWidgetImageView);
      vtn.a(8, 4, a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Int);
      QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
      return;
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      if (localStFeed != null)
      {
        a(a(localStFeed));
        if (this.jdField_a_of_type_JavaLangString.equals(a(localStFeed))) {
          this.jdField_a_of_type_JavaLangString = "";
        }
        QLog.d("QCircleFeedPlayerHelper", 4, "unbind view position:" + paramViewHolder.getAdapterPosition());
      }
    }
  }
  
  public void c()
  {
    a(false);
    RecyclerView.ViewHolder localViewHolder = a(this.jdField_a_of_type_JavaLangString);
    Object localObject = a(localViewHolder);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getChildAt(0);
      if (((localObject instanceof QCircleFeedCleanPlayView)) && (((QCircleFeedCleanPlayView)localObject).b()))
      {
        ((QCircleFeedCleanPlayView)localObject).c();
        vtn.a(8, 5, a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Int);
        QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void e()
  {
    QLog.d("QCircleFeedPlayerHelper", 1, "onDestroy");
    this.jdField_a_of_type_JavaLangString = "";
    l();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void f()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.jdField_a_of_type_JavaLangString);
    if ((localQCircleFeedCleanPlayView != null) && (!a(localQCircleFeedCleanPlayView)))
    {
      if (localQCircleFeedCleanPlayView.b())
      {
        QLog.d("QCircleFeedPlayerHelper", 1, "checkPause stopPlay" + this.jdField_a_of_type_JavaLangString);
        localQCircleFeedCleanPlayView.c();
        vtn.a(8, 5, a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Int);
      }
      a(a(a(this.jdField_a_of_type_JavaLangString)), true);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof aacf))
      {
        i();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof aacd))
    {
      j();
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof aace)) {
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vup
 * JD-Core Version:    0.7.0.1
 */