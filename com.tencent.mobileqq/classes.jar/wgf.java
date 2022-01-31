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
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class wgf
  extends xrg<weh>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private wdr jdField_a_of_type_Wdr;
  private weh jdField_a_of_type_Weh;
  private wph jdField_a_of_type_Wph;
  
  public wgf(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Weh.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Weh.a() == null)
    {
      wsv.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramwph.a();
    }
    paramViewGroup = this.jdField_a_of_type_Weh.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373684);
    ImageView localImageView1 = (ImageView)paramwph.a(2131373671);
    TextView localTextView1 = (TextView)paramwph.a(2131373672);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwph.a(2131373674);
    TextView localTextView2 = (TextView)paramwph.a(2131373710);
    TextView localTextView3 = (TextView)paramwph.a(2131373668);
    ImageView localImageView2 = (ImageView)paramwph.a(2131373667);
    TextView localTextView4 = (TextView)paramwph.a(2131373675);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramwph.a(2131373275);
    localRelativeLayout.setOnClickListener(this);
    xod.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bdda.a(1), "QQStory_main");
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
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
        localTextView3.setBackgroundResource(2130846017);
      }
      if (!wiq.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext) - xod.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      xod.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, xod.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramwph.a();
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
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561400, paramViewGroup, false));
    return this.jdField_a_of_type_Wph;
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_Wdr = paramwdr;
  }
  
  public void a(weh paramweh)
  {
    wsv.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramweh);
    this.jdField_a_of_type_Weh = paramweh;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wph == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wph.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ume.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Weh.a.ownerId);
      wta.a("home_page", "clk_head_nick", wta.a(this.jdField_a_of_type_Weh.a), 0, new String[] { String.valueOf(wta.b(this.jdField_a_of_type_Weh.a)), "2", this.jdField_a_of_type_Weh.a.feedId, "" });
      return;
      ((uhk)vhj.a().a(98)).a(1, this.jdField_a_of_type_Weh.a.ownerId, 0, 13);
      this.jdField_a_of_type_Weh.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      wta.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Weh.a().getOwner().getUnionId(), this.jdField_a_of_type_Weh.a().feedId });
      return;
      wsv.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Weh.a().schema);
      if (this.jdField_a_of_type_Weh.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bdds.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Weh.a().schema).c();
        return;
      }
      if (!xne.a(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131701301), 0).a();
        return;
      }
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Weh.a().schema);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgf
 * JD-Core Version:    0.7.0.1
 */