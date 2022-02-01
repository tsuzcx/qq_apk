import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.b;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qtf
  extends rsd<qru>
  implements View.OnClickListener, QQStoryAutoPlayView.a, StoryHomeHorizontalListView.a, StoryHomeHorizontalListView.b, rsn.a
{
  public static final String KEY = "GeneralFeedProfileSegment";
  private boolean FR;
  private qrn jdField_a_of_type_Qrn;
  protected qru a;
  private qvf jdField_a_of_type_Qvf;
  private String ayk;
  private qyd b;
  protected final int bnW;
  protected int mSource;
  
  public qtf(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.mSource = paramInt1;
    this.bnW = paramInt2;
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
  }
  
  private void A(List<StoryVideoItem> paramList, int paramInt) {}
  
  public static int a(qru paramqru)
  {
    int j = 2;
    int i = 1;
    if ((paramqru.Ko()) || (paramqru.Kp())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramqru.Kq()) {
        break;
      }
      if (paramqru.d.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, qyd paramqyd)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Qru.b().getOwner();
    if (localQQUserUIItem == null)
    {
      ram.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramqyd.getItemView();
    }
    Object localObject = (RelativeLayout)paramqyd.get(2131375117);
    ImageView localImageView = (ImageView)paramqyd.get(2131368398);
    TextView localTextView3 = (TextView)paramqyd.get(2131372361);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131382005);
    TextView localTextView1 = (TextView)paramqyd.get(2131375143);
    TextView localTextView2 = (TextView)paramqyd.get(2131378958);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375142);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramqyd.get(2131381732);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramqyd.get(2131374683);
    ((RelativeLayout)localObject).setOnClickListener(this);
    rpq.b(localImageView, localQQUserUIItem.headUrl, 68, 68, aqhu.F(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.g(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Qru.Kp()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Qru.a();
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).blurb)) {
        break label325;
      }
      localObject = ((GeneralRecommendFeedItem)localObject).blurb;
      label222:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label353;
      }
      localTextView1.setText((CharSequence)localObject);
      localTextView1.setVisibility(0);
      label241:
      localStoryUserBadgeView.setUnionID(localQQUserUIItem.getUnionId(), 2);
      if (!this.FR) {
        localStoryUserBadgeView.aCG();
      }
      if (!localQQUserUIItem.isMe()) {
        break label363;
      }
      c(localTextView2, 0, null);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Qru.bS(), paramqyd);
      a(paramInt, paramqyd, localRelativeLayout, localStoryHomeHorizontalListView);
      this.FR = true;
      return paramqyd.getItemView();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = qyk.t(this.jdField_a_of_type_Qru.bS());
      break label222;
      label339:
      localObject = qyk.t(this.jdField_a_of_type_Qru.bS());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (quc.a(localQQUserUIItem)) {
        c(localTextView2, 1, acfp.m(2131706933));
      } else {
        c(localTextView2, 0, null);
      }
    }
  }
  
  public static int r(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return rpq.dip2px(paramContext, 15.0F) + rpq.dip2px(paramContext, 147.0F) * paramInt - rpq.dip2px(paramContext, 2.5F);
  }
  
  public boolean R(boolean paramBoolean)
  {
    ram.d("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Qrn != null) {
      this.jdField_a_of_type_Qrn.bpV();
    }
    return true;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Qru.Ko()) || (this.jdField_a_of_type_Qru.Kp())) {
      return a(paramInt, paramqyd);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561817, paramViewGroup, false));
    this.b.q("adapter", null);
    return this.b;
  }
  
  protected void a(int paramInt, qyd paramqyd, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Qru.Kn())
    {
      rom.assertTrue(false, "general feed should have video list, but it's not a video list feed.");
      ram.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Qru.b();
      if (this.jdField_a_of_type_Qru.bS().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Qru.bS().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Qru.bS().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramqyd.get(2131375139);
      TextView localTextView = (TextView)paramqyd.get(2131375141);
      paramqyd = (TextView)paramqyd.get(2131375140);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      qyk.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramqyd.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(acfp.m(2131706932));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.isNightMode()) {
          break label344;
        }
        localTextView.setTextColor(this.context.getResources().getColor(2131166761));
        return;
        localTextView.setTextColor(-16777216);
        paramqyd.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(rpq.f(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Qru.d.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramqyd.setVisibility(0);
          paramqyd.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(rpq.aM(paramRelativeLayout.mCreateTime));
        }
        paramqyd.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (qtc)paramqyd.l("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new qtc(this.context, (FragmentActivity)this.context, this.mSource, qem.Z(this.mSource, this.bnW));
      paramqyd.q("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(2131298963));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.setStoryCoverClickListener(this);
    }
    for (paramqyd = paramRelativeLayout;; paramqyd = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.ayk)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Qru.bS().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Qru.bS().get(paramInt)).mVid.equals(this.ayk))
          {
            ram.d("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(r(this.context, paramInt));
          }
        }
        else
        {
          paramqyd.a(this.jdField_a_of_type_Qru.bS(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Qru.bS().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new qtg(this, paramStoryHomeHorizontalListView, paramqyd));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (rpq.isFastDoubleClick()) {
      return;
    }
    paramInt = qem.Z(this.mSource, this.bnW);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    qgg.a((Activity)this.context, localOpenPlayerBuilder.b(), paramView);
    paramInt = rar.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      rar.a("home_page", "clk_card", rar.a(paramVideoListFeedItem), qtc.b(paramStoryVideoItem), new String[] { String.valueOf(paramInt), rar.bX(this.mSource), paramVideoListFeedItem.feedId, paramView });
      return;
    }
  }
  
  protected void a(List<StoryVideoItem> paramList, qyd paramqyd)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramqyd.get(2131375135);
    paramqyd = (TextView)paramqyd.get(2131375136);
    if ((paramList == null) || (paramList.size() < 1))
    {
      localLinearLayout.setVisibility(8);
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      if (!((StoryVideoItem)paramList.next()).isUploadFail()) {
        break label137;
      }
      i += 1;
    }
    label137:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localLinearLayout.setVisibility(0);
        localLinearLayout.setOnClickListener(this);
        paramqyd.setText(ppf.getString(2131701957, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void aXi() {}
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void bqs()
  {
    wB(a(this.jdField_a_of_type_Qru));
  }
  
  public void bqt() {}
  
  protected void c(TextView paramTextView, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramTextView.setVisibility(8);
      paramTextView.setOnClickListener(null);
    }
    for (;;)
    {
      if (QQStoryContext.isNightMode())
      {
        paramTextView.setTextColor(this.context.getResources().getColor(2131166761));
        paramTextView.setBackgroundResource(2130847411);
      }
      return;
      paramInt = rpq.dip2px(this.context, 13.0F);
      int i = rpq.dip2px(this.context, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.context.getResources().getColor(2131167304));
      paramTextView.setBackgroundResource(2130847410);
      paramTextView.setPadding(paramInt, i, paramInt, i);
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
      continue;
      paramTextView.setText(paramString);
      paramTextView.setTextColor(-13844490);
      paramTextView.setBackgroundDrawable(null);
      paramTextView.setPadding(0, 0, 0, 0);
      paramTextView.setVisibility(0);
      paramTextView.setOnClickListener(this);
    }
  }
  
  public void c(qru paramqru)
  {
    ram.b("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramqru);
    this.jdField_a_of_type_Qru = paramqru;
  }
  
  public void dh(int paramInt1, int paramInt2)
  {
    this.ayk = null;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null) && ((this.jdField_a_of_type_Qru.Ko()) || (this.jdField_a_of_type_Qru.Kp())) && (this.jdField_a_of_type_Qru.bS().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Qru.Ko()) || (this.jdField_a_of_type_Qru.Kp()))
      {
        Object localObject1 = (QQUserUIItem)this.jdField_a_of_type_Qru.b().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          A(this.jdField_a_of_type_Qru.bS(), this.jdField_a_of_type_Qru.b().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          Object localObject2 = (pma)qem.getQQAppInterface().getBusinessHandler(98);
          if (this.jdField_a_of_type_Qru.Kp()) {}
          for (int i = 11;; i = 7)
          {
            ((pma)localObject2).b(1, this.jdField_a_of_type_Qru.d.ownerId, 0, i);
            ((QQUserUIItem)localObject1).isSubscribe = 1;
            paramView.setVisibility(4);
            if (!this.jdField_a_of_type_Qru.Kp()) {
              break;
            }
            rar.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Qru.d.feedId });
            break;
          }
          wB(a(this.jdField_a_of_type_Qru));
          rar.a("home_page", "clk_head_nick", rar.a(this.jdField_a_of_type_Qru.d), 0, new String[] { String.valueOf(rar.b(this.jdField_a_of_type_Qru.d)), "2", this.jdField_a_of_type_Qru.d.feedId, "" });
          continue;
          if (this.jdField_a_of_type_Qru.bS() != null)
          {
            localObject1 = new ArrayList();
            localObject2 = this.jdField_a_of_type_Qru.bS().iterator();
            int j;
            for (i = 0; ((Iterator)localObject2).hasNext(); i = j)
            {
              StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
              j = i;
              if (localStoryVideoItem.isUploadFail())
              {
                j = i + 1;
                ((List)localObject1).add(localStoryVideoItem);
              }
            }
            if (i > 0)
            {
              pnx.a((List)localObject1, (Activity)this.context);
              j = rar.a(this.jdField_a_of_type_Qru.d);
              if (this.jdField_a_of_type_Qru.d.getOwner().isMe()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                rar.a("home_page", "clk_retry", j, 0, new String[] { localObject1, rar.bX(this.mSource), String.valueOf(i), this.jdField_a_of_type_Qru.d.feedId });
                break;
              }
            }
          }
          else
          {
            ram.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
            continue;
            localObject1 = (String)paramView.getTag();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new Intent(this.context, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", (String)localObject1);
              this.context.startActivity((Intent)localObject2);
            }
          }
        }
      }
    }
  }
  
  public void rX(String paramString)
  {
    ram.b("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.ayk = paramString;
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
  
  protected void wB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ppf.f(this.context, 4, this.jdField_a_of_type_Qru.d.ownerId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtf
 * JD-Core Version:    0.7.0.1
 */