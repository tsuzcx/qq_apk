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

public class wko
  extends xvp<wiq>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private wia jdField_a_of_type_Wia;
  private wiq jdField_a_of_type_Wiq;
  private wtq jdField_a_of_type_Wtq;
  
  public wko(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.g())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Wiq.g()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Wiq.a() == null)
    {
      wxe.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramwtq.a();
    }
    paramViewGroup = this.jdField_a_of_type_Wiq.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373735);
    ImageView localImageView1 = (ImageView)paramwtq.a(2131373722);
    TextView localTextView1 = (TextView)paramwtq.a(2131373723);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwtq.a(2131373725);
    TextView localTextView2 = (TextView)paramwtq.a(2131373761);
    TextView localTextView3 = (TextView)paramwtq.a(2131373719);
    ImageView localImageView2 = (ImageView)paramwtq.a(2131373718);
    TextView localTextView4 = (TextView)paramwtq.a(2131373726);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramwtq.a(2131373327);
    localRelativeLayout.setOnClickListener(this);
    xsm.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, bdhj.a(1), "QQStory_main");
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
        localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
        localTextView3.setBackgroundResource(2130846090);
      }
      if (!wmz.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext) - xsm.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      xsm.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, xsm.b, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramwtq.a();
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
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561418, paramViewGroup, false));
    return this.jdField_a_of_type_Wtq;
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_Wia = paramwia;
  }
  
  public void a(wiq paramwiq)
  {
    wxe.a("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramwiq);
    this.jdField_a_of_type_Wiq = paramwiq;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Wtq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wtq.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      uqn.a(this.jdField_a_of_type_AndroidContentContext, 4, this.jdField_a_of_type_Wiq.a.ownerId);
      wxj.a("home_page", "clk_head_nick", wxj.a(this.jdField_a_of_type_Wiq.a), 0, new String[] { String.valueOf(wxj.b(this.jdField_a_of_type_Wiq.a)), "2", this.jdField_a_of_type_Wiq.a.feedId, "" });
      return;
      ((ult)vls.a().a(98)).a(1, this.jdField_a_of_type_Wiq.a.ownerId, 0, 13);
      this.jdField_a_of_type_Wiq.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      wxj.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Wiq.a().getOwner().getUnionId(), this.jdField_a_of_type_Wiq.a().feedId });
      return;
      wxe.a("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Wiq.a().schema);
      if (this.jdField_a_of_type_Wiq.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        bdib.a((QQAppInterface)QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wiq.a().schema).c();
        return;
      }
      if (!xrn.a(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131701313), 0).a();
        return;
      }
      paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_Wiq.a().schema);
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
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */