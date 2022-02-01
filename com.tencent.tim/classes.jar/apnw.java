import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class apnw
{
  private View IH;
  private final apol jdField_a_of_type_Apol;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private String aKI;
  private final String aPX;
  private String aQL;
  private acnd jdField_b_of_type_Acnd;
  private TroopInfo jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
  private final boolean bap;
  private boolean bbp;
  private boolean cRF;
  private String cqh;
  private Drawable dD;
  private QQAppInterface mApp;
  private final float mDensity;
  private final String mTroopUin;
  
  public apnw(TroopChatPie paramTroopChatPie, TroopInfo paramTroopInfo, QQAppInterface paramQQAppInterface, apol paramapol)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.mApp = paramQQAppInterface;
    this.aPX = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
    if ((paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) || ((this.aPX != null) && (this.aPX.contains(paramQQAppInterface.getCurrentAccountUin())))) {}
    for (boolean bool = true;; bool = false)
    {
      this.bap = bool;
      this.dD = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().getResources().getDrawable(2130839657);
      this.aKI = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      this.mTroopUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.sessionInfo.aTl;
      this.mDensity = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_Apol = paramapol;
      bpM();
      return;
    }
  }
  
  private void bpM()
  {
    this.jdField_b_of_type_Acnd = new apnz(this);
    this.mApp.addObserver(this.jdField_b_of_type_Acnd);
  }
  
  private Activity getActivity()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
  }
  
  private Resources getResources()
  {
    return getActivity().getResources();
  }
  
  private String getString(int paramInt)
  {
    return BaseApplication.getContext().getString(paramInt);
  }
  
  public void Tq(String paramString)
  {
    a(true, paramString, this.bbp, 0, 0, this.cqh, this.aQL, this.cRF);
  }
  
  public void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AllMemberItem", 2, new Object[] { "updateUIForAtAllRemainedCount: invoked. ", " isSuccess: ", Boolean.valueOf(paramBoolean1), " bCanAtAll: ", Boolean.valueOf(paramBoolean2), " troopCode: ", paramString1, " remainCount: ", Integer.valueOf(paramInt1), " discRemainCount: ", Integer.valueOf(paramInt2), " remainTips: ", paramString2, " noRemainTips: ", paramString3, " allowMemberAtAll:", Boolean.valueOf(paramBoolean3) });
    }
    this.bbp = paramBoolean2;
    this.aQL = paramString3;
    this.cqh = paramString2;
    this.cRF = paramBoolean3;
    if ((!this.bap) && (paramBoolean3) && (this.IH != null))
    {
      ((TextView)this.IH.findViewById(2131380814)).setText(getString(2131721411));
      paramString3 = (TextView)this.IH.findViewById(2131377102);
      paramString3.setTextSize(12.0F);
      paramString3.setText("");
      ((ImageView)this.IH.findViewById(2131369767)).setBackgroundDrawable(aqhu.aW());
      this.IH.setVisibility(0);
      this.IH.setEnabled(false);
    }
    if ((this.bap) && (this.IH != null))
    {
      paramString3 = (ImageView)this.IH.findViewById(2131373912);
      paramString3.setVisibility(0);
      paramString3.setOnClickListener(new apnx(this));
    }
    if ((this.IH != null) && (this.dD != null))
    {
      ((Animatable)this.dD).stop();
      this.dD = null;
      ((TextView)this.IH.findViewById(2131377102)).setCompoundDrawables(null, null, null, null);
    }
    if ((this.IH != null) && (this.IH.getVisibility() != 8))
    {
      this.IH.setEnabled(true);
      if ((paramBoolean1) && (paramString1 != null)) {
        break label383;
      }
    }
    label383:
    String str;
    Button localButton;
    do
    {
      return;
      ((TextView)this.IH.findViewById(2131380814)).setTextColor(getResources().getColor(2131167304));
      paramString3 = (TextView)this.IH.findViewById(2131377102);
      str = acfp.m(2131702367);
      localButton = (Button)this.IH.findViewById(2131372652);
      localButton.setVisibility(8);
      localButton.setOnClickListener(new apny(this));
      paramInt1 = ((acle)this.mApp.getBusinessHandler(13)).AX();
    } while (!paramString1.equals(this.mTroopUin));
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("AllMemberItem", 1, "updateUIForAtAllRemainedCount remainTips empty");
      return;
    }
    if ((!this.bbp) && (paramInt1 != 3)) {
      localButton.setVisibility(0);
    }
    paramString1 = new SpannableString(this.cqh);
    paramString2 = Pattern.compile("[^0-9]").matcher(this.cqh).replaceAll("").trim();
    if (!TextUtils.isEmpty(paramString2))
    {
      paramInt1 = this.cqh.indexOf(paramString2);
      paramInt2 = paramString2.length();
      paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
    }
    if (this.cqh.contains(acfp.m(2131702369)))
    {
      paramInt1 = this.cqh.indexOf(acfp.m(2131702372));
      paramInt2 = acfp.m(2131702368).length();
      paramString1.setSpan(new ForegroundColorSpan(-48606), paramInt1, paramInt2 + paramInt1, 33);
    }
    paramString3.setText(paramString1);
    paramString1 = str + "," + this.cqh;
    this.IH.setContentDescription(paramString1);
  }
  
  boolean aBn()
  {
    return this.bbp;
  }
  
  public void destroy()
  {
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
  }
  
  public void eaO()
  {
    acms localacms = (acms)this.mApp.getBusinessHandler(20);
    if (localacms != null)
    {
      localacms.eF(this.mApp.getCurrentAccountUin(), this.mTroopUin);
      if (QLog.isColorLevel()) {
        QLog.d("AllMemberItem", 2, "fetchRemainCountInfo: invoked. ");
      }
    }
  }
  
  void eaP()
  {
    if (this.bbp) {
      return;
    }
    if (!TextUtils.isEmpty(this.aQL))
    {
      QQToast.a(getActivity(), this.aQL, 0).show();
      return;
    }
    QQToast.a(getActivity(), acfp.m(2131702371), 0).show();
  }
  
  public void ih(View paramView)
  {
    this.IH = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnw
 * JD-Core Version:    0.7.0.1
 */