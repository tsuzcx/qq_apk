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

public class usj
  extends ush
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public usj(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, vas paramvas)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ups.a().getOwner();
    if (localShareGroupItem == null)
    {
      veg.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramvas.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramvas.a(2131373233);
    ImageView localImageView = (ImageView)paramvas.a(2131367399);
    TextView localTextView1 = (TextView)paramvas.a(2131370809);
    TextView localTextView2 = (TextView)paramvas.a(2131373259);
    TextView localTextView3 = (TextView)paramvas.a(2131373260);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvas.a(2131379251);
    TextView localTextView4 = (TextView)paramvas.a(2131376659);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramvas.a(2131373258);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvas.a(2131379014);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(sxw.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Ups.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130845895);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Ups.a(), paramvas);
      a(paramInt, paramvas, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramvas.a();
      localTextView1.setText(ajyc.a(2131713933) + ssi.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130845894);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = vbd.a(this.jdField_a_of_type_Ups.a(), this.jdField_a_of_type_Ups.a());
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
  
  private View b(int paramInt, vas paramvas)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Ups.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      veg.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramvas.a();
    }
    Object localObject = (RelativeLayout)paramvas.a(2131373233);
    ImageView localImageView = (ImageView)paramvas.a(2131367399);
    TextView localTextView1 = (TextView)paramvas.a(2131370809);
    TextView localTextView2 = (TextView)paramvas.a(2131373259);
    TextView localTextView3 = (TextView)paramvas.a(2131373260);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramvas.a(2131379251);
    TextView localTextView4 = (TextView)paramvas.a(2131376659);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373258);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramvas.a(2131379014);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bbdr.a();
    localImageView.setImageDrawable(baxt.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130845893);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, ajyc.a(2131713922));
      a(this.jdField_a_of_type_Ups.a(), paramvas);
      a(paramInt, paramvas, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramvas.a();
      localTextView1.setText(ajyc.a(2131713940) + ssi.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Ups.f()) && (this.jdField_a_of_type_Ups.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.f()) && (this.jdField_a_of_type_Ups.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramvas);
    }
    if (this.jdField_a_of_type_Ups.f()) {
      return a(paramInt, paramvas);
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
    if (this.jdField_a_of_type_Ups.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ups.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, tsu.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, tsu.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131376659: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Ups.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_Ups.a().getOwner();
      } while (!paramView.isSubscribe());
      new uki(tsu.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, ajyc.a(2131713912), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usj
 * JD-Core Version:    0.7.0.1
 */