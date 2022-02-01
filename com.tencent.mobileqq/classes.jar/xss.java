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
import com.tencent.biz.qqstory.utils.UIUtils;
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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class xss
  extends ysg<xoe>
  implements Handler.Callback, IEventReceiver, vrn, vsc, xor, xpz, xsr
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new aqww(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new aqww(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new xsu(this);
  public String a;
  private List<xsh> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private vvj jdField_a_of_type_Vvj;
  private xnp jdField_a_of_type_Xnp;
  protected xoi a;
  private xpe jdField_a_of_type_Xpe;
  protected xpw a;
  xqa jdField_a_of_type_Xqa = new xtc(this);
  private xsi jdField_a_of_type_Xsi;
  private xti jdField_a_of_type_Xti;
  private xtk jdField_a_of_type_Xtk;
  private xtl jdField_a_of_type_Xtl;
  private xtn jdField_a_of_type_Xtn;
  private xtp jdField_a_of_type_Xtp;
  private xtq jdField_a_of_type_Xtq;
  private final int jdField_b_of_type_Int;
  public String b;
  xqa jdField_b_of_type_Xqa = new xtd(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  xqa jdField_c_of_type_Xqa = new xte(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  xqa jdField_d_of_type_Xqa = new xtf(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public xss(Context paramContext, Activity paramActivity, int paramInt, xsi paramxsi, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xsi = paramxsi;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Xoi = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Xtp = new xtp(this);
    this.jdField_a_of_type_Xtl = new xtl(this);
    this.jdField_a_of_type_Xtk = new xtk(this);
    this.jdField_a_of_type_Xtq = new xtq(this);
    this.jdField_a_of_type_Xti = new xti(this);
    this.jdField_a_of_type_Xtn = new xtn(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xtp);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xtl);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xtk);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xtq);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xti);
    vli.a().registerSubscriber(this.jdField_a_of_type_Xtn);
    this.jdField_a_of_type_Xpw = new xpw(Looper.myLooper());
    this.jdField_a_of_type_Xoi.a();
    this.jdField_a_of_type_Vvj = ((vvj)vux.a(2));
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Xpw.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298505);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298516);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Xpw.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Xpw.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (NetworkUtil.isWifiConnected(paramContext)) {
      return 1;
    }
    if (NetworkUtil.isMobileNetWork(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup, xny paramxny)
  {
    paramViewGroup = (ImageView)paramxsh.a(2131374349);
    FrameLayout localFrameLayout = (FrameLayout)paramxsh.a(2131374353);
    b(paramxsh);
    a(paramInt, paramxsh, this.jdField_d_of_type_Boolean);
    a(paramInt, paramxsh, paramxny, paramxny.a().getOwner());
    a(paramxsh, paramxny, true);
    a(paramxny, paramxsh);
    a(paramInt, paramxsh);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167103);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramxsh.a("feed_id", paramxny.a().feedId);
    a(paramxny, paramxsh, localFrameLayout, null);
    if (!paramxny.jdField_b_of_type_Boolean) {
      xwa.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramxny.a().getOwner().getUnionId(), paramxny.a().feedId });
    }
    paramViewGroup = paramxny.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      xwa.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramxsh.a();
  }
  
  private View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup, xpa paramxpa)
  {
    paramViewGroup = (VideoListLayout)paramxsh.a(2131374382);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((xtr)paramxsh.a("general_touch_handler")).a(paramxsh.jdField_b_of_type_Int, paramxsh);
    if ((paramxpa.a() == null) || (paramxpa.a().size() == 0))
    {
      xvv.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramxpa.a()).feedId);
      paramxsh.a.setVisibility(8);
      return paramxsh.a();
    }
    paramxsh.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (xsp)paramxsh.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new xsp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramxsh.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Xpw);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramxpa.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        xvv.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramxpa.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramxpa.a().size();
        paramViewGroup.a(paramxpa.a(), paramxpa.a());
        if (((HotRecommendFeedItem)paramxpa.a()).mIsVideoEnd) {
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
        paramViewGroup = paramxsh.a(2131379708);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((vuq)vux.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        xwa.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup, xpf paramxpf)
  {
    paramViewGroup = (ImageView)paramxsh.a(2131374349);
    a(paramInt, paramxsh, this.jdField_d_of_type_Boolean);
    a(paramxsh, paramxpf);
    a(paramInt, paramxsh);
    a(paramxsh, paramxpf, true);
    a(null, paramxsh);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167103);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    xwa.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramxpf.a()).feedId });
    return paramxsh.a();
  }
  
  private View a(int paramInt, xsh paramxsh, xmy paramxmy)
  {
    Object localObject = (QQStoryOwnerInfoView)paramxsh.a(2131374363);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramxsh.a(2131374334);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramxsh.a(2131374326);
    FrameLayout localFrameLayout = (FrameLayout)paramxsh.a(2131374328);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramxmy.a();
    a(paramInt, paramxsh, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, amtj.a(2131703580), true);
    if (xlq.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      UIUtils.setCircleViewByURL(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bfvo.a(1), "QQStory_main");
      a(paramInt, paramxsh);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramxmy.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (vrx)paramxsh.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new vrx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramxmy, this.jdField_a_of_type_Int);
      ((vrx)localObject).a(paramxmy);
      ((vrx)localObject).l();
      paramxsh.a("commentLikeLego", localObject);
      localFrameLayout.addView(((vrx)localObject).b);
    }
    for (;;)
    {
      ((vrx)localObject).a(this);
      ((vrx)localObject).a(this);
      ((vrx)localObject).a(false);
      if (!paramxmy.jdField_b_of_type_Boolean) {
        xwa.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramxmy.a()).getOwner().getUnionId(), ((BannerFeedItem)paramxmy.a()).feedId });
      }
      return paramxsh.a();
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
      ((vrx)localObject).a(paramxmy, null, paramxmy);
      ((vrx)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      xvv.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = UIUtils.getTimeZoneOffset() / 3600;
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
        return xqc.a(j, true);
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
  
  private void a(int paramInt, xpe paramxpe, String paramString, boolean paramBoolean)
  {
    if (!(paramxpe instanceof xpg)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        xvv.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramxpe, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((xsh)localObject1).a(2131374382);
        List localList = ((xpg)paramxpe).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            xvv.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramxpe.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (xjt)((xsh)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((xjt)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            xvv.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramxpe.a().feedId, Integer.valueOf(j));
            xvv.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, xsh paramxsh, xpg paramxpg, ShareGroupItem paramShareGroupItem)
  {
    bjun.a("FeedSegment.bindFeedShareGroupInfo");
    paramxsh = (QQStoryOwnerInfoView)paramxsh.a(2131374363);
    if (paramShareGroupItem == null)
    {
      paramxsh.setSubTitle(null);
      paramxsh.setBadge(null);
      paramxsh.setQIMIcon(null);
      paramxsh.setSubTitleSuffix(null);
      paramxsh.setButtonTxt(null);
      paramxsh.setName(wkp.jdField_b_of_type_JavaLangString);
      paramxsh.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846350));
      bjun.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bfvo.a();
      paramxsh.setAvatar(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramxsh.setName(paramShareGroupItem.getName());
      if (paramxpg.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((xpd)paramxpg).a(), paramxpg.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramxsh.setSubTitle((String)localObject1);
        paramxsh.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramxsh.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846715);
      label199:
      if (paramxpg.a().type == 2)
      {
        if (!paramxpg.a()) {
          break label328;
        }
        a(paramxsh, amtj.a(2131703587), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramxsh = paramxsh.a();
      paramxsh.a(null);
      paramxsh.setVisibility(8);
      bjun.a();
      return;
      paramxsh.setAvatar(((xck)vux.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846717);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846716);
      break label199;
      label328:
      a(paramxsh, null, false);
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
    bjun.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        xvv.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = xvs.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        xvv.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!xqc.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = xvs.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      bjun.a();
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
      xvv.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = yql.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = yql.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    localbjnw.a(amtj.a(2131703582), 5);
    QQUserUIItem localQQUserUIItem = ((vvj)vux.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = amtj.a(2131703583);; str = amtj.a(2131703575))
    {
      localbjnw.a(str, 5);
      localbjnw.a(amtj.a(2131703600), 5);
      localbjnw.c(2131690620);
      localbjnw.a(new xsx(this, localbjnw, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbjnw.a(new xta(this));
      if (!localbjnw.isShowing()) {
        localbjnw.show();
      }
      xwa.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846526);
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
        xqb.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      xqb.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      UIUtils.clearExpandViewTouchAre(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167012));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846454);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166494));
        localButton.setBackgroundResource(2130846454);
      }
      j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.expandViewTouchArea(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846453);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166481));
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
    paramString.setDecodeHandler(UIUtils.ROUND_CORNER_DECODER);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<xpe> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((vuq)vux.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((xpe)paramList.next()).d();
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
      xvv.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Xpw.a(localArrayList);
      return;
    }
  }
  
  private void a(xpe paramxpe)
  {
    if ((paramxpe == null) || (paramxpe.a() == null) || (paramxpe.a().getOwner() == null)) {
      yos.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramxpe instanceof xnx))
      {
        paramxpe = ((xnx)paramxpe).a().getOwner();
        vpl.a(this.jdField_a_of_type_AndroidContentContext, 4, paramxpe.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramxpe instanceof xpd))
      {
        paramxpe = (ShareGroupFeedItem)((xpd)paramxpe).a();
        localObject = paramxpe.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          xvv.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          yos.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramxpe.getOwner().getRelationType() == 2)
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
      if ((paramxpe instanceof xny))
      {
        paramxpe = ((xny)paramxpe).a();
        localObject = paramxpe.getOwner();
        if (paramxpe.getOwner().getRelationType() == 2)
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
        vpl.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramxpe instanceof xpf))
      {
        paramxpe = (TagFeedItem)((xpf)paramxpe).a();
        wlg.a(this.jdField_a_of_type_AndroidAppActivity, paramxpe.tagItem.a);
        return;
      }
    } while (!(paramxpe instanceof xpa));
    label289:
    l();
    xwa.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(xpe paramxpe, ShareGroupItem paramShareGroupItem)
  {
    if (xbw.a(paramShareGroupItem))
    {
      if (paramxpe.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        xwa.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, amtj.a(2131703599), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new xbx((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    xwa.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(xpe paramxpe, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramxpe.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      xwa.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramxpe.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(xpg paramxpg, xsh paramxsh) {}
  
  private void a(xpg paramxpg, xsh paramxsh, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    bjun.a("FeedSegment.bindCommentLike");
    vrx localvrx;
    if (paramxpg.a().size() > 0)
    {
      localvrx = (vrx)paramxsh.a("commentLikeLego");
      if (localvrx != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localvrx = vrx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramxpg, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramxsh.a("commentLikeLego", localvrx);
      paramFrameLayout.addView(localvrx.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localvrx.k();
        paramxpg = paramFrameLayout.getLayoutParams();
        paramxpg.height = UIUtils.dip2px(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramxpg);
      }
      for (;;)
      {
        bjun.a();
        return;
        label132:
        localvrx = new vrx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramxpg, this.jdField_a_of_type_Int);
        break;
        paramxsh = paramFrameLayout.getLayoutParams();
        paramxsh.height = -2;
        paramFrameLayout.setLayoutParams(paramxsh);
        if (localvrx.a())
        {
          localvrx.a(paramxpg, paramShareGroupItem, null);
          localvrx.c(null);
        }
        for (;;)
        {
          localvrx.a(this);
          localvrx.a(this);
          if ((paramxpg.a().mVideoPullType != 0) || (paramxpg.a().size() <= 1)) {
            break label249;
          }
          localvrx.a(true);
          break;
          localvrx.l();
        }
        label249:
        localvrx.a(false);
      }
    }
  }
  
  private void a(xsh paramxsh, xpg paramxpg, boolean paramBoolean)
  {
    bjun.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramxsh.a(2131374382);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((xtr)paramxsh.a("general_touch_handler")).a(paramxsh.jdField_b_of_type_Int, paramxsh);
    if ((paramxpg.a() == null) || (paramxpg.a().size() == 0))
    {
      xvv.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramxpg.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      bjun.a();
      return;
    }
    Object localObject1;
    if (paramxpg.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (xjt)paramxsh.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new xjt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((xjt)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramxsh.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((xjt)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((xjt)localObject1).a(this.jdField_a_of_type_Xpw);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramxpg.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          xvv.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramxpg.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramxpg.a().size() != 2) {
          break label563;
        }
        j = (UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((xjt)localObject1).a(j, k);
        ((xjt)localObject1).a(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramxpg.a().type != 6) {
          break label642;
        }
        j = k + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298516));
        ((xjt)localObject1).a(paramxpg.a(), paramxpg.a());
        if (vpm.a())
        {
          if ((!this.i) || (paramxsh.jdField_b_of_type_Int != 0) || ((!paramxpg.b()) && (!paramxpg.a().isFakeFeedItem()))) {
            break label660;
          }
          ((xjt)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramxpg.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((xjt)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramxpg.a().size() == 1)
      {
        j = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramxpg.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramxpg.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Xpw);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          voe.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((vpm.a()) && (this.i) && (paramxsh.jdField_b_of_type_Int == 0) && ((paramxpg.b()) || (paramxpg.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167106));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(amtj.a(2131703594));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167106));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramxpg.a().type == 3) && ((paramxpg.a().getOwner() instanceof QQUserUIItem)))
          {
            paramxsh = (QQUserUIItem)paramxpg.a().getOwner();
            if ((paramxsh.isVip) && (!paramxsh.isSubscribe())) {
              xwa.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramxpg.a().type != 6) {
            break;
          }
          xwa.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = voe.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            xvv.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new xtg(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          voe.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167012));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(UIUtils.convertToHHMM(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramxpg.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramxpg.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(UIUtils.convertToHHMM(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramxpg.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Vwn != null))
            {
              localStoryNickNameView.setFormat(amtj.a(2131703604));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Vwn.jdField_a_of_type_JavaLangString);
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
    switch (((vla)wkp.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        xvv.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Vwn == null)) {
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
        paramList = amtj.a(2131703605);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = amtj.a(2131703592);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + amtj.a(2131703597);
        paramList = str1;
      }
    }
  }
  
  private void b(List<xpe> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((vuq)vux.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((xpe)paramList.next()).d();
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
      xvv.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new xth(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Xoi.e();
    xwa.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private xsh c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561633, paramViewGroup, false));
    paramViewGroup.a(2131379708).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Xqa);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374372);
    xtr localxtr = new xtr(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localxtr);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localxtr);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localxtr);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localxtr);
    paramViewGroup.a("general_touch_handler", localxtr);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private xsh d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561738, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374363);
    paramViewGroup.a(2131374364).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374362).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374492).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374487).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Xqa);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374372);
    xtr localxtr = new xtr(this);
    paramViewGroup.a("general_touch_handler", localxtr);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localxtr);
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
    int k = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      xvv.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private xsh e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561564, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374363);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374326).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374334).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Xqa);
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
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    xpe localxpe = (xpe)this.jdField_a_of_type_Xoi.a().get(paramInt);
    localbjnw.a(amtj.a(2131703589), 5);
    localbjnw.c(2131690620);
    localbjnw.a(new xsv(this, localbjnw, paramInt, localxpe));
    localbjnw.a(new xsw(this, paramInt));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
    a(localxpe, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!ypp.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(wkp.a(), 1, amtj.a(2131703603), 0).a();
      return;
    }
    Object localObject = (xpe)this.jdField_a_of_type_Xoi.a().remove(paramInt);
    if (localObject == null)
    {
      yos.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((xpe)localObject, "hide_done");
    String str = ((xpe)localObject).a().getOwner().getUnionId();
    long l;
    switch (((xpe)localObject).a().type)
    {
    case 4: 
    default: 
      yos.a("feed not allow unLike operation type=" + ((xpe)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((xpe)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      ypg.a(str, paramInt, l);
      localObject = ((xpe)localObject).a().feedId;
      Bosses.get().postJob(new xtb(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((xpe)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((xpe)localObject).a()).recommendId;
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
    if (vpm.a()) {}
    do
    {
      return;
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { amtj.a(2131703590), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { amtj.a(2131703598), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { amtj.a(2131703591), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (xuh)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((xuh)localObject).a(false);
      }
      a().setSelection(0);
      return;
      xvv.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void N_()
  {
    this.jdField_a_of_type_Xpe = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Xoi.a()).iterator();
      while (localIterator.hasNext())
      {
        xpe localxpe = (xpe)localIterator.next();
        if (((localxpe instanceof xpd)) && (localxpe.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localxpe.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Xpe == null))
        {
          this.jdField_a_of_type_Xpe = localxpe;
          xvv.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Xpe.toString());
          return;
        }
      }
      xvv.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void P_()
  {
    super.P_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Xpw.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Xpw.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Xoi.c();
    this.jdField_a_of_type_Xoi.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Xoi.a().size();
  }
  
  protected int a(int paramInt)
  {
    xpe localxpe = (xpe)this.jdField_a_of_type_Xoi.a().get(paramInt);
    if (localxpe.a().type == 1) {
      return 0;
    }
    if (localxpe.a().type == 3) {
      return 0;
    }
    if (localxpe.a().type == 2) {
      return 0;
    }
    if (localxpe.a().type == 5) {
      return 1;
    }
    if (localxpe.a().type == 6) {
      return 2;
    }
    if (localxpe.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Xoi.a().size())
    {
      localObject1 = (xpe)this.jdField_a_of_type_Xoi.a().get(j);
      if ((((xpe)localObject1).a().type != 1) && (((xpe)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((xsh)localObject1).a(2131374382);
      if (localObject2 != null) {
        break;
      }
      xvv.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374380);
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { amtj.a(2131703577), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    xpe localxpe = (xpe)this.jdField_a_of_type_Xoi.a().get(paramInt);
    paramxsh.a("feed_id", localxpe.a().feedId);
    View localView = paramxsh.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localxpe.jdField_b_of_type_Boolean = true;
      d(paramxsh);
      paramxsh = new ArrayList();
      paramxsh.add(localxpe);
      b(paramxsh, 0);
      xwa.b("story_home_dev", "feed_exp", localxpe.a().type, localxpe.d().size(), new String[] { localxpe.a().feedId });
      return localView;
      if (localxpe.a().type == 1)
      {
        localView = a(paramInt, paramxsh, paramViewGroup, (xnx)localxpe);
      }
      else if (localxpe.a().type == 2)
      {
        localView = a(paramInt, paramxsh, paramViewGroup, (xpd)localxpe);
      }
      else if (localxpe.a().type == 3)
      {
        localView = a(paramInt, paramxsh, paramViewGroup, (xny)localxpe);
        continue;
        localView = a(paramInt, paramxsh, (xmy)localxpe);
        continue;
        localView = a(paramInt, paramxsh, paramViewGroup, (xpf)localxpe);
        continue;
        localView = a(paramInt, paramxsh, paramViewGroup, (xpa)localxpe);
      }
    }
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup, xnx paramxnx)
  {
    xvv.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramxsh.a(2131374349);
    FrameLayout localFrameLayout = (FrameLayout)paramxsh.a(2131374353);
    a(paramxnx, paramxsh);
    a(paramInt, paramxsh, this.jdField_d_of_type_Boolean);
    a(paramInt, paramxsh, paramxnx, paramxnx.a().getOwner());
    a(paramxsh, paramxnx, true);
    a(paramInt, paramxsh);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167103);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramxsh.a("feed_id", paramxnx.a().feedId);
    a(paramxnx, paramxsh);
    a(paramxnx, paramxsh, localFrameLayout, null);
    return paramxsh.a();
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup, xpd paramxpd)
  {
    xvv.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramxsh.a(2131374349);
    FrameLayout localFrameLayout = (FrameLayout)paramxsh.a(2131374353);
    a(paramxpd, paramxsh);
    a(paramInt, paramxsh, this.jdField_d_of_type_Boolean);
    a(paramInt, paramxsh, paramxpd, ((ShareGroupFeedItem)paramxpd.a()).getOwner());
    a(paramxsh, paramxpd, true);
    a(paramxpd, paramxsh);
    a(paramInt, paramxsh);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167103);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramxsh.a("feed_id", ((ShareGroupFeedItem)paramxpd.a()).feedId);
    paramxsh.a("group_id", ((ShareGroupFeedItem)paramxpd.a()).getOwner().shareGroupId);
    a(paramxpd, paramxsh, localFrameLayout, ((ShareGroupFeedItem)paramxpd.a()).getOwner());
    paramxpd.jdField_b_of_type_Boolean = true;
    return paramxsh.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected xoi a(boolean paramBoolean)
  {
    return new xoi(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    bjun.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      bjun.a();
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
  
  protected xsh a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Xoi.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((xpe)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      xsh localxsh = a(j);
      if ((localxsh != null) && (paramString.equals(localxsh.a("feed_id")))) {
        return localxsh;
      }
      if (localxsh != null)
      {
        localObject = (xpe)((List)localObject).get(j);
        yos.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localxsh.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (xsh)localIterator.next();
        if (localObject != null)
        {
          localObject = (vrx)((xsh)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((vrx)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, xsh paramxsh)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374377);
    TextView localTextView = (TextView)paramxsh.a(2131374378);
    ImageView localImageView = (ImageView)paramxsh.a(2131374375);
    if (localRelativeLayout == null) {
      return;
    }
    if (vpm.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (xpe)this.jdField_a_of_type_Xoi.a().get(paramInt);
    switch (((xpe)localObject).a().type)
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
      localObject = (BannerFeedItem)((xpe)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        xvv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = amtj.a(2131703579);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramxsh);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((xpe)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((xpe)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        xvv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = amtj.a(2131703585);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramxsh);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((xpe)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      xvv.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = amtj.a(2131703576);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramxsh);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, xsh paramxsh, xpg paramxpg, QQUserUIItem paramQQUserUIItem)
  {
    bjun.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramxsh.a(2131374363);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(wkp.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846350));
      bjun.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(UIUtils.getCircleViewByURL(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bfvo.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramxsh = "";
      if (paramxpg.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramxsh);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramxpg.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramxsh = localQQStoryOwnerInfoView.a();
      paramxsh.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramxpg.jdField_b_of_type_Boolean) {
        paramxsh.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      bjun.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramxpg.a().type == 3)
      {
        paramxsh = (GeneralRecommendFeedItem)paramxpg.a();
        if (!TextUtils.isEmpty(paramxsh.blurb))
        {
          paramxsh = paramxsh.blurb;
          break label152;
        }
        paramxsh = a(paramxpg.a());
        break label152;
      }
      paramxsh = a(paramxpg.a());
      break label152;
      label296:
      if (paramxpg.a().type == 3) {
        if (xlq.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, amtj.a(2131703593), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, xsh paramxsh, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374356);
    bjun.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramxsh.a(2131374355);
    Object localObject1 = (ImageView)paramxsh.a(2131374357);
    paramxsh = (ImageView)paramxsh.a(2131374358);
    Object localObject2 = this.jdField_a_of_type_Xoi.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      bjun.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846428);
      paramxsh.setImageResource(2130846430);
      if (paramInt != 0) {
        break label165;
      }
      paramxsh = UIUtils.convertToCalendar(UIUtils.parseDate(((xpe)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramxsh);
    }
    for (;;)
    {
      bjun.a();
      return;
      ((ImageView)localObject1).setImageResource(2130846427);
      paramxsh.setImageResource(2130846429);
      break;
      label165:
      paramxsh = (xpe)((List)localObject2).get(paramInt - 1);
      localObject2 = (xpe)((List)localObject2).get(paramInt);
      localObject1 = UIUtils.parseDate(paramxsh.a().date);
      localObject2 = UIUtils.parseDate(((xpe)localObject2).a().date);
      if (((paramxsh instanceof xpa)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramxsh = UIUtils.convertToCalendar((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramxsh);
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
        wmu.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (vkz)wkp.a().getBusinessHandler(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      xwa.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.isFastDoubleClick()) {
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
      wmu.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      xwa.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      wmu.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          wmu.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = xwa.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        xwa.a("home_page", "clk_card", xwa.a(paramVideoListFeedItem), xjt.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), xwa.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        wmu.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    xvv.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Xoi.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localxpe = (xpe)localIterator.next();
      if (paramString1.equals(localxpe.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localxpe, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      xpe localxpe;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(vrr paramvrr, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramvrr.c != null) && (paramvrr.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Xsi.a();
      paramView.setFeedItemData(paramvrr.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramvrr, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(vrr paramvrr, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramvrr.c != null) && (paramvrr.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Xsi.a();
      paramViewGroup.setFeedItemData(paramvrr.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramvrr, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wdg paramwdg)
  {
    if ((((Integer)((vuq)vux.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramwdg.jdField_a_of_type_JavaUtilList != null))
    {
      wmz.a();
      paramwdg = new ArrayList(paramwdg.jdField_a_of_type_JavaUtilList).iterator();
      while (paramwdg.hasNext()) {
        wmz.a(((StoryVideoItem)paramwdg.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(xnx paramxnx, xsh paramxsh)
  {
    paramxnx = (VideoListLayout)paramxsh.a(2131374382);
    if (paramxnx != null)
    {
      paramxnx = paramxnx.a();
      if (paramxnx != null) {
        paramxnx.setVisibility(8);
      }
    }
  }
  
  public void a(xoe paramxoe)
  {
    boolean bool1 = true;
    xvv.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramxoe == null) {
      c(false);
    }
    do
    {
      return;
      if (paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        yos.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramxoe, new Object[0]);
        c(false);
        return;
      }
      xvv.d("Q.qqstory.home:FeedSegment", paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramxoe.jdField_b_of_type_JavaUtilList, 0);
    } while (paramxoe.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramxoe.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramxoe.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(xpd paramxpd, xsh paramxsh)
  {
    paramxpd = (VideoListLayout)paramxsh.a(2131374382);
    if (paramxpd != null)
    {
      paramxpd = paramxpd.a();
      if (paramxpd != null) {
        paramxpd.setVisibility(8);
      }
    }
  }
  
  public void a(xpg paramxpg)
  {
    xvv.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramxpg);
    if ((paramxpg == null) || (paramxpg.a() == null) || (paramxpg.a().feedId == null))
    {
      xvv.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramxpg.a().feedId);
  }
  
  protected void a(xsh paramxsh)
  {
    Object localObject = (VideoListLayout)paramxsh.a(2131374382);
    ((VideoListLayout)localObject).a().setOnClickListener(paramxsh);
    ((VideoListLayout)localObject).a().setOnClickListener(paramxsh);
    localObject = ((VideoListLayout)localObject).a();
    xtr localxtr = new xtr(this);
    paramxsh.a("general_touch_handler", localxtr);
    paramxsh.a("general_adapter", null);
    paramxsh.a(this.jdField_b_of_type_Xqa);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localxtr);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localxtr);
    paramxsh.a("type", "GeneralView");
  }
  
  protected void a(xsh paramxsh, xpf paramxpf)
  {
    TextView localTextView1 = (TextView)paramxsh.a(2131374490);
    TextView localTextView2 = (TextView)paramxsh.a(2131374489);
    TextView localTextView3 = (TextView)paramxsh.a(2131374492);
    ymk localymk = ((TagFeedItem)paramxpf.a()).tagItem;
    paramxsh = (TextView)paramxsh.a(2131374487);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166499));
      paramxsh.setBackgroundResource(2130846454);
    }
    if (localymk != null)
    {
      localTextView1.setText(localymk.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramxpf.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramxpf.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramxpf.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramxpf.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(xto paramxto)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xoi.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    xvv.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    xvv.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Xoi.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Xnp.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected xsh b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561607, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374363);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    bjun.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Xsi.a()) || (this.jdField_a_of_type_Int != 10))
    {
      bjun.a();
      xvv.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Xsi.a());
      return;
    }
    xvv.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((xsh)localIterator.next()).a(2131374382);
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
        xvv.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374380);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = xqc.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = xqc.a(localQQStoryAutoPlayView);
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
          xvv.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = xqc.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = xqc.c(localQQStoryAutoPlayView);
          break label326;
          k = xqc.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = xqc.b(localQQStoryAutoPlayView);
          break label326;
          xvv.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          xvv.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          bjun.a();
          return;
          xvv.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Xoi.a());
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
    xvv.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(xoe paramxoe)
  {
    c(true);
  }
  
  protected void b(xsh paramxsh)
  {
    ((VideoListLayout)paramxsh.a(2131374382)).a().setVisibility(8);
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
    this.jdField_a_of_type_Xoi.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Xpw == null) {
      return;
    }
    this.jdField_a_of_type_Xpw.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (vpm.a()) {
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
      xqb.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (xuh)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      xvv.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(xsh paramxsh)
  {
    bjun.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramxsh);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramxsh.a(2131374382);
    if (localVideoListLayout == null)
    {
      bjun.a();
      return;
    }
    paramxsh = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramxsh != null) && (paramxsh.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramxsh != null) && (paramxsh.a() != null)) {
        xvv.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramxsh.a().getThumbUrl());
      }
      if (paramxsh != null) {
        paramxsh.a();
      }
      bjun.a();
      return;
      paramxsh = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramxsh = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramxsh = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramxsh = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131374380);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xtp);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xtl);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xtk);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xtq);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xti);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Xtn);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Xpw.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      vrx localvrx = (vrx)((xsh)localIterator.next()).a("commentLikeLego");
      if (localvrx != null) {
        localvrx.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Xoi.b();
    vst.a();
  }
  
  public void d(xsh paramxsh)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramxsh);
  }
  
  public void d_(boolean paramBoolean)
  {
    super.d_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      h();
    }
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
  
  public void f()
  {
    xvv.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int g_()
  {
    return 4;
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new xst(this));
    SegmentList localSegmentList = a();
    String str = a();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  public void h_(int paramInt)
  {
    e(paramInt);
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
      paramMessage = (xoe)paramMessage.obj;
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
      j = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Xsi.a();
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
        paramMessage = (xsh)localIterator.next();
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
      yos.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Xsi.a().getLocationOnScreen(arrayOfInt1);
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
        xvv.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (xsh)localIterator.next();
      xvv.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (vrx)((xsh)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((vrx)localObject).c();
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
    xvv.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((vuq)vux.a(10)).b("mainHallConfig", "");
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
        xvv.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        xvv.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xss
 * JD-Core Version:    0.7.0.1
 */