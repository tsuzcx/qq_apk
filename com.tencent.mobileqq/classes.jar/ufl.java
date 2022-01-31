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

public class ufl
  extends vpv<ucw>
  implements View.OnClickListener, ulo, uqw, uqx, vqk
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private ucg jdField_a_of_type_Ucg;
  protected ucw a;
  private uje jdField_a_of_type_Uje;
  private unw jdField_a_of_type_Unw;
  protected final int b;
  private boolean b;
  
  public ufl(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return vms.a(paramContext, 15.0F) + vms.a(paramContext, 147.0F) * paramInt - vms.a(paramContext, 2.5F);
  }
  
  public static int a(ucw paramucw)
  {
    int j = 2;
    int i = 1;
    if ((paramucw.d()) || (paramucw.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramucw.f()) {
        break;
      }
      if (paramucw.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, unw paramunw)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Ucw.a().getOwner();
    if (localQQUserUIItem == null)
    {
      urk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramunw.a();
    }
    Object localObject = (RelativeLayout)paramunw.a(2131307520);
    ImageView localImageView = (ImageView)paramunw.a(2131301789);
    TextView localTextView3 = (TextView)paramunw.a(2131305136);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramunw.a(2131313417);
    TextView localTextView1 = (TextView)paramunw.a(2131307546);
    TextView localTextView2 = (TextView)paramunw.a(2131310852);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307545);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramunw.a(2131313179);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramunw.a(2131307123);
    ((RelativeLayout)localObject).setOnClickListener(this);
    vms.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bacm.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Ucw.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Ucw.a();
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
      a(this.jdField_a_of_type_Ucw.a(), paramunw);
      a(paramInt, paramunw, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramunw.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = uoh.a(this.jdField_a_of_type_Ucw.a());
      break label222;
      label339:
      localObject = uoh.a(this.jdField_a_of_type_Ucw.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (uhf.a(localQQUserUIItem)) {
        a(localTextView2, 1, ajjy.a(2131639451));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void R_()
  {
    a(a(this.jdField_a_of_type_Ucw));
  }
  
  public void S_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && ((this.jdField_a_of_type_Ucw.d()) || (this.jdField_a_of_type_Ucw.e())) && (this.jdField_a_of_type_Ucw.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ucw.d()) || (this.jdField_a_of_type_Ucw.e())) {
      return a(paramInt, paramunw);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495626, paramViewGroup, false));
    this.jdField_a_of_type_Unw.a("adapter", null);
    return this.jdField_a_of_type_Unw;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    skt.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Ucw.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, unw paramunw, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Ucw.c())
    {
      vkw.a(false, "general feed should have video list, but it's not a video list feed.");
      urk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Ucw.a();
      if (this.jdField_a_of_type_Ucw.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Ucw.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Ucw.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramunw.a(2131307542);
      TextView localTextView = (TextView)paramunw.a(2131307544);
      paramunw = (TextView)paramunw.a(2131307543);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      uoh.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramunw.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(ajjy.a(2131639450));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
        return;
        localTextView.setTextColor(-16777216);
        paramunw.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(vms.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramunw.setVisibility(0);
          paramunw.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(vms.b(paramRelativeLayout.mCreateTime));
        }
        paramunw.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (ufi)paramunw.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new ufi(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, tfy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramunw.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167237));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramunw = paramRelativeLayout;; paramunw = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Ucw.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Ucw.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            urk.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramunw.a(this.jdField_a_of_type_Ucw.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Ucw.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new ufm(this, paramStoryHomeHorizontalListView, paramunw));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vms.b()) {
      return;
    }
    paramInt = tfy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    tij.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = urp.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      urp.a("home_page", "clk_card", urp.a(paramVideoListFeedItem), ufi.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), urp.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
        paramTextView.setBackgroundResource(2130845448);
      }
      return;
      paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = vms.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
      paramTextView.setBackgroundResource(2130845447);
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
    urk.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, unw paramunw)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramunw.a(2131307538);
    paramunw = (TextView)paramunw.a(2131307539);
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
        paramunw.setText(skt.a(2131633917, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void a(ucw paramucw)
  {
    urk.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramucw);
    this.jdField_a_of_type_Ucw = paramucw;
  }
  
  public boolean a(boolean paramBoolean)
  {
    urk.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Ucg != null) {
      this.jdField_a_of_type_Ucg.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Unw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Unw.a().getMeasuredHeight();
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
          } while ((!this.jdField_a_of_type_Ucw.d()) && (!this.jdField_a_of_type_Ucw.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_Ucw.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_Ucw.a(), this.jdField_a_of_type_Ucw.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (sfz)tfy.a().a(98);
        if (this.jdField_a_of_type_Ucw.e()) {}
        for (i = 11;; i = 7)
        {
          ((sfz)localObject2).a(1, this.jdField_a_of_type_Ucw.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_Ucw.e()) {
            break;
          }
          urp.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Ucw.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_Ucw));
        urp.a("home_page", "clk_head_nick", urp.a(this.jdField_a_of_type_Ucw.a), 0, new String[] { String.valueOf(urp.b(this.jdField_a_of_type_Ucw.a)), "2", this.jdField_a_of_type_Ucw.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_Ucw.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_Ucw.a().iterator();
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
      sis.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = urp.a(this.jdField_a_of_type_Ucw.a);
      if (this.jdField_a_of_type_Ucw.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        urp.a("home_page", "clk_retry", j, 0, new String[] { paramView, urp.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Ucw.a.feedId });
        return;
      }
      urk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */