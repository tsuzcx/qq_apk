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

public class yes
  extends yeq
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public yes(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, ynb paramynb)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ycb.a().getOwner();
    if (localShareGroupItem == null)
    {
      yqp.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramynb.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramynb.a(2131374438);
    ImageView localImageView = (ImageView)paramynb.a(2131367849);
    TextView localTextView1 = (TextView)paramynb.a(2131371697);
    TextView localTextView2 = (TextView)paramynb.a(2131374464);
    TextView localTextView3 = (TextView)paramynb.a(2131374465);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramynb.a(2131380975);
    TextView localTextView4 = (TextView)paramynb.a(2131378036);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramynb.a(2131374463);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramynb.a(2131380702);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(wkg.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Ycb.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846792);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Ycb.a(), paramynb);
      a(paramInt, paramynb, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramynb.a();
      localTextView1.setText(anni.a(2131712698) + wes.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846791);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = ynm.a(this.jdField_a_of_type_Ycb.a(), this.jdField_a_of_type_Ycb.a());
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
  
  private View b(int paramInt, ynb paramynb)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Ycb.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      yqp.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramynb.a();
    }
    Object localObject = (RelativeLayout)paramynb.a(2131374438);
    ImageView localImageView = (ImageView)paramynb.a(2131367849);
    TextView localTextView1 = (TextView)paramynb.a(2131371697);
    TextView localTextView2 = (TextView)paramynb.a(2131374464);
    TextView localTextView3 = (TextView)paramynb.a(2131374465);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramynb.a(2131380975);
    TextView localTextView4 = (TextView)paramynb.a(2131378036);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramynb.a(2131374463);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramynb.a(2131380702);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bgmo.a();
    localImageView.setImageDrawable(aoch.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846790);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, anni.a(2131712687));
      a(this.jdField_a_of_type_Ycb.a(), paramynb);
      a(paramInt, paramynb, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramynb.a();
      localTextView1.setText(anni.a(2131712705) + wes.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Ycb.f()) && (this.jdField_a_of_type_Ycb.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null) && (this.jdField_a_of_type_Ycb.f()) && (this.jdField_a_of_type_Ycb.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramynb);
    }
    if (this.jdField_a_of_type_Ycb.f()) {
      return a(paramInt, paramynb);
    }
    throw new IllegalStateException("bind view failed because it's not a share group feed.");
  }
  
  public String a()
  {
    return "ShareGroupFeedProfileSegment";
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Ycb.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Ycb.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ycb.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, xfe.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, xfe.a(this.jdField_a_of_type_Int, this.b));
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
      if (this.jdField_a_of_type_Ycb.f())
      {
        ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ycb.a().getOwner();
        if (localShareGroupItem.isSubscribe())
        {
          new xwr(xfe.a()).a(this.jdField_a_of_type_AndroidContentContext, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
          continue;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anni.a(2131712677), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yes
 * JD-Core Version:    0.7.0.1
 */