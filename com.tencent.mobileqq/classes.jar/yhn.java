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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class yhn
  extends zgz<ycz>
  implements Handler.Callback, IEventReceiver, wgi, wgx, ydm, yeu, yhm
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new asbg(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new asbg(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new yhp(this);
  public String a;
  private List<yhc> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private wke jdField_a_of_type_Wke;
  private yck jdField_a_of_type_Yck;
  protected ydd a;
  private ydz jdField_a_of_type_Ydz;
  protected yer a;
  yev jdField_a_of_type_Yev = new yhx(this);
  private yhd jdField_a_of_type_Yhd;
  private yid jdField_a_of_type_Yid;
  private yif jdField_a_of_type_Yif;
  private yig jdField_a_of_type_Yig;
  private yii jdField_a_of_type_Yii;
  private yik jdField_a_of_type_Yik;
  private yil jdField_a_of_type_Yil;
  private final int jdField_b_of_type_Int;
  public String b;
  yev jdField_b_of_type_Yev = new yhy(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  yev jdField_c_of_type_Yev = new yhz(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  yev jdField_d_of_type_Yev = new yia(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public yhn(Context paramContext, Activity paramActivity, int paramInt, yhd paramyhd, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Yhd = paramyhd;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Ydd = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yik = new yik(this);
    this.jdField_a_of_type_Yig = new yig(this);
    this.jdField_a_of_type_Yif = new yif(this);
    this.jdField_a_of_type_Yil = new yil(this);
    this.jdField_a_of_type_Yid = new yid(this);
    this.jdField_a_of_type_Yii = new yii(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yik);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yig);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yif);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yil);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yid);
    wad.a().registerSubscriber(this.jdField_a_of_type_Yii);
    this.jdField_a_of_type_Yer = new yer(Looper.myLooper());
    this.jdField_a_of_type_Ydd.a();
    this.jdField_a_of_type_Wke = ((wke)wjs.a(2));
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Yer.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298509);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298520);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Yer.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Yer.a(3);
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
  
  private View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup, yct paramyct)
  {
    paramViewGroup = (ImageView)paramyhc.a(2131374587);
    FrameLayout localFrameLayout = (FrameLayout)paramyhc.a(2131374591);
    b(paramyhc);
    a(paramInt, paramyhc, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyhc, paramyct, paramyct.a().getOwner());
    a(paramyhc, paramyct, true);
    a(paramyct, paramyhc);
    a(paramInt, paramyhc);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167117);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyhc.a("feed_id", paramyct.a().feedId);
    a(paramyct, paramyhc, localFrameLayout, null);
    if (!paramyct.jdField_b_of_type_Boolean) {
      ykv.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramyct.a().getOwner().getUnionId(), paramyct.a().feedId });
    }
    paramViewGroup = paramyct.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      ykv.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramyhc.a();
  }
  
  private View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup, ydv paramydv)
  {
    paramViewGroup = (VideoListLayout)paramyhc.a(2131374620);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((yim)paramyhc.a("general_touch_handler")).a(paramyhc.jdField_b_of_type_Int, paramyhc);
    if ((paramydv.a() == null) || (paramydv.a().size() == 0))
    {
      ykq.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramydv.a()).feedId);
      paramyhc.a.setVisibility(8);
      return paramyhc.a();
    }
    paramyhc.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (yhk)paramyhc.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new yhk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramyhc.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Yer);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramydv.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        ykq.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramydv.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramydv.a().size();
        paramViewGroup.a(paramydv.a(), paramydv.a());
        if (((HotRecommendFeedItem)paramydv.a()).mIsVideoEnd) {
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
        paramViewGroup = paramyhc.a(2131380022);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((wjl)wjs.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        ykv.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup, yea paramyea)
  {
    paramViewGroup = (ImageView)paramyhc.a(2131374587);
    a(paramInt, paramyhc, this.jdField_d_of_type_Boolean);
    a(paramyhc, paramyea);
    a(paramInt, paramyhc);
    a(paramyhc, paramyea, true);
    a(null, paramyhc);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167117);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ykv.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramyea.a()).feedId });
    return paramyhc.a();
  }
  
  private View a(int paramInt, yhc paramyhc, ybt paramybt)
  {
    Object localObject = (QQStoryOwnerInfoView)paramyhc.a(2131374601);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramyhc.a(2131374572);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramyhc.a(2131374564);
    FrameLayout localFrameLayout = (FrameLayout)paramyhc.a(2131374566);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramybt.a();
    a(paramInt, paramyhc, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, anvx.a(2131703931), true);
    if (yal.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      UIUtils.setCircleViewByURL(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bheg.a(1), "QQStory_main");
      a(paramInt, paramyhc);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramybt.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (wgs)paramyhc.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new wgs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramybt, this.jdField_a_of_type_Int);
      ((wgs)localObject).a(paramybt);
      ((wgs)localObject).l();
      paramyhc.a("commentLikeLego", localObject);
      localFrameLayout.addView(((wgs)localObject).b);
    }
    for (;;)
    {
      ((wgs)localObject).a(this);
      ((wgs)localObject).a(this);
      ((wgs)localObject).a(false);
      if (!paramybt.jdField_b_of_type_Boolean) {
        ykv.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramybt.a()).getOwner().getUnionId(), ((BannerFeedItem)paramybt.a()).feedId });
      }
      return paramyhc.a();
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
      ((wgs)localObject).a(paramybt, null, paramybt);
      ((wgs)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      ykq.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
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
        return yex.a(j, true);
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
  
  private void a(int paramInt, ydz paramydz, String paramString, boolean paramBoolean)
  {
    if (!(paramydz instanceof yeb)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        ykq.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramydz, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((yhc)localObject1).a(2131374620);
        List localList = ((yeb)paramydz).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            ykq.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramydz.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (xyo)((yhc)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((xyo)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            ykq.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramydz.a().feedId, Integer.valueOf(j));
            ykq.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, yhc paramyhc, yeb paramyeb, ShareGroupItem paramShareGroupItem)
  {
    blfz.a("FeedSegment.bindFeedShareGroupInfo");
    paramyhc = (QQStoryOwnerInfoView)paramyhc.a(2131374601);
    if (paramShareGroupItem == null)
    {
      paramyhc.setSubTitle(null);
      paramyhc.setBadge(null);
      paramyhc.setQIMIcon(null);
      paramyhc.setSubTitleSuffix(null);
      paramyhc.setButtonTxt(null);
      paramyhc.setName(wzk.jdField_b_of_type_JavaLangString);
      paramyhc.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846446));
      blfz.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bheg.a();
      paramyhc.setAvatar(FaceDrawable.getFaceDrawable(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramyhc.setName(paramShareGroupItem.getName());
      if (paramyeb.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((ydy)paramyeb).a(), paramyeb.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramyhc.setSubTitle((String)localObject1);
        paramyhc.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramyhc.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846811);
      label199:
      if (paramyeb.a().type == 2)
      {
        if (!paramyeb.a()) {
          break label328;
        }
        a(paramyhc, anvx.a(2131703938), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramyhc = paramyhc.a();
      paramyhc.a(null);
      paramyhc.setVisibility(8);
      blfz.a();
      return;
      paramyhc.setAvatar(((xrf)wjs.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846813);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846812);
      break label199;
      label328:
      a(paramyhc, null, false);
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
    blfz.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        ykq.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = ykn.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        ykq.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!yex.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = ykn.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      blfz.a();
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
      ykq.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = zfe.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = zfe.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    localbkzi.a(anvx.a(2131703933), 5);
    QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = anvx.a(2131703934);; str = anvx.a(2131703926))
    {
      localbkzi.a(str, 5);
      localbkzi.a(anvx.a(2131703951), 5);
      localbkzi.c(2131690697);
      localbkzi.a(new yhs(this, localbkzi, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbkzi.a(new yhv(this));
      if (!localbkzi.isShowing()) {
        localbkzi.show();
      }
      ykv.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846622);
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
        yew.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      yew.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
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
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846550);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166508));
        localButton.setBackgroundResource(2130846550);
      }
      j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.expandViewTouchArea(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846549);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
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
  
  private void a(List<ydz> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((wjl)wjs.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ydz)paramList.next()).d();
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
      ykq.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Yer.a(localArrayList);
      return;
    }
  }
  
  private void a(ydz paramydz)
  {
    if ((paramydz == null) || (paramydz.a() == null) || (paramydz.a().getOwner() == null)) {
      zdl.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramydz instanceof ycs))
      {
        paramydz = ((ycs)paramydz).a().getOwner();
        weg.a(this.jdField_a_of_type_AndroidContentContext, 4, paramydz.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramydz instanceof ydy))
      {
        paramydz = (ShareGroupFeedItem)((ydy)paramydz).a();
        localObject = paramydz.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          ykq.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          zdl.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramydz.getOwner().getRelationType() == 2)
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
      if ((paramydz instanceof yct))
      {
        paramydz = ((yct)paramydz).a();
        localObject = paramydz.getOwner();
        if (paramydz.getOwner().getRelationType() == 2)
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
        weg.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramydz instanceof yea))
      {
        paramydz = (TagFeedItem)((yea)paramydz).a();
        xab.a(this.jdField_a_of_type_AndroidAppActivity, paramydz.tagItem.a);
        return;
      }
    } while (!(paramydz instanceof ydv));
    label289:
    l();
    ykv.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(ydz paramydz, ShareGroupItem paramShareGroupItem)
  {
    if (xqr.a(paramShareGroupItem))
    {
      if (paramydz.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        ykv.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, anvx.a(2131703950), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new xqs((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    ykv.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(ydz paramydz, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramydz.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      ykv.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramydz.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(yeb paramyeb, yhc paramyhc) {}
  
  private void a(yeb paramyeb, yhc paramyhc, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    blfz.a("FeedSegment.bindCommentLike");
    wgs localwgs;
    if (paramyeb.a().size() > 0)
    {
      localwgs = (wgs)paramyhc.a("commentLikeLego");
      if (localwgs != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localwgs = wgs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyeb, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramyhc.a("commentLikeLego", localwgs);
      paramFrameLayout.addView(localwgs.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localwgs.k();
        paramyeb = paramFrameLayout.getLayoutParams();
        paramyeb.height = UIUtils.dip2px(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramyeb);
      }
      for (;;)
      {
        blfz.a();
        return;
        label132:
        localwgs = new wgs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyeb, this.jdField_a_of_type_Int);
        break;
        paramyhc = paramFrameLayout.getLayoutParams();
        paramyhc.height = -2;
        paramFrameLayout.setLayoutParams(paramyhc);
        if (localwgs.a())
        {
          localwgs.a(paramyeb, paramShareGroupItem, null);
          localwgs.c(null);
        }
        for (;;)
        {
          localwgs.a(this);
          localwgs.a(this);
          if ((paramyeb.a().mVideoPullType != 0) || (paramyeb.a().size() <= 1)) {
            break label249;
          }
          localwgs.a(true);
          break;
          localwgs.l();
        }
        label249:
        localwgs.a(false);
      }
    }
  }
  
  private void a(yhc paramyhc, yeb paramyeb, boolean paramBoolean)
  {
    blfz.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramyhc.a(2131374620);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((yim)paramyhc.a("general_touch_handler")).a(paramyhc.jdField_b_of_type_Int, paramyhc);
    if ((paramyeb.a() == null) || (paramyeb.a().size() == 0))
    {
      ykq.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramyeb.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      blfz.a();
      return;
    }
    Object localObject1;
    if (paramyeb.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (xyo)paramyhc.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new xyo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((xyo)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramyhc.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((xyo)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((xyo)localObject1).a(this.jdField_a_of_type_Yer);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramyeb.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          ykq.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramyeb.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramyeb.a().size() != 2) {
          break label563;
        }
        j = (UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((xyo)localObject1).a(j, k);
        ((xyo)localObject1).a(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramyeb.a().type != 6) {
          break label642;
        }
        j = k + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298520));
        ((xyo)localObject1).a(paramyeb.a(), paramyeb.a());
        if (weh.a())
        {
          if ((!this.i) || (paramyhc.jdField_b_of_type_Int != 0) || ((!paramyeb.b()) && (!paramyeb.a().isFakeFeedItem()))) {
            break label660;
          }
          ((xyo)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramyeb.a().mIsVideoEnd) {
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
        ((xyo)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramyeb.a().size() == 1)
      {
        j = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramyeb.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramyeb.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Yer);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          wcz.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((weh.a()) && (this.i) && (paramyhc.jdField_b_of_type_Int == 0) && ((paramyeb.b()) || (paramyeb.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167120));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(anvx.a(2131703945));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167120));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramyeb.a().type == 3) && ((paramyeb.a().getOwner() instanceof QQUserUIItem)))
          {
            paramyhc = (QQUserUIItem)paramyeb.a().getOwner();
            if ((paramyhc.isVip) && (!paramyhc.isSubscribe())) {
              ykv.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramyeb.a().type != 6) {
            break;
          }
          ykv.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = wcz.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            ykq.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new yib(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          wcz.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(UIUtils.convertToHHMM(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramyeb.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramyeb.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(UIUtils.convertToHHMM(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramyeb.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wli != null))
            {
              localStoryNickNameView.setFormat(anvx.a(2131703955));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wli.jdField_a_of_type_JavaLangString);
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
    switch (((vzv)wzk.a().getManager(QQManagerFactory.QQSTORY_MANAGER)).a())
    {
    }
    do
    {
      do
      {
        return false;
        ykq.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Wli == null)) {
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
        paramList = anvx.a(2131703956);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = anvx.a(2131703943);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + anvx.a(2131703948);
        paramList = str1;
      }
    }
  }
  
  private void b(List<ydz> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((wjl)wjs.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ydz)paramList.next()).d();
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
      ykq.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new yic(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Ydd.e();
    ykv.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private yhc c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561701, paramViewGroup, false));
    paramViewGroup.a(2131380022).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Yev);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374610);
    yim localyim = new yim(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localyim);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localyim);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localyim);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localyim);
    paramViewGroup.a("general_touch_handler", localyim);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private yhc d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561806, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374601);
    paramViewGroup.a(2131374602).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374600).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374730).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374725).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Yev);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374610);
    yim localyim = new yim(this);
    paramViewGroup.a("general_touch_handler", localyim);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localyim);
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
      ykq.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private yhc e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561632, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374601);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374564).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374572).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Yev);
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
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    ydz localydz = (ydz)this.jdField_a_of_type_Ydd.a().get(paramInt);
    localbkzi.a(anvx.a(2131703940), 5);
    localbkzi.c(2131690697);
    localbkzi.a(new yhq(this, localbkzi, paramInt, localydz));
    localbkzi.a(new yhr(this, paramInt));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
    a(localydz, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!zei.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(wzk.a(), 1, anvx.a(2131703954), 0).a();
      return;
    }
    Object localObject = (ydz)this.jdField_a_of_type_Ydd.a().remove(paramInt);
    if (localObject == null)
    {
      zdl.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((ydz)localObject, "hide_done");
    String str = ((ydz)localObject).a().getOwner().getUnionId();
    long l;
    switch (((ydz)localObject).a().type)
    {
    case 4: 
    default: 
      zdl.a("feed not allow unLike operation type=" + ((ydz)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((ydz)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      zdz.a(str, paramInt, l);
      localObject = ((ydz)localObject).a().feedId;
      Bosses.get().postJob(new yhw(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((ydz)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((ydz)localObject).a()).recommendId;
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
    if (weh.a()) {}
    do
    {
      return;
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anvx.a(2131703941), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anvx.a(2131703949), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anvx.a(2131703942), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (yjc)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((yjc)localObject).a(false);
      }
      a().setSelection(0);
      return;
      ykq.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void P_()
  {
    this.jdField_a_of_type_Ydz = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Ydd.a()).iterator();
      while (localIterator.hasNext())
      {
        ydz localydz = (ydz)localIterator.next();
        if (((localydz instanceof ydy)) && (localydz.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localydz.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Ydz == null))
        {
          this.jdField_a_of_type_Ydz = localydz;
          ykq.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Ydz.toString());
          return;
        }
      }
      ykq.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void R_()
  {
    super.R_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Yer.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Yer.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Ydd.c();
    this.jdField_a_of_type_Ydd.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ydd.a().size();
  }
  
  protected int a(int paramInt)
  {
    ydz localydz = (ydz)this.jdField_a_of_type_Ydd.a().get(paramInt);
    if (localydz.a().type == 1) {
      return 0;
    }
    if (localydz.a().type == 3) {
      return 0;
    }
    if (localydz.a().type == 2) {
      return 0;
    }
    if (localydz.a().type == 5) {
      return 1;
    }
    if (localydz.a().type == 6) {
      return 2;
    }
    if (localydz.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Ydd.a().size())
    {
      localObject1 = (ydz)this.jdField_a_of_type_Ydd.a().get(j);
      if ((((ydz)localObject1).a().type != 1) && (((ydz)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((yhc)localObject1).a(2131374620);
      if (localObject2 != null) {
        break;
      }
      ykq.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374618);
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anvx.a(2131703928), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    ydz localydz = (ydz)this.jdField_a_of_type_Ydd.a().get(paramInt);
    paramyhc.a("feed_id", localydz.a().feedId);
    View localView = paramyhc.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localydz.jdField_b_of_type_Boolean = true;
      d(paramyhc);
      paramyhc = new ArrayList();
      paramyhc.add(localydz);
      b(paramyhc, 0);
      ykv.b("story_home_dev", "feed_exp", localydz.a().type, localydz.d().size(), new String[] { localydz.a().feedId });
      return localView;
      if (localydz.a().type == 1)
      {
        localView = a(paramInt, paramyhc, paramViewGroup, (ycs)localydz);
      }
      else if (localydz.a().type == 2)
      {
        localView = a(paramInt, paramyhc, paramViewGroup, (ydy)localydz);
      }
      else if (localydz.a().type == 3)
      {
        localView = a(paramInt, paramyhc, paramViewGroup, (yct)localydz);
        continue;
        localView = a(paramInt, paramyhc, (ybt)localydz);
        continue;
        localView = a(paramInt, paramyhc, paramViewGroup, (yea)localydz);
        continue;
        localView = a(paramInt, paramyhc, paramViewGroup, (ydv)localydz);
      }
    }
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup, ycs paramycs)
  {
    ykq.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramyhc.a(2131374587);
    FrameLayout localFrameLayout = (FrameLayout)paramyhc.a(2131374591);
    a(paramycs, paramyhc);
    a(paramInt, paramyhc, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyhc, paramycs, paramycs.a().getOwner());
    a(paramyhc, paramycs, true);
    a(paramInt, paramyhc);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167117);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyhc.a("feed_id", paramycs.a().feedId);
    a(paramycs, paramyhc);
    a(paramycs, paramyhc, localFrameLayout, null);
    return paramyhc.a();
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup, ydy paramydy)
  {
    ykq.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramyhc.a(2131374587);
    FrameLayout localFrameLayout = (FrameLayout)paramyhc.a(2131374591);
    a(paramydy, paramyhc);
    a(paramInt, paramyhc, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyhc, paramydy, ((ShareGroupFeedItem)paramydy.a()).getOwner());
    a(paramyhc, paramydy, true);
    a(paramydy, paramyhc);
    a(paramInt, paramyhc);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167117);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyhc.a("feed_id", ((ShareGroupFeedItem)paramydy.a()).feedId);
    paramyhc.a("group_id", ((ShareGroupFeedItem)paramydy.a()).getOwner().shareGroupId);
    a(paramydy, paramyhc, localFrameLayout, ((ShareGroupFeedItem)paramydy.a()).getOwner());
    paramydy.jdField_b_of_type_Boolean = true;
    return paramyhc.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected ydd a(boolean paramBoolean)
  {
    return new ydd(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    blfz.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      blfz.a();
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
  
  protected yhc a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ydd.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((ydz)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      yhc localyhc = a(j);
      if ((localyhc != null) && (paramString.equals(localyhc.a("feed_id")))) {
        return localyhc;
      }
      if (localyhc != null)
      {
        localObject = (ydz)((List)localObject).get(j);
        zdl.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localyhc.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (yhc)localIterator.next();
        if (localObject != null)
        {
          localObject = (wgs)((yhc)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((wgs)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, yhc paramyhc)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374615);
    TextView localTextView = (TextView)paramyhc.a(2131374616);
    ImageView localImageView = (ImageView)paramyhc.a(2131374613);
    if (localRelativeLayout == null) {
      return;
    }
    if (weh.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (ydz)this.jdField_a_of_type_Ydd.a().get(paramInt);
    switch (((ydz)localObject).a().type)
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
      localObject = (BannerFeedItem)((ydz)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        ykq.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = anvx.a(2131703930);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramyhc);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((ydz)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((ydz)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        ykq.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = anvx.a(2131703936);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramyhc);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((ydz)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      ykq.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = anvx.a(2131703927);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramyhc);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, yhc paramyhc, yeb paramyeb, QQUserUIItem paramQQUserUIItem)
  {
    blfz.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramyhc.a(2131374601);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(wzk.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846446));
      blfz.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(UIUtils.getCircleViewByURL(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bheg.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramyhc = "";
      if (paramyeb.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramyhc);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramyeb.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramyhc = localQQStoryOwnerInfoView.a();
      paramyhc.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramyeb.jdField_b_of_type_Boolean) {
        paramyhc.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      blfz.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramyeb.a().type == 3)
      {
        paramyhc = (GeneralRecommendFeedItem)paramyeb.a();
        if (!TextUtils.isEmpty(paramyhc.blurb))
        {
          paramyhc = paramyhc.blurb;
          break label152;
        }
        paramyhc = a(paramyeb.a());
        break label152;
      }
      paramyhc = a(paramyeb.a());
      break label152;
      label296:
      if (paramyeb.a().type == 3) {
        if (yal.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, anvx.a(2131703944), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, yhc paramyhc, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374594);
    blfz.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramyhc.a(2131374593);
    Object localObject1 = (ImageView)paramyhc.a(2131374595);
    paramyhc = (ImageView)paramyhc.a(2131374596);
    Object localObject2 = this.jdField_a_of_type_Ydd.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      blfz.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846524);
      paramyhc.setImageResource(2130846526);
      if (paramInt != 0) {
        break label165;
      }
      paramyhc = UIUtils.convertToCalendar(UIUtils.parseDate(((ydz)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramyhc);
    }
    for (;;)
    {
      blfz.a();
      return;
      ((ImageView)localObject1).setImageResource(2130846523);
      paramyhc.setImageResource(2130846525);
      break;
      label165:
      paramyhc = (ydz)((List)localObject2).get(paramInt - 1);
      localObject2 = (ydz)((List)localObject2).get(paramInt);
      localObject1 = UIUtils.parseDate(paramyhc.a().date);
      localObject2 = UIUtils.parseDate(((ydz)localObject2).a().date);
      if (((paramyhc instanceof ydv)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramyhc = UIUtils.convertToCalendar((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramyhc);
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
        xbp.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      if (!paramQQUserUIItem.isVip()) {
        break label96;
      }
    }
    label96:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      ykv.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
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
      xbp.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      ykv.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      xbp.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          xbp.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = ykv.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        ykv.a("home_page", "clk_card", ykv.a(paramVideoListFeedItem), xyo.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), ykv.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        xbp.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    ykq.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Ydd.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localydz = (ydz)localIterator.next();
      if (paramString1.equals(localydz.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localydz, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      ydz localydz;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(wgm paramwgm, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramwgm.c != null) && (paramwgm.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Yhd.a();
      paramView.setFeedItemData(paramwgm.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramwgm, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wgm paramwgm, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramwgm.c != null) && (paramwgm.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Yhd.a();
      paramViewGroup.setFeedItemData(paramwgm.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramwgm, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wsb paramwsb)
  {
    if ((((Integer)((wjl)wjs.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramwsb.jdField_a_of_type_JavaUtilList != null))
    {
      xbu.a();
      paramwsb = new ArrayList(paramwsb.jdField_a_of_type_JavaUtilList).iterator();
      while (paramwsb.hasNext()) {
        xbu.a(((StoryVideoItem)paramwsb.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(ycs paramycs, yhc paramyhc)
  {
    paramycs = (VideoListLayout)paramyhc.a(2131374620);
    if (paramycs != null)
    {
      paramycs = paramycs.a();
      if (paramycs != null) {
        paramycs.setVisibility(8);
      }
    }
  }
  
  public void a(ycz paramycz)
  {
    boolean bool1 = true;
    ykq.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramycz == null) {
      c(false);
    }
    do
    {
      return;
      if (paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        zdl.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramycz, new Object[0]);
        c(false);
        return;
      }
      ykq.d("Q.qqstory.home:FeedSegment", paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramycz.jdField_b_of_type_JavaUtilList, 0);
    } while (paramycz.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramycz.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramycz.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(ydy paramydy, yhc paramyhc)
  {
    paramydy = (VideoListLayout)paramyhc.a(2131374620);
    if (paramydy != null)
    {
      paramydy = paramydy.a();
      if (paramydy != null) {
        paramydy.setVisibility(8);
      }
    }
  }
  
  public void a(yeb paramyeb)
  {
    ykq.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramyeb);
    if ((paramyeb == null) || (paramyeb.a() == null) || (paramyeb.a().feedId == null))
    {
      ykq.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramyeb.a().feedId);
  }
  
  protected void a(yhc paramyhc)
  {
    Object localObject = (VideoListLayout)paramyhc.a(2131374620);
    ((VideoListLayout)localObject).a().setOnClickListener(paramyhc);
    ((VideoListLayout)localObject).a().setOnClickListener(paramyhc);
    localObject = ((VideoListLayout)localObject).a();
    yim localyim = new yim(this);
    paramyhc.a("general_touch_handler", localyim);
    paramyhc.a("general_adapter", null);
    paramyhc.a(this.jdField_b_of_type_Yev);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localyim);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localyim);
    paramyhc.a("type", "GeneralView");
  }
  
  protected void a(yhc paramyhc, yea paramyea)
  {
    TextView localTextView1 = (TextView)paramyhc.a(2131374728);
    TextView localTextView2 = (TextView)paramyhc.a(2131374727);
    TextView localTextView3 = (TextView)paramyhc.a(2131374730);
    zbd localzbd = ((TagFeedItem)paramyea.a()).tagItem;
    paramyhc = (TextView)paramyhc.a(2131374725);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166513));
      paramyhc.setBackgroundResource(2130846550);
    }
    if (localzbd != null)
    {
      localTextView1.setText(localzbd.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramyea.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramyea.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramyea.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramyea.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(yij paramyij)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ydd.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    ykq.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    ykq.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Ydd.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Yck.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected yhc b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561675, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374601);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    blfz.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Yhd.a()) || (this.jdField_a_of_type_Int != 10))
    {
      blfz.a();
      ykq.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Yhd.a());
      return;
    }
    ykq.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((yhc)localIterator.next()).a(2131374620);
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
        ykq.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374618);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = yex.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yex.a(localQQStoryAutoPlayView);
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
          ykq.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = yex.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yex.c(localQQStoryAutoPlayView);
          break label326;
          k = yex.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yex.b(localQQStoryAutoPlayView);
          break label326;
          ykq.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          ykq.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          blfz.a();
          return;
          ykq.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Ydd.a());
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
    ykq.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(ycz paramycz)
  {
    c(true);
  }
  
  protected void b(yhc paramyhc)
  {
    ((VideoListLayout)paramyhc.a(2131374620)).a().setVisibility(8);
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
    this.jdField_a_of_type_Ydd.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Yer == null) {
      return;
    }
    this.jdField_a_of_type_Yer.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (weh.a()) {
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
      yew.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (yjc)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      ykq.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(yhc paramyhc)
  {
    blfz.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramyhc);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramyhc.a(2131374620);
    if (localVideoListLayout == null)
    {
      blfz.a();
      return;
    }
    paramyhc = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramyhc != null) && (paramyhc.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramyhc != null) && (paramyhc.a() != null)) {
        ykq.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramyhc.a().getThumbUrl());
      }
      if (paramyhc != null) {
        paramyhc.a();
      }
      blfz.a();
      return;
      paramyhc = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramyhc = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramyhc = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramyhc = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131374618);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yik);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yig);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yif);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yil);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yid);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Yii);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Yer.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wgs localwgs = (wgs)((yhc)localIterator.next()).a("commentLikeLego");
      if (localwgs != null) {
        localwgs.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Ydd.b();
    who.a();
  }
  
  public void d(yhc paramyhc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramyhc);
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
    ykq.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int f_()
  {
    return 4;
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new yho(this));
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
      paramMessage = (ycz)paramMessage.obj;
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
      localObject = this.jdField_a_of_type_Yhd.a();
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
        paramMessage = (yhc)localIterator.next();
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
      zdl.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Yhd.a().getLocationOnScreen(arrayOfInt1);
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
        ykq.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (yhc)localIterator.next();
      ykq.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (wgs)((yhc)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((wgs)localObject).c();
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
    ykq.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((wjl)wjs.a(10)).b("mainHallConfig", "");
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
        ykq.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        ykq.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhn
 * JD-Core Version:    0.7.0.1
 */