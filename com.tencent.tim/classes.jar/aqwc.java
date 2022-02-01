import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.2;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.Locale;
import mqq.os.MqqHandler;

public class aqwc
{
  public static String TAG = "RegisterLHAssistant";
  public static int edm;
  private MqqHandler O = new aqwd(this);
  private aqwc.a jdField_a_of_type_Aqwc$a;
  private aqwf jdField_a_of_type_Aqwf;
  private final RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  private final View aQ;
  private Intent an;
  public altw b;
  private boolean cWG;
  public boolean cWH;
  private FrameLayout cd;
  private int cnN;
  private String countryCode;
  public String cym;
  private String cyn;
  private ScrollView g;
  private Button hx;
  private String phoneNum;
  private String strNick;
  
  public aqwc(RegisterNewBaseActivity paramRegisterNewBaseActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_Aqwf = new aqwf(paramRegisterNewBaseActivity, this);
    this.aQ = paramView;
    this.g = ((ScrollView)this.aQ.findViewById(2131377565));
    this.cd = ((FrameLayout)this.aQ.findViewById(2131382029));
    edm = paramInt;
    dzC();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Intent paramIntent)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramIntent == null)) {
      return;
    }
    boolean bool;
    if (edm == 1)
    {
      if (paramBoolean) {}
      for (str = "1";; str = "2")
      {
        anot.a(null, "new_reg", "setting_page_yes", "result", "", 1, "", "", str, "", "", "", "", "", "");
        if (QLog.isColorLevel()) {
          h("gotoNextAfterPaidLH-register", paramIntent);
        }
        bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
        paramIntent = new Intent(paramIntent);
        if (!paramBoolean) {
          break label211;
        }
        paramIntent.setComponent(new ComponentName(paramContext, RegisterQQNumberActivity.class));
        paramIntent.putExtra("uin", paramString1);
        paramIntent.putExtra("key_register_is_lh", true);
        paramContext.startActivity(paramIntent);
        if (!QLog.isColorLevel()) {
          break;
        }
        h("gotoNextAfterPaidLH-intent", paramIntent);
        return;
      }
    }
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      anot.a(null, "new_reg", "setting_page_no", "result", "", 1, "", "", str, "", "", "", "", "", "");
      break;
    }
    label211:
    if (bool) {
      paramIntent.setComponent(new ComponentName(paramContext, RegisterPersonalInfoActivity.class));
    }
    for (;;)
    {
      paramIntent.putExtra("key_register_from_fail_pay_lh", true);
      paramIntent.putExtra("key_register_fail_paid_lh", paramString1);
      paramIntent.putExtra("lh_uin", paramString1);
      paramIntent.putExtra("lh_light", paramString2);
      break;
      paramIntent.setComponent(new ComponentName(paramContext, RegisterByNicknameAndPwdActivity.class));
    }
  }
  
  private void dzC()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent();
    this.an = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
    this.phoneNum = localIntent.getStringExtra("phonenum");
    this.countryCode = localIntent.getStringExtra("key");
    this.cWH = localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false);
    this.cym = localIntent.getStringExtra("key_register_fail_paid_lh");
    this.strNick = localIntent.getStringExtra("key_register_nick");
    this.cyn = localIntent.getStringExtra("key_register_password");
    if (QLog.isColorLevel()) {
      h("RegisterLHAssistant init-from", localIntent);
    }
    ClearableEditText localClearableEditText1;
    if (edm == 1)
    {
      this.an.putExtra("key_register_unbind", true);
      this.an.putExtra("key_register_chose_bind_phone", false);
      this.hx = ((Button)this.aQ.findViewById(2131363965));
      this.hx.setText(2131717091);
      if (!this.cWH) {
        break label404;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.xX(false);
      if (edm != 1) {
        break label368;
      }
      ((ImageView)this.aQ.findViewById(2131372890)).setVisibility(0);
      localClearableEditText1 = (ClearableEditText)this.aQ.findViewById(2131372388);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.aQ.findViewById(2131372889);
      localClearableEditText1.setText(this.strNick);
      localClearableEditText1.setEnabled(false);
      localClearableEditText2.setText(this.cyn);
      localClearableEditText2.setEnabled(false);
      label243:
      this.cd.setMinimumHeight(0);
      this.cd.removeAllViews();
      this.cd.scrollTo(0, 0);
      this.cd.setVisibility(0);
      this.cd.addView(this.jdField_a_of_type_Aqwf.a(new aqwi(localIntent)));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.app.setHandler(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass(), this.O);
      return;
      if (edm != 2) {
        break;
      }
      this.an.putExtra("key_register_unbind", false);
      this.an.putExtra("key_register_chose_bind_phone", true);
      this.hx = ((Button)this.aQ.findViewById(2131363867));
      break;
      label368:
      if (edm != 2) {
        break label243;
      }
      localClearableEditText1 = (ClearableEditText)this.aQ.findViewById(2131372388);
      localClearableEditText1.setText(this.strNick);
      localClearableEditText1.setEnabled(false);
      break label243;
      label404:
      this.cd.setMinimumHeight(0);
      this.cd.removeAllViews();
      this.g.scrollTo(0, 0);
      this.cd.setVisibility(8);
      efV();
    }
  }
  
  public static void h(String paramString, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (paramIntent != null)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("--------------").append(paramString).append("---------------------\r\n");
      if (paramIntent.hasExtra("phonenum")) {
        localStringBuilder.append("phoneNum: ").append(aqje.encrypt(paramIntent.getStringExtra("phonenum"))).append("\r\n");
      }
      if (paramIntent.hasExtra("key")) {
        localStringBuilder.append("countryCode: ").append(paramIntent.getStringExtra("key")).append("\r\n");
      }
      if (paramIntent.hasExtra("uin")) {
        localStringBuilder.append("uin: ").append(paramIntent.getStringExtra("uin")).append("\r\n");
      }
      if (paramIntent.hasExtra("invite_code")) {
        localStringBuilder.append("inviteCode: ").append(paramIntent.getStringExtra("uin")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_sign")) {
        localStringBuilder.append("sign: ").append(MD5.toMD5(paramIntent.getByteArrayExtra("key_register_sign"))).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_smscode")) {
        localStringBuilder.append("smsCode: ").append(paramIntent.getStringExtra("key_register_smscode")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_nick")) {
        localStringBuilder.append("nick: ").append(paramIntent.getStringExtra("key_register_nick")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_is_phone_num_registered")) {
        localStringBuilder.append("isPhoneNumRegistered: ").append(paramIntent.getBooleanExtra("key_register_is_phone_num_registered", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_chose_bind_phone")) {
        localStringBuilder.append("isChooseBindPhoneNum: ").append(paramIntent.getBooleanExtra("key_register_chose_bind_phone", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_unbind")) {
        localStringBuilder.append("unbind: ").append(paramIntent.getBooleanExtra("key_register_unbind", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_has_pwd")) {
        localStringBuilder.append("hasPwd: ").append(paramIntent.getBooleanExtra("key_register_has_pwd", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_send_sms")) {
        localStringBuilder.append("fromSendSmsCode: ").append(paramIntent.getBooleanExtra("key_register_from_send_sms", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_quick_register")) {
        localStringBuilder.append("quickRegister: ").append(paramIntent.getBooleanExtra("key_register_from_quick_register", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_is_lh")) {
        localStringBuilder.append("isLH: ").append(paramIntent.getBooleanExtra("key_register_is_lh", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_fail_pay_lh")) {
        localStringBuilder.append("isFromFailPayLh: ").append(paramIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_fail_paid_lh")) {
        localStringBuilder.append("failPayLH: ").append(paramIntent.getStringExtra("key_register_fail_paid_lh")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_result")) {
        localStringBuilder.append("registerResult: ").append(paramIntent.getBooleanExtra("key_register_result", true)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_password")) {
        localStringBuilder.append("pwd: ").append(MD5.toMD5(paramIntent.getStringExtra("key_register_password"))).append("\r\n");
      }
      localStringBuilder.append("-------------------------end---------------------------------\r\n");
      QLog.i(TAG, 2, localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Intent D()
  {
    ClearableEditText localClearableEditText1;
    if (edm == 1)
    {
      localClearableEditText1 = (ClearableEditText)this.aQ.findViewById(2131372388);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.aQ.findViewById(2131372889);
      this.an.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      this.an.putExtra("key_register_password", localClearableEditText2.getText().toString());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        h("getRegisterData-registerData", this.an);
      }
      return this.an;
      if (edm == 2)
      {
        localClearableEditText1 = (ClearableEditText)this.aQ.findViewById(2131372388);
        this.an.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      }
    }
  }
  
  public void SW(boolean paramBoolean)
  {
    Intent localIntent;
    if (this.b == null)
    {
      this.b = new altw(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      localIntent = new Intent();
      localIntent.putExtra("key_register_from_fail_pay_lh", this.cWH);
      localIntent.putExtra("key_register_fail_paid_lh", this.cym);
      localIntent.putExtra("key_register_nick", this.strNick);
      localIntent.putExtra("key_register_password", this.cyn);
      if (edm != 2) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_register_chose_bind_phone", bool);
      localIntent.putExtra("key_register_phonenum_bindnewqq", paramBoolean);
      this.b.dG(localIntent);
      this.b.bRq();
      return;
    }
  }
  
  public void SX(boolean paramBoolean)
  {
    if (this.cWH) {}
    do
    {
      do
      {
        return;
        i = this.cd.getVisibility();
        if (this.cWG) {
          break;
        }
        if (this.g.getScrollY() != 0) {
          this.g.scrollTo(0, 0);
        }
      } while (this.cd.getVisibility() == 8);
      this.cd.setVisibility(8);
      return;
      if ((i == 0) && (paramBoolean))
      {
        this.jdField_a_of_type_Aqwf.a().enable(true);
        return;
      }
      if (i == 0)
      {
        this.jdField_a_of_type_Aqwf.a().enable(false);
        return;
      }
    } while ((i != 8) || (!paramBoolean));
    int[] arrayOfInt = new int[2];
    int j = this.hx.getContext().getResources().getDisplayMetrics().heightPixels;
    this.hx.getLocationOnScreen(arrayOfInt);
    int i = j - (arrayOfInt[1] + this.hx.getHeight());
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format(Locale.getDefault(), "screen: %d, top: %d, height: %d, left: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.hx.getHeight()), Integer.valueOf(i) }));
    }
    this.aQ.findViewById(2131375318).getLocationOnScreen(arrayOfInt);
    j = arrayOfInt[1];
    this.aQ.findViewById(2131372388).getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    this.cnN = (k - j);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format(Locale.getDefault(), "lineA: %d, lineB: %d, scrollHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.cnN) }));
    }
    i = this.cnN + i;
    this.cd.setVisibility(0);
    this.cd.setMinimumHeight(i);
    this.cd.addView(this.jdField_a_of_type_Aqwf.a());
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format(Locale.getDefault(), "miniHeight: %d", new Object[] { Integer.valueOf(i) }));
    }
    if (this.jdField_a_of_type_Aqwc$a == null) {
      this.jdField_a_of_type_Aqwc$a = new aqwc.a(this.g, this.cnN, null);
    }
    this.cd.addOnLayoutChangeListener(this.jdField_a_of_type_Aqwc$a);
  }
  
  public void bJy()
  {
    onDestroy();
    dzC();
  }
  
  public void efU()
  {
    if (edm == 1) {
      anot.a(null, "new_reg", "setting_page_yes", "lianghao_clk", "", 1, "");
    }
    while (edm != 2) {
      return;
    }
    anot.a(null, "new_reg", "setting_page_no", "lianghao_clk", "", 1, "");
  }
  
  public void efV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_quick_register", false))
    {
      this.cWG = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(TAG, 4, "checkVipQQStatus isQuickRegister = true");
      }
      return;
    }
    ThreadManager.excute(new RegisterLHAssistant.2(this), 16, null, true);
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.onDestroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.app.removeHandler(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass());
    if (this.cd != null)
    {
      if (this.jdField_a_of_type_Aqwc$a != null) {
        this.cd.removeOnLayoutChangeListener(this.jdField_a_of_type_Aqwc$a);
      }
      this.jdField_a_of_type_Aqwc$a = null;
      this.cd.removeAllViews();
    }
  }
  
  static class a
    implements View.OnLayoutChangeListener
  {
    final int cnN;
    final WeakReference<ScrollView> mRef;
    
    private a(ScrollView paramScrollView, int paramInt)
    {
      this.mRef = new WeakReference(paramScrollView);
      this.cnN = paramInt;
    }
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ScrollView localScrollView = (ScrollView)this.mRef.get();
      if ((localScrollView != null) && (paramInt4 - paramInt2 > paramInt8 - paramInt6))
      {
        localScrollView.smoothScrollTo(0, this.cnN);
        paramView.removeOnLayoutChangeListener(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwc
 * JD-Core Version:    0.7.0.1
 */