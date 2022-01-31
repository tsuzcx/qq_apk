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

public class wlf
  extends xvp<wiq>
  implements View.OnClickListener, wri, wwq, wwr, xwe
{
  public static final String KEY = "GeneralFeedProfileSegment";
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private wia jdField_a_of_type_Wia;
  protected wiq a;
  private woy jdField_a_of_type_Woy;
  private wtq jdField_a_of_type_Wtq;
  protected final int b;
  private boolean b;
  
  public wlf(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return xsm.a(paramContext, 15.0F) + xsm.a(paramContext, 147.0F) * paramInt - xsm.a(paramContext, 2.5F);
  }
  
  public static int a(wiq paramwiq)
  {
    int j = 2;
    int i = 1;
    if ((paramwiq.d()) || (paramwiq.e())) {
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!paramwiq.f()) {
        break;
      }
      if (paramwiq.a.getOwner().getRelationType() == 2) {}
      while (i == 0)
      {
        return 3;
        i = 0;
      }
    }
    return 1;
  }
  
  private View a(int paramInt, wtq paramwtq)
  {
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_Wiq.a().getOwner();
    if (localQQUserUIItem == null)
    {
      wxe.e("Q.qqstory.detail.GeneralFeedProfileSegment", "bind general view failed because it's invalidate date.");
      return paramwtq.a();
    }
    Object localObject = (RelativeLayout)paramwtq.a(2131373735);
    ImageView localImageView = (ImageView)paramwtq.a(2131367538);
    TextView localTextView3 = (TextView)paramwtq.a(2131371139);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwtq.a(2131380015);
    TextView localTextView1 = (TextView)paramwtq.a(2131373761);
    TextView localTextView2 = (TextView)paramwtq.a(2131377225);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373760);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwtq.a(2131379746);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramwtq.a(2131373327);
    ((RelativeLayout)localObject).setOnClickListener(this);
    xsm.b(localImageView, localQQUserUIItem.headUrl, 68, 68, bdhj.a(1), "QQStory_main");
    localStoryQIMBadgeView.setForceRefresh(true);
    localStoryQIMBadgeView.a(localQQUserUIItem);
    if (TextUtils.isEmpty(localQQUserUIItem.remark))
    {
      localTextView3.setText(localQQUserUIItem.nickName);
      if (!this.jdField_a_of_type_Wiq.e()) {
        break label339;
      }
      localObject = this.jdField_a_of_type_Wiq.a();
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
      a(this.jdField_a_of_type_Wiq.a(), paramwtq);
      a(paramInt, paramwtq, localRelativeLayout, localStoryHomeHorizontalListView);
      this.jdField_b_of_type_Boolean = true;
      return paramwtq.a();
      localTextView3.setText(localQQUserUIItem.remark);
      break;
      label325:
      localObject = wub.a(this.jdField_a_of_type_Wiq.a());
      break label222;
      label339:
      localObject = wub.a(this.jdField_a_of_type_Wiq.a());
      break label222;
      label353:
      localTextView1.setVisibility(8);
      break label241;
      label363:
      if (wmz.a(localQQUserUIItem)) {
        a(localTextView2, 1, alud.a(2131705631));
      } else {
        a(localTextView2, 0, null);
      }
    }
  }
  
  private void a(List<StoryVideoItem> paramList, int paramInt) {}
  
  public void U_()
  {
    a(a(this.jdField_a_of_type_Wiq));
  }
  
  public void V_() {}
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && ((this.jdField_a_of_type_Wiq.d()) || (this.jdField_a_of_type_Wiq.e())) && (this.jdField_a_of_type_Wiq.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Wiq.d()) || (this.jdField_a_of_type_Wiq.e())) {
      return a(paramInt, paramwtq);
    }
    throw new IllegalStateException("bind view failed because it's not a general feed.");
  }
  
  public String a()
  {
    return "GeneralFeedProfileSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561424, paramViewGroup, false));
    this.jdField_a_of_type_Wtq.a("adapter", null);
    return this.jdField_a_of_type_Wtq;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    uqn.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Wiq.a.ownerId);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(int paramInt, wtq paramwtq, RelativeLayout paramRelativeLayout, StoryHomeHorizontalListView paramStoryHomeHorizontalListView)
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Wiq.c())
    {
      xqq.a(false, "general feed should have video list, but it's not a video list feed.");
      wxe.e("Q.qqstory.detail.GeneralFeedProfileSegment", "general feed should have video list, but it's not a video list feed.");
    }
    VideoListFeedItem localVideoListFeedItem;
    label263:
    label337:
    label344:
    for (;;)
    {
      return;
      localVideoListFeedItem = this.jdField_a_of_type_Wiq.a();
      if (this.jdField_a_of_type_Wiq.a().size() == 0)
      {
        paramRelativeLayout.setVisibility(8);
        paramStoryHomeHorizontalListView.setVisibility(8);
        return;
      }
      if (this.jdField_a_of_type_Wiq.a().size() != 1) {
        break;
      }
      paramRelativeLayout.setVisibility(0);
      paramStoryHomeHorizontalListView.setVisibility(8);
      paramRelativeLayout = (StoryVideoItem)this.jdField_a_of_type_Wiq.a().get(0);
      paramStoryHomeHorizontalListView = (QQStoryAutoPlayView)paramwtq.a(2131373757);
      TextView localTextView = (TextView)paramwtq.a(2131373759);
      paramwtq = (TextView)paramwtq.a(2131373758);
      paramStoryHomeHorizontalListView.setItemData(localVideoListFeedItem, paramRelativeLayout, paramInt);
      paramStoryHomeHorizontalListView.setStoryCoverClickListener(this);
      wub.a(paramRelativeLayout, paramStoryHomeHorizontalListView, "QQStory_feed");
      if (paramRelativeLayout.mHadRead == 1)
      {
        localTextView.setTextColor(-7829368);
        paramwtq.setTextColor(-7829368);
        if (!paramRelativeLayout.isUploadFail()) {
          break label263;
        }
        localTextView.setText(alud.a(2131705630));
        localTextView.setTextColor(-7829368);
      }
      for (;;)
      {
        if (!QQStoryContext.a()) {
          break label344;
        }
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
        return;
        localTextView.setTextColor(-16777216);
        paramwtq.setTextColor(-16777216);
        break;
        if (paramRelativeLayout.mTimeZoneOffsetMillis != 2147483647L) {
          localTextView.setText(xsm.a(paramRelativeLayout.mCreateTime, paramRelativeLayout.mTimeZoneOffsetMillis));
        }
        for (;;)
        {
          if (!(this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem)) {
            break label337;
          }
          paramwtq.setVisibility(0);
          paramwtq.setText(paramRelativeLayout.mOwnerName);
          break;
          localTextView.setText(xsm.b(paramRelativeLayout.mCreateTime));
        }
        paramwtq.setVisibility(8);
      }
    }
    paramRelativeLayout.setVisibility(8);
    paramStoryHomeHorizontalListView.setVisibility(0);
    paramRelativeLayout = (wlc)paramwtq.a("adapter");
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new wlc(this.jdField_a_of_type_AndroidContentContext, (FragmentActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, vls.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramwtq.a("adapter", paramRelativeLayout);
      paramStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298356));
      paramStoryHomeHorizontalListView.setAdapter(paramRelativeLayout);
      paramRelativeLayout.a(this);
    }
    for (paramwtq = paramRelativeLayout;; paramwtq = paramRelativeLayout)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.jdField_a_of_type_Wiq.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_Wiq.a().get(paramInt)).mVid.equals(this.jdField_a_of_type_JavaLangString))
          {
            wxe.b("Q.qqstory.detail.GeneralFeedProfileSegment", "select video position:%d.", Integer.valueOf(paramInt));
            paramStoryHomeHorizontalListView.resetCurrentX(a(this.jdField_a_of_type_AndroidContentContext, paramInt));
          }
        }
        else
        {
          paramwtq.a(this.jdField_a_of_type_Wiq.a(), localVideoListFeedItem);
          paramStoryHomeHorizontalListView.setDataCount(this.jdField_a_of_type_Wiq.a().size());
          if (!localVideoListFeedItem.mIsVideoEnd) {
            bool = true;
          }
          paramStoryHomeHorizontalListView.setLoadMoreComplete(bool);
          paramStoryHomeHorizontalListView.setOnLoadMoreListener(this);
          paramStoryHomeHorizontalListView.setOnScrollChangeListener(this);
          paramStoryHomeHorizontalListView.setOnOverScrollRightListener(this);
          paramStoryHomeHorizontalListView.setOnScrollStateChangedListener(new wlg(this, paramStoryHomeHorizontalListView, paramwtq));
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (xsm.b()) {
      return;
    }
    paramInt = vls.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new SingleFeedPlayInfo(paramVideoListFeedItem.feedId, paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), paramInt);
    vod.a((Activity)this.jdField_a_of_type_AndroidContentContext, localOpenPlayerBuilder.a(), paramView);
    paramInt = wxj.b(paramVideoListFeedItem);
    if ((paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {}
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      wxj.a("home_page", "clk_card", wxj.a(paramVideoListFeedItem), wlc.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), wxj.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
        paramTextView.setBackgroundResource(2130846090);
      }
      return;
      paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int i = xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      paramTextView.setText(paramString);
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166903));
      paramTextView.setBackgroundResource(2130846089);
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
    wxe.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set select video: vid = %s.", paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(List<StoryVideoItem> paramList, wtq paramwtq)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramwtq.a(2131373753);
    paramwtq = (TextView)paramwtq.a(2131373754);
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
        paramwtq.setText(uqn.a(2131700097, new Object[] { Integer.valueOf(i) }));
        return;
      }
      localLinearLayout.setVisibility(8);
      localLinearLayout.setOnClickListener(null);
      return;
    }
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_Wia = paramwia;
  }
  
  public void a(wiq paramwiq)
  {
    wxe.a("Q.qqstory.detail.GeneralFeedProfileSegment", "set data: detail feed item = %s.", paramwiq);
    this.jdField_a_of_type_Wiq = paramwiq;
  }
  
  public boolean a(boolean paramBoolean)
  {
    wxe.b("Q.qqstory.detail.GeneralFeedProfileSegment", "load more video");
    if (this.jdField_a_of_type_Wia != null) {
      this.jdField_a_of_type_Wia.b();
    }
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wtq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wtq.a().getMeasuredHeight();
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
          } while ((!this.jdField_a_of_type_Wiq.d()) && (!this.jdField_a_of_type_Wiq.e()));
          localObject1 = (QQUserUIItem)this.jdField_a_of_type_Wiq.a().getOwner();
          if (((QQUserUIItem)localObject1).isMe())
          {
            a(this.jdField_a_of_type_Wiq.a(), this.jdField_a_of_type_Wiq.a().mVideoPullType);
            return;
          }
        } while ((((QQUserUIItem)localObject1).isFriend()) || (((QQUserUIItem)localObject1).isSubscribe == 1));
        Object localObject2 = (ult)vls.a().a(98);
        if (this.jdField_a_of_type_Wiq.e()) {}
        for (i = 11;; i = 7)
        {
          ((ult)localObject2).a(1, this.jdField_a_of_type_Wiq.a.ownerId, 0, i);
          ((QQUserUIItem)localObject1).isSubscribe = 1;
          paramView.setVisibility(4);
          if (!this.jdField_a_of_type_Wiq.e()) {
            break;
          }
          wxj.a("home_page", "follow_recom", 0, 0, new String[] { "1", "2", ((QQUserUIItem)localObject1).getUnionId(), this.jdField_a_of_type_Wiq.a.feedId });
          return;
        }
        a(a(this.jdField_a_of_type_Wiq));
        wxj.a("home_page", "clk_head_nick", wxj.a(this.jdField_a_of_type_Wiq.a), 0, new String[] { String.valueOf(wxj.b(this.jdField_a_of_type_Wiq.a)), "2", this.jdField_a_of_type_Wiq.a.feedId, "" });
        return;
        if (this.jdField_a_of_type_Wiq.a() == null) {
          break;
        }
        paramView = new ArrayList();
        localObject1 = this.jdField_a_of_type_Wiq.a().iterator();
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
      uom.a(paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
      int j = wxj.a(this.jdField_a_of_type_Wiq.a);
      if (this.jdField_a_of_type_Wiq.a.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        wxj.a("home_page", "clk_retry", j, 0, new String[] { paramView, wxj.a(this.jdField_a_of_type_Int), String.valueOf(i), this.jdField_a_of_type_Wiq.a.feedId });
        return;
      }
      wxe.e("Q.qqstory.detail.GeneralFeedProfileSegment", "feed upload retry failed!!");
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlf
 * JD-Core Version:    0.7.0.1
 */