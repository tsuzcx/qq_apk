import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class xyi
  extends zgz<xwc>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private wvu jdField_a_of_type_Wvu;
  private xvm jdField_a_of_type_Xvm;
  private xwc jdField_a_of_type_Xwc;
  private yhc jdField_a_of_type_Yhc;
  private int b;
  
  public xyi(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(yhc paramyhc)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Xwc.a();
    d(paramyhc);
    ((ElasticImageView)paramyhc.a(2131374614)).setVisibility(8);
    Object localObject = (ElasticImageView)paramyhc.a(2131377525);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramyhc.a(2131381267);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      ykq.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyhc.a();
      ((ElasticImageView)localObject).setVisibility(0);
      ((ElasticImageView)localObject).setOnClickListener(this);
      break;
      label109:
      if (localBannerFeedItem.getOwner().isMe()) {
        a((TextView)localObject, localBannerFeedItem.mViewTotalTime, 1);
      } else {
        a((TextView)localObject, 0L, 0);
      }
    }
  }
  
  private StoryVideoItem a(@NonNull List<String> paramList)
  {
    Object localObject2 = null;
    Iterator localIterator = this.jdField_a_of_type_Xwc.a().iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (!StoryVideoItem.isFakeVid(localStoryVideoItem.mVid))
      {
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = localStoryVideoItem;
        }
        for (;;)
        {
          paramList.add(localStoryVideoItem.mVid);
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if (localObject2.mCreateTime > localStoryVideoItem.mCreateTime) {
            localObject1 = localStoryVideoItem;
          }
        }
      }
    }
    return localObject2;
  }
  
  private void a(TextView paramTextView, long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846483);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(anvx.a(2131702637), new Object[] { UIUtils.formatCount(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(anvx.a(2131702636), new Object[] { UIUtils.formatCount(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = UIUtils.parseDate(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(yhc paramyhc)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xwc.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramyhc);
    e(paramyhc);
    ElasticImageView localElasticImageView = (ElasticImageView)paramyhc.a(2131377525);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramyhc.a(2131381267);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      ykq.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyhc.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(yhc paramyhc)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xwc.a();
    d(paramyhc);
    e(paramyhc);
    Object localObject = (ElasticImageView)paramyhc.a(2131377525);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramyhc.a(2131381267);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      ykq.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyhc.a();
      ((ElasticImageView)localObject).setVisibility(0);
      ((ElasticImageView)localObject).setOnClickListener(this);
      break;
      label102:
      if (localVideoListFeedItem.getOwner().isFriend()) {
        a((TextView)localObject, 0L, 0);
      } else if (localVideoListFeedItem.getOwner().isMe()) {
        a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
      } else {
        a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 2);
      }
    }
  }
  
  private void d(yhc paramyhc)
  {
    paramyhc = (ElasticImageView)paramyhc.a(2131370082);
    if (this.jdField_a_of_type_Xwc.a.mHadLike == 1)
    {
      paramyhc.setImageResource(2130846476);
      return;
    }
    if (QQStoryContext.a())
    {
      paramyhc.setImageResource(2130846482);
      return;
    }
    paramyhc.setImageResource(2130846481);
  }
  
  private void e(yhc paramyhc)
  {
    paramyhc = (ElasticImageView)paramyhc.a(2131374614);
    if ((a(this.jdField_a_of_type_Xwc.a.date)) && (this.jdField_a_of_type_Xwc.a().size() > 1))
    {
      paramyhc.setVisibility(0);
      paramyhc.setOnClickListener(this);
      return;
    }
    paramyhc.setVisibility(8);
    paramyhc.setOnClickListener(null);
  }
  
  private void f()
  {
    ykq.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      ykq.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Wvu == null) {
      this.jdField_a_of_type_Wvu = wvu.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Xwc.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Xwc.a());
    wvu localwvu = this.jdField_a_of_type_Wvu;
    if (this.jdField_a_of_type_Xwc.a.getOwner().isMe())
    {
      str = anvx.a(2131702633);
      localObject = localwvu.a(str).a(new xyj(this)).a(new wwu(localStoryVideoItem, this.jdField_a_of_type_Xwc.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((wvu)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((wvu)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718786);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    ykq.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      ykq.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xwc.a().getOwner();
      if (this.jdField_a_of_type_Wvu == null) {
        this.jdField_a_of_type_Wvu = wvu.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Xwc.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Wvu.a(anvx.a(2131702632) + vzh.a + anvx.a(2131702634)).a(wwx.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Xwc.a().size())).a(new xyk(this, localVideoListFeedItem)).b();
    ykv.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    ykq.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Wvu == null) {
      this.jdField_a_of_type_Wvu = wvu.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Wvu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718786)).a(new xyl(this)).a(new wwt(this.jdField_a_of_type_Xwc.a())).b();
  }
  
  public void P_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xwc == null)
    {
      ykq.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramyhc.a();
    }
    if ((this.jdField_a_of_type_Xwc.d()) || (this.jdField_a_of_type_Xwc.e())) {
      return c(paramyhc);
    }
    if (this.jdField_a_of_type_Xwc.f()) {
      return b(paramyhc);
    }
    if (this.jdField_a_of_type_Xwc.g()) {
      return a(paramyhc);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Xwc.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561651, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Yhc.a(2131370082);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Yhc.a(2131364890);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Yhc.a(2131377525);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Yhc.a(2131374614);
    TextView localTextView = (TextView)this.jdField_a_of_type_Yhc.a(2131381267);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846482);
      localElasticImageView1.setImageResource(2130846475);
      localElasticImageView3.setImageResource(2130846528);
      localElasticImageView2.setImageResource(2130846814);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Yhc;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Wvu != null) {
      this.jdField_a_of_type_Wvu.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
  }
  
  public void a(xwc paramxwc, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Yhc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yhc.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370082: 
    case 2131364890: 
    case 2131374614: 
    case 2131377525: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Xwc.f())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_Xwc.a().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xqr.a((ShareGroupItem)localObject))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131702630), 1).a();
            }
          }
          else if ((xqr.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131702629), 1).a();
            continue;
          }
          if (this.jdField_a_of_type_Xvm != null)
          {
            this.jdField_a_of_type_Xvm.K_();
            continue;
            if (this.jdField_a_of_type_Xwc.f())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_Xwc.a().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xqr.a((ShareGroupItem)localObject))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131702635), 1).a();
              }
            }
            else if ((xqr.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131702631), 1).a();
              continue;
            }
            if (this.jdField_a_of_type_Xvm != null) {
              this.jdField_a_of_type_Xvm.f();
            }
          }
        }
        i = wzk.a(this.jdField_a_of_type_Int, this.b);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Xwc.a.feedId, this.jdField_a_of_type_Xwc.a.feedId, "", 1, false), i);
        xbp.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), null);
        i = ykv.b(this.jdField_a_of_type_Xwc.a);
        if ((this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_Xwc.a.getOwner().getUnionId();; localObject = "")
        {
          ykv.a("home_page", "clk_play", ykv.a(this.jdField_a_of_type_Xwc.a), 0, new String[] { String.valueOf(i), ykv.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xwc.a.feedId, localObject });
          break;
        }
      } while (UIUtils.isFastDoubleClick());
      if ((this.jdField_a_of_type_Xwc.d()) || (this.jdField_a_of_type_Xwc.e()))
      {
        f();
        label533:
        if (!(this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_Xwc.a.getOwner().getUnionId();; localObject = "")
      {
        ykv.a("home_page", "clk_share", ykv.a(this.jdField_a_of_type_Xwc.a), 0, new String[] { String.valueOf(ykv.b(this.jdField_a_of_type_Xwc.a)), ykv.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xwc.a.feedId, localObject });
        break;
        if (this.jdField_a_of_type_Xwc.f())
        {
          h();
          break label533;
        }
        if (!this.jdField_a_of_type_Xwc.g()) {
          break label533;
        }
        i();
        break label533;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xwc.a.feedId, this.jdField_a_of_type_Int);
    int i = ykv.a(this.jdField_a_of_type_Xwc.a);
    if (this.jdField_a_of_type_Xwc.a.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      ykv.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, ykv.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Xwc.a.feedId });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyi
 * JD-Core Version:    0.7.0.1
 */