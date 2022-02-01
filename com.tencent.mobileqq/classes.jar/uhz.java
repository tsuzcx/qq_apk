import NS_KING_SOCIALIZE_META.stMetaPerson;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSPlayerMuteEvent;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class uhz
  extends uiu<stFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = upw.a(0.5F);
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ArrayList<stSimpleComment> jdField_a_of_type_JavaUtilArrayList;
  private ucr jdField_a_of_type_Ucr;
  private ugp jdField_a_of_type_Ugp;
  private uhj jdField_a_of_type_Uhj;
  private uhx jdField_a_of_type_Uhx;
  private uwd jdField_a_of_type_Uwd;
  private boolean jdField_a_of_type_Boolean;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  
  private uhz(ViewGroup paramViewGroup, ucr paramucr)
  {
    super(paramViewGroup, 2131560385);
    this.jdField_a_of_type_Ucr = paramucr;
    i();
    k();
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.ding_count;
    }
    return 0;
  }
  
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(uqs.e);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private String a()
  {
    if (zqd.a(a())) {
      return unz.c;
    }
    return unz.b;
  }
  
  public static uhz a(ViewGroup paramViewGroup, ucr paramucr)
  {
    return new uhz(paramViewGroup, paramucr);
  }
  
  private void a(stSimpleComment paramstSimpleComment, ImageView paramImageView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      uqf.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramImageView);
      if (bool) {
        break label207;
      }
      uqf.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      uqf.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramstSimpleComment = this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      int i1 = 1000002;
      if (zqd.a(a())) {
        i1 = 1000003;
      }
      paramstSimpleComment.jdField_a_of_type_Boolean = true;
      uqf.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
      paramImageView = this.jdField_a_of_type_UserGrowthStFeed.feed;
      unr.a(paramstSimpleComment.a(), d(), i1, paramImageView);
      return;
      bool = false;
      break;
      label207:
      if (paramstSimpleComment.dingNum > 1L)
      {
        uqf.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        uqf.c("comment", "执行取消点赞 ...............");
      }
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    uqt.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(upw.a(paramstSimpleMetaPerson.nick));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(upw.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    boolean bool = upw.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      upw.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      localTextView = this.f;
      if (!upw.a(paramstSimpleMetaPerson.followStatus)) {
        break label181;
      }
    }
    label181:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.g.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(this.f.getVisibility());
      if (!h()) {
        break label186;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      i1 = 8;
      break;
    }
    label186:
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        ujq.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new uid(this));
    if (TextUtils.isEmpty(paramString))
    {
      upw.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    upw.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    boolean bool = zqd.a(a());
    HashMap localHashMap = new HashMap();
    localHashMap.put("label_type", String.valueOf(paramInt));
    if (bool)
    {
      a(paramString, unz.c, localHashMap);
      return;
    }
    a(paramString, unz.b, localHashMap);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uns.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uns.a(paramString1, i1, paramString2, paramMap, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (b() == 0)
    {
      upw.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout, this.m });
      this.i.setText(2131719356);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    rpt.a(this.i, b(), "0");
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(upw.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label294;
        }
        bool = true;
        localImageView.setSelected(bool);
        upw.a(0, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(upw.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing != 1) {
          break label299;
        }
        bool = true;
        label230:
        ((ImageView)localObject).setSelected(bool);
        upw.a(0, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
      }
    }
    for (;;)
    {
      paramArrayList = upw.a(2131693142, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
      this.m.setText(paramArrayList);
      this.m.setVisibility(0);
      return;
      label294:
      bool = false;
      break;
      label299:
      bool = false;
      break label230;
      upw.a(8, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
    }
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num;
    }
    return 0;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = ujm.a(paramstSimpleMetaFeed, this.n.getPaint(), d());
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n.setWidth(paramstSimpleMetaFeed.jdField_a_of_type_Int);
    this.n.setText(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.n.setOnTouchListener(new ujj(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder));
    this.o.setText(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if (this.jdField_a_of_type_Ucr.jdField_a_of_type_Uiu == this) {
      if (paramWSPlayerManager.c()) {
        paramWSPlayerManager.b();
      }
    }
    for (;;)
    {
      g(b());
      return;
      paramWSPlayerManager.c();
      continue;
      this.jdField_a_of_type_Ucr.a(this);
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, unz.jdField_a_of_type_JavaLangString);
  }
  
  private int c()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null)) {
      return this.jdField_a_of_type_UserGrowthStFeed.feed.share_info.share_num;
    }
    return 0;
  }
  
  private void c(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("topic_id", paramString);
    int i1 = d();
    String str = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (paramString = this.jdField_a_of_type_UserGrowthStFeed.feed;; paramString = null)
    {
      uns.a("topic", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private int d()
  {
    return ugl.a().a.get(getLayoutPosition()) + 1;
  }
  
  private void d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", paramString);
    int i1 = d();
    String str = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (paramString = this.jdField_a_of_type_UserGrowthStFeed.feed;; paramString = null)
    {
      uns.a("user_at", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Ucr.a() == this.jdField_a_of_type_UserGrowthStFeed.feed;
  }
  
  private void e(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    ufr localufr;
    if ((this.jdField_a_of_type_Ucr != null) && (this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localufr = this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localufr == null) {
        uqf.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    uqf.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      unr.a(localufr.a(), unr.a(localufr.a()) + d(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localufr.a(getPosition());
      localufr.a(localstSimpleMetaFeed);
      localufr.a("focus", "");
      localufr.b();
      uhf.a().a(new WSCommentShowEvent(true));
      return;
      unr.b(localufr.a(), d(), 1000001, localstSimpleMetaFeed);
    }
  }
  
  private boolean e()
  {
    stFeed localstFeed = a();
    return (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0);
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("video", unz.i);
      return;
    }
    b("video");
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.c();
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", unz.t);
      return;
    }
    a("pausebutton", unz.s);
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1007008;; i1 = 1007009)
    {
      a("mutebutton", String.valueOf(i1));
      return;
    }
  }
  
  private boolean h()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null)) {
      return false;
    }
    return upw.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368876));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368890));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368898));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131368901));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131368906));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131368885));
    this.f = ((TextView)a(2131368889));
    this.g = ((TextView)a(2131368888));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368886));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368907));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131368884));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131368903));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368900));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131368921));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368904));
    this.h = ((TextView)a(2131368877));
    this.i = ((TextView)a(2131368908));
    this.j = ((TextView)a(2131368905));
    this.k = ((TextView)a(2131368896));
    this.l = ((TextView)a(2131368909));
    this.p = ((TextView)a(2131368897));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131368874));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131368875));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368881));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368882));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368879));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131368880));
    this.m = ((TextView)a(2131368883));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368928));
    this.n = ((TextView)a(2131368929));
    this.o = ((TextView)a(2131368930));
    this.jdField_a_of_type_Uwd = new uwd(a(2131367675));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Uhj == null) && (this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()))
    {
      this.jdField_a_of_type_Uhj = new uhj(a(), this);
      this.jdField_a_of_type_Uhj.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void k()
  {
    upw.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new uia(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new uib(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new uic(this));
  }
  
  private void l()
  {
    WSFollowFragment.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null) {
      uqf.c("comment", "need create presenter ,holder hashCode:" + hashCode());
    }
    Activity localActivity;
    do
    {
      return;
      uqf.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
      if ((!b()) && (!c())) {
        this.jdField_a_of_type_Ucr.a().d();
      }
      localActivity = this.jdField_a_of_type_Ucr.a();
    } while (localActivity == null);
    WSVerticalPageFragment.a(localActivity, "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    b(false);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = upw.a(uqs.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165728), "focus", false);
    n();
  }
  
  private void n()
  {
    if (f())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838774);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_Ucr.a());
      boolean bool;
      ImageView localImageView;
      if ((this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()) && (d()))
      {
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!this.jdField_b_of_type_Boolean) {
          break label102;
        }
      }
      label102:
      for (Object localObject = null;; localObject = a())
      {
        localImageView.setBackgroundDrawable((Drawable)localObject);
        if (!this.jdField_b_of_type_Boolean) {
          break label110;
        }
        j();
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
        return;
        bool = false;
        break;
      }
      label110:
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838775);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void o()
  {
    q();
    e();
    w();
    p();
  }
  
  private void p()
  {
    boolean bool = e();
    if ((this.jdField_a_of_type_Uhx == null) && (bool))
    {
      this.jdField_a_of_type_Uhx = new uhx(this.jdField_a_of_type_Ucr.a(), this);
      this.jdField_a_of_type_Uhx.a(this.jdField_b_of_type_AndroidViewViewStub);
    }
    if (bool)
    {
      this.jdField_a_of_type_Uhx.f();
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
    }
    while (this.jdField_b_of_type_AndroidViewViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_Uwd.a(new uie(this));
    stMagicBrand localstMagicBrand = this.jdField_a_of_type_UserGrowthStFeed.feed.magicBrand;
    ArrayList localArrayList = this.jdField_a_of_type_UserGrowthStFeed.feed.brands;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Uwd.a(2130850844, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      if ((localstMagicBrand == null) || (TextUtils.isEmpty(localstMagicBrand.text))) {
        break label194;
      }
      if (localstMagicBrand.type != 3) {
        break label177;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
    }
    for (int i1 = 2130850838;; i1 = 2130850839)
    {
      this.jdField_a_of_type_Uwd.b(i1, localstMagicBrand.text, localstMagicBrand.schema);
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Uwd.a();
      break;
      label177:
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
    }
    label194:
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Uwd.b();
  }
  
  private void r()
  {
    WSPlayerManager localWSPlayerManager = a();
    if (localWSPlayerManager == null) {
      return;
    }
    if (f())
    {
      a(localWSPlayerManager);
      c();
      return;
    }
    b(localWSPlayerManager);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    uqt.a(a(), this.jdField_a_of_type_UserGrowthStFeed.feed.weishi_jump_url, "", "", 0, new uif(this));
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      upd localupd = new upd();
      localupd.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localupd.jdField_a_of_type_Int = 20;
      localupd.b = d();
      localupd.jdField_a_of_type_JavaLangString = "focus";
      localupd.c = ("dynamics_more_operations" + d());
      uqi.a(a(), localupd);
      b("more_operations");
    }
  }
  
  private void u()
  {
    if (!nny.a(a()))
    {
      bjuh.a().a(2131719373);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      uqf.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_Ugp == null) {
      this.jdField_a_of_type_Ugp = ugp.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (upw.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", unz.r);
      upw.a(a(), new uig(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", unz.q);
    this.jdField_a_of_type_Ugp.b(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void v()
  {
    ujq.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    y();
  }
  
  private void w()
  {
    if (c() > 0)
    {
      rpt.a(this.j, c(), "0");
      return;
    }
    this.j.setText(2131719375);
  }
  
  private void x()
  {
    this.jdField_a_of_type_Ucr.a().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Ucr.notifyItemRemoved(getAdapterPosition());
    bjuh.a().a(2131719357);
  }
  
  private void y()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", unz.g);
      return;
      i1 = 0;
    }
    a("video", unz.h);
  }
  
  public stFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStFeed;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_Ucr.a();
  }
  
  public void a()
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uns.a("qqgroup_float", i1, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
  }
  
  public void a(stFeed paramstFeed)
  {
    super.a(paramstFeed);
    if ((paramstFeed == null) || (paramstFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
    a(paramstFeed.feed.poster);
    a(paramstFeed.feed.feed_desc);
    m();
    o();
    a(paramstFeed.feed.simpleComments);
    b(paramstFeed.feed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      uqf.d("comment", "添加评论后匹配正确, 添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = upw.a(2131693142, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    uqf.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.m.setText(str);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.i());
    if (!paramWSPlayerManager.i()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Ucr.a(bool);
      paramWSPlayerManager = new WSPlayerMuteEvent(bool);
      uhf.a().a(paramWSPlayerManager);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ImageView paramImageView)
  {
    if (!paramBoolean)
    {
      paramImageView.setSelected(true);
      return;
    }
    paramImageView.setSelected(false);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d();
  }
  
  public void b()
  {
    int i1 = d();
    String str = unz.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uns.a("qqgroup", i1, str, null, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_AndroidWidgetImageView == null) || (f())) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Uhj != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Uhj.f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uwd == null) {
      return;
    }
    if (paramBoolean)
    {
      q();
      this.jdField_a_of_type_Uwd.c();
      return;
    }
    this.jdField_a_of_type_Uwd.f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ucr.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.f();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uwd == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Uwd.d();
      return;
    }
    this.jdField_a_of_type_Uwd.e();
  }
  
  public void e()
  {
    this.k.setVisibility(0);
    this.p.setVisibility(8);
    this.k.setSelected(g());
    if (a() > 0)
    {
      rpt.a(this.l, a(), "0");
      return;
    }
    this.l.setText(2131719372);
  }
  
  public void f()
  {
    if (h())
    {
      this.f.setVisibility(8);
      this.g.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      this.f.setVisibility(0);
      this.g.setVisibility(4);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        ujq.a().a(localstSimpleMetaFeed.id);
      }
    }
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.9(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    uqf.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
    if ((a() != null) && (a().feed != null) && (a().feed.poster != null)) {}
    for (String str1 = a().feed.poster.id;; str1 = "")
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        upw.a(this.jdField_a_of_type_Ucr.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str1);
        b("profile");
        continue;
        String str2 = str1;
        if (a() != null)
        {
          str2 = str1;
          if (a().feed != null)
          {
            str2 = str1;
            if (a().feed.poster != null) {
              str2 = a().feed.poster.id;
            }
          }
        }
        upw.a(this.jdField_a_of_type_Ucr.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str2);
        b("nickname");
        continue;
        u();
        continue;
        x();
        b("close");
        continue;
        r();
        continue;
        t();
        continue;
        e(true);
        continue;
        v();
        continue;
        e(false);
        continue;
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_b_of_type_AndroidWidgetImageView);
          continue;
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
          {
            a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_c_of_type_AndroidWidgetImageView);
            continue;
            s();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhz
 * JD-Core Version:    0.7.0.1
 */