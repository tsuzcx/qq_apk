import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class xyo
  extends BaseAdapter
{
  public int a;
  public Activity a;
  public final Context a;
  private LruCache<String, QQUserUIItem> a;
  public VideoListFeedItem a;
  public List<StoryVideoItem> a;
  public yer a;
  protected yeu a;
  public yhc a;
  public boolean a;
  public int b;
  private int c;
  private int d;
  private int e;
  
  public xyo(Context paramContext, Activity paramActivity, int paramInt)
  {
    this(paramContext, paramActivity, paramInt, 0);
  }
  
  public xyo(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploading()) {
      return 3;
    }
    if (paramStoryVideoItem.isUploadFail()) {
      return 2;
    }
    return 1;
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    ykq.d("Q.qqstory.detail.FeedItemThumbAdapter", "publishAnimationForQIM");
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    paramViewGroup = ObjectAnimator.ofFloat(paramViewGroup, "translationX", new float[] { -300.0F, 0.0F });
    localAnimatorSet.setDuration(500L);
    if (getCount() <= 2) {
      localAnimatorSet.play(localObjectAnimator).with(paramView).with(paramViewGroup);
    }
    for (;;)
    {
      localAnimatorSet.start();
      return;
      localStoryHomeHorizontalListView.scrollTo(300, 0);
      localAnimatorSet.play(localObjectAnimator).with(paramView);
      localObjectAnimator.addUpdateListener(new xyq(this, localStoryHomeHorizontalListView));
    }
  }
  
  protected View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramyhc.b = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      ykq.e("Q.qqstory.detail.FeedItemThumbAdapter", "bind view failed because of invalidate data.");
      return paramyhc.a();
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QQStoryAutoPlayView localQQStoryAutoPlayView = (QQStoryAutoPlayView)paramyhc.a(2131374618);
    TextView localTextView = (TextView)paramyhc.a(2131374619);
    StoryNickNameView localStoryNickNameView = (StoryNickNameView)paramyhc.a(2131374617);
    if ((this.c != 0) && (this.c != localQQStoryAutoPlayView.getLayoutParams().width) && (this.d != 0) && (this.d != localQQStoryAutoPlayView.getLayoutParams().height))
    {
      localQQStoryAutoPlayView.getLayoutParams().width = this.c;
      localQQStoryAutoPlayView.getLayoutParams().height = this.d;
      paramyhc.a().getLayoutParams().width = this.c;
    }
    if (this.e > 0) {
      localQQStoryAutoPlayView.a().setCorner(this.e);
    }
    localQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
    if (this.jdField_a_of_type_Yer != null) {
      localQQStoryAutoPlayView.a(this.jdField_a_of_type_Yer);
    }
    if (this.jdField_a_of_type_Yeu != null) {
      localQQStoryAutoPlayView.setStoryCoverClickListener(this.jdField_a_of_type_Yeu);
    }
    yhn.a(localStoryVideoItem, localQQStoryAutoPlayView, "QQStory_feed_min", this.c, this.d);
    if (localStoryVideoItem.mHadRead == 1)
    {
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167120));
      if (!localStoryVideoItem.isUploadFail()) {
        break label574;
      }
      localTextView.setText(anvx.a(2131703924));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167120));
      localStoryNickNameView.setUnionId(null);
      label315:
      if (!localStoryVideoItem.isUploading()) {
        break label777;
      }
      localQQStoryAutoPlayView.a().a(localStoryVideoItem.mVid);
      localQQStoryAutoPlayView.a().a(0);
      wcz.a().a(localStoryVideoItem.mVid, localQQStoryAutoPlayView.a());
    }
    for (;;)
    {
      if ((weh.a()) && (this.jdField_a_of_type_Boolean) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner().isMe()))
      {
        this.jdField_a_of_type_Boolean = false;
        a(paramViewGroup, localQQStoryAutoPlayView);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.type == 3) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof QQUserUIItem)))
      {
        paramViewGroup = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
        if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
          ykv.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.type == 6) {
        ykv.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      }
      return paramyhc.a();
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
      break;
      label574:
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
      {
        str = UIUtils.convertToHHMM(localStoryVideoItem.mCreateTime, localStoryVideoItem.mTimeZoneOffsetMillis);
        label601:
        localTextView.setText(str);
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label679;
        }
        localStoryNickNameView.setUnionId(null);
        localStoryNickNameView.setVisibility(0);
        localStoryNickNameView.setText(localStoryVideoItem.mOwnerName);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem)) {
          break label768;
        }
        localTextView.setVisibility(8);
        break;
        str = UIUtils.convertToHHMM(localStoryVideoItem.mCreateTime);
        break label601;
        label679:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem))
        {
          localStoryNickNameView.setUnionId(null);
        }
        else if ((yhn.a(localStoryVideoItem)) && (localStoryVideoItem.getVideoLinkInfo().a != null))
        {
          localStoryNickNameView.setFormat(anvx.a(2131703922));
          localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
          localStoryNickNameView.setUnionId(localStoryVideoItem.getVideoLinkInfo().a.a);
        }
        else
        {
          localStoryNickNameView.setUnionId(null);
        }
      }
      label768:
      localTextView.setVisibility(0);
      break label315;
      label777:
      if (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {}
      for (String str = localStoryVideoItem.mVid;; str = wcz.a().a(localStoryVideoItem.mVid))
      {
        localQQStoryAutoPlayView.a().a(str);
        if (!localQQStoryAutoPlayView.a().a()) {
          break label865;
        }
        ykq.a("Q.qqstory.detail.FeedItemThumbAdapter", "vid:%s, animation not end", str);
        localQQStoryAutoPlayView.a().a(new xyp(this, str, localQQStoryAutoPlayView));
        break;
      }
      label865:
      localQQStoryAutoPlayView.a().a(4);
      wcz.a().a(localQQStoryAutoPlayView.a());
    }
  }
  
  protected yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561682, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(@NonNull LruCache<String, QQUserUIItem> paramLruCache)
  {
    this.jdField_a_of_type_AndroidUtilLruCache = paramLruCache;
  }
  
  public void a(List<StoryVideoItem> paramList, VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
    notifyDataSetChanged();
  }
  
  public void a(yer paramyer)
  {
    this.jdField_a_of_type_Yer = paramyer;
  }
  
  public void a(yeu paramyeu)
  {
    this.jdField_a_of_type_Yeu = paramyeu;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    blfz.a("FeedItem.getView");
    Object localObject;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Yhc == null) {
        this.jdField_a_of_type_Yhc = a(0, paramViewGroup);
      }
      localObject = a(0, this.jdField_a_of_type_Yhc, paramViewGroup);
      blfz.a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {
      localObject = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      localObject = a(paramInt, (yhc)localObject, paramViewGroup);
      blfz.a();
      break;
      yhc localyhc = (yhc)paramView.getTag();
      localObject = localyhc;
      if (localyhc == null) {
        localObject = a(paramInt, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyo
 * JD-Core Version:    0.7.0.1
 */