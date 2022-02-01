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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qsr
  extends rsd<qru>
  implements View.OnClickListener
{
  public static final String KEY = "BannerProfileSegment";
  private qrn jdField_a_of_type_Qrn;
  private qru jdField_a_of_type_Qru;
  private qyd b;
  
  public qsr(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Qru.Kr()) {
      throw new IllegalStateException("bind view failed because it's not a banner feed.");
    }
    if (this.jdField_a_of_type_Qru.a() == null)
    {
      ram.e("Q.qqstory.detail.BannerProfileSegment", "bind banner view failed because it's invalidate date.");
      return paramqyd.getItemView();
    }
    paramViewGroup = this.jdField_a_of_type_Qru.a();
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375117);
    ImageView localImageView1 = (ImageView)paramqyd.get(2131375104);
    TextView localTextView1 = (TextView)paramqyd.get(2131375105);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131375107);
    TextView localTextView2 = (TextView)paramqyd.get(2131375143);
    TextView localTextView3 = (TextView)paramqyd.get(2131375101);
    ImageView localImageView2 = (ImageView)paramqyd.get(2131375100);
    TextView localTextView4 = (TextView)paramqyd.get(2131375108);
    StoryQIMBadgeView localStoryQIMBadgeView = (StoryQIMBadgeView)paramqyd.get(2131374683);
    localRelativeLayout.setOnClickListener(this);
    rpq.b(localImageView1, paramViewGroup.getOwner().headUrl, 68, 68, aqhu.F(1), "QQStory_main");
    localStoryQIMBadgeView.g(paramViewGroup.getOwner());
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
      if (QQStoryContext.isNightMode())
      {
        localTextView3.setTextColor(this.context.getResources().getColor(2131166761));
        localTextView3.setBackgroundResource(2130847411);
      }
      if (!quc.a(paramViewGroup.getOwner())) {
        break label435;
      }
      localTextView3.setVisibility(0);
      localTextView3.setOnClickListener(this);
    }
    for (;;)
    {
      float f = paramViewGroup.coverHeight * 1.0F / paramViewGroup.coverWidth;
      paramInt = rpq.getWindowScreenWidth(this.context) - rpq.dip2px(this.context, 15.0F) * 2;
      int i = (int)(f * paramInt);
      localImageView2.getLayoutParams().width = paramInt;
      localImageView2.getLayoutParams().height = i;
      rpq.a(localImageView2, paramViewGroup.coverUrl, paramInt / 2, i / 2, 10, rpq.dl, "QQStory_main");
      localImageView2.setOnClickListener(this);
      localTextView4.setOnClickListener(this);
      return paramqyd.getItemView();
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
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561811, paramViewGroup, false));
    return this.b;
  }
  
  public void c(qru paramqru)
  {
    ram.b("Q.qqstory.detail.BannerProfileSegment", "set data: detail feed item = %s.", paramqru);
    this.jdField_a_of_type_Qru = paramqru;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.Kr())) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "BannerProfileSegment";
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
      ppf.f(this.context, 4, this.jdField_a_of_type_Qru.d.ownerId);
      rar.a("home_page", "clk_head_nick", rar.a(this.jdField_a_of_type_Qru.d), 0, new String[] { String.valueOf(rar.b(this.jdField_a_of_type_Qru.d)), "2", this.jdField_a_of_type_Qru.d.feedId, "" });
      continue;
      ((pma)qem.getQQAppInterface().getBusinessHandler(98)).b(1, this.jdField_a_of_type_Qru.d.ownerId, 0, 13);
      this.jdField_a_of_type_Qru.a().getOwner().isSubscribe = 1;
      paramView.setVisibility(4);
      rar.a("home_page", "follow_recom", 0, 0, new String[] { "3", "2", this.jdField_a_of_type_Qru.a().getOwner().getUnionId(), this.jdField_a_of_type_Qru.a().feedId });
      continue;
      ram.b("Q.qqstory.detail.BannerProfileSegment", "click banner feed and jump to %s", this.jdField_a_of_type_Qru.a().schema);
      if (this.jdField_a_of_type_Qru.a().schema.startsWith("mqqapi:"))
      {
        QQStoryContext.a();
        aqik.c((QQAppInterface)QQStoryContext.c(), this.context, this.jdField_a_of_type_Qru.a().schema).ace();
      }
      else if (!rpc.hasInternet(this.context))
      {
        QQToast.a(this.context, 1, acfp.m(2131703045), 0).show();
      }
      else
      {
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Qru.a().schema);
        this.context.startActivity((Intent)localObject);
        continue;
        localObject = (String)paramView.getTag();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject);
          this.context.startActivity(localIntent);
        }
      }
    }
  }
  
  public int sP()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getItemView().getMeasuredHeight();
  }
  
  public void setCallback(qrn paramqrn)
  {
    this.jdField_a_of_type_Qrn = paramqrn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsr
 * JD-Core Version:    0.7.0.1
 */