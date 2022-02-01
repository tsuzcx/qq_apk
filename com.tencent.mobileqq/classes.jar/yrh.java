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

public class yrh
  extends zsv<ymt>
  implements Handler.Callback, IEventReceiver, wpw, wql, yng, yoo, yrg
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ascz(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ascz(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new yrj(this);
  public String a;
  private List<yqw> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private wtt jdField_a_of_type_Wtt;
  private yme jdField_a_of_type_Yme;
  protected ymx a;
  private ynt jdField_a_of_type_Ynt;
  protected yol a;
  yop jdField_a_of_type_Yop = new yrr(this);
  private yqx jdField_a_of_type_Yqx;
  private yrx jdField_a_of_type_Yrx;
  private yrz jdField_a_of_type_Yrz;
  private ysa jdField_a_of_type_Ysa;
  private ysc jdField_a_of_type_Ysc;
  private yse jdField_a_of_type_Yse;
  private ysf jdField_a_of_type_Ysf;
  private final int jdField_b_of_type_Int;
  public String b;
  yop jdField_b_of_type_Yop = new yrs(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  yop jdField_c_of_type_Yop = new yrt(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  yop jdField_d_of_type_Yop = new yru(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public yrh(Context paramContext, Activity paramActivity, int paramInt, yqx paramyqx, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Yqx = paramyqx;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Ymx = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yse = new yse(this);
    this.jdField_a_of_type_Ysa = new ysa(this);
    this.jdField_a_of_type_Yrz = new yrz(this);
    this.jdField_a_of_type_Ysf = new ysf(this);
    this.jdField_a_of_type_Yrx = new yrx(this);
    this.jdField_a_of_type_Ysc = new ysc(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yse);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ysa);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yrz);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ysf);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Yrx);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Ysc);
    this.jdField_a_of_type_Yol = new yol(Looper.myLooper());
    this.jdField_a_of_type_Ymx.a();
    this.jdField_a_of_type_Wtt = ((wtt)wth.a(2));
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Yol.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298440);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298451);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Yol.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Yol.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bhnv.h(paramContext)) {
      return 1;
    }
    if (bhnv.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup, ymn paramymn)
  {
    paramViewGroup = (ImageView)paramyqw.a(2131374581);
    FrameLayout localFrameLayout = (FrameLayout)paramyqw.a(2131374585);
    b(paramyqw);
    a(paramInt, paramyqw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyqw, paramymn, paramymn.a().getOwner());
    a(paramyqw, paramymn, true);
    a(paramymn, paramyqw);
    a(paramInt, paramyqw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167081);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyqw.a("feed_id", paramymn.a().feedId);
    a(paramymn, paramyqw, localFrameLayout, null);
    if (!paramymn.jdField_b_of_type_Boolean) {
      yup.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramymn.a().getOwner().getUnionId(), paramymn.a().feedId });
    }
    paramViewGroup = paramymn.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      yup.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramyqw.a();
  }
  
  private View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup, ynp paramynp)
  {
    paramViewGroup = (VideoListLayout)paramyqw.a(2131374614);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(zps.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((ysg)paramyqw.a("general_touch_handler")).a(paramyqw.jdField_b_of_type_Int, paramyqw);
    if ((paramynp.a() == null) || (paramynp.a().size() == 0))
    {
      yuk.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramynp.a()).feedId);
      paramyqw.a.setVisibility(8);
      return paramyqw.a();
    }
    paramyqw.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (yre)paramyqw.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new yre(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramyqw.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Yol);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramynp.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        yuk.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramynp.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramynp.a().size();
        paramViewGroup.a(paramynp.a(), paramynp.a());
        if (((HotRecommendFeedItem)paramynp.a()).mIsVideoEnd) {
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
        paramViewGroup = paramyqw.a(2131379938);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((wta)wth.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        yup.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup, ynu paramynu)
  {
    paramViewGroup = (ImageView)paramyqw.a(2131374581);
    a(paramInt, paramyqw, this.jdField_d_of_type_Boolean);
    a(paramyqw, paramynu);
    a(paramInt, paramyqw);
    a(paramyqw, paramynu, true);
    a(null, paramyqw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167081);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    yup.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramynu.a()).feedId });
    return paramyqw.a();
  }
  
  private View a(int paramInt, yqw paramyqw, yln paramyln)
  {
    Object localObject = (QQStoryOwnerInfoView)paramyqw.a(2131374595);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramyqw.a(2131374566);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramyqw.a(2131374558);
    FrameLayout localFrameLayout = (FrameLayout)paramyqw.a(2131374560);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramyln.a();
    a(paramInt, paramyqw, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, anzj.a(2131703350), true);
    if (ykf.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      zps.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bhmq.a(1), "QQStory_main");
      a(paramInt, paramyqw);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramyln.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = zps.a(this.jdField_a_of_type_AndroidContentContext) - zps.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (wqg)paramyqw.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new wqg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyln, this.jdField_a_of_type_Int);
      ((wqg)localObject).a(paramyln);
      ((wqg)localObject).l();
      paramyqw.a("commentLikeLego", localObject);
      localFrameLayout.addView(((wqg)localObject).b);
    }
    for (;;)
    {
      ((wqg)localObject).a(this);
      ((wqg)localObject).a(this);
      ((wqg)localObject).a(false);
      if (!paramyln.jdField_b_of_type_Boolean) {
        yup.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramyln.a()).getOwner().getUnionId(), ((BannerFeedItem)paramyln.a()).feedId });
      }
      return paramyqw.a();
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
      ((wqg)localObject).a(paramyln, null, paramyln);
      ((wqg)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      yuk.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = zps.a() / 3600;
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
        return yor.a(j, true);
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
  
  private void a(int paramInt, ynt paramynt, String paramString, boolean paramBoolean)
  {
    if (!(paramynt instanceof ynv)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        yuk.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramynt, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((yqw)localObject1).a(2131374614);
        List localList = ((ynv)paramynt).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            yuk.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= zps.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramynt.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (yii)((yqw)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((yii)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            yuk.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramynt.a().feedId, Integer.valueOf(j));
            yuk.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, yqw paramyqw, ynv paramynv, ShareGroupItem paramShareGroupItem)
  {
    blqm.a("FeedSegment.bindFeedShareGroupInfo");
    paramyqw = (QQStoryOwnerInfoView)paramyqw.a(2131374595);
    if (paramShareGroupItem == null)
    {
      paramyqw.setSubTitle(null);
      paramyqw.setBadge(null);
      paramyqw.setQIMIcon(null);
      paramyqw.setSubTitleSuffix(null);
      paramyqw.setButtonTxt(null);
      paramyqw.setName(xiz.jdField_b_of_type_JavaLangString);
      paramyqw.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846442));
      blqm.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bhmq.a();
      paramyqw.setAvatar(aoot.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramyqw.setName(paramShareGroupItem.getName());
      if (paramynv.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((yns)paramynv).a(), paramynv.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramyqw.setSubTitle((String)localObject1);
        paramyqw.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramyqw.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846807);
      label199:
      if (paramynv.a().type == 2)
      {
        if (!paramynv.a()) {
          break label328;
        }
        a(paramyqw, anzj.a(2131703357), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramyqw = paramyqw.a();
      paramyqw.a(null);
      paramyqw.setVisibility(8);
      blqm.a();
      return;
      paramyqw.setAvatar(((yaz)wth.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846809);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846808);
      break label199;
      label328:
      a(paramyqw, null, false);
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
    blqm.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        yuk.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = yuh.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        yuk.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!yor.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = yuh.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      blqm.a();
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
      yuk.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = zpp.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = zpp.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    localblir.a(anzj.a(2131703352), 5);
    QQUserUIItem localQQUserUIItem = ((wtt)wth.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = anzj.a(2131703353);; str = anzj.a(2131703345))
    {
      localblir.a(str, 5);
      localblir.a(anzj.a(2131703370), 5);
      localblir.c(2131690580);
      localblir.a(new yrm(this, localblir, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localblir.a(new yrp(this));
      if (!localblir.isShowing()) {
        localblir.show();
      }
      yup.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846618);
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
        yoq.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      yoq.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      zps.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = zps.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = zps.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166990));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846546);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166475));
        localButton.setBackgroundResource(2130846546);
      }
      j = zps.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      zps.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846545);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166462));
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
    paramString.setDecodeHandler(zps.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<ynt> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((wta)wth.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ynt)paramList.next()).d();
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
      yuk.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Yol.a(localArrayList);
      return;
    }
  }
  
  private void a(ynt paramynt)
  {
    if ((paramynt == null) || (paramynt.a() == null) || (paramynt.a().getOwner() == null)) {
      znw.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramynt instanceof ymm))
      {
        paramynt = ((ymm)paramynt).a().getOwner();
        wnu.a(this.jdField_a_of_type_AndroidContentContext, 4, paramynt.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramynt instanceof yns))
      {
        paramynt = (ShareGroupFeedItem)((yns)paramynt).a();
        localObject = paramynt.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          yuk.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          znw.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramynt.getOwner().getRelationType() == 2)
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
      if ((paramynt instanceof ymn))
      {
        paramynt = ((ymn)paramynt).a();
        localObject = paramynt.getOwner();
        if (paramynt.getOwner().getRelationType() == 2)
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
        wnu.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramynt instanceof ynu))
      {
        paramynt = (TagFeedItem)((ynu)paramynt).a();
        xjq.a(this.jdField_a_of_type_AndroidAppActivity, paramynt.tagItem.a);
        return;
      }
    } while (!(paramynt instanceof ynp));
    label289:
    l();
    yup.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(ynt paramynt, ShareGroupItem paramShareGroupItem)
  {
    if (yal.a(paramShareGroupItem))
    {
      if (paramynt.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        yup.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, anzj.a(2131703369), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new yam((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    yup.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(ynt paramynt, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramynt.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      yup.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramynt.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(ynv paramynv, yqw paramyqw) {}
  
  private void a(ynv paramynv, yqw paramyqw, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    blqm.a("FeedSegment.bindCommentLike");
    wqg localwqg;
    if (paramynv.a().size() > 0)
    {
      localwqg = (wqg)paramyqw.a("commentLikeLego");
      if (localwqg != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localwqg = wqg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramynv, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramyqw.a("commentLikeLego", localwqg);
      paramFrameLayout.addView(localwqg.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localwqg.k();
        paramynv = paramFrameLayout.getLayoutParams();
        paramynv.height = zps.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramynv);
      }
      for (;;)
      {
        blqm.a();
        return;
        label132:
        localwqg = new wqg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramynv, this.jdField_a_of_type_Int);
        break;
        paramyqw = paramFrameLayout.getLayoutParams();
        paramyqw.height = -2;
        paramFrameLayout.setLayoutParams(paramyqw);
        if (localwqg.a())
        {
          localwqg.a(paramynv, paramShareGroupItem, null);
          localwqg.c(null);
        }
        for (;;)
        {
          localwqg.a(this);
          localwqg.a(this);
          if ((paramynv.a().mVideoPullType != 0) || (paramynv.a().size() <= 1)) {
            break label249;
          }
          localwqg.a(true);
          break;
          localwqg.l();
        }
        label249:
        localwqg.a(false);
      }
    }
  }
  
  private void a(yqw paramyqw, ynv paramynv, boolean paramBoolean)
  {
    blqm.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramyqw.a(2131374614);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(zps.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((ysg)paramyqw.a("general_touch_handler")).a(paramyqw.jdField_b_of_type_Int, paramyqw);
    if ((paramynv.a() == null) || (paramynv.a().size() == 0))
    {
      yuk.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramynv.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      blqm.a();
      return;
    }
    Object localObject1;
    if (paramynv.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (yii)paramyqw.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new yii(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((yii)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramyqw.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((yii)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((yii)localObject1).a(this.jdField_a_of_type_Yol);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramynv.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          yuk.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramynv.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramynv.a().size() != 2) {
          break label563;
        }
        j = (zps.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((yii)localObject1).a(j, k);
        ((yii)localObject1).a(zps.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramynv.a().type != 6) {
          break label642;
        }
        j = k + zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298451));
        ((yii)localObject1).a(paramynv.a(), paramynv.a());
        if (wnv.a())
        {
          if ((!this.i) || (paramyqw.jdField_b_of_type_Int != 0) || ((!paramynv.b()) && (!paramynv.a().isFakeFeedItem()))) {
            break label660;
          }
          ((yii)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramynv.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = zps.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (zps.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = zps.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = zps.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = zps.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + zps.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((yii)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramynv.a().size() == 1)
      {
        j = zps.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(zps.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramynv.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramynv.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Yol);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          wmf.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((wnv.a()) && (this.i) && (paramyqw.jdField_b_of_type_Int == 0) && ((paramynv.b()) || (paramynv.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167084));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(anzj.a(2131703364));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167084));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramynv.a().type == 3) && ((paramynv.a().getOwner() instanceof QQUserUIItem)))
          {
            paramyqw = (QQUserUIItem)paramynv.a().getOwner();
            if ((paramyqw.isVip) && (!paramyqw.isSubscribe())) {
              yup.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramynv.a().type != 6) {
            break;
          }
          yup.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = wmf.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            yuk.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new yrv(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          wmf.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166990));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(zps.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramynv.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramynv.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(zps.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramynv.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wux != null))
            {
              localStoryNickNameView.setFormat(anzj.a(2131703374));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wux.jdField_a_of_type_JavaLangString);
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
    switch (((wjb)xiz.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        yuk.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Wux == null)) {
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
        paramList = anzj.a(2131703375);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = anzj.a(2131703362);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + anzj.a(2131703367);
        paramList = str1;
      }
    }
  }
  
  private void b(List<ynt> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((wta)wth.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ynt)paramList.next()).d();
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
      yuk.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new yrw(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Ymx.e();
    yup.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private yqw c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561755, paramViewGroup, false));
    paramViewGroup.a(2131379938).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Yop);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374604);
    ysg localysg = new ysg(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localysg);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localysg);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localysg);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localysg);
    paramViewGroup.a("general_touch_handler", localysg);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private yqw d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561861, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374595);
    paramViewGroup.a(2131374596).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374594).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374724).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374719).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Yop);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374604);
    ysg localysg = new ysg(this);
    paramViewGroup.a("general_touch_handler", localysg);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localysg);
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
    int k = zps.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      yuk.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private yqw e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561684, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374595);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374558).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374566).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Yop);
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
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    ynt localynt = (ynt)this.jdField_a_of_type_Ymx.a().get(paramInt);
    localblir.a(anzj.a(2131703359), 5);
    localblir.c(2131690580);
    localblir.a(new yrk(this, localblir, paramInt, localynt));
    localblir.a(new yrl(this, paramInt));
    if (!localblir.isShowing()) {
      localblir.show();
    }
    a(localynt, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!zot.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(xiz.a(), 1, anzj.a(2131703373), 0).a();
      return;
    }
    Object localObject = (ynt)this.jdField_a_of_type_Ymx.a().remove(paramInt);
    if (localObject == null)
    {
      znw.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((ynt)localObject, "hide_done");
    String str = ((ynt)localObject).a().getOwner().getUnionId();
    long l;
    switch (((ynt)localObject).a().type)
    {
    case 4: 
    default: 
      znw.a("feed not allow unLike operation type=" + ((ynt)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((ynt)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      zok.a(str, paramInt, l);
      localObject = ((ynt)localObject).a().feedId;
      Bosses.get().postJob(new yrq(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((ynt)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((ynt)localObject).a()).recommendId;
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
    if (wnv.a()) {}
    do
    {
      return;
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anzj.a(2131703360), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anzj.a(2131703368), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anzj.a(2131703361), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (ysw)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((ysw)localObject).a(false);
      }
      a().setSelection(0);
      return;
      yuk.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void T_()
  {
    this.jdField_a_of_type_Ynt = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Ymx.a()).iterator();
      while (localIterator.hasNext())
      {
        ynt localynt = (ynt)localIterator.next();
        if (((localynt instanceof yns)) && (localynt.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localynt.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Ynt == null))
        {
          this.jdField_a_of_type_Ynt = localynt;
          yuk.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Ynt.toString());
          return;
        }
      }
      yuk.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  protected void V_()
  {
    super.V_();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.b();
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null))
    {
      this.jdField_a_of_type_Yol.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Yol.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Ymx.c();
    this.jdField_a_of_type_Ymx.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ymx.a().size();
  }
  
  protected int a(int paramInt)
  {
    ynt localynt = (ynt)this.jdField_a_of_type_Ymx.a().get(paramInt);
    if (localynt.a().type == 1) {
      return 0;
    }
    if (localynt.a().type == 3) {
      return 0;
    }
    if (localynt.a().type == 2) {
      return 0;
    }
    if (localynt.a().type == 5) {
      return 1;
    }
    if (localynt.a().type == 6) {
      return 2;
    }
    if (localynt.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Ymx.a().size())
    {
      localObject1 = (ynt)this.jdField_a_of_type_Ymx.a().get(j);
      if ((((ynt)localObject1).a().type != 1) && (((ynt)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((yqw)localObject1).a(2131374614);
      if (localObject2 != null) {
        break;
      }
      yuk.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374612);
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anzj.a(2131703347), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    ynt localynt = (ynt)this.jdField_a_of_type_Ymx.a().get(paramInt);
    paramyqw.a("feed_id", localynt.a().feedId);
    View localView = paramyqw.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localynt.jdField_b_of_type_Boolean = true;
      d(paramyqw);
      paramyqw = new ArrayList();
      paramyqw.add(localynt);
      b(paramyqw, 0);
      yup.b("story_home_dev", "feed_exp", localynt.a().type, localynt.d().size(), new String[] { localynt.a().feedId });
      return localView;
      if (localynt.a().type == 1)
      {
        localView = a(paramInt, paramyqw, paramViewGroup, (ymm)localynt);
      }
      else if (localynt.a().type == 2)
      {
        localView = a(paramInt, paramyqw, paramViewGroup, (yns)localynt);
      }
      else if (localynt.a().type == 3)
      {
        localView = a(paramInt, paramyqw, paramViewGroup, (ymn)localynt);
        continue;
        localView = a(paramInt, paramyqw, (yln)localynt);
        continue;
        localView = a(paramInt, paramyqw, paramViewGroup, (ynu)localynt);
        continue;
        localView = a(paramInt, paramyqw, paramViewGroup, (ynp)localynt);
      }
    }
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup, ymm paramymm)
  {
    yuk.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramyqw.a(2131374581);
    FrameLayout localFrameLayout = (FrameLayout)paramyqw.a(2131374585);
    a(paramymm, paramyqw);
    a(paramInt, paramyqw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyqw, paramymm, paramymm.a().getOwner());
    a(paramyqw, paramymm, true);
    a(paramInt, paramyqw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167081);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyqw.a("feed_id", paramymm.a().feedId);
    a(paramymm, paramyqw);
    a(paramymm, paramyqw, localFrameLayout, null);
    return paramyqw.a();
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup, yns paramyns)
  {
    yuk.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramyqw.a(2131374581);
    FrameLayout localFrameLayout = (FrameLayout)paramyqw.a(2131374585);
    a(paramyns, paramyqw);
    a(paramInt, paramyqw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramyqw, paramyns, ((ShareGroupFeedItem)paramyns.a()).getOwner());
    a(paramyqw, paramyns, true);
    a(paramyns, paramyqw);
    a(paramInt, paramyqw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167081);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramyqw.a("feed_id", ((ShareGroupFeedItem)paramyns.a()).feedId);
    paramyqw.a("group_id", ((ShareGroupFeedItem)paramyns.a()).getOwner().shareGroupId);
    a(paramyns, paramyqw, localFrameLayout, ((ShareGroupFeedItem)paramyns.a()).getOwner());
    paramyns.jdField_b_of_type_Boolean = true;
    return paramyqw.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected ymx a(boolean paramBoolean)
  {
    return new ymx(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    blqm.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      blqm.a();
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
  
  protected yqw a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ymx.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((ynt)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      yqw localyqw = a(j);
      if ((localyqw != null) && (paramString.equals(localyqw.a("feed_id")))) {
        return localyqw;
      }
      if (localyqw != null)
      {
        localObject = (ynt)((List)localObject).get(j);
        znw.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localyqw.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (yqw)localIterator.next();
        if (localObject != null)
        {
          localObject = (wqg)((yqw)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((wqg)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, yqw paramyqw)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyqw.a(2131374609);
    TextView localTextView = (TextView)paramyqw.a(2131374610);
    ImageView localImageView = (ImageView)paramyqw.a(2131374607);
    if (localRelativeLayout == null) {
      return;
    }
    if (wnv.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (ynt)this.jdField_a_of_type_Ymx.a().get(paramInt);
    switch (((ynt)localObject).a().type)
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
      localObject = (BannerFeedItem)((ynt)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        yuk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = anzj.a(2131703349);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramyqw);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((ynt)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((ynt)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        yuk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = anzj.a(2131703355);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramyqw);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((ynt)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      yuk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = anzj.a(2131703346);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramyqw);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, yqw paramyqw, ynv paramynv, QQUserUIItem paramQQUserUIItem)
  {
    blqm.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramyqw.a(2131374595);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(xiz.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846442));
      blqm.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(zps.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bhmq.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramyqw = "";
      if (paramynv.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramyqw);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramynv.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramyqw = localQQStoryOwnerInfoView.a();
      paramyqw.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramynv.jdField_b_of_type_Boolean) {
        paramyqw.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      blqm.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramynv.a().type == 3)
      {
        paramyqw = (GeneralRecommendFeedItem)paramynv.a();
        if (!TextUtils.isEmpty(paramyqw.blurb))
        {
          paramyqw = paramyqw.blurb;
          break label152;
        }
        paramyqw = a(paramynv.a());
        break label152;
      }
      paramyqw = a(paramynv.a());
      break label152;
      label296:
      if (paramynv.a().type == 3) {
        if (ykf.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, anzj.a(2131703363), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, yqw paramyqw, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyqw.a(2131374588);
    blqm.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramyqw.a(2131374587);
    Object localObject1 = (ImageView)paramyqw.a(2131374589);
    paramyqw = (ImageView)paramyqw.a(2131374590);
    Object localObject2 = this.jdField_a_of_type_Ymx.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      blqm.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846520);
      paramyqw.setImageResource(2130846522);
      if (paramInt != 0) {
        break label165;
      }
      paramyqw = zps.a(zps.a(((ynt)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramyqw);
    }
    for (;;)
    {
      blqm.a();
      return;
      ((ImageView)localObject1).setImageResource(2130846519);
      paramyqw.setImageResource(2130846521);
      break;
      label165:
      paramyqw = (ynt)((List)localObject2).get(paramInt - 1);
      localObject2 = (ynt)((List)localObject2).get(paramInt);
      localObject1 = zps.a(paramyqw.a().date);
      localObject2 = zps.a(((ynt)localObject2).a().date);
      if (((paramyqw instanceof ynp)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramyqw = zps.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramyqw);
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
        xlj.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (wja)xiz.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      yup.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (zps.b()) {
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
      xlj.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      yup.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      xlj.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          xlj.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = yup.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        yup.a("home_page", "clk_card", yup.a(paramVideoListFeedItem), yii.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), yup.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        xlj.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    yuk.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Ymx.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localynt = (ynt)localIterator.next();
      if (paramString1.equals(localynt.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localynt, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      ynt localynt;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(wqa paramwqa, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramwqa.c != null) && (paramwqa.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Yqx.a();
      paramView.setFeedItemData(paramwqa.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramwqa, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wqa paramwqa, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramwqa.c != null) && (paramwqa.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Yqx.a();
      paramViewGroup.setFeedItemData(paramwqa.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramwqa, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(xbq paramxbq)
  {
    if ((((Integer)((wta)wth.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramxbq.jdField_a_of_type_JavaUtilList != null))
    {
      xlo.a();
      paramxbq = new ArrayList(paramxbq.jdField_a_of_type_JavaUtilList).iterator();
      while (paramxbq.hasNext()) {
        xlo.a(((StoryVideoItem)paramxbq.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(ymm paramymm, yqw paramyqw)
  {
    paramymm = (VideoListLayout)paramyqw.a(2131374614);
    if (paramymm != null)
    {
      paramymm = paramymm.a();
      if (paramymm != null) {
        paramymm.setVisibility(8);
      }
    }
  }
  
  public void a(ymt paramymt)
  {
    boolean bool1 = true;
    yuk.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramymt == null) {
      c(false);
    }
    do
    {
      return;
      if (paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        znw.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramymt, new Object[0]);
        c(false);
        return;
      }
      yuk.d("Q.qqstory.home:FeedSegment", paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramymt.jdField_b_of_type_JavaUtilList, 0);
    } while (paramymt.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramymt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramymt.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(yns paramyns, yqw paramyqw)
  {
    paramyns = (VideoListLayout)paramyqw.a(2131374614);
    if (paramyns != null)
    {
      paramyns = paramyns.a();
      if (paramyns != null) {
        paramyns.setVisibility(8);
      }
    }
  }
  
  public void a(ynv paramynv)
  {
    yuk.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramynv);
    if ((paramynv == null) || (paramynv.a() == null) || (paramynv.a().feedId == null))
    {
      yuk.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramynv.a().feedId);
  }
  
  protected void a(yqw paramyqw)
  {
    Object localObject = (VideoListLayout)paramyqw.a(2131374614);
    ((VideoListLayout)localObject).a().setOnClickListener(paramyqw);
    ((VideoListLayout)localObject).a().setOnClickListener(paramyqw);
    localObject = ((VideoListLayout)localObject).a();
    ysg localysg = new ysg(this);
    paramyqw.a("general_touch_handler", localysg);
    paramyqw.a("general_adapter", null);
    paramyqw.a(this.jdField_b_of_type_Yop);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localysg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localysg);
    paramyqw.a("type", "GeneralView");
  }
  
  protected void a(yqw paramyqw, ynu paramynu)
  {
    TextView localTextView1 = (TextView)paramyqw.a(2131374722);
    TextView localTextView2 = (TextView)paramyqw.a(2131374721);
    TextView localTextView3 = (TextView)paramyqw.a(2131374724);
    zlk localzlk = ((TagFeedItem)paramynu.a()).tagItem;
    paramyqw = (TextView)paramyqw.a(2131374719);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166480));
      paramyqw.setBackgroundResource(2130846546);
    }
    if (localzlk != null)
    {
      localTextView1.setText(localzlk.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramynu.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramynu.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramynu.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramynu.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(ysd paramysd)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ymx.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    yuk.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    yuk.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Ymx.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Yme.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected yqw b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561729, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374595);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    blqm.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Yqx.a()) || (this.jdField_a_of_type_Int != 10))
    {
      blqm.a();
      yuk.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Yqx.a());
      return;
    }
    yuk.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((yqw)localIterator.next()).a(2131374614);
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
        yuk.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374612);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = yor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yor.a(localQQStoryAutoPlayView);
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
          yuk.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = yor.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yor.c(localQQStoryAutoPlayView);
          break label326;
          k = yor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = yor.b(localQQStoryAutoPlayView);
          break label326;
          yuk.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          yuk.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          blqm.a();
          return;
          yuk.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Ymx.a());
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
    yuk.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(ymt paramymt)
  {
    c(true);
  }
  
  protected void b(yqw paramyqw)
  {
    ((VideoListLayout)paramyqw.a(2131374614)).a().setVisibility(8);
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
    this.jdField_a_of_type_Ymx.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Yol == null) {
      return;
    }
    this.jdField_a_of_type_Yol.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (wnv.a()) {
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
      yoq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (ysw)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      yuk.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(yqw paramyqw)
  {
    blqm.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramyqw);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramyqw.a(2131374614);
    if (localVideoListLayout == null)
    {
      blqm.a();
      return;
    }
    paramyqw = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramyqw != null) && (paramyqw.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramyqw != null) && (paramyqw.a() != null)) {
        yuk.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramyqw.a().getThumbUrl());
      }
      if (paramyqw != null) {
        paramyqw.a();
      }
      blqm.a();
      return;
      paramyqw = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramyqw = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramyqw = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramyqw = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131374612);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yse);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ysa);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yrz);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ysf);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Yrx);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Ysc);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Yol.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wqg localwqg = (wqg)((yqw)localIterator.next()).a("commentLikeLego");
      if (localwqg != null) {
        localwqg.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Ymx.b();
    wrc.a();
  }
  
  public void d(yqw paramyqw)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramyqw);
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
    yuk.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new yri(this));
    SegmentList localSegmentList = a();
    String str = a();
    if (!a()) {}
    for (boolean bool = true;; bool = false)
    {
      localSegmentList.setLoadMoreComplete(str, true, bool);
      return;
    }
  }
  
  protected int h_()
  {
    return 4;
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
      paramMessage = (ymt)paramMessage.obj;
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
      j = zps.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Yqx.a();
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
        paramMessage = (yqw)localIterator.next();
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
      znw.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = zps.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Yqx.a().getLocationOnScreen(arrayOfInt1);
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
        yuk.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (yqw)localIterator.next();
      yuk.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (wqg)((yqw)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((wqg)localObject).c();
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
    yuk.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((wta)wth.a(10)).b("mainHallConfig", "");
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
        yuk.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        yuk.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrh
 * JD-Core Version:    0.7.0.1
 */