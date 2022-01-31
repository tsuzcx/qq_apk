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

public class wps
  extends xrg<wle>
  implements Handler.Callback, IEventReceiver, uog, uov, wlr, wmz, wpr
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new apgg(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new apgg(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new wpu(this);
  public String a;
  private List<wph> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private usd jdField_a_of_type_Usd;
  private wkp jdField_a_of_type_Wkp;
  protected wli a;
  private wme jdField_a_of_type_Wme;
  protected wmw a;
  wna jdField_a_of_type_Wna = new wqc(this);
  private wpi jdField_a_of_type_Wpi;
  private wqi jdField_a_of_type_Wqi;
  private wqk jdField_a_of_type_Wqk;
  private wql jdField_a_of_type_Wql;
  private wqn jdField_a_of_type_Wqn;
  private wqp jdField_a_of_type_Wqp;
  private wqq jdField_a_of_type_Wqq;
  private final int jdField_b_of_type_Int;
  public String b;
  wna jdField_b_of_type_Wna = new wqd(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  wna jdField_c_of_type_Wna = new wqe(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  wna jdField_d_of_type_Wna = new wqf(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public wps(Context paramContext, Activity paramActivity, int paramInt, wpi paramwpi, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Wpi = paramwpi;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Wli = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Wqp = new wqp(this);
    this.jdField_a_of_type_Wql = new wql(this);
    this.jdField_a_of_type_Wqk = new wqk(this);
    this.jdField_a_of_type_Wqq = new wqq(this);
    this.jdField_a_of_type_Wqi = new wqi(this);
    this.jdField_a_of_type_Wqn = new wqn(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wqp);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wql);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wqk);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wqq);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wqi);
    uht.a().registerSubscriber(this.jdField_a_of_type_Wqn);
    this.jdField_a_of_type_Wmw = new wmw(Looper.myLooper());
    this.jdField_a_of_type_Wli.a();
    this.jdField_a_of_type_Usd = ((usd)urr.a(2));
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Wmw.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298345);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298356);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Wmw.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Wmw.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bdee.h(paramContext)) {
      return 1;
    }
    if (bdee.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, wph paramwph, ViewGroup paramViewGroup, wky paramwky)
  {
    paramViewGroup = (ImageView)paramwph.a(2131373690);
    FrameLayout localFrameLayout = (FrameLayout)paramwph.a(2131373694);
    b(paramwph);
    a(paramInt, paramwph, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwph, paramwky, paramwky.a().getOwner());
    a(paramwph, paramwky, true);
    a(paramwky, paramwph);
    a(paramInt, paramwph);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwph.a("feed_id", paramwky.a().feedId);
    a(paramwky, paramwph, localFrameLayout, null);
    if (!paramwky.jdField_b_of_type_Boolean) {
      wta.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramwky.a().getOwner().getUnionId(), paramwky.a().feedId });
    }
    paramViewGroup = paramwky.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      wta.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramwph.a();
  }
  
  private View a(int paramInt, wph paramwph, ViewGroup paramViewGroup, wma paramwma)
  {
    paramViewGroup = (VideoListLayout)paramwph.a(2131373723);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(xod.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((wqr)paramwph.a("general_touch_handler")).a(paramwph.jdField_b_of_type_Int, paramwph);
    if ((paramwma.a() == null) || (paramwma.a().size() == 0))
    {
      wsv.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramwma.a()).feedId);
      paramwph.a.setVisibility(8);
      return paramwph.a();
    }
    paramwph.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (wpp)paramwph.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new wpp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramwph.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Wmw);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramwma.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        wsv.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramwma.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramwma.a().size();
        paramViewGroup.a(paramwma.a(), paramwma.a());
        if (((HotRecommendFeedItem)paramwma.a()).mIsVideoEnd) {
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
        paramViewGroup = paramwph.a(2131378823);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((urk)urr.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        wta.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, wph paramwph, ViewGroup paramViewGroup, wmf paramwmf)
  {
    paramViewGroup = (ImageView)paramwph.a(2131373690);
    a(paramInt, paramwph, this.jdField_d_of_type_Boolean);
    a(paramwph, paramwmf);
    a(paramInt, paramwph);
    a(paramwph, paramwmf, true);
    a(null, paramwph);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    wta.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramwmf.a()).feedId });
    return paramwph.a();
  }
  
  private View a(int paramInt, wph paramwph, wjy paramwjy)
  {
    Object localObject = (QQStoryOwnerInfoView)paramwph.a(2131373704);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramwph.a(2131373675);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramwph.a(2131373667);
    FrameLayout localFrameLayout = (FrameLayout)paramwph.a(2131373669);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramwjy.a();
    a(paramInt, paramwph, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, alpo.a(2131704834), true);
    if (wiq.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      xod.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bdda.a(1), "QQStory_main");
      a(paramInt, paramwph);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramwjy.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext) - xod.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (uoq)paramwph.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new uoq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwjy, this.jdField_a_of_type_Int);
      ((uoq)localObject).a(paramwjy);
      ((uoq)localObject).l();
      paramwph.a("commentLikeLego", localObject);
      localFrameLayout.addView(((uoq)localObject).b);
    }
    for (;;)
    {
      ((uoq)localObject).a(this);
      ((uoq)localObject).a(this);
      ((uoq)localObject).a(false);
      if (!paramwjy.jdField_b_of_type_Boolean) {
        wta.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramwjy.a()).getOwner().getUnionId(), ((BannerFeedItem)paramwjy.a()).feedId });
      }
      return paramwph.a();
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
      ((uoq)localObject).a(paramwjy, null, paramwjy);
      ((uoq)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      wsv.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = xod.a() / 3600;
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
        return wnc.a(j, true);
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
  
  private void a(int paramInt, wme paramwme, String paramString, boolean paramBoolean)
  {
    if (!(paramwme instanceof wmg)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        wsv.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramwme, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((wph)localObject1).a(2131373723);
        List localList = ((wmg)paramwme).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            wsv.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= xod.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramwme.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (wgt)((wph)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((wgt)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            wsv.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramwme.a().feedId, Integer.valueOf(j));
            wsv.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, wph paramwph, wmg paramwmg, ShareGroupItem paramShareGroupItem)
  {
    bhxr.a("FeedSegment.bindFeedShareGroupInfo");
    paramwph = (QQStoryOwnerInfoView)paramwph.a(2131373704);
    if (paramShareGroupItem == null)
    {
      paramwph.setSubTitle(null);
      paramwph.setBadge(null);
      paramwph.setQIMIcon(null);
      paramwph.setSubTitleSuffix(null);
      paramwph.setButtonTxt(null);
      paramwph.setName(vhj.jdField_b_of_type_JavaLangString);
      paramwph.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845913));
      bhxr.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bdda.a();
      paramwph.setAvatar(bcxb.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramwph.setName(paramShareGroupItem.getName());
      if (paramwmg.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((wmd)paramwmg).a(), paramwmg.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramwph.setSubTitle((String)localObject1);
        paramwph.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramwph.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846278);
      label199:
      if (paramwmg.a().type == 2)
      {
        if (!paramwmg.a()) {
          break label328;
        }
        a(paramwph, alpo.a(2131704841), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramwph = paramwph.a();
      paramwph.a(null);
      paramwph.setVisibility(8);
      bhxr.a();
      return;
      paramwph.setAvatar(((vzk)urr.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846280);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846279);
      break label199;
      label328:
      a(paramwph, null, false);
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
    bhxr.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        wsv.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = wss.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        wsv.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!wnc.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = wss.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      bhxr.a();
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
      wsv.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = xoa.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = xoa.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    localbhpy.a(alpo.a(2131704836), 5);
    QQUserUIItem localQQUserUIItem = ((usd)urr.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = alpo.a(2131704837);; str = alpo.a(2131704829))
    {
      localbhpy.a(str, 5);
      localbhpy.a(alpo.a(2131704854), 5);
      localbhpy.c(2131690648);
      localbhpy.a(new wpx(this, localbhpy, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbhpy.a(new wqa(this));
      if (!localbhpy.isShowing()) {
        localbhpy.show();
      }
      wta.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846089);
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
        wnb.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      wnb.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      xod.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = xod.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = xod.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166901));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846017);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166395));
        localButton.setBackgroundResource(2130846017);
      }
      j = xod.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      xod.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846016);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166382));
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
    paramString.setDecodeHandler(xod.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<wme> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((urk)urr.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((wme)paramList.next()).d();
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
      wsv.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Wmw.a(localArrayList);
      return;
    }
  }
  
  private void a(wme paramwme)
  {
    if ((paramwme == null) || (paramwme.a() == null) || (paramwme.a().getOwner() == null)) {
      xmh.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramwme instanceof wkx))
      {
        paramwme = ((wkx)paramwme).a().getOwner();
        ume.a(this.jdField_a_of_type_AndroidContentContext, 4, paramwme.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramwme instanceof wmd))
      {
        paramwme = (ShareGroupFeedItem)((wmd)paramwme).a();
        localObject = paramwme.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          wsv.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          xmh.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramwme.getOwner().getRelationType() == 2)
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
      if ((paramwme instanceof wky))
      {
        paramwme = ((wky)paramwme).a();
        localObject = paramwme.getOwner();
        if (paramwme.getOwner().getRelationType() == 2)
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
        ume.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramwme instanceof wmf))
      {
        paramwme = (TagFeedItem)((wmf)paramwme).a();
        via.a(this.jdField_a_of_type_AndroidAppActivity, paramwme.tagItem.a);
        return;
      }
    } while (!(paramwme instanceof wma));
    label289:
    l();
    wta.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(wme paramwme, ShareGroupItem paramShareGroupItem)
  {
    if (vyw.a(paramShareGroupItem))
    {
      if (paramwme.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        wta.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, alpo.a(2131704853), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new vyx((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    wta.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(wme paramwme, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramwme.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      wta.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramwme.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(wmg paramwmg, wph paramwph) {}
  
  private void a(wmg paramwmg, wph paramwph, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    bhxr.a("FeedSegment.bindCommentLike");
    uoq localuoq;
    if (paramwmg.a().size() > 0)
    {
      localuoq = (uoq)paramwph.a("commentLikeLego");
      if (localuoq != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localuoq = uoq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwmg, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramwph.a("commentLikeLego", localuoq);
      paramFrameLayout.addView(localuoq.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localuoq.k();
        paramwmg = paramFrameLayout.getLayoutParams();
        paramwmg.height = xod.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramwmg);
      }
      for (;;)
      {
        bhxr.a();
        return;
        label132:
        localuoq = new uoq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramwmg, this.jdField_a_of_type_Int);
        break;
        paramwph = paramFrameLayout.getLayoutParams();
        paramwph.height = -2;
        paramFrameLayout.setLayoutParams(paramwph);
        if (localuoq.a())
        {
          localuoq.a(paramwmg, paramShareGroupItem, null);
          localuoq.c(null);
        }
        for (;;)
        {
          localuoq.a(this);
          localuoq.a(this);
          if ((paramwmg.a().mVideoPullType != 0) || (paramwmg.a().size() <= 1)) {
            break label249;
          }
          localuoq.a(true);
          break;
          localuoq.l();
        }
        label249:
        localuoq.a(false);
      }
    }
  }
  
  private void a(wph paramwph, wmg paramwmg, boolean paramBoolean)
  {
    bhxr.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramwph.a(2131373723);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(xod.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((wqr)paramwph.a("general_touch_handler")).a(paramwph.jdField_b_of_type_Int, paramwph);
    if ((paramwmg.a() == null) || (paramwmg.a().size() == 0))
    {
      wsv.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramwmg.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      bhxr.a();
      return;
    }
    Object localObject1;
    if (paramwmg.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (wgt)paramwph.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new wgt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((wgt)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramwph.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((wgt)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((wgt)localObject1).a(this.jdField_a_of_type_Wmw);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramwmg.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          wsv.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramwmg.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramwmg.a().size() != 2) {
          break label563;
        }
        j = (xod.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((wgt)localObject1).a(j, k);
        ((wgt)localObject1).a(xod.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramwmg.a().type != 6) {
          break label642;
        }
        j = k + xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298356));
        ((wgt)localObject1).a(paramwmg.a(), paramwmg.a());
        if (umf.a())
        {
          if ((!this.i) || (paramwph.jdField_b_of_type_Int != 0) || ((!paramwmg.b()) && (!paramwmg.a().isFakeFeedItem()))) {
            break label660;
          }
          ((wgt)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramwmg.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = xod.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (xod.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = xod.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = xod.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = xod.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + xod.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((wgt)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramwmg.a().size() == 1)
      {
        j = xod.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(xod.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramwmg.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramwmg.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Wmw);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          ukp.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((umf.a()) && (this.i) && (paramwph.jdField_b_of_type_Int == 0) && ((paramwmg.b()) || (paramwmg.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166989));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(alpo.a(2131704848));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166989));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramwmg.a().type == 3) && ((paramwmg.a().getOwner() instanceof QQUserUIItem)))
          {
            paramwph = (QQUserUIItem)paramwmg.a().getOwner();
            if ((paramwph.isVip) && (!paramwph.isSubscribe())) {
              wta.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramwmg.a().type != 6) {
            break;
          }
          wta.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = ukp.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            wsv.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new wqg(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          ukp.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166901));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(xod.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramwmg.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramwmg.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(xod.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramwmg.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Uth != null))
            {
              localStoryNickNameView.setFormat(alpo.a(2131704858));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Uth.jdField_a_of_type_JavaLangString);
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
    switch (((uhl)vhj.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        wsv.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Uth == null)) {
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
        paramList = alpo.a(2131704859);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = alpo.a(2131704846);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + alpo.a(2131704851);
        paramList = str1;
      }
    }
  }
  
  private void b(List<wme> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((urk)urr.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((wme)paramList.next()).d();
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
      wsv.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new wqh(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Wli.e();
    wta.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private wph c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561461, paramViewGroup, false));
    paramViewGroup.a(2131378823).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Wna);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131373713);
    wqr localwqr = new wqr(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localwqr);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localwqr);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localwqr);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localwqr);
    paramViewGroup.a("general_touch_handler", localwqr);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private wph d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561567, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131373704);
    paramViewGroup.a(2131373705).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373703).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373834).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373829).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Wna);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131373713);
    wqr localwqr = new wqr(this);
    paramViewGroup.a("general_touch_handler", localwqr);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localwqr);
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
    int k = xod.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      wsv.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private wph e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561389, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373704);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373667).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373675).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Wna);
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
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    wme localwme = (wme)this.jdField_a_of_type_Wli.a().get(paramInt);
    localbhpy.a(alpo.a(2131704843), 5);
    localbhpy.c(2131690648);
    localbhpy.a(new wpv(this, localbhpy, paramInt, localwme));
    localbhpy.a(new wpw(this, paramInt));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
    a(localwme, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!xne.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(vhj.a(), 1, alpo.a(2131704857), 0).a();
      return;
    }
    Object localObject = (wme)this.jdField_a_of_type_Wli.a().remove(paramInt);
    if (localObject == null)
    {
      xmh.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((wme)localObject, "hide_done");
    String str = ((wme)localObject).a().getOwner().getUnionId();
    long l;
    switch (((wme)localObject).a().type)
    {
    case 4: 
    default: 
      xmh.a("feed not allow unLike operation type=" + ((wme)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((wme)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      xmv.a(str, paramInt, l);
      localObject = ((wme)localObject).a().feedId;
      Bosses.get().postJob(new wqb(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((wme)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((wme)localObject).a()).recommendId;
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
    if (umf.a()) {}
    do
    {
      return;
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alpo.a(2131704844), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alpo.a(2131704852), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alpo.a(2131704845), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (wrh)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((wrh)localObject).a(false);
      }
      a().setSelection(0);
      return;
      wsv.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void Z_()
  {
    this.jdField_a_of_type_Wme = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Wli.a()).iterator();
      while (localIterator.hasNext())
      {
        wme localwme = (wme)localIterator.next();
        if (((localwme instanceof wmd)) && (localwme.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localwme.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Wme == null))
        {
          this.jdField_a_of_type_Wme = localwme;
          wsv.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Wme.toString());
          return;
        }
      }
      wsv.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Wli.a().size();
  }
  
  protected int a(int paramInt)
  {
    wme localwme = (wme)this.jdField_a_of_type_Wli.a().get(paramInt);
    if (localwme.a().type == 1) {
      return 0;
    }
    if (localwme.a().type == 3) {
      return 0;
    }
    if (localwme.a().type == 2) {
      return 0;
    }
    if (localwme.a().type == 5) {
      return 1;
    }
    if (localwme.a().type == 6) {
      return 2;
    }
    if (localwme.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Wli.a().size())
    {
      localObject1 = (wme)this.jdField_a_of_type_Wli.a().get(j);
      if ((((wme)localObject1).a().type != 1) && (((wme)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((wph)localObject1).a(2131373723);
      if (localObject2 != null) {
        break;
      }
      wsv.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131373721);
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { alpo.a(2131704831), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    wme localwme = (wme)this.jdField_a_of_type_Wli.a().get(paramInt);
    paramwph.a("feed_id", localwme.a().feedId);
    View localView = paramwph.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localwme.jdField_b_of_type_Boolean = true;
      d(paramwph);
      paramwph = new ArrayList();
      paramwph.add(localwme);
      b(paramwph, 0);
      wta.b("story_home_dev", "feed_exp", localwme.a().type, localwme.d().size(), new String[] { localwme.a().feedId });
      return localView;
      if (localwme.a().type == 1)
      {
        localView = a(paramInt, paramwph, paramViewGroup, (wkx)localwme);
      }
      else if (localwme.a().type == 2)
      {
        localView = a(paramInt, paramwph, paramViewGroup, (wmd)localwme);
      }
      else if (localwme.a().type == 3)
      {
        localView = a(paramInt, paramwph, paramViewGroup, (wky)localwme);
        continue;
        localView = a(paramInt, paramwph, (wjy)localwme);
        continue;
        localView = a(paramInt, paramwph, paramViewGroup, (wmf)localwme);
        continue;
        localView = a(paramInt, paramwph, paramViewGroup, (wma)localwme);
      }
    }
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup, wkx paramwkx)
  {
    wsv.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramwph.a(2131373690);
    FrameLayout localFrameLayout = (FrameLayout)paramwph.a(2131373694);
    a(paramwkx, paramwph);
    a(paramInt, paramwph, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwph, paramwkx, paramwkx.a().getOwner());
    a(paramwph, paramwkx, true);
    a(paramInt, paramwph);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwph.a("feed_id", paramwkx.a().feedId);
    a(paramwkx, paramwph);
    a(paramwkx, paramwph, localFrameLayout, null);
    return paramwph.a();
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup, wmd paramwmd)
  {
    wsv.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramwph.a(2131373690);
    FrameLayout localFrameLayout = (FrameLayout)paramwph.a(2131373694);
    a(paramwmd, paramwph);
    a(paramInt, paramwph, this.jdField_d_of_type_Boolean);
    a(paramInt, paramwph, paramwmd, ((ShareGroupFeedItem)paramwmd.a()).getOwner());
    a(paramwph, paramwmd, true);
    a(paramwmd, paramwph);
    a(paramInt, paramwph);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramwph.a("feed_id", ((ShareGroupFeedItem)paramwmd.a()).feedId);
    paramwph.a("group_id", ((ShareGroupFeedItem)paramwmd.a()).getOwner().shareGroupId);
    a(paramwmd, paramwph, localFrameLayout, ((ShareGroupFeedItem)paramwmd.a()).getOwner());
    paramwmd.jdField_b_of_type_Boolean = true;
    return paramwph.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected wli a(boolean paramBoolean)
  {
    return new wli(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    bhxr.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      bhxr.a();
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
  
  protected wph a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Wli.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((wme)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      wph localwph = a(j);
      if ((localwph != null) && (paramString.equals(localwph.a("feed_id")))) {
        return localwph;
      }
      if (localwph != null)
      {
        localObject = (wme)((List)localObject).get(j);
        xmh.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localwph.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (wph)localIterator.next();
        if (localObject != null)
        {
          localObject = (uoq)((wph)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((uoq)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, wph paramwph)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373718);
    TextView localTextView = (TextView)paramwph.a(2131373719);
    ImageView localImageView = (ImageView)paramwph.a(2131373716);
    if (localRelativeLayout == null) {
      return;
    }
    if (umf.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (wme)this.jdField_a_of_type_Wli.a().get(paramInt);
    switch (((wme)localObject).a().type)
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
      localObject = (BannerFeedItem)((wme)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        wsv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = alpo.a(2131704833);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramwph);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((wme)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((wme)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        wsv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = alpo.a(2131704839);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramwph);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((wme)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      wsv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = alpo.a(2131704830);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramwph);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, wph paramwph, wmg paramwmg, QQUserUIItem paramQQUserUIItem)
  {
    bhxr.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramwph.a(2131373704);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(vhj.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845913));
      bhxr.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(xod.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bdda.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramwph = "";
      if (paramwmg.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramwph);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramwmg.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramwph = localQQStoryOwnerInfoView.a();
      paramwph.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramwmg.jdField_b_of_type_Boolean) {
        paramwph.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      bhxr.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramwmg.a().type == 3)
      {
        paramwph = (GeneralRecommendFeedItem)paramwmg.a();
        if (!TextUtils.isEmpty(paramwph.blurb))
        {
          paramwph = paramwph.blurb;
          break label152;
        }
        paramwph = a(paramwmg.a());
        break label152;
      }
      paramwph = a(paramwmg.a());
      break label152;
      label296:
      if (paramwmg.a().type == 3) {
        if (wiq.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, alpo.a(2131704847), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, wph paramwph, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373697);
    bhxr.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramwph.a(2131373696);
    Object localObject1 = (ImageView)paramwph.a(2131373698);
    paramwph = (ImageView)paramwph.a(2131373699);
    Object localObject2 = this.jdField_a_of_type_Wli.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      bhxr.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130845991);
      paramwph.setImageResource(2130845993);
      if (paramInt != 0) {
        break label165;
      }
      paramwph = xod.a(xod.a(((wme)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramwph);
    }
    for (;;)
    {
      bhxr.a();
      return;
      ((ImageView)localObject1).setImageResource(2130845990);
      paramwph.setImageResource(2130845992);
      break;
      label165:
      paramwph = (wme)((List)localObject2).get(paramInt - 1);
      localObject2 = (wme)((List)localObject2).get(paramInt);
      localObject1 = xod.a(paramwph.a().date);
      localObject2 = xod.a(((wme)localObject2).a().date);
      if (((paramwph instanceof wma)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramwph = xod.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramwph);
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
        vju.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (uhk)vhj.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      wta.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (xod.b()) {
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
      vju.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      wta.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      vju.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          vju.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = wta.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        wta.a("home_page", "clk_card", wta.a(paramVideoListFeedItem), wgt.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), wta.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        vju.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    wsv.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Wli.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localwme = (wme)localIterator.next();
      if (paramString1.equals(localwme.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localwme, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      wme localwme;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(uok paramuok, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramuok.c != null) && (paramuok.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Wpi.a();
      paramView.setFeedItemData(paramuok.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramuok, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(uok paramuok, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramuok.c != null) && (paramuok.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Wpi.a();
      paramViewGroup.setFeedItemData(paramuok.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramuok, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(vaa paramvaa)
  {
    if ((((Integer)((urk)urr.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramvaa.jdField_a_of_type_JavaUtilList != null))
    {
      vjz.a();
      paramvaa = new ArrayList(paramvaa.jdField_a_of_type_JavaUtilList).iterator();
      while (paramvaa.hasNext()) {
        vjz.a(((StoryVideoItem)paramvaa.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(wkx paramwkx, wph paramwph)
  {
    paramwkx = (VideoListLayout)paramwph.a(2131373723);
    if (paramwkx != null)
    {
      paramwkx = paramwkx.a();
      if (paramwkx != null) {
        paramwkx.setVisibility(8);
      }
    }
  }
  
  public void a(wle paramwle)
  {
    boolean bool1 = true;
    wsv.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramwle == null) {
      c(false);
    }
    do
    {
      return;
      if (paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        xmh.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramwle, new Object[0]);
        c(false);
        return;
      }
      wsv.d("Q.qqstory.home:FeedSegment", paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramwle.jdField_b_of_type_JavaUtilList, 0);
    } while (paramwle.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramwle.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramwle.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(wmd paramwmd, wph paramwph)
  {
    paramwmd = (VideoListLayout)paramwph.a(2131373723);
    if (paramwmd != null)
    {
      paramwmd = paramwmd.a();
      if (paramwmd != null) {
        paramwmd.setVisibility(8);
      }
    }
  }
  
  public void a(wmg paramwmg)
  {
    wsv.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramwmg);
    if ((paramwmg == null) || (paramwmg.a() == null) || (paramwmg.a().feedId == null))
    {
      wsv.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramwmg.a().feedId);
  }
  
  protected void a(wph paramwph)
  {
    Object localObject = (VideoListLayout)paramwph.a(2131373723);
    ((VideoListLayout)localObject).a().setOnClickListener(paramwph);
    ((VideoListLayout)localObject).a().setOnClickListener(paramwph);
    localObject = ((VideoListLayout)localObject).a();
    wqr localwqr = new wqr(this);
    paramwph.a("general_touch_handler", localwqr);
    paramwph.a("general_adapter", null);
    paramwph.a(this.jdField_b_of_type_Wna);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localwqr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localwqr);
    paramwph.a("type", "GeneralView");
  }
  
  protected void a(wph paramwph, wmf paramwmf)
  {
    TextView localTextView1 = (TextView)paramwph.a(2131373832);
    TextView localTextView2 = (TextView)paramwph.a(2131373831);
    TextView localTextView3 = (TextView)paramwph.a(2131373834);
    xjv localxjv = ((TagFeedItem)paramwmf.a()).tagItem;
    paramwph = (TextView)paramwph.a(2131373829);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
      paramwph.setBackgroundResource(2130846017);
    }
    if (localxjv != null)
    {
      localTextView1.setText(localxjv.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramwmf.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramwmf.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramwmf.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramwmf.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(wqo paramwqo)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Wli.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    wsv.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    wsv.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Wli.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Wkp.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected void ab_()
  {
    super.ab_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Wmw.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Wmw.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Wli.c();
    this.jdField_a_of_type_Wli.d();
    this.g = false;
  }
  
  protected wph b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561434, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373704);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    bhxr.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Wpi.a()) || (this.jdField_a_of_type_Int != 10))
    {
      bhxr.a();
      wsv.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Wpi.a());
      return;
    }
    wsv.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((wph)localIterator.next()).a(2131373723);
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
        wsv.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131373721);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = wnc.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wnc.a(localQQStoryAutoPlayView);
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
          wsv.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = wnc.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wnc.c(localQQStoryAutoPlayView);
          break label326;
          k = wnc.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = wnc.b(localQQStoryAutoPlayView);
          break label326;
          wsv.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          wsv.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          bhxr.a();
          return;
          wsv.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Wli.a());
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
    wsv.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(wle paramwle)
  {
    c(true);
  }
  
  protected void b(wph paramwph)
  {
    ((VideoListLayout)paramwph.a(2131373723)).a().setVisibility(8);
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
    this.jdField_a_of_type_Wli.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Wmw == null) {
      return;
    }
    this.jdField_a_of_type_Wmw.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (umf.a()) {
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
      wnb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (wrh)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      wsv.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(wph paramwph)
  {
    bhxr.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramwph);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramwph.a(2131373723);
    if (localVideoListLayout == null)
    {
      bhxr.a();
      return;
    }
    paramwph = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramwph != null) && (paramwph.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramwph != null) && (paramwph.a() != null)) {
        wsv.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramwph.a().getThumbUrl());
      }
      if (paramwph != null) {
        paramwph.a();
      }
      bhxr.a();
      return;
      paramwph = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramwph = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramwph = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramwph = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131373721);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wqp);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wql);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wqk);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wqq);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wqi);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Wqn);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Wmw.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      uoq localuoq = (uoq)((wph)localIterator.next()).a("commentLikeLego");
      if (localuoq != null) {
        localuoq.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Wli.b();
    upm.a();
  }
  
  public void d(wph paramwph)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramwph);
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
    wsv.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int f_()
  {
    return 4;
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new wpt(this));
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
      paramMessage = (wle)paramMessage.obj;
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
      j = xod.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Wpi.a();
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
        paramMessage = (wph)localIterator.next();
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
      xmh.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = xod.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Wpi.a().getLocationOnScreen(arrayOfInt1);
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
        wsv.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (wph)localIterator.next();
      wsv.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (uoq)((wph)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((uoq)localObject).c();
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
    wsv.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((urk)urr.a(10)).b("mainHallConfig", "");
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
        wsv.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        wsv.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wps
 * JD-Core Version:    0.7.0.1
 */