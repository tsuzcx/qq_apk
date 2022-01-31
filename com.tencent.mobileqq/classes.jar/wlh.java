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

public class wlh
  extends wlf
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public wlh(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, wtq paramwtq)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Wiq.a().getOwner();
    if (localShareGroupItem == null)
    {
      wxe.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramwtq.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramwtq.a(2131373735);
    ImageView localImageView = (ImageView)paramwtq.a(2131367538);
    TextView localTextView1 = (TextView)paramwtq.a(2131371139);
    TextView localTextView2 = (TextView)paramwtq.a(2131373761);
    TextView localTextView3 = (TextView)paramwtq.a(2131373762);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwtq.a(2131380015);
    TextView localTextView4 = (TextView)paramwtq.a(2131377225);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramwtq.a(2131373760);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwtq.a(2131379746);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(uqu.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Wiq.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846353);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Wiq.a(), paramwtq);
      a(paramInt, paramwtq, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramwtq.a();
      localTextView1.setText(alud.a(2131714328) + ulg.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846352);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = wub.a(this.jdField_a_of_type_Wiq.a(), this.jdField_a_of_type_Wiq.a());
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
  
  private View b(int paramInt, wtq paramwtq)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Wiq.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      wxe.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramwtq.a();
    }
    Object localObject = (RelativeLayout)paramwtq.a(2131373735);
    ImageView localImageView = (ImageView)paramwtq.a(2131367538);
    TextView localTextView1 = (TextView)paramwtq.a(2131371139);
    TextView localTextView2 = (TextView)paramwtq.a(2131373761);
    TextView localTextView3 = (TextView)paramwtq.a(2131373762);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramwtq.a(2131380015);
    TextView localTextView4 = (TextView)paramwtq.a(2131377225);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373760);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramwtq.a(2131379746);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bdhj.a();
    localImageView.setImageDrawable(bdbk.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846351);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, alud.a(2131714317));
      a(this.jdField_a_of_type_Wiq.a(), paramwtq);
      a(paramInt, paramwtq, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramwtq.a();
      localTextView1.setText(alud.a(2131714335) + ulg.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Wiq.f()) && (this.jdField_a_of_type_Wiq.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.f()) && (this.jdField_a_of_type_Wiq.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramwtq);
    }
    if (this.jdField_a_of_type_Wiq.f()) {
      return a(paramInt, paramwtq);
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
    if (this.jdField_a_of_type_Wiq.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Wiq.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Wiq.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, vls.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, vls.a(this.jdField_a_of_type_Int, this.b));
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131377225: 
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_Wiq.f());
        paramView = (ShareGroupItem)this.jdField_a_of_type_Wiq.a().getOwner();
      } while (!paramView.isSubscribe());
      new wdg(vls.a()).a(this.jdField_a_of_type_AndroidContentContext, paramView.type, paramView.shareGroupId, paramView.name, paramView.groupUin, 20003, 2);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alud.a(2131714307), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */