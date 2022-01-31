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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ufc
  extends vpv<ucw>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private tci jdField_a_of_type_Tci;
  private ucg jdField_a_of_type_Ucg;
  private ucw jdField_a_of_type_Ucw;
  private unw jdField_a_of_type_Unw;
  private int b;
  
  public ufc(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(unw paramunw)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Ucw.a();
    d(paramunw);
    ((ElasticImageView)paramunw.a(2131307553)).setVisibility(8);
    Object localObject = (ElasticImageView)paramunw.a(2131310236);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramunw.a(2131313457);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      urk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramunw.a();
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
    Iterator localIterator = this.jdField_a_of_type_Ucw.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845381);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(ajjy.a(2131637367), new Object[] { vms.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(ajjy.a(2131637366), new Object[] { vms.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = vms.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(unw paramunw)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ucw.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramunw);
    e(paramunw);
    ElasticImageView localElasticImageView = (ElasticImageView)paramunw.a(2131310236);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramunw.a(2131313457);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      urk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramunw.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(unw paramunw)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ucw.a();
    d(paramunw);
    e(paramunw);
    Object localObject = (ElasticImageView)paramunw.a(2131310236);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramunw.a(2131313457);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      urk.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramunw.a();
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
  
  private void d(unw paramunw)
  {
    paramunw = (ElasticImageView)paramunw.a(2131303508);
    if (this.jdField_a_of_type_Ucw.a.mHadLike == 1)
    {
      paramunw.setImageResource(2130845374);
      return;
    }
    if (QQStoryContext.a())
    {
      paramunw.setImageResource(2130845380);
      return;
    }
    paramunw.setImageResource(2130845379);
  }
  
  private void e(unw paramunw)
  {
    paramunw = (ElasticImageView)paramunw.a(2131307553);
    if ((a(this.jdField_a_of_type_Ucw.a.date)) && (this.jdField_a_of_type_Ucw.a().size() > 1))
    {
      paramunw.setVisibility(0);
      paramunw.setOnClickListener(this);
      return;
    }
    paramunw.setVisibility(8);
    paramunw.setOnClickListener(null);
  }
  
  private void f()
  {
    urk.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      urk.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Tci == null) {
      this.jdField_a_of_type_Tci = tci.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Ucw.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Ucw.a());
    tci localtci = this.jdField_a_of_type_Tci;
    if (this.jdField_a_of_type_Ucw.a.getOwner().isMe())
    {
      str = ajjy.a(2131637363);
      localObject = localtci.a(str).a(new ufd(this)).a(new tdi(localStoryVideoItem, this.jdField_a_of_type_Ucw.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((tci)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((tci)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131653614);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    urk.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      urk.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ucw.a().getOwner();
      if (this.jdField_a_of_type_Tci == null) {
        this.jdField_a_of_type_Tci = tci.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Ucw.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Tci.a(ajjy.a(2131637362) + sfm.a + ajjy.a(2131637364)).a(tdl.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Ucw.a().size())).a(new ufe(this, localVideoListFeedItem)).b();
    urp.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    urk.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Tci == null) {
      this.jdField_a_of_type_Tci = tci.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Tci.a(this.jdField_a_of_type_AndroidContentContext.getString(2131653614)).a(new uff(this)).a(new tdh(this.jdField_a_of_type_Ucw.a())).b();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ucw == null)
    {
      urk.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramunw.a();
    }
    if ((this.jdField_a_of_type_Ucw.d()) || (this.jdField_a_of_type_Ucw.e())) {
      return c(paramunw);
    }
    if (this.jdField_a_of_type_Ucw.f()) {
      return b(paramunw);
    }
    if (this.jdField_a_of_type_Ucw.g()) {
      return a(paramunw);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Ucw.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495628, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Unw.a(2131303508);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Unw.a(2131298878);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Unw.a(2131310236);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Unw.a(2131307553);
    TextView localTextView = (TextView)this.jdField_a_of_type_Unw.a(2131313457);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130845380);
      localElasticImageView1.setImageResource(2130845373);
      localElasticImageView3.setImageResource(2130845426);
      localElasticImageView2.setImageResource(2130845714);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Unw;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Tci != null) {
      this.jdField_a_of_type_Tci.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void a(ucw paramucw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ucw = paramucw;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Unw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Unw.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131303508: 
    case 2131298878: 
    case 2131307553: 
    case 2131310236: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Ucw.f())
            {
              paramView = (ShareGroupItem)this.jdField_a_of_type_Ucw.a().getOwner();
              if ((paramView != null) && (paramView.type == 2) && (txl.a(paramView))) {
                bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131637360), 1).a();
              }
            }
            else if ((txl.a()) && ((this.b == 63) || (this.b == 64)))
            {
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131637359), 1).a();
              return;
            }
          } while (this.jdField_a_of_type_Ucg == null);
          this.jdField_a_of_type_Ucg.O_();
          return;
          if (this.jdField_a_of_type_Ucw.f())
          {
            paramView = (ShareGroupItem)this.jdField_a_of_type_Ucw.a().getOwner();
            if ((paramView != null) && (paramView.type == 2) && (txl.a(paramView))) {
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131637365), 1).a();
            }
          }
          else if ((txl.a()) && ((this.b == 63) || (this.b == 64)))
          {
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131637361), 1).a();
            return;
          }
        } while (this.jdField_a_of_type_Ucg == null);
        this.jdField_a_of_type_Ucg.f();
        return;
        i = tfy.a(this.jdField_a_of_type_Int, this.b);
        paramView = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Ucw.a.feedId, this.jdField_a_of_type_Ucw.a.feedId, "", 1, false), i);
        tij.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView.a(), null);
        i = urp.b(this.jdField_a_of_type_Ucw.a);
        if ((this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) {}
        for (paramView = this.jdField_a_of_type_Ucw.a.getOwner().getUnionId();; paramView = "")
        {
          urp.a("home_page", "clk_play", urp.a(this.jdField_a_of_type_Ucw.a), 0, new String[] { String.valueOf(i), urp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ucw.a.feedId, paramView });
          return;
        }
      } while (vms.b());
      if ((this.jdField_a_of_type_Ucw.d()) || (this.jdField_a_of_type_Ucw.e()))
      {
        f();
        if (!(this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) {
          break label646;
        }
      }
      label646:
      for (paramView = this.jdField_a_of_type_Ucw.a.getOwner().getUnionId();; paramView = "")
      {
        urp.a("home_page", "clk_share", urp.a(this.jdField_a_of_type_Ucw.a), 0, new String[] { String.valueOf(urp.b(this.jdField_a_of_type_Ucw.a)), urp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ucw.a.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Ucw.f())
        {
          h();
          break;
        }
        if (!this.jdField_a_of_type_Ucw.g()) {
          break;
        }
        i();
        break;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ucw.a.feedId, this.jdField_a_of_type_Int);
    int i = urp.a(this.jdField_a_of_type_Ucw.a);
    if (this.jdField_a_of_type_Ucw.a.getOwner().isMe()) {}
    for (paramView = "1";; paramView = "2")
    {
      urp.a("home_page", "clk_view_detail", i, 0, new String[] { paramView, urp.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Ucw.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufc
 * JD-Core Version:    0.7.0.1
 */