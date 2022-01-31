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
import java.util.List;

public class wgy
  extends wgw
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public wgy(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, wph paramwph)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Weh.a().getOwner();
    if (localShareGroupItem == null)
    {
      wsv.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramwph.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramwph.a(2131373684);
    ImageView localImageView = (ImageView)paramwph.a(2131367528);
    TextView localTextView1 = (TextView)paramwph.a(2131371120);
    TextView localTextView2 = (TextView)paramwph.a(2131373710);
    TextView localTextView3 = (TextView)paramwph.a(2131373711);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwph.a(2131379957);
    TextView localTextView4 = (TextView)paramwph.a(2131377171);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramwph.a(2131373709);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwph.a(2131379688);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(uml.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Weh.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846280);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Weh.a(), paramwph);
      a(paramInt, paramwph, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramwph.a();
      localTextView1.setText(alpo.a(2131714316) + ugx.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846279);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = wps.a(this.jdField_a_of_type_Weh.a(), this.jdField_a_of_type_Weh.a());
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
  
  private View b(int paramInt, wph paramwph)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Weh.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      wsv.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramwph.a();
    }
    Object localObject = (RelativeLayout)paramwph.a(2131373684);
    ImageView localImageView = (ImageView)paramwph.a(2131367528);
    TextView localTextView1 = (TextView)paramwph.a(2131371120);
    TextView localTextView2 = (TextView)paramwph.a(2131373710);
    TextView localTextView3 = (TextView)paramwph.a(2131373711);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwph.a(2131379957);
    TextView localTextView4 = (TextView)paramwph.a(2131377171);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373709);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwph.a(2131379688);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bdda.a();
    localImageView.setImageDrawable(bcxb.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846278);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, alpo.a(2131714305));
      a(this.jdField_a_of_type_Weh.a(), paramwph);
      a(paramInt, paramwph, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramwph.a();
      localTextView1.setText(alpo.a(2131714323) + ugx.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Weh.f()) && (this.jdField_a_of_type_Weh.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.f()) && (this.jdField_a_of_type_Weh.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramwph);
    }
    if (this.jdField_a_of_type_Weh.f()) {
      return a(paramInt, paramwph);
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
    if (this.jdField_a_of_type_Weh.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Weh.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Weh.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, vhj.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, vhj.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131377171: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Weh.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_Weh.a().getOwner();
      } while (!paramView.isSubscribe());
      new vyx(vhj.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alpo.a(2131714295), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgy
 * JD-Core Version:    0.7.0.1
 */