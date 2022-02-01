package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;

class SettingGestureConfigActivity$1
  implements UITableView.ClickListener
{
  SettingGestureConfigActivity$1(SettingGestureConfigActivity paramSettingGestureConfigActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool = true;
    if (paramUITableItemView == SettingGestureConfigActivity.access$000(this.this$0))
    {
      if (paramUITableItemView.isChecked() != true) {
        break label92;
      }
      paramUITableItemView.setChecked(paramUITableItemView.isChecked());
      if (FingerPrintDialog.isRequestNormal()) {
        SettingGestureConfigActivity.access$100(this.this$0).show(this.this$0.getFragmentManager(), "FingerPrintDialog");
      }
    }
    else
    {
      return;
    }
    paramUITableItemView = new Intent(this.this$0.getActivity(), GesturePwdActivity.class);
    paramUITableItemView.putExtra("arg_page_state", 6);
    this.this$0.startActivityForResult(paramUITableItemView, 1);
    return;
    label92:
    if ((FingerprintFactory.createInstance().isHarewareDetected()) && (!FingerprintFactory.createInstance().isEnrolled()))
    {
      this.this$0.showTipsForSettingFingerprint();
      return;
    }
    SharedPreferenceUtil.setFingerprintOpen(true);
    if (!paramUITableItemView.isChecked()) {}
    for (;;)
    {
      paramUITableItemView.setChecked(bool);
      DataCollector.logEvent("Event_Fingerprint_enable_setting");
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureConfigActivity.1
 * JD-Core Version:    0.7.0.1
 */