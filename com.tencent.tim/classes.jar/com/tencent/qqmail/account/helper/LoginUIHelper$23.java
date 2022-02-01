package com.tencent.qqmail.account.helper;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.PickerViewControl;
import com.tencent.qqmail.activity.compose.PickerViewControl.PickerViewControlCallback;
import java.util.List;

final class LoginUIHelper$23
  implements PickerViewControl.PickerViewControlCallback
{
  LoginUIHelper$23(Activity paramActivity, LoginUIHelper.SelectPicker paramSelectPicker, List paramList) {}
  
  public void didSelectRow(PickerViewControl paramPickerViewControl, int paramInt)
  {
    this.val$selectRow.select(paramInt, (Account)this.val$accountList.get(paramInt));
  }
  
  public void dismissPickerView(View paramView) {}
  
  public Activity getActivity()
  {
    return this.val$activity;
  }
  
  public void touchUpOutSideContainer() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.LoginUIHelper.23
 * JD-Core Version:    0.7.0.1
 */