import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvf
  extends bjwy<stSimpleMetaPerson>
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private stSimpleMetaPerson jdField_a_of_type_UserGrowthStSimpleMetaPerson;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private ung jdField_a_of_type_Ung;
  private uvh jdField_a_of_type_Uvh;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public uvf(ViewGroup paramViewGroup, uvh paramuvh)
  {
    super(paramViewGroup, 2131560400);
    this.jdField_a_of_type_Uvh = paramuvh;
    d();
    c();
  }
  
  public static uvf a(ViewGroup paramViewGroup, uvh paramuvh)
  {
    return new uvf(paramViewGroup, paramuvh);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      uvm.a("nickname", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, uvt.a);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Uvh != null) {
        this.jdField_a_of_type_Uvh.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      }
      return;
      if (paramInt == 2) {
        uvm.a("profile", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, uvt.a);
      }
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    uvm.a(this.jdField_a_of_type_Int + 1, paramstSimpleMetaPerson);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368999));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368990));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368989));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368992));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131368993));
    this.c = ((TextView)a(2131368991));
    this.d = ((TextView)a(2131368994));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131368995));
    this.e = ((TextView)a(2131368998));
    this.f = ((TextView)a(2131368996));
    this.g = ((TextView)a(2131368997));
    this.h = ((TextView)a(2131368914));
    this.i = ((TextView)a(2131368913));
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetworkAvailable(a()))
    {
      bhzt.a().a(2131719692);
      return;
    }
    if (this.jdField_a_of_type_Ung == null) {
      this.jdField_a_of_type_Ung = ung.a();
    }
    if (uxr.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      uxr.a(a(), new uvg(this), null);
      return;
    }
    this.jdField_a_of_type_Ung.b(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, 1);
    this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus = 1;
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    uvm.a("follow", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, uvt.q);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Uvh != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson != null))
    {
      this.jdField_a_of_type_Uvh.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
      uvm.a("close", this.jdField_a_of_type_Int + 1, this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.id, uvt.a);
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
    if (uxr.a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson.followStatus))
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
    uyo.a(a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, paramstSimpleMetaPerson.avatar);
    boolean bool = uxr.b(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localTextView.setVisibility(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      uxr.a(this.jdField_b_of_type_AndroidWidgetTextView, paramstSimpleMetaPerson.medal, bool);
      this.d.setText(uxr.a(paramstSimpleMetaPerson.nick));
      a(this.e, this.f, paramstSimpleMetaPerson.nueric);
      this.g.setText(paramstSimpleMetaPerson.recommendReason);
      a();
      return;
    }
  }
  
  public void b()
  {
    uya.b("WSRecommendFollowHolder", "[reportExposure]");
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaPerson == null)
    {
      uya.d("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    a(this.jdField_a_of_type_UserGrowthStSimpleMetaPerson);
  }
  
  public void onClick(View paramView)
  {
    uya.b("WSRecommendFollowHolder", "[onClick] view: " + paramView);
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
 * Qualified Name:     uvf
 * JD-Core Version:    0.7.0.1
 */