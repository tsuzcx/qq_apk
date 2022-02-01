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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class yic
  extends zsv<yfw>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private xfj jdField_a_of_type_Xfj;
  private yfg jdField_a_of_type_Yfg;
  private yfw jdField_a_of_type_Yfw;
  private yqw jdField_a_of_type_Yqw;
  private int b;
  
  public yic(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(yqw paramyqw)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Yfw.a();
    d(paramyqw);
    ((ElasticImageView)paramyqw.a(2131374608)).setVisibility(8);
    Object localObject = (ElasticImageView)paramyqw.a(2131377489);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramyqw.a(2131381196);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      yuk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyqw.a();
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
    Iterator localIterator = this.jdField_a_of_type_Yfw.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846479);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(anzj.a(2131702051), new Object[] { zps.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(anzj.a(2131702050), new Object[] { zps.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = zps.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(yqw paramyqw)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Yfw.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramyqw);
    e(paramyqw);
    ElasticImageView localElasticImageView = (ElasticImageView)paramyqw.a(2131377489);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramyqw.a(2131381196);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      yuk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyqw.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(yqw paramyqw)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Yfw.a();
    d(paramyqw);
    e(paramyqw);
    Object localObject = (ElasticImageView)paramyqw.a(2131377489);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramyqw.a(2131381196);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      yuk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramyqw.a();
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
  
  private void d(yqw paramyqw)
  {
    paramyqw = (ElasticImageView)paramyqw.a(2131369918);
    if (this.jdField_a_of_type_Yfw.a.mHadLike == 1)
    {
      paramyqw.setImageResource(2130846472);
      return;
    }
    if (QQStoryContext.a())
    {
      paramyqw.setImageResource(2130846478);
      return;
    }
    paramyqw.setImageResource(2130846477);
  }
  
  private void e(yqw paramyqw)
  {
    paramyqw = (ElasticImageView)paramyqw.a(2131374608);
    if ((a(this.jdField_a_of_type_Yfw.a.date)) && (this.jdField_a_of_type_Yfw.a().size() > 1))
    {
      paramyqw.setVisibility(0);
      paramyqw.setOnClickListener(this);
      return;
    }
    paramyqw.setVisibility(8);
    paramyqw.setOnClickListener(null);
  }
  
  private void f()
  {
    yuk.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      yuk.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Xfj == null) {
      this.jdField_a_of_type_Xfj = xfj.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Yfw.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Yfw.a());
    xfj localxfj = this.jdField_a_of_type_Xfj;
    if (this.jdField_a_of_type_Yfw.a.getOwner().isMe())
    {
      str = anzj.a(2131702047);
      localObject = localxfj.a(str).a(new yid(this)).a(new xgj(localStoryVideoItem, this.jdField_a_of_type_Yfw.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((xfj)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((xfj)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718159);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    yuk.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      yuk.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Yfw.a().getOwner();
      if (this.jdField_a_of_type_Xfj == null) {
        this.jdField_a_of_type_Xfj = xfj.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Yfw.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Xfj.a(anzj.a(2131702046) + win.a + anzj.a(2131702048)).a(xgm.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Yfw.a().size())).a(new yie(this, localVideoListFeedItem)).b();
    yup.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    yuk.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Xfj == null) {
      this.jdField_a_of_type_Xfj = xfj.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Xfj.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718159)).a(new yif(this)).a(new xgi(this.jdField_a_of_type_Yfw.a())).b();
  }
  
  public void T_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yfw == null)
    {
      yuk.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramyqw.a();
    }
    if ((this.jdField_a_of_type_Yfw.d()) || (this.jdField_a_of_type_Yfw.e())) {
      return c(paramyqw);
    }
    if (this.jdField_a_of_type_Yfw.f()) {
      return b(paramyqw);
    }
    if (this.jdField_a_of_type_Yfw.g()) {
      return a(paramyqw);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Yfw.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561703, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Yqw.a(2131369918);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Yqw.a(2131364772);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Yqw.a(2131377489);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Yqw.a(2131374608);
    TextView localTextView = (TextView)this.jdField_a_of_type_Yqw.a(2131381196);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846478);
      localElasticImageView1.setImageResource(2130846471);
      localElasticImageView3.setImageResource(2130846524);
      localElasticImageView2.setImageResource(2130846810);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Yqw;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Xfj != null) {
      this.jdField_a_of_type_Xfj.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
  }
  
  public void a(yfw paramyfw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Yqw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yqw.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369918: 
    case 2131364772: 
    case 2131374608: 
    case 2131377489: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Yfw.f())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_Yfw.a().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (yal.a((ShareGroupItem)localObject))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131702044), 1).a();
            }
          }
          else if ((yal.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131702043), 1).a();
            continue;
          }
          if (this.jdField_a_of_type_Yfg != null)
          {
            this.jdField_a_of_type_Yfg.O_();
            continue;
            if (this.jdField_a_of_type_Yfw.f())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_Yfw.a().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (yal.a((ShareGroupItem)localObject))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131702049), 1).a();
              }
            }
            else if ((yal.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131702045), 1).a();
              continue;
            }
            if (this.jdField_a_of_type_Yfg != null) {
              this.jdField_a_of_type_Yfg.f();
            }
          }
        }
        i = xiz.a(this.jdField_a_of_type_Int, this.b);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Yfw.a.feedId, this.jdField_a_of_type_Yfw.a.feedId, "", 1, false), i);
        xlj.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), null);
        i = yup.b(this.jdField_a_of_type_Yfw.a);
        if ((this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_Yfw.a.getOwner().getUnionId();; localObject = "")
        {
          yup.a("home_page", "clk_play", yup.a(this.jdField_a_of_type_Yfw.a), 0, new String[] { String.valueOf(i), yup.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Yfw.a.feedId, localObject });
          break;
        }
      } while (zps.b());
      if ((this.jdField_a_of_type_Yfw.d()) || (this.jdField_a_of_type_Yfw.e()))
      {
        f();
        label533:
        if (!(this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_Yfw.a.getOwner().getUnionId();; localObject = "")
      {
        yup.a("home_page", "clk_share", yup.a(this.jdField_a_of_type_Yfw.a), 0, new String[] { String.valueOf(yup.b(this.jdField_a_of_type_Yfw.a)), yup.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Yfw.a.feedId, localObject });
        break;
        if (this.jdField_a_of_type_Yfw.f())
        {
          h();
          break label533;
        }
        if (!this.jdField_a_of_type_Yfw.g()) {
          break label533;
        }
        i();
        break label533;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yfw.a.feedId, this.jdField_a_of_type_Int);
    int i = yup.a(this.jdField_a_of_type_Yfw.a);
    if (this.jdField_a_of_type_Yfw.a.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      yup.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, yup.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Yfw.a.feedId });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yic
 * JD-Core Version:    0.7.0.1
 */