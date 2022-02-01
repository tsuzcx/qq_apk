import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView;
import java.util.List;

public class aqwf
{
  private String SB;
  private aqwf.a jdField_a_of_type_Aqwf$a;
  private aqwj jdField_a_of_type_Aqwj;
  private aqwp.a jdField_a_of_type_Aqwp$a;
  private aqwq.a jdField_a_of_type_Aqwq$a;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private aqwc jdField_b_of_type_Aqwc;
  private aqwq.a jdField_b_of_type_Aqwq$a;
  private Context context;
  private int page;
  
  public aqwf(Context paramContext, aqwc paramaqwc)
  {
    this.context = paramContext;
    this.jdField_b_of_type_Aqwc = paramaqwc;
  }
  
  private boolean aFL()
  {
    if ((this.context instanceof RegisterByNicknameAndPwdActivity)) {
      return ((RegisterByNicknameAndPwdActivity)this.context).QC();
    }
    if ((this.context instanceof RegisterPersonalInfoActivity)) {
      return ((RegisterPersonalInfoActivity)this.context).QD();
    }
    return false;
  }
  
  private void efX()
  {
    if ((this.jdField_a_of_type_Aqwj == null) || (this.jdField_a_of_type_Aqwj.iD == null)) {
      return;
    }
    a().c(this.jdField_a_of_type_Aqwj);
    int i = this.jdField_a_of_type_Aqwj.iD.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Aqwj.iD = this.jdField_a_of_type_Aqwj.iD.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Aqwj.iD.clear();
  }
  
  public RegisterLiangHaoChoiceLayoutView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView = new RegisterLiangHaoChoiceLayoutView(this.context);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  }
  
  public RegisterLiangHaoPayFailLayoutView a(aqwi paramaqwi)
  {
    if (paramaqwi == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.context);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(paramaqwi.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a(aqwl paramaqwl)
  {
    if ((this.jdField_b_of_type_Aqwc == null) || (!aFL())) {
      return;
    }
    this.jdField_b_of_type_Aqwc.efU();
    LiangHaoBuyFragment.a(this.context, this.jdField_b_of_type_Aqwc.D(), paramaqwl);
  }
  
  public void a(String paramString, aqwf.a parama)
  {
    this.SB = paramString;
    this.jdField_a_of_type_Aqwf$a = parama;
    if (this.jdField_a_of_type_Aqwq$a == null) {
      this.jdField_a_of_type_Aqwq$a = new aqwg(this);
    }
    int i = this.page;
    this.page = (i + 1);
    new aqwq(paramString, i, this.jdField_a_of_type_Aqwq$a).dpp();
  }
  
  public void a(String paramString, aqwp.a parama)
  {
    this.jdField_a_of_type_Aqwp$a = parama;
    new aqwp(paramString, parama).dpp();
  }
  
  public void b(aqwl paramaqwl)
  {
    if (this.jdField_b_of_type_Aqwc == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.context, this.jdField_b_of_type_Aqwc.D(), paramaqwl);
  }
  
  public void efW()
  {
    if ((this.jdField_a_of_type_Aqwj != null) && (this.jdField_a_of_type_Aqwj.iD != null) && (this.jdField_a_of_type_Aqwj.iD.size() >= 4))
    {
      efX();
      return;
    }
    if (this.jdField_b_of_type_Aqwq$a == null) {
      this.jdField_b_of_type_Aqwq$a = new aqwh(this);
    }
    String str = this.SB;
    int i = this.page;
    this.page = (i + 1);
    new aqwq(str, i, this.jdField_b_of_type_Aqwq$a).dpp();
  }
  
  public void efY()
  {
    if ((this.jdField_b_of_type_Aqwc == null) || (!aFL())) {
      return;
    }
    if ((this.jdField_a_of_type_Aqwj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqwj.moreUrl)))
    {
      str = this.jdField_a_of_type_Aqwj.moreUrl;
      if (str.indexOf("?") >= 0) {
        break label146;
      }
    }
    label146:
    for (String str = str + "?phone=" + this.SB;; str = str + "&phone=" + this.SB)
    {
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtras(this.jdField_b_of_type_Aqwc.D());
      localIntent.putExtra("lh_reg_from", 1);
      this.context.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void SY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwf
 * JD-Core Version:    0.7.0.1
 */