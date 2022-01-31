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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class wkw
  extends xvp<wiq>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private vic jdField_a_of_type_Vic;
  private wia jdField_a_of_type_Wia;
  private wiq jdField_a_of_type_Wiq;
  private wtq jdField_a_of_type_Wtq;
  private int b;
  
  public wkw(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(wtq paramwtq)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Wiq.a();
    d(paramwtq);
    ((ElasticImageView)paramwtq.a(2131373768)).setVisibility(8);
    Object localObject = (ElasticImageView)paramwtq.a(2131376558);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramwtq.a(2131380055);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      wxe.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramwtq.a();
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
    Iterator localIterator = this.jdField_a_of_type_Wiq.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846023);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(alud.a(2131703547), new Object[] { xsm.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(alud.a(2131703546), new Object[] { xsm.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = xsm.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(wtq paramwtq)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Wiq.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramwtq);
    e(paramwtq);
    ElasticImageView localElasticImageView = (ElasticImageView)paramwtq.a(2131376558);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramwtq.a(2131380055);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      wxe.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramwtq.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(wtq paramwtq)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Wiq.a();
    d(paramwtq);
    e(paramwtq);
    Object localObject = (ElasticImageView)paramwtq.a(2131376558);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramwtq.a(2131380055);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      wxe.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramwtq.a();
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
  
  private void d(wtq paramwtq)
  {
    paramwtq = (ElasticImageView)paramwtq.a(2131369426);
    if (this.jdField_a_of_type_Wiq.a.mHadLike == 1)
    {
      paramwtq.setImageResource(2130846016);
      return;
    }
    if (QQStoryContext.a())
    {
      paramwtq.setImageResource(2130846022);
      return;
    }
    paramwtq.setImageResource(2130846021);
  }
  
  private void e(wtq paramwtq)
  {
    paramwtq = (ElasticImageView)paramwtq.a(2131373768);
    if ((a(this.jdField_a_of_type_Wiq.a.date)) && (this.jdField_a_of_type_Wiq.a().size() > 1))
    {
      paramwtq.setVisibility(0);
      paramwtq.setOnClickListener(this);
      return;
    }
    paramwtq.setVisibility(8);
    paramwtq.setOnClickListener(null);
  }
  
  private void f()
  {
    wxe.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      wxe.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Vic == null) {
      this.jdField_a_of_type_Vic = vic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Wiq.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Wiq.a());
    vic localvic = this.jdField_a_of_type_Vic;
    if (this.jdField_a_of_type_Wiq.a.getOwner().isMe())
    {
      str = alud.a(2131703543);
      localObject = localvic.a(str).a(new wkx(this)).a(new vjc(localStoryVideoItem, this.jdField_a_of_type_Wiq.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((vic)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((vic)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131720052);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    wxe.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      wxe.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Wiq.a().getOwner();
      if (this.jdField_a_of_type_Vic == null) {
        this.jdField_a_of_type_Vic = vic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Wiq.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Vic.a(alud.a(2131703542) + ulg.a + alud.a(2131703544)).a(vjf.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Wiq.a().size())).a(new wky(this, localVideoListFeedItem)).b();
    wxj.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    wxe.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Vic == null) {
      this.jdField_a_of_type_Vic = vic.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Vic.a(this.jdField_a_of_type_AndroidContentContext.getString(2131720052)).a(new wkz(this)).a(new vjb(this.jdField_a_of_type_Wiq.a())).b();
  }
  
  public void W_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Wiq == null)
    {
      wxe.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramwtq.a();
    }
    if ((this.jdField_a_of_type_Wiq.d()) || (this.jdField_a_of_type_Wiq.e())) {
      return c(paramwtq);
    }
    if (this.jdField_a_of_type_Wiq.f()) {
      return b(paramwtq);
    }
    if (this.jdField_a_of_type_Wiq.g()) {
      return a(paramwtq);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Wiq.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561426, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Wtq.a(2131369426);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Wtq.a(2131364511);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Wtq.a(2131376558);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Wtq.a(2131373768);
    TextView localTextView = (TextView)this.jdField_a_of_type_Wtq.a(2131380055);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130846022);
      localElasticImageView1.setImageResource(2130846015);
      localElasticImageView3.setImageResource(2130846068);
      localElasticImageView2.setImageResource(2130846354);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Wtq;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Vic != null) {
      this.jdField_a_of_type_Vic.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_Wia = paramwia;
  }
  
  public void a(wiq paramwiq, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wtq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wtq.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369426: 
    case 2131364511: 
    case 2131373768: 
    case 2131376558: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Wiq.f())
            {
              paramView = (ShareGroupItem)this.jdField_a_of_type_Wiq.a().getOwner();
              if ((paramView != null) && (paramView.type == 2) && (wdf.a(paramView))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131703540), 1).a();
              }
            }
            else if ((wdf.a()) && ((this.b == 63) || (this.b == 64)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131703539), 1).a();
              return;
            }
          } while (this.jdField_a_of_type_Wia == null);
          this.jdField_a_of_type_Wia.R_();
          return;
          if (this.jdField_a_of_type_Wiq.f())
          {
            paramView = (ShareGroupItem)this.jdField_a_of_type_Wiq.a().getOwner();
            if ((paramView != null) && (paramView.type == 2) && (wdf.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131703545), 1).a();
            }
          }
          else if ((wdf.a()) && ((this.b == 63) || (this.b == 64)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131703541), 1).a();
            return;
          }
        } while (this.jdField_a_of_type_Wia == null);
        this.jdField_a_of_type_Wia.f();
        return;
        i = vls.a(this.jdField_a_of_type_Int, this.b);
        paramView = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Wiq.a.feedId, this.jdField_a_of_type_Wiq.a.feedId, "", 1, false), i);
        vod.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView.a(), null);
        i = wxj.b(this.jdField_a_of_type_Wiq.a);
        if ((this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem)) {}
        for (paramView = this.jdField_a_of_type_Wiq.a.getOwner().getUnionId();; paramView = "")
        {
          wxj.a("home_page", "clk_play", wxj.a(this.jdField_a_of_type_Wiq.a), 0, new String[] { String.valueOf(i), wxj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wiq.a.feedId, paramView });
          return;
        }
      } while (xsm.b());
      if ((this.jdField_a_of_type_Wiq.d()) || (this.jdField_a_of_type_Wiq.e()))
      {
        f();
        if (!(this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem)) {
          break label646;
        }
      }
      label646:
      for (paramView = this.jdField_a_of_type_Wiq.a.getOwner().getUnionId();; paramView = "")
      {
        wxj.a("home_page", "clk_share", wxj.a(this.jdField_a_of_type_Wiq.a), 0, new String[] { String.valueOf(wxj.b(this.jdField_a_of_type_Wiq.a)), wxj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wiq.a.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Wiq.f())
        {
          h();
          break;
        }
        if (!this.jdField_a_of_type_Wiq.g()) {
          break;
        }
        i();
        break;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wiq.a.feedId, this.jdField_a_of_type_Int);
    int i = wxj.a(this.jdField_a_of_type_Wiq.a);
    if (this.jdField_a_of_type_Wiq.a.getOwner().isMe()) {}
    for (paramView = "1";; paramView = "2")
    {
      wxj.a("home_page", "clk_view_detail", i, 0, new String[] { paramView, wxj.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Wiq.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkw
 * JD-Core Version:    0.7.0.1
 */