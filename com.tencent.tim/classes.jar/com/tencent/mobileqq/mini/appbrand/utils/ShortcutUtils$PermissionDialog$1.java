package com.tencent.mobileqq.mini.appbrand.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShortcutUtils$PermissionDialog$1
  implements View.OnClickListener
{
  ShortcutUtils$PermissionDialog$1(ShortcutUtils.PermissionDialog paramPermissionDialog) {}
  
  public void onClick(View paramView)
  {
    CheckBox localCheckBox = ShortcutUtils.PermissionDialog.access$300(this.this$0);
    if (!ShortcutUtils.PermissionDialog.access$300(this.this$0).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.PermissionDialog.1
 * JD-Core Version:    0.7.0.1
 */