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

public class yeh
  extends zpa<ycb>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private xbo jdField_a_of_type_Xbo;
  private ybl jdField_a_of_type_Ybl;
  private ycb jdField_a_of_type_Ycb;
  private ynb jdField_a_of_type_Ynb;
  private int b;
  
  public yeh(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(ynb paramynb)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Ycb.a();
    d(paramynb);
    ((ElasticImageView)paramynb.a(2131374471)).setVisibility(8);
    Object localObject = (ElasticImageView)paramynb.a(2131377349);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramynb.a(2131381016);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      yqp.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramynb.a();
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
    Iterator localIterator = this.jdField_a_of_type_Ycb.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846462);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(anni.a(2131701944), new Object[] { zlx.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(anni.a(2131701943), new Object[] { zlx.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = zlx.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(ynb paramynb)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ycb.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramynb);
    e(paramynb);
    ElasticImageView localElasticImageView = (ElasticImageView)paramynb.a(2131377349);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramynb.a(2131381016);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      yqp.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramynb.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(ynb paramynb)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ycb.a();
    d(paramynb);
    e(paramynb);
    Object localObject = (ElasticImageView)paramynb.a(2131377349);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramynb.a(2131381016);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      yqp.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramynb.a();
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
  
  private void d(ynb paramynb)
  {
    paramynb = (ElasticImageView)paramynb.a(2131369820);
    if (this.jdField_a_of_type_Ycb.a.mHadLike == 1)
    {
      paramynb.setImageResource(2130846455);
      return;
    }
    if (QQStoryContext.a())
    {
      paramynb.setImageResource(2130846461);
      return;
    }
    paramynb.setImageResource(2130846460);
  }
  
  private void e(ynb paramynb)
  {
    paramynb = (ElasticImageView)paramynb.a(2131374471);
    if ((a(this.jdField_a_of_type_Ycb.a.date)) && (this.jdField_a_of_type_Ycb.a().size() > 1))
    {
      paramynb.setVisibility(0);
      paramynb.setOnClickListener(this);
      return;
    }
    paramynb.setVisibility(8);
    paramynb.setOnClickListener(null);
  }
  
  private void f()
  {
    yqp.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      yqp.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Xbo == null) {
      this.jdField_a_of_type_Xbo = xbo.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Ycb.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Ycb.a());
    xbo localxbo = this.jdField_a_of_type_Xbo;
    if (this.jdField_a_of_type_Ycb.a.getOwner().isMe())
    {
      str = anni.a(2131701940);
      localObject = localxbo.a(str).a(new yei(this)).a(new xco(localStoryVideoItem, this.jdField_a_of_type_Ycb.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((xbo)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((xbo)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718027);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    yqp.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      yqp.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ycb.a().getOwner();
      if (this.jdField_a_of_type_Xbo == null) {
        this.jdField_a_of_type_Xbo = xbo.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Ycb.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Xbo.a(anni.a(2131701939) + wes.a + anni.a(2131701941)).a(xcr.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Ycb.a().size())).a(new yej(this, localVideoListFeedItem)).b();
    yqu.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    yqp.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Xbo == null) {
      this.jdField_a_of_type_Xbo = xbo.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Xbo.a(this.jdField_a_of_type_AndroidContentContext.getString(2131718027)).a(new yek(this)).a(new xcn(this.jdField_a_of_type_Ycb.a())).b();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ycb == null)
    {
      yqp.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramynb.a();
    }
    if ((this.jdField_a_of_type_Ycb.d()) || (this.jdField_a_of_type_Ycb.e())) {
      return c(paramynb);
    }
    if (this.jdField_a_of_type_Ycb.f()) {
      return b(paramynb);
    }
    if (this.jdField_a_of_type_Ycb.g()) {
      return a(paramynb);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Ycb.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561662, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Ynb.a(2131369820);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Ynb.a(2131364725);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Ynb.a(2131377349);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Ynb.a(2131374471);
    TextView localTextView = (TextView)this.jdField_a_of_type_Ynb.a(2131381016);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846461);
      localElasticImageView1.setImageResource(2130846454);
      localElasticImageView3.setImageResource(2130846507);
      localElasticImageView2.setImageResource(2130846793);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Ynb;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Xbo != null) {
      this.jdField_a_of_type_Xbo.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_Ybl = paramybl;
  }
  
  public void a(ycb paramycb, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Ynb == null) {
      return 0;
    }
    return this.jdField_a_of_type_Ynb.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369820: 
    case 2131364725: 
    case 2131374471: 
    case 2131377349: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Ycb.f())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_Ycb.a().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xwq.a((ShareGroupItem)localObject))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131701937), 1).a();
            }
          }
          else if ((xwq.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131701936), 1).a();
            continue;
          }
          if (this.jdField_a_of_type_Ybl != null)
          {
            this.jdField_a_of_type_Ybl.O_();
            continue;
            if (this.jdField_a_of_type_Ycb.f())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_Ycb.a().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (xwq.a((ShareGroupItem)localObject))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131701942), 1).a();
              }
            }
            else if ((xwq.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131701938), 1).a();
              continue;
            }
            if (this.jdField_a_of_type_Ybl != null) {
              this.jdField_a_of_type_Ybl.f();
            }
          }
        }
        i = xfe.a(this.jdField_a_of_type_Int, this.b);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Ycb.a.feedId, this.jdField_a_of_type_Ycb.a.feedId, "", 1, false), i);
        xho.a((Activity)this.jdField_a_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), null);
        i = yqu.b(this.jdField_a_of_type_Ycb.a);
        if ((this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_Ycb.a.getOwner().getUnionId();; localObject = "")
        {
          yqu.a("home_page", "clk_play", yqu.a(this.jdField_a_of_type_Ycb.a), 0, new String[] { String.valueOf(i), yqu.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ycb.a.feedId, localObject });
          break;
        }
      } while (zlx.b());
      if ((this.jdField_a_of_type_Ycb.d()) || (this.jdField_a_of_type_Ycb.e()))
      {
        f();
        label533:
        if (!(this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_Ycb.a.getOwner().getUnionId();; localObject = "")
      {
        yqu.a("home_page", "clk_share", yqu.a(this.jdField_a_of_type_Ycb.a), 0, new String[] { String.valueOf(yqu.b(this.jdField_a_of_type_Ycb.a)), yqu.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ycb.a.feedId, localObject });
        break;
        if (this.jdField_a_of_type_Ycb.f())
        {
          h();
          break label533;
        }
        if (!this.jdField_a_of_type_Ycb.g()) {
          break label533;
        }
        i();
        break label533;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ycb.a.feedId, this.jdField_a_of_type_Int);
    int i = yqu.a(this.jdField_a_of_type_Ycb.a);
    if (this.jdField_a_of_type_Ycb.a.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      yqu.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, yqu.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Ycb.a.feedId });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */