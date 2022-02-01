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
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class yeq
  extends zpa<ycb>
  implements View.OnClickListener, ykt, yqb, yqc, zpp
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private ybl jdField_a_of_type_Ybl;
  protected ycb a;
  private yij jdField_a_of_type_Yij;
  private ynb jdField_a_of_type_Ynb;
  protected final int b;
  private boolean b;
  
  public yeq(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return zlx.a(paramContext, 15.0F) + zlx.a(paramContext, 147.0F) * paramInt - zlx.a(paramContext, 2.5F);
  }
  
  public static int a(ycb paramycb)
  {
    int j = 2;
    int i = 1;
    if ((paramycb.d()) || (paramycb.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramycb.f()) {
        break;
      }
      if (paramycb.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, ynb paramynb)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Ycb.a().getOwner();
    if (localQQUserUIItem == null)
    {
      yqp.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramynb.a();
    }
    Object localObject = (RelativeLayout)paramynb.a(2131374438);
    ImageView localImageView = (ImageView)paramynb.a(2131367849);
    TextView localTextView3 = (TextView)paramynb.a(2131371697);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramynb.a(2131380975);
    TextView localTextView1 = (TextView)paramynb.a(2131374464);
    TextView localTextView2 = (TextView)paramynb.a(2131378036);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramynb.a(2131374463);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramynb.a(2131380702);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramynb.a(2131374027);
    ((RelativeLayout)localObject).setOnClickListener(this);
    zlx.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bgmo.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Ycb.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Ycb.a();
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
      if (!this.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      if (!localQQUserUIItem.isMe()) {
        break label363;
      }
      a(localTextView2, 0, null);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Ycb.a(), paramynb);
      a(paramInt, paramynb, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramynb.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = ynm.a(this.jdField_a_of_type_Ycb.a());
      break label222;
      label339:
      localObject = ynm.a(this.jdField_a_of_type_Ycb.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (ygk.a(localQQUserUIItem)) {
        a(localTextView2, 1, anni.a(2131704027));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void R_()
  {
    a(a(this.jdField_a_of_type_Ycb));
  }
  
  public void S_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null) && ((this.jdField_a_of_type_Ycb.d()) || (this.jdField_a_of_type_Ycb.e())) && (this.jdField_a_of_type_Ycb.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ycb.d()) || (this.jdField_a_of_type_Ycb.e())) {
      return a(paramInt, paramynb);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561660, paramViewGroup, false));
    this.jdField_a_of_type_Ynb.a("adapter", null);
    return this.jdField_a_of_type_Ynb;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wjz.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Ycb.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, ynb paramynb, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Ycb.c())
    {
      zkb.a(false, "general feed should have video list, but it's not a video list feed.");
      yqp.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Ycb.a();
      if (this.jdField_a_of_type_Ycb.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Ycb.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Ycb.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramynb.a(2131374460);
      TextView localTextView = (TextView)paramynb.a(2131374462);
      paramynb = (TextView)paramynb.a(2131374461);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      ynm.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramynb.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(anni.a(2131704026));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
        return;
        localTextView.setTextColor(-16777216);
        paramynb.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(zlx.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramynb.setVisibility(0);
          paramynb.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(zlx.b(paramRelativeLayout.mCreateTime));
        }
        paramynb.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (yen)paramynb.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new yen(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, xfe.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramynb.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298438));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramynb = paramRelativeLayout;; paramynb = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Ycb.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Ycb.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            yqp.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramynb.a(this.jdField_a_of_type_Ycb.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Ycb.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new yer(this, paramStoryHomeHorizontalListView, paramynb));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (zlx.b()) {
      return;
    }
    paramInt = xfe.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    xho.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = yqu.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      yqu.a("home_page", "clk_card", yqu.a(paramVideoListFeedItem), yen.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), yqu.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
      return;
    }
  }
  
  protected void a(TextView paramTextView, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramTextView.setVisibility(8);
      paramTextView.setOnClickListener(null);
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
        paramTextView.setBackgroundResource(2130846529);
      }
      return;
      paramInt = zlx.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = zlx.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
      paramTextView.setBackgroundResource(2130846528);
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
  
  public void a(String paramString)
  {
    yqp.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, ynb paramynb)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramynb.a(2131374456);
    paramynb = (TextView)paramynb.a(2131374457);
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
        paramynb.setText(wjz.a(2131698523, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_Ybl = paramybl;
  }
  
  public void a(ycb paramycb)
  {
    yqp.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramycb);
    this.jdField_a_of_type_Ycb = paramycb;
  }
  
  public boolean a(boolean paramBoolean)
  {
    yqp.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Ybl != null) {
      this.jdField_a_of_type_Ybl.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Ynb == null) {
      return 0;
    }
    return this.jdField_a_of_type_Ynb.a().getMeasuredHeight();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Ycb.d()) || (this.jdField_a_of_type_Ycb.e()))
      {
        Object localObject1 = (QQUserUIItem)this.jdField_a_of_type_Ycb.a().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          a(this.jdField_a_of_type_Ycb.a(), this.jdField_a_of_type_Ycb.a().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          Object localObject2 = (wff)xfe.a().a(98);
          if (this.jdField_a_of_type_Ycb.e()) {}
          for (int i = 11;; i = 7)
          {
            ((wff)localObject2).a(1, this.jdField_a_of_type_Ycb.a.ownerId, 0, i);
            ((QQUserUIItem)localObject1).isSubscribe = 1;
            paramView.setVisibility(4);
            if (!this.jdField_a_of_type_Ycb.e()) {
              break;
            }
            yqu.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Ycb.a.feedId });
            break;
          }
          a(a(this.jdField_a_of_type_Ycb));
          yqu.a("home_page", "clk_head_nick", yqu.a(this.jdField_a_of_type_Ycb.a), 0, new String[] { String.valueOf(yqu.b(this.jdField_a_of_type_Ycb.a)), "2", this.jdField_a_of_type_Ycb.a.feedId, "" });
          continue;
          if (this.jdField_a_of_type_Ycb.a() != null)
          {
            localObject1 = new ArrayList();
            localObject2 = this.jdField_a_of_type_Ycb.a().iterator();
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
              why.a((List)localObject1, (Activity)this.jdField_a_of_type_AndroidContentContext);
              j = yqu.a(this.jdField_a_of_type_Ycb.a);
              if (this.jdField_a_of_type_Ycb.a.getOwner().isMe()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                yqu.a("home_page", "clk_retry", j, 0, new String[] { localObject1, yqu.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Ycb.a.feedId });
                break;
              }
            }
          }
          else
          {
            yqp.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
            continue;
            localObject1 = (String)paramView.getTag();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", (String)localObject1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeq
 * JD-Core Version:    0.7.0.1
 */