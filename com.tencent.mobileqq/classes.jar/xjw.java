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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xjw
  extends ysg<xhh>
  implements View.OnClickListener, xpz, xvh, xvi, ysv
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private xgr jdField_a_of_type_Xgr;
  protected xhh a;
  private xnp jdField_a_of_type_Xnp;
  private xsh jdField_a_of_type_Xsh;
  protected final int b;
  private boolean b;
  
  public xjw(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return UIUtils.dip2px(paramContext, 15.0F) + UIUtils.dip2px(paramContext, 147.0F) * paramInt - UIUtils.dip2px(paramContext, 2.5F);
  }
  
  public static int a(xhh paramxhh)
  {
    int j = 2;
    int i = 1;
    if ((paramxhh.d()) || (paramxhh.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramxhh.f()) {
        break;
      }
      if (paramxhh.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, xsh paramxsh)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Xhh.a().getOwner();
    if (localQQUserUIItem == null)
    {
      xvv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramxsh.a();
    }
    Object localObject = (RelativeLayout)paramxsh.a(2131374343);
    ImageView localImageView = (ImageView)paramxsh.a(2131367950);
    TextView localTextView3 = (TextView)paramxsh.a(2131371769);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramxsh.a(2131380874);
    TextView localTextView1 = (TextView)paramxsh.a(2131374369);
    TextView localTextView2 = (TextView)paramxsh.a(2131377961);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374368);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramxsh.a(2131380606);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramxsh.a(2131373909);
    ((RelativeLayout)localObject).setOnClickListener(this);
    UIUtils.setCircleViewByURL(localImageView, localQQUserUIItem.headUrl, 68, 68, bfvo.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Xhh.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Xhh.a();
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
      a(this.jdField_a_of_type_Xhh.a(), paramxsh);
      a(paramInt, paramxsh, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramxsh.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = xss.a(this.jdField_a_of_type_Xhh.a());
      break label222;
      label339:
      localObject = xss.a(this.jdField_a_of_type_Xhh.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (xlq.a(localQQUserUIItem)) {
        a(localTextView2, 1, amtj.a(2131704363));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void L_()
  {
    a(a(this.jdField_a_of_type_Xhh));
  }
  
  public void M_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && ((this.jdField_a_of_type_Xhh.d()) || (this.jdField_a_of_type_Xhh.e())) && (this.jdField_a_of_type_Xhh.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Xhh.d()) || (this.jdField_a_of_type_Xhh.e())) {
      return a(paramInt, paramxsh);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561581, paramViewGroup, false));
    this.jdField_a_of_type_Xsh.a("adapter", null);
    return this.jdField_a_of_type_Xsh;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    vpl.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Xhh.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, xsh paramxsh, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Xhh.c())
    {
      yos.a(false, "general feed should have video list, but it's not a video list feed.");
      xvv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Xhh.a();
      if (this.jdField_a_of_type_Xhh.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Xhh.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Xhh.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramxsh.a(2131374365);
      TextView localTextView = (TextView)paramxsh.a(2131374367);
      paramxsh = (TextView)paramxsh.a(2131374366);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      xss.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramxsh.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(amtj.a(2131704362));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
        return;
        localTextView.setTextColor(-16777216);
        paramxsh.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(UIUtils.convertToHHMM(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramxsh.setVisibility(0);
          paramxsh.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(UIUtils.convertToHHMM(paramRelativeLayout.mCreateTime));
        }
        paramxsh.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (xjt)paramxsh.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new xjt(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, wkp.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramxsh.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298516));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramxsh = paramRelativeLayout;; paramxsh = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Xhh.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Xhh.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            xvv.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramxsh.a(this.jdField_a_of_type_Xhh.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Xhh.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new xjx(this, paramStoryHomeHorizontalListView, paramxsh));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.isFastDoubleClick()) {
      return;
    }
    paramInt = wkp.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    wmu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = xwa.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      xwa.a("home_page", "clk_card", xwa.a(paramVideoListFeedItem), xjt.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), xwa.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
        paramTextView.setBackgroundResource(2130846454);
      }
      return;
      paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167012));
      paramTextView.setBackgroundResource(2130846453);
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
    xvv.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, xsh paramxsh)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramxsh.a(2131374361);
    paramxsh = (TextView)paramxsh.a(2131374362);
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
        paramxsh.setText(vpl.a(2131698865, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_Xgr = paramxgr;
  }
  
  public void a(xhh paramxhh)
  {
    xvv.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramxhh);
    this.jdField_a_of_type_Xhh = paramxhh;
  }
  
  public boolean a(boolean paramBoolean)
  {
    xvv.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Xgr != null) {
      this.jdField_a_of_type_Xgr.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Xsh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xsh.a().getMeasuredHeight();
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
      if ((this.jdField_a_of_type_Xhh.d()) || (this.jdField_a_of_type_Xhh.e()))
      {
        Object localObject1 = (QQUserUIItem)this.jdField_a_of_type_Xhh.a().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          a(this.jdField_a_of_type_Xhh.a(), this.jdField_a_of_type_Xhh.a().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          Object localObject2 = (vkz)wkp.a().getBusinessHandler(98);
          if (this.jdField_a_of_type_Xhh.e()) {}
          for (int i = 11;; i = 7)
          {
            ((vkz)localObject2).a(1, this.jdField_a_of_type_Xhh.a.ownerId, 0, i);
            ((QQUserUIItem)localObject1).isSubscribe = 1;
            paramView.setVisibility(4);
            if (!this.jdField_a_of_type_Xhh.e()) {
              break;
            }
            xwa.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Xhh.a.feedId });
            break;
          }
          a(a(this.jdField_a_of_type_Xhh));
          xwa.a("home_page", "clk_head_nick", xwa.a(this.jdField_a_of_type_Xhh.a), 0, new String[] { String.valueOf(xwa.b(this.jdField_a_of_type_Xhh.a)), "2", this.jdField_a_of_type_Xhh.a.feedId, "" });
          continue;
          if (this.jdField_a_of_type_Xhh.a() != null)
          {
            localObject1 = new ArrayList();
            localObject2 = this.jdField_a_of_type_Xhh.a().iterator();
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
              vns.a((List)localObject1, (Activity)this.jdField_a_of_type_AndroidContentContext);
              j = xwa.a(this.jdField_a_of_type_Xhh.a);
              if (this.jdField_a_of_type_Xhh.a.getOwner().isMe()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                xwa.a("home_page", "clk_retry", j, 0, new String[] { localObject1, xwa.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Xhh.a.feedId });
                break;
              }
            }
          }
          else
          {
            xvv.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
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
 * Qualified Name:     xjw
 * JD-Core Version:    0.7.0.1
 */