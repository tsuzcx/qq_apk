import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HotRecommendFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.ProfileFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.TroopAssistantHomeFeedPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.16;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.17;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.18;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.6;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class wub
  extends xvp<wpn>
  implements Handler.Callback, IEventReceiver, usp, ute, wqa, wri, wua
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new apkp(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new apkp(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new wud(this);
  public String a;
  private List<wtq> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private uwm jdField_a_of_type_Uwm;
  private woy jdField_a_of_type_Woy;
  protected wpr a;
  private wqn jdField_a_of_type_Wqn;
  protected wrf a;
  wrj jdField_a_of_type_Wrj = new wul(this);
  private wtr jdField_a_of_type_Wtr;
  private wur jdField_a_of_type_Wur;
  private wut jdField_a_of_type_Wut;
  private wuu jdField_a_of_type_Wuu;
  private wuw jdField_a_of_type_Wuw;
  private wuy jdField_a_of_type_Wuy;
  private wuz jdField_a_of_type_Wuz;
  private final int jdField_b_of_type_Int;
  public String b;
  wrj jdField_b_of_type_Wrj = new wum(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  wrj jdField_c_of_type_Wrj = new wun(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  wrj jdField_d_of_type_Wrj = new wuo(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public wub(Context paramContext, Activity paramActivity, int paramInt, wtr paramwtr, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wtr = paramwtr;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Wpr = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wuy = new wuy(this);
    this.jdField_a_of_type_Wuu = new wuu(this);
    this.jdField_a_of_type_Wut = new wut(this);
    this.jdField_a_of_type_Wuz = new wuz(this);
    this.jdField_a_of_type_Wur = new wur(this);
    this.jdField_a_of_type_Wuw = new wuw(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wuy);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wuu);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wut);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wuz);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wur);
    umc.a().registerSubscriber(this.jdField_a_of_type_Wuw);
    this.jdField_a_of_type_Wrf = new wrf(Looper.myLooper());
    this.jdField_a_of_type_Wpr.a();
    this.jdField_a_of_type_Uwm = ((uwm)uwa.a(2));
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Wrf.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298345);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298356);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Wrf.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Wrf.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bdin.h(paramContext)) {
      return 1;
    }
    if (bdin.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup, wph paramwph)
  {
    paramViewGroup = (ImageView)paramwtq.a(2131373741);
    FrameLayout localFrameLayout = (FrameLayout)paramwtq.a(2131373745);
    b(paramwtq);
    a(paramInt, paramwtq, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwtq, paramwph, paramwph.a().getOwner());
    a(paramwtq, paramwph, true);
    a(paramwph, paramwtq);
    a(paramInt, paramwtq);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166988);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwtq.a("feed_id", paramwph.a().feedId);
    a(paramwph, paramwtq, localFrameLayout, null);
    if (!paramwph.jdField_b_of_type_Boolean) {
      wxj.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramwph.a().getOwner().getUnionId(), paramwph.a().feedId });
    }
    paramViewGroup = paramwph.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      wxj.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramwtq.a();
  }
  
  private View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup, wqj paramwqj)
  {
    paramViewGroup = (VideoListLayout)paramwtq.a(2131373774);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(xsm.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((wva)paramwtq.a("general_touch_handler")).a(paramwtq.jdField_b_of_type_Int, paramwtq);
    if ((paramwqj.a() == null) || (paramwqj.a().size() == 0))
    {
      wxe.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramwqj.a()).feedId);
      paramwtq.a.setVisibility(8);
      return paramwtq.a();
    }
    paramwtq.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (wty)paramwtq.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new wty(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramwtq.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Wrf);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramwqj.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        wxe.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramwqj.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramwqj.a().size();
        paramViewGroup.a(paramwqj.a(), paramwqj.a());
        if (((HotRecommendFeedItem)paramwqj.a()).mIsVideoEnd) {
          break label501;
        }
        bool = true;
        label385:
        ((StoryHomeHorizontalListView)localObject1).setLoadMoreComplete(bool);
        if (j > paramInt) {
          ((StoryHomeHorizontalListView)localObject1).post(new FeedSegment.6(this, (StoryHomeHorizontalListView)localObject1));
        }
        if (paramInt > j) {
          ((StoryHomeHorizontalListView)localObject1).a();
        }
        paramViewGroup = paramwtq.a(2131378878);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((uvt)uwa.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        wxj.a("home_page", "multi_exp", 0, 0, new String[0]);
        break;
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(0);
        break label316;
        label501:
        bool = false;
        break label385;
        label507:
        paramViewGroup.setVisibility(0);
      }
    }
  }
  
  private View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup, wqo paramwqo)
  {
    paramViewGroup = (ImageView)paramwtq.a(2131373741);
    a(paramInt, paramwtq, this.jdField_d_of_type_Boolean);
    a(paramwtq, paramwqo);
    a(paramInt, paramwtq);
    a(paramwtq, paramwqo, true);
    a(null, paramwtq);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166988);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    wxj.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramwqo.a()).feedId });
    return paramwtq.a();
  }
  
  private View a(int paramInt, wtq paramwtq, woh paramwoh)
  {
    Object localObject = (QQStoryOwnerInfoView)paramwtq.a(2131373755);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramwtq.a(2131373726);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramwtq.a(2131373718);
    FrameLayout localFrameLayout = (FrameLayout)paramwtq.a(2131373720);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramwoh.a();
    a(paramInt, paramwtq, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, alud.a(2131704846), true);
    if (wmz.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      xsm.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bdhj.a(1), "QQStory_main");
      a(paramInt, paramwtq);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramwoh.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext) - xsm.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (usz)paramwtq.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new usz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwoh, this.jdField_a_of_type_Int);
      ((usz)localObject).a(paramwoh);
      ((usz)localObject).l();
      paramwtq.a("commentLikeLego", localObject);
      localFrameLayout.addView(((usz)localObject).b);
    }
    for (;;)
    {
      ((usz)localObject).a(this);
      ((usz)localObject).a(this);
      ((usz)localObject).a(false);
      if (!paramwoh.jdField_b_of_type_Boolean) {
        wxj.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramwoh.a()).getOwner().getUnionId(), ((BannerFeedItem)paramwoh.a()).feedId });
      }
      return paramwtq.a();
      localButton.setVisibility(8);
      break;
      label518:
      localTextView4.setVisibility(0);
      localTextView4.setText(localBannerFeedItem.content);
      break label164;
      label537:
      localTextView2.setVisibility(0);
      localTextView2.setText(localBannerFeedItem.blurb);
      break label235;
      label556:
      ((usz)localObject).a(paramwoh, null, paramwoh);
      ((usz)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      wxe.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = xsm.a() / 3600;
    paramList = paramList.iterator();
    int k = 0;
    int j = n;
    if (paramList.hasNext())
    {
      localObject = (StoryVideoItem)paramList.next();
      if (TextUtils.isEmpty(((StoryVideoItem)localObject).mUserSelectLocationText)) {}
    }
    for (paramList = ((StoryVideoItem)localObject).mUserSelectLocationText;; paramList = null)
    {
      localObject = paramList;
      if (!TextUtils.isEmpty(paramList)) {
        break;
      }
      if (j != n)
      {
        return wrl.a(j, true);
        if ((k != 0) || (((StoryVideoItem)localObject).mTimeZoneOffsetMillis == 2147483647L)) {
          break label143;
        }
        k = (int)(((StoryVideoItem)localObject).mTimeZoneOffsetMillis / 3600000L);
        j = 1;
      }
      for (;;)
      {
        int m = k;
        k = j;
        j = m;
        break;
        return "";
        label143:
        m = j;
        j = k;
        k = m;
      }
    }
  }
  
  private void a(int paramInt, wqn paramwqn, String paramString, boolean paramBoolean)
  {
    if (!(paramwqn instanceof wqp)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        wxe.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramwqn, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((wtq)localObject1).a(2131373774);
        List localList = ((wqp)paramwqn).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            wxe.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= xsm.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramwqn.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (wlc)((wtq)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((wlc)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            wxe.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramwqn.a().feedId, Integer.valueOf(j));
            wxe.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, wtq paramwtq, wqp paramwqp, ShareGroupItem paramShareGroupItem)
  {
    biby.a("FeedSegment.bindFeedShareGroupInfo");
    paramwtq = (QQStoryOwnerInfoView)paramwtq.a(2131373755);
    if (paramShareGroupItem == null)
    {
      paramwtq.setSubTitle(null);
      paramwtq.setBadge(null);
      paramwtq.setQIMIcon(null);
      paramwtq.setSubTitleSuffix(null);
      paramwtq.setButtonTxt(null);
      paramwtq.setName(vls.jdField_b_of_type_JavaLangString);
      paramwtq.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845986));
      biby.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bdhj.a();
      paramwtq.setAvatar(bdbk.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramwtq.setName(paramShareGroupItem.getName());
      if (paramwqp.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((wqm)paramwqp).a(), paramwqp.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramwtq.setSubTitle((String)localObject1);
        paramwtq.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramwtq.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846351);
      label199:
      if (paramwqp.a().type == 2)
      {
        if (!paramwqp.a()) {
          break label328;
        }
        a(paramwtq, alud.a(2131704853), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramwtq = paramwtq.a();
      paramwtq.a(null);
      paramwtq.setVisibility(8);
      biby.a();
      return;
      paramwtq.setAvatar(((wdt)uwa.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846353);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846352);
      break label199;
      label328:
      a(paramwtq, null, false);
    }
  }
  
  private void a(View paramView)
  {
    paramView.clearAnimation();
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.3F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.3F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
    localAnimatorSet.setDuration(700L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(paramView);
    localAnimatorSet.start();
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString)
  {
    a(paramStoryVideoItem, paramQQStoryAutoPlayView, paramString, -1, -1);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString, int paramInt1, int paramInt2)
  {
    biby.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        wxe.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = wxb.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        wxe.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!wrl.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = wxb.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      biby.a();
      return;
      if (!bool)
      {
        paramInt1 = 225;
        paramInt2 = 364;
        localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        break;
      }
      paramInt1 = 150;
      paramInt2 = 243;
      localDrawable = jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      break;
      label176:
      wxe.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = xsj.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = xsj.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
        }
      }
      else {
        label229:
        paramStoryVideoItem = str;
      }
    }
  }
  
  private void a(HotRecommendFeedItem paramHotRecommendFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
    localbhuf.a(alud.a(2131704848), 5);
    QQUserUIItem localQQUserUIItem = ((uwm)uwa.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = alud.a(2131704849);; str = alud.a(2131704841))
    {
      localbhuf.a(str, 5);
      localbhuf.a(alud.a(2131704866), 5);
      localbhuf.c(2131690648);
      localbhuf.a(new wug(this, localbhuf, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbhuf.a(new wuj(this));
      if (!localbhuf.isShowing()) {
        localbhuf.show();
      }
      wxj.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846162);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
      return;
    }
    try
    {
      paramString1 = new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      if ((paramString1.getStatus() == 2) || (paramString1.getStatus() == 3))
      {
        wrk.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      wrk.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      xsm.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = xsm.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166903));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846090);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166397));
        localButton.setBackgroundResource(2130846090);
      }
      j = xsm.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      xsm.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846089);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166384));
      localButton.setPadding(0, 0, 0, 0);
    }
  }
  
  public static void a(String paramString, ImageView paramImageView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(-3355444);
    localURLDrawableOptions.mMemoryCacheKeySuffix = "q_story";
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(xsm.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<wqn> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((uvt)uwa.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((wqn)paramList.next()).d();
        if (localList != null)
        {
          int n = localList.size();
          int k = paramInt;
          while ((k < paramInt + j) && (k < n))
          {
            localArrayList.add(((StoryVideoItem)localList.get(k)).mVid);
            k += 1;
          }
        }
      }
      wxe.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Wrf.a(localArrayList);
      return;
    }
  }
  
  private void a(wqn paramwqn)
  {
    if ((paramwqn == null) || (paramwqn.a() == null) || (paramwqn.a().getOwner() == null)) {
      xqq.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramwqn instanceof wpg))
      {
        paramwqn = ((wpg)paramwqn).a().getOwner();
        uqn.a(this.jdField_a_of_type_AndroidContentContext, 4, paramwqn.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramwqn instanceof wqm))
      {
        paramwqn = (ShareGroupFeedItem)((wqm)paramwqn).a();
        localObject = paramwqn.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          wxe.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          xqq.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramwqn.getOwner().getRelationType() == 2)
        {
          if (this.jdField_a_of_type_Int == 10)
          {
            j = 1;
            if (this.jdField_a_of_type_Int != 10) {
              break label186;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ShareGroupItem)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), j, k);
            return;
            j = 9;
            break;
          }
        }
        QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, null, 1, 74);
        return;
      }
      if ((paramwqn instanceof wph))
      {
        paramwqn = ((wph)paramwqn).a();
        localObject = paramwqn.getOwner();
        if (paramwqn.getOwner().getRelationType() == 2)
        {
          if (this.jdField_a_of_type_Int == 10)
          {
            j = 2;
            if (this.jdField_a_of_type_Int != 10) {
              break label289;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((QQUserUIItem)localObject).uid, ((QQUserUIItem)localObject).qq, j, k);
            return;
            j = 9;
            break;
          }
        }
        uqn.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramwqn instanceof wqo))
      {
        paramwqn = (TagFeedItem)((wqo)paramwqn).a();
        vmj.a(this.jdField_a_of_type_AndroidAppActivity, paramwqn.tagItem.a);
        return;
      }
    } while (!(paramwqn instanceof wqj));
    label289:
    l();
    wxj.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(wqn paramwqn, ShareGroupItem paramShareGroupItem)
  {
    if (wdf.a(paramShareGroupItem))
    {
      if (paramwqn.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        wxj.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alud.a(2131704865), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new wdg((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    wxj.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(wqn paramwqn, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramwqn.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      wxj.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramwqn.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(wqp paramwqp, wtq paramwtq) {}
  
  private void a(wqp paramwqp, wtq paramwtq, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    biby.a("FeedSegment.bindCommentLike");
    usz localusz;
    if (paramwqp.a().size() > 0)
    {
      localusz = (usz)paramwtq.a("commentLikeLego");
      if (localusz != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localusz = usz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwqp, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramwtq.a("commentLikeLego", localusz);
      paramFrameLayout.addView(localusz.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localusz.k();
        paramwqp = paramFrameLayout.getLayoutParams();
        paramwqp.height = xsm.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramwqp);
      }
      for (;;)
      {
        biby.a();
        return;
        label132:
        localusz = new usz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwqp, this.jdField_a_of_type_Int);
        break;
        paramwtq = paramFrameLayout.getLayoutParams();
        paramwtq.height = -2;
        paramFrameLayout.setLayoutParams(paramwtq);
        if (localusz.a())
        {
          localusz.a(paramwqp, paramShareGroupItem, null);
          localusz.c(null);
        }
        for (;;)
        {
          localusz.a(this);
          localusz.a(this);
          if ((paramwqp.a().mVideoPullType != 0) || (paramwqp.a().size() <= 1)) {
            break label249;
          }
          localusz.a(true);
          break;
          localusz.l();
        }
        label249:
        localusz.a(false);
      }
    }
  }
  
  private void a(wtq paramwtq, wqp paramwqp, boolean paramBoolean)
  {
    biby.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramwtq.a(2131373774);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(xsm.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((wva)paramwtq.a("general_touch_handler")).a(paramwtq.jdField_b_of_type_Int, paramwtq);
    if ((paramwqp.a() == null) || (paramwqp.a().size() == 0))
    {
      wxe.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramwqp.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      biby.a();
      return;
    }
    Object localObject1;
    if (paramwqp.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (wlc)paramwtq.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new wlc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((wlc)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramwtq.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((wlc)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((wlc)localObject1).a(this.jdField_a_of_type_Wrf);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramwqp.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          wxe.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramwqp.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramwqp.a().size() != 2) {
          break label563;
        }
        j = (xsm.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((wlc)localObject1).a(j, k);
        ((wlc)localObject1).a(xsm.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramwqp.a().type != 6) {
          break label642;
        }
        j = k + xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298356));
        ((wlc)localObject1).a(paramwqp.a(), paramwqp.a());
        if (uqo.a())
        {
          if ((!this.i) || (paramwtq.jdField_b_of_type_Int != 0) || ((!paramwqp.b()) && (!paramwqp.a().isFakeFeedItem()))) {
            break label660;
          }
          ((wlc)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramwqp.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = xsm.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (xsm.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = xsm.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = xsm.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = xsm.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + xsm.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((wlc)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramwqp.a().size() == 1)
      {
        j = xsm.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(xsm.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramwqp.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramwqp.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Wrf);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          uoy.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((uqo.a()) && (this.i) && (paramwtq.jdField_b_of_type_Int == 0) && ((paramwqp.b()) || (paramwqp.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166991));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(alud.a(2131704860));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166991));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramwqp.a().type == 3) && ((paramwqp.a().getOwner() instanceof QQUserUIItem)))
          {
            paramwtq = (QQUserUIItem)paramwqp.a().getOwner();
            if ((paramwtq.isVip) && (!paramwtq.isSubscribe())) {
              wxj.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramwqp.a().type != 6) {
            break;
          }
          wxj.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = uoy.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            wxe.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new wup(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          uoy.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166903));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(xsm.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramwqp.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramwqp.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(xsm.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramwqp.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Uxq != null))
            {
              localStoryNickNameView.setFormat(alud.a(2131704870));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Uxq.jdField_a_of_type_JavaLangString);
            }
            else
            {
              localStoryNickNameView.setUnionId(null);
            }
          }
          localTextView.setVisibility(0);
        }
      }
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      break;
    }
  }
  
  public static boolean a(int paramInt)
  {
    switch (((ulu)vls.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        wxe.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Uxq == null)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      paramString = new URL(paramString);
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      if (URLDrawable.getDrawable(paramString, localURLDrawableOptions).getStatus() == 1) {
        return true;
      }
    }
    catch (MalformedURLException paramString)
    {
      return false;
    }
    return false;
  }
  
  public static String[] a(ShareGroupFeedItem paramShareGroupFeedItem, List<StoryVideoItem> paramList)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramShareGroupFeedItem.des)) && (paramShareGroupFeedItem.mVideoPullType == 0))
    {
      localObject = paramShareGroupFeedItem.des;
      if (paramShareGroupFeedItem.todayJoinMemberCount > 1) {
        paramList = alud.a(2131704871);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = alud.a(2131704858);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + alud.a(2131704863);
        paramList = str1;
      }
    }
  }
  
  private void b(List<wqn> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((uvt)uwa.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((wqn)paramList.next()).d();
        if (localList != null)
        {
          int m = localList.size();
          int j = paramInt;
          while ((j < paramInt + k) && (j < m))
          {
            localArrayList.add(((StoryVideoItem)localList.get(j)).mVid);
            j += 1;
          }
        }
      }
      wxe.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new wuq(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Wpr.e();
    wxj.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private wtq c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561479, paramViewGroup, false));
    paramViewGroup.a(2131378878).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Wrj);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131373764);
    wva localwva = new wva(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localwva);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localwva);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localwva);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localwva);
    paramViewGroup.a("general_touch_handler", localwva);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private wtq d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561585, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131373755);
    paramViewGroup.a(2131373756).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373754).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373885).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373880).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Wrj);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131373764);
    wva localwva = new wva(this);
    paramViewGroup.a("general_touch_handler", localwva);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localwva);
    paramViewGroup.a("type", "TagView");
    return paramViewGroup;
  }
  
  private void d(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString.jdField_b_of_type_Int, paramString, a());
    }
  }
  
  private int e()
  {
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long < 100L) && (this.jdField_f_of_type_Int != -1) && (this.jdField_f_of_type_Int != 0))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return this.jdField_f_of_type_Int;
    }
    int k = xsm.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      wxe.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
      if (m != this.jdField_d_of_type_Int) {
        break label230;
      }
      if ((j <= k) && (this.jdField_e_of_type_Int <= k)) {
        break;
      }
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 0;
    }
    if (j > this.jdField_e_of_type_Int)
    {
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 2;
    }
    if (j < this.jdField_e_of_type_Int)
    {
      this.jdField_e_of_type_Int = j;
      this.jdField_d_of_type_Int = m;
      return 1;
      label230:
      if (m > this.jdField_d_of_type_Int)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 1;
      }
      if (m < this.jdField_d_of_type_Int)
      {
        this.jdField_e_of_type_Int = j;
        this.jdField_d_of_type_Int = m;
        return 2;
      }
    }
    this.jdField_e_of_type_Int = j;
    this.jdField_d_of_type_Int = m;
    return 0;
  }
  
  private wtq e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561407, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373755);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373718).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373726).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Wrj);
    paramViewGroup.a("type", "BannerView");
    return paramViewGroup;
  }
  
  private void e(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        b(e());
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b() != 1));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
  }
  
  private void f(int paramInt)
  {
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
    wqn localwqn = (wqn)this.jdField_a_of_type_Wpr.a().get(paramInt);
    localbhuf.a(alud.a(2131704855), 5);
    localbhuf.c(2131690648);
    localbhuf.a(new wue(this, localbhuf, paramInt, localwqn));
    localbhuf.a(new wuf(this, paramInt));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
    a(localwqn, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!xrn.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(vls.a(), 1, alud.a(2131704869), 0).a();
      return;
    }
    Object localObject = (wqn)this.jdField_a_of_type_Wpr.a().remove(paramInt);
    if (localObject == null)
    {
      xqq.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((wqn)localObject, "hide_done");
    String str = ((wqn)localObject).a().getOwner().getUnionId();
    long l;
    switch (((wqn)localObject).a().type)
    {
    case 4: 
    default: 
      xqq.a("feed not allow unLike operation type=" + ((wqn)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((wqn)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      xre.a(str, paramInt, l);
      localObject = ((wqn)localObject).a().feedId;
      Bosses.get().postJob(new wuk(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((wqn)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((wqn)localObject).a()).recommendId;
      paramInt = 10;
    }
  }
  
  private void h(int paramInt)
  {
    if (this.g) {
      d(paramInt);
    }
    while (a(paramInt) != null) {
      return;
    }
    d(paramInt);
    this.g = true;
  }
  
  private void n()
  {
    if (uqo.a()) {}
    do
    {
      return;
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alud.a(2131704856), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alud.a(2131704864), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alud.a(2131704857), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (wvq)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((wvq)localObject).a(false);
      }
      a().setSelection(0);
      return;
      wxe.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void W_()
  {
    this.jdField_a_of_type_Wqn = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Wpr.a()).iterator();
      while (localIterator.hasNext())
      {
        wqn localwqn = (wqn)localIterator.next();
        if (((localwqn instanceof wqm)) && (localwqn.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localwqn.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Wqn == null))
        {
          this.jdField_a_of_type_Wqn = localwqn;
          wxe.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Wqn.toString());
          return;
        }
      }
      wxe.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void Y_()
  {
    super.Y_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Wrf.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Wrf.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Wpr.c();
    this.jdField_a_of_type_Wpr.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Wpr.a().size();
  }
  
  protected int a(int paramInt)
  {
    wqn localwqn = (wqn)this.jdField_a_of_type_Wpr.a().get(paramInt);
    if (localwqn.a().type == 1) {
      return 0;
    }
    if (localwqn.a().type == 3) {
      return 0;
    }
    if (localwqn.a().type == 2) {
      return 0;
    }
    if (localwqn.a().type == 5) {
      return 1;
    }
    if (localwqn.a().type == 6) {
      return 2;
    }
    if (localwqn.a().type == 7) {
      return 3;
    }
    return super.a(paramInt);
  }
  
  public int a(View paramView)
  {
    if (paramView.getScrollY() > 0) {
      return paramView.getScrollY();
    }
    paramView = (ViewGroup)paramView.getParent();
    while (paramView != null)
    {
      if (paramView.getScrollY() > 0) {
        return paramView.getScrollY();
      }
      try
      {
        paramView = (ViewGroup)paramView.getParent();
      }
      catch (Exception paramView)
      {
        return 0;
      }
    }
    return 0;
  }
  
  public View a()
  {
    int j = 0;
    while (j < this.jdField_a_of_type_Wpr.a().size())
    {
      localObject1 = (wqn)this.jdField_a_of_type_Wpr.a().get(j);
      if ((((wqn)localObject1).a().type != 1) && (((wqn)localObject1).a().type != 2))
      {
        j += 1;
      }
      else
      {
        localObject1 = a(j);
        if (localObject1 != null) {
          break label76;
        }
      }
    }
    for (;;)
    {
      return null;
      label76:
      localObject2 = (VideoListLayout)((wtq)localObject1).a(2131373774);
      if (localObject2 != null) {
        break;
      }
      wxe.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131373772);
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alud.a(2131704843), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    wqn localwqn = (wqn)this.jdField_a_of_type_Wpr.a().get(paramInt);
    paramwtq.a("feed_id", localwqn.a().feedId);
    View localView = paramwtq.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localwqn.jdField_b_of_type_Boolean = true;
      d(paramwtq);
      paramwtq = new ArrayList();
      paramwtq.add(localwqn);
      b(paramwtq, 0);
      wxj.b("story_home_dev", "feed_exp", localwqn.a().type, localwqn.d().size(), new String[] { localwqn.a().feedId });
      return localView;
      if (localwqn.a().type == 1)
      {
        localView = a(paramInt, paramwtq, paramViewGroup, (wpg)localwqn);
      }
      else if (localwqn.a().type == 2)
      {
        localView = a(paramInt, paramwtq, paramViewGroup, (wqm)localwqn);
      }
      else if (localwqn.a().type == 3)
      {
        localView = a(paramInt, paramwtq, paramViewGroup, (wph)localwqn);
        continue;
        localView = a(paramInt, paramwtq, (woh)localwqn);
        continue;
        localView = a(paramInt, paramwtq, paramViewGroup, (wqo)localwqn);
        continue;
        localView = a(paramInt, paramwtq, paramViewGroup, (wqj)localwqn);
      }
    }
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup, wpg paramwpg)
  {
    wxe.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramwtq.a(2131373741);
    FrameLayout localFrameLayout = (FrameLayout)paramwtq.a(2131373745);
    a(paramwpg, paramwtq);
    a(paramInt, paramwtq, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwtq, paramwpg, paramwpg.a().getOwner());
    a(paramwtq, paramwpg, true);
    a(paramInt, paramwtq);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166988);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwtq.a("feed_id", paramwpg.a().feedId);
    a(paramwpg, paramwtq);
    a(paramwpg, paramwtq, localFrameLayout, null);
    return paramwtq.a();
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup, wqm paramwqm)
  {
    wxe.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramwtq.a(2131373741);
    FrameLayout localFrameLayout = (FrameLayout)paramwtq.a(2131373745);
    a(paramwqm, paramwtq);
    a(paramInt, paramwtq, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwtq, paramwqm, ((ShareGroupFeedItem)paramwqm.a()).getOwner());
    a(paramwtq, paramwqm, true);
    a(paramwqm, paramwtq);
    a(paramInt, paramwtq);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166988);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwtq.a("feed_id", ((ShareGroupFeedItem)paramwqm.a()).feedId);
    paramwtq.a("group_id", ((ShareGroupFeedItem)paramwqm.a()).getOwner().shareGroupId);
    a(paramwqm, paramwtq, localFrameLayout, ((ShareGroupFeedItem)paramwqm.a()).getOwner());
    paramwqm.jdField_b_of_type_Boolean = true;
    return paramwtq.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected wpr a(boolean paramBoolean)
  {
    return new wpr(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    biby.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      biby.a();
      return paramViewGroup;
      paramViewGroup = b(paramInt, paramViewGroup);
      continue;
      paramViewGroup = e(paramInt, paramViewGroup);
      continue;
      paramViewGroup = d(paramInt, paramViewGroup);
      continue;
      paramViewGroup = c(paramInt, paramViewGroup);
    }
  }
  
  protected wtq a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wpr.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((wqn)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      wtq localwtq = a(j);
      if ((localwtq != null) && (paramString.equals(localwtq.a("feed_id")))) {
        return localwtq;
      }
      if (localwtq != null)
      {
        localObject = (wqn)((List)localObject).get(j);
        xqq.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localwtq.a("feed_id") + " feed info=" + localObject, new Object[0]);
      }
      return null;
      j = -1;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (wtq)localIterator.next();
        if (localObject != null)
        {
          localObject = (usz)((wtq)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((usz)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, wtq paramwtq)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373769);
    TextView localTextView = (TextView)paramwtq.a(2131373770);
    ImageView localImageView = (ImageView)paramwtq.a(2131373767);
    if (localRelativeLayout == null) {
      return;
    }
    if (uqo.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (wqn)this.jdField_a_of_type_Wpr.a().get(paramInt);
    switch (((wqn)localObject).a().type)
    {
    case 4: 
    default: 
      return;
    case 1: 
    case 2: 
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    case 5: 
      localObject = (BannerFeedItem)((wqn)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        wxe.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = alud.a(2131704845);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramwtq);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((wqn)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((wqn)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        wxe.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = alud.a(2131704851);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramwtq);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((wqn)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      wxe.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = alud.a(2131704842);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramwtq);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, wtq paramwtq, wqp paramwqp, QQUserUIItem paramQQUserUIItem)
  {
    biby.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramwtq.a(2131373755);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(vls.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845986));
      biby.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(xsm.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bdhj.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramwtq = "";
      if (paramwqp.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramwtq);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramwqp.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramwtq = localQQStoryOwnerInfoView.a();
      paramwtq.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramwqp.jdField_b_of_type_Boolean) {
        paramwtq.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      biby.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramwqp.a().type == 3)
      {
        paramwtq = (GeneralRecommendFeedItem)paramwqp.a();
        if (!TextUtils.isEmpty(paramwtq.blurb))
        {
          paramwtq = paramwtq.blurb;
          break label152;
        }
        paramwtq = a(paramwqp.a());
        break label152;
      }
      paramwtq = a(paramwqp.a());
      break label152;
      label296:
      if (paramwqp.a().type == 3) {
        if (wmz.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, alud.a(2131704859), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, wtq paramwtq, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373748);
    biby.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramwtq.a(2131373747);
    Object localObject1 = (ImageView)paramwtq.a(2131373749);
    paramwtq = (ImageView)paramwtq.a(2131373750);
    Object localObject2 = this.jdField_a_of_type_Wpr.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      biby.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846064);
      paramwtq.setImageResource(2130846066);
      if (paramInt != 0) {
        break label165;
      }
      paramwtq = xsm.a(xsm.a(((wqn)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramwtq);
    }
    for (;;)
    {
      biby.a();
      return;
      ((ImageView)localObject1).setImageResource(2130846063);
      paramwtq.setImageResource(2130846065);
      break;
      label165:
      paramwtq = (wqn)((List)localObject2).get(paramInt - 1);
      localObject2 = (wqn)((List)localObject2).get(paramInt);
      localObject1 = xsm.a(paramwtq.a().date);
      localObject2 = xsm.a(((wqn)localObject2).a().date);
      if (((paramwtq instanceof wqj)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramwtq = xsm.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramwtq);
      }
      else
      {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void a(long paramLong, String paramString, CommentLikeFeedItem paramCommentLikeFeedItem)
  {
    int j;
    if (this.jdField_a_of_type_Int == 10)
    {
      j = 74;
      if (paramCommentLikeFeedItem.getOwner().getRelationType() == 2) {}
      paramString = null;
      if (this.jdField_a_of_type_Int != 10) {
        break label95;
      }
      paramString = new HomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = new OpenPlayerBuilder(paramString, j);
        paramString.a(c());
        vod.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
      }
      return;
      j = 76;
      break;
      label95:
      if (this.jdField_a_of_type_Int == 11) {
        paramString = new TroopAssistantHomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
      } else if (this.jdField_a_of_type_Int == 12) {
        paramString = new ProfileFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
      }
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, QQUserUIItem paramQQUserUIItem, int paramInt)
  {
    int j = 1;
    int k = paramQQUserUIItem.isSubscribe;
    if (paramQQUserUIItem.isSubscribe())
    {
      paramInt = 0;
      paramQQUserUIItem.isSubscribe = paramInt;
      d(paramVideoListFeedItem.feedId);
      paramView = (ult)vls.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      wxj.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (xsm.b()) {
      return;
    }
    int j;
    if (this.jdField_a_of_type_Int == 10)
    {
      j = 74;
      if (!(paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
        break label177;
      }
      paramVideoListFeedItem = (HotRecommendFeedItem)paramVideoListFeedItem;
      paramVideoListFeedItem = new OpenPlayerBuilder(new HotRecommendFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mAttachedFeedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), j);
      paramVideoListFeedItem.a(false).b(true);
      paramVideoListFeedItem.a(c());
      if (!(paramView instanceof QQStoryAutoPlayView)) {
        break label159;
      }
      vod.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      wxj.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      vod.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
    }
    label177:
    Object localObject = null;
    String str;
    if (this.jdField_a_of_type_Int == 10)
    {
      str = paramVideoListFeedItem.feedId;
      if (!(paramVideoListFeedItem instanceof TagFeedItem)) {
        break label461;
      }
    }
    label303:
    label454:
    label461:
    for (localObject = paramStoryVideoItem.mAttachedFeedId;; localObject = str)
    {
      localObject = new HomeFeedPlayInfo(str, (String)localObject, paramStoryVideoItem.mVid, false);
      if (localObject != null)
      {
        localObject = new OpenPlayerBuilder((Serializable)localObject, j);
        ((OpenPlayerBuilder)localObject).a(c());
        localObject = ((OpenPlayerBuilder)localObject).a();
        if (74 == j) {
          ((OpenPlayerBuilder.Data)localObject).mUIStyle.bottomWidgetShowFlag = 3;
        }
        if ((paramView instanceof QQStoryAutoPlayView)) {
          vod.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = wxj.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        wxj.a("home_page", "clk_card", wxj.a(paramVideoListFeedItem), wlc.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), wxj.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
        return;
        if (this.jdField_a_of_type_Int == 11)
        {
          localObject = new TroopAssistantHomeFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
          break;
        }
        if (this.jdField_a_of_type_Int != 12) {
          break;
        }
        localObject = new ProfileFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
        break;
        vod.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    wxe.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Wpr.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localwqn = (wqn)localIterator.next();
      if (paramString1.equals(localwqn.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localwqn, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      wqn localwqn;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(ust paramust, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramust.c != null) && (paramust.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Wtr.a();
      paramView.setFeedItemData(paramust.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramust, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(ust paramust, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramust.c != null) && (paramust.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Wtr.a();
      paramViewGroup.setFeedItemData(paramust.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramust, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(vej paramvej)
  {
    if ((((Integer)((uvt)uwa.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramvej.jdField_a_of_type_JavaUtilList != null))
    {
      voi.a();
      paramvej = new ArrayList(paramvej.jdField_a_of_type_JavaUtilList).iterator();
      while (paramvej.hasNext()) {
        voi.a(((StoryVideoItem)paramvej.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(wpg paramwpg, wtq paramwtq)
  {
    paramwpg = (VideoListLayout)paramwtq.a(2131373774);
    if (paramwpg != null)
    {
      paramwpg = paramwpg.a();
      if (paramwpg != null) {
        paramwpg.setVisibility(8);
      }
    }
  }
  
  public void a(wpn paramwpn)
  {
    boolean bool1 = true;
    wxe.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramwpn == null) {
      c(false);
    }
    do
    {
      return;
      if (paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        xqq.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramwpn, new Object[0]);
        c(false);
        return;
      }
      wxe.d("Q.qqstory.home:FeedSegment", paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
        break;
      }
      c(false);
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString != null))
      {
        a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false);
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      a(paramwpn.jdField_b_of_type_JavaUtilList, 0);
    } while (paramwpn.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramwpn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramwpn.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(wqm paramwqm, wtq paramwtq)
  {
    paramwqm = (VideoListLayout)paramwtq.a(2131373774);
    if (paramwqm != null)
    {
      paramwqm = paramwqm.a();
      if (paramwqm != null) {
        paramwqm.setVisibility(8);
      }
    }
  }
  
  public void a(wqp paramwqp)
  {
    wxe.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramwqp);
    if ((paramwqp == null) || (paramwqp.a() == null) || (paramwqp.a().feedId == null))
    {
      wxe.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramwqp.a().feedId);
  }
  
  protected void a(wtq paramwtq)
  {
    Object localObject = (VideoListLayout)paramwtq.a(2131373774);
    ((VideoListLayout)localObject).a().setOnClickListener(paramwtq);
    ((VideoListLayout)localObject).a().setOnClickListener(paramwtq);
    localObject = ((VideoListLayout)localObject).a();
    wva localwva = new wva(this);
    paramwtq.a("general_touch_handler", localwva);
    paramwtq.a("general_adapter", null);
    paramwtq.a(this.jdField_b_of_type_Wrj);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localwva);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localwva);
    paramwtq.a("type", "GeneralView");
  }
  
  protected void a(wtq paramwtq, wqo paramwqo)
  {
    TextView localTextView1 = (TextView)paramwtq.a(2131373883);
    TextView localTextView2 = (TextView)paramwtq.a(2131373882);
    TextView localTextView3 = (TextView)paramwtq.a(2131373885);
    xoe localxoe = ((TagFeedItem)paramwqo.a()).tagItem;
    paramwtq = (TextView)paramwtq.a(2131373880);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166402));
      paramwtq.setBackgroundResource(2130846090);
    }
    if (localxoe != null)
    {
      localTextView1.setText(localxoe.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramwqo.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramwqo.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramwqo.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramwqo.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(wux paramwux)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Wpr.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    wxe.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    wxe.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Wpr.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Woy.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected wtq b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561452, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373755);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    biby.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Wtr.a()) || (this.jdField_a_of_type_Int != 10))
    {
      biby.a();
      wxe.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Wtr.a());
      return;
    }
    wxe.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label536:
    label553:
    label557:
    for (;;)
    {
      Object localObject;
      QQStoryAutoPlayView localQQStoryAutoPlayView;
      if (localIterator.hasNext())
      {
        localObject = (VideoListLayout)((wtq)localIterator.next()).a(2131373774);
        if (localObject == null) {
          continue;
        }
        localQQStoryAutoPlayView = ((VideoListLayout)localObject).a();
        localObject = ((VideoListLayout)localObject).a();
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.getVisibility() != 0)) {}
      }
      for (;;)
      {
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.a() == null)) {
          break label557;
        }
        wxe.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131373772);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = wrl.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wrl.a(localQQStoryAutoPlayView);
          label326:
          if ((a(localQQStoryAutoPlayView)) && (k >= j)) {
            if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != localQQStoryAutoPlayView)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
            }
          }
          break;
        }
        for (;;)
        {
          wxe.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = wrl.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wrl.c(localQQStoryAutoPlayView);
          break label326;
          k = wrl.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wrl.b(localQQStoryAutoPlayView);
          break label326;
          wxe.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          wxe.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
          if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() == 0))
          {
            if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a()) {
              break label536;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.c();
          }
        }
        for (;;)
        {
          biby.a();
          return;
          wxe.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Wpr.a());
        }
        localQQStoryAutoPlayView = null;
      }
    }
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
      a((HotRecommendFeedItem)paramVideoListFeedItem, paramStoryVideoItem);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    wxe.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(wpn paramwpn)
  {
    c(true);
  }
  
  protected void b(wtq paramwtq)
  {
    ((VideoListLayout)paramwtq.a(2131373774)).a().setVisibility(8);
  }
  
  public int c()
  {
    int j = 20002;
    if (this.jdField_a_of_type_Int == 11) {
      j = 30000;
    }
    do
    {
      return j;
      if (this.jdField_a_of_type_Int == 12) {
        return 20004;
      }
    } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity));
    return 20002;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Wpr.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Wrf == null) {
      return;
    }
    this.jdField_a_of_type_Wrf.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (uqo.a()) {
      return;
    }
    this.i = true;
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null) {
      ((View)localObject).getGlobalVisibleRect(localRect);
    }
    for (;;)
    {
      wrk.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (wvq)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      wxe.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(wtq paramwtq)
  {
    biby.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramwtq);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramwtq.a(2131373774);
    if (localVideoListLayout == null)
    {
      biby.a();
      return;
    }
    paramwtq = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramwtq != null) && (paramwtq.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramwtq != null) && (paramwtq.a() != null)) {
        wxe.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramwtq.a().getThumbUrl());
      }
      if (paramwtq != null) {
        paramwtq.a();
      }
      biby.a();
      return;
      paramwtq = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramwtq = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramwtq = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramwtq = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131373772);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wuy);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wuu);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wut);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wuz);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wur);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Wuw);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Wrf.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      usz localusz = (usz)((wtq)localIterator.next()).a("commentLikeLego");
      if (localusz != null) {
        localusz.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Wpr.b();
    utv.a();
  }
  
  public void d(wtq paramwtq)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramwtq);
  }
  
  protected void e()
  {
    super.e();
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    b(0);
    AbstractGifImage.resumeAll();
  }
  
  public void e_(boolean paramBoolean)
  {
    super.e_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      h();
    }
  }
  
  public void f()
  {
    wxe.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int f_()
  {
    return 4;
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new wuc(this));
    SegmentList localSegmentList = a();
    String str = a();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int[] arrayOfInt1;
    int j;
    Object localObject;
    String str;
    int[] arrayOfInt2;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      paramMessage = (wpn)paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()))
      {
        c(false);
        return true;
      }
      b(paramMessage);
      return true;
    case 2: 
      c(true);
      return true;
    case 11: 
      arrayOfInt1 = new int[2];
      j = xsm.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Wtr.a();
      ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
      str = (String)paramMessage.obj;
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, str), 50L);
        return true;
      }
      arrayOfInt2 = new int[2];
      a().getLocationOnScreen(arrayOfInt2);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessage = (wtq)localIterator.next();
      } while (!str.equals((String)paramMessage.a("feed_id")));
    }
    for (;;)
    {
      if (paramMessage != null)
      {
        j = paramMessage.jdField_c_of_type_Int;
        int k = paramMessage.a().getBottom();
        int m = paramMessage.a().getTop();
        int n = arrayOfInt2[1];
        ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
        a().setSelectionFromTop(j, arrayOfInt1[1] - (k - m + n));
        return true;
      }
      xqq.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = xsm.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Wtr.a().getLocationOnScreen(arrayOfInt1);
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramMessage), 50L);
        return true;
      }
      localObject = new int[2];
      paramMessage.getLocationOnScreen((int[])localObject);
      j = localObject[1];
      j = paramMessage.getBottom() - paramMessage.getTop() + j - arrayOfInt1[1];
      a().smoothScrollBy(j, j * 2 / 3);
      return true;
      if (QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_Boolean)
      {
        wxe.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
        paramMessage = (Rect)paramMessage.obj;
        ThreadManager.getSubThreadHandler().post(new FeedSegment.9(this, paramMessage));
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, paramMessage.obj), 50L);
      return true;
      paramMessage = null;
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (wtq)localIterator.next();
      wxe.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (usz)((wtq)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((usz)localObject).c();
      }
    }
  }
  
  public void i_(int paramInt)
  {
    e(paramInt);
  }
  
  public boolean isValidate()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void k()
  {
    b(0);
    wxe.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((uvt)uwa.a(10)).b("mainHallConfig", "");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    for (;;)
    {
      try
      {
        str1 = new JSONObject(str1).optString("url");
        if (!TextUtils.isEmpty(str1)) {
          break;
        }
        wxe.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        wxe.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wub
 * JD-Core Version:    0.7.0.1
 */