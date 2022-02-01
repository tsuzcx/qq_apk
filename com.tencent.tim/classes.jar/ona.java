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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ona
  extends auwn<stSimpleMetaPerson>
  implements View.OnClickListener
{
  private onc a;
  private stSimpleMetaPerson jdField_b_of_type_UserGrowthStSimpleMetaPerson;
  private oig jdField_b_of_type_Oig;
  private RoundImageView e;
  private LinearLayout eA;
  private RelativeLayout fH;
  private int mCurrentPosition;
  private TextView pY;
  private RelativeLayout rootLayout;
  private TextView uW;
  private TextView uX;
  private TextView uY;
  private TextView uZ;
  private TextView uu;
  private TextView uv;
  private TextView va;
  private TextView vb;
  
  public ona(ViewGroup paramViewGroup, onc paramonc)
  {
    super(paramViewGroup, 2131560582);
    this.a = paramonc;
    initView();
    kJ();
  }
  
  public static ona a(ViewGroup paramViewGroup, onc paramonc)
  {
    return new ona(paramViewGroup, paramonc);
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
  
  private void bfO()
  {
    if ((this.a != null) && (this.jdField_b_of_type_UserGrowthStSimpleMetaPerson != null))
    {
      this.a.c(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson);
      onf.b("close", this.mCurrentPosition + 1, this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id, onh.a.aqy);
    }
  }
  
  private void bff()
  {
    if (!jqi.isNetworkAvailable(getContext()))
    {
      arxa.a().showToast(2131721932);
      return;
    }
    if (this.jdField_b_of_type_Oig == null) {
      this.jdField_b_of_type_Oig = oig.a();
    }
    if (oor.eu(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      oor.a(getContext(), new onb(this), null);
      return;
    }
    this.jdField_b_of_type_Oig.aY(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id, 1);
    this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.followStatus = 1;
    this.uu.setVisibility(8);
    this.uv.setVisibility(0);
    onf.b("follow", this.mCurrentPosition + 1, this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id, onh.a.aqO);
  }
  
  private void e(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    onf.t("profile", this.mCurrentPosition + 1, paramstSimpleMetaPerson.id);
    onf.t("nickname", this.mCurrentPosition + 1, paramstSimpleMetaPerson.id);
    onf.t("close", this.mCurrentPosition + 1, paramstSimpleMetaPerson.id);
    onf.t("follow", this.mCurrentPosition + 1, this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id);
  }
  
  private void initView()
  {
    this.rootLayout = ((RelativeLayout)getView(2131369513));
    this.fH = ((RelativeLayout)getView(2131369504));
    this.e = ((RoundImageView)getView(2131369503));
    this.uW = ((TextView)getView(2131369506));
    this.uX = ((TextView)getView(2131369507));
    this.uY = ((TextView)getView(2131369505));
    this.pY = ((TextView)getView(2131369508));
    this.eA = ((LinearLayout)getView(2131369509));
    this.uZ = ((TextView)getView(2131369512));
    this.va = ((TextView)getView(2131369510));
    this.vb = ((TextView)getView(2131369511));
    this.uu = ((TextView)getView(2131369443));
    this.uv = ((TextView)getView(2131369442));
  }
  
  private void kJ()
  {
    this.uY.setOnClickListener(this);
    this.fH.setOnClickListener(this);
    this.uu.setOnClickListener(this);
    this.uv.setOnClickListener(this);
    this.fH.setOnClickListener(this);
    this.pY.setOnClickListener(this);
    this.eA.setOnClickListener(this);
    this.vb.setOnClickListener(this);
  }
  
  private void setItemMargin(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.rootLayout.getLayoutParams();
    if (localMarginLayoutParams != null)
    {
      if (paramInt == 0) {
        localMarginLayoutParams.leftMargin = opm.rK();
      }
    }
    else {
      return;
    }
    localMarginLayoutParams.leftMargin = opm.rL();
  }
  
  private void uM(int paramInt)
  {
    if (paramInt == 1) {
      onf.b("nickname", this.mCurrentPosition + 1, this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id, onh.a.aqy);
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.d(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson);
      }
      return;
      if (paramInt == 2) {
        onf.b("profile", this.mCurrentPosition + 1, this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.id, onh.a.aqy);
      }
    }
  }
  
  public void a(stSimpleMetaPerson paramstSimpleMetaPerson, int paramInt)
  {
    super.P(paramstSimpleMetaPerson);
    this.jdField_b_of_type_UserGrowthStSimpleMetaPerson = paramstSimpleMetaPerson;
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    this.mCurrentPosition = paramInt;
    setItemMargin(paramInt);
    opn.a(getContext(), this.e, paramstSimpleMetaPerson.avatar);
    boolean bool = oor.ev(paramstSimpleMetaPerson.relation_type);
    TextView localTextView = this.uW;
    if (bool) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localTextView.setVisibility(paramInt);
      this.uX.setVisibility(8);
      oor.a(this.uX, paramstSimpleMetaPerson.medal, bool);
      this.pY.setText(oor.fy(paramstSimpleMetaPerson.nick));
      a(this.uZ, this.va, paramstSimpleMetaPerson.nueric);
      this.vb.setText(paramstSimpleMetaPerson.recommendReason);
      bfi();
      return;
    }
  }
  
  public void aCG()
  {
    ooz.d("WSRecommendFollowHolder", "[reportExposure]");
    if (this.jdField_b_of_type_UserGrowthStSimpleMetaPerson == null)
    {
      ooz.e("WSRecommendFollowHolder", "[reportExposure] mCurrentPerson is null");
      return;
    }
    e(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson);
  }
  
  public stSimpleMetaPerson b()
  {
    return this.jdField_b_of_type_UserGrowthStSimpleMetaPerson;
  }
  
  public void bfi()
  {
    if (this.jdField_b_of_type_UserGrowthStSimpleMetaPerson == null) {
      return;
    }
    if (oor.eu(this.jdField_b_of_type_UserGrowthStSimpleMetaPerson.followStatus))
    {
      this.uu.setVisibility(8);
      this.uv.setVisibility(0);
      return;
    }
    this.uu.setVisibility(0);
    this.uv.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    ooz.d("WSRecommendFollowHolder", "[onClick] view: " + paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bfO();
      continue;
      bff();
      continue;
      uM(1);
      continue;
      uM(0);
      continue;
      uM(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ona
 * JD-Core Version:    0.7.0.1
 */