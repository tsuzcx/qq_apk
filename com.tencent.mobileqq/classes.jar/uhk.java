import NS_KING_SOCIALIZE_META.stMetaPerson;
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
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.9;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class uhk
  extends uif<stFeed>
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = uov.a(0.5F);
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "profile", "nickname", "content", "video", "more_operations" });
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ArrayList<stSimpleComment> jdField_a_of_type_JavaUtilArrayList;
  private ucp jdField_a_of_type_Ucp;
  private ugn jdField_a_of_type_Ugn;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  
  private uhk(ViewGroup paramViewGroup, ucp paramucp)
  {
    super(paramViewGroup, 2131560373);
    this.jdField_a_of_type_Ucp = paramucp;
    e();
    f();
  }
  
  private int a()
  {
    return ugj.a().a.get(getLayoutPosition()) + 1;
  }
  
  private String a()
  {
    if (zmi.a(a())) {
      return umy.c;
    }
    return umy.b;
  }
  
  public static uhk a(ViewGroup paramViewGroup, ucp paramucp)
  {
    return new uhk(paramViewGroup, paramucp);
  }
  
  private void a(stMagicBrand paramstMagicBrand)
  {
    b(paramstMagicBrand);
    a();
  }
  
  private void a(stSimpleComment paramstSimpleComment, ImageView paramImageView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      upe.c("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramImageView);
      if (bool) {
        break label207;
      }
      upe.c("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      upe.c("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramstSimpleComment = this.jdField_a_of_type_Ucp.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      int i1 = 1000002;
      if (zmi.a(a())) {
        i1 = 1000003;
      }
      paramstSimpleComment.jdField_a_of_type_Boolean = true;
      upe.d("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
      paramImageView = this.jdField_a_of_type_UserGrowthStFeed.feed;
      umt.a(paramstSimpleComment.a(), a(), i1, paramImageView);
      return;
      bool = false;
      break;
      label207:
      if (paramstSimpleComment.dingNum > 1L)
      {
        upe.c("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        upe.c("comment", "执行取消点赞 ...............");
      }
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int i2 = 8;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    ups.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(uov.a(paramstSimpleMetaPerson.nick));
    this.d.setText(uov.a(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    boolean bool = uov.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool)
    {
      i1 = 0;
      localTextView.setVisibility(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      uov.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      localTextView = this.f;
      if (!uov.a(paramstSimpleMetaPerson.followStatus)) {
        break label171;
      }
    }
    label171:
    for (int i1 = i2;; i1 = 0)
    {
      localTextView.setVisibility(i1);
      this.g.setVisibility(4);
      this.e.setVisibility(this.f.getVisibility());
      return;
      i1 = 8;
      break;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        uiw.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.l, this.n, this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    this.i.setCompoundDrawables(paramURLDrawable, null, null, null);
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new uho(this));
    if (TextUtils.isEmpty(paramString))
    {
      uov.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    uov.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1 = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      umu.a(paramString1, i1, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private void a(ArrayList<stSimpleComment> paramArrayList)
  {
    if (uov.a(paramArrayList))
    {
      uov.a(8, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.m });
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(uov.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label298;
        }
        bool = true;
        localImageView.setSelected(bool);
        uov.a(0, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_a_of_type_AndroidWidgetImageView });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(uov.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (paramArrayList.isDing != 1) {
          break label303;
        }
        bool = true;
        label227:
        ((ImageView)localObject).setSelected(bool);
        uov.a(0, new View[] { this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_b_of_type_AndroidWidgetImageView });
      }
    }
    for (;;)
    {
      paramArrayList = uov.a(2131693133, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
      this.m.setText(paramArrayList);
      this.m.setVisibility(0);
      return;
      label298:
      bool = false;
      break;
      label303:
      bool = false;
      break label227;
      uov.a(8, new View[] { this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView, this.jdField_b_of_type_AndroidWidgetImageView });
    }
  }
  
  private void b(stMagicBrand paramstMagicBrand)
  {
    if ((paramstMagicBrand != null) && (!TextUtils.isEmpty(paramstMagicBrand.text)))
    {
      this.i.setVisibility(0);
      this.i.setText(paramstMagicBrand.text);
      this.i.setTag(paramstMagicBrand.schema);
      b(paramstMagicBrand.icon);
      return;
    }
    this.i.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      paramString.setBounds(0, 0, upr.b, upr.b);
      paramString.setURLDrawableListener(new uhp(this));
      a(paramString);
      paramString.startDownload();
      if (1 != paramString.getStatus())
      {
        paramString.restartDownload();
        return;
      }
      a(paramString);
      return;
    }
    a(null);
  }
  
  private void b(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    ufp localufp;
    if ((this.jdField_a_of_type_Ucp != null) && (this.jdField_a_of_type_Ucp.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localufp = this.jdField_a_of_type_Ucp.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localufp == null) {
        upe.c("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    upe.c("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      umt.a(localufp.a(), umt.a(localufp.a()) + a(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localufp.a(getPosition());
      localufp.a(localstSimpleMetaFeed);
      localufp.a("focus", "");
      localufp.b();
      uhd.a().a(new WSCommentShowEvent(true));
      return;
      umt.b(localufp.a(), a(), 1000001, localstSimpleMetaFeed);
    }
  }
  
  private void c(String paramString)
  {
    if (zmi.a(a()))
    {
      a(paramString, umy.c);
      return;
    }
    a(paramString, umy.b);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("video", umy.i);
      return;
    }
    d("video");
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  private void d(String paramString)
  {
    a(paramString, umy.jdField_a_of_type_JavaLangString);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("pausebutton", umy.t);
      return;
    }
    a("pausebutton", umy.s);
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null)) {
      return false;
    }
    return uov.a(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368798));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368811));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368814));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131368815));
    this.d = ((TextView)a(2131368821));
    this.e = ((TextView)a(2131368807));
    this.f = ((TextView)a(2131368810));
    this.g = ((TextView)a(2131368809));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368808));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131368822));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131368806));
    this.h = ((TextView)a(2131368817));
    this.i = ((TextView)a(2131368819));
    this.j = ((TextView)a(2131368818));
    this.k = ((TextView)a(2131368799));
    this.l = ((TextView)a(2131368812));
    this.n = ((TextView)a(2131368813));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368803));
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131368804));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368801));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131368802));
    this.m = ((TextView)a(2131368805));
  }
  
  private void e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("topic_id", paramString);
    int i1 = a();
    String str = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (paramString = this.jdField_a_of_type_UserGrowthStFeed.feed;; paramString = null)
    {
      umu.a("topic", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void f()
  {
    uov.a(this, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new uhl(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnTouchListener(new uhm(this));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new uhn(this));
  }
  
  private void f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_id", paramString);
    int i1 = a();
    String str = a();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (paramString = this.jdField_a_of_type_UserGrowthStFeed.feed;; paramString = null)
    {
      umu.a("user_at", i1, str, localHashMap, paramString);
      return;
    }
  }
  
  private void g()
  {
    WSFollowFragment.c = true;
    if (this.jdField_a_of_type_Ucp.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null) {
      upe.c("comment", "need create presenter ,holder hashCode:" + hashCode());
    }
    Activity localActivity;
    do
    {
      return;
      upe.c("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
      if ((!a()) && (!b())) {
        this.jdField_a_of_type_Ucp.a().d();
      }
      localActivity = this.jdField_a_of_type_Ucp.a();
    } while (localActivity == null);
    WSVerticalPageFragment.a(localActivity, "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    a(false);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.height = uov.a(upr.c(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    ups.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStFeed.feed, a().getResources().getDrawable(2131165728), "focus", false);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    ups.a(a(), this.jdField_a_of_type_UserGrowthStFeed.feed.weishi_jump_url, "", "", 0, new uhq(this));
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      uoc localuoc = new uoc();
      localuoc.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localuoc.jdField_a_of_type_Int = 20;
      localuoc.b = a();
      localuoc.jdField_a_of_type_JavaLangString = "focus";
      localuoc.c = ("dynamics_more_operations" + a());
      uph.a(a(), localuoc);
      d("more_operations");
    }
  }
  
  private void k()
  {
    if (!nmd.a(a()))
    {
      biti.a().a(2131719196);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      upe.b("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_a_of_type_Ugn == null) {
      this.jdField_a_of_type_Ugn = ugn.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (uov.a(localstSimpleMetaPerson.followStatus))
    {
      a("follow", umy.r);
      uov.a(a(), new uhr(this, localstSimpleMetaPerson), null);
      return;
    }
    a("follow", umy.q);
    this.jdField_a_of_type_Ugn.b(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void l()
  {
    uiw.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.l, this.n, this.jdField_a_of_type_AndroidViewViewGroup);
    n();
  }
  
  private void m()
  {
    this.jdField_a_of_type_Ucp.a().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Ucp.notifyItemRemoved(getAdapterPosition());
    biti.a().a(2131719182);
  }
  
  private void n()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i1 != 0)
    {
      a("video", umy.g);
      return;
      i1 = 0;
    }
    a("video", umy.h);
  }
  
  public stFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStFeed;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    this.l.setVisibility(0);
    this.n.setVisibility(8);
    this.l.setSelected(c());
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ups.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramInt1, paramInt2);
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
    h();
    a(paramstFeed.feed.magicBrand);
    a(paramstFeed.feed.simpleComments);
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      upe.d("comment", "添加评论后匹配正确,添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = uov.a(2131693133, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    upe.d("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.m.setText(str);
    a(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h == null) {
      return;
    }
    this.h.setSelected(paramBoolean);
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
  
  public void b()
  {
    if (d())
    {
      this.f.setVisibility(8);
      this.g.setVisibility(0);
    }
    for (;;)
    {
      this.e.setVisibility(0);
      return;
      this.f.setVisibility(0);
      this.g.setVisibility(4);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        uiw.a().a(localstSimpleMetaFeed.id);
      }
    }
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().postDelayed(new WSFollowFeedHolder.9(this), 500L);
  }
  
  public void onClick(View paramView)
  {
    upe.b("WSFollowFeedHolder", "[onClick] view: " + paramView);
    if ((a() != null) && (a().feed != null) && (a().feed.poster != null)) {}
    for (Object localObject1 = a().feed.poster.id;; localObject1 = "")
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        uov.a(this.jdField_a_of_type_Ucp.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, (String)localObject1);
        d("profile");
        continue;
        Object localObject2 = localObject1;
        if (a() != null)
        {
          localObject2 = localObject1;
          if (a().feed != null)
          {
            localObject2 = localObject1;
            if (a().feed.poster != null) {
              localObject2 = a().feed.poster.id;
            }
          }
        }
        uov.a(this.jdField_a_of_type_Ucp.a(), (stSchema)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, (String)localObject2);
        d("nickname");
        continue;
        k();
        continue;
        m();
        d("close");
        continue;
        localObject1 = this.jdField_a_of_type_Ucp.a();
        if (this.jdField_a_of_type_Ucp.jdField_a_of_type_Uif == this) {
          if (((WSPlayerManager)localObject1).c()) {
            ((WSPlayerManager)localObject1).b();
          }
        }
        for (;;)
        {
          d(a());
          break;
          ((WSPlayerManager)localObject1).c();
          continue;
          this.jdField_a_of_type_Ucp.a(this);
        }
        if ((paramView.getTag() instanceof stSchema))
        {
          uov.a(this.jdField_a_of_type_Ucp.a(), (stSchema)paramView.getTag(), 700, a(), "bottom_label");
          c("bottom_label");
          continue;
          j();
          continue;
          b(true);
          continue;
          l();
          continue;
          b(false);
          continue;
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_a_of_type_AndroidWidgetImageView);
            continue;
            if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
            {
              a((stSimpleComment)this.jdField_a_of_type_JavaUtilArrayList.get(1), this.jdField_b_of_type_AndroidWidgetImageView);
              continue;
              i();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhk
 * JD-Core Version:    0.7.0.1
 */