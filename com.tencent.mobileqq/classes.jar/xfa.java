import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.PriceTextWater;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.ValueSelector;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormEditItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xfa
  extends xfd
{
  long jdField_a_of_type_Long = 20000L;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new xfc(this);
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new xfb(this);
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ValueSelector jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector;
  FormEditItem jdField_a_of_type_ComTencentMobileqqWidgetFormEditItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 1L;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  boolean e = false;
  
  public xfa(GoldMsgSettingActivity paramGoldMsgSettingActivity, Context paramContext, Intent paramIntent, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramGoldMsgSettingActivity, paramContext, paramIntent, paramString1, paramString2, paramString3, paramInt);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = QWalletSetting.a(paramString2, "money_max", 20000L);
    paramContext = paramGoldMsgSettingActivity.getResources();
    this.jdField_a_of_type_JavaLangString = String.format(paramContext.getString(2131432313), new Object[] { NumAnim.formatNumber(this.jdField_b_of_type_Long / 100.0D, false) });
    this.jdField_b_of_type_JavaLangString = String.format(paramContext.getString(2131432312), new Object[] { NumAnim.formatNumber(this.jdField_a_of_type_Long / 100.0D, false) });
    this.jdField_a_of_type_AndroidTextTextWatcher = new PriceSettingDialog.PriceTextWater(paramGoldMsgSettingActivity.getApplicationContext(), 1L, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if (1 == QWalletSetting.a(paramString2, "goldmsg_recv_goldonly_", 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      this.jdField_d_of_type_Boolean = GoldMsgSettingActivity.a(paramGoldMsgSettingActivity).getBooleanExtra("goldmsg_fromgreytips", false);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label82;
      }
      j = 1;
      label12:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(j);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormEditItem.setVisibility(i);
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(NumAnim.formatNumber(this.jdField_c_of_type_Long / 100.0D, false));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(i);
      if (!paramBoolean) {
        break label87;
      }
    }
    label82:
    label87:
    for (int i = 2131432320;; i = 2131432317)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(i);
      return;
      i = 8;
      break;
      j = 0;
      break label12;
    }
  }
  
  private void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    if (!this.jdField_c_of_type_Boolean)
    {
      a(paramBoolean1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GoldMsgSettingActivity", 2, "refreshGoldOnly. operatedByUser:" + this.jdField_c_of_type_Boolean);
    }
  }
  
  private boolean b()
  {
    QQToast localQQToast1 = null;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    long l1 = 1L;
    if ((!this.jdField_b_of_type_Boolean) && (bool)) {
      localQQToast1 = QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432325, 0);
    }
    for (;;)
    {
      if (localQQToast1 != null) {
        localQQToast1.a();
      }
      long l2;
      for (;;)
      {
        if (localQQToast1 != null) {
          break label200;
        }
        return true;
        if (!bool) {
          break label202;
        }
        try
        {
          l2 = QWalletTools.a(this.jdField_a_of_type_AndroidWidgetEditText).longValue();
          l1 = l2;
          if (l2 < this.jdField_b_of_type_Long)
          {
            l1 = l2;
            localQQToast1 = QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 0);
          }
          else
          {
            l1 = l2;
            if (l2 > this.jdField_a_of_type_Long)
            {
              l1 = l2;
              localQQToast1 = QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0);
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localQQToast2 = QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432299, 0);
        }
        break;
        if ((bool != this.jdField_a_of_type_Boolean) || ((bool) && (this.jdField_a_of_type_Boolean) && (l1 != this.jdField_c_of_type_Long))) {
          GoldMsgChatHelper.a().a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, bool, l1);
        }
      }
      label200:
      return false;
      label202:
      QQToast localQQToast2 = null;
      continue;
      l1 = l2;
    }
  }
  
  void a(View paramView)
  {
    long l2 = 1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector = ((ValueSelector)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364762));
    long l3 = this.jdField_a_of_type_Long;
    paramView = GoldMsgChatHelper.a().a(0, this.jdField_c_of_type_JavaLangString);
    if (paramView != null) {}
    for (long l1 = paramView.jdField_a_of_type_Long;; l1 = 1L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setRange(l1, l3);
      paramView = QWalletSetting.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.app.getAccount(), "money_array", Long.class);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setValueAndDisplay(paramView);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364763);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364765));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormEditItem = ((FormEditItem)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364766));
      this.jdField_a_of_type_AndroidWidgetEditText = this.jdField_a_of_type_ComTencentMobileqqWidgetFormEditItem.a();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364768));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldMsgSettingActivity.findViewById(2131364767));
      if (this.e)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView = GoldMsgChatHelper.GoldMsgFriendSet.a(this.jdField_c_of_type_JavaLangString);
        boolean bool;
        if (paramView != null)
        {
          bool = true;
          l1 = l2;
          if (paramView != null) {
            l1 = paramView.jdField_a_of_type_Long;
          }
          a(bool, l1, this.jdField_b_of_type_Boolean);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
          if ((QWalletSetting.a(this.jdField_d_of_type_JavaLangString, "goldmsg_poptips", false)) || (!this.jdField_d_of_type_Boolean)) {
            break label308;
          }
        }
        label308:
        for (int i = 0;; i = 8)
        {
          if (i == 0) {
            QWalletSetting.a(this.jdField_d_of_type_JavaLangString, "goldmsg_poptips", true);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
          return;
          bool = false;
          break;
        }
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  void a(boolean paramBoolean, GoldMsgGetReq paramGoldMsgGetReq, GoldMsgGetRsp paramGoldMsgGetRsp)
  {
    long l1 = 1L;
    boolean bool = true;
    if ((paramGoldMsgGetReq == null) || (GoldMsgSettingActivity.jdField_b_of_type_Boolean) || (paramGoldMsgGetReq.type != 2) || (!String.valueOf(paramGoldMsgGetReq.friendUin).equals(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    long l2;
    if ((paramBoolean) && (paramGoldMsgGetRsp != null)) {
      if (paramGoldMsgGetRsp.goldMsgSwitch == 1)
      {
        paramBoolean = true;
        l2 = paramGoldMsgGetRsp.goldMsgPrice;
        if ((paramBoolean) || (l2 >= 1L)) {
          break label124;
        }
      }
    }
    for (;;)
    {
      if (paramGoldMsgGetRsp.status != GoldMsgGetRsp.STATUS_NOTINWHITELIST) {}
      for (;;)
      {
        a(paramBoolean, l1, bool);
        return;
        paramBoolean = false;
        break;
        bool = false;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432328, 0).a();
      return;
      label124:
      l1 = l2;
    }
  }
  
  void a(boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp)
  {
    boolean bool = true;
    if ((paramGoldMsgSetReq == null) || (GoldMsgSettingActivity.jdField_b_of_type_Boolean) || (!String.valueOf(paramGoldMsgSetReq.friendUin).equals(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean)
    {
      if (paramGoldMsgSetReq.goldMsgSwitch == 1)
      {
        paramBoolean = bool;
        this.jdField_a_of_type_Boolean = paramBoolean;
        this.jdField_c_of_type_Long = paramGoldMsgSetReq.goldMsgPrice;
        if (QLog.isColorLevel()) {
          QLog.i("GoldMsgSettingActivity", 2, "GOLDMSG_SET, open:" + this.jdField_a_of_type_Boolean + ",price:" + this.jdField_c_of_type_Long);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label139;
        }
      }
      label139:
      for (int i = 2131432326;; i = 2131432327)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, i, 0).a();
        return;
        paramBoolean = false;
        break;
      }
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432300, 0).a();
  }
  
  boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = b();
    if ((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.checkIsInputEmpty()))
    {
      Long localLong = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.checkAndQueryInputValue();
      if (localLong != null)
      {
        GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState = GoldMsgChatHelper.a().a(0, this.jdField_c_of_type_JavaLangString);
        if (localGoldMsgChatState != null) {
          localGoldMsgChatState.a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 0, localLong.longValue(), 0);
        }
        bool1 = bool2;
      }
      return bool1;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfa
 * JD-Core Version:    0.7.0.1
 */