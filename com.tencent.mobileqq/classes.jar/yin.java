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

public class yin
  extends yil
{
  public static final String KEY = "ShareGroupFeedProfileSegment";
  
  public yin(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1, paramInt2);
  }
  
  private View a(int paramInt, yqw paramyqw)
  {
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Yfw.a().getOwner();
    if (localShareGroupItem == null)
    {
      yuk.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramyqw.a();
    }
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramyqw.a(2131374575);
    ImageView localImageView = (ImageView)paramyqw.a(2131367917);
    TextView localTextView1 = (TextView)paramyqw.a(2131371805);
    TextView localTextView2 = (TextView)paramyqw.a(2131374601);
    TextView localTextView3 = (TextView)paramyqw.a(2131374602);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyqw.a(2131381155);
    TextView localTextView4 = (TextView)paramyqw.a(2131378191);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramyqw.a(2131374600);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyqw.a(2131380880);
    localRelativeLayout1.setOnClickListener(this);
    localImageView.setImageDrawable(wob.a(localShareGroupItem.headerUnionIdList));
    if (!TextUtils.isEmpty(localShareGroupItem.getName()))
    {
      localTextView1.setText(localShareGroupItem.getName());
      if (this.jdField_a_of_type_Yfw.f()) {
        a(localTextView2, localTextView3);
      }
      if (!localShareGroupItem.isPublic()) {
        break label277;
      }
      localStoryUserBadgeView.setImageResource(2130846809);
    }
    for (;;)
    {
      localStoryUserBadgeView.setOnClickListener(null);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 0, null);
      a(this.jdField_a_of_type_Yfw.a(), paramyqw);
      a(paramInt, paramyqw, localRelativeLayout2, localStoryHomeHorizontalListView);
      return paramyqw.a();
      localTextView1.setText(anzj.a(2131712807) + win.a);
      break;
      label277:
      localStoryUserBadgeView.setImageResource(2130846808);
    }
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2)
  {
    Object localObject = yrh.a(this.jdField_a_of_type_Yfw.a(), this.jdField_a_of_type_Yfw.a());
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
  
  private View b(int paramInt, yqw paramyqw)
  {
    ShareGroupFeedItem localShareGroupFeedItem = this.jdField_a_of_type_Yfw.a();
    if ((localShareGroupFeedItem == null) || (localShareGroupFeedItem.getOwner() == null))
    {
      yuk.e("Q.qqstory.detail.ShareGroupFeedProfileSegment", "bind share group view failed because it's invalidate date.");
      return paramyqw.a();
    }
    Object localObject = (RelativeLayout)paramyqw.a(2131374575);
    ImageView localImageView = (ImageView)paramyqw.a(2131367917);
    TextView localTextView1 = (TextView)paramyqw.a(2131371805);
    TextView localTextView2 = (TextView)paramyqw.a(2131374601);
    TextView localTextView3 = (TextView)paramyqw.a(2131374602);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramyqw.a(2131381155);
    TextView localTextView4 = (TextView)paramyqw.a(2131378191);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyqw.a(2131374600);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramyqw.a(2131380880);
    ((RelativeLayout)localObject).setOnClickListener(this);
    localObject = bhmq.a();
    localImageView.setImageDrawable(aoot.a(QQStoryContext.a(), 4, String.valueOf(localShareGroupFeedItem.getOwner().groupUin), 3, (Drawable)localObject, (Drawable)localObject));
    if (!TextUtils.isEmpty(localShareGroupFeedItem.getOwner().getName())) {
      localTextView1.setText(localShareGroupFeedItem.getOwner().getName());
    }
    for (;;)
    {
      a(localTextView2, localTextView3);
      localStoryUserBadgeView.setImageResource(2130846807);
      localStoryUserBadgeView.setOnClickListener(this);
      localStoryUserBadgeView.setVisibility(0);
      a(localTextView4, 2, anzj.a(2131712796));
      a(this.jdField_a_of_type_Yfw.a(), paramyqw);
      a(paramInt, paramyqw, localRelativeLayout, localStoryHomeHorizontalListView);
      return paramyqw.a();
      localTextView1.setText(anzj.a(2131712814) + win.a);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Yfw.f()) && (this.jdField_a_of_type_Yfw.a().getOwner().getRelationType() == 2);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null) && (this.jdField_a_of_type_Yfw.f()) && (this.jdField_a_of_type_Yfw.a().size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (b()) {
      return b(paramInt, paramyqw);
    }
    if (this.jdField_a_of_type_Yfw.f()) {
      return a(paramInt, paramyqw);
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
    if (this.jdField_a_of_type_Yfw.a.getOwner().isSubscribe()) {}
    for (int i = 3; !(this.jdField_a_of_type_Yfw.a.getOwner() instanceof ShareGroupItem); i = 4) {
      return;
    }
    ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Yfw.a.getOwner();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, localShareGroupItem.shareGroupId, String.valueOf(localShareGroupItem.groupUin), i, xiz.a(this.jdField_a_of_type_Int, this.b));
      return;
    }
    QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, localShareGroupItem.shareGroupId, null, i, xiz.a(this.jdField_a_of_type_Int, this.b));
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
      if (this.jdField_a_of_type_Yfw.f())
      {
        ShareGroupItem localShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Yfw.a().getOwner();
        if (localShareGroupItem.isSubscribe())
        {
          new yam(xiz.a()).a(this.jdField_a_of_type_AndroidContentContext, localShareGroupItem.type, localShareGroupItem.shareGroupId, localShareGroupItem.name, localShareGroupItem.groupUin, 20003, 2);
          continue;
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anzj.a(2131712786), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */