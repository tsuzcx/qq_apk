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
import com.tencent.biz.common.util.NetworkUtil;
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

public class uou
  extends upp<stFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = uxr.a(0.5F);
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
  private ujh jdField_a_of_type_Ujh;
  private ung jdField_a_of_type_Ung;
  private uoa jdField_a_of_type_Uoa;
  private uop jdField_a_of_type_Uop;
  private vea jdField_a_of_type_Vea;
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
  
  private uou(ViewGroup paramViewGroup, ujh paramujh)
  {
    super(paramViewGroup, 2131560393);
    this.jdField_a_of_type_Ujh = paramujh;
    i();
    k();
  }
  
  private void A()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", uvt.g);
      return;
      i1 = 0;
    }
    a("video", uvt.h);
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
    localGradientDrawable.setCornerRadius(uyn.e);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private WSFollowFragment a()
  {
    if (this.jdField_a_of_type_Ujh != null) {
      return this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
    }
    return null;
  }
  
  private String a()
  {
    if (yqu.a(a())) {
      return uvt.c;
    }
    return uvt.b;
  }
  
  public static uou a(ViewGroup paramViewGroup, ujh paramujh)
  {
    return new uou(paramViewGroup, paramujh);
  }
  
  private void a(stSimpleComment paramstSimpleComment, ImageView paramImageView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      uya.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramImageView);
      if (bool) {
        break label162;
      }
      uya.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      uya.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramImageView = this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (paramImageView != null) {
        break label211;
      }
      return;
      bool = false;
      break;
      label162:
      if (paramstSimpleComment.dingNum > 1L)
      {
        uya.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        uya.c("comment", "执行取消点赞 ...............");
      }
    }
    label211:
    paramImageView.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, paramstSimpleComment);
    int i1 = 1000002;
    if (yqu.a(a())) {
      i1 = 1000003;
    }
    paramImageView.jdField_a_of_type_Boolean = true;
    uya.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
    paramstSimpleComment = this.jdField_a_of_type_UserGrowthStFeed.feed;
    uvl.a(paramImageView.a(), d(), i1, paramstSimpleComment);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    uyo.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(uxr.a(paramstSimpleMetaPerson.nick));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(uxr.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    boolean bool = uxr.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      uxr.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      localTextView = this.f;
      if (!uxr.a(paramstSimpleMetaPerson.followStatus)) {
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
        uql.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new uoy(this));
    if (TextUtils.isEmpty(paramString))
    {
      uxr.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    uxr.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    boolean bool = yqu.a(a());
    HashMap localHashMap = new HashMap();
    localHashMap.put("label_type", String.valueOf(paramInt));
    if (bool)
    {
      a(paramString, uvt.c, localHashMap);
      return;
    }
    a(paramString, uvt.b, localHashMap);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uvm.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uvm.a(paramString1, i1, paramString2, paramMap, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (b() == 0)
    {
      uxr.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout, this.m });
      this.i.setText(2131719674);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    rwv.a(this.i, b(), "0");
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(uxr.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label294;
        }
        bool = true;
        localImageView.setSelected(bool);
        uxr.a(0, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(uxr.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing != 1) {
          break label299;
        }
        bool = true;
        label230:
        ((ImageView)localObject).setSelected(bool);
        uxr.a(0, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
      }
    }
    for (;;)
    {
      paramArrayList = uxr.a(2131693205, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
      this.m.setText(paramArrayList);
      this.m.setVisibility(0);
      return;
      label294:
      bool = false;
      break;
      label299:
      bool = false;
      break label230;
      uxr.a(8, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
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
    paramstSimpleMetaFeed = uqh.a(paramstSimpleMetaFeed, this.n.getPaint(), d());
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n.setWidth(paramstSimpleMetaFeed.jdField_a_of_type_Int);
    this.n.setText(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.n.setOnTouchListener(new uqe(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder));
    this.o.setText(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if (this.jdField_a_of_type_Ujh.jdField_a_of_type_Upp == this) {
      if (paramWSPlayerManager.c()) {
        paramWSPlayerManager.b();
      }
    }
    for (;;)
    {
      g(b());
      return;
      paramWSPlayerManager.c();
      s();
      continue;
      this.jdField_a_of_type_Ujh.a(this);
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, uvt.jdField_a_of_type_JavaLangString);
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
      uvm.a("topic", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private int d()
  {
    return unc.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(getLayoutPosition()) + 1;
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
      uvm.a("user_at", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Ujh.a() == this.jdField_a_of_type_UserGrowthStFeed.feed;
  }
  
  private void e(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    umj localumj;
    if ((this.jdField_a_of_type_Ujh != null) && (this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localumj = this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localumj == null) {
        uya.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    uya.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      uvl.a(localumj.a(), uvl.a(localumj.a()) + d(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localumj.a(getPosition());
      localumj.a(localstSimpleMetaFeed);
      localumj.a("focus", "");
      localumj.b();
      unw.a().a(new WSCommentShowEvent(true));
      return;
      uvl.b(localumj.a(), d(), 1000001, localstSimpleMetaFeed);
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
      a("video", uvt.i);
      return;
    }
    b("video");
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.c();
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", uvt.t);
      return;
    }
    a("pausebutton", uvt.s);
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
    return uxr.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368901));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368915));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368923));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131368926));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131368931));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131368910));
    this.f = ((TextView)a(2131368914));
    this.g = ((TextView)a(2131368913));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368911));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368932));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131368909));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131368928));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131368925));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131368947));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368929));
    this.h = ((TextView)a(2131368902));
    this.i = ((TextView)a(2131368933));
    this.j = ((TextView)a(2131368930));
    this.k = ((TextView)a(2131368921));
    this.l = ((TextView)a(2131368934));
    this.p = ((TextView)a(2131368922));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131368899));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131368900));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368906));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368907));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368904));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131368905));
    this.m = ((TextView)a(2131368908));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368954));
    this.n = ((TextView)a(2131368955));
    this.o = ((TextView)a(2131368956));
    this.jdField_a_of_type_Vea = new vea(a(2131367707));
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Uoa == null) && (this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()))
    {
      this.jdField_a_of_type_Uoa = new uoa(a(), this);
      this.jdField_a_of_type_Uoa.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void k()
  {
    uxr.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new uov(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new uow(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new uox(this));
  }
  
  private void l()
  {
    WSFollowFragment.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null) {
      uya.c("comment", "need create presenter ,holder hashCode:" + hashCode());
    }
    Activity localActivity;
    do
    {
      return;
      uya.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
      if ((!b()) && (!c())) {
        this.jdField_a_of_type_Ujh.a().d();
      }
      localActivity = this.jdField_a_of_type_Ujh.a();
    } while (localActivity == null);
    WSVerticalPageFragment.a(localActivity, "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    b(false);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = uxr.a(uyn.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    uyo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165738), "focus", false);
    n();
  }
  
  private void n()
  {
    if (f())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838861);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_Ujh.a());
      boolean bool;
      ImageView localImageView;
      if ((this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()) && (d()))
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
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838862);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void o()
  {
    q();
    e();
    x();
    p();
  }
  
  private void p()
  {
    boolean bool = e();
    if ((this.jdField_a_of_type_Uop == null) && (bool))
    {
      this.jdField_a_of_type_Uop = new uop(this.jdField_a_of_type_Ujh.a(), this);
      this.jdField_a_of_type_Uop.a(this.jdField_b_of_type_AndroidViewViewStub);
    }
    if (bool)
    {
      this.jdField_a_of_type_Uop.f();
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
    this.jdField_a_of_type_Vea.a(new uoz(this));
    stMagicBrand localstMagicBrand = this.jdField_a_of_type_UserGrowthStFeed.feed.magicBrand;
    ArrayList localArrayList = this.jdField_a_of_type_UserGrowthStFeed.feed.brands;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Vea.a(2130850778, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      if ((localstMagicBrand == null) || (TextUtils.isEmpty(localstMagicBrand.text))) {
        break label194;
      }
      if (localstMagicBrand.type != 3) {
        break label177;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
    }
    for (int i1 = 2130850772;; i1 = 2130850773)
    {
      this.jdField_a_of_type_Vea.b(i1, localstMagicBrand.text, localstMagicBrand.schema);
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Vea.a();
      break;
      label177:
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
    }
    label194:
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Vea.b();
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
    Object localObject;
    WSFollowFragment localWSFollowFragment;
    if (this.jdField_a_of_type_Ujh != null)
    {
      localObject = this.jdField_a_of_type_Ujh.jdField_a_of_type_Upp;
      if (localObject != null)
      {
        localObject = ((upp)localObject).jdField_a_of_type_Urt;
        if (localObject != null)
        {
          localWSFollowFragment = a();
          if (localWSFollowFragment != null) {
            break label38;
          }
        }
      }
    }
    label38:
    while (localWSFollowFragment.e()) {
      return;
    }
    uvm.a((urt)localObject);
    localWSFollowFragment.d(true);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    } while (uyo.b());
    uyo.a(a(), this.jdField_a_of_type_UserGrowthStFeed.feed.weishi_jump_url, "", "", 0, new upa(this));
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      uwy localuwy = new uwy();
      localuwy.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localuwy.jdField_a_of_type_Int = 20;
      localuwy.b = d();
      localuwy.jdField_a_of_type_JavaLangString = "focus";
      localuwy.c = ("dynamics_more_operations" + d());
      uyd.a(a(), localuwy);
      b("more_operations");
    }
  }
  
  private void v()
  {
    if (!NetworkUtil.isNetworkAvailable(a()))
    {
      bhzt.a().a(2131719692);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      uya.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_Ung == null) {
      this.jdField_a_of_type_Ung = ung.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (uxr.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", uvt.r);
      uxr.a(a(), new upb(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", uvt.q);
    this.jdField_a_of_type_Ung.b(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void w()
  {
    if (uyo.b()) {
      return;
    }
    uql.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    A();
  }
  
  private void x()
  {
    if (c() > 0)
    {
      rwv.a(this.j, c(), "0");
      return;
    }
    this.j.setText(2131719694);
  }
  
  private void y()
  {
    uyd.a(this.jdField_a_of_type_UserGrowthStFeed.feed, 20, d());
    unc.a().jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_UserGrowthStFeed.feed);
    unc.a().b.remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Ujh.a().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Ujh.notifyItemRemoved(getAdapterPosition());
    bhzt.a().a(2131719675);
    z();
  }
  
  private void z()
  {
    upp localupp = this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(this, true, true);
    StringBuilder localStringBuilder;
    if ((localupp != null) && (this == this.jdField_a_of_type_Ujh.jdField_a_of_type_Upp))
    {
      localStringBuilder = new StringBuilder().append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
      if (localupp.jdField_a_of_type_Urx == null) {
        break label81;
      }
    }
    label81:
    for (String str = localupp.jdField_a_of_type_Urx.d;; str = "videoInfo is null!")
    {
      uya.e("WSFollowFeedHolder", str);
      this.jdField_a_of_type_Ujh.a(localupp);
      return;
    }
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
    return this.jdField_a_of_type_Ujh.a();
  }
  
  public void a()
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uvm.a("qqgroup_float", i1, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    uyo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
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
      uya.d("comment", "添加评论后匹配正确, 添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = uxr.a(2131693205, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    uya.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.m.setText(str);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.i());
    if (!paramWSPlayerManager.i()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Ujh.a(bool);
      paramWSPlayerManager = new WSPlayerMuteEvent(bool);
      unw.a().a(paramWSPlayerManager);
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
    return this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d();
  }
  
  public void b()
  {
    int i1 = d();
    String str = uvt.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      uvm.a("qqgroup", i1, str, null, localstSimpleMetaFeed);
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
    if ((this.jdField_a_of_type_Uoa != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Uoa.f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vea == null) {
      return;
    }
    if (paramBoolean)
    {
      q();
      this.jdField_a_of_type_Vea.c();
      return;
    }
    this.jdField_a_of_type_Vea.f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ujh.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.f();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vea == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Vea.d();
      return;
    }
    this.jdField_a_of_type_Vea.e();
  }
  
  public void e()
  {
    this.k.setVisibility(0);
    this.p.setVisibility(8);
    this.k.setSelected(g());
    if (a() > 0)
    {
      rwv.a(this.l, a(), "0");
      return;
    }
    this.l.setText(2131719691);
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
        uql.a().a(localstSimpleMetaFeed.id);
      }
    }
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.9(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    uya.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
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
        uxr.a(this.jdField_a_of_type_Ujh.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str1);
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
        uxr.a(this.jdField_a_of_type_Ujh.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str2);
        b("nickname");
        continue;
        v();
        continue;
        y();
        b("close");
        continue;
        r();
        continue;
        u();
        continue;
        e(true);
        continue;
        w();
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
            t();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uou
 * JD-Core Version:    0.7.0.1
 */