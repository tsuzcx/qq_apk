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

public class urn
  extends wco<upp>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private uoz jdField_a_of_type_Uoz;
  private upp jdField_a_of_type_Upp;
  private vap jdField_a_of_type_Vap;
  
  public urn(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Upp.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Upp.a() == null)
    {
      ved.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramvap.a();
    }
    paramViewGroup = this.jdField_a_of_type_Upp.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373235);
    ImageView localImageView1 = (ImageView)paramvap.a(2131373222);
    TextView localTextView1 = (TextView)paramvap.a(2131373223);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131373225);
    TextView localTextView2 = (TextView)paramvap.a(2131373261);
    TextView localTextView3 = (TextView)paramvap.a(2131373219);
    ImageView localImageView2 = (ImageView)paramvap.a(2131373218);
    TextView localTextView4 = (TextView)paramvap.a(2131373226);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramvap.a(2131372837);
    localRelativeLayout.setOnClickListener(this);
    vzl.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bbef.a(1), "QQStory_main");
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
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
        localTextView3.setBackgroundResource(2130845638);
      }
      if (!uty.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext) - vzl.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      vzl.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, vzl.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramvap.a();
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
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561210, paramViewGroup, false));
    return this.jdField_a_of_type_Vap;
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
  }
  
  public void a(upp paramupp)
  {
    ved.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramupp);
    this.jdField_a_of_type_Upp = paramupp;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vap == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vap.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      sxm.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Upp.a.ownerId);
      vei.a("home_page", "clk_head_nick", vei.a(this.jdField_a_of_type_Upp.a), 0, new String[] { String.valueOf(vei.b(this.jdField_a_of_type_Upp.a)), "2", this.jdField_a_of_type_Upp.a.feedId, "" });
      return;
      ((sss)tsr.a().a(98)).a(1, this.jdField_a_of_type_Upp.a.ownerId, 0, 13);
      this.jdField_a_of_type_Upp.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      vei.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Upp.a().getOwner().getUnionId(), this.jdField_a_of_type_Upp.a().feedId });
      return;
      ved.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Upp.a().schema);
      if (this.jdField_a_of_type_Upp.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bbex.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Upp.a().schema).c();
        return;
      }
      if (!vym.a(this.jdField_a_of_type_AndroidContentContext))
      {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131700932), 0).a();
        return;
      }
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Upp.a().schema);
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
 * Qualified Name:     urn
 * JD-Core Version:    0.7.0.1
 */