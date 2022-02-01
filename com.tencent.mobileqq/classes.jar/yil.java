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

public class yil
  extends zsv<yfw>
  implements View.OnClickListener, yoo, ytw, ytx, ztk
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private yfg jdField_a_of_type_Yfg;
  protected yfw a;
  private yme jdField_a_of_type_Yme;
  private yqw jdField_a_of_type_Yqw;
  protected final int b;
  private boolean b;
  
  public yil(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return zps.a(paramContext, 15.0F) + zps.a(paramContext, 147.0F) * paramInt - zps.a(paramContext, 2.5F);
  }
  
  public static int a(yfw paramyfw)
  {
    int j = 2;
    int i = 1;
    if ((paramyfw.d()) || (paramyfw.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramyfw.f()) {
        break;
      }
      if (paramyfw.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, yqw paramyqw)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Yfw.a().getOwner();
    if (localQQUserUIItem == null)
    {
      yuk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramyqw.a();
    }
    Object localObject = (RelativeLayout)paramyqw.a(2131374575);
    ImageView localImageView = (ImageView)paramyqw.a(2131367917);
    TextView localTextView3 = (TextView)paramyqw.a(2131371805);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyqw.a(2131381155);
    TextView localTextView1 = (TextView)paramyqw.a(2131374601);
    TextView localTextView2 = (TextView)paramyqw.a(2131378191);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyqw.a(2131374600);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyqw.a(2131380880);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramyqw.a(2131374166);
    ((RelativeLayout)localObject).setOnClickListener(this);
    zps.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bhmq.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Yfw.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Yfw.a();
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
      a(this.jdField_a_of_type_Yfw.a(), paramyqw);
      a(paramInt, paramyqw, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramyqw.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = yrh.a(this.jdField_a_of_type_Yfw.a());
      break label222;
      label339:
      localObject = yrh.a(this.jdField_a_of_type_Yfw.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (ykf.a(localQQUserUIItem)) {
        a(localTextView2, 1, anzj.a(2131704134));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void R_()
  {
    a(a(this.jdField_a_of_type_Yfw));
  }
  
  public void S_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null) && ((this.jdField_a_of_type_Yfw.d()) || (this.jdField_a_of_type_Yfw.e())) && (this.jdField_a_of_type_Yfw.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Yfw.d()) || (this.jdField_a_of_type_Yfw.e())) {
      return a(paramInt, paramyqw);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561701, paramViewGroup, false));
    this.jdField_a_of_type_Yqw.a("adapter", null);
    return this.jdField_a_of_type_Yqw;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    wnu.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Yfw.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, yqw paramyqw, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Yfw.c())
    {
      znw.a(false, "general feed should have video list, but it's not a video list feed.");
      yuk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Yfw.a();
      if (this.jdField_a_of_type_Yfw.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Yfw.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Yfw.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramyqw.a(2131374597);
      TextView localTextView = (TextView)paramyqw.a(2131374599);
      paramyqw = (TextView)paramyqw.a(2131374598);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      yrh.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramyqw.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(anzj.a(2131704133));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
        return;
        localTextView.setTextColor(-16777216);
        paramyqw.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(zps.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramyqw.setVisibility(0);
          paramyqw.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(zps.b(paramRelativeLayout.mCreateTime));
        }
        paramyqw.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (yii)paramyqw.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new yii(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, xiz.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramyqw.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298451));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramyqw = paramRelativeLayout;; paramyqw = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Yfw.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Yfw.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            yuk.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramyqw.a(this.jdField_a_of_type_Yfw.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Yfw.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new yim(this, paramStoryHomeHorizontalListView, paramyqw));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (zps.b()) {
      return;
    }
    paramInt = xiz.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    xlj.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = yup.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      yup.a("home_page", "clk_card", yup.a(paramVideoListFeedItem), yii.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), yup.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
        paramTextView.setBackgroundResource(2130846546);
      }
      return;
      paramInt = zps.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = zps.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166990));
      paramTextView.setBackgroundResource(2130846545);
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
    yuk.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, yqw paramyqw)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramyqw.a(2131374593);
    paramyqw = (TextView)paramyqw.a(2131374594);
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
        paramyqw.setText(wnu.a(2131698630, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
  }
  
  public void a(yfw paramyfw)
  {
    yuk.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramyfw);
    this.jdField_a_of_type_Yfw = paramyfw;
  }
  
  public boolean a(boolean paramBoolean)
  {
    yuk.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Yfg != null) {
      this.jdField_a_of_type_Yfg.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Yqw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yqw.a().getMeasuredHeight();
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
      if ((this.jdField_a_of_type_Yfw.d()) || (this.jdField_a_of_type_Yfw.e()))
      {
        Object localObject1 = (QQUserUIItem)this.jdField_a_of_type_Yfw.a().getOwner();
        if (((QQUserUIItem)localObject1).isMe())
        {
          a(this.jdField_a_of_type_Yfw.a(), this.jdField_a_of_type_Yfw.a().mVideoPullType);
        }
        else if ((!((QQUserUIItem)localObject1).isFriend()) && (((QQUserUIItem)localObject1).isSubscribe != 1))
        {
          Object localObject2 = (wja)xiz.a().a(98);
          if (this.jdField_a_of_type_Yfw.e()) {}
          for (int i = 11;; i = 7)
          {
            ((wja)localObject2).a(1, this.jdField_a_of_type_Yfw.a.ownerId, 0, i);
            ((QQUserUIItem)localObject1).isSubscribe = 1;
            paramView.setVisibility(4);
            if (!this.jdField_a_of_type_Yfw.e()) {
              break;
            }
            yup.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Yfw.a.feedId });
            break;
          }
          a(a(this.jdField_a_of_type_Yfw));
          yup.a("home_page", "clk_head_nick", yup.a(this.jdField_a_of_type_Yfw.a), 0, new String[] { String.valueOf(yup.b(this.jdField_a_of_type_Yfw.a)), "2", this.jdField_a_of_type_Yfw.a.feedId, "" });
          continue;
          if (this.jdField_a_of_type_Yfw.a() != null)
          {
            localObject1 = new ArrayList();
            localObject2 = this.jdField_a_of_type_Yfw.a().iterator();
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
              wlt.a((List)localObject1, (Activity)this.jdField_a_of_type_AndroidContentContext);
              j = yup.a(this.jdField_a_of_type_Yfw.a);
              if (this.jdField_a_of_type_Yfw.a.getOwner().isMe()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                yup.a("home_page", "clk_retry", j, 0, new String[] { localObject1, yup.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Yfw.a.feedId });
                break;
              }
            }
          }
          else
          {
            yuk.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
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
 * Qualified Name:     yil
 * JD-Core Version:    0.7.0.1
 */