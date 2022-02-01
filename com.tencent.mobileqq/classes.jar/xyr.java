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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xyr
  extends zgz<xwc>
  implements View.OnClickListener, yeu, ykc, ykd, zho
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private xvm jdField_a_of_type_Xvm;
  protected xwc a;
  private yck jdField_a_of_type_Yck;
  private yhc jdField_a_of_type_Yhc;
  protected final int b;
  private boolean b;
  
  public xyr(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return UIUtils.dip2px(paramContext, 15.0F) + UIUtils.dip2px(paramContext, 147.0F) * paramInt - UIUtils.dip2px(paramContext, 2.5F);
  }
  
  public static int a(xwc paramxwc)
  {
    int j = 2;
    int i = 1;
    if ((paramxwc.d()) || (paramxwc.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramxwc.f()) {
        break;
      }
      if (paramxwc.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, yhc paramyhc)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Xwc.a().getOwner();
    if (localQQUserUIItem == null)
    {
      ykq.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramyhc.a();
    }
    Object localObject = (RelativeLayout)paramyhc.a(2131374581);
    ImageView localImageView = (ImageView)paramyhc.a(2131368086);
    TextView localTextView3 = (TextView)paramyhc.a(2131371958);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyhc.a(2131381226);
    TextView localTextView1 = (TextView)paramyhc.a(2131374607);
    TextView localTextView2 = (TextView)paramyhc.a(2131378249);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374606);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyhc.a(2131380952);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramyhc.a(2131374138);
    ((RelativeLayout)localObject).setOnClickListener(this);
    UIUtils.setCircleViewByURL(localImageView, localQQUserUIItem.headUrl, 68, 68, bheg.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Xwc.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Xwc.a();
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
      a(this.jdField_a_of_type_Xwc.a(), paramyhc);
      a(paramInt, paramyhc, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramyhc.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = yhn.a(this.jdField_a_of_type_Xwc.a());
      break label222;
      label339:
      localObject = yhn.a(this.jdField_a_of_type_Xwc.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (yal.a(localQQUserUIItem)) {
        a(localTextView2, 1, anvx.a(2131704714));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void N_()
  {
    a(a(this.jdField_a_of_type_Xwc));
  }
  
  public void O_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && ((this.jdField_a_of_type_Xwc.d()) || (this.jdField_a_of_type_Xwc.e())) && (this.jdField_a_of_type_Xwc.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Xwc.d()) || (this.jdField_a_of_type_Xwc.e())) {
      return a(paramInt, paramyhc);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561649, paramViewGroup, false));
    this.jdField_a_of_type_Yhc.a("adapter", null);
    return this.jdField_a_of_type_Yhc;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    weg.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Xwc.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, yhc paramyhc, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Xwc.c())
    {
      zdl.a(false, "general feed should have video list, but it's not a video list feed.");
      ykq.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Xwc.a();
      if (this.jdField_a_of_type_Xwc.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Xwc.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Xwc.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramyhc.a(2131374603);
      TextView localTextView = (TextView)paramyhc.a(2131374605);
      paramyhc = (TextView)paramyhc.a(2131374604);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      yhn.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramyhc.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(anvx.a(2131704713));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        return;
        localTextView.setTextColor(-16777216);
        paramyhc.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(UIUtils.convertToHHMM(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramyhc.setVisibility(0);
          paramyhc.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(UIUtils.convertToHHMM(paramRelativeLayout.mCreateTime));
        }
        paramyhc.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (xyo)paramyhc.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new xyo(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, wzk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramyhc.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298520));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramyhc = paramRelativeLayout;; paramyhc = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Xwc.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Xwc.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            ykq.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramyhc.a(this.jdField_a_of_type_Xwc.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Xwc.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new xys(this, paramStoryHomeHorizontalListView, paramyhc));
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
    paramInt = wzk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    xbp.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = ykv.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      ykv.a("home_page", "clk_card", ykv.a(paramVideoListFeedItem), xyo.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), ykv.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        paramTextView.setBackgroundResource(2130846550);
      }
      return;
      paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
      paramTextView.setBackgroundResource(2130846549);
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
    ykq.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, yhc paramyhc)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramyhc.a(2131374599);
    paramyhc = (TextView)paramyhc.a(2131374600);
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
        paramyhc.setText(weg.a(2131699216, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
  }
  
  public void a(xwc paramxwc)
  {
    ykq.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramxwc);
    this.jdField_a_of_type_Xwc = paramxwc;
  }
  
  public boolean a(boolean paramBoolean)
  {
    ykq.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Xvm != null) {
      this.jdField_a_of_type_Xvm.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Yhc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yhc.a().getMeasuredHeight();
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
      if ((this.jdField_a_of_type_Xwc.d()) || (this.jdField_a_of_type_Xwc.e()))
      {
        Object localObject1 = (QQUserUIItem)this.jdField_a_of_type_Xwc.a().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          a(this.jdField_a_of_type_Xwc.a(), this.jdField_a_of_type_Xwc.a().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          Object localObject2 = (vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
          if (this.jdField_a_of_type_Xwc.e()) {}
          for (int i = 11;; i = 7)
          {
            ((vzu)localObject2).a(1, this.jdField_a_of_type_Xwc.a.ownerId, 0, i);
            ((QQUserUIItem)localObject1).isSubscribe = 1;
            paramView.setVisibility(4);
            if (!this.jdField_a_of_type_Xwc.e()) {
              break;
            }
            ykv.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Xwc.a.feedId });
            break;
          }
          a(a(this.jdField_a_of_type_Xwc));
          ykv.a("home_page", "clk_head_nick", ykv.a(this.jdField_a_of_type_Xwc.a), 0, new String[] { String.valueOf(ykv.b(this.jdField_a_of_type_Xwc.a)), "2", this.jdField_a_of_type_Xwc.a.feedId, "" });
          continue;
          if (this.jdField_a_of_type_Xwc.a() != null)
          {
            localObject1 = new ArrayList();
            localObject2 = this.jdField_a_of_type_Xwc.a().iterator();
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
              wcn.a((List)localObject1, (Activity)this.jdField_a_of_type_AndroidContentContext);
              j = ykv.a(this.jdField_a_of_type_Xwc.a);
              if (this.jdField_a_of_type_Xwc.a.getOwner().isMe()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                ykv.a("home_page", "clk_retry", j, 0, new String[] { localObject1, ykv.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Xwc.a.feedId });
                break;
              }
            }
          }
          else
          {
            ykq.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
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
 * Qualified Name:     xyr
 * JD-Core Version:    0.7.0.1
 */