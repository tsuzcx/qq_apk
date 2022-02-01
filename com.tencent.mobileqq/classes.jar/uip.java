import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;

public class uip
  extends blsy<stSimpleMetaFeed>
  implements View.OnClickListener, uio
{
  private static final int jdField_a_of_type_Int = upw.a(5.0F);
  private static long jdField_a_of_type_Long;
  private static final int jdField_b_of_type_Int = upw.a(10.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private udq jdField_a_of_type_Udq;
  private uir jdField_a_of_type_Uir;
  private uis jdField_a_of_type_Uis;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  
  private uip(ViewGroup paramViewGroup, udq paramudq, int paramInt)
  {
    super(paramViewGroup, 2131560396);
    this.jdField_a_of_type_Uir = uiq.a(paramInt);
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_Udq = paramudq;
    this.jdField_a_of_type_Uis = new uis(this);
    a();
    this.itemView.setOnClickListener(this);
  }
  
  public static uip a(ViewGroup paramViewGroup, udq paramudq, int paramInt)
  {
    return new uip(paramViewGroup, paramudq, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368955));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368956));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)a(2131368953));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131368957));
    this.c = ((TextView)a(2131368962));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368951));
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368951));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368958));
    this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368954));
    this.e = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368954));
    this.f = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368959));
    this.g = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368959));
    this.h = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368961));
    this.i = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368961));
    this.j = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368960));
    this.k = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368960));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      upw.a(m, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.f, this.h, this.j });
      return;
    }
  }
  
  private void b()
  {
    int n = 0;
    int m;
    if (upw.a())
    {
      if (uiq.a(upw.jdField_a_of_type_Int))
      {
        m = upw.jdField_a_of_type_Int;
        this.jdField_a_of_type_Uir = uiq.a(m);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Uir.d) {
        break label119;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(true);
      label61:
      if (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc)) {
        break label201;
      }
      if (!this.jdField_a_of_type_Uir.jdField_a_of_type_Boolean) {
        break label190;
      }
      m = 8;
      label87:
      if (!this.jdField_a_of_type_Uir.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    for (;;)
    {
      this.d.setVisibility(m);
      this.e.setVisibility(n);
      return;
      m = 1;
      break;
      label119:
      if (this.jdField_a_of_type_Uir.e)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        a(false);
        break label61;
      }
      upw.a(0, new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout });
      a(this.jdField_a_of_type_Uir.b);
      break label61;
      label190:
      m = 0;
      break label87;
      label195:
      n = 8;
    }
    label201:
    upw.a(8, new View[] { this.d, this.e });
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int, 1);
  }
  
  private void d()
  {
    stH5OpInfo localstH5OpInfo = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info;
    StringBuilder localStringBuilder = new StringBuilder().append("title = ").append(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc).append(", feedId = ").append(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id).append(", posterId = ").append(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster_id).append(", video_type = ").append(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_type).append(", h5OpInfo.type = ");
    if (localstH5OpInfo != null)
    {
      localObject = Integer.valueOf(localstH5OpInfo.type);
      localStringBuilder = localStringBuilder.append(localObject).append(", h5OpInfo.maskImgUrl = ");
      if (localstH5OpInfo == null) {
        break label241;
      }
    }
    label241:
    for (Object localObject = localstH5OpInfo.maskImgUrl;; localObject = "null")
    {
      uqf.a("WSGridCardHolder", (String)localObject + ", cardType = " + this.jdField_a_of_type_Uir.toString());
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.video_type != 1) {
        break label258;
      }
      if ((localstH5OpInfo != null) && (localstH5OpInfo.type == 2)) {
        upw.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout });
      }
      if ((ugd.a().a(1) != 2) || (localstH5OpInfo == null) || (TextUtils.isEmpty(localstH5OpInfo.maskImgUrl))) {
        break label248;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localstH5OpInfo.maskImgUrl);
      return;
      localObject = "null";
      break;
    }
    label248:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    return;
    label258:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Uir.jdField_a_of_type_Int == 10) {
      upw.a(8, new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout });
    }
  }
  
  private void f()
  {
    float f2 = 1.333333F;
    Object localObject = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.waterFallCardStyle;
    boolean bool;
    float f1;
    label58:
    label66:
    label75:
    int m;
    if ((localObject != null) && (((stWaterFallCardStyle)localObject).isFullSpan))
    {
      bool = true;
      if ((localObject == null) || (((stWaterFallCardStyle)localObject).ratioW == 0)) {
        break label157;
      }
      f1 = ((stWaterFallCardStyle)localObject).ratioH * 1.0F / ((stWaterFallCardStyle)localObject).ratioW;
      if (f1 <= 2.0F) {
        break label164;
      }
      f1 = f2;
      if (!bool) {
        break label167;
      }
      f1 = 0.5625F;
      ((StaggeredGridLayoutManager.LayoutParams)this.itemView.getLayoutParams()).setFullSpan(bool);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.getLayoutParams();
      m = uqs.c();
      if (!bool) {
        break label170;
      }
      m -= udg.jdField_a_of_type_Int * 2;
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(f1 * m));
      uqt.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, upw.a(2131165728), "feeds", true);
      return;
      bool = false;
      break;
      label157:
      f1 = 1.333333F;
      break label58;
      label164:
      break label66;
      label167:
      break label75;
      label170:
      m = (m - udg.jdField_a_of_type_Int * 3) / 2;
    }
  }
  
  private void h()
  {
    stVideoTag localstVideoTag = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.videoTag;
    if ((localstVideoTag == null) || (TextUtils.isEmpty(localstVideoTag.text)))
    {
      this.c.setVisibility(8);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
    {
      localObject1 = localstVideoTag.textColor;
      if ((TextUtils.isEmpty(localstVideoTag.bgColor)) || (!localstVideoTag.bgColor.startsWith("#"))) {
        break label264;
      }
      localObject2 = localstVideoTag.bgColor;
      label88:
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(uqs.c);
      localGradientDrawable.setStroke(uqs.jdField_a_of_type_Int, Color.parseColor("#4CFFFFFF"));
      if (!uqs.a((String)localObject2)) {
        break label291;
      }
      label127:
      localGradientDrawable.setColor(Color.parseColor((String)localObject2));
      this.c.setText(localstVideoTag.text);
      localObject2 = this.c;
      if (!uqs.a((String)localObject1)) {
        break label298;
      }
      label159:
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      this.c.setBackgroundDrawable(localGradientDrawable);
      this.c.setVisibility(0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        break label305;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131368953);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(jdField_b_of_type_Int, 0, jdField_b_of_type_Int, jdField_b_of_type_Int);
    }
    for (;;)
    {
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
      localObject1 = "#" + localstVideoTag.textColor;
      break;
      label264:
      localObject2 = "#" + localstVideoTag.bgColor;
      break label88;
      label291:
      localObject2 = "#80000000";
      break label127;
      label298:
      localObject1 = "#FFFFFF";
      break label159;
      label305:
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131368955);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(jdField_b_of_type_Int, 0, jdField_b_of_type_Int, 0);
    }
  }
  
  private void i()
  {
    String str = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_desc;
    if (this.d.getVisibility() == 0) {
      this.d.setText(str);
    }
    while (this.e.getVisibility() != 0) {
      return;
    }
    this.e.setText(str);
  }
  
  private void j()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster;
    if ((localstSimpleMetaPerson == null) || (this.jdField_a_of_type_Uir.c))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    boolean bool;
    label123:
    TextView localTextView;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.getVisibility() == 0)
    {
      bool = true;
      uqf.b("WSGridCardHolder", "inner: " + bool + ", nick: " + localstSimpleMetaPerson.nick + ", medal: " + localstSimpleMetaPerson.medal + ", avatar: " + localstSimpleMetaPerson.avatar);
      if (!bool) {
        break label182;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
      if (!bool) {
        break label190;
      }
      localTextView = this.f;
      label132:
      uqt.a(this.jdField_a_of_type_AndroidContentContext, (RoundImageView)localObject, localstSimpleMetaPerson.avatar);
      localTextView.setText(upw.a(localstSimpleMetaPerson.nick));
      if (!bool) {
        break label198;
      }
    }
    label182:
    label190:
    label198:
    for (Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;; localObject = this.jdField_b_of_type_AndroidWidgetTextView)
    {
      upw.a((TextView)localObject, localstSimpleMetaPerson.medal, false);
      return;
      bool = false;
      break;
      localObject = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
      break label123;
      localTextView = this.g;
      break label132;
    }
  }
  
  private void k()
  {
    int m = 2130843133;
    int i1;
    label63:
    label67:
    label75:
    TextView localTextView1;
    label85:
    TextView localTextView2;
    if (this.h.getVisibility() == 0)
    {
      i1 = 1;
      if (this.jdField_a_of_type_Uir.c)
      {
        if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.playNum > 0) || (i1 == 0)) {
          break label156;
        }
        upw.a(8, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.f });
      }
      if (i1 == 0) {
        break label211;
      }
      if (i1 == 0) {
        break label218;
      }
      n = 2130846680;
      if (i1 == 0) {
        break label225;
      }
      localTextView1 = this.h;
      if (i1 == 0) {
        break label234;
      }
      localTextView2 = this.j;
      label95:
      if (!this.jdField_a_of_type_Uir.f) {
        break label243;
      }
      label105:
      if (!this.jdField_a_of_type_Uir.f) {
        break label248;
      }
    }
    label156:
    label211:
    label218:
    label225:
    label234:
    label243:
    label248:
    for (int n = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.playNum;; n = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.ding_count)
    {
      if ((n > 0) || (i1 == 0)) {
        break label259;
      }
      upw.a(8, new View[] { localTextView1, localTextView2 });
      return;
      i1 = 0;
      break;
      upw.a(0, new View[] { this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.f });
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(upw.a(2130843133));
      rpt.a(this.f, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.playNum, "0");
      break label63;
      m = 2130850851;
      break label67;
      n = 2130850850;
      break label75;
      localTextView1 = this.i;
      break label85;
      localTextView2 = this.k;
      break label95;
      m = n;
      break label105;
    }
    label259:
    upw.a(0, new View[] { localTextView1, localTextView2 });
    localTextView1.setBackgroundResource(m);
    rpt.a(localTextView2, n, "0");
  }
  
  public udq a()
  {
    return this.jdField_a_of_type_Udq;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    super.a(paramstSimpleMetaFeed);
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    b();
    f();
    i();
    h();
    j();
    k();
    d();
    e();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L) {
      uqf.a("WSGridCardHolder", "fast click, ignored: recommend item view");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_a_of_type_Long = System.currentTimeMillis();
      int m = getAdapterPosition() - ((bltq)this.jdField_a_of_type_Udq.a.getAdapter()).a();
      uqf.b("WSGridCardHolder", "onClick: " + m);
      ArrayList localArrayList = new ArrayList();
      if ((m >= this.jdField_a_of_type_Udq.b()) || (m < 0))
      {
        uqf.d("WSGridCardHolder", "position out of bound");
      }
      else
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.jdField_a_of_type_Udq.a(m);
        if (localstSimpleMetaFeed == null)
        {
          uqf.d("WSGridCardHolder", "feed is null");
        }
        else
        {
          unx.a(112, unx.a(m, localstSimpleMetaFeed));
          uqg.b();
          if (localstSimpleMetaFeed.video_type == 1)
          {
            this.jdField_a_of_type_Uis.a(this.jdField_a_of_type_AndroidContentContext, localstSimpleMetaFeed, m);
            uqf.b("WSGridCardHolder", "点击了运营图片");
          }
          else if (localstSimpleMetaFeed.video_type == 6)
          {
            this.jdField_a_of_type_Uis.a(this.jdField_a_of_type_AndroidContentContext, m, localstSimpleMetaFeed);
          }
          else
          {
            uno.a(localstSimpleMetaFeed, m, 112);
            if (!this.jdField_a_of_type_Uis.a(this.jdField_a_of_type_AndroidContentContext, m, localArrayList, localstSimpleMetaFeed))
            {
              this.jdField_a_of_type_Uis.a(this.jdField_a_of_type_AndroidContentContext, m, localArrayList, localstSimpleMetaFeed);
              WSPublicAccReport.getInstance().feedsItemReport("gzh_click", uqt.a(1), localstSimpleMetaFeed, uno.a(localstSimpleMetaFeed, m), 1000001);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */