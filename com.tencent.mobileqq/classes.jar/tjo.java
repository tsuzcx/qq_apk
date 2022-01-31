import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;

public class tjo
  extends biac<stSimpleMetaPerson>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaPerson jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private tep jdField_a_of_type_Tep;
  private tjq jdField_a_of_type_Tjq;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public tjo(ViewGroup paramViewGroup, tjq paramtjq)
  {
    super(paramViewGroup, 2131560224);
    this.jdField_a_of_type_Tjq = paramtjq;
    e();
    d();
  }
  
  public static tjo a(ViewGroup paramViewGroup, tjq paramtjq)
  {
    return new tjo(paramViewGroup, paramtjq);
  }
  
  private void a(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (localMarginLayoutParams != null)
    {
      if (paramInt == 0) {
        localMarginLayoutParams.leftMargin = tlu.c();
      }
    }
    else {
      return;
    }
    localMarginLayoutParams.leftMargin = tlu.d();
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    tjt.a("profile", this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson.id);
    tjt.a("nickname", this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson.id);
    tjt.a("close", this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson.id);
    tjt.a("follow", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id);
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, stMetaNumericSys paramstMetaNumericSys)
  {
    if (paramstMetaNumericSys == null)
    {
      paramTextView1.setText("");
      paramTextView2.setText("");
      return;
    }
    if (paramstMetaNumericSys.feed_num > 0)
    {
      paramTextView1.setText("作品");
      paramTextView2.setText(String.valueOf(paramstMetaNumericSys.feed_num));
      return;
    }
    if (paramstMetaNumericSys.fans_num > 0)
    {
      paramTextView1.setText("粉丝数");
      paramTextView2.setText(String.valueOf(paramstMetaNumericSys.fans_num));
      return;
    }
    paramTextView1.setText("");
    paramTextView2.setText("");
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      tjt.a("nickname", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, tjw.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Tjq != null) {
        this.jdField_a_of_type_Tjq.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      }
      return;
      if (paramInt == 2) {
        tjt.a("profile", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, tjw.a);
      }
    }
  }
  
  private void d()
  {
    this.c.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)b(2131368547));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)b(2131368538));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)b(2131368537));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)b(2131368540));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)b(2131368541));
    this.c = ((TextView)b(2131368539));
    this.d = ((TextView)b(2131368542));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)b(2131368543));
    this.e = ((TextView)b(2131368546));
    this.f = ((TextView)b(2131368544));
    this.g = ((TextView)b(2131368545));
    this.h = ((TextView)b(2131368491));
    this.i = ((TextView)b(2131368490));
  }
  
  private void f()
  {
    if (!ndk.a(a()))
    {
      bfhq.a().a(2131721476);
      return;
    }
    if (this.jdField_a_of_type_Tep == null) {
      this.jdField_a_of_type_Tep = tep.a();
    }
    if (tlf.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      tlf.a(a(), new tjp(this), null);
      return;
    }
    this.jdField_a_of_type_Tep.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 1);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 1;
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    tjt.a("follow", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, tjw.q);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Tjq != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson != null))
    {
      this.jdField_a_of_type_Tjq.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      tjt.a("close", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, tjw.a);
    }
  }
  
  public stSimpleMetaPerson a()
  {
    return this.jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null) {
      return;
    }
    if (tlf.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      return;
    }
    this.h.setVisibility(0);
    this.i.setVisibility(8);
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson, int paramInt)
  {
    super.a(paramstSimpleMetaPerson);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson = paramstSimpleMetaPerson;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt);
    tlv.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    boolean bool = tlf.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localTextView.setVisibility(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      tlf.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      this.d.setText(tlf.a(paramstSimpleMetaPerson.nick));
      a(this.e, this.f, paramstSimpleMetaPerson.nueric);
      this.g.setText(paramstSimpleMetaPerson.recommendReason);
      a();
      return;
    }
  }
  
  public void b()
  {
    tlo.b("WSRecommendFollowHolder", "[reportExposure]");
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null)
    {
      tlo.d("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
  }
  
  public void onClick(View paramView)
  {
    tlo.b("WSRecommendFollowHolder", "[onClick] view: " + paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368539: 
      g();
      return;
    case 2131368490: 
    case 2131368491: 
      f();
      return;
    case 2131368542: 
      b(1);
      return;
    case 2131368543: 
    case 2131368545: 
      b(0);
      return;
    }
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tjo
 * JD-Core Version:    0.7.0.1
 */