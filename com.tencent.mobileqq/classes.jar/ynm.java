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

public class ynm
  extends zpa<yiy>
  implements Handler.Callback, IEventReceiver, wmb, wmq, yjl, ykt, ynl
{
  public static final String KEY = "FeedSegment";
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new arnj(-2631721, 180, 320);
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new arnj(-2631721, 180, 320);
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, QQUserUIItem> jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new yno(this);
  public String a;
  private List<ynb> jdField_a_of_type_JavaUtilList;
  protected Map<String, Integer> a;
  protected AtomicBoolean a;
  private wpy jdField_a_of_type_Wpy;
  private yij jdField_a_of_type_Yij;
  protected yjc a;
  private yjy jdField_a_of_type_Yjy;
  protected ykq a;
  yku jdField_a_of_type_Yku = new ynw(this);
  private ync jdField_a_of_type_Ync;
  private yoc jdField_a_of_type_Yoc;
  private yoe jdField_a_of_type_Yoe;
  private yof jdField_a_of_type_Yof;
  private yoh jdField_a_of_type_Yoh;
  private yoj jdField_a_of_type_Yoj;
  private yok jdField_a_of_type_Yok;
  private final int jdField_b_of_type_Int;
  public String b;
  yku jdField_b_of_type_Yku = new ynx(this);
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int;
  yku jdField_c_of_type_Yku = new yny(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  yku jdField_d_of_type_Yku = new ynz(this);
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public ynm(Context paramContext, Activity paramActivity, int paramInt, ync paramync, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ync = paramync;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_d_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    this.jdField_a_of_type_Yjc = a(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Yoj = new yoj(this);
    this.jdField_a_of_type_Yof = new yof(this);
    this.jdField_a_of_type_Yoe = new yoe(this);
    this.jdField_a_of_type_Yok = new yok(this);
    this.jdField_a_of_type_Yoc = new yoc(this);
    this.jdField_a_of_type_Yoh = new yoh(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yoj);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yof);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yoe);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yok);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yoc);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Yoh);
    this.jdField_a_of_type_Ykq = new ykq(Looper.myLooper());
    this.jdField_a_of_type_Yjc.a();
    this.jdField_a_of_type_Wpy = ((wpy)wpm.a(2));
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_a_of_type_Int == 10) {
      this.jdField_a_of_type_Ykq.a(1);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298427);
      this.jdField_c_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298438);
      return;
      if (this.jdField_a_of_type_Int == 11) {
        this.jdField_a_of_type_Ykq.a(2);
      } else if (this.jdField_a_of_type_Int == 12) {
        this.jdField_a_of_type_Ykq.a(3);
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    if (bgnt.h(paramContext)) {
      return 1;
    }
    if (bgnt.b(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  private View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup, yis paramyis)
  {
    paramViewGroup = (ImageView)paramynb.a(2131374444);
    FrameLayout localFrameLayout = (FrameLayout)paramynb.a(2131374448);
    b(paramynb);
    a(paramInt, paramynb, this.jdField_d_of_type_Boolean);
    a(paramInt, paramynb, paramyis, paramyis.a().getOwner());
    a(paramynb, paramyis, true);
    a(paramyis, paramynb);
    a(paramInt, paramynb);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167071);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramynb.a("feed_id", paramyis.a().feedId);
    a(paramyis, paramynb, localFrameLayout, null);
    if (!paramyis.jdField_b_of_type_Boolean) {
      yqu.a("home_page", "exp_recom", 0, 0, new String[] { "1", "", paramyis.a().getOwner().getUnionId(), paramyis.a().feedId });
    }
    paramViewGroup = paramyis.a().getOwner();
    if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
      yqu.c("ID_exp", "IDexp_IDrecommend", 0, 0, new String[] { "", paramViewGroup.qq });
    }
    return paramynb.a();
  }
  
  private View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup, yju paramyju)
  {
    paramViewGroup = (VideoListLayout)paramynb.a(2131374477);
    Object localObject1 = paramViewGroup.a();
    Object localObject2 = paramViewGroup.b();
    paramViewGroup.a().setUnionId(null);
    ((TextView)localObject2).setVisibility(8);
    ((QQStoryAutoPlayView)localObject1).setVisibility(8);
    paramViewGroup.setFailedTxt(false, null);
    paramViewGroup.setHorizontalViewHeight(zlx.a(this.jdField_a_of_type_AndroidContentContext, 178.0F));
    paramViewGroup.setMarginTop(0);
    localObject1 = paramViewGroup.a();
    ((yol)paramynb.a("general_touch_handler")).a(paramynb.jdField_b_of_type_Int, paramynb);
    if ((paramyju.a() == null) || (paramyju.a().size() == 0))
    {
      yqp.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + ((HotRecommendFeedItem)paramyju.a()).feedId);
      paramynb.a.setVisibility(8);
      return paramynb.a();
    }
    paramynb.a.setVisibility(0);
    ((StoryHomeHorizontalListView)localObject1).setVisibility(0);
    paramViewGroup = (ynj)paramynb.a("general_adapter");
    if (paramViewGroup == null)
    {
      paramViewGroup = new ynj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      paramynb.a("general_adapter", paramViewGroup);
      ((StoryHomeHorizontalListView)localObject1).setAdapter(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(this);
      paramViewGroup.a(this);
      paramViewGroup.a(this.jdField_a_of_type_Ykq);
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(((HotRecommendFeedItem)paramyju.a()).feedId);
      label316:
      boolean bool;
      if ((localObject2 != null) && (((Integer)localObject2).intValue() > 0))
      {
        ((StoryHomeHorizontalListView)localObject1).resetCurrentX(((Integer)localObject2).intValue());
        yqp.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", ((HotRecommendFeedItem)paramyju.a()).feedId, localObject2);
        ((StoryHomeHorizontalListView)localObject1).setOverScrollMode(0);
        ((StoryHomeHorizontalListView)localObject1).setDividerWidth(zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        paramInt = paramViewGroup.getCount();
        int j = paramyju.a().size();
        paramViewGroup.a(paramyju.a(), paramyju.a());
        if (((HotRecommendFeedItem)paramyju.a()).mIsVideoEnd) {
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
        paramViewGroup = paramynb.a(2131379760);
        if (paramViewGroup.getVisibility() == 8)
        {
          if (!TextUtils.isEmpty((String)((wpf)wpm.a(10)).b("mainHallConfig", ""))) {
            break label507;
          }
          paramViewGroup.setVisibility(8);
        }
      }
      for (;;)
      {
        yqu.a("home_page", "multi_exp", 0, 0, new String[0]);
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
  
  private View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup, yjz paramyjz)
  {
    paramViewGroup = (ImageView)paramynb.a(2131374444);
    a(paramInt, paramynb, this.jdField_d_of_type_Boolean);
    a(paramynb, paramyjz);
    a(paramInt, paramynb);
    a(paramynb, paramyjz, true);
    a(null, paramynb);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167071);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    yqu.c("ID_exp", "IDexp_topicrecommend", 0, 0, new String[] { "", ((TagFeedItem)paramyjz.a()).feedId });
    return paramynb.a();
  }
  
  private View a(int paramInt, ynb paramynb, yhs paramyhs)
  {
    Object localObject = (QQStoryOwnerInfoView)paramynb.a(2131374458);
    TextView localTextView1 = ((QQStoryOwnerInfoView)localObject).a();
    TextView localTextView2 = ((QQStoryOwnerInfoView)localObject).b();
    TextView localTextView3 = ((QQStoryOwnerInfoView)localObject).c();
    TextView localTextView4 = (TextView)paramynb.a(2131374429);
    ImageView localImageView = ((QQStoryOwnerInfoView)localObject).a();
    Button localButton = ((QQStoryOwnerInfoView)localObject).a();
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)paramynb.a(2131374421);
    FrameLayout localFrameLayout = (FrameLayout)paramynb.a(2131374423);
    StoryQIMBadgeView localStoryQIMBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    StoryUserBadgeView localStoryUserBadgeView = ((QQStoryOwnerInfoView)localObject).a();
    BannerFeedItem localBannerFeedItem = (BannerFeedItem)paramyhs.a();
    a(paramInt, paramynb, this.jdField_d_of_type_Boolean);
    a((QQStoryOwnerInfoView)localObject, anni.a(2131703243), true);
    if (ygk.a(localBannerFeedItem.getOwner()))
    {
      localButton.setVisibility(0);
      if (!TextUtils.isEmpty(localBannerFeedItem.content)) {
        break label518;
      }
      localTextView4.setVisibility(8);
      label164:
      localTextView1.setText(localBannerFeedItem.getOwner().getName());
      zlx.b(localImageView, localBannerFeedItem.getOwner().headUrl, 68, 68, bgmo.a(1), "QQStory_main");
      a(paramInt, paramynb);
      localStoryQIMBadgeView.a(localBannerFeedItem.getOwner());
      if (!TextUtils.isEmpty(localBannerFeedItem.blurb)) {
        break label537;
      }
      localTextView2.setVisibility(8);
      label235:
      localTextView3.setVisibility(8);
      localStoryUserBadgeView.setUnionID(localBannerFeedItem.getOwner().getUnionId(), 1);
      if (!paramyhs.jdField_b_of_type_Boolean) {
        localStoryUserBadgeView.a();
      }
      float f1 = localBannerFeedItem.coverHeight * 1.0F / localBannerFeedItem.coverWidth;
      paramInt = zlx.a(this.jdField_a_of_type_AndroidContentContext) - zlx.a(this.jdField_a_of_type_AndroidContentContext, 15.0F) * 2;
      int j = (int)(f1 * paramInt);
      localRoundCornerImageView.getLayoutParams().width = paramInt;
      localRoundCornerImageView.getLayoutParams().height = j;
      localRoundCornerImageView.setCorner(paramInt / 80);
      a(localBannerFeedItem.coverUrl, localRoundCornerImageView);
      localObject = (wml)paramynb.a("commentLikeLego");
      if (localObject != null) {
        break label556;
      }
      localObject = new wml(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyhs, this.jdField_a_of_type_Int);
      ((wml)localObject).a(paramyhs);
      ((wml)localObject).l();
      paramynb.a("commentLikeLego", localObject);
      localFrameLayout.addView(((wml)localObject).b);
    }
    for (;;)
    {
      ((wml)localObject).a(this);
      ((wml)localObject).a(this);
      ((wml)localObject).a(false);
      if (!paramyhs.jdField_b_of_type_Boolean) {
        yqu.a("home_page", "exp_recom", 0, 0, new String[] { "3", "", ((BannerFeedItem)paramyhs.a()).getOwner().getUnionId(), ((BannerFeedItem)paramyhs.a()).feedId });
      }
      return paramynb.a();
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
      ((wml)localObject).a(paramyhs, null, paramyhs);
      ((wml)localObject).c(null);
    }
  }
  
  @Nullable
  public static String a(List<StoryVideoItem> paramList)
  {
    Object localObject;
    if (paramList == null)
    {
      yqp.e("Q.qqstory.home:FeedSegment", "when setSubTitle, data is null");
      localObject = "";
      return localObject;
    }
    int n = zlx.a() / 3600;
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
        return ykw.a(j, true);
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
  
  private void a(int paramInt, yjy paramyjy, String paramString, boolean paramBoolean)
  {
    if (!(paramyjy instanceof yka)) {}
    for (;;)
    {
      return;
      Object localObject1 = a(paramInt);
      if (localObject1 == null)
      {
        yqp.a("Q.qqstory.home:FeedSegment", "doScrollHorizal, findViewHolder, null, waiting...  %s", Boolean.valueOf(paramBoolean));
        if (!paramBoolean) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.16(this, paramInt, paramyjy, paramString), 300L);
        }
      }
      else
      {
        Object localObject2 = (VideoListLayout)((ynb)localObject1).a(2131374477);
        List localList = ((yka)paramyjy).a();
        if (localList.size() <= 2) {
          this.jdField_a_of_type_AndroidOsHandler.post(new FeedSegment.17(this, localList, (VideoListLayout)localObject2, paramString));
        }
        Iterator localIterator = localList.iterator();
        paramInt = 0;
        while (localIterator.hasNext())
        {
          if (((StoryVideoItem)localIterator.next()).mVid.equals(paramString))
          {
            yqp.a("Q.qqstory.home:FeedSegment", "do scroll data pos:%d", Integer.valueOf(paramInt));
            localObject2 = ((VideoListLayout)localObject2).a();
            int j = paramInt;
            if (!paramBoolean)
            {
              paramInt *= zlx.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
              this.jdField_a_of_type_JavaUtilMap.put(paramyjy.a().feedId, Integer.valueOf(paramInt));
              ((StoryHomeHorizontalListView)localObject2).resetCurrentX(paramInt);
              localObject1 = (yen)((ynb)localObject1).a("general_adapter");
              j = paramInt;
              if (localObject1 != null)
              {
                ((yen)localObject1).notifyDataSetChanged();
                j = paramInt;
              }
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FeedSegment.18(this, (StoryHomeHorizontalListView)localObject2, localList, paramString), 400L);
            yqp.a("Q.qqstory.home:FeedSegment", "pppp bind view remeber feedId:%s x:%s", paramyjy.a().feedId, Integer.valueOf(j));
            yqp.a("Q.qqstory.home:FeedSegment", "do scroll horiz pos:%d", Integer.valueOf(j));
            return;
          }
          paramInt += 1;
        }
      }
    }
  }
  
  private void a(int paramInt, ynb paramynb, yka paramyka, ShareGroupItem paramShareGroupItem)
  {
    bkpj.a("FeedSegment.bindFeedShareGroupInfo");
    paramynb = (QQStoryOwnerInfoView)paramynb.a(2131374458);
    if (paramShareGroupItem == null)
    {
      paramynb.setSubTitle(null);
      paramynb.setBadge(null);
      paramynb.setQIMIcon(null);
      paramynb.setSubTitleSuffix(null);
      paramynb.setButtonTxt(null);
      paramynb.setName(xfe.jdField_b_of_type_JavaLangString);
      paramynb.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846425));
      bkpj.a();
      return;
    }
    Object localObject1;
    if (paramShareGroupItem.getRelationType() == 2)
    {
      localObject1 = bgmo.a();
      paramynb.setAvatar(aoch.a(QQStoryContext.a(), 4, String.valueOf(paramShareGroupItem.groupUin), 3, (Drawable)localObject1, (Drawable)localObject1));
      paramynb.setName(paramShareGroupItem.getName());
      if (paramyka.a().type == 2)
      {
        Object localObject2 = a((ShareGroupFeedItem)((yjx)paramyka).a(), paramyka.a());
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramynb.setSubTitle((String)localObject1);
        paramynb.setSubTitleSuffix((String)localObject2);
      }
      localObject1 = paramynb.a();
      if (paramShareGroupItem.getRelationType() != 2) {
        break label298;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846790);
      label199:
      if (paramyka.a().type == 2)
      {
        if (!paramyka.a()) {
          break label328;
        }
        a(paramynb, anni.a(2131703250), false);
      }
    }
    for (;;)
    {
      ((StoryUserBadgeView)localObject1).setUnionID("-1", 1);
      ((StoryUserBadgeView)localObject1).setVisibility(0);
      ((StoryUserBadgeView)localObject1).setOnClickListener(null);
      paramynb = paramynb.a();
      paramynb.a(null);
      paramynb.setVisibility(8);
      bkpj.a();
      return;
      paramynb.setAvatar(((xxe)wpm.a(24)).a(paramShareGroupItem.headerUnionIdList, paramShareGroupItem.getName()));
      break;
      label298:
      if (paramShareGroupItem.isPublic())
      {
        ((StoryUserBadgeView)localObject1).setImageResource(2130846792);
        break label199;
      }
      ((StoryUserBadgeView)localObject1).setImageResource(2130846791);
      break label199;
      label328:
      a(paramynb, null, false);
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
    bkpj.a("Feed.setCover");
    boolean bool = "QQStory_feed_min".equals(paramString);
    Drawable localDrawable;
    String str;
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      localDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      str = "";
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath))
      {
        yqp.b("Q.qqstory.home:FeedSegment", "fake url not empty");
        str = yqm.a(paramStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
        if (a(str, paramInt1, paramInt2)) {
          break label176;
        }
        str = "";
        yqp.b("Q.qqstory.home:FeedSegment", "not hit fake url cache");
      }
      label87:
      if (!TextUtils.isEmpty(str)) {
        break label229;
      }
      if (!ykw.a(paramStoryVideoItem.mVideoLocalThumbnailPath)) {
        break label188;
      }
      paramStoryVideoItem = yqm.a(paramStoryVideoItem.mVideoLocalThumbnailPath);
    }
    for (;;)
    {
      a(paramQQStoryAutoPlayView, paramStoryVideoItem, paramInt1, paramInt2, 0, localDrawable, paramString);
      paramQQStoryAutoPlayView.setCoverUrl(paramStoryVideoItem, paramInt1, paramInt2);
      bkpj.a();
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
      yqp.b("Q.qqstory.home:FeedSegment", "hit fake url cache");
      break label87;
      label188:
      if (!TextUtils.isEmpty(paramStoryVideoItem.mVideoThumbnailUrl))
      {
        if (bool) {
          paramStoryVideoItem = zlu.c(paramStoryVideoItem.mVideoThumbnailUrl);
        } else {
          paramStoryVideoItem = zlu.a(paramQQStoryAutoPlayView.getContext(), paramStoryVideoItem.mVideoThumbnailUrl);
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
    bkho localbkho = bkho.a(this.jdField_a_of_type_AndroidContentContext);
    localbkho.a(anni.a(2131703245), 5);
    QQUserUIItem localQQUserUIItem = ((wpy)wpm.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if ((localQQUserUIItem != null) && (localQQUserUIItem.isSubscribe())) {}
    for (String str = anni.a(2131703246);; str = anni.a(2131703238))
    {
      localbkho.a(str, 5);
      localbkho.a(anni.a(2131703263), 5);
      localbkho.c(2131690582);
      localbkho.a(new ynr(this, localbkho, localQQUserUIItem, paramStoryVideoItem, paramHotRecommendFeedItem));
      localbkho.a(new ynu(this));
      if (!localbkho.isShowing()) {
        localbkho.show();
      }
      yqu.a("home_page", "multi_press", 0, 0, new String[0]);
      return;
    }
  }
  
  public static void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, String paramString1, int paramInt1, int paramInt2, int paramInt3, Drawable paramDrawable, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = paramQQStoryAutoPlayView.getResources().getDrawable(2130846601);
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
        ykv.c("Q.qqstory.home:FeedSegment", new Object[] { "drawable restartDownload" });
        paramString1.restartDownload();
      }
      paramQQStoryAutoPlayView.setImageDrawable(paramString1, paramString2);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1.printStackTrace();
      ykv.a("Q.qqstory.home:FeedSegment", new Object[] { paramString1.getMessage() });
      paramQQStoryAutoPlayView.setImageDrawable(localDrawable, "QQStory_feed");
    }
  }
  
  private void a(QQStoryOwnerInfoView paramQQStoryOwnerInfoView, String paramString, boolean paramBoolean)
  {
    Button localButton = paramQQStoryOwnerInfoView.a();
    paramQQStoryOwnerInfoView.setButtonTxt(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      zlx.a(localButton);
      return;
    }
    int j;
    if (paramBoolean)
    {
      j = zlx.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
      int k = zlx.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
      if (QQStoryContext.a())
      {
        localButton.setBackgroundResource(2130846529);
        localButton.setPadding(j, k, j, k);
      }
    }
    for (;;)
    {
      if (QQStoryContext.a())
      {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166471));
        localButton.setBackgroundResource(2130846529);
      }
      j = zlx.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      zlx.a(localButton, j, j, j, j);
      return;
      localButton.setBackgroundResource(2130846528);
      break;
      localButton.setBackgroundDrawable(null);
      localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166458));
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
    paramString.setDecodeHandler(zlx.a);
    if ((paramString.getStatus() != 1) || (paramString.getStatus() == 3)) {
      paramString.restartDownload();
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(List<yjy> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = ((Integer)((wpf)wpm.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (m > 0) {}
    for (int j = m;; j = 1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((yjy)paramList.next()).d();
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
      yqp.d("Q.qqstory.home:FeedSegment", "fetchStoryVideoItem, startIndex=%d, preloadCount=%d, fetchCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(j), new JSONArray(localArrayList) });
      this.jdField_a_of_type_Ykq.a(localArrayList);
      return;
    }
  }
  
  private void a(yjy paramyjy)
  {
    if ((paramyjy == null) || (paramyjy.a() == null) || (paramyjy.a().getOwner() == null)) {
      zkb.a("homeFeed is not refreshFinish！！", new Object[0]);
    }
    label186:
    do
    {
      return;
      if ((paramyjy instanceof yir))
      {
        paramyjy = ((yir)paramyjy).a().getOwner();
        wjz.a(this.jdField_a_of_type_AndroidContentContext, 4, paramyjy.getUnionId());
        return;
      }
      Object localObject;
      int j;
      int k;
      if ((paramyjy instanceof yjx))
      {
        paramyjy = (ShareGroupFeedItem)((yjx)paramyjy).a();
        localObject = paramyjy.getOwner();
        String str = ((ShareGroupItem)localObject).getUnionId();
        if (TextUtils.isEmpty(str))
        {
          yqp.e("Q.qqstory.home:FeedSegment", "click the avatar when group id is null");
          zkb.a("click the avatar when group id is null", new Object[0]);
          return;
        }
        if (paramyjy.getOwner().getRelationType() == 2)
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
      if ((paramyjy instanceof yis))
      {
        paramyjy = ((yis)paramyjy).a();
        localObject = paramyjy.getOwner();
        if (paramyjy.getOwner().getRelationType() == 2)
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
        wjz.a(this.jdField_a_of_type_AndroidContentContext, 4, ((QQUserUIItem)localObject).getUnionId());
        return;
      }
      if ((paramyjy instanceof yjz))
      {
        paramyjy = (TagFeedItem)((yjz)paramyjy).a();
        xfv.a(this.jdField_a_of_type_AndroidAppActivity, paramyjy.tagItem.a);
        return;
      }
    } while (!(paramyjy instanceof yju));
    label289:
    l();
    yqu.a("home_page", "left_load_more", 0, 0, new String[0]);
  }
  
  private void a(yjy paramyjy, ShareGroupItem paramShareGroupItem)
  {
    if (xwq.a(paramShareGroupItem))
    {
      if (paramyjy.a().type == 4) {}
      for (int j = 3;; j = 1)
      {
        yqu.a("share_story", "pub_limit", j, 0, new String[] { "1", "", "", paramShareGroupItem.shareGroupId });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, anni.a(2131703262), 1).a();
        return;
      }
    }
    QQStoryContext.a();
    new xwr((QQAppInterface)QQStoryContext.a()).a(this.jdField_a_of_type_AndroidAppActivity, paramShareGroupItem.type, paramShareGroupItem.shareGroupId, paramShareGroupItem.name, paramShareGroupItem.groupUin, 20003, 1);
    yqu.b("story_grp", "clk_add", 0, 0, new String[0]);
  }
  
  private void a(yjy paramyjy, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    switch (paramyjy.a().type)
    {
    default: 
      str1 = str2;
    }
    for (;;)
    {
      yqu.a("home_page", paramString, 0, 0, new String[] { str1, "", "", paramyjy.a().feedId });
      return;
      str1 = "1";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
    }
  }
  
  @Deprecated
  private void a(yka paramyka, ynb paramynb) {}
  
  private void a(yka paramyka, ynb paramynb, FrameLayout paramFrameLayout, ShareGroupItem paramShareGroupItem)
  {
    bkpj.a("FeedSegment.bindCommentLike");
    wml localwml;
    if (paramyka.a().size() > 0)
    {
      localwml = (wml)paramynb.a("commentLikeLego");
      if (localwml != null) {
        break label258;
      }
      if (paramShareGroupItem == null) {
        break label132;
      }
      localwml = wml.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyka, this.jdField_a_of_type_Int, paramShareGroupItem);
      paramynb.a("commentLikeLego", localwml);
      paramFrameLayout.addView(localwml.b);
    }
    label258:
    for (;;)
    {
      if ((paramShareGroupItem != null) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        localwml.k();
        paramyka = paramFrameLayout.getLayoutParams();
        paramyka.height = zlx.a(BaseApplicationImpl.getApplication(), 15.0F);
        paramFrameLayout.setLayoutParams(paramyka);
      }
      for (;;)
      {
        bkpj.a();
        return;
        label132:
        localwml = new wml(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, null, paramyka, this.jdField_a_of_type_Int);
        break;
        paramynb = paramFrameLayout.getLayoutParams();
        paramynb.height = -2;
        paramFrameLayout.setLayoutParams(paramynb);
        if (localwml.a())
        {
          localwml.a(paramyka, paramShareGroupItem, null);
          localwml.c(null);
        }
        for (;;)
        {
          localwml.a(this);
          localwml.a(this);
          if ((paramyka.a().mVideoPullType != 0) || (paramyka.a().size() <= 1)) {
            break label249;
          }
          localwml.a(true);
          break;
          localwml.l();
        }
        label249:
        localwml.a(false);
      }
    }
  }
  
  private void a(ynb paramynb, yka paramyka, boolean paramBoolean)
  {
    bkpj.a("FeedSegment.bindVideoList");
    Object localObject2 = (VideoListLayout)paramynb.a(2131374477);
    Object localObject3 = ((VideoListLayout)localObject2).a();
    TextView localTextView = ((VideoListLayout)localObject2).b();
    StoryNickNameView localStoryNickNameView = ((VideoListLayout)localObject2).a();
    localStoryNickNameView.setMaxWidth(zlx.a(this.jdField_a_of_type_AndroidContentContext, 180.0F));
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = ((VideoListLayout)localObject2).a();
    ((yol)paramynb.a("general_touch_handler")).a(paramynb.jdField_b_of_type_Int, paramynb);
    if ((paramyka.a() == null) || (paramyka.a().size() == 0))
    {
      yqp.e("Q.qqstory.home:FeedSegment", "that item is no video!!! feed id=" + paramyka.a().feedId);
      localStoryHomeHorizontalListView.setVisibility(8);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      bkpj.a();
      return;
    }
    Object localObject1;
    if (paramyka.a().size() > 1)
    {
      localStoryHomeHorizontalListView.setVisibility(0);
      ((QQStoryAutoPlayView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      localStoryNickNameView.setUnionId(null);
      localObject1 = (yen)paramynb.a("general_adapter");
      if (localObject1 != null) {
        break label1509;
      }
      localObject1 = new yen(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      ((yen)localObject1).a(this.jdField_a_of_type_AndroidUtilLruCache);
      paramynb.a("general_adapter", localObject1);
      localStoryHomeHorizontalListView.setAdapter((ListAdapter)localObject1);
      ((yen)localObject1).a(this);
    }
    label344:
    label1247:
    label1509:
    for (;;)
    {
      ((yen)localObject1).a(this.jdField_a_of_type_Ykq);
      int j;
      int k;
      if (paramBoolean)
      {
        localObject3 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramyka.a().feedId);
        if ((localObject3 != null) && (((Integer)localObject3).intValue() > 0))
        {
          localStoryHomeHorizontalListView.resetCurrentX(((Integer)localObject3).intValue());
          yqp.a("Q.qqstory.home:FeedSegment", "pppp bind view reset feedId:%s x:%s", paramyka.a().feedId, localObject3);
        }
      }
      else
      {
        if (paramyka.a().size() != 2) {
          break label563;
        }
        j = (zlx.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2 - this.jdField_c_of_type_Int) / 2;
        k = (int)(j * 1.7D);
        localStoryHomeHorizontalListView.setOverScrollMode(2);
        ((yen)localObject1).a(j, k);
        ((yen)localObject1).a(zlx.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
        if (paramyka.a().type != 6) {
          break label642;
        }
        j = k + zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        ((VideoListLayout)localObject2).setHorizontalViewHeight(j);
        localStoryHomeHorizontalListView.setDividerWidth(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298438));
        ((yen)localObject1).a(paramyka.a(), paramyka.a());
        if (wka.a())
        {
          if ((!this.i) || (paramynb.jdField_b_of_type_Int != 0) || ((!paramyka.b()) && (!paramyka.a().isFakeFeedItem()))) {
            break label660;
          }
          ((yen)localObject1).jdField_a_of_type_Boolean = true;
          this.i = false;
        }
        if (paramyka.a().mIsVideoEnd) {
          break label669;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStoryHomeHorizontalListView.setLoadMoreComplete(paramBoolean);
        break;
        localStoryHomeHorizontalListView.resetCurrentX(0);
        break label344;
        j = zlx.a(this.jdField_a_of_type_AndroidContentContext, 152.0F);
        if (zlx.a(this.jdField_a_of_type_AndroidContentContext) > j * 2.2D) {}
        for (k = zlx.a(this.jdField_a_of_type_AndroidContentContext, 270.0F);; k = zlx.a(this.jdField_a_of_type_AndroidContentContext, 226.0F))
        {
          localStoryHomeHorizontalListView.setOverScrollMode(0);
          break;
          j = zlx.a(this.jdField_a_of_type_AndroidContentContext, 133.0F);
        }
        j = k + zlx.a(this.jdField_a_of_type_AndroidContentContext, 22.0F);
        break label447;
        ((yen)localObject1).jdField_a_of_type_Boolean = false;
        break label533;
      }
      if (paramyka.a().size() == 1)
      {
        j = zlx.a(this.jdField_a_of_type_AndroidContentContext) - this.jdField_b_of_type_Int * 2;
        k = (int)(j * 1.3D);
        ((VideoListLayout)localObject2).setSingleVideoSize(j, k);
        ((VideoListLayout)localObject2).a().a().setCorner(zlx.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
        localObject2 = (StoryVideoItem)paramyka.a().get(0);
        localStoryHomeHorizontalListView.setVisibility(8);
        ((QQStoryAutoPlayView)localObject3).setVisibility(0);
        localTextView.setVisibility(0);
        localStoryNickNameView.setVisibility(0);
        ((QQStoryAutoPlayView)localObject3).setItemData(paramyka.a(), (StoryVideoItem)localObject2, 0);
        ((QQStoryAutoPlayView)localObject3).setStoryCoverClickListener(this);
        ((QQStoryAutoPlayView)localObject3).a(this.jdField_a_of_type_Ykq);
        a((StoryVideoItem)localObject2, (QQStoryAutoPlayView)localObject3, "QQStory_feed", j, k);
        if (((StoryVideoItem)localObject2).isUploading())
        {
          ((QQStoryAutoPlayView)localObject3).a().a(((StoryVideoItem)localObject2).mVid);
          ((QQStoryAutoPlayView)localObject3).a().a(0);
          wik.a().a(((StoryVideoItem)localObject2).mVid, ((QQStoryAutoPlayView)localObject3).a());
          label871:
          if ((wka.a()) && (this.i) && (paramynb.jdField_b_of_type_Int == 0) && ((paramyka.b()) || (paramyka.a().isFakeFeedItem())))
          {
            a((View)localObject3);
            this.i = false;
          }
          if (((StoryVideoItem)localObject2).mHadRead != 1) {
            break label1247;
          }
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167074));
          if (!((StoryVideoItem)localObject2).isUploadFail()) {
            break label1268;
          }
          localTextView.setText(anni.a(2131703257));
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167074));
          localStoryNickNameView.setUnionId(null);
        }
        for (;;)
        {
          if ((paramyka.a().type == 3) && ((paramyka.a().getOwner() instanceof QQUserUIItem)))
          {
            paramynb = (QQUserUIItem)paramyka.a().getOwner();
            if ((paramynb.isVip) && (!paramynb.isSubscribe())) {
              yqu.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
            }
          }
          if (paramyka.a().type != 6) {
            break;
          }
          yqu.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", ((StoryVideoItem)localObject2).mVid });
          break;
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid)) {}
          for (localObject1 = ((StoryVideoItem)localObject2).mVid;; localObject1 = wik.a().a(((StoryVideoItem)localObject2).mVid))
          {
            ((QQStoryAutoPlayView)localObject3).a().a((String)localObject1);
            if (!((QQStoryAutoPlayView)localObject3).a().a()) {
              break label1224;
            }
            yqp.a("Q.qqstory.home:FeedSegment", "vid:%s, animation not end", localObject1);
            ((QQStoryAutoPlayView)localObject3).a().a(new yoa(this, (String)localObject1, (QQStoryAutoPlayView)localObject3));
            break;
          }
          ((QQStoryAutoPlayView)localObject3).a().a(4);
          wik.a().a(((QQStoryAutoPlayView)localObject3).a());
          break label871;
          localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
          break label946;
          label1268:
          if (((StoryVideoItem)localObject2).mTimeZoneOffsetMillis != 2147483647L)
          {
            localTextView.setText(zlx.a(((StoryVideoItem)localObject2).mCreateTime, ((StoryVideoItem)localObject2).mTimeZoneOffsetMillis));
            if (!(paramyka.a().getOwner() instanceof ShareGroupItem)) {
              break label1372;
            }
            localStoryNickNameView.setUnionId(null);
            localStoryNickNameView.setVisibility(0);
            localStoryNickNameView.setText(((StoryVideoItem)localObject2).mOwnerName);
          }
          for (;;)
          {
            if (!(paramyka.a().getOwner() instanceof TagUserItem)) {
              break label1470;
            }
            localTextView.setVisibility(8);
            break;
            localTextView.setText(zlx.b(((StoryVideoItem)localObject2).mCreateTime));
            break label1298;
            if ((paramyka.a().getOwner() instanceof TagUserItem))
            {
              localStoryNickNameView.setUnionId(null);
            }
            else if ((this.jdField_a_of_type_Int == 10) && (a((StoryVideoItem)localObject2)) && (((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wrc != null))
            {
              localStoryNickNameView.setFormat(anni.a(2131703267));
              localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
              localStoryNickNameView.setUnionId(((StoryVideoItem)localObject2).getVideoLinkInfo().jdField_a_of_type_Wrc.jdField_a_of_type_JavaLangString);
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
    switch (((wfg)xfe.a().getManager(181)).a())
    {
    }
    do
    {
      do
      {
        return false;
        yqp.b("Q.qqstory.home:FeedSegment", "");
      } while ((paramInt != 1) && (paramInt != 2));
      return true;
    } while (paramInt != 1);
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.getVideoLinkInfo() == null) {}
    while ((paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Int != 5) || (paramStoryVideoItem.getVideoLinkInfo().jdField_a_of_type_Wrc == null)) {
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
        paramList = anni.a(2131703268);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramList };
      paramList = anni.a(2131703255);
      continue;
      String str2 = a(paramList);
      String str1 = "";
      paramList = str1;
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        localObject = paramShareGroupFeedItem.videoCount + anni.a(2131703260);
        paramList = str1;
      }
    }
  }
  
  private void b(List<yjy> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int k = ((Integer)((wpf)wpm.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue();
    if (k > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = ((yjy)paramList.next()).d();
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
      yqp.d("Q.qqstory.home:FeedSegment", "preloadStoryVideo, startIndex=%d, preloadCount=%d, vidList=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), new JSONArray(localArrayList) });
      Bosses.get().postJob(new yob(this, "Q.qqstory.home:FeedSegment", localArrayList));
    }
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_Yjc.e();
    yqu.a("home_page", "load_home", 0, 0, new String[0]);
    return true;
  }
  
  @NonNull
  private String c()
  {
    return String.valueOf(hashCode());
  }
  
  private ynb c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561714, paramViewGroup, false));
    paramViewGroup.a(2131379760).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_d_of_type_Yku);
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup.a(2131374467);
    yol localyol = new yol(this);
    localStoryHomeHorizontalListView.setOnLoadMoreListener(localyol);
    localStoryHomeHorizontalListView.setOnOverScrollRightListener(localyol);
    localStoryHomeHorizontalListView.setOnScrollChangeListener(localyol);
    localStoryHomeHorizontalListView.setOnScrollStateChangedListener(localyol);
    paramViewGroup.a("general_touch_handler", localyol);
    paramViewGroup.a("general_adapter", null);
    return paramViewGroup;
  }
  
  private ynb d(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561820, paramViewGroup, false));
    Object localObject = (QQStoryOwnerInfoView)paramViewGroup.a(2131374458);
    paramViewGroup.a(2131374459).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374457).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374587).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374582).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_c_of_type_Yku);
    localObject = (StoryHomeHorizontalListView)paramViewGroup.a(2131374467);
    yol localyol = new yol(this);
    paramViewGroup.a("general_touch_handler", localyol);
    paramViewGroup.a("general_adapter", null);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localyol);
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
    int k = zlx.d(this.jdField_a_of_type_AndroidContentContext);
    int m = a().getFirstVisiblePosition();
    if (a().getChildAt(0) != null) {}
    for (int j = a().getChildAt(0).getTop();; j = k + 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      yqp.b("Q.qqstory.home:FeedSegment", "scrollToWhere firstIndex=" + m + ",lastFirstIndex=" + this.jdField_d_of_type_Int + ",firstTopY=" + j + ",lastFirstTopY=" + this.jdField_e_of_type_Int);
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
  
  private ynb e(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561643, paramViewGroup, false));
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374458);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374421).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131374429).setOnClickListener(paramViewGroup);
    paramViewGroup.a(this.jdField_a_of_type_Yku);
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
    bkho localbkho = bkho.a(this.jdField_a_of_type_AndroidContentContext);
    yjy localyjy = (yjy)this.jdField_a_of_type_Yjc.a().get(paramInt);
    localbkho.a(anni.a(2131703252), 5);
    localbkho.c(2131690582);
    localbkho.a(new ynp(this, localbkho, paramInt, localyjy));
    localbkho.a(new ynq(this, paramInt));
    if (!localbkho.isShowing()) {
      localbkho.show();
    }
    a(localyjy, "clk_hide");
  }
  
  private void g(int paramInt)
  {
    if (!zky.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(xfe.a(), 1, anni.a(2131703266), 0).a();
      return;
    }
    Object localObject = (yjy)this.jdField_a_of_type_Yjc.a().remove(paramInt);
    if (localObject == null)
    {
      zkb.a("feed is null when unLike.", new Object[0]);
      return;
    }
    a((yjy)localObject, "hide_done");
    String str = ((yjy)localObject).a().getOwner().getUnionId();
    long l;
    switch (((yjy)localObject).a().type)
    {
    case 4: 
    default: 
      zkb.a("feed not allow unLike operation type=" + ((yjy)localObject).a().type, new Object[0]);
      return;
    case 3: 
      l = ((GeneralRecommendFeedItem)((yjy)localObject).a()).recommendId;
      paramInt = 9;
    }
    for (;;)
    {
      zkp.a(str, paramInt, l);
      localObject = ((yjy)localObject).a().feedId;
      Bosses.get().postJob(new ynv(this, "Q.qqstory.home:FeedSegment", (String)localObject));
      m();
      return;
      l = ((BannerFeedItem)((yjy)localObject).a()).recommendId;
      paramInt = 11;
      continue;
      l = ((TagFeedItem)((yjy)localObject).a()).recommendId;
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
    if (wka.a()) {}
    do
    {
      return;
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "publishAnimationForQQ isShowPublishAnim=", Boolean.valueOf(this.i), ",notifyFromFakeItemUpdate=", Boolean.valueOf(this.h) });
    } while ((!this.i) || (!this.h));
    Object localObject = a();
    Rect localRect = new Rect();
    if (localObject != null)
    {
      boolean bool = ((View)localObject).getGlobalVisibleRect(localRect);
      int[] arrayOfInt = new int[2];
      ((View)localObject).getLocationInWindow(arrayOfInt);
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anni.a(2131703253), Integer.valueOf(arrayOfInt[0]), ",y=", Integer.valueOf(arrayOfInt[1]) });
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anni.a(2131703261), Boolean.valueOf(bool), " and:", Integer.valueOf(((View)localObject).getId()), ",scrollX：", Integer.valueOf(((ViewGroup)((View)localObject).getParent()).getScrollX()), ",scrollY:", Integer.valueOf(a((View)localObject)) });
    }
    for (;;)
    {
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anni.a(2131703254), Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      this.i = false;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, localRect));
      localObject = (ypb)a().a("NewMyStorySegment");
      if (localObject != null) {
        ((ypb)localObject).a(false);
      }
      a().setSelection(0);
      return;
      yqp.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view");
    }
  }
  
  public void T_()
  {
    this.jdField_a_of_type_Yjy = null;
    if (this.jdField_f_of_type_Boolean)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Yjc.a()).iterator();
      while (localIterator.hasNext())
      {
        yjy localyjy = (yjy)localIterator.next();
        if (((localyjy instanceof yjx)) && (localyjy.a().getOwner().getRelationType() != 2) && (((ShareGroupItem)localyjy.a().getOwner()).isPublic()) && (this.jdField_a_of_type_Yjy == null))
        {
          this.jdField_a_of_type_Yjy = localyjy;
          yqp.a("Q.qqstory.home:FeedSegment", "find the feed that need show add videos guide. %s.", this.jdField_a_of_type_Yjy.toString());
          return;
        }
      }
      yqp.b("Q.qqstory.home:FeedSegment", "no feed that need show add videos guide.");
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
      this.jdField_a_of_type_Ykq.b(2);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.h();
      this.jdField_a_of_type_Ykq.b(0);
    }
    AbstractGifImage.pauseAll();
    this.g = false;
    this.jdField_a_of_type_Yjc.c();
    this.jdField_a_of_type_Yjc.d();
    this.g = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Yjc.a().size();
  }
  
  protected int a(int paramInt)
  {
    yjy localyjy = (yjy)this.jdField_a_of_type_Yjc.a().get(paramInt);
    if (localyjy.a().type == 1) {
      return 0;
    }
    if (localyjy.a().type == 3) {
      return 0;
    }
    if (localyjy.a().type == 2) {
      return 0;
    }
    if (localyjy.a().type == 5) {
      return 1;
    }
    if (localyjy.a().type == 6) {
      return 2;
    }
    if (localyjy.a().type == 7) {
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
    while (j < this.jdField_a_of_type_Yjc.a().size())
    {
      localObject1 = (yjy)this.jdField_a_of_type_Yjc.a().get(j);
      if ((((yjy)localObject1).a().type != 1) && (((yjy)localObject1).a().type != 2))
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
      localObject2 = (VideoListLayout)((ynb)localObject1).a(2131374477);
      if (localObject2 != null) {
        break;
      }
      yqp.e("Q.qqstory.home:FeedSegment", "data is  general feed item ,but view have no list view!! this is bug!!");
    }
    Object localObject1 = ((VideoListLayout)localObject2).a();
    Object localObject2 = ((VideoListLayout)localObject2).a();
    if ((localObject1 != null) && (((QQStoryAutoPlayView)localObject1).getVisibility() == 0))
    {
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "返回了单个视频的view：" + ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    if ((localObject2 != null) && (((StoryHomeHorizontalListView)localObject2).getVisibility() == 0) && (((StoryHomeHorizontalListView)localObject2).getChildAt(0) != null))
    {
      localObject1 = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject2).getChildAt(0).findViewById(2131374475);
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { anni.a(2131703240), ((QQStoryAutoPlayView)localObject1).a().getThumbUrl() });
      return localObject1;
    }
    return null;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    yjy localyjy = (yjy)this.jdField_a_of_type_Yjc.a().get(paramInt);
    paramynb.a("feed_id", localyjy.a().feedId);
    View localView = paramynb.a();
    switch (a(paramInt))
    {
    }
    for (;;)
    {
      localyjy.jdField_b_of_type_Boolean = true;
      d(paramynb);
      paramynb = new ArrayList();
      paramynb.add(localyjy);
      b(paramynb, 0);
      yqu.b("story_home_dev", "feed_exp", localyjy.a().type, localyjy.d().size(), new String[] { localyjy.a().feedId });
      return localView;
      if (localyjy.a().type == 1)
      {
        localView = a(paramInt, paramynb, paramViewGroup, (yir)localyjy);
      }
      else if (localyjy.a().type == 2)
      {
        localView = a(paramInt, paramynb, paramViewGroup, (yjx)localyjy);
      }
      else if (localyjy.a().type == 3)
      {
        localView = a(paramInt, paramynb, paramViewGroup, (yis)localyjy);
        continue;
        localView = a(paramInt, paramynb, (yhs)localyjy);
        continue;
        localView = a(paramInt, paramynb, paramViewGroup, (yjz)localyjy);
        continue;
        localView = a(paramInt, paramynb, paramViewGroup, (yju)localyjy);
      }
    }
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup, yir paramyir)
  {
    yqp.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramynb.a(2131374444);
    FrameLayout localFrameLayout = (FrameLayout)paramynb.a(2131374448);
    a(paramyir, paramynb);
    a(paramInt, paramynb, this.jdField_d_of_type_Boolean);
    a(paramInt, paramynb, paramyir, paramyir.a().getOwner());
    a(paramynb, paramyir, true);
    a(paramInt, paramynb);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167071);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramynb.a("feed_id", paramyir.a().feedId);
    a(paramyir, paramynb);
    a(paramyir, paramynb, localFrameLayout, null);
    return paramynb.a();
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup, yjx paramyjx)
  {
    yqp.a("Q.qqstory.home.position", "bindView position%d", Integer.valueOf(paramInt));
    paramViewGroup = (ImageView)paramynb.a(2131374444);
    FrameLayout localFrameLayout = (FrameLayout)paramynb.a(2131374448);
    a(paramyjx, paramynb);
    a(paramInt, paramynb, this.jdField_d_of_type_Boolean);
    a(paramInt, paramynb, paramyjx, ((ShareGroupFeedItem)paramyjx.a()).getOwner());
    a(paramynb, paramyjx, true);
    a(paramyjx, paramynb);
    a(paramInt, paramynb);
    paramInt = -3355444;
    if (this.jdField_d_of_type_Boolean) {
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167071);
    }
    paramViewGroup.setBackgroundColor(paramInt);
    paramynb.a("feed_id", ((ShareGroupFeedItem)paramyjx.a()).feedId);
    paramynb.a("group_id", ((ShareGroupFeedItem)paramyjx.a()).getOwner().shareGroupId);
    a(paramyjx, paramynb, localFrameLayout, ((ShareGroupFeedItem)paramyjx.a()).getOwner());
    paramyjx.jdField_b_of_type_Boolean = true;
    return paramynb.a();
  }
  
  public String a()
  {
    return "FeedSegment";
  }
  
  @NonNull
  protected yjc a(boolean paramBoolean)
  {
    return new yjc(this.jdField_a_of_type_Int, this, paramBoolean);
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    bkpj.a("FeedItem.createView");
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = b(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a().requestLayout();
      bkpj.a();
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
  
  protected ynb a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Yjc.a();
    int j = 0;
    if (j < ((List)localObject).size()) {
      if (!TextUtils.equals(paramString, ((yjy)((List)localObject).get(j)).a().feedId)) {}
    }
    for (;;)
    {
      if (j == -1)
      {
        return null;
        j += 1;
        break;
      }
      ynb localynb = a(j);
      if ((localynb != null) && (paramString.equals(localynb.a("feed_id")))) {
        return localynb;
      }
      if (localynb != null)
      {
        localObject = (yjy)((List)localObject).get(j);
        zkb.a("data and view is not correspond. feedID=" + paramString + ",and holder feed id=" + localynb.a("feed_id") + " feed info=" + localObject, new Object[0]);
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
        Object localObject = (ynb)localIterator.next();
        if (localObject != null)
        {
          localObject = (wml)((ynb)localObject).a("commentLikeLego");
          if (localObject != null) {
            ((wml)localObject).a(paramInt1, paramInt2, paramIntent);
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, ynb paramynb)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramynb.a(2131374472);
    TextView localTextView = (TextView)paramynb.a(2131374473);
    ImageView localImageView = (ImageView)paramynb.a(2131374470);
    if (localRelativeLayout == null) {
      return;
    }
    if (wka.a())
    {
      localRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = (yjy)this.jdField_a_of_type_Yjc.a().get(paramInt);
    switch (((yjy)localObject).a().type)
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
      localObject = (BannerFeedItem)((yjy)localObject).a();
      if (((BannerFeedItem)localObject).recommendId <= 0L)
      {
        yqp.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((BannerFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((BannerFeedItem)localObject).recommendTitle)) {}
      for (localObject = anni.a(2131703242);; localObject = ((BannerFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramynb);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    case 3: 
      if (((yjy)localObject).a().getOwner().isSubscribe())
      {
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      localObject = (GeneralRecommendFeedItem)((yjy)localObject).a();
      if (((GeneralRecommendFeedItem)localObject).recommendId <= 0L)
      {
        yqp.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((GeneralRecommendFeedItem)localObject).feedId);
        localRelativeLayout.setVisibility(8);
        localImageView.setOnClickListener(null);
        return;
      }
      if (TextUtils.isEmpty(((GeneralRecommendFeedItem)localObject).recommendTitle)) {}
      for (localObject = anni.a(2131703248);; localObject = ((GeneralRecommendFeedItem)localObject).recommendTitle)
      {
        localRelativeLayout.setVisibility(0);
        localImageView.setOnClickListener(paramynb);
        localTextView.setText((CharSequence)localObject);
        return;
      }
    }
    localObject = (TagFeedItem)((yjy)localObject).a();
    if (((TagFeedItem)localObject).recommendId <= 0L)
    {
      yqp.e("Q.qqstory.home:FeedSegment", "feed have no recommend id. feed=" + ((TagFeedItem)localObject).feedId);
      localRelativeLayout.setVisibility(8);
      localImageView.setOnClickListener(null);
      return;
    }
    if (TextUtils.isEmpty(((TagFeedItem)localObject).recommendTitle)) {}
    for (localObject = anni.a(2131703239);; localObject = ((TagFeedItem)localObject).recommendTitle)
    {
      localRelativeLayout.setVisibility(0);
      localImageView.setOnClickListener(paramynb);
      localTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  protected void a(int paramInt, ynb paramynb, yka paramyka, QQUserUIItem paramQQUserUIItem)
  {
    bkpj.a("FeedSegment.bindFeedUserInfo");
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramynb.a(2131374458);
    if (paramQQUserUIItem == null)
    {
      localQQStoryOwnerInfoView.setSubTitle(null);
      localQQStoryOwnerInfoView.setBadge(null);
      localQQStoryOwnerInfoView.setQIMIcon(null);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      localQQStoryOwnerInfoView.setButtonTxt(null);
      localQQStoryOwnerInfoView.setName(xfe.jdField_b_of_type_JavaLangString);
      localQQStoryOwnerInfoView.setAvatar(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846425));
      bkpj.a();
      return;
    }
    localQQStoryOwnerInfoView.setAvatar(zlx.a(this.jdField_a_of_type_AndroidContentContext, paramQQUserUIItem.headUrl, 68, 68, bgmo.a(1), "QQStory_main"));
    if (TextUtils.isEmpty(paramQQUserUIItem.remark))
    {
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.nickName);
      paramynb = "";
      if (paramyka.a().getOwner().getRelationType() != 2) {
        break label237;
      }
      label152:
      localQQStoryOwnerInfoView.setSubTitle(paramynb);
      localQQStoryOwnerInfoView.setSubTitleSuffix(null);
      if (paramyka.a().type != 1) {
        break label296;
      }
      a(localQQStoryOwnerInfoView, null, false);
    }
    for (;;)
    {
      paramynb = localQQStoryOwnerInfoView.a();
      paramynb.setUnionID(paramQQUserUIItem.getUnionId(), 1);
      if (!paramyka.jdField_b_of_type_Boolean) {
        paramynb.a();
      }
      localQQStoryOwnerInfoView.a().a(paramQQUserUIItem);
      bkpj.a();
      return;
      localQQStoryOwnerInfoView.setName(paramQQUserUIItem.remark);
      break;
      label237:
      if (paramyka.a().type == 3)
      {
        paramynb = (GeneralRecommendFeedItem)paramyka.a();
        if (!TextUtils.isEmpty(paramynb.blurb))
        {
          paramynb = paramynb.blurb;
          break label152;
        }
        paramynb = a(paramyka.a());
        break label152;
      }
      paramynb = a(paramyka.a());
      break label152;
      label296:
      if (paramyka.a().type == 3) {
        if (ygk.a(paramQQUserUIItem)) {
          a(localQQStoryOwnerInfoView, anni.a(2131703256), true);
        } else {
          a(localQQStoryOwnerInfoView, null, false);
        }
      }
    }
  }
  
  protected void a(int paramInt, ynb paramynb, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramynb.a(2131374451);
    bkpj.a("FeedSegment.setCalendar");
    TextView localTextView = (TextView)paramynb.a(2131374450);
    Object localObject1 = (ImageView)paramynb.a(2131374452);
    paramynb = (ImageView)paramynb.a(2131374453);
    Object localObject2 = this.jdField_a_of_type_Yjc.a();
    if (((List)localObject2).size() <= paramInt)
    {
      localRelativeLayout.setVisibility(8);
      bkpj.a();
      return;
    }
    if (paramBoolean)
    {
      ((ImageView)localObject1).setImageResource(2130846503);
      paramynb.setImageResource(2130846505);
      if (paramInt != 0) {
        break label165;
      }
      paramynb = zlx.a(zlx.a(((yjy)((List)localObject2).get(paramInt)).a().date));
      localRelativeLayout.setVisibility(0);
      localTextView.setText(paramynb);
    }
    for (;;)
    {
      bkpj.a();
      return;
      ((ImageView)localObject1).setImageResource(2130846502);
      paramynb.setImageResource(2130846504);
      break;
      label165:
      paramynb = (yjy)((List)localObject2).get(paramInt - 1);
      localObject2 = (yjy)((List)localObject2).get(paramInt);
      localObject1 = zlx.a(paramynb.a().date);
      localObject2 = zlx.a(((yjy)localObject2).a().date);
      if (((paramynb instanceof yju)) || (localObject1[0] != localObject2[0]) || (localObject1[1] != localObject2[1]) || (localObject1[2] != localObject2[2]))
      {
        paramynb = zlx.a((int[])localObject2);
        localRelativeLayout.setVisibility(0);
        localTextView.setText(paramynb);
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
        xho.a(this.jdField_a_of_type_AndroidAppActivity, paramString.a());
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
      paramView = (wff)xfe.a().a(98);
      if (!paramQQUserUIItem.isVip()) {
        break label95;
      }
    }
    label95:
    for (paramInt = j;; paramInt = 0)
    {
      paramView.a(paramInt, paramQQUserUIItem.uid, k, 10);
      yqu.a("home_page", "multi_follow_clk", 0, k + 1, new String[0]);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (zlx.b()) {
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
      xho.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), ((QQStoryAutoPlayView)paramView).a());
    }
    for (;;)
    {
      yqu.a("home_page", "multi_card_clk", 0, 0, new String[] { paramStoryVideoItem.mOwnerUid, paramStoryVideoItem.mVid, String.valueOf(paramInt + 1) });
      return;
      j = 76;
      break;
      label159:
      xho.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.a(), paramView);
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
          xho.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, ((QQStoryAutoPlayView)paramView).a());
        }
      }
      else
      {
        paramInt = yqu.b(paramVideoListFeedItem);
        if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label454;
        }
      }
      for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
      {
        yqu.a("home_page", "clk_card", yqu.a(paramVideoListFeedItem), yen.a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), yqu.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
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
        xho.a((FragmentActivity)this.jdField_a_of_type_AndroidAppActivity, (OpenPlayerBuilder.Data)localObject, paramView);
        break label303;
      }
    }
  }
  
  public void a(String paramString)
  {
    yqp.b("Q.qqstory.home:FeedSegment", "onAddFakeFeedItem:" + paramString);
    this.h = true;
    c(true);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Yjc.a().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      localyjy = (yjy)localIterator.next();
      if (paramString1.equals(localyjy.a().feedId))
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_b_of_type_JavaLangString = null;
        h(j);
        a(j, localyjy, paramString2, false);
      }
    }
    while (!paramBoolean)
    {
      yjy localyjy;
      return;
      j += 1;
      break;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    b();
  }
  
  public void a(wmf paramwmf, View paramView, String paramString)
  {
    boolean bool = true;
    if ((paramwmf.c != null) && (paramwmf.c.size() > 1)) {}
    for (;;)
    {
      paramView = this.jdField_a_of_type_Ync.a();
      paramView.setFeedItemData(paramwmf.a, this.jdField_a_of_type_Int, c(), bool);
      paramView.a(paramwmf, null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(11, paramString), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wmf paramwmf, ViewGroup paramViewGroup, View paramView, int paramInt, CommentEntry paramCommentEntry)
  {
    boolean bool = true;
    if ((paramwmf.c != null) && (paramwmf.c.size() > 1)) {}
    for (;;)
    {
      paramViewGroup = this.jdField_a_of_type_Ync.a();
      paramViewGroup.setFeedItemData(paramwmf.a, this.jdField_a_of_type_Int, c(), bool);
      paramViewGroup.a(paramwmf, paramCommentEntry);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, paramView), 150L);
      return;
      bool = false;
    }
  }
  
  public void a(wxv paramwxv)
  {
    if ((((Integer)((wpf)wpm.a(10)).b("key_story_home_preload_count", Integer.valueOf(4))).intValue() > 0) && (paramwxv.jdField_a_of_type_JavaUtilList != null))
    {
      xht.a();
      paramwxv = new ArrayList(paramwxv.jdField_a_of_type_JavaUtilList).iterator();
      while (paramwxv.hasNext()) {
        xht.a(((StoryVideoItem)paramwxv.next()).mVid);
      }
    }
    b(0);
  }
  
  protected void a(yir paramyir, ynb paramynb)
  {
    paramyir = (VideoListLayout)paramynb.a(2131374477);
    if (paramyir != null)
    {
      paramyir = paramyir.a();
      if (paramyir != null) {
        paramyir.setVisibility(8);
      }
    }
  }
  
  public void a(yiy paramyiy)
  {
    boolean bool1 = true;
    yqp.d("Q.qqstory.home:FeedSegment", "onFeedItemBack");
    if (paramyiy == null) {
      c(false);
    }
    do
    {
      return;
      if (paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null)
      {
        zkb.a("FeedSegment onFeedItemBack feedData.errorInfo=null!!," + paramyiy, new Object[0]);
        c(false);
        return;
      }
      yqp.d("Q.qqstory.home:FeedSegment", paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.toString());
      if (!paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {
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
      a(paramyiy.jdField_b_of_type_JavaUtilList, 0);
    } while (paramyiy.jdField_b_of_type_Boolean);
    SegmentList localSegmentList = a();
    String str = a();
    boolean bool2 = paramyiy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    if (!paramyiy.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localSegmentList.setLoadMoreComplete(str, bool2, bool1);
      return;
      c(true);
      break;
      bool1 = false;
    }
  }
  
  protected void a(yjx paramyjx, ynb paramynb)
  {
    paramyjx = (VideoListLayout)paramynb.a(2131374477);
    if (paramyjx != null)
    {
      paramyjx = paramyjx.a();
      if (paramyjx != null) {
        paramyjx.setVisibility(8);
      }
    }
  }
  
  public void a(yka paramyka)
  {
    yqp.a("Q.qqstory.home:FeedSegment", "on feed video page update, %s", paramyka);
    if ((paramyka == null) || (paramyka.a() == null) || (paramyka.a().feedId == null))
    {
      yqp.e("Q.qqstory.home:FeedSegment", "onFeedVideoUpdate item is not refreshFinish!!!!!!!!!!!!!!!!!");
      return;
    }
    d(paramyka.a().feedId);
  }
  
  protected void a(ynb paramynb)
  {
    Object localObject = (VideoListLayout)paramynb.a(2131374477);
    ((VideoListLayout)localObject).a().setOnClickListener(paramynb);
    ((VideoListLayout)localObject).a().setOnClickListener(paramynb);
    localObject = ((VideoListLayout)localObject).a();
    yol localyol = new yol(this);
    paramynb.a("general_touch_handler", localyol);
    paramynb.a("general_adapter", null);
    paramynb.a(this.jdField_b_of_type_Yku);
    ((StoryHomeHorizontalListView)localObject).setOnLoadMoreListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnOverScrollRightListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnScrollChangeListener(localyol);
    ((StoryHomeHorizontalListView)localObject).setOnScrollStateChangedListener(localyol);
    paramynb.a("type", "GeneralView");
  }
  
  protected void a(ynb paramynb, yjz paramyjz)
  {
    TextView localTextView1 = (TextView)paramynb.a(2131374585);
    TextView localTextView2 = (TextView)paramynb.a(2131374584);
    TextView localTextView3 = (TextView)paramynb.a(2131374587);
    zhp localzhp = ((TagFeedItem)paramyjz.a()).tagItem;
    paramynb = (TextView)paramynb.a(2131374582);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
      paramynb.setBackgroundResource(2130846529);
    }
    if (localzhp != null)
    {
      localTextView1.setText(localzhp.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(((TagFeedItem)paramyjz.a()).blurb)) {
        break label181;
      }
      localTextView2.setVisibility(0);
      localTextView2.setText(((TagFeedItem)paramyjz.a()).blurb);
    }
    while (!TextUtils.isEmpty(((TagFeedItem)paramyjz.a()).content))
    {
      localTextView3.setVisibility(0);
      localTextView3.setText(((TagFeedItem)paramyjz.a()).content);
      return;
      label181:
      localTextView2.setVisibility(8);
    }
    localTextView3.setVisibility(8);
  }
  
  public void a(yoi paramyoi)
  {
    b(0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Yjc.a();
  }
  
  public boolean a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getHeight();
    int k = paramView.getWidth();
    paramView = new int[2];
    a().getLocationOnScreen(paramView);
    yqp.b("Q.qqstory.home:FeedSegment", "isOnScreenArea location[1]=" + arrayOfInt[1] + ",parentLocation[1]=" + paramView[1] + ",viewHeight" + j + ",getParentListView().getHeight()=" + a().getHeight());
    return (arrayOfInt[1] > paramView[1]) && (j + arrayOfInt[1] < paramView[1] + a().getHeight()) && (arrayOfInt[0] > -k / 2);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    yqp.c("Q.qqstory.home:FeedSegment", "onRefresh");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    this.jdField_a_of_type_Yjc.a(false);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Yij.jdField_a_of_type_JavaUtilMap.clear();
    if (!paramBoolean) {
      this.jdField_f_of_type_Boolean = false;
    }
    return true;
  }
  
  protected ynb b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561688, paramViewGroup, false));
    paramViewGroup.a().setOnClickListener(paramViewGroup);
    QQStoryOwnerInfoView localQQStoryOwnerInfoView = (QQStoryOwnerInfoView)paramViewGroup.a(2131374458);
    localQQStoryOwnerInfoView.a().setOnClickListener(paramViewGroup);
    localQQStoryOwnerInfoView.setOwnerInfoOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(int paramInt)
  {
    bkpj.a("fetchViewWhichNeedPlay");
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_a_of_type_Ync.a()) || (this.jdField_a_of_type_Int != 10))
    {
      bkpj.a();
      yqp.e("Q.qqstory.home:FeedSegment", "fetchViewWhichNeedPlay but needAutoPlay=" + this.jdField_c_of_type_Boolean + ",mIView.isViewOnResume()=" + this.jdField_a_of_type_Ync.a());
      return;
    }
    yqp.d("Q.qqstory.home:FeedSegment", "checkAutoPlayCondition scrollDirection=" + paramInt);
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
        localObject = (VideoListLayout)((ynb)localIterator.next()).a(2131374477);
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
        yqp.b("Q.qqstory.home:FeedSegment", "for holder start cover=" + localQQStoryAutoPlayView.a().getThumbUrl());
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = localQQStoryAutoPlayView;
          break;
          if ((localObject == null) || (((StoryHomeHorizontalListView)localObject).getVisibility() != 0) || (((StoryHomeHorizontalListView)localObject).getChildAt(0) == null)) {
            break label553;
          }
          localQQStoryAutoPlayView = (QQStoryAutoPlayView)((StoryHomeHorizontalListView)localObject).getChildAt(0).findViewById(2131374475);
          continue;
        }
        int k;
        int j;
        switch (paramInt)
        {
        default: 
          k = ykw.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ykw.a(localQQStoryAutoPlayView);
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
          yqp.b("Q.qqstory.home:FeedSegment", "for holder end-----------");
          break;
          k = ykw.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ykw.c(localQQStoryAutoPlayView);
          break label326;
          k = ykw.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
          j = ykw.b(localQQStoryAutoPlayView);
          break label326;
          yqp.b("Q.qqstory.home:FeedSegment", "compare mPlayingView and cover is the same");
          continue;
          localQQStoryAutoPlayView.b();
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null)
        {
          yqp.b("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView index=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a() + ",url=" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a().getThumbUrl());
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
          bkpj.a();
          return;
          yqp.e("Q.qqstory.home:FeedSegment", "FeedSegment checkAutoPlayCondition find playView is null");
          break;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a(this.jdField_a_of_type_Yjc.a());
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
    yqp.b("Q.qqstory.home:FeedSegment", "onFeedItemUpdate");
    c(true);
  }
  
  public void b(yiy paramyiy)
  {
    c(true);
  }
  
  protected void b(ynb paramynb)
  {
    ((VideoListLayout)paramynb.a(2131374477)).a().setVisibility(8);
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
    this.jdField_a_of_type_Yjc.a(true);
    this.jdField_c_of_type_Boolean = a(a(this.jdField_a_of_type_AndroidContentContext));
    h();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Ykq == null) {
      return;
    }
    this.jdField_a_of_type_Ykq.b(paramInt);
  }
  
  public void c(@NonNull String paramString)
  {
    if (wka.a()) {
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
      ykv.b("Q.qqstory.home:FeedSegment_animation", new Object[] { "启动播放动画的activity，top:", Integer.valueOf(localRect.top), ",bottom:", Integer.valueOf(localRect.bottom) });
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryTakeVideoCloseAnimationActivity.class);
      ((Intent)localObject).putExtra("path", paramString);
      ((Intent)localObject).putExtra("target_top", localRect.top);
      ((Intent)localObject).putExtra("target_right", localRect.right);
      ((Intent)localObject).putExtra("target_left", localRect.left);
      ((Intent)localObject).putExtra("target_bottom", localRect.bottom);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      paramString = (ypb)a().a("NewMyStorySegment");
      if (paramString != null) {
        paramString.a(false);
      }
      a().setSelection(0);
      return;
      yqp.e("Q.qqstory.home:FeedSegment_animation", "获取不到第一个卡片的view~~~~~~~~~");
    }
  }
  
  public void c(ynb paramynb)
  {
    bkpj.a("FeedSegment.onMovedToScrapHeap");
    this.jdField_a_of_type_JavaUtilList.remove(paramynb);
    VideoListLayout localVideoListLayout = (VideoListLayout)paramynb.a(2131374477);
    if (localVideoListLayout == null)
    {
      bkpj.a();
      return;
    }
    paramynb = localVideoListLayout.a();
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = localVideoListLayout.a();
    localVideoListLayout = null;
    if ((paramynb != null) && (paramynb.getVisibility() == 0)) {}
    for (;;)
    {
      if ((paramynb != null) && (paramynb.a() != null)) {
        yqp.b("Q.qqstory.home:FeedSegment", "for holder onMovedToScrapHeap cover=" + paramynb.a().getThumbUrl());
      }
      if (paramynb != null) {
        paramynb.a();
      }
      bkpj.a();
      return;
      paramynb = localVideoListLayout;
      if (localStoryHomeHorizontalListView != null)
      {
        paramynb = localVideoListLayout;
        if (localStoryHomeHorizontalListView.getVisibility() == 0)
        {
          paramynb = localVideoListLayout;
          if (localStoryHomeHorizontalListView.getChildAt(0) != null) {
            paramynb = (QQStoryAutoPlayView)localStoryHomeHorizontalListView.getChildAt(0).findViewById(2131374475);
          }
        }
      }
    }
  }
  
  protected void d()
  {
    super.d();
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yoj);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yof);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yoe);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yok);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yoc);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Yoh);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.a();
    }
    this.jdField_a_of_type_Ykq.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      wml localwml = (wml)((ynb)localIterator.next()).a("commentLikeLego");
      if (localwml != null) {
        localwml.a();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_Yjc.b();
    wnh.a();
  }
  
  public void d(ynb paramynb)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramynb);
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
    yqp.b("Q.qqstory.home:FeedSegment", "tag list update");
    c(true);
  }
  
  public void h()
  {
    a().setOnLoadMoreListener(a(), new ynn(this));
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
      paramMessage = (yiy)paramMessage.obj;
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
      j = zlx.d(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_Ync.a();
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
        paramMessage = (ynb)localIterator.next();
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
      zkb.a(false, "comment feed id is error! id=" + str);
      return true;
      paramMessage = (View)paramMessage.obj;
      arrayOfInt1 = new int[2];
      j = zlx.d(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Ync.a().getLocationOnScreen(arrayOfInt1);
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
        yqp.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了");
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
      Object localObject = (ynb)localIterator.next();
      yqp.b("Q.qqstory.home:FeedSegment", "updateCommentLikeView");
      localObject = (wml)((ynb)localObject).a("commentLikeLego");
      if (localObject != null) {
        ((wml)localObject).c();
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
    yqp.b("Q.qqstory.home:FeedSegment", "listViewUpdateCompleted");
    n();
    this.h = false;
  }
  
  public void l()
  {
    String str1 = (String)((wpf)wpm.a(10)).b("mainHallConfig", "");
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
        yqp.d("Q.qqstory.home:FeedSegment", "square config not ready , use default config instead");
        return;
      }
      catch (Exception localException)
      {
        yqp.d("Q.qqstory.home:FeedSegment", "analyze config error , error :%s", new Object[] { localException.getMessage() });
      }
      str2 = "";
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str2);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynm
 * JD-Core Version:    0.7.0.1
 */