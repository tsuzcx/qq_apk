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
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class qtc
  extends BaseAdapter
{
  protected QQStoryAutoPlayView.a a;
  public qwn a;
  public boolean aFp = true;
  public int bnY;
  private int bnZ;
  public qyd c;
  public VideoListFeedItem e;
  public int from;
  private LruCache<String, QQUserUIItem> i = new LruCache(1024);
  public List<StoryVideoItem> la = new ArrayList();
  public final Context mContext;
  private int mVideoHeight;
  private int mVideoWidth;
  public Activity y;
  
  public qtc(Context paramContext, Activity paramActivity, int paramInt)
  {
    this(paramContext, paramActivity, paramInt, 0);
  }
  
  public qtc(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.y = paramActivity;
    this.from = paramInt1;
    this.bnY = paramInt2;
  }
  
  public static int b(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploading()) {
      return 3;
    }
    if (paramStoryVideoItem.isUploadFail()) {
      return 2;
    }
    return 1;
  }
  
  private void c(ViewGroup paramViewGroup, View paramView)
  {
    ram.w("Q.qqstory.detail.FeedItemThumbAdapter", "publishAnimationForQIM");
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
      localObjectAnimator.addUpdateListener(new qte(this, localStoryHomeHorizontalListView));
    }
  }
  
  protected View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramqyd.position = paramInt;
    if ((this.la == null) || (paramInt >= this.la.size()))
    {
      ram.e("Q.qqstory.detail.FeedItemThumbAdapter", "bind view failed because of invalidate data.");
      return paramqyd.getItemView();
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.la.get(paramInt);
    QQStoryAutoPlayView localQQStoryAutoPlayView = (QQStoryAutoPlayView)paramqyd.get(2131375154);
    TextView localTextView = (TextView)paramqyd.get(2131375155);
    StoryNickNameView localStoryNickNameView = (StoryNickNameView)paramqyd.get(2131375153);
    if ((this.mVideoWidth != 0) && (this.mVideoWidth != localQQStoryAutoPlayView.getLayoutParams().width) && (this.mVideoHeight != 0) && (this.mVideoHeight != localQQStoryAutoPlayView.getLayoutParams().height))
    {
      localQQStoryAutoPlayView.getLayoutParams().width = this.mVideoWidth;
      localQQStoryAutoPlayView.getLayoutParams().height = this.mVideoHeight;
      paramqyd.getItemView().getLayoutParams().width = this.mVideoWidth;
    }
    if (this.bnZ > 0) {
      localQQStoryAutoPlayView.a().setCorner(this.bnZ);
    }
    localQQStoryAutoPlayView.setItemData(this.e, localStoryVideoItem, paramInt);
    if (this.jdField_a_of_type_Qwn != null) {
      localQQStoryAutoPlayView.a(this.jdField_a_of_type_Qwn);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a != null) {
      localQQStoryAutoPlayView.setStoryCoverClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a);
    }
    qyk.a(localStoryVideoItem, localQQStoryAutoPlayView, "QQStory_feed_min", this.mVideoWidth, this.mVideoHeight);
    if (localStoryVideoItem.mHadRead == 1)
    {
      localTextView.setTextColor(this.mContext.getResources().getColor(2131167393));
      if (!localStoryVideoItem.isUploadFail()) {
        break label574;
      }
      localTextView.setText(acfp.m(2131706168));
      localTextView.setTextColor(this.mContext.getResources().getColor(2131167393));
      localStoryNickNameView.setUnionId(null);
      label315:
      if (!localStoryVideoItem.isUploading()) {
        break label777;
      }
      localQQStoryAutoPlayView.a().setVid(localStoryVideoItem.mVid);
      localQQStoryAutoPlayView.a().setVisibility(0);
      poe.a().a(localStoryVideoItem.mVid, localQQStoryAutoPlayView.a());
    }
    for (;;)
    {
      if ((ppg.ID()) && (this.aFp) && (paramInt == 0) && (this.e.getOwner().isMe()))
      {
        this.aFp = false;
        c(paramViewGroup, localQQStoryAutoPlayView);
      }
      if ((this.e.type == 3) && ((this.e.getOwner() instanceof QQUserUIItem)))
      {
        paramViewGroup = (QQUserUIItem)this.e.getOwner();
        if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
          rar.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
        }
      }
      if (this.e.type == 6) {
        rar.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      }
      return paramqyd.getItemView();
      localTextView.setTextColor(this.mContext.getResources().getColor(2131167304));
      break;
      label574:
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
      {
        str = rpq.f(localStoryVideoItem.mCreateTime, localStoryVideoItem.mTimeZoneOffsetMillis);
        label601:
        localTextView.setText(str);
        if (!(this.e.getOwner() instanceof ShareGroupItem)) {
          break label679;
        }
        localStoryNickNameView.setUnionId(null);
        localStoryNickNameView.setVisibility(0);
        localStoryNickNameView.setText(localStoryVideoItem.mOwnerName);
      }
      for (;;)
      {
        if (!(this.e.getOwner() instanceof TagUserItem)) {
          break label768;
        }
        localTextView.setVisibility(8);
        break;
        str = rpq.aM(localStoryVideoItem.mCreateTime);
        break label601;
        label679:
        if ((this.e.getOwner() instanceof TagUserItem))
        {
          localStoryNickNameView.setUnionId(null);
        }
        else if ((qyk.h(localStoryVideoItem)) && (localStoryVideoItem.getVideoLinkInfo().a != null))
        {
          localStoryNickNameView.setFormat(acfp.m(2131706167));
          localStoryNickNameView.c(this.i);
          localStoryNickNameView.setUnionId(localStoryVideoItem.getVideoLinkInfo().a.avo);
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
      for (String str = localStoryVideoItem.mVid;; str = poe.a().fO(localStoryVideoItem.mVid))
      {
        localQQStoryAutoPlayView.a().setVid(str);
        if (!localQQStoryAutoPlayView.a().KO()) {
          break label865;
        }
        ram.b("Q.qqstory.detail.FeedItemThumbAdapter", "vid:%s, animation not end", str);
        localQQStoryAutoPlayView.a().a(new qtd(this, str, localQQStoryAutoPlayView));
        break;
      }
      label865:
      localQQStoryAutoPlayView.a().setVisibility(4);
      poe.a().a(localQQStoryAutoPlayView.a());
    }
  }
  
  public void a(@NonNull LruCache<String, QQUserUIItem> paramLruCache)
  {
    this.i = paramLruCache;
  }
  
  public void a(List<StoryVideoItem> paramList, VideoListFeedItem paramVideoListFeedItem)
  {
    this.la.clear();
    this.la.addAll(paramList);
    this.e = paramVideoListFeedItem;
    notifyDataSetChanged();
  }
  
  public void a(qwn paramqwn)
  {
    this.jdField_a_of_type_Qwn = paramqwn;
  }
  
  protected qyd b(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.mContext).inflate(2131561852, paramViewGroup, false));
  }
  
  public int getCount()
  {
    if (this.la == null) {
      return 0;
    }
    return this.la.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.la != null) && (paramInt < this.la.size())) {
      return this.la.get(paramInt);
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
    auvk.traceBegin("FeedItem.getView");
    Object localObject;
    if (paramInt == 0)
    {
      if (this.c == null) {
        this.c = b(0, paramViewGroup);
      }
      localObject = a(0, this.c, paramViewGroup);
      auvk.traceEnd();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {
      localObject = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      localObject = a(paramInt, (qyd)localObject, paramViewGroup);
      auvk.traceEnd();
      break;
      qyd localqyd = (qyd)paramView.getTag();
      localObject = localqyd;
      if (localqyd == null) {
        localObject = b(paramInt, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setStoryCoverClickListener(QQStoryAutoPlayView.a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$a = parama;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
  }
  
  public void wA(int paramInt)
  {
    this.bnZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtc
 * JD-Core Version:    0.7.0.1
 */