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

public class ush
  extends wcr<ups>
  implements View.OnClickListener, uyk, vds, vdt, wdg
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private upc jdField_a_of_type_Upc;
  protected ups a;
  private uwa jdField_a_of_type_Uwa;
  private vas jdField_a_of_type_Vas;
  protected final int b;
  private boolean b;
  
  public ush(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return vzo.a(paramContext, 15.0F) + vzo.a(paramContext, 147.0F) * paramInt - vzo.a(paramContext, 2.5F);
  }
  
  public static int a(ups paramups)
  {
    int j = 2;
    int i = 1;
    if ((paramups.d()) || (paramups.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramups.f()) {
        break;
      }
      if (paramups.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, vas paramvas)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Ups.a().getOwner();
    if (localQQUserUIItem == null)
    {
      veg.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramvas.a();
    }
    Object localObject = (RelativeLayout)paramvas.a(2131373233);
    ImageView localImageView = (ImageView)paramvas.a(2131367399);
    TextView localTextView3 = (TextView)paramvas.a(2131370809);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvas.a(2131379251);
    TextView localTextView1 = (TextView)paramvas.a(2131373259);
    TextView localTextView2 = (TextView)paramvas.a(2131376659);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373258);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvas.a(2131379014);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramvas.a(2131372835);
    ((RelativeLayout)localObject).setOnClickListener(this);
    vzo.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bbdr.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Ups.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Ups.a();
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
      a(this.jdField_a_of_type_Ups.a(), paramvas);
      a(paramInt, paramvas, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramvas.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = vbd.a(this.jdField_a_of_type_Ups.a());
      break label222;
      label339:
      localObject = vbd.a(this.jdField_a_of_type_Ups.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (uub.a(localQQUserUIItem)) {
        a(localTextView2, 1, ajyc.a(2131705236));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void P_()
  {
    a(a(this.jdField_a_of_type_Ups));
  }
  
  public void Q_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && ((this.jdField_a_of_type_Ups.d()) || (this.jdField_a_of_type_Ups.e())) && (this.jdField_a_of_type_Ups.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ups.d()) || (this.jdField_a_of_type_Ups.e())) {
      return a(paramInt, paramvas);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561217, paramViewGroup, false));
    this.jdField_a_of_type_Vas.a("adapter", null);
    return this.jdField_a_of_type_Vas;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    sxp.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Ups.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, vas paramvas, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Ups.c())
    {
      vxs.a(false, "general feed should have video list, but it's not a video list feed.");
      veg.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Ups.a();
      if (this.jdField_a_of_type_Ups.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Ups.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Ups.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramvas.a(2131373255);
      TextView localTextView = (TextView)paramvas.a(2131373257);
      paramvas = (TextView)paramvas.a(2131373256);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      vbd.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramvas.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(ajyc.a(2131705235));
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
        paramvas.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(vzo.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramvas.setVisibility(0);
          paramvas.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(vzo.b(paramRelativeLayout.mCreateTime));
        }
        paramvas.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (use)paramvas.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new use(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, tsu.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramvas.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298330));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramvas = paramRelativeLayout;; paramvas = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Ups.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Ups.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            veg.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramvas.a(this.jdField_a_of_type_Ups.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Ups.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new usi(this, paramStoryHomeHorizontalListView, paramvas));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vzo.b()) {
      return;
    }
    paramInt = tsu.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    tvf.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = vel.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      vel.a("home_page", "clk_card", vel.a(paramVideoListFeedItem), use.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), vel.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setBackgroundResource(2130845632);
      }
      return;
      paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = vzo.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      paramTextView.setBackgroundResource(2130845631);
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
    veg.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, vas paramvas)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramvas.a(2131373251);
    paramvas = (TextView)paramvas.a(2131373252);
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
        paramvas.setText(sxp.a(2131699705, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
  }
  
  public void a(ups paramups)
  {
    veg.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramups);
    this.jdField_a_of_type_Ups = paramups;
  }
  
  public boolean a(boolean paramBoolean)
  {
    veg.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Upc != null) {
      this.jdField_a_of_type_Upc.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vas == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vas.a().getMeasuredHeight();
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
          } while ((!this.jdField_a_of_type_Ups.d()) && (!this.jdField_a_of_type_Ups.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_Ups.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_Ups.a(), this.jdField_a_of_type_Ups.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (ssv)tsu.a().a(98);
        if (this.jdField_a_of_type_Ups.e()) {}
        for (i = 11;; i = 7)
        {
          ((ssv)localObject2).a(1, this.jdField_a_of_type_Ups.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_Ups.e()) {
            break;
          }
          vel.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Ups.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_Ups));
        vel.a("home_page", "clk_head_nick", vel.a(this.jdField_a_of_type_Ups.a), 0, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_Ups.a)), "2", this.jdField_a_of_type_Ups.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_Ups.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_Ups.a().iterator();
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
      svo.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = vel.a(this.jdField_a_of_type_Ups.a);
      if (this.jdField_a_of_type_Ups.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        vel.a("home_page", "clk_retry", j, 0, new String[] { paramView, vel.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Ups.a.feedId });
        return;
      }
      veg.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */