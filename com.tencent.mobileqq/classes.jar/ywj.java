import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.5;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.6;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import java.lang.ref.WeakReference;

public class ywj
  implements View.OnClickListener, beqs
{
  protected Dialog a;
  protected EditText a;
  protected TextView a;
  protected TextView b;
  
  @TargetApi(11)
  public ywj(TroopGiftPanel paramTroopGiftPanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramContext, 2131755164);
    Window localWindow = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    localWindow.setSoftInputMode(16);
    View localView = localWindow.getDecorView();
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -2);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560445, null);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramContext);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    paramContext = (InputMethodLinearLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367221);
    paramContext.setOnSizeChangedListenner(this);
    this.b = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364694));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363915));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367227));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new ywk(this, paramTroopGiftPanel));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new ywl(this, paramTroopGiftPanel));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramContext.setOnClickListener(new ywm(this, paramTroopGiftPanel));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppDialog.setOnShowListener(new ywn(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new ywi(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, 5) });
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_Ywq.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
      ((BaseChatPie)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.get()).n(false);
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method");
    View localView = this.jdField_a_of_type_AndroidAppDialog.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (nav.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a())) {}
    for (int i = 2;; i = 1) {
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    c();
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.5(this), 100L);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
    {
      alxn.a("gift_store", "cancel_num", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      return;
    }
    azqs.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numcancel", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
    return;
    c();
    paramView = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!TextUtils.isEmpty(paramView)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(paramView);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.6(this), 100L);
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
    {
      alxn.a("gift_store", "sure_num", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      return;
    }
    azqs.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString, "" + mwu.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywj
 * JD-Core Version:    0.7.0.1
 */