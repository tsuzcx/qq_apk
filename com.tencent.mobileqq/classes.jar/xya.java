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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xya
  extends zgz<xwc>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private xvm jdField_a_of_type_Xvm;
  private xwc jdField_a_of_type_Xwc;
  private yhc jdField_a_of_type_Yhc;
  
  public xya(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Xwc.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Xwc.a() == null)
    {
      ykq.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramyhc.a();
    }
    paramViewGroup = this.jdField_a_of_type_Xwc.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374581);
    ImageView localImageView1 = (ImageView)paramyhc.a(2131374568);
    TextView localTextView1 = (TextView)paramyhc.a(2131374569);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyhc.a(2131374571);
    TextView localTextView2 = (TextView)paramyhc.a(2131374607);
    TextView localTextView3 = (TextView)paramyhc.a(2131374565);
    ImageView localImageView2 = (ImageView)paramyhc.a(2131374564);
    TextView localTextView4 = (TextView)paramyhc.a(2131374572);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramyhc.a(2131374138);
    localRelativeLayout.setOnClickListener(this);
    UIUtils.setCircleViewByURL(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bheg.a(1), "QQStory_main");
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
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
        localTextView3.setBackgroundResource(2130846550);
      }
      if (!yal.a(paramViewGroup.getOwner())) {
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
      return paramyhc.a();
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
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561643, paramViewGroup, false));
    return this.jdField_a_of_type_Yhc;
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
  }
  
  public void a(xwc paramxwc)
  {
    ykq.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramxwc);
    this.jdField_a_of_type_Xwc = paramxwc;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Yhc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yhc.a().getMeasuredHeight();
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
      weg.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Xwc.a.ownerId);
      ykv.a("home_page", "clk_head_nick", ykv.a(this.jdField_a_of_type_Xwc.a), 0, new String[] { String.valueOf(ykv.b(this.jdField_a_of_type_Xwc.a)), "2", this.jdField_a_of_type_Xwc.a.feedId, "" });
      continue;
      ((vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a(1, this.jdField_a_of_type_Xwc.a.ownerId, 0, 13);
      this.jdField_a_of_type_Xwc.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      ykv.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Xwc.a().getOwner().getUnionId(), this.jdField_a_of_type_Xwc.a().feedId });
      continue;
      ykq.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Xwc.a().schema);
      if (this.jdField_a_of_type_Xwc.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bhey.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Xwc.a().schema).a();
      }
      else if (!zei.a(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131700430), 0).a();
      }
      else
      {
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Xwc.a().schema);
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
 * Qualified Name:     xya
 * JD-Core Version:    0.7.0.1
 */