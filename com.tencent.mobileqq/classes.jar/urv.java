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

public class urv
  extends wco<upp>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private tpb jdField_a_of_type_Tpb;
  private uoz jdField_a_of_type_Uoz;
  private upp jdField_a_of_type_Upp;
  private vap jdField_a_of_type_Vap;
  private int b;
  
  public urv(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(vap paramvap)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Upp.a();
    d(paramvap);
    ((ElasticImageView)paramvap.a(2131373268)).setVisibility(8);
    Object localObject = (ElasticImageView)paramvap.a(2131376005);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramvap.a(2131379296);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      ved.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvap.a();
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
    Iterator localIterator = this.jdField_a_of_type_Upp.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845571);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(ajya.a(2131703163), new Object[] { vzl.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(ajya.a(2131703162), new Object[] { vzl.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = vzl.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(vap paramvap)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Upp.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramvap);
    e(paramvap);
    ElasticImageView localElasticImageView = (ElasticImageView)paramvap.a(2131376005);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramvap.a(2131379296);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      ved.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvap.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(vap paramvap)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Upp.a();
    d(paramvap);
    e(paramvap);
    Object localObject = (ElasticImageView)paramvap.a(2131376005);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramvap.a(2131379296);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      ved.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvap.a();
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
  
  private void d(vap paramvap)
  {
    paramvap = (ElasticImageView)paramvap.a(2131369176);
    if (this.jdField_a_of_type_Upp.a.mHadLike == 1)
    {
      paramvap.setImageResource(2130845564);
      return;
    }
    if (QQStoryContext.a())
    {
      paramvap.setImageResource(2130845570);
      return;
    }
    paramvap.setImageResource(2130845569);
  }
  
  private void e(vap paramvap)
  {
    paramvap = (ElasticImageView)paramvap.a(2131373268);
    if ((a(this.jdField_a_of_type_Upp.a.date)) && (this.jdField_a_of_type_Upp.a().size() > 1))
    {
      paramvap.setVisibility(0);
      paramvap.setOnClickListener(this);
      return;
    }
    paramvap.setVisibility(8);
    paramvap.setOnClickListener(null);
  }
  
  private void f()
  {
    ved.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      ved.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Tpb == null) {
      this.jdField_a_of_type_Tpb = tpb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Upp.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Upp.a());
    tpb localtpb = this.jdField_a_of_type_Tpb;
    if (this.jdField_a_of_type_Upp.a.getOwner().isMe())
    {
      str = ajya.a(2131703159);
      localObject = localtpb.a(str).a(new urw(this)).a(new tqb(localStoryVideoItem, this.jdField_a_of_type_Upp.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((tpb)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((tpb)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131719508);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    ved.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      ved.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Upp.a().getOwner();
      if (this.jdField_a_of_type_Tpb == null) {
        this.jdField_a_of_type_Tpb = tpb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Upp.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Tpb.a(ajya.a(2131703158) + ssf.a + ajya.a(2131703160)).a(tqe.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Upp.a().size())).a(new urx(this, localVideoListFeedItem)).b();
    vei.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    ved.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Tpb == null) {
      this.jdField_a_of_type_Tpb = tpb.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Tpb.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719508)).a(new ury(this)).a(new tqa(this.jdField_a_of_type_Upp.a())).b();
  }
  
  public void R_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Upp == null)
    {
      ved.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramvap.a();
    }
    if ((this.jdField_a_of_type_Upp.d()) || (this.jdField_a_of_type_Upp.e())) {
      return c(paramvap);
    }
    if (this.jdField_a_of_type_Upp.f()) {
      return b(paramvap);
    }
    if (this.jdField_a_of_type_Upp.g()) {
      return a(paramvap);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Upp.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561218, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Vap.a(2131369176);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Vap.a(2131364437);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Vap.a(2131376005);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Vap.a(2131373268);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vap.a(2131379296);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130845570);
      localElasticImageView1.setImageResource(2130845563);
      localElasticImageView3.setImageResource(2130845616);
      localElasticImageView2.setImageResource(2130845902);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Vap;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Tpb != null) {
      this.jdField_a_of_type_Tpb.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
  }
  
  public void a(upp paramupp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Upp = paramupp;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vap == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vap.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369176: 
    case 2131364437: 
    case 2131373268: 
    case 2131376005: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Upp.f())
            {
              paramView = (ShareGroupItem)this.jdField_a_of_type_Upp.a().getOwner();
              if ((paramView != null) && (paramView.type == 2) && (uke.a(paramView))) {
                bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131703156), 1).a();
              }
            }
            else if ((uke.a()) && ((this.b == 63) || (this.b == 64)))
            {
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131703155), 1).a();
              return;
            }
          } while (this.jdField_a_of_type_Uoz == null);
          this.jdField_a_of_type_Uoz.M_();
          return;
          if (this.jdField_a_of_type_Upp.f())
          {
            paramView = (ShareGroupItem)this.jdField_a_of_type_Upp.a().getOwner();
            if ((paramView != null) && (paramView.type == 2) && (uke.a(paramView))) {
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131703161), 1).a();
            }
          }
          else if ((uke.a()) && ((this.b == 63) || (this.b == 64)))
          {
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131703157), 1).a();
            return;
          }
        } while (this.jdField_a_of_type_Uoz == null);
        this.jdField_a_of_type_Uoz.f();
        return;
        i = tsr.a(this.jdField_a_of_type_Int, this.b);
        paramView = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Upp.a.feedId, this.jdField_a_of_type_Upp.a.feedId, "", 1, false), i);
        tvc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView.a(), null);
        i = vei.b(this.jdField_a_of_type_Upp.a);
        if ((this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) {}
        for (paramView = this.jdField_a_of_type_Upp.a.getOwner().getUnionId();; paramView = "")
        {
          vei.a("home_page", "clk_play", vei.a(this.jdField_a_of_type_Upp.a), 0, new String[] { String.valueOf(i), vei.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Upp.a.feedId, paramView });
          return;
        }
      } while (vzl.b());
      if ((this.jdField_a_of_type_Upp.d()) || (this.jdField_a_of_type_Upp.e()))
      {
        f();
        if (!(this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) {
          break label646;
        }
      }
      label646:
      for (paramView = this.jdField_a_of_type_Upp.a.getOwner().getUnionId();; paramView = "")
      {
        vei.a("home_page", "clk_share", vei.a(this.jdField_a_of_type_Upp.a), 0, new String[] { String.valueOf(vei.b(this.jdField_a_of_type_Upp.a)), vei.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Upp.a.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Upp.f())
        {
          h();
          break;
        }
        if (!this.jdField_a_of_type_Upp.g()) {
          break;
        }
        i();
        break;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Upp.a.feedId, this.jdField_a_of_type_Int);
    int i = vei.a(this.jdField_a_of_type_Upp.a);
    if (this.jdField_a_of_type_Upp.a.getOwner().isMe()) {}
    for (paramView = "1";; paramView = "2")
    {
      vei.a("home_page", "clk_view_detail", i, 0, new String[] { paramView, vei.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Upp.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */