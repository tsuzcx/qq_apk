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

public class xjn
  extends ysg<xhh>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private wgz jdField_a_of_type_Wgz;
  private xgr jdField_a_of_type_Xgr;
  private xhh jdField_a_of_type_Xhh;
  private xsh jdField_a_of_type_Xsh;
  private int b;
  
  public xjn(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(xsh paramxsh)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Xhh.a();
    d(paramxsh);
    ((ElasticImageView)paramxsh.a(2131374376)).setVisibility(8);
    Object localObject = (ElasticImageView)paramxsh.a(2131377252);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramxsh.a(2131380915);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      xvv.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramxsh.a();
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
    Iterator localIterator = this.jdField_a_of_type_Xhh.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846387);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(amtj.a(2131702286), new Object[] { UIUtils.formatCount(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(amtj.a(2131702285), new Object[] { UIUtils.formatCount(paramLong) }));
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
  
  private View b(xsh paramxsh)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xhh.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramxsh);
    e(paramxsh);
    ElasticImageView localElasticImageView = (ElasticImageView)paramxsh.a(2131377252);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramxsh.a(2131380915);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      xvv.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramxsh.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(xsh paramxsh)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Xhh.a();
    d(paramxsh);
    e(paramxsh);
    Object localObject = (ElasticImageView)paramxsh.a(2131377252);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramxsh.a(2131380915);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      xvv.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramxsh.a();
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
  
  private void d(xsh paramxsh)
  {
    paramxsh = (ElasticImageView)paramxsh.a(2131369912);
    if (this.jdField_a_of_type_Xhh.a.mHadLike == 1)
    {
      paramxsh.setImageResource(2130846380);
      return;
    }
    if (QQStoryContext.a())
    {
      paramxsh.setImageResource(2130846386);
      return;
    }
    paramxsh.setImageResource(2130846385);
  }
  
  private void e(xsh paramxsh)
  {
    paramxsh = (ElasticImageView)paramxsh.a(2131374376);
    if ((a(this.jdField_a_of_type_Xhh.a.date)) && (this.jdField_a_of_type_Xhh.a().size() > 1))
    {
      paramxsh.setVisibility(0);
      paramxsh.setOnClickListener(this);
      return;
    }
    paramxsh.setVisibility(8);
    paramxsh.setOnClickListener(null);
  }
  
  private void f()
  {
    xvv.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      xvv.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Wgz == null) {
      this.jdField_a_of_type_Wgz = wgz.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Xhh.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Xhh.a());
    wgz localwgz = this.jdField_a_of_type_Wgz;
    if (this.jdField_a_of_type_Xhh.a.getOwner().isMe())
    {
      str = amtj.a(2131702282);
      localObject = localwgz.a(str).a(new xjo(this)).a(new whz(localStoryVideoItem, this.jdField_a_of_type_Xhh.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((wgz)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((wgz)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718400);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    xvv.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      xvv.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xhh.a().getOwner();
      if (this.jdField_a_of_type_Wgz == null) {
        this.jdField_a_of_type_Wgz = wgz.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Xhh.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Wgz.a(amtj.a(2131702281) + vkm.a + amtj.a(2131702283)).a(wic.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Xhh.a().size())).a(new xjp(this, localVideoListFeedItem)).b();
    xwa.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    xvv.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Wgz == null) {
      this.jdField_a_of_type_Wgz = wgz.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Wgz.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718400)).a(new xjq(this)).a(new why(this.jdField_a_of_type_Xhh.a())).b();
  }
  
  public void N_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xhh == null)
    {
      xvv.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramxsh.a();
    }
    if ((this.jdField_a_of_type_Xhh.d()) || (this.jdField_a_of_type_Xhh.e())) {
      return c(paramxsh);
    }
    if (this.jdField_a_of_type_Xhh.f()) {
      return b(paramxsh);
    }
    if (this.jdField_a_of_type_Xhh.g()) {
      return a(paramxsh);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Xhh.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561583, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Xsh.a(2131369912);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Xsh.a(2131364803);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Xsh.a(2131377252);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Xsh.a(2131374376);
    TextView localTextView = (TextView)this.jdField_a_of_type_Xsh.a(2131380915);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846386);
      localElasticImageView1.setImageResource(2130846379);
      localElasticImageView3.setImageResource(2130846432);
      localElasticImageView2.setImageResource(2130846718);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Xsh;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Wgz != null) {
      this.jdField_a_of_type_Wgz.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_Xgr = paramxgr;
  }
  
  public void a(xhh paramxhh, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Xsh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xsh.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369912: 
    case 2131364803: 
    case 2131374376: 
    case 2131377252: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Xhh.f())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_Xhh.a().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xbw.a((ShareGroupItem)localObject))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131702279), 1).a();
            }
          }
          else if ((xbw.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131702278), 1).a();
            continue;
          }
          if (this.jdField_a_of_type_Xgr != null)
          {
            this.jdField_a_of_type_Xgr.I_();
            continue;
            if (this.jdField_a_of_type_Xhh.f())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_Xhh.a().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xbw.a((ShareGroupItem)localObject))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131702284), 1).a();
              }
            }
            else if ((xbw.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131702280), 1).a();
              continue;
            }
            if (this.jdField_a_of_type_Xgr != null) {
              this.jdField_a_of_type_Xgr.f();
            }
          }
        }
        i = wkp.a(this.jdField_a_of_type_Int, this.b);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Xhh.a.feedId, this.jdField_a_of_type_Xhh.a.feedId, "", 1, false), i);
        wmu.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), null);
        i = xwa.b(this.jdField_a_of_type_Xhh.a);
        if ((this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_Xhh.a.getOwner().getUnionId();; localObject = "")
        {
          xwa.a("home_page", "clk_play", xwa.a(this.jdField_a_of_type_Xhh.a), 0, new String[] { String.valueOf(i), xwa.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xhh.a.feedId, localObject });
          break;
        }
      } while (UIUtils.isFastDoubleClick());
      if ((this.jdField_a_of_type_Xhh.d()) || (this.jdField_a_of_type_Xhh.e()))
      {
        f();
        label533:
        if (!(this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_Xhh.a.getOwner().getUnionId();; localObject = "")
      {
        xwa.a("home_page", "clk_share", xwa.a(this.jdField_a_of_type_Xhh.a), 0, new String[] { String.valueOf(xwa.b(this.jdField_a_of_type_Xhh.a)), xwa.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xhh.a.feedId, localObject });
        break;
        if (this.jdField_a_of_type_Xhh.f())
        {
          h();
          break label533;
        }
        if (!this.jdField_a_of_type_Xhh.g()) {
          break label533;
        }
        i();
        break label533;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xhh.a.feedId, this.jdField_a_of_type_Int);
    int i = xwa.a(this.jdField_a_of_type_Xhh.a);
    if (this.jdField_a_of_type_Xhh.a.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      xwa.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, xwa.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Xhh.a.feedId });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */