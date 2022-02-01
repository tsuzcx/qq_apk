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
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.16;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.17;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.18;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.6;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.9;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.b;
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
import com.tencent.widget.HorizontalListView.d;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Event;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
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

public class qyk
  extends rsd<qvq>
  implements Handler.Callback, QQStoryAutoPlayView.a, IEventReceiver, pqh.b, pqn.a, qvt.f, qyi.a
{
  public static final String KEY = "FeedSegment";
  private static Drawable defaultDrawable = new afei(-2631721, 180, 320);
  private static Drawable dh = new afei(-2631721, 180, 320);
  private long By = -1L;
  private boolean Ln;
  private qvf jdField_a_of_type_Qvf;
  protected qvt a;
  protected qwn a;
  private qye jdField_a_of_type_Qye;
  private qyk.a jdField_a_of_type_Qyk$a;
  private qyk.c jdField_a_of_type_Qyk$c;
  private qyk.d jdField_a_of_type_Qyk$d;
  private qyk.f jdField_a_of_type_Qyk$f;
  private qyk.h jdField_a_of_type_Qyk$h;
  private qyk.i jdField_a_of_type_Qyk$i;
  private boolean aDA = true;
  private boolean aEJ;
  private boolean aGe;
  private boolean aGf;
  private boolean aGg;
  private boolean aGh;
  protected AtomicBoolean aX = new AtomicBoolean(true);
  public String ayG;
  public String ayH;
  private ptf jdField_b_of_type_Ptf;
  private qwa jdField_b_of_type_Qwa;
  private final int boX;
  private final int boY;
  private int boZ = -1;
  private int bpa = -1;
  private int bpb = -1;
  private QQStoryAutoPlayView jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_d_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qym(this);
  qwo jdField_d_of_type_Qwo = new qyu(this);
  qwo e = new qyv(this);
  qwo f = new qyw(this);
  qwo g = new qyx(this);
  protected Map<String, Integer> gd = new HashMap();
  private LruCache<String, QQUserUIItem> i = new LruCache(1024);
  private boolean isNightMode;
  protected int mFeedType;
  private Handler mHandler;
  private List<qyd> ot;
  private Activity y;
  
  public qyk(Context paramContext, Activity paramActivity, int paramInt, qye paramqye, boolean paramBoolean)
  {
    super(paramContext);
    this.y = paramActivity;
    this.jdField_a_of_type_Qye = paramqye;
    this.mFeedType = paramInt;
    this.aGe = paramBoolean;
    QQStoryContext.a();
    this.isNightMode = ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null);
    this.jdField_a_of_type_Qvt = a(paramBoolean);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.ot = new ArrayList();
    this.jdField_a_of_type_Qyk$h = new qyk.h(this);
    this.jdField_a_of_type_Qyk$d = new qyk.d(this);
    this.jdField_a_of_type_Qyk$c = new qyk.c(this);
    this.jdField_a_of_type_Qyk$i = new qyk.i(this);
    this.jdField_a_of_type_Qyk$a = new qyk.a(this);
    this.jdField_a_of_type_Qyk$f = new qyk.f(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$h);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$d);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$c);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$i);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$a);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qyk$f);
    this.jdField_a_of_type_Qwn = new qwn(Looper.myLooper());
    this.jdField_a_of_type_Qvt.create();
    this.jdField_b_of_type_Ptf = ((ptf)psx.a(2));
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_d_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.mFeedType == 10) {
      this.jdField_a_of_type_Qwn.wE(1);
    }
    for (;;)
    {
      this.aGf = false;
      this.boX = paramContext.getResources().getDimensionPixelSize(2131298952);
      this.boY = paramContext.getResources().getDimensionPixelSize(2131298963);
      return;
      if (this.mFeedType == 11) {
        this.jdField_a_of_type_Qwn.wE(2);
      } else if (this.mFeedType == 12) {
        this.jdField_a_of_type_Qwn.wE(3);
      }
    }
  }
  
  private void B(List<qwa> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((psr)psx.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((qwa)paramList.next()).bZ();
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
      ram.w("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Qwn.eI(localArrayList);
      return;
    }
  }
  
  private void C(List<qwa> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((psr)psx.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((qwa)paramList.next()).bZ();
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
      ram.w("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new qyz(this, "Q.qqstory.home:FeedSegment"));
    }
  }
  
  private boolean KB()
  {
    this.jdField_a_of_type_Qvt.aMG();
    rar.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  private View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup, qvk paramqvk)
  {
    paramViewGroup = (ImageView)paramqyd.get(2131375123);
    FrameLayout localFrameLayout = (FrameLayout)paramqyd.get(2131375127);
    d(paramqyd);
    a(paramInt, paramqyd, this.isNightMode);
    a(paramInt, paramqyd, paramqvk, paramqvk.b().getOwner());
    a(paramqyd, paramqvk, true);
    a(paramqvk, paramqyd);
    a(paramInt, paramqyd);
    paramInt = -3355444;
    if (this.isNightMode) {
      paramInt = this.context.getResources().getColor(2131167390);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramqyd.q("feed_id", paramqvk.b().feedId);
    a(paramqvk, paramqyd, localFrameLayout, null);
    if (!paramqvk.FR) {
      rar.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramqvk.b().getOwner().getUnionId(), paramqvk.b().feedId });
    }
    paramViewGroup = paramqvk.b().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      rar.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramqyd.getItemView();
  }
  
  private View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup, qvx paramqvx)
  {
    paramViewGroup = (VideoListLayout)paramqyd.get(2131375156);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.C();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(rpq.dip2px(this.context, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((qyk.j)paramqyd.l("general_touch_handler")).b(paramqyd.position, paramqyd);
    if ((paramqvx.bS() == null) || (paramqvx.bS().size() == 0))
    {
      ram.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramqvx.c()).feedId);
      paramqyd.itemView.setVisibility(8);
      return paramqyd.getItemView();
    }
    paramqyd.itemView.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (qyi)paramqyd.l("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new qyi(this.context, this.y, this.mFeedType);
      paramqyd.q("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.setStoryCoverClickListener(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Qwn);
      localObject2 = (Integer)this.gd.get(((HotRecommendFeedItem)paramqvx.c()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        ram.b("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramqvx.c()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(rpq.dip2px(this.context, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramqvx.bS().size();
        paramViewGroup.a(paramqvx.bS(), paramqvx.c());
        if (((HotRecommendFeedItem)paramqvx.c()).mIsVideoEnd) {
          break label501;
        }
        bool = true;
        label385:
        ((StoryHomeHorizontalListView)localObject1).setLoadMoreComplete(bool);
        if (j > paramInt) {
          ((StoryHomeHorizontalListView)localObject1).post(new FeedSegment.6(this, (StoryHomeHorizontalListView)localObject1));
        }
        if (paramInt > j) {
          ((StoryHomeHorizontalListView)localObject1).brV();
        }
        paramViewGroup = paramqyd.get(2131380795);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((psr)psx.a(10)).c("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        rar.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup, qwb paramqwb)
  {
    paramViewGroup = (ImageView)paramqyd.get(2131375123);
    a(paramInt, paramqyd, this.isNightMode);
    a(paramqyd, paramqwb);
    a(paramInt, paramqyd);
    a(paramqyd, paramqwb, true);
    a(null, paramqyd);
    paramInt = -3355444;
    if (this.isNightMode) {
      paramInt = this.context.getResources().getColor(2131167390);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    rar.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramqwb.c()).feedId });
    return paramqyd.getItemView();
  }
  
  private View a(int paramInt, qyd paramqyd, quw paramquw)
  {
    Object localObject = (QQStoryOwnerInfoView)paramqyd.get(2131375137);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).o();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).z();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).A();
    TextView localTextView4 = (TextView)paramqyd.get(2131375108);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).m();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramqyd.get(2131375100);
    FrameLayout localFrameLayout = (FrameLayout)paramqyd.get(2131375102);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramquw.a();
    a(paramInt, paramqyd, this.isNightMode);
    a((QQStoryOwnerInfoView)localObject, acfp.m(2131706174), true);
    if (quc.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      rpq.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, aqhu.F(1), "QQStory_main");
      a(paramInt, paramqyd);
      localStoryQIMBadgeView.g(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramquw.FR) {
        localStoryUserBadgeView.aCG();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = rpq.getWindowScreenWidth(this.context) - rpq.dip2px(this.context, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (pqn)paramqyd.l("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new pqn(this.context, this.y, null, paramquw, this.mFeedType);
      ((pqn)localObject).a(paramquw);
      ((pqn)localObject).bmA();
      paramqyd.q("commentLikeLego", localObject);
      localFrameLayout.addView(((pqn)localObject).mParentView);
    }
    for (;;)
    {
      ((pqn)localObject).b(this);
      ((pqn)localObject).a(this);
      ((pqn)localObject).sa(false);
      if (!paramquw.FR) {
        rar.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramquw.a()).getOwner().getUnionId(), ((BannerFeedItem)paramquw.a()).feedId });
      }
      return paramqyd.getItemView();
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
      ((pqn)localObject).a(paramquw, null, paramquw);
      ((pqn)localObject).dZ(null);
    }
  }
  
  private void a(int paramInt, qwa paramqwa, String paramString, boolean paramBoolean)
  {
    if (!(paramqwa instanceof qwc)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        ram.b("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.mHandler.postDelayed(new FeedSegment.16(this, paramInt, paramqwa, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((qyd)localObject1).get(2131375156);
        List localList = ((qwc)paramqwa).bS();
        if (localList.size() <= 2) {
          this.mHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            ram.b("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= rpq.dip2px(this.context, 152.0F);
              this.gd.put(paramqwa.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (qtc)((qyd)localObject1).l("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((qtc)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.mHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            ram.b("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramqwa.a().feedId, Integer.valueOf(j));
            ram.b("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, qyd paramqyd, qwc paramqwc, ShareGroupItem paramShareGroupItem)
  {
    auvk.traceBegin("FeedSegment.bindFeedShareGroupInfo");
    paramqyd = (QQStoryOwnerInfoView)paramqyd.get(2131375137);
    if (paramShareGroupItem == null)
    {
      paramqyd.setSubTitle(null);
      paramqyd.setBadge(null);
      paramqyd.setQIMIcon(null);
      paramqyd.setSubTitleSuffix(null);
      paramqyd.setButtonTxt(null);
      paramqyd.setName(qem.auW);
      paramqyd.setAvatar(this.context.getResources().getDrawable(2130847307));
      auvk.traceEnd();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = aqhu.aU();
      paramqyd.setAvatar(aqdj.a(QQStoryContext.c(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramqyd.setName(paramShareGroupItem.getName());
      if (paramqwc.c().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((qvz)paramqwc).c(), paramqwc.bS());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramqyd.setSubTitle((String)localObject1);
        paramqyd.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramqyd.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130847672);
      label199:
      if (paramqwc.c().type == 2)
      {
        if (!paramqwc.KD()) {
          break label328;
        }
        a(paramqyd, acfp.m(2131706181), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramqyd = paramqyd.a();
      paramqyd.g(null);
      paramqyd.setVisibility(8);
      auvk.traceEnd();
      return;
      paramqyd.setAvatar(((qph)psx.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130847674);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130847673);
      break label199;
      label328:
      a(paramqyd, null, false);
    }
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString)
  {
    a(paramStoryVideoItem, paramQQStoryAutoPlayView, paramString, -1, -1);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString, int paramInt1, int paramInt2)
  {
    auvk.traceBegin("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = defaultDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        ram.d("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = raj.a.gb(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (d(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        ram.d("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!qwq.isFileExist(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = raj.a.gb(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      auvk.traceEnd();
      return;
      if (!bool)
      {
        paramInt1 = 225;
        paramInt2 = 364;
        localDrawable = defaultDrawable;
        break;
      }
      paramInt1 = 150;
      paramInt2 = 243;
      localDrawable = dh;
      break;
      label176:
      ram.d("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = rpn.go(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = rpn.r(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    ausj localausj = ausj.b(this.context);
    localausj.addButton(acfp.m(2131706176), 5);
    QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = acfp.m(2131706177);; str = acfp.m(2131706169))
    {
      localausj.addButton(str, 5);
      localausj.addButton(acfp.m(2131706194), 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new qyp(this, localausj, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localausj.a(new qys(this));
      if (!localausj.isShowing()) {
        localausj.show();
      }
      rar.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130847483);
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
        qwp.w("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      qwp.e("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      rpq.dV(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = rpq.dip2px(this.context, 13.0F);
      int k = rpq.dip2px(this.context, 3.0F);
      localButton.setTextColor(this.context.getResources().getColor(2131167304));
      if (QQStoryContext.isNightMode())
      {
        localButton.setBackgroundResource(2130847411);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.isNightMode())
      {
        localButton.setTextColor(this.context.getResources().getColor(2131166758));
        localButton.setBackgroundResource(2130847411);
      }
      j = rpq.dip2px(this.context, 20.0F);
      rpq.h(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130847410);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.context.getResources().getColor(2131166745));
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
    paramString.setDecodeHandler(rpq.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(qwa paramqwa)
  {
    if ((paramqwa == null) || (paramqwa.a() == null) || (paramqwa.a().getOwner() == null)) {
      rom.fail("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramqwa instanceof qvj))
      {
        paramqwa = ((qvj)paramqwa).c().getOwner();
        ppf.f(this.context, 4, paramqwa.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramqwa instanceof qvz))
      {
        paramqwa = (ShareGroupFeedItem)((qvz)paramqwa).c();
        localObject = paramqwa.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          ram.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          rom.fail("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramqwa.getOwner().getRelationType() == 2)
        {
          if (this.mFeedType == 10)
          {
            j = 1;
            if (this.mFeedType != 10) {
              break label186;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.context, 1, ((ShareGroupItem)localObject).getUnionId(), String.valueOf(((ShareGroupItem)localObject).groupUin), j, k);
            return;
            j = 9;
            break;
          }
        }
        QQStoryShareGroupProfileActivity.a(this.y, 2, str, null, 1, 74);
        return;
      }
      if ((paramqwa instanceof qvk))
      {
        paramqwa = ((qvk)paramqwa).b();
        localObject = paramqwa.getOwner();
        if (paramqwa.getOwner().getRelationType() == 2)
        {
          if (this.mFeedType == 10)
          {
            j = 2;
            if (this.mFeedType != 10) {
              break label289;
            }
          }
          for (k = 74;; k = 76)
          {
            QQStoryShareGroupProfileActivity.a(this.context, 1, ((QQUserUIItem)localObject).uid, ((QQUserUIItem)localObject).qq, j, k);
            return;
            j = 9;
            break;
          }
        }
        ppf.f(this.context, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramqwa instanceof qwb))
      {
        paramqwa = (TagFeedItem)((qwb)paramqwa).c();
        qev.a(this.y, paramqwa.tagItem.a);
        return;
      }
    } while (!(paramqwa instanceof qvx));
    label289:
    brP();
    rar.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(qwa paramqwa, ShareGroupItem paramShareGroupItem)
  {
    if (qow.a(paramShareGroupItem))
    {
      if (paramqwa.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        rar.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.y, 1, acfp.m(2131706193), 1).show();
        return;
      }
    }
    QQStoryContext.a();
    new qox((QQAppInterface)QQStoryContext.c()).a(this.y, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    rar.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(qwa paramqwa, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramqwa.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      rar.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramqwa.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(qwc paramqwc, qyd paramqyd) {}
  
  private void a(qwc paramqwc, qyd paramqyd, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    auvk.traceBegin("FeedSegment.bindCommentLike");
    pqn localpqn;
    if (paramqwc.bS().size() > 0)
    {
      localpqn = (pqn)paramqyd.l("commentLikeLego");
      if (localpqn != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localpqn = pqn.a(this.context, this.y, null, paramqwc, this.mFeedType, paramShareGroupItem);
      paramqyd.q("commentLikeLego", localpqn);
      paramFrameLayout.addView(localpqn.mParentView);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localpqn.hide();
        paramqwc = paramFrameLayout.getLayoutParams();
        paramqwc.height = rpq.dip2px(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramqwc);
      }
      for (;;)
      {
        auvk.traceEnd();
        return;
        label132:
        localpqn = new pqn(this.context, this.y, null, paramqwc, this.mFeedType);
        break;
        paramqyd = paramFrameLayout.getLayoutParams();
        paramqyd.height = -2;
        paramFrameLayout.setLayoutParams(paramqyd);
        if (localpqn.IG())
        {
          localpqn.a(paramqwc, paramShareGroupItem, null);
          localpqn.dZ(null);
        }
        for (;;)
        {
          localpqn.b(this);
          localpqn.a(this);
          if ((paramqwc.c().mVideoPullType != 0) || (paramqwc.bS().size() <= 1)) {
            break label249;
          }
          localpqn.sa(true);
          break;
          localpqn.bmA();
        }
        label249:
        localpqn.sa(false);
      }
    }
  }
  
  private void a(qyd paramqyd, qwc paramqwc, boolean paramBoolean)
  {
    auvk.traceBegin("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramqyd.get(2131375156);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).C();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(rpq.dip2px(this.context, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((qyk.j)paramqyd.l("general_touch_handler")).b(paramqyd.position, paramqyd);
    if ((paramqwc.bS() == null) || (paramqwc.bS().size() == 0))
    {
      ram.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramqwc.c().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      auvk.traceEnd();
      return;
    }
    Object localObject1;
    if (paramqwc.bS().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (qtc)paramqyd.l("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new qtc(this.context, this.y, this.mFeedType);
      ((qtc)localObject1).a(this.i);
      paramqyd.q("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((qtc)localObject1).setStoryCoverClickListener(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((qtc)localObject1).a(this.jdField_a_of_type_Qwn);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.gd.get(paramqwc.c().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          ram.b("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramqwc.c().feedId, localObject3);
        }
      }
      else
      {
        if (paramqwc.bS().size() != 2) {
          break label563;
        }
        j = (rpq.getWindowScreenWidth(this.context) - this.boX * 2 - this.boY) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((qtc)localObject1).setVideoSize(j, k);
        ((qtc)localObject1).wA(rpq.dip2px(this.context, 8.0F));
        if (paramqwc.c().type != 6) {
          break label642;
        }
        j = k + rpq.dip2px(this.context, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.context.getResources().getDimensionPixelSize(2131298963));
        ((qtc)localObject1).a(paramqwc.bS(), paramqwc.c());
        if (ppg.ID())
        {
          if ((!this.aGh) || (paramqyd.position != 0) || ((!paramqwc.KE()) && (!paramqwc.c().isFakeFeedItem()))) {
            break label660;
          }
          ((qtc)localObject1).aFp = true;
          this.aGh = false;
        }
        if (paramqwc.c().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = rpq.dip2px(this.context, 152.0F);
        if (rpq.getWindowScreenWidth(this.context) > j * 2.2D) {}
        for (k = rpq.dip2px(this.context, 270.0F);; k = rpq.dip2px(this.context, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = rpq.dip2px(this.context, 133.0F);
        }
        j = k + rpq.dip2px(this.context, 22.0F);
        break label447;
        ((qtc)localObject1).aFp = false;
        break label533;
      }
      if (paramqwc.bS().size() == 1)
      {
        j = rpq.getWindowScreenWidth(this.context) - this.boX * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(rpq.dip2px(this.context, 11.0F));
        localObject2 = (StoryVideoItem)paramqwc.bS().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramqwc.c(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Qwn);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().setVid(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().setVisibility(0);
          poe.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((ppg.ID()) && (this.aGh) && (paramqyd.position == 0) && ((paramqwc.KE()) || (paramqwc.c().isFakeFeedItem())))
          {
            dN((View)localObject3);
            this.aGh = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.context.getResources().getColor(2131167393));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(acfp.m(2131706188));
          localTextView.setTextColor(this.context.getResources().getColor(2131167393));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramqwc.c().type == 3) && ((paramqwc.c().getOwner() instanceof QQUserUIItem)))
          {
            paramqyd = (QQUserUIItem)paramqwc.c().getOwner();
            if ((paramqyd.isVip) && (!paramqyd.isSubscribe())) {
              rar.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramqwc.c().type != 6) {
            break;
          }
          rar.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = poe.a().fO(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().setVid((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().KO()) {
              break label1224;
            }
            ram.b("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new qyy(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().setVisibility(4);
          poe.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.context.getResources().getColor(2131167304));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(rpq.f(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramqwc.c().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramqwc.c().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(rpq.aM(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramqwc.c().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.mFeedType == 10) && (h((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().a != null))
            {
              localStoryNickNameView.setFormat(acfp.m(2131706198));
              localStoryNickNameView.c(this.i);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().a.avo);
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
  
  public static String[] a(ShareGroupFeedItem paramShareGroupFeedItem, List<StoryVideoItem> paramList)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramShareGroupFeedItem.des)) && (paramShareGroupFeedItem.mVideoPullType == 0))
    {
      localObject = paramShareGroupFeedItem.des;
      if (paramShareGroupFeedItem.todayJoinMemberCount > 1) {
        paramList = acfp.m(2131706199);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = acfp.m(2131706186);
      continue;
      String str2 = t(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + acfp.m(2131706191);
        paramList = str1;
      }
    }
  }
  
  public static int ab(Context paramContext)
  {
    if (aqiw.isWifiConnected(paramContext)) {
      return 1;
    }
    if (aqiw.isMobileNetWork(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private void brO()
  {
    if (ppg.ID()) {}
    do
    {
      return;
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.aGh), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.aGg) });
    } while ((!this.aGh) || (!this.aGg));
    Object localObject = aw();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { acfp.m(2131706184), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { acfp.m(2131706192), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(l((View)localObject)) });
    }
    for (;;)
    {
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { acfp.m(2131706185), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.aGh = false;
      this.mHandler.sendMessage(this.mHandler.obtainMessage(13, localRect));
      localObject = (qzh)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((qzh)localObject).setOpen(false);
      }
      a().setSelection(0);
      return;
      ram.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  private qyd d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561872, paramViewGroup, false));
    paramViewGroup.get(2131380795).setOnClickListener(paramViewGroup);
    paramViewGroup.b(this.g);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.get(2131375146);
    qyk.j localj = new qyk.j();
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localj);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localj);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localj);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localj);
    paramViewGroup.q("general_touch_handler", localj);
    paramViewGroup.q("general_adapter", null);
    return paramViewGroup;
  }
  
  private static boolean d(String paramString, int paramInt1, int paramInt2)
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
  
  private void dN(View paramView)
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
  
  private qyd e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561978, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.get(2131375137);
    paramViewGroup.get(2131375138).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131375136).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131375267).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131375262).setOnClickListener(paramViewGroup);
    paramViewGroup.b(this.f);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.get(2131375146);
    qyk.j localj = new qyk.j();
    paramViewGroup.q("general_touch_handler", localj);
    paramViewGroup.q("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localj);
    paramViewGroup.q("type", "TagView");
    return paramViewGroup;
  }
  
  public static boolean eK(int paramInt)
  {
    switch (((pmb)qem.getQQAppInterface().getManager(181)).sl())
    {
    }
    do
    {
      do
      {
        return false;
        ram.d("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  private qyd f(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561800, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.get(2131375137);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131375100).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131375108).setOnClickListener(paramViewGroup);
    paramViewGroup.b(this.jdField_d_of_type_Qwo);
    paramViewGroup.q("type", "BannerView");
    return paramViewGroup;
  }
  
  public static boolean h(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().styleType != 5) || (paramStoryVideoItem.getVideoLinkInfo().a == null)) {
      return false;
    }
    return true;
  }
  
  @NonNull
  private String mF()
  {
    return String.valueOf(hashCode());
  }
  
  private int sX()
  {
    if ((System.currentTimeMillis() - this.By < 100L) && (this.bpb != -1) && (this.bpb != 0))
    {
      this.By = System.currentTimeMillis();
      return this.bpb;
    }
    int k = rpq.getWindowScreenHeight(this.context);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.By = System.currentTimeMillis();
      ram.d("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.boZ + ",firstTopY=" + j + ",lastFirstTopY=" + this.bpa);
      if (m != this.boZ) {
        break label230;
      }
      if ((j <= k) && (this.bpa <= k)) {
        break;
      }
      this.bpa = j;
      this.boZ = m;
      return 0;
    }
    if (j > this.bpa)
    {
      this.bpa = j;
      this.boZ = m;
      return 2;
    }
    if (j < this.bpa)
    {
      this.bpa = j;
      this.boZ = m;
      return 1;
      label230:
      if (m > this.boZ)
      {
        this.bpa = j;
        this.boZ = m;
        return 1;
      }
      if (m < this.boZ)
      {
        this.bpa = j;
        this.boZ = m;
        return 2;
      }
    }
    this.bpa = j;
    this.boZ = m;
    return 0;
  }
  
  private void sl(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString.position, paramString, a());
    }
  }
  
  @Nullable
  public static String t(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      ram.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = rpq.tP() / 3600;
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
        return qwq.h(j, true);
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
  
  private void wI(int paramInt)
  {
    if (!this.Ln) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        wH(sX());
        return;
      }
    } while ((this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null) || (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.sR() != 1));
    this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.pausePlay();
  }
  
  private void wJ(int paramInt)
  {
    ausj localausj = ausj.b(this.context);
    qwa localqwa = (qwa)this.jdField_a_of_type_Qvt.bY().get(paramInt);
    localausj.addButton(acfp.m(2131706183), 5);
    localausj.addCancelButton(2131721058);
    localausj.a(new qyn(this, localausj, paramInt, localqwa));
    localausj.a(new qyo(this, paramInt));
    if (!localausj.isShowing()) {
      localausj.show();
    }
    a(localqwa, "clk_hide");
  }
  
  private void wK(int paramInt)
  {
    if (!rpc.hasInternet(this.context))
    {
      QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131706197), 0).show();
      return;
    }
    Object localObject = (qwa)this.jdField_a_of_type_Qvt.bY().remove(paramInt);
    if (localObject == null)
    {
      rom.fail("feed is null when unLike.", new Object[0]);
      return;
    }
    a((qwa)localObject, "hide_done");
    String str = ((qwa)localObject).a().getOwner().getUnionId();
    long l;
    switch (((qwa)localObject).a().type)
    {
    case 4: 
    default: 
      rom.fail("feed not allow unLike operation type=" + ((qwa)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((qwa)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      rov.i(str, paramInt, l);
      localObject = ((qwa)localObject).a().feedId;
      Bosses.get().postJob(new qyt(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      bwd();
      return;
      l = ((BannerFeedItem)((qwa)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((qwa)localObject).a()).recommendId;
      paramInt = 10;
    }
  }
  
  private void ws(int paramInt)
  {
    if (this.aEJ) {
      setSelection(paramInt);
    }
    while (a(paramInt) != null) {
      return;
    }
    setSelection(paramInt);
    this.aEJ = true;
  }
  
  public boolean G(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    ram.d("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected int J(int paramInt)
  {
    qwa localqwa = (qwa)this.jdField_a_of_type_Qvt.bY().get(paramInt);
    if (localqwa.a().type == 1) {
      return 0;
    }
    if (localqwa.a().type == 3) {
      return 0;
    }
    if (localqwa.a().type == 2) {
      return 0;
    }
    if (localqwa.a().type == 5) {
      return 1;
    }
    if (localqwa.a().type == 6) {
      return 2;
    }
    if (localqwa.a().type == 7) {
      return 3;
    }
    return super.J(paramInt);
  }
  
  protected boolean Z(boolean paramBoolean)
  {
    ram.i("Q.qqstory.home:FeedSegment", "onRefresh");
    this.aX.set(false);
    this.Ln = eK(ab(this.context));
    this.jdField_a_of_type_Qvt.refreshData(false);
    this.gd.clear();
    this.jdField_a_of_type_Qvf.gb.clear();
    if (!paramBoolean) {
      this.aGf = false;
    }
    return true;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    qwa localqwa = (qwa)this.jdField_a_of_type_Qvt.bY().get(paramInt);
    paramqyd.q("feed_id", localqwa.a().feedId);
    View localView = paramqyd.getItemView();
    switch (J(paramInt))
    {
    }
    for (;;)
    {
      localqwa.FR = true;
      f(paramqyd);
      paramqyd = new ArrayList();
      paramqyd.add(localqwa);
      C(paramqyd, 0);
      rar.b("story_home_dev", "feed_exp", localqwa.a().type, localqwa.bZ().size(), new String[] { localqwa.a().feedId });
      return localView;
      if (localqwa.a().type == 1)
      {
        localView = a(paramInt, paramqyd, paramViewGroup, (qvj)localqwa);
      }
      else if (localqwa.a().type == 2)
      {
        localView = a(paramInt, paramqyd, paramViewGroup, (qvz)localqwa);
      }
      else if (localqwa.a().type == 3)
      {
        localView = a(paramInt, paramqyd, paramViewGroup, (qvk)localqwa);
        continue;
        localView = a(paramInt, paramqyd, (quw)localqwa);
        continue;
        localView = a(paramInt, paramqyd, paramViewGroup, (qwb)localqwa);
        continue;
        localView = a(paramInt, paramqyd, paramViewGroup, (qvx)localqwa);
      }
    }
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup, qvj paramqvj)
  {
    ram.b("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramqyd.get(2131375123);
    FrameLayout localFrameLayout = (FrameLayout)paramqyd.get(2131375127);
    a(paramqvj, paramqyd);
    a(paramInt, paramqyd, this.isNightMode);
    a(paramInt, paramqyd, paramqvj, paramqvj.c().getOwner());
    a(paramqyd, paramqvj, true);
    a(paramInt, paramqyd);
    paramInt = -3355444;
    if (this.isNightMode) {
      paramInt = this.context.getResources().getColor(2131167390);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramqyd.q("feed_id", paramqvj.c().feedId);
    a(paramqvj, paramqyd);
    a(paramqvj, paramqyd, localFrameLayout, null);
    return paramqyd.getItemView();
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup, qvz paramqvz)
  {
    ram.b("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramqyd.get(2131375123);
    FrameLayout localFrameLayout = (FrameLayout)paramqyd.get(2131375127);
    a(paramqvz, paramqyd);
    a(paramInt, paramqyd, this.isNightMode);
    a(paramInt, paramqyd, paramqvz, ((ShareGroupFeedItem)paramqvz.c()).getOwner());
    a(paramqyd, paramqvz, true);
    a(paramqvz, paramqyd);
    a(paramInt, paramqyd);
    paramInt = -3355444;
    if (this.isNightMode) {
      paramInt = this.context.getResources().getColor(2131167390);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramqyd.q("feed_id", ((ShareGroupFeedItem)paramqvz.c()).feedId);
    paramqyd.q("group_id", ((ShareGroupFeedItem)paramqvz.c()).getOwner().shareGroupId);
    a(paramqvz, paramqyd, localFrameLayout, ((ShareGroupFeedItem)paramqvz.c()).getOwner());
    paramqvz.FR = true;
    return paramqyd.getItemView();
  }
  
  @NonNull
  protected qvt a(boolean paramBoolean)
  {
    return new qvt(this.mFeedType, this, paramBoolean);
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    auvk.traceBegin("FeedItem.createView");
    switch (J(paramInt))
    {
    default: 
      paramViewGroup = c(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.getItemView().requestLayout();
      auvk.traceEnd();
      return paramViewGroup;
      paramViewGroup = c(paramInt, paramViewGroup);
      continue;
      paramViewGroup = f(paramInt, paramViewGroup);
      continue;
      paramViewGroup = e(paramInt, paramViewGroup);
      continue;
      paramViewGroup = d(paramInt, paramViewGroup);
    }
  }
  
  protected qyd a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Qvt.bY();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((qwa)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      qyd localqyd = a(j);
      if ((localqyd != null) && (paramString.equals(localqyd.l("feed_id")))) {
        return localqyd;
      }
      if (localqyd != null)
      {
        localObject = (qwa)((List)localObject).get(j);
        rom.fail("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localqyd.l("feed_id") + " feed info=" + localObject, new Object[0]);
      }
      return null;
      j = -1;
    }
  }
  
  protected void a(int paramInt, qyd paramqyd)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375151);
    TextView localTextView = (TextView)paramqyd.get(2131375152);
    ImageView localImageView = (ImageView)paramqyd.get(2131375149);
    if (localRelativeLayout == null) {
      return;
    }
    if (ppg.ID())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (qwa)this.jdField_a_of_type_Qvt.bY().get(paramInt);
    switch (((qwa)localObject).a().type)
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
      localObject = (BannerFeedItem)((qwa)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        ram.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = acfp.m(2131706173);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramqyd);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((qwa)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((qwa)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        ram.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = acfp.m(2131706179);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramqyd);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((qwa)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      ram.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = acfp.m(2131706170);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramqyd);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, qyd paramqyd, qwc paramqwc, QQUserUIItem paramQQUserUIItem)
  {
    auvk.traceBegin("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramqyd.get(2131375137);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(qem.auW);
      localQQStoryOwnerInfoView.setAvatar(this.context.getResources().getDrawable(2130847307));
      auvk.traceEnd();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(rpq.a(this.context, paramQQUserUIItem.headUrl, 68, 68, aqhu.F(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramqyd = "";
      if (paramqwc.c().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramqyd);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramqwc.c().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramqyd = localQQStoryOwnerInfoView.a();
      paramqyd.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramqwc.FR) {
        paramqyd.aCG();
      }
      localQQStoryOwnerInfoView.a().g(paramQQUserUIItem);
      auvk.traceEnd();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramqwc.c().type == 3)
      {
        paramqyd = (GeneralRecommendFeedItem)paramqwc.c();
        if (!TextUtils.isEmpty(paramqyd.blurb))
        {
          paramqyd = paramqyd.blurb;
          break label152;
        }
        paramqyd = t(paramqwc.bS());
        break label152;
      }
      paramqyd = t(paramqwc.bS());
      break label152;
      label296:
      if (paramqwc.c().type == 3) {
        if (quc.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, acfp.m(2131706187), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, qyd paramqyd, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375130);
    auvk.traceBegin("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramqyd.get(2131375129);
    Object localObject1 = (ImageView)paramqyd.get(2131375131);
    paramqyd = (ImageView)paramqyd.get(2131375132);
    Object localObject2 = this.jdField_a_of_type_Qvt.bY();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      auvk.traceEnd();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130847385);
      paramqyd.setImageResource(2130847387);
      if (paramInt != 0) {
        break label165;
      }
      paramqyd = rpq.c(rpq.g(((qwa)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramqyd);
    }
    for (;;)
    {
      auvk.traceEnd();
      return;
      ((ImageView)localObject1).setImageResource(2130847384);
      paramqyd.setImageResource(2130847386);
      break;
      label165:
      paramqyd = (qwa)((List)localObject2).get(paramInt - 1);
      localObject2 = (qwa)((List)localObject2).get(paramInt);
      localObject1 = rpq.g(paramqyd.a().date);
      localObject2 = rpq.g(((qwa)localObject2).a().date);
      if (((paramqyd instanceof qvx)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramqyd = rpq.c((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramqyd);
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
    if (this.mFeedType == 10)
    {
      j = 74;
      if (paramCommentLikeFeedItem.getOwner().getRelationType() == 2) {}
      paramString = null;
      if (this.mFeedType != 10) {
        break label95;
      }
      paramString = new HomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = new OpenPlayerBuilder(paramString, j);
        paramString.a(mF());
        qgg.a(this.y, paramString.b());
      }
      return;
      j = 76;
      break;
      label95:
      if (this.mFeedType == 11) {
        paramString = new TroopAssistantHomeFeedPlayInfo(paramCommentLikeFeedItem.feedId, true);
      } else if (this.mFeedType == 12) {
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
      sl(paramVideoListFeedItem.feedId);
      paramView = (pma)qem.getQQAppInterface().getBusinessHandler(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.b(paramInt, paramQQUserUIItem.uid, k, 10);
      rar.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (rpq.isFastDoubleClick()) {
      return;
    }
    int j;
    if (this.mFeedType == 10)
    {
      j = 74;
      if (!(paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
        break label177;
      }
      paramVideoListFeedItem = (HotRecommendFeedItem)paramVideoListFeedItem;
      paramVideoListFeedItem = new OpenPlayerBuilder(new HotRecommendFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mAttachedFeedId, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType), j);
      paramVideoListFeedItem.a(false).b(true);
      paramVideoListFeedItem.a(mF());
      if (!(paramView instanceof QQStoryAutoPlayView)) {
        break label159;
      }
      qgg.a((FragmentActivity)this.y, paramVideoListFeedItem.b(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      rar.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      qgg.a((FragmentActivity)this.y, paramVideoListFeedItem.b(), paramView);
    }
    label177:
    Object localObject = null;
    String str;
    if (this.mFeedType == 10)
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
        ((OpenPlayerBuilder)localObject).a(mF());
        localObject = ((OpenPlayerBuilder)localObject).b();
        if (74 == j) {
          ((OpenPlayerBuilder.Data)localObject).mUIStyle.bottomWidgetShowFlag = 3;
        }
        if ((paramView instanceof QQStoryAutoPlayView)) {
          qgg.a((FragmentActivity)this.y, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = rar.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        rar.a("home_page", "clk_card", rar.a(paramVideoListFeedItem), qtc.b(paramStoryVideoItem), new String[] { String.valueOf(paramInt), rar.bX(this.mFeedType), paramVideoListFeedItem.feedId, paramView });
        return;
        if (this.mFeedType == 11)
        {
          localObject = new TroopAssistantHomeFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
          break;
        }
        if (this.mFeedType != 12) {
          break;
        }
        localObject = new ProfileFeedPlayInfo(paramVideoListFeedItem.feedId, paramStoryVideoItem.mVid);
        break;
        qgg.a((FragmentActivity)this.y, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(pqj parampqj, View paramView, String paramString)
  {
    boolean bool = true;
    if ((parampqj.mw != null) && (parampqj.mw.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Qye.a();
      paramView.setFeedItemData(parampqj.a, this.mFeedType, sY(), bool);
      paramView.a(parampqj, null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(pqj parampqj, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((parampqj.mw != null) && (parampqj.mw.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Qye.a();
      paramViewGroup.setFeedItemData(parampqj.a, this.mFeedType, sY(), bool);
      paramViewGroup.a(parampqj, paramCommentEntry);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(pyc.a parama)
  {
    if ((((Integer)((psr)psx.a(10)).c("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (parama.mVideoList != null)) {}
    wH(0);
  }
  
  protected void a(qvj paramqvj, qyd paramqyd)
  {
    paramqvj = (VideoListLayout)paramqyd.get(2131375156);
    if (paramqvj != null)
    {
      paramqvj = paramqvj.h();
      if (paramqvj != null) {
        paramqvj.setVisibility(8);
      }
    }
  }
  
  public void a(qvq paramqvq)
  {
    boolean bool1 = true;
    ram.w("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramqvq == null) {
      notifyDataSetChanged(false);
    }
    do
    {
      return;
      if (paramqvq.b == null)
      {
        rom.fail("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramqvq, new Object[0]);
        notifyDataSetChanged(false);
        return;
      }
      ram.w("Q.qqstory.home:FeedSegment", paramqvq.b.toString());
      if (!paramqvq.b.isFail()) {
        break;
      }
      notifyDataSetChanged(false);
      if ((this.ayG != null) && (this.ayH != null))
      {
        q(this.ayG, this.ayH, false);
        this.ayG = null;
        this.ayH = null;
      }
      this.aX.set(true);
      B(paramqvq.or, 0);
    } while (paramqvq.aCu);
    SegmentList localSegmentList = a();
    String str = getKey();
    boolean bool2 = paramqvq.b.isSuccess();
    if (!paramqvq.isEnd) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      notifyDataSetChanged(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(qvz paramqvz, qyd paramqyd)
  {
    paramqvz = (VideoListLayout)paramqyd.get(2131375156);
    if (paramqvz != null)
    {
      paramqvz = paramqvz.h();
      if (paramqvz != null) {
        paramqvz.setVisibility(8);
      }
    }
  }
  
  protected void a(qyd paramqyd, qwb paramqwb)
  {
    TextView localTextView1 = (TextView)paramqyd.get(2131375265);
    TextView localTextView2 = (TextView)paramqyd.get(2131375264);
    TextView localTextView3 = (TextView)paramqyd.get(2131375267);
    rmw localrmw = ((TagFeedItem)paramqwb.c()).tagItem;
    paramqyd = (TextView)paramqyd.get(2131375262);
    if (QQStoryContext.isNightMode())
    {
      localTextView3.setTextColor(this.context.getResources().getColor(2131166763));
      paramqyd.setBackgroundResource(2130847411);
    }
    if (localrmw != null)
    {
      localTextView1.setText(localrmw.a.name);
      if (TextUtils.isEmpty(((TagFeedItem)paramqwb.c()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramqwb.c()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramqwb.c()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramqwb.c()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(qyk.g paramg)
  {
    wH(0);
  }
  
  public View aw()
  {
    int j = 0;
    while (j < this.jdField_a_of_type_Qvt.bY().size())
    {
      localObject1 = (qwa)this.jdField_a_of_type_Qvt.bY().get(j);
      if ((((qwa)localObject1).a().type != 1) && (((qwa)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((qyd)localObject1).get(2131375156);
      if (localObject2 != null) {
        break;
      }
      ram.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).b().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131375154);
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { acfp.m(2131706171), ((QQStoryAutoPlayView)localObject1).b().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if ((paramVideoListFeedItem instanceof HotRecommendFeedItem)) {
      a((HotRecommendFeedItem)paramVideoListFeedItem, paramStoryVideoItem);
    }
  }
  
  protected void bqO()
  {
    this.jdField_a_of_type_Qvt.refreshData(true);
    this.Ln = eK(ab(this.context));
    bqW();
  }
  
  public void bqW()
  {
    a().setOnLoadMoreListener(getKey(), new qyl(this));
    SegmentList localSegmentList = a();
    String str = getKey();
    if (!isEnd()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  public void bqo()
  {
    this.jdField_b_of_type_Qwa = null;
    if (this.aGf)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Qvt.bY()).iterator();
      while (localIterator.hasNext())
      {
        qwa localqwa = (qwa)localIterator.next();
        if (((localqwa instanceof qvz)) && (localqwa.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localqwa.a().getOwner()).isPublic()) && (this.jdField_b_of_type_Qwa == null))
        {
          this.jdField_b_of_type_Qwa = localqwa;
          ram.b("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_b_of_type_Qwa.toString());
          return;
        }
      }
      ram.d("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.ot.clear();
  }
  
  public void brL()
  {
    Iterator localIterator = this.ot.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (qyd)localIterator.next();
      ram.d("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (pqn)((qyd)localObject).l("commentLikeLego");
      if (localObject != null) {
        ((pqn)localObject).bmp();
      }
    }
  }
  
  public void brM()
  {
    this.gd.clear();
  }
  
  public void brN()
  {
    wH(0);
    ram.d("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    brO();
    this.aGg = false;
  }
  
  public void brP()
  {
    String str1 = (String)((psr)psx.a(10)).c("mainHallConfig", "");
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
        ram.w("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        ram.w("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.y, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.y.startActivity(localIntent);
  }
  
  public void brh()
  {
    ram.d("Q.qqstory.home:FeedSegment", "tag list update");
    notifyDataSetChanged(true);
  }
  
  protected qyd c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561845, paramViewGroup, false));
    paramViewGroup.getItemView().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.get(2131375137);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    c(paramViewGroup);
    return paramViewGroup;
  }
  
  public void c(qwc paramqwc)
  {
    ram.b("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramqwc);
    if ((paramqwc == null) || (paramqwc.c() == null) || (paramqwc.c().feedId == null))
    {
      ram.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    sl(paramqwc.c().feedId);
  }
  
  protected void c(qyd paramqyd)
  {
    Object localObject = (VideoListLayout)paramqyd.get(2131375156);
    ((VideoListLayout)localObject).B().setOnClickListener(paramqyd);
    ((VideoListLayout)localObject).h().setOnClickListener(paramqyd);
    localObject = ((VideoListLayout)localObject).a();
    qyk.j localj = new qyk.j();
    paramqyd.q("general_touch_handler", localj);
    paramqyd.q("general_adapter", null);
    paramqyd.b(this.e);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localj);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localj);
    paramqyd.q("type", "GeneralView");
  }
  
  protected void d(qyd paramqyd)
  {
    ((VideoListLayout)paramqyd.get(2131375156)).h().setVisibility(8);
  }
  
  public void e(qyd paramqyd)
  {
    auvk.traceBegin("FeedSegment.onMovedToScrapHeap");
    this.ot.remove(paramqyd);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramqyd.get(2131375156);
    if (localVideoListLayout == null)
    {
      auvk.traceEnd();
      return;
    }
    paramqyd = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramqyd != null) && (paramqyd.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramqyd != null) && (paramqyd.b() != null)) {
        ram.d("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramqyd.b().getThumbUrl());
      }
      if (paramqyd != null) {
        paramqyd.release();
      }
      auvk.traceEnd();
      return;
      paramqyd = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramqyd = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramqyd = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramqyd = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131375154);
          }
        }
      }
    }
  }
  
  public void f(qyd paramqyd)
  {
    this.ot.add(paramqyd);
  }
  
  public void g(qvq paramqvq)
  {
    notifyDataSetChanged(true);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Qvt.bY().size();
  }
  
  public String getKey()
  {
    return "FeedSegment";
  }
  
  protected int getViewTypeCount()
  {
    return 4;
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
      paramMessage = (qvq)paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.b.isFail()))
      {
        notifyDataSetChanged(false);
        return true;
      }
      g(paramMessage);
      return true;
    case 2: 
      notifyDataSetChanged(true);
      return true;
    case 11: 
      arrayOfInt1 = new int[2];
      j = rpq.getWindowScreenHeight(this.context);
      localObject = this.jdField_a_of_type_Qye.a();
      ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
      str = (String)paramMessage.obj;
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11, str), 50L);
        return true;
      }
      arrayOfInt2 = new int[2];
      a().getLocationOnScreen(arrayOfInt2);
      Iterator localIterator = this.ot.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMessage = (qyd)localIterator.next();
      } while (!str.equals((String)paramMessage.l("feed_id")));
    }
    for (;;)
    {
      if (paramMessage != null)
      {
        j = paramMessage.bov;
        int k = paramMessage.getItemView().getBottom();
        int m = paramMessage.getItemView().getTop();
        int n = arrayOfInt2[1];
        ((StoryInputBarView)localObject).getLocationOnScreen(arrayOfInt1);
        a().setSelectionFromTop(j, arrayOfInt1[1] - (k - m + n));
        return true;
      }
      rom.assertTrue(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = rpq.getWindowScreenHeight(this.context);
      this.jdField_a_of_type_Qye.a().getLocationOnScreen(arrayOfInt1);
      if (arrayOfInt1[1] > j * 4 / 5)
      {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, paramMessage), 50L);
        return true;
      }
      localObject = new int[2];
      paramMessage.getLocationOnScreen((int[])localObject);
      j = localObject[1];
      j = paramMessage.getBottom() - paramMessage.getTop() + j - arrayOfInt1[1];
      a().smoothScrollBy(j, j * 2 / 3);
      return true;
      if (QQStoryTakeVideoCloseAnimationActivity.aHw)
      {
        ram.d("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
        paramMessage = (Rect)paramMessage.obj;
        ThreadManager.getSubThreadHandler().post(new FeedSegment.9(this, paramMessage));
        return true;
      }
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(13, paramMessage.obj), 50L);
      return true;
      paramMessage = null;
    }
  }
  
  public boolean isEnd()
  {
    return this.jdField_a_of_type_Qvt.isEnd();
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  public int l(View paramView)
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.ot != null) && (!this.ot.isEmpty()))
    {
      Iterator localIterator = this.ot.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (qyd)localIterator.next();
        if (localObject != null)
        {
          localObject = (pqn)((qyd)localObject).l("commentLikeLego");
          if (localObject != null) {
            ((pqn)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$h);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$d);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$c);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$i);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qyk$f);
    this.mHandler.removeCallbacksAndMessages(null);
    this.aDA = false;
    if (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.release();
    }
    this.jdField_a_of_type_Qwn.release();
    Iterator localIterator = this.ot.iterator();
    while (localIterator.hasNext())
    {
      pqn localpqn = (pqn)((qyd)localIterator.next()).l("commentLikeLego");
      if (localpqn != null) {
        localpqn.onDestory();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_d_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Qvt.destroy();
    pre.destory();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.aX.set(true);
    if (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.pausePlay();
    }
    if ((this.Ln) && (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Qwn.wF(2);
      this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.bro();
      this.jdField_a_of_type_Qwn.wF(0);
    }
    AbstractGifImage.pauseAll();
    this.aEJ = false;
    this.jdField_a_of_type_Qvt.pause();
    this.jdField_a_of_type_Qvt.brg();
    this.aEJ = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    QQStoryContext.a();
    this.isNightMode = ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null);
    this.Ln = eK(ab(this.context));
    wH(0);
    AbstractGifImage.resumeAll();
  }
  
  public void q(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Qvt.bY().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localqwa = (qwa)localIterator.next();
      if (paramString1.equals(localqwa.a().feedId))
      {
        this.ayG = null;
        this.ayH = null;
        ws(j);
        a(j, localqwa, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      qwa localqwa;
      return;
      j += 1;
      break;
    }
    this.ayG = paramString1;
    this.ayH = paramString2;
    KB();
  }
  
  public int sY()
  {
    int j = 20002;
    if (this.mFeedType == 11) {
      j = 30000;
    }
    do
    {
      return j;
      if (this.mFeedType == 12) {
        return 20004;
      }
    } while (!(this.y instanceof SplashActivity));
    return 20002;
  }
  
  public void setDisplay(boolean paramBoolean)
  {
    super.setDisplay(paramBoolean);
    if (this.isDisplay) {
      bqW();
    }
  }
  
  public void sg(String paramString)
  {
    ram.d("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.aGg = true;
    notifyDataSetChanged(true);
  }
  
  public void sh(String paramString)
  {
    this.aX.set(true);
    ram.d("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    notifyDataSetChanged(true);
  }
  
  public void sm(@NonNull String paramString)
  {
    if (ppg.ID()) {
      return;
    }
    this.aGh = true;
    Object localObject = aw();
    Rect localRect = new Rect();
    if (localObject != null) {
      ((View)localObject).getGlobalVisibleRect(localRect);
    }
    for (;;)
    {
      qwp.d("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.y, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.y.startActivity((Intent)localObject);
      this.y.overridePendingTransition(0, 0);
      paramString = (qzh)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.setOpen(false);
      }
      a().setSelection(0);
      return;
      ram.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void wF(int paramInt)
  {
    if (this.jdField_a_of_type_Qwn == null) {
      return;
    }
    this.jdField_a_of_type_Qwn.wF(paramInt);
  }
  
  public void wG(int paramInt)
  {
    wI(paramInt);
  }
  
  public void wH(int paramInt)
  {
    auvk.traceBegin("fetchViewWhichNeedPlay");
    if ((!this.Ln) || (!this.jdField_a_of_type_Qye.Kh()) || (this.mFeedType != 10))
    {
      auvk.traceEnd();
      ram.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.Ln + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Qye.Kh());
      return;
    }
    ram.w("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
    Iterator localIterator = this.ot.iterator();
    label536:
    label553:
    label557:
    for (;;)
    {
      Object localObject;
      QQStoryAutoPlayView localQQStoryAutoPlayView;
      if (localIterator.hasNext())
      {
        localObject = (VideoListLayout)((qyd)localIterator.next()).get(2131375156);
        if (localObject == null) {
          continue;
        }
        localQQStoryAutoPlayView = ((VideoListLayout)localObject).a();
        localObject = ((VideoListLayout)localObject).a();
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.getVisibility() != 0)) {}
      }
      for (;;)
      {
        if ((localQQStoryAutoPlayView == null) || (localQQStoryAutoPlayView.b() == null)) {
          break label557;
        }
        ram.d("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.b().getThumbUrl());
        if (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131375154);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = qwq.i(this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = qwq.i(localQQStoryAutoPlayView);
          label326:
          if ((G(localQQStoryAutoPlayView)) && (k >= j)) {
            if (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != localQQStoryAutoPlayView)
            {
              this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.pausePlay();
              this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
            }
          }
          break;
        }
        for (;;)
        {
          ram.d("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = qwq.k(this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = qwq.k(localQQStoryAutoPlayView);
          break label326;
          k = qwq.j(this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = qwq.j(localQQStoryAutoPlayView);
          break label326;
          ram.d("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.pausePlay();
        }
        if (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          ram.d("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.sU() + ",url=" + this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b().getThumbUrl());
          if ((this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) && (this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.sU() == 0))
          {
            if (!this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.isPause()) {
              break label536;
            }
            this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.resumePlay();
          }
        }
        for (;;)
        {
          auvk.traceEnd();
          return;
          ram.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_d_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.eK(this.jdField_a_of_type_Qvt.bY());
        }
        localQQStoryAutoPlayView = null;
      }
    }
  }
  
  public static class a
    extends QQUIEventReceiver<qyk, psf>
  {
    public a(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull psf parampsf)
    {
      if (parampsf.aBt) {
        qyk.d(paramqyk);
      }
    }
    
    public Class acceptEventClass()
    {
      return psf.class;
    }
  }
  
  public static class b
    implements Dispatcher.Event
  {
    public float bottom;
    public float left;
    public float right;
    public float top;
    
    public b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.bottom = paramFloat4;
      this.left = paramFloat2;
      this.right = paramFloat3;
      this.top = paramFloat1;
    }
  }
  
  public static class c
    extends QQUIEventReceiver<qyk, pxs.b>
  {
    public c(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull pxs.b paramb)
    {
      paramqyk.brL();
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public static class d
    extends QQUIEventReceiver<qyk, pyc.a>
  {
    public d(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull pyc.a parama)
    {
      if ((parama.b.isFail()) || (parama.mVideoList == null)) {
        return;
      }
      paramqyk.a(parama);
    }
    
    public Class acceptEventClass()
    {
      return pyc.a.class;
    }
  }
  
  public static abstract interface e
  {
    public abstract void b(String paramString, CommentEntry paramCommentEntry);
    
    public abstract void bqJ();
    
    public abstract void bqK();
    
    public abstract void bqL();
    
    public abstract void bqM();
  }
  
  public static class f
    extends QQUIEventReceiver<qyk, qiy>
  {
    public f(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull qiy paramqiy)
    {
      ram.b(this.TAG, "play video groupId=%s, %s", paramqiy.a, paramqiy.vid);
      if ((qyk.a(paramqyk).equals(paramqiy.axu)) && ((paramqiy.a instanceof qgr.a)))
      {
        qvd localqvd = ((qgr.a)paramqiy.a).a;
        if (localqvd != null) {
          paramqyk.q(localqvd.mFeedId, paramqiy.vid, true);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return qiy.class;
    }
  }
  
  public static class g
    extends plt
  {
    public String vid;
  }
  
  public static class h
    extends QQUIEventReceiver<qyk, qyk.g>
  {
    public h(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull qyk.g paramg)
    {
      paramqyk.a(paramg);
    }
    
    public Class acceptEventClass()
    {
      return qyk.g.class;
    }
  }
  
  public static class i
    extends QQUIEventReceiver<qyk, ptc.a>
  {
    public i(@NonNull qyk paramqyk)
    {
      super();
    }
    
    public void a(@NonNull qyk paramqyk, @NonNull ptc.a parama)
    {
      paramqyk.brL();
    }
    
    public Class acceptEventClass()
    {
      return ptc.a.class;
    }
  }
  
  public class j
    implements StoryHomeHorizontalListView.a, StoryHomeHorizontalListView.b, HorizontalListView.d, rsn.a
  {
    private qyd d;
    private int position = -1;
    
    protected j() {}
    
    public boolean R(boolean paramBoolean)
    {
      if (this.position == -1)
      {
        rom.fail(acfp.m(2131706189), new Object[0]);
        return false;
      }
      for (;;)
      {
        try
        {
          qwc localqwc = (qwc)qyk.this.a.bY().get(this.position);
          int i = rar.a(localqwc.c());
          if (localqwc.c().getOwner().isMe())
          {
            String str1 = "1";
            if (qyk.this.mFeedType == 10)
            {
              str3 = "1";
              rar.a("home_page", "left_load", i, 0, new String[] { str1, str3, "", localqwc.c().feedId });
              return qyk.this.a.a(localqwc);
            }
            String str3 = "3";
            continue;
          }
          String str2 = "2";
        }
        catch (Exception localException)
        {
          ram.e("Q.qqstory.home:FeedSegment", "onLoadMore occur error:" + localException);
          rom.fail(localException.getMessage(), new Object[0]);
          return false;
        }
      }
    }
    
    public void aXi()
    {
      if (this.position == -1) {
        rom.fail(acfp.m(2131706200), new Object[0]);
      }
    }
    
    public void b(int paramInt, qyd paramqyd)
    {
      this.position = paramInt;
      this.d = paramqyd;
    }
    
    public void bqs()
    {
      if (this.position == -1) {
        rom.fail(acfp.m(2131706178), new Object[0]);
      }
      while (qyk.this.mFeedType == 12) {
        return;
      }
      qwa localqwa = (qwa)qyk.this.a.bY().get(this.position);
      qyk.a(qyk.this, localqwa);
    }
    
    public void bqt() {}
    
    public void dh(int paramInt1, int paramInt2)
    {
      if (this.position == -1)
      {
        rom.fail(acfp.m(2131706180), new Object[0]);
        return;
      }
      qwa localqwa = (qwa)qyk.this.a.bY().get(this.position);
      if ((localqwa.a() != null) && (!TextUtils.isEmpty(localqwa.a().feedId)))
      {
        qyk.this.gd.put(localqwa.a().feedId, Integer.valueOf(paramInt2));
        ram.b("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", localqwa.a().feedId, Integer.valueOf(paramInt2));
        return;
      }
      rom.fail(acfp.m(2131706201), new Object[0]);
      ram.e("Q.qqstory.home:FeedSegment", "feed item is not refreshFinish when onScrollChange");
    }
    
    public void onScrollStateChanged(int paramInt)
    {
      int j = 0;
      if (this.position == -1)
      {
        rom.fail(acfp.m(2131706195), new Object[0]);
        break label22;
      }
      label22:
      label93:
      label362:
      label363:
      for (;;)
      {
        return;
        if (qyk.c(qyk.this))
        {
          StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)this.d.get(2131375146);
          qwa localqwa;
          Object localObject;
          if (qyk.this.a.bY().size() > this.position)
          {
            localqwa = (qwa)qyk.this.a.bY().get(this.position);
            if ((localqwa != null) && ((paramInt == 4097) || (paramInt == 4098)))
            {
              int k = localStoryHomeHorizontalListView.getFirstVisiblePosition();
              int i = k;
              if (k < 0) {
                i = 0;
              }
              ram.b("Q.qqstory.home:FeedSegment", "onScrollChange, state=%d, leftPosition=%d", Integer.valueOf(paramInt), Integer.valueOf(i));
              localObject = new ArrayList();
              ((List)localObject).add(localqwa);
              qyk.a(qyk.this, (List)localObject, i);
              qyk.b(qyk.this, (List)localObject, i);
            }
            localObject = (qtc)this.d.l("general_adapter");
            if (paramInt != 4097) {
              break label327;
            }
            paramInt = qyk.a(qyk.this);
            qyk.this.wH(paramInt);
            if ((localStoryHomeHorizontalListView == null) || (localObject == null) || (localqwa == null)) {
              break;
            }
            paramInt = localStoryHomeHorizontalListView.getFirstVisiblePosition();
            if (paramInt >= 0) {
              break label362;
            }
            paramInt = j;
          }
          for (;;)
          {
            if (((qtc)localObject).la.isEmpty()) {
              break label363;
            }
            qyk.a(qyk.this).gb.put("1_" + localqwa.a().feedId, ((StoryVideoItem)((qtc)localObject).la.get(paramInt)).mVid);
            return;
            localqwa = null;
            break label93;
            if ((qyk.a(qyk.this) == null) || (qyk.a(qyk.this).sR() != 1)) {
              break;
            }
            qyk.a(qyk.this).pausePlay();
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qyk
 * JD-Core Version:    0.7.0.1
 */