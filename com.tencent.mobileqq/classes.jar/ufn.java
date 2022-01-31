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

public class ufn
  extends ufl
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public ufn(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, unw paramunw)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ucw.a().getOwner();
    if (localShareGroupItem == null)
    {
      urk.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramunw.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramunw.a(2131307520);
    ImageView localImageView = (ImageView)paramunw.a(2131301789);
    TextView localTextView1 = (TextView)paramunw.a(2131305136);
    TextView localTextView2 = (TextView)paramunw.a(2131307546);
    TextView localTextView3 = (TextView)paramunw.a(2131307547);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramunw.a(2131313417);
    TextView localTextView4 = (TextView)paramunw.a(2131310852);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramunw.a(2131307545);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramunw.a(2131313179);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(sla.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Ucw.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130845713);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Ucw.a(), paramunw);
      a(paramInt, paramunw, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramunw.a();
      localTextView1.setText(ajjy.a(2131648145) + sfm.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130845712);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = uoh.a(this.jdField_a_of_type_Ucw.a(), this.jdField_a_of_type_Ucw.a());
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
  
  private View b(int paramInt, unw paramunw)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Ucw.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      urk.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramunw.a();
    }
    Object localObject = (RelativeLayout)paramunw.a(2131307520);
    ImageView localImageView = (ImageView)paramunw.a(2131301789);
    TextView localTextView1 = (TextView)paramunw.a(2131305136);
    TextView localTextView2 = (TextView)paramunw.a(2131307546);
    TextView localTextView3 = (TextView)paramunw.a(2131307547);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramunw.a(2131313417);
    TextView localTextView4 = (TextView)paramunw.a(2131310852);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307545);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramunw.a(2131313179);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bacm.a();
    localImageView.setImageDrawable(azwp.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130845711);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, ajjy.a(2131648134));
      a(this.jdField_a_of_type_Ucw.a(), paramunw);
      a(paramInt, paramunw, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramunw.a();
      localTextView1.setText(ajjy.a(2131648152) + sfm.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Ucw.f()) && (this.jdField_a_of_type_Ucw.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.f()) && (this.jdField_a_of_type_Ucw.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramunw);
    }
    if (this.jdField_a_of_type_Ucw.f()) {
      return a(paramInt, paramunw);
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
    if (this.jdField_a_of_type_Ucw.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ucw.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, tfy.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, tfy.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131310852: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Ucw.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_Ucw.a().getOwner();
      } while (!paramView.isSubscribe());
      new txm(tfy.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, ajjy.a(2131648124), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */