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

public class xyt
  extends xyr
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public xyt(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, yhc paramyhc)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xwc.a().getOwner();
    if (localShareGroupItem == null)
    {
      ykq.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramyhc.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramyhc.a(2131374581);
    ImageView localImageView = (ImageView)paramyhc.a(2131368086);
    TextView localTextView1 = (TextView)paramyhc.a(2131371958);
    TextView localTextView2 = (TextView)paramyhc.a(2131374607);
    TextView localTextView3 = (TextView)paramyhc.a(2131374608);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyhc.a(2131381226);
    TextView localTextView4 = (TextView)paramyhc.a(2131378249);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramyhc.a(2131374606);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyhc.a(2131380952);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(wen.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Xwc.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846813);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Xwc.a(), paramyhc);
      a(paramInt, paramyhc, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramyhc.a();
      localTextView1.setText(anvx.a(2131713386) + vzh.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846812);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    if ((this.jdField_a_of_type_Xwc == null) || (this.jdField_a_of_type_Xwc.a() == null)) {
      return;
    }
    Object localObject = yhn.a(this.jdField_a_of_type_Xwc.a(), this.jdField_a_of_type_Xwc.a());
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
  
  private View b(int paramInt, yhc paramyhc)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Xwc.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      ykq.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramyhc.a();
    }
    Object localObject = (RelativeLayout)paramyhc.a(2131374581);
    ImageView localImageView = (ImageView)paramyhc.a(2131368086);
    TextView localTextView1 = (TextView)paramyhc.a(2131371958);
    TextView localTextView2 = (TextView)paramyhc.a(2131374607);
    TextView localTextView3 = (TextView)paramyhc.a(2131374608);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyhc.a(2131381226);
    TextView localTextView4 = (TextView)paramyhc.a(2131378249);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374606);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyhc.a(2131380952);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bheg.a();
    localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846811);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, anvx.a(2131713375));
      a(this.jdField_a_of_type_Xwc.a(), paramyhc);
      a(paramInt, paramyhc, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramyhc.a();
      localTextView1.setText(anvx.a(2131713393) + vzh.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Xwc.f()) && (this.jdField_a_of_type_Xwc.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.f()) && (this.jdField_a_of_type_Xwc.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramyhc);
    }
    if (this.jdField_a_of_type_Xwc.f()) {
      return a(paramInt, paramyhc);
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
    if (this.jdField_a_of_type_Xwc.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Xwc.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xwc.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, wzk.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, wzk.a(this.jdField_a_of_type_Int, this.b));
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
      if (this.jdField_a_of_type_Xwc.f())
      {
        ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Xwc.a().getOwner();
        if (localShareGroupItem.isSubscribe())
        {
          new xqs(wzk.a()).a(this.jdField_a_of_type_AndroidContentContext, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
          continue;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anvx.a(2131713365), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyt
 * JD-Core Version:    0.7.0.1
 */