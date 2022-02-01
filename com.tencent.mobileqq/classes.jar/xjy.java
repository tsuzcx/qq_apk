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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class xjy
  extends xjw
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public xjy(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, xsh paramxsh)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xhh.a().getOwner();
    if (localShareGroupItem == null)
    {
      xvv.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramxsh.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramxsh.a(2131374343);
    ImageView localImageView = (ImageView)paramxsh.a(2131367950);
    TextView localTextView1 = (TextView)paramxsh.a(2131371769);
    TextView localTextView2 = (TextView)paramxsh.a(2131374369);
    TextView localTextView3 = (TextView)paramxsh.a(2131374370);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramxsh.a(2131380874);
    TextView localTextView4 = (TextView)paramxsh.a(2131377961);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramxsh.a(2131374368);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramxsh.a(2131380606);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(vps.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Xhh.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846717);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Xhh.a(), paramxsh);
      a(paramInt, paramxsh, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramxsh.a();
      localTextView1.setText(amtj.a(2131713039) + vkm.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846716);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if ((this.jdField_a_of_type_Xhh == null) || (this.jdField_a_of_type_Xhh.a() == null)) {
      return;
    }
    Object localObject = xss.a(this.jdField_a_of_type_Xhh.a(), this.jdField_a_of_type_Xhh.a());
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
  
  private View b(int paramInt, xsh paramxsh)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Xhh.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      xvv.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramxsh.a();
    }
    Object localObject = (RelativeLayout)paramxsh.a(2131374343);
    ImageView localImageView = (ImageView)paramxsh.a(2131367950);
    TextView localTextView1 = (TextView)paramxsh.a(2131371769);
    TextView localTextView2 = (TextView)paramxsh.a(2131374369);
    TextView localTextView3 = (TextView)paramxsh.a(2131374370);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramxsh.a(2131380874);
    TextView localTextView4 = (TextView)paramxsh.a(2131377961);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374368);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramxsh.a(2131380606);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bfvo.a();
    localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846715);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, amtj.a(2131713028));
      a(this.jdField_a_of_type_Xhh.a(), paramxsh);
      a(paramInt, paramxsh, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramxsh.a();
      localTextView1.setText(amtj.a(2131713046) + vkm.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Xhh.f()) && (this.jdField_a_of_type_Xhh.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.f()) && (this.jdField_a_of_type_Xhh.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramxsh);
    }
    if (this.jdField_a_of_type_Xhh.f()) {
      return a(paramInt, paramxsh);
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
    if (this.jdField_a_of_type_Xhh.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Xhh.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xhh.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, wkp.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, wkp.a(this.jdField_a_of_type_Int, this.b));
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
      if (this.jdField_a_of_type_Xhh.f())
      {
        ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xhh.a().getOwner();
        if (localShareGroupItem.isSubscribe())
        {
          new xbx(wkp.a()).a(this.jdField_a_of_type_AndroidContentContext, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
          continue;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, amtj.a(2131713018), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjy
 * JD-Core Version:    0.7.0.1
 */