import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xjf
  extends ysg<xhh>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private xgr jdField_a_of_type_Xgr;
  private xhh jdField_a_of_type_Xhh;
  private xsh jdField_a_of_type_Xsh;
  
  public xjf(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Xhh.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Xhh.a() == null)
    {
      xvv.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramxsh.a();
    }
    paramViewGroup = this.jdField_a_of_type_Xhh.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374343);
    ImageView localImageView1 = (ImageView)paramxsh.a(2131374330);
    TextView localTextView1 = (TextView)paramxsh.a(2131374331);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramxsh.a(2131374333);
    TextView localTextView2 = (TextView)paramxsh.a(2131374369);
    TextView localTextView3 = (TextView)paramxsh.a(2131374327);
    ImageView localImageView2 = (ImageView)paramxsh.a(2131374326);
    TextView localTextView4 = (TextView)paramxsh.a(2131374334);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramxsh.a(2131373909);
    localRelativeLayout.setOnClickListener(this);
    UIUtils.setCircleViewByURL(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bfvo.a(1), "QQStory_main");
    localStoryQIMBadgeView.a(paramViewGroup.getOwner());
    localTextView1.setText(paramViewGroup.getOwner().getName());
    localStoryUserBadgeView.setUnionID(paramViewGroup.getOwner().getUnionId(), 2);
    if (TextUtils.isEmpty(paramViewGroup.blurb))
    {
      localTextView2.setVisibility(8);
      if (!TextUtils.isEmpty(paramViewGroup.content)) {
        break label417;
      }
      localTextView4.setVisibility(8);
      label245:
      if (QQStoryContext.a())
      {
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
        localTextView3.setBackgroundResource(2130846454);
      }
      if (!xlq.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      UIUtils.setRoundCornerViewByURL(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, UIUtils.roundDefaultIcon, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramxsh.a();
      localTextView2.setText(paramViewGroup.blurb);
      localTextView2.setVisibility(0);
      break;
      label417:
      localTextView4.setVisibility(0);
      localTextView4.setText(paramViewGroup.content);
      break label245;
      label435:
      localTextView3.setVisibility(8);
      localTextView3.setOnClickListener(null);
    }
  }
  
  public String a()
  {
    return "BannerProfileSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561575, paramViewGroup, false));
    return this.jdField_a_of_type_Xsh;
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_Xgr = paramxgr;
  }
  
  public void a(xhh paramxhh)
  {
    xvv.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramxhh);
    this.jdField_a_of_type_Xhh = paramxhh;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Xsh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xsh.a().getMeasuredHeight();
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
      vpl.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Xhh.a.ownerId);
      xwa.a("home_page", "clk_head_nick", xwa.a(this.jdField_a_of_type_Xhh.a), 0, new String[] { String.valueOf(xwa.b(this.jdField_a_of_type_Xhh.a)), "2", this.jdField_a_of_type_Xhh.a.feedId, "" });
      continue;
      ((vkz)wkp.a().getBusinessHandler(98)).a(1, this.jdField_a_of_type_Xhh.a.ownerId, 0, 13);
      this.jdField_a_of_type_Xhh.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      xwa.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Xhh.a().getOwner().getUnionId(), this.jdField_a_of_type_Xhh.a().feedId });
      continue;
      xvv.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Xhh.a().schema);
      if (this.jdField_a_of_type_Xhh.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bfwg.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xhh.a().schema).a();
      }
      else if (!ypp.a(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131700079), 0).a();
      }
      else
      {
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Xhh.a().schema);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        continue;
        localObject = (String)paramView.getTag();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjf
 * JD-Core Version:    0.7.0.1
 */