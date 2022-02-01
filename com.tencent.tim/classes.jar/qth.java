import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class qth
  extends qtf
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public qth(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private boolean Ky()
  {
    return (this.a.Kq()) && (this.a.a().getOwner().getRelationType() == 2);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = qyk.a(this.a.a(), this.a.bS());
    CharSequence localCharSequence = localObject[0];
    localObject = localObject[1];
    if (TextUtils.isEmpty(localCharSequence)) {
      paramTextView1.setVisibility(8);
    }
    while (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView2.setVisibility(8);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(localCharSequence);
    }
    paramTextView2.setVisibility(0);
    paramTextView2.setText((CharSequence)localObject);
  }
  
  private View b(int paramInt, qyd paramqyd)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.b().getOwner();
    if (localShareGroupItem == null)
    {
      ram.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramqyd.getItemView();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramqyd.get(2131375117);
    ImageView localImageView = (ImageView)paramqyd.get(2131368398);
    TextView localTextView1 = (TextView)paramqyd.get(2131372361);
    TextView localTextView2 = (TextView)paramqyd.get(2131375143);
    TextView localTextView3 = (TextView)paramqyd.get(2131375144);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131382005);
    TextView localTextView4 = (TextView)paramqyd.get(2131378958);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramqyd.get(2131375142);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramqyd.get(2131381732);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(ppg.f.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.a.Kq()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130847674);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      c(localTextView4, 0, null);
      a(this.a.bS(), paramqyd);
      a(paramInt, paramqyd, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramqyd.getItemView();
      localTextView1.setText(acfp.m(2131714391) + plr.asY);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130847673);
    }
  }
  
  private View c(int paramInt, qyd paramqyd)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.a.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      ram.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramqyd.getItemView();
    }
    Object localObject = (RelativeLayout)paramqyd.get(2131375117);
    ImageView localImageView = (ImageView)paramqyd.get(2131368398);
    TextView localTextView1 = (TextView)paramqyd.get(2131372361);
    TextView localTextView2 = (TextView)paramqyd.get(2131375143);
    TextView localTextView3 = (TextView)paramqyd.get(2131375144);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramqyd.get(2131382005);
    TextView localTextView4 = (TextView)paramqyd.get(2131378958);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375142);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramqyd.get(2131381732);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = aqhu.aU();
    localImageView.setImageDrawable(aqdj.a(QQStoryContext.c(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130847672);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      c(localTextView4, 2, acfp.m(2131714380));
      a(this.a.bS(), paramqyd);
      a(paramInt, paramqyd, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramqyd.getItemView();
      localTextView1.setText(acfp.m(2131714398) + plr.asY);
    }
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (Ky()) {
      return c(paramInt, paramqyd);
    }
    if (this.a.Kq()) {
      return b(paramInt, paramqyd);
    }
    throw new IllegalStateException("bind view failed because it's not a share group feed.");
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.a != null) && (this.a.Kq()) && (this.a.bS().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "ShareGroupFeedProfileSegment";
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.Kq())
      {
        ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.b().getOwner();
        if (localShareGroupItem.isSubscribe())
        {
          new qox(qem.getQQAppInterface()).a(this.context, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
          continue;
          QQToast.a(this.context, 0, acfp.m(2131714370), 0).show();
        }
      }
    }
  }
  
  protected void wB(int paramInt)
  {
    super.wB(paramInt);
    if (this.a.d.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.a.d.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.a.d.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.context, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, qem.Z(this.mSource, this.bnW));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.context, 2, localShareGroupItem.shareGroupId, null, i, qem.Z(this.mSource, this.bnW));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qth
 * JD-Core Version:    0.7.0.1
 */