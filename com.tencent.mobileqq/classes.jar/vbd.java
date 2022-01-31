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

public class vbd
  extends wcr<uwp>
  implements Handler.Callback, IEventReceiver, szr, tag, uxc, uyk, vbc
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new anou(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new anou(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new vbf(this);
  public String a;
  private List<vas> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private tdo jdField_a_of_type_Tdo;
  private uwa jdField_a_of_type_Uwa;
  protected uwt a;
  private uxp jdField_a_of_type_Uxp;
  protected uyh a;
  uyl jdField_a_of_type_Uyl = new vbn(this);
  private vat jdField_a_of_type_Vat;
  private vbt jdField_a_of_type_Vbt;
  private vbv jdField_a_of_type_Vbv;
  private vbw jdField_a_of_type_Vbw;
  private vby jdField_a_of_type_Vby;
  private vca jdField_a_of_type_Vca;
  private vcb jdField_a_of_type_Vcb;
  private final int jdField_b_of_type_Int;
  public String b;
  uyl jdField_b_of_type_Uyl = new vbo(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  uyl jdField_c_of_type_Uyl = new vbp(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  uyl jdField_d_of_type_Uyl = new vbq(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public vbd(Context paramContext, Activity paramActivity, int paramInt, vat paramvat, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Vat = paramvat;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Uwt = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Vca = new vca(this);
    this.jdField_a_of_type_Vbw = new vbw(this);
    this.jdField_a_of_type_Vbv = new vbv(this);
    this.jdField_a_of_type_Vcb = new vcb(this);
    this.jdField_a_of_type_Vbt = new vbt(this);
    this.jdField_a_of_type_Vby = new vby(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vca);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vbw);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vbv);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vcb);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vbt);
    ste.a().registerSubscriber(this.jdField_a_of_type_Vby);
    this.jdField_a_of_type_Uyh = new uyh(Looper.myLooper());
    this.jdField_a_of_type_Uwt.a();
    this.jdField_a_of_type_Tdo = ((tdo)tdc.a(2));
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Uyh.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298319);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298330);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Uyh.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Uyh.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bbev.h(paramContext)) {
      return 1;
    }
    if (bbev.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, vas paramvas, ViewGroup paramViewGroup, uwj paramuwj)
  {
    paramViewGroup = (ImageView)paramvas.a(2131373239);
    FrameLayout localFrameLayout = (FrameLayout)paramvas.a(2131373243);
    b(paramvas);
    a(paramInt, paramvas, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvas, paramuwj, paramuwj.a().getOwner());
    a(paramvas, paramuwj, true);
    a(paramuwj, paramvas);
    a(paramInt, paramvas);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvas.a("feed_id", paramuwj.a().feedId);
    a(paramuwj, paramvas, localFrameLayout, null);
    if (!paramuwj.jdField_b_of_type_Boolean) {
      vel.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramuwj.a().getOwner().getUnionId(), paramuwj.a().feedId });
    }
    paramViewGroup = paramuwj.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      vel.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramvas.a();
  }
  
  private View a(int paramInt, vas paramvas, ViewGroup paramViewGroup, uxl paramuxl)
  {
    paramViewGroup = (VideoListLayout)paramvas.a(2131373272);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(vzo.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((vcc)paramvas.a("general_touch_handler")).a(paramvas.jdField_b_of_type_Int, paramvas);
    if ((paramuxl.a() == null) || (paramuxl.a().size() == 0))
    {
      veg.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramuxl.a()).feedId);
      paramvas.a.setVisibility(8);
      return paramvas.a();
    }
    paramvas.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (vba)paramvas.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new vba(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramvas.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Uyh);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramuxl.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        veg.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramuxl.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramuxl.a().size();
        paramViewGroup.a(paramuxl.a(), paramuxl.a());
        if (((HotRecommendFeedItem)paramuxl.a()).mIsVideoEnd) {
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
        paramViewGroup = paramvas.a(2131378251);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((tcv)tdc.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        vel.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, vas paramvas, ViewGroup paramViewGroup, uxq paramuxq)
  {
    paramViewGroup = (ImageView)paramvas.a(2131373239);
    a(paramInt, paramvas, this.jdField_d_of_type_Boolean);
    a(paramvas, paramuxq);
    a(paramInt, paramvas);
    a(paramvas, paramuxq, true);
    a(null, paramvas);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    vel.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramuxq.a()).feedId });
    return paramvas.a();
  }
  
  private View a(int paramInt, vas paramvas, uvj paramuvj)
  {
    Object localObject = (QQStoryOwnerInfoView)paramvas.a(2131373253);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramvas.a(2131373224);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramvas.a(2131373216);
    FrameLayout localFrameLayout = (FrameLayout)paramvas.a(2131373218);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramuvj.a();
    a(paramInt, paramvas, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, ajyc.a(2131704451), true);
    if (uub.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      vzo.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bbdr.a(1), "QQStory_main");
      a(paramInt, paramvas);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramuvj.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext) - vzo.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (tab)paramvas.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new tab(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuvj, this.jdField_a_of_type_Int);
      ((tab)localObject).a(paramuvj);
      ((tab)localObject).l();
      paramvas.a("commentLikeLego", localObject);
      localFrameLayout.addView(((tab)localObject).b);
    }
    for (;;)
    {
      ((tab)localObject).a(this);
      ((tab)localObject).a(this);
      ((tab)localObject).a(false);
      if (!paramuvj.jdField_b_of_type_Boolean) {
        vel.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramuvj.a()).getOwner().getUnionId(), ((BannerFeedItem)paramuvj.a()).feedId });
      }
      return paramvas.a();
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
      ((tab)localObject).a(paramuvj, null, paramuvj);
      ((tab)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      veg.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = vzo.a() / 3600;
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
        return uyn.a(j, true);
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
  
  private void a(int paramInt, uxp paramuxp, String paramString, boolean paramBoolean)
  {
    if (!(paramuxp instanceof uxr)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        veg.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramuxp, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((vas)localObject1).a(2131373272);
        List localList = ((uxr)paramuxp).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            veg.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= vzo.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramuxp.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (use)((vas)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((use)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            veg.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramuxp.a().feedId, Integer.valueOf(j));
            veg.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, vas paramvas, uxr paramuxr, ShareGroupItem paramShareGroupItem)
  {
    bfwd.a("FeedSegment.bindFeedShareGroupInfo");
    paramvas = (QQStoryOwnerInfoView)paramvas.a(2131373253);
    if (paramShareGroupItem == null)
    {
      paramvas.setSubTitle(null);
      paramvas.setBadge(null);
      paramvas.setQIMIcon(null);
      paramvas.setSubTitleSuffix(null);
      paramvas.setButtonTxt(null);
      paramvas.setName(tsu.jdField_b_of_type_JavaLangString);
      paramvas.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845528));
      bfwd.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bbdr.a();
      paramvas.setAvatar(baxt.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramvas.setName(paramShareGroupItem.getName());
      if (paramuxr.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((uxo)paramuxr).a(), paramuxr.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramvas.setSubTitle((String)localObject1);
        paramvas.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramvas.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845893);
      label199:
      if (paramuxr.a().type == 2)
      {
        if (!paramuxr.a()) {
          break label328;
        }
        a(paramvas, ajyc.a(2131704458), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramvas = paramvas.a();
      paramvas.a(null);
      paramvas.setVisibility(8);
      bfwd.a();
      return;
      paramvas.setAvatar(((ukv)tdc.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130845895);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845894);
      break label199;
      label328:
      a(paramvas, null, false);
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
    bfwd.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        veg.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = ved.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        veg.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!uyn.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = ved.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      bfwd.a();
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
      veg.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = vzl.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = vzl.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    localbfol.a(ajyc.a(2131704453), 5);
    QQUserUIItem localQQUserUIItem = ((tdo)tdc.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = ajyc.a(2131704454);; str = ajyc.a(2131704446))
    {
      localbfol.a(str, 5);
      localbfol.a(ajyc.a(2131704471), 5);
      localbfol.c(2131690596);
      localbfol.a(new vbi(this, localbfol, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbfol.a(new vbl(this));
      if (!localbfol.isShowing()) {
        localbfol.show();
      }
      vel.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130845704);
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
        uym.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      uym.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      vzo.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = vzo.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = vzo.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130845632);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166348));
        localButton.setBackgroundResource(2130845632);
      }
      j = vzo.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vzo.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130845631);
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
    paramString.setDecodeHandler(vzo.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<uxp> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((tcv)tdc.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((uxp)paramList.next()).d();
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
      veg.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Uyh.a(localArrayList);
      return;
    }
  }
  
  private void a(uxp paramuxp)
  {
    if ((paramuxp == null) || (paramuxp.a() == null) || (paramuxp.a().getOwner() == null)) {
      vxs.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramuxp instanceof uwi))
      {
        paramuxp = ((uwi)paramuxp).a().getOwner();
        sxp.a(this.jdField_a_of_type_AndroidContentContext, 4, paramuxp.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramuxp instanceof uxo))
      {
        paramuxp = (ShareGroupFeedItem)((uxo)paramuxp).a();
        localObject = paramuxp.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          veg.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          vxs.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramuxp.getOwner().getRelationType() == 2)
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
      if ((paramuxp instanceof uwj))
      {
        paramuxp = ((uwj)paramuxp).a();
        localObject = paramuxp.getOwner();
        if (paramuxp.getOwner().getRelationType() == 2)
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
        sxp.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramuxp instanceof uxq))
      {
        paramuxp = (TagFeedItem)((uxq)paramuxp).a();
        ttl.a(this.jdField_a_of_type_AndroidAppActivity, paramuxp.tagItem.a);
        return;
      }
    } while (!(paramuxp instanceof uxl));
    label289:
    l();
    vel.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(uxp paramuxp, ShareGroupItem paramShareGroupItem)
  {
    if (ukh.a(paramShareGroupItem))
    {
      if (paramuxp.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        vel.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajyc.a(2131704470), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new uki((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    vel.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(uxp paramuxp, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramuxp.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      vel.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramuxp.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(uxr paramuxr, vas paramvas) {}
  
  private void a(uxr paramuxr, vas paramvas, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    bfwd.a("FeedSegment.bindCommentLike");
    tab localtab;
    if (paramuxr.a().size() > 0)
    {
      localtab = (tab)paramvas.a("commentLikeLego");
      if (localtab != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localtab = tab.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuxr, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramvas.a("commentLikeLego", localtab);
      paramFrameLayout.addView(localtab.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localtab.k();
        paramuxr = paramFrameLayout.getLayoutParams();
        paramuxr.height = vzo.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramuxr);
      }
      for (;;)
      {
        bfwd.a();
        return;
        label132:
        localtab = new tab(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuxr, this.jdField_a_of_type_Int);
        break;
        paramvas = paramFrameLayout.getLayoutParams();
        paramvas.height = -2;
        paramFrameLayout.setLayoutParams(paramvas);
        if (localtab.a())
        {
          localtab.a(paramuxr, paramShareGroupItem, null);
          localtab.c(null);
        }
        for (;;)
        {
          localtab.a(this);
          localtab.a(this);
          if ((paramuxr.a().mVideoPullType != 0) || (paramuxr.a().size() <= 1)) {
            break label249;
          }
          localtab.a(true);
          break;
          localtab.l();
        }
        label249:
        localtab.a(false);
      }
    }
  }
  
  private void a(vas paramvas, uxr paramuxr, boolean paramBoolean)
  {
    bfwd.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramvas.a(2131373272);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(vzo.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((vcc)paramvas.a("general_touch_handler")).a(paramvas.jdField_b_of_type_Int, paramvas);
    if ((paramuxr.a() == null) || (paramuxr.a().size() == 0))
    {
      veg.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramuxr.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      bfwd.a();
      return;
    }
    Object localObject1;
    if (paramuxr.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (use)paramvas.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new use(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((use)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramvas.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((use)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((use)localObject1).a(this.jdField_a_of_type_Uyh);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramuxr.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          veg.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramuxr.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramuxr.a().size() != 2) {
          break label563;
        }
        j = (vzo.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((use)localObject1).a(j, k);
        ((use)localObject1).a(vzo.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramuxr.a().type != 6) {
          break label642;
        }
        j = k + vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298330));
        ((use)localObject1).a(paramuxr.a(), paramuxr.a());
        if (sxq.a())
        {
          if ((!this.i) || (paramvas.jdField_b_of_type_Int != 0) || ((!paramuxr.b()) && (!paramuxr.a().isFakeFeedItem()))) {
            break label660;
          }
          ((use)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramuxr.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = vzo.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (vzo.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = vzo.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = vzo.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = vzo.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + vzo.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((use)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramuxr.a().size() == 1)
      {
        j = vzo.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(vzo.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramuxr.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramuxr.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Uyh);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          swa.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((sxq.a()) && (this.i) && (paramvas.jdField_b_of_type_Int == 0) && ((paramuxr.b()) || (paramuxr.a().isFakeFeedItem())))
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
          localTextView.setText(ajyc.a(2131704465));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166941));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramuxr.a().type == 3) && ((paramuxr.a().getOwner() instanceof QQUserUIItem)))
          {
            paramvas = (QQUserUIItem)paramuxr.a().getOwner();
            if ((paramvas.isVip) && (!paramvas.isSubscribe())) {
              vel.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramuxr.a().type != 6) {
            break;
          }
          vel.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = swa.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            veg.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new vbr(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          swa.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(vzo.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramuxr.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramuxr.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(vzo.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramuxr.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Tes != null))
            {
              localStoryNickNameView.setFormat(ajyc.a(2131704475));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Tes.jdField_a_of_type_JavaLangString);
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
    switch (((ssw)tsu.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        veg.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Tes == null)) {
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
        paramList = ajyc.a(2131704476);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = ajyc.a(2131704463);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + ajyc.a(2131704468);
        paramList = str1;
      }
    }
  }
  
  private void b(List<uxp> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((tcv)tdc.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((uxp)paramList.next()).d();
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
      veg.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new vbs(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Uwt.e();
    vel.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private vas c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561272, paramViewGroup, false));
    paramViewGroup.a(2131378251).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Uyl);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131373262);
    vcc localvcc = new vcc(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localvcc);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localvcc);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localvcc);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localvcc);
    paramViewGroup.a("general_touch_handler", localvcc);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private vas d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561378, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131373253);
    paramViewGroup.a(2131373254).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373252).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373383).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373378).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Uyl);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131373262);
    vcc localvcc = new vcc(this);
    paramViewGroup.a("general_touch_handler", localvcc);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localvcc);
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
    int k = vzo.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      veg.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private vas e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561200, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373253);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373216).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131373224).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Uyl);
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
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    uxp localuxp = (uxp)this.jdField_a_of_type_Uwt.a().get(paramInt);
    localbfol.a(ajyc.a(2131704460), 5);
    localbfol.c(2131690596);
    localbfol.a(new vbg(this, localbfol, paramInt, localuxp));
    localbfol.a(new vbh(this, paramInt));
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
    a(localuxp, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!vyp.a(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(tsu.a(), 1, ajyc.a(2131704474), 0).a();
      return;
    }
    Object localObject = (uxp)this.jdField_a_of_type_Uwt.a().remove(paramInt);
    if (localObject == null)
    {
      vxs.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((uxp)localObject, "hide_done");
    String str = ((uxp)localObject).a().getOwner().getUnionId();
    long l;
    switch (((uxp)localObject).a().type)
    {
    case 4: 
    default: 
      vxs.a("feed not allow unLike operation type=" + ((uxp)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((uxp)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      vyg.a(str, paramInt, l);
      localObject = ((uxp)localObject).a().feedId;
      Bosses.get().postJob(new vbm(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((uxp)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((uxp)localObject).a()).recommendId;
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
    if (sxq.a()) {}
    do
    {
      return;
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajyc.a(2131704461), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajyc.a(2131704469), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajyc.a(2131704462), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (vcs)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((vcs)localObject).a(false);
      }
      a().setSelection(0);
      return;
      veg.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void R_()
  {
    this.jdField_a_of_type_Uxp = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Uwt.a()).iterator();
      while (localIterator.hasNext())
      {
        uxp localuxp = (uxp)localIterator.next();
        if (((localuxp instanceof uxo)) && (localuxp.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localuxp.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Uxp == null))
        {
          this.jdField_a_of_type_Uxp = localuxp;
          veg.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Uxp.toString());
          return;
        }
      }
      veg.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
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
      this.jdField_a_of_type_Uyh.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Uyh.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Uwt.c();
    this.jdField_a_of_type_Uwt.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Uwt.a().size();
  }
  
  protected int a(int paramInt)
  {
    uxp localuxp = (uxp)this.jdField_a_of_type_Uwt.a().get(paramInt);
    if (localuxp.a().type == 1) {
      return 0;
    }
    if (localuxp.a().type == 3) {
      return 0;
    }
    if (localuxp.a().type == 2) {
      return 0;
    }
    if (localuxp.a().type == 5) {
      return 1;
    }
    if (localuxp.a().type == 6) {
      return 2;
    }
    if (localuxp.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Uwt.a().size())
    {
      localObject1 = (uxp)this.jdField_a_of_type_Uwt.a().get(j);
      if ((((uxp)localObject1).a().type != 1) && (((uxp)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((vas)localObject1).a(2131373272);
      if (localObject2 != null) {
        break;
      }
      veg.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131373270);
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajyc.a(2131704448), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    uxp localuxp = (uxp)this.jdField_a_of_type_Uwt.a().get(paramInt);
    paramvas.a("feed_id", localuxp.a().feedId);
    View localView = paramvas.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localuxp.jdField_b_of_type_Boolean = true;
      d(paramvas);
      paramvas = new ArrayList();
      paramvas.add(localuxp);
      b(paramvas, 0);
      vel.b("story_home_dev", "feed_exp", localuxp.a().type, localuxp.d().size(), new String[] { localuxp.a().feedId });
      return localView;
      if (localuxp.a().type == 1)
      {
        localView = a(paramInt, paramvas, paramViewGroup, (uwi)localuxp);
      }
      else if (localuxp.a().type == 2)
      {
        localView = a(paramInt, paramvas, paramViewGroup, (uxo)localuxp);
      }
      else if (localuxp.a().type == 3)
      {
        localView = a(paramInt, paramvas, paramViewGroup, (uwj)localuxp);
        continue;
        localView = a(paramInt, paramvas, (uvj)localuxp);
        continue;
        localView = a(paramInt, paramvas, paramViewGroup, (uxq)localuxp);
        continue;
        localView = a(paramInt, paramvas, paramViewGroup, (uxl)localuxp);
      }
    }
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup, uwi paramuwi)
  {
    veg.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramvas.a(2131373239);
    FrameLayout localFrameLayout = (FrameLayout)paramvas.a(2131373243);
    a(paramuwi, paramvas);
    a(paramInt, paramvas, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvas, paramuwi, paramuwi.a().getOwner());
    a(paramvas, paramuwi, true);
    a(paramInt, paramvas);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvas.a("feed_id", paramuwi.a().feedId);
    a(paramuwi, paramvas);
    a(paramuwi, paramvas, localFrameLayout, null);
    return paramvas.a();
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup, uxo paramuxo)
  {
    veg.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramvas.a(2131373239);
    FrameLayout localFrameLayout = (FrameLayout)paramvas.a(2131373243);
    a(paramuxo, paramvas);
    a(paramInt, paramvas, this.jdField_d_of_type_Boolean);
    a(paramInt, paramvas, paramuxo, ((ShareGroupFeedItem)paramuxo.a()).getOwner());
    a(paramvas, paramuxo, true);
    a(paramuxo, paramvas);
    a(paramInt, paramvas);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166938);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramvas.a("feed_id", ((ShareGroupFeedItem)paramuxo.a()).feedId);
    paramvas.a("group_id", ((ShareGroupFeedItem)paramuxo.a()).getOwner().shareGroupId);
    a(paramuxo, paramvas, localFrameLayout, ((ShareGroupFeedItem)paramuxo.a()).getOwner());
    paramuxo.jdField_b_of_type_Boolean = true;
    return paramvas.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected uwt a(boolean paramBoolean)
  {
    return new uwt(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    bfwd.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      bfwd.a();
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
  
  protected vas a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Uwt.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((uxp)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      vas localvas = a(j);
      if ((localvas != null) && (paramString.equals(localvas.a("feed_id")))) {
        return localvas;
      }
      if (localvas != null)
      {
        localObject = (uxp)((List)localObject).get(j);
        vxs.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localvas.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (vas)localIterator.next();
        if (localObject != null)
        {
          localObject = (tab)((vas)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((tab)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, vas paramvas)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373267);
    TextView localTextView = (TextView)paramvas.a(2131373268);
    ImageView localImageView = (ImageView)paramvas.a(2131373265);
    if (localRelativeLayout == null) {
      return;
    }
    if (sxq.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (uxp)this.jdField_a_of_type_Uwt.a().get(paramInt);
    switch (((uxp)localObject).a().type)
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
      localObject = (BannerFeedItem)((uxp)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        veg.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajyc.a(2131704450);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramvas);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((uxp)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((uxp)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        veg.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajyc.a(2131704456);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramvas);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((uxp)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      veg.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = ajyc.a(2131704447);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramvas);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, vas paramvas, uxr paramuxr, QQUserUIItem paramQQUserUIItem)
  {
    bfwd.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramvas.a(2131373253);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(tsu.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845528));
      bfwd.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(vzo.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bbdr.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramvas = "";
      if (paramuxr.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramvas);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramuxr.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramvas = localQQStoryOwnerInfoView.a();
      paramvas.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramuxr.jdField_b_of_type_Boolean) {
        paramvas.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      bfwd.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramuxr.a().type == 3)
      {
        paramvas = (GeneralRecommendFeedItem)paramuxr.a();
        if (!TextUtils.isEmpty(paramvas.blurb))
        {
          paramvas = paramvas.blurb;
          break label152;
        }
        paramvas = a(paramuxr.a());
        break label152;
      }
      paramvas = a(paramuxr.a());
      break label152;
      label296:
      if (paramuxr.a().type == 3) {
        if (uub.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, ajyc.a(2131704464), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, vas paramvas, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373246);
    bfwd.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramvas.a(2131373245);
    Object localObject1 = (ImageView)paramvas.a(2131373247);
    paramvas = (ImageView)paramvas.a(2131373248);
    Object localObject2 = this.jdField_a_of_type_Uwt.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      bfwd.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130845606);
      paramvas.setImageResource(2130845608);
      if (paramInt != 0) {
        break label165;
      }
      paramvas = vzo.a(vzo.a(((uxp)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramvas);
    }
    for (;;)
    {
      bfwd.a();
      return;
      ((ImageView)localObject1).setImageResource(2130845605);
      paramvas.setImageResource(2130845607);
      break;
      label165:
      paramvas = (uxp)((List)localObject2).get(paramInt - 1);
      localObject2 = (uxp)((List)localObject2).get(paramInt);
      localObject1 = vzo.a(paramvas.a().date);
      localObject2 = vzo.a(((uxp)localObject2).a().date);
      if (((paramvas instanceof uxl)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramvas = vzo.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramvas);
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
        tvf.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (ssv)tsu.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      vel.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vzo.b()) {
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
      tvf.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      vel.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      tvf.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          tvf.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = vel.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        vel.a("home_page", "clk_card", vel.a(paramVideoListFeedItem), use.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), vel.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        tvf.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    veg.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Uwt.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localuxp = (uxp)localIterator.next();
      if (paramString1.equals(localuxp.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localuxp, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      uxp localuxp;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(szv paramszv, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramszv.c != null) && (paramszv.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Vat.a();
      paramView.setFeedItemData(paramszv.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramszv, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(szv paramszv, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramszv.c != null) && (paramszv.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Vat.a();
      paramViewGroup.setFeedItemData(paramszv.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramszv, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(tll paramtll)
  {
    if ((((Integer)((tcv)tdc.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramtll.jdField_a_of_type_JavaUtilList != null))
    {
      tvk.a();
      paramtll = new ArrayList(paramtll.jdField_a_of_type_JavaUtilList).iterator();
      while (paramtll.hasNext()) {
        tvk.a(((StoryVideoItem)paramtll.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(uwi paramuwi, vas paramvas)
  {
    paramuwi = (VideoListLayout)paramvas.a(2131373272);
    if (paramuwi != null)
    {
      paramuwi = paramuwi.a();
      if (paramuwi != null) {
        paramuwi.setVisibility(8);
      }
    }
  }
  
  public void a(uwp paramuwp)
  {
    boolean bool1 = true;
    veg.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramuwp == null) {
      c(false);
    }
    do
    {
      return;
      if (paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        vxs.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramuwp, new Object[0]);
        c(false);
        return;
      }
      veg.d("Q.qqstory.home:FeedSegment", paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramuwp.jdField_b_of_type_JavaUtilList, 0);
    } while (paramuwp.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramuwp.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramuwp.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(uxo paramuxo, vas paramvas)
  {
    paramuxo = (VideoListLayout)paramvas.a(2131373272);
    if (paramuxo != null)
    {
      paramuxo = paramuxo.a();
      if (paramuxo != null) {
        paramuxo.setVisibility(8);
      }
    }
  }
  
  public void a(uxr paramuxr)
  {
    veg.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramuxr);
    if ((paramuxr == null) || (paramuxr.a() == null) || (paramuxr.a().feedId == null))
    {
      veg.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramuxr.a().feedId);
  }
  
  protected void a(vas paramvas)
  {
    Object localObject = (VideoListLayout)paramvas.a(2131373272);
    ((VideoListLayout)localObject).a().setOnClickListener(paramvas);
    ((VideoListLayout)localObject).a().setOnClickListener(paramvas);
    localObject = ((VideoListLayout)localObject).a();
    vcc localvcc = new vcc(this);
    paramvas.a("general_touch_handler", localvcc);
    paramvas.a("general_adapter", null);
    paramvas.a(this.jdField_b_of_type_Uyl);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localvcc);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localvcc);
    paramvas.a("type", "GeneralView");
  }
  
  protected void a(vas paramvas, uxq paramuxq)
  {
    TextView localTextView1 = (TextView)paramvas.a(2131373381);
    TextView localTextView2 = (TextView)paramvas.a(2131373380);
    TextView localTextView3 = (TextView)paramvas.a(2131373383);
    vvg localvvg = ((TagFeedItem)paramuxq.a()).tagItem;
    paramvas = (TextView)paramvas.a(2131373378);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166353));
      paramvas.setBackgroundResource(2130845632);
    }
    if (localvvg != null)
    {
      localTextView1.setText(localvvg.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramuxq.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramuxq.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramuxq.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramuxq.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(vbz paramvbz)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Uwt.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    veg.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    veg.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Uwt.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Uwa.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected vas b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561245, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131373253);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    bfwd.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Vat.a()) || (this.jdField_a_of_type_Int != 10))
    {
      bfwd.a();
      veg.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Vat.a());
      return;
    }
    veg.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((vas)localIterator.next()).a(2131373272);
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
        veg.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131373270);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = uyn.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyn.a(localQQStoryAutoPlayView);
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
          veg.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = uyn.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyn.c(localQQStoryAutoPlayView);
          break label326;
          k = uyn.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = uyn.b(localQQStoryAutoPlayView);
          break label326;
          veg.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          veg.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          bfwd.a();
          return;
          veg.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Uwt.a());
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
    veg.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(uwp paramuwp)
  {
    c(true);
  }
  
  protected void b(vas paramvas)
  {
    ((VideoListLayout)paramvas.a(2131373272)).a().setVisibility(8);
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
    this.jdField_a_of_type_Uwt.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Uyh == null) {
      return;
    }
    this.jdField_a_of_type_Uyh.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (sxq.a()) {
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
      uym.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (vcs)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      veg.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(vas paramvas)
  {
    bfwd.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramvas);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramvas.a(2131373272);
    if (localVideoListLayout == null)
    {
      bfwd.a();
      return;
    }
    paramvas = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramvas != null) && (paramvas.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramvas != null) && (paramvas.a() != null)) {
        veg.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramvas.a().getThumbUrl());
      }
      if (paramvas != null) {
        paramvas.a();
      }
      bfwd.a();
      return;
      paramvas = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramvas = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramvas = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramvas = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131373270);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vca);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vbw);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vbv);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vcb);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vbt);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Vby);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Uyh.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      tab localtab = (tab)((vas)localIterator.next()).a("commentLikeLego");
      if (localtab != null) {
        localtab.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Uwt.b();
    tax.a();
  }
  
  public void d(vas paramvas)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramvas);
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
    veg.b("Q.qqstory.home:FeedSegment", "tag list update");
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
    a().setOnLoadMoreListener(a(), new vbe(this));
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
      paramMessage = (uwp)paramMessage.obj;
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
      j = vzo.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Vat.a();
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
        paramMessage = (vas)localIterator.next();
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
      vxs.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = vzo.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Vat.a().getLocationOnScreen(arrayOfInt1);
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
        veg.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (vas)localIterator.next();
      veg.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (tab)((vas)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((tab)localObject).c();
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
    veg.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((tcv)tdc.a(10)).b("mainHallConfig", "");
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
        veg.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        veg.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbd
 * JD-Core Version:    0.7.0.1
 */