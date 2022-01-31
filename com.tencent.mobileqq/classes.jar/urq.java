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

public class urq
  extends wcr<ups>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private upc jdField_a_of_type_Upc;
  private ups jdField_a_of_type_Ups;
  private vas jdField_a_of_type_Vas;
  
  public urq(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Ups.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Ups.a() == null)
    {
      veg.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramvas.a();
    }
    paramViewGroup = this.jdField_a_of_type_Ups.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373233);
    ImageView localImageView1 = (ImageView)paramvas.a(2131373220);
    TextView localTextView1 = (TextView)paramvas.a(2131373221);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvas.a(2131373223);
    TextView localTextView2 = (TextView)paramvas.a(2131373259);
    TextView localTextView3 = (TextView)paramvas.a(2131373217);
    ImageView localImageView2 = (ImageView)paramvas.a(2131373216);
    TextView localTextView4 = (TextView)paramvas.a(2131373224);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramvas.a(2131372835);
    localRelativeLayout.setOnClickListener(this);
    vzo.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bbdr.a(1), "QQStory_main");
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
        localTextView3.setBackgroundResource(2130845632);
      }
      if (!uub.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext) - vzo.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      vzo.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, vzo.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramvas.a();
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
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561211, paramViewGroup, false));
    return this.jdField_a_of_type_Vas;
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
  }
  
  public void a(ups paramups)
  {
    veg.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramups);
    this.jdField_a_of_type_Ups = paramups;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vas == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vas.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      sxp.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Ups.a.ownerId);
      vel.a("home_page", "clk_head_nick", vel.a(this.jdField_a_of_type_Ups.a), 0, new String[] { String.valueOf(vel.b(this.jdField_a_of_type_Ups.a)), "2", this.jdField_a_of_type_Ups.a.feedId, "" });
      return;
      ((ssv)tsu.a().a(98)).a(1, this.jdField_a_of_type_Ups.a.ownerId, 0, 13);
      this.jdField_a_of_type_Ups.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      vel.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Ups.a().getOwner().getUnionId(), this.jdField_a_of_type_Ups.a().feedId });
      return;
      veg.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Ups.a().schema);
      if (this.jdField_a_of_type_Ups.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bbej.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ups.a().schema).c();
        return;
      }
      if (!vyp.a(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131700921), 0).a();
        return;
      }
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Ups.a().schema);
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
 * Qualified Name:     urq
 * JD-Core Version:    0.7.0.1
 */