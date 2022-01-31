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

public class uoh
  extends vpv<ujt>
  implements Handler.Callback, IEventReceiver, smv, snk, ukg, ulo, uog
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new amym(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new amym(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new uoj(this);
  public String a;
  private List<unw> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private sqs jdField_a_of_type_Sqs;
  private uje jdField_a_of_type_Uje;
  protected ujx a;
  private ukt jdField_a_of_type_Ukt;
  protected ull a;
  ulp jdField_a_of_type_Ulp = new uor(this);
  private unx jdField_a_of_type_Unx;
  private uox jdField_a_of_type_Uox;
  private uoz jdField_a_of_type_Uoz;
  private upa jdField_a_of_type_Upa;
  private upc jdField_a_of_type_Upc;
  private upe jdField_a_of_type_Upe;
  private upf jdField_a_of_type_Upf;
  private final int jdField_b_of_type_Int;
  public String b;
  ulp jdField_b_of_type_Ulp = new uos(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  ulp jdField_c_of_type_Ulp = new uot(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  ulp jdField_d_of_type_Ulp = new uou(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public uoh(Context paramContext, Activity paramActivity, int paramInt, unx paramunx, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Unx = paramunx;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Ujx = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Upe = new upe(this);
    this.jdField_a_of_type_Upa = new upa(this);
    this.jdField_a_of_type_Uoz = new uoz(this);
    this.jdField_a_of_type_Upf = new upf(this);
    this.jdField_a_of_type_Uox = new uox(this);
    this.jdField_a_of_type_Upc = new upc(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Upe);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Upa);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uoz);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Upf);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Uox);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Upc);
    this.jdField_a_of_type_Ull = new ull(Looper.myLooper());
    this.jdField_a_of_type_Ujx.a();
    this.jdField_a_of_type_Sqs = ((sqs)sqg.a(2));
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Ull.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131167226);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131167237);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Ull.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Ull.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (badq.h(paramContext)) {
      return 1;
    }
    if (badq.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, unw paramunw, ViewGroup paramViewGroup, ujn paramujn)
  {
    paramViewGroup = (ImageView)paramunw.a(2131307526);
    FrameLayout localFrameLayout = (FrameLayout)paramunw.a(2131307530);
    b(paramunw);
    a(paramInt, paramunw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramunw, paramujn, paramujn.a().getOwner());
    a(paramunw, paramujn, true);
    a(paramujn, paramunw);
    a(paramInt, paramunw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101343);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramunw.a("feed_id", paramujn.a().feedId);
    a(paramujn, paramunw, localFrameLayout, null);
    if (!paramujn.jdField_b_of_type_Boolean) {
      urp.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramujn.a().getOwner().getUnionId(), paramujn.a().feedId });
    }
    paramViewGroup = paramujn.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      urp.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramunw.a();
  }
  
  private View a(int paramInt, unw paramunw, ViewGroup paramViewGroup, ukp paramukp)
  {
    paramViewGroup = (VideoListLayout)paramunw.a(2131307559);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(vms.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((upg)paramunw.a("general_touch_handler")).a(paramunw.jdField_b_of_type_Int, paramunw);
    if ((paramukp.a() == null) || (paramukp.a().size() == 0))
    {
      urk.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramukp.a()).feedId);
      paramunw.a.setVisibility(8);
      return paramunw.a();
    }
    paramunw.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (uoe)paramunw.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new uoe(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramunw.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Ull);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramukp.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        urk.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramukp.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramukp.a().size();
        paramViewGroup.a(paramukp.a(), paramukp.a());
        if (((HotRecommendFeedItem)paramukp.a()).mIsVideoEnd) {
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
        paramViewGroup = paramunw.a(2131312423);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((spz)sqg.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        urp.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, unw paramunw, ViewGroup paramViewGroup, uku paramuku)
  {
    paramViewGroup = (ImageView)paramunw.a(2131307526);
    a(paramInt, paramunw, this.jdField_d_of_type_Boolean);
    a(paramunw, paramuku);
    a(paramInt, paramunw);
    a(paramunw, paramuku, true);
    a(null, paramunw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101343);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    urp.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramuku.a()).feedId });
    return paramunw.a();
  }
  
  private View a(int paramInt, unw paramunw, uin paramuin)
  {
    Object localObject = (QQStoryOwnerInfoView)paramunw.a(2131307540);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramunw.a(2131307511);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramunw.a(2131307503);
    FrameLayout localFrameLayout = (FrameLayout)paramunw.a(2131307505);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramuin.a();
    a(paramInt, paramunw, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, ajjy.a(2131638666), true);
    if (uhf.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      vms.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bacm.a(1), "QQStory_main");
      a(paramInt, paramunw);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramuin.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext) - vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (snf)paramunw.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new snf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramuin, this.jdField_a_of_type_Int);
      ((snf)localObject).a(paramuin);
      ((snf)localObject).l();
      paramunw.a("commentLikeLego", localObject);
      localFrameLayout.addView(((snf)localObject).b);
    }
    for (;;)
    {
      ((snf)localObject).a(this);
      ((snf)localObject).a(this);
      ((snf)localObject).a(false);
      if (!paramuin.jdField_b_of_type_Boolean) {
        urp.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramuin.a()).getOwner().getUnionId(), ((BannerFeedItem)paramuin.a()).feedId });
      }
      return paramunw.a();
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
      ((snf)localObject).a(paramuin, null, paramuin);
      ((snf)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      urk.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = vms.a() / 3600;
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
        return ulr.a(j, true);
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
  
  private void a(int paramInt, ukt paramukt, String paramString, boolean paramBoolean)
  {
    if (!(paramukt instanceof ukv)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        urk.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramukt, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((unw)localObject1).a(2131307559);
        List localList = ((ukv)paramukt).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            urk.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= vms.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramukt.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (ufi)((unw)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((ufi)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            urk.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramukt.a().feedId, Integer.valueOf(j));
            urk.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, unw paramunw, ukv paramukv, ShareGroupItem paramShareGroupItem)
  {
    beoj.a("FeedSegment.bindFeedShareGroupInfo");
    paramunw = (QQStoryOwnerInfoView)paramunw.a(2131307540);
    if (paramShareGroupItem == null)
    {
      paramunw.setSubTitle(null);
      paramunw.setBadge(null);
      paramunw.setQIMIcon(null);
      paramunw.setSubTitleSuffix(null);
      paramunw.setButtonTxt(null);
      paramunw.setName(tfy.jdField_b_of_type_JavaLangString);
      paramunw.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845344));
      beoj.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bacm.a();
      paramunw.setAvatar(azwp.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramunw.setName(paramShareGroupItem.getName());
      if (paramukv.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((uks)paramukv).a(), paramukv.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramunw.setSubTitle((String)localObject1);
        paramunw.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramunw.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845711);
      label199:
      if (paramukv.a().type == 2)
      {
        if (!paramukv.a()) {
          break label328;
        }
        a(paramunw, ajjy.a(2131638673), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramunw = paramunw.a();
      paramunw.a(null);
      paramunw.setVisibility(8);
      beoj.a();
      return;
      paramunw.setAvatar(((txz)sqg.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130845713);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130845712);
      break label199;
      label328:
      a(paramunw, null, false);
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
    beoj.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        urk.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = urh.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        urk.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!ulr.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = urh.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      beoj.a();
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
      urk.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = vmp.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = vmp.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
    localbegr.a(ajjy.a(2131638668), 5);
    QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = ajjy.a(2131638669);; str = ajjy.a(2131638661))
    {
      localbegr.a(str, 5);
      localbegr.a(ajjy.a(2131638686), 5);
      localbegr.c(2131625035);
      localbegr.a(new uom(this, localbegr, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbegr.a(new uop(this));
      if (!localbegr.isShowing()) {
        localbegr.show();
      }
      urp.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130845521);
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
        ulq.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      ulq.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      vms.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = vms.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = vms.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130845448);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100755));
        localButton.setBackgroundResource(2130845448);
      }
      j = vms.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vms.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130845447);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100742));
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
    paramString.setDecodeHandler(vms.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<ukt> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((spz)sqg.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ukt)paramList.next()).d();
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
      urk.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Ull.a(localArrayList);
      return;
    }
  }
  
  private void a(ukt paramukt)
  {
    if ((paramukt == null) || (paramukt.a() == null) || (paramukt.a().getOwner() == null)) {
      vkw.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramukt instanceof ujm))
      {
        paramukt = ((ujm)paramukt).a().getOwner();
        skt.a(this.jdField_a_of_type_AndroidContentContext, 4, paramukt.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramukt instanceof uks))
      {
        paramukt = (ShareGroupFeedItem)((uks)paramukt).a();
        localObject = paramukt.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          urk.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          vkw.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramukt.getOwner().getRelationType() == 2)
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
      if ((paramukt instanceof ujn))
      {
        paramukt = ((ujn)paramukt).a();
        localObject = paramukt.getOwner();
        if (paramukt.getOwner().getRelationType() == 2)
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
        skt.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramukt instanceof uku))
      {
        paramukt = (TagFeedItem)((uku)paramukt).a();
        tgp.a(this.jdField_a_of_type_AndroidAppActivity, paramukt.tagItem.a);
        return;
      }
    } while (!(paramukt instanceof ukp));
    label289:
    l();
    urp.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(ukt paramukt, ShareGroupItem paramShareGroupItem)
  {
    if (txl.a(paramShareGroupItem))
    {
      if (paramukt.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        urp.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131638685), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new txm((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    urp.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(ukt paramukt, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramukt.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      urp.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramukt.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(ukv paramukv, unw paramunw) {}
  
  private void a(ukv paramukv, unw paramunw, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    beoj.a("FeedSegment.bindCommentLike");
    snf localsnf;
    if (paramukv.a().size() > 0)
    {
      localsnf = (snf)paramunw.a("commentLikeLego");
      if (localsnf != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localsnf = snf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramukv, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramunw.a("commentLikeLego", localsnf);
      paramFrameLayout.addView(localsnf.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localsnf.k();
        paramukv = paramFrameLayout.getLayoutParams();
        paramukv.height = vms.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramukv);
      }
      for (;;)
      {
        beoj.a();
        return;
        label132:
        localsnf = new snf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramukv, this.jdField_a_of_type_Int);
        break;
        paramunw = paramFrameLayout.getLayoutParams();
        paramunw.height = -2;
        paramFrameLayout.setLayoutParams(paramunw);
        if (localsnf.a())
        {
          localsnf.a(paramukv, paramShareGroupItem, null);
          localsnf.c(null);
        }
        for (;;)
        {
          localsnf.a(this);
          localsnf.a(this);
          if ((paramukv.a().mVideoPullType != 0) || (paramukv.a().size() <= 1)) {
            break label249;
          }
          localsnf.a(true);
          break;
          localsnf.l();
        }
        label249:
        localsnf.a(false);
      }
    }
  }
  
  private void a(unw paramunw, ukv paramukv, boolean paramBoolean)
  {
    beoj.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramunw.a(2131307559);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(vms.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((upg)paramunw.a("general_touch_handler")).a(paramunw.jdField_b_of_type_Int, paramunw);
    if ((paramukv.a() == null) || (paramukv.a().size() == 0))
    {
      urk.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramukv.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      beoj.a();
      return;
    }
    Object localObject1;
    if (paramukv.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (ufi)paramunw.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new ufi(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((ufi)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramunw.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((ufi)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((ufi)localObject1).a(this.jdField_a_of_type_Ull);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramukv.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          urk.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramukv.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramukv.a().size() != 2) {
          break label563;
        }
        j = (vms.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((ufi)localObject1).a(j, k);
        ((ufi)localObject1).a(vms.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramukv.a().type != 6) {
          break label642;
        }
        j = k + vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167237));
        ((ufi)localObject1).a(paramukv.a(), paramukv.a());
        if (sku.a())
        {
          if ((!this.i) || (paramunw.jdField_b_of_type_Int != 0) || ((!paramukv.b()) && (!paramukv.a().isFakeFeedItem()))) {
            break label660;
          }
          ((ufi)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramukv.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = vms.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (vms.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = vms.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = vms.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = vms.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + vms.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((ufi)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramukv.a().size() == 1)
      {
        j = vms.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(vms.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramukv.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramukv.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Ull);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          sje.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((sku.a()) && (this.i) && (paramunw.jdField_b_of_type_Int == 0) && ((paramukv.b()) || (paramukv.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101346));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(ajjy.a(2131638680));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101346));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramukv.a().type == 3) && ((paramukv.a().getOwner() instanceof QQUserUIItem)))
          {
            paramunw = (QQUserUIItem)paramukv.a().getOwner();
            if ((paramunw.isVip) && (!paramunw.isSubscribe())) {
              urp.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramukv.a().type != 6) {
            break;
          }
          urp.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = sje.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            urk.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new uov(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          sje.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(vms.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramukv.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramukv.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(vms.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramukv.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Srw != null))
            {
              localStoryNickNameView.setFormat(ajjy.a(2131638690));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Srw.jdField_a_of_type_JavaLangString);
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
    switch (((sga)tfy.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        urk.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Srw == null)) {
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
        paramList = ajjy.a(2131638691);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = ajjy.a(2131638678);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + ajjy.a(2131638683);
        paramList = str1;
      }
    }
  }
  
  private void b(List<ukt> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((spz)sqg.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((ukt)paramList.next()).d();
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
      urk.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new uow(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Ujx.e();
    urp.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private unw c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495681, paramViewGroup, false));
    paramViewGroup.a(2131312423).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Ulp);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131307549);
    upg localupg = new upg(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localupg);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localupg);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localupg);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localupg);
    paramViewGroup.a("general_touch_handler", localupg);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private unw d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495787, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131307540);
    paramViewGroup.a(2131307541).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131307539).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131307670).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131307665).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Ulp);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131307549);
    upg localupg = new upg(this);
    paramViewGroup.a("general_touch_handler", localupg);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localupg);
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
    int k = vms.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      urk.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private unw e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495609, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131307540);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131307503).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131307511).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Ulp);
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
    begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
    ukt localukt = (ukt)this.jdField_a_of_type_Ujx.a().get(paramInt);
    localbegr.a(ajjy.a(2131638675), 5);
    localbegr.c(2131625035);
    localbegr.a(new uok(this, localbegr, paramInt, localukt));
    localbegr.a(new uol(this, paramInt));
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
    a(localukt, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!vlt.a(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(tfy.a(), 1, ajjy.a(2131638689), 0).a();
      return;
    }
    Object localObject = (ukt)this.jdField_a_of_type_Ujx.a().remove(paramInt);
    if (localObject == null)
    {
      vkw.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((ukt)localObject, "hide_done");
    String str = ((ukt)localObject).a().getOwner().getUnionId();
    long l;
    switch (((ukt)localObject).a().type)
    {
    case 4: 
    default: 
      vkw.a("feed not allow unLike operation type=" + ((ukt)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((ukt)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      vlk.a(str, paramInt, l);
      localObject = ((ukt)localObject).a().feedId;
      Bosses.get().postJob(new uoq(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((ukt)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((ukt)localObject).a()).recommendId;
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
    if (sku.a()) {}
    do
    {
      return;
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajjy.a(2131638676), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajjy.a(2131638684), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajjy.a(2131638677), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (upw)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((upw)localObject).a(false);
      }
      a().setSelection(0);
      return;
      urk.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void T_()
  {
    this.jdField_a_of_type_Ukt = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Ujx.a()).iterator();
      while (localIterator.hasNext())
      {
        ukt localukt = (ukt)localIterator.next();
        if (((localukt instanceof uks)) && (localukt.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localukt.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Ukt == null))
        {
          this.jdField_a_of_type_Ukt = localukt;
          urk.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Ukt.toString());
          return;
        }
      }
      urk.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
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
      this.jdField_a_of_type_Ull.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Ull.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Ujx.c();
    this.jdField_a_of_type_Ujx.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ujx.a().size();
  }
  
  protected int a(int paramInt)
  {
    ukt localukt = (ukt)this.jdField_a_of_type_Ujx.a().get(paramInt);
    if (localukt.a().type == 1) {
      return 0;
    }
    if (localukt.a().type == 3) {
      return 0;
    }
    if (localukt.a().type == 2) {
      return 0;
    }
    if (localukt.a().type == 5) {
      return 1;
    }
    if (localukt.a().type == 6) {
      return 2;
    }
    if (localukt.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Ujx.a().size())
    {
      localObject1 = (ukt)this.jdField_a_of_type_Ujx.a().get(j);
      if ((((ukt)localObject1).a().type != 1) && (((ukt)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((unw)localObject1).a(2131307559);
      if (localObject2 != null) {
        break;
      }
      urk.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131307557);
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { ajjy.a(2131638663), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    ukt localukt = (ukt)this.jdField_a_of_type_Ujx.a().get(paramInt);
    paramunw.a("feed_id", localukt.a().feedId);
    View localView = paramunw.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localukt.jdField_b_of_type_Boolean = true;
      d(paramunw);
      paramunw = new ArrayList();
      paramunw.add(localukt);
      b(paramunw, 0);
      urp.b("story_home_dev", "feed_exp", localukt.a().type, localukt.d().size(), new String[] { localukt.a().feedId });
      return localView;
      if (localukt.a().type == 1)
      {
        localView = a(paramInt, paramunw, paramViewGroup, (ujm)localukt);
      }
      else if (localukt.a().type == 2)
      {
        localView = a(paramInt, paramunw, paramViewGroup, (uks)localukt);
      }
      else if (localukt.a().type == 3)
      {
        localView = a(paramInt, paramunw, paramViewGroup, (ujn)localukt);
        continue;
        localView = a(paramInt, paramunw, (uin)localukt);
        continue;
        localView = a(paramInt, paramunw, paramViewGroup, (uku)localukt);
        continue;
        localView = a(paramInt, paramunw, paramViewGroup, (ukp)localukt);
      }
    }
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup, ujm paramujm)
  {
    urk.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramunw.a(2131307526);
    FrameLayout localFrameLayout = (FrameLayout)paramunw.a(2131307530);
    a(paramujm, paramunw);
    a(paramInt, paramunw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramunw, paramujm, paramujm.a().getOwner());
    a(paramunw, paramujm, true);
    a(paramInt, paramunw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101343);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramunw.a("feed_id", paramujm.a().feedId);
    a(paramujm, paramunw);
    a(paramujm, paramunw, localFrameLayout, null);
    return paramunw.a();
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup, uks paramuks)
  {
    urk.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramunw.a(2131307526);
    FrameLayout localFrameLayout = (FrameLayout)paramunw.a(2131307530);
    a(paramuks, paramunw);
    a(paramInt, paramunw, this.jdField_d_of_type_Boolean);
    a(paramInt, paramunw, paramuks, ((ShareGroupFeedItem)paramuks.a()).getOwner());
    a(paramunw, paramuks, true);
    a(paramuks, paramunw);
    a(paramInt, paramunw);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101343);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramunw.a("feed_id", ((ShareGroupFeedItem)paramuks.a()).feedId);
    paramunw.a("group_id", ((ShareGroupFeedItem)paramuks.a()).getOwner().shareGroupId);
    a(paramuks, paramunw, localFrameLayout, ((ShareGroupFeedItem)paramuks.a()).getOwner());
    paramuks.jdField_b_of_type_Boolean = true;
    return paramunw.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected ujx a(boolean paramBoolean)
  {
    return new ujx(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    beoj.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      beoj.a();
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
  
  protected unw a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ujx.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((ukt)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      unw localunw = a(j);
      if ((localunw != null) && (paramString.equals(localunw.a("feed_id")))) {
        return localunw;
      }
      if (localunw != null)
      {
        localObject = (ukt)((List)localObject).get(j);
        vkw.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localunw.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (unw)localIterator.next();
        if (localObject != null)
        {
          localObject = (snf)((unw)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((snf)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, unw paramunw)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307554);
    TextView localTextView = (TextView)paramunw.a(2131307555);
    ImageView localImageView = (ImageView)paramunw.a(2131307552);
    if (localRelativeLayout == null) {
      return;
    }
    if (sku.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (ukt)this.jdField_a_of_type_Ujx.a().get(paramInt);
    switch (((ukt)localObject).a().type)
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
      localObject = (BannerFeedItem)((ukt)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        urk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajjy.a(2131638665);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramunw);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((ukt)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((ukt)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        urk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = ajjy.a(2131638671);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramunw);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((ukt)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      urk.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = ajjy.a(2131638662);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramunw);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, unw paramunw, ukv paramukv, QQUserUIItem paramQQUserUIItem)
  {
    beoj.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramunw.a(2131307540);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(tfy.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845344));
      beoj.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(vms.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bacm.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramunw = "";
      if (paramukv.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramunw);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramukv.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramunw = localQQStoryOwnerInfoView.a();
      paramunw.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramukv.jdField_b_of_type_Boolean) {
        paramunw.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      beoj.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramukv.a().type == 3)
      {
        paramunw = (GeneralRecommendFeedItem)paramukv.a();
        if (!TextUtils.isEmpty(paramunw.blurb))
        {
          paramunw = paramunw.blurb;
          break label152;
        }
        paramunw = a(paramukv.a());
        break label152;
      }
      paramunw = a(paramukv.a());
      break label152;
      label296:
      if (paramukv.a().type == 3) {
        if (uhf.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, ajjy.a(2131638679), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, unw paramunw, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307533);
    beoj.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramunw.a(2131307532);
    Object localObject1 = (ImageView)paramunw.a(2131307534);
    paramunw = (ImageView)paramunw.a(2131307535);
    Object localObject2 = this.jdField_a_of_type_Ujx.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      beoj.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130845422);
      paramunw.setImageResource(2130845424);
      if (paramInt != 0) {
        break label165;
      }
      paramunw = vms.a(vms.a(((ukt)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramunw);
    }
    for (;;)
    {
      beoj.a();
      return;
      ((ImageView)localObject1).setImageResource(2130845421);
      paramunw.setImageResource(2130845423);
      break;
      label165:
      paramunw = (ukt)((List)localObject2).get(paramInt - 1);
      localObject2 = (ukt)((List)localObject2).get(paramInt);
      localObject1 = vms.a(paramunw.a().date);
      localObject2 = vms.a(((ukt)localObject2).a().date);
      if (((paramunw instanceof ukp)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramunw = vms.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramunw);
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
        tij.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (sfz)tfy.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      urp.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (vms.b()) {
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
      tij.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      urp.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      tij.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          tij.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = urp.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        urp.a("home_page", "clk_card", urp.a(paramVideoListFeedItem), ufi.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), urp.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        tij.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    urk.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Ujx.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localukt = (ukt)localIterator.next();
      if (paramString1.equals(localukt.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localukt, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      ukt localukt;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(smz paramsmz, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramsmz.c != null) && (paramsmz.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Unx.a();
      paramView.setFeedItemData(paramsmz.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramsmz, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(smz paramsmz, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramsmz.c != null) && (paramsmz.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Unx.a();
      paramViewGroup.setFeedItemData(paramsmz.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramsmz, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(syp paramsyp)
  {
    if ((((Integer)((spz)sqg.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramsyp.jdField_a_of_type_JavaUtilList != null))
    {
      tio.a();
      paramsyp = new ArrayList(paramsyp.jdField_a_of_type_JavaUtilList).iterator();
      while (paramsyp.hasNext()) {
        tio.a(((StoryVideoItem)paramsyp.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(ujm paramujm, unw paramunw)
  {
    paramujm = (VideoListLayout)paramunw.a(2131307559);
    if (paramujm != null)
    {
      paramujm = paramujm.a();
      if (paramujm != null) {
        paramujm.setVisibility(8);
      }
    }
  }
  
  public void a(ujt paramujt)
  {
    boolean bool1 = true;
    urk.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramujt == null) {
      c(false);
    }
    do
    {
      return;
      if (paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        vkw.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramujt, new Object[0]);
        c(false);
        return;
      }
      urk.d("Q.qqstory.home:FeedSegment", paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramujt.jdField_b_of_type_JavaUtilList, 0);
    } while (paramujt.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramujt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramujt.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(uks paramuks, unw paramunw)
  {
    paramuks = (VideoListLayout)paramunw.a(2131307559);
    if (paramuks != null)
    {
      paramuks = paramuks.a();
      if (paramuks != null) {
        paramuks.setVisibility(8);
      }
    }
  }
  
  public void a(ukv paramukv)
  {
    urk.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramukv);
    if ((paramukv == null) || (paramukv.a() == null) || (paramukv.a().feedId == null))
    {
      urk.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramukv.a().feedId);
  }
  
  protected void a(unw paramunw)
  {
    Object localObject = (VideoListLayout)paramunw.a(2131307559);
    ((VideoListLayout)localObject).a().setOnClickListener(paramunw);
    ((VideoListLayout)localObject).a().setOnClickListener(paramunw);
    localObject = ((VideoListLayout)localObject).a();
    upg localupg = new upg(this);
    paramunw.a("general_touch_handler", localupg);
    paramunw.a("general_adapter", null);
    paramunw.a(this.jdField_b_of_type_Ulp);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localupg);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localupg);
    paramunw.a("type", "GeneralView");
  }
  
  protected void a(unw paramunw, uku paramuku)
  {
    TextView localTextView1 = (TextView)paramunw.a(2131307668);
    TextView localTextView2 = (TextView)paramunw.a(2131307667);
    TextView localTextView3 = (TextView)paramunw.a(2131307670);
    vik localvik = ((TagFeedItem)paramuku.a()).tagItem;
    paramunw = (TextView)paramunw.a(2131307665);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100760));
      paramunw.setBackgroundResource(2130845448);
    }
    if (localvik != null)
    {
      localTextView1.setText(localvik.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramuku.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramuku.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramuku.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramuku.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(upd paramupd)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ujx.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    urk.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    urk.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Ujx.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Uje.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected unw b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495654, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131307540);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    beoj.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Unx.a()) || (this.jdField_a_of_type_Int != 10))
    {
      beoj.a();
      urk.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Unx.a());
      return;
    }
    urk.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((unw)localIterator.next()).a(2131307559);
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
        urk.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131307557);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = ulr.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ulr.a(localQQStoryAutoPlayView);
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
          urk.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = ulr.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ulr.c(localQQStoryAutoPlayView);
          break label326;
          k = ulr.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ulr.b(localQQStoryAutoPlayView);
          break label326;
          urk.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          urk.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          beoj.a();
          return;
          urk.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Ujx.a());
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
    urk.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(ujt paramujt)
  {
    c(true);
  }
  
  protected void b(unw paramunw)
  {
    ((VideoListLayout)paramunw.a(2131307559)).a().setVisibility(8);
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
    this.jdField_a_of_type_Ujx.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Ull == null) {
      return;
    }
    this.jdField_a_of_type_Ull.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (sku.a()) {
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
      ulq.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (upw)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      urk.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(unw paramunw)
  {
    beoj.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramunw);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramunw.a(2131307559);
    if (localVideoListLayout == null)
    {
      beoj.a();
      return;
    }
    paramunw = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramunw != null) && (paramunw.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramunw != null) && (paramunw.a() != null)) {
        urk.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramunw.a().getThumbUrl());
      }
      if (paramunw != null) {
        paramunw.a();
      }
      beoj.a();
      return;
      paramunw = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramunw = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramunw = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramunw = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131307557);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Upe);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Upa);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uoz);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Upf);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Uox);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Upc);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Ull.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      snf localsnf = (snf)((unw)localIterator.next()).a("commentLikeLego");
      if (localsnf != null) {
        localsnf.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Ujx.b();
    sob.a();
  }
  
  public void d(unw paramunw)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramunw);
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
    urk.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  protected int f_()
  {
    return 4;
  }
  
  public void f_(boolean paramBoolean)
  {
    super.f_(paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      h();
    }
  }
  
  public void g_(int paramInt)
  {
    e(paramInt);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new uoi(this));
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
      paramMessage = (ujt)paramMessage.obj;
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
      j = vms.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Unx.a();
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
        paramMessage = (unw)localIterator.next();
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
      vkw.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = vms.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Unx.a().getLocationOnScreen(arrayOfInt1);
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
        urk.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (unw)localIterator.next();
      urk.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (snf)((unw)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((snf)localObject).c();
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
    urk.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((spz)sqg.a(10)).b("mainHallConfig", "");
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
        urk.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        urk.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uoh
 * JD-Core Version:    0.7.0.1
 */