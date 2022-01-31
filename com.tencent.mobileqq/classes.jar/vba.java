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

public class vba
  extends wco<uwm>
  implements Handler.Callback, IEventReceiver, szo, tad, uwz, uyh, vaz
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new anoz(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new anoz(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new vbc(this);
  public String a;
  private List<vap> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private tdl jdField_a_of_type_Tdl;
  private uvx jdField_a_of_type_Uvx;
  protected uwq a;
  private uxm jdField_a_of_type_Uxm;
  protected uye a;
  uyi jdField_a_of_type_Uyi = new vbk(this);
  private vaq jdField_a_of_type_Vaq;
  private vbq jdField_a_of_type_Vbq;
  private vbs jdField_a_of_type_Vbs;
  private vbt jdField_a_of_type_Vbt;
  private vbv jdField_a_of_type_Vbv;
  private vbx jdField_a_of_type_Vbx;
  private vby jdField_a_of_type_Vby;
  private final int jdField_b_of_type_Int;
  public String b;
  uyi jdField_b_of_type_Uyi = new vbl(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  uyi jdField_c_of_type_Uyi = new vbm(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  uyi jdField_d_of_type_Uyi = new vbn(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public vba(Context paramContext, Activity paramActivity, int paramInt, vaq paramvaq, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Vaq = paramvaq;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Uwq = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vbx = new vbx(this);
    this.jdField_a_of_type_Vbt = new vbt(this);
    this.jdField_a_of_type_Vbs = new vbs(this);
    this.jdField_a_of_type_Vby = new vby(this);
    this.jdField_a_of_type_Vbq = new vbq(this);
    this.jdField_a_of_type_Vbv = new vbv(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vbx);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vbt);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vbs);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vby);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vbq);
    stb.a().registerSubscriber(this.jdField_a_of_type_Vbv);
    this.jdField_a_of_type_Uye = new uye(Looper.myLooper());
    this.jdField_a_of_type_Uwq.a();
    this.jdField_a_of_type_Tdl = ((tdl)tcz.a(2));
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Uye.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298319);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298330);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Uye.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Uye.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bbfj.h(paramContext)) {
      return 1;
    }
    if (bbfj.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, vap paramvap, ViewGroup paramViewGroup, uwg paramuwg)
  {
    paramViewGroup = (ImageView)paramvap.a(2131373241);
    FrameLayout localFrameLayout = (FrameLayout)paramvap.a(2131373245);
    b(paramvap);
    a(paramInt, paramvap, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvap, paramuwg, paramuwg.a().getOwner());
    a(paramvap, paramuwg, true);
    a(paramuwg, paramvap);
    a(paramInt, paramvap);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvap.a("feed_id", paramuwg.a().feedId);
    a(paramuwg, paramvap, localFrameLayout, null);
    if (!paramuwg.jdField_b_of_type_Boolean) {
      vei.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramuwg.a().getOwner().getUnionId(), paramuwg.a().feedId });
    }
    paramViewGroup = paramuwg.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      vei.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramvap.a();
  }
  
  private View a(int paramInt, vap paramvap, ViewGroup paramViewGroup, uxi paramuxi)
  {
    paramViewGroup = (VideoListLayout)paramvap.a(2131373274);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(vzl.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((vbz)paramvap.a("general_touch_handler")).a(paramvap.jdField_b_of_type_Int, paramvap);
    if ((paramuxi.a() == null) || (paramuxi.a().size() == 0))
    {
      ved.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramuxi.a()).feedId);
      paramvap.a.setVisibility(8);
      return paramvap.a();
    }
    paramvap.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (vax)paramvap.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new vax(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramvap.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Uye);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramuxi.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        ved.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramuxi.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramuxi.a().size();
        paramViewGroup.a(paramuxi.a(), paramuxi.a());
        if (((HotRecommendFeedItem)paramuxi.a()).mIsVideoEnd) {
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
        paramViewGroup = paramvap.a(2131378254);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((tcs)tcz.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        vei.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, vap paramvap, ViewGroup paramViewGroup, uxn paramuxn)
  {
    paramViewGroup = (ImageView)paramvap.a(2131373241);
    a(paramInt, paramvap, this.jdField_d_of_type_Boolean);
    a(paramvap, paramuxn);
    a(paramInt, paramvap);
    a(paramvap, paramuxn, true);
    a(null, paramvap);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    vei.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramuxn.a()).feedId });
    return paramvap.a();
  }
  
  private View a(int paramInt, vap paramvap, uvg paramuvg)
  {
    Object localObject = (QQStoryOwnerInfoView)paramvap.a(2131373255);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramvap.a(2131373226);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramvap.a(2131373218);
    FrameLayout localFrameLayout = (FrameLayout)paramvap.a(2131373220);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramuvg.a();
    a(paramInt, paramvap, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, ajya.a(2131704462), true);
    if (uty.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      vzl.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bbef.a(1), "QQStory_main");
      a(paramInt, paramvap);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramuvg.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext) - vzl.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (szy)paramvap.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new szy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuvg, this.jdField_a_of_type_Int);
      ((szy)localObject).a(paramuvg);
      ((szy)localObject).l();
      paramvap.a("commentLikeLego", localObject);
      localFrameLayout.addView(((szy)localObject).b);
    }
    for (;;)
    {
      ((szy)localObject).a(this);
      ((szy)localObject).a(this);
      ((szy)localObject).a(false);
      if (!paramuvg.jdField_b_of_type_Boolean) {
        vei.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramuvg.a()).getOwner().getUnionId(), ((BannerFeedItem)paramuvg.a()).feedId });
      }
      return paramvap.a();
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
      ((szy)localObject).a(paramuvg, null, paramuvg);
      ((szy)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      ved.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = vzl.a() / 3600;
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
        return uyk.a(j, true);
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
  
  private void a(int paramInt, uxm paramuxm, String paramString, boolean paramBoolean)
  {
    if (!(paramuxm instanceof uxo)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        ved.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramuxm, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((vap)localObject1).a(2131373274);
        List localList = ((uxo)paramuxm).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            ved.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= vzl.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramuxm.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (usb)((vap)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((usb)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            ved.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramuxm.a().feedId, Integer.valueOf(j));
            ved.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, vap paramvap, uxo paramuxo, ShareGroupItem paramShareGroupItem)
  {
    bfwu.a("FeedSegment.bindFeedShareGroupInfo");
    paramvap = (QQStoryOwnerInfoView)paramvap.a(2131373255);
    if (paramShareGroupItem == null)
    {
      paramvap.setSubTitle(null);
      paramvap.setBadge(null);
      paramvap.setQIMIcon(null);
      paramvap.setSubTitleSuffix(null);
      paramvap.setButtonTxt(null);
      paramvap.setName(tsr.jdField_b_of_type_JavaLangString);
      paramvap.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845534));
      bfwu.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bbef.a();
      paramvap.setAvatar(bayh.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramvap.setName(paramShareGroupItem.getName());
      if (paramuxo.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((uxl)paramuxo).a(), paramuxo.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramvap.setSubTitle((String)localObject1);
        paramvap.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramvap.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845899);
      label199:
      if (paramuxo.a().type == 2)
      {
        if (!paramuxo.a()) {
          break label328;
        }
        a(paramvap, ajya.a(2131704469), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramvap = paramvap.a();
      paramvap.a(null);
      paramvap.setVisibility(8);
      bfwu.a();
      return;
      paramvap.setAvatar(((uks)tcz.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130845901);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845900);
      break label199;
      label328:
      a(paramvap, null, false);
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
    bfwu.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        ved.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = vea.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        ved.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!uyk.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = vea.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      bfwu.a();
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
      ved.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = vzi.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = vzi.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    localbfpc.a(ajya.a(2131704464), 5);
    QQUserUIItem localQQUserUIItem = ((tdl)tcz.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = ajya.a(2131704465);; str = ajya.a(2131704457))
    {
      localbfpc.a(str, 5);
      localbfpc.a(ajya.a(2131704482), 5);
      localbfpc.c(2131690596);
      localbfpc.a(new vbf(this, localbfpc, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbfpc.a(new vbi(this));
      if (!localbfpc.isShowing()) {
        localbfpc.show();
      }
      vei.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130845710);
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
        uyj.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      uyj.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      vzl.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = vzl.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130845638);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166348));
        localButton.setBackgroundResource(2130845638);
      }
      j = vzl.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vzl.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130845637);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166335));
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
    paramString.setDecodeHandler(vzl.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<uxm> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((tcs)tcz.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((uxm)paramList.next()).d();
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
      ved.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Uye.a(localArrayList);
      return;
    }
  }
  
  private void a(uxm paramuxm)
  {
    if ((paramuxm == null) || (paramuxm.a() == null) || (paramuxm.a().getOwner() == null)) {
      vxp.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramuxm instanceof uwf))
      {
        paramuxm = ((uwf)paramuxm).a().getOwner();
        sxm.a(this.jdField_a_of_type_AndroidContentContext, 4, paramuxm.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramuxm instanceof uxl))
      {
        paramuxm = (ShareGroupFeedItem)((uxl)paramuxm).a();
        localObject = paramuxm.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          ved.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          vxp.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramuxm.getOwner().getRelationType() == 2)
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
      if ((paramuxm instanceof uwg))
      {
        paramuxm = ((uwg)paramuxm).a();
        localObject = paramuxm.getOwner();
        if (paramuxm.getOwner().getRelationType() == 2)
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
        sxm.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramuxm instanceof uxn))
      {
        paramuxm = (TagFeedItem)((uxn)paramuxm).a();
        tti.a(this.jdField_a_of_type_AndroidAppActivity, paramuxm.tagItem.a);
        return;
      }
    } while (!(paramuxm instanceof uxi));
    label289:
    l();
    vei.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(uxm paramuxm, ShareGroupItem paramShareGroupItem)
  {
    if (uke.a(paramShareGroupItem))
    {
      if (paramuxm.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        vei.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajya.a(2131704481), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new ukf((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    vei.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(uxm paramuxm, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramuxm.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      vei.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramuxm.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(uxo paramuxo, vap paramvap) {}
  
  private void a(uxo paramuxo, vap paramvap, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    bfwu.a("FeedSegment.bindCommentLike");
    szy localszy;
    if (paramuxo.a().size() > 0)
    {
      localszy = (szy)paramvap.a("commentLikeLego");
      if (localszy != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localszy = szy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuxo, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramvap.a("commentLikeLego", localszy);
      paramFrameLayout.addView(localszy.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localszy.k();
        paramuxo = paramFrameLayout.getLayoutParams();
        paramuxo.height = vzl.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramuxo);
      }
      for (;;)
      {
        bfwu.a();
        return;
        label132:
        localszy = new szy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuxo, this.jdField_a_of_type_Int);
        break;
        paramvap = paramFrameLayout.getLayoutParams();
        paramvap.height = -2;
        paramFrameLayout.setLayoutParams(paramvap);
        if (localszy.a())
        {
          localszy.a(paramuxo, paramShareGroupItem, null);
          localszy.c(null);
        }
        for (;;)
        {
          localszy.a(this);
          localszy.a(this);
          if ((paramuxo.a().mVideoPullType != 0) || (paramuxo.a().size() <= 1)) {
            break label249;
          }
          localszy.a(true);
          break;
          localszy.l();
        }
        label249:
        localszy.a(false);
      }
    }
  }
  
  private void a(vap paramvap, uxo paramuxo, boolean paramBoolean)
  {
    bfwu.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramvap.a(2131373274);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(vzl.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((vbz)paramvap.a("general_touch_handler")).a(paramvap.jdField_b_of_type_Int, paramvap);
    if ((paramuxo.a() == null) || (paramuxo.a().size() == 0))
    {
      ved.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramuxo.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      bfwu.a();
      return;
    }
    Object localObject1;
    if (paramuxo.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (usb)paramvap.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new usb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((usb)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramvap.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((usb)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((usb)localObject1).a(this.jdField_a_of_type_Uye);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramuxo.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          ved.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramuxo.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramuxo.a().size() != 2) {
          break label563;
        }
        j = (vzl.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((usb)localObject1).a(j, k);
        ((usb)localObject1).a(vzl.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramuxo.a().type != 6) {
          break label642;
        }
        j = k + vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298330));
        ((usb)localObject1).a(paramuxo.a(), paramuxo.a());
        if (sxn.a())
        {
          if ((!this.i) || (paramvap.jdField_b_of_type_Int != 0) || ((!paramuxo.b()) && (!paramuxo.a().isFakeFeedItem()))) {
            break label660;
          }
          ((usb)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramuxo.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = vzl.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (vzl.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = vzl.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = vzl.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = vzl.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + vzl.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((usb)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramuxo.a().size() == 1)
      {
        j = vzl.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(vzl.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramuxo.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramuxo.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Uye);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          svx.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((sxn.a()) && (this.i) && (paramvap.jdField_b_of_type_Int == 0) && ((paramuxo.b()) || (paramuxo.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166941));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(ajya.a(2131704476));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166941));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramuxo.a().type == 3) && ((paramuxo.a().getOwner() instanceof QQUserUIItem)))
          {
            paramvap = (QQUserUIItem)paramuxo.a().getOwner();
            if ((paramvap.isVip) && (!paramvap.isSubscribe())) {
              vei.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramuxo.a().type != 6) {
            break;
          }
          vei.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = svx.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            ved.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new vbo(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          svx.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(vzl.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramuxo.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramuxo.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(vzl.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramuxo.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Tep != null))
            {
              localStoryNickNameView.setFormat(ajya.a(2131704486));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Tep.jdField_a_of_type_JavaLangString);
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
    switch (((sst)tsr.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        ved.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Tep == null)) {
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
        paramList = ajya.a(2131704487);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = ajya.a(2131704474);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + ajya.a(2131704479);
        paramList = str1;
      }
    }
  }
  
  private void b(List<uxm> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((tcs)tcz.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((uxm)paramList.next()).d();
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
      ved.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new vbp(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Uwq.e();
    vei.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private vap c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561271, paramViewGroup, false));
    paramViewGroup.a(2131378254).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Uyi);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131373264);
    vbz localvbz = new vbz(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localvbz);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localvbz);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localvbz);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localvbz);
    paramViewGroup.a("general_touch_handler", localvbz);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private vap d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561377, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131373255);
    paramViewGroup.a(2131373256).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373254).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373385).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373380).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Uyi);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131373264);
    vbz localvbz = new vbz(this);
    paramViewGroup.a("general_touch_handler", localvbz);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localvbz);
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
    int k = vzl.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      ved.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private vap e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561199, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373255);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373218).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373226).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Uyi);
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
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    uxm localuxm = (uxm)this.jdField_a_of_type_Uwq.a().get(paramInt);
    localbfpc.a(ajya.a(2131704471), 5);
    localbfpc.c(2131690596);
    localbfpc.a(new vbd(this, localbfpc, paramInt, localuxm));
    localbfpc.a(new vbe(this, paramInt));
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
    a(localuxm, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!vym.a(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(tsr.a(), 1, ajya.a(2131704485), 0).a();
      return;
    }
    Object localObject = (uxm)this.jdField_a_of_type_Uwq.a().remove(paramInt);
    if (localObject == null)
    {
      vxp.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((uxm)localObject, "hide_done");
    String str = ((uxm)localObject).a().getOwner().getUnionId();
    long l;
    switch (((uxm)localObject).a().type)
    {
    case 4: 
    default: 
      vxp.a("feed not allow unLike operation type=" + ((uxm)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((uxm)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      vyd.a(str, paramInt, l);
      localObject = ((uxm)localObject).a().feedId;
      Bosses.get().postJob(new vbj(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((uxm)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((uxm)localObject).a()).recommendId;
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
    if (sxn.a()) {}
    do
    {
      return;
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajya.a(2131704472), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajya.a(2131704480), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajya.a(2131704473), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (vcp)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((vcp)localObject).a(false);
      }
      a().setSelection(0);
      return;
      ved.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void R_()
  {
    this.jdField_a_of_type_Uxm = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Uwq.a()).iterator();
      while (localIterator.hasNext())
      {
        uxm localuxm = (uxm)localIterator.next();
        if (((localuxm instanceof uxl)) && (localuxm.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localuxm.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Uxm == null))
        {
          this.jdField_a_of_type_Uxm = localuxm;
          ved.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Uxm.toString());
          return;
        }
      }
      ved.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void T_()
  {
    super.T_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Uye.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Uye.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Uwq.c();
    this.jdField_a_of_type_Uwq.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Uwq.a().size();
  }
  
  protected int a(int paramInt)
  {
    uxm localuxm = (uxm)this.jdField_a_of_type_Uwq.a().get(paramInt);
    if (localuxm.a().type == 1) {
      return 0;
    }
    if (localuxm.a().type == 3) {
      return 0;
    }
    if (localuxm.a().type == 2) {
      return 0;
    }
    if (localuxm.a().type == 5) {
      return 1;
    }
    if (localuxm.a().type == 6) {
      return 2;
    }
    if (localuxm.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Uwq.a().size())
    {
      localObject1 = (uxm)this.jdField_a_of_type_Uwq.a().get(j);
      if ((((uxm)localObject1).a().type != 1) && (((uxm)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((vap)localObject1).a(2131373274);
      if (localObject2 != null) {
        break;
      }
      ved.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131373272);
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajya.a(2131704459), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    uxm localuxm = (uxm)this.jdField_a_of_type_Uwq.a().get(paramInt);
    paramvap.a("feed_id", localuxm.a().feedId);
    View localView = paramvap.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localuxm.jdField_b_of_type_Boolean = true;
      d(paramvap);
      paramvap = new ArrayList();
      paramvap.add(localuxm);
      b(paramvap, 0);
      vei.b("story_home_dev", "feed_exp", localuxm.a().type, localuxm.d().size(), new String[] { localuxm.a().feedId });
      return localView;
      if (localuxm.a().type == 1)
      {
        localView = a(paramInt, paramvap, paramViewGroup, (uwf)localuxm);
      }
      else if (localuxm.a().type == 2)
      {
        localView = a(paramInt, paramvap, paramViewGroup, (uxl)localuxm);
      }
      else if (localuxm.a().type == 3)
      {
        localView = a(paramInt, paramvap, paramViewGroup, (uwg)localuxm);
        continue;
        localView = a(paramInt, paramvap, (uvg)localuxm);
        continue;
        localView = a(paramInt, paramvap, paramViewGroup, (uxn)localuxm);
        continue;
        localView = a(paramInt, paramvap, paramViewGroup, (uxi)localuxm);
      }
    }
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup, uwf paramuwf)
  {
    ved.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramvap.a(2131373241);
    FrameLayout localFrameLayout = (FrameLayout)paramvap.a(2131373245);
    a(paramuwf, paramvap);
    a(paramInt, paramvap, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvap, paramuwf, paramuwf.a().getOwner());
    a(paramvap, paramuwf, true);
    a(paramInt, paramvap);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvap.a("feed_id", paramuwf.a().feedId);
    a(paramuwf, paramvap);
    a(paramuwf, paramvap, localFrameLayout, null);
    return paramvap.a();
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup, uxl paramuxl)
  {
    ved.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramvap.a(2131373241);
    FrameLayout localFrameLayout = (FrameLayout)paramvap.a(2131373245);
    a(paramuxl, paramvap);
    a(paramInt, paramvap, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvap, paramuxl, ((ShareGroupFeedItem)paramuxl.a()).getOwner());
    a(paramvap, paramuxl, true);
    a(paramuxl, paramvap);
    a(paramInt, paramvap);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvap.a("feed_id", ((ShareGroupFeedItem)paramuxl.a()).feedId);
    paramvap.a("group_id", ((ShareGroupFeedItem)paramuxl.a()).getOwner().shareGroupId);
    a(paramuxl, paramvap, localFrameLayout, ((ShareGroupFeedItem)paramuxl.a()).getOwner());
    paramuxl.jdField_b_of_type_Boolean = true;
    return paramvap.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected uwq a(boolean paramBoolean)
  {
    return new uwq(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    bfwu.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      bfwu.a();
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
  
  protected vap a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uwq.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((uxm)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      vap localvap = a(j);
      if ((localvap != null) && (paramString.equals(localvap.a("feed_id")))) {
        return localvap;
      }
      if (localvap != null)
      {
        localObject = (uxm)((List)localObject).get(j);
        vxp.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localvap.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (vap)localIterator.next();
        if (localObject != null)
        {
          localObject = (szy)((vap)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((szy)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, vap paramvap)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373269);
    TextView localTextView = (TextView)paramvap.a(2131373270);
    ImageView localImageView = (ImageView)paramvap.a(2131373267);
    if (localRelativeLayout == null) {
      return;
    }
    if (sxn.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (uxm)this.jdField_a_of_type_Uwq.a().get(paramInt);
    switch (((uxm)localObject).a().type)
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
      localObject = (BannerFeedItem)((uxm)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        ved.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajya.a(2131704461);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramvap);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((uxm)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((uxm)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        ved.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajya.a(2131704467);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramvap);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((uxm)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      ved.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = ajya.a(2131704458);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramvap);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, vap paramvap, uxo paramuxo, QQUserUIItem paramQQUserUIItem)
  {
    bfwu.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramvap.a(2131373255);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(tsr.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845534));
      bfwu.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(vzl.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bbef.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramvap = "";
      if (paramuxo.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramvap);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramuxo.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramvap = localQQStoryOwnerInfoView.a();
      paramvap.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramuxo.jdField_b_of_type_Boolean) {
        paramvap.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      bfwu.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramuxo.a().type == 3)
      {
        paramvap = (GeneralRecommendFeedItem)paramuxo.a();
        if (!TextUtils.isEmpty(paramvap.blurb))
        {
          paramvap = paramvap.blurb;
          break label152;
        }
        paramvap = a(paramuxo.a());
        break label152;
      }
      paramvap = a(paramuxo.a());
      break label152;
      label296:
      if (paramuxo.a().type == 3) {
        if (uty.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, ajya.a(2131704475), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, vap paramvap, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373248);
    bfwu.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramvap.a(2131373247);
    Object localObject1 = (ImageView)paramvap.a(2131373249);
    paramvap = (ImageView)paramvap.a(2131373250);
    Object localObject2 = this.jdField_a_of_type_Uwq.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      bfwu.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130845612);
      paramvap.setImageResource(2130845614);
      if (paramInt != 0) {
        break label165;
      }
      paramvap = vzl.a(vzl.a(((uxm)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramvap);
    }
    for (;;)
    {
      bfwu.a();
      return;
      ((ImageView)localObject1).setImageResource(2130845611);
      paramvap.setImageResource(2130845613);
      break;
      label165:
      paramvap = (uxm)((List)localObject2).get(paramInt - 1);
      localObject2 = (uxm)((List)localObject2).get(paramInt);
      localObject1 = vzl.a(paramvap.a().date);
      localObject2 = vzl.a(((uxm)localObject2).a().date);
      if (((paramvap instanceof uxi)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramvap = vzl.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramvap);
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
        tvc.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (sss)tsr.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      vei.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vzl.b()) {
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
      tvc.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      vei.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      tvc.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          tvc.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = vei.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        vei.a("home_page", "clk_card", vei.a(paramVideoListFeedItem), usb.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), vei.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        tvc.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    ved.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Uwq.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localuxm = (uxm)localIterator.next();
      if (paramString1.equals(localuxm.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localuxm, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      uxm localuxm;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(szs paramszs, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramszs.c != null) && (paramszs.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Vaq.a();
      paramView.setFeedItemData(paramszs.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramszs, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(szs paramszs, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramszs.c != null) && (paramszs.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Vaq.a();
      paramViewGroup.setFeedItemData(paramszs.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramszs, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(tli paramtli)
  {
    if ((((Integer)((tcs)tcz.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramtli.jdField_a_of_type_JavaUtilList != null))
    {
      tvh.a();
      paramtli = new ArrayList(paramtli.jdField_a_of_type_JavaUtilList).iterator();
      while (paramtli.hasNext()) {
        tvh.a(((StoryVideoItem)paramtli.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(uwf paramuwf, vap paramvap)
  {
    paramuwf = (VideoListLayout)paramvap.a(2131373274);
    if (paramuwf != null)
    {
      paramuwf = paramuwf.a();
      if (paramuwf != null) {
        paramuwf.setVisibility(8);
      }
    }
  }
  
  public void a(uwm paramuwm)
  {
    boolean bool1 = true;
    ved.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramuwm == null) {
      c(false);
    }
    do
    {
      return;
      if (paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        vxp.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramuwm, new Object[0]);
        c(false);
        return;
      }
      ved.d("Q.qqstory.home:FeedSegment", paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramuwm.jdField_b_of_type_JavaUtilList, 0);
    } while (paramuwm.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramuwm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramuwm.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(uxl paramuxl, vap paramvap)
  {
    paramuxl = (VideoListLayout)paramvap.a(2131373274);
    if (paramuxl != null)
    {
      paramuxl = paramuxl.a();
      if (paramuxl != null) {
        paramuxl.setVisibility(8);
      }
    }
  }
  
  public void a(uxo paramuxo)
  {
    ved.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramuxo);
    if ((paramuxo == null) || (paramuxo.a() == null) || (paramuxo.a().feedId == null))
    {
      ved.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramuxo.a().feedId);
  }
  
  protected void a(vap paramvap)
  {
    Object localObject = (VideoListLayout)paramvap.a(2131373274);
    ((VideoListLayout)localObject).a().setOnClickListener(paramvap);
    ((VideoListLayout)localObject).a().setOnClickListener(paramvap);
    localObject = ((VideoListLayout)localObject).a();
    vbz localvbz = new vbz(this);
    paramvap.a("general_touch_handler", localvbz);
    paramvap.a("general_adapter", null);
    paramvap.a(this.jdField_b_of_type_Uyi);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localvbz);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localvbz);
    paramvap.a("type", "GeneralView");
  }
  
  protected void a(vap paramvap, uxn paramuxn)
  {
    TextView localTextView1 = (TextView)paramvap.a(2131373383);
    TextView localTextView2 = (TextView)paramvap.a(2131373382);
    TextView localTextView3 = (TextView)paramvap.a(2131373385);
    vvd localvvd = ((TagFeedItem)paramuxn.a()).tagItem;
    paramvap = (TextView)paramvap.a(2131373380);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166353));
      paramvap.setBackgroundResource(2130845638);
    }
    if (localvvd != null)
    {
      localTextView1.setText(localvvd.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramuxn.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramuxn.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramuxn.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramuxn.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(vbw paramvbw)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Uwq.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    ved.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    ved.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Uwq.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Uvx.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected vap b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561244, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373255);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    bfwu.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Vaq.a()) || (this.jdField_a_of_type_Int != 10))
    {
      bfwu.a();
      ved.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Vaq.a());
      return;
    }
    ved.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((vap)localIterator.next()).a(2131373274);
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
        ved.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131373272);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = uyk.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyk.a(localQQStoryAutoPlayView);
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
          ved.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = uyk.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyk.c(localQQStoryAutoPlayView);
          break label326;
          k = uyk.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyk.b(localQQStoryAutoPlayView);
          break label326;
          ved.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          ved.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          bfwu.a();
          return;
          ved.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Uwq.a());
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
    ved.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(uwm paramuwm)
  {
    c(true);
  }
  
  protected void b(vap paramvap)
  {
    ((VideoListLayout)paramvap.a(2131373274)).a().setVisibility(8);
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
    this.jdField_a_of_type_Uwq.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Uye == null) {
      return;
    }
    this.jdField_a_of_type_Uye.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (sxn.a()) {
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
      uyj.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (vcp)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      ved.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(vap paramvap)
  {
    bfwu.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramvap);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramvap.a(2131373274);
    if (localVideoListLayout == null)
    {
      bfwu.a();
      return;
    }
    paramvap = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramvap != null) && (paramvap.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramvap != null) && (paramvap.a() != null)) {
        ved.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramvap.a().getThumbUrl());
      }
      if (paramvap != null) {
        paramvap.a();
      }
      bfwu.a();
      return;
      paramvap = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramvap = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramvap = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramvap = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131373272);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vbx);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vbt);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vbs);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vby);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vbq);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Vbv);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Uye.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      szy localszy = (szy)((vap)localIterator.next()).a("commentLikeLego");
      if (localszy != null) {
        localszy.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Uwq.b();
    tau.a();
  }
  
  public void d(vap paramvap)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramvap);
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
    ved.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int f_()
  {
    return 4;
  }
  
  public void g_(int paramInt)
  {
    e(paramInt);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new vbb(this));
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
      paramMessage = (uwm)paramMessage.obj;
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
      j = vzl.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Vaq.a();
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
        paramMessage = (vap)localIterator.next();
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
      vxp.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = vzl.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Vaq.a().getLocationOnScreen(arrayOfInt1);
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
        ved.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (vap)localIterator.next();
      ved.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (szy)((vap)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((szy)localObject).c();
      }
    }
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
    ved.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((tcs)tcz.a(10)).b("mainHallConfig", "");
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
        ved.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        ved.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */