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

public class qsw
  extends rsd<qru>
  implements View.OnClickListener
{
  public static final String KEY = "DetailInteractSegment";
  private qbc jdField_a_of_type_Qbc;
  private qrn jdField_a_of_type_Qrn;
  private qru jdField_a_of_type_Qru;
  private qyd b;
  private int bnW;
  private int mSource;
  
  public qsw(Context paramContext)
  {
    super(paramContext);
  }
  
  private View a(qyd paramqyd)
  {
    BannerFeedItem localBannerFeedItem = this.jdField_a_of_type_Qru.a();
    a(paramqyd);
    ((ElasticImageView)paramqyd.get(2131375150)).setVisibility(8);
    Object localObject = (ElasticImageView)paramqyd.get(2131378168);
    if (localBannerFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramqyd.get(2131382047);
      if (localBannerFeedItem.mViewTotalTime > 0L) {
        break label109;
      }
      ram.w("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramqyd.getItemView();
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
    Iterator localIterator = this.jdField_a_of_type_Qru.bS().iterator();
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
      Drawable localDrawable = this.context.getResources().getDrawable(2130847344);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      paramTextView.setText(String.format(acfp.m(2131704950), new Object[] { rpq.aL(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      return;
    case 2: 
      paramTextView.setCompoundDrawables(null, null, null, null);
      paramTextView.setText(String.format(acfp.m(2131704949), new Object[] { rpq.aL(paramLong) }));
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(null);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(qyd paramqyd)
  {
    paramqyd = (ElasticImageView)paramqyd.get(2131370433);
    if (this.jdField_a_of_type_Qru.d.mHadLike == 1)
    {
      paramqyd.setImageResource(2130847337);
      return;
    }
    if (QQStoryContext.isNightMode())
    {
      paramqyd.setImageResource(2130847343);
      return;
    }
    paramqyd.setImageResource(2130847342);
  }
  
  private View b(qyd paramqyd)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Qru.b();
    Object localObject = (ShareGroupItem)localVideoListFeedItem.getOwner();
    a(paramqyd);
    b(paramqyd);
    ElasticImageView localElasticImageView = (ElasticImageView)paramqyd.get(2131378168);
    if ((!((ShareGroupItem)localObject).isPublic()) || (((ShareGroupItem)localObject).getRelationType() == 2))
    {
      localElasticImageView.setVisibility(8);
      localElasticImageView.setOnClickListener(null);
      localObject = (TextView)paramqyd.get(2131382047);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label118;
      }
      ram.w("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramqyd.getItemView();
      localElasticImageView.setVisibility(0);
      localElasticImageView.setOnClickListener(this);
      break;
      label118:
      a((TextView)localObject, localVideoListFeedItem.mViewTotalTime, 1);
    }
  }
  
  private void b(qyd paramqyd)
  {
    paramqyd = (ElasticImageView)paramqyd.get(2131375150);
    if ((fo(this.jdField_a_of_type_Qru.d.date)) && (this.jdField_a_of_type_Qru.bS().size() > 1))
    {
      paramqyd.setVisibility(0);
      paramqyd.setOnClickListener(this);
      return;
    }
    paramqyd.setVisibility(8);
    paramqyd.setOnClickListener(null);
  }
  
  private void bqp()
  {
    ram.i("Q.qqstory.detail.DetailInteractSegment", "start to share general feed.");
    Object localObject = new ArrayList();
    StoryVideoItem localStoryVideoItem = a((List)localObject);
    if (localStoryVideoItem == null)
    {
      ram.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
      return;
    }
    if (this.jdField_a_of_type_Qbc == null) {
      this.jdField_a_of_type_Qbc = qbc.a((Activity)this.context);
    }
    boolean bool1 = StoryVideoItem.hasPollVideo(this.jdField_a_of_type_Qru.bS());
    boolean bool2 = StoryVideoItem.hasInteractVideo(this.jdField_a_of_type_Qru.bS());
    qbc localqbc = this.jdField_a_of_type_Qbc;
    if (this.jdField_a_of_type_Qru.d.getOwner().isMe())
    {
      str = acfp.m(2131704946);
      localObject = localqbc.a(str).a(new qsx(this)).a(new qcc(localStoryVideoItem, this.jdField_a_of_type_Qru.d.feedId, ((List)localObject).size()));
      if (!bool1) {
        break label215;
      }
      str = "1";
      label168:
      localObject = ((qbc)localObject).a("vote", str);
      if (!bool2) {
        break label222;
      }
    }
    label215:
    label222:
    for (String str = "1";; str = "0")
    {
      ((qbc)localObject).a("grade", str).b();
      return;
      str = this.context.getString(2131720177);
      break;
      str = "0";
      break label168;
    }
  }
  
  private void bqq()
  {
    ram.i("Q.qqstory.detail.DetailInteractSegment", "start to share share group feed.");
    StoryVideoItem localStoryVideoItem = a(new ArrayList());
    if (localStoryVideoItem == null) {
      ram.e("Q.qqstory.detail.DetailInteractSegment", "share feed failed because there are no videos.");
    }
    ShareGroupItem localShareGroupItem;
    VideoListFeedItem localVideoListFeedItem;
    do
    {
      return;
      localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Qru.b().getOwner();
      if (this.jdField_a_of_type_Qbc == null) {
        this.jdField_a_of_type_Qbc = qbc.a((Activity)this.context);
      }
      localVideoListFeedItem = this.jdField_a_of_type_Qru.b();
    } while (localVideoListFeedItem == null);
    this.jdField_a_of_type_Qbc.a(acfp.m(2131704945) + plr.asY + acfp.m(2131704947)).a(qcf.a(localShareGroupItem, localStoryVideoItem, localVideoListFeedItem.feedId, localStoryVideoItem.mCreateTime, this.jdField_a_of_type_Qru.bS().size())).a(new qsy(this, localVideoListFeedItem)).b();
    rar.a("share_story", "share_day", 0, 0, new String[] { localShareGroupItem.getReportUserType() });
  }
  
  private void bqr()
  {
    ram.i("Q.qqstory.detail.DetailInteractSegment", "start to share banner feed.");
    if (this.jdField_a_of_type_Qbc == null) {
      this.jdField_a_of_type_Qbc = qbc.a((Activity)this.context);
    }
    this.jdField_a_of_type_Qbc.a(this.context.getString(2131720177)).a(new qsz(this)).a(new qcb(this.jdField_a_of_type_Qru.a())).b();
  }
  
  private View c(qyd paramqyd)
  {
    VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Qru.b();
    a(paramqyd);
    b(paramqyd);
    Object localObject = (ElasticImageView)paramqyd.get(2131378168);
    if (localVideoListFeedItem.getOwner().isFriend())
    {
      ((ElasticImageView)localObject).setVisibility(8);
      ((ElasticImageView)localObject).setOnClickListener(null);
      localObject = (TextView)paramqyd.get(2131382047);
      if (localVideoListFeedItem.mViewTotalTime > 0L) {
        break label102;
      }
      ram.w("Q.qqstory.detail.DetailInteractSegment", "set visit view invisible because of invalidate visit count.");
      a((TextView)localObject, 0L, 0);
    }
    for (;;)
    {
      return paramqyd.getItemView();
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
  
  private boolean fo(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    paramString = rpq.g(paramString);
    return (localCalendar.get(1) + 0 == paramString[0]) && (localCalendar.get(2) + 1 == paramString[1]) && (localCalendar.get(5) + 0 == paramString[2]);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Qru == null)
    {
      ram.e("Q.qqstory.detail.DetailInteractSegment", "bind view failed. data is invalidate.");
      return paramqyd.getItemView();
    }
    if ((this.jdField_a_of_type_Qru.Ko()) || (this.jdField_a_of_type_Qru.Kp())) {
      return c(paramqyd);
    }
    if (this.jdField_a_of_type_Qru.Kq()) {
      return b(paramqyd);
    }
    if (this.jdField_a_of_type_Qru.Kr()) {
      return a(paramqyd);
    }
    throw new IllegalStateException("detail interact segment can't recognize this feed type. type=" + this.jdField_a_of_type_Qru.d.type);
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561819, paramViewGroup, false));
    paramViewGroup = (ElasticImageView)this.b.get(2131370433);
    ElasticImageView localElasticImageView1 = (ElasticImageView)this.b.get(2131364968);
    ElasticImageView localElasticImageView2 = (ElasticImageView)this.b.get(2131378168);
    ElasticImageView localElasticImageView3 = (ElasticImageView)this.b.get(2131375150);
    TextView localTextView = (TextView)this.b.get(2131382047);
    if (QQStoryContext.isNightMode())
    {
      paramViewGroup.setImageResource(2130847343);
      localElasticImageView1.setImageResource(2130847336);
      localElasticImageView3.setImageResource(2130847389);
      localElasticImageView2.setImageResource(2130847675);
      localTextView.setTextColor(this.context.getResources().getColor(2131166761));
    }
    paramViewGroup.setOnClickListener(this);
    localElasticImageView1.setOnClickListener(this);
    return this.b;
  }
  
  public void a(qru paramqru, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qru = paramqru;
    this.mSource = paramInt1;
    this.bnW = paramInt2;
  }
  
  public void bqo()
  {
    if (((StoryDetailListView)a()).Kx())
    {
      this.isDisplay = true;
      return;
    }
    this.isDisplay = false;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null)) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "DetailInteractSegment";
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Qbc != null) {
      this.jdField_a_of_type_Qbc.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131370433: 
    case 2131364968: 
    case 2131375150: 
    case 2131378168: 
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_Qru.Kq())
          {
            localObject = (ShareGroupItem)this.jdField_a_of_type_Qru.b().getOwner();
            if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (qow.a((ShareGroupItem)localObject))) {
              QQToast.a(this.context, 1, acfp.m(2131704943), 1).show();
            }
          }
          else if ((qow.Ke()) && ((this.bnW == 63) || (this.bnW == 64)))
          {
            QQToast.a(this.context, 1, acfp.m(2131704942), 1).show();
            continue;
          }
          if (this.jdField_a_of_type_Qrn != null)
          {
            this.jdField_a_of_type_Qrn.bmr();
            continue;
            if (this.jdField_a_of_type_Qru.Kq())
            {
              localObject = (ShareGroupItem)this.jdField_a_of_type_Qru.b().getOwner();
              if ((localObject != null) && (((ShareGroupItem)localObject).type == 2) && (qow.a((ShareGroupItem)localObject))) {
                QQToast.a(this.context, 1, acfp.m(2131704948), 1).show();
              }
            }
            else if ((qow.Ke()) && ((this.bnW == 63) || (this.bnW == 64)))
            {
              QQToast.a(this.context, 1, acfp.m(2131704944), 1).show();
              continue;
            }
            if (this.jdField_a_of_type_Qrn != null) {
              this.jdField_a_of_type_Qrn.bpX();
            }
          }
        }
        i = qem.Z(this.mSource, this.bnW);
        localObject = new OpenPlayerBuilder(new SingleFeedPlayInfo(this.jdField_a_of_type_Qru.d.feedId, this.jdField_a_of_type_Qru.d.feedId, "", 1, false), i);
        qgg.a((Activity)this.context, ((OpenPlayerBuilder)localObject).b(), null);
        i = rar.b(this.jdField_a_of_type_Qru.d);
        if ((this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) {}
        for (localObject = this.jdField_a_of_type_Qru.d.getOwner().getUnionId();; localObject = "")
        {
          rar.a("home_page", "clk_play", rar.a(this.jdField_a_of_type_Qru.d), 0, new String[] { String.valueOf(i), rar.bX(this.mSource), this.jdField_a_of_type_Qru.d.feedId, localObject });
          break;
        }
      } while (rpq.isFastDoubleClick());
      if ((this.jdField_a_of_type_Qru.Ko()) || (this.jdField_a_of_type_Qru.Kp()))
      {
        bqp();
        label533:
        if (!(this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) {
          break label669;
        }
      }
      label669:
      for (localObject = this.jdField_a_of_type_Qru.d.getOwner().getUnionId();; localObject = "")
      {
        rar.a("home_page", "clk_share", rar.a(this.jdField_a_of_type_Qru.d), 0, new String[] { String.valueOf(rar.b(this.jdField_a_of_type_Qru.d)), rar.bX(this.mSource), this.jdField_a_of_type_Qru.d.feedId, localObject });
        break;
        if (this.jdField_a_of_type_Qru.Kq())
        {
          bqq();
          break label533;
        }
        if (!this.jdField_a_of_type_Qru.Kr()) {
          break label533;
        }
        bqr();
        break label533;
      }
    }
    QQStoryWatcherListActivity.i((Activity)this.context, this.jdField_a_of_type_Qru.d.feedId, this.mSource);
    int i = rar.a(this.jdField_a_of_type_Qru.d);
    if (this.jdField_a_of_type_Qru.d.getOwner().isMe()) {}
    for (Object localObject = "1";; localObject = "2")
    {
      rar.a("home_page", "clk_view_detail", i, 0, new String[] { localObject, rar.bX(this.mSource), "", this.jdField_a_of_type_Qru.d.feedId });
      break;
    }
  }
  
  public int sP()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getItemView().getMeasuredHeight();
  }
  
  public void setCallback(qrn paramqrn)
  {
    this.jdField_a_of_type_Qrn = paramqrn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsw
 * JD-Core Version:    0.7.0.1
 */