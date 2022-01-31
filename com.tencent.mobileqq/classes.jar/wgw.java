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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wgw
  extends xrg<weh>
  implements View.OnClickListener, wmz, wsh, wsi, xrv
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private wdr jdField_a_of_type_Wdr;
  protected weh a;
  private wkp jdField_a_of_type_Wkp;
  private wph jdField_a_of_type_Wph;
  protected final int b;
  private boolean b;
  
  public wgw(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return xod.a(paramContext, 15.0F) + xod.a(paramContext, 147.0F) * paramInt - xod.a(paramContext, 2.5F);
  }
  
  public static int a(weh paramweh)
  {
    int j = 2;
    int i = 1;
    if ((paramweh.d()) || (paramweh.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramweh.f()) {
        break;
      }
      if (paramweh.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, wph paramwph)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Weh.a().getOwner();
    if (localQQUserUIItem == null)
    {
      wsv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramwph.a();
    }
    Object localObject = (RelativeLayout)paramwph.a(2131373684);
    ImageView localImageView = (ImageView)paramwph.a(2131367528);
    TextView localTextView3 = (TextView)paramwph.a(2131371120);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwph.a(2131379957);
    TextView localTextView1 = (TextView)paramwph.a(2131373710);
    TextView localTextView2 = (TextView)paramwph.a(2131377171);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373709);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwph.a(2131379688);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramwph.a(2131373275);
    ((RelativeLayout)localObject).setOnClickListener(this);
    xod.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bdda.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Weh.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Weh.a();
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
      a(this.jdField_a_of_type_Weh.a(), paramwph);
      a(paramInt, paramwph, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramwph.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = wps.a(this.jdField_a_of_type_Weh.a());
      break label222;
      label339:
      localObject = wps.a(this.jdField_a_of_type_Weh.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (wiq.a(localQQUserUIItem)) {
        a(localTextView2, 1, alpo.a(2131705619));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void X_()
  {
    a(a(this.jdField_a_of_type_Weh));
  }
  
  public void Y_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && ((this.jdField_a_of_type_Weh.d()) || (this.jdField_a_of_type_Weh.e())) && (this.jdField_a_of_type_Weh.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Weh.d()) || (this.jdField_a_of_type_Weh.e())) {
      return a(paramInt, paramwph);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561406, paramViewGroup, false));
    this.jdField_a_of_type_Wph.a("adapter", null);
    return this.jdField_a_of_type_Wph;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ume.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Weh.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, wph paramwph, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Weh.c())
    {
      xmh.a(false, "general feed should have video list, but it's not a video list feed.");
      wsv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Weh.a();
      if (this.jdField_a_of_type_Weh.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Weh.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Weh.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramwph.a(2131373706);
      TextView localTextView = (TextView)paramwph.a(2131373708);
      paramwph = (TextView)paramwph.a(2131373707);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      wps.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramwph.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(alpo.a(2131705618));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
        return;
        localTextView.setTextColor(-16777216);
        paramwph.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(xod.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Weh.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramwph.setVisibility(0);
          paramwph.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(xod.b(paramRelativeLayout.mCreateTime));
        }
        paramwph.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (wgt)paramwph.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new wgt(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, vhj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramwph.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298356));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramwph = paramRelativeLayout;; paramwph = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Weh.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Weh.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            wsv.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramwph.a(this.jdField_a_of_type_Weh.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Weh.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new wgx(this, paramStoryHomeHorizontalListView, paramwph));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (xod.b()) {
      return;
    }
    paramInt = vhj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    vju.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = wta.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      wta.a("home_page", "clk_card", wta.a(paramVideoListFeedItem), wgt.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), wta.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
        paramTextView.setBackgroundResource(2130846017);
      }
      return;
      paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = xod.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166901));
      paramTextView.setBackgroundResource(2130846016);
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
    wsv.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, wph paramwph)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramwph.a(2131373702);
    paramwph = (TextView)paramwph.a(2131373703);
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
        paramwph.setText(ume.a(2131700085, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_Wdr = paramwdr;
  }
  
  public void a(weh paramweh)
  {
    wsv.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramweh);
    this.jdField_a_of_type_Weh = paramweh;
  }
  
  public boolean a(boolean paramBoolean)
  {
    wsv.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Wdr != null) {
      this.jdField_a_of_type_Wdr.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wph == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wph.a().getMeasuredHeight();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return;
          } while ((!this.jdField_a_of_type_Weh.d()) && (!this.jdField_a_of_type_Weh.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_Weh.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_Weh.a(), this.jdField_a_of_type_Weh.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (uhk)vhj.a().a(98);
        if (this.jdField_a_of_type_Weh.e()) {}
        for (i = 11;; i = 7)
        {
          ((uhk)localObject2).a(1, this.jdField_a_of_type_Weh.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_Weh.e()) {
            break;
          }
          wta.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Weh.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_Weh));
        wta.a("home_page", "clk_head_nick", wta.a(this.jdField_a_of_type_Weh.a), 0, new String[] { String.valueOf(wta.b(this.jdField_a_of_type_Weh.a)), "2", this.jdField_a_of_type_Weh.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_Weh.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_Weh.a().iterator();
        for (i = 0; ((Iterator)localObject1).hasNext(); i = j)
        {
          localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
          j = i;
          if (((StoryVideoItem)localObject2).isUploadFail())
          {
            j = i + 1;
            paramView.add(localObject2);
          }
        }
      } while (i <= 0);
      ukd.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = wta.a(this.jdField_a_of_type_Weh.a);
      if (this.jdField_a_of_type_Weh.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        wta.a("home_page", "clk_retry", j, 0, new String[] { paramView, wta.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Weh.a.feedId });
        return;
      }
      wsv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgw
 * JD-Core Version:    0.7.0.1
 */