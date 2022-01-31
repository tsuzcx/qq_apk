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

public class ueu
  extends vpv<ucw>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private ucg jdField_a_of_type_Ucg;
  private ucw jdField_a_of_type_Ucw;
  private unw jdField_a_of_type_Unw;
  
  public ueu(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Ucw.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Ucw.a() == null)
    {
      urk.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramunw.a();
    }
    paramViewGroup = this.jdField_a_of_type_Ucw.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307520);
    ImageView localImageView1 = (ImageView)paramunw.a(2131307507);
    TextView localTextView1 = (TextView)paramunw.a(2131307508);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramunw.a(2131307510);
    TextView localTextView2 = (TextView)paramunw.a(2131307546);
    TextView localTextView3 = (TextView)paramunw.a(2131307504);
    ImageView localImageView2 = (ImageView)paramunw.a(2131307503);
    TextView localTextView4 = (TextView)paramunw.a(2131307511);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramunw.a(2131307123);
    localRelativeLayout.setOnClickListener(this);
    vms.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bacm.a(1), "QQStory_main");
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
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
        localTextView3.setBackgroundResource(2130845448);
      }
      if (!uhf.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext) - vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      vms.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, vms.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramunw.a();
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
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495620, paramViewGroup, false));
    return this.jdField_a_of_type_Unw;
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void a(ucw paramucw)
  {
    urk.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramucw);
    this.jdField_a_of_type_Ucw = paramucw;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Unw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Unw.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      skt.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Ucw.a.ownerId);
      urp.a("home_page", "clk_head_nick", urp.a(this.jdField_a_of_type_Ucw.a), 0, new String[] { String.valueOf(urp.b(this.jdField_a_of_type_Ucw.a)), "2", this.jdField_a_of_type_Ucw.a.feedId, "" });
      return;
      ((sfz)tfy.a().a(98)).a(1, this.jdField_a_of_type_Ucw.a.ownerId, 0, 13);
      this.jdField_a_of_type_Ucw.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      urp.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Ucw.a().getOwner().getUnionId(), this.jdField_a_of_type_Ucw.a().feedId });
      return;
      urk.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Ucw.a().schema);
      if (this.jdField_a_of_type_Ucw.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bade.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ucw.a().schema).c();
        return;
      }
      if (!vlt.a(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131635137), 0).a();
        return;
      }
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Ucw.a().schema);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueu
 * JD-Core Version:    0.7.0.1
 */