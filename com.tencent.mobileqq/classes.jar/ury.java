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

public class ury
  extends wcr<ups>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private int jdField_a_of_type_Int;
  private tpe jdField_a_of_type_Tpe;
  private upc jdField_a_of_type_Upc;
  private ups jdField_a_of_type_Ups;
  private vas jdField_a_of_type_Vas;
  private int b;
  
  public ury(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(vas paramvas)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Ups.a();
    d(paramvas);
    ((ElasticImageView)paramvas.a(2131373266)).setVisibility(8);
    Object localObject = (ElasticImageView)paramvas.a(2131376003);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramvas.a(2131379291);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      veg.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvas.a();
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
    Iterator localIterator = this.jdField_a_of_type_Ups.a().iterator();
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
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845565);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(ajyc.a(2131703152), new Object[] { vzo.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(ajyc.a(2131703151), new Object[] { vzo.a(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private boolean a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = vzo.a(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  private View b(vas paramvas)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ups.a();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    d(paramvas);
    e(paramvas);
    ElasticImageView localElasticImageView = (ElasticImageView)paramvas.a(2131376003);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramvas.a(2131379291);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      veg.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvas.a();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private View c(vas paramvas)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Ups.a();
    d(paramvas);
    e(paramvas);
    Object localObject = (ElasticImageView)paramvas.a(2131376003);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramvas.a(2131379291);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      veg.d("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramvas.a();
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
  
  private void d(vas paramvas)
  {
    paramvas = (ElasticImageView)paramvas.a(2131369176);
    if (this.jdField_a_of_type_Ups.a.mHadLike == 1)
    {
      paramvas.setImageResource(2130845558);
      return;
    }
    if (QQStoryContext.a())
    {
      paramvas.setImageResource(2130845564);
      return;
    }
    paramvas.setImageResource(2130845563);
  }
  
  private void e(vas paramvas)
  {
    paramvas = (ElasticImageView)paramvas.a(2131373266);
    if ((a(this.jdField_a_of_type_Ups.a.date)) && (this.jdField_a_of_type_Ups.a().size() > 1))
    {
      paramvas.setVisibility(0);
      paramvas.setOnClickListener(this);
      return;
    }
    paramvas.setVisibility(8);
    paramvas.setOnClickListener(null);
  }
  
  private void f()
  {
    veg.c("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      veg.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Tpe == null) {
      this.jdField_a_of_type_Tpe = tpe.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Ups.a());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Ups.a());
    tpe localtpe = this.jdField_a_of_type_Tpe;
    if (this.jdField_a_of_type_Ups.a.getOwner().isMe())
    {
      str = ajyc.a(2131703148);
      localObject = localtpe.a(str).a(new urz(this)).a(new tqe(localStoryVideoItem, this.jdField_a_of_type_Ups.a.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label216;
      }
      str = "1";
      label169:
      localObject = ((tpe)localObject).a("vote", str);
      if (!bool2) {
        break label223;
      }
    }
    label216:
    label223:
    for (String str = "1";; str = "0")
    {
      ((tpe)localObject).a("grade", str).b();
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131719497);
      break;
      str = "0";
      break label169;
    }
  }
  
  private void h()
  {
    veg.c("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      veg.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ups.a().getOwner();
      if (this.jdField_a_of_type_Tpe == null) {
        this.jdField_a_of_type_Tpe = tpe.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Ups.a();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Tpe.a(ajyc.a(2131703147) + ssi.a + ajyc.a(2131703149)).a(tqh.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Ups.a().size())).a(new usa(this, localVideoListFeedItem)).b();
    vel.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void i()
  {
    veg.c("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Tpe == null) {
      this.jdField_a_of_type_Tpe = tpe.a((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Tpe.a(this.jdField_a_of_type_AndroidContentContext.getString(2131719497)).a(new usb(this)).a(new tqd(this.jdField_a_of_type_Ups.a())).b();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ups == null)
    {
      veg.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramvas.a();
    }
    if ((this.jdField_a_of_type_Ups.d()) || (this.jdField_a_of_type_Ups.e())) {
      return c(paramvas);
    }
    if (this.jdField_a_of_type_Ups.f()) {
      return b(paramvas);
    }
    if (this.jdField_a_of_type_Ups.g()) {
      return a(paramvas);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Ups.a.type);
  }
  
  public String a()
  {
    return "DetailInteractSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561219, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.jdField_a_of_type_Vas.a(2131369176);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.jdField_a_of_type_Vas.a(2131364438);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.jdField_a_of_type_Vas.a(2131376003);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.jdField_a_of_type_Vas.a(2131373266);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vas.a(2131379291);
    if (QQStoryContext.a())
    {
      paramViewGroup.setImageResource(2130845564);
      localElasticImageView1.setImageResource(2130845557);
      localElasticImageView3.setImageResource(2130845610);
      localElasticImageView2.setImageResource(2130845896);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.jdField_a_of_type_Vas;
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Tpe != null) {
      this.jdField_a_of_type_Tpe.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
  }
  
  public void a(ups paramups, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ups = paramups;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vas == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vas.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369176: 
    case 2131364438: 
    case 2131373266: 
    case 2131376003: 
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Ups.f())
            {
              paramView = (ShareGroupItem)this.jdField_a_of_type_Ups.a().getOwner();
              if ((paramView != null) && (paramView.type == 2) && (ukh.a(paramView))) {
                bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131703145), 1).a();
              }
            }
            else if ((ukh.a()) && ((this.b == 63) || (this.b == 64)))
            {
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131703144), 1).a();
              return;
            }
          } while (this.jdField_a_of_type_Upc == null);
          this.jdField_a_of_type_Upc.M_();
          return;
          if (this.jdField_a_of_type_Ups.f())
          {
            paramView = (ShareGroupItem)this.jdField_a_of_type_Ups.a().getOwner();
            if ((paramView != null) && (paramView.type == 2) && (ukh.a(paramView))) {
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131703150), 1).a();
            }
          }
          else if ((ukh.a()) && ((this.b == 63) || (this.b == 64)))
          {
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131703146), 1).a();
            return;
          }
        } while (this.jdField_a_of_type_Upc == null);
        this.jdField_a_of_type_Upc.f();
        return;
        i = tsu.a(this.jdField_a_of_type_Int, this.b);
        paramView = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Ups.a.feedId, this.jdField_a_of_type_Ups.a.feedId, "", 1, false), i);
        tvf.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView.a(), null);
        i = vel.b(this.jdField_a_of_type_Ups.a);
        if ((this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) {}
        for (paramView = this.jdField_a_of_type_Ups.a.getOwner().getUnionId();; paramView = "")
        {
          vel.a("home_page", "clk_play", vel.a(this.jdField_a_of_type_Ups.a), 0, new String[] { String.valueOf(i), vel.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ups.a.feedId, paramView });
          return;
        }
      } while (vzo.b());
      if ((this.jdField_a_of_type_Ups.d()) || (this.jdField_a_of_type_Ups.e()))
      {
        f();
        if (!(this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) {
          break label646;
        }
      }
      label646:
      for (paramView = this.jdField_a_of_type_Ups.a.getOwner().getUnionId();; paramView = "")
      {
        vel.a("home_page", "clk_share", vel.a(this.jdField_a_of_type_Ups.a), 0, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_Ups.a)), vel.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ups.a.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Ups.f())
        {
          h();
          break;
        }
        if (!this.jdField_a_of_type_Ups.g()) {
          break;
        }
        i();
        break;
      }
    }
    QQStoryWatcherListActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ups.a.feedId, this.jdField_a_of_type_Int);
    int i = vel.a(this.jdField_a_of_type_Ups.a);
    if (this.jdField_a_of_type_Ups.a.getOwner().isMe()) {}
    for (paramView = "1";; paramView = "2")
    {
      vel.a("home_page", "clk_view_detail", i, 0, new String[] { paramView, vel.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_Ups.a.feedId });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ury
 * JD-Core Version:    0.7.0.1
 */