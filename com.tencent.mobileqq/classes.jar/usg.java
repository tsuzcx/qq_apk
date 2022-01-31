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
import java.util.List;

public class usg
  extends use
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public usg(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, vap paramvap)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Upp.a().getOwner();
    if (localShareGroupItem == null)
    {
      ved.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramvap.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramvap.a(2131373235);
    ImageView localImageView = (ImageView)paramvap.a(2131367399);
    TextView localTextView1 = (TextView)paramvap.a(2131370809);
    TextView localTextView2 = (TextView)paramvap.a(2131373261);
    TextView localTextView3 = (TextView)paramvap.a(2131373262);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131379256);
    TextView localTextView4 = (TextView)paramvap.a(2131376661);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramvap.a(2131373260);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvap.a(2131379019);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(sxt.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Upp.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130845901);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Upp.a(), paramvap);
      a(paramInt, paramvap, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramvap.a();
      localTextView1.setText(ajya.a(2131713944) + ssf.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130845900);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = vba.a(this.jdField_a_of_type_Upp.a(), this.jdField_a_of_type_Upp.a());
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
  
  private View b(int paramInt, vap paramvap)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Upp.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      ved.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramvap.a();
    }
    Object localObject = (RelativeLayout)paramvap.a(2131373235);
    ImageView localImageView = (ImageView)paramvap.a(2131367399);
    TextView localTextView1 = (TextView)paramvap.a(2131370809);
    TextView localTextView2 = (TextView)paramvap.a(2131373261);
    TextView localTextView3 = (TextView)paramvap.a(2131373262);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvap.a(2131379256);
    TextView localTextView4 = (TextView)paramvap.a(2131376661);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373260);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvap.a(2131379019);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bbef.a();
    localImageView.setImageDrawable(bayh.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130845899);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, ajya.a(2131713933));
      a(this.jdField_a_of_type_Upp.a(), paramvap);
      a(paramInt, paramvap, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramvap.a();
      localTextView1.setText(ajya.a(2131713951) + ssf.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Upp.f()) && (this.jdField_a_of_type_Upp.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.f()) && (this.jdField_a_of_type_Upp.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramvap);
    }
    if (this.jdField_a_of_type_Upp.f()) {
      return a(paramInt, paramvap);
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
    if (this.jdField_a_of_type_Upp.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Upp.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, tsr.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, tsr.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131376661: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Upp.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_Upp.a().getOwner();
      } while (!paramView.isSubscribe());
      new ukf(tsr.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, 0, ajya.a(2131713923), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usg
 * JD-Core Version:    0.7.0.1
 */