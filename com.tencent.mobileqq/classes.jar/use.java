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

public class use
  extends wco<upp>
  implements View.OnClickListener, uyh, vdp, vdq, wdd
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private uoz jdField_a_of_type_Uoz;
  protected upp a;
  private uvx jdField_a_of_type_Uvx;
  private vap jdField_a_of_type_Vap;
  protected final int b;
  private boolean b;
  
  public use(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return vzl.a(paramContext, 15.0F) + vzl.a(paramContext, 147.0F) * paramInt - vzl.a(paramContext, 2.5F);
  }
  
  public static int a(upp paramupp)
  {
    int j = 2;
    int i = 1;
    if ((paramupp.d()) || (paramupp.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramupp.f()) {
        break;
      }
      if (paramupp.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, vap paramvap)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Upp.a().getOwner();
    if (localQQUserUIItem == null)
    {
      ved.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramvap.a();
    }
    Object localObject = (RelativeLayout)paramvap.a(2131373235);
    ImageView localImageView = (ImageView)paramvap.a(2131367399);
    TextView localTextView3 = (TextView)paramvap.a(2131370809);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131379256);
    TextView localTextView1 = (TextView)paramvap.a(2131373261);
    TextView localTextView2 = (TextView)paramvap.a(2131376661);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373260);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvap.a(2131379019);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramvap.a(2131372837);
    ((RelativeLayout)localObject).setOnClickListener(this);
    vzl.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bbef.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Upp.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Upp.a();
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
      a(this.jdField_a_of_type_Upp.a(), paramvap);
      a(paramInt, paramvap, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramvap.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = vba.a(this.jdField_a_of_type_Upp.a());
      break label222;
      label339:
      localObject = vba.a(this.jdField_a_of_type_Upp.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (uty.a(localQQUserUIItem)) {
        a(localTextView2, 1, ajya.a(2131705247));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void P_()
  {
    a(a(this.jdField_a_of_type_Upp));
  }
  
  public void Q_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && ((this.jdField_a_of_type_Upp.d()) || (this.jdField_a_of_type_Upp.e())) && (this.jdField_a_of_type_Upp.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Upp.d()) || (this.jdField_a_of_type_Upp.e())) {
      return a(paramInt, paramvap);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561216, paramViewGroup, false));
    this.jdField_a_of_type_Vap.a("adapter", null);
    return this.jdField_a_of_type_Vap;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    sxm.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Upp.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, vap paramvap, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Upp.c())
    {
      vxp.a(false, "general feed should have video list, but it's not a video list feed.");
      ved.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Upp.a();
      if (this.jdField_a_of_type_Upp.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Upp.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Upp.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramvap.a(2131373257);
      TextView localTextView = (TextView)paramvap.a(2131373259);
      paramvap = (TextView)paramvap.a(2131373258);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      vba.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramvap.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(ajya.a(2131705246));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        return;
        localTextView.setTextColor(-16777216);
        paramvap.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(vzl.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramvap.setVisibility(0);
          paramvap.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(vzl.b(paramRelativeLayout.mCreateTime));
        }
        paramvap.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (usb)paramvap.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new usb(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, tsr.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramvap.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298330));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramvap = paramRelativeLayout;; paramvap = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Upp.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Upp.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            ved.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramvap.a(this.jdField_a_of_type_Upp.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Upp.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new usf(this, paramStoryHomeHorizontalListView, paramvap));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vzl.b()) {
      return;
    }
    paramInt = tsr.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    tvc.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = vei.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      vei.a("home_page", "clk_card", vei.a(paramVideoListFeedItem), usb.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), vei.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        paramTextView.setBackgroundResource(2130845638);
      }
      return;
      paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      paramTextView.setBackgroundResource(2130845637);
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
    ved.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, vap paramvap)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramvap.a(2131373253);
    paramvap = (TextView)paramvap.a(2131373254);
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
        paramvap.setText(sxm.a(2131699716, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
  }
  
  public void a(upp paramupp)
  {
    ved.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramupp);
    this.jdField_a_of_type_Upp = paramupp;
  }
  
  public boolean a(boolean paramBoolean)
  {
    ved.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Uoz != null) {
      this.jdField_a_of_type_Uoz.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vap == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vap.a().getMeasuredHeight();
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
          } while ((!this.jdField_a_of_type_Upp.d()) && (!this.jdField_a_of_type_Upp.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_Upp.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_Upp.a(), this.jdField_a_of_type_Upp.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (sss)tsr.a().a(98);
        if (this.jdField_a_of_type_Upp.e()) {}
        for (i = 11;; i = 7)
        {
          ((sss)localObject2).a(1, this.jdField_a_of_type_Upp.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_Upp.e()) {
            break;
          }
          vei.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Upp.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_Upp));
        vei.a("home_page", "clk_head_nick", vei.a(this.jdField_a_of_type_Upp.a), 0, new String[] { String.valueOf(vei.b(this.jdField_a_of_type_Upp.a)), "2", this.jdField_a_of_type_Upp.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_Upp.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_Upp.a().iterator();
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
      svl.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = vei.a(this.jdField_a_of_type_Upp.a);
      if (this.jdField_a_of_type_Upp.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        vei.a("home_page", "clk_retry", j, 0, new String[] { paramView, vei.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Upp.a.feedId });
        return;
      }
      ved.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     use
 * JD-Core Version:    0.7.0.1
 */