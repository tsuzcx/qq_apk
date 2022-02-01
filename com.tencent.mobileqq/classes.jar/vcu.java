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
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.10;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class vcu
  extends vdq<stFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = vmg.a(0.5F);
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
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ArrayList<stSimpleComment> jdField_a_of_type_JavaUtilArrayList;
  private uxe jdField_a_of_type_Uxe;
  private vbg jdField_a_of_type_Vbg;
  private vca jdField_a_of_type_Vca;
  private vcp jdField_a_of_type_Vcp;
  private vst jdField_a_of_type_Vst;
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
  
  private vcu(ViewGroup paramViewGroup, uxe paramuxe)
  {
    super(paramViewGroup, 2131560443);
    this.jdField_a_of_type_Uxe = paramuxe;
    j();
    l();
  }
  
  private void A()
  {
    vdq localvdq = this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a(this, true, true);
    StringBuilder localStringBuilder;
    if ((localvdq != null) && (this == this.jdField_a_of_type_Uxe.jdField_a_of_type_Vdq))
    {
      localStringBuilder = new StringBuilder().append("[WSFollowFeedHolder.java][tryPlayNextVideoOnDelete] playVideo:");
      if (localvdq.jdField_a_of_type_Vgi == null) {
        break label79;
      }
    }
    label79:
    for (String str = localvdq.jdField_a_of_type_Vgi.d;; str = "videoInfo is null!")
    {
      vmp.e("WSFollowFeedHolder", str);
      this.jdField_a_of_type_Uxe.a(localvdq);
      return;
    }
  }
  
  private void B()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", vkh.g);
      return;
      i1 = 0;
    }
    a("video", vkh.h);
  }
  
  private void C()
  {
    Object localObject = null;
    HashMap localHashMap = new HashMap();
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        localObject = localstSimpleMetaFeed.poster;
      }
      if (!vmg.a((stSimpleMetaPerson)localObject)) {
        break label72;
      }
    }
    label72:
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("is_livenow", localObject);
      vka.a("profile", d(), vkh.jdField_a_of_type_JavaLangString, localHashMap, localstSimpleMetaFeed);
      return;
      localstSimpleMetaFeed = null;
      break;
    }
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
    localGradientDrawable.setCornerRadius(vnc.e);
    localGradientDrawable.setColor(Color.parseColor("#40000000"));
    return localGradientDrawable;
  }
  
  private WSFollowFragment a()
  {
    if (this.jdField_a_of_type_Uxe != null) {
      return this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
    }
    return null;
  }
  
  private String a()
  {
    if (zfn.a(a())) {
      return vkh.c;
    }
    return vkh.b;
  }
  
  public static vcu a(ViewGroup paramViewGroup, uxe paramuxe)
  {
    return new vcu(paramViewGroup, paramuxe);
  }
  
  private void a(stSimpleComment paramstSimpleComment, ImageView paramImageView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      vmp.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramImageView);
      if (bool) {
        break label164;
      }
      vmp.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      vmp.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramImageView = this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (paramImageView != null) {
        break label215;
      }
      return;
      bool = false;
      break;
      label164:
      if (paramstSimpleComment.dingNum > 1L)
      {
        vmp.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        vmp.c("comment", "执行取消点赞 ...............");
      }
    }
    label215:
    paramImageView.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, paramstSimpleComment);
    int i1 = 1000002;
    if (zfn.a(a())) {
      i1 = 1000003;
    }
    paramImageView.jdField_a_of_type_Boolean = true;
    vmp.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
    paramstSimpleComment = this.jdField_a_of_type_UserGrowthStFeed.feed;
    vjz.a(paramImageView.a(), d(), i1, paramstSimpleComment);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    boolean bool = vmg.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      if (!vmg.a(paramstSimpleMetaPerson)) {
        break label178;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      label75:
      this.jdField_c_of_type_AndroidWidgetTextView.setText(vmg.a(paramstSimpleMetaPerson.nick));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(vmg.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
      localTextView = this.f;
      if (!vmg.a(paramstSimpleMetaPerson.followStatus)) {
        break label187;
      }
    }
    label178:
    label187:
    for (int i1 = 8;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.g.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(this.f.getVisibility());
      if (!h()) {
        break label192;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      i1 = 8;
      break;
      a(paramstSimpleMetaPerson, bool);
      break label75;
    }
    label192:
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    vnd.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    vmg.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        vem.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new vcy(this));
    if (TextUtils.isEmpty(paramString))
    {
      vmg.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    vmg.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    boolean bool = zfn.a(a());
    HashMap localHashMap = new HashMap();
    localHashMap.put("label_type", String.valueOf(paramInt));
    if (bool)
    {
      a(paramString, vkh.c, localHashMap);
      return;
    }
    a(paramString, vkh.b, localHashMap);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      vka.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      vka.a(paramString1, i1, paramString2, paramMap, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (b() == 0)
    {
      vmg.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout, this.m });
      this.i.setText(2131720127);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    six.a(this.i, b(), "0");
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(vmg.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label320;
        }
        bool = true;
        localImageView.setSelected(bool);
        vmg.a(0, new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(vmg.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.jdField_c_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing != 1) {
          break label325;
        }
        bool = true;
        label229:
        ((ImageView)localObject).setSelected(bool);
        vmg.a(0, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
      }
    }
    for (;;)
    {
      paramArrayList = a().getString(2131693384);
      localObject = a().getString(2131693385);
      paramArrayList = paramArrayList + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num + (String)localObject;
      this.m.setText(paramArrayList);
      this.m.setVisibility(0);
      return;
      label320:
      bool = false;
      break;
      label325:
      bool = false;
      break label229;
      vmg.a(8, new View[] { this.jdField_b_of_type_AndroidWidgetFrameLayout });
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
    paramstSimpleMetaFeed = vei.a(paramstSimpleMetaFeed, this.n.getPaint(), d());
    if (TextUtils.isEmpty(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.n.setWidth(paramstSimpleMetaFeed.jdField_a_of_type_Int);
    this.n.setText(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.n.setOnTouchListener(new vef(paramstSimpleMetaFeed.jdField_a_of_type_AndroidTextSpannableStringBuilder));
    this.o.setText(paramstSimpleMetaFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if (this.jdField_a_of_type_Uxe.jdField_a_of_type_Vdq == this) {
      if (paramWSPlayerManager.c()) {
        paramWSPlayerManager.b();
      }
    }
    for (;;)
    {
      g(b());
      return;
      paramWSPlayerManager.c();
      t();
      continue;
      this.jdField_a_of_type_Uxe.a(this);
    }
  }
  
  private void b(String paramString)
  {
    a(paramString, vkh.jdField_a_of_type_JavaLangString);
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
      vka.a("topic", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private int d()
  {
    return vbc.a().jdField_a_of_type_AndroidUtilSparseIntArray.get(getLayoutPosition()) + 1;
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
      vka.a("user_at", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_Uxe.a() == this.jdField_a_of_type_UserGrowthStFeed.feed;
  }
  
  private void e(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    vaj localvaj;
    if ((this.jdField_a_of_type_Uxe != null) && (this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localvaj = this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localvaj == null) {
        vmp.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    vmp.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      vjz.a(localvaj.a(), vjz.a(localvaj.a()) + d(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localvaj.a(getPosition());
      localvaj.a(localstSimpleMetaFeed);
      localvaj.a("focus", "");
      localvaj.b();
      vbw.a().a(new WSCommentShowEvent(true));
      return;
      vjz.b(localvaj.a(), d(), 1000001, localstSimpleMetaFeed);
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
      a("video", vkh.i);
      return;
    }
    b("video");
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.c();
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", vkh.t);
      return;
    }
    a("pausebutton", vkh.s);
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
    return vmg.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131369061));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131369063));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369076));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131369084));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131369087));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131369092));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131369072));
    this.f = ((TextView)a(2131369075));
    this.g = ((TextView)a(2131369074));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369073));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131369093));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131369071));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131369089));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131369086));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131369108));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369090));
    this.h = ((TextView)a(2131369064));
    this.i = ((TextView)a(2131369094));
    this.j = ((TextView)a(2131369091));
    this.k = ((TextView)a(2131369082));
    this.l = ((TextView)a(2131369095));
    this.p = ((TextView)a(2131369083));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131369059));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131369060));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369068));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131369069));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131369066));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131369067));
    this.m = ((TextView)a(2131369070));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131369115));
    this.n = ((TextView)a(2131369116));
    this.o = ((TextView)a(2131369117));
    this.jdField_a_of_type_Vst = new vst(a(2131376912));
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Vca == null) && (this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()))
    {
      this.jdField_a_of_type_Vca = new vca(a(), this);
      this.jdField_a_of_type_Vca.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void l()
  {
    vmg.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView });
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new vcv(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new vcw(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new vcx(this));
  }
  
  private void m()
  {
    WSFollowFragment.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null) {
      vmp.c("comment", "need create presenter ,holder hashCode:" + hashCode());
    }
    Activity localActivity;
    do
    {
      return;
      vmp.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
      if ((!b()) && (!c())) {
        this.jdField_a_of_type_Uxe.a().d();
      }
      localActivity = this.jdField_a_of_type_Uxe.a();
    } while (localActivity == null);
    WSVerticalPageFragment.a(localActivity, "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    b(false);
  }
  
  private void n()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = vmg.a(vnc.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165747), "focus", false);
    o();
  }
  
  private void o()
  {
    if (f())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838907);
      this.jdField_d_of_type_AndroidWidgetImageView.setSelected(this.jdField_a_of_type_Uxe.a());
      boolean bool;
      ImageView localImageView;
      if ((this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d()) && (d()))
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
        k();
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
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130838908);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void p()
  {
    r();
    e();
    y();
    q();
  }
  
  private void q()
  {
    boolean bool = e();
    if ((this.jdField_a_of_type_Vcp == null) && (bool))
    {
      this.jdField_a_of_type_Vcp = new vcp(this.jdField_a_of_type_Uxe.a(), this);
      this.jdField_a_of_type_Vcp.a(this.jdField_b_of_type_AndroidViewViewStub);
    }
    if (bool)
    {
      this.jdField_a_of_type_Vcp.f();
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
    }
    while (this.jdField_b_of_type_AndroidViewViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_Vst.a(new vcz(this));
    stMagicBrand localstMagicBrand = this.jdField_a_of_type_UserGrowthStFeed.feed.magicBrand;
    ArrayList localArrayList = this.jdField_a_of_type_UserGrowthStFeed.feed.brands;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Vst.a(2130850920, ((stMagicBrand)localArrayList.get(0)).text, ((stMagicBrand)localArrayList.get(0)).schema);
      if ((localstMagicBrand == null) || (TextUtils.isEmpty(localstMagicBrand.text))) {
        break label194;
      }
      if (localstMagicBrand.type != 3) {
        break label177;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
    }
    for (int i1 = 2130850914;; i1 = 2130850915)
    {
      this.jdField_a_of_type_Vst.b(i1, localstMagicBrand.text, localstMagicBrand.schema);
      return;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Vst.a();
      break;
      label177:
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
    }
    label194:
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Vst.b();
  }
  
  private void s()
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
  
  private void t()
  {
    Object localObject;
    WSFollowFragment localWSFollowFragment;
    if (this.jdField_a_of_type_Uxe != null)
    {
      localObject = this.jdField_a_of_type_Uxe.jdField_a_of_type_Vdq;
      if (localObject != null)
      {
        localObject = ((vdq)localObject).jdField_a_of_type_Vgb;
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
    vka.a((vgb)localObject);
    localWSFollowFragment.d(true);
  }
  
  private void u()
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
    } while (vnd.b());
    vnd.a(a(), this.jdField_a_of_type_UserGrowthStFeed.feed.weishi_jump_url, "", "", 0, new vda(this));
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      vln localvln = new vln();
      localvln.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localvln.jdField_a_of_type_Int = 20;
      localvln.b = d();
      localvln.jdField_a_of_type_JavaLangString = "focus";
      localvln.c = ("dynamics_more_operations" + d());
      vms.a(a(), localvln);
      b("more_operations");
    }
  }
  
  private void w()
  {
    if (!NetworkUtil.isNetworkAvailable(a()))
    {
      bjkv.a().a(2131720145);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      vmp.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_Vbg == null) {
      this.jdField_a_of_type_Vbg = vbg.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (vmg.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", vkh.r);
      vmg.a(a(), new vdb(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", vkh.q);
    this.jdField_a_of_type_Vbg.b(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void x()
  {
    if (vnd.b()) {
      return;
    }
    vem.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.k, this.p, this.jdField_a_of_type_AndroidViewViewGroup);
    B();
  }
  
  private void y()
  {
    if (c() > 0)
    {
      six.a(this.j, c(), "0");
      return;
    }
    this.j.setText(2131720147);
  }
  
  private void z()
  {
    vms.a(this.jdField_a_of_type_UserGrowthStFeed.feed, 20, d());
    vbc.a().jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_UserGrowthStFeed.feed);
    vbc.a().b.remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Uxe.b().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Uxe.notifyItemRemoved(getAdapterPosition());
    bjkv.a().a(2131720128);
    A();
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
    return this.jdField_a_of_type_Uxe.a();
  }
  
  public void a()
  {
    int i1 = d();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      vka.a("qqgroup_float", i1, localstSimpleMetaFeed);
      return;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    vnd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
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
    n();
    p();
    a(paramstFeed.feed.simpleComments);
    b(paramstFeed.feed);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      vmp.d("comment", "添加评论后匹配正确, 添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = vmg.a(2131693383, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    vmp.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.m.setText(str);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    h(paramWSPlayerManager.i());
    if (!paramWSPlayerManager.i()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Uxe.a(bool);
      paramWSPlayerManager = new WSPlayerMuteEvent(bool);
      vbw.a().a(paramWSPlayerManager);
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
    return this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.d();
  }
  
  public void b()
  {
    int i1 = d();
    String str = vkh.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      vka.a("qqgroup", i1, str, null, localstSimpleMetaFeed);
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
    if ((this.jdField_a_of_type_Vca != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Vca.f();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vst == null) {
      return;
    }
    if (paramBoolean)
    {
      r();
      this.jdField_a_of_type_Vst.c();
      return;
    }
    this.jdField_a_of_type_Vst.f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Uxe.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.f();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vst == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Vst.d();
      return;
    }
    this.jdField_a_of_type_Vst.e();
  }
  
  public void e()
  {
    this.k.setVisibility(0);
    this.p.setVisibility(8);
    this.k.setSelected(g());
    if (a() > 0)
    {
      six.a(this.l, a(), "0");
      return;
    }
    this.l.setText(2131720144);
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
    Object localObject = this.jdField_a_of_type_UserGrowthStFeed;
    if (localObject != null)
    {
      localObject = ((stFeed)localObject).feed;
      if (localObject != null)
      {
        localObject = ((stSimpleMetaFeed)localObject).poster;
        if (localObject != null) {
          break label28;
        }
      }
    }
    label28:
    while (!vmg.a((stSimpleMetaPerson)localObject)) {
      return;
    }
    veu.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, ((stSimpleMetaPerson)localObject).avatar, new vdc(this, (stSimpleMetaPerson)localObject));
  }
  
  public void h()
  {
    super.h();
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {}
    }
    else
    {
      return;
    }
    vem.a().a(localstSimpleMetaFeed.id);
    veu.a().a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void i()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.10(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    vmp.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
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
        vmg.a(this.jdField_a_of_type_Uxe.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str1);
        C();
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
        vmg.a(this.jdField_a_of_type_Uxe.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, str2);
        b("nickname");
        continue;
        w();
        continue;
        z();
        b("close");
        continue;
        s();
        continue;
        v();
        continue;
        e(true);
        continue;
        x();
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
            u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */