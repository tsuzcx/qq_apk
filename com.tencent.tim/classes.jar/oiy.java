import NS_KING_SOCIALIZE_META.stMetaPerson;
import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.annotation.SuppressLint;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class oiy
  extends ojm<stFeed>
  implements View.OnClickListener
{
  private static final List<String> ld = Arrays.asList(new String[] { "profile", "nickname", "content", "video", "more_operations" });
  private KandianUrlImageView Z;
  private stFeed jdField_a_of_type_UserGrowthStFeed;
  private oey jdField_a_of_type_Oey;
  private FeedRichTextView jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private RoundImageView jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private oig jdField_b_of_type_Oig;
  private FeedRichTextView c;
  private ViewGroup ci;
  private FeedRichTextView d;
  private TextView ll;
  private GestureDetector mGestureDetector;
  private TextView mTimeText;
  private ArrayList<stSimpleComment> me;
  private TextView uA;
  private TextView uC;
  private TextView uD;
  private TextView uF;
  private TextView uH;
  private TextView uq;
  private TextView ur;
  private TextView us;
  private TextView ut;
  private TextView uu;
  private TextView uv;
  private TextView uw;
  private TextView ux;
  private TextView uy;
  
  private oiy(ViewGroup paramViewGroup, oey paramoey)
  {
    super(paramViewGroup, 2131560579);
    this.jdField_a_of_type_Oey = paramoey;
    initView();
    kJ();
  }
  
  private void C(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        okd.a().a(localstSimpleMetaFeed, -1, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), null, this.uA, this.uH, this.ci);
      }
    }
  }
  
  private boolean GV()
  {
    return (this.jdField_a_of_type_UserGrowthStFeed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed != null) && (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1);
  }
  
  public static oiy a(ViewGroup paramViewGroup, oey paramoey)
  {
    return new oiy(paramViewGroup, paramoey);
  }
  
  private void a(stMagicBrand paramstMagicBrand)
  {
    b(paramstMagicBrand);
    bfh();
  }
  
  private void a(stSimpleComment paramstSimpleComment, TextView paramTextView)
  {
    boolean bool;
    if (paramstSimpleComment.isDing == 1)
    {
      bool = true;
      ooz.w("comment", "点赞前 isDing：" + bool + ",mComment.isDing:" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      a(bool, paramTextView);
      if (bool) {
        break label210;
      }
      ooz.w("comment", "执行点赞 ...............");
      paramstSimpleComment.dingNum += 1L;
    }
    for (;;)
    {
      paramstSimpleComment.isDing = ((paramstSimpleComment.isDing + 1) % 2);
      ooz.w("comment", "点赞后 mComment.isDing：" + paramstSimpleComment.isDing + ",mComment.dingNum:" + paramstSimpleComment.dingNum);
      paramstSimpleComment = this.jdField_a_of_type_Oey.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      int i = 1000002;
      if (rpw.isWeishiInstalled(getContext())) {
        i = 1000003;
      }
      paramstSimpleComment.axf = true;
      ooz.e("comment", "wsCommentPresenter.mCommentListChanged:true---------------------");
      paramTextView = this.jdField_a_of_type_UserGrowthStFeed.feed;
      WSPublicAccReport.getInstance().reportCommentDing(paramstSimpleComment.getSopName(), rw(), i, paramTextView);
      return;
      bool = false;
      break;
      label210:
      if (paramstSimpleComment.dingNum > 1L)
      {
        ooz.w("comment", "执行点赞-1 ...............");
        paramstSimpleComment.dingNum -= 1L;
      }
      else
      {
        paramstSimpleComment.dingNum -= 1L;
        ooz.w("comment", "执行取消点赞 ...............");
      }
    }
  }
  
  private void b(stMagicBrand paramstMagicBrand)
  {
    if ((paramstMagicBrand != null) && (!TextUtils.isEmpty(paramstMagicBrand.text)))
    {
      this.ux.setVisibility(0);
      this.ux.setText(paramstMagicBrand.text);
      this.ux.setTag(paramstMagicBrand.schema);
      pD(paramstMagicBrand.icon);
      return;
    }
    this.ux.setVisibility(8);
  }
  
  private void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    int j = 8;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setTag(paramstSimpleMetaPerson.avatarSchema);
    opn.a(getContext(), this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    this.us.setText(oor.fy(paramstSimpleMetaPerson.nick));
    this.mTimeText.setText(oor.bM(this.jdField_a_of_type_UserGrowthStFeed.feed.createTime));
    boolean bool = oor.ev(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.uq;
    if (bool)
    {
      i = 0;
      localTextView.setVisibility(i);
      this.ur.setVisibility(8);
      oor.a(this.ur, paramstSimpleMetaPerson.medal, bool);
      localTextView = this.uu;
      if (!oor.eu(paramstSimpleMetaPerson.followStatus)) {
        break label171;
      }
    }
    label171:
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      this.uv.setVisibility(4);
      this.ut.setVisibility(this.uu.getVisibility());
      return;
      i = 8;
      break;
    }
  }
  
  private void bfc()
  {
    WSFollowFragment.awK = true;
    if (this.jdField_a_of_type_Oey.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a == null)
    {
      ooz.w("comment", "need create presenter ,holder hashCode:" + hashCode());
      return;
    }
    ooz.w("comment", "复用 presenter 33333333333333333, holder hashCode:" + hashCode());
    if (!isPlaying()) {
      this.jdField_a_of_type_Oey.a().stop();
    }
    WSVerticalPageFragment.a(this.jdField_a_of_type_Oey.getActivity(), "follow_tab", "focus", null, getLayoutPosition(), 4097);
    this.Z.setVisibility(0);
    qK(false);
  }
  
  private void bfd()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ci.getLayoutParams();
    localLayoutParams.height = oor.a(opm.getScreenWidth(), this.jdField_a_of_type_UserGrowthStFeed.feed.video);
    this.Z.setLayoutParams(localLayoutParams);
    this.ci.setLayoutParams(localLayoutParams);
    this.Z.setVisibility(0);
    opn.a(this.Z, this.jdField_a_of_type_UserGrowthStFeed.feed, getContext().getResources().getDrawable(2131165905), "focus", false);
  }
  
  private void bfe()
  {
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      ooe localooe = new ooe();
      localooe.b = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localooe.mPageType = 20;
      localooe.mPosition = rw();
      localooe.mSopName = "focus";
      localooe.aqU = ("dynamics_more_operations" + rw());
      opc.a(getContext(), localooe);
      reportClick("more_operations");
    }
  }
  
  private void bff()
  {
    if (!jqi.isNetworkAvailable(getContext()))
    {
      arxa.a().showToast(2131721932);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null))
    {
      ooz.d("WSFollowFeedHolder", "[showFollowAction] is null");
      return;
    }
    if (this.jdField_b_of_type_Oig == null) {
      this.jdField_b_of_type_Oig = oig.a();
    }
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStFeed.feed.poster;
    if (oor.eu(localstSimpleMetaPerson.followStatus))
    {
      reportClick("follow", onh.a.aqP);
      oor.a(getContext(), new oje(this, localstSimpleMetaPerson), null);
      return;
    }
    reportClick("follow", onh.a.aqO);
    this.jdField_b_of_type_Oig.aY(localstSimpleMetaPerson.id, 1);
    localstSimpleMetaPerson.followStatus = 1;
    this.uu.setVisibility(8);
    this.uv.setVisibility(0);
  }
  
  private void bfg()
  {
    okd.a().a(this.jdField_a_of_type_UserGrowthStFeed.feed, -1, null, this.uA, this.uH, this.ci);
    bfk();
  }
  
  private void bfj()
  {
    this.jdField_a_of_type_Oey.be().remove(this.jdField_a_of_type_UserGrowthStFeed);
    this.jdField_a_of_type_Oey.notifyItemRemoved(getAdapterPosition());
    arxa.a().showToast(2131721923);
  }
  
  private void bfk()
  {
    int i = 1;
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null)) {
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.is_ding == 1) {}
    while (i != 0)
    {
      reportClick("video", onh.a.aqE);
      return;
      i = 0;
    }
    reportClick("video", onh.a.aqF);
  }
  
  private void cb(ArrayList<stSimpleComment> paramArrayList)
  {
    if (oor.v(paramArrayList))
    {
      oor.a(8, new View[] { this.c, this.d, this.uC, this.uD, this.uF });
      return;
    }
    this.me = paramArrayList;
    Object localObject;
    boolean bool;
    if (paramArrayList.size() > 0)
    {
      localObject = (stSimpleComment)paramArrayList.get(0);
      if (localObject != null)
      {
        this.c.setText(oor.a(((stSimpleComment)localObject).poster.nick, ((stSimpleComment)localObject).wording, ((stSimpleComment)localObject).posterId));
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        TextView localTextView = this.uC;
        if (((stSimpleComment)localObject).isDing != 1) {
          break label298;
        }
        bool = true;
        localTextView.setSelected(bool);
        oor.a(0, new View[] { this.c, this.uC });
      }
    }
    if (paramArrayList.size() > 1)
    {
      paramArrayList = (stSimpleComment)paramArrayList.get(1);
      if (paramArrayList != null)
      {
        this.d.setText(oor.a(paramArrayList.poster.nick, paramArrayList.wording, paramArrayList.posterId));
        this.c.setMovementMethod(LinkMovementMethod.getInstance());
        localObject = this.uD;
        if (paramArrayList.isDing != 1) {
          break label303;
        }
        bool = true;
        label227:
        ((TextView)localObject).setSelected(bool);
        oor.a(0, new View[] { this.d, this.uD });
      }
    }
    for (;;)
    {
      paramArrayList = oor.b(2131695131, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
      this.uF.setText(paramArrayList);
      this.uF.setVisibility(0);
      return;
      label298:
      bool = false;
      break;
      label303:
      bool = false;
      break label227;
      oor.a(8, new View[] { this.d, this.uD });
    }
  }
  
  private void d(URLDrawable paramURLDrawable)
  {
    this.ux.setCompoundDrawables(paramURLDrawable, null, null, null);
  }
  
  private void initView()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)getView(2131369431));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(DpUtil.dip2px(getContext(), 0.5F));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#D9D9D9"));
    this.uq = ((TextView)getView(2131369444));
    this.ur = ((TextView)getView(2131369447));
    this.us = ((TextView)getView(2131369448));
    this.mTimeText = ((TextView)getView(2131369454));
    this.ut = ((TextView)getView(2131369440));
    this.uu = ((TextView)getView(2131369443));
    this.uv = ((TextView)getView(2131369442));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)getView(2131369441));
    this.ci = ((ViewGroup)getView(2131369455));
    this.Z = ((KandianUrlImageView)getView(2131369439));
    this.uw = ((TextView)getView(2131369450));
    this.ux = ((TextView)getView(2131369452));
    this.uy = ((TextView)getView(2131369451));
    this.ll = ((TextView)getView(2131369432));
    this.uA = ((TextView)getView(2131369445));
    this.uH = ((TextView)getView(2131369446));
    this.c = ((FeedRichTextView)getView(2131369436));
    this.d = ((FeedRichTextView)getView(2131369437));
    this.uC = ((TextView)getView(2131369434));
    this.uD = ((TextView)getView(2131369435));
    this.uF = ((TextView)getView(2131369438));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void kJ()
  {
    oor.a(this, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.us, this.uq, this.ur });
    this.ut.setOnClickListener(this);
    this.uu.setOnClickListener(this);
    this.uv.setOnClickListener(this);
    this.uw.setOnClickListener(this);
    this.ux.setOnClickListener(this);
    this.uy.setOnClickListener(this);
    this.ll.setOnClickListener(this);
    this.uA.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.uC.setOnClickListener(this);
    this.uD.setOnClickListener(this);
    this.uF.setOnClickListener(this);
    this.mGestureDetector = new GestureDetector(getContext(), new oiz(this));
    this.Z.setOnTouchListener(new oja(this));
    this.ci.setOnTouchListener(new ojb(this));
  }
  
  private void pC(String paramString)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnElementClickListener(new ojc(this));
    if (TextUtils.isEmpty(paramString))
    {
      oor.a(8, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
      return;
    }
    oor.a(0, new View[] { this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView });
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void pD(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      paramString.setBounds(0, 0, opm.bfD, opm.bfD);
      paramString.setURLDrawableListener(new ojd(this));
      d(paramString);
      paramString.startDownload();
      if (1 != paramString.getStatus())
      {
        paramString.restartDownload();
        return;
      }
      d(paramString);
      return;
    }
    d(null);
  }
  
  private void pE(String paramString)
  {
    if (rpw.isWeishiInstalled(getContext()))
    {
      reportClick(paramString, onh.a.aqA);
      return;
    }
    reportClick(paramString, onh.a.aqz);
  }
  
  private void qJ(boolean paramBoolean)
  {
    stSimpleMetaFeed localstSimpleMetaFeed;
    ohl localohl;
    if ((this.jdField_a_of_type_Oey != null) && (this.jdField_a_of_type_Oey.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment != null))
    {
      localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      localohl = this.jdField_a_of_type_Oey.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.a;
      if (localohl == null) {
        ooz.w("comment", "need create presenter , holder hashCode:" + hashCode());
      }
    }
    else
    {
      return;
    }
    ooz.w("comment", "复用 presenter 2222222222222222222222222222222222, holder hashCode:" + hashCode());
    if (paramBoolean) {
      WSPublicAccReport.getInstance().reportCommentEntryClick(localohl.getSopName(), WSPublicAccReport.getEntryPositionId(localohl.getSopName()) + rw(), 1000001, localstSimpleMetaFeed);
    }
    for (;;)
    {
      localohl.setPosition(getPosition());
      localohl.b(localstSimpleMetaFeed);
      localohl.bX("focus", "");
      localohl.beM();
      oiv.a().b(new WSCommentShowEvent(true));
      return;
      WSPublicAccReport.getInstance().reportCommentEntryTextClick(localohl.getSopName(), rw(), 1000001, localstSimpleMetaFeed);
    }
  }
  
  private void qL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      reportClick("video", onh.a.aqG);
      return;
    }
    reportClick("video");
  }
  
  private void qM(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      reportClick("pausebutton", onh.a.aqR);
      return;
    }
    reportClick("pausebutton", onh.a.aqQ);
  }
  
  private void reportClick(String paramString)
  {
    reportClick(paramString, onh.a.aqy);
  }
  
  private void reportClick(String paramString1, String paramString2)
  {
    int i = rw();
    if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
    for (stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;; localstSimpleMetaFeed = null)
    {
      onf.a(paramString1, i, paramString2, localstSimpleMetaFeed);
      return;
    }
  }
  
  private int rw()
  {
    return oie.a().D.get(getLayoutPosition()) + 1;
  }
  
  private boolean yq()
  {
    if ((this.jdField_a_of_type_UserGrowthStFeed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed == null) || (this.jdField_a_of_type_UserGrowthStFeed.feed.poster == null)) {
      return false;
    }
    return oor.eu(this.jdField_a_of_type_UserGrowthStFeed.feed.poster.followStatus);
  }
  
  public stFeed a()
  {
    return this.jdField_a_of_type_UserGrowthStFeed;
  }
  
  public void a(stFeed paramstFeed)
  {
    super.P(paramstFeed);
    if ((paramstFeed == null) || (paramstFeed.feed == null)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStFeed = paramstFeed;
    b(paramstFeed.feed.poster);
    pC(paramstFeed.feed.feed_desc);
    bfd();
    a(paramstFeed.feed.magicBrand);
    cb(paramstFeed.feed.simpleComments);
  }
  
  public void a(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setSelected(true);
      return;
    }
    paramTextView.setSelected(false);
  }
  
  public void aCG()
  {
    Object localObject = new ArrayList(ld);
    if (this.ut.getVisibility() == 0)
    {
      ((List)localObject).add("follow");
      ((List)localObject).add("close");
    }
    if (this.ux.getVisibility() == 0) {
      ((List)localObject).add("bottom_label");
    }
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = rw();
      if (this.jdField_a_of_type_UserGrowthStFeed != null) {}
      for (localObject = this.jdField_a_of_type_UserGrowthStFeed.feed;; localObject = null)
      {
        onf.a(str, i, (stSimpleMetaFeed)localObject);
        break;
      }
    }
  }
  
  public void bey()
  {
    super.bey();
    if (this.jdField_a_of_type_UserGrowthStFeed != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStFeed.feed;
      if (localstSimpleMetaFeed != null) {
        okd.a().pH(localstSimpleMetaFeed.id);
      }
    }
  }
  
  public void bfh()
  {
    this.uA.setVisibility(0);
    this.uH.setVisibility(8);
    this.uA.setSelected(GV());
  }
  
  public void bfi()
  {
    if (yq())
    {
      this.uu.setVisibility(8);
      this.uv.setVisibility(0);
    }
    for (;;)
    {
      this.ut.setVisibility(0);
      return;
      this.uu.setVisibility(0);
      this.uv.setVisibility(4);
    }
  }
  
  public void c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (this.jdField_a_of_type_UserGrowthStFeed.feed.id.equals(paramstSimpleMetaFeed.id)) {
      ooz.e("comment", "添加评论后匹配正确,添加前评论size:" + paramstSimpleMetaFeed.comments.size());
    }
    String str = oor.b(2131695131, new Object[] { Integer.valueOf(this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num) });
    ooz.e("comment", "updateCommentSize, comment size: " + this.jdField_a_of_type_UserGrowthStFeed.feed.total_comment_num);
    this.uF.setText(str);
    cb(paramstSimpleMetaFeed.simpleComments);
  }
  
  public void dB(int paramInt1, int paramInt2)
  {
    opn.m(this.Z, paramInt1, paramInt2);
  }
  
  public void onClick(View paramView)
  {
    ooz.d("WSFollowFeedHolder", "[onClick] view: " + paramView);
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
        oor.a(this.jdField_a_of_type_Oey.getActivity(), (stSchema)this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, (String)localObject1);
        reportClick("profile");
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
        oor.a(this.jdField_a_of_type_Oey.getActivity(), (stSchema)this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getTag(), 700, (String)localObject2);
        reportClick("nickname");
        continue;
        bff();
        continue;
        bfj();
        reportClick("close");
        continue;
        localObject1 = this.jdField_a_of_type_Oey.a();
        if (this.jdField_a_of_type_Oey.jdField_a_of_type_Ojm == this) {
          if (((WSPlayerManager)localObject1).isPlaying()) {
            ((WSPlayerManager)localObject1).pause();
          }
        }
        for (;;)
        {
          qM(isPlaying());
          break;
          ((WSPlayerManager)localObject1).restart();
          continue;
          this.jdField_a_of_type_Oey.a(this);
        }
        if ((paramView.getTag() instanceof stSchema))
        {
          oor.a(this.jdField_a_of_type_Oey.getActivity(), (stSchema)paramView.getTag(), 700, rw(), "bottom_label");
          pE("bottom_label");
          continue;
          bfe();
          continue;
          qJ(true);
          continue;
          bfg();
          continue;
          qJ(false);
          continue;
          if ((this.me != null) && (this.me.size() > 0))
          {
            a((stSimpleComment)this.me.get(0), this.uC);
            continue;
            if ((this.me != null) && (this.me.size() > 1)) {
              a((stSimpleComment)this.me.get(1), this.uD);
            }
          }
        }
      }
    }
  }
  
  public ViewGroup p()
  {
    return this.ci;
  }
  
  public void qK(boolean paramBoolean)
  {
    if (this.uw == null) {
      return;
    }
    this.uw.setSelected(paramBoolean);
  }
  
  public void uJ(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oiy
 * JD-Core Version:    0.7.0.1
 */