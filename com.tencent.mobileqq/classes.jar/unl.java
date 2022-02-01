import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class unl
  extends blsy<stSimpleMetaPerson>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaPerson jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ugp jdField_a_of_type_Ugp;
  private unn jdField_a_of_type_Unn;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public unl(ViewGroup paramViewGroup, unn paramunn)
  {
    super(paramViewGroup, 2131560392);
    this.jdField_a_of_type_Unn = paramunn;
    d();
    c();
  }
  
  public static unl a(ViewGroup paramViewGroup, unn paramunn)
  {
    return new unl(paramViewGroup, paramunn);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      uns.a("nickname", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, unz.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Unn != null) {
        this.jdField_a_of_type_Unn.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      }
      return;
      if (paramInt == 2) {
        uns.a("profile", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, unz.a);
      }
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    uns.a(this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson);
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
  
  private void c()
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368973));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368964));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368963));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368966));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368967));
    this.c = ((TextView)a(2131368965));
    this.d = ((TextView)a(2131368968));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368969));
    this.e = ((TextView)a(2131368972));
    this.f = ((TextView)a(2131368970));
    this.g = ((TextView)a(2131368971));
    this.h = ((TextView)a(2131368889));
    this.i = ((TextView)a(2131368888));
  }
  
  private void e()
  {
    if (!nny.a(a()))
    {
      bjuh.a().a(2131719373);
      return;
    }
    if (this.jdField_a_of_type_Ugp == null) {
      this.jdField_a_of_type_Ugp = ugp.a();
    }
    if (upw.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      upw.a(a(), new unm(this), null);
      return;
    }
    this.jdField_a_of_type_Ugp.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 1);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 1;
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    uns.a("follow", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, unz.q);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Unn != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson != null))
    {
      this.jdField_a_of_type_Unn.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      uns.a("close", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, unz.a);
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
    if (upw.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
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
    uqt.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    boolean bool = upw.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localTextView.setVisibility(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      upw.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      this.d.setText(upw.a(paramstSimpleMetaPerson.nick));
      a(this.e, this.f, paramstSimpleMetaPerson.nueric);
      this.g.setText(paramstSimpleMetaPerson.recommendReason);
      a();
      return;
    }
  }
  
  public void b()
  {
    uqf.b("WSRecommendFollowHolder", "[reportExposure]");
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null)
    {
      uqf.d("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
  }
  
  public void onClick(View paramView)
  {
    uqf.b("WSRecommendFollowHolder", "[onClick] view: " + paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f();
      continue;
      e();
      continue;
      a(1);
      continue;
      a(0);
      continue;
      a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unl
 * JD-Core Version:    0.7.0.1
 */